package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0007¨\u0006\u0014"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FontKt {
    public static final FontFamily toFontFamily(Font r100) {
        return FontFamilyKt.FontFamily(new Font[]{r100});
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility until Compose 1.3.", replaceWith = @ReplaceWith(expression = "Font(resId, weight, style)", imports = {}))
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ Font m7090FontRetOiIg(int r100, FontWeight r110, int r111) {
        return new ResourceFont(r100, r110, r111, null, FontLoadingStrategy.Companion.m7104getBlockingPKNRLFQ(), 8, null);
    }

    /* JADX INFO: renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m7092FontYpTlLL0(int r100, FontWeight r101, int r110, int r111) {
        return new ResourceFont(r100, r101, r110, new FontVariation.Settings(new FontVariation.Setting[0]), r111, null);
    }

    /* JADX INFO: renamed from: Font-F3nL8kk, reason: not valid java name */
    public static final Font m7088FontF3nL8kk(int r100, FontWeight r101, int r110, int r111, FontVariation.Settings r112) {
        return new ResourceFont(r100, r101, r110, r112, r111, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m7091FontRetOiIg$default(int r100, FontWeight r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = FontWeight.Companion.getNormal();
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        return m7090FontRetOiIg(r100, r101, r102);
    }

    /* JADX INFO: renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m7093FontYpTlLL0$default(int r100, FontWeight r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = FontWeight.Companion.getNormal();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = FontLoadingStrategy.Companion.m7104getBlockingPKNRLFQ();
    L12:
        return m7092FontYpTlLL0(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: Font-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ Font m7089FontF3nL8kk$default(int r100, FontWeight r101, int r102, int r103, FontVariation.Settings r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r101 = FontWeight.Companion.getNormal();
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = FontLoadingStrategy.Companion.m7104getBlockingPKNRLFQ();
    L12:
        if ((r105 & 16) == 0) goto L15;
        r104 = FontVariation.INSTANCE.m7134Settings6EWAqTQ(r101, r102, new FontVariation.Setting[0]);
    L15:
        return m7088FontF3nL8kk(r100, r101, r102, r103, r104);
    }
}
