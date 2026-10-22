package com.obric.oui.texteffects.render;

import android.graphics.LinearGradient;
import android.text.TextUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLayoutCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003Jq\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00106\u001a\u000207H\u0016J\t\u00108\u001a\u000209HÖ\u0001R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006:"}, d2 = {"Lcom/obric/oui/texteffects/render/TextLayoutCache;", "", "text", "", "displayText", "chars", "", "widths", "", "contentWidth", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textSizePx", "baseTotalWidth", "baseStartX", "gradientShader", "Landroid/graphics/LinearGradient;", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[C[FFLandroid/text/TextUtils$TruncateAt;FFFLandroid/graphics/LinearGradient;)V", "getBaseStartX", "()F", "setBaseStartX", "(F)V", "getBaseTotalWidth", "setBaseTotalWidth", "getChars", "()[C", "getContentWidth", "getDisplayText", "()Ljava/lang/CharSequence;", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getGradientShader", "()Landroid/graphics/LinearGradient;", "setGradientShader", "(Landroid/graphics/LinearGradient;)V", "getText", "getTextSizePx", "getWidths", "()[F", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextLayoutCache {
    private float baseStartX;
    private float baseTotalWidth;
    private final char[] chars;
    private final float contentWidth;
    private final CharSequence displayText;
    private final TextUtils.TruncateAt ellipsize;
    private LinearGradient gradientShader;
    private final CharSequence text;
    private final float textSizePx;
    private final float[] widths;

    public static /* synthetic */ TextLayoutCache copy$default(TextLayoutCache r11, CharSequence r12, CharSequence r13, char[] r14, float[] r15, float r16, TextUtils.TruncateAt r17, float r18, float r19, float r20, LinearGradient r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        CharSequence r2 = r11.text;
    L7:
        if ((r22 & 2) == 0) goto L9;
        CharSequence r3 = r11.displayText;
    L11:
        if ((r22 & 4) == 0) goto L13;
        char[] r4 = r11.chars;
    L15:
        if ((r22 & 8) == 0) goto L17;
        float[] r5 = r11.widths;
    L19:
        if ((r22 & 16) == 0) goto L21;
        float r6 = r11.contentWidth;
    L23:
        if ((r22 & 32) == 0) goto L25;
        TextUtils.TruncateAt r7 = r11.ellipsize;
    L27:
        if ((r22 & 64) == 0) goto L29;
        float r8 = r11.textSizePx;
    L31:
        if ((r22 & 128) == 0) goto L33;
        float r9 = r11.baseTotalWidth;
    L35:
        if ((r22 & 256) == 0) goto L37;
        float r10 = r11.baseStartX;
    L39:
        if ((r22 & 512) == 0) goto L41;
        LinearGradient r1 = r11.gradientShader;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final CharSequence component1() {
        return this.text;
    }

    public final LinearGradient component10() {
        return this.gradientShader;
    }

    public final CharSequence component2() {
        return this.displayText;
    }

    public final char[] component3() {
        return this.chars;
    }

    public final float[] component4() {
        return this.widths;
    }

    public final float component5() {
        return this.contentWidth;
    }

    public final TextUtils.TruncateAt component6() {
        return this.ellipsize;
    }

    public final float component7() {
        return this.textSizePx;
    }

    public final float component8() {
        return this.baseTotalWidth;
    }

    public final float component9() {
        return this.baseStartX;
    }

    public final TextLayoutCache copy(CharSequence r13, CharSequence r14, char[] r15, float[] r16, float r17, TextUtils.TruncateAt r18, float r19, float r20, float r21, LinearGradient r22) {
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r14, "displayText");
        Intrinsics.checkNotNullParameter(r15, "chars");
        Intrinsics.checkNotNullParameter(r16, "widths");
        return new TextLayoutCache(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public String toString() {
        return "TextLayoutCache(text=" + this.text + ", displayText=" + this.displayText + ", chars=" + Arrays.toString(this.chars) + ", widths=" + Arrays.toString(this.widths) + ", contentWidth=" + this.contentWidth + ", ellipsize=" + this.ellipsize + ", textSizePx=" + this.textSizePx + ", baseTotalWidth=" + this.baseTotalWidth + ", baseStartX=" + this.baseStartX + ", gradientShader=" + this.gradientShader + ')';
    }

    public TextLayoutCache(CharSequence r2, CharSequence r3, char[] r4, float[] r5, float r6, TextUtils.TruncateAt r7, float r8, float r9, float r10, LinearGradient r11) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "displayText");
        Intrinsics.checkNotNullParameter(r4, "chars");
        Intrinsics.checkNotNullParameter(r5, "widths");
        this.text = r2;
        this.displayText = r3;
        this.chars = r4;
        this.widths = r5;
        this.contentWidth = r6;
        this.ellipsize = r7;
        this.textSizePx = r8;
        this.baseTotalWidth = r9;
        this.baseStartX = r10;
        this.gradientShader = r11;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final CharSequence getDisplayText() {
        return this.displayText;
    }

    public final char[] getChars() {
        return this.chars;
    }

    public final float[] getWidths() {
        return this.widths;
    }

    public final float getContentWidth() {
        return this.contentWidth;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final float getTextSizePx() {
        return this.textSizePx;
    }

    public final float getBaseTotalWidth() {
        return this.baseTotalWidth;
    }

    public final void setBaseTotalWidth(float r1) {
        this.baseTotalWidth = r1;
    }

    public final float getBaseStartX() {
        return this.baseStartX;
    }

    public final void setBaseStartX(float r1) {
        this.baseStartX = r1;
    }

    public final LinearGradient getGradientShader() {
        return this.gradientShader;
    }

    public final void setGradientShader(LinearGradient r1) {
        this.gradientShader = r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextLayoutCache) == true) goto L8;
        return false;
    L8:
        TextLayoutCache r6 = (TextLayoutCache) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == false) goto L42;
        if (Intrinsics.areEqual(this.displayText, r6.displayText) == false) goto L42;
        if (Arrays.equals(this.chars, r6.chars) == false) goto L42;
        if (Arrays.equals(this.widths, r6.widths) == false) goto L42;
        if (this.contentWidth != r6.contentWidth) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == false) goto L42;
        if (this.ellipsize != r6.ellipsize) goto L42;
        if (this.textSizePx != r6.textSizePx) goto L26;
        boolean r2 = true;
    L27:
        if (r2 == false) goto L42;
        if (this.baseTotalWidth != r6.baseTotalWidth) goto L31;
        boolean r3 = true;
    L32:
        if (r3 == false) goto L42;
        if (this.baseStartX != r6.baseStartX) goto L36;
        boolean r4 = true;
    L37:
        if (r4 == false) goto L42;
        if (Intrinsics.areEqual(this.gradientShader, r6.gradientShader) == false) goto L42;
        return true;
    L36:
        r4 = false;
        goto L37
    L31:
        r3 = false;
        goto L32
    L26:
        r2 = false;
        goto L27
    L19:
        r1 = false;
    L42:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((((this.text.hashCode() * 31) + this.displayText.hashCode()) * 31) + Arrays.hashCode(this.chars)) * 31) + Arrays.hashCode(this.widths)) * 31) + Float.hashCode(this.contentWidth)) * 31;
        TextUtils.TruncateAt r1 = this.ellipsize;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + Float.hashCode(this.textSizePx)) * 31) + Float.hashCode(this.baseTotalWidth)) * 31) + Float.hashCode(this.baseStartX)) * 31;
        LinearGradient r5 = this.gradientShader;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }
}
