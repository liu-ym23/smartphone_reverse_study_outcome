package com.android.contacts.setting;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.layout.OUIRelativeLayout;
import com.obric.oui.titlebar.OCTitleBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TransferAccountsActivity extends Activity {
    private static final int REQUEST_CODE_GET_TRANSFER_RAWCONTACTS = 1008;
    private static final String TAG = "TransferAccountsActivity";
    private final String ACCOUNTNAME;
    private final String ACCOUNTTYPE;
    private final int TOKEN_QUERY_STATISTICS;
    private List<AccountWithDataSet> mAccountList;
    private Map<AccountWithDataSet, Integer> mAccountStatisticsMap;
    private AccountTypeManager mAccountTypes;
    private AccountWithDataSet mExcludeAccount;
    private ListView mListView;
    private AccountWithDataSet mOldSelectedAccount;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private boolean mPickRawContactsNeeded;
    private AccountWithDataSet mSelectedAccount;
    private StatisticsQueryHandler mStatisticsQueryHandler;
    private TransferAccountsAdapter mTransferAccountsAdapter;
    private ArrayList<Long> mTransferRawContactsIds;

    private class StatisticsQueryHandler extends AsyncQueryHandler {
        final /* synthetic */ TransferAccountsActivity this$0;

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r2, Object r3, Cursor r4) {
            super.onQueryComplete(r2, r3, r4);
            if (r2 != 1009) goto L12;
            if (r4 == null) goto L11;
            int r0 = 0;
            if (r4.moveToNext() == false) goto L9;
            r0 = r4.getInt(0);
        L9:
            Map r5 = TransferAccountsActivity.access$800(this.this$0);
            r5.put((AccountWithDataSet) r3, Integer.valueOf(r0));
            TransferAccountsActivity.access$900(this.this$0).notifyDataSetChanged();
            return;
        L11:
            return;
        }

        public StatisticsQueryHandler(TransferAccountsActivity r1, ContentResolver r2) {
            this.this$0 = r1;
            super(r2);
        }
    }

    private class TransferAccountsAdapter extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ TransferAccountsActivity this$0;

        private class ViewHolder {
            ImageView arrow;
            ImageView iconView;
            OUIRelativeLayout item;
            TextView summary;
            final /* synthetic */ TransferAccountsAdapter this$1;
            TextView titleView;

            private ViewHolder(TransferAccountsAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(TransferAccountsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return 0;
        }

        public TransferAccountsAdapter(TransferAccountsActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return TransferAccountsActivity.access$000(this.this$0).size();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r2) {
            if (TransferAccountsActivity.access$000(this.this$0).get(r2) != null) goto L5;
            return true;
        L5:
            if (((AccountWithDataSet) TransferAccountsActivity.access$000(this.this$0).get(r2)).equals(TransferAccountsActivity.access$500(this.this$0)) == false) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r8, View r9, ViewGroup r10) {
            if (r9 != null) goto L5;
        L8:
            r9 = LayoutInflater.from(this.mContext).inflate(R.layout.transfer_account_item_layout, null, false);
            ViewHolder r0 = new ViewHolder(this, null);
            r0.item = (OUIRelativeLayout) r9.findViewById(R.id.item);
            r0.iconView = (ImageView) r9.findViewById(R.id.item_icon);
            r0.titleView = (TextView) r9.findViewById(R.id.item_title);
            r0.summary = (TextView) r9.findViewById(R.id.item_summary);
            r0.arrow = (ImageView) r9.findViewById(R.id.item_arrow);
            r9.setTag(r0);
        L9:
            AccountWithDataSet r11 = (AccountWithDataSet) TransferAccountsActivity.access$000(this.this$0).get(r8);
            AccountType r1 = TransferAccountsActivity.access$700(this.this$0).getAccountType(r11.type, r11.dataSet);
            r0.titleView.setText(r1.getDisplayLabel(this.mContext));
            r0.iconView.setImageDrawable(r1.getDisplayIcon(this.mContext));
            Integer r2 = (Integer) TransferAccountsActivity.access$800(this.this$0).get(r11);
            if (r2 == null) goto L17;
            String r3 = this.this$0.getResources().getQuantityString(R.plurals.account_total_contacts, r2.intValue(), new Object[]{r2});
            if (r11.equals(TransferAccountsActivity.access$300(this.this$0)) == true) goto L14;
        L16:
            r0.summary.setText(r3);
            r0.summary.setVisibility(0);
        L19:
            if (r11.equals(TransferAccountsActivity.access$500(this.this$0)) == false) goto L21;
            r9.setEnabled(false);
        L22:
            return r9;
        L21:
            r9.setEnabled(true);
            goto L22
        L14:
            if (TransferAccountsActivity.access$400(this.this$0) == null) goto L16;
            r3 = (r3 + this.this$0.getString(R.string.symbol_comma)) + this.this$0.getResources().getQuantityString(R.plurals.account_statistics_summary, TransferAccountsActivity.access$400(this.this$0).size(), new Object[]{Integer.valueOf(TransferAccountsActivity.access$400(this.this$0).size())});
            goto L16
        L17:
            r0.summary.setVisibility(4);
            goto L19
        L5:
            if (r9.getTag() == null) goto L8;
            r0 = (ViewHolder) r9.getTag();
            goto L9
        }
    }

    public void com_android_contacts_setting_TransferAccountsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_setting_TransferAccountsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public TransferAccountsActivity() {
        this.ACCOUNTTYPE = "ACCOUNTTYPE";
        this.ACCOUNTNAME = "ACCOUNTNAME";
        this.TOKEN_QUERY_STATISTICS = 1009;
        this.mAccountStatisticsMap = new HashMap();
        this.mPickRawContactsNeeded = false;
        this.mOnItemClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ List access$000(TransferAccountsActivity r0) {
        return r0.mAccountList;
    }

    static /* synthetic */ AccountWithDataSet access$100(TransferAccountsActivity r0) {
        return r0.mSelectedAccount;
    }

    static /* synthetic */ AccountWithDataSet access$102(TransferAccountsActivity r0, AccountWithDataSet r1) {
        r0.mSelectedAccount = r1;
        return r1;
    }

    static /* synthetic */ boolean access$200(TransferAccountsActivity r0) {
        return r0.mPickRawContactsNeeded;
    }

    static /* synthetic */ AccountWithDataSet access$300(TransferAccountsActivity r0) {
        return r0.mOldSelectedAccount;
    }

    static /* synthetic */ ArrayList access$400(TransferAccountsActivity r0) {
        return r0.mTransferRawContactsIds;
    }

    static /* synthetic */ AccountWithDataSet access$500(TransferAccountsActivity r0) {
        return r0.mExcludeAccount;
    }

    static /* synthetic */ AccountTypeManager access$700(TransferAccountsActivity r0) {
        return r0.mAccountTypes;
    }

    static /* synthetic */ Map access$800(TransferAccountsActivity r0) {
        return r0.mAccountStatisticsMap;
    }

    static /* synthetic */ TransferAccountsAdapter access$900(TransferAccountsActivity r0) {
        return r0.mTransferAccountsAdapter;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.transfer_accounts_layout);
        UiUtils.setWindowColorStatusBar(this);
        this.mListView = (ListView) findViewById(R.id.listView);
        configTitle();
        View r5 = LayoutInflater.from(this).inflate(R.layout.contact_list_view_header, null);
        this.mListView.addHeaderView(r5);
        this.mAccountTypes = AccountTypeManager.getInstance(this);
        this.mTransferAccountsAdapter = new TransferAccountsAdapter(this, this);
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.mStatisticsQueryHandler = new StatisticsQueryHandler(this, getContentResolver());
        Intent r0 = getIntent();
        TextView r6 = (TextView) r5.findViewById(R.id.header_text_view);
        if (r0 != null) goto L5;
        return;
    L5:
        if ("src".equals(r0.getStringExtra("transfer_direction")) == false) goto L7;
        this.mPickRawContactsNeeded = true;
        r6.setText(getString(R.string.select_export_account));
        this.mOldSelectedAccount = (AccountWithDataSet) r0.getParcelableExtra("old_src_account");
        this.mTransferRawContactsIds = (ArrayList) r0.getExtra("com.android.contacts.extra.PHONE_IDS");
    L8:
        this.mExcludeAccount = (AccountWithDataSet) r0.getParcelableExtra("exclude_account");
        return;
    L7:
        r6.setText(getString(R.string.select_import_account));
        goto L8
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mAccountList = this.mAccountTypes.getAccounts(true);
        this.mListView.setEmptyView(findViewById(R.id.emptyView));
        this.mListView.setAdapter(this.mTransferAccountsAdapter);
        List<AccountWithDataSet> r0 = this.mAccountList;
        if (r0 == null) goto L8;
        Iterator<AccountWithDataSet> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        queryStatistics(r1.next());
        goto L6
    L10:
        return;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 != 1008) goto L10;
        this.mTransferRawContactsIds = (ArrayList) r4.getExtra("com.android.contacts.extra.PHONE_IDS");
        Intent r5 = new Intent();
        r5.putExtra("transfer_rawcontacts", this.mTransferRawContactsIds);
        r5.putExtra("src_account", this.mSelectedAccount);
        setResult(-1, r5);
        finish();
        return;
    }

    private void configTitle() {
        ((OCTitleBar) findViewById(R.id.otitlebar)).getMLeftActionBack().setOnClickListener(new AnonymousClass1(this));
    }

    private void queryStatistics(AccountWithDataSet r11) {
        if (TextUtils.isEmpty(r11.dataSet) == false) goto L5;
        String[] r0 = {r11.name, r11.type};
        String r1 = "deleted != 1 AND account_name = ? AND account_type = ? AND data_set IS NULL";
    L6:
        StatisticsQueryHandler r2 = this.mStatisticsQueryHandler;
        Uri r5 = ContactsContract.RawContacts.CONTENT_URI;
        String[] r6 = {"_count"};
        r2.startQuery(1009, r11, r5, r6, r1, r0, null);
        return;
    L5:
        r0 = new String[]{r11.name, r11.type, r11.dataSet};
        r1 = "deleted != 1 AND account_name = ? AND account_type = ? AND data_set = ?";
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_setting_TransferAccountsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TransferAccountsActivity r1) {
        r1.com_android_contacts_setting_TransferAccountsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
