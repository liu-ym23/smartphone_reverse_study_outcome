package t0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.List;
import s0.e;
import y0.g;

/* loaded from: classes.dex */
public class i extends k {
    public static int j(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // t0.k
    public Typeface a(Context context, e.c cVar, Resources resources, int i10) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (e.d dVar : cVar.a()) {
                try {
                    Font fontBuild = new Font.Builder(resources, dVar.a()).setWeight(dVar.d()).setSlant(dVar.e() ? 1 : 0).setTtcIndex(dVar.b()).setFontVariationSettings(dVar.c()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(e(fontFamilyBuild, i10).getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    @Override // t0.k
    public Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i10) {
        try {
            FontFamily fontFamilyG = g(cancellationSignal, bVarArr, context.getContentResolver());
            if (fontFamilyG == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyG).setStyle(e(fontFamilyG, i10).getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    @Override // t0.k
    public Typeface c(Context context, CancellationSignal cancellationSignal, List<g.b[]> list, int i10) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyG = g(cancellationSignal, list.get(0), contentResolver);
            if (fontFamilyG == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyG);
            for (int i11 = 1; i11 < list.size(); i11++) {
                FontFamily fontFamilyG2 = g(cancellationSignal, list.get(i11), contentResolver);
                if (fontFamilyG2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyG2);
                }
            }
            return customFallbackBuilder.setStyle(e(fontFamilyG, i10).getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    @Override // t0.k
    public Typeface d(Context context, Resources resources, int i10, String str, int i11) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i10).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    public final Font e(FontFamily fontFamily, int i10) {
        FontStyle fontStyle = new FontStyle((i10 & 1) != 0 ? 700 : Const.I_TILE_TINY, (i10 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iJ = j(fontStyle, font.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font font2 = fontFamily.getFont(i11);
            int iJ2 = j(fontStyle, font2.getStyle());
            if (iJ2 < iJ) {
                font = font2;
                iJ = iJ2;
            }
        }
        return font;
    }

    public final Font f(CancellationSignal cancellationSignal, g.b bVar, ContentResolver contentResolver) {
        return bVar.i() ? i(bVar) : h(cancellationSignal, bVar, contentResolver);
    }

    public FontFamily g(CancellationSignal cancellationSignal, g.b[] bVarArr, ContentResolver contentResolver) {
        FontFamily.Builder builder = null;
        for (g.b bVar : bVarArr) {
            Font fontF = f(cancellationSignal, bVar, contentResolver);
            if (fontF != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontF);
                } else {
                    builder.addFont(fontF);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public final Font h(CancellationSignal cancellationSignal, g.b bVar, ContentResolver contentResolver) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.e(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    return null;
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            try {
                Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.g()).setSlant(bVar.h() ? 1 : 0).setTtcIndex(bVar.d());
                if (!TextUtils.isEmpty(bVar.f())) {
                    ttcIndex.setFontVariationSettings(bVar.f());
                }
                Font fontBuild = ttcIndex.build();
                parcelFileDescriptorOpenFileDescriptor.close();
                return fontBuild;
            } finally {
            }
        } catch (IOException e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            return null;
        }
    }

    public Font i(g.b bVar) {
        throw null;
    }
}
