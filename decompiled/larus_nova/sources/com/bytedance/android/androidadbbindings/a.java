package com.bytedance.android.androidadbbindings;

import android.net.LocalSocket;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends w6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalSocket f38386a;

    @Override // w6.a
    public final void close() {
        this.f38386a.close();
    }

    public a(LocalSocket r100) {
        this.f38386a = r100;
    }

    @Override // w6.a
    public final void read(byte[] r100) {
        this.f38386a.getInputStream().read(r100);
    }

    @Override // w6.a
    public final void write(byte[] r100) {
        this.f38386a.getOutputStream().write(r100);
    }
}
