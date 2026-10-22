package androidx.compose.ui.text.font;

import android.content.Context;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u001e¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "<init>", "()V", "createDefault", "Landroid/graphics/Typeface;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "optionalOnDeviceFontFamilyByName", CommonConstant.KEY_FAMILY_NAME, "", "weight", "style", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createAndroidTypefaceUsingTypefaceStyle", "genericFontFamily", "createAndroidTypefaceUsingTypefaceStyle-RetOiIg", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PlatformTypefacesApi implements PlatformTypefaces {
    public PlatformTypefacesApi() {
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo7139createDefaultFO1MlWM(FontWeight r100, int r101) {
        return m7142createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, r100, r101);
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m7142createAndroidTypefaceUsingTypefaceStyleRetOiIg(String r100, FontWeight r101, int r102) {
        boolean r103 = false;
        if (FontStyle.m7112equalsimpl0(r102, FontStyle.Companion.m7119getNormal_LCdwA()) == true) goto L5;
    L15:
        int r104 = AndroidFontUtils_androidKt.m7063getAndroidTypefaceStyleFO1MlWM(r101, r102);
        if (r100 != null) goto L18;
    L19:
        r103 = true;
    L20:
        if (r103 == false) goto L23;
        return android.graphics.Typeface.defaultFromStyle(r104);
    L23:
        return android.graphics.Typeface.create(r100, r104);
    L18:
        if (r100.length() != 0) goto L20;
    L5:
        if (Intrinsics.areEqual(r101, FontWeight.Companion.getNormal()) == false) goto L15;
        if (r100 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        return android.graphics.Typeface.DEFAULT;
    L8:
        if (r100.length() == 0) goto L11;
        r105 = false;
        goto L12
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m7144loadNamedFromTypefaceCacheOrNullRetOiIg(String r100, FontWeight r101, int r102) {
        boolean r103 = true;
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
        return null;
    L9:
        android.graphics.Typeface r105 = m7142createAndroidTypefaceUsingTypefaceStyleRetOiIg(r100, r101, r102);
        if (Intrinsics.areEqual(r105, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.m7063getAndroidTypefaceStyleFO1MlWM(r101, r102))) == false) goto L12;
    L14:
        r103 = false;
    L15:
        if (r103 == true) goto L17;
        return null;
    L17:
        return r105;
    L12:
        if (Intrinsics.areEqual(r105, m7142createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, r101, r102)) == true) goto L14;
    L5:
        r104 = false;
        goto L7
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo7140createNamedRetOiIg(GenericFontFamily r100, FontWeight r101, int r102) {
        android.graphics.Typeface r103 = m7144loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefaces_androidKt.getWeightSuffixForFallbackFamilyName(r100.getName(), r101), r101, r102);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return m7142createAndroidTypefaceUsingTypefaceStyleRetOiIg(r100.getName(), r101, r102);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public android.graphics.Typeface mo7141optionalOnDeviceFontFamilyByName78DK7lM(String r100, FontWeight r101, int r102, FontVariation.Settings r103, Context r104) {
        FontFamily.Companion r105 = FontFamily.Companion;
        if (Intrinsics.areEqual(r100, r105.getSansSerif().getName()) == false) goto L6;
        android.graphics.Typeface r106 = mo7140createNamedRetOiIg(r105.getSansSerif(), r101, r102);
    L16:
        return PlatformTypefaces_androidKt.setFontVariationSettings(r106, r103, r104);
    L6:
        if (Intrinsics.areEqual(r100, r105.getSerif().getName()) == false) goto L9;
        r106 = mo7140createNamedRetOiIg(r105.getSerif(), r101, r102);
        goto L16
    L9:
        if (Intrinsics.areEqual(r100, r105.getMonospace().getName()) == false) goto L12;
        r106 = mo7140createNamedRetOiIg(r105.getMonospace(), r101, r102);
        goto L16
    L12:
        if (Intrinsics.areEqual(r100, r105.getCursive().getName()) == false) goto L14;
        r106 = mo7140createNamedRetOiIg(r105.getCursive(), r101, r102);
        goto L16
    L14:
        r106 = m7144loadNamedFromTypefaceCacheOrNullRetOiIg(r100, r101, r102);
        goto L16
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ android.graphics.Typeface m7143createAndroidTypefaceUsingTypefaceStyleRetOiIg$default(PlatformTypefacesApi r100, String r101, FontWeight r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = FontWeight.Companion.getNormal();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = FontStyle.Companion.m7119getNormal_LCdwA();
    L12:
        return r100.m7142createAndroidTypefaceUsingTypefaceStyleRetOiIg(r101, r102, r103);
    }
}
