package com.bytedance.android.livesdk.chatroom.ui;

/* JADX INFO: loaded from: classes8.dex */
public final class y7 implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f114322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f114323b;

    public y7(long r100, boolean r101) {
        this.f114322a = r100;
        this.f114323b = r101;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "setExpDelayTime = " + this.f114322a + ", setEnableInvalidateDelay =" + this.f114323b;
    }
}
