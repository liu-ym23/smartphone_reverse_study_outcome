package com.bumptech.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: GlideUrl.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f3441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final URL f3442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3444e;
    private URL f;
    private volatile byte[] g;
    private int h;

    public g(URL r2) {
        this(r2, h.f3446b);
    }

    public g(String r2) {
        this(r2, h.f3446b);
    }

    public g(URL r3, h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        this.f3442c = (URL) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3), URL.class, "com.obric.aiagent.plugin");
        this.f3443d = null;
        this.f3441b = (h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r5), h.class, "com.obric.aiagent.plugin");
    }

    public g(String r3, h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        this.f3442c = null;
        this.f3443d = com.bumptech.glide.f.j.a(r3);
        this.f3441b = (h) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r5), h.class, "com.obric.aiagent.plugin");
    }

    public URL a() {
        return d();
    }

    private URL d() {
        if (this.f != null) goto L6;
        this.f = new URL(e());
    L6:
        return this.f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f3444e) == false) goto L9;
        String r0 = this.f3443d;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = ((URL) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f3442c), URL.class, "com.obric.aiagent.plugin")).toString();
    L7:
        this.f3444e = Uri.encode(r0, "@#&=*+-_.,:!?()/~'%;$");
    L9:
        return this.f3444e;
    }

    public Map<String, String> b() {
        return this.f3441b.a();
    }

    public String c() {
        String r0 = this.f3443d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ((URL) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(this.f3442c), URL.class, "com.obric.aiagent.plugin")).toString();
    }

    public String toString() {
        return c();
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r1) {
        r1.update(f());
    }

    private byte[] f() {
        if (this.g != null) goto L6;
        this.g = c().getBytes(f3763a);
    L6:
        return this.g;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L10;
        g r5 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");
        if (c().equals(r5.c()) == true) goto L7;
        return false;
    L7:
        if (this.f3441b.equals(r5.f3441b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        if (this.h != 0) goto L6;
        int r0 = c().hashCode();
        this.h = r0;
        this.h = (r0 * 31) + this.f3441b.hashCode();
    L6:
        return this.h;
    }
}
