package com.bytedance.frameworks.baselib.network.h;

import com.bytedance.security.zenmobile.io.SensitiveType;

/* JADX INFO: compiled from: TTReflectException.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8125c;

    public c(String r2, Throwable r3, String... r4) {
        super(a(r2, r4), r3);
        int r5 = r4.length;
        String r6 = SensitiveType.UNKNOWN;
        if (r5 <= 0) goto L5;
        String r7 = r4[0];
    L6:
        this.f8123a = r7;
        if (r4.length <= 1) goto L9;
        String r8 = r4[1];
    L10:
        this.f8124b = r8;
        if (r4.length <= 2) goto L13;
        r6 = r4[2];
    L13:
        this.f8125c = r6;
        return;
    L9:
        r8 = SensitiveType.UNKNOWN;
        goto L10
    L5:
        r7 = SensitiveType.UNKNOWN;
        goto L6
    }

    public c(String r3) {
        this(r3, null, new String[0]);
    }

    private static String a(String r2, String... r3) {
        StringBuilder r0 = new StringBuilder(r2);
        if (r3 == null) goto L14;
        if (r3.length <= 0) goto L14;
        r0.append(" [TargetClass: ").append(r3[0]);
        if (r3.length <= 1) goto L10;
        r0.append(", TargetMember: ").append(r3[1]);
    L10:
        if (r3.length <= 2) goto L12;
        r0.append(", MemberType: ").append(r3[2]);
    L12:
        r0.append("]");
    L14:
        return r0.toString();
    }
}
