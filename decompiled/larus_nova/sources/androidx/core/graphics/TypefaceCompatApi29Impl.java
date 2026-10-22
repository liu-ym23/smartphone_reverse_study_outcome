package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f06.b;
import f06.d;
import g06.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi29Impl";

    public TypefaceCompatApi29Impl() {
    }

    private Font findBaseFont(FontFamily r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = 700;
    L6:
        int r103 = 1;
        if ((r101 & 2) == 0) goto L9;
        int r104 = 1;
    L10:
        FontStyle r105 = new FontStyle(r102, r104);
        Font r106 = r100.getFont(0);
        int r107 = getMatchScore(r105, r106.getStyle());
    L12:
        if (r103 >= r100.getSize()) goto L17;
        Font r108 = r100.getFont(r103);
        int r109 = getMatchScore(r105, r108.getStyle());
        if (r109 >= r107) goto L16;
        r106 = r108;
        r107 = r109;
    L16:
        r103 = r103 + 1;
        goto L12
    L17:
        return r106;
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 400;
        goto L6
    }

    private static int getMatchScore(FontStyle r100, FontStyle r101) {
        int r102 = Math.abs(r100.getWeight() - r101.getWeight()) / 100;
        if (r100.getSlant() != r101.getSlant()) goto L5;
        int r103 = 0;
    L7:
        return r102 + r103;
    L5:
        r103 = 2;
        goto L7
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromInputStream(Context r100, InputStream r101) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r100, int r101) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    private static FontFamily getFontFamily(CancellationSignal r100, FontsContractCompat.FontInfo[] r110, ContentResolver r111) {
        int r101 = r110.length;
        FontFamily.Builder r102 = null;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L26;
        FontsContractCompat.FontInfo r104 = r110[r103];
        ParcelFileDescriptor r105 = androidx_core_graphics_TypefaceCompatApi29Impl_android_content_ContentResolver_openFileDescriptor(r111, r104.getUri(), "r", r100);     // Catch: IOException -> L30
        if (r105 != null) goto L35;
        if (r105 == null) goto L25;
    L8:
        r105.close();     // Catch: IOException -> L30
        goto L25
    L35:
        Font.Builder r106 = new Font.Builder(r105).setWeight(r104.getWeight());     // Catch: Throwable -> L19
        if (r104.isItalic() == false) goto L13;
        int r107 = 1;
    L14:
        Font r108 = r106.setSlant(r107).setTtcIndex(r104.getTtcIndex()).build();     // Catch: Throwable -> L19
        if (r102 != null) goto L17;
        r102 = new FontFamily.Builder(r108);     // Catch: Throwable -> L19
        goto L8
    L17:
        r102.addFont(r108);     // Catch: Throwable -> L19
        goto L8
    L13:
        r107 = 0;
        goto L14
    L19:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L30
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L30
    L25:
        r103 = r103 + 1;
        goto L3
    L26:
        if (r102 != null) goto L29;
        return null;
    L29:
        return r102.build();
    }

    private static ParcelFileDescriptor androidx_core_graphics_TypefaceCompatApi29Impl_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210, CancellationSignal r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return r110.openFileDescriptor(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r100, FontResourcesParserCompat.FontFamilyFilesResourceEntry r101, Resources r110, int r111) {
        FontResourcesParserCompat.FontFileResourceEntry[] r102 = r101.getEntries();     // Catch: Exception -> L20
        int r103 = r102.length;     // Catch: Exception -> L20
        FontFamily.Builder r104 = null;
        int r105 = 0;
    L4:
        if (r105 >= r103) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r106 = r102[r105];     // Catch: Exception -> L20
        Font.Builder r107 = new Font.Builder(r110, r106.getResourceId()).setWeight(r106.getWeight());     // Catch: IOException -> L19 Exception -> L20
        if (r106.isItalic() == false) goto L9;
        int r108 = 1;
    L10:
        Font r109 = r107.setSlant(r108).setTtcIndex(r106.getTtcIndex()).setFontVariationSettings(r106.getVariationSettings()).build();     // Catch: IOException -> L19 Exception -> L20
        if (r104 != null) goto L13;
        r104 = new FontFamily.Builder(r109);     // Catch: IOException -> L19 Exception -> L20
        goto L14
    L13:
        r104.addFont(r109);     // Catch: IOException -> L19 Exception -> L20
        goto L14
    L9:
        r108 = 0;
    L14:
        r105 = r105 + 1;
        goto L4
    L15:
        if (r104 != null) goto L17;
        return null;
    L17:
        FontFamily r112 = r104.build();     // Catch: Exception -> L20
        return new Typeface.CustomFallbackBuilder(r112).setStyle(findBaseFont(r112, r111).getStyle()).build();
    L28:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r100, CancellationSignal r101, FontsContractCompat.FontInfo[] r102, int r103) {
        FontFamily r104 = getFontFamily(r101, r102, r100.getContentResolver());     // Catch: Exception -> L8
        if (r104 != null) goto L6;
        return null;
    L6:
        return new Typeface.CustomFallbackBuilder(r104).setStyle(findBaseFont(r104, r103).getStyle()).build();
    L8:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfoWithFallback(Context r100, CancellationSignal r101, List<FontsContractCompat.FontInfo[]> r102, int r103) {
        ContentResolver r104 = r100.getContentResolver();
        FontFamily r105 = getFontFamily(r101, (FontsContractCompat.FontInfo[]) ListProtector.get(r102, 0), r104);     // Catch: Exception -> L15
        if (r105 != null) goto L6;
        return null;
    L6:
        Typeface.CustomFallbackBuilder r106 = new Typeface.CustomFallbackBuilder(r105);     // Catch: Exception -> L15
        int r107 = 1;
    L8:
        if (r107 >= r102.size()) goto L13;
        FontFamily r108 = getFontFamily(r101, (FontsContractCompat.FontInfo[]) ListProtector.get(r102, r107), r104);     // Catch: Exception -> L15
        if (r108 == null) goto L12;
        r106.addCustomFallback(r108);     // Catch: Exception -> L15
    L12:
        r107 = r107 + 1;     // Catch: Exception -> L15
        goto L8
    L13:
        return r106.setStyle(findBaseFont(r105, r103).getStyle()).build();
    L15:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createWeightStyle(Context r100, Typeface r101, int r102, boolean r103) {
        return Typeface.create(r101, r102, r103);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context r100, Resources r101, int r102, String r103, int r104) {
        Font r105 = new Font.Builder(r101, r102).build();     // Catch: Exception -> L4
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r105).build()).setStyle(r105.getStyle()).build();
    L4:
        return null;
    }
}
