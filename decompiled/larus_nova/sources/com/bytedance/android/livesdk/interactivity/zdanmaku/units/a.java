package com.bytedance.android.livesdk.interactivity.zdanmaku.units;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.live.artist.render.RenderEntity;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> extends tk6.b<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final sk6.a f141805k = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f141806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f141807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public sk6.a f141808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f141809j;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.zdanmaku.units.a$a, reason: collision with other inner class name */
    public static final class C2235a {
    }

    static {
        f141805k = new sk6.a(0);
    }

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void d() {
        super.d();
        T r100 = this.f523106d;
        boolean r101 = r100 instanceof q72.b;
        if (r101 == true) goto L5;
        Object r102 = null;
    L6:
        q72.b r103 = (q72.b) r102;
        if (r103 == null) goto L9;
        r103.f531924b = null;
    L9:
        if (r101 == true) goto L11;
        Object r104 = null;
    L12:
        q72.b r105 = (q72.b) r104;
        if (r105 == null) goto L16;
        r105.f531923a = null;
    L16:
        if ((r100 instanceof q72.c) == true) goto L18;
        r100 = (T) null;
    L18:
        q72.c r106 = r100;
        if (r106 == null) goto L22;
        r106.f531933f = null;
        return;
    L22:
        return;
    L11:
        r104 = r100;
        goto L12
    L5:
        r102 = r100;
        goto L6
    }

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void e() {
        super.e();
        of6.a r100 = this.f523105c;
        if (r100 == null) goto L29;
        this.f141809j = ((tk6.a) r100).f546529i;
        boolean r101 = r100 instanceof tk6.a;
        if (r101 == true) goto L7;
        of6.a r102 = null;
    L8:
        tk6.a r103 = (tk6.a) r102;
        int r104 = 0;
        if (r103 == null) goto L11;
        int r105 = r103.f546527g;
    L12:
        if (r101 == true) goto L14;
        r100 = null;
    L14:
        tk6.a r106 = (tk6.a) r100;
        if (r106 == null) goto L17;
        r104 = r106.f546528h;
    L17:
        float r107 = r105;
        float r108 = r104;
        RenderEntity r109 = this.f254850a;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L20:
        com.bytedance.live.artist.render.f r110 = r109.f254828c;
        r110.f254852a = r107;
        r110.f254853b = r108;
        RenderEntity r111 = this.f254850a;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L23:
        sk6.a r112 = (sk6.a) r111.e(sk6.a.class);
        if (r112 != null) goto L26;
        r112 = f141805k;
    L26:
        this.f141808i = r112;
        return;
    L11:
        r105 = 0;
        goto L12
    L7:
        r102 = r100;
        goto L8
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.zdanmaku.render.canvas.template.BitmapRenderSnapshot");
    }

    @Override // of6.c, com.bytedance.live.artist.render.e
    public final void f() {
        if (c().f254834i != null) goto L5;
        super.f();
        return;
    L5:
        sk6.a r100 = this.f141808i;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L8:
        float r101 = r100.f542420c.f518953a;
        sk6.a r102 = this.f141808i;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L11:
        float r103 = r102.f542420c.f518954b;
        RenderEntity r104 = c();
        com.bytedance.live.artist.render.b r105 = r104.f254830e;
        r105.f254847a = r101;
        r105.f254848b = r103;
        com.bytedance.live.artist.render.f r106 = r104.f254828c;
        float r107 = r101 - (r106.f254852a / 2.0f);
        float r108 = r103 - (r106.f254853b / 2.0f);
        com.bytedance.live.artist.render.b r109 = r104.f254829d;
        r109.f254847a = r107;
        r109.f254848b = r108;
        this.f141807h.reset();
        Matrix r110 = this.f141807h;
        sk6.a r111 = this.f141808i;
        if (r111 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L14:
        float r112 = r111.f542419b.f518955a;
        sk6.a r113 = this.f141808i;
        if (r113 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L17:
        r110.setScale(r112, r113.f542419b.f518956b, c().f254828c.f254852a * 0.5f, c().f254828c.f254853b * 0.5f);
        this.f141807h.postTranslate(c().f254829d.f254847a, c().f254829d.f254848b);
        Paint r114 = (Paint) this.f141806g.getValue();
        sk6.a r115 = this.f141808i;
        if (r115 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("danmakuAttributes");
    L20:
        r114.setAlpha(r115.f542418a.f529667a);
        Canvas r116 = this.f546532f;
        if (r116 == null) goto L28;
        Bitmap r117 = this.f141809j;
        if (r117 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException(SimplayerImageStrategy.RESULT_BITMAP);
    L25:
        r116.drawBitmap(r117, this.f141807h, (Paint) this.f141806g.getValue());
        return;
    }

    public a(Object r100, tk6.e r101) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        super(r100, r101);
        this.f141806g = LazyKt.lazy(ActionCanvasTemplateRenderUnit$bitmapPaint$2.INSTANCE);
        this.f141807h = new Matrix();
    }
}
