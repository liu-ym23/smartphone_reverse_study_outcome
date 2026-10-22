package com.bytedance.frameworks.baselib.network.http.i;

import java.io.IOException;

/* JADX INFO: compiled from: DownloadFileTooLargeException.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f8375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f8376b;

    public d(int r3, long r4) {
        super("Download file too large: " + r4 + " exceed maxsize: " + r3);
        this.f8375a = r3;
        this.f8376b = r4;
    }
}
