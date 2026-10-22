package com.android.contacts.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactsActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.group.GroupBrowseListAdapter;
import com.android.contacts.group.GroupBrowseListFragment;
import com.android.contacts.group.GroupListItem;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.util.UiUtils;
import com.android.contacts.widget.SelectAllState;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.utils.views.ObricBottomDeleteBarView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: GroupBrowseListActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/contacts/activities/GroupBrowseListActivity;", "Lcom/android/contacts/ContactsActivity;", "()V", "mBottomBarFrame", "Landroid/widget/FrameLayout;", "mBottomDeleteBar", "Lcom/obric/utils/views/ObricBottomDeleteBarView;", "mBottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "mFragmentsCallback", "Lcom/android/contacts/ContactFragmentsCallback;", "mGroupBrowseListFragment", "Lcom/android/contacts/group/GroupBrowseListFragment;", "mGroupSelectAllState", "Lcom/android/contacts/widget/SelectAllState;", "mTitleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "cancelEdit", "", "onAddGroupClicked", "onClickDelete", "onClickEdit", "onClickSelectAll", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "onStatusBarHeightChanged", "OnGroupActionListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GroupBrowseListActivity extends ContactsActivity {
    private FrameLayout mBottomBarFrame;
    private ObricBottomDeleteBarView mBottomDeleteBar;
    private final BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private final ContactFragmentsCallback mFragmentsCallback;
    private GroupBrowseListFragment mGroupBrowseListFragment;
    private SelectAllState mGroupSelectAllState;
    private OFloatingTitleBarHolder mTitleBarHolder;

    /* JADX INFO: compiled from: GroupBrowseListActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/activities/GroupBrowseListActivity$OnGroupActionListener;", "Lcom/android/contacts/group/GroupBrowseListFragment$OnGroupBrowserActionListener;", "(Lcom/android/contacts/activities/GroupBrowseListActivity;)V", "onChooseGroup", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "onDataBinded", "onGroupDelete", "onViewGroupAction", "groupUri", "Landroid/net/Uri;", "setCanEdit", "isCanEdit", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class OnGroupActionListener implements GroupBrowseListFragment.OnGroupBrowserActionListener {
        final /* synthetic */ GroupBrowseListActivity this$0;

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onDataBinded() {
        }

        public OnGroupActionListener(GroupBrowseListActivity r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onViewGroupAction(Uri r4) {
            Intent r0 = new Intent(this.this$0, GroupBrowserActivity.class);
            r0.setData(r4);
            this.this$0.startActivity(r0);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onChooseGroup(int r5) {
            BottomDeleteLayoutListener r0 = GroupBrowseListActivity.access$getMBottomDeleteLayoutListener$p(this.this$0);
            if (r5 <= 0) goto L5;
            boolean r3 = true;
        L6:
            r0.setBottomBtnEnable(r3);
            if (GroupBrowseListActivity.access$getMGroupBrowseListFragment$p(this.this$0) == null) goto L37;
            GroupBrowseListFragment r1 = GroupBrowseListActivity.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r1 == null) goto L11;
            GroupBrowseListAdapter r2 = r1.getAdapter();
        L12:
            if (r2 == null) goto L37;
            if (GroupBrowseListActivity.access$getMGroupSelectAllState$p(this.this$0) == null) goto L37;
            GroupBrowseListFragment r4 = GroupBrowseListActivity.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r4 == null) goto L22;
            GroupBrowseListAdapter r6 = r4.getAdapter();
            if (r6 == null) goto L22;
            ArrayList<GroupListItem> r7 = r6.getGroupList();
            if (r7 == null) goto L22;
            int r8 = r7.size();
        L23:
            GroupBrowseListFragment r9 = GroupBrowseListActivity.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r9 == null) goto L28;
            GroupBrowseListAdapter r10 = r9.getAdapter();
            if (r10 == null) goto L28;
            int r11 = r10.getReadOnlyItemSize();
        L29:
            int r12 = r8 - r11;
            SelectAllState r13 = GroupBrowseListActivity.access$getMGroupSelectAllState$p(this.this$0);
            if (r13 == null) goto L37;
            if (r5 <= 0) goto L35;
            if (r12 != r5) goto L35;
            boolean r14 = true;
        L36:
            r13.setSelectAll(r14);
        L35:
            r14 = false;
        L28:
            r11 = 0;
        L22:
            r8 = 0;
            goto L23
        L11:
            r2 = null;
        L37:
            String r15 = this.this$0.getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r5)});
            Intrinsics.checkNotNullExpressionValue(r15, "getString(R.string.delet…ected_item_numbers, size)");
            OFloatingTitleBarHolder r16 = GroupBrowseListActivity.access$getMTitleBarHolder$p(this.this$0);
            if (r16 == null) goto L43;
            OFloatingTitleBar r17 = r16.getTitleBar();
            if (r17 == null) goto L44;
            r17.setCenterTitle(r15);
            return;
        L44:
            return;
        L43:
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onGroupDelete() {
            GroupBrowseListActivity.access$cancelEdit(this.this$0);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void setCanEdit(boolean r2) {
            if (r2 == true) goto L10;
            OFloatingTitleBarHolder r3 = GroupBrowseListActivity.access$getMTitleBarHolder$p(this.this$0);
            if (r3 == null) goto L6;
            r3.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
        L6:
            GroupBrowseListFragment r1 = GroupBrowseListActivity.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r1 == null) goto L11;
            r1.setGroupEdit(false);
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3I8zxtb-OZE6LD-3z72CKr1XubQ, reason: not valid java name */
    public static /* synthetic */ void m124$r8$lambda$3I8zxtbOZE6LD3z72CKr1XubQ(GroupBrowseListActivity r0, View r1) {
        onCreate$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$6I_O534RFVP8EcltduUHzTgTODQ(GroupBrowseListActivity r0, View r1) {
        onCreate$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$axPmQvgMl7SNYoygOEfs7_mr8_U(GroupBrowseListActivity r0, View r1) {
        onCreate$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$irDgc3nm1LjRXXW2Jnqh5RrmLJs(GroupBrowseListActivity r0, View r1) {
        onCreate$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jacQu68a1-Jubw6_W4hj8y1DRcU, reason: not valid java name */
    public static /* synthetic */ void m125$r8$lambda$jacQu68a1Jubw6_W4hj8y1DRcU(GroupBrowseListActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$x3pr2zfjU6PgKrsdRtYIVnLK4X0(GroupBrowseListActivity r0, View r1) {
        onCreate$lambda$3(r0, r1);
    }

    public void com_android_contacts_activities_GroupBrowseListActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_GroupBrowseListActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_activities_GroupBrowseListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public GroupBrowseListActivity() {
        this.mFragmentsCallback = new ContactFragmentsCallback(this);
        this.mBottomDeleteLayoutListener = new GroupBrowseListActivity$mBottomDeleteLayoutListener$1(this);
    }

    public static final /* synthetic */ void access$cancelEdit(GroupBrowseListActivity r0) {
        r0.cancelEdit();
    }

    public static final /* synthetic */ FrameLayout access$getMBottomBarFrame$p(GroupBrowseListActivity r0) {
        return r0.mBottomBarFrame;
    }

    public static final /* synthetic */ ObricBottomDeleteBarView access$getMBottomDeleteBar$p(GroupBrowseListActivity r0) {
        return r0.mBottomDeleteBar;
    }

    public static final /* synthetic */ BottomDeleteLayoutListener access$getMBottomDeleteLayoutListener$p(GroupBrowseListActivity r0) {
        return r0.mBottomDeleteLayoutListener;
    }

    public static final /* synthetic */ GroupBrowseListFragment access$getMGroupBrowseListFragment$p(GroupBrowseListActivity r0) {
        return r0.mGroupBrowseListFragment;
    }

    public static final /* synthetic */ SelectAllState access$getMGroupSelectAllState$p(GroupBrowseListActivity r0) {
        return r0.mGroupSelectAllState;
    }

    public static final /* synthetic */ OFloatingTitleBarHolder access$getMTitleBarHolder$p(GroupBrowseListActivity r0) {
        return r0.mTitleBarHolder;
    }

    public void com_android_contacts_activities_GroupBrowseListActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.activity_group_browse_list);
        UiUtils.setWindowColorStatusBar(this);
        getWindow().setBackgroundDrawable(null);
        this.mBottomBarFrame = (FrameLayout) findViewById(R.id.bottom_bar_frame);
        ObricBottomDeleteBarView r7 = (ObricBottomDeleteBarView) findViewById(R.id.bottom_delete_bar);
        this.mBottomDeleteBar = r7;
        if (r7 == null) goto L7;
        OButtonFloating r8 = r7.getDeleteBtn();
        if (r8 == null) goto L7;
        r8.setOnClickListener(new GroupBrowseListActivity$$ExternalSyntheticLambda0(this));
    L7:
        OFloatingTitleBar r9 = (OFloatingTitleBar) findViewById(R.id.otitlebar);
        Intrinsics.checkNotNull(r9);
        OFloatingTitleBarHolder r1 = new OFloatingTitleBarHolder(r9);
        this.mTitleBarHolder = r1;
        r1.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_back_22_22, new GroupBrowseListActivity$$ExternalSyntheticLambda1(this));
        OFloatingTitleBarHolder r10 = this.mTitleBarHolder;
        if (r10 == null) goto L10;
        r10.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_common_add_selector, new GroupBrowseListActivity$$ExternalSyntheticLambda2(this));
    L10:
        OFloatingTitleBarHolder r11 = this.mTitleBarHolder;
        if (r11 == null) goto L13;
        r11.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_multi_select_selector, new GroupBrowseListActivity$$ExternalSyntheticLambda3(this));
    L13:
        OFloatingTitleBarHolder r12 = this.mTitleBarHolder;
        if (r12 == null) goto L16;
        r12.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new GroupBrowseListActivity$$ExternalSyntheticLambda4(this));
    L16:
        OFloatingTitleBarHolder r13 = this.mTitleBarHolder;
        if (r13 == null) goto L19;
        String r3 = getResources().getString(R.string.select_all);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(R.string.select_all)");
        View r14 = r13.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, r3, new GroupBrowseListActivity$$ExternalSyntheticLambda5(this));
    L21:
        if ((r14 instanceof ViewGroup) == false) goto L23;
        ViewGroup r15 = (ViewGroup) r14;
    L24:
        if (r15 == null) goto L26;
        View r16 = r15.getChildAt(0);
    L28:
        if ((r16 instanceof OTextView) == false) goto L30;
        OTextView r17 = (OTextView) r16;
    L31:
        if (r17 == null) goto L33;
        r17.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        this.mGroupSelectAllState = new SelectAllState(r17);
    L33:
        OFloatingTitleBarHolder r18 = this.mTitleBarHolder;
        if (r18 == null) goto L36;
        r18.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
    L36:
        GroupBrowseListFragment r19 = new GroupBrowseListFragment();
        this.mGroupBrowseListFragment = r19;
        r19.setFragmentsCallback(this.mFragmentsCallback);
        GroupBrowseListFragment r20 = this.mGroupBrowseListFragment;
        Intrinsics.checkNotNull(r20);
        r20.setListener(new OnGroupActionListener(this));
        FragmentTransaction r21 = getSupportFragmentManager().beginTransaction();
        GroupBrowseListFragment r5 = this.mGroupBrowseListFragment;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.android.contacts.group.GroupBrowseListFragment");
        r21.add(R.id.fragment_container, r5).commit();
        return;
    L30:
        r17 = null;
        goto L31
    L26:
        r16 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r14 = null;
        goto L21
    }

    private static final void onCreate$lambda$0(GroupBrowseListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClickDelete();
    }

    private static final void onCreate$lambda$1(GroupBrowseListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void onCreate$lambda$2(GroupBrowseListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onAddGroupClicked();
    }

    private static final void onCreate$lambda$3(GroupBrowseListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClickEdit();
    }

    private static final void onCreate$lambda$4(GroupBrowseListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.cancelEdit();
    }

    private static final void onCreate$lambda$5(GroupBrowseListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClickSelectAll();
    }

    private final void onClickDelete() {
        GroupBrowseListFragment r0 = this.mGroupBrowseListFragment;
        if (r0 == null) goto L6;
        r0.deleteCheckedGroups();
        return;
    }

    private final void onAddGroupClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L8;
        GroupBrowseListFragment r1 = this.mGroupBrowseListFragment;
        if (r1 == null) goto L9;
        r1.createNewGroupWithAccountDisambiguation();
        return;
    L9:
        return;
    }

    private final void onClickSelectAll() {
        SelectAllState r0 = this.mGroupSelectAllState;
        if (r0 == null) goto L5;
        r0.toggle();
    L5:
        SelectAllState r1 = this.mGroupSelectAllState;
        if (r1 == null) goto L8;
        boolean r2 = r1.isSelectAll();
    L9:
        GroupBrowseListFragment r3 = this.mGroupBrowseListFragment;
        if (r3 == null) goto L58;
        if (r3 == null) goto L13;
        GroupBrowseListAdapter r4 = r3.getAdapter();
    L14:
        if (r4 == null) goto L59;
        GroupBrowseListFragment r5 = this.mGroupBrowseListFragment;
        if (r5 == null) goto L20;
        GroupBrowseListAdapter r6 = r5.getAdapter();
        if (r6 == null) goto L20;
        int r7 = r6.getCount();
    L21:
        int r8 = 0;
    L22:
        if (r8 >= r7) goto L29;
        GroupBrowseListFragment r9 = this.mGroupBrowseListFragment;
        if (r9 == null) goto L28;
        GroupBrowseListAdapter r10 = r9.getAdapter();
        if (r10 == null) goto L28;
        r10.setChecked(r8, r2);
    L28:
        r8 = r8 + 1;
        goto L22
    L29:
        GroupBrowseListFragment r11 = this.mGroupBrowseListFragment;
        if (r11 == null) goto L35;
        GroupBrowseListAdapter r12 = r11.getAdapter();
        if (r12 == null) goto L35;
        r12.notifyDataSetChanged();
    L35:
        if (r2 == false) goto L47;
        GroupBrowseListFragment r13 = this.mGroupBrowseListFragment;
        if (r13 == null) goto L41;
        GroupBrowseListAdapter r14 = r13.getAdapter();
        if (r14 == null) goto L41;
        int r15 = r14.getReadOnlyItemSize();
    L42:
        String r16 = getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r7 - r15)});
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.delet…_item_numbers, totleSize)");
        OFloatingTitleBarHolder r17 = this.mTitleBarHolder;
        if (r17 == null) goto L52;
        OFloatingTitleBar r18 = r17.getTitleBar();
        if (r18 == null) goto L52;
        r18.setCenterTitle(r16);
    L52:
        this.mBottomDeleteLayoutListener.setBottomBtnEnable(r2);
        return;
    L41:
        r15 = 0;
        goto L42
    L47:
        String r19 = getString(R.string.delete_selected_item_numbers, new Object[]{0});
        Intrinsics.checkNotNullExpressionValue(r19, "getString(R.string.delet…selected_item_numbers, 0)");
        OFloatingTitleBarHolder r20 = this.mTitleBarHolder;
        if (r20 == null) goto L52;
        OFloatingTitleBar r21 = r20.getTitleBar();
        if (r21 == null) goto L52;
        r21.setCenterTitle(r19);
    L20:
        r7 = 0;
        goto L21
    L59:
        return;
    L13:
        r4 = null;
        goto L14
    L58:
        return;
    L8:
        r2 = false;
        goto L9
    }

    private final void cancelEdit() {
        OFloatingTitleBarHolder r0 = this.mTitleBarHolder;
        if (r0 == null) goto L5;
        r0.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
    L5:
        GroupBrowseListFragment r1 = this.mGroupBrowseListFragment;
        if (r1 == null) goto L8;
        r1.setGroupEdit(false);
    L8:
        this.mBottomDeleteLayoutListener.startTransition(false);
        this.mBottomDeleteLayoutListener.setLayoutVisible(false);
        OFloatingTitleBarHolder r2 = this.mTitleBarHolder;
        if (r2 == null) goto L14;
        OFloatingTitleBar r3 = r2.getTitleBar();
        if (r3 == null) goto L15;
        r3.setCenterTitle(getString(R.string.mine_group));
        return;
    L15:
        return;
    }

    private final void onClickEdit() {
        SelectAllState r0 = this.mGroupSelectAllState;
        if (r0 == null) goto L6;
        r0.setSelectAll(false);
    L6:
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        if (r1 == null) goto L9;
        r1.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L9:
        GroupBrowseListFragment r2 = this.mGroupBrowseListFragment;
        if (r2 == null) goto L12;
        r2.setGroupEdit(true);
    L12:
        this.mBottomDeleteLayoutListener.startTransition(true);
        this.mBottomDeleteLayoutListener.setLayoutVisible(true);
        GroupBrowseListFragment r3 = this.mGroupBrowseListFragment;
        if (r3 == null) goto L19;
        GroupBrowseListAdapter r4 = r3.getAdapter();
        if (r4 == null) goto L19;
        ArrayList<Long> r5 = r4.getCheckedGroupIds();
        if (r5 == null) goto L19;
        int r6 = r5.size();
    L20:
        OFloatingTitleBarHolder r7 = this.mTitleBarHolder;
        if (r7 == null) goto L26;
        OFloatingTitleBar r8 = r7.getTitleBar();
        if (r8 == null) goto L27;
        r8.setCenterTitle(getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r6)}));
        return;
    L27:
        return;
    L26:
        return;
    L19:
        r6 = 0;
        goto L20
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_GroupBrowseListActivity_com_obric_privacyhook_PrivacyHook_onCreate(GroupBrowseListActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupBrowseListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_GroupBrowseListActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_GroupBrowseListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(GroupBrowseListActivity r1) {
        com_android_contacts_activities_GroupBrowseListActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_GroupBrowseListActivity_com_obric_privacyhook_PrivacyHook_onStop(GroupBrowseListActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        GroupBrowseListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_GroupBrowseListActivity__onStop$___twin___();
    }
}
