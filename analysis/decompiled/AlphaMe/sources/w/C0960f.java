package w;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.ArrayList;
import java.util.Iterator;
import s.AbstractC0831a;

/* renamed from: w.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0960f implements InterfaceC0958d {

    /* renamed from: d, reason: collision with root package name */
    public final p f15755d;

    /* renamed from: f, reason: collision with root package name */
    public int f15757f;

    /* renamed from: g, reason: collision with root package name */
    public int f15758g;

    /* renamed from: a, reason: collision with root package name */
    public p f15752a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15753b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15754c = false;

    /* renamed from: e, reason: collision with root package name */
    public int f15756e = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f15759h = 1;

    /* renamed from: i, reason: collision with root package name */
    public C0961g f15760i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15761j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f15762k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f15763l = new ArrayList();

    public C0960f(p pVar) {
        this.f15755d = pVar;
    }

    @Override // w.InterfaceC0958d
    public final void a(InterfaceC0958d interfaceC0958d) {
        ArrayList arrayList = this.f15763l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((C0960f) it.next()).f15761j) {
                return;
            }
        }
        this.f15754c = true;
        p pVar = this.f15752a;
        if (pVar != null) {
            pVar.a(this);
        }
        if (this.f15753b) {
            this.f15755d.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        C0960f c0960f = null;
        int i4 = 0;
        while (it2.hasNext()) {
            C0960f c0960f2 = (C0960f) it2.next();
            if (!(c0960f2 instanceof C0961g)) {
                i4++;
                c0960f = c0960f2;
            }
        }
        if (c0960f != null && i4 == 1 && c0960f.f15761j) {
            C0961g c0961g = this.f15760i;
            if (c0961g != null) {
                if (!c0961g.f15761j) {
                    return;
                } else {
                    this.f15757f = this.f15759h * c0961g.f15758g;
                }
            }
            d(c0960f.f15758g + this.f15757f);
        }
        p pVar2 = this.f15752a;
        if (pVar2 != null) {
            pVar2.a(this);
        }
    }

    public final void b(InterfaceC0958d interfaceC0958d) {
        this.f15762k.add(interfaceC0958d);
        if (this.f15761j) {
            interfaceC0958d.a(interfaceC0958d);
        }
    }

    public final void c() {
        this.f15763l.clear();
        this.f15762k.clear();
        this.f15761j = false;
        this.f15758g = 0;
        this.f15754c = false;
        this.f15753b = false;
    }

    public void d(int i4) {
        if (this.f15761j) {
            return;
        }
        this.f15761j = true;
        this.f15758g = i4;
        Iterator it = this.f15762k.iterator();
        while (it.hasNext()) {
            InterfaceC0958d interfaceC0958d = (InterfaceC0958d) it.next();
            interfaceC0958d.a(interfaceC0958d);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15755d.f15786b.f15564h0);
        sb.append(AwarenessDataItem.USERID_SPLITTER);
        sb.append(AbstractC0831a.k(this.f15756e));
        sb.append("(");
        sb.append(this.f15761j ? Integer.valueOf(this.f15758g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f15763l.size());
        sb.append(":d=");
        sb.append(this.f15762k.size());
        sb.append(">");
        return sb.toString();
    }
}
