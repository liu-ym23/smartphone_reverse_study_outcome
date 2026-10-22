package com.android.ttcjpaysdk.base.ui.component.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/base/StdUIbaseDraw;", "", "()V", "BORDER_COLOR", "", "BORDER_WIDTH", "", "isStdUIDebugMod", "", "()Ljava/lang/Boolean;", "setStdUIDebugMod", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "width", "", "height", "tagName", "neeDrawDebugUI", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdUIbaseDraw {
    public static final String BORDER_COLOR = "#FF00FF";
    public static final float BORDER_WIDTH = 5.0f;
    public static final StdUIbaseDraw INSTANCE = null;
    private static Boolean isStdUIDebugMod;

    static {
        INSTANCE = new StdUIbaseDraw();
    }

    private StdUIbaseDraw() {
    }

    public final boolean neeDrawDebugUI() {
        if (Intrinsics.areEqual(Boolean.TRUE, isStdUIDebugMod) == false) goto L7;
        return true;
    L7:
        if (CJEnv.n() == false) goto L11;
        a.f554342a.getClass();
        Boolean r100 = Boolean.valueOf(((CJHostService) a.d(CJHostService.class)).isStdUIDebugMode());
        isStdUIDebugMod = r100;
        if (r100 == null) goto L11;
        return r100.booleanValue();
    L11:
        return false;
    }

    public final Boolean isStdUIDebugMod() {
        return isStdUIDebugMod;
    }

    public final void setStdUIDebugMod(Boolean r100) {
        isStdUIDebugMod = r100;
    }

    public final void draw(Canvas r100, int r101, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "tagName");
        if (neeDrawDebugUI() == true) goto L5;
        return;
    L5:
        Paint r102 = new Paint();
        r102.setColor(ColorProtector.parseColor(BORDER_COLOR));
        r102.setStrokeWidth(5.0f);
        r102.setStyle(Paint.Style.STROKE);
        if (r100 == null) goto L8;
        r100.drawRect(0.0f, 0.0f, r101, r110, r102);
    L8:
        Paint r103 = new Paint();
        r103.setTextSize(30.0f);
        r103.setColor(-65536);
        if (r100 == null) goto L12;
        r100.drawText("s : " + r111, 0.0f, 30.0f, r103);
        return;
    }
}
