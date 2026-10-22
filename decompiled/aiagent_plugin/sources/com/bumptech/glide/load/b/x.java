package com.bumptech.glide.load.b;

import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UrlUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f3504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<g, Data> f3505b;

    /* JADX INFO: compiled from: UrlUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        public a() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, InputStream> a(r r3) {
            return new x(r3.a(g.class, InputStream.class));
        }
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"));
    }

    static {
        f3504a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    }

    public x(n<g, Data> r3) {
        this.f3505b = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<Data> a2(Uri r2, int r3, int r4, com.bumptech.glide.load.i r5) {
        g r0 = new g(r2.toString());
        return this.f3505b.a(r0, r3, r4, r5);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return f3504a.contains(r1.getScheme());
    }
}
