package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000f¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/font/ResourceFont;", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "<init>", "(ILandroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getResId", "()I", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "I", "getVariationSettings", "()Landroidx/compose/ui/text/font/FontVariation$Settings;", "getLoadingStrategy-PKNRLFQ$annotations", "()V", "getLoadingStrategy-PKNRLFQ", "copy", "copy-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/ResourceFont;", "copy-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/ResourceFont;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ResourceFont implements Font {
    public static final int $stable = 0;
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final FontVariation.Settings variationSettings;
    private final FontWeight weight;

    public /* synthetic */ ResourceFont(int r100, FontWeight r101, int r102, FontVariation.Settings r103, int r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ$annotations, reason: not valid java name */
    public static /* synthetic */ void m7150getLoadingStrategyPKNRLFQ$annotations() {
    }

    public int hashCode() {
        return (((((((this.resId * 31) + getWeight().hashCode()) * 31) + FontStyle.m7113hashCodeimpl(mo7064getStyle_LCdwA())) * 31) + FontLoadingStrategy.m7100hashCodeimpl(mo7054getLoadingStrategyPKNRLFQ())) * 31) + this.variationSettings.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + getWeight() + ", style=" + FontStyle.m7114toStringimpl(mo7064getStyle_LCdwA()) + ", loadingStrategy=" + FontLoadingStrategy.m7101toStringimpl(mo7054getLoadingStrategyPKNRLFQ()) + ')';
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ */
    public int mo7054getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    public final int getResId() {
        return this.resId;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo7064getStyle_LCdwA() {
        return this.style;
    }

    public final FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceFont) == true) goto L8;
        return false;
    L8:
        ResourceFont r101 = (ResourceFont) r100;
        if (this.resId == r101.resId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getWeight(), r101.getWeight()) == true) goto L15;
        return false;
    L15:
        if (FontStyle.m7112equalsimpl0(mo7064getStyle_LCdwA(), r101.mo7064getStyle_LCdwA()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.variationSettings, r101.variationSettings) == true) goto L21;
        return false;
    L21:
        if (FontLoadingStrategy.m7099equalsimpl0(mo7054getLoadingStrategyPKNRLFQ(), r101.mo7054getLoadingStrategyPKNRLFQ()) == true) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX INFO: renamed from: copy-RetOiIg, reason: not valid java name */
    public final ResourceFont m7152copyRetOiIg(int r100, FontWeight r110, int r111) {
        return m7148copyF3nL8kk$default(this, r100, r110, r111, mo7054getLoadingStrategyPKNRLFQ(), null, 16, null);
    }

    private ResourceFont(int r100, FontWeight r101, int r102, FontVariation.Settings r103, int r104) {
        this.resId = r100;
        this.weight = r101;
        this.style = r102;
        this.variationSettings = r103;
        this.loadingStrategy = r104;
    }

    /* JADX INFO: renamed from: copy-F3nL8kk, reason: not valid java name */
    public final ResourceFont m7151copyF3nL8kk(int r100, FontWeight r110, int r111, int r112, FontVariation.Settings r113) {
        return new ResourceFont(r100, r110, r111, r113, r112, null);
    }

    /* JADX INFO: renamed from: copy-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ ResourceFont m7149copyRetOiIg$default(ResourceFont r100, int r101, FontWeight r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.resId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.getWeight();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.mo7064getStyle_LCdwA();
    L12:
        return r100.m7152copyRetOiIg(r101, r102, r103);
    }

    public /* synthetic */ ResourceFont(int r100, FontWeight r101, int r110, FontVariation.Settings r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        r101 = FontWeight.Companion.getNormal();
    L5:
        FontWeight r102 = r101;
        if ((r113 & 4) == 0) goto L8;
        r110 = FontStyle.Companion.m7119getNormal_LCdwA();
    L8:
        int r103 = r110;
        if ((r113 & 8) == 0) goto L11;
        r111 = FontVariation.INSTANCE.m7134Settings6EWAqTQ(r102, r103, new FontVariation.Setting[0]);
    L11:
        FontVariation.Settings r104 = r111;
        if ((r113 & 16) == 0) goto L14;
        r112 = FontLoadingStrategy.Companion.m7103getAsyncPKNRLFQ();
    L14:
        this(r100, r102, r103, r104, r112, null);
    }

    /* JADX INFO: renamed from: copy-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ ResourceFont m7148copyF3nL8kk$default(ResourceFont r100, int r101, FontWeight r102, int r103, int r104, FontVariation.Settings r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.resId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.getWeight();
    L8:
        FontWeight r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.mo7064getStyle_LCdwA();
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.mo7054getLoadingStrategyPKNRLFQ();
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.variationSettings;
    L17:
        int r109 = r101;
        return r100.m7151copyF3nL8kk(r109, r111, r107, r108, r105);
    }
}
