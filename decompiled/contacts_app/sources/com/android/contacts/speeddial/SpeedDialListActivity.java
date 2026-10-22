package com.android.contacts.speeddial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.util.Constants;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SpeedDialListActivity extends ContactsActivity implements AdapterView.OnItemClickListener {
    private SparseArray<SpeedDialUtils.SpeedDialRecord> SpeedDialRecords;
    private SpeedDialAdapter mListAdapter;
    private ListView mListView;

    private class SpeedDialAdapter extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ SpeedDialListActivity this$0;

        private class ViewHolder {
            TextView labelView;
            TextView numberView;
            final /* synthetic */ SpeedDialAdapter this$1;

            private ViewHolder(SpeedDialAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(SpeedDialAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        public int getBackgroundRes(int r1, int r2) {
            if (r1 != 1) goto L6;
            return R.drawable.detail_item_single_bg;
        L6:
            if (r2 != 0) goto L10;
            return R.drawable.detail_item_top_bg;
        L10:
            if (r2 != (r1 - 1)) goto L13;
            return R.drawable.detail_item_bottom_bg;
        L13:
            return R.drawable.detail_item_middle_bg;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return null;
        }

        public SpeedDialAdapter(SpeedDialListActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SpeedDialListActivity.access$000(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return SpeedDialListActivity.access$000(this.this$0).keyAt(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
        L7:
            r4 = LayoutInflater.from(this.mContext).inflate(R.layout.speed_dial_list_item, null, false);
            ViewHolder r6 = new ViewHolder(this, null);
            r6.labelView = (TextView) r4.findViewById(R.id.speed_dial_label);
            r6.numberView = (TextView) r4.findViewById(R.id.speed_dial_number);
            r4.setTag(r6);
        L8:
            r6.labelView.setText(String.valueOf(SpeedDialListActivity.access$000(this.this$0).keyAt(r3)));
            SpeedDialUtils.SpeedDialRecord r0 = (SpeedDialUtils.SpeedDialRecord) SpeedDialListActivity.access$000(this.this$0).valueAt(r3);
            TextView r7 = r6.numberView;
            if (TextUtils.isEmpty(r0.phoneNumber) == false) goto L11;
            String r1 = "";
        L12:
            r7.setText(r1);
            r4.setBackgroundResource(getBackgroundRes(SpeedDialListActivity.access$000(this.this$0).size(), r3));
            return r4;
        L11:
            r1 = r0.phoneNumber;
            goto L12
        L4:
            if (r4.getTag() == null) goto L7;
            r6 = (ViewHolder) r4.getTag();
            goto L8
        }
    }

    public void com_android_contacts_speeddial_SpeedDialListActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_speeddial_SpeedDialListActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_speeddial_SpeedDialListActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_speeddial_SpeedDialListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SpeedDialListActivity() {
        this.SpeedDialRecords = new SparseArray(8);
    }

    static /* synthetic */ SparseArray access$000(SpeedDialListActivity r0) {
        return r0.SpeedDialRecords;
    }

    public void com_android_contacts_speeddial_SpeedDialListActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        setContentView(R.layout.activity_speed_dial_list);
        UiUtils.setWindowColorStatusBar(this);
        ListView r3 = (ListView) findViewById(R.id.listView);
        this.mListView = r3;
        r3.addHeaderView(getHeaderView());
        this.mListView.setOnItemClickListener(this);
        SpeedDialAdapter r4 = new SpeedDialAdapter(this, this);
        this.mListAdapter = r4;
        this.mListView.setAdapter(r4);
        ((OCTitleBar) findViewById(R.id.otitlebar)).getMLeftActionBack().setOnClickListener(new AnonymousClass1(this));
    }

    public void com_android_contacts_speeddial_SpeedDialListActivity__onResume$___twin___() {
        super.onResume();
        loadSpeedDialRecords();
    }

    private void loadSpeedDialRecords() {
        int r0 = 2;
    L4:
        if (r0 > 9) goto L9;
        SpeedDialUtils.checkValidity(this, r0);
        String r1 = SpeedDialUtils.getPhoneNumber(this, r0);
        long r2 = SpeedDialUtils.getContactId(this, r0);
        if (r2 == (-1)) goto L8;
        this.SpeedDialRecords.put(r0, new SpeedDialUtils.SpeedDialRecord(r1, r2));
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        this.mListAdapter.notifyDataSetChanged();
    }

    private View getHeaderView() {
        TextView r0 = new TextView(this);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_content_top_bottom_margin)));
        return r0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        Intent r5 = new Intent(this, SpeedDialSettingActivity.class);
        r5.putExtra(SpeedDialSettingActivity.EXTRA_NUMBER, this.SpeedDialRecords.keyAt(r3 - 1));
        r5.putExtra(Constants.EXTRA_FROM_SETTINGS, true);
        startActivity(r5);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_speeddial_SpeedDialListActivity_com_obric_privacyhook_PrivacyHook_onCreate(SpeedDialListActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SpeedDialListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_speeddial_SpeedDialListActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_speeddial_SpeedDialListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SpeedDialListActivity r1) {
        com_android_contacts_speeddial_SpeedDialListActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_speeddial_SpeedDialListActivity_com_obric_privacyhook_PrivacyHook_onResume(SpeedDialListActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SpeedDialListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_speeddial_SpeedDialListActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_speeddial_SpeedDialListActivity_com_obric_privacyhook_PrivacyHook_onStop(SpeedDialListActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        SpeedDialListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_speeddial_SpeedDialListActivity__onStop$___twin___();
    }
}
