package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes46.dex */
public final class VideoThemeDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f71682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, a> f71683b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f71684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> f71685b;

        public a(String r100, String r101, ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "id");
            Intrinsics.checkNotNullParameter(r102, "listeners");
            this.f71684a = r101;
            this.f71685b = r102;
        }
    }

    static {
        f71682a = LazyKt.lazy(VideoThemeDownloadManager$STORAGE_ROOT_DIR$2.INSTANCE);
        f71683b = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
    }

    public static String c() {
        StringBuilder r100 = new StringBuilder();
        r100.append((String) f71682a.getValue());
        String r101 = File.separator;
        r100.append(r101);
        r100.append("theme");
        r100.append(r101);
        r100.append("video");
        r100.append(r101);
        return r100.toString();
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoUrl");
        return c() + String.valueOf(r100.hashCode());
    }

    public static boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return new PolarisFileWrapper(d(r100)).exists();
    }

    public static void f(String r100, com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "downloadStateListener");
        HashMap<String, a> r102 = f71683b;
        if (r102.containsKey(r100) == false) goto L10;
        a r103 = r102.get(r100);
        if (r103 == null) goto L11;
        ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r104 = r103.f71685b;
        if (r104 == null) goto L12;
        r104.add(new WeakReference(r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void b(String r100, String r101, VideoThemeView.e r102) {
        boolean r103 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return;
    L11:
        HashMap<String, a> r105 = f71683b;
        if (r105.containsKey(r101) == false) goto L15;
        return;
    L15:
        if (e(r101) == false) goto L17;
        return;
    L17:
        if (r100 != null) goto L19;
    L22:
        if (r103 == false) goto L24;
        return;
    L24:
        r105.put(r101, new a(r100, r101, new ArrayList()));
        a r106 = r105.get(r101);
        if (r106 == null) goto L29;
        ArrayList<WeakReference<com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b>> r107 = r106.f71685b;
        if (r107 == null) goto L29;
        r107.add(new WeakReference(r102));
    L29:
        Downloader.with(s1.getContext()).url(r100).name(String.valueOf(r101.hashCode())).savePath(c()).subThreadListener(new g(r100, r101)).download();
        return;
    L19:
        if (r100.length() == 0) goto L22;
        r103 = false;
        goto L22
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
