package com.bumptech.glide.load;

import java.io.IOException;

/* JADX INFO: compiled from: HttpException.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3510a;

    public e(int r3) {
        this("Http request failed with status code: " + r3, r3);
    }

    public e(String r2) {
        this(r2, -1);
    }

    public e(String r2, int r3) {
        this(r2, r3, null);
    }

    public e(String r1, int r2, Throwable r3) {
        super(r1, r3);
        this.f3510a = r2;
    }
}
