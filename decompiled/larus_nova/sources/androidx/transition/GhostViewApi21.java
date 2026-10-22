package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class GhostViewApi21 implements GhostViewImpl {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // androidx.transition.GhostViewImpl
    public void reserveEndViewTransition(ViewGroup r100, View r101) {
    }

    private static void fetchAddGhostMethod() {
        if (sAddGhostMethodFetched == false) goto L9;
        return;
    L9:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L8
        Method r100 = sGhostViewClass.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});     // Catch: NoSuchMethodException -> L8
        sAddGhostMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sAddGhostMethodFetched = true;
    }

    private static void fetchGhostViewClass() {
        if (sGhostViewClassFetched == true) goto L10;
        sGhostViewClass = INVOKESTATIC_androidx_transition_GhostViewApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.GhostView");     // Catch: ClassNotFoundException -> L7
    L5:
        sGhostViewClassFetched = true;
        return;
    }

    private static void fetchRemoveGhostMethod() {
        if (sRemoveGhostMethodFetched == false) goto L9;
        return;
    L9:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L8
        Method r100 = sGhostViewClass.getDeclaredMethod("removeGhost", new Class[]{View.class});     // Catch: NoSuchMethodException -> L8
        sRemoveGhostMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sRemoveGhostMethodFetched = true;
    }

    private GhostViewApi21(View r100) {
        this.mGhostView = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_transition_GhostViewApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void removeGhost(View r100) {
        fetchRemoveGhostMethod();
        Method r101 = sRemoveGhostMethod;
        if (r101 != null) goto L12;
        return;
    L12:
        r101.invoke(null, new Object[]{r100});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @Override // androidx.transition.GhostViewImpl
    public void setVisibility(int r100) {
        this.mGhostView.setVisibility(r100);
    }

    public static GhostViewImpl addGhost(View r100, ViewGroup r101, Matrix r102) {
        fetchAddGhostMethod();
        Method r103 = sAddGhostMethod;
        if (r103 != null) goto L11;
    L9:
        return null;
    L11:
        return new GhostViewApi21((View) r103.invoke(null, new Object[]{r100, r101, r102}));
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }
}
