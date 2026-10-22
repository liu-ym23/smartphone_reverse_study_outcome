package l0;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import o0.C0896i;
import q0.C0938A;
import q0.C0947J;
import q0.U;
import q0.b0;

/* loaded from: classes.dex */
public class g implements c {

    /* renamed from: g, reason: collision with root package name */
    private static ConcurrentMap<String, g> f18033g = new ConcurrentHashMap(128, 0.75f, 1);

    /* renamed from: a, reason: collision with root package name */
    private final String f18034a;

    /* renamed from: b, reason: collision with root package name */
    private B[] f18035b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18036c;

    /* renamed from: d, reason: collision with root package name */
    private b0 f18037d;

    /* renamed from: e, reason: collision with root package name */
    private C0896i f18038e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18039f;

    static class A extends v {

        /* renamed from: f, reason: collision with root package name */
        private final Pattern f18040f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18041g;

        public A(String str, boolean z5, String str2, boolean z6) {
            super(str, z5);
            this.f18040f = Pattern.compile(str2);
            this.f18041g = z6;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null) {
                return false;
            }
            boolean zMatches = this.f18040f.matcher(objB.toString()).matches();
            return this.f18041g ? !zMatches : zMatches;
        }
    }

    interface B {
        Object a(g gVar, Object obj, Object obj2);
    }

    static class C implements B {

        /* renamed from: a, reason: collision with root package name */
        public static final C f18042a = new C();

        C() {
        }

        @Override // l0.g.B
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(g gVar, Object obj, Object obj2) {
            return Integer.valueOf(gVar.g(obj2));
        }
    }

    static class D extends v {

        /* renamed from: f, reason: collision with root package name */
        private final String[] f18043f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18044g;

        public D(String str, boolean z5, String[] strArr, boolean z6) {
            super(str, z5);
            this.f18043f = strArr;
            this.f18044g = z6;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            boolean z5;
            Object objB = b(gVar, obj, obj3);
            for (String str : this.f18043f) {
                if (str == objB) {
                    z5 = this.f18044g;
                } else if (str != null && str.equals(objB)) {
                    z5 = this.f18044g;
                }
                return !z5;
            }
            return this.f18044g;
        }
    }

    static class E extends v {

        /* renamed from: f, reason: collision with root package name */
        private final String f18045f;

        /* renamed from: g, reason: collision with root package name */
        private final u f18046g;

        public E(String str, boolean z5, String str2, u uVar) {
            super(str, z5);
            this.f18045f = str2;
            this.f18046g = uVar;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            u uVar = this.f18046g;
            if (uVar == u.EQ) {
                return this.f18045f.equals(objB);
            }
            if (uVar == u.NE) {
                return !this.f18045f.equals(objB);
            }
            if (objB == null) {
                return false;
            }
            int iCompareTo = this.f18045f.compareTo(objB.toString());
            u uVar2 = this.f18046g;
            return uVar2 == u.GE ? iCompareTo <= 0 : uVar2 == u.GT ? iCompareTo < 0 : uVar2 == u.LE ? iCompareTo >= 0 : uVar2 == u.LT && iCompareTo > 0;
        }
    }

    static class F implements B {

        /* renamed from: a, reason: collision with root package name */
        public static final F f18047a = new F();

        F() {
        }

        @Override // l0.g.B
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(g gVar, Object obj, Object obj2) {
            return obj2 == null ? "null" : obj2 instanceof Collection ? "array" : obj2 instanceof Number ? "number" : obj2 instanceof Boolean ? "boolean" : ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) ? "string" : "object";
        }
    }

    static class G extends v {

        /* renamed from: f, reason: collision with root package name */
        private final Object f18048f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f18049g;

        public G(String str, boolean z5, Object obj, boolean z6) {
            super(str, z5);
            this.f18049g = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.f18048f = obj;
            this.f18049g = z6;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            boolean zEquals = this.f18048f.equals(b(gVar, obj, obj3));
            return !this.f18049g ? !zEquals : zEquals;
        }
    }

    static class H implements B {

        /* renamed from: c, reason: collision with root package name */
        public static final H f18050c = new H(false, false);

        /* renamed from: d, reason: collision with root package name */
        public static final H f18051d = new H(true, false);

        /* renamed from: e, reason: collision with root package name */
        public static final H f18052e = new H(true, true);

        /* renamed from: a, reason: collision with root package name */
        private boolean f18053a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f18054b;

        private H(boolean z5, boolean z6) {
            this.f18053a = z5;
            this.f18054b = z6;
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            if (!this.f18053a) {
                return gVar.l(obj2);
            }
            ArrayList arrayList = new ArrayList();
            gVar.c(obj2, arrayList);
            return arrayList;
        }
    }

    /* renamed from: l0.g$a, reason: case insensitive filesystem */
    static /* synthetic */ class C0824a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18055a;

        static {
            int[] iArr = new int[u.values().length];
            f18055a = iArr;
            try {
                iArr[u.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18055a[u.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18055a[u.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18055a[u.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18055a[u.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18055a[u.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: l0.g$b, reason: case insensitive filesystem */
    static class C0825b implements B {

        /* renamed from: a, reason: collision with root package name */
        private final int f18056a;

        public C0825b(int i5) {
            this.f18056a = i5;
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            return gVar.h(obj2, this.f18056a);
        }
    }

    /* renamed from: l0.g$c, reason: case insensitive filesystem */
    static class C0826c extends v {

        /* renamed from: f, reason: collision with root package name */
        private final double f18057f;

        /* renamed from: g, reason: collision with root package name */
        private final u f18058g;

        public C0826c(String str, boolean z5, double d6, u uVar) {
            super(str, z5);
            this.f18057f = d6;
            this.f18058g = uVar;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null || !(objB instanceof Number)) {
                return false;
            }
            double dDoubleValue = ((Number) objB).doubleValue();
            switch (C0824a.f18055a[this.f18058g.ordinal()]) {
                case 1:
                    if (dDoubleValue == this.f18057f) {
                    }
                    break;
                case 2:
                    if (dDoubleValue != this.f18057f) {
                    }
                    break;
                case 3:
                    if (dDoubleValue >= this.f18057f) {
                    }
                    break;
                case 4:
                    if (dDoubleValue > this.f18057f) {
                    }
                    break;
                case 5:
                    if (dDoubleValue <= this.f18057f) {
                    }
                    break;
                case 6:
                    if (dDoubleValue < this.f18057f) {
                    }
                    break;
            }
            return false;
        }
    }

    /* renamed from: l0.g$d, reason: case insensitive filesystem */
    interface InterfaceC0827d {
        boolean a(g gVar, Object obj, Object obj2, Object obj3);
    }

    /* renamed from: l0.g$e, reason: case insensitive filesystem */
    static class C0828e implements InterfaceC0827d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f18059a;

        /* renamed from: b, reason: collision with root package name */
        private List<InterfaceC0827d> f18060b;

        public C0828e(InterfaceC0827d interfaceC0827d, InterfaceC0827d interfaceC0827d2, boolean z5) {
            ArrayList arrayList = new ArrayList(2);
            this.f18060b = arrayList;
            arrayList.add(interfaceC0827d);
            this.f18060b.add(interfaceC0827d2);
            this.f18059a = z5;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            if (this.f18059a) {
                Iterator<InterfaceC0827d> it = this.f18060b.iterator();
                while (it.hasNext()) {
                    if (!it.next().a(gVar, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<InterfaceC0827d> it2 = this.f18060b.iterator();
            while (it2.hasNext()) {
                if (it2.next().a(gVar, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: l0.g$f, reason: case insensitive filesystem */
    public static class C0829f implements B {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0827d f18061a;

        public C0829f(InterfaceC0827d interfaceC0827d) {
            this.f18061a = interfaceC0827d;
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            C0823b c0823b = new C0823b();
            if (!(obj2 instanceof Iterable)) {
                if (this.f18061a.a(gVar, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.f18061a.a(gVar, obj, obj2, obj3)) {
                    c0823b.add(obj3);
                }
            }
            return c0823b;
        }
    }

    /* renamed from: l0.g$g, reason: collision with other inner class name */
    static class C0225g implements B {

        /* renamed from: a, reason: collision with root package name */
        public static final C0225g f18062a = new C0225g();

        C0225g() {
        }

        private static Object b(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                return Double.valueOf(Math.floor(((Float) obj).floatValue()));
            }
            if (obj instanceof Double) {
                return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
            }
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            if (!(obj2 instanceof C0823b)) {
                return b(obj2);
            }
            C0823b c0823b = (C0823b) ((C0823b) obj2).clone();
            for (int i5 = 0; i5 < c0823b.size(); i5++) {
                Object obj3 = c0823b.get(i5);
                Object objB = b(obj3);
                if (objB != obj3) {
                    c0823b.set(i5, objB);
                }
            }
            return c0823b;
        }
    }

    /* renamed from: l0.g$h, reason: case insensitive filesystem */
    static class C0830h extends v {

        /* renamed from: f, reason: collision with root package name */
        private final long f18063f;

        /* renamed from: g, reason: collision with root package name */
        private final long f18064g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f18065h;

        public C0830h(String str, boolean z5, long j5, long j6, boolean z6) {
            super(str, z5);
            this.f18063f = j5;
            this.f18064g = j6;
            this.f18065h = z6;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null) {
                return false;
            }
            if (objB instanceof Number) {
                long jC0 = u0.o.C0((Number) objB);
                if (jC0 >= this.f18063f && jC0 <= this.f18064g) {
                    return !this.f18065h;
                }
            }
            return this.f18065h;
        }
    }

    static class i extends v {

        /* renamed from: f, reason: collision with root package name */
        private final long[] f18066f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18067g;

        public i(String str, boolean z5, long[] jArr, boolean z6) {
            super(str, z5);
            this.f18066f = jArr;
            this.f18067g = z6;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null) {
                return false;
            }
            if (objB instanceof Number) {
                long jC0 = u0.o.C0((Number) objB);
                for (long j5 : this.f18066f) {
                    if (j5 == jC0) {
                        return !this.f18067g;
                    }
                }
            }
            return this.f18067g;
        }
    }

    static class j extends v {

        /* renamed from: f, reason: collision with root package name */
        private final Long[] f18068f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f18069g;

        public j(String str, boolean z5, Long[] lArr, boolean z6) {
            super(str, z5);
            this.f18068f = lArr;
            this.f18069g = z6;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            boolean z5;
            Object objB = b(gVar, obj, obj3);
            int i5 = 0;
            if (objB == null) {
                Long[] lArr = this.f18068f;
                int length = lArr.length;
                while (i5 < length) {
                    if (lArr[i5] == null) {
                        z5 = this.f18069g;
                    } else {
                        i5++;
                    }
                }
                return this.f18069g;
            }
            if (objB instanceof Number) {
                long jC0 = u0.o.C0((Number) objB);
                Long[] lArr2 = this.f18068f;
                int length2 = lArr2.length;
                while (i5 < length2) {
                    Long l5 = lArr2[i5];
                    if (l5 != null && l5.longValue() == jC0) {
                        z5 = this.f18069g;
                    } else {
                        i5++;
                    }
                }
            }
            return this.f18069g;
            return !z5;
        }
    }

    static class k extends v {

        /* renamed from: f, reason: collision with root package name */
        private final long f18070f;

        /* renamed from: g, reason: collision with root package name */
        private final u f18071g;

        /* renamed from: h, reason: collision with root package name */
        private BigDecimal f18072h;

        /* renamed from: i, reason: collision with root package name */
        private Float f18073i;

        /* renamed from: j, reason: collision with root package name */
        private Double f18074j;

        public k(String str, boolean z5, long j5, u uVar) {
            super(str, z5);
            this.f18070f = j5;
            this.f18071g = uVar;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null || !(objB instanceof Number)) {
                return false;
            }
            if (objB instanceof BigDecimal) {
                if (this.f18072h == null) {
                    this.f18072h = BigDecimal.valueOf(this.f18070f);
                }
                int iCompareTo = this.f18072h.compareTo((BigDecimal) objB);
                switch (C0824a.f18055a[this.f18071g.ordinal()]) {
                    case 1:
                        if (iCompareTo == 0) {
                        }
                        break;
                    case 2:
                        if (iCompareTo != 0) {
                        }
                        break;
                    case 3:
                        if (iCompareTo <= 0) {
                        }
                        break;
                    case 4:
                        if (iCompareTo < 0) {
                        }
                        break;
                    case 5:
                        if (iCompareTo >= 0) {
                        }
                        break;
                    case 6:
                        if (iCompareTo > 0) {
                        }
                        break;
                }
                return false;
            }
            if (objB instanceof Float) {
                if (this.f18073i == null) {
                    this.f18073i = Float.valueOf(this.f18070f);
                }
                int iCompareTo2 = this.f18073i.compareTo((Float) objB);
                switch (C0824a.f18055a[this.f18071g.ordinal()]) {
                    case 1:
                        if (iCompareTo2 == 0) {
                        }
                        break;
                    case 2:
                        if (iCompareTo2 != 0) {
                        }
                        break;
                    case 3:
                        if (iCompareTo2 <= 0) {
                        }
                        break;
                    case 4:
                        if (iCompareTo2 < 0) {
                        }
                        break;
                    case 5:
                        if (iCompareTo2 >= 0) {
                        }
                        break;
                    case 6:
                        if (iCompareTo2 > 0) {
                        }
                        break;
                }
                return false;
            }
            if (!(objB instanceof Double)) {
                long jC0 = u0.o.C0((Number) objB);
                switch (C0824a.f18055a[this.f18071g.ordinal()]) {
                    case 1:
                        if (jC0 == this.f18070f) {
                        }
                        break;
                    case 2:
                        if (jC0 != this.f18070f) {
                        }
                        break;
                    case 3:
                        if (jC0 >= this.f18070f) {
                        }
                        break;
                    case 4:
                        if (jC0 > this.f18070f) {
                        }
                        break;
                    case 5:
                        if (jC0 <= this.f18070f) {
                        }
                        break;
                    case 6:
                        if (jC0 < this.f18070f) {
                        }
                        break;
                }
                return false;
            }
            if (this.f18074j == null) {
                this.f18074j = Double.valueOf(this.f18070f);
            }
            int iCompareTo3 = this.f18074j.compareTo((Double) objB);
            switch (C0824a.f18055a[this.f18071g.ordinal()]) {
                case 1:
                    if (iCompareTo3 == 0) {
                    }
                    break;
                case 2:
                    if (iCompareTo3 != 0) {
                    }
                    break;
                case 3:
                    if (iCompareTo3 <= 0) {
                    }
                    break;
                case 4:
                    if (iCompareTo3 < 0) {
                    }
                    break;
                case 5:
                    if (iCompareTo3 >= 0) {
                    }
                    break;
                case 6:
                    if (iCompareTo3 > 0) {
                    }
                    break;
            }
            return false;
        }
    }

    static class l {

        /* renamed from: f, reason: collision with root package name */
        private static final Pattern f18075f = Pattern.compile("'\\s*,\\s*'");

        /* renamed from: a, reason: collision with root package name */
        private final String f18076a;

        /* renamed from: b, reason: collision with root package name */
        private int f18077b;

        /* renamed from: c, reason: collision with root package name */
        private char f18078c;

        /* renamed from: d, reason: collision with root package name */
        private int f18079d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f18080e;

        public l(String str) {
            this.f18076a = str;
            i();
        }

        static boolean g(char c6) {
            if (c6 == '-' || c6 == '+') {
                return true;
            }
            return c6 >= '0' && c6 <= '9';
        }

        void a(char c6) {
            if (this.f18078c == ' ') {
                i();
            }
            if (this.f18078c == c6) {
                if (h()) {
                    return;
                }
                i();
            } else {
                throw new h("expect '" + c6 + ", but '" + this.f18078c + "'");
            }
        }

        B c(String str) {
            int length = str.length();
            char cCharAt = str.charAt(0);
            int i5 = length - 1;
            char cCharAt2 = str.charAt(i5);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                String strSubstring = str.substring(1, i5);
                return (iIndexOf == -1 || !f18075f.matcher(str).find()) ? new w(strSubstring, false) : new r(strSubstring.split("'\\s*,\\s*'"));
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                if (u0.o.u0(str)) {
                    try {
                        return new C0825b(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new w(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new w(str, false);
            }
            if (iIndexOf != -1) {
                String[] strArrSplit = str.split(",");
                int[] iArr = new int[strArrSplit.length];
                for (int i6 = 0; i6 < strArrSplit.length; i6++) {
                    iArr[i6] = Integer.parseInt(strArrSplit[i6]);
                }
                return new q(iArr);
            }
            if (iIndexOf2 == -1) {
                throw new UnsupportedOperationException();
            }
            String[] strArrSplit2 = str.split(":");
            int length2 = strArrSplit2.length;
            int[] iArr2 = new int[length2];
            for (int i7 = 0; i7 < strArrSplit2.length; i7++) {
                String str2 = strArrSplit2[i7];
                if (str2.length() != 0) {
                    iArr2[i7] = Integer.parseInt(str2);
                } else {
                    if (i7 != 0) {
                        throw new UnsupportedOperationException();
                    }
                    iArr2[i7] = 0;
                }
            }
            int i8 = iArr2[0];
            int i9 = length2 > 1 ? iArr2[1] : -1;
            int i10 = length2 == 3 ? iArr2[2] : 1;
            if (i9 < 0 || i9 >= i8) {
                if (i10 > 0) {
                    return new x(i8, i9, i10);
                }
                throw new UnsupportedOperationException("step must greater than zero : " + i10);
            }
            throw new UnsupportedOperationException("end must greater than or equals start. start " + i8 + ",  end " + i9);
        }

        public B[] d() {
            String str = this.f18076a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            B[] bArr = new B[8];
            while (true) {
                B bP = p();
                if (bP == null) {
                    break;
                }
                if (bP instanceof w) {
                    w wVar = (w) bP;
                    if (wVar.f18117c || !wVar.f18115a.equals("*")) {
                    }
                }
                int i5 = this.f18079d;
                if (i5 == bArr.length) {
                    B[] bArr2 = new B[(i5 * 3) / 2];
                    System.arraycopy(bArr, 0, bArr2, 0, i5);
                    bArr = bArr2;
                }
                int i6 = this.f18079d;
                this.f18079d = i6 + 1;
                bArr[i6] = bP;
            }
            int i7 = this.f18079d;
            if (i7 == bArr.length) {
                return bArr;
            }
            B[] bArr3 = new B[i7];
            System.arraycopy(bArr, 0, bArr3, 0, i7);
            return bArr3;
        }

        InterfaceC0827d e(InterfaceC0827d interfaceC0827d) {
            char c6 = this.f18078c;
            boolean z5 = true;
            boolean z6 = c6 == '&';
            if ((c6 != '&' || f() != '&') && (this.f18078c != '|' || f() != '|')) {
                return interfaceC0827d;
            }
            i();
            i();
            if (this.f18078c == '(') {
                i();
            } else {
                z5 = false;
            }
            while (this.f18078c == ' ') {
                i();
            }
            C0828e c0828e = new C0828e(interfaceC0827d, (InterfaceC0827d) k(false), z6);
            if (z5 && this.f18078c == ')') {
                i();
            }
            return c0828e;
        }

        char f() {
            return this.f18076a.charAt(this.f18077b);
        }

        boolean h() {
            return this.f18077b >= this.f18076a.length();
        }

        void i() {
            String str = this.f18076a;
            int i5 = this.f18077b;
            this.f18077b = i5 + 1;
            this.f18078c = str.charAt(i5);
        }

        B j(boolean z5) {
            Object objK = k(z5);
            return objK instanceof B ? (B) objK : new C0829f((InterfaceC0827d) objK);
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0119  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.lang.Object k(boolean r26) {
            /*
                Method dump skipped, instructions count: 1841
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l0.g.l.k(boolean):java.lang.Object");
        }

        protected double l(long j5) {
            int i5 = this.f18077b - 1;
            i();
            while (true) {
                char c6 = this.f18078c;
                if (c6 < '0' || c6 > '9') {
                    break;
                }
                i();
            }
            return Double.parseDouble(this.f18076a.substring(i5, this.f18077b - 1)) + j5;
        }

        protected long m() {
            int i5 = this.f18077b - 1;
            char c6 = this.f18078c;
            if (c6 == '+' || c6 == '-') {
                i();
            }
            while (true) {
                char c7 = this.f18078c;
                if (c7 < '0' || c7 > '9') {
                    break;
                }
                i();
            }
            return Long.parseLong(this.f18076a.substring(i5, this.f18077b - 1));
        }

        String n() {
            s();
            char c6 = this.f18078c;
            if (c6 != '\\' && !Character.isJavaIdentifierStart(c6)) {
                throw new h("illeal jsonpath syntax. " + this.f18076a);
            }
            StringBuilder sb = new StringBuilder();
            while (!h()) {
                char c7 = this.f18078c;
                if (c7 == '\\') {
                    i();
                    sb.append(this.f18078c);
                    if (h()) {
                        return sb.toString();
                    }
                    i();
                } else {
                    if (!Character.isJavaIdentifierPart(c7)) {
                        break;
                    }
                    sb.append(this.f18078c);
                    i();
                }
            }
            if (h() && Character.isJavaIdentifierPart(this.f18078c)) {
                sb.append(this.f18078c);
            }
            return sb.toString();
        }

        protected u o() {
            u uVar;
            char c6 = this.f18078c;
            if (c6 == '=') {
                i();
                char c7 = this.f18078c;
                if (c7 == '~') {
                    i();
                    uVar = u.REG_MATCH;
                } else if (c7 == '=') {
                    i();
                    uVar = u.EQ;
                } else {
                    uVar = u.EQ;
                }
            } else if (c6 == '!') {
                i();
                a('=');
                uVar = u.NE;
            } else if (c6 == '<') {
                i();
                if (this.f18078c == '=') {
                    i();
                    uVar = u.LE;
                } else {
                    uVar = u.LT;
                }
            } else if (c6 == '>') {
                i();
                if (this.f18078c == '=') {
                    i();
                    uVar = u.GE;
                } else {
                    uVar = u.GT;
                }
            } else {
                uVar = null;
            }
            if (uVar != null) {
                return uVar;
            }
            String strN = n();
            if ("not".equalsIgnoreCase(strN)) {
                s();
                String strN2 = n();
                if ("like".equalsIgnoreCase(strN2)) {
                    return u.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(strN2)) {
                    return u.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(strN2)) {
                    return u.NOT_IN;
                }
                if ("between".equalsIgnoreCase(strN2)) {
                    return u.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(strN)) {
                return u.NOT_IN;
            }
            if ("like".equalsIgnoreCase(strN)) {
                return u.LIKE;
            }
            if ("rlike".equalsIgnoreCase(strN)) {
                return u.RLIKE;
            }
            if ("in".equalsIgnoreCase(strN)) {
                return u.IN;
            }
            if ("between".equalsIgnoreCase(strN)) {
                return u.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        B p() {
            boolean z5;
            if (this.f18079d == 0 && this.f18076a.length() == 1) {
                if (g(this.f18078c)) {
                    return new C0825b(this.f18078c - '0');
                }
                char c6 = this.f18078c;
                if ((c6 >= 'a' && c6 <= 'z') || (c6 >= 'A' && c6 <= 'Z')) {
                    return new w(Character.toString(c6), false);
                }
            }
            while (!h()) {
                s();
                char c7 = this.f18078c;
                if (c7 != '$') {
                    if (c7 != '.' && c7 != '/') {
                        if (c7 == '[') {
                            return j(true);
                        }
                        if (this.f18079d == 0) {
                            return new w(n(), false);
                        }
                        if (c7 == '?') {
                            return new C0829f((InterfaceC0827d) k(false));
                        }
                        throw new h("not support jsonpath : " + this.f18076a);
                    }
                    i();
                    if (c7 == '.' && this.f18078c == '.') {
                        i();
                        int length = this.f18076a.length();
                        int i5 = this.f18077b;
                        if (length > i5 + 3 && this.f18078c == '[' && this.f18076a.charAt(i5) == '*' && this.f18076a.charAt(this.f18077b + 1) == ']' && this.f18076a.charAt(this.f18077b + 2) == '.') {
                            i();
                            i();
                            i();
                            i();
                        }
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    char c8 = this.f18078c;
                    if (c8 == '*' || (z5 && c8 == '[')) {
                        boolean z6 = c8 == '[';
                        if (!h()) {
                            i();
                        }
                        return z5 ? z6 ? H.f18052e : H.f18051d : H.f18050c;
                    }
                    if (g(c8)) {
                        return j(false);
                    }
                    String strN = n();
                    if (this.f18078c != '(') {
                        return new w(strN, z5);
                    }
                    i();
                    if (this.f18078c != ')') {
                        throw new h("not support jsonpath : " + this.f18076a);
                    }
                    if (!h()) {
                        i();
                    }
                    if ("size".equals(strN) || "length".equals(strN)) {
                        return C.f18042a;
                    }
                    if ("max".equals(strN)) {
                        return o.f18087a;
                    }
                    if ("min".equals(strN)) {
                        return p.f18088a;
                    }
                    if ("keySet".equals(strN)) {
                        return m.f18081a;
                    }
                    if ("type".equals(strN)) {
                        return F.f18047a;
                    }
                    if ("floor".equals(strN)) {
                        return C0225g.f18062a;
                    }
                    throw new h("not support jsonpath : " + this.f18076a);
                }
                i();
                s();
                if (this.f18078c == '?') {
                    return new C0829f((InterfaceC0827d) k(false));
                }
            }
            return null;
        }

        String q() {
            char c6 = this.f18078c;
            i();
            int i5 = this.f18077b - 1;
            while (this.f18078c != c6 && !h()) {
                i();
            }
            String strSubstring = this.f18076a.substring(i5, h() ? this.f18077b : this.f18077b - 1);
            a(c6);
            return strSubstring;
        }

        protected Object r() {
            s();
            if (g(this.f18078c)) {
                return Long.valueOf(m());
            }
            char c6 = this.f18078c;
            if (c6 == '\"' || c6 == '\'') {
                return q();
            }
            if (c6 != 'n') {
                throw new UnsupportedOperationException();
            }
            if ("null".equals(n())) {
                return null;
            }
            throw new h(this.f18076a);
        }

        public final void s() {
            while (true) {
                char c6 = this.f18078c;
                if (c6 > ' ') {
                    return;
                }
                if (c6 != ' ' && c6 != '\r' && c6 != '\n' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                    return;
                } else {
                    i();
                }
            }
        }
    }

    static class m implements B {

        /* renamed from: a, reason: collision with root package name */
        public static final m f18081a = new m();

        m() {
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            return gVar.f(obj2);
        }
    }

    static class n extends v {

        /* renamed from: f, reason: collision with root package name */
        private final String f18082f;

        /* renamed from: g, reason: collision with root package name */
        private final String f18083g;

        /* renamed from: h, reason: collision with root package name */
        private final String[] f18084h;

        /* renamed from: i, reason: collision with root package name */
        private final int f18085i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f18086j;

        public n(String str, boolean z5, String str2, String str3, String[] strArr, boolean z6) {
            super(str, z5);
            this.f18082f = str2;
            this.f18083g = str3;
            this.f18084h = strArr;
            this.f18086j = z6;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.f18085i = length;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            int length;
            Object objB = b(gVar, obj, obj3);
            if (objB == null) {
                return false;
            }
            String string = objB.toString();
            if (string.length() < this.f18085i) {
                return this.f18086j;
            }
            String str = this.f18082f;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.f18086j;
                }
                length = this.f18082f.length();
            }
            String[] strArr = this.f18084h;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.f18086j;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            String str3 = this.f18083g;
            return (str3 == null || string.endsWith(str3)) ? !this.f18086j : this.f18086j;
        }
    }

    static class o implements B {

        /* renamed from: a, reason: collision with root package name */
        public static final o f18087a = new o();

        o() {
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || g.a(obj3, obj4) < 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    static class p implements B {

        /* renamed from: a, reason: collision with root package name */
        public static final p f18088a = new p();

        p() {
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || g.a(obj3, obj4) > 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    static class q implements B {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f18089a;

        public q(int[] iArr) {
            this.f18089a = iArr;
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            C0823b c0823b = new C0823b(this.f18089a.length);
            int i5 = 0;
            while (true) {
                int[] iArr = this.f18089a;
                if (i5 >= iArr.length) {
                    return c0823b;
                }
                c0823b.add(gVar.h(obj2, iArr[i5]));
                i5++;
            }
        }
    }

    static class r implements B {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f18090a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f18091b;

        public r(String[] strArr) {
            this.f18090a = strArr;
            this.f18091b = new long[strArr.length];
            int i5 = 0;
            while (true) {
                long[] jArr = this.f18091b;
                if (i5 >= jArr.length) {
                    return;
                }
                jArr[i5] = u0.o.I(strArr[i5]);
                i5++;
            }
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f18090a.length);
            int i5 = 0;
            while (true) {
                String[] strArr = this.f18090a;
                if (i5 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(gVar.k(obj2, strArr[i5], this.f18091b[i5]));
                i5++;
            }
        }
    }

    static class s extends v {
        public s(String str, boolean z5) {
            super(str, z5);
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            return gVar.k(obj3, this.f18111a, this.f18112b) != null;
        }
    }

    static class t extends v {
        public t(String str, boolean z5) {
            super(str, z5);
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            return b(gVar, obj, obj3) == null;
        }
    }

    enum u {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    static abstract class v implements InterfaceC0827d {

        /* renamed from: e, reason: collision with root package name */
        static long f18110e = u0.o.I("type");

        /* renamed from: a, reason: collision with root package name */
        protected final String f18111a;

        /* renamed from: b, reason: collision with root package name */
        protected final long f18112b;

        /* renamed from: c, reason: collision with root package name */
        protected final boolean f18113c;

        /* renamed from: d, reason: collision with root package name */
        protected B f18114d;

        protected v(String str, boolean z5) {
            this.f18111a = str;
            long jI = u0.o.I(str);
            this.f18112b = jI;
            this.f18113c = z5;
            if (z5) {
                if (jI == f18110e) {
                    this.f18114d = F.f18047a;
                } else {
                    if (jI == 5614464919154503228L) {
                        this.f18114d = C.f18042a;
                        return;
                    }
                    throw new h("unsupported funciton : " + str);
                }
            }
        }

        protected Object b(g gVar, Object obj, Object obj2) {
            B b6 = this.f18114d;
            return b6 != null ? b6.a(gVar, obj, obj2) : gVar.k(obj2, this.f18111a, this.f18112b);
        }
    }

    static class w implements B {

        /* renamed from: a, reason: collision with root package name */
        private final String f18115a;

        /* renamed from: b, reason: collision with root package name */
        private final long f18116b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f18117c;

        public w(String str, boolean z5) {
            this.f18115a = str;
            this.f18116b = u0.o.I(str);
            this.f18117c = z5;
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            if (!this.f18117c) {
                return gVar.k(obj2, this.f18115a, this.f18116b);
            }
            ArrayList arrayList = new ArrayList();
            gVar.d(obj2, this.f18115a, arrayList);
            return arrayList;
        }
    }

    static class x implements B {

        /* renamed from: a, reason: collision with root package name */
        private final int f18118a;

        /* renamed from: b, reason: collision with root package name */
        private final int f18119b;

        /* renamed from: c, reason: collision with root package name */
        private final int f18120c;

        public x(int i5, int i6, int i7) {
            this.f18118a = i5;
            this.f18119b = i6;
            this.f18120c = i7;
        }

        @Override // l0.g.B
        public Object a(g gVar, Object obj, Object obj2) {
            int iIntValue = C.f18042a.a(gVar, obj, obj2).intValue();
            int i5 = this.f18118a;
            if (i5 < 0) {
                i5 += iIntValue;
            }
            int i6 = this.f18119b;
            if (i6 < 0) {
                i6 += iIntValue;
            }
            int i7 = ((i6 - i5) / this.f18120c) + 1;
            if (i7 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i7);
            while (i5 <= i6 && i5 < iIntValue) {
                arrayList.add(gVar.h(obj2, i5));
                i5 += this.f18120c;
            }
            return arrayList;
        }
    }

    static class y extends v {

        /* renamed from: f, reason: collision with root package name */
        private final B f18121f;

        /* renamed from: g, reason: collision with root package name */
        private final u f18122g;

        public y(String str, boolean z5, B b6, u uVar) {
            super(str, z5);
            this.f18121f = b6;
            this.f18122g = uVar;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null || !(objB instanceof Number)) {
                return false;
            }
            Object objA = this.f18121f.a(gVar, obj, obj);
            if ((objA instanceof Integer) || (objA instanceof Long) || (objA instanceof Short) || (objA instanceof Byte)) {
                long jC0 = u0.o.C0((Number) objA);
                if ((objB instanceof Integer) || (objB instanceof Long) || (objB instanceof Short) || (objB instanceof Byte)) {
                    long jC02 = u0.o.C0((Number) objB);
                    switch (C0824a.f18055a[this.f18122g.ordinal()]) {
                        case 1:
                            return jC02 == jC0;
                        case 2:
                            return jC02 != jC0;
                        case 3:
                            return jC02 >= jC0;
                        case 4:
                            return jC02 > jC0;
                        case 5:
                            return jC02 <= jC0;
                        case 6:
                            return jC02 < jC0;
                    }
                }
                if (objB instanceof BigDecimal) {
                    int iCompareTo = BigDecimal.valueOf(jC0).compareTo((BigDecimal) objB);
                    switch (C0824a.f18055a[this.f18122g.ordinal()]) {
                        case 1:
                            return iCompareTo == 0;
                        case 2:
                            return iCompareTo != 0;
                        case 3:
                            return iCompareTo <= 0;
                        case 4:
                            return iCompareTo < 0;
                        case 5:
                            return iCompareTo >= 0;
                        case 6:
                            return iCompareTo > 0;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    static class z extends v {

        /* renamed from: f, reason: collision with root package name */
        private final Pattern f18123f;

        /* renamed from: g, reason: collision with root package name */
        private final u f18124g;

        public z(String str, boolean z5, Pattern pattern, u uVar) {
            super(str, z5);
            this.f18123f = pattern;
            this.f18124g = uVar;
        }

        @Override // l0.g.InterfaceC0827d
        public boolean a(g gVar, Object obj, Object obj2, Object obj3) {
            Object objB = b(gVar, obj, obj3);
            if (objB == null) {
                return false;
            }
            return this.f18123f.matcher(objB.toString()).matches();
        }
    }

    public g(String str) {
        this(str, b0.g(), C0896i.s(), true);
    }

    static int a(Object obj, Object obj2) {
        Object d6;
        Object f5;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls == BigDecimal.class) {
            if (cls2 == Integer.class) {
                f5 = new BigDecimal(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f5 = new BigDecimal(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f5 = new BigDecimal(((Float) obj2).floatValue());
            } else if (cls2 == Double.class) {
                f5 = new BigDecimal(((Double) obj2).doubleValue());
            }
            obj2 = f5;
        } else if (cls == Long.class) {
            if (cls2 == Integer.class) {
                f5 = new Long(((Integer) obj2).intValue());
                obj2 = f5;
            } else {
                if (cls2 == BigDecimal.class) {
                    d6 = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    d6 = new Float(((Long) obj).longValue());
                } else if (cls2 == Double.class) {
                    d6 = new Double(((Long) obj).longValue());
                }
                obj = d6;
            }
        } else if (cls == Integer.class) {
            if (cls2 == Long.class) {
                d6 = new Long(((Integer) obj).intValue());
            } else if (cls2 == BigDecimal.class) {
                d6 = new BigDecimal(((Integer) obj).intValue());
            } else if (cls2 == Float.class) {
                d6 = new Float(((Integer) obj).intValue());
            } else if (cls2 == Double.class) {
                d6 = new Double(((Integer) obj).intValue());
            }
            obj = d6;
        } else if (cls == Double.class) {
            if (cls2 == Integer.class) {
                f5 = new Double(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f5 = new Double(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f5 = new Double(((Float) obj2).floatValue());
            }
            obj2 = f5;
        } else if (cls == Float.class) {
            if (cls2 == Integer.class) {
                f5 = new Float(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f5 = new Float(((Long) obj2).longValue());
            } else if (cls2 == Double.class) {
                d6 = new Double(((Float) obj).floatValue());
                obj = d6;
            }
            obj2 = f5;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public static g b(String str) {
        if (str == null) {
            throw new h("jsonpath can not be null");
        }
        g gVar = f18033g.get(str);
        if (gVar == null) {
            gVar = new g(str);
            if (f18033g.size() < 1024) {
                f18033g.putIfAbsent(str, gVar);
                return f18033g.get(str);
            }
        }
        return gVar;
    }

    protected static boolean n(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    protected void c(Object obj, List<Object> list) {
        Collection collectionV;
        Class<?> cls = obj.getClass();
        C0947J c0947jJ = j(cls);
        if (c0947jJ != null) {
            try {
                collectionV = c0947jJ.v(obj);
            } catch (Exception e6) {
                throw new h("jsonpath error, path " + this.f18034a, e6);
            }
        } else {
            collectionV = obj instanceof Map ? ((Map) obj).values() : obj instanceof Collection ? (Collection) obj : null;
        }
        if (collectionV == null) {
            throw new UnsupportedOperationException(cls.getName());
        }
        for (Object obj2 : collectionV) {
            if (obj2 == null || C0896i.v(obj2.getClass())) {
                list.add(obj2);
            } else {
                c(obj2, list);
            }
        }
    }

    protected void d(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !C0896i.v(value.getClass())) {
                    d(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!C0896i.v(obj2.getClass())) {
                    d(obj2, str, list);
                }
            }
            return;
        }
        C0947J c0947jJ = j(obj.getClass());
        if (c0947jJ == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    d(list2.get(i5), str, list);
                }
                return;
            }
            return;
        }
        try {
            C0938A c0938aT = c0947jJ.t(str);
            if (c0938aT == null) {
                Iterator<Object> it = c0947jJ.v(obj).iterator();
                while (it.hasNext()) {
                    d(it.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(c0938aT.e(obj));
                } catch (InvocationTargetException e6) {
                    throw new d("getFieldValue error." + str, e6);
                }
            } catch (IllegalAccessException e7) {
                throw new d("getFieldValue error." + str, e7);
            }
        } catch (Exception e8) {
            throw new h("jsonpath error, path " + this.f18034a + ", segement " + str, e8);
        }
    }

    public Object e(Object obj) {
        if (obj == null) {
            return null;
        }
        m();
        int i5 = 0;
        Object objA = obj;
        while (true) {
            B[] bArr = this.f18035b;
            if (i5 >= bArr.length) {
                return objA;
            }
            objA = bArr[i5].a(this, obj, objA);
            i5++;
        }
    }

    Set<?> f(Object obj) {
        C0947J c0947jJ;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (c0947jJ = j(obj.getClass())) == null) {
            return null;
        }
        try {
            return c0947jJ.r(obj);
        } catch (Exception e6) {
            throw new h("evalKeySet error : " + this.f18034a, e6);
        }
    }

    int g(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i5++;
                }
            }
            return i5;
        }
        C0947J c0947jJ = j(obj.getClass());
        if (c0947jJ == null) {
            return -1;
        }
        try {
            return c0947jJ.y(obj);
        } catch (Exception e6) {
            throw new h("evalSize error : " + this.f18034a, e6);
        }
    }

    protected Object h(Object obj, int i5) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i5 >= 0) {
                if (i5 < list.size()) {
                    return list.get(i5);
                }
                return null;
            }
            if (Math.abs(i5) <= list.size()) {
                return list.get(list.size() + i5);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i5 >= 0) {
                if (i5 < length) {
                    return Array.get(obj, i5);
                }
                return null;
            }
            if (Math.abs(i5) <= length) {
                return Array.get(obj, length + i5);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i5));
            return obj2 == null ? map.get(Integer.toString(i5)) : obj2;
        }
        if (!(obj instanceof Collection)) {
            if (i5 == 0) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }
        int i6 = 0;
        for (Object obj3 : (Collection) obj) {
            if (i6 == i5) {
                return obj3;
            }
            i6++;
        }
        return null;
    }

    @Override // l0.c
    public String i() {
        return AbstractC0822a.F(this.f18034a);
    }

    protected C0947J j(Class<?> cls) {
        U uH = this.f18037d.h(cls);
        if (uH instanceof C0947J) {
            return (C0947J) uH;
        }
        return null;
    }

    protected Object k(Object obj, String str, long j5) {
        Object obj2;
        C0823b c0823b = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj2 = (e) AbstractC0822a.t((String) obj, this.f18038e);
            } catch (Exception unused) {
            }
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(str);
            return obj3 == null ? (5614464919154503228L == j5 || -1580386065683472715L == j5) ? Integer.valueOf(map.size()) : obj3 : obj3;
        }
        C0947J c0947jJ = j(obj2.getClass());
        if (c0947jJ != null) {
            try {
                return c0947jJ.u(obj2, str, j5, false);
            } catch (Exception e6) {
                throw new h("jsonpath error, path " + this.f18034a + ", segement " + str, e6);
            }
        }
        int i5 = 0;
        if (obj2 instanceof List) {
            List list = (List) obj2;
            if (5614464919154503228L == j5 || -1580386065683472715L == j5) {
                return Integer.valueOf(list.size());
            }
            while (i5 < list.size()) {
                Object obj4 = list.get(i5);
                if (obj4 == list) {
                    if (c0823b == null) {
                        c0823b = new C0823b(list.size());
                    }
                    c0823b.add(obj4);
                } else {
                    Object objK = k(obj4, str, j5);
                    if (objK instanceof Collection) {
                        Collection collection = (Collection) objK;
                        if (c0823b == null) {
                            c0823b = new C0823b(list.size());
                        }
                        c0823b.addAll(collection);
                    } else if (objK != null || !this.f18039f) {
                        if (c0823b == null) {
                            c0823b = new C0823b(list.size());
                        }
                        c0823b.add(objK);
                    }
                }
                i5++;
            }
            return c0823b == null ? Collections.EMPTY_LIST : c0823b;
        }
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (5614464919154503228L == j5 || -1580386065683472715L == j5) {
                return Integer.valueOf(objArr.length);
            }
            C0823b c0823b2 = new C0823b(objArr.length);
            while (i5 < objArr.length) {
                Object[] objArr2 = objArr[i5];
                if (objArr2 == objArr) {
                    c0823b2.add(objArr2);
                } else {
                    Object objK2 = k(objArr2, str, j5);
                    if (objK2 instanceof Collection) {
                        c0823b2.addAll((Collection) objK2);
                    } else if (objK2 != null || !this.f18039f) {
                        c0823b2.add(objK2);
                    }
                }
                i5++;
            }
            return c0823b2;
        }
        if (obj2 instanceof Enum) {
            Enum r8 = (Enum) obj2;
            if (-4270347329889690746L == j5) {
                return r8.name();
            }
            if (-1014497654951707614L == j5) {
                return Integer.valueOf(r8.ordinal());
            }
        }
        if (obj2 instanceof Calendar) {
            Calendar calendar = (Calendar) obj2;
            if (8963398325558730460L == j5) {
                return Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j5) {
                return Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j5) {
                return Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j5) {
                return Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j5) {
                return Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j5) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    protected Collection<Object> l(Object obj) {
        if (obj == null) {
            return null;
        }
        C0947J c0947jJ = j(obj.getClass());
        if (c0947jJ == null) {
            if (obj instanceof Map) {
                return ((Map) obj).values();
            }
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
        try {
            return c0947jJ.v(obj);
        } catch (Exception e6) {
            throw new h("jsonpath error, path " + this.f18034a, e6);
        }
    }

    protected void m() {
        if (this.f18035b != null) {
            return;
        }
        if ("*".equals(this.f18034a)) {
            this.f18035b = new B[]{H.f18050c};
            return;
        }
        l lVar = new l(this.f18034a);
        this.f18035b = lVar.d();
        this.f18036c = lVar.f18080e;
    }

    public boolean o() {
        try {
            m();
            int i5 = 0;
            while (true) {
                B[] bArr = this.f18035b;
                if (i5 >= bArr.length) {
                    return true;
                }
                Class<?> cls = bArr[i5].getClass();
                if (cls != C0825b.class && cls != w.class) {
                    return false;
                }
                i5++;
            }
        } catch (h unused) {
            return false;
        }
    }

    public g(String str, b0 b0Var, C0896i c0896i, boolean z5) {
        if (str == null || str.length() == 0) {
            throw new h("json-path can not be null or empty");
        }
        this.f18034a = str;
        this.f18037d = b0Var;
        this.f18038e = c0896i;
        this.f18039f = z5;
    }
}
