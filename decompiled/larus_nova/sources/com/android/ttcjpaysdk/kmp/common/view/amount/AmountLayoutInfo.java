package com.android.ttcjpaysdk.kmp.common.view.amount;

import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001Be\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J{\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\rHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001c¨\u00062"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/AmountLayoutInfo;", "", "slots", "", "Lcom/android/ttcjpaysdk/kmp/common/view/amount/AmountSlot;", "digitLayouts", "Landroidx/compose/ui/text/TextLayoutResult;", "digitWidthPx", "", "digitHeightPx", "totalWidthPx", "heightPx", "baselinePx", "", "digitStepPx", "moneySymbolLayout", "moneySymbolWidthPx", "<init>", "(Ljava/util/List;Ljava/util/List;IIIIFFLandroidx/compose/ui/text/TextLayoutResult;F)V", "getSlots", "()Ljava/util/List;", "getDigitLayouts", "getDigitWidthPx", "()I", "getDigitHeightPx", "getTotalWidthPx", "getHeightPx", "getBaselinePx", "()F", "getDigitStepPx", "getMoneySymbolLayout", "()Landroidx/compose/ui/text/TextLayoutResult;", "getMoneySymbolWidthPx", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AmountLayoutInfo {
    private final float baselinePx;
    private final int digitHeightPx;
    private final List<TextLayoutResult> digitLayouts;
    private final float digitStepPx;
    private final int digitWidthPx;
    private final int heightPx;
    private final TextLayoutResult moneySymbolLayout;
    private final float moneySymbolWidthPx;
    private final List<AmountSlot> slots;
    private final int totalWidthPx;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AmountLayoutInfo copy$default(AmountLayoutInfo r110, List r111, List r112, int r113, int r114, int r115, int r116, float r117, float r118, TextLayoutResult r210, float r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        List r100 = r110.slots;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = r110.digitLayouts;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = r110.digitWidthPx;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.digitHeightPx;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.totalWidthPx;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.heightPx;
    L27:
        if ((r212 & 64) == 0) goto L29;
        float r106 = r110.baselinePx;
    L31:
        if ((r212 & 128) == 0) goto L33;
        float r107 = r110.digitStepPx;
    L35:
        if ((r212 & 256) == 0) goto L37;
        TextLayoutResult r119 = r110.moneySymbolLayout;
    L39:
        if ((r212 & 512) == 0) goto L41;
        float r108 = r110.moneySymbolWidthPx;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
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

    public final List<AmountSlot> component1() {
        return this.slots;
    }

    public final float component10() {
        return this.moneySymbolWidthPx;
    }

    public final List<TextLayoutResult> component2() {
        return this.digitLayouts;
    }

    public final int component3() {
        return this.digitWidthPx;
    }

    public final int component4() {
        return this.digitHeightPx;
    }

    public final int component5() {
        return this.totalWidthPx;
    }

    public final int component6() {
        return this.heightPx;
    }

    public final float component7() {
        return this.baselinePx;
    }

    public final float component8() {
        return this.digitStepPx;
    }

    public final TextLayoutResult component9() {
        return this.moneySymbolLayout;
    }

    public final AmountLayoutInfo copy(List<AmountSlot> r110, List<TextLayoutResult> r111, int r112, int r113, int r114, int r115, float r116, float r210, TextLayoutResult r211, float r212) {
        Intrinsics.checkNotNullParameter(r110, "slots");
        Intrinsics.checkNotNullParameter(r111, "digitLayouts");
        return new AmountLayoutInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AmountLayoutInfo) == true) goto L8;
        return false;
    L8:
        AmountLayoutInfo r101 = (AmountLayoutInfo) r100;
        if (Intrinsics.areEqual(this.slots, r101.slots) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.digitLayouts, r101.digitLayouts) == true) goto L15;
        return false;
    L15:
        if (this.digitWidthPx == r101.digitWidthPx) goto L18;
        return false;
    L18:
        if (this.digitHeightPx == r101.digitHeightPx) goto L21;
        return false;
    L21:
        if (this.totalWidthPx == r101.totalWidthPx) goto L24;
        return false;
    L24:
        if (this.heightPx == r101.heightPx) goto L27;
        return false;
    L27:
        if (Float.compare(this.baselinePx, r101.baselinePx) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.digitStepPx, r101.digitStepPx) == 0) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.moneySymbolLayout, r101.moneySymbolLayout) == true) goto L36;
        return false;
    L36:
        if (Float.compare(this.moneySymbolWidthPx, r101.moneySymbolWidthPx) == 0) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((this.slots.hashCode() * 31) + this.digitLayouts.hashCode()) * 31) + this.digitWidthPx) * 31) + this.digitHeightPx) * 31) + this.totalWidthPx) * 31) + this.heightPx) * 31) + Float.floatToIntBits(this.baselinePx)) * 31) + Float.floatToIntBits(this.digitStepPx)) * 31;
        TextLayoutResult r101 = this.moneySymbolLayout;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + Float.floatToIntBits(this.moneySymbolWidthPx);
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AmountLayoutInfo(slots=" + this.slots + ", digitLayouts=" + this.digitLayouts + ", digitWidthPx=" + this.digitWidthPx + ", digitHeightPx=" + this.digitHeightPx + ", totalWidthPx=" + this.totalWidthPx + ", heightPx=" + this.heightPx + ", baselinePx=" + this.baselinePx + ", digitStepPx=" + this.digitStepPx + ", moneySymbolLayout=" + this.moneySymbolLayout + ", moneySymbolWidthPx=" + this.moneySymbolWidthPx + ')';
    }

    public final float getBaselinePx() {
        return this.baselinePx;
    }

    public final int getDigitHeightPx() {
        return this.digitHeightPx;
    }

    public final List<TextLayoutResult> getDigitLayouts() {
        return this.digitLayouts;
    }

    public final float getDigitStepPx() {
        return this.digitStepPx;
    }

    public final int getDigitWidthPx() {
        return this.digitWidthPx;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final TextLayoutResult getMoneySymbolLayout() {
        return this.moneySymbolLayout;
    }

    public final float getMoneySymbolWidthPx() {
        return this.moneySymbolWidthPx;
    }

    public final List<AmountSlot> getSlots() {
        return this.slots;
    }

    public final int getTotalWidthPx() {
        return this.totalWidthPx;
    }

    public AmountLayoutInfo(List<AmountSlot> r100, List<TextLayoutResult> r101, int r102, int r103, int r104, int r105, float r106, float r107, TextLayoutResult r110, float r111) {
        Intrinsics.checkNotNullParameter(r100, "slots");
        Intrinsics.checkNotNullParameter(r101, "digitLayouts");
        this.slots = r100;
        this.digitLayouts = r101;
        this.digitWidthPx = r102;
        this.digitHeightPx = r103;
        this.totalWidthPx = r104;
        this.heightPx = r105;
        this.baselinePx = r106;
        this.digitStepPx = r107;
        this.moneySymbolLayout = r110;
        this.moneySymbolWidthPx = r111;
    }
}
