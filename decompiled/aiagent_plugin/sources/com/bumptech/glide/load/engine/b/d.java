package com.bumptech.glide.load.engine.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: DiskLruCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.b.a.InterfaceC0093a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f3564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3565b;

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public d(a r3, long r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        this.f3564a = r4;
        this.f3565b = r5;
    }

    @Override // com.bumptech.glide.load.engine.b.a.InterfaceC0093a
    public com.bumptech.glide.load.engine.b.a a() {
        File r0 = this.f3565b.a();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.mkdirs() == true) goto L13;
        if (r0.exists() == true) goto L10;
    L11:
        return null;
    L10:
        if (r0.isDirectory() == false) goto L11;
    L13:
        return e.a(r0, this.f3564a);
    }
}
