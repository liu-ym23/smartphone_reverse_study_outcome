package com.bytedance.android.live.xplay.basic;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f102839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f102840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f102841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f102842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f102843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Subject<com.bytedance.android.live.broadcastgame.api.xplay.g> f102844f;

    public static final class a {
    }

    static {
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f102839a == true) goto L9;
        ByteBuffer r100 = this.f102840b;
        if (r100 == null) goto L7;
        r100.clear();
    L7:
        this.f102840b = null;
        this.f102844f.onComplete();
        this.f102839a = true;
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f102839a;
    }

    public j(PublishSubject r100) {
        Intrinsics.checkNotNullParameter(r100, "frameSink");
        this.f102844f = r100;
        this.f102841c = 1000;
        this.f102842d = System.currentTimeMillis();
    }
}
