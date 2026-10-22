package com.bytedance.android.livesdk.slideuptip;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveSlideUpTipsGuideStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f158367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f158368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f158369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f158370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f158371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f158372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ILiveRoomListProvider f158373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f158374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f158375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f158376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f158377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long[] f158378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f158379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f158380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.livesdk.slideuptip.a f158381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f158382p;

    public static final class a {
    }

    static {
    }

    public final String a() {
        com.bytedance.android.livesdk.slideuptip.a r100 = this.f158381o;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.slideGuideText;
    }

    public LiveSlideUpTipsGuideStrategy() {
        this.f158372f = new Handler(Looper.getMainLooper());
        this.f158374h = new CompositeDisposable();
        this.f158376j = true;
        this.f158378l = new long[8];
        this.f158379m = LazyKt.lazy(LiveSlideUpTipsGuideStrategy$enableNotify$2.INSTANCE);
    }

    public static void b(String r100) {
        ALogger.i("LiveSlideUpTipsGuideStrategy", r100);
    }

    public final void c(String r100) {
        this.f158381o = null;
        this.f158374h.clear();
        this.f158372f.removeCallbacksAndMessages(null);
        b("resetStatus ".concat(r100));
    }
}
