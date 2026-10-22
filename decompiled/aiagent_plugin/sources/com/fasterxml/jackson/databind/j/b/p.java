package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;

/* JADX INFO: compiled from: InetAddressSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends ai<InetAddress> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f12907a;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((InetAddress) ZeusTransformUtils.preCheckCast(r3, InetAddress.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((InetAddress) ZeusTransformUtils.preCheckCast(r3, InetAddress.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    public p() {
        this(false);
    }

    public p(boolean r2) {
        super(InetAddress.class);
        this.f12907a = r2;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
        JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
        if (r5 == null) goto L9;
        JsonFormat.Shape r6 = r5.getShape();
        if (r6.isNumeric() == false) goto L7;
    L8:
        boolean r7 = true;
    L11:
        if (r7 != this.f12907a) goto L13;
        return this;
    L13:
        return new p(r7);
    L7:
        if (r6 == JsonFormat.Shape.ARRAY) goto L8;
    L9:
        r7 = false;
        goto L11
    }

    public void a(InetAddress r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        if (this.f12907a == false) goto L5;
        String r0 = r1.getHostAddress();
    L10:
        r2.b(r0);
        return;
    L5:
        r0 = r1.toString().trim();
        int r4 = r0.indexOf(47);
        if (r4 < 0) goto L10;
        if (r4 != 0) goto L9;
        r0 = r0.substring(1);
        goto L10
    L9:
        r0 = r0.substring(0, r4);
        goto L10
    }

    public void a(InetAddress r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r3, InetAddress.class, com.fasterxml.jackson.a.n.h));
        a(r3, r4, r5);
        r6.b(r4, r0);
    }
}
