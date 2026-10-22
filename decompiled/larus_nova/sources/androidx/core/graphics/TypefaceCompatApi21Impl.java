package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import f06.b;
import f06.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle;
    private static Method sCreateFromFamiliesWithDefault;
    private static Class<?> sFontFamily;
    private static Constructor<?> sFontFamilyCtor;
    private static boolean sHasInitBeenCalled;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ Typeface access$001(File r100) {
        return Typeface.createFromFile(r100);
    }

    private static void init() {
        if (sHasInitBeenCalled == false) goto L5;
        return;
    L5:
        sHasInitBeenCalled = true;
        Class<?> r100 = INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi21Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L8
        Constructor<?> r101 = r100.getConstructor(new Class[0]);     // Catch: Throwable -> L8
        Method r102 = r100.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L8
        Method r103 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r100, 1).getClass()});     // Catch: Throwable -> L8
    L9:
        sFontFamilyCtor = r101;
        sFontFamily = r100;
        sAddFontWeightStyle = r102;
        sCreateFromFamiliesWithDefault = r103;
        return;
    L8:
        r100 = null;
        r103 = null;
        r101 = null;
        r102 = null;
        goto L9
    }

    private static Object newFamily() {
        init();
        return sFontFamilyCtor.newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public TypefaceCompatApi21Impl() {
    }

    public static Typeface INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi21Impl_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(File r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L15;
        String r101 = r100.getPath();
        if (r101 == null) goto L15;
        if (TypeFaceLancet.cache.contains(r101) == true) goto L9;
        Typeface r102 = access$001(r100);
        if (r102 == null) goto L15;
        TypeFaceLancet.cache.put(r101, r102);
        return r102;
    L9:
        return (Typeface) TypeFaceLancet.cache.get(r101);
    L15:
        return access$001(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi21Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static Typeface createFromFamiliesWithDefault(Object r100) {
        init();
        Object r101 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5 IllegalAccessException -> L7
        Array.set(r101, 0, r100);     // Catch: Throwable -> L5 IllegalAccessException -> L7
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r101});
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private File getFile(ParcelFileDescriptor r100) {
        String r101 = Os.readlink("/proc/self/fd/" + r100.getFd());     // Catch: ErrnoException -> L8
        if (OsConstants.S_ISREG(Os.stat(r101).st_mode) == false) goto L7;
        return new File(r101);
    L7:
        return null;
    }

    private static boolean addFontWeightStyle(Object r100, String r101, int r102, boolean r103) {
        init();
        return ((Boolean) sAddFontWeightStyle.invoke(r100, new Object[]{r101, Integer.valueOf(r102), Boolean.valueOf(r103)})).booleanValue();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static ParcelFileDescriptor androidx_core_graphics_TypefaceCompatApi21Impl_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210, CancellationSignal r211) {
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

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r100, FontResourcesParserCompat.FontFamilyFilesResourceEntry r101, Resources r110, int r111) {
        Object r112 = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] r102 = r101.getEntries();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L22;
        FontResourcesParserCompat.FontFileResourceEntry r105 = r102[r104];
        File r106 = TypefaceCompatUtil.getTempFile(r100);
        if (r106 == null) goto L6;
    L19:
        r106.delete();
        return null;
    L16:
        th = move-exception;
        r106.delete();
        throw th;
    L8:
        if (TypefaceCompatUtil.copyToFile(r106, r110, r105.getResourceId()) == false) goto L9;
        if (addFontWeightStyle(r112, r106.getPath(), r105.getWeight(), r105.isItalic()) == false) goto L13;
        r106.delete();
        r104 = r104 + 1;
        goto L3
    L13:
        r106.delete();
        return null;
    L9:
        r106.delete();
        return null;
    L6:
        return null;
    L22:
        return createFromFamiliesWithDefault(r112);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r100, CancellationSignal r101, FontsContractCompat.FontInfo[] r102, int r103) {
        if (r102.length >= 1) goto L5;
        return null;
    L5:
        FontsContractCompat.FontInfo r104 = findBestInfo(r102, r103);
        ContentResolver r105 = r100.getContentResolver();
        ParcelFileDescriptor r106 = androidx_core_graphics_TypefaceCompatApi21Impl_android_content_ContentResolver_openFileDescriptor(r105, r104.getUri(), "r", r101);     // Catch: IOException -> L36
        if (r106 != null) goto L37;
        if (r106 == null) goto L10;
        r106.close();     // Catch: IOException -> L36
    L10:
        return null;
    L37:
        File r107 = getFile(r106);     // Catch: Throwable -> L30
        if (r107 != null) goto L14;
    L19:
        FileInputStream r108 = new FileInputStream(r106.getFileDescriptor());     // Catch: Throwable -> L30
        Typeface r109 = super.createFromInputStream(r100, r108);     // Catch: Throwable -> L24
        r108.close();     // Catch: Throwable -> L30
        r106.close();     // Catch: IOException -> L36
        return r109;
    L24:
        th = move-exception;
        r108.close();     // Catch: Throwable -> L27
    L29:
        throw th;     // Catch: Throwable -> L30
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L30
        goto L29
    L14:
        if (r107.canRead() == false) goto L19;
        Typeface r110 = INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi21Impl_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(r107);     // Catch: Throwable -> L30
        r106.close();     // Catch: IOException -> L36
        return r110;
    L30:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: IOException -> L36
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L36
    L36:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createWeightStyle(Context r100, Typeface r101, int r102, boolean r103) {
        Typeface r104 = WeightTypefaceApi21.createWeightStyle(r101, r102, r103);     // Catch: RuntimeException -> L4
    L5:
        if (r104 == null) goto L7;
        return r104;
    L7:
        return super.createWeightStyle(r100, r101, r102, r103);
    L4:
        r104 = null;
        goto L5
    }
}
