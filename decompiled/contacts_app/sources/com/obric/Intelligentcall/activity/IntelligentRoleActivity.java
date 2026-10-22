package com.obric.Intelligentcall.activity;

import android.os.Bundle;
import android.view.View;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentRoleActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0016J2\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0014H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentRoleActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "roleIdMap", "Ljava/util/LinkedHashMap;", "Lcom/obric/settings/SettingsProviderHelper$CharacterType;", "", "Lkotlin/collections/LinkedHashMap;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onStatusBarHeightChanged", "setGroup", "ids", "", "selected", "callback", "Lkotlin/Function1;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentRoleActivity extends BaseActivity {
    private final LinkedHashMap<SettingsProviderHelper.CharacterType, Integer> roleIdMap;

    public static /* synthetic */ void $r8$lambda$0Vf19XMDtnXYy8P3HmdwlwKY5N4(IntelligentRoleActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ckbmKHk3SfQq7WnIp6mIN-ZUnqY, reason: not valid java name */
    public static /* synthetic */ void m293$r8$lambda$ckbmKHk3SfQq7WnIp6mINZUnqY(List r0, Function1 r1, int r2, OCardListItem r3, View r4) {
        setGroup$lambda$5$lambda$4(r0, r1, r2, r3, r4);
    }

    public void com_obric_Intelligentcall_activity_IntelligentRoleActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentRoleActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentRoleActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentRoleActivity() {
        this.roleIdMap = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(SettingsProviderHelper.CharacterType.AUTO, Integer.valueOf(R.id.intelligent_role_auto)), TuplesKt.to(SettingsProviderHelper.CharacterType.AI, Integer.valueOf(R.id.intelligent_role_ai))});
    }

    public static final /* synthetic */ LinkedHashMap access$getRoleIdMap$p(IntelligentRoleActivity r0) {
        return r0.roleIdMap;
    }

    public void com_obric_Intelligentcall_activity_IntelligentRoleActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.ai_intelligent_role_activity);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r0 == null) goto L5;
        OFloatingTitleBar.addStartAction$default(r0, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new IntelligentRoleActivity$$ExternalSyntheticLambda1(this));
    L5:
        SettingsProviderHelper.CharacterType r8 = SettingsProviderHelper.INSTANCE.getAutoIntelligentRole(this);
        Collection<Integer> r1 = this.roleIdMap.values();
        Intrinsics.checkNotNullExpressionValue(r1, "roleIdMap.values");
        Set<SettingsProviderHelper.CharacterType> r2 = this.roleIdMap.keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "roleIdMap.keys");
        setGroup(r1, CollectionsKt.indexOf(r2, r8), new AnonymousClass2(this));
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentRoleActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void setGroup(Collection<Integer> r7, int r8, final Function1<? super Integer, Unit> r9) {
        Collection<Integer> r10 = r7;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r0.add((OCardListItem) findViewById(((Number) r11.next()).intValue()));
        goto L4
    L6:
        final ArrayList r1 = r0;
        Iterator r6 = r1.iterator();
        final int r2 = 0;
    L8:
        if (r6.hasNext() == false) goto L25;
        Object r3 = r6.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        final OCardListItem r5 = (OCardListItem) r3;
        if (r5 == null) goto L15;
        OCheckMark r12 = r5.getEndMark();
    L16:
        if (r12 == null) goto L22;
        if (r2 != r8) goto L20;
        boolean r13 = true;
    L21:
        r12.setChecked(r13);
        goto L22
    L20:
        r13 = false;
    L22:
        if (r5 == null) goto L24;
        r5.setOnContentClickListener(new IntelligentRoleActivity$$ExternalSyntheticLambda0(r1, r9, r2, r5));
    L24:
        r2 = r4;
        goto L8
    L15:
        r12 = null;
        goto L16
    }

    private static final void setGroup$lambda$5$lambda$4(List r1, Function1 r2, int r3, OCardListItem r4, View r5) {
        Intrinsics.checkNotNullParameter(r1, "$views");
        Intrinsics.checkNotNullParameter(r2, "$callback");
        Iterator r6 = r1.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        OCardListItem r7 = (OCardListItem) r6.next();
        if (r7 == null) goto L8;
        OCheckMark r0 = r7.getEndMark();
    L9:
        if (r0 == null) goto L4;
        if (r7 != r4) goto L13;
        boolean r8 = true;
    L14:
        r0.setChecked(r8);
        goto L4
    L13:
        r8 = false;
        goto L14
    L8:
        r0 = null;
        goto L9
    L15:
        r2.invoke(Integer.valueOf(r3));
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentRoleActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentRoleActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentRoleActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentRoleActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentRoleActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentRoleActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentRoleActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentRoleActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentRoleActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentRoleActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentRoleActivity__onStop$___twin___();
    }
}
