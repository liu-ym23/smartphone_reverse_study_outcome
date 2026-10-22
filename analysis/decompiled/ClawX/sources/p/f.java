package p;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class f implements d {
    public final o d;

    /* renamed from: f, reason: collision with root package name */
    public int f4614f;

    /* renamed from: g, reason: collision with root package name */
    public int f4615g;

    /* renamed from: a, reason: collision with root package name */
    public o f4610a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4611b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4612c = false;

    /* renamed from: e, reason: collision with root package name */
    public int f4613e = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f4616h = 1;

    /* renamed from: i, reason: collision with root package name */
    public g f4617i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4618j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f4619k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f4620l = new ArrayList();

    public f(o oVar) {
        this.d = oVar;
    }

    @Override // p.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f4620l;
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            if (!((f) obj).f4618j) {
                return;
            }
        }
        this.f4612c = true;
        o oVar = this.f4610a;
        if (oVar != null) {
            oVar.a(this);
        }
        if (this.f4611b) {
            this.d.a(this);
            return;
        }
        int size2 = arrayList.size();
        f fVar = null;
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            f fVar2 = (f) obj2;
            if (!(fVar2 instanceof g)) {
                i8++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i8 == 1 && fVar.f4618j) {
            g gVar = this.f4617i;
            if (gVar != null) {
                if (!gVar.f4618j) {
                    return;
                } else {
                    this.f4614f = this.f4616h * gVar.f4615g;
                }
            }
            d(fVar.f4615g + this.f4614f);
        }
        o oVar2 = this.f4610a;
        if (oVar2 != null) {
            oVar2.a(this);
        }
    }

    public final void b(o oVar) {
        this.f4619k.add(oVar);
        if (this.f4618j) {
            oVar.a(oVar);
        }
    }

    public final void c() {
        this.f4620l.clear();
        this.f4619k.clear();
        this.f4618j = false;
        this.f4615g = 0;
        this.f4612c = false;
        this.f4611b = false;
    }

    public void d(int i8) {
        if (this.f4618j) {
            return;
        }
        this.f4618j = true;
        this.f4615g = i8;
        ArrayList arrayList = this.f4619k;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.f4634b.f4224g0);
        sb.append(":");
        switch (this.f4613e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = AbstractJsonLexerKt.NULL;
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f4618j ? Integer.valueOf(this.f4615g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f4620l.size());
        sb.append(":d=");
        sb.append(this.f4619k.size());
        sb.append(">");
        return sb.toString();
    }
}
