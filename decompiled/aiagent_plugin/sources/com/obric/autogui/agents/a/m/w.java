package com.obric.autogui.agents.a.m;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ActionEffectTimingRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f26729d;

    public /* synthetic */ w(long r1, long r3, long r5, d.h.b.h r7) {
        this(r1, r3, r5);
    }

    private w(long r1, long r3, long r5) {
        this.f26726a = r1;
        this.f26727b = r3;
        this.f26728c = r5;
        this.f26729d = new AtomicBoolean(false);
    }

    public final long d() {
        return this.f26726a;
    }

    public final long e() {
        return this.f26727b;
    }

    public final long f() {
        return this.f26728c;
    }

    public final boolean g() {
        return this.f26729d.compareAndSet(false, true);
    }

    public final boolean h() {
        return this.f26729d.get();
    }
}
