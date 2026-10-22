package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "didOverflow", "", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public /* synthetic */ AutoSizeStepBased(long r100, long r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.m7743hashCodeimpl(this.minFontSize) * 31) + TextUnit.m7743hashCodeimpl(this.maxFontSize)) * 31) + TextUnit.m7743hashCodeimpl(this.stepSize);
    }

    private final boolean didOverflow(TextLayoutResult r100) {
        int r101 = r100.getLayoutInput().m6965getOverflowgIe3tQ8();
        TextOverflow.Companion r102 = TextOverflow.Companion;
        if (TextOverflow.m7460equalsimpl0(r101, r102.m7469getClipgIe3tQ8()) == true) goto L18;
        if (TextOverflow.m7460equalsimpl0(r101, r102.m7473getVisiblegIe3tQ8()) == true) goto L18;
        if (TextOverflow.m7460equalsimpl0(r101, r102.m7472getStartEllipsisgIe3tQ8()) == true) goto L19;
        if (TextOverflow.m7460equalsimpl0(r101, r102.m7471getMiddleEllipsisgIe3tQ8()) == true) goto L19;
        if (TextOverflow.m7460equalsimpl0(r101, r102.m7470getEllipsisgIe3tQ8()) == true) goto L19;
        throw new IllegalArgumentException("TextOverflow type " + TextOverflow.m7462toStringimpl(r100.getLayoutInput().m6965getOverflowgIe3tQ8()) + " is not supported.");
    L19:
        return didOverflowByEllipsize(r100);
    L18:
        return didOverflowBounds(r100);
    }

    private final boolean didOverflowBounds(TextLayoutResult r100) {
        if (r100.getDidOverflowWidth() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.getDidOverflowHeight() == true) goto L8;
        return false;
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult r100) {
        int r101 = r100.getLineCount();
        if (r101 != 0) goto L5;
        return false;
    L5:
        if (r101 == 1) goto L16;
        int r102 = r100.getLayoutInput().m6965getOverflowgIe3tQ8();
        TextOverflow.Companion r103 = TextOverflow.Companion;
        if (TextOverflow.m7460equalsimpl0(r102, r103.m7472getStartEllipsisgIe3tQ8()) == true) goto L20;
        if (TextOverflow.m7460equalsimpl0(r102, r103.m7471getMiddleEllipsisgIe3tQ8()) == true) goto L20;
        if (TextOverflow.m7460equalsimpl0(r102, r103.m7470getEllipsisgIe3tQ8()) == true) goto L19;
        return false;
    L19:
        return r100.isLineEllipsized(r100.getLineCount() - 1);
    L20:
        return didOverflowBounds(r100);
    L16:
        return r100.isLineEllipsized(0);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof AutoSizeStepBased) == true) goto L11;
        return false;
    L11:
        AutoSizeStepBased r101 = (AutoSizeStepBased) r100;
        if (TextUnit.m7739equalsimpl0(r101.minFontSize, this.minFontSize) == true) goto L15;
        return false;
    L15:
        if (TextUnit.m7739equalsimpl0(r101.maxFontSize, this.maxFontSize) == true) goto L18;
        return false;
    L18:
        if (TextUnit.m7739equalsimpl0(r101.stepSize, this.stepSize) == true) goto L20;
        return false;
    L20:
        return true;
    }

    private AutoSizeStepBased(long r100, long r101, long r102) {
        this.minFontSize = r100;
        this.maxFontSize = r101;
        this.stepSize = r102;
        TextUnit.Companion r103 = TextUnit.Companion;
        if (TextUnit.m7739equalsimpl0(r100, r103.m7753getUnspecifiedXSAIIZE()) == true) goto L34;
        if (TextUnit.m7739equalsimpl0(r101, r103.m7753getUnspecifiedXSAIIZE()) == true) goto L32;
        if (TextUnit.m7739equalsimpl0(r102, r103.m7753getUnspecifiedXSAIIZE()) == true) goto L30;
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(this.minFontSize), TextUnit.m7741getTypeUIouoOA(r101)) == false) goto L14;
        long r104 = this.minFontSize;
        TextUnitKt.m7756checkArithmeticNB67dxo(r104, r101);
        if (Float.compare(TextUnit.m7742getValueimpl(r104), TextUnit.m7742getValueimpl(r101)) <= 0) goto L14;
        this.minFontSize = r101;
    L14:
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r102), TextUnitType.Companion.m7775getSpUIouoOA()) == false) goto L21;
        long r105 = TextUnitKt.getSp(1.0E-4f);
        TextUnitKt.m7756checkArithmeticNB67dxo(r102, r105);
        if (Float.compare(TextUnit.m7742getValueimpl(r102), TextUnit.m7742getValueimpl(r105)) >= 0) goto L21;
        throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
    L21:
        if (TextUnit.m7742getValueimpl(this.minFontSize) < 0.0f) goto L28;
        if (TextUnit.m7742getValueimpl(r101) < 0.0f) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
    L28:
        throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
    L30:
        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
    L32:
        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
    L34:
        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* JADX INFO: renamed from: getFontSize-Ci0_558, reason: not valid java name */
    public long mo1030getFontSizeCi0_558(TextAutoSizeLayoutScope r110, long r111, AnnotatedString r112) {
        float r100 = r110.mo370toPxR2X_6o(this.stepSize);
        float r101 = r110.mo370toPxR2X_6o(this.minFontSize);
        float r113 = r110.mo370toPxR2X_6o(this.maxFontSize);
        float r114 = 2;
        float r115 = (r101 + r113) / r114;
        float r116 = r101;
        float r117 = r113;
    L4:
        if ((r117 - r116) < r100) goto L10;
        if (didOverflow(r110.mo1419performLayout5ZSfY2I(r111, r112, r110.mo374toSpkPz2Gy4(r115))) == false) goto L8;
        r117 = r115;
    L9:
        r115 = (r116 + r117) / r114;
        goto L4
    L8:
        r116 = r115;
        goto L9
    L10:
        float r102 = r101 + (((float) Math.floor((r116 - r101) / r100)) * r100);
        float r103 = r100 + r102;
        if (r103 > r113) goto L16;
        if (didOverflow(r110.mo1419performLayout5ZSfY2I(r111, r112, r110.mo374toSpkPz2Gy4(r103))) == true) goto L16;
        r102 = r103;
    L16:
        return r110.mo374toSpkPz2Gy4(r102);
    }
}
