package com.bytedance.android.monitorV2.lynx.impl.blank;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f163198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f163199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f163200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Integer[]> f163201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Integer> f163202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Integer> f163203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f163204g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f163205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f163206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f163207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f163208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f163209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f163210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, Integer> f163211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, Integer> f163212h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f163213i;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f163205a, r101.f163205a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f163206b, r101.f163206b) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f163207c, r101.f163207c) == true) goto L18;
            return false;
        L18:
            if (this.f163208d == r101.f163208d) goto L21;
            return false;
        L21:
            if (this.f163209e == r101.f163209e) goto L24;
            return false;
        L24:
            if (this.f163210f == r101.f163210f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f163211g, r101.f163211g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f163212h, r101.f163212h) == true) goto L33;
            return false;
        L33:
            if (this.f163213i == r101.f163213i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((((((Float.floatToIntBits(this.f163205a) * 31) + Float.floatToIntBits(this.f163206b)) * 31) + this.f163207c.hashCode()) * 31) + this.f163208d) * 31) + this.f163209e) * 31) + this.f163210f) * 31) + this.f163211g.hashCode()) * 31) + this.f163212h.hashCode()) * 31;
            if (this.f163213i == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "CheckResult(effectiveAreaRatio=" + this.f163205a + ", maxBlankAreaRatio=" + this.f163206b + ", blankBitmap=" + this.f163207c + ", blankBitmapWidth=" + this.f163208d + ", blankBitmapHeight=" + this.f163209e + ", validViewCount=" + this.f163210f + ", elements=" + this.f163211g + ", validElements=" + this.f163212h + ", validChildNode=" + this.f163213i + ')';
        }

        public /* synthetic */ a(int r110) {
            this(0.0f, 0.0f, "", 0, 0, 0, MapsKt.emptyMap(), MapsKt.emptyMap(), false);
        }

        public a(float r100, float r101, String r102, int r103, int r104, int r105, Map<String, Integer> r106, Map<String, Integer> r107, boolean r110) {
            Intrinsics.checkNotNullParameter(r102, "blankBitmap");
            Intrinsics.checkNotNullParameter(r106, SlcElement.KEY_ELEMENTS);
            Intrinsics.checkNotNullParameter(r107, "validElements");
            this.f163205a = r100;
            this.f163206b = r101;
            this.f163207c = r102;
            this.f163208d = r103;
            this.f163209e = r104;
            this.f163210f = r105;
            this.f163211g = r106;
            this.f163212h = r107;
            this.f163213i = r110;
        }
    }

    public f(int r100, int r101) {
        int r102 = Math.max(1, (int) (Math.max(r100, r101) / 100.0f));
        this.f163198a = r100;
        this.f163199b = r101;
        this.f163200c = r102;
        this.f163201d = new ArrayList();
        this.f163202e = new HashMap();
        this.f163203f = new HashMap();
    }

    public final void a(int r100, int r101, int r102, int r103, int r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "element");
        Integer r104 = 0;
        if (r110 == 0) goto L5;
        this.f163201d.add(new Integer[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r110)});
    L5:
        if (r112 == false) goto L8;
        if (r110 != 1) goto L8;
        this.f163204g = true;
    L8:
        if (r110 != 1) goto L13;
        HashMap<String, Integer> r105 = this.f163203f;
        Integer r106 = r105.get(r111);
        if (r106 != null) goto L12;
        r106 = r104;
    L12:
        r105.put(r111, Integer.valueOf(r106.intValue() + 1));
    L13:
        HashMap<String, Integer> r107 = this.f163202e;
        Integer r108 = r107.get(r111);
        if (r108 == null) goto L17;
        r104 = r108;
    L17:
        r107.put(r111, Integer.valueOf(r104.intValue() + 1));
    }
}
