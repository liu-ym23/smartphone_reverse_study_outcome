package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.f.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.f.g<com.bumptech.glide.load.g, String> f3584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.util.f.a<a> f3585b;

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    private static final class a implements com.bumptech.glide.f.a.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageDigest f3587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.f.a.c f3588b;

        a(MessageDigest r2) {
            this.f3588b = com.bumptech.glide.f.a.c.a();
            this.f3587a = r2;
        }

        @Override // com.bumptech.glide.f.a.a.c
        public com.bumptech.glide.f.a.c b_() {
            return this.f3588b;
        }
    }

    public j() {
        this.f3584a = new com.bumptech.glide.f.g(1000);
        this.f3585b = com.bumptech.glide.f.a.a.a(10, new AnonymousClass1(this));
    }

    public String a(com.bumptech.glide.load.g r5) {
        com.bumptech.glide.load.g r6 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.f.g<com.bumptech.glide.load.g, String> r0 = this.f3584a;
        monitor-enter(r0);
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f3584a.b(r6), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (r1 != null) goto L8;
        r1 = b(r6);
    L8:
        com.bumptech.glide.f.g<com.bumptech.glide.load.g, String> r2 = this.f3584a;
        monitor-enter(r2);
        this.f3584a.b(r6, r1);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return r1;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    private String b(com.bumptech.glide.load.g r4) {
        com.bumptech.glide.load.g r5 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f3585b.a()), a.class, "com.obric.aiagent.plugin");
        r5.a(r0.f3587a);     // Catch: Throwable -> L6
        String r6 = k.a(r0.f3587a.digest());     // Catch: Throwable -> L6
        this.f3585b.a(r0);
        return r6;
    L6:
        th = move-exception;
        this.f3585b.a(r0);
        throw th;
    }
}
