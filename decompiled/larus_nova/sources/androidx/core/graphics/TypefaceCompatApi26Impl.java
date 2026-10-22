package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import f06.b;
import f06.d;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
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

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) goto L5;
        return true;
    L5:
        return false;
    }

    private Object newFamily() {
        return this.mFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    public Class<?> obtainFontFamily() throws ClassNotFoundException {
        return INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi26Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(FONT_FAMILY_CLASS);
    }

    public TypefaceCompatApi26Impl() {
        Class<?> r100 = obtainFontFamily();     // Catch: Throwable -> L5
        Constructor<?> r101 = obtainFontFamilyCtor(r100);     // Catch: Throwable -> L5
        Method r102 = obtainAddFontFromAssetManagerMethod(r100);     // Catch: Throwable -> L5
        Method r103 = obtainAddFontFromBufferMethod(r100);     // Catch: Throwable -> L5
        Method r104 = obtainFreezeMethod(r100);     // Catch: Throwable -> L5
        Method r105 = obtainAbortCreationMethod(r100);     // Catch: Throwable -> L5
        Method r106 = obtainCreateFromFamiliesWithDefaultMethod(r100);     // Catch: Throwable -> L5
    L6:
        this.mFontFamily = r100;
        this.mFontFamilyCtor = r101;
        this.mAddFontFromAssetManager = r102;
        this.mAddFontFromBuffer = r103;
        this.mFreeze = r104;
        this.mAbortCreation = r105;
        this.mCreateFromFamiliesWithDefault = r106;
        return;
    L5:
        r100 = null;
        r101 = null;
        r102 = null;
        r103 = null;
        r104 = null;
        r105 = null;
        r106 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi26Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private void abortCreation(Object r100) {
        this.mAbortCreation.invoke(r100, new Object[0]);     // Catch: Throwable -> L4
        return;
    }

    private boolean freeze(Object r100) {
        return ((Boolean) this.mFreeze.invoke(r100, new Object[0])).booleanValue();
    L5:
        return false;
    }

    public Typeface createFromFamiliesWithDefault(Object r100) {
        Object r101 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r101, 0, r100);     // Catch: Throwable -> L5
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r101, -1, -1});
    L5:
        return null;
    }

    public Method obtainAbortCreationMethod(Class<?> r100) throws NoSuchMethodException {
        return r100.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> r100) throws NoSuchMethodException {
        Class<?> r101 = Integer.TYPE;
        return r100.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, r101, Boolean.TYPE, r101, r101, r101, FontVariationAxis[].class});
    }

    public Method obtainAddFontFromBufferMethod(Class<?> r100) throws NoSuchMethodException {
        Class<?> r101 = Integer.TYPE;
        return r100.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, r101, FontVariationAxis[].class, r101, r101});
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r100) throws NoSuchMethodException {
        Class r101 = Integer.TYPE;
        Method r102 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r100, 1).getClass(), r101, r101});
        r102.setAccessible(true);
        return r102;
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> r100) throws NoSuchMethodException {
        return r100.getConstructor(new Class[0]);
    }

    public Method obtainFreezeMethod(Class<?> r100) throws NoSuchMethodException {
        return r100.getMethod(FREEZE_METHOD, new Class[0]);
    }

    private static ParcelFileDescriptor androidx_core_graphics_TypefaceCompatApi26Impl_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210, CancellationSignal r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
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

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r110, FontResourcesParserCompat.FontFamilyFilesResourceEntry r111, Resources r112, int r113) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r114 = newFamily();
        if (r114 != null) goto L9;
        return null;
    L9:
        FontResourcesParserCompat.FontFileResourceEntry[] r115 = r111.getEntries();
        int r100 = r115.length;
        int r101 = 0;
    L10:
        if (r101 >= r100) goto L17;
        FontResourcesParserCompat.FontFileResourceEntry r102 = r115[r101];
        String r103 = r102.getFileName();
        int r104 = r102.getTtcIndex();
        int r105 = r102.getWeight();
        boolean r106 = r102.isItalic();
        FontVariationAxis[] r107 = FontVariationAxis.fromFontVariationSettings(r102.getVariationSettings());
        if (addFontFromAssetManager(r110, r114, r103, r104, r105, r106 ? 1 : 0, r107) == false) goto L13;
        r101 = r101 + 1;
        goto L10
    L13:
        abortCreation(r114);
        return null;
    L17:
        if (freeze(r114) == true) goto L20;
        return null;
    L20:
        return createFromFamiliesWithDefault(r114);
    L5:
        return super.createFromFontFamilyFilesResourceEntry(r110, r111, r112, r113);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r110, CancellationSignal r111, FontsContractCompat.FontInfo[] r112, int r113) {
        if (r112.length >= 1) goto L6;
        return null;
    L6:
        if (isFontFamilyPrivateAPIAvailable() == true) goto L23;
        FontsContractCompat.FontInfo r114 = findBestInfo(r112, r113);
        ContentResolver r115 = r110.getContentResolver();
        ParcelFileDescriptor r116 = androidx_core_graphics_TypefaceCompatApi26Impl_android_content_ContentResolver_openFileDescriptor(r115, r114.getUri(), "r", r111);     // Catch: IOException -> L22
        if (r116 != null) goto L48;
        if (r116 == null) goto L12;
        r116.close();     // Catch: IOException -> L22
    L12:
        return null;
    L48:
        Typeface r117 = new Typeface.Builder(r116.getFileDescriptor()).setWeight(r114.getWeight()).setItalic(r114.isItalic()).build();     // Catch: Throwable -> L16
        r116.close();     // Catch: IOException -> L22
        return r117;
    L16:
        th = move-exception;
        r116.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        return null;
    L23:
        Map<Uri, ByteBuffer> r118 = TypefaceCompatUtil.readFontInfoIntoByteBuffer(r110, r112, r111);
        Object r119 = newFamily();
        if (r119 != null) goto L26;
        return null;
    L26:
        int r100 = r112.length;
        boolean r101 = false;
        int r102 = 0;
    L27:
        if (r102 >= r100) goto L37;
        FontsContractCompat.FontInfo r103 = r112[r102];
        ByteBuffer r104 = r118.get(r103.getUri());
        if (r104 == null) goto L36;
        if (addFontFromBuffer(r119, r104, r103.getTtcIndex(), r103.getWeight(), r103.isItalic() ? 1 : 0) == false) goto L33;
        r101 = true;
        goto L36
    L33:
        abortCreation(r119);
        return null;
    L36:
        r102 = r102 + 1;
        goto L27
    L37:
        if (r101 == true) goto L41;
        abortCreation(r119);
        return null;
    L41:
        if (freeze(r119) == true) goto L43;
        return null;
    L43:
        Typeface r120 = createFromFamiliesWithDefault(r119);
        if (r120 != null) goto L47;
        return null;
    L47:
        return Typeface.create(r120, r113);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public /* bridge */ /* synthetic */ Typeface createFromFontInfoWithFallback(Context r100, CancellationSignal r101, List r102, int r103) {
        return super.createFromFontInfoWithFallback(r100, r101, r102, r103);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createWeightStyle(Context r100, Typeface r101, int r102, boolean r103) {
        Typeface r104 = WeightTypefaceApi26.createWeightStyle(r101, r102, r103);     // Catch: RuntimeException -> L4
    L5:
        if (r104 == null) goto L7;
        return r104;
    L7:
        return super.createWeightStyle(r100, r101, r102, r103);
    L4:
        r104 = null;
        goto L5
    }

    private boolean addFontFromBuffer(Object r100, ByteBuffer r101, int r102, int r103, int r104) {
        return ((Boolean) this.mAddFontFromBuffer.invoke(r100, new Object[]{r101, Integer.valueOf(r102), null, Integer.valueOf(r103), Integer.valueOf(r104)})).booleanValue();
    L5:
        return false;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context r100, Resources r110, int r111, String r112, int r113) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r114 = newFamily();
        if (r114 != null) goto L10;
        return null;
    L10:
        if (addFontFromAssetManager(r100, r114, r112, 0, -1, -1, null) == true) goto L14;
        abortCreation(r114);
        return null;
    L14:
        if (freeze(r114) == true) goto L17;
        return null;
    L17:
        return createFromFamiliesWithDefault(r114);
    L5:
        return super.createFromResourcesFontFile(r100, r110, r111, r112, r113);
    }

    private boolean addFontFromAssetManager(Context r100, Object r101, String r102, int r103, int r104, int r105, FontVariationAxis[] r110) {
        return ((Boolean) this.mAddFontFromAssetManager.invoke(r101, new Object[]{r100.getAssets(), r102, 0, Boolean.FALSE, Integer.valueOf(r103), Integer.valueOf(r104), Integer.valueOf(r105), r110})).booleanValue();
    L5:
        return false;
    }
}
