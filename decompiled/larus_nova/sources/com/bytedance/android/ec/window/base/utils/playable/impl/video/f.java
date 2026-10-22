package com.bytedance.android.ec.window.base.utils.playable.impl.video;

import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public abstract class f<SOURCE> implements tp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f49760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f49761b;

    public static final class a {
    }

    static {
    }

    @Override // tp.c
    public final void pausePlay() {
        v();
        M();
    }

    @Override // tp.c
    public final boolean resumePlay() {
        boolean r100 = g0();
        U0();
        return r100;
    }

    @Override // tp.c
    public final void startPlay() {
        R();
        x();
    }

    @Override // tp.c
    public final void stopPlay() {
        B();
        z();
    }

    @Override // tp.c
    public final void M() {
        tp.c.a.a(this);
    }

    @Override // tp.c
    public final WindowPlayAbleType P() {
        return WindowPlayAbleType.VIDEO;
    }

    @Override // tp.c
    public final void U0() {
        tp.c.a.b(this);
    }

    @Override // tp.c
    public final void x() {
        tp.c.a.c(this);
    }

    @Override // tp.c
    public final void z() {
        tp.c.a.d(this);
    }

    public f(Function0<Boolean> r100) {
        this.f49761b = r100;
    }
}
