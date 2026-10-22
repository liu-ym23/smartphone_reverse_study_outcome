package com.android.contacts.model;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.accounts.OnAccountsUpdateListener;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SyncAdapterType;
import android.content.SyncStatusObserver;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.util.TimingLogger;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.ReflectUtils;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.ContactsIntentUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AccountTypeManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class AccountTypeManagerImpl extends AccountTypeManager implements OnAccountsUpdateListener, SyncStatusObserver {
    private static final Comparator<Account> ACCOUNT_COMPARATOR = null;
    private static final Map<AccountTypeWithDataSet, AccountType> EMPTY_UNMODIFIABLE_ACCOUNT_TYPE_MAP = null;
    private static final int MESSAGE_LOAD_DATA = 0;
    private static final int MESSAGE_PROCESS_BROADCAST_INTENT = 1;
    private static final Uri SAMPLE_CONTACT_URI = null;
    private AccountManager mAccountManager;
    private Map<AccountTypeWithDataSet, AccountType> mAccountTypesWithDataSets;
    private List<AccountWithDataSet> mAccounts;
    private BroadcastReceiver mBroadcastReceiver;
    private final Runnable mCheckFilterValidityRunnable;
    private List<AccountWithDataSet> mContactWritableAccounts;
    private Context mContext;
    private AccountType mFallbackAccountType;
    private List<AccountWithDataSet> mGroupWritableAccounts;
    private volatile CountDownLatch mInitializationLatch;
    private final InvitableAccountTypeCache mInvitableAccountTypeCache;
    private Map<AccountTypeWithDataSet, AccountType> mInvitableAccountTypes;
    private final AtomicBoolean mInvitablesCacheIsInitialized;
    private final AtomicBoolean mInvitablesTaskIsRunning;
    private Handler mListenerHandler;
    private HandlerThread mListenerThread;
    private final Handler mMainThreadHandler;

    /* JADX INFO: compiled from: AccountTypeManager.java */
    private class FindInvitablesTask extends AsyncTask<Void, Void, Map<AccountTypeWithDataSet, AccountType>> {
        final /* synthetic */ AccountTypeManagerImpl this$0;

        private FindInvitablesTask(AccountTypeManagerImpl r1) {
            this.this$0 = r1;
        }

        /* synthetic */ FindInvitablesTask(AccountTypeManagerImpl r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Map<AccountTypeWithDataSet, AccountType> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Map<AccountTypeWithDataSet, AccountType> r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Map<AccountTypeWithDataSet, AccountType> doInBackground2(Void... r1) {
            AccountTypeManagerImpl r0 = this.this$0;
            return AccountTypeManagerImpl.access$400(r0, AccountTypeManagerImpl.access$000(r0));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Map<AccountTypeWithDataSet, AccountType> r2) {
            AccountTypeManagerImpl.access$500(this.this$0).setCachedValue(r2);
            AccountTypeManagerImpl.access$600(this.this$0).set(false);
        }
    }

    /* JADX INFO: compiled from: AccountTypeManager.java */
    private static final class InvitableAccountTypeCache {
        private static final long TIME_TO_LIVE = 60000;
        private Map<AccountTypeWithDataSet, AccountType> mInvitableAccountTypes;
        private long mTimeLastSet;

        private InvitableAccountTypeCache() {
        }

        /* synthetic */ InvitableAccountTypeCache(AnonymousClass1 r1) {
            this();
        }

        public boolean isExpired() {
            if ((SystemClock.elapsedRealtime() - this.mTimeLastSet) <= 60000) goto L5;
            return true;
        L5:
            return false;
        }

        public Map<AccountTypeWithDataSet, AccountType> getCachedValue() {
            return this.mInvitableAccountTypes;
        }

        public void setCachedValue(Map<AccountTypeWithDataSet, AccountType> r3) {
            this.mInvitableAccountTypes = r3;
            this.mTimeLastSet = SystemClock.elapsedRealtime();
        }
    }

    private List<Account> getAccountsOfDoppelganger(Context r1) {
        return null;
    }

    static /* synthetic */ Context access$000(AccountTypeManagerImpl r0) {
        return r0.mContext;
    }

    static /* synthetic */ Handler access$100(AccountTypeManagerImpl r0) {
        return r0.mListenerHandler;
    }

    static /* synthetic */ Map access$400(AccountTypeManagerImpl r0, Context r1) {
        return r0.findUsableInvitableAccountTypes(r1);
    }

    static /* synthetic */ InvitableAccountTypeCache access$500(AccountTypeManagerImpl r0) {
        return r0.mInvitableAccountTypeCache;
    }

    static /* synthetic */ AtomicBoolean access$600(AccountTypeManagerImpl r0) {
        return r0.mInvitablesTaskIsRunning;
    }

    static {
        EMPTY_UNMODIFIABLE_ACCOUNT_TYPE_MAP = Collections.unmodifiableMap(new HashMap());
        SAMPLE_CONTACT_URI = ContactsContract.Contacts.getLookupUri(1, "xxx");
        ACCOUNT_COMPARATOR = new AnonymousClass3();
    }

    public AccountTypeManagerImpl(Context r5) {
        this.mAccounts = Lists.newArrayList();
        this.mContactWritableAccounts = Lists.newArrayList();
        this.mGroupWritableAccounts = Lists.newArrayList();
        this.mAccountTypesWithDataSets = Maps.newHashMap();
        this.mInvitableAccountTypes = EMPTY_UNMODIFIABLE_ACCOUNT_TYPE_MAP;
        this.mInvitablesCacheIsInitialized = new AtomicBoolean(false);
        this.mInvitablesTaskIsRunning = new AtomicBoolean(false);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mCheckFilterValidityRunnable = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mInitializationLatch = new CountDownLatch(1);
        this.mContext = r5.getApplicationContext();
        this.mFallbackAccountType = new FallbackAccountType(this.mContext);
        this.mAccountManager = AccountManager.get(this.mContext);
        HandlerThread r6 = new HandlerThread("AccountChangeListener");
        this.mListenerThread = r6;
        r6.start();
        final Looper r0 = this.mListenerThread.getLooper();
        this.mListenerHandler = new AnonymousClass4(this, r0);
        this.mInvitableAccountTypeCache = new InvitableAccountTypeCache(null);
        IntentFilter r7 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        r7.addAction("android.intent.action.PACKAGE_REMOVED");
        r7.addAction("android.intent.action.PACKAGE_CHANGED");
        r7.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r7);
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        r8.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r8);
        IntentFilter r9 = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r9);
        this.mAccountManager.addOnAccountsUpdatedListener(this, this.mListenerHandler, false);
        ContentResolver.addStatusChangeListener(1, this);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == true) goto L5;
    L7:
        this.mListenerHandler.sendEmptyMessage(0);
        this.mListenerHandler.postDelayed(new AnonymousClass6(this), WsConstants.EXIT_DELAY_TIME);
        return;
    L5:
        if (DSUtils.isMultiSimEnabled() == false) goto L7;
        DSUtils.registerIccStateListener(new AnonymousClass5(this));
        goto L7
    }

    @Override // android.content.SyncStatusObserver
    public void onStatusChanged(int r1) {
        this.mListenerHandler.sendEmptyMessage(0);
    }

    public void processBroadcastIntent(Intent r1) {
        this.mListenerHandler.sendEmptyMessage(0);
    }

    @Override // android.accounts.OnAccountsUpdateListener
    public void onAccountsUpdated(Account[] r1) {
        loadAccountsInBackground();
    }

    void ensureAccountsLoaded() {
        CountDownLatch r1 = this.mInitializationLatch;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.await();     // Catch: InterruptedException -> L7
        return;
    L7:
        Thread.currentThread().interrupt();
        goto L8
    }

    protected void loadAccountsInBackground() {
        if (Log.isLoggable("ContactsPerf", 3) == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactsPerf", "AccountTypeManager.loadAccountsInBackground start");
    L5:
        TimingLogger r3 = new TimingLogger("AccountTypeManager", "loadAccountsInBackground");
        long r4 = SystemClock.currentThreadTimeMillis();
        long r6 = SystemClock.elapsedRealtime();
        Map<AccountTypeWithDataSet, AccountType> r8 = Maps.newHashMap();
        Map<String, List<AccountType>> r9 = Maps.newHashMap();
        ArrayList r10 = Lists.newArrayList();
        ArrayList r11 = Lists.newArrayList();
        ArrayList r12 = Lists.newArrayList();
        HashSet r0 = Sets.newHashSet();
        AccountManager r13 = this.mAccountManager;
        SyncAdapterType[] r2 = ContentResolver.getContentService().getSyncAdapterTypes();     // Catch: Throwable -> L74
        AuthenticatorDescription[] r14 = r13.getAuthenticatorTypes();     // Catch: Throwable -> L74
        int r15 = r2.length;     // Catch: Throwable -> L74
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L47;
        int r17 = r15;
        SyncAdapterType r18 = r2[r16];     // Catch: Throwable -> L74
        SyncAdapterType[] r19 = r2;
        long r110 = r4;
        if ("com.android.contacts".equals(r18.authority) == true) goto L13;
    L12:
        r14 = r14;
        int r111 = 0;
    L159:
        r16 = r16 + 1;     // Catch: Throwable -> L72
        r15 = r17;
        r2 = r19;
        r4 = r110;
        r14 = r14;
    L72:
        th = th;
    L77:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "Problem loading accounts: " + th.toString());
    L78:
        r3.addSplit("Loaded account types");
        ArrayList r5 = new ArrayList();
        Account[] r7 = this.mAccountManager.getAccounts();
        int r20 = r7.length;
        int r112 = r111;
    L79:
        if (r112 >= r20) goto L91;
        Account r113 = r7[r112];
        if (ContentResolver.getContentService().getIsSyncable(r113, "com.android.contacts") <= 0) goto L84;
        boolean r1 = true;
    L88:
        if (r1 == false) goto L90;
        r5.add(r113);
    L90:
        r112 = r112 + 1;
        r7 = r7;
        r20 = r20;
        goto L79
    L84:
        r1 = false;
    L86:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("AccountTypeManager", "Cannot obtain sync flag for account: " + r113, th);
        r1 = false;
        goto L88
    L91:
        List<Account> r21 = getAccountsOfDoppelganger(this.mContext);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "accountsOfDoppelganger == " + r21);
        if (r21 != null) goto L94;
    L96:
        Iterator r22 = r5.iterator();
    L98:
        if (r22.hasNext() == false) goto L120;
        Account r23 = (Account) r22.next();
        List<AccountType> r24 = r9.get(r23.type);
        if (r24 == null) goto L112;
        Iterator<AccountType> r25 = r24.iterator();
    L103:
        if (r25.hasNext() == false) goto L111;
        AccountType r26 = r25.next();
        Iterator r114 = r22;
        AccountWithDataSet r115 = new AccountWithDataSet(r23.name, r23.type, r26.dataSet);
        r10.add(r115);
        if (r26.areContactsWritable() == false) goto L108;
        r11.add(r115);
    L108:
        if (r26.isGroupMembershipEditable() == false) goto L110;
        r12.add(r115);
    L110:
        r22 = r114;
        goto L103
    L111:
        Iterator r116 = r22;
    L118:
        r22 = r116;
        goto L98
    L112:
        r116 = r22;
        AccountWithDataSet r27 = new AccountWithDataSet(r23.name, r23.type, null);
        r10.add(r27);
        if (this.mFallbackAccountType.areContactsWritable() == false) goto L116;
        r11.add(r27);
    L116:
        if (this.mFallbackAccountType.isGroupMembershipEditable() == false) goto L118;
        r12.add(r27);
        goto L118
    L120:
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == true) goto L122;
    L136:
        Comparator<Account> r28 = ACCOUNT_COMPARATOR;
        Collections.sort(r10, r28);
        Collections.sort(r11, r28);
        Collections.sort(r12, r28);
        r3.addSplit("Loaded accounts");
        monitor-enter(this);
        this.mAccountTypesWithDataSets = r8;     // Catch: Throwable -> L154
        this.mAccounts = r10;     // Catch: Throwable -> L154
        this.mContactWritableAccounts = r11;     // Catch: Throwable -> L154
        this.mGroupWritableAccounts = r12;     // Catch: Throwable -> L154
        this.mInvitableAccountTypes = findAllInvitableAccountTypes(this.mContext, r10, r8);     // Catch: Throwable -> L154
        monitor-exit(this);     // Catch: Throwable -> L154
        r3.dumpToLog();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("AccountTypeManager", "Loaded meta-data for " + this.mAccountTypesWithDataSets.size() + " account types, " + this.mAccounts.size() + " accounts in " + (SystemClock.elapsedRealtime() - r6) + "ms(wall) " + (SystemClock.currentThreadTimeMillis() - r110) + "ms(cpu)");
        monitor-enter(this);
    L151:
        th = move-exception;
        throw th;
    L143:
        if (this.mInitializationLatch == null) goto L145;
        this.mInitializationLatch.countDown();     // Catch: Throwable -> L151
        this.mInitializationLatch = null;     // Catch: Throwable -> L151
    L145:
        monitor-exit(this);     // Catch: Throwable -> L151
        if (Log.isLoggable("ContactsPerf", 3) == false) goto L149;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactsPerf", "AccountTypeManager.loadAccountsInBackground finish");
    L149:
        this.mMainThreadHandler.post(this.mCheckFilterValidityRunnable);
        return;
    L154:
        th = move-exception;
        throw th;
    L122:
        if (DSUtils.isMultiSimEnabled() == false) goto L136;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "add sim accounts for CMCC");
        int r117 = 0;
    L125:
        if (r117 >= DSUtils.getPhoneCount()) goto L136;
        if (DSUtils.hasIccCard(r117) == false) goto L135;
        if (DSUtils.isSimEnable(r117) == false) goto L135;
        if (MoreContactUtils.canSaveEmail(r117) == false) goto L133;
        String r29 = "USIM";
    L134:
        String r30 = MoreContactUtils.getSimAccountName(r117);
        r10.add(new AccountWithDataSet(r30, "com.android.sim", r29));
        r11.add(new AccountWithDataSet(r30, "com.android.sim", r29));
        goto L135
    L133:
        r29 = SimContactsConstants.SIM_NAME;
    L135:
        r117 = r117 + 1;
        goto L125
    L94:
        if (r21.size() <= 0) goto L96;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "add " + r21.size() + " accounts of doppelganger.");
        r5.addAll(r21);
        goto L96
    L13:
        String r31 = r18.accountType;     // Catch: Throwable -> L45
        AuthenticatorDescription r32 = findAuthenticator(r14, r31);     // Catch: Throwable -> L45
        if (r32 != null) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "No authenticator found for type=" + r31 + ", ignoring it.");     // Catch: Throwable -> L45
        goto L12
    L17:
        if ("com.google".equals(r31) == false) goto L21;
        AccountType r33 = new GoogleAccountType(this.mContext, r32.packageName);     // Catch: Throwable -> L45
    L19:
        r14 = r14;
        r111 = 0;
    L37:
        if (r33.isInitialized() == false) goto L39;
        r33.accountType = r32.type;     // Catch: Throwable -> L72
        r33.titleRes = r32.labelId;     // Catch: Throwable -> L72
        r33.iconRes = r32.iconId;     // Catch: Throwable -> L72
        addAccountType(r33, r8, r9);     // Catch: Throwable -> L72
        r0.addAll(r33.getExtensionPackageNames());     // Catch: Throwable -> L72
        goto L159
    L39:
        if (r33.isEmbedded() == false) goto L159;
        throw new IllegalStateException("Problem initializing embedded type " + r33.getClass().getCanonicalName());     // Catch: Throwable -> L72
    L21:
        if (ExchangeAccountType.ACCOUNT_TYPE.equals(r31) == false) goto L24;
        r33 = new ExchangeAccountType(this.mContext, r32.packageName);     // Catch: Throwable -> L45
        goto L19
    L24:
        if (BytedanceAccountType.ACCOUNT_TYPE.equals(r31) == false) goto L27;
        r33 = new BytedanceAccountType(this.mContext, r32.packageName);     // Catch: Throwable -> L45
        goto L19
    L27:
        if ("com.android.sim".equals(r31) == true) goto L12;
        if (ContactsUtils.DEBUG == false) goto L34;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Registering external account type=" + r31 + ", packageName=" + r32.packageName);     // Catch: Throwable -> L45
    L34:
        r111 = 0;
        r33 = new ExternalAccountType(this.mContext, r32.packageName, false);     // Catch: Throwable -> L72
    L45:
        th = th;
    L76:
        r111 = 0;
        goto L77
    L47:
        r110 = r4;
        r111 = 0;
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L51;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "create sim accounts for cmcc.");     // Catch: Throwable -> L72
        AccountType r34 = new SimAccountType(this.mContext, "com.android.contacts");     // Catch: Throwable -> L72
        r34.accountType = "com.android.sim";     // Catch: Throwable -> L72
        r34.titleRes = R.string.account_sim;     // Catch: Throwable -> L72
        r34.iconRes = R.drawable.ic_sim;     // Catch: Throwable -> L72
        addAccountType(r34, r8, r9);     // Catch: Throwable -> L72
        AccountType r35 = new USimAccountType(this.mContext, "com.android.contacts");     // Catch: Throwable -> L72
        r35.accountType = "com.android.sim";     // Catch: Throwable -> L72
        r35.titleRes = R.string.account_sim;     // Catch: Throwable -> L72
        r35.iconRes = R.drawable.ic_sim;     // Catch: Throwable -> L72
        addAccountType(r35, r8, r9);     // Catch: Throwable -> L72
    L51:
        if (r0.isEmpty() == true) goto L78;
        if (ContactsUtils.DEBUG == false) goto L55;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Registering " + r0.size() + " extension packages");     // Catch: Throwable -> L72
    L55:
        Iterator r36 = r0.iterator();     // Catch: Throwable -> L72
    L57:
        if (r36.hasNext() == false) goto L78;
        String r37 = (String) r36.next();     // Catch: Throwable -> L72
        ExternalAccountType r38 = new ExternalAccountType(this.mContext, r37, true);     // Catch: Throwable -> L72
        if (r38.isInitialized() == false) goto L57;
        if (r38.hasContactsMetadata() == false) goto L63;
        if (TextUtils.isEmpty(r38.accountType) == true) goto L66;
        if (ContactsUtils.DEBUG == false) goto L70;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Registering extension package account type=" + r38.accountType + ", dataSet=" + r38.dataSet + ", packageName=" + r37);     // Catch: Throwable -> L72
    L70:
        addAccountType(r38, r8, r9);     // Catch: Throwable -> L72
        goto L57
    L66:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "Skipping extension package " + r37 + " because the CONTACTS_STRUCTURE metadata doesn't have the accountType attribute");     // Catch: Throwable -> L72
        goto L57
    L63:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "Skipping extension package " + r37 + " because it doesn't have the CONTACTS_STRUCTURE metadata");     // Catch: Throwable -> L72
    L74:
        th = th;
        r110 = r4;
        goto L76
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public boolean isSyncActive() {
        Account[] r0 = AccountManager.get(this.mContext).getAccounts();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.length <= 0) goto L13;
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        if (ReflectUtils.isSyncActive(this.mContext, r0[r3], "com.android.contacts") == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    }

    private void addAccountType(AccountType r1, Map<AccountTypeWithDataSet, AccountType> r2, Map<String, List<AccountType>> r3) {
        r2.put(r1.getAccountTypeAndDataSet(), r1);
        List<AccountType> r0 = r3.get(r1.accountType);
        if (r0 != null) goto L5;
        r0 = Lists.newArrayList();
    L5:
        r0.add(r1);
        r3.put(r1.accountType, r0);
    }

    protected static AuthenticatorDescription findAuthenticator(AuthenticatorDescription[] r4, String r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        AuthenticatorDescription r2 = r4[r1];
        if (r5.equals(r2.type) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public List<AccountWithDataSet> getAccounts(boolean r3) {
        ensureAccountsLoaded();
        if (r3 == false) goto L5;
        List<AccountWithDataSet> r2 = this.mContactWritableAccounts;
    L6:
        ArrayList r0 = new ArrayList(r2);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L14;
        Iterator r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if ("com.android.sim".equals(((AccountWithDataSet) r4.next()).type) == false) goto L10;
        r4.remove();
    L14:
        return r0;
    L5:
        r2 = this.mAccounts;
        goto L6
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public List<AccountWithDataSet> getAccountsIncludeSIM(boolean r2) {
        ensureAccountsLoaded();
        if (r2 == false) goto L5;
        List<AccountWithDataSet> r1 = this.mContactWritableAccounts;
    L7:
        return new ArrayList(r1);
    L5:
        r1 = this.mAccounts;
        goto L7
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public List<AccountWithDataSet> getGroupWritableAccounts() {
        ensureAccountsLoaded();
        return this.mGroupWritableAccounts;
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public DataKind getKindOrFallback(String r2, String r3, String r4) {
        ensureAccountsLoaded();
        AccountType r5 = this.mAccountTypesWithDataSets.get(AccountTypeWithDataSet.get(r2, r3));
        if (r5 == null) goto L5;
        DataKind r6 = r5.getKindForMimetype(r4);
    L6:
        if (r6 != null) goto L8;
        r6 = this.mFallbackAccountType.getKindForMimetype(r4);
    L8:
        if (r6 != null) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "Unknown type=" + r2 + ", mime=" + r4);
    L10:
        return r6;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public AccountType getAccountType(AccountTypeWithDataSet r2) {
        ensureAccountsLoaded();
        monitor-enter(this);
        AccountType r3 = this.mAccountTypesWithDataSets.get(r2);     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        r3 = this.mFallbackAccountType;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    private Map<AccountTypeWithDataSet, AccountType> getAllInvitableAccountTypes() {
        ensureAccountsLoaded();
        return this.mInvitableAccountTypes;
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public Map<AccountTypeWithDataSet, AccountType> getUsableInvitableAccountTypes() {
        ensureAccountsLoaded();
        if (this.mInvitablesCacheIsInitialized.get() == true) goto L6;
        this.mInvitableAccountTypeCache.setCachedValue(findUsableInvitableAccountTypes(this.mContext));
        this.mInvitablesCacheIsInitialized.set(true);
    L11:
        return this.mInvitableAccountTypeCache.getCachedValue();
    L6:
        if (this.mInvitableAccountTypeCache.isExpired() == false) goto L11;
        if (this.mInvitablesTaskIsRunning.compareAndSet(false, true) == false) goto L11;
        new FindInvitablesTask(this, null).execute(new Void[0]);
        goto L11
    }

    static Map<AccountTypeWithDataSet, AccountType> findAllInvitableAccountTypes(Context r5, Collection<AccountWithDataSet> r6, Map<AccountTypeWithDataSet, AccountType> r7) {
        HashMap r8 = Maps.newHashMap();
        Iterator<AccountWithDataSet> r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L18;
        AccountTypeWithDataSet r0 = r9.next().getAccountTypeWithDataSet();
        AccountType r1 = r7.get(r0);
        if (r1 == null) goto L4;
        if (r8.containsKey(r0) == true) goto L4;
        if (Log.isLoggable("AccountTypeManager", 3) == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Type " + r0 + " inviteClass=" + r1.getInviteContactActivityClassName());
    L15:
        if (TextUtils.isEmpty(r1.getInviteContactActivityClassName()) == true) goto L4;
        r8.put(r0, r1);
        goto L4
    L18:
        return Collections.unmodifiableMap(r8);
    }

    private Map<AccountTypeWithDataSet, AccountType> findUsableInvitableAccountTypes(Context r7) {
        Map<AccountTypeWithDataSet, AccountType> r6 = getAllInvitableAccountTypes();
        if (r6.isEmpty() == true) goto L5;
        HashMap r0 = Maps.newHashMap();
        r0.putAll(r6);
        PackageManager r1 = r7.getPackageManager();
        Iterator<AccountTypeWithDataSet> r2 = r6.keySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        AccountTypeWithDataSet r3 = r2.next();
        Intent r4 = ContactsIntentUtils.getInvitableIntent(r6.get(r3), SAMPLE_CONTACT_URI);
        if (r4 == null) goto L11;
        if (r1.resolveActivity(r4, 65536) == null) goto L14;
        if (r3.hasData(r7) == true) goto L8;
        r0.remove(r3);
        goto L8
    L14:
        r0.remove(r3);
        goto L8
    L11:
        r0.remove(r3);
        goto L8
    L19:
        return Collections.unmodifiableMap(r0);
    L5:
        return EMPTY_UNMODIFIABLE_ACCOUNT_TYPE_MAP;
    }

    @Override // com.android.contacts.model.AccountTypeManager
    public List<AccountType> getAccountTypes(boolean r5) {
        ensureAccountsLoaded();
        ArrayList r0 = Lists.newArrayList();
        monitor-enter(this);
        Iterator<AccountType> r1 = this.mAccountTypesWithDataSets.values().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        AccountType r2 = r1.next();     // Catch: Throwable -> L14
        if (r5 == false) goto L11;
        if (r2.areContactsWritable() == false) goto L6;
    L11:
        r0.add(r2);     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return r0;
    L14:
        th = move-exception;
        throw th;
    }
}
