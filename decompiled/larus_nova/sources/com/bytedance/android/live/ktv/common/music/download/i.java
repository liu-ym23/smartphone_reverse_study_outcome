package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    public interface a {
        void a(long r100, int r101, String r102);

        void b(ub0.c r100);
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f70065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ub0.c f70066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f70067c;

        public b(i r100, ub0.c r101, a r102) {
            this.f70065a = r100;
            this.f70066b = r101;
            this.f70067c = r102;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Object> r110) {
            Intrinsics.checkNotNullParameter(r110, "it");
            i r111 = this.f70065a;
            ub0.c r100 = this.f70066b;
            a r101 = this.f70067c;
            r111.getClass();
            String r112 = r100.f549327d;
            long r102 = System.currentTimeMillis();
            DownloadTask r113 = Downloader.with(s1.getContext()).url(r100.f549324a).name(h.c(r112)).savePath(h.f(r112)).autoRemoveCallback(true).monitorScene("musicpack_lyrics");
            Class r103 = i.a();     // Catch: Exception -> L5
            Object r104 = r103.newInstance();     // Catch: Exception -> L5
            Method r105 = r103.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L5
            r105.setAccessible(true);     // Catch: Exception -> L5
            r105.invoke(r104, new Object[]{Integer.valueOf(AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_AGE)});     // Catch: Exception -> L5
        L7:
            r113.mainThreadListener(new j(r100, r102, r101)).download();
            return;
        L5:
            e = move-exception;
            String r106 = "set cache life time max fail : " + e.getMessage();
            ALogger.i(bb0.b.b(), r106 + ", invoke class :" + i.class.getSimpleName());
            goto L7
        }
    }

    public i() {
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

    public final void b(ub0.c r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "lyricsDownloadInfo");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Observable.create(new b(this, r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
    }
}
