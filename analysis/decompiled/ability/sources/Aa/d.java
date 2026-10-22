package Aa;

import N9.j;
import Z6.k;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m9.c0;
import o9.InterfaceC1779e;
import za.i;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f167a;
    public volatile i b;
    public final Map c;
    public final AtomicBoolean d;
    public final AtomicReference e;
    public final InterfaceC1779e f;
    public volatile c0 g;
    public volatile int h;
    public final List i;

    public d(e eVar, i iVar, List list) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicReference atomicReference = new AtomicReference(null);
        kotlinx.coroutines.channels.a aVarB = k.b(-1, 6, null);
        this.f167a = eVar;
        this.b = iVar;
        this.c = concurrentHashMap;
        this.d = atomicBoolean;
        this.e = atomicReference;
        this.f = aVarB;
        this.g = null;
        this.h = 0;
        this.i = list;
    }

    public final c0 a() {
        return this.g;
    }

    public final i b() {
        return this.b;
    }

    public final boolean c() {
        boolean z10 = this.b.n;
        boolean z11 = this.b.o;
        List list = this.i;
        j.H("enableExperience: false   taskInfo.takeoverEverHappened:" + z10 + "  taskInfo.infoEverHappened:" + z11 + "  experienceActions.size:" + (list != null ? Integer.valueOf(list.size()) : null), "GuiExecutionPipeline");
        return false;
    }

    public final boolean d() {
        return this.e.get() != null;
    }

    public final void e(c0 c0Var) {
        this.g = c0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.k.b(this.f167a, dVar.f167a) && kotlin.jvm.internal.k.b(this.b, dVar.b) && kotlin.jvm.internal.k.b(this.c, dVar.c) && kotlin.jvm.internal.k.b(this.d, dVar.d) && kotlin.jvm.internal.k.b(this.e, dVar.e) && kotlin.jvm.internal.k.b(this.f, dVar.f) && kotlin.jvm.internal.k.b(this.g, dVar.g) && this.h == dVar.h && kotlin.jvm.internal.k.b(this.i, dVar.i);
    }

    public final boolean f() {
        return this.h > this.f167a.f168a.getMaxFailureTolerance();
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.h, (((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + androidx.appfunctions.metadata.a.f(this.c, (this.b.hashCode() + (this.f167a.hashCode() * 31)) * 31, 31)) * 31)) * 31)) * 31) + (this.g == null ? 0 : this.g.hashCode())) * 31, 31);
        List list = this.i;
        return Boolean.hashCode(false) + androidx.constraintlayout.core.dsl.a.a(0, (iA + (list == null ? 0 : list.hashCode())) * 31, 31);
    }

    public final String toString() {
        e eVar = this.f167a;
        i iVar = this.b;
        Map map = this.c;
        AtomicBoolean atomicBoolean = this.d;
        AtomicReference atomicReference = this.e;
        InterfaceC1779e interfaceC1779e = this.f;
        c0 c0Var = this.g;
        int i = this.h;
        List list = this.i;
        StringBuilder sb = new StringBuilder("TaskContext(runtime=");
        sb.append(eVar);
        sb.append(", taskInfo=");
        sb.append(iVar);
        sb.append(", stepInfos=");
        sb.append(map);
        sb.append(", stopSignal=");
        sb.append(atomicBoolean);
        sb.append(", pendingTakeoverRequest=");
        sb.append(atomicReference);
        sb.append(", controlEvents=");
        sb.append(interfaceC1779e);
        sb.append(", activeJob=");
        sb.append(c0Var);
        sb.append(", consecutiveFailures=");
        sb.append(i);
        sb.append(", experienceActions=");
        return androidx.appfunctions.metadata.a.q(sb, list, ", experienceIndex=0, enableExperience=false)");
    }
}
