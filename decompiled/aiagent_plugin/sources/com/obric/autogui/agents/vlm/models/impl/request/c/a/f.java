package com.obric.autogui.agents.vlm.models.impl.request.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StreamingResponsePackage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f28117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.tools.api.net.b f28118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f28119e;
    private final String f;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f28115a, r6.f28115a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f28116b, r6.f28116b) == true) goto L15;
        return false;
    L15:
        if (this.f28117c == r6.f28117c) goto L18;
        return false;
    L18:
        if (o.a(this.f28118d, r6.f28118d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f28119e, r6.f28119e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f28115a.hashCode() * 31) + this.f28116b.hashCode()) * 31) + Boolean.hashCode(this.f28117c)) * 31;
        com.obric.autogui.tools.api.net.b r1 = this.f28118d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        e r5 = this.f28119e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "StreamingResponsePackage(forRequestId=" + this.f28115a + ", modelReply=" + this.f28116b + ", isEnd=" + this.f28117c + ", netError=" + this.f28118d + ", servError=" + this.f28119e + ", debugInfo=" + this.f + ')';
    }

    public f(String r3, String r4, boolean r5, com.obric.autogui.tools.api.net.b r6, e r7, String r8) {
        com.obric.autogui.tools.api.net.b r9 = (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "forRequestId");
        o.e(r4, "modelReply");
        this.f28115a = r3;
        this.f28116b = r4;
        this.f28117c = r5;
        this.f28118d = r9;
        this.f28119e = r7;
        this.f = r8;
    }

    public /* synthetic */ f(String r11, String r12, boolean r13, com.obric.autogui.tools.api.net.b r14, e r15, String r16, int r17, h r18) {
        com.obric.autogui.tools.api.net.b r0 = (com.obric.autogui.tools.api.net.b) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.autogui.tools.api.net.b.class, "com.obric.aiagent.plugin");
        if ((r17 & 8) == 0) goto L5;
        com.obric.autogui.tools.api.net.b r7 = null;
    L7:
        if ((r17 & 16) == 0) goto L9;
        e r8 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        String r9 = null;
    L14:
        this(r11, r12, r13, r7, r8, r9);
        return;
    L13:
        r9 = r16;
        goto L14
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r0;
        goto L7
    }

    public final String a() {
        return this.f28115a;
    }

    public final String b() {
        return this.f28116b;
    }

    public final boolean c() {
        return this.f28117c;
    }

    public final com.obric.autogui.tools.api.net.b d() {
        return this.f28118d;
    }

    public final e e() {
        return this.f28119e;
    }

    public final String f() {
        return this.f;
    }
}
