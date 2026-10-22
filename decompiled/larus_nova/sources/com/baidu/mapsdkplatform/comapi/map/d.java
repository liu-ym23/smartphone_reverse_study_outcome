package com.baidu.mapsdkplatform.comapi.map;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.serval.svg.SVGRenderEngine;

/* JADX INFO: loaded from: classes39.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f32142b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f32143c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f32144d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f32145e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f32146f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f32147g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f32148h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f32149i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f32150j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f32151k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f32152l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f32153m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f32154n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f32155o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f32156p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final /* synthetic */ d[] f32157q = null;

    static {
        d r100 = new d("logo", 0);
        f32141a = r100;
        d r101 = new d("popup", 1);
        f32142b = r101;
        d r102 = new d("marker", 2);
        f32143c = r102;
        d r103 = new d("ground", 3);
        f32144d = r103;
        d r104 = new d("text", 4);
        f32145e = r104;
        d r105 = new d("arc", 5);
        f32146f = r105;
        d r110 = new d("dot", 6);
        f32147g = r110;
        d r111 = new d(SVGRenderEngine.CIRCLE, 7);
        f32148h = r111;
        d r112 = new d(SVGRenderEngine.POLYLINE, 8);
        f32149i = r112;
        d r113 = new d(SVGRenderEngine.POLYGON, 9);
        f32150j = r113;
        d r114 = new d("multiPoint", 10);
        f32151k = r114;
        d r115 = new d("prism", 11);
        f32152l = r115;
        d r106 = new d("BM3DModel", 12);
        f32153m = r106;
        d r107 = new d("gradientLine", 13);
        f32154n = r107;
        d r108 = new d(GXTemplateKey.GAIAX_TRACK, 14);
        f32155o = r108;
        d r109 = new d("textPath", 15);
        f32156p = r109;
        f32157q = new d[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public static d[] values() {
        return (d[]) f32157q.clone();
    }

    public static d valueOf(String r100) {
        return (d) r27.a.a(d.class, r100);
    }

    private d(String r100, int r101) {
        super(r100, r101);
    }
}
