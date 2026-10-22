package com.bumptech.glide.load.resource;

import android.graphics.ImageDecoder;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements k<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final r f3773a;

    public abstract v<T> a(ImageDecoder.Source r1, int r2, int r3, ImageDecoder.OnHeaderDecodedListener r4);

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public final boolean a2(ImageDecoder.Source r1, i r2) {
        return true;
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ v a(ImageDecoder.Source r3, int r4, int r5, i r6) {
        return a2((ImageDecoder.Source) ZeusTransformUtils.preCheckCast(r3, ImageDecoder.Source.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.bumptech.glide.load.k
    public /* synthetic */ boolean a(ImageDecoder.Source r3, i r4) {
        return a2((ImageDecoder.Source) ZeusTransformUtils.preCheckCast(r3, ImageDecoder.Source.class, "com.obric.aiagent.plugin"), r4);
    }

    public a() {
        this.f3773a = r.a();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public final v<T> a2(ImageDecoder.Source r12, final int r13, final int r14, i r15) {
        final com.bumptech.glide.load.b r8 = (com.bumptech.glide.load.b) ZeusTransformUtils.preCheckCast(r15.a(m.f3815a), com.bumptech.glide.load.b.class, "com.obric.aiagent.plugin");
        final l r9 = (l) ZeusTransformUtils.preCheckCast(r15.a(l.h), l.class, "com.obric.aiagent.plugin");
        if (r15.a(m.f3819e) != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        final boolean r7 = r0;
        final j r10 = (j) ZeusTransformUtils.preCheckCast(r15.a(m.f3816b), j.class, "com.obric.aiagent.plugin");
        return a(r12, r13, r14, new ImageDecoderResourceDecoder$1(this, r13, r14, r7, r8, r9, r10));
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.a(m.f3819e), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }
}
