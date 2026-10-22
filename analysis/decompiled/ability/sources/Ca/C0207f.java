package Ca;

import va.InterfaceC2078a;

/* renamed from: Ca.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0207f implements InterfaceC2078a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ stepai.aios.guiagent.runtime.a f349a;

    public C0207f(stepai.aios.guiagent.runtime.a aVar) {
        this.f349a = aVar;
    }

    @Override // va.InterfaceC2078a
    public final void afterCapture(String sessionId, String str) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        stepai.aios.guiagent.runtime.a.b(this.f349a, sessionId, new j(sessionId, str));
    }

    @Override // va.InterfaceC2078a
    public final void afterPerformAccessibilityAction(String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        stepai.aios.guiagent.runtime.a aVar = this.f349a;
        String strC = stepai.aios.guiagent.runtime.a.c(aVar, reason);
        if (strC == null) {
            return;
        }
        stepai.aios.guiagent.runtime.a.b(aVar, strC, new h(strC, stepai.aios.guiagent.runtime.a.d(aVar, reason)));
    }

    @Override // va.InterfaceC2078a
    public final void beforeCapture(String sessionId, String str) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        stepai.aios.guiagent.runtime.a.b(this.f349a, sessionId, new k(sessionId, str));
    }

    @Override // va.InterfaceC2078a
    public final void beforePerformAccessibilityAction(String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        stepai.aios.guiagent.runtime.a aVar = this.f349a;
        String strC = stepai.aios.guiagent.runtime.a.c(aVar, reason);
        if (strC == null) {
            return;
        }
        stepai.aios.guiagent.runtime.a.b(aVar, strC, new i(strC, stepai.aios.guiagent.runtime.a.d(aVar, reason)));
    }
}
