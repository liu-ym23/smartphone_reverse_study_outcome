package com.android.contacts.common.model;

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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TimingLogger;
import com.GlobalProxyLancet;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.account.AccountTypeWithDataSet;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.model.account.ExchangeAccountType;
import com.android.contacts.common.model.account.ExternalAccountType;
import com.android.contacts.common.model.account.FallbackAccountType;
import com.android.contacts.common.model.account.GoogleAccountType;
import com.android.contacts.common.model.account.PhoneAccountType;
import com.android.contacts.common.model.account.SamsungAccountType;
import com.android.contacts.common.model.account.SimAccountType;
import com.android.contacts.common.model.dataitem.DataKind;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
/* JADX INFO: loaded from: classes.dex */
public class AccountTypeManagerImpl extends AccountTypeManager implements OnAccountsUpdateListener, SyncStatusObserver {
    private static final Comparator<AccountWithDataSet> ACCOUNT_COMPARATOR = null;
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
        this.mContext = r5;
        this.mFallbackAccountType = new FallbackAccountType(r5);
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
        this.mListenerHandler.sendEmptyMessage(0);
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
        TimingLogger r0 = new TimingLogger("AccountTypeManager", "loadAccountsInBackground");
        long r3 = SystemClock.currentThreadTimeMillis();
        long r5 = SystemClock.elapsedRealtime();
        Map<AccountTypeWithDataSet, AccountType> r7 = Maps.newHashMap();
        Map<String, List<AccountType>> r8 = Maps.newHashMap();
        ArrayList r9 = Lists.newArrayList();
        ArrayList r10 = Lists.newArrayList();
        ArrayList r11 = Lists.newArrayList();
        HashSet r12 = Sets.newHashSet();
        AccountManager r13 = this.mAccountManager;
        SyncAdapterType[] r14 = ContentResolver.getSyncAdapterTypes();
        AuthenticatorDescription[] r15 = r13.getAuthenticatorTypes();
        int r16 = r14.length;
        int r2 = 0;
    L6:
        if (r2 >= r16) goto L39;
        int r17 = r16;
        SyncAdapterType r18 = r14[r2];
        SyncAdapterType[] r19 = r14;
        long r110 = r3;
        if ("com.android.contacts".equals(r18.authority) == true) goto L10;
    L9:
        AuthenticatorDescription[] r20 = r15;
    L38:
        r2 = r2 + 1;
        r16 = r17;
        r14 = r19;
        r3 = r110;
        r15 = r20;
        goto L6
    L10:
        String r4 = r18.accountType;
        AuthenticatorDescription r6 = findAuthenticator(r15, r4);
        if (r6 != null) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "No authenticator found for type=" + r4 + ", ignoring it.");
        goto L9
    L14:
        if ("com.google".equals(r4) == false) goto L18;
        AccountType r21 = new GoogleAccountType(this.mContext, r6.packageName);
        r20 = r15;
    L31:
        if (r21.isInitialized() == false) goto L33;
        r21.accountType = r6.type;
        r21.titleRes = r6.labelId;
        r21.iconRes = r6.iconId;
        addAccountType(r21, r7, r8);
        r12.addAll(r21.getExtensionPackageNames());
        goto L38
    L33:
        if (r21.isEmbedded() == false) goto L38;
        throw new IllegalStateException("Problem initializing embedded type " + r21.getClass().getCanonicalName());
    L18:
        if (ExchangeAccountType.isExchangeType(r4) == false) goto L20;
        r20 = r15;
        r21 = new ExchangeAccountType(this.mContext, r6.packageName, r4);
        goto L31
    L20:
        r20 = r15;
        if (SamsungAccountType.isSamsungAccountType(this.mContext, r4, r6.packageName) == false) goto L24;
        r21 = new SamsungAccountType(this.mContext, r6.packageName, r4);
        goto L31
    L24:
        if ("com.android.sim".equals(r4) == false) goto L27;
        r21 = new SimAccountType(this.mContext, r6.packageName);
        goto L31
    L27:
        if ("com.android.localphone".equals(r4) == false) goto L29;
        r21 = new PhoneAccountType(this.mContext, r6.packageName);
        goto L31
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Registering external account type=" + r4 + ", packageName=" + r6.packageName);
        r21 = new ExternalAccountType(this.mContext, r6.packageName, false);
        goto L31
    L39:
        long r111 = r3;
        boolean r112 = false;
        boolean r22 = true;
        if (r12.isEmpty() == true) goto L54;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Registering " + r12.size() + " extension packages");
        Iterator r23 = r12.iterator();
    L43:
        if (r23.hasNext() == false) goto L54;
        String r24 = (String) r23.next();
        ExternalAccountType r113 = new ExternalAccountType(this.mContext, r24, r22);
        if (r113.isInitialized() == false) goto L43;
        if (r113.hasContactsMetadata() == false) goto L49;
        if (TextUtils.isEmpty(r113.accountType) == true) goto L52;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Registering extension package account type=" + r113.accountType + ", dataSet=" + r113.dataSet + ", packageName=" + r24);
        addAccountType(r113, r7, r8);
        r22 = true;
        goto L43
    L52:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "Skipping extension package " + r24 + " because the CONTACTS_STRUCTURE metadata doesn't have the accountType attribute");
        goto L43
    L49:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("AccountTypeManager", "Skipping extension package " + r24 + " because it doesn't have the CONTACTS_STRUCTURE metadata");
    L54:
        r0.addSplit("Loaded account types");
        Account[] r25 = this.mAccountManager.getAccounts();
        int r26 = r25.length;
        int r27 = 0;
    L55:
        if (r27 >= r26) goto L74;
        Account r114 = r25[r27];
        if (ContentResolver.getIsSyncable(r114, "com.android.contacts") <= 0) goto L59;
        boolean r115 = true;
    L60:
        if (r115 == false) goto L73;
        List<AccountType> r116 = r8.get(r114.type);
        if (r116 == null) goto L73;
        Iterator<AccountType> r117 = r116.iterator();
    L65:
        if (r117.hasNext() == false) goto L73;
        AccountType r118 = r117.next();
        Account[] r119 = r25;
        int r28 = r26;
        Map<String, List<AccountType>> r29 = r8;
        AccountWithDataSet r120 = new AccountWithDataSet(r114.name, r114.type, r118.dataSet);
        r9.add(r120);
        if (r118.areContactsWritable() == false) goto L70;
        r10.add(r120);
    L70:
        if (r118.isGroupMembershipEditable() == false) goto L72;
        r11.add(r120);
    L72:
        r25 = r119;
        r26 = r28;
        r8 = r29;
    L73:
        r27 = r27 + 1;
        r25 = r25;
        r26 = r26;
        r8 = r8;
        r112 = false;
        goto L55
    L59:
        r115 = r112;
        goto L60
    L74:
        Comparator<AccountWithDataSet> r30 = ACCOUNT_COMPARATOR;
        Collections.sort(r9, r30);
        Collections.sort(r10, r30);
        Collections.sort(r11, r30);
        r0.addSplit("Loaded accounts");
        monitor-enter(this);
        this.mAccountTypesWithDataSets = r7;     // Catch: Throwable -> L86
        this.mAccounts = r9;     // Catch: Throwable -> L86
        this.mContactWritableAccounts = r10;     // Catch: Throwable -> L86
        this.mGroupWritableAccounts = r11;     // Catch: Throwable -> L86
        this.mInvitableAccountTypes = findAllInvitableAccountTypes(this.mContext, r9, r7);     // Catch: Throwable -> L86
        monitor-exit(this);     // Catch: Throwable -> L86
        r0.dumpToLog();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("AccountTypeManager", "Loaded meta-data for " + this.mAccountTypesWithDataSets.size() + " account types, " + this.mAccounts.size() + " accounts in " + (SystemClock.elapsedRealtime() - r5) + "ms(wall) " + (SystemClock.currentThreadTimeMillis() - r111) + "ms(cpu)");
        if (this.mInitializationLatch == null) goto L82;
        this.mInitializationLatch.countDown();
        this.mInitializationLatch = null;
    L82:
        if (Log.isLoggable("ContactsPerf", 3) == false) goto L84;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("ContactsPerf", "AccountTypeManager.loadAccountsInBackground finish");
    L84:
        this.mMainThreadHandler.post(this.mCheckFilterValidityRunnable);
        return;
    L86:
        th = move-exception;
        throw th;
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

    @Override // com.android.contacts.common.model.AccountTypeManager
    public List<AccountWithDataSet> getAccounts(boolean r2) {
        return getAccounts(r2, 0);
    }

    @Override // com.android.contacts.common.model.AccountTypeManager
    public List<AccountWithDataSet> getAccounts(boolean r3, int r4) {
        ensureAccountsLoaded();
        if (r4 != 0) goto L5;
        if (r3 == false) goto L24;
        List<AccountWithDataSet> r5 = this.mContactWritableAccounts;
    L25:
        String r1 = (String) null;
        return trimAccountByType(r5, new String[]{null});
    L24:
        r5 = this.mAccounts;
        goto L25
    L5:
        if (r4 != 1) goto L7;
        if (r3 == false) goto L19;
        List<AccountWithDataSet> r6 = this.mContactWritableAccounts;
    L21:
        return trimAccountByType(r6, new String[]{"com.android.sim"});
    L19:
        r6 = this.mAccounts;
        goto L21
    L7:
        if (r4 == 2) goto L12;
        if (r3 == false) goto L11;
        return this.mContactWritableAccounts;
    L11:
        return this.mAccounts;
    L12:
        if (r3 == false) goto L14;
        List<AccountWithDataSet> r7 = this.mContactWritableAccounts;
    L16:
        return trimAccountByType(r7, new String[]{"com.android.sim", "com.android.localphone"});
    L14:
        r7 = this.mAccounts;
        goto L16
    }

    private boolean isSimAccountInvalid(AccountWithDataSet r3) {
        TelephonyManager r2 = (TelephonyManager) this.mContext.getSystemService("phone");
        if ("com.android.sim".equals(r3.type) == true) goto L5;
        return false;
    L5:
        if (r2.getPhoneCount() <= 1) goto L10;
        if (r3.name.equals(SimContactsConstants.SIM_NAME) == false) goto L14;
        return true;
    L14:
        return false;
    L10:
        if (r3.name.equals(SimContactsConstants.SIM_NAME) == true) goto L15;
        return true;
    L15:
        return false;
    }

    private List<AccountWithDataSet> trimAccountByType(List<AccountWithDataSet> r7, String... r8) {
        ArrayList r0 = Lists.newArrayList();
        Iterator<AccountWithDataSet> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L21;
        AccountWithDataSet r1 = r9.next();
        if (r8 == null) goto L18;
        if (r8.length <= 0) goto L18;
        int r2 = r8.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L18;
        String r4 = r8[r3];
        if (r4 == null) goto L16;
        if (r4.equals(r1.type) == true) goto L4;
    L16:
        r3 = r3 + 1;
    L18:
        if (isSimAccountInvalid(r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L21:
        return r0;
    }

    @Override // com.android.contacts.common.model.AccountTypeManager
    public List<AccountWithDataSet> getGroupWritableAccounts() {
        ensureAccountsLoaded();
        return this.mGroupWritableAccounts;
    }

    @Override // com.android.contacts.common.model.AccountTypeManager
    public DataKind getKindOrFallback(AccountType r4, String r5) {
        ensureAccountsLoaded();
        if (r4 == null) goto L5;
        DataKind r0 = r4.getKindForMimetype(r5);
    L6:
        if (r0 != null) goto L8;
        r0 = this.mFallbackAccountType.getKindForMimetype(r5);
    L8:
        if (r0 == null) goto L10;
    L12:
        return r0;
    L10:
        if (Log.isLoggable("AccountTypeManager", 3) == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AccountTypeManager", "Unknown type=" + r4 + ", mime=" + r5);
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.android.contacts.common.model.AccountTypeManager
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

    @Override // com.android.contacts.common.model.AccountTypeManager
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
        Intent r4 = MoreContactUtils.getInvitableIntent(r6.get(r3), SAMPLE_CONTACT_URI);
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

    @Override // com.android.contacts.common.model.AccountTypeManager
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
