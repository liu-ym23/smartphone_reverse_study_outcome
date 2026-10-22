package com.obric.agent.auth;

import android.app.Application;
import android.app.KeyguardManager;
import android.os.Bundle;
import com.obric.agent.utils.b;
import com.obric.aiagent.assistant.idl.IDismissKeyguardCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.IRequestAuthenticationCallbackIDL;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.capabilitykit.common.intent.BaseCalendarShowScheduleIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent;
import com.obric.capabilitykit.common.intent.BaseFilesShowFileIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesShowMessageIntent;
import com.obric.capabilitykit.common.intent.BaseNotesShowNoteIntent;
import com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowPhotoIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderShowRecordingIntent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.f;
import d.g;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;
import d.x;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AgentAuthServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentAuthServiceImpl implements IAgentAuthService {
    public static final a Companion = null;
    private static final String TAG = "AgentAuthServiceImpl";
    private final f keyguardManager$delegate;
    private final String[] noTTSIntents;
    private m<String, Boolean> windowShowingBeforeAuth;
    private m<String, Boolean> windowState;

    /* JADX INFO: compiled from: AgentAuthServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$Ux5PvwP3UcwczNHXuk3lqgKOHO8(String r0, Bundle r1, n r2) {
        return requestBiometricAuth$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ KeyguardManager lambda$X5zqekRzDF0BPUzCmvsoWfZVMC8() {
        return keyguardManager_delegate$lambda$0();
    }

    public static /* synthetic */ x lambda$YgVvxiaIaQTOiIXEylfrouxo7SQ(String r0, Bundle r1, n r2) {
        return requestDeviceCredentialAuth$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$qotB4fIg5TM1msf_rAQje8rDubg(String r0, Bundle r1, n r2) {
        return requestVoiceprintAuth$lambda$4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$vBUI6BjWZ2K8L6be_U-D1DlSS1c, reason: not valid java name */
    public static /* synthetic */ x m66lambda$vBUI6BjWZ2K8L6be_UD1DlSS1c(String r0, AgentAuthServiceImpl r1, boolean r2, Bundle r3, String r4, n r5) {
        return requestDismissKeyguard$lambda$2(r0, r1, r2, r3, r4, r5);
    }

    public AgentAuthServiceImpl() {
        this.keyguardManager$delegate = g.a($$Lambda$AgentAuthServiceImpl$X5zqekRzDF0BPUzCmvsoWfZVMC8.INSTANCE);
        this.noTTSIntents = new String[]{new BaseClockShowAlarmIntent().getName(), new BaseClockShowCountdownIntent().getName(), new BaseNotesShowNoteIntent().getName(), new BaseContactsShowContactIntent().getName(), new BasePhoneShowCallHistoryIntent().getName(), new BaseCalendarShowScheduleIntent().getName(), new BaseFilesShowFileIntent().getName(), new BaseMessagesShowMessageIntent().getName(), new BasePhotoShowPhotoIntent().getName(), new BasePhotoShowAlbumIntent().getName(), new BaseRecorderShowRecordingIntent().getName(), new BaseCommonViewEntitiesIntent().getName()};
    }

    public static final /* synthetic */ m access$getWindowShowingBeforeAuth$p(AgentAuthServiceImpl r0) {
        return r0.windowShowingBeforeAuth;
    }

    public static final /* synthetic */ void access$setWindowShowingBeforeAuth$p(AgentAuthServiceImpl r0, m r1) {
        r0.windowShowingBeforeAuth = r1;
    }

    public static final /* synthetic */ void access$setWindowState$p(AgentAuthServiceImpl r0, m r1) {
        r0.windowState = r1;
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(this.keyguardManager$delegate.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$0() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public boolean isKeyguardReallyLocked() {
        return getKeyguardManager().isDeviceLocked();
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public Object requestDismissKeyguard(final String r15, final String r16, final boolean r17, Bundle r18, d<? super Boolean> r19) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "requestAuth, " + r15);
        if (r18 != null) goto L5;
        final Bundle r7 = buildReportParams(r16);
    L7:
        return b.f15994a.a(18000, d.c.b.a.b.a(false), new $$Lambda$AgentAuthServiceImpl$vBUI6BjWZ2K8L6be_UD1DlSS1c(r15, this, r17, r7, r16), r0);
    L5:
        r7 = r18;
        goto L7
    }

    private static final x requestDismissKeyguard$lambda$2(String r8, final AgentAuthServiceImpl r9, boolean r10, Bundle r11, final String r12, n r13) {
        final n r14 = (n) ZeusTransformUtils.wrapperContextForParams(r13, n.class, "com.obric.aiagent.plugin");
        o.e(r14, "continuation");
        if (r8 == null) goto L8;
        IFlowUiIDL r2 = aw.a(aa.b(IFlowUiIDL.class));
        if (r2 == null) goto L8;
        r2.suspendDismissKeyguard(r8, r9.noTTSIntents, (IDismissKeyguardCallbackIDL) ZeusTransformUtils.preCheckCast(new AgentAuthServiceImpl$requestDismissKeyguard$2$1$1(r9, r12, r14), IDismissKeyguardCallbackIDL.class, "com.obric.aiagent.plugin"), r10, r11);
    L8:
        return x.f38692a;
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public Authentication isAuthPass(String r1, String r2) {
        IFlowUiIDL r0 = aw.a(aa.b(IFlowUiIDL.class));
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isAuthenticationPassV3(r2);
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public Object requestVoiceprintAuth(final String r7, String r8, final Bundle r9, d<? super Integer> r10) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L6;
        r9 = buildReportParams(r8);
    L6:
        return b.f15994a.a(5000, d.c.b.a.b.a(1), new $$Lambda$AgentAuthServiceImpl$qotB4fIg5TM1msf_rAQje8rDubg(r7, r9), r5);
    }

    private static final x requestVoiceprintAuth$lambda$4(String r2, Bundle r3, n r4) {
        final n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        o.e(r5, "continuation");
        if (r2 == null) goto L8;
        IFlowUiIDL r6 = aw.a(aa.b(IFlowUiIDL.class));
        if (r6 == null) goto L8;
        r6.requestVoicePrintAuthentication((IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(new AgentAuthServiceImpl$requestVoiceprintAuth$2$1$1(r5), IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin"), r3);
    L8:
        return x.f38692a;
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public Object requestBiometricAuth(final String r7, String r8, final Bundle r9, d<? super Integer> r10) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_GENESIS_R) == true) goto L16;
        if (o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_GENESIS_M) == true) goto L16;
        if (r9 != null) goto L9;
        r9 = buildReportParams(r8);
    L9:
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L12;
        boolean r12 = r11.isWindowShowing();
    L13:
        this.windowShowingBeforeAuth = s.a(r8, d.c.b.a.b.a(r12));
        return b.f15994a.a(18000, d.c.b.a.b.a(1), new $$Lambda$AgentAuthServiceImpl$Ux5PvwP3UcwczNHXuk3lqgKOHO8(r7, r9), r5);
    L12:
        r12 = false;
    L16:
        return d.c.b.a.b.a(3);
    }

    private static final x requestBiometricAuth$lambda$6(String r2, Bundle r3, n r4) {
        final n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        o.e(r5, "continuation");
        if (r2 == null) goto L8;
        IFlowUiIDL r6 = aw.a(aa.b(IFlowUiIDL.class));
        if (r6 == null) goto L8;
        r6.requestBiometricAuthentication((IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(new AgentAuthServiceImpl$requestBiometricAuth$2$1$1(r5), IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin"), true, r3);
    L8:
        return x.f38692a;
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public Object requestDeviceCredentialAuth(final String r7, String r8, final Bundle r9, d<? super Integer> r10) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L6;
        r9 = buildReportParams(r8);
    L6:
        return b.f15994a.a(18000, d.c.b.a.b.a(1), new $$Lambda$AgentAuthServiceImpl$YgVvxiaIaQTOiIXEylfrouxo7SQ(r7, r9), r5);
    }

    private static final x requestDeviceCredentialAuth$lambda$8(String r2, Bundle r3, n r4) {
        final n r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
        o.e(r5, "continuation");
        if (r2 == null) goto L8;
        IFlowUiIDL r6 = aw.a(aa.b(IFlowUiIDL.class));
        if (r6 == null) goto L8;
        r6.requestDeviceCredentialAuthentication((IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(new AgentAuthServiceImpl$requestDeviceCredentialAuth$2$1$1(r5), IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin"), r3);
    L8:
        return x.f38692a;
    }

    private final Bundle buildReportParams(String r2) {
        Bundle r1 = new Bundle();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.putString("message_id", r2);
        r1.putInt("is_omni", 0);
        return r1;
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public void dismissKeyguard() {
        IFlowUiIDL r0 = aw.a(aa.b(IFlowUiIDL.class));
        if (r0 == null) goto L6;
        r0.dismissKeyguard();
        return;
    }

    @Override // com.obric.agent.auth.IAgentAuthService
    public void popWindowIfNeed(String r9, String r10, int r11) {
        o.e(r10, "intentName");
        m<String, Boolean> r0 = this.windowState;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.a(), String.class, "com.obric.aiagent.plugin");
    L6:
        boolean r4 = true;
        if (o.a(r9, r2) == false) goto L28;
        m<String, Boolean> r3 = this.windowState;
        if (r3 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L28;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("_Show", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L28;
        if (o.a(r10, "Common_ViewEntities") == true) goto L28;
        if (o.a(r10, "Office_JumpToLarkUrl") == true) goto L28;
        if (o.a(r10, "Photo_Search") == true) goto L28;
        if (o.a(r10, "System_OpenApp") == true) goto L28;
        this.windowState = s.a(r9, false);
        IFlowUiIDL r8 = aw.a(aa.b(IFlowUiIDL.class));
        if (r8 == null) goto L48;
        r8.popWindow();
        return;
    L48:
        return;
    L11:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L13;
        r5 = true;
    L28:
        m<String, Boolean> r6 = this.windowState;
        if (r6 == null) goto L32;
        r1 = (String) ZeusTransformUtils.preCheckCast(r6.a(), String.class, "com.obric.aiagent.plugin");
    L32:
        if (o.a(r9, r1) == false) goto L50;
        m<String, Boolean> r7 = this.windowState;
        if (r7 != null) goto L36;
    L38:
        r4 = false;
    L39:
        if (r4 == true) goto L41;
        return;
    L41:
        if (o.a(r10, "System_OpenApp") == false) goto L52;
        if (r11 == 0) goto L46;
        IFlowUiIDL r12 = aw.a(aa.b(IFlowUiIDL.class));
        if (r12 == null) goto L46;
        r12.popWindow();
    L46:
        this.windowState = s.a(r9, false);
        return;
    L52:
        return;
    L36:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L38;
    L50:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
