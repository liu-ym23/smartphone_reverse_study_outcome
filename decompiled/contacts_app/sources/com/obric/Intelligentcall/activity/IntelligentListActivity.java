package com.obric.Intelligentcall.activity;

import android.os.Bundle;
import android.view.View;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.calllog.record.CallRecordAndSummaryActivity;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.adapter.IntelligentListAdapter;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.widget.EmptySupportRecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentListActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0014J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentListActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "adapter", "Lcom/obric/Intelligentcall/adapter/IntelligentListAdapter;", "listTopInsetPx", "", "getListTopInsetPx", "()I", "listTopInsetPx$delegate", "Lkotlin/Lazy;", "navigationBarHeightPx", "recyclerView", "Lcom/obric/widget/EmptySupportRecyclerView;", "applyRecyclerInsets", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onResume", "onStatusBarHeightChanged", "startCallRecordAndSummaryActivity", "name", "", "callCreateTime", "", "phoneNumber", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentListActivity extends BaseActivity {
    private final IntelligentListAdapter adapter;
    private final Lazy listTopInsetPx$delegate;
    private int navigationBarHeightPx;
    private EmptySupportRecyclerView recyclerView;

    public static /* synthetic */ void $r8$lambda$t3bSWIotoA6p1HMI_ffEoCDpH1k(IntelligentListActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    public void com_obric_Intelligentcall_activity_IntelligentListActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentListActivity() {
        this.adapter = new IntelligentListAdapter(this);
        this.listTopInsetPx$delegate = LazyKt.lazy(IntelligentListActivity$listTopInsetPx$2.INSTANCE);
    }

    private final int getListTopInsetPx() {
        return ((Number) this.listTopInsetPx$delegate.getValue()).intValue();
    }

    public void com_obric_Intelligentcall_activity_IntelligentListActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.activity_intelligent_list_layout);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r0 == null) goto L5;
        OFloatingTitleBar.addStartAction$default(r0, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new IntelligentListActivity$$ExternalSyntheticLambda0(this));
    L5:
        View r8 = findViewById(R.id.list);
        Intrinsics.checkNotNull(r8);
        EmptySupportRecyclerView r9 = (EmptySupportRecyclerView) r8;
        this.recyclerView = r9;
        EmptySupportRecyclerView r1 = null;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L8:
        View r2 = findViewById(R.id.list_empty_view);
        if (r2 == null) goto L15;
        OPageStatus r3 = (OPageStatus) r2.findViewById(R.id.black_view);
        if (r3 == null) goto L13;
        r3.setTitle(getString(R.string.no_intelligent_call_log));
    L13:
        if (r3 == null) goto L16;
        r3.setMessage(getString(R.string.no_intelligent_call_log_desc));
    L16:
        r9.setEmptyView(r2);
        EmptySupportRecyclerView r10 = this.recyclerView;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r10 = null;
    L19:
        r10.setLayoutManager(new LinearLayoutManager(this));
        EmptySupportRecyclerView r11 = this.recyclerView;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L23:
        IntelligentListAdapter r12 = this.adapter;
        r12.startQuery();
        r1.setAdapter(r12);
        applyRecyclerInsets();
        return;
    L22:
        r1 = r11;
        goto L23
    L15:
        r2 = null;
        goto L16
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    public void com_obric_Intelligentcall_activity_IntelligentListActivity__onResume$___twin___() {
        super.onResume();
        EmptySupportRecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L5:
        IntelligentListAdapter r1 = this.adapter;
        r1.startQuery();
        r0.setAdapter(r1);
    }

    public void com_obric_Intelligentcall_activity_IntelligentListActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.adapter.destroy();
    }

    public final void startCallRecordAndSummaryActivity(String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r12, "phoneNumber");
        CallRecordAndSummaryActivity.Companion.startSelf(this, Long.valueOf(r10), r12, r9, "inner", true);
        AnimationUtil.switchActivityAnimation(this, 5);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
        this.navigationBarHeightPx = r1;
        applyRecyclerInsets();
    }

    private final void applyRecyclerInsets() {
        EmptySupportRecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
        return;
    L5:
        EmptySupportRecyclerView r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L8:
        EmptySupportRecyclerView r3 = this.recyclerView;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r3 = null;
    L11:
        int r4 = r3.getPaddingLeft();
        int r5 = getListTopInsetPx();
        EmptySupportRecyclerView r6 = this.recyclerView;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L15:
        r0.setPadding(r4, r5, r1.getPaddingRight(), this.navigationBarHeightPx);
        return;
    L14:
        r1 = r6;
        goto L15
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentListActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentListActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentListActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentListActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onResume(IntelligentListActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentListActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentListActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentListActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_obric_Intelligentcall_activity_IntelligentListActivity_com_obric_privacyhook_PrivacyHook_onDestroy(IntelligentListActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentListActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentListActivity__onDestroy$___twin___();
    }
}
