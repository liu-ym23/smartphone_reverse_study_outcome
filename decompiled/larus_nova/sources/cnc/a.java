package cnc;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile PThreadPoolExecutor f24587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile PThreadPoolExecutor f24588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f24589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f24590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f24591e;

    /* JADX INFO: renamed from: cnc.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0470a {
    }

    public static class b implements ThreadFactory {
        private b() {
        }

        public /* synthetic */ b(C0470a r100) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "VideoLiveManager-H");
            ThreadMethodProxy.setPriority(r101, a.access$200().f24592a);
            return r101;
        }
    }

    public static class c implements ThreadFactory {
        private c() {
        }

        public /* synthetic */ c(C0470a r100) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "VideoLiveManager-L");
            ThreadMethodProxy.setPriority(r101, a.access$300().f24592a);
            return r101;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f24593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24594c;

        public d() {
        }

        public static d newHighPriorityConfig() {
            d r100 = new d();
            r100.f24592a = 5;
            r100.f24593b = 1;
            r100.f24594c = 2;
            return r100;
        }

        public static d newLowPriorityConfig() {
            d r100 = new d();
            r100.f24592a = 4;
            r100.f24593b = 2;
            r100.f24594c = 4;
            return r100;
        }

        public void print() {
            com.ss.videoarch.liveplayer.log.c.d("GlobalLiveThreadPool", "ThreadPoolConfig, priority:" + this.f24592a + ", core:" + this.f24593b + ", max:" + this.f24594c);
        }
    }

    public a() {
    }

    public static /* synthetic */ d access$200() {
        return f24590d;
    }

    public static /* synthetic */ d access$300() {
        return f24591e;
    }

    public static ExecutorService getHighPriorityPool() {
        return f24587a;
    }

    public static ExecutorService getLowPriorityPool() {
        return f24588b;
    }

    public static boolean isInitialized() {
        return f24589c;
    }

    public static Future addHighPriorityTask(Runnable r100) {
        if (f24589c == false) goto L8;
        if (r100 != null) goto L7;
        return null;
    L7:
        return f24587a.submit(r100);
    L8:
        return null;
    }

    public static void init(String r110, int r111) {
        if (f24589c == false) goto L31;
        return;
    L31:
        JSONObject r100 = new JSONObject(r110);     // Catch: JSONException -> L26
        if (r100.has("live_sdk_use_global_threadpool") == false) goto L9;
        int r112 = r100.optInt("live_sdk_use_global_threadpool");     // Catch: JSONException -> L26
    L10:
        if (r112 != 0) goto L14;
        com.ss.videoarch.liveplayer.log.c.i("GlobalLiveThreadPool", "Not enable threadpool");
        return;
    L14:
        monitor-enter(a.class);
    L23:
        th = move-exception;
        throw th;
    L16:
        if (f24589c == true) goto L21;
        f24590d = d.newHighPriorityConfig();     // Catch: Throwable -> L23
        f24591e = d.newLowPriorityConfig();     // Catch: Throwable -> L23
        updateThreadPoolConfig(r100.optJSONObject("high"), f24590d);     // Catch: Throwable -> L23
        updateThreadPoolConfig(r100.optJSONObject("low"), f24591e);     // Catch: Throwable -> L23
        if (r111 <= 0) goto L20;
        int r113 = Math.min(10, Math.max(1, r111));     // Catch: Throwable -> L23
        d r101 = f24590d;     // Catch: Throwable -> L23
        r101.f24592a = Math.min(r101.f24592a, r113);     // Catch: Throwable -> L23
        d r102 = f24591e;     // Catch: Throwable -> L23
        r102.f24592a = Math.min(r102.f24592a, r113);     // Catch: Throwable -> L23
    L20:
        d r103 = f24590d;     // Catch: Throwable -> L23
        int r104 = r103.f24593b;     // Catch: Throwable -> L23
        int r105 = r103.f24594c;     // Catch: Throwable -> L23
        TimeUnit r114 = TimeUnit.SECONDS;     // Catch: Throwable -> L23
        C0470a r106 = null;
        f24587a = new PThreadPoolExecutor(r104, r105, 60, r114, new LinkedBlockingQueue(), new b(r106));     // Catch: Throwable -> L23
        d r107 = f24591e;     // Catch: Throwable -> L23
        f24588b = new PThreadPoolExecutor(r107.f24593b, r107.f24594c, 60, r114, new LinkedBlockingQueue(), new c(r106));     // Catch: Throwable -> L23
        f24589c = true;     // Catch: Throwable -> L23
    L21:
        monitor-exit(a.class);     // Catch: Throwable -> L23
        return;
    L9:
        r112 = 0;
    L26:
        e = move-exception;
        e.printStackTrace();
        com.ss.videoarch.liveplayer.log.c.e("GlobalLiveThreadPool", "init fail, input config is not valid json.");
    }

    private static void updateThreadPoolConfig(JSONObject r100, d r101) {
        if (r100 == null) goto L16;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.has("priority") == false) goto L9;
        r101.f24592a = r100.optInt("priority");
    L9:
        if (r100.has("core_size") == false) goto L12;
        r101.f24593b = r100.optInt("core_size");
    L12:
        if (r100.has(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE) == false) goto L14;
        r101.f24594c = r100.optInt(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE);
    L14:
        r101.print();
        return;
    }
}
