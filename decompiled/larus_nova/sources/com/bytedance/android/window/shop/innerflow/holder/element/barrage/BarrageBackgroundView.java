package com.bytedance.android.window.shop.innerflow.holder.element.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import com.larus.dora.impl.ota.g2.j0;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/barrage/BarrageBackgroundView;", "Landroid/view/View;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageBackgroundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, LinearGradient> f189050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Path> f189051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, LinearGradient> f189052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Path> f189053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f189054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f189055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f189056g;

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        this.f189054e.setColor(2147483392);
        Paint r100 = this.f189054e;
        int r101 = getWidth();
        int r102 = getHeight();
        LinearGradient r103 = this.f189050a.get(Integer.valueOf(r101));
        if (r103 != null) goto L6;
        int r110 = (int) 2151346943L;
        r103 = new LinearGradient(0.0f, 0.0f, r101, r102, r110, r110, Shader.TileMode.CLAMP);
        this.f189050a.put(Integer.valueOf(r101), r103);
    L6:
        r100.setShader(r103);
        int r104 = getWidth();
        int r105 = getHeight();
        Path r106 = this.f189051b.get(Integer.valueOf(r104));
        if (r106 != null) goto L10;
        float r107 = r104;
        float r108 = r105;
        float r109 = r108 / 2;
        RectF r111 = new RectF(0.0f, 0.0f, r108, r108);
        RectF r112 = new RectF(r107 - r108, 0.0f, r107, r108);
        RectF r113 = new RectF(this.f189055f, this.f189056g, r108, r108);
        RectF r114 = new RectF(r107 - (r108 - this.f189056g), this.f189055f, r107, r108);
        Path r115 = new Path();
        r115.moveTo(r109, r108);
        r115.arcTo(r111, 90.0f, 180.0f);
        r115.lineTo(r107 - r109, 0.0f);
        r115.arcTo(r112, 270.0f, 180.0f);
        r115.arcTo(r114, 90.0f, -180.0f);
        r115.lineTo(r113.centerX(), r113.top);
        r115.arcTo(r113, 270.0f, -180.0f);
        r115.lineTo(r109, r108);
        this.f189051b.put(Integer.valueOf(r104), r115);
        r106 = r115;
    L10:
        r210.drawPath(r106, this.f189054e);
        this.f189054e.setColor(2147418112);
        Paint r116 = this.f189054e;
        int r117 = getWidth();
        int r118 = getHeight();
        LinearGradient r119 = this.f189052c.get(Integer.valueOf(r117));
        if (r119 != null) goto L14;
        LinearGradient r120 = new LinearGradient(0.0f, 0.0f, r117 - this.f189056g, r118 - this.f189055f, (int) j0.G2_OTA_SPACE_RESERVE_BYTES, MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED, Shader.TileMode.CLAMP);
        this.f189052c.put(Integer.valueOf(r117), r120);
        r119 = r120;
    L14:
        r116.setShader(r119);
        int r121 = getWidth();
        int r122 = getHeight();
        Path r123 = this.f189053d.get(Integer.valueOf(r121));
        if (r123 != null) goto L18;
        float r124 = r121;
        float r125 = r122;
        float r126 = r125 / 2;
        RectF r127 = new RectF(this.f189055f, this.f189056g, r125, r125);
        RectF r128 = new RectF(r124 - (r125 - this.f189056g), this.f189055f, r124, r125);
        Path r129 = new Path();
        r129.moveTo(r126, r125);
        r129.arcTo(r127, 90.0f, 180.0f);
        r129.lineTo(r124 - r126, this.f189055f);
        r129.arcTo(r128, 270.0f, 180.0f);
        r129.close();
        this.f189053d.put(Integer.valueOf(r121), r129);
        r123 = r129;
    L18:
        r210.drawPath(r123, this.f189054e);
    }

    public BarrageBackgroundView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100, r101);
        this.f189050a = new ConcurrentHashMap();
        this.f189051b = new ConcurrentHashMap();
        this.f189052c = new ConcurrentHashMap();
        this.f189053d = new ConcurrentHashMap();
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r103 = Unit.INSTANCE;
        this.f189054e = r102;
        this.f189055f = b.b(2);
        this.f189056g = b.b(2);
    }
}
