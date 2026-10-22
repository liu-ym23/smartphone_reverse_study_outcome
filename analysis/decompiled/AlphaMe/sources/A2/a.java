package A2;

import com.airbnb.lottie.h;
import java.util.Iterator;
import java.util.List;
import s2.C0855a;
import s2.b;
import s2.c;
import z2.InterfaceC1006a;

/* loaded from: classes.dex */
public final class a implements InterfaceC1006a {

    /* renamed from: a, reason: collision with root package name */
    public final C0855a f56a;

    /* renamed from: b, reason: collision with root package name */
    public final List f57b;

    /* renamed from: c, reason: collision with root package name */
    public final b f58c;

    /* renamed from: d, reason: collision with root package name */
    public int f59d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f61f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f62g;

    /* renamed from: h, reason: collision with root package name */
    public int f63h;

    /* renamed from: i, reason: collision with root package name */
    public int f64i;

    /* renamed from: j, reason: collision with root package name */
    public int f65j;

    /* renamed from: k, reason: collision with root package name */
    public int f66k;

    /* renamed from: l, reason: collision with root package name */
    public int f67l;

    /* renamed from: m, reason: collision with root package name */
    public int f68m;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f60e = new int[4];

    /* renamed from: n, reason: collision with root package name */
    public final int[] f69n = new int[1];

    public a(C0855a c0855a, List list, b bVar) {
        this.f56a = c0855a;
        this.f57b = list;
        this.f58c = bVar;
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        h.k(this.f56a);
        Iterator it = this.f57b.iterator();
        while (it.hasNext()) {
            h.k((c) it.next());
        }
        h.k(this.f58c);
    }
}
