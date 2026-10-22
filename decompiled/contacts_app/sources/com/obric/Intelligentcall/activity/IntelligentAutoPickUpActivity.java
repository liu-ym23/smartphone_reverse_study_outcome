package com.obric.Intelligentcall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentAutoPickUpActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J2\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f0\u001aH\u0002J#\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001c\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\""}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentAutoPickUpActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "autoPickupWaitTimeView", "Lcom/obric/oui/lisitem/OCardListItem;", "typeTimeListGroup", "", "", "[Ljava/lang/Integer;", "getAutoPickupWaitTimeTrailingText", "", "waitTime", "intelligentTypeSettingsId2Value", "id", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onResume", "onStatusBarHeightChanged", "setSwitch", MaterialConfigFormatNames.CHECKED, "", "callback", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "show", "ids", "([Ljava/lang/Integer;Z)V", "showIntelligentItems", "isShow", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentAutoPickUpActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "IntelligentAutoPickUpActivity";
    private OCardListItem autoPickupWaitTimeView;
    private final Integer[] typeTimeListGroup;

    /* JADX INFO: compiled from: IntelligentAutoPickUpActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentAutoPickUpActivity$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$2N9yQok4uJIJqPtewvR4RO2ZgBs(IntelligentAutoPickUpActivity r0, String[] r1, View r2) {
        onCreate$lambda$5$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$AKFd8xfzWgoo4zVlitl9gBvaZzI(Function2 r0, CompoundButton r1, boolean r2) {
        setSwitch$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gO4ykWPULLMYMFe6TIPaJCXY_tY(IntelligentAutoPickUpActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    private final int intelligentTypeSettingsId2Value(int r1) {
        switch(r1) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L19;
        };
    L5:
        return 8192;
    L6:
        return 4096;
    L7:
        return 512;
    L8:
        return 32;
    L9:
        return 16;
    L10:
        return 64;
    L11:
        return 8;
    L12:
        return 4;
    L13:
        return 1;
    L14:
        return 128;
    L15:
        return 256;
    L16:
        return 2;
    L17:
        return 268435456;
    L19:
        return 134217728;
    }

    public void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentAutoPickUpActivity() {
        this.typeTimeListGroup = new Integer[]{Integer.valueOf(R.id.intelligent_type_contact), Integer.valueOf(R.id.intelligent_type_stranger), Integer.valueOf(R.id.intelligent_type_mark_classify_ad_sales), Integer.valueOf(R.id.intelligent_type_mark_classify_insurance_finance), Integer.valueOf(R.id.intelligent_type_mark_classify_high_risk), Integer.valueOf(R.id.intelligent_type_mark_classify_harassment), Integer.valueOf(R.id.intelligent_type_mark_classify_house_market), Integer.valueOf(R.id.intelligent_type_mark_classify_express), Integer.valueOf(R.id.intelligent_type_mark_classify_taxi), Integer.valueOf(R.id.intelligent_type_mark_classify_fraud), Integer.valueOf(R.id.intelligent_type_mark_classify_head_hunter), Integer.valueOf(R.id.intelligent_type_mark_classify_load_promotion), Integer.valueOf(R.id.intelligent_type_mark_classify_education), Integer.valueOf(R.id.intelligent_type_mark_classify_decoration)};
    }

    public static final /* synthetic */ OCardListItem access$getAutoPickupWaitTimeView$p(IntelligentAutoPickUpActivity r0) {
        return r0.autoPickupWaitTimeView;
    }

    public static final /* synthetic */ void access$showIntelligentItems(IntelligentAutoPickUpActivity r0, boolean r1) {
        r0.showIntelligentItems(r1);
    }

    public void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity__onCreate$___twin___(Bundle r10) {
        super.onCreate(r10);
        setContentView(R.layout.ai_intelligent_auto_pick_up_activity);
        UiUtils.setWindowColorStatusBar(this);
        String r0 = getString(R.string.intelligent_answer);
        Intrinsics.checkNotNullExpressionValue(r0, "getString(R.string.intelligent_answer)");
        String r1 = getString(R.string.intelligent_answer_5);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(R.string.intelligent_answer_5)");
        String r2 = getString(R.string.intelligent_answer_15);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.intelligent_answer_15)");
        String r3 = getString(R.string.intelligent_answer_30);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.intelligent_answer_30)");
        final String[] r11 = {r0, r1, r2, r3};
        OFloatingTitleBar r4 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r4 == null) goto L5;
        OFloatingTitleBar.addStartAction$default(r4, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new IntelligentAutoPickUpActivity$$ExternalSyntheticLambda1(this));
    L5:
        IntelligentAutoPickUpActivity r5 = this;
        boolean r6 = SettingsProviderHelper.INSTANCE.isAutoIntelligentEnabled(r5, false);
        setSwitch(R.id.auto_intelligent, r6, new AnonymousClass2(this));
        showIntelligentItems(r6);
        final Ref.IntRef r7 = new Ref.IntRef();
        r7.element = IntelligentUtils.INSTANCE.getIntelligentEnableTypes(r5);
        int r8 = this.typeTimeListGroup.length;
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L12;
        int r12 = this.typeTimeListGroup[r9].intValue();
        final int r13 = intelligentTypeSettingsId2Value(r9);
        if ((r7.element & r13) == 0) goto L10;
        boolean r14 = true;
    L11:
        setSwitch(r12, r14, new AnonymousClass3(r7, r13, this));
        r9 = r9 + 1;
        goto L6
    L10:
        r14 = false;
        goto L11
    L12:
        OCardListItem r15 = (OCardListItem) findViewById(R.id.intelligent_auto_pick_up_wait_time);
        if (r15 == null) goto L15;
        r15.setOnContentClickListener(new IntelligentAutoPickUpActivity$$ExternalSyntheticLambda2(this, r11));
    L16:
        this.autoPickupWaitTimeView = r15;
        return;
    L15:
        r15 = null;
        goto L16
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentAutoPickUpActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, com.obric.oui.popover.v2.OPopover] */
    private static final void onCreate$lambda$5$lambda$4(final IntelligentAutoPickUpActivity r24, final String[] r25, View r26) {
        Intrinsics.checkNotNullParameter(r24, "this$0");
        Intrinsics.checkNotNullParameter(r25, "$timeSettingsIndex2");
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        OPopover.Builder r3 = new OPopover.Builder(r24).setAutoDismissDelayMillis(Long.MIN_VALUE);
        IntelligentAutoPickUpActivity r4 = r24;
        OPopoverEntranceMenuView.Builder r15 = new OPopoverEntranceMenuView.Builder(r4);
        r15.enableOption();
        boolean r14 = true;
        int r13 = SettingsProviderHelper.INSTANCE.getIntelligentAnswerValue(r4, IntelligentUtils.INSTANCE.intelligentAnswerTimeSettingsIndex2Value(1));
        int r12 = r25.length;
        int r5 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r12) goto L9;
        String r6 = r25[r11];
        int r17 = r5 + 1;
        if (IntelligentUtils.INSTANCE.intelligentAnswerTimeSettingsIndex2Value(r5) != r13) goto L7;
        boolean r18 = r14;
    L8:
        OPopoverEntranceMenuView.Builder r7 = r15;
        int r20 = r12;
        boolean r16 = r18;
        OPopoverEntranceMenuView.Builder.addPopoverLeftOptionItem$default(r7, null, null, null, r6, null, false, false, r16, new IntelligentAutoPickUpActivity$onCreate$4$1$1$1$1(r24, r25, r2), 119, null);
        r11 = r11 + 1;
        r5 = r17;
        r13 = r13;
        r12 = r20;
        r14 = r14;
        r15 = r15;
        goto L3
    L7:
        r18 = false;
        goto L8
    L9:
        Unit r1 = Unit.INSTANCE;
        r2.element = r3.setView(r15.build()).build();
        OCardListItem r0 = r24.autoPickupWaitTimeView;
        OPopover r8 = null;
        if (r0 == null) goto L12;
        View r9 = r0.getCustomEndView();
    L13:
        OPopoverHelperEx r10 = OPopoverHelperEx.INSTANCE;
        if (r2.element != 0) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("popover");
    L17:
        Intrinsics.checkNotNull(r9);
        OPopoverHelperEx.showPopoverSmartly$default(r10, r8, r9, 80, false, 0, false, 0, 0, 248, null);
        return;
    L16:
        r8 = (OPopover) r2.element;
        goto L17
    L12:
        r9 = null;
        goto L13
    }

    public void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity__onResume$___twin___() {
        super.onResume();
        int r0 = SettingsProviderHelper.INSTANCE.getIntelligentAnswerValue(this, IntelligentUtils.INSTANCE.intelligentAnswerTimeSettingsIndex2Value(1));
        OCardListItem r1 = this.autoPickupWaitTimeView;
        if (r1 == null) goto L6;
        OCardListItem.setEndDetailText$default(r1, getAutoPickupWaitTimeTrailingText(r0), 0, 2, null);
        return;
    }

    private final void showIntelligentItems(boolean r4) {
        show((Integer[]) CollectionsKt.listOf(Integer.valueOf(R.id.intelligent_auto_pick_up_wait_time)).toArray(new Integer[0]), r4);
        show((Integer[]) CollectionsKt.listOf(Integer.valueOf(R.id.intelligent_type_tips)).toArray(new Integer[0]), r4);
        show(this.typeTimeListGroup, r4);
    }

    private final void setSwitch(int r1, boolean r2, final Function2<? super CompoundButton, ? super Boolean, Unit> r3) {
        OCardListItem r0 = (OCardListItem) findViewById(r1);
        if (r0 == null) goto L5;
        OSwitch r4 = r0.getEndSwitch();
    L6:
        if (r4 == null) goto L9;
        r4.setClickable(true);
    L9:
        if (r4 == null) goto L12;
        r4.setChecked(r2);
    L12:
        if (r4 == null) goto L15;
        r4.setOnCheckedChangeListener(new IntelligentAutoPickUpActivity$$ExternalSyntheticLambda0(r3));
        return;
    L15:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private static final void setSwitch$lambda$6(Function2 r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        r1.invoke(r2, Boolean.valueOf(r3));
    }

    private final String getAutoPickupWaitTimeTrailingText(int r4) {
        if (r4 != 0) goto L5;
        String r3 = getString(R.string.intelligent_answer);
        Intrinsics.checkNotNullExpressionValue(r3, "{\n                getStr…ent_answer)\n            }");
        return r3;
    L5:
        if (r4 != 5) goto L7;
        String r5 = getString(R.string.intelligent_answer_5);
        Intrinsics.checkNotNullExpressionValue(r5, "{\n                getStr…t_answer_5)\n            }");
        return r5;
    L7:
        if (r4 != 15) goto L9;
        String r6 = getString(R.string.intelligent_answer_15);
        Intrinsics.checkNotNullExpressionValue(r6, "{\n                getStr…_answer_15)\n            }");
        return r6;
    L9:
        if (r4 == 30) goto L11;
        String r7 = getString(R.string.intelligent_answer);
        Intrinsics.checkNotNullExpressionValue(r7, "{\n                getStr…ent_answer)\n            }");
        return r7;
    L11:
        String r8 = getString(R.string.intelligent_answer_30);
        Intrinsics.checkNotNullExpressionValue(r8, "{\n                getStr…_answer_30)\n            }");
        return r8;
    }

    private final void show(Integer[] r6, boolean r7) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        View r3 = findViewById(r6[r2].intValue());
        if (r3 == null) goto L12;
        if ((!r7) == false) goto L10;
        int r4 = 8;
    L11:
        r3.setVisibility(r4);
        goto L12
    L10:
        r4 = 0;
    L12:
        r2 = r2 + 1;
        goto L3
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentAutoPickUpActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentAutoPickUpActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentAutoPickUpActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_obric_privacyhook_PrivacyHook_onResume(IntelligentAutoPickUpActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentAutoPickUpActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentAutoPickUpActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentAutoPickUpActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentAutoPickUpActivity__onStop$___twin___();
    }
}
