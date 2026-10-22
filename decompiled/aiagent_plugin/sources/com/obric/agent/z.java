package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UploadingImgInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16089b;

    /* JADX WARN: Multi-variable type inference failed */
    public z() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, z.class) == true) goto L8;
        return false;
    L8:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f16088a, r6.f16088a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f16089b, r6.f16089b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f16088a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f16089b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UploadingImgInfo(identifier=" + this.f16088a + ", uri=" + this.f16089b + ')';
    }

    public z(String r1, String r2) {
        this.f16088a = r1;
        this.f16089b = r2;
    }

    public /* synthetic */ z(String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }

    public final String getIdentifier() {
        return this.f16088a;
    }

    public final String a() {
        return this.f16089b;
    }
}
