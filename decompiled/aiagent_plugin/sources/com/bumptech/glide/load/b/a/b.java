package com.bumptech.glide.load.b.a;

import android.net.Uri;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.b.n;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: HttpUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f3406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<g, InputStream> f3407b;

    /* JADX INFO: compiled from: HttpUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        public a() {
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, InputStream> a(r r3) {
            return new b(r3.a(g.class, InputStream.class));
        }
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ n.a<InputStream> a(Uri r3, int r4, int r5, i r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.b.n
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.aiagent.plugin"));
    }

    static {
        f3406a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));
    }

    public b(n<g, InputStream> r3) {
        this.f3407b = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<InputStream> a2(Uri r2, int r3, int r4, i r5) {
        return this.f3407b.a(new g(r2.toString()), r3, r4, r5);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return f3406a.contains(r1.getScheme());
    }
}
