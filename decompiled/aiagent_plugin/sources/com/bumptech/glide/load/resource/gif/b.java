package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GifBitmapProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bumptech.glide.b.a.InterfaceC0083a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3883b;

    public b(com.bumptech.glide.load.engine.a.e r3, com.bumptech.glide.load.engine.a.b r4) {
        com.bumptech.glide.load.engine.a.e r5 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this.f3882a = r5;
        this.f3883b = r6;
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0083a
    public Bitmap a(int r1, int r2, Bitmap.Config r3) {
        return this.f3882a.b(r1, r2, r3);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0083a
    public void a(Bitmap r1) {
        this.f3882a.a(r1);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0083a
    public byte[] a(int r2) {
        com.bumptech.glide.load.engine.a.b r1 = this.f3883b;
        if (r1 != null) goto L7;
        return new byte[r2];
    L7:
        return (byte[]) ZeusTransformUtils.preCheckCast(r1.a(r2, byte[].class), byte[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0083a
    public void a(byte[] r1) {
        com.bumptech.glide.load.engine.a.b r0 = this.f3883b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1);
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0083a
    public int[] b(int r2) {
        com.bumptech.glide.load.engine.a.b r1 = this.f3883b;
        if (r1 != null) goto L7;
        return new int[r2];
    L7:
        return (int[]) ZeusTransformUtils.preCheckCast(r1.a(r2, int[].class), int[].class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.b.a.InterfaceC0083a
    public void a(int[] r1) {
        com.bumptech.glide.load.engine.a.b r0 = this.f3883b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1);
    }
}
