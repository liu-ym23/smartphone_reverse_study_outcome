package com.bytedance.common.wschannel.event;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChannelType f7031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectionState f7032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7033c;

    public a(ConnectionState r10, ChannelType r11, int r12) {
        this.f7032b = r10;
        this.f7031a = r11;
        this.f7033c = r12;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.f7031a + ", connectionState=" + this.f7032b + ", mChannelId=" + this.f7033c + '}';
    }
}
