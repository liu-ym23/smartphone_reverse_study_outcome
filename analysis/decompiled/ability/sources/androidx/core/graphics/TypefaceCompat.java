package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.util.List;

/* loaded from: classes2.dex */
public class TypefaceCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean DOWNLOADABLE_FALLBACK_DEBUG = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean DOWNLOADABLE_FONT_TRACING = true;
    private static final String REFERENCE_CHAR_FOR_PRIMARY_FONT = " ";
    private static final String TAG = "TypefaceCompat";
    private static Paint sCachedPaint;
    private static final LruCache<String, Typeface> sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int i) {
            ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.lambda$callbackFailAsync$1(i);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.lambda$callbackSuccessAsync$0(typeface);
            }
        }
    }

    static {
        Trace.beginSection("TypefaceCompat static init");
        sTypefaceCompatImpl = new TypefaceCompatApi31Impl();
        sTypefaceCache = new LruCache<>(16);
        sCachedPaint = null;
        Trace.endSection();
    }

    private TypefaceCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    public static Typeface create(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Trace.beginSection("TypefaceCompat.createFromFontInfo");
        try {
            return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i);
        } finally {
            Trace.endSection();
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list, int i) {
        Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return sTypefaceCompatImpl.createFromFontInfoWithFallback(context, cancellationSignal, list, i);
        } finally {
            Trace.endSection();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, String str, int i6, int i10, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z10) {
        Typeface typefaceCreateFromFontFamilyFilesResourceEntry;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface systemFontFamilyWithFallback = getSystemFontFamilyWithFallback(providerResourceEntry);
            if (systemFontFamilyWithFallback != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(systemFontFamilyWithFallback, handler);
                }
                sTypefaceCache.put(createResourceUid(resources, i, str, i6, i10), systemFontFamilyWithFallback);
                return systemFontFamilyWithFallback;
            }
            typefaceCreateFromFontFamilyFilesResourceEntry = FontsContractCompat.requestFont(context, providerResourceEntry.getRequests(), i10, !z10 ? fontCallback != null : providerResourceEntry.getFetchStrategy() != 0, z10 ? providerResourceEntry.getTimeout() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback));
        } else {
            typefaceCreateFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i10);
            if (fontCallback != null) {
                if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
                    fontCallback.callbackSuccessAsync(typefaceCreateFromFontFamilyFilesResourceEntry, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i6, i10), typefaceCreateFromFontFamilyFilesResourceEntry);
        }
        return typefaceCreateFromFontFamilyFilesResourceEntry;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i6, int i10) {
        Typeface typefaceCreateFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, str, i10);
        if (typefaceCreateFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i6, i10), typefaceCreateFromResourcesFontFile);
        }
        return typefaceCreateFromResourcesFontFile;
    }

    private static String createResourceUid(Resources resources, int i, String str, int i6, int i10) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i6 + '-' + i + '-' + i10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface findFromCache(Resources resources, int i, String str, int i6, int i10) {
        return sTypefaceCache.get(createResourceUid(resources, i, str, i6, i10));
    }

    private static Typeface getBestFontFromFamily(Context context, Typeface typeface, int i) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamily = typefaceCompatBaseImpl.getFontFamily(typeface);
        if (fontFamily == null) {
            return null;
        }
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, fontFamily, context.getResources(), i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface getSystemFontFamily(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
    
        return r0.build();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface getSystemFontFamilyWithFallback(androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry r9) {
        /*
            java.lang.String r0 = r9.getSystemFontFamilyName()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L11
            android.graphics.Typeface r0 = getSystemFontFamily(r0)
            if (r0 == 0) goto L11
            return r0
        L11:
            java.util.List r9 = r9.getRequests()
            int r0 = r9.size()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L2c
            java.lang.Object r9 = r9.get(r1)
            androidx.core.provider.FontRequest r9 = (androidx.core.provider.FontRequest) r9
            java.lang.String r9 = r9.getSystemFont()
            android.graphics.Typeface r9 = getSystemFontFamily(r9)
            return r9
        L2c:
            r0 = r1
        L2d:
            int r3 = r9.size()
            r4 = 0
            if (r0 >= r3) goto L48
            java.lang.Object r3 = r9.get(r0)
            androidx.core.provider.FontRequest r3 = (androidx.core.provider.FontRequest) r3
            java.lang.String r3 = r3.getSystemFont()
            android.graphics.Typeface r3 = getSystemFontFamily(r3)
            if (r3 != 0) goto L45
            return r4
        L45:
            int r0 = r0 + 1
            goto L2d
        L48:
            r0 = r4
        L49:
            int r3 = r9.size()
            if (r1 >= r3) goto Ldc
            java.lang.Object r3 = r9.get(r1)
            androidx.core.provider.FontRequest r3 = (androidx.core.provider.FontRequest) r3
            int r5 = r9.size()
            int r5 = r5 - r2
            if (r1 != r5) goto L6e
            java.lang.String r5 = r3.getVariationSettings()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L6e
            java.lang.String r9 = r3.getSystemFont()
            r0.setSystemFallback(r9)
            goto Ldc
        L6e:
            java.lang.String r5 = r3.getSystemFont()
            android.graphics.Typeface r5 = getSystemFontFamily(r5)
            android.graphics.fonts.Font r5 = guessPrimaryFont(r5)
            java.lang.String r6 = "TypefaceCompat"
            if (r5 != 0) goto L99
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable identify the primary font for "
            r9.<init>(r0)
            java.lang.String r0 = r3.getSystemFont()
            r9.append(r0)
            java.lang.String r0 = ". Falling back to provider font."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            android.util.Log.w(r6, r9)
            return r4
        L99:
            java.lang.String r7 = r3.getVariationSettings()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto Lc4
            android.graphics.fonts.FontFamily$Builder r7 = new android.graphics.fonts.FontFamily$Builder     // Catch: java.io.IOException -> Lbe
            android.graphics.fonts.Font$Builder r8 = new android.graphics.fonts.Font$Builder     // Catch: java.io.IOException -> Lbe
            r8.<init>(r5)     // Catch: java.io.IOException -> Lbe
            java.lang.String r3 = r3.getVariationSettings()     // Catch: java.io.IOException -> Lbe
            android.graphics.fonts.Font$Builder r3 = r8.setFontVariationSettings(r3)     // Catch: java.io.IOException -> Lbe
            android.graphics.fonts.Font r3 = r3.build()     // Catch: java.io.IOException -> Lbe
            r7.<init>(r3)     // Catch: java.io.IOException -> Lbe
            android.graphics.fonts.FontFamily r3 = r7.build()     // Catch: java.io.IOException -> Lbe
            goto Lcd
        Lbe:
            java.lang.String r9 = "Failed to clone Font instance. Fall back to provider font."
            android.util.Log.e(r6, r9)
            return r4
        Lc4:
            android.graphics.fonts.FontFamily$Builder r3 = new android.graphics.fonts.FontFamily$Builder
            r3.<init>(r5)
            android.graphics.fonts.FontFamily r3 = r3.build()
        Lcd:
            if (r0 != 0) goto Ld5
            android.graphics.Typeface$CustomFallbackBuilder r0 = new android.graphics.Typeface$CustomFallbackBuilder
            r0.<init>(r3)
            goto Ld8
        Ld5:
            r0.addCustomFallback(r3)
        Ld8:
            int r1 = r1 + 1
            goto L49
        Ldc:
            android.graphics.Typeface r9 = r0.build()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompat.getSystemFontFamilyWithFallback(androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry):android.graphics.Typeface");
    }

    @RequiresApi(31)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Font guessPrimaryFont(Typeface typeface) {
        if (sCachedPaint == null) {
            sCachedPaint = new Paint();
        }
        sCachedPaint.setTextSize(10.0f);
        sCachedPaint.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, sCachedPaint);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface findFromCache(Resources resources, int i, int i6) {
        return findFromCache(resources, i, null, 0, i6);
    }

    public static Typeface create(Context context, Typeface typeface, @IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID, to = 1000) int i, boolean z10) {
        if (context != null) {
            Preconditions.checkArgumentInRange(i, 1, 1000, "weight");
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            return sTypefaceCompatImpl.createWeightStyle(context, typeface, i, z10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i6) {
        return createFromResourcesFontFile(context, resources, i, str, 0, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, int i6, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z10) {
        return createFromResourcesFamilyXml(context, familyResourceEntry, resources, i, null, 0, i6, fontCallback, handler, z10);
    }
}
