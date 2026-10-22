package com.android.ttcjpaysdk.kmp.common.view.text;

import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\b\u0015J>\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/text/HyperLinkConfig;", "", "textSpanArray", "", "Lcom/android/ttcjpaysdk/kmp/common/view/text/TextSpan;", "textClickAction", "Lkotlin/Function0;", "", "textFontSize", "Landroidx/compose/ui/unit/TextUnit;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/unit/TextUnit;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextSpanArray", "()Ljava/util/List;", "getTextClickAction", "()Lkotlin/jvm/functions/Function0;", "getTextFontSize-U3a4LBI", "()Landroidx/compose/ui/unit/TextUnit;", "component1", "component2", "component3", "component3-U3a4LBI", "copy", "copy-enNrUpA", "equals", "", "other", "hashCode", "", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HyperLinkConfig {
    public static final int $stable = 8;
    private final Function0<Unit> textClickAction;
    private final TextUnit textFontSize;
    private final List<TextSpan> textSpanArray;

    public /* synthetic */ HyperLinkConfig(List r100, Function0 r101, TextUnit r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-enNrUpA$default, reason: not valid java name */
    public static /* synthetic */ HyperLinkConfig m8109copyenNrUpA$default(HyperLinkConfig r100, List r101, Function0 r102, TextUnit r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.textSpanArray;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.textClickAction;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textFontSize;
    L12:
        return r100.m8111copyenNrUpA(r101, r102, r103);
    }

    public final List<TextSpan> component1() {
        return this.textSpanArray;
    }

    public final Function0<Unit> component2() {
        return this.textClickAction;
    }

    /* JADX INFO: renamed from: component3-U3a4LBI, reason: not valid java name */
    public final TextUnit m8110component3U3a4LBI() {
        return this.textFontSize;
    }

    /* JADX INFO: renamed from: copy-enNrUpA, reason: not valid java name */
    public final HyperLinkConfig m8111copyenNrUpA(List<TextSpan> r100, Function0<Unit> r101, TextUnit r102) {
        return new HyperLinkConfig(r100, r101, r102, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HyperLinkConfig) == true) goto L8;
        return false;
    L8:
        HyperLinkConfig r101 = (HyperLinkConfig) r100;
        if (Intrinsics.areEqual(this.textSpanArray, r101.textSpanArray) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textClickAction, r101.textClickAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textFontSize, r101.textFontSize) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<TextSpan> r100 = this.textSpanArray;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.textClickAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        TextUnit r107 = this.textFontSize;
        if (r107 == null) goto L15;
        r101 = TextUnit.m7743hashCodeimpl(r107.m7751unboximpl());
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "HyperLinkConfig(textSpanArray=" + this.textSpanArray + ", textClickAction=" + this.textClickAction + ", textFontSize=" + this.textFontSize + ')';
    }

    public final Function0<Unit> getTextClickAction() {
        return this.textClickAction;
    }

    /* JADX INFO: renamed from: getTextFontSize-U3a4LBI, reason: not valid java name */
    public final TextUnit m8112getTextFontSizeU3a4LBI() {
        return this.textFontSize;
    }

    public final List<TextSpan> getTextSpanArray() {
        return this.textSpanArray;
    }

    private HyperLinkConfig(List<TextSpan> r100, Function0<Unit> r101, TextUnit r102) {
        this.textSpanArray = r100;
        this.textClickAction = r101;
        this.textFontSize = r102;
    }

    public /* synthetic */ HyperLinkConfig(List r100, Function0 r101, TextUnit r102, int r103, DefaultConstructorMarker r104) {
        DefaultConstructorMarker r105 = null;
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102, r105);
    }
}
