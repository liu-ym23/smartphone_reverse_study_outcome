package com.obric.autogui.agents.vlm.models.impl.c;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: PageStateDigest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f27614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f27616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f27617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f27618e;
    private final int f;
    private final byte[] g;
    private final Long h;
    private final Integer i;
    private final Integer j;
    private final Boolean k;

    public b(Long r2, String r3, ComponentName r4, Integer r5, int r6, int r7, byte[] r8, Long r9, Integer r10, Integer r11, Boolean r12) {
        o.e(r3, "evidenceSource");
        this.f27614a = r2;
        this.f27615b = r3;
        this.f27616c = r4;
        this.f27617d = r5;
        this.f27618e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public final Long a() {
        return this.f27614a;
    }

    public final String b() {
        return this.f27615b;
    }

    public final ComponentName getActivity() {
        return this.f27616c;
    }

    public final Integer c() {
        return this.f27617d;
    }

    public final int d() {
        return this.f27618e;
    }

    public final int e() {
        return this.f;
    }

    public final byte[] f() {
        return this.g;
    }

    public final Long g() {
        return this.h;
    }

    public final Integer h() {
        return this.i;
    }

    public final Integer i() {
        return this.j;
    }

    public final Boolean j() {
        return this.k;
    }

    public final boolean k() {
        if (o.a(this.k, true) == false) goto L5;
        return true;
    L5:
        if (this.f27616c == null) goto L7;
        return true;
    L7:
        if (this.f27617d == null) goto L9;
        return true;
    L9:
        if (this.g != null) goto L16;
        return false;
    L16:
        return true;
    }

    public final String l() {
        List r0 = p.a();
        if (this.f27616c == null) goto L6;
        r0.add("activity");
    L6:
        if (this.f27617d == null) goto L9;
        r0.add("viewtree");
    L9:
        if (this.g == null) goto L12;
        r0.add("image");
    L12:
        if (this.k == null) goto L15;
        r0.add("secure");
    L15:
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(p.a(r0), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    }

    public final String a(String r2) {
        o.e(r2, "salt");
        Integer r1 = this.f27617d;
        if (r1 == null) goto L6;
        int r3 = r1.intValue();
        byte[] r4 = ByteBuffer.allocate(4).putInt(r3).array();
        o.c(r4, "array(...)");
        return d.a(r2, r4);
    L6:
        return null;
    }

    public final String b(String r2) {
        o.e(r2, "salt");
        byte[] r1 = this.g;
        if (r1 != null) goto L7;
        return null;
    L7:
        return d.a(r2, r1);
    }
}
