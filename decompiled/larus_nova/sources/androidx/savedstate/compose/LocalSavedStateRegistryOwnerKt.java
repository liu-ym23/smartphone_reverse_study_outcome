package androidx.savedstate.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import t.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalSavedStateRegistryOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "savedstate-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LocalSavedStateRegistryOwnerKt {
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner = null;

    static {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        ClassLoader r102 = SavedStateRegistryOwner.class.getClassLoader();     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L17
        Method r103 = INVOKEVIRTUAL_androidx_savedstate_compose_LocalSavedStateRegistryOwnerKt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r102, "androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalSavedStateRegistryOwner", new Class[0]);     // Catch: Throwable -> L17
        Annotation[] r104 = r103.getAnnotations();     // Catch: Throwable -> L17
        int r105 = r104.length;     // Catch: Throwable -> L17
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L9;
        if ((r104[r106] instanceof Deprecated) == true) goto L7;
        r106 = r106 + 1;     // Catch: Throwable -> L17
        goto L4
    L7:
        boolean r107 = true;
    L10:
        if (r107 == false) goto L12;
    L11:
        ProvidableCompositionLocal r108 = null;
    L15:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r109) == true) goto L23;
        r100 = r109;
    L23:
        ProvidableCompositionLocal<SavedStateRegistryOwner> r110 = (ProvidableCompositionLocal) r100;
        if (r110 != null) goto L26;
        r110 = CompositionLocalKt.staticCompositionLocalOf(new a());
    L26:
        LocalSavedStateRegistryOwner = r110;
        return;
    L12:
        Object r111 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L17
        if ((r111 instanceof ProvidableCompositionLocal) == false) goto L11;
        r108 = (ProvidableCompositionLocal) r111;     // Catch: Throwable -> L17
        goto L15
    L9:
        r107 = false;
    L17:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static /* synthetic */ SavedStateRegistryOwner a() {
        return LocalSavedStateRegistryOwner$lambda$3$lambda$2();
    }

    private static final SavedStateRegistryOwner LocalSavedStateRegistryOwner$lambda$3$lambda$2() {
        throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present".toString());
    }

    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwner;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_androidx_savedstate_compose_LocalSavedStateRegistryOwnerKt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
