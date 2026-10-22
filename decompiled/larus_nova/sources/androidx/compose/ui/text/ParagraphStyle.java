package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015Bs\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0016B7\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0017BO\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0018Bg\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0019J\u0014\u0010<\u001a\u00020\u00002\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0000H\u0087\u0002J=\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b@\u0010AJU\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\bB\u0010CJm\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\bD\u0010EJy\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\bF\u0010GJo\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00020K2\b\u0010=\u001a\u0004\u0018\u00010LH\u0096\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020PH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u0010\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b(\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u00038GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010-\u001a\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\u00118GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010-\u001a\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\u000f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010-\u001a\u0004\b:\u0010;¨\u0006Q"}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "<init>", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextAlign-e0LSkKk", "()I", "I", "getTextDirection-s_7X-co", "getLineHeight-XSAIIZE", "()J", "J", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLineBreak-rAG3T2k", "getHyphens-vmbZdU8", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "()V", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "merge", "other", "plus", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ciSxzs0", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-NH1kkwU", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ykzQM6k", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParagraphStyle implements AnnotatedString.Annotation {
    public static final int $stable = 0;
    private final int hyphens;
    private final int lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final int textAlign;
    private final int textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    public /* synthetic */ ParagraphStyle(int r100, int r101, long r102, TextIndent r103, PlatformParagraphStyle r104, LineHeightStyle r105, int r106, int r107, TextMotion r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    public /* synthetic */ ParagraphStyle(TextAlign r100, TextDirection r101, long r102, TextIndent r103, PlatformParagraphStyle r104, LineHeightStyle r105, LineBreak r106, Hyphens r107, TextMotion r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign r100, TextDirection r101, long r102, TextIndent r103, PlatformParagraphStyle r104, LineHeightStyle r105, LineBreak r106, Hyphens r107, DefaultConstructorMarker r110) {
        this(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructors.")
    public /* synthetic */ ParagraphStyle(TextAlign r100, TextDirection r101, long r102, TextIndent r103, PlatformParagraphStyle r104, LineHeightStyle r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.")
    public /* synthetic */ ParagraphStyle(TextAlign r100, TextDirection r101, long r102, TextIndent r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getHyphens-EaSxIns$annotations, reason: not valid java name */
    public static /* synthetic */ void m6888getHyphensEaSxIns$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getLineBreak-LgCVezo$annotations, reason: not valid java name */
    public static /* synthetic */ void m6889getLineBreakLgCVezo$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getTextAlign-buA522U$annotations, reason: not valid java name */
    public static /* synthetic */ void m6890getTextAlignbuA522U$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Kept for backwards compatibility.")
    /* JADX INFO: renamed from: getTextDirection-mmuk1to$annotations, reason: not valid java name */
    public static /* synthetic */ void m6891getTextDirectionmmuk1to$annotations() {
    }

    /* JADX INFO: renamed from: getHyphens-EaSxIns, reason: not valid java name */
    public final Hyphens m6897getHyphensEaSxIns() {
        return Hyphens.m7309boximpl(this.hyphens);
    }

    /* JADX INFO: renamed from: getLineBreak-LgCVezo, reason: not valid java name */
    public final LineBreak m6899getLineBreakLgCVezo() {
        return LineBreak.m7319boximpl(this.lineBreak);
    }

    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m6902getTextAlignbuA522U() {
        return TextAlign.m7411boximpl(this.textAlign);
    }

    /* JADX INFO: renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m6904getTextDirectionmmuk1to() {
        return TextDirection.m7425boximpl(this.textDirection);
    }

    public int hashCode() {
        int r100 = ((((TextAlign.m7415hashCodeimpl(this.textAlign) * 31) + TextDirection.m7429hashCodeimpl(this.textDirection)) * 31) + TextUnit.m7743hashCodeimpl(this.lineHeight)) * 31;
        TextIndent r101 = this.textIndent;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        PlatformParagraphStyle r105 = this.platformStyle;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        LineHeightStyle r108 = this.lineHeightStyle;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((((r107 + r109) * 31) + LineBreak.m7329hashCodeimpl(this.lineBreak)) * 31) + Hyphens.m7313hashCodeimpl(this.hyphens)) * 31;
        TextMotion r111 = this.textMotion;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + TextAlign.m7416toStringimpl(this.textAlign) + ", textDirection=" + TextDirection.m7430toStringimpl(this.textDirection) + ", lineHeight=" + TextUnit.m7749toStringimpl(this.lineHeight) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + LineBreak.m7330toStringimpl(this.lineBreak) + ", hyphens=" + Hyphens.m7314toStringimpl(this.hyphens) + ", textMotion=" + this.textMotion + ')';
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m6898getHyphensvmbZdU8() {
        return this.hyphens;
    }

    /* JADX INFO: renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m6900getLineBreakrAG3T2k() {
        return this.lineBreak;
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m6901getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m6903getTextAligne0LSkKk() {
        return this.textAlign;
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m6905getTextDirections_7Xco() {
        return this.textDirection;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ParagraphStyle) == true) goto L8;
        return false;
    L8:
        ParagraphStyle r101 = (ParagraphStyle) r100;
        if (TextAlign.m7414equalsimpl0(this.textAlign, r101.textAlign) == true) goto L12;
        return false;
    L12:
        if (TextDirection.m7428equalsimpl0(this.textDirection, r101.textDirection) == true) goto L15;
        return false;
    L15:
        if (TextUnit.m7739equalsimpl0(this.lineHeight, r101.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textIndent, r101.textIndent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.platformStyle, r101.platformStyle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lineHeightStyle, r101.lineHeightStyle) == true) goto L27;
        return false;
    L27:
        if (LineBreak.m7325equalsimpl0(this.lineBreak, r101.lineBreak) == true) goto L30;
        return false;
    L30:
        if (Hyphens.m7312equalsimpl0(this.hyphens, r101.hyphens) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.textMotion, r101.textMotion) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final ParagraphStyle merge(ParagraphStyle r110) {
        if (r110 != null) goto L5;
        return this;
    L5:
        return ParagraphStyleKt.m6906fastMergej5T8yCg(this, r110.textAlign, r110.textDirection, r110.lineHeight, r110.textIndent, r110.platformStyle, r110.lineHeightStyle, r110.lineBreak, r110.hyphens, r110.textMotion);
    }

    public final ParagraphStyle plus(ParagraphStyle r100) {
        return merge(r100);
    }

    private ParagraphStyle(TextAlign r110, TextDirection r111, long r112, TextIndent r113) {
        if (r110 == null) goto L4;
        int r100 = r110.m7417unboximpl();
    L5:
        int r101 = r100;
        if (r111 == null) goto L8;
        int r102 = r111.m7431unboximpl();
    L9:
        this(r101, r102, r112, r113, null, null, LineBreak.Companion.m7339getUnspecifiedrAG3T2k(), Hyphens.Companion.m7318getUnspecifiedvmbZdU8(), null, null);
        return;
    L8:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L9
    L4:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L5
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle r100, ParagraphStyle r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.merge(r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-Elsmlbk, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6892copyElsmlbk(TextAlign r110, TextDirection r111, long r112, TextIndent r113) {
        if (r110 == null) goto L5;
        int r100 = r110.m7417unboximpl();
    L6:
        int r101 = r100;
        if (r111 == null) goto L9;
        int r102 = r111.m7431unboximpl();
    L11:
        return new ParagraphStyle(r101, r102, r112, r113, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, null);
    L9:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L11
    L5:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L6
    }

    private ParagraphStyle(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r210) {
        if (r110 == null) goto L4;
        int r100 = r110.m7417unboximpl();
    L5:
        int r101 = r100;
        if (r111 == null) goto L8;
        int r102 = r111.m7431unboximpl();
    L9:
        this(r101, r102, r112, r113, r114, r210, LineBreak.Companion.m7339getUnspecifiedrAG3T2k(), Hyphens.Companion.m7318getUnspecifiedvmbZdU8(), null, null);
        return;
    L8:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L9
    L4:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L5
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-xPh5V4g, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6895copyxPh5V4g(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r210, LineHeightStyle r211) {
        if (r110 == null) goto L5;
        int r100 = r110.m7417unboximpl();
    L6:
        int r101 = r100;
        if (r111 == null) goto L9;
        int r102 = r111.m7431unboximpl();
    L11:
        return new ParagraphStyle(r101, r102, r112, r113, r210, r211, this.lineBreak, this.hyphens, this.textMotion, null);
    L9:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L11
    L5:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L6
    }

    public /* synthetic */ ParagraphStyle(TextAlign r100, TextDirection r110, long r111, TextIndent r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        TextAlign r101 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        TextDirection r102 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r111 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L13:
        long r103 = r111;
        if ((r113 & 8) == 0) goto L16;
        TextIndent r104 = null;
    L17:
        this(r101, r102, r103, r104, null);
        return;
    L16:
        r104 = r112;
        goto L17
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    /* JADX INFO: renamed from: copy-Elsmlbk$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6883copyElsmlbk$default(ParagraphStyle r100, TextAlign r101, TextDirection r102, long r103, TextIndent r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = TextAlign.m7411boximpl(r100.textAlign);
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = TextDirection.m7425boximpl(r100.textDirection);
    L8:
        TextDirection r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.lineHeight;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.textIndent;
    L14:
        TextAlign r107 = r101;
        return r100.m6892copyElsmlbk(r107, r111, r106, r104);
    }

    private ParagraphStyle(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r210, LineBreak r211, Hyphens r212) {
        if (r110 == null) goto L4;
        int r100 = r110.m7417unboximpl();
    L5:
        int r101 = r100;
        if (r111 == null) goto L8;
        int r102 = r111.m7431unboximpl();
    L9:
        int r103 = r102;
        if (r211 == null) goto L12;
        int r104 = r211.m7331unboximpl();
    L13:
        int r105 = r104;
        if (r212 == null) goto L16;
        int r106 = r212.m7315unboximpl();
    L17:
        this(r101, r103, r112, r113, r114, r210, r105, r106, null, null);
        return;
    L16:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L17
    L12:
        r104 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L13
    L8:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L9
    L4:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L5
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable copy constructor.")
    /* JADX INFO: renamed from: copy-ciSxzs0, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6894copyciSxzs0(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r210, LineHeightStyle r211, LineBreak r212, Hyphens r213) {
        if (r110 == null) goto L5;
        int r100 = r110.m7417unboximpl();
    L6:
        int r101 = r100;
        if (r111 == null) goto L9;
        int r102 = r111.m7431unboximpl();
    L10:
        int r103 = r102;
        if (r212 == null) goto L13;
        int r104 = r212.m7331unboximpl();
    L14:
        int r105 = r104;
        if (r213 == null) goto L17;
        int r106 = r213.m7315unboximpl();
    L19:
        return new ParagraphStyle(r101, r103, r112, r113, r210, r211, r105, r106, this.textMotion, null);
    L17:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L19
    L13:
        r104 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L14
    L9:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L10
    L5:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L6
    }

    public /* synthetic */ ParagraphStyle(TextAlign r100, TextDirection r110, long r111, TextIndent r112, PlatformParagraphStyle r113, LineHeightStyle r114, int r115, DefaultConstructorMarker r116) {
        LineHeightStyle r101 = null;
        if ((r115 & 1) == 0) goto L5;
        TextAlign r102 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        TextDirection r103 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        long r104 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L15:
        if ((r115 & 8) == 0) goto L17;
        TextIndent r105 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        PlatformParagraphStyle r106 = null;
    L23:
        if ((r115 & 32) != 0) goto L26;
        r101 = r114;
    L26:
        this(r102, r103, r104, r105, r106, r101, null);
        return;
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }

    private ParagraphStyle(int r100, int r101, long r102, TextIndent r103, PlatformParagraphStyle r104, LineHeightStyle r105, int r106, int r107, TextMotion r110) {
        this.textAlign = r100;
        this.textDirection = r101;
        this.lineHeight = r102;
        this.textIndent = r103;
        this.platformStyle = r104;
        this.lineHeightStyle = r105;
        this.lineBreak = r106;
        this.hyphens = r107;
        this.textMotion = r110;
        if (TextUnit.m7739equalsimpl0(r102, TextUnit.Companion.m7753getUnspecifiedXSAIIZE()) == false) goto L5;
        return;
    L5:
        if (TextUnit.m7742getValueimpl(r102) < 0.0f) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L12;
        InlineClassHelperKt.throwIllegalStateException("lineHeight can't be negative (" + TextUnit.m7742getValueimpl(r102) + ')');
        return;
    L12:
        return;
    L7:
        r108 = false;
        goto L8
    }

    /* JADX INFO: renamed from: copy-xPh5V4g$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6886copyxPh5V4g$default(ParagraphStyle r100, TextAlign r101, TextDirection r102, long r103, TextIndent r110, PlatformParagraphStyle r111, LineHeightStyle r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = TextAlign.m7411boximpl(r100.textAlign);
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = TextDirection.m7425boximpl(r100.textDirection);
    L8:
        TextDirection r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.lineHeight;
    L11:
        long r104 = r103;
        if ((r113 & 8) == 0) goto L14;
        r110 = r100.textIndent;
    L14:
        TextIndent r105 = r110;
        if ((r113 & 16) == 0) goto L17;
        r111 = r100.platformStyle;
    L17:
        PlatformParagraphStyle r106 = r111;
        if ((r113 & 32) == 0) goto L20;
        r112 = r100.lineHeightStyle;
    L20:
        TextAlign r107 = r101;
        return r100.m6895copyxPh5V4g(r107, r115, r104, r105, r106, r112);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "ParagraphStyle copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.")
    /* JADX INFO: renamed from: copy-NH1kkwU, reason: not valid java name */
    public final /* synthetic */ ParagraphStyle m6893copyNH1kkwU(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r210, LineBreak r211, Hyphens r212, TextMotion r213) {
        if (r110 == null) goto L5;
        int r100 = r110.m7417unboximpl();
    L6:
        int r101 = r100;
        if (r111 == null) goto L9;
        int r102 = r111.m7431unboximpl();
    L10:
        int r103 = r102;
        if (r211 == null) goto L13;
        int r104 = r211.m7331unboximpl();
    L14:
        int r105 = r104;
        if (r212 == null) goto L17;
        int r106 = r212.m7315unboximpl();
    L19:
        return new ParagraphStyle(r101, r103, r112, r113, r114, r210, r105, r106, r213, null);
    L17:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L19
    L13:
        r104 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L14
    L9:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L10
    L5:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L6
    }

    /* JADX INFO: renamed from: copy-ykzQM6k, reason: not valid java name */
    public final ParagraphStyle m6896copyykzQM6k(int r110, int r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r210, int r211, int r212, TextMotion r213) {
        return new ParagraphStyle(r110, r111, r112, r113, r114, r210, r211, r212, r213, null);
    }

    private ParagraphStyle(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r210, LineBreak r211, Hyphens r212, TextMotion r213) {
        if (r110 == null) goto L4;
        int r100 = r110.m7417unboximpl();
    L5:
        int r101 = r100;
        if (r111 == null) goto L8;
        int r102 = r111.m7431unboximpl();
    L9:
        int r103 = r102;
        if (r211 == null) goto L12;
        int r104 = r211.m7331unboximpl();
    L13:
        int r105 = r104;
        if (r212 == null) goto L16;
        int r106 = r212.m7315unboximpl();
    L17:
        this(r101, r103, r112, r113, r114, r210, r105, r106, r213, null);
        return;
    L16:
        r106 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
        goto L17
    L12:
        r104 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
        goto L13
    L8:
        r102 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
        goto L9
    L4:
        r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
        goto L5
    }

    public /* synthetic */ ParagraphStyle(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r115, LineBreak r116, Hyphens r117, int r210, DefaultConstructorMarker r211) {
        Hyphens r100 = null;
        if ((r210 & 1) == 0) goto L5;
        TextAlign r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        TextDirection r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r103 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L15:
        if ((r210 & 8) == 0) goto L17;
        TextIndent r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        PlatformParagraphStyle r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        LineHeightStyle r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        LineBreak r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100, null);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public /* synthetic */ ParagraphStyle(int r110, int r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r115, int r116, int r210, TextMotion r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = TextAlign.Companion.m7424getUnspecifiede0LSkKk();
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = TextDirection.Companion.m7437getUnspecifieds_7Xco();
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L14:
        TextMotion r103 = null;
        if ((r212 & 8) == 0) goto L17;
        TextIndent r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        PlatformParagraphStyle r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        LineHeightStyle r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r107 = LineBreak.Companion.m7339getUnspecifiedrAG3T2k();
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r117 = Hyphens.Companion.m7318getUnspecifiedvmbZdU8();
    L35:
        if ((r212 & 256) != 0) goto L38;
        r103 = r211;
    L38:
        this(r100, r101, r102, r104, r105, r106, r107, r117, r103, null);
        return;
    L33:
        r117 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX INFO: renamed from: copy-ciSxzs0$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6885copyciSxzs0$default(ParagraphStyle r110, TextAlign r111, TextDirection r112, long r113, TextIndent r114, PlatformParagraphStyle r115, LineHeightStyle r116, LineBreak r117, Hyphens r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        TextAlign r100 = TextAlign.m7411boximpl(r110.textAlign);
    L7:
        if ((r210 & 2) == 0) goto L9;
        TextDirection r101 = TextDirection.m7425boximpl(r110.textDirection);
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.lineHeight;
    L15:
        if ((r210 & 8) == 0) goto L17;
        TextIndent r103 = r110.textIndent;
    L19:
        if ((r210 & 16) == 0) goto L21;
        PlatformParagraphStyle r104 = r110.platformStyle;
    L23:
        if ((r210 & 32) == 0) goto L25;
        LineHeightStyle r105 = r110.lineHeightStyle;
    L27:
        if ((r210 & 64) == 0) goto L29;
        LineBreak r106 = LineBreak.m7319boximpl(r110.lineBreak);
    L31:
        if ((r210 & 128) == 0) goto L33;
        Hyphens r107 = Hyphens.m7309boximpl(r110.hyphens);
    L35:
        return r110.m6894copyciSxzs0(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ ParagraphStyle(TextAlign r110, TextDirection r111, long r112, TextIndent r113, PlatformParagraphStyle r114, LineHeightStyle r115, LineBreak r116, Hyphens r210, TextMotion r211, int r212, DefaultConstructorMarker r213) {
        TextMotion r100 = null;
        if ((r212 & 1) == 0) goto L5;
        TextAlign r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        TextDirection r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r103 = TextUnit.Companion.m7753getUnspecifiedXSAIIZE();
    L15:
        if ((r212 & 8) == 0) goto L17;
        TextIndent r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        PlatformParagraphStyle r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        LineHeightStyle r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        LineBreak r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Hyphens r117 = null;
    L35:
        if ((r212 & 256) != 0) goto L38;
        r100 = r211;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r117, r100, null);
        return;
    L33:
        r117 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    /* JADX INFO: renamed from: copy-NH1kkwU$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6884copyNH1kkwU$default(ParagraphStyle r110, TextAlign r111, TextDirection r112, long r113, TextIndent r114, PlatformParagraphStyle r115, LineHeightStyle r116, LineBreak r117, Hyphens r210, TextMotion r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        TextAlign r100 = TextAlign.m7411boximpl(r110.textAlign);
    L7:
        if ((r212 & 2) == 0) goto L9;
        TextDirection r101 = TextDirection.m7425boximpl(r110.textDirection);
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.lineHeight;
    L15:
        if ((r212 & 8) == 0) goto L17;
        TextIndent r103 = r110.textIndent;
    L19:
        if ((r212 & 16) == 0) goto L21;
        PlatformParagraphStyle r104 = r110.platformStyle;
    L23:
        if ((r212 & 32) == 0) goto L25;
        LineHeightStyle r105 = r110.lineHeightStyle;
    L27:
        if ((r212 & 64) == 0) goto L29;
        LineBreak r106 = LineBreak.m7319boximpl(r110.lineBreak);
    L31:
        if ((r212 & 128) == 0) goto L33;
        Hyphens r118 = Hyphens.m7309boximpl(r110.hyphens);
    L35:
        if ((r212 & 256) == 0) goto L37;
        TextMotion r107 = r110.textMotion;
    L39:
        return r110.m6893copyNH1kkwU(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-ykzQM6k$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m6887copyykzQM6k$default(ParagraphStyle r110, int r111, int r112, long r113, TextIndent r114, PlatformParagraphStyle r115, LineHeightStyle r116, int r117, int r210, TextMotion r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.textAlign;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.textDirection;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.lineHeight;
    L15:
        if ((r212 & 8) == 0) goto L17;
        TextIndent r103 = r110.textIndent;
    L19:
        if ((r212 & 16) == 0) goto L21;
        PlatformParagraphStyle r104 = r110.platformStyle;
    L23:
        if ((r212 & 32) == 0) goto L25;
        LineHeightStyle r105 = r110.lineHeightStyle;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.lineBreak;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r118 = r110.hyphens;
    L35:
        if ((r212 & 256) == 0) goto L37;
        TextMotion r107 = r110.textMotion;
    L39:
        return r110.m6896copyykzQM6k(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
