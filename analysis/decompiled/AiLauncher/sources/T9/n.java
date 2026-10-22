package T9;

import C9.o;
import Z8.C1172u;
import Z8.Q;
import Z9.InterfaceC1178a;
import Z9.InterfaceC1179b;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import ma.AbstractC4927g;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;

/* loaded from: classes5.dex */
public final class n extends c {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f5909h = {t.i(new PropertyReference1Impl(n.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5865h f5910g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(InterfaceC1178a annotation, V9.k c10) {
        super(c10, annotation, o.a.f1860H);
        p.i(annotation, "annotation");
        p.i(c10, "c");
        this.f5910g = c10.e().i(new m(this));
    }

    public static final Map i(n nVar) {
        InterfaceC1179b interfaceC1179bC = nVar.c();
        AbstractC4927g<?> abstractC4927gD = interfaceC1179bC instanceof Z9.e ? f.f5897a.d(((Z9.e) nVar.c()).c()) : interfaceC1179bC instanceof Z9.m ? f.f5897a.d(C1172u.e(nVar.c())) : null;
        Map mapF = abstractC4927gD != null ? Q.f(Y8.j.a(d.f5891a.d(), abstractC4927gD)) : null;
        return mapF == null ? kotlin.collections.a.i() : mapF;
    }

    @Override // T9.c, F9.c
    public Map<ga.e, AbstractC4927g<Object>> a() {
        return (Map) C5868k.a(this.f5910g, this, f5909h[0]);
    }
}
