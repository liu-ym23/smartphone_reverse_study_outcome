package com.bytedance.android.livesdk.livecommerce.utils;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/* JADX INFO: loaded from: classes10.dex */
public final class x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile x0 f153121b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subject<Object> f153122a;

    public static x0 a() {
        if (f153121b != null) goto L15;
        monitor-enter(x0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f153121b != null) goto L9;
        f153121b = new x0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(x0.class);     // Catch: Throwable -> L11
    L15:
        return f153121b;
    }

    public x0() {
        this.f153122a = PublishSubject.create().toSerialized();
    }
}
