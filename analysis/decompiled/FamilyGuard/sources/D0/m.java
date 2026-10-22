package D0;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class m implements k {

    /* renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f1031d;

    /* renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f1032e;

    /* renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f1033f;

    /* renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f1034g;

    /* renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f1035h;

    /* renamed from: a, reason: collision with root package name */
    private final c f1036a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final g<b, Bitmap> f1037b = new g<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f1038c = new HashMap();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1039a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f1039a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1039a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1039a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1039a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        private final c f1040a;

        /* renamed from: b, reason: collision with root package name */
        int f1041b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f1042c;

        public b(c cVar) {
            this.f1040a = cVar;
        }

        @Override // D0.l
        public void a() {
            this.f1040a.c(this);
        }

        public void b(int i5, Bitmap.Config config) {
            this.f1041b = i5;
            this.f1042c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f1041b == bVar.f1041b && X0.k.d(this.f1042c, bVar.f1042c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i5 = this.f1041b * 31;
            Bitmap.Config config = this.f1042c;
            return i5 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return m.h(this.f1041b, this.f1042c);
        }
    }

    static class c extends D0.c<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // D0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i5, Bitmap.Config config) {
            b bVarB = b();
            bVarB.b(i5, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        f1031d = configArr;
        f1032e = configArr;
        f1033f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f1034g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f1035h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num2 = navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private D0.m.b g(int r9, android.graphics.Bitmap.Config r10) {
        /*
            r8 = this;
            D0.m$c r0 = r8.f1036a
            D0.m$b r0 = r0.e(r9, r10)
            android.graphics.Bitmap$Config[] r1 = i(r10)
            int r2 = r1.length
            r3 = 0
        Lc:
            if (r3 >= r2) goto L4c
            r4 = r1[r3]
            java.util.NavigableMap r5 = r8.j(r4)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            java.lang.Object r5 = r5.ceilingKey(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L49
            int r6 = r5.intValue()
            int r7 = r9 * 8
            if (r6 > r7) goto L49
            int r1 = r5.intValue()
            if (r1 != r9) goto L39
            if (r4 != 0) goto L33
            if (r10 == 0) goto L4c
            goto L39
        L33:
            boolean r9 = r4.equals(r10)
            if (r9 != 0) goto L4c
        L39:
            D0.m$c r9 = r8.f1036a
            r9.c(r0)
            D0.m$c r8 = r8.f1036a
            int r9 = r5.intValue()
            D0.m$b r8 = r8.e(r9, r4)
            return r8
        L49:
            int r3 = r3 + 1
            goto Lc
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: D0.m.g(int, android.graphics.Bitmap$Config):D0.m$b");
    }

    static String h(int i5, Bitmap.Config config) {
        return "[" + i5 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return f1032e;
        }
        int i5 = a.f1039a[config.ordinal()];
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? new Bitmap.Config[]{config} : f1035h : f1034g : f1033f : f1031d;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f1038c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f1038c.put(config, treeMap);
        return treeMap;
    }

    @Override // D0.k
    public String a(int i5, int i6, Bitmap.Config config) {
        return h(X0.k.g(i5, i6, config), config);
    }

    @Override // D0.k
    public int b(Bitmap bitmap) {
        return X0.k.h(bitmap);
    }

    @Override // D0.k
    public void c(Bitmap bitmap) {
        b bVarE = this.f1036a.e(X0.k.h(bitmap), bitmap.getConfig());
        this.f1037b.d(bVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num = navigableMapJ.get(Integer.valueOf(bVarE.f1041b));
        navigableMapJ.put(Integer.valueOf(bVarE.f1041b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // D0.k
    public Bitmap d(int i5, int i6, Bitmap.Config config) {
        b bVarG = g(X0.k.g(i5, i6, config), config);
        Bitmap bitmapA = this.f1037b.a(bVarG);
        if (bitmapA != null) {
            f(Integer.valueOf(bVarG.f1041b), bitmapA);
            bitmapA.reconfigure(i5, i6, config);
        }
        return bitmapA;
    }

    @Override // D0.k
    public String e(Bitmap bitmap) {
        return h(X0.k.h(bitmap), bitmap.getConfig());
    }

    @Override // D0.k
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f1037b.f();
        if (bitmapF != null) {
            f(Integer.valueOf(X0.k.h(bitmapF)), bitmapF);
        }
        return bitmapF;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f1037b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f1038c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f1038c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), BuildConfig.FLAVOR);
        }
        sb.append(")}");
        return sb.toString();
    }
}
