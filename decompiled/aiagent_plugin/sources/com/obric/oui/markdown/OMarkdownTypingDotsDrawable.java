package com.obric.oui.markdown;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OMarkdownTypingDotsDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMarkdownTypingDotsDrawable extends Drawable {
    private final int cursorColor;
    private final Integer[] cursorColors;
    private final Paint[] paints;
    private final float radius;
    private long startTime;
    private final float[] xList;
    private final float xUnit;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public OMarkdownTypingDotsDrawable(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        this.xUnit = 10.0f;
        this.radius = 8.0f;
        this.xList = new float[3];
        this.cursorColor = androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(R.color.markdown_cursor_default_color, "color", "markdown_cursor_default_color"));
        this.startTime = SystemClock.uptimeMillis();
        Paint[] r1 = new Paint[3];
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= 3) goto L6;
        Paint r7 = new Paint(1);
        r7.setColor(androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(R.color.markdown_cursor_default_color, "color", "markdown_cursor_default_color")));
        r1[r5] = r7;
        r5 = r5 + 1;
        goto L4
    L6:
        this.paints = r1;
        this.cursorColors = new Integer[]{Integer.valueOf(cursorColorWithAlpha(0.1f)), Integer.valueOf(cursorColorWithAlpha(0.3f)), Integer.valueOf(cursorColorWithAlpha(0.6f))};
        Resources r11 = Resources.getSystem();
        o.c(r11, "Resources.getSystem()");
        DisplayMetrics r12 = r11.getDisplayMetrics();
    L7:
        if (r4 >= 3) goto L9;
        int r2 = r4 + 1;
        this.xList[r4] = (r2 * this.xUnit) * r12.density;
        r4 = r2;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        o.e(r9, "canvas");
        int r0 = (int) (((SystemClock.uptimeMillis() - this.startTime) / ((long) 240)) % ((long) 3));
        int r1 = this.paints.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        this.paints[r4].setColor(this.cursorColors[(r4 + r0) % 3].intValue());
        r4 = r4 + 1;
    L5:
        if (r3 >= 3) goto L7;
        r9.drawCircle(this.xList[r3], getBounds().height() / 2.0f, this.radius, this.paints[r3]);
        r3 = r3 + 1;
        goto L5
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r4) {
        Paint[] r3 = this.paints;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].setAlpha(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r4) {
        Paint[] r3 = this.paints;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].setColorFilter(r4);
        r1 = r1 + 1;
        goto L3
    }

    private final int cursorColorWithAlpha(float r4) {
        return Color.argb((int) (r4 * 255), Color.red(this.cursorColor), Color.green(this.cursorColor), Color.blue(this.cursorColor));
    }
}
