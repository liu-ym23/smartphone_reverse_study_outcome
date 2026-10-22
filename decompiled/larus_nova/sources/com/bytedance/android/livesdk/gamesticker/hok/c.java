package com.bytedance.android.livesdk.gamesticker.hok;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f125588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f125589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f125590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f125591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0 f125592e;

    public c(d r100, long r101, Function0 r102, long r103, Function0 r104) {
        this.f125588a = r100;
        this.f125589b = r101;
        this.f125590c = r102;
        this.f125591d = r103;
        this.f125592e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f125588a.getClass();
        if (r101 != null) goto L6;
    L8:
        long r102 = this.f125591d + this.f125589b;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.longValue() != r102) goto L16;
        this.f125588a.getClass();
        this.f125592e.invoke();
        return;
    L16:
        return;
    L6:
        if (r101.longValue() != this.f125589b) goto L8;
        this.f125588a.getClass();
        this.f125590c.invoke();
    }
}
