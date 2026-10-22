package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.barrage.StrokeTextBarrage;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends StrokeTextBarrage implements a {
    public jq1.b H;
    public final LinearGradient I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Matrix f109027J;
    public final boolean K;

    @Override // com.ss.ugc.live.barrage.barrage.StrokeTextBarrage, com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void g(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.K == false) goto L16;
        RectF r101 = this.f458058f;
        float r102 = r101.left;
        float r103 = this.f458075s;
        float r104 = 0;
        if (r103 > r104) goto L8;
        r103 = this.f458065m.f458068b;
    L8:
        float r105 = r102 + r103;
        float r106 = (r101.bottom - this.f458077u) + this.f458065m.f458069c;
        this.f109027J.reset();
        this.f109027J.setScale(this.f458078v.width(), this.f458078v.height(), 0.0f, 0.0f);
        this.f109027J.postTranslate(r105, r106);
        this.I.setLocalMatrix(this.f109027J);
        q().setShader(this.I);
        if (this.D <= r104) goto L15;
        String r107 = this.f458079w;
        RectF r108 = this.f458058f;
        float r109 = r108.left;
        float r110 = this.f458075s;
        if (r110 > r104) goto L14;
        r110 = this.f458065m.f458068b;
    L14:
        float r111 = (r108.bottom - this.f458077u) + this.f458065m.f458069c;
        Lazy r112 = this.C;
        KProperty r113 = StrokeTextBarrage.G[0];
        r100.drawText(r107, r109 + r110, r111, (Paint) r112.getValue());
    L15:
        r100.drawText(this.f458079w, r105, r106, q());
        return;
    L16:
        super.g(r100);
    }

    public o(String r100, float r101, int r102, Typeface r103, float r104, AbsBarrage.b r105, float r106, int r107, int r110, boolean r111, boolean r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r105, "config");
        super(r100, r101, r102, r103, r104, r105, r106, r107, r110);
        this.K = r112;
        this.I = new LinearGradient(0.0f, 1.0f, 1.0f, 1.0f, r113, r114, Shader.TileMode.CLAMP);
        this.f109027J = new Matrix();
        if (r111 == false) goto L6;
        q().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        return;
    }
}
