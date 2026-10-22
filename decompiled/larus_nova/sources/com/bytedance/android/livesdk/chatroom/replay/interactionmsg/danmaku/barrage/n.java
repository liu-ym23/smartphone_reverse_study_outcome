package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils.ReplayDanmakuUtilsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f109023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f109024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f109025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f109026d;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public n(int r100) {
        this.f109026d = null;
        float r101 = UtilityKotlinExtentionsKt.b(1);
        this.f109023a = r101;
        Paint r102 = new Paint(1);
        r102.setColor(r100);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(r101);
        Unit r103 = Unit.INSTANCE;
        this.f109024b = r102;
        this.f109025c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f109025c.set(getBounds());
        RectF r100 = this.f109025c;
        float r101 = this.f109023a;
        float r102 = 2;
        r100.inset(r101 / r102, r101 / r102);
        if (this.f109026d == null) goto L5;
        RectF r103 = this.f109025c;
        float r104 = r103.right - r103.left;
        Paint r105 = this.f109024b;
        int r106 = ReplayDanmakuUtilsKt.c((String) ListProtector.get(this.f109026d, 0));
        List<String> r107 = this.f109026d;
        r105.setShader(new LinearGradient(0.0f, 1.0f, r104, 1.0f, r106, ReplayDanmakuUtilsKt.c((String) ListProtector.get(r107, r107.size() - 1)), Shader.TileMode.CLAMP));
    L5:
        RectF r108 = this.f109025c;
        r110.drawRoundRect(r108, r108.height() / r102, this.f109025c.height() / r102, this.f109024b);
    }
}
