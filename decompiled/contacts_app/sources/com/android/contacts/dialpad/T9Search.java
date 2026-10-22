package com.android.contacts.dialpad;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.preference.PreferenceManager;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bytedanceos.util.PinyinHelper;
import com.GlobalProxyLancet;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.PhoneCallDetailsHelper;
import com.android.contacts.PinnedHeaderList.WrapperView;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.bytedanceosquickcontact.QuickContactHelper;
import com.android.contacts.bytedanceosquickcontact.QuickContactListener;
import com.android.contacts.calllog.CallLogListItemHelper;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.CallTypeHelper;
import com.android.contacts.calllog.CallTypeIconsView;
import com.android.contacts.calllog.IntentProvider;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.dialpad.search.T9SearchHelper;
import com.android.contacts.dialpad.search.T9SearchLocaleUtils;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.HorizontalScrollListView;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.numberassistant.NumberInfosManagerImpl;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactTypeLabelUtils;
import com.android.contacts.util.FuzzyTonesHelper;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.widget.AvatarImageView;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.oui.button.OButton;
import com.obric.tracker.CallScreenShowUtils;
import com.obric.tracker.event.CallScreenShowEvent;
import com.obric.utils.commonitemview.CallLogItemCardView;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obric.utils.views.commonitemview.ContactsSwipeHelper;
import com.obric.utils.views.commonitemview.bean.SwipeItemButtonType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import obric.app.tracker.Agent;

/* JADX INFO: loaded from: classes.dex */
public class T9Search implements ComponentCallbacks2 {
    private static final String CACHE_FILE_NAME = "t9cache.par";
    private static final int CALLS_CACHED_LOOKUP_URI = 1;
    private static final int CALLS_CACHED_NUMBER_LABEL = 6;
    private static final int CALLS_COLUMN_SHOW_SIM_ICON = 9;
    private static final int CALLS_COLUMN_SIM_ID = 10;
    private static final int CALLS_COLUMN_SUBSCRIPTION = 8;
    private static final int CALLS_COUNTRY_ISO = 7;
    private static final int CALLS_DATE = 0;
    private static final int CALLS_GEOCODED_LOCATION = 5;
    private static final int CALLS_ID = 3;
    private static final int CALLS_NUMBER = 2;
    private static final int CaLLS_TYPE = 4;
    private static final int NAME_FIRST = 1;
    private static final int NUMBER_FIRST = 2;
    private static final String PHONE_ID_SELECTION = "mimetype = ? ";
    private static final String[] PHONE_ID_SELECTION_ARGS = null;
    private static final String PHONE_SORT = "contact_id ASC";
    private static final String SINGLE_PHONE_SELECTION = "contact_id = ? ";
    private static final String TAG = "T9Search";
    private static char[][] sT9Map;
    private static T9Search sT9Search;
    private static String sT9String;
    private final String[] CALLS_PROJECTION;
    private final boolean DEBUG;
    private Set<ContactItem> mAllResults;
    private BroadcastReceiver mBroadcastReceiver;
    private boolean mCacheLoaded;
    private ArrayList<ContactItem> mCallLogCache;
    private final Object mCallLogCacheLock;
    private boolean mCancelLoad;
    private long mContactId;
    private ContentObserver mContactObserver;
    private Uri mContactUri;
    private ArrayList<ContactItem> mContacts;
    private Context mContext;
    private int mDisplayOrder;
    private boolean mForceQuery;
    private boolean mHasRegisterContentObserver;
    private boolean mHasRegisterLocaleChanged;
    private ColorStateList mHighLightColor;
    private int mItemViewCachethrottle;
    private Listener mListener;
    private LoadTask mLoadTask;
    private boolean mLoaded;
    private Map<String, String> mLocationInfoCache;
    private Handler mMainHandler;
    private HashSet<String> mNumberKeys;
    private PreferencesCallback mPrefsCallback;
    private String mPrevInput;
    private Uri mProfileLookupUri;
    private LoadSingleContactTask mSingleLoadTask;
    private int mSortMode;
    private int mSortOrder;
    private boolean mSqlOnChange;
    private long mSyncTime;
    private Set<ContactItem> mTempAllResults;

    /* JADX INFO: renamed from: com.android.contacts.dialpad.T9Search$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType = null;

        static {
            int[] r0 = new int[SwipeItemButtonType.values().length];
            $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType = r0;
            r0[SwipeItemButtonType.SWIPE_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$utils$views$commonitemview$bean$SwipeItemButtonType[SwipeItemButtonType.SWIPE_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static class ContactQuery {
        public static final int CONTACT_DISPLAY_NAME = 1;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_LOOKUP_KEY = 5;
        public static final int CONTACT_PHOTO_THUMBNAIL_URI = 3;
        private static final String[] CONTACT_PROJECTION = null;
        public static final String CONTACT_SELECTION = "has_phone_number > 0";
        public static final String CONTACT_SORT = "_id ASC";
        public static final int CONTACT_SORT_KEY_PRIMARY = 4;
        public static final int CONTACT_TIME_CONTACTED = 2;

        private ContactQuery() {
        }

        static {
            CONTACT_PROJECTION = new String[]{"_id", "display_name", "times_contacted", "photo_thumb_uri", PickerFragment.CONTACT_SORT_CNAME, "lookup"};
        }

        public static String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            CONTACT_PROJECTION[1] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            CONTACT_PROJECTION[4] = "sort_key_alt";
        L11:
            return CONTACT_PROJECTION;
        L9:
            CONTACT_PROJECTION[4] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            CONTACT_PROJECTION[1] = "display_name";
            goto L7
        }
    }

    public interface Listener {
        boolean isResumed();

        boolean isSyncActive();

        void onLoadFinished();
    }

    private class LoadSingleContactTask extends LoadTask {
        final /* synthetic */ T9Search this$0;

        private LoadSingleContactTask(T9Search r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ LoadSingleContactTask(T9Search r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.contacts.dialpad.T9Search.LoadTask, android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Uri[] r1) {
            return doInBackground2(r1);
        }

        @Override // com.android.contacts.dialpad.T9Search.LoadTask, android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        @Override // com.android.contacts.dialpad.T9Search.LoadTask
        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Uri... r8) {
            Uri r9 = r8[0];
            if (r9 != null) goto L6;
            return null;
        L6:
            if (ContactsUtils.readBooleanQueryParameter(r9, "remove_duplicate_entries", false) == true) goto L8;
            Uri r0 = r9.buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build();
        L9:
            long r2 = T9Search.access$1500(this.this$0);
            T9Search.access$1502(this.this$0, -1);
            T9Search.access$1402(this.this$0, null);
            if (T9Search.access$2600(this.this$0) != null) goto L12;
        L14:
            loadChangedContact(r0, r2);
        L15:
            Iterator<ContactItem> r10 = this.contactsToRemove.iterator();
        L17:
            if (r10.hasNext() == false) goto L19;
            ContactItem r1 = r10.next();
            T9Search.access$800(this.this$0).remove(r1);
            T9Search.access$2000(this.this$0).remove(getNumberKey(r1.number));
            goto L17
        L19:
            Iterator<ContactItem> r11 = this.contactsToAdd.iterator();
        L21:
            if (r11.hasNext() == false) goto L23;
            ContactItem r3 = r11.next();
            T9Search.access$800(this.this$0).add(r3);
            T9Search.access$2000(this.this$0).add(getNumberKey(r3.number));
            goto L21
        L23:
            T9Search.access$1200(this.this$0);
            return null;
        L12:
            if (r9.equals(T9Search.access$2600(this.this$0)) == false) goto L14;
            loadChangedProfile(r0, r2);
            goto L15
        L8:
            r0 = r9;
            goto L9
        }

