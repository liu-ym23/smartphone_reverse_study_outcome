package v;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import s.C1045c;
import s.i;
import w.o;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private int f23000b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f23001c;

    /* renamed from: d, reason: collision with root package name */
    public final e f23002d;

    /* renamed from: e, reason: collision with root package name */
    public final b f23003e;

    /* renamed from: f, reason: collision with root package name */
    public d f23004f;

    /* renamed from: i, reason: collision with root package name */
    s.i f23007i;

    /* renamed from: a, reason: collision with root package name */
    private HashSet<d> f22999a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f23005g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f23006h = Integer.MIN_VALUE;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23008a;

        static {
            int[] iArr = new int[b.values().length];
            f23008a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23008a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23008a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23008a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23008a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23008a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23008a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23008a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23008a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f23002d = eVar;
        this.f23003e = bVar;
    }

    public boolean a(d dVar, int i5) {
        return b(dVar, i5, Integer.MIN_VALUE, false);
    }

    public boolean b(d dVar, int i5, int i6, boolean z5) {
        if (dVar == null) {
            q();
            return true;
        }
        if (!z5 && !p(dVar)) {
            return false;
        }
        this.f23004f = dVar;
        if (dVar.f22999a == null) {
            dVar.f22999a = new HashSet<>();
        }
        HashSet<d> hashSet = this.f23004f.f22999a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f23005g = i5;
        this.f23006h = i6;
        return true;
    }

    public void c(int i5, ArrayList<o> arrayList, o oVar) {
        HashSet<d> hashSet = this.f22999a;
        if (hashSet != null) {
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                w.i.a(it.next().f23002d, i5, arrayList, oVar);
            }
        }
    }

    public HashSet<d> d() {
        return this.f22999a;
    }

    public int e() {
        if (this.f23001c) {
            return this.f23000b;
        }
        return 0;
    }

    public int f() {
        d dVar;
        if (this.f23002d.V() == 8) {
            return 0;
        }
        return (this.f23006h == Integer.MIN_VALUE || (dVar = this.f23004f) == null || dVar.f23002d.V() != 8) ? this.f23005g : this.f23006h;
    }

    public final d g() {
        switch (a.f23008a[this.f23003e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return null;
            case 2:
                return this.f23002d.f23046Q;
            case 3:
                return this.f23002d.f23044O;
            case 4:
                return this.f23002d.f23047R;
            case 5:
                return this.f23002d.f23045P;
            default:
                throw new AssertionError(this.f23003e.name());
        }
    }

    public e h() {
        return this.f23002d;
    }

    public s.i i() {
        return this.f23007i;
    }

    public d j() {
        return this.f23004f;
    }

    public b k() {
        return this.f23003e;
    }

    public boolean l() {
        HashSet<d> hashSet = this.f22999a;
        if (hashSet == null) {
            return false;
        }
        Iterator<d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<d> hashSet = this.f22999a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.f23001c;
    }

    public boolean o() {
        return this.f23004f != null;
    }

    public boolean p(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarK = dVar.k();
        b bVar = this.f23003e;
        if (bVarK == bVar) {
            return bVar != b.BASELINE || (dVar.h().Z() && h().Z());
        }
        switch (a.f23008a[bVar.ordinal()]) {
            case 1:
                return (bVarK == b.BASELINE || bVarK == b.CENTER_X || bVarK == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z5 = bVarK == b.LEFT || bVarK == b.RIGHT;
                return dVar.h() instanceof h ? z5 || bVarK == b.CENTER_X : z5;
            case 4:
            case 5:
                boolean z6 = bVarK == b.TOP || bVarK == b.BOTTOM;
                return dVar.h() instanceof h ? z6 || bVarK == b.CENTER_Y : z6;
            case 6:
                return (bVarK == b.LEFT || bVarK == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return false;
            default:
                throw new AssertionError(this.f23003e.name());
        }
    }

    public void q() {
        HashSet<d> hashSet;
        d dVar = this.f23004f;
        if (dVar != null && (hashSet = dVar.f22999a) != null) {
            hashSet.remove(this);
            if (this.f23004f.f22999a.size() == 0) {
                this.f23004f.f22999a = null;
            }
        }
        this.f22999a = null;
        this.f23004f = null;
        this.f23005g = 0;
        this.f23006h = Integer.MIN_VALUE;
        this.f23001c = false;
        this.f23000b = 0;
    }

    public void r() {
        this.f23001c = false;
        this.f23000b = 0;
    }

    public void s(C1045c c1045c) {
        s.i iVar = this.f23007i;
        if (iVar == null) {
            this.f23007i = new s.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.h();
        }
    }

    public void t(int i5) {
        this.f23000b = i5;
        this.f23001c = true;
    }

    public String toString() {
        return this.f23002d.t() + ":" + this.f23003e.toString();
    }

    public void u(int i5) {
        if (o()) {
            this.f23006h = i5;
        }
    }
}
