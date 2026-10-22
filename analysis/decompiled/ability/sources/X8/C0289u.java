package X8;

import java.util.Comparator;

/* renamed from: X8.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0289u implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S7.k f1535a;

    public C0289u(S7.k kVar) {
        this.f1535a = kVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        w wVar = (w) obj;
        kotlin.jvm.internal.k.c(wVar);
        S7.k kVar = this.f1535a;
        String string = kVar.invoke(wVar).toString();
        w wVar2 = (w) obj2;
        kotlin.jvm.internal.k.c(wVar2);
        return N9.j.m(string, kVar.invoke(wVar2).toString());
    }
}
