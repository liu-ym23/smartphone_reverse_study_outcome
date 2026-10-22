package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class<?> mFontFamily;
    protected final Constructor<?> mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Class<?> r0 = obtainFontFamily();     // Catch: Throwable -> L5
        Constructor<?> r1 = obtainFontFamilyCtor(r0);     // Catch: Throwable -> L5
        Method r2 = obtainAddFontFromAssetManagerMethod(r0);     // Catch: Throwable -> L5
        Method r3 = obtainAddFontFromBufferMethod(r0);     // Catch: Throwable -> L5
        Method r4 = obtainFreezeMethod(r0);     // Catch: Throwable -> L5
        Method r5 = obtainAbortCreationMethod(r0);     // Catch: Throwable -> L5
        Method r6 = obtainCreateFromFamiliesWithDefaultMethod(r0);     // Catch: Throwable -> L5
    L7:
        this.mFontFamily = r0;
        this.mFontFamilyCtor = r1;
        this.mAddFontFromAssetManager = r2;
        this.mAddFontFromBuffer = r3;
        this.mFreeze = r4;
        this.mAbortCreation = r5;
        this.mCreateFromFamiliesWithDefault = r6;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
        r0 = null;
        r1 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        r5 = null;
        r6 = null;
        goto L7
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager != null) goto L6;
        Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
    L6:
        if (this.mAddFontFromAssetManager == null) goto L8;
        return true;
    L8:
        return false;
    }

    private Object newFamily() {
        return this.mFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    private boolean addFontFromAssetManager(Context r3, Object r4, String r5, int r6, int r7, int r8, FontVariationAxis[] r9) {
        return ((Boolean) this.mAddFontFromAssetManager.invoke(r4, new Object[]{r3.getAssets(), r5, 0, false, Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8), r9})).booleanValue();
    L5:
        return false;
    }

    private boolean addFontFromBuffer(Object r3, ByteBuffer r4, int r5, int r6, int r7) {
        return ((Boolean) this.mAddFontFromBuffer.invoke(r3, new Object[]{r4, Integer.valueOf(r5), null, Integer.valueOf(r6), Integer.valueOf(r7)})).booleanValue();
    L5:
        return false;
    }

    protected Typeface createFromFamiliesWithDefault(Object r5) {
        Object r1 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r5);     // Catch: Throwable -> L5
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r1, -1, -1});
    L5:
        return null;
    }

    private boolean freeze(Object r3) {
        return ((Boolean) this.mFreeze.invoke(r3, new Object[0])).booleanValue();
    L5:
        return false;
    }

    private void abortCreation(Object r2) {
        this.mAbortCreation.invoke(r2, new Object[0]);     // Catch: Throwable -> L4
        return;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r11, FontResourcesParserCompat.FontFamilyFilesResourceEntry r12, Resources r13, int r14) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r15 = newFamily();
        if (r15 != null) goto L9;
        return null;
    L9:
        FontResourcesParserCompat.FontFileResourceEntry[] r16 = r12.getEntries();
        int r8 = r16.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L17;
        FontResourcesParserCompat.FontFileResourceEntry r0 = r16[r9];
        String r3 = r0.getFileName();
        int r4 = r0.getTtcIndex();
        int r5 = r0.getWeight();
        boolean r6 = r0.isItalic();
        if (addFontFromAssetManager(r11, r15, r3, r4, r5, r6 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(r0.getVariationSettings())) == false) goto L13;
        r9 = r9 + 1;
        goto L10
    L13:
        abortCreation(r15);
        return null;
    L17:
        if (freeze(r15) == true) goto L20;
        return null;
    L20:
        return createFromFamiliesWithDefault(r15);
    L5:
        return super.createFromFontFamilyFilesResourceEntry(r11, r12, r13, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r11, CancellationSignal r12, FontsContractCompat.FontInfo[] r13, int r14) {
        if (r13.length >= 1) goto L6;
        return null;
    L6:
        if (isFontFamilyPrivateAPIAvailable() == true) goto L25;
        FontsContractCompat.FontInfo r10 = findBestInfo(r13, r14);
        ParcelFileDescriptor r15 = r11.getContentResolver().openFileDescriptor(r10.getUri(), "r", r12);     // Catch: IOException -> L24
        if (r15 != null) goto L53;
        if (r15 == null) goto L12;
        r15.close();     // Catch: IOException -> L24
    L12:
        return null;
    L53:
        Typeface r16 = new Typeface.Builder(r15.getFileDescriptor()).setWeight(r10.getWeight()).setItalic(r10.isItalic()).build();     // Catch: Throwable -> L17
        if (r15 == null) goto L16;
        r15.close();     // Catch: IOException -> L24
    L16:
        return r16;
    L17:
        th = move-exception;
        if (r15 != null) goto L50;
    L23:
        throw th;     // Catch: IOException -> L24
    L50:
        r15.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        return null;
    L25:
        Map<Uri, ByteBuffer> r17 = TypefaceCompatUtil.readFontInfoIntoByteBuffer(r11, r13, r12);
        Object r18 = newFamily();
        if (r18 != null) goto L28;
        return null;
    L28:
        int r0 = r13.length;
        boolean r3 = false;
        int r9 = 0;
    L29:
        if (r9 >= r0) goto L39;
        FontsContractCompat.FontInfo r4 = r13[r9];
        ByteBuffer r5 = r17.get(r4.getUri());
        if (r5 == null) goto L38;
        if (addFontFromBuffer(r18, r5, r4.getTtcIndex(), r4.getWeight(), r4.isItalic() ? 1 : 0) == false) goto L35;
        r3 = true;
        goto L38
    L35:
        abortCreation(r18);
        return null;
    L38:
        r9 = r9 + 1;
        goto L29
    L39:
        if (r3 == true) goto L43;
        abortCreation(r18);
        return null;
    L43:
        if (freeze(r18) == true) goto L45;
        return null;
    L45:
        Typeface r19 = createFromFamiliesWithDefault(r18);
        if (r19 != null) goto L49;
        return null;
    L49:
        return Typeface.create(r19, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context r9, Resources r10, int r11, String r12, int r13) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r14 = newFamily();
        if (r14 != null) goto L10;
        return null;
    L10:
        if (addFontFromAssetManager(r9, r14, r12, 0, -1, -1, null) == true) goto L14;
        abortCreation(r14);
        return null;
    L14:
        if (freeze(r14) == true) goto L17;
        return null;
    L17:
        return createFromFamiliesWithDefault(r14);
    L5:
        return super.createFromResourcesFontFile(r9, r10, r11, r12, r13);
    }

    protected Class<?> obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor<?> obtainFontFamilyCtor(Class<?> r1) throws NoSuchMethodException {
        return r1.getConstructor(new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class<?> r3) throws NoSuchMethodException {
        return r3.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    protected Method obtainAddFontFromBufferMethod(Class<?> r3) throws NoSuchMethodException {
        return r3.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    protected Method obtainFreezeMethod(Class<?> r2) throws NoSuchMethodException {
        return r2.getMethod(FREEZE_METHOD, new Class[0]);
    }

    protected Method obtainAbortCreationMethod(Class<?> r2) throws NoSuchMethodException {
        return r2.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r4) throws NoSuchMethodException {
        Method r5 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r4, 1).getClass(), Integer.TYPE, Integer.TYPE});
        r5.setAccessible(true);
        return r5;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context r2, Typeface r3, int r4, boolean r5) {
        Typeface r0 = WeightTypefaceApi26.createWeightStyle(r3, r4, r5);     // Catch: RuntimeException -> L4
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return super.createWeightStyle(r2, r3, r4, r5);
    L4:
        r0 = null;
        goto L5
    }
}
