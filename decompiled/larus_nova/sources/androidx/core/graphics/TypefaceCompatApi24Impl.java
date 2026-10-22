package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle = null;
    private static final Method sCreateFromFamiliesWithDefault = null;
    private static final Class<?> sFontFamily = null;
    private static final Constructor<?> sFontFamilyCtor = null;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        Class<?> r100 = INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi24Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L4
        Constructor<?> r101 = r100.getConstructor(new Class[0]);     // Catch: Throwable -> L4
        Class<?> r102 = Integer.TYPE;     // Catch: Throwable -> L4
        Method r103 = r100.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{ByteBuffer.class, r102, List.class, r102, Boolean.TYPE});     // Catch: Throwable -> L4
        Method r104 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r100, 1).getClass()});     // Catch: Throwable -> L4
    L5:
        sFontFamilyCtor = r101;
        sFontFamily = r100;
        sAddFontWeightStyle = r103;
        sCreateFromFamiliesWithDefault = r104;
        return;
    L4:
        r100 = null;
        r104 = null;
        r101 = null;
        r103 = null;
        goto L5
    }

    public static boolean isUsable() {
        if (sAddFontWeightStyle == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static Object newFamily() {
        return sFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    public TypefaceCompatApi24Impl() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_graphics_TypefaceCompatApi24Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
        Object r101 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r101, 0, r100);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r101});
    L5:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r100, FontResourcesParserCompat.FontFamilyFilesResourceEntry r101, Resources r110, int r111) {
        Object r112 = newFamily();
        if (r112 != null) goto L5;
        return null;
    L5:
        FontResourcesParserCompat.FontFileResourceEntry[] r102 = r101.getEntries();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r105 = r102[r104];
        ByteBuffer r106 = TypefaceCompatUtil.copyToDirectBuffer(r100, r110, r105.getResourceId());
        if (r106 == null) goto L9;
        if (addFontWeightStyle(r112, r106, r105.getTtcIndex(), r105.getWeight(), r105.isItalic()) == false) goto L12;
        r104 = r104 + 1;
        goto L6
    L12:
        return null;
    L9:
        return null;
    L15:
        return createFromFamiliesWithDefault(r112);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r110, CancellationSignal r111, FontsContractCompat.FontInfo[] r112, int r113) {
        Object r100 = newFamily();
        if (r100 != null) goto L5;
        return null;
    L5:
        SimpleArrayMap r101 = new SimpleArrayMap();
        int r102 = r112.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L16;
        FontsContractCompat.FontInfo r104 = r112[r103];
        Uri r105 = r104.getUri();
        ByteBuffer r106 = (ByteBuffer) r101.get(r105);
        if (r106 != null) goto L10;
        r106 = TypefaceCompatUtil.mmap(r110, r111, r105);
        r101.put(r105, r106);
    L10:
        if (r106 == null) goto L11;
        if (addFontWeightStyle(r100, r106, r104.getTtcIndex(), r104.getWeight(), r104.isItalic()) == false) goto L14;
        r103 = r103 + 1;
        goto L6
    L14:
        return null;
    L11:
        return null;
    L16:
        Typeface r114 = createFromFamiliesWithDefault(r100);
        if (r114 != null) goto L20;
        return null;
    L20:
        return Typeface.create(r114, r113);
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

    private static boolean addFontWeightStyle(Object r100, ByteBuffer r101, int r102, int r103, boolean r104) {
        return ((Boolean) sAddFontWeightStyle.invoke(r100, new Object[]{r101, Integer.valueOf(r102), null, Integer.valueOf(r103), Boolean.valueOf(r104)})).booleanValue();
    L5:
        return false;
    }
}
