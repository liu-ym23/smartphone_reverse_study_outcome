package com.bytedance.android.live.room.api.visibilitycontrol;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f99178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f99179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject f99180c;

    public final void a() {
        Disposable r100 = this.f99178a;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.dispose();
        return;
    }

    public f() {
        PublishSubject r100 = PublishSubject.create();
        this.f99179b = r100;
        this.f99180c = r100;
    }
}