        @Override // com.android.contacts.dialpad.T9Search.LoadTask
        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            T9Search.access$100(this.this$0);
        }
    }

    private class LoadTask extends AsyncTask<Uri, Void, Void> {
        private ArrayList<ContactItem> calllogs;
        public ArrayList<ContactItem> contactsToAdd;
        public ArrayList<ContactItem> contactsToRemove;
        final /* synthetic */ T9Search this$0;

        private LoadTask(T9Search r1) {
            this.this$0 = r1;
            this.calllogs = new ArrayList();
            this.contactsToRemove = new ArrayList();
            this.contactsToAdd = new ArrayList();
        }

        /* synthetic */ LoadTask(T9Search r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$700(LoadTask r0) {
            r0.loadContactsForT9();
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Uri[] r1) {
            return doInBackground(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        protected Void doInBackground(Uri... r3) {
            if (T9Search.access$1000(this.this$0) == true) goto L8;
            T9Search r4 = this.this$0;
            T9Search.access$802(r4, T9Search.access$1100(r4, T9Search.CACHE_FILE_NAME));
            if (T9Search.access$800(this.this$0).size() <= 0) goto L7;
            T9Search.access$1200(this.this$0);
        L7:
            T9Search.access$1002(this.this$0, true);
        L8:
            loadContactsForT9();
            loadProfileForT9();
            if (T9Search.access$1300(this.this$0) == false) goto L11;
            return null;
        L11:
            T9Search.access$1200(this.this$0);
            loadCalllogForT9();
            if (T9Search.access$1300(this.this$0) == false) goto L14;
            return null;
        L14:
            T9Search.access$1200(this.this$0);
            T9Search r2 = this.this$0;
            T9Search.access$900(r2, T9Search.access$800(r2), T9Search.CACHE_FILE_NAME);
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        protected void onPostExecute(Void r3) {
            if (T9Search.access$1300(this.this$0) == false) goto L5;
        L9:
            T9Search.access$1602(this.this$0, true);
            T9Search.access$1302(this.this$0, false);
            if (T9Search.access$1700(this.this$0) == false) goto L13;
            T9Search.access$100(this.this$0);
            T9Search.access$1702(this.this$0, false);
            return;
        L13:
            return;
        L5:
            if (T9Search.access$000(this.this$0) == null) goto L9;
            if (T9Search.access$000(this.this$0).isResumed() == false) goto L9;
            T9Search.access$1402(this.this$0, null);
            T9Search.access$1502(this.this$0, -1);
            goto L9
        }

        private void loadCalllogForT9() {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                Method dump skipped, instruction units count: 266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.T9Search.LoadTask.loadCalllogForT9():void");
        }

        public synchronized void addAllToContacts(ArrayList<ContactItem> r2) {
            monitor-enter(this);
            T9Search.access$800(this.this$0).addAll(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public String getNumberKey(String r2) {
            String r1 = T9Search.removeNonDigits(r2);
            if (r1.length() < 11) goto L6;
            return r1.substring(r1.length() - 11);
        L6:
            if (r1.length() >= 7) goto L8;
            return r1;
        L8:
            return r1.substring(r1.length() - 7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void loadContactsForT9() {
            ArrayList<ContactItem> r0 = new ArrayList();
            HashSet<String> r2 = new HashSet();
            Cursor r3 = null;
            Cursor r4 = T9Search.access$1900(this.this$0).getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, ContactQuery.getProjection(T9Search.access$2300(this.this$0), T9Search.access$2400(this.this$0)), ContactQuery.CONTACT_SELECTION, null, ContactQuery.CONTACT_SORT);     // Catch: Throwable -> L104
            Cursor r5 = T9Search.access$1900(this.this$0).getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build(), PhoneQuery.getProjection(T9Search.access$2400(this.this$0)), null, null, T9Search.PHONE_SORT);     // Catch: Throwable -> L102
            if (r5 == null) goto L95;
            if (r4 == null) goto L95;
            r5.moveToFirst();     // Catch: Throwable -> L102
            Cursor r6 = T9Search.access$1900(this.this$0).getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"date", BlockedCallAdapter.KEY_LOOKUP_URI, "number"}, "lookup_uri is not NULL ", null, "date DESC LIMIT 500");     // Catch: Throwable -> L102
            int r7 = 0;
            int r8 = 1;
            if (r6 != null) goto L11;
        L18:
            ArrayList r9 = new ArrayList();     // Catch: Throwable -> L102
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).resume();     // Catch: Throwable -> L102
            long r10 = -1;
        L20:
            if (r4.moveToNext() == false) goto L87;
            if (T9Search.access$1300(this.this$0) == true) goto L87;
            long r11 = r4.getLong(r7);     // Catch: Throwable -> L102
            if (r5.isAfterLast() == true) goto L87;
            if (r11 == r10) goto L31;
            r9.clear();     // Catch: Throwable -> L102
            r10 = r11;
        L31:
            if (r5.getLong(r8) != r11) goto L85;
            if (T9Search.access$1300(this.this$0) == true) goto L85;
            String r13 = r5.getString(r7);     // Catch: Throwable -> L102
            if (TextUtils.isEmpty(r13) == false) goto L38;
        L80:
            long r16 = r10;
        L82:
            if (r5.moveToNext() == false) goto L86;
            r10 = r16;
            r7 = 0;
        L86:
            r10 = r16;
            r7 = 0;
            goto L20
        L38:
            if (ContactsUtils.isExistInList(r9, r13) == true) goto L80;
            ContactItem r14 = new ContactItem();     // Catch: Throwable -> L102
            r14.id = r11;     // Catch: Throwable -> L102
            r14.dataId = r5.getLong(6);     // Catch: Throwable -> L102
            r14.name = r4.getString(r8);     // Catch: Throwable -> L102
            if (TextUtils.isEmpty(r14.name) == true) goto L42;
            boolean r12 = r8;
        L43:
            r14.hasname = r12;     // Catch: Throwable -> L102
            r14.name = ContactsUtils.getContactName(T9Search.access$1900(this.this$0), r14.name);     // Catch: Throwable -> L102
            r14.number = PhoneNumberUtils.formatNumber(r13);     // Catch: Throwable -> L102
            r14.normalNumber = T9Search.removeNonDigits(r13);     // Catch: Throwable -> L102
            r14.normalName = T9Search.nameToNumber(r14.name);     // Catch: Throwable -> L102
            r14.lookupkey = r4.getString(5);     // Catch: Throwable -> L102
            r14.sortkey = r4.getString(4);     // Catch: Throwable -> L102
            r14.timesContacted = 0;     // Catch: Throwable -> L102
            r14.lookupUri = ContactsContract.Contacts.getLookupUri(r14.id, r14.lookupkey);     // Catch: Throwable -> L102
            Iterator<ContactItem> r15 = this.calllogs.iterator();     // Catch: Throwable -> L102
        L45:
            if (r15.hasNext() == false) goto L55;
            ContactItem r17 = r15.next();     // Catch: Throwable -> L102
            if (PhoneNumberUtils.compare(r17.number, r14.number) == true) goto L49;
            r10 = r10;
        L54:
            r10 = r10;
            goto L45
        L49:
            if (r14.timesContacted != 0) goto L52;
            r14.lastConnectTime = r17.lastConnectTime;     // Catch: Throwable -> L102
        L52:
            r8 = 1;
            r14.timesContacted++;     // Catch: Throwable -> L102
            r15.remove();     // Catch: Throwable -> L102
            goto L54
        L55:
            r16 = r10;
            r14.section = ContactsUtils.getContactSection(r14.sortkey);     // Catch: Throwable -> L102
            if (r5.getInt(2) <= 0) goto L58;
            boolean r18 = r8;
        L59:
            r14.isSuperPrimary = r18;     // Catch: Throwable -> L102
            r14.groupType = ContactTypeLabelUtils.getPhoneTypeLabel(T9Search.access$1900(this.this$0), Integer.valueOf(r5.getInt(3)), r5.getString(4));     // Catch: Throwable -> L102
            if (r4.isNull(3) == true) goto L63;
            r14.photoUri = Uri.parse(r4.getString(3));     // Catch: Throwable -> L102
        L63:
            if (r14.hasname == false) goto L72;
            int r19 = 0;
        L66:
            if (r19 >= r14.name.length()) goto L71;
            if (T9SearchLocaleUtils.isChinese(r14.name.charAt(r19)) == true) goto L69;
            r19 = r19 + 1;     // Catch: Throwable -> L102
            goto L66
        L69:
            r14.language = Locale.CHINA.getLanguage();     // Catch: Throwable -> L102
        L71:
            r14.positionLength.clear();     // Catch: Throwable -> L102
            setNameList(r14, r0, r2);     // Catch: Throwable -> L102
            goto L82
        L72:
            int r20 = 0;
        L74:
            if (r20 >= r14.pinyinNameList.size()) goto L79;
            if (r14.pinyinNameList.get(r20) == null) goto L79;
            r14.remainingLengthListInit.add(r20, Integer.valueOf(r14.pinyinNameList.get(r20).length()));     // Catch: Throwable -> L102
            r20 = r20 + 1;     // Catch: Throwable -> L102
        L79:
            r2.add(getNumberKey(r14.number));     // Catch: Throwable -> L102
            r0.add(r14);     // Catch: Throwable -> L102
            goto L82
        L58:
            r18 = 0;
            goto L59
        L42:
            r12 = 0;
        L85:
            r16 = r10;
        L87:
            if (r4 == null) goto L89;
            r4.close();
        L89:
            if (r5 == null) goto L91;
            r5.close();
        L91:
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).pause();
            if (T9Search.access$1300(this.this$0) == true) goto L132;
            T9Search.access$802(this.this$0, r0);
            T9Search.access$2002(this.this$0, r2);
            return;
        L132:
            return;
        L11:
            if (r6.moveToFirst() == true) goto L13;
        L17:
            r6.close();     // Catch: Throwable -> L102
        L13:
            if (r6.getString(1) == null) goto L16;
            ContactItem r21 = new ContactItem();     // Catch: Throwable -> L102
            r21.lookupUri = Uri.parse(r6.getString(1));     // Catch: Throwable -> L102
            r21.lastConnectTime = r6.getLong(0);     // Catch: Throwable -> L102
            r21.number = r6.getString(2);     // Catch: Throwable -> L102
            this.calllogs.add(r21);     // Catch: Throwable -> L102
        L16:
            if (r6.moveToNext() == true) goto L13;
        L95:
            T9Search.access$600("query phone number or contacts error in loadContactsForT9");     // Catch: Throwable -> L102
            if (r4 == null) goto L98;
            r4.close();
        L98:
            if (r5 == null) goto L100;
            r5.close();
        L100:
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).pause();
            return;
        L102:
            th = move-exception;
            Throwable r22 = th;
            r3 = r4;
        L106:
            if (r3 == null) goto L108;
            r3.close();
        L108:
            if (r3 == 0) goto L110;
            r3.close();
        L110:
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).pause();
            throw r22;
        L104:
            th = move-exception;
            r22 = th;
            goto L106
        }

        private boolean isNumberInList(String r1, List<PhoneNumberHolder> r2) {
            if (r2 == null) goto L10;
            Iterator<PhoneNumberHolder> r0 = r2.iterator();
        L5:
            if (r0.hasNext() == false) goto L15;
            if (TextUtils.equals(r0.next().number, r1) == false) goto L5;
            return true;
        L15:
            return false;
        L10:
            return false;
        }

        private List<PhoneNumberHolder> getProfileNumbers(long r14) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.android.contacts.dialpad.T9Search r1 = r13.this$0
                android.content.Context r1 = com.android.contacts.dialpad.T9Search.access$1900(r1)
                android.content.ContentResolver r2 = r1.getContentResolver()
                android.net.Uri r1 = android.provider.ContactsContract.Profile.CONTENT_URI
                java.lang.String r3 = "data"
                android.net.Uri r3 = android.net.Uri.withAppendedPath(r1, r3)
                com.android.contacts.dialpad.T9Search r1 = r13.this$0
                int r1 = com.android.contacts.dialpad.T9Search.access$2400(r1)
                java.lang.String[] r4 = com.android.contacts.dialpad.T9Search.PhoneQuery.getProjection(r1)
                java.lang.String r5 = "mimetype = ? AND contact_id = ?"
                r1 = 2
                java.lang.String[] r6 = new java.lang.String[r1]
                java.lang.String r7 = "vnd.android.cursor.item/phone_v2"
                r8 = 0
                r6[r8] = r7
                java.lang.String r7 = java.lang.String.valueOf(r14)
                r9 = 1
                r6[r9] = r7
                r7 = 0
                android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)
                if (r2 == 0) goto L9c
                boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                if (r3 == 0) goto L9c
            L40:
                com.android.contacts.dialpad.T9Search r3 = r13.this$0     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                boolean r3 = com.android.contacts.dialpad.T9Search.access$1300(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r4 = 0
                if (r3 == 0) goto L4f
                if (r2 == 0) goto L4e
                r2.close()
            L4e:
                return r4
            L4f:
                java.lang.String r3 = r2.getString(r8)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                boolean r5 = r13.isNumberInList(r3, r0)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                if (r5 == 0) goto L5a
                goto L86
            L5a:
                int r5 = r2.getInt(r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                if (r5 <= 0) goto L62
                r5 = r9
                goto L63
            L62:
                r5 = r8
            L63:
                r6 = 3
                int r6 = r2.getInt(r6)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r7 = 6
                long r10 = r2.getLong(r7)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r7 = 4
                java.lang.String r7 = r2.getString(r7)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                com.android.contacts.dialpad.T9Search$PhoneNumberHolder r12 = new com.android.contacts.dialpad.T9Search$PhoneNumberHolder     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.<init>(r4)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.contactID = r14     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.number = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.superPrimary = r5     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.type = r6     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.dataID = r10     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r12.label = r7     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                r0.add(r12)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            L86:
                boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
                if (r3 != 0) goto L40
                goto L9c
            L8d:
                r13 = move-exception
                goto L96
            L8f:
                r13 = move-exception
                r13.printStackTrace()     // Catch: java.lang.Throwable -> L8d
                if (r2 == 0) goto La1
                goto L9e
            L96:
                if (r2 == 0) goto L9b
                r2.close()
            L9b:
                throw r13
            L9c:
                if (r2 == 0) goto La1
            L9e:
                r2.close()
            La1:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.T9Search.LoadTask.getProfileNumbers(long):java.util.List");
        }

        private void loadProfileForT9() {
            T9Search.access$2602(this.this$0, null);
            ArrayList<ContactItem> r0 = new ArrayList();
            Cursor r1 = T9Search.access$1900(this.this$0).getContentResolver().query(ContactsContract.Profile.CONTENT_URI, ContactQuery.getProjection(T9Search.access$2300(this.this$0), T9Search.access$2400(this.this$0)), ContactQuery.CONTACT_SELECTION, null, ContactQuery.CONTACT_SORT);
            if (r1 != null) goto L33;
        L29:
            if (r1 == null) goto L37;
            r1.close();
            return;
        L37:
            return;
        L33:
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            if (r1 == null) goto L24;
        L23:
            r1.close();
        L24:
            addAllToContacts(r0);
            return;
        L5:
            if (r1.moveToFirst() == false) goto L29;
            if (DSUtils.useDSFeature() == false) goto L15;
            int r2 = 0;
        L10:
            parseContact(r1, r0);     // Catch: Throwable -> L18 Exception -> L20
            r2 = r2 + 1;     // Catch: Throwable -> L18 Exception -> L20
            if (r1.moveToNext() == false) goto L16;
            if (r2 < 2) goto L10;
        L16:
            if (r1 == null) goto L24;
        L15:
            parseContact(r1, r0);     // Catch: Throwable -> L18 Exception -> L20
        L18:
            th = move-exception;
            if (r1 == null) goto L28;
            r1.close();
        L28:
            throw th;
        }

        private void parseContact(Cursor r13, ArrayList<ContactItem> r14) {
            long r1 = r13.getLong(0);
            List<PhoneNumberHolder> r3 = getProfileNumbers(r1);
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).resume();
            if (r3 == null) goto L45;
            Iterator<PhoneNumberHolder> r4 = r3.iterator();
        L6:
            if (r4.hasNext() == false) goto L45;
            PhoneNumberHolder r5 = r4.next();
            if (r1 != r5.contactID) goto L6;
            ContactItem r6 = new ContactItem();
            r6.id = r5.contactID;
            r6.dataId = r5.dataID;
            r6.name = r13.getString(1);
            r6.hasname = !TextUtils.isEmpty(r6.name);
            r6.name = ContactsUtils.getContactName(T9Search.access$1900(this.this$0), r6.name);
            r6.number = PhoneNumberUtils.formatNumber(r5.number);
            r6.normalNumber = T9Search.removeNonDigits(r5.number);
            r6.timesContacted = r13.getInt(2);
            r6.normalName = T9Search.nameToNumber(r6.name);
            r6.lookupkey = r13.getString(5);
            r6.sortkey = r13.getString(4);
            Uri r7 = ContactsContract.Contacts.getLookupUri(r6.id, r6.lookupkey);
            r6.lookupUri = r7;
            T9Search.access$2602(this.this$0, r7);
            if (r6.timesContacted <= 0) goto L23;
            r6.timesContacted = 0;
            int r8 = this.calllogs.size() - 1;
        L13:
            if (r8 < 0) goto L23;
            ContactItem r9 = this.calllogs.get(r8);
            if (r9.lookupUri.equals(r7) == false) goto L22;
            if (PhoneNumberUtils.compare(r9.number, r6.number) == false) goto L22;
            if (r6.timesContacted != 0) goto L21;
            r6.lastConnectTime = r9.lastConnectTime;
        L21:
            r6.timesContacted++;
            this.calllogs.remove(r8);
        L22:
            r8 = r8 - 1;
        L23:
            r6.section = ContactsUtils.getContactSection(r6.sortkey);
            r6.isSuperPrimary = r5.superPrimary;
            r6.groupType = ContactTypeLabelUtils.getPhoneTypeLabel(T9Search.access$1900(this.this$0), Integer.valueOf(r5.type), r5.label);
            if (r13.isNull(3) == true) goto L27;
            r6.photoUri = Uri.parse(r13.getString(3));
        L27:
            if (r6.hasname == true) goto L28;
            int r10 = 0;
        L38:
            if (r10 >= r6.pinyinNameList.size()) goto L43;
            if (r6.pinyinNameList.get(r10) == null) goto L43;
            r6.remainingLengthListInit.add(r10, Integer.valueOf(r6.pinyinNameList.get(r10).length()));
            r10 = r10 + 1;
        L43:
            if (r14 == null) goto L6;
            T9Search.access$2000(this.this$0).add(getNumberKey(r6.number));
            r14.add(r6);
            goto L6
        L28:
            int r11 = 0;
        L30:
            if (r11 >= r6.name.length()) goto L35;
            if (T9SearchLocaleUtils.isChinese(r6.name.charAt(r11)) == true) goto L33;
            r11 = r11 + 1;
            goto L30
        L33:
            r6.language = Locale.CHINA.getLanguage();
        L35:
            r6.positionLength.clear();
            setNameList(r6, r14, T9Search.access$2000(this.this$0));
        L45:
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).pause();
        }

        void loadChangedContact(Uri r20, long r21) {
            Cursor r3 = T9Search.access$1900(this.this$0).getContentResolver().query(r20, ContactQuery.getProjection(T9Search.access$2300(this.this$0), T9Search.access$2400(this.this$0)), ContactQuery.CONTACT_SELECTION, null, ContactQuery.CONTACT_SORT);
            Cursor r4 = T9Search.access$1900(this.this$0).getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"date", BlockedCallAdapter.KEY_LOOKUP_URI, "number"}, "lookup_uri = ?", new String[]{Uri.parse(r20.toString()).buildUpon().clearQuery().build().toString()}, "date DESC ");
            if (r4 != null) goto L77;
        L16:
            if (r4 == null) goto L18;
            r4.close();
        L18:
            Iterator r5 = T9Search.access$800(this.this$0).iterator();
        L20:
            if (r5.hasNext() == false) goto L24;
            ContactItem r7 = (ContactItem) r5.next();
            if (r7.id != r21) goto L20;
            this.contactsToRemove.add(r7);
            goto L20
        L24:
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).resume();
            if (r3 != null) goto L27;
        L73:
            if (r3 == null) goto L75;
            r3.close();
        L75:
            T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).pause();
            return;
        L27:
            if (r3.moveToFirst() == false) goto L73;
            Cursor r6 = T9Search.access$1900(this.this$0).getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PhoneQuery.getProjection(T9Search.access$2400(this.this$0)), "contact_id = " + String.valueOf(r21), null, T9Search.PHONE_SORT);
            if (r6 != null) goto L31;
        L71:
            if (r6 == null) goto L73;
            r6.close();
            goto L73
        L31:
            if (r6.moveToFirst() == false) goto L71;
            ArrayList r8 = new ArrayList();
        L33:
            String r9 = r6.getString(0);
            if (ContactsUtils.isExistInList(r8, r9) == true) goto L70;
            ContactItem r10 = new ContactItem();
            r10.id = r21;
            r10.dataId = r6.getLong(6);
            r10.name = r3.getString(1);
            r10.hasname = !TextUtils.isEmpty(r10.name);
            r10.name = ContactsUtils.getContactName(T9Search.access$1900(this.this$0), r10.name);
            r10.number = PhoneNumberUtils.formatNumber(r9);
            r10.normalNumber = T9Search.removeNonDigits(r9);
            r10.normalName = T9Search.nameToNumber(r10.name);
            r10.lookupkey = r3.getString(5);
            r10.sortkey = r3.getString(4);
            r10.lookupUri = ContactsContract.Contacts.getLookupUri(r21, r10.lookupkey);
            r10.timesContacted = 0;
            Iterator<ContactItem> r11 = this.calllogs.iterator();
        L37:
            if (r11.hasNext() == false) goto L44;
            ContactItem r12 = r11.next();
            if (PhoneNumberUtils.compare(r12.number, r10.number) == false) goto L37;
            if (r10.timesContacted != 0) goto L43;
            r10.lastConnectTime = r12.lastConnectTime;
        L43:
            r10.timesContacted++;
            r11.remove();
            goto L37
        L44:
            r10.section = ContactsUtils.getContactSection(r10.sortkey);
            if (r6.getInt(2) <= 0) goto L47;
            boolean r13 = true;
        L48:
            r10.isSuperPrimary = r13;
            r10.groupType = ContactTypeLabelUtils.getPhoneTypeLabel(T9Search.access$1900(this.this$0), Integer.valueOf(r6.getInt(3)), r6.getString(4));
            if (r3.isNull(3) == true) goto L52;
            r10.photoUri = Uri.parse(r3.getString(3));
        L52:
            if (r10.hasname == false) goto L61;
            int r14 = 0;
        L55:
            if (r14 >= r10.name.length()) goto L60;
            if (T9SearchLocaleUtils.isChinese(r10.name.charAt(r14)) == true) goto L58;
            r14 = r14 + 1;
            goto L55
        L58:
            r10.language = Locale.CHINA.getLanguage();
        L60:
            r10.positionLength.clear();
            setNameList(r10, this.contactsToAdd, T9Search.access$2000(this.this$0));
            goto L70
        L61:
            int r15 = 0;
        L63:
            if (r15 >= r10.pinyinNameList.size()) goto L68;
            if (r10.pinyinNameList.get(r15) == null) goto L68;
            r10.remainingLengthListInit.add(r15, Integer.valueOf(r10.pinyinNameList.get(r15).length()));
            r15 = r15 + 1;
        L68:
            this.contactsToAdd.add(r10);
            goto L70
        L47:
            r13 = false;
        L70:
            if (r6.moveToNext() == true) goto L33;
        L77:
        L12:
            th = move-exception;
            if (r4 == null) goto L15;
            r4.close();
        L15:
            throw th;
        L5:
            if (r4.moveToFirst() == false) goto L16;
        L6:
            if (r4.getString(1) == null) goto L10;
            ContactItem r16 = new ContactItem();     // Catch: Throwable -> L12
            r16.lookupUri = Uri.parse(r4.getString(1));     // Catch: Throwable -> L12
            r16.lastConnectTime = r4.getLong(0);     // Catch: Throwable -> L12
            r16.number = r4.getString(2);     // Catch: Throwable -> L12
            this.calllogs.add(r16);     // Catch: Throwable -> L12
        L10:
            if (r4.moveToNext() == true) goto L6;
            goto L16
        }

        void loadChangedProfile(Uri r3, long r4) {
            Iterator r5 = T9Search.access$800(this.this$0).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            ContactItem r6 = (ContactItem) r5.next();
            if (ContactsContract.isProfileId(r6.id) == false) goto L4;
            this.contactsToRemove.add(r6);
            goto L4
        L8:
            loadProfileForT9();
        }

        private void setJapaneseNameList(ContactItem r12, ArrayList<ContactItem> r13, HashSet<String> r14) {
            if (r13 != null) goto L4;
            return;
        L4:
            String[] r0 = r12.name.split(HanziToPinyin.Token.SEPARATOR);
            String[] r2 = r12.sortkey.split(HanziToPinyin.Token.SEPARATOR);
            if (r0 == null) goto L29;
            if (r2 == null) goto L30;
            r12.language = Locale.JAPAN.getLanguage();
            int r3 = Math.min(r0.length, r2.length);
            int r5 = 0;
            int r6 = 0;
        L9:
            if (r5 >= r3) goto L23;
            String r7 = r0[r5];
            if (r7 != null) goto L13;
        L18:
            r12.pinyinNameList.add(r6, T9Search.nameToNumber(r2[r5]));
            r12.positionLength.add(r6, Integer.valueOf(r0[r5].length()));
            r12.remainingLengthListInit.add(r6, Integer.valueOf(r0[r5].length()));
            r6 = r6 + 1;
        L20:
            if (r5 == (r0.length - 1)) goto L22;
            r12.pinyinNameList.add(r6, HanziToPinyin.Token.SEPARATOR);
            r12.positionLength.add(r6, 1);
            r12.remainingLengthListInit.add(r6, 1);
            r6 = r6 + 1;
        L22:
            r5 = r5 + 1;
            goto L9
        L13:
            if (r7.equals(r2[r5]) == false) goto L18;
            int r8 = 0;
        L16:
            if (r8 >= r0[r5].length()) goto L20;
            r12.pinyinNameList.add(r6, T9Search.nameToNumber(String.valueOf(r2[r5].charAt(r8))));
            r12.positionLength.add(r6, 1);
            r12.remainingLengthListInit.add(r6, 1);
            r6 = r6 + 1;
            r8 = r8 + 1;
            goto L16
        L23:
            r14.add(getNumberKey(r12.number));
            r13.add(r12);
            return;
        L30:
            return;
        }

        private void setNameList(ContactItem r19, ArrayList<ContactItem> r20, HashSet<String> r21) {
            if (r20 != null) goto L5;
            return;
        L5:
            int r11 = 0;
            if (Locale.JAPAN.getLanguage().equals(Locale.getDefault().getLanguage()) == true) goto L8;
        L15:
            int r0 = 0;
            boolean r1 = false;
            int r12 = 0;
        L17:
            if (r12 >= r19.name.length()) goto L95;
            boolean r13 = true;
            if (T9Search.access$2700(this.this$0, String.valueOf(r19.name.charAt(r12))) == true) goto L24;
            if (r12 == 0) goto L22;
            r0 = r0 + 1;
        L22:
            r19.pinyinNameList.add(r0, String.valueOf(r19.name.charAt(r12)));
            r19.sortname += String.valueOf(r19.name.charAt(r12));
            r19.positionLength.add(r0, 1);
            r1 = true;
        L94:
            r12 = r12 + 1;
            goto L17
        L24:
            if (T9SearchLocaleUtils.isChinese(r19.name.charAt(r12)) == false) goto L52;
            if (r12 == 0) goto L27;
            r0 = r0 + 1;
        L27:
            int r14 = r0;
            String[] r15 = T9Search.access$2800(this.this$0, r19.name.charAt(r12), r19.sortkey);
            if (r15 != null) goto L29;
            String r2 = T9Search.access$2900(this.this$0, r19.name.charAt(r12), r19.sortkey);
            r19.pinyinNameList.add(r14, T9Search.nameToNumber(r2));
            r19.sortname += r2;
            r19.positionLength.add(r14, 1);
            r1 = true;
        L50:
            r0 = r14;
            goto L94
        L29:
            r19.isMutilPinyinName = true;
            ContactItem r7 = new ContactItem();
            copyContactItem(r19, r7);
            int r3 = 0;
        L31:
            if (r3 >= r19.pinyinNameList.size()) goto L33;
            r7.pinyinNameList.add(r19.pinyinNameList.get(r3));
            r3 = r3 + 1;
            goto L31
        L33:
            int r4 = 0;
        L35:
            if (r4 >= r19.positionLength.size()) goto L37;
            r7.positionLength.add(r19.positionLength.get(r4));
            r4 = r4 + 1;
            goto L35
        L37:
            int r6 = 0;
        L39:
            if (r6 >= r15.length) goto L96;
            String r5 = r15[r6];
            ContactItem r8 = new ContactItem();
            copyContactItem(r7, r8);
            int r9 = 0;
        L42:
            if (r9 >= r7.pinyinNameList.size()) goto L44;
            r8.pinyinNameList.add(r7.pinyinNameList.get(r9));
            r9 = r9 + 1;
            goto L42
        L44:
            r8.pinyinNameList.add(r14, T9Search.nameToNumber(r5));
            r8.sortname += r5;
            int r10 = 0;
        L46:
            if (r10 >= r7.positionLength.size()) goto L48;
            r8.positionLength.add(r7.positionLength.get(r10));
            r10 = r10 + 1;
            goto L46
        L48:
            r8.positionLength.add(r14, 1);
            setNameMuiltPingyinList(1, r12 + 1, r14, true, r8, r20, r21);
            r6 = r6 + 1;
            r7 = r7;
        L96:
            if (r13 == false) goto L98;
            return;
        L98:
            if (r11 >= r19.pinyinNameList.size()) goto L103;
            if (r19.pinyinNameList.get(r11) == null) goto L103;
            r19.remainingLengthListInit.add(r11, Integer.valueOf(r19.pinyinNameList.get(r11).length()));
            r11 = r11 + 1;
        L103:
            r21.add(getNumberKey(r19.number));
            r20.add(r19);
            return;
        L52:
            if (T9SearchLocaleUtils.isKorean(r19.name.charAt(r12)) == true) goto L54;
        L83:
            if (r1 == false) goto L86;
            r0 = r0 + 1;
            r1 = false;
        L86:
            if (r19.pinyinNameList.size() > r0) goto L88;
            r19.pinyinNameList.add(r0, T9Search.nameToNumber(String.valueOf(r19.name.charAt(r12))));
        L90:
            if (r19.positionLength.size() > r0) goto L92;
            r19.positionLength.add(r0, 1);
        L93:
            r19.sortname += String.valueOf(r19.name.charAt(r12));
            goto L94
        L92:
            r19.positionLength.set(r0, Integer.valueOf(r19.positionLength.get(r0).intValue() + 1));
            goto L93
        L88:
            r19.pinyinNameList.set(r0, r19.pinyinNameList.get(r0) + T9Search.nameToNumber(String.valueOf(r19.name.charAt(r12))));
            goto L90
        L54:
            if (T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).isEnabled() == false) goto L83;
            if (r12 == 0) goto L57;
            r0 = r0 + 1;
        L57:
            r14 = r0;
            List<String> r16 = T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).splitKoreanLetter(r19.name.charAt(r12));
            if (r16 == null) goto L95;
            if (r16.size() > 1) goto L62;
            r19.pinyinNameList.add(r14, T9Search.nameToNumber(r16.get(0)));
            r19.sortname += r16;
            r19.positionLength.add(r14, 1);
            goto L50
        L62:
            r19.isMutilPinyinName = true;
            ContactItem r17 = new ContactItem();
            copyContactItem(r19, r17);
            int r18 = 0;
        L64:
            if (r18 >= r19.pinyinNameList.size()) goto L66;
            r17.pinyinNameList.add(r19.pinyinNameList.get(r18));
            r18 = r18 + 1;
            goto L64
        L66:
            int r22 = 0;
        L68:
            if (r22 >= r19.positionLength.size()) goto L70;
            r17.positionLength.add(r19.positionLength.get(r22));
            r22 = r22 + 1;
            goto L68
        L70:
            Iterator<String> r110 = r16.iterator();
        L72:
            if (r110.hasNext() == false) goto L96;
            String r23 = r110.next();
            ContactItem r24 = new ContactItem();
            copyContactItem(r17, r24);
            int r25 = 0;
        L75:
            if (r25 >= r17.pinyinNameList.size()) goto L77;
            r24.pinyinNameList.add(r17.pinyinNameList.get(r25));
            r25 = r25 + 1;
            goto L75
        L77:
            r24.pinyinNameList.add(r14, T9Search.nameToNumber(r23));
            r24.sortname += r23;
            int r26 = 0;
        L79:
            if (r26 >= r17.positionLength.size()) goto L81;
            r24.positionLength.add(r17.positionLength.get(r26));
            r26 = r26 + 1;
            goto L79
        L81:
            r24.positionLength.add(r14, 1);
            setNameMuiltPingyinList(1, r12 + 1, r14, true, r24, r20, r21);
        L95:
            r13 = false;
            goto L96
        L8:
            if (T9SearchLocaleUtils.isChineseOrJapaneseName(r19.name) == false) goto L15;
            if (TextUtils.isEmpty(r19.sortkey) == true) goto L15;
            if (T9SearchLocaleUtils.isJapanesePhonetic(r19.sortkey.charAt(0)) == false) goto L15;
            setJapaneseNameList(r19, r20, r21);
        }

        private void copyContactItem(ContactItem r3, ContactItem r4) {
            r4.dataId = r3.dataId;
            r4.groupType = r3.groupType;
            r4.id = r3.id;
            r4.language = r3.language;
            r4.photoUri = r3.photoUri;
            r4.number = r3.number;
            r4.normalNumber = r3.normalNumber;
            r4.normalName = r3.normalName;
            r4.lookupkey = r3.lookupkey;
            r4.sortname = r3.sortname;
            r4.lookupUri = r3.lookupUri;
            r4.position = r3.position;
            r4.timesContacted = r3.timesContacted;
            r4.lastConnectTime = r3.lastConnectTime;
            r4.nameMatchId = r3.nameMatchId;
            r4.numberMatchId = r3.numberMatchId;
            r4.nameRate = r3.nameRate;
            r4.name = r3.name;
            r4.sortKeyPrimary = r3.sortKeyPrimary;
            r4.isMutilPinyinName = r3.isMutilPinyinName;
            r4.sortkey = r3.sortkey;
            r4.phoneBookLabel = r3.phoneBookLabel;
            r4.hasname = r3.hasname;
            r4.section = r3.section;
        }

        private void setNameMuiltPingyinList(int r19, int r20, int r21, boolean r22, ContactItem r23, ArrayList<ContactItem> r24, HashSet<String> r25) {
            int r10 = r20;
            int r0 = r21;
            boolean r1 = r22;
        L3:
            int r11 = 0;
            if (r10 >= r23.name.length()) goto L83;
            boolean r12 = true;
            if (T9Search.access$2700(this.this$0, String.valueOf(r23.name.charAt(r10))) == true) goto L11;
            if (r10 == 0) goto L9;
            r0 = r0 + 1;
        L9:
            r23.pinyinNameList.add(r0, String.valueOf(r23.name.charAt(r10)));
            r23.sortname += String.valueOf(r23.name.charAt(r10));
            r23.positionLength.add(r0, 1);
            r1 = true;
        L82:
            r10 = r10 + 1;
            goto L3
        L11:
            if (T9SearchLocaleUtils.isChinese(r23.name.charAt(r10)) == false) goto L40;
            if (r10 == 0) goto L14;
            r0 = r0 + 1;
        L14:
            int r13 = r0;
            String[] r14 = T9Search.access$2800(this.this$0, r23.name.charAt(r10), r23.sortkey);
            int r2 = r19;
            if (r2 >= 2) goto L37;
            if (r14 == null) goto L37;
            r23.isMutilPinyinName = true;
            ContactItem r15 = new ContactItem();
            copyContactItem(r23, r15);
            int r3 = 0;
        L19:
            if (r3 >= r23.pinyinNameList.size()) goto L21;
            r15.pinyinNameList.add(r23.pinyinNameList.get(r3));
            r3 = r3 + 1;
            goto L19
        L21:
            int r4 = 0;
        L23:
            if (r4 >= r23.positionLength.size()) goto L25;
            r15.positionLength.add(r23.positionLength.get(r4));
            r4 = r4 + 1;
            goto L23
        L25:
            int r7 = 0;
        L27:
            if (r7 >= r14.length) goto L84;
            String r5 = r14[r7];
            ContactItem r6 = new ContactItem();
            copyContactItem(r15, r6);
            int r8 = 0;
        L30:
            if (r8 >= r15.pinyinNameList.size()) goto L32;
            r6.pinyinNameList.add(r15.pinyinNameList.get(r8));
            r8 = r8 + 1;
            goto L30
        L32:
            r6.pinyinNameList.add(r13, T9Search.nameToNumber(r5));
            r6.sortname += r5;
            int r9 = 0;
        L34:
            if (r9 >= r15.positionLength.size()) goto L36;
            r6.positionLength.add(r15.positionLength.get(r9));
            r9 = r9 + 1;
            goto L34
        L36:
            r6.positionLength.add(r13, 1);
            int r16 = r2 + 1;
            setNameMuiltPingyinList(r16, r10 + 1, r13, true, r6, r24, r25);
            r7 = r7 + 1;
            r2 = r16;
        L84:
            if (r12 == false) goto L86;
            return;
        L86:
            if (r11 >= r23.pinyinNameList.size()) goto L91;
            if (r23.pinyinNameList.get(r11) == null) goto L91;
            r23.remainingLengthListInit.add(r11, Integer.valueOf(r23.pinyinNameList.get(r11).length()));
            r11 = r11 + 1;
        L91:
            r25.add(getNumberKey(r23.number));
            r24.add(r23);
            return;
        L37:
            String r17 = T9Search.access$2900(this.this$0, r23.name.charAt(r10), r23.sortkey);
            r23.pinyinNameList.add(r13, T9Search.nameToNumber(r17));
            r23.sortname += r17;
            r23.positionLength.add(r13, 1);
            r1 = true;
        L38:
            r0 = r13;
            goto L82
        L40:
            if (T9SearchLocaleUtils.isKorean(r23.name.charAt(r10)) == true) goto L42;
        L71:
            if (r1 == false) goto L74;
            r0 = r0 + 1;
            r1 = false;
        L74:
            if (r23.pinyinNameList.size() > r0) goto L76;
            r23.pinyinNameList.add(r0, T9Search.nameToNumber(String.valueOf(r23.name.charAt(r10))));
        L78:
            if (r23.positionLength.size() > r0) goto L80;
            r23.positionLength.add(r0, 1);
        L81:
            r23.sortname += String.valueOf(r23.name.charAt(r10));
            goto L82
        L80:
            r23.positionLength.set(r0, Integer.valueOf(r23.positionLength.get(r0).intValue() + 1));
            goto L81
        L76:
            r23.pinyinNameList.set(r0, r23.pinyinNameList.get(r0) + T9Search.nameToNumber(String.valueOf(r23.name.charAt(r10))));
            goto L78
        L42:
            if (T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).isEnabled() == false) goto L71;
            if (r10 == 0) goto L45;
            r0 = r0 + 1;
        L45:
            r13 = r0;
            List<String> r18 = T9SearchHelper.getInstance(T9Search.access$1900(this.this$0)).splitKoreanLetter(r23.name.charAt(r10));
            if (r18 == null) goto L83;
            if (r18.size() > 1) goto L50;
            r23.pinyinNameList.add(r13, T9Search.nameToNumber(r18.get(0)));
            r23.sortname += r18;
            r23.positionLength.add(r13, 1);
            goto L38
        L50:
            r23.isMutilPinyinName = true;
            ContactItem r110 = new ContactItem();
            copyContactItem(r23, r110);
            int r26 = 0;
        L52:
            if (r26 >= r23.pinyinNameList.size()) goto L54;
            r110.pinyinNameList.add(r23.pinyinNameList.get(r26));
            r26 = r26 + 1;
            goto L52
        L54:
            int r27 = 0;
        L56:
            if (r27 >= r23.positionLength.size()) goto L58;
            r110.positionLength.add(r23.positionLength.get(r27));
            r27 = r27 + 1;
            goto L56
        L58:
            Iterator<String> r111 = r18.iterator();
        L60:
            if (r111.hasNext() == false) goto L84;
            String r28 = r111.next();
            ContactItem r29 = new ContactItem();
            copyContactItem(r110, r29);
            int r30 = 0;
        L63:
            if (r30 >= r110.pinyinNameList.size()) goto L65;
            r29.pinyinNameList.add(r110.pinyinNameList.get(r30));
            r30 = r30 + 1;
            goto L63
        L65:
            r29.pinyinNameList.add(r13, T9Search.nameToNumber(r28));
            r29.sortname += r28;
            int r31 = 0;
        L67:
            if (r31 >= r110.positionLength.size()) goto L69;
            r29.positionLength.add(r110.positionLength.get(r31));
            r31 = r31 + 1;
            goto L67
        L69:
            r29.positionLength.add(r13, 1);
            setNameMuiltPingyinList(1, r10 + 1, r13, true, r29, r24, r25);
        L83:
            r12 = false;
            goto L84
        }
    }

    private class NewNameSortComparator implements Comparator<ContactItem> {
        NameSortComparator mNameSortComparator;
        final /* synthetic */ T9Search this$0;

        private NewNameSortComparator(T9Search r1) {
            this.this$0 = r1;
            this.mNameSortComparator = new NameSortComparator();
        }

        /* synthetic */ NewNameSortComparator(T9Search r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ContactItem r1, ContactItem r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ContactItem r5, ContactItem r6) {
            if (r6.nameRate != r5.nameRate) goto L5;
            int r0 = Integer.compare(r6.timesContacted, r5.timesContacted);
            if (r0 != 0) goto L11;
            r0 = Long.compare(r6.lastConnectTime, r5.lastConnectTime);
        L11:
            if (r0 != 0) goto L13;
            int r4 = this.mNameSortComparator.compare2(r5, r6);
        L14:
            if (r4 == 0) goto L16;
            return r4;
        L16:
            return Long.compare(r5.id, r6.id);
        L13:
            r4 = r0;
            goto L14
        L5:
            if (r6.nameRate <= r5.nameRate) goto L7;
            r4 = 1;
            goto L14
        L7:
            r4 = -1;
            goto L14
        }
    }

    private class NumberComparator implements Comparator<ContactItem> {
        NameSortComparator mNameSortComparator;
        final /* synthetic */ T9Search this$0;

        private NumberComparator(T9Search r1) {
            this.this$0 = r1;
            this.mNameSortComparator = new NameSortComparator();
        }

        /* synthetic */ NumberComparator(T9Search r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ContactItem r1, ContactItem r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ContactItem r5, ContactItem r6) {
            if (r5.lookupUri != null) goto L8;
            if (r6.lookupUri != null) goto L8;
        L15:
            int r0 = Integer.compare(r6.timesContacted, r5.timesContacted);
            if (r0 != 0) goto L18;
            r0 = Long.compare(r6.lastConnectTime, r5.lastConnectTime);
        L18:
            if (r0 != 0) goto L20;
            r0 = this.mNameSortComparator.compare2(r5, r6);
        L20:
            if (r0 == 0) goto L22;
            return r0;
        L22:
            return Long.compare(r5.id, r6.id);
        L8:
            if (r5.lookupUri != null) goto L12;
            return 1;
        L12:
            if (r6.lookupUri != null) goto L15;
            return -1;
        }
    }

    private static final class PhoneNumberHolder {
        long contactID;
        long dataID;
        String label;
        String number;
        boolean superPrimary;
        int type;

        private PhoneNumberHolder() {
        }

        /* synthetic */ PhoneNumberHolder(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class PhoneQuery {
        public static final int PHONE_COLUMN_CONTACT_ID_INDEX = 1;
        public static final int PHONE_COLUMN_ID_INDEX = 6;
        public static final int PHONE_COLUMN_IS_SUPER_PRIMARY_INDEX = 2;
        public static final int PHONE_COLUMN_LABEL_INDEX = 4;
        public static final int PHONE_COLUMN_NUMBER_INDEX = 0;
        public static final int PHONE_COLUMN_SORT_KEY_PRIMARY_INDEX = 5;
        public static final int PHONE_COLUMN_TYPE_INDEX = 3;
        private static final String[] PHONE_PROJECTION = null;

        private PhoneQuery() {
        }

        static {
            PHONE_PROJECTION = new String[]{"data1", "contact_id", "is_super_primary", DBHelper.COL_DATA2, DBHelper.COL_DATA3, PickerFragment.CONTACT_SORT_CNAME, "_id"};
        }

        public static final String[] getProjection(int r2) {
            if (r2 != 2) goto L5;
            PHONE_PROJECTION[5] = "sort_key_alt";
        L7:
            return PHONE_PROJECTION;
        L5:
            PHONE_PROJECTION[5] = PickerFragment.CONTACT_SORT_CNAME;
            goto L7
        }
    }

    public class T9Adapter extends BaseAdapter implements HorizontalScrollListView.ScrollStateListener {
        private static final int CONTACT_NOT_SAVED = 1;
        private static final int CONTACT_SAVED = 0;
        private ContactsCommonListItem closingSwipeItem;
        private BlackListQueryHandler mBlHandler;
        private Bitmap mBlacklistAvatar;
        private BlacklistManager mBlacklistManager;
        private final CallLogListItemHelper mCallLogViewsHelper;
        private Context mContext;
        private boolean mCountLimit;
        private AdapterView.OnItemClickListener mItemClickedListener;
        private HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
        private ArrayList<ContactItem> mItems;
        private LayoutInflater mLayoutInflater;
        private int mListScrollState;
        private ListView mListView;
        private NumberInfosManager mNumberInfosManager;
        private PhoneNumberHelper mPhoneNumberHelper;
        private ContactPhotoManager mPhotoLoader;
        private QuickContactListener mT9List;
        private ContactsCommonListItem swipeItem;
        final /* synthetic */ T9Search this$0;

        /* JADX INFO: renamed from: com.android.contacts.dialpad.T9Search$T9Adapter$5, reason: invalid class name */
        class AnonymousClass5 implements Function2<List<? extends SwipeItemButtonType>, Function1<? super SwipeItemButtonType, Unit>, Unit> {
            final /* synthetic */ T9Adapter this$1;
            final /* synthetic */ CallLogItemCardView val$callLogItemCardView;

            AnonymousClass5(T9Adapter r1, CallLogItemCardView r2) {
                this.this$1 = r1;
                this.val$callLogItemCardView = r2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SwipeItemButtonType> r1, Function1<? super SwipeItemButtonType, Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public Unit invoke2(List<? extends SwipeItemButtonType> r3, final Function1<? super SwipeItemButtonType, Unit> r4) {
                this.val$callLogItemCardView.setSwipeItemButtonView(r3, new T9Search$T9Adapter$5$$ExternalSyntheticLambda0(this, r4));
                return null;
            }

            /* JADX INFO: renamed from: lambda$invoke$0$com-android-contacts-dialpad-T9Search$T9Adapter$5, reason: not valid java name */
            /* synthetic */ Unit m186xaf61425b(Function1 r1, SwipeItemButtonType r2) {
                r1.invoke(r2);
                T9Adapter.access$3300(this.this$1);
                return null;
            }
        }

        /* JADX INFO: renamed from: com.android.contacts.dialpad.T9Search$T9Adapter$7, reason: invalid class name */
        class AnonymousClass7 extends NumberInfosManager.NumberInfosListenerAdatper {
            final /* synthetic */ T9Adapter this$1;
            final /* synthetic */ List val$holders;

            AnonymousClass7(T9Adapter r1, List r2) {
                this.this$1 = r1;
                this.val$holders = r2;
            }

            @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListenerAdatper, com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
            public void onQueryNumberInfosDone(final NumberInfosManager.NumberInfos r3) {
                if (r3 != null) goto L4;
                return;
            L4:
                this.val$holders.forEach(new T9Search$T9Adapter$7$$ExternalSyntheticLambda0(this, r3));
            }

            /* JADX INFO: renamed from: lambda$onQueryNumberInfosDone$0$com-android-contacts-dialpad-T9Search$T9Adapter$7, reason: not valid java name */
            /* synthetic */ void m187x9a37875a(NumberInfosManager.NumberInfos r3, ViewHolder r4) {
                if (r4.phone.equals(r3.getNumber()) == true) goto L6;
                return;
            L6:
                if (TextUtils.equals(r4.contact.label, r3.getLabel()) == true) goto L9;
                ContactsUtils.updateCalllogLabel(T9Adapter.access$3400(this.this$1), r4.phone, r4.contact.countryIso, r3.getLabel());
                return;
            }
        }

        class ViewHolder {
            ImageView arrow;
            View bgItem;
            ImageView blacklistView;
            CallTypeIconsView call_type;
            ContactItem contact;
            PhoneCallDetails details;
            QuickContactHelper helper;
            AvatarImageView icon;
            CallLogItemCardView listItem;
            TextView location;
            String lookupKey;
            TextView name;
            TextView number;
            String phone;
            QuickContactChildLayout quickContactLayout;
            ImageView simIcon;
            final /* synthetic */ T9Adapter this$1;

            ViewHolder(T9Adapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
        public void onScrollCompleted(View r1) {
        }

        @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
        public void onScrollRestored(View r1) {
        }

        @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
        public void onScrolling(int r1, View r2) {
        }

        static /* synthetic */ void access$3300(T9Adapter r0) {
            r0.hideSwipedViews();
        }

        static /* synthetic */ Context access$3400(T9Adapter r0) {
            return r0.mContext;
        }

        static /* synthetic */ AdapterView.OnItemClickListener access$3600(T9Adapter r0) {
            return r0.mItemClickedListener;
        }

        static /* synthetic */ HorizontalScrollListView.ItemLongClickedListener access$3700(T9Adapter r0) {
            return r0.mItemLongClickedListener;
        }

        static /* synthetic */ QuickContactListener access$3800(T9Adapter r0) {
            return r0.mT9List;
        }

        static /* synthetic */ ContactsCommonListItem access$3900(T9Adapter r0) {
            return r0.closingSwipeItem;
        }

        static /* synthetic */ ContactsCommonListItem access$3902(T9Adapter r0, ContactsCommonListItem r1) {
            r0.closingSwipeItem = r1;
            return r1;
        }

        static /* synthetic */ ContactsCommonListItem access$4000(T9Adapter r0) {
            return r0.swipeItem;
        }

        static /* synthetic */ ContactsCommonListItem access$4002(T9Adapter r0, ContactsCommonListItem r1) {
            r0.swipeItem = r1;
            return r1;
        }

        static /* synthetic */ void access$4300(T9Adapter r0, ContactItem r1) {
            r0.removeCallLog(r1);
        }

        static /* synthetic */ void access$4400(T9Adapter r0) {
            r0.initBlHandlerIfNeed();
        }

        static /* synthetic */ BlackListQueryHandler access$4500(T9Adapter r0) {
            return r0.mBlHandler;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        private void hideSwipedViews() {
            ContactsCommonListItem r0 = this.swipeItem;
            if (r0 == null) goto L6;
            this.closingSwipeItem = r0;
            r0.swipeClose();
            this.closingSwipeItem.setEnableSwipe(false);
            this.swipeItem = null;
            return;
        }

        public T9Adapter(T9Search r7, Context r8, ArrayList<ContactItem> r9) {
            this.this$0 = r7;
            this.mCountLimit = true;
            this.swipeItem = null;
            this.closingSwipeItem = null;
            this.mContext = r8;
            this.mItems = r9;
            this.mLayoutInflater = LayoutInflater.from(r8);
            this.mPhotoLoader = ContactPhotoManager.getInstance(this.mContext);
            this.mBlacklistManager = BlacklistManager.getInstances(this.mContext);
            Resources r10 = this.mContext.getResources();
            CallTypeHelper r2 = new CallTypeHelper(r10);
            this.mPhoneNumberHelper = new PhoneNumberHelper(r10);
            this.mCallLogViewsHelper = new CallLogListItemHelper(new PhoneCallDetailsHelper(r10, r2, this.mPhoneNumberHelper, this.mContext, false), this.mPhoneNumberHelper, r10);
            this.mNumberInfosManager = NumberInfosManager.getInstance();
        }

        private Uri getContactUri(Long r1, String r2) {
            return ContactsContract.Contacts.getLookupUri(r1.longValue(), r2);
        }

        public void setQuickContactListener(QuickContactListener r1) {
            this.mT9List = r1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            QuickContactListener r0 = this.mT9List;
            if (r0 == null) goto L5;
            r0.hideQuickContactWithoutAnimation(false);
        L5:
            hideSwipedViews();
            super.notifyDataSetChanged();
            if ((this.mT9List instanceof HorizontalScrollListView) == false) goto L9;
            ContactDetailCacheManager.getInstance().refreshCache((HorizontalScrollListView) this.mT9List);
            return;
        }

        @Override // android.widget.Adapter
        public ContactItem getItem(int r1) {
            return this.mItems.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return getItem(r1).dataId;
        }

        public void setCountLimit(boolean r3) {
            T9Search.access$600("setCountLimit " + r3);
            if (this.mCountLimit == r3) goto L8;
            this.mCountLimit = r3;
            if (r3 == true) goto L9;
            notifyDataSetChanged();
            return;
        L9:
            return;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<ContactItem> r0 = this.mItems;
            if (r0 == null) goto L5;
            int r1 = r0.size();
        L7:
            if (this.mCountLimit == true) goto L9;
            return r1;
        L9:
            return Math.min(T9Search.access$3200(this.this$0), r1);
        L5:
            r1 = 0;
            goto L7
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            if (getItem(r1).lookupUri != null) goto L6;
            return 1;
        L6:
            return 0;
        }

        public void setItems(ArrayList<ContactItem> r1) {
            this.mItems = r1;
            notifyDataSetChanged();
        }

        private void checkIfHeldSameContact(ViewHolder r4, ContactItem r5) {
            Object r0 = this.mT9List;
            if ((r0 instanceof HorizontalScrollListView) == true) goto L5;
            return;
        L5:
            if (((HorizontalScrollListView) r0).isStateIdle() == true) goto L22;
            if (r4 == null) goto L23;
            if (r5 != null) goto L9;
            return;
        L9:
            if (r4.lookupKey == null) goto L14;
            if (r4.lookupKey.equals(r5.lookupkey) == true) goto L14;
            ((HorizontalScrollListView) this.mT9List).restoreScrollState(false);
        L14:
            if (TextUtils.isEmpty(r4.lookupKey) == true) goto L16;
            return;
        L16:
            if (TextUtils.isEmpty(r5.lookupkey) == true) goto L18;
            return;
        L18:
            if (r4.phone.equals(r5.number) == true) goto L27;
            ((HorizontalScrollListView) this.mT9List).restoreScrollState(false);
            return;
        L27:
            return;
        L23:
            return;
        }

        private void onButtonPhoneClick(String r4, int r5, boolean r6) {
            Agent.getInstance().onClick("DialpadFragment", Constants.ContactsTracker.EVENT_CALL_SEARCH_RESULT_CALL_LOG_ICON);
            IntentProvider r7 = IntentProvider.getReturnCallIntentProvider(r4, !r6);
            if (r7 == null) goto L8;
            Intent r8 = r7.getIntent(this.mContext);
            if ((-1) == r5) goto L7;
            DSUtils.putSlotIdToIntent(this.mContext, r8, r5);
        L7:
            this.mContext.startActivity(r8);
            CallScreenShowUtils.INSTANCE.start(new CallScreenShowEvent());
        L8:
            Object r3 = this.mT9List;
            if ((r3 instanceof HorizontalScrollListView) == false) goto L12;
            ((HorizontalScrollListView) r3).restoreScrollState(true);
            return;
        }

        @Override // android.widget.Adapter
        public View getView(final int r34, View r35, ViewGroup r36) {
            final ContactItem r8 = this.mItems.get(r34);
            if (r35 != null) goto L5;
            View r9 = new CallLogItemCardView(this.mContext, null);
        L6:
            final CallLogItemCardView r10 = (CallLogItemCardView) r9;
            r10.setShowAvatarContainer(true);
            r10.hideIntelligentStatusView(true);
            r10.showSingleContactCalls(false, false);
            if (getItemViewType(r34) == 0) goto L9;
            boolean r0 = true;
        L10:
            r10.showCustomEnd(r0);
            if (r8.name == null) goto L13;
            String r13 = ContactsUtils.formatNumberForT9(r8.normalNumber);
            if (getItemViewType(r34) != 0) goto L25;
            TextView r1 = r10.getDefaultTitleText();
            if (r1 == null) goto L21;
            r1.setText(r8.name, TextView.BufferType.SPANNABLE);
        L21:
            TextView r2 = r10.getCallLabelText();
            if (r2 == null) goto L24;
            r2.setText(ContactsUtils.getContactPhoneDescribe(this.mContext, 0, r8.groupType, r13), TextView.BufferType.SPANNABLE);
        L24:
            final Uri r3 = getContactUri(Long.valueOf(r8.id), r8.lookupkey);
            r10.getTailIconView().setOnClickListener(new AnonymousClass1(this, r10, r8, r3));
        L37:
            updateTextSpan(r13, r10, r34, r8);
            if (r8.lookupUri == null) goto L46;
            AvatarImageView r14 = r10.getAvatarPhoto();
            if (r14 != null) goto L42;
        L45:
            this.mBlacklistManager.loadBlacklist(r10.getBlacklistPhoto(), r8.number);
        L52:
            r10.setOnClickListener(new AnonymousClass3(this, r34, r8));
            r10.setEnableSwipe(true);
            if (getItemViewType(r34) == 0) goto L55;
            ArrayList r4 = new ArrayList();
            r4.add(SwipeItemButtonType.SWIPE_MESSAGE);
            r4.add(SwipeItemButtonType.SWIPE_DELETE);
            r10.setSwipeItemButtonView(r4, new AnonymousClass4(this, r8));
        L56:
            r10.addSwipeListener(new AnonymousClass6(this, r10));
            return r9;
        L55:
            ArrayList r15 = new ArrayList();
            r15.add(SwipeItemButtonType.SWIPE_PHONE);
            r15.add(SwipeItemButtonType.SWIPE_PHONE1);
            r15.add(SwipeItemButtonType.SWIPE_PHONE2);
            r15.add(SwipeItemButtonType.SWIPE_MESSAGE);
            r15.add(SwipeItemButtonType.SWIPE_STAR);
            new ContactsSwipeHelper().init(this.mContext, false, r8.lookupUri.toString(), r15, null, new AnonymousClass5(this, r10));
            goto L56
        L42:
            if (r8.photoUri != null) goto L44;
            r14.setPhotoID(0);
            r14.setStrokeEnabled(false);
            this.mPhotoLoader.loadPhoto(r14, 0, false, true);
            goto L45
        L44:
            r14.setPhotoID(1);
            r14.setStrokeEnabled(true);
            this.mPhotoLoader.loadPhoto(r14, r8.photoUri, false, true);
            goto L45
        L46:
            r10.setAvatarPhotoId(0L);
            AvatarImageView r5 = r10.getAvatarPhoto();
            if (r5 == null) goto L50;
            r5.setStrokeEnabled(false);
        L50:
            if (this.mCountLimit == true) goto L52;
            loadStrangerIcon(r10.getBlacklistPhoto(), r8.number, r5);
            goto L52
        L25:
            r10.setPhoneCallDetails(new PhoneCallDetails(r8.number, null, null, r8.geoLocation, new int[]{r8.callType}, r8.date, 0, r8.name, -1, "", null, null, -1, 1, ""), r8.callType);
            TextView r6 = r10.getDefaultTitleText();
            if (r6 == null) goto L28;
            r6.setText(ContactsUtils.formatNumberForT9(r8.normalNumber), TextView.BufferType.SPANNABLE);
        L28:
            TextView r7 = r10.getCallLabelText();
            String r11 = r8.label;
            NumberInfosManager r12 = this.mNumberInfosManager;
            if (r12 == null) goto L33;
            NumberInfosManager.NumberInfos r16 = r12.getCachedBaseAndMarkInfos(r8.number);
            if (r16 == null) goto L33;
            CharSequence r17 = T9Search.access$3500(r16, r11);
            boolean r18 = false;
        L34:
            if (r7 == null) goto L36;
            r7.setText(r17);
            r7.setVisibility(0);
        L36:
            r10.getTailIconView().setOnClickListener(new AnonymousClass2(this, r10, r8));
            r10.setPhoneSimStatus(r8.simId, true);
            queryNumberInfos(r8, r7, r8.countryIso, r11, r18);
        L33:
            r17 = r11;
            r18 = true;
            goto L34
        L13:
            if (getItemViewType(r34) != 0) goto L15;
            r10.setTitleText(this.mContext.getResources().getString(R.string.missing_name));
        L15:
            r10.showSubtitleContainer(false);
            goto L52
        L9:
            r0 = false;
            goto L10
        L5:
            r9 = r35;
            goto L6
        }

        private void updateTextSpan(String r18, CallLogItemCardView r19, int r20, ContactItem r21) {
            if (getItemViewType(r20) != 0) goto L34;
            Spannable r4 = (Spannable) r19.getDefaultTitleText().getText();
            String r8 = r21.name;
            int r9 = r21.positionLength.size();
            ArrayList<Integer> r10 = r21.remainingLengthList;
            if (r21.remainingLengthListInit.size() >= r9) goto L8;
            r9 = r21.remainingLengthListInit.size();
        L8:
            if (r10.size() >= r9) goto L10;
            r9 = r10.size();
        L10:
            int r11 = 0;
            int r12 = 0;
        L11:
            if (r11 >= r9) goto L32;
            if (r11 <= 0) goto L15;
            r12 = r12 + r21.positionLength.get(r11 - 1).intValue();
        L15:
            if ((r21.remainingLengthListInit.get(r11).intValue() - r10.get(r11).intValue()) <= 0) goto L31;
            int r14 = 50;
            if (r21.positionLength.get(r11).intValue() != 1) goto L23;
            int r13 = r12 + 1;
            if (r13 > 50) goto L31;
            if (r13 > r8.length()) goto L31;
            r4.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oui_functional_blue_6)), r12, r13, 18);
            goto L31
        L23:
            if (r12 >= 50) goto L31;
            if (((r21.remainingLengthListInit.get(r11).intValue() + r12) - r10.get(r11).intValue()) > r8.length()) goto L31;
            ForegroundColorSpan r15 = new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oui_functional_blue_6));
            if (((r21.remainingLengthListInit.get(r11).intValue() + r12) - r10.get(r11).intValue()) > 50) goto L30;
            r14 = (r21.remainingLengthListInit.get(r11).intValue() + r12) - r10.get(r11).intValue();
        L30:
            r4.setSpan(r15, r12, r14, 18);
        L31:
            r11 = r11 + 1;
            goto L11
        L32:
            r19.getDefaultTitleText().setText(r4);
        L34:
            if (r21.numberMatchId == (-1)) goto L115;
            Spannable r5 = (Spannable) r19.getDefaultTitleText().getText();
            if (getItemViewType(r20) != 0) goto L38;
            r5 = (Spannable) r19.getCallLabelText().getText();
        L38:
            int r3 = r21.numberMatchId;
            int r16 = 0;
            int r17 = 0;
            int r110 = 0;
        L39:
            int r111 = r3 + r17;
            if (r16 > r111) goto L56;
            if (r18 == null) goto L55;
            if (r18.length() <= r16) goto L55;
            if (r18.charAt(r16) != ' ') goto L47;
        L52:
            r110 = r110 + 1;
            if (r111 >= r18.length()) goto L55;
            r17 = r17 + 1;
            goto L55
        L47:
            if (r18.charAt(r16) == '-') goto L52;
            if (r18.charAt(r16) == '(') goto L52;
            if (r18.charAt(r16) == ')') goto L52;
        L55:
            r16 = r16 + 1;
            goto L39
        L56:
            int r7 = 0;
        L57:
            int r22 = r3 + r17;
            if (r111 >= (T9Search.access$4100(this.this$0).length() + r22)) goto L75;
            if (r111 < 0) goto L74;
            if (r18 == null) goto L74;
            if (r18.length() <= r111) goto L74;
            if (r18.charAt(r111) != ' ') goto L66;
        L71:
            r7 = r7 + 1;
            if ((r22 + T9Search.access$4100(this.this$0).length()) >= r18.length()) goto L74;
            r17 = r17 + 1;
            goto L74
        L66:
            if (r18.charAt(r111) == '-') goto L71;
            if (r18.charAt(r111) == '(') goto L71;
            if (r18.charAt(r111) == ')') goto L71;
        L74:
            r111 = r111 + 1;
            goto L57
        L75:
            int r6 = ((T9Search.access$4100(this.this$0).length() + r3) + r7) + r110;
            if (r18 != null) goto L78;
        L80:
            int r23 = r3 + r110;
            if (r23 < 0) goto L90;
            if (r23 > r6) goto L90;
            if (r6 <= r5.length()) goto L86;
            r6 = r5.length();
        L86:
            int r1 = Math.min(r6, r5.length());
            if (r23 >= r1) goto L90;
            r5.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oui_functional_blue_6)), r23, r1, 18);
        L90:
            if (getItemViewType(r20) == 0) goto L92;
            r19.getDefaultTitleText().setText(r5);
            return;
        L92:
            r19.getCallLabelText().setText(r5);
            return;
        L78:
            if (r6 <= r18.length()) goto L80;
            r6 = r18.length();
            goto L80
        }

        public void setLongClick(HorizontalScrollListView.ItemLongClickedListener r1) {
            this.mItemLongClickedListener = r1;
        }

        public void setItemClick(AdapterView.OnItemClickListener r1) {
            this.mItemClickedListener = r1;
        }

        public void setListView(ListView r1) {
            this.mListView = r1;
        }

        public void setListViewScrollState(int r2) {
            int r0 = this.mListScrollState;
            if (r0 == r2) goto L6;
            this.mListScrollState = r2;
            onListViewScrollStateChanged(r0, r2);
            return;
        }

        private void onListViewScrollStateChanged(int r3, int r4) {
            ListView r0 = this.mListView;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3 != 2) goto L10;
            if (r4 != 0) goto L11;
            updateStrangerInfosAndIcons(r0);
            return;
        L11:
            return;
        }

        public void updateStrangerInfosAndIcons(ListView r6) {
            int r0 = r6.getChildCount();
            ArrayList r1 = new ArrayList();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L14;
            View r3 = r6.getChildAt(r2);
            if (r3 == null) goto L12;
            ViewHolder r4 = (ViewHolder) r3.getTag();
            if (r4 == null) goto L12;
            if (r4.contact == null) goto L12;
            r1.add(r4);
        L12:
            r2 = r2 + 1;
            goto L3
        L14:
            if (r1.isEmpty() == true) goto L22;
            queryBatchNumberInfos(r1);
            loadBatchStranerIcons(r1);
            return;
        }

        private void loadBatchStranerIcons(List<ViewHolder> r4) {
            Iterator<ViewHolder> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ViewHolder r0 = r5.next();
            loadStrangerIcon(r0.blacklistView, r0.phone, r0.icon);
            goto L4
        }

        private void loadStrangerIcon(ImageView r3, String r4, AvatarImageView r5) {
            if (this.mListScrollState == 2) goto L12;
            this.mBlacklistManager.loadBlacklist(r3, r4);
            if (r3.getVisibility() == 0) goto L7;
            Bitmap r2 = null;
        L11:
            NumberInfosManager.getInstance().bindPublicNumberLogoAsync(r4, r5, r2);
            return;
        L7:
            if (this.mBlacklistAvatar != null) goto L9;
            this.mBlacklistAvatar = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.photo_blacklist_in_detail);
        L9:
            r2 = this.mBlacklistAvatar;
            goto L11
        L12:
            NumberInfosManager.NumberInfos r0 = NumberInfosManager.getInstance().getCachedLogoInfos(r4);
            if (r0 == null) goto L23;
            this.mBlacklistManager.loadBlacklist(r3, r4);
            if (r0.getLogo() != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            r5.setStrokeEnabled(r6);
            r5.setAvatarBitmap(r0.getLogo());
            return;
        L17:
            if (r0.isClassifyLogo() == true) goto L19;
            r6 = true;
            goto L20
        }

        private void queryBatchNumberInfos(List<ViewHolder> r4) {
            AnonymousClass7 r0 = new AnonymousClass7(this, r4);
            final ArrayList r1 = new ArrayList();
            r4.forEach(new T9Search$T9Adapter$$ExternalSyntheticLambda0(r1));
            this.mNumberInfosManager.getBaseAndMarkInfosAsync(r1, r0);
        }

        static /* synthetic */ void lambda$queryBatchNumberInfos$0(List r0, ViewHolder r1) {
            r0.add(r1.phone);
        }

        private void queryNumberInfos(final ContactItem r11, final TextView r12, final String r13, final String r14, boolean r15) {
            if (r11 == null) goto L4;
            String r16 = r11.number;
        L6:
            if (this.mListScrollState != 2) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r16) == true) goto L16;
            final String r2 = NumberInfosManagerImpl.normalizeNumberForQuery(r16);
            if (r12 == null) goto L13;
            r12.setTag(R.id.tag_logo_number, r2);
        L13:
            final String r4 = r16;
            this.mNumberInfosManager.getBaseAndMarkInfosAsync(r16, new AnonymousClass8(this, r2, r14, r4, r13, r11, r12));
            return;
        L16:
            return;
        L4:
            r16 = null;
            goto L6
        }

        private void setBackgroundItemButtonsOnClickListener(final QuickContactHelper r2) {
            r2.setBackgroundButtonOnClickListener(R.id.umb_star, new AnonymousClass9(this, r2));
        }

        private View bindBackgroundItemButtons(View r4) {
            View r0 = r4.findViewById(R.id.item_background);
            if (r0 != null) goto L9;
            ViewStub r1 = (ViewStub) r4.findViewById(R.id.item_background_stub);
            if (r1 != null) goto L7;
            return null;
        L7:
            r0 = r1.inflate();
        L9:
            if (r4.findViewWithTag(ContractKt.PARAM_ACTION_DOMAIN_CALLLOG) == r0) goto L12;
            return null;
        L12:
            if (r4.getTag() != null) goto L14;
        L18:
            return null;
        L14:
            if ((r4.getTag() instanceof ViewHolder) == false) goto L18;
            ViewHolder r5 = (ViewHolder) r4.getTag();
            final ContactItem r2 = r5.contact;
            PhoneCallDetails r6 = r5.details;
            ((OButton) r0.findViewById(R.id.umb_message)).setOnClickListener(new AnonymousClass10(this, r2));
            ((OButton) r0.findViewById(R.id.umb_delete)).setOnClickListener(new AnonymousClass11(this, r2));
            return r0;
        }

        public void doRemoveCallLog(final ContactItem r3) {
            Object r0 = this.mT9List;
            if (r0 == null) goto L5;
            ((HorizontalScrollListView) r0).playDeleteItemAnimation(new AnonymousClass12(this, r3));
            return;
        L5:
            removeCallLog(r3);
            Object r2 = this.mT9List;
            if ((r2 instanceof HorizontalScrollListView) == false) goto L10;
            ((HorizontalScrollListView) r2).restoreScrollState(true);
            return;
        }

        private void removeCallLog(ContactItem r7) {
            this.mContext.getContentResolver().delete(CallLog.Calls.CONTENT_URI, "number = ?", new String[]{String.valueOf(r7.number)});
            this.mItems.remove(r7);
            Object r0 = T9Search.access$2100(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (T9Search.access$2200(this.this$0) == null) goto L7;
            T9Search.access$2200(this.this$0).remove(r7);     // Catch: Throwable -> L10
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L10
            notifyDataSetChanged();
        }

        @Override // com.android.contacts.list.HorizontalScrollListView.ScrollStateListener
        public void onScrollStateChanged(View r1, int r2, int r3) {
            if (r2 == 0) goto L4;
            return;
        L4:
            if (bindBackgroundItemButtons(r1) == null) goto L6;
            return;
        L6:
            if ((r1 instanceof WrapperView) == false) goto L8;
            r1 = ((ViewGroup) r1).getChildAt(0);
        L8:
            if (r1 != null) goto L10;
            return;
        L10:
            Object r0 = r1.getTag();
            if ((r0 instanceof ViewHolder) == false) goto L18;
            ViewHolder r4 = (ViewHolder) r0;
            if (r4.helper == null) goto L19;
            r4.helper.beforeHorizontalScrollOpen();
            r1.findViewById(R.id.item_background);
            return;
        L19:
            return;
        }

        private void initBlHandlerIfNeed() {
            if (this.mBlHandler != null) goto L6;
            this.mBlHandler = new BlackListQueryHandler(this.mContext);
            return;
        }

        public void numberIntoBlackList(ContactItem r4) {
            if (this.mBlacklistManager.isInBlackList(this.mContext.getContentResolver(), r4.number) == true) goto L5;
            addNumberToBlackList(r4);
            return;
        L5:
            removeNumberFromBlackList(r4.number);
            T9Search.access$4200(this.this$0).postDelayed(new AnonymousClass13(this), 100);
        }

        public void removeNumberFromBlackList(String r2) {
            initBlHandlerIfNeed();
            this.mBlHandler.doRemoveBlacklistAction(r2);
            Object r1 = this.mT9List;
            if ((r1 instanceof HorizontalScrollListView) == false) goto L5;
            ((HorizontalScrollListView) r1).restoreScrollState(true);
        L5:
            ContactsApplication.showToast(R.string.toast_remove_blacklist_done, 0);
        }

        public void addNumberToBlackList(ContactItem r22) {
            initBlHandlerIfNeed();
            addNumberToBlackList(new PhoneCallDetails(r22.number, null, null, r22.geoLocation, new int[]{r22.callType}, r22.date, 0, r22.name, -1, "", null, null, -1, 1, ""));
        }

        public void addNumberToBlackList(final PhoneCallDetails r3) {
            if (TextUtils.isEmpty(r3.number.toString().trim()) == false) goto L8;
            Toast.makeText(this.mContext, R.string.toast_no_support_blacklist, 0).show();
            Object r2 = this.mT9List;
            if ((r2 instanceof HorizontalScrollListView) == false) goto L10;
            ((HorizontalScrollListView) r2).restoreScrollState(true);
            return;
        L10:
            return;
        L8:
            OAlertDialogUtils.showDefaultBlacklistConfirmationDialog(this.mContext, new AnonymousClass14(this, r3));
        }
    }

    public class T9SearchResult {
        private final ArrayList<ContactItem> mResults;
        final /* synthetic */ T9Search this$0;

        public T9SearchResult(T9Search r1, ArrayList<ContactItem> r2) {
            this.this$0 = r1;
            this.mResults = r2;
        }

        public ArrayList<ContactItem> getResults() {
            return this.mResults;
        }
    }

    private boolean isDigit(char r1) {
        if (r1 < '0') goto L7;
        if (r1 > '9') goto L7;
        return true;
    L7:
        if (r1 != ',') goto L9;
        return true;
    L9:
        if (r1 != ';') goto L11;
        return true;
    L11:
        if (r1 != '+') goto L13;
        return true;
    L13:
        if (r1 != '*') goto L15;
        return true;
    L15:
        if (r1 == '#') goto L25;
        return false;
    L25:
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
    }

    static /* synthetic */ Listener access$000(T9Search r0) {
        return r0.mListener;
    }

    static /* synthetic */ void access$100(T9Search r0) {
        r0.triggerLoad();
    }

    static /* synthetic */ boolean access$1000(T9Search r0) {
        return r0.mCacheLoaded;
    }

    static /* synthetic */ boolean access$1002(T9Search r0, boolean r1) {
        r0.mCacheLoaded = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1100(T9Search r0, String r1) {
        return r0.loadContactsFromFile(r1);
    }

    static /* synthetic */ void access$1200(T9Search r0) {
        r0.notifyLoadFinished();
    }

    static /* synthetic */ boolean access$1300(T9Search r0) {
        return r0.mCancelLoad;
    }

    static /* synthetic */ boolean access$1302(T9Search r0, boolean r1) {
        r0.mCancelLoad = r1;
        return r1;
    }

    static /* synthetic */ Uri access$1400(T9Search r0) {
        return r0.mContactUri;
    }

    static /* synthetic */ Uri access$1402(T9Search r0, Uri r1) {
        r0.mContactUri = r1;
        return r1;
    }

    static /* synthetic */ long access$1500(T9Search r2) {
        return r2.mContactId;
    }

    static /* synthetic */ long access$1502(T9Search r0, long r1) {
        r0.mContactId = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1602(T9Search r0, boolean r1) {
        r0.mLoaded = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1700(T9Search r0) {
        return r0.mSqlOnChange;
    }

    static /* synthetic */ boolean access$1702(T9Search r0, boolean r1) {
        r0.mSqlOnChange = r1;
        return r1;
    }

    static /* synthetic */ String[] access$1800(T9Search r0) {
        return r0.CALLS_PROJECTION;
    }

    static /* synthetic */ Context access$1900(T9Search r0) {
        return r0.mContext;
    }

    static /* synthetic */ long access$200(T9Search r2) {
        return r2.mSyncTime;
    }

    static /* synthetic */ HashSet access$2000(T9Search r0) {
        return r0.mNumberKeys;
    }

    static /* synthetic */ HashSet access$2002(T9Search r0, HashSet r1) {
        r0.mNumberKeys = r1;
        return r1;
    }

    static /* synthetic */ long access$202(T9Search r0, long r1) {
        r0.mSyncTime = r1;
        return r1;
    }

    static /* synthetic */ Object access$2100(T9Search r0) {
        return r0.mCallLogCacheLock;
    }

    static /* synthetic */ ArrayList access$2200(T9Search r0) {
        return r0.mCallLogCache;
    }

    static /* synthetic */ int access$2300(T9Search r0) {
        return r0.mDisplayOrder;
    }

    static /* synthetic */ int access$2400(T9Search r0) {
        return r0.mSortOrder;
    }

    static /* synthetic */ Uri access$2600(T9Search r0) {
        return r0.mProfileLookupUri;
    }

    static /* synthetic */ Uri access$2602(T9Search r0, Uri r1) {
        r0.mProfileLookupUri = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2700(T9Search r0, String r1) {
        return r0.isNameCanToNumber(r1);
    }

    static /* synthetic */ String[] access$2800(T9Search r0, char r1, String r2) {
        return r0.getMultiTones(r1, r2);
    }

    static /* synthetic */ String access$2900(T9Search r0, char r1, String r2) {
        return r0.getPinyin(r1, r2);
    }

    static /* synthetic */ void access$300(T9Search r0) {
        r0.initT9Map();
    }

    static /* synthetic */ int access$3200(T9Search r0) {
        return r0.mItemViewCachethrottle;
    }

    static /* synthetic */ String access$3500(NumberInfosManager.NumberInfos r0, String r1) {
        return maybeTruncateCustomizeLabel(r0, r1);
    }

    static /* synthetic */ String access$4100(T9Search r0) {
        return r0.mPrevInput;
    }

    static /* synthetic */ Handler access$4200(T9Search r0) {
        return r0.mMainHandler;
    }

    static /* synthetic */ void access$600(String r0) {
        log(r0);
    }

    static /* synthetic */ ArrayList access$800(T9Search r0) {
        return r0.mContacts;
    }

    static /* synthetic */ ArrayList access$802(T9Search r0, ArrayList r1) {
        r0.mContacts = r1;
        return r1;
    }

    static /* synthetic */ void access$900(T9Search r0, ArrayList r1, String r2) {
        r0.saveContactsToFile(r1, r2);
    }

    private static String maybeTruncateCustomizeLabel(NumberInfosManager.NumberInfos r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r2 == null) goto L12;
        if (r2.getNumberMainMarkClassify() != 1073741824) goto L12;
        if (r3.length() <= 8) goto L12;
        return r3.substring(0, 8) + "...";
    L12:
        return r3;
    }

    static {
        PHONE_ID_SELECTION_ARGS = new String[]{"vnd.android.cursor.item/phone_v2"};
        sT9String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ012abcÃƒÂ ÃƒÂ¡ÃƒÂ¢ÃƒÂ¤ÃƒÂ¥Ã‰â€˜ÃƒÂ¦ÃƒÂ§Ã‡Â½Ã„â€¡Ã„Â\u008dÃƒÂ¡3defÃƒÂ©ÃƒÂ¨ÃƒÂªÃƒÂ«4ghiÃƒÂ\u00adÃƒÂ¬ÃƒÂ¯ÃƒÂ®Ã‡Âµ5jklÃ¡Â¸Â±Ã¡Â¸Â±Ã„Âº6mnoÃƒÂ²ÃƒÂ³ÃƒÂ¶ÃƒÂ´ÃƒÂ¸ÃƒÂ±Ã…â€¹Ã‡Â¿Ã¡Â¸Â¿Ã…â€žÃ…â€˜7pqrsÃƒÅ¸Ã‰Â¾Ã¡Â¹â€¢Ã…â€¢Ã…â€ºÃ…â„¢Ã…Â¡8tuvÃƒÂºÃƒÂ¹ÃƒÂ¼ÃƒÂ»Ã…Â±9wxyzÃƒÂ½Ã¡ÂºÆ’Ã…Âº";
        sT9Search = null;
    }

    public void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefsCallback = r1;
    }

    public void initPreferences() {
        this.mDisplayOrder = getDisplayOrder();
        this.mSortOrder = getSortOrder();
    }

    private int getDisplayOrder() {
        PreferencesCallback r0 = this.mPrefsCallback;
        if (r0 != null) goto L7;
        return new ContactsPreferences(this.mContext).getDisplayOrder();
    L7:
        return r0.getDisplayOrder();
    }

    private int getSortOrder() {
        PreferencesCallback r0 = this.mPrefsCallback;
        if (r0 != null) goto L7;
        return new ContactsPreferences(this.mContext).getSortOrder();
    L7:
        return r0.getSortOrder();
    }

    private T9Search(Context r10) {
        this.mProfileLookupUri = null;
        this.DEBUG = false;
        this.mHighLightColor = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{0}}, new int[]{-1, -1, Color.parseColor("#b95353")});
        this.CALLS_PROJECTION = new String[]{"date", BlockedCallAdapter.KEY_LOOKUP_URI, "number", "_id", "type", "geocoded_location", "numberlabel", "countryiso", CallLogQuery.COLUMN_SUBSCRIPTION, CallLogQuery.COLUMN_SHOW_SIM_ICON, "sim_id"};
        this.mAllResults = new LinkedHashSet();
        this.mTempAllResults = new LinkedHashSet();
        this.mContacts = new ArrayList();
        this.mCacheLoaded = false;
        this.mNumberKeys = new HashSet();
        this.mLocationInfoCache = new ConcurrentHashMap();
        this.mCancelLoad = false;
        this.mSqlOnChange = false;
        this.mContactUri = null;
        this.mContactId = -1;
        this.mSyncTime = -1;
        this.mLoaded = false;
        this.mForceQuery = false;
        this.mItemViewCachethrottle = 4;
        this.mCallLogCacheLock = new Object();
        this.mCallLogCache = new ArrayList();
        this.mHasRegisterContentObserver = false;
        this.mHasRegisterLocaleChanged = false;
        this.mContext = r10;
        this.mSortMode = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(r10).getString("t9_sort", "1"));
        initPreferences();
        initT9Map();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        initViewCache(r10);
    }

    private void initViewCache(Context r5) {
        double r0 = ((double) (ContactsUtils.getScreenHeight(r5) / ContactsUtils.dipTopx(r5, 60.0d))) / 2.5d;
        int r6 = this.mItemViewCachethrottle;
        if (r0 <= r6) goto L6;
        this.mItemViewCachethrottle = r6 * 2;
        return;
    }

    public static synchronized T9Search getInstance(Context r2) {
        monitor-enter(T9Search.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sT9Search != null) goto L7;
        sT9Search = new T9Search(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        T9Search r3 = sT9Search;     // Catch: Throwable -> L10
        monitor-exit(T9Search.class);
        return r3;
    }

    public void setCallback(Listener r1) {
        this.mListener = r1;
        if (this.mLoaded == false) goto L7;
        if (r1 == null) goto L8;
        r1.onLoadFinished();
        return;
    L8:
        return;
    }

    private synchronized void notifyLoadFinished() {
        monitor-enter(this);
        this.mForceQuery = true;     // Catch: Throwable -> L9
        Listener r0 = this.mListener;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.onLoadFinished();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setRegisterContentObserverChange(boolean r4) {
        if (this.mContactObserver != null) goto L6;
        final Handler r1 = new Handler();
        this.mContactObserver = new AnonymousClass1(this, r1);
    L6:
        if (this.mHasRegisterContentObserver != r4) goto L8;
        return;
    L8:
        this.mHasRegisterContentObserver = r4;
        if (r4 == false) goto L11;
        this.mContext.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.mContactObserver);
        this.mContext.getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, this.mContactObserver);
        this.mContext.getContentResolver().registerContentObserver(ContactsContract.Profile.CONTENT_URI, true, this.mContactObserver);
        return;
    L11:
        this.mContext.getContentResolver().unregisterContentObserver(this.mContactObserver);
    }

    public void setRegisterLocaleChange(boolean r2) {
        if (this.mBroadcastReceiver != null) goto L6;
        this.mBroadcastReceiver = new AnonymousClass2(this);
    L6:
        if (this.mHasRegisterLocaleChanged != r2) goto L8;
        return;
    L8:
        this.mHasRegisterLocaleChanged = r2;
        if (r2 == false) goto L11;
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.intent.action.LOCALE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r3);
        return;
    L11:
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
    }

    private void triggerLoad() {
        LoadTask r0 = this.mLoadTask;
        if (r0 != null) goto L5;
    L8:
        LoadTask r1 = new LoadTask(this, null);
        this.mLoadTask = r1;
        r1.execute(new Uri[0]);
        return;
    L5:
        if (r0.getStatus() == AsyncTask.Status.FINISHED) goto L8;
        this.mSqlOnChange = true;
    }

    private void triggerLoadSingle(Uri r3) throws InterruptedException {
        cancelLoad();
        LoadSingleContactTask r0 = this.mSingleLoadTask;
        if (r0 != null) goto L5;
    L6:
        LoadSingleContactTask r1 = new LoadSingleContactTask(this, null);
        this.mSingleLoadTask = r1;
        r1.execute(new Uri[]{r3});
        return;
    L5:
        if (r0.getStatus() == AsyncTask.Status.FINISHED) goto L6;
    }

    private void cancelLoad() {
        LoadTask r0 = this.mLoadTask;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getStatus() != AsyncTask.Status.RUNNING) goto L9;
        this.mCancelLoad = true;
        this.mLoadTask.cancel(true);
        this.mLoadTask = null;
        return;
    }

    public void refresh() throws InterruptedException {
        Uri r0 = this.mContactUri;
        if (r0 == null) goto L5;
        triggerLoadSingle(r0);
        return;
    L5:
        triggerLoad();
    }

    private void saveContactsToFile(ArrayList<ContactItem> r3, String r4) {
        log("saveContactsToFile: " + r3.size());
        ArrayList r0 = new ArrayList(r3);
        FileOutputStream r2 = this.mContext.openFileOutput(r4, 0);     // Catch: OutOfMemoryError -> L19 Exception -> L21
        Parcel r5 = Parcel.obtain();     // Catch: Throwable -> L12
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L8;
        ((ContactItem) r1.next()).writeToParcel(r5, 0);     // Catch: Throwable -> L12
        goto L6
    L8:
        byte[] r6 = r5.marshall();     // Catch: Throwable -> L12
        log("data length = " + r6.length);     // Catch: Throwable -> L12
        r2.write(r6);     // Catch: Throwable -> L12
        r5.recycle();     // Catch: Throwable -> L12
        if (r2 == null) goto L30;
        r2.close();     // Catch: OutOfMemoryError -> L19 Exception -> L21
        return;
    L30:
        return;
    L12:
        th = move-exception;
        if (r2 != null) goto L26;
    L18:
        throw th;     // Catch: OutOfMemoryError -> L19 Exception -> L21
    L26:
        r2.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: OutOfMemoryError -> L19 Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        log("data too large");
        e.printStackTrace();
    }

    private ArrayList<ContactItem> loadContactsFromFile(String r6) {
        ArrayList<ContactItem> r2 = new ArrayList();
        Parcel r3 = Parcel.obtain();
        FileInputStream r5 = this.mContext.openFileInput(r6);     // Catch: Throwable -> L11
        int r7 = r5.available();     // Catch: Throwable -> L11
        log("file size: " + r7);     // Catch: Throwable -> L11
        byte[] r8 = new byte[r7];     // Catch: Throwable -> L11
        int r1 = r5.read(r8);     // Catch: Throwable -> L11
        log("readed size: " + r1);     // Catch: Throwable -> L11
        r3.unmarshall(r8, 0, r1);     // Catch: Throwable -> L11
        r3.setDataPosition(0);     // Catch: Throwable -> L11
    L5:
        if (r3.dataAvail() <= 0) goto L9;
        ContactItem r9 = ContactItem.CREATOR.createFromParcel(r3);     // Catch: Throwable -> L11
        if (r9 == null) goto L9;
        r2.add(r9);     // Catch: Throwable -> L11
    L9:
        r5.close();     // Catch: Throwable -> L11
    L15:
        log("loadContactsFromFile: " + r2.size());
        r3.recycle();
        return r2;
    L11:
        th = move-exception;
        if (ContactsUtils.DEBUG == false) goto L15;
        th.printStackTrace();
        goto L15
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.dialpad.T9Search$3] */
    public void asyncPreloadContacts() {
        new AnonymousClass3(this).start();
    }

    private String[] getMultiTones(char r7, String r8) {
        String[] r0 = PinyinHelper.getPolyphony(r7);
        if (ContactsUtils.isFuzzyTonesEnabled() == true) goto L5;
        return r0;
    L5:
        HashSet r1 = new HashSet();
        if (r0 != null) goto L10;
        Set<String> r6 = FuzzyTonesHelper.getInstance(this.mContext).parseFuzzyTones(getPinyin(r7, r8));
        if (r6 == null) goto L17;
        r1.addAll(r6);
    L17:
        if (r1.size() != 0) goto L20;
        return null;
    L20:
        String[] r9 = (String[]) r1.toArray(new String[0]);
        if (ContactsUtils.DEBUG == false) goto L23;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getMultiTones for " + r7 + ": " + Arrays.toString(r9));
    L23:
        return r9;
    L10:
        int r10 = r0.length;
        int r3 = 0;
    L11:
        if (r3 >= r10) goto L17;
        Set<String> r4 = FuzzyTonesHelper.getInstance(this.mContext).parseFuzzyTones(r0[r3]);
        if (r4 == null) goto L15;
        r1.addAll(r4);
    L15:
        r3 = r3 + 1;
        goto L11
    }

    private String getPinyin(char r5, String r6) {
        if (r6 == null) goto L4;
        int r4 = r6.indexOf(r5);
        if (r4 == (-1)) goto L8;
        int r7 = r4 - 2;
        String r1 = "";
    L10:
        if (r7 < 0) goto L18;
        if (r6.charAt(r7) == ' ') goto L14;
        r1 = r6.charAt(r7) + r1;
        r7 = r7 - 1;
        goto L10
    L14:
        if (r1 == "") goto L16;
        return r1;
    L16:
        return ContactsUtils.getPinyinName(String.valueOf(r5));
    L18:
        if (r1 == "") goto L20;
        return r1;
    L20:
        return ContactsUtils.getPinyinName(String.valueOf(r5));
    L8:
        return ContactsUtils.getPinyinName(String.valueOf(r5));
    L4:
        return ContactsUtils.getPinyinName(String.valueOf(r5));
    }

    public synchronized T9SearchResult search(String r18) {
        monitor-enter(this);
    L57:
        th = move-exception;
        throw th;
    L5:
        AnonymousClass1 r9 = null;
        if (r18.length() != 0) goto L9;
        monitor-exit(this);
        return null;
    L9:
        ArrayList<ContactItem> r0 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList<ContactItem> r10 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList<Long> r11 = new ArrayList();     // Catch: Throwable -> L57
        ArrayList<ContactItem> r12 = new ArrayList();     // Catch: Throwable -> L57
        String r13 = removeNonDigits(r18);     // Catch: Throwable -> L57
        String r1 = this.mPrevInput;     // Catch: Throwable -> L57
        if (r1 != null) goto L12;
    L17:
        boolean r2 = true;
    L18:
        this.mForceQuery = false;     // Catch: Throwable -> L57
        if (r13.length() <= 0) goto L40;
        if (r2 == false) goto L36;
        Iterator<ContactItem> r15 = this.mContacts.iterator();     // Catch: Throwable -> L57
    L23:
        if (r15.hasNext() == false) goto L25;
        search(r15.next(), r13, r10, r11, r12, r0);     // Catch: Throwable -> L57
        goto L23
    L25:
        Object r16 = this.mCallLogCacheLock;     // Catch: Throwable -> L57
        monitor-enter(r16);     // Catch: Throwable -> L57
        Iterator<ContactItem> r17 = this.mCallLogCache.iterator();     // Catch: Throwable -> L33
    L29:
        if (r17.hasNext() == false) goto L31;
        search(r17.next(), r13, r10, r11, r12, r0);     // Catch: Throwable -> L33
        goto L29
    L31:
        monitor-exit(r16);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L36:
        Iterator<ContactItem> r19 = this.mTempAllResults.iterator();     // Catch: Throwable -> L57
    L38:
        if (r19.hasNext() == false) goto L40;
        search(r19.next(), r13, r10, r11, r12, r0);     // Catch: Throwable -> L57
    L40:
        r11.clear();     // Catch: Throwable -> L57
        this.mAllResults.clear();     // Catch: Throwable -> L57
        this.mTempAllResults.clear();     // Catch: Throwable -> L57
        this.mPrevInput = r13;     // Catch: Throwable -> L57
        Collections.sort(r12, new NumberComparator(this, r9));     // Catch: Throwable -> L57
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L57
        log("prepare sort search nameResult");     // Catch: Throwable -> L57
        Collections.sort(r0, new NewNameSortComparator(this, r9));     // Catch: Throwable -> L57
        log("complete sort search nameResult,spend time is " + (System.currentTimeMillis() - r3));     // Catch: Throwable -> L57
        if (r0.size() <= 0) goto L43;
    L47:
        this.mTempAllResults.addAll(r10);     // Catch: Throwable -> L57
        this.mTempAllResults.addAll(r12);     // Catch: Throwable -> L57
        int r4 = this.mSortMode;     // Catch: Throwable -> L57
        if (r4 != 1) goto L50;
        this.mAllResults.addAll(r0);     // Catch: Throwable -> L57
        this.mAllResults.addAll(r12);     // Catch: Throwable -> L57
    L54:
        T9SearchResult r5 = new T9SearchResult(this, new ArrayList(this.mAllResults));     // Catch: Throwable -> L57
        monitor-exit(this);
        return r5;
    L50:
        if (r4 != 2) goto L54;
        this.mAllResults.addAll(r12);     // Catch: Throwable -> L57
        this.mAllResults.addAll(r0);     // Catch: Throwable -> L57
        goto L54
    L43:
        if (r12.size() > 0) goto L47;
        monitor-exit(this);
        return null;
    L12:
        if (r13.indexOf(r1) < 0) goto L17;
        if (this.mForceQuery == true) goto L17;
        r2 = false;
        goto L18
    }

    private void search(ContactItem r18, String r19, ArrayList<ContactItem> r20, ArrayList<Long> r21, ArrayList<ContactItem> r22, ArrayList<ContactItem> r23) {
        r18.numberMatchId = -1;
        r18.nameMatchId = -1;
        r18.position = new Boolean[r18.pinyinNameList.size()];
        int r2 = 0;
    L4:
        if (r2 >= r18.position.length) goto L6;
        r18.position[r2] = false;
        r2 = r2 + 1;
        goto L4
    L6:
        r18.remainingLengthList = new ArrayList();
        r18.remainingLengthList = (ArrayList) r18.remainingLengthListInit.clone();
        int r9 = r18.normalNumber.indexOf(r19);
        if (r18.language != null) goto L9;
    L11:
        boolean r16 = false;
    L13:
        if (searchName(r19.charAt(0), r19.substring(1, r19.length()), 0, r18.pinyinNameList, r18.position, r18.remainingLengthList, r18.positionLength, true, r16) == false) goto L25;
        getNameRate(r18);
        r20.add(r18);
        if (r18.isMutilPinyinName == true) goto L17;
        T9Search r0 = this;
        int r1 = r9;
        r23.add(r18);
    L26:
        if (r1 != (-1)) goto L28;
        return;
    L28:
        if (r0.getItemInNumberResult(r18, r22) != null) goto L33;
        r18.numberMatchId = r1;
        r22.add(r18);
        return;
    L33:
        return;
    L17:
        if (r21.contains(Long.valueOf(r18.dataId)) == true) goto L25;
        r21.add(Long.valueOf(r18.dataId));
        r23.add(r18);
        if (r9 == (-1)) goto L25;
        r0 = this;
        r1 = r9;
        ContactItem r3 = r0.getItemInNumberResult(r18, r22);
        if (r3 == null) goto L23;
        r22.remove(r3);
    L23:
        r18.numberMatchId = r1;
        r22.add(r18);
    L25:
        r0 = this;
        r1 = r9;
        goto L26
    L9:
        if (r18.language.equals(Locale.JAPAN.getLanguage()) == false) goto L11;
        r16 = true;
        goto L13
    }

    private ContactItem getItemInNumberResult(ContactItem r5, ArrayList<ContactItem> r6) {
        if (r5.isMutilPinyinName == false) goto L12;
        Iterator<ContactItem> r4 = r6.iterator();
    L6:
        if (r4.hasNext() == false) goto L20;
        ContactItem r7 = r4.next();
        if (r7.id != r5.id) goto L6;
        if (r7.dataId != r5.dataId) goto L6;
        return r7;
    L20:
        return null;
    L12:
        return null;
    }

    public void getNameRate(ContactItem r9) {
        int r8 = 0;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0 >= r9.position.length) goto L9;
        int r3 = r9.positionLength.get(r0).intValue();
        if (r9.position[r0].booleanValue() == false) goto L8;
        r1 = r1 + r3;
    L8:
        r2 = r2 + r3;
        r0 = r0 + 1;
        goto L4
    L9:
        int r4 = Math.min(r1, r9.position.length);
        if (TextUtils.isEmpty(r9.name) == true) goto L26;
        if (r9.name.contains(HanziToPinyin.Token.SEPARATOR) == false) goto L26;
        int r5 = 0;
        int r6 = 0;
    L15:
        if (r5 >= r9.name.length()) goto L20;
        if (HanziToPinyin.Token.SEPARATOR.equals(r9.name.charAt(r5) + "") == false) goto L19;
        r6 = r6 + 1;
    L19:
        r5 = r5 + 1;
        goto L15
    L20:
        int r7 = r4 - r6;
        if (r7 < 0) goto L24;
        r8 = r7;
    L24:
        r4 = r8;
    L26:
        if (r2 != 0) goto L28;
        r9.nameRate = r4 / 10000.0f;
        return;
    L28:
        if (r2 <= 0) goto L38;
        r9.nameRate = (r1 / r2) + (r4 / 10000.0f);
        return;
    }

    public boolean searchName(char r19, String r20, int r21, ArrayList<String> r22, Boolean[] r23, ArrayList<Integer> r24, ArrayList<Integer> r25, boolean r26, boolean r27) {
        char r11 = r19;
        String r12 = r20;
        ArrayList<String> r13 = r22;
        int r8 = r21;
    L4:
        if (r8 >= r22.size()) goto L96;
        if (r13.get(r8) == null) goto L96;
        if (r13.get(r8).length() == 0) goto L96;
        if (r13.get(r8).length() != 1) goto L22;
        if (isDigit(r13.get(r8).charAt(0)) == true) goto L22;
        if (r26 == false) goto L16;
        int r10 = r8;
    L95:
        r8 = r10 + 1;
        goto L4
    L16:
        int r14 = r8;
        if (searchName(r19, r20, r21 + 1, r22, r23, r24, r25, r26, r27) == false) goto L20;
        r23[r14] = true;
        return true;
    L20:
        return false;
    L22:
        if (r11 == r13.get(r8).charAt(0)) goto L24;
        boolean r17 = false;
        r10 = r8;
    L93:
        if (r26 == true) goto L95;
        return r17;
    L24:
        if (r20.length() == 0) goto L25;
        if ((r13.get(r8).length() - 1) >= r20.length()) goto L33;
        r10 = r8;
        if ((r13.get(r10).length() - 1) < r20.length()) goto L61;
    L91:
        r17 = false;
        goto L93
    L61:
        if (r20.length() <= 1) goto L69;
        boolean r16 = true;
        if (searchName(r12.charAt(0), r12.substring(1, r20.length()), r10 + 1, r22, r23, r24, r25, false, r27) == true) goto L64;
    L79:
        r17 = false;
        r11 = r19;
        if ((r11 + r12).indexOf(r13.get(r10)) != 0) goto L93;
        if (r13.get(r10).length() != r20.length()) goto L88;
        if (searchName(r12.charAt(r13.get(r10).length() - 1), "", r10 + 1, r22, r23, r24, r25, false, r27) == false) goto L93;
        r24.set(r10, 0);
        r23[r10] = Boolean.valueOf(r16);
        return r16;
    L88:
        if (searchName(r12.charAt(r13.get(r10).length() - 1), r12.substring(r13.get(r10).length(), r20.length()), r10 + 1, r22, r23, r24, r25, false, r27) == false) goto L93;
        r24.set(r10, 0);
        r23[r10] = Boolean.valueOf(r16);
        return r16;
    L64:
        if (r27 == false) goto L66;
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - r25.get(r10).intValue()));
    L67:
        r23[r10] = true;
        return true;
    L66:
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - 1));
        goto L67
    L69:
        r16 = true;
        if (searchName(r12.charAt(0), "", r10 + 1, r22, r23, r24, r25, false, r27) == false) goto L79;
        if (isDigit(r13.get(r10).charAt(0)) == false) goto L76;
        if (r27 == false) goto L75;
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - r25.get(r10).intValue()));
    L77:
        r23[r10] = true;
        return true;
    L75:
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - 1));
        goto L77
    L76:
        r24.set(r10, 0);
        goto L77
    L33:
        if (r20.length() <= 1) goto L42;
        r10 = r8;
        ArrayList r15 = r25;
        if (searchName(r12.charAt(0), r12.substring(1, r20.length()), r8 + 1, r22, r23, r24, r25, false, r27) == true) goto L36;
        boolean r18 = true;
    L49:
        boolean r9 = r18;
        r12 = r20;
        String r0 = r11 + r12;
        r13 = r22;
        if (r13.get(r10).indexOf(r0) != 0) goto L91;
        if (r27 == true) goto L53;
    L55:
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - r0.length()));
    L56:
        r23[r10] = Boolean.valueOf(r9);
        return r9;
    L53:
        if ((r24.get(r10).intValue() - r0.length()) >= 0) goto L55;
        r24.set(r10, 0);
        goto L56
    L36:
        if (r27 == false) goto L38;
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - ((Integer) r15.get(r10)).intValue()));
        boolean r28 = true;
    L39:
        r23[r10] = Boolean.valueOf(r28);
        return r28;
    L38:
        r28 = true;
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - 1));
        goto L39
    L42:
        r10 = r8;
        r15 = r25;
        r18 = true;
        if (searchName(r12.charAt(0), "", r10 + 1, r22, r23, r24, r25, false, r27) == false) goto L49;
        if (r27 == false) goto L46;
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - ((Integer) r15.get(r10)).intValue()));
    L47:
        r23[r10] = true;
        return true;
    L46:
        r24.set(r10, Integer.valueOf(r24.get(r10).intValue() - 1));
        goto L47
    L25:
        if (r27 == false) goto L27;
        r24.set(r8, Integer.valueOf(r24.get(r8).intValue() - r25.get(r8).intValue()));
    L28:
        r23[r8] = true;
        return true;
    L27:
        r24.set(r8, Integer.valueOf(r24.get(r8).intValue() - 1));
    L96:
        int r7 = 0;
    L98:
        if (r7 >= r23.length) goto L103;
        if (r23[r7].booleanValue() == false) goto L103;
        r23[r7] = false;
        r7 = r7 + 1;
    L103:
        return false;
    }

    private void initT9Map() {
        String[] r11 = this.mContext.getResources().getStringArray(R.array.t9_map);
        char[][] r0 = new char[r11.length][];
        int r1 = r11.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L8;
        String r5 = r11[r3];
        r0[r4] = new char[r5.length()];
        char[] r6 = r5.toCharArray();
        int r7 = r6.length;
        int r8 = 0;
        int r9 = 0;
    L5:
        if (r8 >= r7) goto L7;
        r0[r4][r9] = r6[r8];
        r9 = r9 + 1;
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L3
    L8:
        sT9Map = r0;
    }

    public static String nameToNumber(String r13) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r13.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L19;
        char r4 = Character.toLowerCase(r13.charAt(r3));
        char[][] r5 = sT9Map;
        int r6 = r5.length;
        int r7 = 0;
        boolean r8 = false;
    L5:
        if (r7 >= r6) goto L15;
        char[] r9 = r5[r7];
        int r10 = r9.length;
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L12;
        if (r4 == r9[r11]) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        r0.append(r9[0]);
        r8 = true;
    L12:
        if (r8 == true) goto L15;
        r7 = r7 + 1;
    L15:
        if (r8 == true) goto L17;
        r0.append(r4);
    L17:
        r3 = r3 + 1;
        goto L3
    L19:
        return r0.toString();
    }

    private boolean isNameCanToNumber(String r2) {
        if (sT9String.indexOf(r2) == (-1)) goto L5;
        return true;
    L5:
        if (T9SearchLocaleUtils.isChinese(r2.charAt(0)) == false) goto L7;
        return true;
    L7:
        if (T9SearchLocaleUtils.isKorean(r2.charAt(0)) == false) goto L9;
        return true;
    L9:
        if (ContactsUtils.isRussianLetter(r2.charAt(0)) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static String removeNonDigits(String r5) {
        int r0 = r5.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        char r3 = r5.charAt(r2);
        if (r3 < '0') goto L9;
        if (r3 > '9') goto L9;
    L18:
        r1.append(r3);
    L19:
        r2 = r2 + 1;
    L9:
        if (r3 == '*') goto L18;
        if (r3 == '#') goto L18;
        if (r3 == '+') goto L18;
        if (r3 == ',') goto L18;
        if (r3 != ';') goto L19;
    L21:
        return r1.toString();
    }

    public T9Adapter getT9Adapter(Context r2, ArrayList<ContactItem> r3) {
        return new T9Adapter(this, r2, r3);
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }
}
