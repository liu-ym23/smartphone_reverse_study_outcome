package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class TypefaceCompat {
    public static final boolean DOWNLOADABLE_FALLBACK_DEBUG = false;
    public static final boolean DOWNLOADABLE_FONT_TRACING = true;
    private static final LruCache<String, Typeface> sTypefaceCache = null;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl = null;

    /* JADX INFO: loaded from: classes17.dex */
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback r100) {
            this.mFontCallback = r100;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int r100) {
            ResourcesCompat.FontCallback r101 = this.mFontCallback;
            if (r101 == null) goto L6;
            r101.onFontRetrievalFailed(r100);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(Typeface r100) {
            ResourcesCompat.FontCallback r101 = this.mFontCallback;
            if (r101 == null) goto L6;
            r101.onFontRetrieved(r100);
            return;
        }
    }

    private TypefaceCompat() {
    }

    static {
        Trace.beginSection("TypefaceCompat static init");
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L6;
        sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
    L17:
        sTypefaceCache = new LruCache(16);
        Trace.endSection();
        return;
    L6:
        if (r100 < 28) goto L9;
        sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        goto L17
    L9:
        if (r100 < 26) goto L12;
        sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        goto L17
    L12:
        if (r100 >= 24) goto L14;
    L16:
        sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        goto L17
    L14:
        if (TypefaceCompatApi24Impl.isUsable() == false) goto L16;
        sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
        goto L17
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    private static Typeface getSystemFontFamily(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L16;
        Typeface r101 = Typeface.create(r100, 0);
        Typeface r102 = Typeface.create(Typeface.DEFAULT, 0);
        if (r101 != null) goto L10;
        return null;
    L10:
        if (r101.equals(r102) == false) goto L12;
        return null;
    L12:
        return r101;
    L16:
        return null;
    }

    public static Typeface create(Context r100, Typeface r101, int r102) {
        if (r100 == null) goto L6;
        return Typeface.create(r101, r102);
    L6:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface findFromCache(Resources r100, int r101, int r102) {
        return findFromCache(r100, r101, null, 0, r102);
    }

    private static Typeface getBestFontFromFamily(Context r100, Typeface r101, int r102) {
        TypefaceCompatBaseImpl r103 = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r104 = r103.getFontFamily(r101);
        if (r104 != null) goto L7;
        return null;
    L7:
        return r103.createFromFontFamilyFilesResourceEntry(r100, r104, r100.getResources(), r102);
    }

    public static Typeface create(Context r100, Typeface r101, int r102, boolean r103) {
        if (r100 == null) goto L9;
        Preconditions.checkArgumentInRange(r102, 1, 1000, "weight");
        if (r101 != null) goto L7;
        r101 = Typeface.DEFAULT;
    L7:
        return sTypefaceCompatImpl.createWeightStyle(r100, r101, r102, r103);
    L9:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromFontInfo(Context r100, CancellationSignal r101, FontsContractCompat.FontInfo[] r102, int r103) {
        Trace.beginSection("TypefaceCompat.createFromFontInfo");
        Typeface r104 = sTypefaceCompatImpl.createFromFontInfo(r100, r101, r102, r103);     // Catch: Throwable -> L6
        Trace.endSection();
        return r104;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static Typeface createFromFontInfoWithFallback(Context r100, CancellationSignal r101, List<FontsContractCompat.FontInfo[]> r102, int r103) {
        Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
        Typeface r104 = sTypefaceCompatImpl.createFromFontInfoWithFallback(r100, r101, r102, r103);     // Catch: Throwable -> L6
        Trace.endSection();
        return r104;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static Typeface createFromResourcesFontFile(Context r100, Resources r101, int r102, String r103, int r110) {
        return createFromResourcesFontFile(r100, r101, r102, r103, 0, r110);
    }

    private static String createResourceUid(Resources r100, int r101, String r102, int r103, int r104) {
        return r100.getResourcePackageName(r101) + '-' + r102 + '-' + r103 + '-' + r101 + '-' + r104;
    }

    public static Typeface findFromCache(Resources r100, int r101, String r102, int r103, int r104) {
        return sTypefaceCache.get(createResourceUid(r100, r101, r102, r103, r104));
    }

    public static Typeface createFromResourcesFontFile(Context r100, Resources r101, int r102, String r103, int r110, int r111) {
        Typeface r104 = sTypefaceCompatImpl.createFromResourcesFontFile(r100, r101, r102, r103, r111);
        if (r104 == null) goto L5;
        String r105 = createResourceUid(r101, r102, r103, r110, r111);
        sTypefaceCache.put(r105, r104);
    L5:
        return r104;
    }

    public static Typeface createFromResourcesFamilyXml(Context r110, FontResourcesParserCompat.FamilyResourceEntry r111, Resources r112, int r113, int r114, ResourcesCompat.FontCallback r115, Handler r116, boolean r117) {
        return createFromResourcesFamilyXml(r110, r111, r112, r113, null, 0, r114, r115, r116, r117);
    }

    public static Typeface createFromResourcesFamilyXml(Context r110, FontResourcesParserCompat.FamilyResourceEntry r111, Resources r112, int r113, String r114, int r115, int r116, ResourcesCompat.FontCallback r210, Handler r211, boolean r212) {
        if ((r111 instanceof FontResourcesParserCompat.ProviderResourceEntry) == false) goto L28;
        FontResourcesParserCompat.ProviderResourceEntry r100 = (FontResourcesParserCompat.ProviderResourceEntry) r111;
        Typeface r101 = getSystemFontFamily(r100.getSystemFontFamilyName());
        if (r101 == null) goto L9;
        if (r210 == null) goto L8;
        r210.callbackSuccessAsync(r101, r211);
    L8:
        return r101;
    L9:
        int r102 = 0;
        if (r212 == true) goto L12;
        if (r210 != null) goto L16;
    L15:
        boolean r103 = true;
    L17:
        if (r212 == false) goto L19;
        int r117 = r100.getTimeout();
    L20:
        Handler r118 = ResourcesCompat.FontCallback.getHandler(r211);
        ResourcesCallbackAdapter r119 = new ResourcesCallbackAdapter(r210);
        if (r100.getFallbackRequest() == null) goto L26;
        Object[] r104 = {r100.getRequest(), r100.getFallbackRequest()};
        ArrayList r105 = new ArrayList(2);
    L23:
        if (r102 >= 2) goto L25;
        Object r106 = r104[r102];
        Objects.requireNonNull(r106);
        r105.add(r106);
        r102 = r102 + 1;
        goto L23
    L25:
        List r107 = Collections.unmodifiableList(r105);
    L27:
        Typeface r108 = FontsContractCompat.requestFont(r110, r107, r116, r103, r117, r118, r119);
    L33:
        if (r108 == null) goto L35;
        sTypefaceCache.put(createResourceUid(r112, r113, r114, r115, r116), r108);
    L35:
        return r108;
    L26:
        Object[] r109 = {r100.getRequest()};
        ArrayList r120 = new ArrayList(1);
        Object r121 = r109[0];
        Objects.requireNonNull(r121);
        r120.add(r121);
        r107 = Collections.unmodifiableList(r120);
        goto L27
    L19:
        r117 = -1;
    L16:
        r103 = false;
        goto L17
    L12:
        if (r100.getFetchStrategy() != 0) goto L16;
    L28:
        r108 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(r110, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) r111, r112, r116);
        if (r210 == null) goto L33;
        if (r108 == null) goto L32;
        r210.callbackSuccessAsync(r108, r211);
        goto L33
    L32:
        r210.callbackFailAsync(-3, r211);
        goto L33
    }
}
