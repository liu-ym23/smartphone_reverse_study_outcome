package com.bumptech.glide.load.a;

import com.bumptech.glide.load.resource.bitmap.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f3386a;

    /* JADX INFO: compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.b f3387a;

        @Override // com.bumptech.glide.load.a.e.a
        public /* synthetic */ e<InputStream> a(InputStream r3) {
            return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"));
        }

        public a(com.bumptech.glide.load.engine.a.b r3) {
            this.f3387a = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public e<InputStream> a2(InputStream r2) {
            return new k(r2, this.f3387a);
        }

        @Override // com.bumptech.glide.load.a.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.a.e
    public /* synthetic */ InputStream a() {
        return c();
    }

    public k(InputStream r3, com.bumptech.glide.load.engine.a.b r4) {
        w r0 = new w(r3, (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin"));
        this.f3386a = r0;
        r0.mark(5242880);
    }

    public InputStream c() {
        this.f3386a.reset();
        return this.f3386a;
    }

    @Override // com.bumptech.glide.load.a.e
    public void b() {
        this.f3386a.b();
    }

    public void d() {
        this.f3386a.a();
    }
}
