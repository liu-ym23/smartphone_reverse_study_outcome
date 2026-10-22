package com.android.ttcjpaysdk.kmp.common.view.carousel;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\b\u0019J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003JP\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001¢\u0006\u0002\b\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/carousel/CarouselAtomicComponent;", "", "url", "", "text", "text_color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "", "width", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/Color;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getText", "getText_color-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getFontSize", "()I", "getWidth", "getHeight", "component1", "component2", "component3", "component3-QN2ZGVo", "component4", "component5", "component6", "copy", "copy-gKt5lHk", "equals", "", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CarouselAtomicComponent {
    public static final int $stable = 0;
    private final int fontSize;
    private final int height;
    private final String text;
    private final Color text_color;
    private final String url;
    private final int width;

    public /* synthetic */ CarouselAtomicComponent(String r100, String r101, Color r102, int r103, int r104, int r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    /* JADX INFO: renamed from: copy-gKt5lHk$default, reason: not valid java name */
    public static /* synthetic */ CarouselAtomicComponent m8065copygKt5lHk$default(CarouselAtomicComponent r100, String r101, String r102, Color r103, int r104, int r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.text;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.text_color;
    L11:
        Color r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.fontSize;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.width;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.height;
    L20:
        String r109 = r101;
        return r100.m8067copygKt5lHk(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3-QN2ZGVo, reason: not valid java name */
    public final Color m8066component3QN2ZGVo() {
        return this.text_color;
    }

    public final int component4() {
        return this.fontSize;
    }

    public final int component5() {
        return this.width;
    }

    public final int component6() {
        return this.height;
    }

    /* JADX INFO: renamed from: copy-gKt5lHk, reason: not valid java name */
    public final CarouselAtomicComponent m8067copygKt5lHk(String r110, String r111, Color r112, int r113, int r114, int r115) {
        return new CarouselAtomicComponent(r110, r111, r112, r113, r114, r115, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CarouselAtomicComponent) == true) goto L8;
        return false;
    L8:
        CarouselAtomicComponent r101 = (CarouselAtomicComponent) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text_color, r101.text_color) == true) goto L18;
        return false;
    L18:
        if (this.fontSize == r101.fontSize) goto L21;
        return false;
    L21:
        if (this.width == r101.width) goto L24;
        return false;
    L24:
        if (this.height == r101.height) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Color r107 = this.text_color;
        if (r107 == null) goto L15;
        r101 = Color.m4834hashCodeimpl(r107.m4837unboximpl());
    L15:
        return ((((((r106 + r101) * 31) + this.fontSize) * 31) + this.width) * 31) + this.height;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CarouselAtomicComponent(url=" + this.url + ", text=" + this.text + ", text_color=" + this.text_color + ", fontSize=" + this.fontSize + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getText_color-QN2ZGVo, reason: not valid java name */
    public final Color m8068getText_colorQN2ZGVo() {
        return this.text_color;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    private CarouselAtomicComponent(String r100, String r101, Color r102, int r103, int r104, int r105) {
        this.url = r100;
        this.text = r101;
        this.text_color = r102;
        this.fontSize = r103;
        this.width = r104;
        this.height = r105;
    }

    public /* synthetic */ CarouselAtomicComponent(String r100, String r101, Color r110, int r111, int r112, int r113, int r114, DefaultConstructorMarker r115) {
        Color r102 = null;
        if ((r114 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r114 & 4) != 0) goto L15;
        r102 = r110;
    L15:
        if ((r114 & 8) == 0) goto L17;
        int r105 = 14;
    L18:
        int r106 = 16;
        if ((r114 & 16) == 0) goto L21;
        int r107 = 16;
    L23:
        if ((r114 & 32) != 0) goto L26;
        r106 = r113;
    L26:
        this(r103, r104, r102, r105, r107, r106, null);
        return;
    L21:
        r107 = r112;
        goto L23
    L17:
        r105 = r111;
        goto L18
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
