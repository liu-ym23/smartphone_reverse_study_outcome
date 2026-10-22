package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public final enum y2 extends Enum<y2> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y2 f28408c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y2 f28409d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y2 f28410e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y2 f28411f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y2 f28412g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y2 f28413h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y2 f28414i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y2 f28415j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y2 f28416k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y2 f28417l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final y2 f28418m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y2 f28419n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ y2[] f28420o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28422b;

    static {
        y2 r100 = new y2("STYLE_ELEMENT_LABELFILL_OLD", 0, "labels.text.fill", 0);
        f28408c = r100;
        y2 r101 = new y2("STYLE_ELEMENT_LABELSTROKE_OLD", 1, "labels.text.stroke", 1);
        f28409d = r101;
        y2 r102 = new y2("STYLE_ELEMENT_GEOMETRYSTROKE_OLD", 2, "geometry.stroke", 2);
        f28410e = r102;
        y2 r103 = new y2("STYLE_ELEMENT_GEOMETRYFILL_OLD", 3, "geometry.fill", 3);
        f28411f = r103;
        y2 r104 = new y2("STYLE_ELEMENT_LABELFILL", 4, "textFillColor", 0);
        f28412g = r104;
        y2 r105 = new y2("STYLE_ELEMENT_LABELSTROKE", 5, "textStrokeColor", 1);
        f28413h = r105;
        y2 r110 = new y2("STYLE_ELEMENT_GEOMETRYSTROKE", 6, "strokeColor", 2);
        f28414i = r110;
        y2 r111 = new y2("STYLE_ELEMENT_GEOMETRYFILL", 7, "fillColor", 3);
        f28415j = r111;
        y2 r112 = new y2("STYLE_ELEMENT_GEOMETRYFILL1", 8, "color", 3);
        f28416k = r112;
        y2 r106 = new y2("STYLE_ELEMENT_GEOMETRYFILL2", 9, "textureName", 3);
        f28417l = r106;
        y2 r107 = new y2("STYLE_ELEMENT_BACKGROUNDFILL", 10, "backgroundColor", 4);
        f28418m = r107;
        y2 r108 = new y2("STYLE_ELEMENT_VISIBLE", 11, "visible", 5);
        f28419n = r108;
        f28420o = new y2[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r107, r108};
    }

    public static y2[] values() {
        return (y2[]) f28420o.clone();
    }

    public static int a(String r100) {
        y2[] r101 = values();
        int r102 = 0;
    L4:
        if (r102 >= 12) goto L10;
        y2 r103 = r101[r102];
        if (r103.f28421a.equals(r100) == true) goto L8;
        r102 = r102 + 1;
        goto L4
    L8:
        return r103.f28422b;
    L10:
        return -1;
    }

    public static y2 valueOf(String r100) {
        return (y2) r27.a.a(y2.class, r100);
    }

    private y2(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.f28421a = r102;
        this.f28422b = r103;
    }
}
