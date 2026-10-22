package rc;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import org.scilab.forge.jlatexmath.InvalidUnitException;

/* loaded from: classes5.dex */
public class R0 extends AbstractC5276d {

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, Integer> f39151l;

    /* renamed from: m, reason: collision with root package name */
    public static o[] f39152m;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39153d;

    /* renamed from: e, reason: collision with root package name */
    public int f39154e;

    /* renamed from: f, reason: collision with root package name */
    public float f39155f;

    /* renamed from: g, reason: collision with root package name */
    public float f39156g;

    /* renamed from: h, reason: collision with root package name */
    public float f39157h;

    /* renamed from: i, reason: collision with root package name */
    public int f39158i;

    /* renamed from: j, reason: collision with root package name */
    public int f39159j;

    /* renamed from: k, reason: collision with root package name */
    public int f39160k;

    public class a implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 65536.0f) / y02.j();
        }
    }

    public class b implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 0.996264f) / y02.j();
        }
    }

    public class c implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 1.0660349f) / y02.j();
        }
    }

    public class d implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 12.792419f) / y02.j();
        }
    }

    public class e implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return y02.n().N(y02.m());
        }
    }

    public class f implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return y02.n().m(y02.m());
        }
    }

    public class g implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return y02.n().t(y02.m(), y02.h());
        }
    }

    public class h implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return 1.0f / y02.j();
        }
    }

    public class i implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return a1.f39201g / y02.j();
        }
    }

    public class j implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 12.0f) / y02.j();
        }
    }

    public class k implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            Z0 z0N = y02.n();
            return z0N.O(y02.m(), z0N.I()) / 18.0f;
        }
    }

    public class l implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 28.346457f) / y02.j();
        }
    }

    public class m implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 2.8346457f) / y02.j();
        }
    }

    public class n implements o {
        @Override // rc.R0.o
        public float a(Y0 y02) {
            return (a1.f39201g * 72.0f) / y02.j();
        }
    }

    public interface o {
        float a(Y0 y02);
    }

    static {
        HashMap map = new HashMap();
        f39151l = map;
        map.put("em", 0);
        f39151l.put(Const.LBS_FAIL_BD_EX, 1);
        f39151l.put("px", 2);
        f39151l.put("pix", 2);
        f39151l.put("pixel", 2);
        f39151l.put("pt", 10);
        f39151l.put("bp", 3);
        f39151l.put("pica", 4);
        f39151l.put("pc", 4);
        f39151l.put("mu", 5);
        f39151l.put("cm", 6);
        f39151l.put("mm", 7);
        f39151l.put("in", 8);
        f39151l.put("sp", 9);
        f39151l.put("dd", 11);
        f39151l.put("cc", 12);
        f39152m = new o[]{new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m(), new n(), new a(), new b(), new c(), new d(), new e()};
    }

    public R0() {
        this.f39153d = true;
    }

    public static void i(int i10) throws InvalidUnitException {
        if (i10 < 0 || i10 >= f39152m.length) {
            throw new InvalidUnitException();
        }
    }

    public static float j(int i10, Y0 y02) {
        return f39152m[i10].a(y02);
    }

    public static float[] k(String str) {
        if (str == null) {
            return new float[]{2.0f, 0.0f};
        }
        int i10 = 0;
        while (i10 < str.length() && !Character.isLetter(str.charAt(i10))) {
            i10++;
        }
        try {
            return new float[]{i10 != str.length() ? n(str.substring(i10).toLowerCase()) : 2, Float.parseFloat(str.substring(0, i10))};
        } catch (NumberFormatException unused) {
            return new float[]{Float.NaN};
        }
    }

    public static int n(String str) {
        Integer num = f39151l.get(str);
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        if (!this.f39153d) {
            return new U0(this.f39155f * j(this.f39158i, y02), this.f39156g * j(this.f39159j, y02), this.f39157h * j(this.f39160k, y02), 0.0f);
        }
        int i10 = this.f39154e;
        if (i10 == 0) {
            return new U0(y02.l(), 0.0f, 0.0f, 0.0f);
        }
        if (i10 < 0) {
            i10 = -i10;
        }
        AbstractC5284h abstractC5284hB = i10 == 1 ? K.b(7, 1, y02) : i10 == 2 ? K.b(2, 1, y02) : K.b(3, 1, y02);
        if (this.f39154e < 0) {
            abstractC5284hB.l();
        }
        return abstractC5284hB;
    }

    public R0(int i10) {
        this.f39153d = true;
        this.f39154e = i10;
    }

    public R0(int i10, float f10, float f11, float f12) throws InvalidUnitException {
        i(i10);
        this.f39158i = i10;
        this.f39159j = i10;
        this.f39160k = i10;
        this.f39155f = f10;
        this.f39156g = f11;
        this.f39157h = f12;
    }
}
