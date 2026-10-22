package com.obric.aiagent.network;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentNetworkIDLSPI;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.ttnet.ITTNet;
import com.obric.aiagent.ttnet.b;
import com.obric.aiagent.ttnet.d;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: AgentNetworkIDLSPIImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentNetworkIDLSPIImpl implements IAgentNetworkIDLSPI {
    private final String TAG;

    public AgentNetworkIDLSPIImpl() {
        this.TAG = "[AgentNetworkIDLSPIImpl]";
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentNetworkIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void notifyRequestStatus(boolean r4, Map<Object, Object> r5) {
        ISecureLogDepend.Companion.i(this.TAG, "notifyRequestStatus, " + r4 + ", " + ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
    public void updateExcludeRules(RequestRestrictRule r6) {
        ILogDepend.Companion.i(this.TAG, "updateExcludeRules rule=" + r6);
        d r5 = new d();
        a r0 = a.f18724a;
        List<String> r1 = null;
        if (r6 == null) goto L5;
        List<String> r2 = r6.getAllowedHosts();
    L6:
        if (r6 == null) goto L8;
        List<String> r3 = r6.getAllowedPaths();
    L9:
        if (r6 == null) goto L11;
        r1 = r6.getAllowedUrlPrefixes();
    L11:
        r<List<String>, List<String>, List<String>> r7 = r0.a(r2, r3, r1);
        List r4 = (List) ZeusTransformUtils.preCheckCast(r7.d(), List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.preCheckCast(r7.e(), List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7.f(), List.class, "com.obric.aiagent.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        r5.a((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));
        goto L13
    L15:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        r5.b((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"));
        goto L17
    L19:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        r5.c('^' + Pattern.quote((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin")) + ".*");
        goto L21
    L23:
        ITTNet r13 = (ITTNet) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNet.class), ITTNet.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L32;
        b r14 = r13.getRequestRestrictManager();
        if (r14 == null) goto L33;
        r14.a(r5);
        return;
    L33:
        return;
    L32:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
