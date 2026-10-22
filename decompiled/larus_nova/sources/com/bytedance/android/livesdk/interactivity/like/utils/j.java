package com.bytedance.android.livesdk.interactivity.like.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f137731a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f137732b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f137733c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f137734d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f137735e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f137736f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f137737g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f137738h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f137739i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f137740j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f137741k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f137742l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f137743m = null;

    static {
        f137731a = s1.f(32.0f);
        f137732b = s1.f(36.0f);
        f137733c = ColorProtector.parseColor("#BDBDBE");
        f137734d = -1;
        f137735e = s1.f(1.3f);
        f137736f = s1.f(11.0f);
        f137737g = ColorProtector.parseColor("#FF308A");
        f137738h = -s1.f(2.0f);
        f137739i = -1;
        f137740j = s1.f(2.0f);
        s1.f(54.0f);
        f137741k = s1.f(22.0f);
        f137742l = i2.b("/digg/live_digg_double_like_stmosphere.webp");
        f137743m = i2.b("/digg/live_digg_double_like_stmosphere_begin.webp");
    }

    public static Bitmap a(Bitmap r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "avatar");
        int r100 = f137731a;
        int r101 = f137732b;
        Bitmap r102 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_4444);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        Rect r105 = new Rect(0, 0, r100, r100);
        RectF r106 = new RectF(r105);
        float r107 = r100 / 2;
        r103.drawARGB(0, 0, 0, 0);
        r104.setColor(f137733c);
        r103.drawRoundRect(r106, r107, r107, r104);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r110, null, r105, r104);
        r104.setColor(f137734d);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(f137735e);
        r103.drawCircle(r106.centerX(), r106.centerY(), r106.width() / 2, r104);
        String r112 = Marker.ANY_NON_NULL_MARKER + r111;
        Paint r113 = new Paint();
        r113.setAntiAlias(true);
        r113.setTextAlign(Paint.Align.CENTER);
        r113.setTextSize(f137736f);
        r113.setTextSkewX(-0.25f);
        r113.setFakeBoldText(true);
        float r108 = r107 + f137738h;
        float r109 = r101 - r113.getFontMetrics().bottom;
        r113.setStyle(Paint.Style.FILL_AND_STROKE);
        r113.setColor(f137739i);
        r113.setStrokeWidth(f137740j);
        r103.drawText(r112, r108, r109, r113);
        r113.setColor(f137737g);
        r113.setStrokeWidth(0.0f);
        r103.drawText(r112, r108, r109, r113);
        return r102;
    }
}
