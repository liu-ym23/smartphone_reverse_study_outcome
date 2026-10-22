package com.android.contacts.list;

import android.app.LoaderManager;
import android.content.AsyncQueryHandler;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.PointerIconCompat;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.BytedanceAccountType;
import com.android.contacts.util.Constants;
import com.android.contacts.util.TitleBarUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.common.collect.Lists;
import com.obric.account.LocalAccountContactsUtils;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.OUIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccountFilterActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final int AVAILABLE_FILTERS_LOADER_ID = 0;
    private static final String TAG = "AccountFilterActivity";
    private final int TOKEN_QUERY_STATISTICS;
    private Map<ContactListFilter, Integer> mAccountStatisticsMap;
    private FilterListAdapter mFilterListAdapter;
    private ListView mListView;
    private Set<ContactListFilter> mSelectedFilters;
    private StatisticsQueryHandler mStatisticsQueryHandler;

    private static class AvailableFiltersLoader extends AsyncTaskLoader<List<ContactListFilter>> {
        private Context mContext;

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<ContactListFilter> loadInBackground() {
            return loadInBackground2();
        }

        public AvailableFiltersLoader(Context r1) {
            super(r1);
            this.mContext = r1;
        }

        @Override // android.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<ContactListFilter> loadInBackground2() {
            return AccountFilterActivity.access$300(this.mContext);
        }

        @Override // android.content.Loader
        protected void onStartLoading() {
            forceLoad();
        }

        @Override // android.content.Loader
        protected void onStopLoading() {
            cancelLoad();
        }

        @Override // android.content.Loader
        protected void onReset() {
            onStopLoading();
        }
    }

    private class FilterListAdapter extends BaseAdapter {
        private final AccountTypeManager mAccountTypes;
        private final Context mContext;
        private final List<ContactListFilter> mFilters;
        private final LayoutInflater mLayoutInflater;
        final /* synthetic */ AccountFilterActivity this$0;

        private class ViewHolder {
            OCardListItem cardListItem;
            final /* synthetic */ FilterListAdapter this$1;

            private ViewHolder(FilterListAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(FilterListAdapter r1, AnonymousClass1 r2) {
                this(r1);
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

        public FilterListAdapter(AccountFilterActivity r1, Context r2, List<ContactListFilter> r3) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mLayoutInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
            this.mFilters = r3;
            this.mAccountTypes = AccountTypeManager.getInstance(r2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mFilters.size();
        }

        @Override // android.widget.Adapter
        public ContactListFilter getItem(int r1) {
            return this.mFilters.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            int r10 = 0;
            if (r8 != null) goto L5;
        L8:
            r8 = this.mLayoutInflater.inflate(R.layout.contact_list_filter_item_bytedance, null, false);
            ViewHolder r0 = new ViewHolder(this, null);
            r0.cardListItem = (OCardListItem) r8.findViewById(R.id.list_item);
            r0.cardListItem.setCardPosition(0);
            r0.cardListItem.setCardType(0);
            r8.setTag(r0);
        L9:
            final ContactListFilter r1 = this.mFilters.get(r7);
            AccountType r2 = this.mAccountTypes.getAccountType(r1.accountType, r1.dataSet);
            if (LocalAccountContactsUtils.isLocalAccount(r1.accountName, r1.accountType) == false) goto L13;
            r0.cardListItem.setTitle(this.mContext.getString(R.string.local_account_filter_label));
            r0.cardListItem.setSubTitle(this.mContext.getString(R.string.local_account_filter_description));
        L16:
            r0.cardListItem.showSubTitle(true);
            r0.cardListItem.setDefaultCustomStartView(0);
            r0.cardListItem.showCustomStart(true);
            if (getCount() != 1) goto L19;
            r0.cardListItem.setCardPosition(0);
        L25:
            OCheckBoxLayout r3 = r0.cardListItem.getStartCheckBox();
            if (r3 == null) goto L28;
            OCheckBox r4 = r3.getCheckBox();
            r4.setChecked(AccountFilterActivity.access$400(this.this$0).contains(r1));
            r4.setOnCheckedChangeListener(new AnonymousClass1(this, r1));
        L28:
            r0.cardListItem.setDefaultCustomEndView(3);
            r0.cardListItem.showCustomEnd(true);
            OTextView r5 = r0.cardListItem.getEndDetail();
            Integer r6 = (Integer) AccountFilterActivity.access$100(this.this$0).get(r1);
            if (r6 == null) goto L33;
            String r11 = this.mContext.getResources().getQuantityString(R.plurals.person, r6.intValue(), new Object[]{r6});
            if (r5 == null) goto L35;
            r5.setText(r11);
        L35:
            View r12 = r8.findViewById(R.id.desc);
            if (r7 == (getCount() - 1)) goto L39;
            r10 = 8;
        L39:
            r12.setVisibility(r10);
            return r8;
        L33:
            if (r5 == null) goto L35;
            r5.setText("");
            goto L35
        L19:
            if (r7 != 0) goto L22;
            r0.cardListItem.setCardPosition(1);
            goto L25
        L22:
            if (r7 != (getCount() - 1)) goto L24;
            r0.cardListItem.setCardPosition(3);
            goto L25
        L24:
            r0.cardListItem.setCardPosition(2);
            goto L25
        L13:
            if ("com.android.sim".equals(r1.accountType) == false) goto L15;
            r0.cardListItem.setTitle(ContactsUtils.getAccountName(this.mContext, r1.accountType, r1.accountName));
            r0.cardListItem.setSubTitle(this.mContext.getString(R.string.sim_account_filter_description));
            goto L16
        L15:
            r0.cardListItem.setTitle(r2.getDisplayLabel(this.mContext));
            r0.cardListItem.setSubTitle(ContactsUtils.getAccountName(this.mContext, r1.accountType, r1.accountName));
            goto L16
        L5:
            if (r8.getTag() == null) goto L8;
            r0 = (ViewHolder) r8.getTag();
            goto L9
        }
    }

    private class MyLoaderCallbacks implements LoaderManager.LoaderCallbacks<List<ContactListFilter>> {
        final /* synthetic */ AccountFilterActivity this$0;

        @Override // android.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader<List<ContactListFilter>> r1) {
        }

        private MyLoaderCallbacks(AccountFilterActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MyLoaderCallbacks(AccountFilterActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<ContactListFilter>> r1, List<ContactListFilter> r2) {
            onLoadFinished2(r1, r2);
        }

        @Override // android.app.LoaderManager.LoaderCallbacks
        public Loader<List<ContactListFilter>> onCreateLoader(int r1, Bundle r2) {
            return new AvailableFiltersLoader(this.this$0);
        }

        /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
        public void onLoadFinished2(Loader<List<ContactListFilter>> r4, List<ContactListFilter> r5) {
            if (r5 != null) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(AccountFilterActivity.TAG, "Failed to load filters");
            return;
        L5:
            Iterator<ContactListFilter> r6 = r5.iterator();
            boolean r0 = false;
        L7:
            if (r6.hasNext() == false) goto L11;
            if (BytedanceAccountType.ACCOUNT_TYPE.equals(r6.next().accountType) == false) goto L7;
            r0 = true;
            goto L7
        L11:
            if (r0 == true) goto L14;
            r5.add(ContactListFilter.createAccountFilter(ContactsUtils.LOCAL_ACCOUNT_TYPE, "default", null));
        L14:
            if (AccountFilterActivity.access$400(this.this$0) != null) goto L16;
            AccountFilterActivity.access$402(this.this$0, new HashSet(r5));
        L16:
            AccountFilterActivity r7 = this.this$0;
            AccountFilterActivity r1 = this.this$0;
            AccountFilterActivity.access$002(r7, new FilterListAdapter(r1, r1, r5));
            AccountFilterActivity.access$500(this.this$0).setAdapter(AccountFilterActivity.access$000(this.this$0));
            AccountFilterActivity.access$600(this.this$0, r5);
        }
    }

    private class StatisticsQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ AccountFilterActivity this$0;

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r2, Object r3, Cursor r4) {
            super.onQueryComplete(r2, r3, r4);
            if (r2 != 1019) goto L15;
            if (r4 == null) goto L13;
            int r0 = 0;
            if (r4.moveToNext() == false) goto L9;
            r0 = r4.getInt(0);
        L9:
            ContactListFilter r5 = (ContactListFilter) r3;
            if (AccountFilterActivity.access$000(this.this$0) == null) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(AccountFilterActivity.TAG, "query statistics accountName:" + r5.accountName + " count:" + r0);
            AccountFilterActivity.access$100(this.this$0).put(r5, Integer.valueOf(r0));
            AccountFilterActivity.access$000(this.this$0).notifyDataSetChanged();
            return;
        L14:
            return;
        L13:
            return;
        }

        public StatisticsQueryHandler(AccountFilterActivity r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }
    }

    public void com_android_contacts_list_AccountFilterActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_list_AccountFilterActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_contacts_list_AccountFilterActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_list_AccountFilterActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public AccountFilterActivity() {
        this.TOKEN_QUERY_STATISTICS = PointerIconCompat.TYPE_ZOOM_OUT;
        this.mAccountStatisticsMap = new HashMap();
    }

    static /* synthetic */ FilterListAdapter access$000(AccountFilterActivity r0) {
        return r0.mFilterListAdapter;
    }

    static /* synthetic */ FilterListAdapter access$002(AccountFilterActivity r0, FilterListAdapter r1) {
        r0.mFilterListAdapter = r1;
        return r1;
    }

    static /* synthetic */ Map access$100(AccountFilterActivity r0) {
        return r0.mAccountStatisticsMap;
    }

    static /* synthetic */ List access$300(Context r0) {
        return loadAccountFilters(r0);
    }

    static /* synthetic */ Set access$400(AccountFilterActivity r0) {
        return r0.mSelectedFilters;
    }

    static /* synthetic */ Set access$402(AccountFilterActivity r0, Set r1) {
        r0.mSelectedFilters = r1;
        return r1;
    }

    static /* synthetic */ ListView access$500(AccountFilterActivity r0) {
        return r0.mListView;
    }

    static /* synthetic */ void access$600(AccountFilterActivity r0, List r1) {
        r0.queryStatistics(r1);
    }

    public void com_android_contacts_list_AccountFilterActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.contact_list_filter);
        UiUtils.setWindowColorStatusBar(this);
        configTitle();
        ListView r4 = (ListView) findViewById(R.id.listView);
        this.mListView = r4;
        r4.setOnItemClickListener(this);
        this.mSelectedFilters = ContactListFilterController.getInstance(this).getFilters();
        this.mStatisticsQueryHandler = new StatisticsQueryHandler(this, getContentResolver());
        OUIHelper.OUIList.setHeader(getLayoutInflater(), this.mListView, Integer.valueOf(OUIHelper.OUIList.getHeaderHeight112()));
        getLoaderManager().initLoader(0, null, new MyLoaderCallbacks(this, null));
    }

    public void com_android_contacts_list_AccountFilterActivity__onPause$___twin___() {
        super.onPause();
        ContactListFilterController.getInstance(this).setContactListFilter(this.mSelectedFilters, true);
    }

    private void configTitle() {
        Intent r0 = getIntent();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        ((OFloatingTitleBar) findViewById(R.id.otitlebar)).addStartAction(TitleBarUtil.getLeftRes(r1), -1, new AnonymousClass1(this));
        return;
    L5:
        if (r0.getBooleanExtra(Constants.EXTRA_FROM_SETTINGS, false) == false) goto L7;
        r1 = true;
        goto L7
    }

    private View getHeaderView() {
        TextView r0 = new TextView(this);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_content_top_bottom_margin)));
        return r0;
    }

    private static List<ContactListFilter> loadAccountFilters(Context r9) {
        ArrayList r0 = Lists.newArrayList();
        ArrayList r1 = Lists.newArrayList();
        AccountTypeManager r2 = AccountTypeManager.getInstance(r9);
        if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L5;
        List<AccountWithDataSet> r3 = r2.getAccountsIncludeSIM(false);
    L6:
        Iterator<AccountWithDataSet> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        AccountWithDataSet r5 = r4.next();
        String r6 = r5.type;
        String r7 = r5.name;
        if ("com.android.sim".equals(r5.type) == false) goto L12;
        String r8 = null;
    L13:
        r1.add(ContactListFilter.createAccountFilter(r6, r7, r8));
        goto L8
    L12:
        r8 = r5.dataSet;
        goto L13
    L14:
        r0.addAll(r1);
        ContactListFilter.storeAvailableAccountsToPreferences(r9, r3);
        return r0;
    L5:
        r3 = r2.getAccounts(false);
        goto L6
    }

    private void queryStatistics(List<ContactListFilter> r10) {
        Iterator<ContactListFilter> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ContactListFilter r3 = r11.next();
        if ("com.android.sim".equals(r3.accountType) == true) goto L7;
        Uri.Builder r0 = ContactsContract.Contacts.CONTENT_URI.buildUpon();
        r3.addAccountQueryParameterToUrl(r0);
        this.mStatisticsQueryHandler.startQuery(PointerIconCompat.TYPE_ZOOM_OUT, r3, r0.build(), new String[]{"_count"}, null, null, null);
        goto L4
    L7:
        this.mStatisticsQueryHandler.startQuery(PointerIconCompat.TYPE_ZOOM_OUT, r3, ContactsContract.Contacts.CONTENT_URI, new String[]{"_count"}, "account_type = ? AND account_name = ?", new String[]{r3.accountType, r3.accountName}, null);
        goto L4
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_list_AccountFilterActivity_com_obric_privacyhook_PrivacyHook_onCreate(AccountFilterActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AccountFilterActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_list_AccountFilterActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_list_AccountFilterActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AccountFilterActivity r1) {
        com_android_contacts_list_AccountFilterActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_list_AccountFilterActivity_com_obric_privacyhook_PrivacyHook_onPause(AccountFilterActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AccountFilterActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_list_AccountFilterActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_list_AccountFilterActivity_com_obric_privacyhook_PrivacyHook_onStop(AccountFilterActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AccountFilterActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_list_AccountFilterActivity__onStop$___twin___();
    }
}
