package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.b.n;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: UrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements n<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<g, InputStream> f3423a;

    /* JADX INFO: compiled from: UrlLoader.java */
    public static class a implements o<URL, InputStream> {
        public a() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<URL, InputStream> a(r r3) {
            return new f(r3.a(g.class, InputStream.class));
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(URL r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a<InputStream> a(URL r3, int r4, int r5, i r6) {
        return a2((URL) ZeusTransformUtils.preCheckCast(r3, URL.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(URL r3) {
        return a2((URL) ZeusTransformUtils.preCheckCast(r3, URL.class, "com.obric.aiagent.plugin"));
    }

    public f(n<g, InputStream> r3) {
        this.f3423a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<InputStream> a2(URL r2, int r3, int r4, i r5) {
        return this.f3423a.a(new g(r2), r3, r4, r5);
    }
}
