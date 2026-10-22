package wa;

import F9.g;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import p9.InterfaceC5063a;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* renamed from: wa.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5777a implements F9.g {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f43178b = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C5777a.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5865h f43179a;

    public C5777a(InterfaceC5869l storageManager, InterfaceC5063a<? extends List<? extends F9.c>> compute) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(compute, "compute");
        this.f43179a = storageManager.i(compute);
    }

    private final List<F9.c> b() {
        return (List) C5868k.a(this.f43179a, this, f43178b[0]);
    }

    @Override // F9.g
    public /* bridge */ boolean E(ga.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // F9.g
    public /* bridge */ F9.c d(ga.c cVar) {
        return g.b.a(this, cVar);
    }

    @Override // F9.g
    public boolean isEmpty() {
        return b().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<F9.c> iterator() {
        return b().iterator();
    }
}
