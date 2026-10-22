package com.bytedance.vmsdk.a.a;

import android.net.LocalSocket;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SocketLike.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalSocket f11722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f11723b;

    public d(d r1, b r2) {
        this(r1.f11722a, r2);
    }

    public d(LocalSocket r1, b r2) {
        this.f11722a = r1;
        this.f11723b = r2;
    }

    public InputStream a() {
        return this.f11723b.a();
    }

    public OutputStream b() {
        return this.f11722a.getOutputStream();
    }
}
