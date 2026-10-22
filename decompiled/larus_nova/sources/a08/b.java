package a08;

import android.content.Context;
import android.content.res.Resources;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel4;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SortedMap<Integer, a> f1319a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1325f;

        /* JADX INFO: renamed from: a08.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0001a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f1326a = null;

            static {
                int[] r100 = new int[ZoomLevel6.values().length];
                r100[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[ZoomLevel6.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[ZoomLevel6.LARGE1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[ZoomLevel6.LARGE2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[ZoomLevel6.LARGE3.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[ZoomLevel6.LARGE4.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f1326a = r100;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f1320a == r101.f1320a) goto L12;
            return false;
        L12:
            if (this.f1321b == r101.f1321b) goto L15;
            return false;
        L15:
            if (this.f1322c == r101.f1322c) goto L18;
            return false;
        L18:
            if (this.f1323d == r101.f1323d) goto L21;
            return false;
        L21:
            if (this.f1324e == r101.f1324e) goto L24;
            return false;
        L24:
            if (this.f1325f == r101.f1325f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f1320a * 31) + this.f1321b) * 31) + this.f1322c) * 31) + this.f1323d) * 31) + this.f1324e) * 31) + this.f1325f;
        }

        public final String toString() {
            return "LarkFontConfig(small=" + this.f1320a + ", normal=" + this.f1321b + ", large1=" + this.f1322c + ", large2=" + this.f1323d + ", large3=" + this.f1324e + ", large4=" + this.f1325f + ')';
        }

        public final int a(ZoomLevel4 r100) {
            Intrinsics.checkNotNullParameter(r100, "zoomLevel");
            ZoomLevel6 r101 = zz7.b.d();
            switch(C0001a.f1326a[r101.ordinal()]) {
                case 1: goto L10;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L11;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L11:
            return this.f1323d;
        L12:
            return this.f1322c;
        L13:
            return this.f1321b;
        L10:
            return this.f1320a;
        }

        public final int b(ZoomLevel6 r100) {
            Intrinsics.checkNotNullParameter(r100, "zoomLevel");
            switch(C0001a.f1326a[r100.ordinal()]) {
                case 1: goto L12;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L13:
            return this.f1325f;
        L14:
            return this.f1324e;
        L15:
            return this.f1323d;
        L16:
            return this.f1322c;
        L17:
            return this.f1321b;
        L12:
            return this.f1320a;
        }

        public a(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.f1320a = r100;
            this.f1321b = r101;
            this.f1322c = r102;
            this.f1323d = r103;
            this.f1324e = r104;
            this.f1325f = r105;
        }
    }

    static {
        a r100 = new a(24, 26, 28, 30, 34, 40);
        a r101 = new a(22, 24, 26, 28, 32, 36);
        a r102 = new a(18, 20, 22, 24, 28, 32);
        a r103 = new a(16, 17, 18, 20, 24, 28);
        a r104 = new a(15, 16, 17, 18, 20, 24);
        a r105 = new a(13, 14, 15, 16, 18, 20);
        a r106 = new a(11, 12, 13, 14, 15, 16);
        a r107 = new a(9, 10, 11, 12, 13, 14);
        LinkedHashMap r108 = new LinkedHashMap();
        insert(r108, r100);
        insert(r108, r101);
        insert(r108, r102);
        insert(r108, r103);
        insert(r108, r104);
        insert(r108, r105);
        insert(r108, r106);
        insert(r108, r107);
        f1319a = MapsKt.toSortedMap(r108);
    }

    @JvmStatic
    public static final float a(float r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (yz7.a.f569550b == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return r100;
    L10:
        ZoomLevel6 r103 = zz7.b.d();
        ZoomLevel6 r104 = ZoomLevel6.NORMAL;
        if (r103 != r104) goto L13;
        return r100;
    L13:
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r105 = r101.getResources();
        int r106 = MathKt.roundToInt((r100 / WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density) + 0.5f);
        if (r103 != r104) goto L16;
        float r107 = r104.getMultiplier();
    L48:
        return r100 * r107;
    L16:
        SortedMap<Integer, a> r108 = f1319a;
        a r109 = r108.get(Integer.valueOf(r106));
        if (r109 == null) goto L19;
        int r110 = r109.b(r103);
    L46:
        r107 = r110 / r106;
        goto L48
    L19:
        Iterator<T> r111 = r108.values().iterator();
        Object r112 = null;
        Object r113 = null;
    L21:
        if (r111.hasNext() == false) goto L28;
        Object r114 = r111.next();
        if (((a) r114).f1321b >= r106) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L21;
        r113 = r114;
        goto L21
    L25:
        r115 = false;
        goto L26
    L28:
        a r116 = (a) r113;
        Iterator<T> r117 = f1319a.values().iterator();
    L30:
        if (r117.hasNext() == false) goto L37;
        Object r118 = r117.next();
        if (((a) r118).f1321b <= r106) goto L34;
        boolean r119 = true;
    L35:
        if (r119 == false) goto L30;
        r112 = r118;
        goto L37
    L34:
        r119 = false;
    L37:
        a r120 = (a) r112;
        if (r116 == null) goto L41;
        if (r120 == null) goto L41;
        r110 = MathKt.roundToInt((((r116.b(r103) / r116.f1321b) + (r120.b(r103) / r120.f1321b)) / 2.0f) * r106);
    L41:
        if (r116 == null) goto L43;
        r110 = MathKt.roundToInt((r116.b(r103) / r116.f1321b) * r106);
        goto L46
    L43:
        if (r120 == null) goto L45;
        r110 = MathKt.roundToInt((r120.b(r103) / r120.f1321b) * r106);
        goto L46
    L45:
        r110 = r106;
        goto L46
    L5:
        if (yz7.a.f569549a == false) goto L7;
        r102 = true;
        goto L8
    }

    @JvmStatic
    public static final int b(int r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return MathKt.roundToInt(a(r100, r101));
    }

    @JvmStatic
    public static final void insert(HashMap<Integer, a> r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        r100.put(Integer.valueOf(r101.f1321b), r101);
    }
}
