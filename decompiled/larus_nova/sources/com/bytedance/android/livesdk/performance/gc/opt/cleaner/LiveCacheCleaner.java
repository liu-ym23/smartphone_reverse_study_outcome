package com.bytedance.android.livesdk.performance.gc.opt.cleaner;

import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.LiveMemCacheConfig;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveCacheCleaner {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f154626h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f154628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f154629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f154630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f154631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f154632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f154633g;

    public static final class a {
    }

    static {
    }

    public final LiveMemCacheConfig a() {
        return (LiveMemCacheConfig) this.f154632f.getValue();
    }

    public LiveCacheCleaner() {
        this.f154631e = "";
        this.f154632f = LazyKt.lazy(LiveCacheCleaner$config$2.INSTANCE);
        this.f154633g = LazyKt.lazy(new LiveCacheCleaner$mainHandler$2(this));
    }

    public final void b() {
        if (a().getEnableCleanWhenExit() == true) goto L6;
        return;
    L6:
        if (this.f154627a == false) goto L10;
        ALogger.w("LiveCacheCleaner", "cleanCacheWhenExit: mIsInLive is true");
        return;
    L10:
        if (a().getCleanActionsWhenExit() > 0) goto L12;
        return;
    L12:
        ALogger.i("LiveCacheCleaner", "postCleanCacheWhenExit: actions = " + a() + ".cleanActionsWhenExit");
        ((LiveCacheCleaner$mainHandler$2.a) this.f154633g.getValue()).sendMessage(Message.obtain((LiveCacheCleaner$mainHandler$2.a) this.f154633g.getValue(), 1001, 1, a().getCleanActionsWhenExit()));
    }
}
