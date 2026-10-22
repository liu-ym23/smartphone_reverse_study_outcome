package w;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class o {

    /* renamed from: g, reason: collision with root package name */
    static int f23454g;

    /* renamed from: b, reason: collision with root package name */
    int f23456b;

    /* renamed from: d, reason: collision with root package name */
    int f23458d;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<v.e> f23455a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    boolean f23457c = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<a> f23459e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f23460f = -1;

    class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<v.e> f23461a;

        /* renamed from: b, reason: collision with root package name */
        int f23462b;

        /* renamed from: c, reason: collision with root package name */
        int f23463c;

        /* renamed from: d, reason: collision with root package name */
        int f23464d;

        /* renamed from: e, reason: collision with root package name */
        int f23465e;

        /* renamed from: f, reason: collision with root package name */
        int f23466f;

        /* renamed from: g, reason: collision with root package name */
        int f23467g;

        public a(v.e eVar, s.d dVar, int i5) {
            this.f23461a = new WeakReference<>(eVar);
            this.f23462b = dVar.x(eVar.f23044O);
            this.f23463c = dVar.x(eVar.f23045P);
            this.f23464d = dVar.x(eVar.f23046Q);
            this.f23465e = dVar.x(eVar.f23047R);
            this.f23466f = dVar.x(eVar.f23048S);
            this.f23467g = i5;
        }
    }

    public o(int i5) {
        int i6 = f23454g;
        f23454g = i6 + 1;
        this.f23456b = i6;
        this.f23458d = i5;
    }

    private String e() {
        int i5 = this.f23458d;
        return i5 == 0 ? "Horizontal" : i5 == 1 ? "Vertical" : i5 == 2 ? "Both" : "Unknown";
    }

    private int j(s.d dVar, ArrayList<v.e> arrayList, int i5) {
        int iX;
        int iX2;
        v.f fVar = (v.f) arrayList.get(0).K();
        dVar.D();
        fVar.g(dVar, false);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.get(i6).g(dVar, false);
        }
        if (i5 == 0 && fVar.f23125W0 > 0) {
            v.b.b(fVar, dVar, arrayList, 0);
        }
        if (i5 == 1 && fVar.f23126X0 > 0) {
            v.b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f23459e = new ArrayList<>();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            this.f23459e.add(new a(arrayList.get(i7), dVar, i5));
        }
        if (i5 == 0) {
            iX = dVar.x(fVar.f23044O);
            iX2 = dVar.x(fVar.f23046Q);
            dVar.D();
        } else {
            iX = dVar.x(fVar.f23045P);
            iX2 = dVar.x(fVar.f23047R);
            dVar.D();
        }
        return iX2 - iX;
    }

    public boolean a(v.e eVar) {
        if (this.f23455a.contains(eVar)) {
            return false;
        }
        this.f23455a.add(eVar);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int size = this.f23455a.size();
        if (this.f23460f != -1 && size > 0) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                o oVar = arrayList.get(i5);
                if (this.f23460f == oVar.f23456b) {
                    g(this.f23458d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f23456b;
    }

    public int d() {
        return this.f23458d;
    }

    public int f(s.d dVar, int i5) {
        if (this.f23455a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f23455a, i5);
    }

    public void g(int i5, o oVar) {
        ArrayList<v.e> arrayList = this.f23455a;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            v.e eVar = arrayList.get(i6);
            i6++;
            v.e eVar2 = eVar;
            oVar.a(eVar2);
            if (i5 == 0) {
                eVar2.f23037I0 = oVar.c();
            } else {
                eVar2.f23039J0 = oVar.c();
            }
        }
        this.f23460f = oVar.f23456b;
    }

    public void h(boolean z5) {
        this.f23457c = z5;
    }

    public void i(int i5) {
        this.f23458d = i5;
    }

    public String toString() {
        String str = e() + " [" + this.f23456b + "] <";
        ArrayList<v.e> arrayList = this.f23455a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            v.e eVar = arrayList.get(i5);
            i5++;
            str = str + " " + eVar.t();
        }
        return str + " >";
    }
}
