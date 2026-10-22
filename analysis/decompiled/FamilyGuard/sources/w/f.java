package w;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f implements InterfaceC1198d {

    /* renamed from: d, reason: collision with root package name */
    p f23419d;

    /* renamed from: f, reason: collision with root package name */
    int f23421f;

    /* renamed from: g, reason: collision with root package name */
    public int f23422g;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1198d f23416a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f23417b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23418c = false;

    /* renamed from: e, reason: collision with root package name */
    a f23420e = a.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    int f23423h = 1;

    /* renamed from: i, reason: collision with root package name */
    g f23424i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23425j = false;

    /* renamed from: k, reason: collision with root package name */
    List<InterfaceC1198d> f23426k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    List<f> f23427l = new ArrayList();

    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f23419d = pVar;
    }

    @Override // w.InterfaceC1198d
    public void a(InterfaceC1198d interfaceC1198d) {
        Iterator<f> it = this.f23427l.iterator();
        while (it.hasNext()) {
            if (!it.next().f23425j) {
                return;
            }
        }
        this.f23418c = true;
        InterfaceC1198d interfaceC1198d2 = this.f23416a;
        if (interfaceC1198d2 != null) {
            interfaceC1198d2.a(this);
        }
        if (this.f23417b) {
            this.f23419d.a(this);
            return;
        }
        f fVar = null;
        int i5 = 0;
        for (f fVar2 : this.f23427l) {
            if (!(fVar2 instanceof g)) {
                i5++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i5 == 1 && fVar.f23425j) {
            g gVar = this.f23424i;
            if (gVar != null) {
                if (!gVar.f23425j) {
                    return;
                } else {
                    this.f23421f = this.f23423h * gVar.f23422g;
                }
            }
            d(fVar.f23422g + this.f23421f);
        }
        InterfaceC1198d interfaceC1198d3 = this.f23416a;
        if (interfaceC1198d3 != null) {
            interfaceC1198d3.a(this);
        }
    }

    public void b(InterfaceC1198d interfaceC1198d) {
        this.f23426k.add(interfaceC1198d);
        if (this.f23425j) {
            interfaceC1198d.a(interfaceC1198d);
        }
    }

    public void c() {
        this.f23427l.clear();
        this.f23426k.clear();
        this.f23425j = false;
        this.f23422g = 0;
        this.f23418c = false;
        this.f23417b = false;
    }

    public void d(int i5) {
        if (this.f23425j) {
            return;
        }
        this.f23425j = true;
        this.f23422g = i5;
        for (InterfaceC1198d interfaceC1198d : this.f23426k) {
            interfaceC1198d.a(interfaceC1198d);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23419d.f23470b.t());
        sb.append(":");
        sb.append(this.f23420e);
        sb.append("(");
        sb.append(this.f23425j ? Integer.valueOf(this.f23422g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f23427l.size());
        sb.append(":d=");
        sb.append(this.f23426k.size());
        sb.append(">");
        return sb.toString();
    }
}
