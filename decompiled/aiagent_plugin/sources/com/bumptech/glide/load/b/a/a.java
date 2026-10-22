package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.a.j;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.b.m;
import com.bumptech.glide.load.b.n;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: HttpGlideUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements n<g, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<Integer> f3403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<g, g> f3404b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpGlideUrlLoader.java */
    public static class C0088a implements o<g, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m<g, g> f3405a;

        public C0088a() {
            this.f3405a = new m(500);
        }

        @Override // com.bumptech.glide.load.b.o
        public n<g, InputStream> a(r r1) {
            return new a(this.f3405a);
        }
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(g r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a<InputStream> a(g r3, int r4, int r5, i r6) {
        return a2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(g r3) {
        return a2((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"));
    }

    static {
        f3403a = h.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    }

    public a() {
        this(null);
    }

    public a(m<g, g> r1) {
        this.f3404b = r1;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<InputStream> a2(g r3, int r4, int r5, i r6) {
        m<g, g> r7 = this.f3404b;
        if (r7 == null) goto L9;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7.a(r3, 0, 0), g.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L7;
        this.f3404b.a(r3, 0, 0, r3);
        goto L9
    L7:
        r3 = r8;
    L9:
        return new n.a(r3, new j(r3, ((Integer) ZeusTransformUtils.preCheckCast(r6.a(f3403a), Integer.class, "com.obric.aiagent.plugin")).intValue()));
    }
}
