package com.bytedance.bdinstall.a;

/* JADX INFO: compiled from: CallbackWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<Event, Listener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Listener f6109a;

    c(Listener r1) {
        this.f6109a = r1;
    }

    Listener a() {
        return this.f6109a;
    }
}
