package com.obric.agent.intents.skill.d;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SkillActionDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.obric.agent.intents.skill.a.a<com.obric.agent.intents.skill.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15057b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, ?>> f15058c = null;

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f15056a = new a();
        f15057b = "SkillActionDispatcher";
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new com.obric.agent.intents.skill.a.c[]{f.f15146a, b.f15059a, d.f15095a, e.f15133a}), Iterable.class, "com.obric.aiagent.plugin");
        Map<String, com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, ?>> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(p.a(r0, 10)), 16)), Map.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(((com.obric.agent.intents.skill.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.a.c.class, "com.obric.aiagent.plugin")).a(), r3);
        goto L4
    L6:
        f15058c = r1;
    }

    @Override // com.obric.agent.intents.skill.a.a
    public String a() {
        return f15057b;
    }

    @Override // com.obric.agent.intents.skill.a.a
    public Map<String, com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, ?>> b() {
        return f15058c;
    }

    @Override // com.obric.agent.intents.skill.a.a
    public Object a(com.obric.agent.intents.skill.a.f r1, DispatchContext r2, d.c.d<? super com.obric.agent.intents.skill.a.a.AbstractC0296a<? extends com.obric.agent.intents.skill.a.b>> r3) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return new com.obric.agent.intents.skill.a.a.AbstractC0296a.b(com.obric.agent.intents.skill.a.b.f14887a);
    }

    @Override // com.obric.agent.intents.skill.a.a
    public IntentResult<Empty> a(String r14, Throwable r15) {
        o.e(r14, "actionType");
        o.e(r15, WsConstants.KEY_CONNECTION_ERROR);
        return new IntentResult(-2002, null, null, "operation failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    @Override // com.obric.agent.intents.skill.a.a
    public IntentResult<Empty> a(String r14) {
        o.e(r14, "actionType");
        return new IntentResult(999, null, null, "unsupported action", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }
}
