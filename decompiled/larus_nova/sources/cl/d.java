package cl;

import android.view.View;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24079a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f24080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static d f24081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f24082c = null;

        public a() {
        }

        static {
            f24082c = new a();
        }

        public static d b() {
            d r100 = f24081b;
            if (r100 == null) goto L5;
            return r100;
        L5:
            if (f24080a == true) goto L27;
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            Object r103 = a("com.bytedance.android.ec.local.impl.ECLocalService").newInstance();     // Catch: Throwable -> L13
            if ((r103 instanceof d) == true) goto L11;
            r103 = null;
        L11:
            Object r104 = Result.m9449constructorimpl((d) r103);     // Catch: Throwable -> L13
        L16:
            if (Result.m9452exceptionOrNullimpl(r104) == null) goto L19;
            f24080a = true;
        L19:
            if (Result.m9455isFailureimpl(r104) == true) goto L22;
            r101 = r104;
        L22:
            d r105 = (d) r101;
            f24081b = r105;
            return r105;
        L13:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        L27:
            return r100;
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
    }

    public static final class b {
        public static /* synthetic */ void a(d r100, String r101, String r102, Map r103, Throwable r104, ErrorType r105, int r106) {
            if ((r106 & 16) == 0) goto L5;
            r105 = ErrorType.DEFAULT;
        L5:
            r100.o(r101, r102, r105);
        }
    }

    static {
        f24079a = a.f24082c;
    }

    void a(String r100, Object r101, Function0 r102);

    void b();

    void c(View r100);

    void d(JSONObject r100);

    void e();

    void f();

    void g();

    void h(Map r100);

    void i();

    void j(String r100);

    void k();

    void l();

    void m();

    void n();

    void o(String r100, String r101, ErrorType r102);

    void p();

    void q();

    void r();
}
