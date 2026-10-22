package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: d, reason: collision with root package name */
    public final n f15537d;

    /* renamed from: f, reason: collision with root package name */
    public int f15539f;

    /* renamed from: g, reason: collision with root package name */
    public int f15540g;

    /* renamed from: a, reason: collision with root package name */
    public n f15534a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15535b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15536c = false;

    /* renamed from: e, reason: collision with root package name */
    public int f15538e = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f15541h = 1;
    public f i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15542j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f15543k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f15544l = new ArrayList();

    public e(n nVar) {
        this.f15537d = nVar;
    }

    @Override // x2.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f15544l;
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (!((e) obj).f15542j) {
                return;
            }
        }
        this.f15536c = true;
        n nVar = this.f15534a;
        if (nVar != null) {
            nVar.a(this);
        }
        if (this.f15535b) {
            this.f15537d.a(this);
            return;
        }
        int size2 = arrayList.size();
        e eVar = null;
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            e eVar2 = (e) obj2;
            if (!(eVar2 instanceof f)) {
                i++;
                eVar = eVar2;
            }
        }
        if (eVar != null && i == 1 && eVar.f15542j) {
            f fVar = this.i;
            if (fVar != null) {
                if (!fVar.f15542j) {
                    return;
                } else {
                    this.f15539f = this.f15541h * fVar.f15540g;
                }
            }
            d(eVar.f15540g + this.f15539f);
        }
        n nVar2 = this.f15534a;
        if (nVar2 != null) {
            nVar2.a(this);
        }
    }

    public final void b(n nVar) {
        this.f15543k.add(nVar);
        if (this.f15542j) {
            nVar.a(nVar);
        }
    }

    public final void c() {
        this.f15544l.clear();
        this.f15543k.clear();
        this.f15542j = false;
        this.f15540g = 0;
        this.f15536c = false;
        this.f15535b = false;
    }

    public void d(int i) {
        if (this.f15542j) {
            return;
        }
        this.f15542j = true;
        this.f15540g = i;
        ArrayList arrayList = this.f15543k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15537d.f15559b.f15169g0);
        sb2.append(":");
        switch (this.f15538e) {
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
                str = "null";
                break;
        }
        sb2.append(str);
        sb2.append("(");
        sb2.append(this.f15542j ? Integer.valueOf(this.f15540g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f15544l.size());
        sb2.append(":d=");
        sb2.append(this.f15543k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
