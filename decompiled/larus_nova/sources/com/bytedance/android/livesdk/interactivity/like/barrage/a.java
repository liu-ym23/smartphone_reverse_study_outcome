package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.ss.ugc.live.barrage.barrage.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f137583r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f137584s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f137585t;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.barrage.a$a, reason: collision with other inner class name */
    public static final class C2180a {
    }

    static {
    }

    public a(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        super(r100);
        this.f137585t = (int) 153.0d;
        this.f137583r = InfraKotlinExtsKt.mainThreadLazy(DiggBarrage$matrix$2.INSTANCE);
        this.f137584s = 1.0f;
        RectF r101 = this.f458058f;
        r101.right = r101.left;
        r101.bottom = r101.top;
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void g(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f458059g == AbsBarrage.State.VISIBLE) goto L5;
        return;
    L5:
        if (this.f458085q.isRecycled() == true) goto L10;
        i().setAlpha(this.f137585t);
        float r100 = this.f458058f.width();
        float r101 = this.f458058f.height();
        float r102 = 2;
        float r103 = r100 / r102;
        float r104 = r101 / r102;
        ((Matrix) this.f137583r.getValue()).setRotate(0.0f, r103, r104);
        Matrix r105 = (Matrix) this.f137583r.getValue();
        float r106 = this.f137584s;
        r105.postScale(r106, r106);
        Matrix r107 = (Matrix) this.f137583r.getValue();
        RectF r108 = this.f458058f;
        float r109 = r108.left;
        float r111 = 1 - this.f137584s;
        r107.postTranslate((r109 + ((r100 * 0.5f) * r111)) - r103, (r108.top + ((r101 * 0.5f) * r111)) - r104);
        r110.drawBitmap(this.f458085q, (Matrix) this.f137583r.getValue(), i());
        return;
    }
}
