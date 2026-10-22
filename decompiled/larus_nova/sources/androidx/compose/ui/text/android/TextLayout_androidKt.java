package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\f*\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0015\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0002\u0010\u0018\u001a3\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001f\u001a\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016*\u00020\u0011H\u0002¢\u0006\u0002\u0010!\u001a\u0014\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020\nH\u0000\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0010\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006&"}, d2 = {"SharedTextAndroidCanvas", "Ljava/lang/ThreadLocal;", "Landroidx/compose/ui/text/android/TextAndroidCanvas;", "getSharedTextAndroidCanvas$annotations", "()V", "getSharedTextAndroidCanvas", "()Ljava/lang/ThreadLocal;", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "", "VerticalPaddings", "Landroidx/compose/ui/text/android/VerticalPaddings;", "topPadding", "bottomPadding", "(II)J", "getVerticalPaddings", "Landroidx/compose/ui/text/android/TextLayout;", "(Landroidx/compose/ui/text/android/TextLayout;)J", "ZeroVerticalPadding", "J", "getLineHeightPaddings", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "([Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)J", "getLastLineMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "textPaint", "Landroid/text/TextPaint;", "frameworkTextDir", "lineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Landroid/graphics/Paint$FontMetricsInt;", "getLineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "isLineEllipsized", "", "Landroid/text/Layout;", "lineIndex", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayout_androidKt {
    private static final ThreadLocal<TextAndroidCanvas> SharedTextAndroidCanvas = null;
    private static final long ZeroVerticalPadding = 0;

    public static /* synthetic */ void getSharedTextAndroidCanvas$annotations() {
    }

    static {
        SharedTextAndroidCanvas = new ThreadLocal();
        ZeroVerticalPadding = VerticalPaddings(0, 0);
    }

    public static final /* synthetic */ long access$getZeroVerticalPadding$p() {
        return ZeroVerticalPadding;
    }

    public static final ThreadLocal<TextAndroidCanvas> getSharedTextAndroidCanvas() {
        return SharedTextAndroidCanvas;
    }

    public static final /* synthetic */ long access$getLineHeightPaddings(LineHeightStyleSpan[] r100) {
        return getLineHeightPaddings(r100);
    }

    public static final /* synthetic */ LineHeightStyleSpan[] access$getLineHeightSpans(TextLayout r100) {
        return getLineHeightSpans(r100);
    }

    public static final /* synthetic */ long access$getVerticalPaddings(TextLayout r100) {
        return getVerticalPaddings(r100);
    }

    private static final long getLineHeightPaddings(LineHeightStyleSpan[] r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r102 >= r101) goto L11;
        LineHeightStyleSpan r105 = r100[r102];
        if (r105.getFirstAscentDiff() >= 0) goto L8;
        r103 = Math.max(r103, Math.abs(r105.getFirstAscentDiff()));
    L8:
        if (r105.getLastDescentDiff() >= 0) goto L10;
        r104 = Math.max(r103, Math.abs(r105.getLastDescentDiff()));
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        if (r103 != 0) goto L15;
        if (r104 != 0) goto L15;
        return ZeroVerticalPadding;
    L15:
        return VerticalPaddings(r103, r104);
    }

    private static final LineHeightStyleSpan[] getLineHeightSpans(TextLayout r100) {
        if ((r100.getText() instanceof Spanned) == true) goto L5;
        return null;
    L5:
        CharSequence r101 = r100.getText();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.text.Spanned");
        if (SpannedExtensions_androidKt.hasSpan((Spanned) r101, LineHeightStyleSpan.class) == false) goto L8;
    L13:
        CharSequence r102 = r100.getText();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.text.Spanned");
        return (LineHeightStyleSpan[]) ((Spanned) r102).getSpans(0, r100.getText().length(), LineHeightStyleSpan.class);
    L8:
        if (r100.getText().length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return null;
    L10:
        r103 = false;
        goto L11
    }

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int r100) {
        if (r100 == 0) goto L20;
        if (r100 == 1) goto L26;
        if (r100 == 2) goto L25;
        if (r100 == 3) goto L24;
        if (r100 == 4) goto L23;
        if (r100 == 5) goto L22;
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L22:
        return TextDirectionHeuristics.LOCALE;
    L23:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L24:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L25:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L26:
        return TextDirectionHeuristics.RTL;
    L20:
        return TextDirectionHeuristics.LTR;
    }

    private static final long getVerticalPaddings(TextLayout r100) {
        if (r100.getIncludePadding() == true) goto L25;
        if (r100.isFallbackLinespacingApplied$ui_text() == true) goto L25;
        TextPaint r101 = r100.getLayout().getPaint();
        CharSequence r102 = r100.getLayout().getText();
        Rect r103 = PaintExtensions_androidKt.getCharSequenceBounds(r101, r102, r100.getLayout().getLineStart(0), r100.getLayout().getLineEnd(0));
        int r104 = r100.getLayout().getLineAscent(0);
        int r105 = r103.top;
        if (r105 >= r104) goto L10;
        int r106 = r104 - r105;
    L12:
        if (r100.getLineCount() == 1) goto L15;
        int r107 = r100.getLineCount() - 1;
        r103 = PaintExtensions_androidKt.getCharSequenceBounds(r101, r102, r100.getLayout().getLineStart(r107), r100.getLayout().getLineEnd(r107));
    L15:
        int r108 = r100.getLayout().getLineDescent(r100.getLineCount() - 1);
        int r109 = r103.bottom;
        if (r109 <= r108) goto L18;
        int r110 = r109 - r108;
    L19:
        if (r106 != 0) goto L23;
        if (r110 != 0) goto L23;
        return ZeroVerticalPadding;
    L23:
        return VerticalPaddings(r106, r110);
    L18:
        r110 = r100.getLayout().getBottomPadding();
        goto L19
    L10:
        r106 = r100.getLayout().getTopPadding();
    L25:
        return ZeroVerticalPadding;
    }

    public static final long VerticalPaddings(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return VerticalPaddings.m7046constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102);
    }

    public static final boolean isLineEllipsized(Layout r100, int r101) {
        if (r100.getEllipsisCount(r101) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ Paint.FontMetricsInt access$getLastLineMetrics(TextLayout r100, TextPaint r101, TextDirectionHeuristic r102, LineHeightStyleSpan[] r103) {
        return getLastLineMetrics(r100, r101, r102, r103);
    }

    private static final Paint.FontMetricsInt getLastLineMetrics(TextLayout r210, TextPaint r211, TextDirectionHeuristic r310, LineHeightStyleSpan[] r311) {
        boolean r100 = true;
        int r101 = r210.getLineCount() - 1;
        if (r210.getLayout().getLineStart(r101) == r210.getLayout().getLineEnd(r101)) goto L5;
        return null;
    L5:
        if (r311 != null) goto L7;
    L13:
        if (r100 == true) goto L24;
        SpannableString r102 = new SpannableString("\u200b");
        LineHeightStyleSpan r103 = (LineHeightStyleSpan) ArraysKt.first(r311);
        int r104 = r102.length();
        if (r101 != 0) goto L17;
    L19:
        boolean r105 = r103.getTrimLastLineBottom();
    L20:
        r102.setSpan(r103.copy$ui_text(0, r104, r105), 0, r102.length(), 33);
        StaticLayout r106 = StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, r102, r211, Integer.MAX_VALUE, 0, r102.length(), r310, null, 0, null, 0, 0.0f, 0.0f, 0, r210.getIncludePadding(), r210.getFallbackLineSpacing(), 0, 0, 0, 0, null, null, 2072512, null);
        Paint.FontMetricsInt r107 = new Paint.FontMetricsInt();
        r107.ascent = r106.getLineAscent(0);
        r107.descent = r106.getLineDescent(0);
        r107.top = r106.getLineTop(0);
        r107.bottom = r106.getLineBottom(0);
        return r107;
    L17:
        if (r103.getTrimLastLineBottom() == false) goto L19;
        r105 = false;
        goto L20
    L24:
        return null;
    L7:
        if (r311.length != 0) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == true) goto L13;
        r100 = false;
        goto L13
    L9:
        r108 = false;
        goto L10
    }
}
