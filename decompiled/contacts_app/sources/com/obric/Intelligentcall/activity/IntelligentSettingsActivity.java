package com.obric.Intelligentcall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.internal.ViewUtils;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentSettingsActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J#\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010\u001c\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0002J\u0012\u0010#\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSettingsActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "callForMeVoice", "Lcom/obric/oui/lisitem/OCardListItem;", "callForMeVoiceText", "Lcom/obric/oui/text/OTextView;", "customQuickReply", "intelligentCallList", "intelligentPickup", "intelligentPickupText", "intelligentRole", "intelligentRoleText", "intelligentVoice", "intelligentVoiceText", "getAutoPickUpStatusText", "", "getCallForMeVoice", "getIntelligentRoleText", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "onResume", "onStatusBarHeightChanged", "show", "ids", "", "", "([Ljava/lang/Integer;Z)V", "showContactsLogSettings", "isShow", "showPpeSettings", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentSettingsActivity extends BaseActivity {
    public static final int ACTIVITY_CODE_CALL_FOR_ME_VOICE = 2;
    public static final int ACTIVITY_CODE_INTELLIGENT_VOICE = 1;
    public static final Companion Companion = null;
    private static final String TAG = "IntelligentSettingsActivity";
    private static final int TITLE_BAR_CLICK_COUNT_LIMIT = 5;
    private OCardListItem callForMeVoice;
    private OTextView callForMeVoiceText;
    private OCardListItem customQuickReply;
    private OCardListItem intelligentCallList;
    private OCardListItem intelligentPickup;
    private OTextView intelligentPickupText;
    private OCardListItem intelligentRole;
    private OTextView intelligentRoleText;
    private OCardListItem intelligentVoice;
    private OTextView intelligentVoiceText;

    /* JADX INFO: compiled from: IntelligentSettingsActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSettingsActivity$Companion;", "", "()V", "ACTIVITY_CODE_CALL_FOR_ME_VOICE", "", "ACTIVITY_CODE_INTELLIGENT_VOICE", "TAG", "", "TITLE_BAR_CLICK_COUNT_LIMIT", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IntelligentSettingsActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SettingsProviderHelper.CharacterType.values().length];
            r0[SettingsProviderHelper.CharacterType.AI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SettingsProviderHelper.CharacterType.HUMAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SettingsProviderHelper.CharacterType.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$BMsvOxuE6ie7wxDntDQemaFYb8A(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$C-0iskxQlzLXpMfKjBFF5-9A-Jk, reason: not valid java name */
    public static /* synthetic */ void m295$r8$lambda$C0iskxQlzLXpMfKjBFF59AJk(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Mj7xjLHDccBwi5r7MX5QU9bDUN4(IntelligentSettingsActivity r0, CompoundButton r1, boolean r2) {
        show$lambda$15$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$UEkhyWK0viB3hvg8hVGaacxlEt0(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZJW4yjzBzBjic0VfIhttEj9YwZw(IntelligentSettingsActivity r0, CompoundButton r1, boolean r2) {
        show$lambda$15$lambda$12(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$b_8fHq8T8MS3kt_usq_-j3ktI1U, reason: not valid java name */
    public static /* synthetic */ void m296$r8$lambda$b_8fHq8T8MS3kt_usq_j3ktI1U(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$dhh4XycDIOElyDEy3ZyNFVsqyZ4(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fePLdSPNy46Ou0JAfblBTousMwQ(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$rMECbX7EKXz-iPThPUqlVuLbQgc, reason: not valid java name */
    public static /* synthetic */ void m297$r8$lambda$rMECbX7EKXziPThPUqlVuLbQgc(IntelligentSettingsActivity r0, String r1, OCardListItem r2, View r3) {
        show$lambda$15$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$rSLXG_Ve2OVDf_Ol8tK7rwkayh0(IntelligentSettingsActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentSettingsActivity() {
    }

    public static final /* synthetic */ void access$showContactsLogSettings(IntelligentSettingsActivity r0, boolean r1) {
        r0.showContactsLogSettings(r1);
    }

    public static final /* synthetic */ void access$showPpeSettings(IntelligentSettingsActivity r0, boolean r1) {
        r0.showPpeSettings(r1);
    }

    public void com_obric_Intelligentcall_activity_IntelligentSettingsActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.ai_intelligent_settings_activity);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBar r8 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r8 == null) goto L7;
        r8.setCenterTitle(getString(R.string.ai_intelligent_title));
        OFloatingTitleBar.addStartAction$default(r8, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda0(this));
        if (ContactsUtils.KSA_VERSION == true) goto L7;
        r8.findViewById(R.id.center_container).setOnClickListener(new IntelligentSettingsActivity$onCreate$1$2(this));
    L7:
        OCardListItem r9 = (OCardListItem) findViewById(R.id.intelligent_auto_pick_up);
        this.intelligentPickup = r9;
        if (r9 == null) goto L10;
        View r10 = r9.getCustomEndView();
    L11:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        this.intelligentPickupText = (OTextView) r10;
        OCardListItem r11 = this.intelligentPickup;
        if (r11 == null) goto L14;
        r11.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda1(this));
    L14:
        OCardListItem r12 = (OCardListItem) findViewById(R.id.intelligent_scene);
        this.customQuickReply = r12;
        if (r12 == null) goto L17;
        r12.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda2(this));
    L17:
        OCardListItem r13 = (OCardListItem) findViewById(R.id.intelligent_list);
        this.intelligentCallList = r13;
        if (r13 == null) goto L20;
        r13.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda3(this));
    L20:
        OCardListItem r14 = (OCardListItem) findViewById(R.id.intelligent_role);
        this.intelligentRole = r14;
        if (r14 == null) goto L23;
        View r15 = r14.getCustomEndView();
    L24:
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        this.intelligentRoleText = (OTextView) r15;
        OCardListItem r16 = this.intelligentRole;
        if (r16 == null) goto L27;
        r16.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda4(this));
    L27:
        OCardListItem r17 = (OCardListItem) findViewById(R.id.intelligent_voice);
        this.intelligentVoice = r17;
        if (r17 == null) goto L30;
        View r18 = r17.getCustomEndView();
    L31:
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        this.intelligentVoiceText = (OTextView) r18;
        OCardListItem r19 = this.intelligentVoice;
        if (r19 == null) goto L34;
        r19.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda5(this));
    L34:
        OCardListItem r20 = (OCardListItem) findViewById(R.id.call_for_me_voice);
        this.callForMeVoice = r20;
        if (r20 == null) goto L37;
        View r21 = r20.getCustomEndView();
    L38:
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        this.callForMeVoiceText = (OTextView) r21;
        OCardListItem r22 = this.callForMeVoice;
        if (r22 == null) goto L41;
        r22.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda6(this));
    L41:
        showPpeSettings$default(this, false, 1, null);
        showContactsLogSettings$default(this, false, 1, null);
        return;
    L37:
        r21 = null;
        goto L38
    L30:
        r18 = null;
        goto L31
    L23:
        r15 = null;
        goto L24
    L10:
        r10 = null;
        goto L11
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentSettingsActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void onCreate$lambda$3(IntelligentSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2, IntelligentAutoPickUpActivity.class));
    }

    private static final void onCreate$lambda$4(IntelligentSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2, IntelligentSceneActivity.class));
    }

    private static final void onCreate$lambda$5(IntelligentSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2, IntelligentListActivity.class));
    }

    private static final void onCreate$lambda$7(IntelligentSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2, IntelligentRoleActivity.class));
    }

    private static final void onCreate$lambda$9(IntelligentSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivityForResult(new Intent(r2, IntelligentVoiceActivity.class), 1);
    }

    private static final void onCreate$lambda$11(IntelligentSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivityForResult(new Intent(r2, CallForMeVoiceActivity.class), 2);
    }

    static /* synthetic */ void showContactsLogSettings$default(IntelligentSettingsActivity r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.showContactsLogSettings(r1);
    }

    private final void showContactsLogSettings(boolean r4) {
        if (ContactsUtils.KSA_VERSION == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "KSA version showPpeSettings: 不支持");
        return;
    L6:
        if (r4 == false) goto L9;
        show(new Integer[]{Integer.valueOf(R.id.settings_set_contacts_log_enable)}, true);
        return;
    }

    static /* synthetic */ void showPpeSettings$default(IntelligentSettingsActivity r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.showPpeSettings(r1);
    }

    private final void showPpeSettings(boolean r3) {
        if (ContactsUtils.KSA_VERSION == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "KSA version showPpeSettings: 不支持");
        return;
    L6:
        if (r3 == false) goto L9;
        show(new Integer[]{Integer.valueOf(R.id.settings_set_ppe_name), Integer.valueOf(R.id.settings_set_ppe_enable)}, true);
        return;
    }

    public void com_obric_Intelligentcall_activity_IntelligentSettingsActivity__onResume$___twin___() {
        super.onResume();
        OTextView r0 = this.intelligentPickupText;
        if (r0 == null) goto L6;
        r0.setText(getAutoPickUpStatusText());
    L6:
        OTextView r1 = this.intelligentRoleText;
        if (r1 == null) goto L10;
        r1.setText(getIntelligentRoleText());
    L10:
        OTextView r2 = this.intelligentVoiceText;
        if (r2 == null) goto L14;
        r2.setText(IntelligentUtils.INSTANCE.getSelectedSoundName(this));
    L14:
        OTextView r3 = this.callForMeVoiceText;
        if (r3 == null) goto L19;
        r3.setText(getCallForMeVoice());
        return;
    }

    private final String getCallForMeVoice() {
        String r0 = SettingsProviderHelper.INSTANCE.getCallForMeVoice(this);
        if (Intrinsics.areEqual(r0, SettingsProviderHelper.CALL_FOR_ME_VOICE_FEMALE) == false) goto L6;
        String r3 = getString(R.string.common_default_tone);
        Intrinsics.checkNotNullExpressionValue(r3, "{ //使用 tts 播放女声\n        …fault_tone)\n            }");
        return r3;
    L6:
        if (Intrinsics.areEqual(r0, SettingsProviderHelper.CALL_FOR_ME_VOICE_MALE) == false) goto L8;
        String r4 = getString(R.string.call_for_male_voice);
        Intrinsics.checkNotNullExpressionValue(r4, "{ //播放已有问音频文件\n          …male_voice)\n            }");
        return r4;
    L8:
        String r5 = getString(R.string.common_default_tone);
        Intrinsics.checkNotNullExpressionValue(r5, "{ //默认使用女声\n             …fault_tone)\n            }");
        return r5;
    }

    private static final void show$lambda$15$lambda$12(IntelligentSettingsActivity r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        SettingsProviderHelper.INSTANCE.setUsePpe(r1, r3);
    }

    private static final void show$lambda$15$lambda$13(IntelligentSettingsActivity r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        SettingsProviderHelper.INSTANCE.setContactsLogEnable(r1, r3);
    }

    private static final void show$lambda$15$lambda$14(final IntelligentSettingsActivity r15, final String r16, final OCardListItem r17, View r18) {
        Intrinsics.checkNotNullParameter(r15, "this$0");
        OSheetUtils.getEditDialog$default(OSheetUtils.INSTANCE, r15, "输入 PPE 名称", null, null, r16, false, new IntelligentSettingsActivity$show$1$3$1(r16, r15, r17), null, 0, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null).show();
    }

    private final String getAutoPickUpStatusText() {
        if (SettingsProviderHelper.INSTANCE.isAutoIntelligentEnabled(this, false) == false) goto L6;
        String r3 = getString(R.string.common_opened);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.common_opened)");
        return r3;
    L6:
        String r4 = getString(R.string.common_closed);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.common_closed)");
        return r4;
    }

    private final String getIntelligentRoleText() {
        SettingsProviderHelper.CharacterType r0 = SettingsProviderHelper.INSTANCE.getAutoIntelligentRole(this);
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        String r2 = getString(R.string.intelligent_role_ai_title);
        Intrinsics.checkNotNullExpressionValue(r2, "{\n                getStr…e_ai_title)\n            }");
        return r2;
    L5:
        if (r1 != 2) goto L7;
    L11:
        String r3 = getString(R.string.intelligent_role_title);
        Intrinsics.checkNotNullExpressionValue(r3, "{\n                getStr…role_title)\n            }");
        return r3;
    L7:
        if (r1 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    private final void show(Integer[] r11, boolean r12) {
        int r0 = r11.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L29;
        int r3 = r11[r2].intValue();
        final OCardListItem r4 = (OCardListItem) findViewById(r3);
        if (r4 == null) goto L12;
        OCardListItem r5 = r4;
        if ((!r12) == false) goto L10;
        int r6 = 8;
    L11:
        r5.setVisibility(r6);
        goto L12
    L10:
        r6 = 0;
    L12:
        View r7 = null;
        if (r3 != R.id.settings_set_ppe_enable) goto L19;
        if (r4 == null) goto L16;
        View r8 = r4.getCustomEndView();
    L17:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
        OSwitch r9 = (OSwitch) r8;
        r9.setChecked(SettingsProviderHelper.INSTANCE.getUsePpe(this, false));
        r9.setOnCheckedChangeListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda7(this));
        goto L19
    L16:
        r8 = null;
    L19:
        if (r3 != R.id.settings_set_contacts_log_enable) goto L24;
        if (r4 == null) goto L22;
        r7 = r4.getCustomEndView();
    L22:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
        OSwitch r10 = (OSwitch) r7;
        r10.setChecked(SettingsProviderHelper.INSTANCE.getContactsLogEnable(this, false));
        r10.setOnCheckedChangeListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda8(this));
    L24:
        if (r3 != R.id.settings_set_ppe_name) goto L28;
        final String r13 = SettingsProviderHelper.INSTANCE.getPpeName(this);
        if (r4 == null) goto L28;
        r4.setOnContentClickListener(new IntelligentSettingsActivity$$ExternalSyntheticLambda9(this, r13, r4));
    L28:
        r2 = r2 + 1;
        goto L3
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentSettingsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentSettingsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentSettingsActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_obric_privacyhook_PrivacyHook_onResume(IntelligentSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentSettingsActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentSettingsActivity__onStop$___twin___();
    }
}
