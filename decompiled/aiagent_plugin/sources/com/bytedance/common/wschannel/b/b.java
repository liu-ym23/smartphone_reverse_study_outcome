package com.bytedance.common.wschannel.b;

/* JADX INFO: compiled from: ConnectEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f6774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6775c;

    public b(c r1, a r2, int r3) {
        this.f6774b = r1;
        this.f6773a = r2;
        this.f6775c = r3;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.f6773a + ", connectionState=" + this.f6774b + ", mChannelId=" + this.f6775c + '}';
    }
}
