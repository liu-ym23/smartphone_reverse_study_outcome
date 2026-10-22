package androidx.compose.ui.text.font;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", CommonConstant.KEY_FAMILY_NAME, "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-vxs03AY", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DeviceFontFamilyNameFontKt {
    /* JADX INFO: renamed from: Font-vxs03AY, reason: not valid java name */
    public static final Font m7081Fontvxs03AY(String r100, FontWeight r101, int r102, FontVariation.Settings r110) {
        return new DeviceFontFamilyNameFont(r100, r101, r102, r110, null);
    }

    /* JADX INFO: renamed from: Font-vxs03AY$default, reason: not valid java name */
    public static /* synthetic */ Font m7082Fontvxs03AY$default(String r100, FontWeight r101, int r102, FontVariation.Settings r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = FontWeight.Companion.getNormal();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = FontStyle.Companion.m7119getNormal_LCdwA();
    L9:
        if ((r104 & 8) == 0) goto L12;
        r103 = new FontVariation.Settings(new FontVariation.Setting[0]);
    L12:
        return m7081Fontvxs03AY(r100, r101, r102, r103);
    }
}
