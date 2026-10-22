package T9;

import C9.o;
import Z8.Q;
import Z9.InterfaceC1178a;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import ma.AbstractC4927g;
import ma.x;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;

/* loaded from: classes5.dex */
public final class h extends c {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f5901h = {t.i(new PropertyReference1Impl(h.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5865h f5902g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(InterfaceC1178a interfaceC1178a, V9.k c10) {
        super(c10, interfaceC1178a, o.a.f1942y);
        p.i(c10, "c");
        this.f5902g = c10.e().i(g.f5900a);
    }

    public static final Map i() {
        return Q.f(Y8.j.a(d.f5891a.b(), new x("Deprecated in Java")));
    }

    @Override // T9.c, F9.c
    public Map<ga.e, AbstractC4927g<?>> a() {
        return (Map) C5868k.a(this.f5902g, this, f5901h[0]);
    }
}
