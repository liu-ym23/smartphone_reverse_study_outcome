package com.bytedance.android.livesdk.interactivity.service.messagelist;

import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f140895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<Integer> f140896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f140897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishSubject<Integer> f140898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IMessageListManager.b f140899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f140900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f140901g;

    public l() {
        this.f140896b = PublishSubject.create();
        this.f140897c = -1;
        this.f140898d = PublishSubject.create();
        this.f140901g = true;
    }

    public final void a(int r100) {
        if (r100 != this.f140895a) goto L5;
        return;
    L5:
        this.f140895a = r100;
        this.f140896b.onNext(Integer.valueOf(r100));
    }

    public final void onEvent(IMessageListManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getType() != IMessageListManager.MessageChangeType.INSERT_BOTTOM) goto L12;
        c r101 = r100.f140857e;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.a() != true) goto L14;
        this.f140900f = System.currentTimeMillis();
        if (this.f140901g == false) goto L15;
        a(this.f140895a + 1);
        return;
    L15:
        return;
    L14:
        return;
    }
}
