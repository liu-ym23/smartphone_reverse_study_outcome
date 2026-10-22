package com.android.ttcjpaysdk.kmp.common.view.amount;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/amount/AmountSlot;", "", "char", "", "isDigit", "", "digitIndex", "", "widthPx", "positionIndex", "staticLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(CZLjava/lang/Integer;IILandroidx/compose/ui/text/TextLayoutResult;)V", "getChar", "()C", "()Z", "getDigitIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidthPx", "()I", "getPositionIndex", "getStaticLayout", "()Landroidx/compose/ui/text/TextLayoutResult;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(CZLjava/lang/Integer;IILandroidx/compose/ui/text/TextLayoutResult;)Lcom/android/ttcjpaysdk/kmp/common/view/amount/AmountSlot;", "equals", "other", "hashCode", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AmountSlot {

    /* JADX INFO: renamed from: char, reason: not valid java name */
    private final char f53char;
    private final Integer digitIndex;
    private final boolean isDigit;
    private final int positionIndex;
    private final TextLayoutResult staticLayout;
    private final int widthPx;

    public static /* synthetic */ AmountSlot copy$default(AmountSlot r100, char r101, boolean r102, Integer r103, int r104, int r105, TextLayoutResult r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f53char;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.isDigit;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.digitIndex;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.widthPx;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.positionIndex;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.staticLayout;
    L20:
        char r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final char component1() {
        return this.f53char;
    }

    public final boolean component2() {
        return this.isDigit;
    }

    public final Integer component3() {
        return this.digitIndex;
    }

    public final int component4() {
        return this.widthPx;
    }

    public final int component5() {
        return this.positionIndex;
    }

    public final TextLayoutResult component6() {
        return this.staticLayout;
    }

    public final AmountSlot copy(char r100, boolean r110, Integer r111, int r112, int r113, TextLayoutResult r114) {
        return new AmountSlot(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AmountSlot) == true) goto L8;
        return false;
    L8:
        AmountSlot r101 = (AmountSlot) r100;
        if (this.f53char == r101.f53char) goto L12;
        return false;
    L12:
        if (this.isDigit == r101.isDigit) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.digitIndex, r101.digitIndex) == true) goto L18;
        return false;
    L18:
        if (this.widthPx == r101.widthPx) goto L21;
        return false;
    L21:
        if (this.positionIndex == r101.positionIndex) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.staticLayout, r101.staticLayout) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.f53char * 31;
        if (this.isDigit == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Integer r103 = this.digitIndex;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r102 + r105) * 31) + this.widthPx) * 31) + this.positionIndex) * 31;
        TextLayoutResult r107 = this.staticLayout;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "AmountSlot(char=" + this.f53char + ", isDigit=" + this.isDigit + ", digitIndex=" + this.digitIndex + ", widthPx=" + this.widthPx + ", positionIndex=" + this.positionIndex + ", staticLayout=" + this.staticLayout + ')';
    }

    public final char getChar() {
        return this.f53char;
    }

    public final Integer getDigitIndex() {
        return this.digitIndex;
    }

    public final int getPositionIndex() {
        return this.positionIndex;
    }

    public final TextLayoutResult getStaticLayout() {
        return this.staticLayout;
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public final boolean isDigit() {
        return this.isDigit;
    }

    public AmountSlot(char r100, boolean r101, Integer r102, int r103, int r104, TextLayoutResult r105) {
        this.f53char = r100;
        this.isDigit = r101;
        this.digitIndex = r102;
        this.widthPx = r103;
        this.positionIndex = r104;
        this.staticLayout = r105;
    }
}
