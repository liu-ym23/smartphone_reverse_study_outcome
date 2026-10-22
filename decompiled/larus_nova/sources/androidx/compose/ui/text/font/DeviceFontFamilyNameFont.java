package androidx.compose.ui.text.font;

import android.content.Context;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyNameFont;", "Landroidx/compose/ui/text/font/AndroidFont;", CommonConstant.KEY_FAMILY_NAME, "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getStyle-_-LCdwA", "()I", "I", "loadCached", "Landroid/graphics/Typeface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DeviceFontFamilyNameFont extends AndroidFont {
    private final String familyName;
    private final int style;
    private final FontWeight weight;

    public /* synthetic */ DeviceFontFamilyNameFont(String r100, FontWeight r101, int r102, FontVariation.Settings r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.m7078hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m7113hashCodeimpl(mo7064getStyle_LCdwA())) * 31) + getVariationSettings().hashCode();
    }

    public String toString() {
        return "Font(familyName=\"" + DeviceFontFamilyName.m7079toStringimpl(this.familyName) + "\", weight=" + getWeight() + ", style=" + FontStyle.m7114toStringimpl(mo7064getStyle_LCdwA()) + ')';
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo7064getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeviceFontFamilyNameFont) == true) goto L8;
        return false;
    L8:
        DeviceFontFamilyNameFont r101 = (DeviceFontFamilyNameFont) r100;
        if (DeviceFontFamilyName.m7077equalsimpl0(this.familyName, r101.familyName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getWeight(), r101.getWeight()) == true) goto L15;
        return false;
    L15:
        if (FontStyle.m7112equalsimpl0(mo7064getStyle_LCdwA(), r101.mo7064getStyle_LCdwA()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getVariationSettings(), r101.getVariationSettings()) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final android.graphics.Typeface loadCached(Context r100) {
        return PlatformTypefaces_androidKt.PlatformTypefaces().mo7141optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), mo7064getStyle_LCdwA(), getVariationSettings(), r100);
    }

    private DeviceFontFamilyNameFont(String r100, FontWeight r101, int r102, FontVariation.Settings r103) {
        super(FontLoadingStrategy.Companion.m7105getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, r103, null);
        this.familyName = r100;
        this.weight = r101;
        this.style = r102;
    }
}
