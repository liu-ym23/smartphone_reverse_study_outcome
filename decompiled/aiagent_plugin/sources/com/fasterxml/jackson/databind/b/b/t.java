package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: compiled from: MapEntryDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class t extends i<Map.Entry<Object, Object>> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.q f12464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12466c;

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    public t(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.q r4, com.fasterxml.jackson.databind.l<Object> r5, com.fasterxml.jackson.databind.h.e r6) {
        super(r3);
        if (r3.z() != 2) goto L7;
        this.f12464a = r4;
        this.f12465b = r5;
        this.f12466c = r6;
        return;
    L7:
        throw new IllegalArgumentException("Missing generic type information for " + r3);
    }

    public t(t r1, com.fasterxml.jackson.databind.q r2, com.fasterxml.jackson.databind.l<Object> r3, com.fasterxml.jackson.databind.h.e r4) {
        super(r1);
        this.f12464a = r2;
        this.f12465b = r3;
        this.f12466c = r4;
    }

    public t a(com.fasterxml.jackson.databind.q r2, com.fasterxml.jackson.databind.h.e r3, com.fasterxml.jackson.databind.l<?> r4) {
        if (this.f12464a != r2) goto L10;
        if (this.f12465b != r4) goto L10;
        if (this.f12466c != r3) goto L10;
        return this;
    L10:
        return new t(this, r2, r4, r3);
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12969c;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r5, com.fasterxml.jackson.databind.d r6) {
        com.fasterxml.jackson.databind.d r7 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r0 = this.f12464a;
        if (r0 != null) goto L6;
        r0 = r5.b(this.f12422e.a(0), r7);
    L8:
        com.fasterxml.jackson.databind.l<?> r1 = a(r5, r7, this.f12465b);
        com.fasterxml.jackson.databind.k r2 = this.f12422e.a(1);
        if (r1 != null) goto L11;
        com.fasterxml.jackson.databind.l<?> r8 = r5.a(r2, r7);
    L12:
        com.fasterxml.jackson.databind.h.e r3 = this.f12466c;
        if (r3 == null) goto L16;
        r3 = r3.a(r7);
    L16:
        return a(r0, r3, r8);
    L11:
        r8 = r5.b(r1, r7, r2);
        goto L12
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.b.j.class) == false) goto L8;
        r0 = ((com.fasterxml.jackson.databind.b.j) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.b.j.class, "com.obric.aiagent.plugin")).a(r5, r7);
        goto L8
    }

    @Override // com.fasterxml.jackson.databind.b.b.i
    public com.fasterxml.jackson.databind.l<Object> h() {
        return this.f12465b;
    }

    public Map.Entry<Object, Object> b(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        com.fasterxml.jackson.a.n r0 = r9.l();
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L6;
        r0 = r9.g();
    L16:
        if (r0 != com.fasterxml.jackson.a.n.f) goto L18;
        com.fasterxml.jackson.databind.q r1 = this.f12464a;
        com.fasterxml.jackson.databind.l<Object> r2 = this.f12465b;
        com.fasterxml.jackson.databind.h.e r3 = this.f12466c;
        String r4 = r9.w();
        Object r5 = r1.a(r4, r10);
    L31:
        e = move-exception;
        a(r10, e, Map.Entry.class, r4);
        Object r6 = null;
    L33:
        com.fasterxml.jackson.a.n r7 = r9.g();
        if (r7 == com.fasterxml.jackson.a.n.f12153c) goto L41;
        if (r7 != com.fasterxml.jackson.a.n.f) goto L38;
        r10.a(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", new Object[]{r9.w()});
    L39:
        return null;
    L38:
        r10.a(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + r7, new Object[0]);
        goto L39
    L41:
        return new AbstractMap.SimpleEntry(r5, r6);
    L25:
        if (r9.g() != com.fasterxml.jackson.a.n.m) goto L27;
        r6 = r2.a(r10);     // Catch: Exception -> L31
    L42:
        goto L33
    L27:
        if (r3 != null) goto L29;
        r6 = r2.a(r9, r10);     // Catch: Exception -> L31
        goto L42
    L29:
        r6 = r2.a(r9, r10, r3);     // Catch: Exception -> L31
        goto L42
    L18:
        if (r0 != com.fasterxml.jackson.a.n.f12153c) goto L22;
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r10.a(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]), Map.Entry.class, "com.obric.aiagent.plugin");
    L22:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r10.a(a(), r9), Map.Entry.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == com.fasterxml.jackson.a.n.f) goto L16;
        if (r0 == com.fasterxml.jackson.a.n.f12153c) goto L16;
        if (r0 != com.fasterxml.jackson.a.n.f12154d) goto L14;
        return (Map.Entry) ZeusTransformUtils.preCheckCast(e(r9, r10), Map.Entry.class, "com.obric.aiagent.plugin");
    L14:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r10.a(f(r10), r9), Map.Entry.class, "com.obric.aiagent.plugin");
    }

    public Map.Entry<Object, Object> a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, Map.Entry<Object, Object> r3) {
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.a(r1, r2);
    }
}
