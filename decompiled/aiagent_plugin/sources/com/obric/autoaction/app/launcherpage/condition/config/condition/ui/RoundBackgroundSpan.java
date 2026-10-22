package com.obric.autoaction.app.launcherpage.condition.config.condition.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.style.ReplacementSpan;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RoundBackgroundSpan.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RoundBackgroundSpan extends ReplacementSpan {
    private final int backgroundColor;
    private final Float cornerRadius;
    private final float paddingBottom;
    private final float paddingLeft;
    private final float paddingRight;
    private final float paddingTop;
    private final int textColor;
    private final Float textSize;
    private final Integer textWeight;
    private final Float totalMaxWidth;

    public /* synthetic */ RoundBackgroundSpan(int r15, int r16, Float r17, float r18, float r19, float r20, float r21, Float r22, Float r23, Integer r24, int r25, h r26) {
        if ((r25 & 4) == 0) goto L5;
        Float r6 = null;
    L7:
        if ((r25 & 32) == 0) goto L9;
        float r9 = 0.0f;
    L11:
        if ((r25 & 64) == 0) goto L13;
        float r10 = 0.0f;
    L15:
        if ((r25 & 128) == 0) goto L17;
        Float r11 = null;
    L19:
        if ((r25 & 256) == 0) goto L21;
        Float r12 = null;
    L23:
        if ((r25 & 512) == 0) goto L25;
        Integer r13 = null;
    L26:
        this(r15, r16, r6, r18, r19, r9, r10, r11, r12, r13);
        return;
    L25:
        r13 = r24;
        goto L26
    L21:
        r12 = r23;
        goto L23
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }

    public RoundBackgroundSpan(int r1, int r2, Float r3, float r4, float r5, float r6, float r7, Float r8, Float r9, Integer r10) {
        this.backgroundColor = r1;
        this.textColor = r2;
        this.cornerRadius = r3;
        this.paddingLeft = r4;
        this.paddingRight = r5;
        this.paddingTop = r6;
        this.paddingBottom = r7;
        this.totalMaxWidth = r8;
        this.textSize = r9;
        this.textWeight = r10;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r11, CharSequence r12, int r13, int r14, Paint.FontMetricsInt r15) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r11, "paint");
        o.e(r3, "text");
        float r16 = r11.getTextSize();
        Typeface r17 = r11.getTypeface();
        int r7 = getMaxWidth(r11, r3, r13, r14);
        Float r1 = this.textSize;
        if (r1 == null) goto L5;
        r11.setTextSize(r1.floatValue());
    L5:
        boolean r8 = false;
        if (this.textWeight != null) goto L8;
    L10:
        int r9 = (int) Math.ceil((r11.measureText(r3, r13, r14) + this.paddingLeft) + this.paddingRight);
        if (r7 <= 0) goto L13;
        float r2 = (r7 - this.paddingLeft) - this.paddingRight;
    L14:
        String r18 = getClipText(r11, r3, r13, r14, r2);
        float r19 = r11.measureText(r18);
        r11.setTextSize(r16);
        r11.setTypeface(r17);
        if (r7 <= 0) goto L23;
        int r10 = (int) Math.ceil(this.paddingLeft + this.paddingRight);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L19;
        r8 = true;
    L19:
        if (r8 == false) goto L22;
        return r10;
    L22:
        return Math.max(Math.min((int) Math.ceil((r19 + this.paddingLeft) + this.paddingRight), r7), r10);
    L23:
        return r9;
    L13:
        r2 = -1.0f;
        goto L14
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r11.setTypeface(Typeface.create(r11.getTypeface(), this.textWeight.intValue(), false));
        goto L10
    }

    private final int getMaxWidth(Paint r7, CharSequence r8, int r9, int r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        Float r0 = this.totalMaxWidth;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.floatValue() <= 0.0f) goto L21;
        float r1 = r7.getTextSize();
        Typeface r2 = r7.getTypeface();
        Float r3 = this.textSize;
        if (r3 == null) goto L11;
        r7.setTextSize(r3.floatValue());
    L11:
        if (this.textWeight != null) goto L13;
    L15:
        int r12 = (int) Math.ceil((r7.measureText(r11, r9, r10) + this.paddingLeft) + this.paddingRight);
        r7.setTextSize(r1);
        r7.setTypeface(r2);
        if (r12 > this.totalMaxWidth.floatValue()) goto L18;
        return -1;
    L18:
        return Math.max(((int) this.totalMaxWidth.floatValue()) - 1, (int) Math.ceil(this.paddingLeft + this.paddingRight));
    L13:
        if (Build.VERSION.SDK_INT < 28) goto L15;
        r7.setTypeface(Typeface.create(r7.getTypeface(), this.textWeight.intValue(), false));
        goto L15
    L21:
        return -1;
    }

    private final String getClipText(Paint r5, CharSequence r6, int r7, int r8, float r9) {
        String r4 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin")).subSequence(r7, r8).toString();
        if (r9 > 0.0f) goto L6;
        return r4;
    L6:
        if (r5.measureText(r4) > r9) goto L9;
        return r4;
    L9:
        if (r5.measureText("...") <= r9) goto L12;
        return "";
    L12:
        int r10 = 5;
        if (r4.length() > 5) goto L15;
        r10 = r4.length() / 2;
    L15:
        int r11 = r4.length() - r10;
        if (r11 <= 0) goto L37;
        if (r10 <= 0) goto L37;
        StringBuilder r2 = new StringBuilder();
        String r3 = r4.substring(0, r11);
        o.c(r3, "substring(...)");
        StringBuilder r12 = r2.append(r3).append("...");
        String r13 = r4.substring(r4.length() - r10);
        o.c(r13, "substring(...)");
        String r14 = r12.append(r13).toString();
        float r15 = r5.measureText(r14);
    L20:
        if (r15 <= r9) goto L50;
        if (r11 > 0) goto L24;
        if (r10 <= 0) goto L50;
    L24:
        if (r11 <= 1) goto L26;
    L25:
        r11 = r11 - 1;
    L28:
        if (r11 <= 0) goto L31;
        if (r10 <= 0) goto L31;
        StringBuilder r16 = new StringBuilder();
        String r17 = r4.substring(0, r11);
        o.c(r17, "substring(...)");
        StringBuilder r18 = r16.append(r17).append("...");
        String r19 = r4.substring(r4.length() - r10);
        o.c(r19, "substring(...)");
        r14 = r18.append(r19).toString();
    L36:
        r15 = r5.measureText(r14);
    L31:
        if (r11 <= 0) goto L33;
        StringBuilder r20 = new StringBuilder();
        String r21 = r4.substring(0, r11);
        o.c(r21, "substring(...)");
        r14 = r20.append(r21).append("...").toString();
        goto L36
    L33:
        if (r10 <= 0) goto L35;
        StringBuilder r22 = new StringBuilder().append("...");
        String r23 = r4.substring(r4.length() - r10);
        o.c(r23, "substring(...)");
        r14 = r22.append(r23).toString();
        goto L36
    L35:
        r14 = "...";
        goto L36
    L26:
        if (r10 <= 0) goto L25;
        r10 = r10 - 1;
    L50:
        if (r5.measureText(r14) <= r9) goto L52;
        return "...";
    L52:
        return r14;
    L37:
        if (r11 <= 0) goto L48;
        StringBuilder r24 = new StringBuilder();
        String r25 = r4.substring(0, r11);
        o.c(r25, "substring(...)");
        String r26 = r24.append(r25).append("...").toString();
        float r27 = r5.measureText(r26);
    L40:
        if (r27 <= r9) goto L47;
        if (r11 <= 0) goto L47;
        r11 = r11 - 1;
        if (r11 <= 0) goto L45;
        StringBuilder r28 = new StringBuilder();
        String r29 = r4.substring(0, r11);
        o.c(r29, "substring(...)");
        r26 = r28.append(r29).append("...").toString();
    L46:
        r27 = r5.measureText(r26);
        goto L40
    L45:
        r26 = "...";
    L47:
        r14 = r26;
        goto L50
    L48:
        r14 = "...";
        goto L50
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r17, CharSequence r18, int r19, int r20, float r21, int r22, int r23, int r24, Paint r25) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r18, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r17, "canvas");
        o.e(r2, "text");
        o.e(r25, "paint");
        int r11 = r25.getColor();
        Paint.Style r12 = r25.getStyle();
        boolean r13 = r25.isAntiAlias();
        float r14 = r25.getTextSize();
        Typeface r15 = r25.getTypeface();
        int r0 = getMaxWidth(r25, r2, r19, r20);
        r25.setAntiAlias(true);
        Float r1 = this.textSize;
        if (r1 == null) goto L6;
        r25.setTextSize(r1.floatValue());
    L6:
        if (this.textWeight != null) goto L8;
    L10:
        if (r0 <= 0) goto L12;
        float r3 = (r0 - this.paddingLeft) - this.paddingRight;
    L13:
        String r4 = getClipText(r25, r2, r19, r20, r3);
        float r5 = ((this.paddingLeft + r21) + r25.measureText(r4)) + this.paddingRight;
        Paint.FontMetricsInt r6 = r25.getFontMetricsInt();
        RectF r7 = new RectF(r21, (r6.ascent + r23) - this.paddingTop, r5, (r6.descent + r23) + this.paddingBottom);
        float r8 = r7.height() / 2.0f;
        Float r9 = this.cornerRadius;
        if (r9 == null) goto L16;
        float r10 = r9.floatValue();
    L17:
        float r16 = Math.min(r10, r8);
        r25.setColor(this.backgroundColor);
        r25.setStyle(Paint.Style.FILL);
        r17.drawRoundRect(r7, r16, r16, r25);
        r25.setColor(this.textColor);
        r17.drawText(r4, 0, r4.length(), this.paddingLeft + r21, r23, r25);
        r25.setColor(r11);
        r25.setStyle(r12);
        r25.setAntiAlias(r13);
        r25.setTextSize(r14);
        r25.setTypeface(r15);
        return;
    L16:
        r10 = r8;
        goto L17
    L12:
        r3 = -1.0f;
        goto L13
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r25.setTypeface(Typeface.create(r25.getTypeface(), this.textWeight.intValue(), false));
        goto L10
    }
}
