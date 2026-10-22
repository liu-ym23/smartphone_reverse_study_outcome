package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.LinearLayout;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniGamePlayLaunchButtonWidget f54599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f54600b;

    public e(MiniGamePlayLaunchButtonWidget r100, String r101) {
        this.f54599a = r100;
        this.f54600b = r101;
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(this.f54600b)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        Integer r102 = (Integer) r101;
        if (r102 == null) goto L12;
        int r103 = r102.intValue();
    L13:
        float r104 = 4;
        float[] r105 = {UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104), UtilityKotlinExtentionsKt.b(r104)};
        if (this.f54599a.f54578w == false) goto L16;
        float r106 = 8;
        r105 = new float[]{UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106), UtilityKotlinExtentionsKt.b(r106)};
    L16:
        ShapeDrawable r107 = new ShapeDrawable(new RoundRectShape(r105, new RectF(0.0f, 0.0f, 0.0f, 0.0f), r105));
        r107.getPaint().setColor(r103);
        LinearLayout r108 = this.f54599a.dr();
        if (r108 == null) goto L19;
        int r109 = r108.getWidth();
    L20:
        LinearLayout r110 = this.f54599a.dr();
        if (r110 == null) goto L23;
        int r111 = r110.getHeight();
    L24:
        r107.setBounds(new Rect(0, 0, r109, r111));
        this.f54599a.dr().setBackgroundDrawable(r107);
        return;
    L23:
        r111 = 0;
        goto L24
    L19:
        r109 = 0;
        goto L20
    L12:
        r103 = ColorProtector.parseColor("#0FFE2C55");
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
