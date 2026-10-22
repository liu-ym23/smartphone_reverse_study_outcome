package ea;

import Z8.C1168p;
import Z8.C1173v;
import Z8.F;
import Z8.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.p;

/* renamed from: ea.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4017a {

    /* renamed from: f, reason: collision with root package name */
    public static final C0395a f32349f = new C0395a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f32350a;

    /* renamed from: b, reason: collision with root package name */
    public final int f32351b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32352c;

    /* renamed from: d, reason: collision with root package name */
    public final int f32353d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Integer> f32354e;

    /* renamed from: ea.a$a, reason: collision with other inner class name */
    public static final class C0395a {
        public /* synthetic */ C0395a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public C0395a() {
        }
    }

    public AbstractC4017a(int... numbers) {
        List<Integer> listM;
        p.i(numbers, "numbers");
        this.f32350a = numbers;
        Integer numI0 = r.i0(numbers, 0);
        this.f32351b = numI0 != null ? numI0.intValue() : -1;
        Integer numI02 = r.i0(numbers, 1);
        this.f32352c = numI02 != null ? numI02.intValue() : -1;
        Integer numI03 = r.i0(numbers, 2);
        this.f32353d = numI03 != null ? numI03.intValue() : -1;
        if (numbers.length <= 3) {
            listM = C1173v.m();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + '.');
            }
            listM = F.m1(C1168p.c(numbers).subList(3, numbers.length));
        }
        this.f32354e = listM;
    }

    public final int a() {
        return this.f32351b;
    }

    public final int b() {
        return this.f32352c;
    }

    public final boolean c(int i10, int i11, int i12) {
        int i13 = this.f32351b;
        if (i13 > i10) {
            return true;
        }
        if (i13 < i10) {
            return false;
        }
        int i14 = this.f32352c;
        if (i14 > i11) {
            return true;
        }
        return i14 >= i11 && this.f32353d >= i12;
    }

    public final boolean d(AbstractC4017a version) {
        p.i(version, "version");
        return c(version.f32351b, version.f32352c, version.f32353d);
    }

    public final boolean e(int i10, int i11, int i12) {
        int i13 = this.f32351b;
        if (i13 < i10) {
            return true;
        }
        if (i13 > i10) {
            return false;
        }
        int i14 = this.f32352c;
        if (i14 < i11) {
            return true;
        }
        return i14 <= i11 && this.f32353d <= i12;
    }

    public boolean equals(Object obj) {
        if (obj == null || !p.d(getClass(), obj.getClass())) {
            return false;
        }
        AbstractC4017a abstractC4017a = (AbstractC4017a) obj;
        return this.f32351b == abstractC4017a.f32351b && this.f32352c == abstractC4017a.f32352c && this.f32353d == abstractC4017a.f32353d && p.d(this.f32354e, abstractC4017a.f32354e);
    }

    public final boolean f(AbstractC4017a ourVersion) {
        p.i(ourVersion, "ourVersion");
        int i10 = this.f32351b;
        return i10 == 0 ? ourVersion.f32351b == 0 && this.f32352c == ourVersion.f32352c : i10 == ourVersion.f32351b && this.f32352c <= ourVersion.f32352c;
    }

    public final int[] g() {
        return this.f32350a;
    }

    public int hashCode() {
        int i10 = this.f32351b;
        int i11 = i10 + (i10 * 31) + this.f32352c;
        int i12 = i11 + (i11 * 31) + this.f32353d;
        return i12 + (i12 * 31) + this.f32354e.hashCode();
    }

    public String toString() {
        int[] iArrG = g();
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArrG) {
            if (i10 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList.isEmpty() ? "unknown" : F.A0(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
