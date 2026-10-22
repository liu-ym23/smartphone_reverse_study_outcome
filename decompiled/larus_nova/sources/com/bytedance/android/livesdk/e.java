package com.bytedance.android.livesdk;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f123279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f123280d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<Boolean> f123281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observable<Boolean> f123282b;

    public static e b() {
        if (f123279c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f123279c != null) goto L9;
        f123279c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f123279c;
    }

    public static boolean c() {
        if (f123280d > 0) goto L8;
        f.d().getClass();
        if (f.e() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void a() {
        f123280d++;
        this.f123281a.onNext(Boolean.valueOf(c()));
    }

    public final void d() {
        f123280d--;
        if (f123280d >= 0) goto L6;
        f123280d = 0;
    L6:
        if (f123280d != 0) goto L9;
        this.f123281a.onNext(Boolean.valueOf(c()));
        return;
    }

    public e() {
        PublishSubject<Boolean> r100 = PublishSubject.create();
        this.f123281a = r100;
        this.f123282b = r100.observeOn(AndroidSchedulers.mainThread());
        Observer r101 = new d(this);
        f.d().f123392a.observeForever(r101);
    }
}
