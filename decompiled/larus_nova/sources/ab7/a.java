package ab7;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f2498a;

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter");
    }

    public static b b() {
        if (f2498a != null) goto L18;
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f2498a == null) goto L19;
    L12:
        monitor-exit(a.class);     // Catch: Throwable -> L14
        goto L18
    L19:
        f2498a = (b) a().newInstance();     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return f2498a;
    }

    public static Object c(Object... r100) {
        if (TextUtils.isEmpty("CookieManager") == false) goto L5;
    L21:
        return null;
    L5:
        if (TextUtils.isEmpty("getCookie") == true) goto L21;
        if (b() == null) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        CookieManager r102 = CookieManager.getInstance();     // Catch: Throwable -> L19
        if (r102 == null) goto L21;
        return r102.getCookie((String) r100[0]);
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    L13:
        return b().a();
    L10:
        r101 = false;
        goto L11
    }

    public static void startActivityForResult(String r100, Activity r101, Intent r102, int r103) {
        if (b() == null) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        b().startActivityForResult(r100, r101, r102, r103);
        return;
    L8:
        r101.startActivityForResult(r102, r103);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
