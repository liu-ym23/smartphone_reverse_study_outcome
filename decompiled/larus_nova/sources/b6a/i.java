package b6a;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.lottieadapter.AnimationType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f17886a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<AnimationType, c> f17887b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f17888c;

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f17889a;

        public a(Class r100) {
            this.f17889a = r100;
        }

        @Override // b6a.c
        public final b6a.b create(Context r100) {
            return (b6a.b) this.f17889a.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r100});
        L4:
            e = move-exception;
            throw new RuntimeException("Failed to create adapter instance for ".concat(this.f17889a.getName()), e);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17890a = null;

        static {
            int[] r100 = new int[AnimationType.values().length];
            f17890a = r100;
            r100[AnimationType.LOTTIE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f17890a[AnimationType.ANIMAX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public i() {
    }

    static {
        f17886a = new k();
        f17887b = new ConcurrentHashMap();
        f17888c = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static void c(AnimationType r100) {
        int r101 = b.f17890a[r100.ordinal()];
        if (r101 != 1) goto L5;
        String r102 = "com.lynx.lottieadapter.LottieAdapterLottie";
    L12:
        a r103 = new a(a(r102));     // Catch: ClassNotFoundException -> L11
        ((ConcurrentHashMap) f17887b).put(r100, r103);     // Catch: ClassNotFoundException -> L11
        return;
    L14:
        return;
    L5:
        if (r101 == 2) goto L7;
        return;
    L7:
        r102 = "com.lynx.lottieadapter.LottieAdapterAnimaX";
        goto L12
    }

    public static b6a.b b(Context r100, k r101) {
        if (f17888c == false) goto L5;
    L14:
        Map<AnimationType, c> r102 = f17887b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        c r104 = (c) r103.get(r101.getType());
        if (r104 == null) goto L19;
        b6a.b r105 = r104.create(r100);
        r105.setOption(r101);
        return r105;
    L19:
        return new b6a.a();
    L5:
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f17888c == true) goto L9;
        c(AnimationType.LOTTIE);     // Catch: Throwable -> L11
        c(AnimationType.ANIMAX);     // Catch: Throwable -> L11
        f17888c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
        goto L14
    }
}
