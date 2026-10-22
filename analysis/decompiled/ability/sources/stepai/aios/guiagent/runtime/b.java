package stepai.aios.guiagent.runtime;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.i;
import m9.AbstractC1683A;
import m9.C1724q;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f6130a;
    public final a b;
    public final h c;
    public final i d;

    public b(String sessionId, h hVar, i iVar, C1724q c1724q, a aVar) {
        k.f(sessionId, "sessionId");
        this.f6130a = sessionId;
        this.b = aVar;
        this.c = hVar;
        this.d = iVar;
    }

    public final void a(String str) {
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new GuiTaskHandle$cancel$1(this, str, null));
    }
}
