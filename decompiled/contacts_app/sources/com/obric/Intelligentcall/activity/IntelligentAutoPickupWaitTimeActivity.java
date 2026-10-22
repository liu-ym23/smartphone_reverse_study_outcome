package com.obric.Intelligentcall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentAutoPickupWaitTimeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J7\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\r\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentAutoPickupWaitTimeActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "setGroup", "ids", "", "selected", "callback", "Lkotlin/Function1;", "([Ljava/lang/Integer;ILkotlin/jvm/functions/Function1;)V", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentAutoPickupWaitTimeActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "IntelligentAutoPickupWaitTimeActivity";

    /* JADX INFO: compiled from: IntelligentAutoPickupWaitTimeActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentAutoPickupWaitTimeActivity$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$M5hfOW_jlgHGx2ogKHqcPvWcYj4(IntelligentAutoPickupWaitTimeActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$uSs2I7taefhufQUBrvlZhKPwkYo(List r0, Function1 r1, int r2, OListItemGeneral r3, View r4) {
        setGroup$lambda$5$lambda$4(r0, r1, r2, r3, r4);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentAutoPickupWaitTimeActivity() {
    }

    public void com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.ai_intelligent_auto_pickup_wait_time_activity);
        UiUtils.setWindowColorStatusBar(this);
        Integer[] r7 = {Integer.valueOf(R.id.intelligent_answer), Integer.valueOf(R.id.intelligent_answer_5), Integer.valueOf(R.id.intelligent_answer_15), Integer.valueOf(R.id.intelligent_answer_30)};
        OCTitleBar r0 = (OCTitleBar) findViewById(R.id.title_bar);
        if (r0 == null) goto L7;
        OButton r1 = r0.getMLeftActionBack();
        if (r1 == null) goto L7;
        r1.setOnClickListener(new IntelligentAutoPickupWaitTimeActivity$$ExternalSyntheticLambda0(this));
    L7:
        setGroup(r7, IntelligentUtils.INSTANCE.intelligentAnswerTimeSettingsValue2Index(SettingsProviderHelper.INSTANCE.getIntelligentAnswerValue(this, IntelligentUtils.INSTANCE.intelligentAnswerTimeSettingsIndex2Value(1))), new AnonymousClass2(this));
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentAutoPickupWaitTimeActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void setGroup$lambda$5$lambda$4(List r2, Function1 r3, int r4, OListItemGeneral r5, View r6) {
        Intrinsics.checkNotNullParameter(r2, "$views");
        Intrinsics.checkNotNullParameter(r3, "$callback");
        Iterator r7 = r2.iterator();
    L4:
        if (r7.hasNext() == false) goto L18;
        OListItemGeneral r8 = (OListItemGeneral) r7.next();
        if (r8 == null) goto L8;
        FrameLayout r0 = r8.getMTrailingElement();
    L9:
        if (r0 == null) goto L4;
        FrameLayout r1 = r0;
        int r9 = 0;
        if (r8 == r5) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L17;
        r9 = 8;
    L17:
        r1.setVisibility(r9);
        goto L4
    L14:
        r10 = false;
        goto L15
    L8:
        r0 = null;
        goto L9
    L18:
        r3.invoke(Integer.valueOf(r4));
    }

    private final void setGroup(Integer[] r7, int r8, final Function1<? super Integer, Unit> r9) {
        ArrayList r0 = new ArrayList(r7.length);
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add((OListItemGeneral) findViewById(r7[r3].intValue()));
        r3 = r3 + 1;
        goto L3
    L5:
        final ArrayList r2 = r0;
        Iterator r6 = r2.iterator();
        final int r10 = 0;
    L7:
        if (r6.hasNext() == false) goto L28;
        Object r4 = r6.next();
        int r5 = r10 + 1;
        if (r10 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        final OListItemGeneral r11 = (OListItemGeneral) r4;
        if (r11 == null) goto L14;
        FrameLayout r12 = r11.getMTrailingElement();
    L15:
        if (r12 == null) goto L25;
        FrameLayout r13 = r12;
        if (r10 == r8) goto L20;
        boolean r14 = true;
    L21:
        if (r14 == false) goto L23;
        int r15 = 8;
    L24:
        r13.setVisibility(r15);
        goto L25
    L23:
        r15 = 0;
        goto L24
    L20:
        r14 = false;
    L25:
        if (r11 == null) goto L27;
        r11.setOnClickListener(new IntelligentAutoPickupWaitTimeActivity$$ExternalSyntheticLambda1(r2, r9, r10, r11));
    L27:
        r10 = r5;
        goto L7
    L14:
        r12 = null;
        goto L15
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentAutoPickupWaitTimeActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentAutoPickupWaitTimeActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentAutoPickupWaitTimeActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentAutoPickupWaitTimeActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentAutoPickupWaitTimeActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentAutoPickupWaitTimeActivity__onStop$___twin___();
    }
}
