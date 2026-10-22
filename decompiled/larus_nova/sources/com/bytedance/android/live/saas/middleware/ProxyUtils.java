package com.bytedance.android.live.saas.middleware;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.push.PushClientConstants;
import el9.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR2\u0010\u0003\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/ProxyUtils;", "", "()V", "mCacheMaps", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, PushClientConstants.TAG_CLASS_NAME, "(Ljava/lang/String;)Ljava/lang/Object;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class ProxyUtils {
    public static final ProxyUtils INSTANCE = null;
    private static final HashMap<String, WeakReference<?>> mCacheMaps = null;

    private ProxyUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        INSTANCE = new ProxyUtils();
        mCacheMaps = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_saas_middleware_ProxyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public final synchronized <T> T get(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);     // Catch: Throwable -> L19
        T r101 = null;
        HashMap<String, WeakReference<?>> r102 = mCacheMaps;     // Catch: Exception -> L15 Throwable -> L19
        WeakReference<?> r103 = r102.get(r100);     // Catch: Exception -> L15 Throwable -> L19
        if (r103 == null) goto L8;
        Object r104 = r103.get();     // Catch: Exception -> L15 Throwable -> L19
    L10:
        if ((r104 instanceof Object) == true) goto L12;
        r104 = null;
    L12:
        if (r104 != null) goto L14;
        r104 = INVOKESTATIC_com_bytedance_android_live_saas_middleware_ProxyUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();     // Catch: Exception -> L15 Throwable -> L19
        r102.put(r100, new WeakReference(r104));     // Catch: Exception -> L15 Throwable -> L19
    L14:
        r101 = (T) r104;
    L17:
        monitor-exit(this);
        return r101;
    L8:
        r104 = null;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
