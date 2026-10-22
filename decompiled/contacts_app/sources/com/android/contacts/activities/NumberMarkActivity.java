package com.android.contacts.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import com.android.contacts.BaseActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.editor.LabeledEditorView;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.DialogUtils;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.utils.ViewAnimationUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class NumberMarkActivity extends BaseActivity {
    public static final String EXTRA_PARAM_MARKED = "EXTRA_PARAM_MARKED";
    public static final String EXTRA_PARAM_NUMBER = "EXTRA_PARAM_NUMBER";
    private List<Integer> classifyResIds;
    private List<String> classifyTexts;
    private boolean isFinish;
    private Activity mActivity;
    private OSimpleFormDialog mDialog;
    private ViewGroup mFlagActionView;
    private ViewGroup mFlageView;
    private ListView mListView;

    private class NumberMarkAdapter extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ NumberMarkActivity this$0;

        private class ViewHolder {
            OCardListItem item;
            final /* synthetic */ NumberMarkAdapter this$1;

            private ViewHolder(NumberMarkAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(NumberMarkAdapter r1, AnonymousClass1 r2) {
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

        public NumberMarkAdapter(NumberMarkActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return NumberMarkActivity.access$300(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public View getView(final int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
        L7:
            r6 = LayoutInflater.from(this.mContext).inflate(R.layout.number_mark_item_layout, r7, false);
            ViewHolder r8 = new ViewHolder(this, null);
            r8.item = (OCardListItem) r6.findViewById(R.id.item);
            r6.setTag(r8);
        L9:
            if (r5 != 0) goto L12;
            r8.item.setCardPosition(1);
        L15:
            OCardListItem r1 = r8.item;
            NumberMarkActivity r2 = this.this$0;
            r1.setIcon(r2.getDrawable(((Integer) NumberMarkActivity.access$500(r2).get(r5)).intValue()));
            r8.item.showIcon(true);
            r8.item.getIconView().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r8.item.setTitle((CharSequence) NumberMarkActivity.access$300(this.this$0).get(r5));
            r8.item.setOnContentClickListener(new AnonymousClass1(this, r5));
            return r6;
        L12:
            if (r5 != (getCount() - 1)) goto L14;
            r8.item.setCardPosition(3);
            goto L15
        L14:
            r8.item.setCardPosition(2);
            goto L15
        L4:
            if (r6.getTag() == null) goto L7;
            r8 = (ViewHolder) r6.getTag();
            goto L9
        }
    }

    public void com_android_contacts_activities_NumberMarkActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_NumberMarkActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public NumberMarkActivity() {
        this.classifyTexts = new ArrayList();
        this.classifyResIds = new ArrayList();
        this.isFinish = false;
    }

    static /* synthetic */ boolean access$002(NumberMarkActivity r0, boolean r1) {
        r0.isFinish = r1;
        return r1;
    }

    static /* synthetic */ Activity access$100(NumberMarkActivity r0) {
        return r0.mActivity;
    }

    static /* synthetic */ OSimpleFormDialog access$200(NumberMarkActivity r0) {
        return r0.mDialog;
    }

    static /* synthetic */ List access$300(NumberMarkActivity r0) {
        return r0.classifyTexts;
    }

    static /* synthetic */ List access$500(NumberMarkActivity r0) {
        return r0.classifyResIds;
    }

    static /* synthetic */ void access$600(NumberMarkActivity r0, int r1) {
        r0.ItemClick(r1);
    }

    public void com_android_contacts_activities_NumberMarkActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        overridePendingTransition(0, 0);
        setContentView(R.layout.number_mark_activity);
        UiUtils.setWindowColorStatusBar(this);
        DialogUtils.clearDimBeforeDialogShow(this);
        this.mActivity = this;
        configTitle();
        NumberInfosManager.Classify[] r0 = NumberInfosManager.Classify.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        NumberInfosManager.Classify r3 = r0[r2];
        if (r3.ordinal() > NumberInfosManager.Classify.CUSTOMIZE.ordinal()) goto L8;
        this.classifyTexts.add(r3.getClassifyText());
        this.classifyResIds.add(Integer.valueOf(r3.getClassifySelector()));
        r2 = r2 + 1;
    L8:
        this.mFlageView = (ViewGroup) findViewById(R.id.contact_flag_view);
        this.mFlagActionView = (ViewGroup) findViewById(R.id.contacts_flag_action_container);
        this.mListView = (ListView) findViewById(R.id.listView);
        ViewAnimationUtils.INSTANCE.showPageAnimationWithBGAlpha(this.mFlageView, this.mFlagActionView, ContextCompat.getColor(getBaseContext(), R.color.oui_advanced_scrim_sheet));
        this.mListView.addHeaderView(getHeaderView(getIntent().getBooleanExtra(EXTRA_PARAM_MARKED, false)));
        this.mListView.setAdapter(new NumberMarkAdapter(this, this));
    }

    private void configTitle() {
        ((OFloatingTitleBar) findViewById(R.id.otitlebar)).addEndAction(R.drawable.icon_cancel_22_22, -1, new AnonymousClass1(this));
    }

    public void com_android_contacts_activities_NumberMarkActivity__onPause$___twin___() {
        super.onPause();
        OSimpleFormDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mDialog.dismiss();
        return;
    }

    public void com_android_contacts_activities_NumberMarkActivity__finish$___twin___() {
        if (this.isFinish == false) goto L5;
        super.finish();
        overridePendingTransition(0, 0);
        return;
    L5:
        OSimpleFormDialog r0 = this.mDialog;
        if (r0 != null) goto L8;
    L10:
        ViewAnimationUtils.INSTANCE.hidePageAnimationWithBGAlpha(this.mFlageView, this.mFlagActionView, ContextCompat.getColor(getBaseContext(), R.color.oui_advanced_scrim_sheet), new AnonymousClass2(this));
        return;
    L8:
        if (r0.isShowing() == false) goto L10;
        this.mDialog.dismiss();
        goto L10
    }

    private View getHeaderView(boolean r7) {
        View r0 = LayoutInflater.from(this).inflate(R.layout.number_mark_item_layout, this.mListView, false);
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.item);
        r1.setCardType(2);
        r1.setCardPosition(0);
        TextView r2 = new TextView(this);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, OUnitExtensionKt.dp2px(48)));
        r2.setGravity(17);
        r2.setText(R.string.common_untag);
        r2.setTextColor(getColor(R.color.oui_blue_6));
        r2.setTextAppearance(this, R.style.Title_1_Medium);
        r1.setCustomStartView(r2);
        ViewKt.updateLayoutParams(r1, new AnonymousClass3(this));
        if (r7 == true) goto L5;
        r1.setVisibility(8);
    L5:
        r1.setOnContentClickListener(new AnonymousClass4(this));
        return r0;
    }

    private void ItemClick(int r15) {
        if (this.mActivity != null) goto L5;
        return;
    L5:
        if (ContactsUtils.isJustClicked() == true) goto L17;
        Intent r0 = new Intent();
        final String r1 = getIntent().getStringExtra(EXTRA_PARAM_NUMBER);
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r0.putExtra(EXTRA_PARAM_NUMBER, r1);
    L11:
        if (r15 != (this.classifyTexts.size() - 1)) goto L13;
        OSimpleFormDialog r2 = OUIDialogHelper.getSimpleFormDialog(this, getString(R.string.common_custom_marker_content), "", getString(R.string.common_ok), getString(R.string.common_cancel), getString(R.string.edit_custom_mark_hint), "", false, new AnonymousClass5(this, r15, r1), new AnonymousClass6(this, r15));
        final OSimpleFormDialog[] r16 = {r2};
        this.mDialog = r2;
        OEditText r17 = r2.getInputView1().getVInput();
        r17.setInputType(LabeledEditorView.INPUT_TYPE_CUSTOM);
        r17.setSaveEnabled(true);
        this.mDialog.setCancelable(true);
        this.mDialog.setAutoDismiss(false);
        this.mDialog.getPositiveButton().setEnabled(false);
        r17.addTextChangedListener(new AnonymousClass7(this));
        this.mDialog.show();
        return;
    L13:
        r0.putExtra("position", r15);
        setResult(-1, r0);
        this.mActivity.finish();
        return;
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r4) {
        ListView r5 = this.mListView;
        if (r5 == null) goto L6;
        ViewKt.updatePadding(r5, r5.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getPaddingRight(), OUnitExtensionKt.dp2px(32));
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_onCreate(NumberMarkActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        NumberMarkActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_NumberMarkActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_NumberMarkActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NumberMarkActivity r1) {
        com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_onPause(NumberMarkActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        NumberMarkActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_android_contacts_activities_NumberMarkActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_onStop(NumberMarkActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        NumberMarkActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_NumberMarkActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_android_contacts_activities_NumberMarkActivity_com_obric_privacyhook_PrivacyHook_finish(NumberMarkActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        NumberMarkActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_android_contacts_activities_NumberMarkActivity__finish$___twin___();
    }
}
