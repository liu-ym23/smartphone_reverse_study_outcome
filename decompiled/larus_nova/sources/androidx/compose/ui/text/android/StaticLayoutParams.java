package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\"\b\u0002\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0018\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u00107R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>¨\u0006@"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutParams;", "", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "<init>", "(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;Landroid/text/Layout$Alignment;ILandroid/text/TextUtils$TruncateAt;IFFIZZIIII[I[I)V", "getText", "()Ljava/lang/CharSequence;", "getStart", "()I", "getEnd", "getPaint", "()Landroid/text/TextPaint;", "getWidth", "getTextDir", "()Landroid/text/TextDirectionHeuristic;", "getAlignment", "()Landroid/text/Layout$Alignment;", "getMaxLines", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getEllipsizedWidth", "getLineSpacingMultiplier", "()F", "getLineSpacingExtra", "getJustificationMode", "getIncludePadding", "()Z", "getUseFallbackLineSpacing", "getBreakStrategy", "getLineBreakStyle", "getLineBreakWordStyle", "getHyphenationFrequency", "getLeftIndents", "()[I", "getRightIndents", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StaticLayoutParams {
    private final Layout.Alignment alignment;
    private final int breakStrategy;
    private final TextUtils.TruncateAt ellipsize;
    private final int ellipsizedWidth;
    private final int end;
    private final int hyphenationFrequency;
    private final boolean includePadding;
    private final int justificationMode;
    private final int[] leftIndents;
    private final int lineBreakStyle;
    private final int lineBreakWordStyle;
    private final float lineSpacingExtra;
    private final float lineSpacingMultiplier;
    private final int maxLines;
    private final TextPaint paint;
    private final int[] rightIndents;
    private final int start;
    private final CharSequence text;
    private final TextDirectionHeuristic textDir;
    private final boolean useFallbackLineSpacing;
    private final int width;

    public final Layout.Alignment getAlignment() {
        return this.alignment;
    }

    public final int getBreakStrategy() {
        return this.breakStrategy;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final int getEllipsizedWidth() {
        return this.ellipsizedWidth;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    public final int[] getLeftIndents() {
        return this.leftIndents;
    }

    public final int getLineBreakStyle() {
        return this.lineBreakStyle;
    }

    public final int getLineBreakWordStyle() {
        return this.lineBreakWordStyle;
    }

    public final float getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public final float getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final TextPaint getPaint() {
        return this.paint;
    }

    public final int[] getRightIndents() {
        return this.rightIndents;
    }

    public final int getStart() {
        return this.start;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final TextDirectionHeuristic getTextDir() {
        return this.textDir;
    }

    public final boolean getUseFallbackLineSpacing() {
        return this.useFallbackLineSpacing;
    }

    public final int getWidth() {
        return this.width;
    }

    public StaticLayoutParams(CharSequence r110, int r111, int r112, TextPaint r113, int r114, TextDirectionHeuristic r115, Layout.Alignment r116, int r117, TextUtils.TruncateAt r118, int r210, float r211, float r212, int r213, boolean r214, boolean r215, int r216, int r217, int r218, int r219, int[] r310, int[] r311) {
        this.text = r110;
        this.start = r111;
        this.end = r112;
        this.paint = r113;
        this.width = r114;
        this.textDir = r115;
        this.alignment = r116;
        this.maxLines = r117;
        this.ellipsize = r118;
        this.ellipsizedWidth = r210;
        this.lineSpacingMultiplier = r211;
        this.lineSpacingExtra = r212;
        this.justificationMode = r213;
        this.includePadding = r214;
        this.useFallbackLineSpacing = r215;
        this.breakStrategy = r216;
        this.lineBreakStyle = r217;
        this.lineBreakWordStyle = r218;
        this.hyphenationFrequency = r219;
        this.leftIndents = r310;
        this.rightIndents = r311;
        boolean r100 = true;
        if (r111 < 0) goto L6;
        if (r111 > r112) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("invalid start value");
    L9:
        int r102 = r110.length();
        if (r112 < 0) goto L13;
        if (r112 > r102) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
        InlineClassHelperKt.throwIllegalArgumentException("invalid end value");
    L16:
        if (r117 < 0) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L21;
        InlineClassHelperKt.throwIllegalArgumentException("invalid maxLines value");
    L21:
        if (r114 < 0) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == true) goto L26;
        InlineClassHelperKt.throwIllegalArgumentException("invalid width value");
    L26:
        if (r210 < 0) goto L28;
        boolean r106 = true;
    L29:
        if (r106 == true) goto L32;
        InlineClassHelperKt.throwIllegalArgumentException("invalid ellipsizedWidth value");
    L32:
        if (r211 >= 0.0f) goto L35;
        r100 = false;
    L35:
        if (r100 == true) goto L38;
        InlineClassHelperKt.throwIllegalArgumentException("invalid lineSpacingMultiplier value");
        return;
    L38:
        return;
    L28:
        r106 = false;
        goto L29
    L23:
        r105 = false;
        goto L24
    L18:
        r104 = false;
    L13:
        r103 = false;
    L6:
        r101 = false;
        goto L7
    }

    public /* synthetic */ StaticLayoutParams(CharSequence r210, int r211, int r212, TextPaint r213, int r214, TextDirectionHeuristic r215, Layout.Alignment r310, int r311, TextUtils.TruncateAt r312, int r313, float r314, float r315, int r316, boolean r317, boolean r318, int r319, int r410, int r411, int r412, int[] r413, int[] r414, int r415, DefaultConstructorMarker r416) {
        if ((r415 & 2) == 0) goto L5;
        int r100 = 0;
    L6:
        this(r210, r100, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
        return;
    L5:
        r100 = r211;
        goto L6
    }
}
