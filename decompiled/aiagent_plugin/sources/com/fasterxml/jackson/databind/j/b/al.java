package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeZoneSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class al extends ai<TimeZone> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((TimeZone) ZeusTransformUtils.preCheckCast(r3, TimeZone.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((TimeZone) ZeusTransformUtils.preCheckCast(r3, TimeZone.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    public al() {
        super(TimeZone.class);
    }

    public void a(TimeZone r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.b(r1.getID());
    }

    public void a(TimeZone r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r3, TimeZone.class, com.fasterxml.jackson.a.n.h));
        a(r3, r4, r5);
        r6.b(r4, r0);
    }
}
