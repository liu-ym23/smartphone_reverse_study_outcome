package com.bytedance.frameworks.baselib.network;

import com.bytedance.frameworks.baselib.network.http.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamWrapWithMetrics.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.b f7956a;

    public a(InputStream r3, com.bytedance.retrofit2.b.e r4, com.bytedance.frameworks.baselib.network.http.b r5) {
        super(r3, (com.bytedance.retrofit2.b.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.b.e.class, "com.obric.aiagent.plugin"));
        this.f7956a = r5;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.e, java.io.InputStream
    public int read(byte[] r2) {
        if (this.f7956a.f8138d == null) goto L15;
        this.f7956a.f8138d.as();
    L15:
        int r3 = super.read(r2);     // Catch: Throwable -> L10
        if (this.f7956a.f8138d == null) goto L9;
        this.f7956a.f8138d.at();
    L9:
        return r3;
    L10:
        th = move-exception;
        if (this.f7956a.f8138d == null) goto L14;
        this.f7956a.f8138d.at();
    L14:
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.e, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        if (this.f7956a.f8138d == null) goto L15;
        this.f7956a.f8138d.as();
    L15:
        int r5 = super.read(r2, r3, r4);     // Catch: Throwable -> L10
        if (this.f7956a.f8138d == null) goto L9;
        this.f7956a.f8138d.at();
    L9:
        return r5;
    L10:
        th = move-exception;
        if (this.f7956a.f8138d == null) goto L14;
        this.f7956a.f8138d.at();
    L14:
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.e, java.io.InputStream
    public int read() {
        if (this.f7956a.f8138d == null) goto L15;
        this.f7956a.f8138d.as();
    L15:
        int r0 = super.read();     // Catch: Throwable -> L10
        if (this.f7956a.f8138d == null) goto L9;
        this.f7956a.f8138d.at();
    L9:
        return r0;
    L10:
        th = move-exception;
        if (this.f7956a.f8138d == null) goto L14;
        this.f7956a.f8138d.at();
    L14:
        throw th;
    }
}
