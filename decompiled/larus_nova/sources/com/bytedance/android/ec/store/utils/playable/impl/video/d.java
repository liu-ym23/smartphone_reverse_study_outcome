package com.bytedance.android.ec.store.utils.playable.impl.video;

import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d<SOURCE> implements ln.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f48686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f48687b;

    public static final class a {
    }

    static {
    }

    @Override // ln.c
    public final void pausePlay() {
        ((b) this).v();
        M();
    }

    @Override // ln.c
    public final void startPlay() {
        ((b) this).R();
        x();
    }

    @Override // ln.c
    public final void stopPlay() {
        ((b) this).B();
        z();
    }

    @Override // ln.c
    public final void M() {
        ln.c.a.a(this);
    }

    @Override // ln.c
    public final PlayAbleType P() {
        return PlayAbleType.VIDEO;
    }

    @Override // ln.c
    public final void x() {
        ln.c.a.b(this);
    }

    @Override // ln.c
    public final void z() {
        ln.c.a.c(this);
    }

    public d(Function0<Boolean> r100) {
        this.f48687b = r100;
    }
}
