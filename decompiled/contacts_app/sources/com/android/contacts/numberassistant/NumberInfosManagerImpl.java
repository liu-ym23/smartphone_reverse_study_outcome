package com.android.contacts.numberassistant;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.LruCache;
import bytedanceos.app.numberassistant.NumberAssistantCallback;
import bytedanceos.app.numberassistant.NumberAssistantProxy;
import bytedanceos.app.numberassistant.NumberBaseInfo;
import bytedanceos.app.numberassistant.NumberLogoInfo;
import bytedanceos.app.numberassistant.NumberMarkInfo;
import bytedanceos.app.numberassistant.NumberQueryParams;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.widget.AvatarImageView;
import com.android.vcard.VCardConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class NumberInfosManagerImpl extends NumberInfosManager {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int KEY_LOGO_TAG = 2131363741;
    private static final int MAXIMUM_POOL_SIZE = 0;
    public static final String QUERY_OFFLINE_MODE_KEY = "query_offline_mode";
    public static final Executor sExecutor = null;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;
    private NumberAssistantProxy mAssistant;
    private Context mContext;
    private Handler mHandler;
    private LruCache<String, NumberInfosManager.NumberInfos> mInfoCaches;
    private boolean mIsConnected;
    private LruCache<String, NumberInfosManager.LinkedNumberInfosListener> mListenerCaches;
    private PhoneNumberHelper mPhoneNumberHelper;

    /* JADX INFO: renamed from: com.android.contacts.numberassistant.NumberInfosManagerImpl$11, reason: invalid class name */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ NumberInfosManagerImpl this$0;
        final /* synthetic */ boolean val$isOfflineMode;
        final /* synthetic */ NumberInfosManager.NumberInfosListener val$listener;
        final /* synthetic */ List val$numbers;
        final /* synthetic */ int val$queryStrategy;
        final /* synthetic */ int val$queryType;

        AnonymousClass11(NumberInfosManagerImpl r1, NumberInfosManager.NumberInfosListener r2, List r3, int r4, int r5, boolean r6) {
            this.this$0 = r1;
            this.val$listener = r2;
            this.val$numbers = r3;
            this.val$queryType = r4;
            this.val$queryStrategy = r5;
            this.val$isOfflineMode = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberInfosManager.NumberInfosListenerAdatper r4 = new AnonymousClass1(this);
            NumberInfosManagerImpl.access$300(this.this$0, this.val$numbers, this.val$queryType, this.val$queryStrategy, r4, this.val$isOfflineMode);
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.numberassistant.NumberInfosManagerImpl$12, reason: invalid class name */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ NumberInfosManagerImpl this$0;
        final /* synthetic */ String val$customerMark;
        final /* synthetic */ NumberInfosManager.NumberInfosListener val$listener;
        final /* synthetic */ String val$number;
        final /* synthetic */ int val$type;

        AnonymousClass12(NumberInfosManagerImpl r1, NumberInfosManager.NumberInfosListener r2, String r3, int r4, String r5) {
            this.this$0 = r1;
            this.val$listener = r2;
            this.val$number = r3;
            this.val$type = r4;
            this.val$customerMark = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberInfosManager.NumberInfosListenerAdatper r0 = new AnonymousClass1(this);
            NumberInfosManagerImpl.access$400(this.this$0, this.val$number, this.val$type, this.val$customerMark, r0);
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.numberassistant.NumberInfosManagerImpl$15, reason: invalid class name */
    public class AnonymousClass15 extends NumberAssistantCallback {
        private List<NumberInfosManager.NumberInfos> mNumberInfosList;
        final /* synthetic */ NumberInfosManagerImpl this$0;
        final /* synthetic */ NumberInfosManager.NumberInfosListener val$listener;
        final /* synthetic */ List val$numbers;
        final /* synthetic */ NumberQueryParams val$queryParams;
        final /* synthetic */ int val$queryType;

        AnonymousClass15(NumberInfosManagerImpl r1, NumberQueryParams r2, List r3, NumberInfosManager.NumberInfosListener r4, int r5) {
            this.this$0 = r1;
            this.val$queryParams = r2;
            this.val$numbers = r3;
            this.val$listener = r4;
            this.val$queryType = r5;
            this.mNumberInfosList = NumberInfosManager.NumberInfos.newNumberInfosList(r2);
        }

        public void executeMarkInfo(List<NumberMarkInfo> r7) {
            if (this.this$0.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "executeMarkInfo: " + this.val$numbers + " ->> " + r7);
        L5:
            int r0 = 0;
        L7:
            if (r0 >= this.mNumberInfosList.size()) goto L22;
            NumberInfosManager.NumberInfos r1 = this.mNumberInfosList.get(r0);
            if (r7 != null) goto L11;
        L20:
            NumberMarkInfo r3 = null;
        L21:
            r1.setNumberMarkInfo(r1.getNumber(), r3);
            r0 = r0 + 1;
            goto L7
        L11:
            if (r7.isEmpty() == true) goto L20;
            Iterator<NumberMarkInfo> r2 = r7.iterator();
        L14:
            if (r2.hasNext() == false) goto L20;
            r3 = r2.next();
            String r4 = NumberInfosManagerImpl.normalizeNumberForQuery(r3.getNumber());
            if (r4 == null) goto L14;
            if (r4.equals(r1.getNumber()) == false) goto L14;
        L22:
            onQueryNumberInfosDone();
        }

        public void executeLogoInfo(List<NumberLogoInfo> r7) {
            if (this.this$0.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "executeLogoInfo: " + this.val$numbers + " ->> " + r7);
        L5:
            int r0 = 0;
        L7:
            if (r0 >= this.mNumberInfosList.size()) goto L22;
            NumberInfosManager.NumberInfos r1 = this.mNumberInfosList.get(r0);
            if (r7 != null) goto L11;
        L20:
            NumberLogoInfo r3 = null;
        L21:
            r1.setNumberLogoInfo(r1.getNumber(), r3);
            r0 = r0 + 1;
            goto L7
        L11:
            if (r7.isEmpty() == true) goto L20;
            Iterator<NumberLogoInfo> r2 = r7.iterator();
        L14:
            if (r2.hasNext() == false) goto L20;
            r3 = r2.next();
            String r4 = NumberInfosManagerImpl.normalizeNumberForQuery(r3.getNumber());
            if (r4 == null) goto L14;
            if (r4.equals(r1.getNumber()) == false) goto L14;
        L22:
            onQueryNumberInfosDone();
        }

        public void executeBaseInfo(List<NumberBaseInfo> r7) {
            if (this.this$0.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "executeBaseInfo: " + this.val$numbers + " ->> " + r7);
        L6:
            if (this.val$queryParams.isQueryYellowPage() == false) goto L8;
            onQueryYellowPageDone(r7);
            return;
        L8:
            int r0 = 0;
        L10:
            if (r0 >= this.mNumberInfosList.size()) goto L25;
            NumberInfosManager.NumberInfos r1 = this.mNumberInfosList.get(r0);
            if (r7 != null) goto L14;
        L23:
            NumberBaseInfo r3 = null;
        L24:
            r1.setNumberBaseInfo(r1.getNumber(), r3);
            r0 = r0 + 1;
            goto L10
        L14:
            if (r7.isEmpty() == true) goto L23;
            Iterator<NumberBaseInfo> r2 = r7.iterator();
        L17:
            if (r2.hasNext() == false) goto L23;
            r3 = r2.next();
            String r4 = NumberInfosManagerImpl.normalizeNumberForQuery(r3.getNumber());
            if (r4 == null) goto L17;
            if (r4.equals(r1.getNumber()) == false) goto L17;
        L25:
            onQueryNumberInfosDone();
        }

        private void onQueryNumberInfosDone() {
            int r1 = 0;
            if (this.mNumberInfosList.get(0).hasQueriedDone() == true) goto L5;
            return;
        L5:
            if (this.val$listener != null) goto L7;
            return;
        L7:
            if (this.this$0.DEBUG == false) goto L10;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "onQueryNumberInfosDone:: " + this.mNumberInfosList);
        L10:
            if (r1 >= this.mNumberInfosList.size()) goto L25;
            NumberInfosManager.NumberInfos r0 = this.mNumberInfosList.get(r1);
            NumberInfosManager.NumberInfos r2 = (NumberInfosManager.NumberInfos) NumberInfosManagerImpl.access$500(this.this$0).get(r0.getNumber());
            if (r2 == null) goto L14;
            r2.merge(r0);
            r0 = r2;
        L15:
            NumberInfosManager.NumberInfosListener r3 = (NumberInfosManager.NumberInfosListener) NumberInfosManagerImpl.access$700(this.this$0).remove(NumberInfosManagerImpl.access$600(this.this$0, r0.getNumber(), this.val$queryType));
            if (r3 == null) goto L18;
            r3.onQueryNumberInfosDone(r0);
        L18:
            r1 = r1 + 1;
            goto L10
        L14:
            NumberInfosManagerImpl.access$500(this.this$0).put(r0.getNumber(), r0);
            goto L15
        }

        private void onQueryYellowPageDone(List<NumberBaseInfo> r3) {
            if (this.val$listener != null) goto L5;
            return;
        L5:
            if (r3 != null) goto L7;
            int r1 = 0;
        L8:
            final ArrayList r0 = new ArrayList(r1);
            if (r3 == null) goto L12;
            r3.forEach(new NumberInfosManagerImpl$15$$ExternalSyntheticLambda0(r0));
        L12:
            if (this.this$0.DEBUG == false) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "onQueryYellowPageDone:: " + r0);
        L14:
            this.val$listener.onQueryYellowPageDone(r0);
            return;
        L7:
            r1 = r3.size();
            goto L8
        }

        static /* synthetic */ void lambda$onQueryYellowPageDone$0(List r2, NumberBaseInfo r3) {
            r2.add(new NumberInfosManager.NumberInfos(null, r3, null, null));
        }
    }

    static /* synthetic */ boolean access$002(NumberInfosManagerImpl r0, boolean r1) {
        r0.mIsConnected = r1;
        return r1;
    }

    static /* synthetic */ void access$100(NumberInfosManagerImpl r0, String r1, NumberInfosManager.NumberInfosListener r2) {
        r0.getMarkInfoAsync(r1, r2);
    }

    static /* synthetic */ Handler access$200(NumberInfosManagerImpl r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$300(NumberInfosManagerImpl r0, List r1, int r2, int r3, NumberInfosManager.NumberInfosListener r4, boolean r5) {
        r0.internalQueryNumberInfos(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ void access$400(NumberInfosManagerImpl r0, String r1, int r2, String r3, NumberInfosManager.NumberInfosListener r4) {
        r0.internalUploadMarkInfos(r1, r2, r3, r4);
    }

    static /* synthetic */ LruCache access$500(NumberInfosManagerImpl r0) {
        return r0.mInfoCaches;
    }

    static /* synthetic */ String access$600(NumberInfosManagerImpl r0, String r1, int r2) {
        return r0.getListenerKey(r1, r2);
    }

    static /* synthetic */ LruCache access$700(NumberInfosManagerImpl r0) {
        return r0.mListenerCaches;
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r0;
        int r4 = Math.max(2, Math.min(r0 - 1, 4));
        CORE_POOL_SIZE = r4;
        int r5 = (r0 * 2) + 1;
        MAXIMUM_POOL_SIZE = r5;
        ThreadFactory r10 = new AnonymousClass1();
        sThreadFactory = r10;
        LinkedBlockingQueue r9 = new LinkedBlockingQueue();
        sPoolWorkQueue = r9;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r4, r5, 30, TimeUnit.SECONDS, r9, r10, new ThreadPoolExecutor.CallerRunsPolicy());
        r1.allowCoreThreadTimeOut(true);
        sExecutor = r1;
    }

    public static String normalizeNumberForQuery(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        String r3 = PhoneNumberUtils.extractNetworkPortion(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return r3;
    L8:
        if (r3.startsWith("+86") == true) goto L12;
        if (r3.startsWith("0086") == true) goto L12;
        return r3;
    L12:
        if (r3.startsWith("+86") == false) goto L14;
        String r4 = r3.substring(3);
    L16:
        return r4.trim();
    L14:
        r4 = r3.substring(4);
        goto L16
    }

    public NumberInfosManagerImpl() {
        this.mContext = ContactsApplication.getInstance().getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mInfoCaches = new LruCache(140);
        this.mListenerCaches = new LruCache(140);
        this.mPhoneNumberHelper = new PhoneNumberHelper(this.mContext.getResources());
        this.mAssistant = NumberAssistantProxy.getInstance();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("NumberInfosManager", "Number service binding... *\\(^_^)/*");
        this.mAssistant.bind(this.mContext, new AnonymousClass2(this));
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public NumberInfosManager.NumberInfos getCachedLogoInfos(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        String r3 = normalizeNumberForQuery(r2);
        NumberInfosManager.NumberInfos r1 = this.mInfoCaches.get(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.getLogo() == null) goto L12;
        return r1;
    L12:
        return null;
    L9:
        return null;
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public NumberInfosManager.NumberInfos getCachedBaseAndMarkInfos(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L11;
        String r3 = normalizeNumberForQuery(r2);
        NumberInfosManager.NumberInfos r1 = this.mInfoCaches.get(r3);
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.hasQueriedDone(1) == true) goto L9;
        return null;
    L9:
        if (r1.hasQueriedDone(2) == false) goto L15;
        return r1;
    L15:
        return null;
    L11:
        return null;
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getBaseAndMarkOfflineAsync(final String r8, NumberInfosManager.NumberInfosListener r9) {
        if (this.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getBaseAndMarkOfflineAsync: " + r8);
    L6:
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L8;
    L11:
        r9.onQueryNumberInfosDone(null);
        return;
    L8:
        if (ContactsUtils.isFeatureDomestic() == false) goto L11;
        internalQueryNumberInfosAsync(new AnonymousClass3(this, r8), 3, 1, r9, true);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getBaseAndMarkInfos(final String r3, NumberInfosManager.NumberInfosListener r4) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getBaseAndMarkInfos: " + r3);
    L5:
        internalQueryNumberInfos(new AnonymousClass4(this, r3), 3, 1, r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getBaseAndMarkInfosAsync(final String r3, NumberInfosManager.NumberInfosListener r4) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getBaseAndMarkInfosAsync: " + r3);
    L5:
        getBaseAndMarkInfosAsync(new AnonymousClass5(this, r3), r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getBaseAndMarkInfosAsync(List<String> r3, NumberInfosManager.NumberInfosListener r4) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getBaseAndMarkInfosAsync: " + r3);
    L5:
        internalQueryNumberInfosAsync(r3, 3, 1, r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getBaseInfos(final String r3, NumberInfosManager.NumberInfosListener r4) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getBaseInfos: " + r3);
    L5:
        internalQueryNumberInfos(new AnonymousClass6(this, r3), 1, 1, r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getPublicNumberLogoAsync(final String r3, NumberInfosManager.NumberInfosListener r4) {
        if (this.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getPublicNumberLogoAsync: " + r3);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return;
    L8:
        if (this.mPhoneNumberHelper.isVoicemailNumber(r3) == false) goto L11;
        r4.onQueryNumberInfosDone(new NumberInfosManager.NumberInfos(BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.voicemail)));
        return;
    L11:
        NumberInfosManager.NumberInfos r0 = this.mInfoCaches.get(r3);
        if (r0 != null) goto L14;
    L16:
        internalQueryNumberInfosAsync(new AnonymousClass7(this, r3), 5, 1, r4);
        return;
    L14:
        if (r0.hasQueriedDone(4) == false) goto L16;
        r4.onQueryNumberInfosDone(r0);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void bindPublicNumberLogoAsync(final String r3, final AvatarImageView r4, final Bitmap r5) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "bindPublicNumberLogoAsync: " + r3);
    L5:
        NumberInfosManager.NumberInfosListenerAdatper r0 = new AnonymousClass8(this, r3, r4, r5);
        r4.setTag(R.id.tag_logo_number, r3);
        getPublicNumberLogoAsync(r3, r0);
    }

    private void getMarkInfoAsync(final String r3, NumberInfosManager.NumberInfosListener r4) {
        internalQueryNumberInfosAsync(new AnonymousClass9(this, r3), 2, 1, r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void getYellowPageDataAsync(final String r3, NumberInfosManager.NumberInfosListener r4) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "getYellowPageDataAsync: " + r3);
    L5:
        internalQueryNumberInfosAsync(new AnonymousClass10(this, r3), 1024, -1, r4);
    }

    private void internalQueryNumberInfosAsync(List<String> r7, int r8, int r9, NumberInfosManager.NumberInfosListener r10) {
        internalQueryNumberInfosAsync(r7, r8, r9, r10, false);
    }

    private void internalQueryNumberInfosAsync(List<String> r10, int r11, int r12, NumberInfosManager.NumberInfosListener r13, boolean r14) {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "internalQueryNumberInfosAsync: number=" + r10 + ", queryType=" + r11 + ", strategy=" + r12 + ", isOfflineMode=" + r14);
    L5:
        AnonymousClass11 r0 = new AnonymousClass11(this, r13, r10, r11, r12, r14);
        if (this.DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "exe >> internalQueryNumberInfosAsync: " + r10);
    L13:
        sExecutor.execute(r0);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void setMarkInfoAsync(String r2, int r3, NumberInfosManager.NumberInfosListener r4) {
        NumberInfosManager.Classify r5 = NumberInfosManager.Classify.getClassifyByIndex(r3);
        if (r5 != null) goto L5;
        r4.onUploadMarkInfoDone(false);
        return;
    L5:
        internalUploadMarkInfosAsync(r2, r5.getClassifyType(), null, r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void setCustomMarkInfoAsync(String r2, String r3, NumberInfosManager.NumberInfosListener r4) {
        internalUploadMarkInfosAsync(r2, 1073741824, r3, r4);
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager
    public void clearMarkInfoAsync(String r3, NumberInfosManager.NumberInfosListener r4) {
        internalUploadMarkInfosAsync(r3, 0, null, r4);
    }

    private void internalUploadMarkInfosAsync(String r8, int r9, String r10, NumberInfosManager.NumberInfosListener r11) {
        AnonymousClass12 r6 = new AnonymousClass12(this, r11, r8, r9, r10);
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "exe >> internalUploadMarkInfosAsync: " + r8);
    L5:
        sExecutor.execute(r6);
    }

    private void internalUploadMarkInfos(final String r4, int r5, String r6, final NumberInfosManager.NumberInfosListener r7) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L17:
        r7.onUploadMarkInfoDone(false);
        return;
    L5:
        if (r5 == 1073741824) goto L7;
    L9:
        final NumberMarkInfo.Builder r1 = new NumberMarkInfo.Builder();
        r1.setNumber(r4);
        r1.addMarkClassify(r5);
        r1.setMarkClassifyCount(r5, 1);
        if (r5 != 1073741824) goto L13;
        r1.setCustomizeMarkString(r6);
    L13:
        if (this.DEBUG == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "internalUploadMarkInfos: " + r4 + ", " + r1.build());
    L15:
        this.mAssistant.uploadNumberMark(new AnonymousClass14(this, r1), new AnonymousClass13(this, r4, r7));
        return;
    L7:
        if (TextUtils.isEmpty(r6) == false) goto L9;
        goto L9
    }

    private void internalQueryNumberInfos(List<String> r7, int r8, int r9, NumberInfosManager.NumberInfosListener r10) {
        internalQueryNumberInfos(r7, r8, r9, r10, false);
    }

    private void internalQueryNumberInfos(List<String> r9, int r10, int r11, NumberInfosManager.NumberInfosListener r12, boolean r13) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.isEmpty() == true) goto L19;
        if (r12 == null) goto L20;
        ensureConnected();
        NumberQueryParams r14 = buildQueryParams(r9, r10, r11, r12, r13);
        if (r14 != null) goto L11;
        return;
    L11:
        if (this.DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "internalQueryNumberInfos(" + r9 + ", " + strQueryType(r14) + " : " + r10 + ", isOfflineMode=" + r13 + ")");
    L13:
        AnonymousClass15 r15 = new AnonymousClass15(this, r14, r9, r12, r10);
        if (this.DEBUG == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "Go query ===> " + r14);
    L16:
        this.mAssistant.queryNumberInfo(r14, r15);
        return;
    L20:
        return;
    }

    private NumberQueryParams buildQueryParams(List<String> r7, int r8, int r9, NumberInfosManager.NumberInfosListener r10) {
        return buildQueryParams(r7, r8, r9, r10, false);
    }

    private NumberQueryParams buildQueryParams(List<String> r8, int r9, int r10, NumberInfosManager.NumberInfosListener r11, boolean r12) {
        NumberQueryParams.Builder r0 = new NumberQueryParams.Builder();
        if (r9 <= (-1)) goto L5;
        r0.setQueryType(r9);
    L5:
        NumberQueryParams r2 = r0.build();
        if (r2.isQueryYellowPage() == false) goto L8;
        Bundle r7 = new Bundle();
        r7.putString("query_yellow_page_text", r8.get(0));
        r0.setExtension(r7);
    L22:
        if (r10 <= (-1)) goto L24;
        r0.setQueryStrategy(r10);
    L24:
        if (r12 == false) goto L26;
        Bundle r13 = new Bundle();
        r13.putBoolean(QUERY_OFFLINE_MODE_KEY, true);
        r0.setExtension(r13);
    L26:
        return r2;
    L8:
        Iterator<String> r14 = r8.iterator();
    L10:
        if (r14.hasNext() == false) goto L19;
        String r3 = normalizeNumberForQuery(r14.next());
        if (callListenerDone(r2, this.mInfoCaches.get(r3), r11) == true) goto L10;
        NumberInfosManager.LinkedNumberInfosListener r4 = new NumberInfosManager.LinkedNumberInfosListener(this, r11);
        NumberInfosManager.LinkedNumberInfosListener r5 = this.mListenerCaches.put(getListenerKey(r3, r9), r4);
        if (r5 != null) goto L16;
        r2.addNumber(r3);
        goto L10
    L16:
        r4.setNext(r5);
        goto L10
    L19:
        if (r2.getNumberList().size() > 0) goto L22;
        return null;
    }

    private String getListenerKey(String r1, int r2) {
        return r1 + "&" + r2;
    }

    private boolean callListenerDone(NumberQueryParams r4, NumberInfosManager.NumberInfos r5, NumberInfosManager.NumberInfosListener r6) {
        if (r5 != null) goto L5;
    L24:
        return false;
    L5:
        if (r4.isQueryBase() == true) goto L7;
    L9:
        boolean r0 = true;
    L11:
        if (r4.isQueryMark() == false) goto L16;
        if (r5.hasQueriedDone(2) == true) goto L16;
        r0 = false;
    L16:
        if (r4.isQueryLogo() == true) goto L18;
    L20:
        if (r0 == false) goto L24;
        r6.onQueryNumberInfosDone(r5);
        if (r4.isQueryMark() == true) goto L24;
        return true;
    L18:
        if (r5.hasQueriedDone(4) == true) goto L20;
        r0 = false;
        goto L20
    L7:
        if (r5.hasQueriedDone(1) == true) goto L9;
        r0 = false;
        goto L11
    }

    private String strQueryType(NumberQueryParams r2) {
        StringBuffer r1 = new StringBuffer();
        if (r2.isQueryBase() == false) goto L6;
        r1.append("BASE");
    L6:
        if (r2.isQueryMark() == false) goto L13;
        if (r1.length() > 0) goto L10;
        String r0 = "MARK";
    L11:
        r1.append(r0);
        goto L13
    L10:
        r0 = "|MARK";
    L13:
        if (r2.isQueryLogo() == false) goto L20;
        if (r1.length() > 0) goto L17;
        String r3 = VCardConstants.PROPERTY_LOGO;
    L18:
        r1.append(r3);
        goto L20
    L17:
        r3 = "|LOGO";
    L20:
        if (r2.isQueryYellowPage() == false) goto L23;
        r1.append("YELLOW");
    L23:
        return r1.toString();
    }

    private void ensureConnected() {
        if (this.mIsConnected == true) goto L17;
        int r0 = 0;
    L6:
        if (r0 >= 3) goto L25;
        if (this.mIsConnected == true) goto L26;
        Thread.sleep(100);     // Catch: InterruptedException -> L14
        if (ContactsUtils.DEBUG == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NumberInfosManager", "sleep in ensureConnected");     // Catch: InterruptedException -> L14
    L16:
        r0 = r0 + 1;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L26:
        return;
    L25:
        return;
    }
}
