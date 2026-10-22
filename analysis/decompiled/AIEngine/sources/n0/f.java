package n0;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.core.ability.speech.AsrCloudWsSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import s0.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f extends h {
    public static Font b(FontFamily fontFamily, int i10) {
        FontStyle fontStyle = new FontStyle((i10 & 1) != 0 ? 700 : AsrCloudWsSession.SILENCE_TAIL_MARGIN_MS, (i10 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iE = e(fontStyle, font.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font font2 = fontFamily.getFont(i11);
            int iE2 = e(fontStyle, font2.getStyle());
            if (iE2 < iE) {
                font = font2;
                iE = iE2;
            }
        }
        return font;
    }

    public static int e(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public final Typeface a(Context context, List list, int i10) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyC = c((l[]) list.get(0), contentResolver);
            if (fontFamilyC == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyC);
            for (int i11 = 1; i11 < list.size(); i11++) {
                FontFamily fontFamilyC2 = c((l[]) list.get(i11), contentResolver);
                if (fontFamilyC2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyC2);
                }
            }
            return customFallbackBuilder.setStyle(b(fontFamilyC, i10).getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    public final FontFamily c(l[] lVarArr, ContentResolver contentResolver) throws IOException {
        Font fontBuild;
        String str;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (l lVar : lVarArr) {
            if (Objects.equals(lVar.f11861a.getScheme(), "systemfont")) {
                fontBuild = d(lVar);
            } else {
                try {
                    Uri uri = lVar.f11861a;
                    str = lVar.f11865e;
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e10) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    fontBuild = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(lVar.f11863c).setSlant(lVar.f11864d ? 1 : 0).setTtcIndex(lVar.f11862b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        fontBuild = ttcIndex.build();
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font d(l lVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }
}
