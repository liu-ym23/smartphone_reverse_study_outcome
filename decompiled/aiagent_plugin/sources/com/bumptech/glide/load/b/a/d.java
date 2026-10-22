package com.bumptech.glide.load.b.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.b.n;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements n<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3410a;

    /* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
    public static class a implements o<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f3411a;

        public a(Context r3) {
            this.f3411a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.load.b.o
        public n<Uri, InputStream> a(r r1) {
            return new d(this.f3411a);
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

    public d(Context r3) {
        this.f3410a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public n.a<InputStream> a2(Uri r1, int r2, int r3, i r4) {
        if (com.bumptech.glide.load.a.a.b.a(r2, r3) == true) goto L5;
        return null;
    L5:
        if (a(r4) == true) goto L7;
        return null;
    L7:
        return new n.a(new com.bumptech.glide.e.d(r1), com.bumptech.glide.load.a.a.c.b(this.f3410a, r1));
    }

    private boolean a(i r3) {
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r3.a(ab.f3783a), Long.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.longValue() != (-1)) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return com.bumptech.glide.load.a.a.b.b(r1);
    }
}
