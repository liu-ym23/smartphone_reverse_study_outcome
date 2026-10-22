package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/config/l8;", "", "", "scaleType", "I", "f", "()I", com.amap.api.col.s.ce.f26396k, "(I)V", "Lcom/bytedance/android/livesdk/config/y1;", "contentFrame", "Lcom/bytedance/android/livesdk/config/y1;", "c", "()Lcom/bytedance/android/livesdk/config/y1;", "setContentFrame", "(Lcom/bytedance/android/livesdk/config/y1;)V", "Lcom/bytedance/android/livesdk/config/k8;", "bigAlignModeConfig", "Lcom/bytedance/android/livesdk/config/k8;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/config/k8;", "setBigAlignModeConfig", "(Lcom/bytedance/android/livesdk/config/k8;)V", "smallAlignModeConfig", com.amap.api.col.s.ce.f26391f, "setSmallAlignModeConfig", "topMargin", "h", "l", "bottomMargin", "b", RXScreenCaptureService.KEY_INDEX, "leftMargin", "d", "setLeftMargin", "rightMargin", "e", com.amap.api.col.s.ce.f26395j, "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f120658a = 0;

    @SerializedName("big")
    private k8 bigAlignModeConfig;

    @SerializedName("bottom_margin")
    private int bottomMargin;

    @SerializedName("content_frame")
    private y1 contentFrame;

    @SerializedName("left_margin")
    private int leftMargin;

    @SerializedName("right_margin")
    private int rightMargin;

    @SerializedName("scale_type")
    private int scaleType;

    @SerializedName("small")
    private k8 smallAlignModeConfig;

    @SerializedName("top_margin")
    private int topMargin;

    public static final class a {
        public static HashMap a() {
            HashMap r100 = new HashMap();
            l8 r101 = new l8();
            RenderViewScaleType r102 = RenderViewScaleType.WIDTH_ALIGN;
            r101.k(r102.getValue());
            r101.c().f();
            r101.l(140);
            k8 r103 = r101.a();
            AlignModeType r104 = AlignModeType.TOP_ALIGN;
            r103.b(r104.getValue());
            r101.g().b(r104.getValue());
            y1 r105 = r101.c();
            wu r106 = wu.f121553a;
            r105.h(r106.getValue().floatValue());
            r100.put(11, r101);
            l8 r107 = new l8();
            r107.k(r102.getValue());
            r107.c().f();
            r107.l(140);
            r107.a().b(r104.getValue());
            r107.g().b(r104.getValue());
            r107.c().h(r106.getValue().floatValue());
            r100.put(16, r107);
            l8 r108 = new l8();
            r108.k(r102.getValue());
            r108.c().f();
            r108.l(140);
            r108.a().b(r104.getValue());
            r108.g().b(r104.getValue());
            r108.c().h(r106.getValue().floatValue());
            r100.put(9, r108);
            l8 r109 = new l8();
            RenderViewScaleType r110 = RenderViewScaleType.HEIGHT_ALIGN;
            r109.k(r110.getValue());
            r109.c().e(0.7375f);
            r109.l(123);
            r109.i();
            k8 r111 = r109.a();
            AlignModeType r112 = AlignModeType.RIGHT_ALIGN;
            r111.b(r112.getValue());
            k8 r113 = r109.g();
            AlignModeType r114 = AlignModeType.HORIZONTAL_CENTER_ALIGN;
            r113.b(r114.getValue());
            r109.c().h(0.2625f);
            r109.c().f();
            r109.j();
            r100.put(10, r109);
            l8 r115 = new l8();
            r115.k(r110.getValue());
            r115.c().e(1.0f);
            r115.a().b(r112.getValue());
            r115.g().b(r112.getValue());
            r115.c().f();
            r115.c().g();
            r115.j();
            r100.put(8, r115);
            l8 r116 = new l8();
            r116.k(r110.getValue());
            r116.c().e(0.7375f);
            r116.l(123);
            r116.i();
            r116.a().b(r112.getValue());
            r116.g().b(r114.getValue());
            r116.c().h(0.2625f);
            r116.c().f();
            r116.j();
            r100.put(12, r116);
            l8 r117 = new l8();
            r117.k(r102.getValue());
            r117.c().f();
            r117.l(140);
            r117.a().b(r104.getValue());
            r117.g().b(r104.getValue());
            r117.c().h(r106.getValue().floatValue());
            r100.put(13, r117);
            l8 r118 = new l8();
            r118.k(r110.getValue());
            r118.c().e(1.0f);
            r118.a().b(r112.getValue());
            r118.g().b(r112.getValue());
            r118.c().f();
            r118.c().g();
            r118.j();
            r100.put(15, r118);
            l8 r119 = new l8();
            r119.k(r102.getValue());
            r119.c().f();
            r119.l(140);
            r119.a().b(r104.getValue());
            r119.g().b(r104.getValue());
            r119.c().h(r106.getValue().floatValue());
            r100.put(17, r119);
            r100.put(31, r119);
            r100.put(32, r119);
            r100.put(33, r119);
            r100.put(39, r119);
            l8 r120 = new l8();
            r120.k(r102.getValue());
            r120.c().f();
            r120.l(128);
            r120.a().b(r104.getValue());
            r120.g().b(r104.getValue());
            r120.c().h(0.18035f);
            r100.put(3, r120);
            return r100;
        }
    }

    static {
    }

    public final void j() {
        this.rightMargin = 0;
    }

    public final void i() {
        this.bottomMargin = 48;
    }

    public l8() {
        this.contentFrame = new y1();
        this.bigAlignModeConfig = new k8();
        this.smallAlignModeConfig = new k8();
    }

    public final k8 a() {
        return this.bigAlignModeConfig;
    }

    public final int b() {
        return this.bottomMargin;
    }

    public final y1 c() {
        return this.contentFrame;
    }

    public final int d() {
        return this.leftMargin;
    }

    public final int e() {
        return this.rightMargin;
    }

    public final int f() {
        return this.scaleType;
    }

    public final k8 g() {
        return this.smallAlignModeConfig;
    }

    public final int h() {
        return this.topMargin;
    }

    public final void k(int r100) {
        this.scaleType = r100;
    }

    public final void l(int r100) {
        this.topMargin = r100;
    }
}
