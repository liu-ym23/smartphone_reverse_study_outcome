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
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f70071a = null;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.music.download.k$a$a, reason: collision with other inner class name */
        public static final class C1141a<T> implements ObservableOnSubscribe {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f70072a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WeakReference f70073b;

            public C1141a(c r100, WeakReference r101) {
                this.f70072a = r100;
                this.f70073b = r101;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<Object> r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                a r101 = k.f70071a;
                c r102 = this.f70072a;
                WeakReference r103 = this.f70073b;
                r101.getClass();
                DownloadTask r104 = Downloader.with(s1.getContext()).url(r102.f70075b).name(h.c(r102.f70076c)).savePath(h.f(r102.f70076c)).monitorScene("musicpack_midi");
                Class r105 = a.a();     // Catch: Exception -> L5
                Object r106 = r105.newInstance();     // Catch: Exception -> L5
                Method r107 = r105.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L5
                r107.setAccessible(true);     // Catch: Exception -> L5
                r107.invoke(r106, new Object[]{Integer.valueOf(AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_AGE)});     // Catch: Exception -> L5
            L7:
                Ref.IntRef r108 = new Ref.IntRef();
                r108.element = r104.getDownloadId();
                r104.subThreadListener(new l(r103, r102, r108)).download();
                return;
            L5:
                e = move-exception;
                String r109 = "set cache life time max fail : " + e.getMessage();
                ALogger.i(bb0.b.b(), r109 + ", invoke class :" + a.class.getSimpleName());
                goto L7
            }
        }

        public a() {
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

        public static void b(c r100, WeakReference r101) {
            Intrinsics.checkNotNullParameter(r100, "info");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Observable.create(new C1141a(r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        }
    }

    public interface b {
        void a(long r100, String r101, int r102);

        void onFailed(String r100, int r101);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f70074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f70075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f70076c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (this.f70074a == r101.f70074a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f70075b, r101.f70075b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f70076c, r101.f70076c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f70074a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f70075b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f70076c;
            if (r106 == null) goto L10;
            r103 = r106.hashCode();
        L10:
            return r105 + r103;
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "KtvMidiDownloadInfo(musicId=" + this.f70074a + ", url=" + this.f70075b + ", midiSavePath=" + this.f70076c + ")";
        }

        public c(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r102, "midiSavePath");
            this.f70074a = r100;
            this.f70075b = r101;
            this.f70076c = r102;
        }
    }

    static {
        f70071a = new a();
    }
}
