package com.bumptech.glide.request.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NoTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class a<R> implements b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<?> f3911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c<?> f3912b = null;

    /* JADX INFO: renamed from: com.bumptech.glide.request.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NoTransition.java */
    public static class C0098a<R> implements c<R> {
        public C0098a() {
        }

        @Override // com.bumptech.glide.request.a.c
        public b<R> a(com.bumptech.glide.load.a r1, boolean r2) {
            return a.f3911a;
        }
    }

    @Override // com.bumptech.glide.request.a.b
    public boolean a(Object r1, b.a r2) {
        b.a r0 = (b.a) ZeusTransformUtils.wrapperContextForParams(r2, b.a.class, "com.obric.aiagent.plugin");
        return false;
    }

    public a() {
    }

    static {
        f3911a = new a();
        f3912b = new C0098a();
    }

    public static <R> c<R> a() {
        return (c<R>) f3912b;
    }
}
