package a97;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.k;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.chameleon.GeckoConst;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends WandTrick.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WandTrick.a f2284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d97.c f2285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f2286e;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.common.jato.jit.JitBlock");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.common.jato.jit.JitBlock");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.common.jato.jit.JitBlock");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.common.jato.jit.JitBlock");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.common.jato.jit.JitBlock");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.common.jato.jit.JitBlock");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.common.jato.jit.JitBlock");
    }

    @Override // com.bytedance.reparo.core.WandTrick.a
    public final int a() throws Exception {
        if (Build.VERSION.SDK_INT < 24) goto L14;
        Method r100 = null;
        Class r101 = d();     // Catch: Throwable -> L9
        if (r101 != null) goto L21;
    L11:
        if (r100 == null) goto L14;
        k.e(GeckoConst.HOTFIX, "stop JitBlock");
        r100.invoke(r101, new Object[0]);
        goto L14
    L21:
        r101.getDeclaredMethod("lightJitBlockStart", new Class[0]);     // Catch: Throwable -> L18
        r100 = r101.getDeclaredMethod("lightJitBlockStop", new Class[0]);     // Catch: Throwable -> L18
    L10:
        k.e(GeckoConst.HOTFIX, "JitBlock class not found");
    L9:
        r101 = null;
    L14:
        if (this.f2284c.c() == false) goto L17;
        d97.c r102 = this.f2285d;
        r102.getClass();
        r102.f467622a = true;
        this.f2286e.d();
    L17:
        return this.f2284c.f267325a;
    }

    @Override // com.bytedance.reparo.core.WandTrick.a
    public final boolean b(int r100) {
        return this.f2284c.b(r100);
    }

    public c(WandTrick.a r100, d97.c r101, f r102) {
        this.f2284c = r100;
        this.f2285d = r101;
        this.f2286e = r102;
    }
}
