package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontResolveInterceptor;", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "fontWeightAdjustment", "", "<init>", "(I)V", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    public static final int $stable = 0;
    private final int fontWeightAdjustment;

    private final int component1() {
        return this.fontWeightAdjustment;
    }

    public static /* synthetic */ AndroidFontResolveInterceptor copy$default(AndroidFontResolveInterceptor r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.fontWeightAdjustment;
    L6:
        return r100.copy(r101);
    }

    public final AndroidFontResolveInterceptor copy(int r100) {
        return new AndroidFontResolveInterceptor(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AndroidFontResolveInterceptor) == true) goto L9;
        return false;
    L9:
        if (this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) r100).fontWeightAdjustment) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fontWeightAdjustment;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public final /* synthetic */ FontFamily interceptFontFamily(FontFamily r100) {
        return PlatformResolveInterceptor.CC.$default$interceptFontFamily(this, r100);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    /* JADX INFO: renamed from: interceptFontStyle-T2F_aPo, reason: not valid java name */
    public final /* synthetic */ int mo7061interceptFontStyleT2F_aPo(int r100) {
        return PlatformResolveInterceptor.CC.m7137$default$interceptFontStyleT2F_aPo(this, r100);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    /* JADX INFO: renamed from: interceptFontSynthesis-Mscr08Y, reason: not valid java name */
    public final /* synthetic */ int mo7062interceptFontSynthesisMscr08Y(int r100) {
        return PlatformResolveInterceptor.CC.m7138$default$interceptFontSynthesisMscr08Y(this, r100);
    }

    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.fontWeightAdjustment + ')';
    }

    public AndroidFontResolveInterceptor(int r100) {
        this.fontWeightAdjustment = r100;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public FontWeight interceptFontWeight(FontWeight r100) {
        int r101 = this.fontWeightAdjustment;
        if (r101 != 0) goto L5;
    L9:
        return r100;
    L5:
        if (r101 == Integer.MAX_VALUE) goto L9;
        return new FontWeight(RangesKt.coerceIn(r100.getWeight() + this.fontWeightAdjustment, 1, 1000));
    }
}
