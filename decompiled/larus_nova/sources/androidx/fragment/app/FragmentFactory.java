package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = null;

    public FragmentFactory() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    static {
        sClassCacheMap = new SimpleArrayMap();
    }

    public static boolean isFragmentClass(ClassLoader r100, String r101) {
        return Fragment.class.isAssignableFrom(loadClass(r100, r101));
    L4:
        return false;
    }

    private static Class<?> loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> r102 = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new SimpleArrayMap();
        r102.put(r100, r103);
    L5:
        Class<?> r104 = r103.get(r101);
        if (r104 != null) goto L9;
        Class<?> r105 = INVOKESTATIC_androidx_fragment_app_FragmentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100);
        r103.put(r101, r105);
        return r105;
    L9:
        return r104;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader r100, String r101) {
        return loadClass(r100, r101);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r101 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r101 + ": make sure class name exists", e);
    }

    public Fragment instantiate(ClassLoader r100, String r101) {
        return loadFragmentClass(r100, r101).getConstructor(new Class[0]).newInstance(new Object[0]);
    L11:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r101 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L14:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r101 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r101 + ": could not find Fragment constructor", e);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r101 + ": calling Fragment constructor caused an exception", e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_fragment_app_FragmentFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
