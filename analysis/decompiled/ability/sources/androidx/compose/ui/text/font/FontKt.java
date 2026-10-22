package androidx.compose.ui.text.font;

import C7.c;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0007¨\u0006\u0014"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontKt {
    @ExperimentalTextApi
    /* renamed from: Font-F3nL8kk, reason: not valid java name */
    public static final Font m6398FontF3nL8kk(int i, FontWeight fontWeight, int i6, int i10, FontVariation.Settings settings) {
        return new ResourceFont(i, fontWeight, i6, settings, i10, null);
    }

    /* renamed from: Font-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ Font m6399FontF3nL8kk$default(int i, FontWeight fontWeight, int i6, int i10, FontVariation.Settings settings, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i11 & 4) != 0) {
            i6 = FontStyle.INSTANCE.m6429getNormal_LCdwA();
        }
        if ((i11 & 8) != 0) {
            i10 = FontLoadingStrategy.INSTANCE.m6414getBlockingPKNRLFQ();
        }
        if ((i11 & 16) != 0) {
            settings = FontVariation.INSTANCE.m6444Settings6EWAqTQ(fontWeight, i6, new FontVariation.Setting[0]);
        }
        return m6398FontF3nL8kk(i, fontWeight, i6, i10, settings);
    }

    @Stable
    @c
    /* renamed from: Font-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ Font m6400FontRetOiIg(int i, FontWeight fontWeight, int i6) {
        return new ResourceFont(i, fontWeight, i6, null, FontLoadingStrategy.INSTANCE.m6414getBlockingPKNRLFQ(), 8, null);
    }

    /* renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m6401FontRetOiIg$default(int i, FontWeight fontWeight, int i6, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i10 & 4) != 0) {
            i6 = FontStyle.INSTANCE.m6429getNormal_LCdwA();
        }
        return m6400FontRetOiIg(i, fontWeight, i6);
    }

    @Stable
    /* renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m6402FontYpTlLL0(int i, FontWeight fontWeight, int i6, int i10) {
        return new ResourceFont(i, fontWeight, i6, new FontVariation.Settings(new FontVariation.Setting[0]), i10, null);
    }

    /* renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m6403FontYpTlLL0$default(int i, FontWeight fontWeight, int i6, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i11 & 4) != 0) {
            i6 = FontStyle.INSTANCE.m6429getNormal_LCdwA();
        }
        if ((i11 & 8) != 0) {
            i10 = FontLoadingStrategy.INSTANCE.m6414getBlockingPKNRLFQ();
        }
        return m6402FontYpTlLL0(i, fontWeight, i6, i10);
    }

    @Stable
    public static final FontFamily toFontFamily(Font font) {
        return FontFamilyKt.FontFamily(font);
    }
}
