package com.obric.aiagent.ipc.assistant;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IAgentAssistantStateIDL;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.IAgentIDLSPI;
import com.obric.aiagent.assistant.idl.IAgentMessageIDL;
import com.obric.aiagent.assistant.idl.IAgentNetworkIDL;
import com.obric.aiagent.assistant.idl.IAgentPrivacyIDL;
import com.obric.aiagent.assistant.idl.IAgentSettingsIDL;
import com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.IFlowIDL;
import com.obric.aiagent.assistant.idl.IPlatformApiIDL;
import com.obric.aiagent.assistant.idl.b;
import com.obric.aiagent.assistant.idl.bc;
import com.obric.aiagent.assistant.idl.d;
import com.obric.aiagent.assistant.idl.f;
import com.obric.aiagent.assistant.idl.g;
import com.obric.aiagent.assistant.idl.i;
import com.obric.aiagent.assistant.idl.j;
import com.obric.aiagent.assistant.idl.l;
import com.obric.aiagent.assistant.idl.m;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantIDLStub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AssistantIDLStub implements IAgentIDLSPI {
    public static final a Companion = null;
    private static final String TAG = "AssistantIDLStub";

    /* JADX INFO: compiled from: AssistantIDLStub.kt */
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

    public AssistantIDLStub() {
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IAgentNetworkIDL getAgentNetworkIDL() {
        return (IAgentNetworkIDL) ZeusTransformUtils.preCheckCast(getAgentNetworkIDL(), IAgentNetworkIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IAgentAppIntentIDL getAppIntentIDL() {
        return (IAgentAppIntentIDL) ZeusTransformUtils.preCheckCast(getAppIntentIDL(), IAgentAppIntentIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IAgentAssistantStateIDL getAssistantStateIDL() {
        return (IAgentAssistantStateIDL) ZeusTransformUtils.preCheckCast(getAssistantStateIDL(), IAgentAssistantStateIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IFileIDL getFileIDL() {
        return (IFileIDL) ZeusTransformUtils.preCheckCast(getFileIDL(), IFileIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IAgentMessageIDL getMessageIDL() {
        return (IAgentMessageIDL) ZeusTransformUtils.preCheckCast(getMessageIDL(), IAgentMessageIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IPlatformApiIDL getPlatformApiIDL() {
        return (IPlatformApiIDL) ZeusTransformUtils.preCheckCast(getPlatformApiIDL(), IPlatformApiIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IAgentSettingsIDL getSettingsIDL() {
        return (IAgentSettingsIDL) ZeusTransformUtils.preCheckCast(getSettingsIDL(), IAgentSettingsIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public /* synthetic */ IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
        return (IAgentVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(getVoiceInteractionIDL(), IAgentVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public void registerFlowIDL(IFlowIDL r3) {
        IFlowIDL r4 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowIDL.class, "com.obric.aiagent.plugin");
        o.e(r4, "flowIDL");
        checkPolicy();
        com.obric.aiagent.ipc.utils.h.f18670a.a(IAgentIDLSPI.TAG, "registerFlowIDL(" + r4 + ')');
        com.obric.aiagent.ipc.assistant.a.f18606a.a(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IFileIDL.Stub getFileIDL() {
        return (IFileIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(com.obric.aiagent.ipc.idl.a.a(aa.b(IFileIDL.class), false, 1, null)), IFileIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAppIntentIDL.Stub getAppIntentIDL() {
        return (IAgentAppIntentIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(com.obric.aiagent.assistant.idl.a.a(aa.b(IAgentAppIntentIDL.class), false, 1, null)), IAgentAppIntentIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentVoiceInteractionIDL.Stub getVoiceInteractionIDL() {
        return (IAgentVoiceInteractionIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(m.a(aa.b(IAgentVoiceInteractionIDL.class), false, 1, null)), IAgentVoiceInteractionIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSettingsIDL.Stub getSettingsIDL() {
        return (IAgentSettingsIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(i.a(aa.b(IAgentSettingsIDL.class), false, 1, null)), IAgentSettingsIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentMessageIDL.Stub getMessageIDL() {
        return (IAgentMessageIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(f.a(aa.b(IAgentMessageIDL.class), false, 1, null)), IAgentMessageIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentAssistantStateIDL.Stub getAssistantStateIDL() {
        return (IAgentAssistantStateIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(b.a(aa.b(IAgentAssistantStateIDL.class), false, 1, null)), IAgentAssistantStateIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentNetworkIDL.Stub getAgentNetworkIDL() {
        return (IAgentNetworkIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(g.a(aa.b(IAgentNetworkIDL.class), false, 1, null)), IAgentNetworkIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IPlatformApiIDL.Stub getPlatformApiIDL() {
        return (IPlatformApiIDL.Stub) ZeusTransformUtils.preCheckCast(ifAllow(bc.a(aa.b(IPlatformApiIDL.class), false, 1, null)), IPlatformApiIDL.Stub.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
        return (IAgentDMStateManagerIDL) ZeusTransformUtils.preCheckCast(ifAllow(d.a(aa.b(IAgentDMStateManagerIDL.class), false, 1, null)), IAgentDMStateManagerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentPrivacyIDL getPrivacyIDL() {
        return (IAgentPrivacyIDL) ZeusTransformUtils.preCheckCast(ifAllow(com.obric.aiagent.assistant.idl.h.a(aa.b(IAgentPrivacyIDL.class), false, 1, null)), IAgentPrivacyIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentTaskAppIDL getTaskAppIDL() {
        return (IAgentTaskAppIDL) ZeusTransformUtils.preCheckCast(ifAllow(l.a(aa.b(IAgentTaskAppIDL.class), false, 1, null)), IAgentTaskAppIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentIDL
    public IAgentSkillManagerIDL getSkillManagerIDL() {
        return (IAgentSkillManagerIDL) ZeusTransformUtils.preCheckCast(ifAllow(j.a(aa.b(IAgentSkillManagerIDL.class), false, 1, null)), IAgentSkillManagerIDL.class, "com.obric.aiagent.plugin");
    }

    private final <T> T ifAllow(T r1) {
        checkPolicy();
        return r1;
    }

    private final void checkPolicy() {
        PackageManager r3 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
        if (r3 == null) goto L7;
        String[] r4 = r3.getPackagesForUid(Binder.getCallingUid());
        if (r4 == null) goto L7;
        String r5 = (String) ZeusTransformUtils.preCheckCast(d.a.i.c(r4), String.class, "com.obric.aiagent.plugin");
    L8:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L20;
        if (com.obric.aiagent.ipc.a.a.f18605a.a(r5, IAppContext.Companion.getPackageName(), "AssistantIDLStub.*") == false) goto L20;
        return;
    L20:
        throw new SecurityException("IPC Reject");
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
    L7:
        r5 = null;
        goto L8
    }
}
