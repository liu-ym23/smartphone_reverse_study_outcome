package Ca;

import com.stepos.motionkit.fx.material.capability.GlassTextBinding;
import com.stepos.motionkit.fx.material.capability.GlassTextParams;
import com.stepos.taskrobot.llmapi.stepfun.ZyqlStepService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import m9.C1687E;
import m9.C1724q;
import s2.C1912a;
import stepai.aios.guiagent.llm.Message;
import stepai.android.llm.base.MessageBuilder;
import wa.C2110a;

/* renamed from: Ca.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0204c implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f346a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ C0204c(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f346a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f346a) {
            case 0:
                stepai.aios.guiagent.runtime.a aVar = (stepai.aios.guiagent.runtime.a) this.b;
                String str = (String) this.c;
                C0205d c0205d = (C0205d) this.d;
                C1724q c1724q = c0205d.c;
                C1687E c1687e = (C1687E) this.e;
                Throwable th = (Throwable) obj;
                if (th != null) {
                    com.stepos.statsrpk.service.c.o("startTask coroutine failed: ", th.getClass().getSimpleName(), ": ", th.getMessage(), "GuiRuntime");
                    if (th instanceof CancellationException) {
                        String message = ((CancellationException) th).getMessage();
                        if (message == null) {
                            message = "Task cancelled";
                        }
                        stepai.aios.guiagent.runtime.a.i(za.d.a(C1912a.j(message), str), c1724q);
                        aVar.l(str, c0205d, "startTask cancelled");
                    } else {
                        c1724q.g0(th);
                        aVar.l(str, c0205d, B7.a.n("startTask exception: ", th.getClass().getSimpleName(), ": ", th.getMessage()));
                    }
                } else {
                    try {
                        za.d dVar = (za.d) c1687e.J();
                        stepai.aios.guiagent.runtime.a.i(dVar, c1724q);
                        if (dVar.d) {
                            aVar.n(c0205d);
                        }
                    } catch (Throwable th2) {
                        com.stepos.statsrpk.service.c.o("startTask getCompleted failed: ", th2.getClass().getSimpleName(), ": ", th2.getMessage(), "GuiRuntime");
                        c1724q.g0(th2);
                        aVar.l(str, c0205d, B7.a.n("startTask completion exception: ", th2.getClass().getSimpleName(), ": ", th2.getMessage()));
                    }
                }
                return C7.r.f317a;
            case 1:
                stepai.aios.guiagent.runtime.a aVar2 = (stepai.aios.guiagent.runtime.a) this.b;
                String sessionId = (String) this.c;
                kotlinx.coroutines.flow.h hVar = (kotlinx.coroutines.flow.h) this.e;
                C0205d c0205d2 = (C0205d) this.d;
                Throwable th3 = (Throwable) obj;
                if (th3 != null) {
                    com.stepos.statsrpk.service.c.o("Result completed exceptionally: ", th3.getClass().getSimpleName(), ": ", th3.getMessage(), "GuiRuntime");
                    C2110a c2110a = aVar2.d;
                    c2110a.getClass();
                    kotlin.jvm.internal.k.f(sessionId, "sessionId");
                    za.i iVar = (za.i) c2110a.f6857a.get(sessionId);
                    if (iVar != null) {
                        aVar2.k(hVar, new u(iVar, th3));
                    }
                    aVar2.l(sessionId, c0205d2, B7.a.n("result exception: ", th3.getClass().getSimpleName(), ": ", th3.getMessage()));
                }
                return C7.r.f317a;
            case 2:
                return GlassTextBinding.pushGlyph$lambda$8((GlassTextBinding) this.b, (Class) this.c, (GlassTextParams) this.d, this.e, obj);
            default:
                return ZyqlStepService.chat$lambda$2$0$0((ZyqlStepService) this.b, (Message) this.c, (Map) this.d, (LinkedHashMap) this.e, (MessageBuilder) obj);
        }
    }

    public /* synthetic */ C0204c(stepai.aios.guiagent.runtime.a aVar, String str, kotlinx.coroutines.flow.h hVar, C0205d c0205d) {
        this.f346a = 1;
        this.b = aVar;
        this.c = str;
        this.e = hVar;
        this.d = c0205d;
    }
}
