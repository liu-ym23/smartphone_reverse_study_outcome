package com.bytedance.android.livesdk.feed.tab.repository;

import android.os.SystemClock;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class l implements com.bytedance.android.livesdk.feed.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f124499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f124500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedTabMonitor f124501c;

    @Override // com.bytedance.android.livesdk.feed.j
    public final List<com.bytedance.android.livesdk.feed.feed.e> c() {
        return this.f124499a.b();
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final Observable<List<com.bytedance.android.livesdk.feed.feed.e>> e() {
        FeedTabMonitor r100 = this.f124501c;
        r100.getClass();
        r100.f124482a = SystemClock.uptimeMillis();
        return Observable.concat(Observable.create(new a(this)), Observable.create(new c(this)));
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final com.bytedance.android.livesdk.feed.feed.f getExtra() {
        return this.f124499a.getExtra();
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final Observable<List<com.bytedance.android.livesdk.feed.feed.e>> a(final FeedTabMonitor.Action r100) {
        FeedTabMonitor r101 = this.f124501c;
        r101.getClass();
        r101.f124482a = SystemClock.uptimeMillis();
        return this.f124500b.a().map(new d(this)).doOnNext(new e(this, r100)).doOnError(new f(this, r100));
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final boolean b(long r100) {
        com.bytedance.android.livesdk.feed.feed.e r101 = d(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.c() <= 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final com.bytedance.android.livesdk.feed.feed.e d(long r100) {
        return this.f124499a.f(r100);
    }

    public l(s r100, r r101) {
        this.f124501c = new FeedTabMonitor();
        this.f124499a = r100;
        this.f124500b = r101;
    }
}
