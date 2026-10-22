package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UnitTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class g<Z> implements e<Z, Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g<?> f3866a = null;

    @Override // com.bumptech.glide.load.resource.d.e
    public v<Z> a(v<Z> r1, i r2) {
        return (v) ZeusTransformUtils.wrapperContextForParams(r1, v.class, "com.obric.aiagent.plugin");
    }

    public g() {
    }

    static {
        f3866a = new g();
    }

    public static <Z> e<Z, Z> a() {
        return f3866a;
    }
}
