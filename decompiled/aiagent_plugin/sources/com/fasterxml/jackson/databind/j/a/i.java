package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObjectIdWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fasterxml.jackson.databind.k f12813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fasterxml.jackson.a.q f12814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObjectIdGenerator<?> f12815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.fasterxml.jackson.databind.p<Object> f12816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12817e;

    public i(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.a.q r4, ObjectIdGenerator<?> r5, com.fasterxml.jackson.databind.p<?> r6, boolean r7) {
        com.fasterxml.jackson.a.q r8 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
        this.f12813a = r3;
        this.f12814b = r8;
        this.f12815c = r5;
        this.f12816d = r6;
        this.f12817e = r7;
    }

    public static i a(com.fasterxml.jackson.databind.k r7, x r8, ObjectIdGenerator<?> r9, boolean r10) {
        com.fasterxml.jackson.a.d.m r0 = null;
        if (r8 != null) goto L5;
        String r11 = null;
    L6:
        if (r11 == null) goto L10;
        r0 = new com.fasterxml.jackson.a.d.m(r11);
    L10:
        return new i(r7, r0, r9, null, r10);
    L5:
        r11 = r8.b();
        goto L6
    }

    public i a(com.fasterxml.jackson.databind.p<?> r8) {
        return new i(this.f12813a, this.f12814b, this.f12815c, r8, this.f12817e);
    }

    public i a(boolean r8) {
        if (r8 != this.f12817e) goto L6;
        return this;
    L6:
        return new i(this.f12813a, this.f12814b, this.f12815c, this.f12816d, r8);
    }
}
