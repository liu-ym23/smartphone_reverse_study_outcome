package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = null;
    static final FragmentTransitionImpl SUPPORT_IMPL = null;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        PLATFORM_IMPL = new FragmentTransitionCompat21();
        SUPPORT_IMPL = resolveSupportImpl();
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        return (FragmentTransitionImpl) INVOKESTATIC_androidx_fragment_app_FragmentTransition_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        return null;
    }

    public static boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }

    private FragmentTransition() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_fragment_app_FragmentTransition_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static String findKeyForValue(ArrayMap<String, String> r100, String r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.equals(r100.valueAt(r103)) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return r100.keyAt(r103);
    L9:
        return null;
    }

    public static void retainValues(ArrayMap<String, String> r100, ArrayMap<String, View> r101) {
        int r102 = r100.size() - 1;
    L3:
        if (r102 < 0) goto L8;
        if (r101.containsKey(r100.valueAt(r102)) == true) goto L7;
        r100.removeAt(r102);
    L7:
        r102 = r102 - 1;
        goto L3
    }

    public static void setViewVisibility(ArrayList<View> r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = r100.size() - 1;
    L5:
        if (r102 < 0) goto L7;
        ((View) ListProtector.get(r100, r102)).setVisibility(r101);
        r102 = r102 - 1;
        goto L5
    }

    public static void callSharedElementStartEnd(Fragment r100, Fragment r101, boolean r102, ArrayMap<String, View> r103, boolean r104) {
        if (r102 == false) goto L4;
        SharedElementCallback r105 = r101.getEnterTransitionCallback();
    L5:
        if (r105 == null) goto L19;
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        int r108 = 0;
        if (r103 != null) goto L9;
        int r109 = 0;
    L10:
        if (r108 >= r109) goto L13;
        r107.add(r103.keyAt(r108));
        r106.add(r103.valueAt(r108));
        r108 = r108 + 1;
        goto L10
    L13:
        if (r104 == false) goto L15;
        r105.onSharedElementStart(r107, r106, null);
        return;
    L15:
        r105.onSharedElementEnd(r107, r106, null);
        return;
    L9:
        r109 = r103.size();
        goto L10
    L19:
        return;
    L4:
        r105 = r100.getEnterTransitionCallback();
        goto L5
    }
}
