package com.bumptech.glide.e;

import android.content.Context;
import com.bumptech.glide.f.k;
import com.bumptech.glide.load.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: AndroidResourceSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f3300c;

    public static g a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        g r0 = b.a(r3);
        return new a(ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48, r0);
    }

    private a(int r3, g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        this.f3299b = r3;
        this.f3300c = r5;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        if (this.f3299b == r5.f3299b) goto L7;
        return false;
    L7:
        if (this.f3300c.equals(r5.f3300c) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return k.a(this.f3300c, this.f3299b);
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest r2) {
        this.f3300c.a(r2);
        r2.update(ByteBuffer.allocate(4).putInt(this.f3299b).array());
    }
}
