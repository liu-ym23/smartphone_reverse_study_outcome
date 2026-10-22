package com.android.contacts.recommend;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.ContactInfoHelper;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.util.DateUtils;
import com.android.contacts.util.ExecutorUtils;
import com.android.contacts.util.ExpirableCache;
import com.android.contacts.util.UriUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendDataLoader {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    private static final boolean DEBUG = false;
    private static final long DELAY_UPDATE_CALLLOG = 1000;
    private static final int MAX_CONTACT_RESULT_COUNT = 6;
    private static final int MSG_LOAD_DATA_DONE = 1;
    private static final int MSG_UPDATE_CALLLOG = 2;
    private static final String TAG = "RecommendDataLoader";
    private static final int THREAD_FOR_DIALPAD_SIZE = 2;
    private static final int THREAD_FOR_LIST_SIZE = 3;
    private BlacklistManager mBlackListManager;
    private ExpirableCache<String, RecommendContact> mContactCache;
    private ContactInfoHelper mContactInfoHelper;
    private Context mContext;
    private CountryMonitor mCountryMonitor;
    private List<BaseFlowAdapter.FlowEntry> mDataList;
    private ExecutorService mExecutor;
    private List<RecommendContact> mFavoriteData;
    private volatile boolean mForDialpad;
    private List<RecommendContact> mFrequentData;
    private Handler mHandler;
    private OnRecommendDataLoadListener mListener;
    private boolean mLoad;
    private CountDownLatch mLoaderLatch;
    private List<Task> mLoaderList;
    private List<RecommendContact> mRecentData;

    private class FavoriteLoader extends Task {
        private Context context;
        final /* synthetic */ RecommendDataLoader this$0;

        public FavoriteLoader(RecommendDataLoader r2, Context r3) {
            this.this$0 = r2;
            super(r2, r3, "Favorite_Load_Task");
            this.context = r3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.load == false) goto L9;
            List<RecommendContact> r0 = queryFavoriteContact();
            RecommendDataLoader r1 = this.this$0;
            if (this.load == true) goto L8;
            r0 = null;
        L8:
            RecommendDataLoader.access$802(r1, r0);
        L9:
            RecommendDataLoader.access$400(this.this$0).countDown();
        }

        private List<RecommendContact> queryFavoriteContact() {
            ArrayList r3 = new ArrayList();
            Cursor r4 = null;
            r4 = this.context.getContentResolver().query(RecommedDataLoad.FavoriteDataLoad.URI, RecommedDataLoad.FavoriteDataLoad.PROJECTION, "data15 = 1 AND mimetype='vnd.android.cursor.item/phone_v2'", null, "CAST(data14 AS DECIMAL) DESC");     // Catch: Exception -> L7 Throwable -> L12
            processCursor(r4, r3);     // Catch: Exception -> L7 Throwable -> L12
            MoreCloseables.closeQuietly(r4);
            StringBuilder r12 = new StringBuilder("Load favorite done: ");
        L5:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, r12.append(r3.size()).toString());
            return r3;
        L7:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecommendDataLoader.TAG, "Failed to load favorite contacts: " + e);     // Catch: Throwable -> L12
            if (RecommendDataLoader.access$900() == false) goto L11;
            e.printStackTrace();     // Catch: Throwable -> L12
        L11:
            MoreCloseables.closeQuietly(r4);
            r12 = new StringBuilder("Load favorite done: ");
        L12:
            MoreCloseables.closeQuietly(r4);
            r12 = new StringBuilder("Load favorite done: ");
            goto L5
        }

        private void processCursor(Cursor r8, List<RecommendContact> r9) {
        L3:
            if (this.load == false) goto L22;
            if (r8 == null) goto L31;
            if (r8.moveToNext() == false) goto L32;
            RecommendContact r0 = new RecommendContact();
            r0.number = r8.getString(1);
            long r1 = r8.getLong(10);
            if (RecommendDataLoader.access$1500(this.this$0).isInBlackList(this.cr, Long.valueOf(r1), r0.number) == true) goto L3;
            r0.contactId = r1;
            r8.getString(5);
            r0.photoId = r8.getLong(7);
            String r3 = r8.getString(11);
            if (TextUtils.isEmpty(r3) == false) goto L13;
            Uri r4 = null;
        L14:
            r0.photoUri = r4;
            r0.type = r8.getInt(2);
            if (r0.type != 0) goto L17;
            r0.label = r8.getString(3);
        L17:
            r0.name = ContactsUtils.getContactName(RecommendDataLoader.access$300(this.this$0), r8.getString(9));
            r0.lookupUri = ContactsContract.Contacts.getLookupUri(r1, r8.getString(8));
            if (RecommendDataLoader.access$1400(this.this$0, r0, r9) == true) goto L20;
            r9.add(r0);
        L20:
            RecommendDataLoader.access$1200(this.this$0).put(r0.number, r0);
            if (r9.size() < 6) goto L3;
            return;
        L13:
            r4 = Uri.parse(r3);
            goto L14
        L32:
            return;
        L31:
            return;
        }
    }

    private class FrequentLoader extends Task {
        final /* synthetic */ RecommendDataLoader this$0;

        public FrequentLoader(RecommendDataLoader r2, Context r3) {
            this.this$0 = r2;
            super(r2, r3, "Frequent_Load_Task");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.load == false) goto L9;
            List<RecommendContact> r0 = getContactFrequence();
            RecommendDataLoader r1 = this.this$0;
            if (this.load == true) goto L8;
            r0 = null;
        L8:
            RecommendDataLoader.access$702(r1, r0);
        L9:
            RecommendDataLoader.access$400(this.this$0).countDown();
        }

        private String getNormalizedNumber(String r1, String r2) {
            String r0 = PhoneNumberUtils.stripSeparators(r1);
            String r3 = PhoneNumberUtils.formatNumberToE164(r0, r2);
            if (TextUtils.isEmpty(r3) == false) goto L6;
            return r0;
        L6:
            return r3;
        }

        private void updateWeightAndResetTimes(HashMap<String, RecommendContact> r2, long r3) {
            float r1 = RecommendUtil.getDayFactor(r3);
            Iterator<Map.Entry<String, RecommendContact>> r4 = r2.entrySet().iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            RecommendContact r5 = r4.next().getValue();
            if (r5.callTimes <= 0) goto L4;
            r5.weight += r5.callTimes * r1;
            r5.callTimes = 0;
            goto L4
        }

        private void addOrUpdateFromCursor(HashMap<String, RecommendContact> r4, String r5, Cursor r6) {
            if (r4.containsKey(r5) == true) goto L5;
            RecommendContact r3 = new RecommendContact();
            r3.number = r6.getString(0);
            r3.lastContactSubId = r6.getInt(1);
            r3.lastContactSlotId = r6.getString(2);
            r3.date = r6.getLong(3);
            r3.normalizedNumber = r5;
            r3.callTimes++;
            r4.put(r5, r3);
            return;
        L5:
            r4.get(r5).callTimes++;
        }

        private List<RecommendContact> getContactFrequence() {
            ContentResolver r8 = RecommendDataLoader.access$300(this.this$0).getContentResolver();
            String r9 = RecommendDataLoader.access$1600(this.this$0).getCountryIso();
            HashMap<String, RecommendContact> r10 = new HashMap();
            long r2 = DateUtils.getYesterdayInMillis();
            int r11 = 0;
            int r0 = 3;
            String r14 = String.format("%s > %s and %s < %s", new Object[]{"date", Long.toString(r2 - RecommedDataLoad.FrequentDataLoad.VALID_TIME_MILLIS), "date", Long.toString(r2)});
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecommendDataLoader.TAG, "Count number times sql selection: lookup_uri NOT NULL and " + r14);
            Calendar r7 = Calendar.getInstance();     // Catch: Throwable -> L53 Exception -> L55
            Calendar r6 = Calendar.getInstance();     // Catch: Throwable -> L53 Exception -> L55
            long r17 = 0;
            int r5 = 0;
            boolean r19 = false;
            Cursor r20 = null;
        L160:
        L51:
            e = e;
        L57:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecommendDataLoader.TAG, "Failed to load frequent contacts when quering from call log: " + e);     // Catch: Throwable -> L146
            if (RecommendDataLoader.access$900() == false) goto L60;
            e.printStackTrace();     // Catch: Throwable -> L146
        L60:
            MoreCloseables.closeQuietly(r20);
            if (this.load == true) goto L63;
            return null;
        L63:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, "Load frequence query call log: " + r10.size());
            HashMap r12 = new HashMap();
            Cursor r3 = r8.query(ContactsContract.Data.CONTENT_URI, RecommedDataLoad.FrequentDataLoad.PROJECTION, "mimetype = 'vnd.android.cursor.item/phone_v2'", null, null);     // Catch: Throwable -> L112 Exception -> L114
            StringBuilder r1 = new StringBuilder().append("Load frequence query data cursor: ");     // Catch: Throwable -> L107 Exception -> L109
            if (r3 != null) goto L68;
            Integer r4 = null;
        L69:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, r1.append(r4).toString());     // Catch: Throwable -> L107 Exception -> L109
        L70:
            if (this.load == false) goto L104;
            if (r3 == null) goto L104;
            if (r3.moveToNext() == false) goto L104;
            long r13 = r3.getLong(r11);     // Catch: Throwable -> L107 Exception -> L109
            String r15 = r3.getString(2);     // Catch: Throwable -> L107 Exception -> L109
            if (RecommendDataLoader.access$1500(this.this$0).isInBlackList(r8, Long.valueOf(r13), r15) == true) goto L70;
            String r16 = getNormalizedNumber(r15, r9);     // Catch: Throwable -> L107 Exception -> L109
            RecommendContact r18 = r10.get(r16);     // Catch: Throwable -> L107 Exception -> L109
            if (r18 == null) goto L102;
            float r21 = r18.weight;     // Catch: Throwable -> L107 Exception -> L109
            if (r12.containsKey(Long.valueOf(r13)) == false) goto L154;
            RecommendContact r22 = (RecommendContact) r12.get(Long.valueOf(r13));     // Catch: Throwable -> L107 Exception -> L109
            if (r22.numbers.contains(r16) == true) goto L70;
            HashMap r110 = r12;
            if (r18.date <= r22.date) goto L96;
            r22.number = r18.number;     // Catch: Exception -> L100 Throwable -> L107
            r22.date = r18.date;     // Catch: Exception -> L100 Throwable -> L107
            r22.lastContactSlotId = r18.lastContactSlotId;     // Catch: Exception -> L100 Throwable -> L107
            r22.lastContactSubId = r18.lastContactSubId;     // Catch: Exception -> L100 Throwable -> L107
        L96:
            r22.weight += r21;     // Catch: Exception -> L100 Throwable -> L107
            if (r21 <= 0.0f) goto L103;
            r22.numbers.add(r16);     // Catch: Exception -> L100 Throwable -> L107
        L103:
            r12 = r110;
            r11 = 0;
        L100:
            e = e;
        L111:
            r20 = r3;
        L116:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecommendDataLoader.TAG, "Failed to load frequent contacts when quering from data: " + e);     // Catch: Throwable -> L112
            if (RecommendDataLoader.access$900() == false) goto L119;
            e.printStackTrace();     // Catch: Throwable -> L112
        L119:
            MoreCloseables.closeQuietly(r20);
            if (this.load == true) goto L122;
            return null;
        L122:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, "Load frequence query data: " + r110.size());
            ArrayList r23 = new ArrayList(r110.values());
            Collections.sort(r23, new AnonymousClass1(this));
            ArrayList r24 = new ArrayList();
            int r111 = 0;
        L124:
            if (r24.size() >= 6) goto L138;
            if (r111 >= r23.size()) goto L138;
            RecommendContact r25 = (RecommendContact) r23.get(r111);
            if (r24.isEmpty() == false) goto L131;
            r24.add(r25);
        L136:
            r111 = r111 + 1;
            goto L124
        L131:
            if (isDuplicate((RecommendContact) r24.get(r24.size() - 1), r25) == true) goto L134;
            r24.add(r25);
            goto L136
        L134:
            if (r25.contactId >= ((RecommendContact) r24.get(r24.size() - 1)).contactId) goto L136;
            r24.remove(r24.size() - 1);
            r24.add(r25);
        L138:
            if (RecommendDataLoader.access$900() == false) goto L140;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecommendDataLoader.TAG, "Frequent contacts: " + r24);
        L140:
            r23.clear();
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, "Load frequence contact done: " + r24.size());
            return r24;
        L154:
            RecommendContact r26 = RecommendContact.copy(r18);     // Catch: Exception -> L87 Throwable -> L107
            r26.weight = r21;     // Catch: Exception -> L87 Throwable -> L107
            r26.contactId = r13;     // Catch: Exception -> L87 Throwable -> L107
            r12.put(Long.valueOf(r13), r26);     // Catch: Exception -> L87 Throwable -> L107
            fillFieldsFromCursorIfNeed(r3, r26);     // Catch: Exception -> L87 Throwable -> L107
            if (r21 <= 0.0f) goto L102;
            r26.numbers.add(r16);     // Catch: Exception -> L87 Throwable -> L107
        L87:
            e = e;
            r20 = r3;
        L115:
            r110 = r12;
        L102:
            r110 = r12;
        L104:
            r110 = r12;
            MoreCloseables.closeQuietly(r3);
            if (this.load == true) goto L122;
            return null;
        L68:
            r4 = Integer.valueOf(r3.getCount());     // Catch: Throwable -> L107 Exception -> L109
        L109:
            e = e;
            r110 = r12;
        L107:
            th = th;
            r20 = r3;
        L142:
            MoreCloseables.closeQuietly(r20);
            if (this.load == true) goto L145;
            return null;
        L145:
            throw th;
        L112:
            th = th;
        L114:
            e = e;
            goto L115
        L6:
            if (this.load == false) goto L48;
            if (r19 == true) goto L48;
            int r112 = r5;
            Calendar r113 = r6;
            Calendar r27 = r7;
            Cursor r28 = r8.query(RecommedDataLoad.FrequentDataLoad.CALLLOG_URI.buildUpon().appendQueryParameter("offset", String.valueOf(r5 * 1000)).build(), RecommedDataLoad.FrequentDataLoad.CALLLOG_PROJECTION, r14, null, "date DESC");     // Catch: Exception -> L51 Throwable -> L146
            StringBuilder r29 = new StringBuilder().append("Load frequence query call log cursor: ").append(r112).append(", ");     // Catch: Throwable -> L44 Exception -> L46
            if (r28 != null) goto L12;
            Integer r30 = null;
        L13:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, r29.append(r30).toString());     // Catch: Throwable -> L44 Exception -> L46
            if (r28 != null) goto L16;
        L19:
            r19 = true;
        L21:
            if (this.load == false) goto L39;
            if (r28 == null) goto L39;
            if (r28.moveToNext() == false) goto L39;
            String r31 = r28.getString(0);     // Catch: Throwable -> L44 Exception -> L46
            if (RecommendDataLoader.access$1500(this.this$0).isInBlackList(r8, r31) == false) goto L28;
        L37:
            Calendar r32 = r27;
        L38:
            r27 = r32;
            r0 = 3;
            goto L21
        L28:
            if (TextUtils.isEmpty(r31) == true) goto L37;
            long r33 = r28.getLong(r0);     // Catch: Throwable -> L44 Exception -> L46
            r32 = r27;
            r32.setTimeInMillis(r17);     // Catch: Throwable -> L44 Exception -> L46
            r113.setTimeInMillis(r33);     // Catch: Throwable -> L44 Exception -> L46
            String r34 = getNormalizedNumber(r31, r9);     // Catch: Throwable -> L44 Exception -> L46
            if (DateUtils.isSameDay(r32, r113) == false) goto L33;
        L36:
            addOrUpdateFromCursor(r10, r34, r28);     // Catch: Throwable -> L44 Exception -> L46
            goto L38
        L33:
            if (r10.isEmpty() == true) goto L35;
            updateWeightAndResetTimes(r10, r17);     // Catch: Throwable -> L44 Exception -> L46
        L35:
            r17 = r33;
        L39:
            Calendar r35 = r27;
            if (r10.isEmpty() == true) goto L42;
            updateWeightAndResetTimes(r10, r17);     // Catch: Throwable -> L44 Exception -> L46
        L42:
            r5 = r112 + 1;     // Catch: Throwable -> L44 Exception -> L46
            MoreCloseables.closeQuietly(r28);     // Catch: Throwable -> L44 Exception -> L46
            r7 = r35;
            r20 = r28;
            r17 = r17;
            r6 = r113;
            r0 = 3;
            goto L160
        L16:
            if (r28.getCount() >= 1000) goto L21;
        L12:
            r30 = Integer.valueOf(r28.getCount());     // Catch: Throwable -> L44 Exception -> L46
            goto L13
        L46:
            e = e;
            r20 = r28;
        L44:
            th = th;
            Cursor r210 = r28;
        L147:
            MoreCloseables.closeQuietly(r210);
            if (this.load == true) goto L150;
            return null;
        L150:
            throw th;
        L48:
            MoreCloseables.closeQuietly(r20);
            if (this.load == true) goto L63;
            return null;
        L146:
            th = th;
        L55:
            e = e;
            r20 = null;
        L53:
            th = th;
            r210 = null;
            goto L147
        }

        private boolean isDuplicate(RecommendContact r2, RecommendContact r3) {
            if (TextUtils.equals(r2.normalizedNumber, r3.normalizedNumber) == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.numbers.equals(r3.numbers) == false) goto L7;
            return true;
        }

        private void fillFieldsFromCursorIfNeed(Cursor r3, RecommendContact r4) {
            if (r3 == null) goto L20;
            if (r4 == null) goto L21;
            r4.name = ContactsUtils.getContactName(RecommendDataLoader.access$300(this.this$0), r3.getString(1));
            if (TextUtils.isEmpty(r4.number) == false) goto L8;
            r4.number = r3.getString(2);
        L8:
            r4.type = r3.getInt(3);
            if (r4.type != 0) goto L12;
            r4.label = r3.getString(4);
        L12:
            if (TextUtils.isEmpty(r4.normalizedNumber) == false) goto L14;
            r4.normalizedNumber = r3.getString(5);
        L14:
            r4.photoId = r3.getLong(6);
            String r2 = r3.getString(8);
            if (TextUtils.isEmpty(r2) == false) goto L17;
            Uri r5 = null;
        L18:
            r4.photoUri = r5;
            String r6 = r3.getString(7);
            r4.lookupUri = ContactsContract.Contacts.getLookupUri(r3.getLong(0), r6);
            return;
        L17:
            r5 = Uri.parse(r2);
            goto L18
        L21:
            return;
        }
    }

    private class LoadDoneLatch extends Task {
        final /* synthetic */ RecommendDataLoader this$0;

        public LoadDoneLatch(RecommendDataLoader r2, Context r3) {
            this.this$0 = r2;
            super(r2, r3, "Load_Latch_Task");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            RecommendDataLoader.access$400(this.this$0).await();     // Catch: InterruptedException -> L5
        L7:
            RecommendDataLoader.access$500(this.this$0).clear();
            if (this.load == true) goto L10;
            return;
        L10:
            if (RecommendDataLoader.access$600(this.this$0) == null) goto L15;
            if (RecommendDataLoader.access$600(this.this$0).isEmpty() == true) goto L15;
            RecommendDataLoader.access$500(this.this$0).add(new RecommendHead(RecommendDataLoader.access$300(this.this$0).getText(R.string.recommend_recent), 0));
            RecommendDataLoader.access$500(this.this$0).addAll(RecommendDataLoader.access$600(this.this$0));
        L15:
            if (RecommendDataLoader.access$700(this.this$0) == null) goto L20;
            if (RecommendDataLoader.access$700(this.this$0).isEmpty() == true) goto L20;
            RecommendDataLoader.access$500(this.this$0).add(new RecommendHead(RecommendDataLoader.access$300(this.this$0).getText(R.string.recommend_frequent), 1));
            RecommendDataLoader.access$500(this.this$0).addAll(RecommendDataLoader.access$700(this.this$0));
        L20:
            if (RecommendDataLoader.access$800(this.this$0) == null) goto L25;
            if (RecommendDataLoader.access$800(this.this$0).isEmpty() == true) goto L25;
            RecommendDataLoader.access$500(this.this$0).add(new RecommendHead(RecommendDataLoader.access$300(this.this$0).getText(R.string.recommend_favorite), 2));
            RecommendDataLoader.access$500(this.this$0).addAll(RecommendDataLoader.access$800(this.this$0));
        L25:
            if (RecommendDataLoader.access$900() == false) goto L32;
            StringBuilder r1 = new StringBuilder("Recommend data loaded. size = ").append(RecommendDataLoader.access$500(this.this$0).size()).append(" for ");
            if (RecommendDataLoader.access$1000(this.this$0) == false) goto L29;
            String r3 = "Dialpad";
        L30:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecommendDataLoader.TAG, r1.append(r3).toString());
            goto L32
        L29:
            r3 = "List";
        L32:
            if (RecommendDataLoader.access$1100(this.this$0).hasMessages(1) == false) goto L34;
            RecommendDataLoader.access$1100(this.this$0).removeMessages(1);
        L34:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, "Recommend result size: " + RecommendDataLoader.access$500(this.this$0).size() + ", " + RecommendDataLoader.access$1000(this.this$0));
            Message.obtain(RecommendDataLoader.access$1100(this.this$0), 1, new ArrayList(RecommendDataLoader.access$500(this.this$0))).sendToTarget();
            return;
        L5:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecommendDataLoader.TAG, "Latch thread interrupted " + e);
            goto L7
        }
    }

    public interface OnRecommendDataLoadListener {
        void onRecommendDataLoaded(List<BaseFlowAdapter.FlowEntry> r1);
    }

    private class RecentLoader extends Task {
        final /* synthetic */ RecommendDataLoader this$0;

        public RecentLoader(RecommendDataLoader r2, Context r3) {
            this.this$0 = r2;
            super(r2, r3, "Recent_Load_Task");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.load == false) goto L9;
            List<RecommendContact> r0 = loadCalllogList();
            RecommendDataLoader r1 = this.this$0;
            if (this.load == true) goto L8;
            r0 = null;
        L8:
            RecommendDataLoader.access$602(r1, r0);
        L9:
            RecommendDataLoader.access$400(this.this$0).countDown();
        }

        private List<RecommendContact> loadCalllogList() {
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, "Load load call log list.");
            Cursor r3 = null;
            Integer r4 = null;
            r3 = null;
            Cursor r5 = this.cr.query(RecommedDataLoad.CallLogDataLoad.URI, RecommedDataLoad.CallLogDataLoad.PROJECTION, RecommedDataLoad.CallLogDataLoad.SELECTION, null, "max(date) desc");     // Catch: Throwable -> L41 Exception -> L43
            StringBuilder r6 = new StringBuilder("Load call log cursor: ");     // Catch: Throwable -> L37 Exception -> L39
            if (r5 == null) goto L8;
            r4 = Integer.valueOf(r5.getCount());     // Catch: Throwable -> L37 Exception -> L39
        L8:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, r6.append(r4).toString());     // Catch: Throwable -> L37 Exception -> L39
        L9:
            if (this.load == false) goto L36;
            if (r5 == null) goto L36;
            if (r5.moveToNext() == false) goto L36;
            String r0 = r5.getString(1);     // Catch: Throwable -> L37 Exception -> L39
            String r9 = r5.getString(3);     // Catch: Throwable -> L37 Exception -> L39
            if (TextUtils.isEmpty(r0) == true) goto L9;
            RecommendContact r7 = getContactInfoFromCallLog(r5);     // Catch: Throwable -> L37 Exception -> L39
            RecommendContact r8 = (RecommendContact) RecommendDataLoader.access$1200(this.this$0).get(r0);     // Catch: Throwable -> L37 Exception -> L39
            if (r8 != null) goto L23;
            ContactInfo r10 = RecommendDataLoader.access$1300(this.this$0).lookupNumber(r0, r9);     // Catch: Throwable -> L37 Exception -> L39
            if (r10 == null) goto L9;
            RecommendContact r11 = new RecommendContact(r10);     // Catch: Throwable -> L37 Exception -> L39
            RecommendDataLoader.access$1200(this.this$0).put(r0, r11);     // Catch: Throwable -> L37 Exception -> L39
            RecommendContact r12 = r11;
        L25:
            if (callLogInfoMatches(r7, r12) == true) goto L28;
            r2.add(new UpdateCallLogRequest(this.this$0, r0, r9, r7, new RecommendContact(r12)));     // Catch: Throwable -> L37 Exception -> L39
        L28:
            if (RecommendDataLoader.access$1400(this.this$0, r12, r1) == true) goto L9;
            Long r13 = Long.valueOf(ContentUris.parseId(r12.lookupUri));     // Catch: Throwable -> L37 Exception -> L39
            if (RecommendDataLoader.access$1500(this.this$0).isInBlackList(this.cr, r13, r0) == true) goto L9;
            r12.contactId = r13.longValue();     // Catch: Throwable -> L37 Exception -> L39
            r12.name = ContactsUtils.getContactName(RecommendDataLoader.access$300(this.this$0), r12.name);     // Catch: Throwable -> L37 Exception -> L39
            r12.lastContactSlotId = r7.lastContactSlotId;     // Catch: Throwable -> L37 Exception -> L39
            r12.lastContactSubId = r7.lastContactSubId;     // Catch: Throwable -> L37 Exception -> L39
            r12.lastCallType = r7.lastCallType;     // Catch: Throwable -> L37 Exception -> L39
            r1.add(r12);     // Catch: Throwable -> L37 Exception -> L39
            if (r1.size() < 6) goto L9;
        L23:
            r12 = r8;
        L36:
            MoreCloseables.closeQuietly(r5);
        L49:
            if (r2.isEmpty() == true) goto L51;
            Message r14 = Message.obtain(RecommendDataLoader.access$1100(this.this$0), 2, r2);
            RecommendDataLoader.access$1100(this.this$0).removeMessages(2);
            RecommendDataLoader.access$1100(this.this$0).sendMessageDelayed(r14, 1000);
        L51:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(RecommendDataLoader.TAG, "Load log list done: " + r1.size());
            return r1;
        L39:
            e = e;
            r3 = r5;
        L44:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecommendDataLoader.TAG, "Failed to load call log list: " + e);     // Catch: Throwable -> L41
            if (RecommendDataLoader.access$900() == false) goto L47;
            e.printStackTrace();     // Catch: Throwable -> L41
        L47:
            MoreCloseables.closeQuietly(r3);
        L37:
            th = th;
            r3 = r5;
        L53:
            MoreCloseables.closeQuietly(r3);
            throw th;
        L43:
            e = e;
        L41:
            th = th;
            goto L53
        }

        private boolean callLogInfoMatches(RecommendContact r2, RecommendContact r3) {
            if (TextUtils.equals(r2.name, r3.name) == true) goto L5;
        L9:
            return false;
        L5:
            if (r2.type != r3.type) goto L9;
            if (TextUtils.equals(r2.label, r3.label) == false) goto L9;
            return true;
        }

        private RecommendContact getContactInfoFromCallLog(Cursor r3) {
            RecommendContact r2 = new RecommendContact();
            r2.lookupUri = UriUtils.parseUriOrNull(r3.getString(7));
            r2.name = r3.getString(4);
            String r0 = r3.getString(5);
            if (TextUtils.isEmpty(r0) == false) goto L5;
            int r1 = 0;
        L6:
            r2.type = r1;
            String r4 = r3.getString(8);
            if (r4 != null) goto L9;
            r4 = r3.getString(1);
        L9:
            r2.number = r4;
            r2.label = r3.getString(6);
            r2.normalizedNumber = r3.getString(9);
            r2.photoId = r3.getLong(10);
            r2.photoUri = null;
            r2.formattedNumber = r3.getString(11);
            r2.lastCallType = r3.getInt(2);
            r2.lastContactSlotId = r3.getString(13);
            r2.lastContactSubId = r3.getInt(12);
            r2.features = r3.getInt(14);
            return r2;
        L5:
            r1 = Integer.parseInt(r0);
            goto L6
        }
    }

    private class Task extends Thread {
        protected ContentResolver cr;
        protected volatile boolean load;
        final /* synthetic */ RecommendDataLoader this$0;

        public Task(RecommendDataLoader r1, Context r2, String r3) {
            this.this$0 = r1;
            super(r3);
            this.cr = r2.getContentResolver();
        }

        public void setLoadFlag(boolean r1) {
            this.load = r1;
        }
    }

    private class UpdateCallLog extends Task {
        private List<UpdateCallLogRequest> list;
        final /* synthetic */ RecommendDataLoader this$0;

        public UpdateCallLog(RecommendDataLoader r2, Context r3, List<UpdateCallLogRequest> r4) {
            this.this$0 = r2;
            super(r2, r3, "Updata_Call_Log_Task");
            this.list = r4;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ArrayList<ContentProviderOperation> r0 = new ArrayList();
            Iterator<UpdateCallLogRequest> r1 = this.list.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            ContentProviderOperation r2 = buildOperations(r1.next());
            if (r2 == null) goto L4;
            r0.add(r2);
            goto L4
        L9:
            if (r0.isEmpty() == true) goto L24;
            this.cr.applyBatch("call_log", r0);     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecommendDataLoader.TAG, "Failed to update batch of contacts for call log. size: " + r0.size());
            if (RecommendDataLoader.access$900() == false) goto L25;
            e.printStackTrace();
            return;
        L25:
            return;
        }

        private ContentProviderOperation buildOperations(UpdateCallLogRequest r14) {
            String r13 = r14.number;
            String r0 = r14.countryIso;
            RecommendContact r1 = r14.cursorInfo;
            RecommendContact r15 = r14.nowInfo;
            ContentValues r2 = new ContentValues();
            if (r1 != null) goto L5;
            r2.put("name", r15.name);
            r2.put("numbertype", Integer.valueOf(r15.type));
            r2.put("numberlabel", r15.label);
            r2.put(BlockedCallAdapter.KEY_LOOKUP_URI, UriUtils.uriToString(r15.lookupUri));
            r2.put("matched_number", r15.number);
            r2.put("normalized_number", r15.normalizedNumber);
            r2.put("photo_id", Long.valueOf(r15.photoId));
            r2.put("formatted_number", r15.formattedNumber);
        L30:
            if (r2.size() <= 0) goto L37;
            StringBuilder r16 = new StringBuilder("number =? AND ");
            if (TextUtils.isEmpty(r0) == false) goto L34;
            r16.append("countryiso IS NULL");
            String[] r3 = {r13};
        L35:
            r16.append(" AND type IN (1, 7, 2, 3)");
            return ContentProviderOperation.newUpdate(CallLog.Calls.CONTENT_URI).withValues(r2).withSelection(r16.toString(), r3).build();
        L34:
            r16.append("countryiso =?");
            r3 = new String[]{r13, r0};
            goto L35
        L37:
            return null;
        L5:
            if (TextUtils.equals(r1.name, r15.name) == true) goto L8;
            r2.put("name", r15.name);
        L8:
            if (r1.type == r15.type) goto L11;
            r2.put("numbertype", Integer.valueOf(r15.type));
        L11:
            if (TextUtils.equals(r1.label, r15.label) == true) goto L14;
            r2.put("numberlabel", r15.label);
        L14:
            if (UriUtils.areEqual(r15.lookupUri, r15.lookupUri) == true) goto L17;
            r2.put(BlockedCallAdapter.KEY_LOOKUP_URI, UriUtils.uriToString(r15.lookupUri));
        L17:
            if (TextUtils.equals(r1.normalizedNumber, r15.normalizedNumber) == true) goto L20;
            r2.put("normalized_number", r15.normalizedNumber);
        L20:
            if (TextUtils.equals(r1.number, r15.number) == true) goto L23;
            r2.put("matched_number", r15.number);
        L23:
            if (r1.photoId == r15.photoId) goto L26;
            r2.put("photo_id", Long.valueOf(r15.photoId));
        L26:
            if (TextUtils.equals(r1.formattedNumber, r15.formattedNumber) == true) goto L30;
            r2.put("formatted_number", r15.formattedNumber);
            goto L30
        }
    }

    private class UpdateCallLogRequest {
        public String countryIso;
        public RecommendContact cursorInfo;
        public RecommendContact nowInfo;
        public String number;
        final /* synthetic */ RecommendDataLoader this$0;

        public UpdateCallLogRequest(RecommendDataLoader r1, String r2, String r3, RecommendContact r4, RecommendContact r5) {
            this.this$0 = r1;
            this.number = r2;
            this.countryIso = r3;
            this.cursorInfo = r4;
            this.nowInfo = r5;
        }
    }

    static /* synthetic */ boolean access$000(RecommendDataLoader r0) {
        return r0.mLoad;
    }

    static /* synthetic */ boolean access$002(RecommendDataLoader r0, boolean r1) {
        r0.mLoad = r1;
        return r1;
    }

    static /* synthetic */ void access$100(RecommendDataLoader r0, List r1) {
        r0.notifyRecommendDataLoaded(r1);
    }

    static /* synthetic */ boolean access$1000(RecommendDataLoader r0) {
        return r0.mForDialpad;
    }

    static /* synthetic */ Handler access$1100(RecommendDataLoader r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ExpirableCache access$1200(RecommendDataLoader r0) {
        return r0.mContactCache;
    }

    static /* synthetic */ ContactInfoHelper access$1300(RecommendDataLoader r0) {
        return r0.mContactInfoHelper;
    }

    static /* synthetic */ boolean access$1400(RecommendDataLoader r0, RecommendContact r1, List r2) {
        return r0.isRecommendContactInList(r1, r2);
    }

    static /* synthetic */ BlacklistManager access$1500(RecommendDataLoader r0) {
        return r0.mBlackListManager;
    }

    static /* synthetic */ CountryMonitor access$1600(RecommendDataLoader r0) {
        return r0.mCountryMonitor;
    }

    static /* synthetic */ ExecutorService access$200(RecommendDataLoader r0) {
        return r0.mExecutor;
    }

    static /* synthetic */ Context access$300(RecommendDataLoader r0) {
        return r0.mContext;
    }

    static /* synthetic */ CountDownLatch access$400(RecommendDataLoader r0) {
        return r0.mLoaderLatch;
    }

    static /* synthetic */ List access$500(RecommendDataLoader r0) {
        return r0.mDataList;
    }

    static /* synthetic */ List access$600(RecommendDataLoader r0) {
        return r0.mRecentData;
    }

    static /* synthetic */ List access$602(RecommendDataLoader r0, List r1) {
        r0.mRecentData = r1;
        return r1;
    }

    static /* synthetic */ List access$700(RecommendDataLoader r0) {
        return r0.mFrequentData;
    }

    static /* synthetic */ List access$702(RecommendDataLoader r0, List r1) {
        r0.mFrequentData = r1;
        return r1;
    }

    static /* synthetic */ List access$800(RecommendDataLoader r0) {
        return r0.mFavoriteData;
    }

    static /* synthetic */ List access$802(RecommendDataLoader r0, List r1) {
        r0.mFavoriteData = r1;
        return r1;
    }

    static /* synthetic */ boolean access$900() {
        return DEBUG;
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
        int r0 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r0;
        CORE_POOL_SIZE = Math.max(2, Math.min(r0 - 1, 4));
    }

    public void setOnRecommendDataLoadListener(OnRecommendDataLoadListener r1) {
        this.mListener = r1;
    }

    private void notifyRecommendDataLoaded(List<BaseFlowAdapter.FlowEntry> r1) {
        OnRecommendDataLoadListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRecommendDataLoaded(r1);
        return;
    }

    public RecommendDataLoader(Context r3, OnRecommendDataLoadListener r4) {
        this.mExecutor = ExecutorUtils.newFixedThreadPool(CORE_POOL_SIZE, "RecommendLoader");
        this.mContactCache = ExpirableCache.create(100);
        this.mDataList = new ArrayList();
        this.mLoaderList = new ArrayList();
        this.mHandler = new AnonymousClass1(this);
        this.mContext = r3;
        this.mListener = r4;
        String r5 = ContactsUtils.getCurrentCountryIso(r3);
        this.mContactInfoHelper = new ContactInfoHelper(this.mContext, r5);
        this.mBlackListManager = BlacklistManager.getInstances(this.mContext);
        this.mCountryMonitor = CountryMonitor.getInstance(this.mContext);
    }

    public void invalidateCache() {
        this.mContactCache.expireAll();
    }

    public void loadRecommendData(boolean r4) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Load recommend data from dialpad? " + r4 + ", mLoad=" + this.mLoad);
        if (this.mLoad == true) goto L15;
        this.mForDialpad = r4;
        invalidateCache();
        if (r4 == false) goto L7;
        int r1 = 2;
    L8:
        this.mLoaderLatch = new CountDownLatch(r1);
        this.mLoaderList.clear();
        this.mLoaderList.add(new LoadDoneLatch(this, this.mContext));
        this.mLoaderList.add(new RecentLoader(this, this.mContext));
        this.mLoaderList.add(new FrequentLoader(this, this.mContext));
        if (r4 == true) goto L11;
        this.mLoaderList.add(new FavoriteLoader(this, this.mContext));
    L11:
        this.mLoad = true;
        Iterator<Task> r5 = this.mLoaderList.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Task r0 = r5.next();
        r0.setLoadFlag(this.mLoad);
        this.mExecutor.execute(r0);
        goto L13
    L17:
        return;
    L7:
        r1 = 3;
        goto L8
    }

    public boolean isLoading() {
        return this.mLoad;
    }

    public void stopLoadRecommendData(String r3) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Stop load recommend data for: " + r3);
        this.mLoad = false;
        Iterator<Task> r4 = this.mLoaderList.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().setLoadFlag(this.mLoad);
        goto L4
    L6:
        this.mLoaderList.clear();
        List<RecommendContact> r5 = this.mRecentData;
        if (r5 == null) goto L9;
        r5.clear();
    L9:
        List<RecommendContact> r6 = this.mFrequentData;
        if (r6 == null) goto L12;
        r6.clear();
    L12:
        List<RecommendContact> r7 = this.mFavoriteData;
        if (r7 == null) goto L15;
        r7.clear();
    L15:
        invalidateCache();
    }

    public void destroy() {
        if (DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Destroy recommend data loader.");
    L5:
        stopLoadRecommendData("self");
        this.mExecutor.shutdownNow();
        this.mExecutor = null;
        this.mListener = null;
        invalidateCache();
        this.mContext = null;
    }

    private boolean isRecommendContactInList(RecommendContact r2, List<RecommendContact> r3) {
        if (r2 == null) goto L16;
        if (r3 == null) goto L17;
        Iterator<RecommendContact> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        if (r2.isSameContactWith(r4.next()) == false) goto L8;
        return true;
    L18:
        return false;
    L17:
        return false;
    L16:
        return false;
    }
}
