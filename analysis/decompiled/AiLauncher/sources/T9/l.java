package T9;

import C9.o;
import Z8.Q;
import Z9.InterfaceC1178a;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import ma.AbstractC4927g;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;

/* loaded from: classes5.dex */
public final class l extends c {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f5906h = {t.i(new PropertyReference1Impl(l.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5865h f5907g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(InterfaceC1178a annotation, V9.k c10) {
        super(c10, annotation, o.a.f1868L);
        p.i(annotation, "annotation");
        p.i(c10, "c");
        this.f5907g = c10.e().i(new k(this));
    }

    public static final Map i(l lVar) {
        AbstractC4927g<?> abstractC4927gB = f.f5897a.b(lVar.c());
        Map mapF = abstractC4927gB != null ? Q.f(Y8.j.a(d.f5891a.c(), abstractC4927gB)) : null;
        return mapF == null ? kotlin.collections.a.i() : mapF;
    }

    @Override // T9.c, F9.c
    public Map<ga.e, AbstractC4927g<?>> a() {
        return (Map) C5868k.a(this.f5907g, this, f5906h[0]);
    }
}
