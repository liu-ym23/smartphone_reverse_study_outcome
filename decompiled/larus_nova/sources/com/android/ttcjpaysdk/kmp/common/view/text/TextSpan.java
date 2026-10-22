package com.android.ttcjpaysdk.kmp.common.view.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\b\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\b\u001eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003JP\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\b!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/text/TextSpan;", "", "text", "", "clickAction", "Lkotlin/Function0;", "", "textFontColor", "Landroidx/compose/ui/graphics/Color;", "textFontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/unit/TextUnit;Landroidx/compose/ui/text/font/FontWeight;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getClickAction", "()Lkotlin/jvm/functions/Function0;", "getTextFontColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getTextFontSize-U3a4LBI", "()Landroidx/compose/ui/unit/TextUnit;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "component1", "component2", "component3", "component3-QN2ZGVo", "component4", "component4-U3a4LBI", "component5", "copy", "copy-5YoCcK4", "equals", "", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextSpan {
    public static final int $stable = 0;
    private final Function0<Unit> clickAction;
    private final FontWeight fontWeight;
    private final String text;
    private final Color textFontColor;
    private final TextUnit textFontSize;

    public /* synthetic */ TextSpan(String r100, Function0 r101, Color r102, TextUnit r103, FontWeight r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-5YoCcK4$default, reason: not valid java name */
    public static /* synthetic */ TextSpan m8114copy5YoCcK4$default(TextSpan r100, String r101, Function0 r102, Color r103, TextUnit r104, FontWeight r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.clickAction;
    L8:
        Function0 r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.textFontColor;
    L11:
        Color r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.textFontSize;
    L14:
        TextUnit r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.fontWeight;
    L17:
        String r109 = r101;
        return r100.m8117copy5YoCcK4(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.text;
    }

    public final Function0<Unit> component2() {
        return this.clickAction;
    }

    /* JADX INFO: renamed from: component3-QN2ZGVo, reason: not valid java name */
    public final Color m8115component3QN2ZGVo() {
        return this.textFontColor;
    }

    /* JADX INFO: renamed from: component4-U3a4LBI, reason: not valid java name */
    public final TextUnit m8116component4U3a4LBI() {
        return this.textFontSize;
    }

    public final FontWeight component5() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: copy-5YoCcK4, reason: not valid java name */
    public final TextSpan m8117copy5YoCcK4(String r100, Function0<Unit> r110, Color r111, TextUnit r112, FontWeight r113) {
        return new TextSpan(r100, r110, r111, r112, r113, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextSpan) == true) goto L8;
        return false;
    L8:
        TextSpan r101 = (TextSpan) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clickAction, r101.clickAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textFontColor, r101.textFontColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textFontSize, r101.textFontSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.clickAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Color r107 = this.textFontColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TextUnit r110 = this.textFontSize;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        FontWeight r113 = this.fontWeight;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = TextUnit.m7743hashCodeimpl(r110.m7751unboximpl());
        goto L18
    L13:
        r108 = Color.m4834hashCodeimpl(r107.m4837unboximpl());
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TextSpan(text=" + this.text + ", clickAction=" + this.clickAction + ", textFontColor=" + this.textFontColor + ", textFontSize=" + this.textFontSize + ", fontWeight=" + this.fontWeight + ')';
    }

    public final Function0<Unit> getClickAction() {
        return this.clickAction;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getTextFontColor-QN2ZGVo, reason: not valid java name */
    public final Color m8118getTextFontColorQN2ZGVo() {
        return this.textFontColor;
    }

    /* JADX INFO: renamed from: getTextFontSize-U3a4LBI, reason: not valid java name */
    public final TextUnit m8119getTextFontSizeU3a4LBI() {
        return this.textFontSize;
    }

    private TextSpan(String r100, Function0<Unit> r101, Color r102, TextUnit r103, FontWeight r104) {
        this.text = r100;
        this.clickAction = r101;
        this.textFontColor = r102;
        this.textFontSize = r103;
        this.fontWeight = r104;
    }

    public /* synthetic */ TextSpan(String r100, Function0 r110, Color r111, TextUnit r112, FontWeight r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        Function0 r102 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Color r103 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        TextUnit r104 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        FontWeight r105 = null;
    L22:
        this(r101, r102, r103, r104, r105, null);
        return;
    L21:
        r105 = r113;
        goto L22
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }
}
