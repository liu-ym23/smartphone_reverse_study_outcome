package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f62461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f62462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f62463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f62464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f62465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f62466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f62467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f62468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Subject<com.bytedance.android.live.broadcastgame.api.xplay.g> f62469i;

    public static final class a {
    }

    static {
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f62461a == true) goto L9;
        ByteBuffer r100 = this.f62464d;
        if (r100 == null) goto L7;
        r100.clear();
    L7:
        this.f62464d = null;
        this.f62469i.onComplete();
        this.f62461a = true;
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f62461a;
    }

    public t(PublishSubject r100) {
        Intrinsics.checkNotNullParameter(r100, "frameSink");
        this.f62469i = r100;
        this.f62463c = true;
        this.f62465e = 1000;
        this.f62466f = System.currentTimeMillis();
    }
}
