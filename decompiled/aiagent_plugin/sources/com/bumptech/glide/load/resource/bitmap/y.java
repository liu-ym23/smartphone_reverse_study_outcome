package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class y implements com.bumptech.glide.load.k<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f3846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f3847b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    static class a implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w f3848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.f.d f3849b;

        a(w r1, com.bumptech.glide.f.d r2) {
            this.f3848a = r1;
            this.f3849b = r2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.a
        public void a() {
            this.f3848a.a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.a
        public void a(com.bumptech.glide.load.engine.a.e r3, Bitmap r4) {
            com.bumptech.glide.load.engine.a.e r5 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
            IOException r2 = this.f3849b.a();
            if (r2 == null) goto L7;
            if (r4 == null) goto L8;
            r5.a(r4);
            throw r2;
        L8:
            throw r2;
        }
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ com.bumptech.glide.load.engine.v<Bitmap> a(InputStream r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(InputStream r3, com.bumptech.glide.load.i r4) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), r4);
    }

    public y(m r3, com.bumptech.glide.load.engine.a.b r4) {
        com.bumptech.glide.load.engine.a.b r5 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        this.f3846a = r3;
        this.f3847b = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(InputStream r1, com.bumptech.glide.load.i r2) {
        return this.f3846a.a(r1);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.v<Bitmap> a2(InputStream r10, int r11, int r12, com.bumptech.glide.load.i r13) {
        if (ZeusTransformUtils.instanceOf(r10, w.class) == false) goto L5;
        w r14 = (w) ZeusTransformUtils.preCheckCast(r10, w.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
    L6:
        com.bumptech.glide.f.d r1 = com.bumptech.glide.f.d.a(r14);
        com.bumptech.glide.load.engine.v<Bitmap> r9 = this.f3846a.a(new com.bumptech.glide.f.h(r1), r11, r12, r13, new a(r14, r1));     // Catch: Throwable -> L12
        r1.b();
        if (r0 == false) goto L11;
        r14.b();
    L11:
        return r9;
    L12:
        th = move-exception;
        r1.b();
        if (r0 == false) goto L16;
        r14.b();
    L16:
        throw th;
    L5:
        r0 = true;
        r14 = new w(r10, this.f3847b);
        goto L6
    }
}
