package com.bytedance.compression.zstd;

/* JADX INFO: compiled from: ZstdException.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7097a;

    public e(long r3) {
        this(Zstd.getErrorCode(r3), Zstd.getErrorName(r3));
    }

    public e(long r1, String r3) {
        super(r3);
        this.f7097a = r1;
    }
}
