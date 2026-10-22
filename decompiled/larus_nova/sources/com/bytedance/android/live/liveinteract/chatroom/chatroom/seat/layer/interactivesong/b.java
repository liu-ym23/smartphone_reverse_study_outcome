package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f72303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f72305c;

    public b() {
        this(null);
    }

    public abstract void a();

    public final String toString() {
        return "{type:" + getClass() + ",working:" + this.f72304b + ",token:" + this.f72305c + '}';
    }

    public b(Object r100) {
        this.f72305c = r100;
        this.f72304b = true;
    }
}
