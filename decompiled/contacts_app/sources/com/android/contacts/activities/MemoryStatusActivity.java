package com.android.contacts.activities;

import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.ReflectUtils;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.reflection.IIccPhoneBookUtil;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.Constants;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.collect.Lists;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.privacy.PrivacyUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class MemoryStatusActivity extends ContactsActivity {
    private static final int INVALID_COUNT = 0;
    private static final String TAG = "MemoryStatusActivity";
    private View empty;
    private AccountListAdapter mAdapter;
    private List<AccountListItem> mFilters;
    private Handler mHandler;
    private ListView mListView;
    private LoaderThread mThread;

    private class AccountListAdapter extends BaseAdapter {
        private Context accountContext;
        private final LayoutInflater mLayoutInflater;
        final /* synthetic */ MemoryStatusActivity this$0;

        public class AccountListItemViewCache {
            public final TextView content;
            final /* synthetic */ AccountListAdapter this$1;

            public AccountListItemViewCache(AccountListAdapter r1, View r2) {
                this.this$1 = r1;
                this.content = (TextView) r2.findViewById(R.id.content);
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public AccountListAdapter(MemoryStatusActivity r1, Context r2) {
            this.this$0 = r1;
            this.mLayoutInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
            this.accountContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MemoryStatusActivity.access$000(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public AccountListItem getItem(int r1) {
            return (AccountListItem) MemoryStatusActivity.access$000(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 == null) goto L4;
            AccountListItemViewCache r0 = (AccountListItemViewCache) r6.getTag();
            View r1 = r6;
        L5:
            bindView(r5, r6, r7, r0);
            return r1;
        L4:
            View r2 = this.mLayoutInflater.inflate(R.layout.memory_account_list_item, r7, false);
            AccountListItemViewCache r3 = new AccountListItemViewCache(this, r2);
            r2.setTag(r3);
            r1 = r2;
            r0 = r3;
            goto L5
        }

        private void bindView(int r3, View r4, ViewGroup r5, AccountListItemViewCache r6) {
            AccountListItem r7 = (AccountListItem) MemoryStatusActivity.access$000(this.this$0).get(r3);
            if (TextUtils.isEmpty(r7.accountType) == true) goto L5;
            r6.content.setText(DSUtils.getSimName(this.this$0, MoreContactUtils.getSubscription(r7.accountType, r7.accountName)) + " : " + r7.count + LibrarianImpl.Constants.SEPARATOR + r7.total);
            return;
        L5:
            r6.content.setText(this.this$0.getString(R.string.mobile) + " : " + r7.count);
        }
    }

    private final class AccountListItem {
        public final String accountName;
        public final String accountType;
        public final int count;
        public final String dataSet;
        public final Drawable icon;
        final /* synthetic */ MemoryStatusActivity this$0;
        public final int total;

        public AccountListItem(MemoryStatusActivity r1, String r2, String r3, String r4, Drawable r5, int r6, int r7) {
            this.this$0 = r1;
            this.accountType = r2;
            this.accountName = r3;
            this.dataSet = r4;
            this.icon = r5;
            this.total = r6;
            this.count = r7;
        }
    }

    public class LoaderThread extends Thread {
        final /* synthetic */ MemoryStatusActivity this$0;

        public LoaderThread(MemoryStatusActivity r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            MemoryStatusActivity r0 = this.this$0;
            List r1 = MemoryStatusActivity.access$200(r0, r0);
            Message r2 = Message.obtain();
            r2.obj = r1;
            MemoryStatusActivity.access$300(this.this$0).sendMessage(r2);
        }
    }

    public void com_android_contacts_activities_MemoryStatusActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_MemoryStatusActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_activities_MemoryStatusActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_MemoryStatusActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public MemoryStatusActivity() {
        this.mThread = null;
    }

    static /* synthetic */ List access$000(MemoryStatusActivity r0) {
        return r0.mFilters;
    }

    static /* synthetic */ List access$002(MemoryStatusActivity r0, List r1) {
        r0.mFilters = r1;
        return r1;
    }

    static /* synthetic */ AccountListAdapter access$100(MemoryStatusActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ List access$200(MemoryStatusActivity r0, Context r1) {
        return r0.loadAccountFilters(r1);
    }

    static /* synthetic */ Handler access$300(MemoryStatusActivity r0) {
        return r0.mHandler;
    }

    public void com_android_contacts_activities_MemoryStatusActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.contact_memory_list);
        UiUtils.setWindowColorStatusBar(this);
        OCTitleBar r6 = (OCTitleBar) findViewById(R.id.otitlebar);
        Intent r0 = getIntent();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        OButton r7 = r6.createTransIconButton(this, r6.mLeftContainer);
        r7.setMIcon(getDrawable(TitleBarUtil.getLeftRes(r2)));
        r7.setOnClickListener(new AnonymousClass1(this));
        this.mListView = (ListView) findViewById(android.R.id.list);
        View r8 = findViewById(R.id.empty);
        this.empty = r8;
        this.mListView.setEmptyView(r8);
        ActionBar r9 = getActionBar();
        if (r9 == null) goto L10;
        r9.setDisplayHomeAsUpEnabled(true);
    L10:
        this.mFilters = Lists.newArrayList();
        AccountListAdapter r10 = new AccountListAdapter(this, this);
        this.mAdapter = r10;
        this.mListView.setAdapter(r10);
        this.mHandler = new AnonymousClass2(this);
        return;
    L5:
        if (r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r2 = true;
        goto L7
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 16908332) goto L5;
        Intent r4 = new Intent(this, DialtactsActivity.class);
        r4.addFlags(67108864);
        startActivity(r4);
        finish();
        return true;
    L5:
        return super.onOptionsItemSelected(r3);
    }

    public void com_android_contacts_activities_MemoryStatusActivity__onResume$___twin___() {
        super.onResume();
        if (this.mFilters.isEmpty() == true) goto L5;
        return;
    L5:
        if (this.mThread != null) goto L10;
        this.mThread = new LoaderThread(this);
    L10:
        this.mThread.start();     // Catch: Exception -> L9
        return;
    }

    private List<AccountListItem> loadAccountFilters(Context r22) {
        log("Start loadAccountFilters");
        ArrayList r1 = Lists.newArrayList();
        AccountTypeManager r2 = AccountTypeManager.getInstance(r22);
        List<AccountWithDataSet> r3 = r2.getAccountsIncludeSIM(true);
        ContentResolver r10 = r22.getContentResolver();
        Iterator<AccountWithDataSet> r4 = r3.iterator();
    L3:
        int r11 = 0;
        if (r4.hasNext() == false) goto L29;
        AccountWithDataSet r12 = r4.next();
        AccountType r5 = r2.getAccountType(r12.type, r12.dataSet);
        if (r5 == null) goto L12;
        if (r5.isExtension() == false) goto L12;
        if (r12.hasData(r22) == false) goto L3;
    L12:
        if (r5 == null) goto L14;
        Drawable r6 = r5.getDisplayIcon(r22);
    L15:
        Drawable r18 = r6;
        if (TextUtils.isEmpty(r12.type) == true) goto L3;
        if (r12.type.equals("com.android.sim") == false) goto L3;
        log("Start fetch sim phonebook, account.name = " + r12.name);
        int r15 = getAdnCount(MoreContactUtils.getSubscription(r12.type, r12.name));
        log("Finish fetch sim phonebook capacity = " + r15);
        if (r15 <= 0) goto L28;
        Cursor r7 = r10.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "account_name = '" + r12.name + "' AND deleted = 0", null, null);
        if (r7 == null) goto L28;
        r11 = r7.getCount();     // Catch: Throwable -> L25
        r7.close();
    L25:
        th = move-exception;
        r7.close();
        throw th;
    L28:
        log("Finish fetch sim phonebook count = " + r11);
        r1.add(new AccountListItem(this, r12.type, r12.name, r12.dataSet, r18, r15, r11));
        goto L3
    L14:
        r6 = null;
        goto L15
    L29:
        Cursor r8 = r10.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "deleted = 0 AND account_type <> 'com.android.sim'", null, null);
        if (r8 != null) goto L38;
    L36:
        int r13 = r11;
        log("Finish fetch phone contacts count = " + r13);
        r1.add(new AccountListItem(this, null, null, null, null, r13, r13));
        log("Finish loadAccountFilters");
        return r1;
    L38:
        r11 = r8.getCount();     // Catch: Throwable -> L33
        r8.close();
    L33:
        th = move-exception;
        r8.close();
        throw th;
    }

    public static int getSimCardMaxCount() {
        List<?> r0 = IIccPhoneBookUtil.getAdnRecordsInEf(IIccPhoneBookUtil.EF_ADN);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public static int getAdnCount(int r1) {
        if (r1 != (-1)) goto L7;
        return 0;
    L7:
        if (DSUtils.isMultiSimEnabled() == false) goto L11;
        return ReflectUtils.getMSimCardMaxCount(r1);
    L11:
        return getSimCardMaxCount();
    }

    private static void log(String r1) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_MemoryStatusActivity_com_obric_privacyhook_PrivacyHook_onCreate(MemoryStatusActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        MemoryStatusActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_MemoryStatusActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_MemoryStatusActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MemoryStatusActivity r1) {
        com_android_contacts_activities_MemoryStatusActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_activities_MemoryStatusActivity_com_obric_privacyhook_PrivacyHook_onResume(MemoryStatusActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        MemoryStatusActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_activities_MemoryStatusActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_MemoryStatusActivity_com_obric_privacyhook_PrivacyHook_onStop(MemoryStatusActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        MemoryStatusActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_MemoryStatusActivity__onStop$___twin___();
    }
}
