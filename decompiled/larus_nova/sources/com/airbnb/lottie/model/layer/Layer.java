package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.Mask;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import n0.j;
import n0.k;
import n0.l;

/* JADX INFO: loaded from: classes3.dex */
public final class Layer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o0.b> f24864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieComposition f24865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayerType f24868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f24869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f24870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Mask> f24871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f24872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f24873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f24874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f24875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f24876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f24877n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f24878o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f24879p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j f24880q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k f24881r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final n0.b f24882s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<v0.a<Float>> f24883t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MatteType f24884u;

    public static final enum LayerType extends Enum<LayerType> {
        public static final LayerType Image = null;
        public static final LayerType Null = null;
        public static final LayerType PreComp = null;
        public static final LayerType Shape = null;
        public static final LayerType Solid = null;
        public static final LayerType Text = null;
        public static final LayerType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LayerType[] f24885a = null;

        static {
            LayerType r100 = new LayerType("PreComp", 0);
            PreComp = r100;
            LayerType r101 = new LayerType("Solid", 1);
            Solid = r101;
            LayerType r102 = new LayerType("Image", 2);
            Image = r102;
            LayerType r103 = new LayerType("Null", 3);
            Null = r103;
            LayerType r104 = new LayerType("Shape", 4);
            Shape = r104;
            LayerType r105 = new LayerType("Text", 5);
            Text = r105;
            LayerType r110 = new LayerType("Unknown", 6);
            Unknown = r110;
            f24885a = new LayerType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static LayerType[] values() {
            return (LayerType[]) f24885a.clone();
        }

        public static LayerType valueOf(String r100) {
            return (LayerType) r27.a.a(LayerType.class, r100);
        }

        public LayerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MatteType extends Enum<MatteType> {
        public static final MatteType Add = null;
        public static final MatteType Invert = null;
        public static final MatteType None = null;
        public static final MatteType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MatteType[] f24886a = null;

        static {
            MatteType r100 = new MatteType("None", 0);
            None = r100;
            MatteType r101 = new MatteType("Add", 1);
            Add = r101;
            MatteType r102 = new MatteType("Invert", 2);
            Invert = r102;
            MatteType r103 = new MatteType("Unknown", 3);
            Unknown = r103;
            f24886a = new MatteType[]{r100, r101, r102, r103};
        }

        public static MatteType[] values() {
            return (MatteType[]) f24886a.clone();
        }

        public static MatteType valueOf(String r100) {
            return (MatteType) r27.a.a(MatteType.class, r100);
        }

        public MatteType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return a("");
    }

    public final String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(this.f24866c);
        r101.append("\n");
        Layer r102 = this.f24865b.layerModelForId(this.f24869f);
        if (r102 == null) goto L9;
        r101.append("\t\tParents: ");
        r101.append(r102.f24866c);
        Layer r103 = this.f24865b.layerModelForId(r102.f24869f);
    L5:
        if (r103 == null) goto L7;
        r101.append("->");
        r101.append(r103.f24866c);
        r103 = this.f24865b.layerModelForId(r103.f24869f);
        goto L5
    L7:
        r101.append(r100);
        r101.append("\n");
    L9:
        if (this.f24871h.isEmpty() == true) goto L12;
        r101.append(r100);
        r101.append("\tMasks: ");
        r101.append(this.f24871h.size());
        r101.append("\n");
    L12:
        if (this.f24873j == 0) goto L17;
        if (this.f24874k == 0) goto L17;
        r101.append(r100);
        r101.append("\tBackground: ");
        r101.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(this.f24873j), Integer.valueOf(this.f24874k), Integer.valueOf(this.f24875l)}));
    L17:
        if (this.f24864a.isEmpty() == true) goto L23;
        r101.append(r100);
        r101.append("\tShapes:\n");
        Iterator<o0.b> r104 = this.f24864a.iterator();
    L20:
        if (r104.hasNext() == false) goto L23;
        o0.b r105 = r104.next();
        r101.append(r100);
        r101.append("\t\t");
        r101.append(r105);
        r101.append("\n");
    L23:
        return r101.toString();
    }

    public Layer(List<o0.b> r100, LottieComposition r101, String r102, long r103, LayerType r104, long r110, String r111, List<Mask> r112, l r113, int r114, int r115, int r116, float r117, float r118, int r210, int r211, j r212, k r213, List<v0.a<Float>> r214, MatteType r215, n0.b r216) {
        this.f24864a = r100;
        this.f24865b = r101;
        this.f24866c = r102;
        this.f24867d = r103;
        this.f24868e = r104;
        this.f24869f = r110;
        this.f24870g = r111;
        this.f24871h = r112;
        this.f24872i = r113;
        this.f24873j = r114;
        this.f24874k = r115;
        this.f24875l = r116;
        this.f24876m = r117;
        this.f24877n = r118;
        this.f24878o = r210;
        this.f24879p = r211;
        this.f24880q = r212;
        this.f24881r = r213;
        this.f24883t = r214;
        this.f24884u = r215;
        this.f24882s = r216;
    }
}
