package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.annotation.FloatRange;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u001b\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010 R$\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010+R$\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010+¨\u0006."}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "", "lineHeight", "", "startIndex", "endIndex", "", "trimFirstLineTop", "trimLastLineBottom", "topRatio", "preserveMinimumHeight", AppAgent.CONSTRUCT, "(FIIZZFZ)V", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetricsInt", "LC7/r;", "calculateTargetMetrics", "(Landroid/graphics/Paint$FontMetricsInt;)V", "", "text", "start", "end", "spanStartVertical", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "copy$ui_text", "(IIZ)Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "copy", "F", "getLineHeight", "()F", "I", "Z", "getTrimLastLineBottom", "()Z", "firstAscent", "ascent", "descent", "lastDescent", "value", "firstAscentDiff", "getFirstAscentDiff", "()I", "lastDescentDiff", "getLastDescentDiff", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 8;
    private final int endIndex;
    private int firstAscentDiff;
    private int lastDescentDiff;
    private final float lineHeight;
    private final boolean preserveMinimumHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;
    private int firstAscent = Integer.MIN_VALUE;
    private int ascent = Integer.MIN_VALUE;
    private int descent = Integer.MIN_VALUE;
    private int lastDescent = Integer.MIN_VALUE;

    public LineHeightStyleSpan(float f, int i, int i6, boolean z10, boolean z11, @FloatRange(from = -1.0d, to = 1.0d) float f7, boolean z12) {
        this.lineHeight = f;
        this.startIndex = i;
        this.endIndex = i6;
        this.trimFirstLineTop = z10;
        this.trimLastLineBottom = z11;
        this.topRatio = f7;
        this.preserveMinimumHeight = z12;
        if ((0.0f <= f7 && f7 <= 1.0f) || f7 == -1.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        double dCeil;
        int iCeil = (int) Math.ceil(this.lineHeight);
        int iLineHeight = iCeil - LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        if (this.preserveMinimumHeight && iLineHeight <= 0) {
            int i = fontMetricsInt.ascent;
            this.ascent = i;
            int i6 = fontMetricsInt.descent;
            this.descent = i6;
            this.firstAscent = i;
            this.lastDescent = i6;
            this.firstAscentDiff = 0;
            this.lastDescentDiff = 0;
            return;
        }
        float fAbs = this.topRatio;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        }
        if (iLineHeight <= 0) {
            dCeil = Math.ceil(iLineHeight * fAbs);
        } else {
            dCeil = Math.ceil((1.0f - fAbs) * iLineHeight);
        }
        int i10 = (int) dCeil;
        int i11 = fontMetricsInt.descent;
        int i12 = i10 + i11;
        this.descent = i12;
        int i13 = i12 - iCeil;
        this.ascent = i13;
        if (this.trimFirstLineTop) {
            i13 = fontMetricsInt.ascent;
        }
        this.firstAscent = i13;
        if (this.trimLastLineBottom) {
            i12 = i11;
        }
        this.lastDescent = i12;
        this.firstAscentDiff = fontMetricsInt.ascent - i13;
        this.lastDescentDiff = i12 - i11;
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text$default(LineHeightStyleSpan lineHeightStyleSpan, int i, int i6, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text(i, i6, z10);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanStartVertical, int lineHeight, Paint.FontMetricsInt fontMetricsInt) {
        if (LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt) <= 0) {
            return;
        }
        boolean z10 = start == this.startIndex;
        boolean z11 = end == this.endIndex;
        if (z10 && z11 && this.trimFirstLineTop && this.trimLastLineBottom) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = z10 ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z11 ? this.lastDescent : this.descent;
    }

    public final LineHeightStyleSpan copy$ui_text(int startIndex, int endIndex, boolean trimFirstLineTop) {
        return new LineHeightStyleSpan(this.lineHeight, startIndex, endIndex, trimFirstLineTop, this.trimLastLineBottom, this.topRatio, this.preserveMinimumHeight);
    }

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
}
