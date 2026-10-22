package com.bytedance.vmsdk.a.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: ReadHandler.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedInputStream f11702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f11703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteArrayOutputStream f11704c;

    public e(InputStream r3, f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        this.f11704c = new ByteArrayOutputStream();
        this.f11702a = new BufferedInputStream(r3, 1024);
        this.f11703b = r5;
    }

    public void a(d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        a r0 = new a();
    L3:
        r0.a(this.f11702a);
        this.f11704c.write(r0.i, 0, (int) r0.g);
        if (r0.f11697a == false) goto L7;
        byte[] r1 = this.f11704c.toByteArray();
        r8.a(r0.f11701e, r1, r1.length);
        this.f11704c.reset();
    L7:
        if (r0.f11701e != 8) goto L3;
    }
}
