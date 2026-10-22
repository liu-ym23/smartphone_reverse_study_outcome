package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u001c\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001a¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/android/LayoutIntrinsics;", "", "charSequence", "", "textPaint", "Landroid/text/TextPaint;", "textDirectionHeuristic", "", "<init>", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;I)V", "_maxIntrinsicWidth", "", "_minIntrinsicWidth", "_boringMetrics", "Landroid/text/BoringLayout$Metrics;", "boringMetricsIsInit", "", "_charSequenceForIntrinsicWidth", "charSequenceForIntrinsicWidth", "getCharSequenceForIntrinsicWidth", "()Ljava/lang/CharSequence;", "boringMetrics", "getBoringMetrics", "()Landroid/text/BoringLayout$Metrics;", "minIntrinsicWidth", "getMinIntrinsicWidth", "()F", "computeMinIntrinsicWidth", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "computeMaxIntrinsicWidth", "getDesiredWidth", "start", "end", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutIntrinsics {
    public static final int $stable = 8;
    private BoringLayout.Metrics _boringMetrics;
    private CharSequence _charSequenceForIntrinsicWidth;
    private float _maxIntrinsicWidth;
    private float _minIntrinsicWidth;
    private boolean boringMetricsIsInit;
    private final CharSequence charSequence;
    private final int textDirectionHeuristic;
    private final TextPaint textPaint;

    public static /* synthetic */ int a(Pair r100, Pair r101) {
        return computeMinIntrinsicWidth$lambda$1(r100, r101);
    }

    private final float computeMinIntrinsicWidth() {
        BreakIterator r100 = BreakIterator.getLineInstance(this.textPaint.getTextLocale());
        CharSequence r101 = this.charSequence;
        r100.setText(new CharSequenceCharacterIterator(r101, 0, r101.length()));
        PriorityQueue r102 = new PriorityQueue(10, new b());
        int r103 = r100.next();
        int r104 = 0;
    L4:
        if (r103 == (-1)) goto L15;
        if (r102.size() >= 10) goto L8;
        r102.add(new Pair(Integer.valueOf(r104), Integer.valueOf(r103)));
    L13:
        int r105 = r103;
        r103 = r100.next();
        r104 = r105;
        goto L4
    L8:
        Pair r106 = (Pair) r102.peek();
        if (r106 == null) goto L13;
        if ((((Number) r106.getSecond()).intValue() - ((Number) r106.getFirst()).intValue()) >= (r103 - r104)) goto L13;
        r102.poll();
        r102.add(new Pair(Integer.valueOf(r104), Integer.valueOf(r103)));
        goto L13
    L15:
        if (r102.isEmpty() == false) goto L17;
        return 0.0f;
    L17:
        Iterator r107 = r102.iterator();
        if (r107.hasNext() == false) goto L26;
        Pair r108 = (Pair) r107.next();
        float r109 = getDesiredWidth(((Number) r108.component1()).intValue(), ((Number) r108.component2()).intValue());
    L21:
        if (r107.hasNext() == false) goto L24;
        Pair r110 = (Pair) r107.next();
        r109 = Math.max(r109, getDesiredWidth(((Number) r110.component1()).intValue(), ((Number) r110.component2()).intValue()));
        goto L21
    L24:
        return r109;
    L26:
        throw new NoSuchElementException();
    }

    private final CharSequence getCharSequenceForIntrinsicWidth() {
        CharSequence r100 = this._charSequenceForIntrinsicWidth;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        if (LayoutIntrinsics_androidKt.access$getStripNonMetricAffectingCharSpans$p() == false) goto L11;
        CharSequence r101 = LayoutIntrinsics_androidKt.access$stripNonMetricAffectingCharacterStyleSpans(this.charSequence);
        this._charSequenceForIntrinsicWidth = r101;
        return r101;
    L11:
        return this.charSequence;
    }

    public final BoringLayout.Metrics getBoringMetrics() {
        if (this.boringMetricsIsInit == true) goto L6;
        TextDirectionHeuristic r100 = TextLayout_androidKt.getTextDirectionHeuristic(this.textDirectionHeuristic);
        this._boringMetrics = BoringLayoutFactory.INSTANCE.measure(this.charSequence, this.textPaint, r100);
        this.boringMetricsIsInit = true;
    L6:
        return this._boringMetrics;
    }

    public final float getMaxIntrinsicWidth() {
        if (Float.isNaN(this._maxIntrinsicWidth) == false) goto L7;
        float r100 = computeMaxIntrinsicWidth();
        this._maxIntrinsicWidth = r100;
        return r100;
    L7:
        return this._maxIntrinsicWidth;
    }

    public final float getMinIntrinsicWidth() {
        if (Float.isNaN(this._minIntrinsicWidth) == false) goto L7;
        float r100 = computeMinIntrinsicWidth();
        this._minIntrinsicWidth = r100;
        return r100;
    L7:
        return this._minIntrinsicWidth;
    }

    private final float computeMaxIntrinsicWidth() {
        BoringLayout.Metrics r100 = getBoringMetrics();
        if (r100 == null) goto L5;
        int r101 = r100.width;
    L6:
        float r102 = r101;
        if (r102 >= 0.0f) goto L10;
        r102 = (float) Math.ceil(getDesiredWidth$default(this, 0, 0, 3, null));
    L10:
        if (LayoutIntrinsics_androidKt.access$shouldIncreaseMaxIntrinsic(r102, this.charSequence, this.textPaint) == true) goto L12;
        return r102;
    L12:
        return r102 + 0.5f;
    L5:
        r101 = -1;
        goto L6
    }

    private static final int computeMinIntrinsicWidth$lambda$1(Pair r100, Pair r101) {
        return (((Number) r100.getSecond()).intValue() - ((Number) r100.getFirst()).intValue()) - (((Number) r101.getSecond()).intValue() - ((Number) r101.getFirst()).intValue());
    }

    private final float getDesiredWidth(int r100, int r101) {
        return Layout.getDesiredWidth(getCharSequenceForIntrinsicWidth(), r100, r101, this.textPaint);
    }

    public LayoutIntrinsics(CharSequence r100, TextPaint r101, int r102) {
        this.charSequence = r100;
        this.textPaint = r101;
        this.textDirectionHeuristic = r102;
        this._maxIntrinsicWidth = Float.NaN;
        this._minIntrinsicWidth = Float.NaN;
    }

    public static /* synthetic */ float getDesiredWidth$default(LayoutIntrinsics r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.getCharSequenceForIntrinsicWidth().length();
    L9:
        return r100.getDesiredWidth(r101, r102);
    }
}
