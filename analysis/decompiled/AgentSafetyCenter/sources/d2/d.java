package d2;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Appendable {

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f3071c = new StringBuilder(16);

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3072f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f3073g = new ArrayList();

    public d() {
        new ArrayList();
    }

    public final void a(e0 e0Var, int i, int i3) {
        this.f3073g.add(new c(e0Var, i, i3, 8));
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i3) {
        boolean z10 = charSequence instanceof g;
        StringBuilder sb2 = this.f3071c;
        if (!z10) {
            sb2.append(charSequence, i, i3);
            return this;
        }
        g gVar = (g) charSequence;
        int length = sb2.length();
        sb2.append((CharSequence) gVar.f3101f, i, i3);
        List listA = h.a(gVar, i, i3, null);
        if (listA != null) {
            int size = listA.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = (e) listA.get(i10);
                this.f3073g.add(new c(eVar.f3078b + length, eVar.f3079c + length, eVar.f3077a, eVar.f3080d));
            }
        }
        return this;
    }

    public final void b(g gVar) {
        StringBuilder sb2 = this.f3071c;
        int length = sb2.length();
        sb2.append(gVar.f3101f);
        List list = gVar.f3100c;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) list.get(i);
                this.f3073g.add(new c(eVar.f3078b + length, eVar.f3079c + length, eVar.f3077a, eVar.f3080d));
            }
        }
    }

    public final void c() {
        ArrayList arrayList = this.f3072f;
        if (arrayList.isEmpty()) {
            i2.a.b("Nothing to pop.");
        }
        ((c) arrayList.remove(arrayList.size() - 1)).f3047c = this.f3071c.length();
    }

    public final void d(int i) {
        ArrayList arrayList = this.f3072f;
        if (i >= arrayList.size()) {
            i2.a.b(i + " should be less than " + arrayList.size());
        }
        while (arrayList.size() - 1 >= i) {
            c();
        }
    }

    public final g e() {
        StringBuilder sb2 = this.f3071c;
        String string = sb2.toString();
        ArrayList arrayList = this.f3073g;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) arrayList.get(i);
            int length = sb2.length();
            int i3 = cVar.f3047c;
            if (i3 != Integer.MIN_VALUE) {
                length = i3;
            }
            if (length == Integer.MIN_VALUE) {
                i2.a.b("Item.end should be set first");
            }
            arrayList2.add(new e(cVar.f3046b, length, cVar.f3045a, cVar.f3048d));
        }
        return new g(string, arrayList2);
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence instanceof g) {
            b((g) charSequence);
            return this;
        }
        this.f3071c.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c9) {
        this.f3071c.append(c9);
        return this;
    }
}
