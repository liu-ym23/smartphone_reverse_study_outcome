package com.bytedance.android.livesdk.utils.ntp;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.bytedance.android.livesdk.utils.p6;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f159089c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f159090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Disposable f159091b;

    public static long a() {
        if (f159089c == null) goto L19;
        if (f159089c.f159090a == null) goto L19;
        if (f159089c.f159090a.f159097d == false) goto L19;
        f r100 = f159089c.f159090a;
        boolean r101 = r100.f159097d;
        if (r101 == false) goto L20;
        long r102 = r100.f159098e;
        if (r101 == false) goto L15;
        long r103 = SystemClock.elapsedRealtime() - r100.f159099f;
    L17:
        return r102 + r103;
    L15:
        r103 = Long.MAX_VALUE;
        goto L17
    L20:
        return p6.b();
    L19:
        return p6.b();
    }

    public e(Context r100) {
        String r101 = com.bytedance.android.livesdk.p6.f154194a.getValue();
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        monitor-enter(f.class);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (f.f159092g != null) goto L10;
        f.f159092g = new f(r101);     // Catch: Throwable -> L14
        f.f159093h = r100.getApplicationContext();     // Catch: Throwable -> L14
    L10:
        f r102 = f.f159092g;     // Catch: Throwable -> L14
        monitor-exit(f.class);
        this.f159090a = r102;
        this.f159091b = du2.a.d(60, TimeUnit.MINUTES).take(SieveCacheKt.NodeLinkMask).subscribeOn(Schedulers.computation()).map(new b()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(), new d());
    }

    public static void b(Context r100) {
        if (f159089c == null) goto L5;
        return;
    L5:
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f159089c != null) goto L9;
        f159089c = new e(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    }
}
