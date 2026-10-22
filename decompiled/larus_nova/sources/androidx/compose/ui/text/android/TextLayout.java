package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\tH\u0002J\u000e\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010[\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010\\\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\tJ\u000e\u0010]\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\tJ\u000e\u0010^\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\tJ\u000e\u0010_\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\tJ\u000e\u0010`\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\tJ\u000e\u0010a\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010b\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010c\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010d\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010e\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010f\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010g\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010h\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tJ\u000e\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020\tJ\u0016\u0010k\u001a\u00020\t2\u0006\u0010X\u001a\u00020\t2\u0006\u0010l\u001a\u00020\u0005J\u0018\u0010m\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\t2\b\b\u0002\u0010o\u001a\u00020\u0010J\u0018\u0010p\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\t2\b\b\u0002\u0010o\u001a\u00020\u0010J\u000e\u0010q\u001a\u00020\t2\u0006\u0010n\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\tJ\u000e\u0010s\u001a\u00020\t2\u0006\u0010X\u001a\u00020\tJ\u001e\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020yJ2\u0010z\u001a\u0004\u0018\u00010\u00192\u0006\u0010K\u001a\u00020{2\u0006\u0010|\u001a\u00020\t2\u0018\u0010}\u001a\u0014\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020\u00100~J \u0010\u007f\u001a\u00020u2\u0006\u0010Z\u001a\u00020\t2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0000¢\u0006\u0003\b\u0082\u0001J,\u0010\u0083\u0001\u001a\u00020u2\u0007\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\t2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0086\u0001\u001a\u00020\tJ\u000f\u0010\u0087\u0001\u001a\u00020{2\u0006\u0010n\u001a\u00020\tJ\u0011\u0010\u0088\u0001\u001a\u00020u2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u000f\u0010\u008b\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u008c\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0002038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u00105\u001a\u0004\b=\u0010:R\u001c\u0010>\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u00105\u001a\u0004\b@\u0010:R\u000e\u0010A\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010G\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bV\u0010:¨\u0006\u008d\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "<init>", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "getTextPaint", "()Landroid/text/TextPaint;", "getIncludePadding", "()Z", "getFallbackLineSpacing", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "didExceedMaxLines", "getDidExceedMaxLines", "backingWordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "wordIterator", "getWordIterator", "()Landroidx/compose/ui/text/android/selection/WordIterator;", "layout", "Landroid/text/Layout;", "getLayout$annotations", "()V", "getLayout", "()Landroid/text/Layout;", "lineCount", "getLineCount", "()I", "topPadding", "getTopPadding$ui_text$annotations", "getTopPadding$ui_text", "bottomPadding", "getBottomPadding$ui_text$annotations", "getBottomPadding$ui_text", "leftPadding", "rightPadding", "isBoringLayout", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "lastLineExtra", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "backingLayoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "text", "getText", "()Ljava/lang/CharSequence;", "height", "getHeight", "getHorizontalPadding", "line", "getLineLeft", "lineIndex", "getLineRight", "getLineTop", "getLineBottom", "getLineAscent", "getLineBaseline", "getLineDescent", "getLineHeight", "getLineWidth", "getLineStart", "getLineEnd", "getLineVisibleEnd", "isLineEllipsized", "getLineEllipsisOffset", "getLineEllipsisCount", "getLineForVertical", "vertical", "getOffsetForHorizontal", "horizontal", "getPrimaryHorizontal", "offset", "upstream", "getSecondaryHorizontal", "getLineForOffset", "isRtlCharAt", "getParagraphDirection", "getSelectionPath", "", "start", "end", "dest", "Landroid/graphics/Path;", "getRangeForRect", "Landroid/graphics/RectF;", "granularity", "inclusionStrategy", "Lkotlin/Function2;", "fillLineHorizontalBounds", "array", "", "fillLineHorizontalBounds$ui_text", "fillBoundingBoxes", "startOffset", "endOffset", "arrayStart", "getBoundingBox", "paint", "canvas", "Landroid/graphics/Canvas;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLayout {
    public static final int $stable = 8;
    private LayoutHelper backingLayoutHelper;
    private WordIterator backingWordIterator;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final TextUtils.TruncateAt ellipsize;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    private final Paint.FontMetricsInt lastLineFontMetrics;
    private final Layout layout;
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final Rect rect;
    private final float rightPadding;
    private final TextPaint textPaint;
    private final int topPadding;

    public static /* synthetic */ void getBottomPadding$ui_text$annotations() {
    }

    public static /* synthetic */ void getLayout$annotations() {
    }

    public static /* synthetic */ void getTopPadding$ui_text$annotations() {
    }

    private final LayoutHelper getLayoutHelper() {
        LayoutHelper r100 = this.backingLayoutHelper;
        if (r100 != null) goto L6;
        LayoutHelper r101 = new LayoutHelper(this.layout);
        this.backingLayoutHelper = r101;
        return r101;
    L6:
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public final int getHeight() {
        if (this.didExceedMaxLines == false) goto L5;
        int r100 = this.layout.getLineBottom(this.lineCount - 1);
    L7:
        return ((r100 + this.topPadding) + this.bottomPadding) + this.lastLineExtra;
    L5:
        r100 = this.layout.getHeight();
        goto L7
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final CharSequence getText() {
        return this.layout.getText();
    }

    public final WordIterator getWordIterator() {
        WordIterator r100 = this.backingWordIterator;
        if (r100 == null) goto L5;
        return r100;
    L5:
        WordIterator r101 = new WordIterator(this.layout.getText(), 0, this.layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = r101;
        return r101;
    }

    public final boolean isFallbackLinespacingApplied$ui_text() {
        if (this.isBoringLayout == false) goto L5;
        BoringLayoutFactory r100 = BoringLayoutFactory.INSTANCE;
        Layout r101 = this.layout;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.text.BoringLayout");
        return r100.isFallbackLineSpacingEnabled((BoringLayout) r101);
    L5:
        StaticLayoutFactory r102 = StaticLayoutFactory.INSTANCE;
        Layout r103 = this.layout;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.text.StaticLayout");
        return r102.isFallbackLineSpacingEnabled((StaticLayout) r103, this.fallbackLineSpacing);
    }

    public final int getBottomPadding$ui_text() {
        return this.bottomPadding;
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    public final int getTopPadding$ui_text() {
        return this.topPadding;
    }

    private final float getHorizontalPadding(int r100) {
        if (r100 == (this.lineCount - 1)) goto L7;
        return 0.0f;
    L7:
        return this.leftPadding + this.rightPadding;
    }

    public final RectF getBoundingBox(int r100) {
        int r101 = getLineForOffset(r100);
        float r102 = getLineTop(r101);
        float r103 = getLineBottom(r101);
        if (getParagraphDirection(r101) != 1) goto L5;
        boolean r104 = true;
    L6:
        boolean r105 = this.layout.isRtlCharAt(r100);
        if (r104 == false) goto L10;
        if (r105 == true) goto L10;
        float r106 = getPrimaryHorizontal(r100, false);
        float r107 = getPrimaryHorizontal(r100 + 1, true);
    L18:
        return new RectF(r106, r102, r107, r103);
    L10:
        if (r104 == false) goto L13;
        if (r105 == false) goto L13;
        float r108 = getSecondaryHorizontal(r100, false);
        float r109 = getSecondaryHorizontal(r100 + 1, true);
    L15:
        float r110 = r108;
        r106 = r109;
        r107 = r110;
    L13:
        if (r105 == false) goto L16;
        r108 = getPrimaryHorizontal(r100, false);
        r109 = getPrimaryHorizontal(r100 + 1, true);
        goto L15
    L16:
        r106 = getSecondaryHorizontal(r100, false);
        r107 = getSecondaryHorizontal(r100 + 1, true);
        goto L18
    L5:
        r104 = false;
        goto L6
    }

    public final float getLineAscent(int r100) {
        if (r100 != (this.lineCount - 1)) goto L7;
        Paint.FontMetricsInt r101 = this.lastLineFontMetrics;
        if (r101 == null) goto L7;
        int r102 = r101.ascent;
    L9:
        return r102;
    L7:
        r102 = this.layout.getLineAscent(r100);
        goto L9
    }

    public final float getLineBaseline(int r100) {
        float r101 = this.topPadding;
        if (r100 == (this.lineCount - 1)) goto L5;
    L7:
        float r102 = this.layout.getLineBaseline(r100);
    L9:
        return r101 + r102;
    L5:
        if (this.lastLineFontMetrics == null) goto L7;
        r102 = getLineTop(r100) - this.lastLineFontMetrics.ascent;
        goto L9
    }

    public final float getLineBottom(int r100) {
        if (r100 == (this.lineCount - 1)) goto L5;
    L8:
        float r101 = this.topPadding + this.layout.getLineBottom(r100);
        if (r100 != (this.lineCount - 1)) goto L11;
        int r102 = this.bottomPadding;
    L13:
        return r101 + r102;
    L11:
        r102 = 0;
        goto L13
    L5:
        if (this.lastLineFontMetrics == null) goto L8;
        return this.layout.getLineBottom(r100 - 1) + this.lastLineFontMetrics.bottom;
    }

    public final float getLineDescent(int r100) {
        if (r100 != (this.lineCount - 1)) goto L7;
        Paint.FontMetricsInt r101 = this.lastLineFontMetrics;
        if (r101 == null) goto L7;
        int r102 = r101.descent;
    L9:
        return r102;
    L7:
        r102 = this.layout.getLineDescent(r100);
        goto L9
    }

    public final int getLineEllipsisCount(int r100) {
        return this.layout.getEllipsisCount(r100);
    }

    public final int getLineEllipsisOffset(int r100) {
        return this.layout.getEllipsisStart(r100);
    }

    public final int getLineEnd(int r100) {
        if (TextLayout_androidKt.isLineEllipsized(this.layout, r100) == false) goto L8;
        if (this.ellipsize != TextUtils.TruncateAt.END) goto L8;
        return this.layout.getText().length();
    L8:
        return this.layout.getLineEnd(r100);
    }

    public final int getLineForOffset(int r100) {
        return this.layout.getLineForOffset(r100);
    }

    public final int getLineForVertical(int r100) {
        return this.layout.getLineForVertical(r100 - this.topPadding);
    }

    public final float getLineHeight(int r100) {
        return getLineBottom(r100) - getLineTop(r100);
    }

    public final float getLineLeft(int r100) {
        float r101 = this.layout.getLineLeft(r100);
        if (r100 != (this.lineCount - 1)) goto L5;
        float r102 = this.leftPadding;
    L7:
        return r101 + r102;
    L5:
        r102 = 0.0f;
        goto L7
    }

    public final float getLineRight(int r100) {
        float r101 = this.layout.getLineRight(r100);
        if (r100 != (this.lineCount - 1)) goto L5;
        float r102 = this.rightPadding;
    L7:
        return r101 + r102;
    L5:
        r102 = 0.0f;
        goto L7
    }

    public final int getLineStart(int r100) {
        return this.layout.getLineStart(r100);
    }

    public final float getLineTop(int r100) {
        float r101 = this.layout.getLineTop(r100);
        if (r100 != 0) goto L5;
        int r102 = 0;
    L7:
        return r101 + r102;
    L5:
        r102 = this.topPadding;
        goto L7
    }

    public final int getLineVisibleEnd(int r100) {
        if (TextLayout_androidKt.isLineEllipsized(this.layout, r100) == false) goto L8;
        if (this.ellipsize != TextUtils.TruncateAt.END) goto L8;
        return this.layout.getLineStart(r100) + this.layout.getEllipsisStart(r100);
    L8:
        return getLayoutHelper().getLineVisibleEnd(r100);
    }

    public final float getLineWidth(int r100) {
        return this.layout.getLineWidth(r100);
    }

    public final int getParagraphDirection(int r100) {
        return this.layout.getParagraphDirection(r100);
    }

    public final boolean isLineEllipsized(int r100) {
        return TextLayout_androidKt.isLineEllipsized(this.layout, r100);
    }

    public final boolean isRtlCharAt(int r100) {
        return this.layout.isRtlCharAt(r100);
    }

    public final void paint(Canvas r100) {
        if (r100.getClipBounds(this.rect) == true) goto L5;
        return;
    L5:
        int r101 = this.topPadding;
        if (r101 == 0) goto L8;
        r100.translate(0.0f, r101);
    L8:
        ThreadLocal<TextAndroidCanvas> r102 = TextLayout_androidKt.getSharedTextAndroidCanvas();
        TextAndroidCanvas r103 = r102.get();
        if (r103 != null) goto L11;
        r103 = new TextAndroidCanvas();
        r102.set(r103);
    L11:
        TextAndroidCanvas r104 = r103;
        r104.set_nativeCanvas$ui_text(r100);
        this.layout.draw(r104);     // Catch: Throwable -> L17
        r104.set_nativeCanvas$ui_text(null);
        int r105 = this.topPadding;
        if (r105 == 0) goto L22;
        r100.translate(0.0f, (-1) * r105);
        return;
    L22:
        return;
    L17:
        th = move-exception;
        r104.set_nativeCanvas$ui_text(null);
        throw th;
    }

    public final void fillLineHorizontalBounds$ui_text(int r100, float[] r101) {
        int r102 = getLineStart(r100);
        int r103 = getLineEnd(r100);
        int r104 = (r103 - r102) * 2;
        int r105 = 0;
        boolean r106 = true;
        if (r101.length < r104) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
    L8:
        HorizontalPositionCache r108 = new HorizontalPositionCache(this);
        if (getParagraphDirection(r100) == 1) goto L12;
        r106 = false;
    L12:
        if (r102 >= r103) goto L24;
        boolean r109 = isRtlCharAt(r102);
        if (r106 == false) goto L17;
        if (r109 == true) goto L17;
        float r110 = r108.getPrimaryDownstream(r102);
        float r111 = r108.getPrimaryUpstream(r102 + 1);
    L23:
        r101[r105] = r110;
        r101[r105 + 1] = r111;
        r105 = r105 + 2;
        r102 = r102 + 1;
    L17:
        if (r106 == false) goto L20;
        if (r109 == false) goto L20;
        r111 = r108.getSecondaryDownstream(r102);
        r110 = r108.getSecondaryUpstream(r102 + 1);
    L20:
        if (r109 == false) goto L22;
        r111 = r108.getPrimaryDownstream(r102);
        r110 = r108.getPrimaryUpstream(r102 + 1);
        goto L23
    L22:
        r110 = r108.getSecondaryDownstream(r102);
        r111 = r108.getSecondaryUpstream(r102 + 1);
        goto L23
    L24:
        return;
    L5:
        r107 = false;
        goto L6
    }

    public final int getOffsetForHorizontal(int r100, float r101) {
        return this.layout.getOffsetForHorizontal(r100, r101 + ((-1) * getHorizontalPadding(r100)));
    }

    public final float getPrimaryHorizontal(int r100, boolean r101) {
        return getLayoutHelper().getHorizontalPosition(r100, true, r101) + getHorizontalPadding(getLineForOffset(r100));
    }

    public final float getSecondaryHorizontal(int r100, boolean r101) {
        return getLayoutHelper().getHorizontalPosition(r100, false, r101) + getHorizontalPadding(getLineForOffset(r100));
    }

    public final int[] getRangeForRect(RectF r100, int r101, Function2<? super RectF, ? super RectF, Boolean> r102) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return AndroidLayoutApi34.INSTANCE.getRangeForRect$ui_text(this, r100, r101, r102);
    L7:
        return TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(this, this.layout, getLayoutHelper(), r100, r101, r102);
    }

    public final void getSelectionPath(int r100, int r101, Path r102) {
        this.layout.getSelectionPath(r100, r101, r102);
        if (this.topPadding != 0) goto L5;
        return;
    L5:
        if (r102.isEmpty() == true) goto L9;
        r102.offset(0.0f, this.topPadding);
        return;
    }

    public final void fillBoundingBoxes(int r110, int r111, float[] r210, int r211) {
        int r100 = getText().length();
        int r101 = 1;
        if (r110 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("startOffset must be > 0");
    L8:
        if (r110 >= r100) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("startOffset must be less than text length");
    L13:
        if (r111 <= r110) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
        InlineClassHelperKt.throwIllegalArgumentException("endOffset must be greater than startOffset");
    L18:
        if (r111 > r100) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L24;
        InlineClassHelperKt.throwIllegalArgumentException("endOffset must be smaller or equal to text length");
    L24:
        if ((r210.length - r211) < ((r111 - r110) * 4)) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == true) goto L29;
        InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
    L29:
        int r107 = getLineForOffset(r110);
        int r108 = getLineForOffset(r111 - 1);
        HorizontalPositionCache r109 = new HorizontalPositionCache(this);
        if (r107 > r108) goto L52;
        int r112 = r107;
        int r113 = r211;
    L32:
        int r114 = getLineStart(r112);
        int r115 = getLineEnd(r112);
        int r116 = Math.max(r110, r114);
        int r117 = Math.min(r111, r115);
        float r118 = getLineTop(r112);
        float r119 = getLineBottom(r112);
        if (getParagraphDirection(r112) != r101) goto L35;
        boolean r120 = true;
    L36:
        boolean r121 = !r120;
    L37:
        if (r116 >= r117) goto L50;
        boolean r122 = isRtlCharAt(r116);
        if (r120 == false) goto L42;
        if (r122 == true) goto L42;
        float r123 = r109.getPrimaryDownstream(r116);
        float r124 = r109.getPrimaryUpstream(r116 + 1);
    L49:
        r210[r113] = r123;
        r210[r113 + 1] = r118;
        r210[r113 + 2] = r124;
        r210[r113 + 3] = r119;
        r113 = r113 + 4;
        r116 = r116 + 1;
    L42:
        if (r120 == false) goto L45;
        if (r122 == false) goto L45;
        r124 = r109.getSecondaryDownstream(r116);
        r123 = r109.getSecondaryUpstream(r116 + 1);
    L45:
        if (r121 == false) goto L48;
        if (r122 == false) goto L48;
        r124 = r109.getPrimaryDownstream(r116);
        r123 = r109.getPrimaryUpstream(r116 + 1);
    L48:
        r123 = r109.getSecondaryDownstream(r116);
        r124 = r109.getSecondaryUpstream(r116 + 1);
        goto L49
    L50:
        if (r112 == r108) goto L59;
        r112 = r112 + 1;
        r101 = 1;
        goto L32
    L59:
        return;
    L35:
        r120 = false;
        goto L36
    L52:
        return;
    L26:
        r106 = false;
        goto L27
    L20:
        r105 = false;
        goto L21
    L15:
        r104 = false;
        goto L16
    L10:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L6
    }

    public static /* synthetic */ float getPrimaryHorizontal$default(TextLayout r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getPrimaryHorizontal(r101, r102);
    }

    public static /* synthetic */ float getSecondaryHorizontal$default(TextLayout r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getSecondaryHorizontal(r101, r102);
    }

    public TextLayout(CharSequence r210, float r211, TextPaint r310, int r311, TextUtils.TruncateAt r312, int r313, float r314, float r315, boolean r316, boolean r317, int r318, int r319, int r410, int r411, int r412, int r413, int[] r414, int[] r415, LayoutIntrinsics r416) {
        this.textPaint = r310;
        this.ellipsize = r312;
        this.includePadding = r316;
        this.fallbackLineSpacing = r317;
        this.layoutIntrinsics = r416;
        this.rect = new Rect();
        int r100 = r210.length();
        TextDirectionHeuristic r110 = TextLayout_androidKt.getTextDirectionHeuristic(r313);
        Layout.Alignment r101 = TextAlignmentAdapter.INSTANCE.get(r311);
        if ((r210 instanceof Spanned) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Trace.beginSection("TextLayout:initLayout");
        BoringLayout.Metrics r103 = r416.getBoringMetrics();     // Catch: Throwable -> L35
        double r104 = r211;
        int r111 = (int) Math.ceil(r104);     // Catch: Throwable -> L35
        if (r103 != null) goto L12;
    L15:
        this.isBoringLayout = false;     // Catch: Throwable -> L35
        TextDirectionHeuristic r212 = r110;
        Layout r105 = StaticLayoutFactory.INSTANCE.create(r210, r310, r111, 0, r210.length(), r110, r101, r318, r312, (int) Math.ceil(r104), r314, r315, r413, r316, r317, r319, r410, r411, r412, r414, r415);     // Catch: Throwable -> L35
    L16:
        this.layout = r105;     // Catch: Throwable -> L35
        Trace.endSection();
        int r106 = Math.min(r105.getLineCount(), r318);
        this.lineCount = r106;
        int r107 = r106 - 1;
        if (r106 >= r318) goto L21;
    L19:
        boolean r108 = false;
    L25:
        this.didExceedMaxLines = r108;
        long r109 = TextLayout_androidKt.access$getVerticalPaddings(this);
        LineHeightStyleSpan[] r112 = TextLayout_androidKt.access$getLineHeightSpans(this);
        this.lineHeightSpans = r112;
        if (r112 == null) goto L28;
        long r113 = TextLayout_androidKt.access$getLineHeightPaddings(r112);
    L29:
        this.topPadding = Math.max(VerticalPaddings.m7050getTopPaddingimpl(r109), VerticalPaddings.m7050getTopPaddingimpl(r113));
        this.bottomPadding = Math.max(VerticalPaddings.m7049getBottomPaddingimpl(r109), VerticalPaddings.m7049getBottomPaddingimpl(r113));
        Paint.FontMetricsInt r114 = TextLayout_androidKt.access$getLastLineMetrics(this, r310, r212, r112);
        if (r114 == null) goto L32;
        int r115 = r114.bottom - ((int) getLineHeight(r107));
    L33:
        this.lastLineExtra = r115;
        this.lastLineFontMetrics = r114;
        this.leftPadding = IndentationFixSpan_androidKt.getEllipsizedLeftPadding$default(r105, r107, null, 2, null);
        this.rightPadding = IndentationFixSpan_androidKt.getEllipsizedRightPadding$default(r105, r107, null, 2, null);
        return;
    L32:
        r115 = 0;
        goto L33
    L28:
        r113 = TextLayout_androidKt.access$getZeroVerticalPadding$p();
        goto L29
    L21:
        if (r105.getEllipsisCount(r107) <= 0) goto L23;
    L24:
        r108 = true;
        goto L25
    L23:
        if (r105.getLineEnd(r107) == r210.length()) goto L19;
    L12:
        if (r416.getMaxIntrinsicWidth() > r211) goto L15;
        if (r102 == true) goto L15;
        this.isBoringLayout = true;     // Catch: Throwable -> L35
        r105 = BoringLayoutFactory.INSTANCE.create(r210, r310, r111, r103, r101, r316, r317, r312, r111);     // Catch: Throwable -> L35
        r212 = r110;
    L35:
        th = move-exception;
        Trace.endSection();
        throw th;
    L5:
        if (((Spanned) r210).nextSpanTransition(-1, r100, BaselineShiftSpan.class) >= r100) goto L7;
        r102 = true;
        goto L8
    }

    public /* synthetic */ TextLayout(CharSequence r210, float r211, TextPaint r212, int r213, TextUtils.TruncateAt r214, int r215, float r310, float r311, boolean r312, boolean r313, int r314, int r315, int r316, int r317, int r318, int r319, int[] r410, int[] r411, LayoutIntrinsics r412, int r413, DefaultConstructorMarker r414) {
        if ((r413 & 8) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r413 & 16) == 0) goto L9;
        TextUtils.TruncateAt r101 = null;
    L11:
        if ((r413 & 32) == 0) goto L13;
        int r102 = 2;
    L15:
        if ((r413 & 64) == 0) goto L17;
        float r110 = 1.0f;
    L19:
        if ((r413 & 128) == 0) goto L21;
        float r111 = 0.0f;
    L23:
        if ((r413 & 256) == 0) goto L25;
        boolean r112 = false;
    L27:
        if ((r413 & 512) == 0) goto L29;
        boolean r113 = true;
    L31:
        if ((r413 & 1024) == 0) goto L33;
        int r114 = Integer.MAX_VALUE;
    L35:
        if ((r413 & 2048) == 0) goto L37;
        int r115 = 0;
    L39:
        if ((r413 & 4096) == 0) goto L41;
        int r116 = 0;
    L43:
        if ((r413 & 8192) == 0) goto L45;
        int r117 = 0;
    L47:
        if ((r413 & 16384) == 0) goto L49;
        int r118 = 0;
    L51:
        if ((32768 & r413) == 0) goto L53;
        int r119 = 0;
    L55:
        if ((65536 & r413) == 0) goto L57;
        int[] r216 = null;
    L59:
        if ((131072 & r413) == 0) goto L61;
        int[] r217 = null;
    L63:
        if ((r413 & 262144) == 0) goto L65;
        LayoutIntrinsics r218 = new LayoutIntrinsics(r210, r212, r102);
    L66:
        this(r210, r211, r212, r100, r101, r102, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217, r218);
        return;
    L65:
        r218 = r412;
        goto L66
    L61:
        r217 = r411;
        goto L63
    L57:
        r216 = r410;
        goto L59
    L53:
        r119 = r319;
        goto L55
    L49:
        r118 = r318;
        goto L51
    L45:
        r117 = r317;
        goto L47
    L41:
        r116 = r316;
        goto L43
    L37:
        r115 = r315;
        goto L39
    L33:
        r114 = r314;
        goto L35
    L29:
        r113 = r313;
        goto L31
    L25:
        r112 = r312;
        goto L27
    L21:
        r111 = r311;
        goto L23
    L17:
        r110 = r310;
        goto L19
    L13:
        r102 = r215;
        goto L15
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
