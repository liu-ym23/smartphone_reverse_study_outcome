package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: UnitTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public final class c<T> implements m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final m<?> f3855b = null;

    @Override // com.bumptech.glide.load.m
    public v<T> a(Context r1, v<T> r2, int r3, int r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        return (v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r1) {
    }

    static {
        f3855b = new c();
    }

    public static <T> c<T> a() {
        return (c) ZeusTransformUtils.preCheckCast(f3855b, c.class, "com.obric.aiagent.plugin");
    }

    private c() {
    }
}
