package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: ProxyFrame.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f9827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f9830d;

    public f(h r2, int r3, int r4, byte[] r5) {
        d.h.b.o.e(r2, "type");
        d.h.b.o.e(r5, "payload");
        this.f9827a = r2;
        this.f9828b = r3;
        this.f9829c = r4;
        this.f9830d = r5;
    }

    public /* synthetic */ f(h r2, int r3, int r4, byte[] r5, int r6, d.h.b.h r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = new byte[0];
    L8:
        this(r2, r3, r4, r5);
    }

    public final h getType() {
        return this.f9827a;
    }

    public final int a() {
        return this.f9828b;
    }

    public final int b() {
        return this.f9829c;
    }

    public final byte[] c() {
        return this.f9830d;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.f9827a != ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f9827a) goto L13;
        if (this.f9828b != ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f9828b) goto L13;
        if (this.f9829c != ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f9829c) goto L13;
        if (Arrays.equals(this.f9830d, ((f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin")).f9830d) == false) goto L13;
        return true;
    }

    public int hashCode() {
        return (((((this.f9827a.hashCode() * 31) + this.f9828b) * 31) + this.f9829c) * 31) + Arrays.hashCode(this.f9830d);
    }

    public String toString() {
        return "ProxyFrame(type=" + this.f9827a + ", streamId=" + this.f9828b + ", flags=" + this.f9829c + ", payload=" + this.f9830d.length + " bytes)";
    }
}
