package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ8\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J'\u0010&\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "preserveMinimumHeight", "<init>", "(FIIZZFZ)V", "getLineHeight", "()F", "getTrimLastLineBottom", "()Z", "firstAscent", "ascent", "descent", "lastDescent", "value", "firstAscentDiff", "getFirstAscentDiff", "()I", "lastDescentDiff", "getLastDescentDiff", "chooseHeight", "", "text", "", "start", "end", "spanStartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "calculateTargetMetrics", "copy", "copy$ui_text", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 8;
    private int ascent;
    private int descent;
    private final int endIndex;
    private int firstAscent;
    private int firstAscentDiff;
    private int lastDescent;
    private int lastDescentDiff;
    private final float lineHeight;
    private final boolean preserveMinimumHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt r100) {
        int r101 = LineHeightStyleSpan_androidKt.lineHeight(r100);
        int r102 = (int) Math.ceil(this.lineHeight);
        int r103 = r102 - r101;
        boolean r104 = false;
        if (this.preserveMinimumHeight == false) goto L7;
        if (r103 > 0) goto L7;
        int r105 = r100.ascent;
        this.ascent = r105;
        int r106 = r100.descent;
        this.descent = r106;
        this.firstAscent = r105;
        this.lastDescent = r106;
        this.firstAscentDiff = 0;
        this.lastDescentDiff = 0;
        return;
    L7:
        float r107 = this.topRatio;
        if (r107 != (-1.0f)) goto L10;
        r104 = true;
    L10:
        if (r104 == false) goto L12;
        r107 = Math.abs(r100.ascent) / LineHeightStyleSpan_androidKt.lineHeight(r100);
    L12:
        if (r103 > 0) goto L14;
        double r108 = Math.ceil(r103 * r107);
    L15:
        int r109 = (int) r108;
        int r110 = r100.descent;
        int r111 = r109 + r110;
        this.descent = r111;
        int r112 = r111 - r102;
        this.ascent = r112;
        if (this.trimFirstLineTop == false) goto L18;
        r112 = r100.ascent;
    L18:
        this.firstAscent = r112;
        if (this.trimLastLineBottom == false) goto L21;
        r111 = r110;
    L21:
        this.lastDescent = r111;
        this.firstAscentDiff = r100.ascent - r112;
        this.lastDescentDiff = r111 - r110;
        return;
    L14:
        r108 = Math.ceil(r103 * (1.0f - r107));
        goto L15
    }

    public final LineHeightStyleSpan copy$ui_text(int r110, int r111, boolean r112) {
        return new LineHeightStyleSpan(this.lineHeight, r110, r111, r112, this.trimLastLineBottom, this.topRatio, this.preserveMinimumHeight);
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text$default(LineHeightStyleSpan r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = r100.trimFirstLineTop;
    L6:
        return r100.copy$ui_text(r101, r102, r103);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        if (LineHeightStyleSpan_androidKt.lineHeight(r105) > 0) goto L5;
        return;
    L5:
        boolean r106 = true;
        if (r101 != this.startIndex) goto L8;
        boolean r107 = true;
    L10:
        if (r102 == this.endIndex) goto L13;
        r106 = false;
    L13:
        if (r107 == false) goto L21;
        if (r106 == false) goto L21;
        if (this.trimFirstLineTop == false) goto L21;
        if (this.trimLastLineBottom == false) goto L21;
        return;
    L21:
        if (this.firstAscent != Integer.MIN_VALUE) goto L23;
        calculateTargetMetrics(r105);
    L23:
        if (r107 == false) goto L25;
        int r108 = this.firstAscent;
    L26:
        r105.ascent = r108;
        if (r106 == false) goto L29;
        int r109 = this.lastDescent;
    L30:
        r105.descent = r109;
        return;
    L29:
        r109 = this.descent;
        goto L30
    L25:
        r108 = this.ascent;
        goto L26
    L8:
        r107 = false;
        goto L10
    }

    public LineHeightStyleSpan(float r100, int r101, int r102, boolean r103, boolean r104, float r105, boolean r106) {
        this.lineHeight = r100;
        this.startIndex = r101;
        this.endIndex = r102;
        this.trimFirstLineTop = r103;
        this.trimLastLineBottom = r104;
        this.topRatio = r105;
        this.preserveMinimumHeight = r106;
        this.firstAscent = Integer.MIN_VALUE;
        this.ascent = Integer.MIN_VALUE;
        this.descent = Integer.MIN_VALUE;
        this.lastDescent = Integer.MIN_VALUE;
        boolean r107 = true;
        if (0.0f <= r105) goto L5;
    L7:
        boolean r108 = false;
    L8:
        if (r108 == false) goto L10;
    L16:
        if (r107 == true) goto L19;
        InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
        return;
    L19:
        return;
    L10:
        if (r105 != (-1.0f)) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == true) goto L16;
        r107 = false;
        goto L16
    L12:
        r109 = false;
        goto L13
    L5:
        if (r105 > 1.0f) goto L7;
        r108 = true;
        goto L8
    }
}
