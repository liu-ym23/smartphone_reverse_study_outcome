package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: StringArraySerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class n extends com.fasterxml.jackson.databind.j.b.a<String[]> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f12842a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.fasterxml.jackson.databind.k f12843e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.p<Object> f12844b;

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5) {
        a((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(ac r3, Object r4) {
        return a(r3, (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.a
    public /* synthetic */ void b(String[] r3, com.fasterxml.jackson.a.h r4, ac r5) {
        b2((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.aiagent.plugin"), r4, r5);
    }

    static {
        f12843e = com.fasterxml.jackson.databind.k.o.a().a(String.class);
        f12842a = new n();
    }

    public n() {
        super(String[].class);
        this.f12844b = null;
    }

    public n(n r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.p<?> r5, Boolean r6) {
        super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r6);
        this.f12844b = r5;
    }

    @Override // com.fasterxml.jackson.databind.j.b.a
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r3, Boolean r4) {
        return new n(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), this.f12844b, r4);
    }

    @Override // com.fasterxml.jackson.databind.j.b.a, com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(ac r5, com.fasterxml.jackson.databind.d r6) {
        com.fasterxml.jackson.databind.d r7 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.p<?> r0 = null;
        if (r7 == null) goto L9;
        com.fasterxml.jackson.databind.b r1 = r5.d();
        com.fasterxml.jackson.databind.e.j r2 = r7.d();
        if (r2 == null) goto L9;
        Object r3 = r1.o(r2);
        if (r3 == null) goto L9;
        com.fasterxml.jackson.databind.p<Object> r4 = r5.b(r2, r3);
    L10:
        Boolean r8 = a(r5, r7, String[].class, JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        if (r4 != null) goto L13;
        r4 = this.f12844b;
    L13:
        com.fasterxml.jackson.databind.p<?> r9 = a(r5, r7, r4);
        if (r9 != null) goto L17;
        r9 = r5.c(String.class, r7);
    L17:
        if (a(r9) == true) goto L21;
        r0 = r9;
    L21:
        if (r0 != this.f12844b) goto L26;
        if (Objects.equals(r8, this.f12860d) == false) goto L26;
        return this;
    L26:
        return new n(this, r7, r0, r8);
    L9:
        r4 = null;
        goto L10
    }

    public boolean a(ac r1, String[] r2) {
        if (r2.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(String[] r1) {
        if (r1.length == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void a(String[] r4, com.fasterxml.jackson.a.h r5, ac r6) {
        int r0 = r4.length;
        if (r0 == 1) goto L5;
    L12:
        r5.a(r4, r0);
        b2(r4, r5, r6);
        r5.i();
        return;
    L5:
        if (this.f12860d != null) goto L9;
        if (r6.a(ab.u) == false) goto L9;
    L10:
        b2(r4, r5, r6);
        return;
    L9:
        if (this.f12860d != Boolean.TRUE) goto L12;
        goto L10
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(String[] r3, com.fasterxml.jackson.a.h r4, ac r5) {
        int r0 = r3.length;
        if (r0 != 0) goto L5;
        return;
    L5:
        com.fasterxml.jackson.databind.p<Object> r1 = this.f12844b;
        if (r1 == null) goto L9;
        a(r3, r4, r5, r1);
        return;
    L9:
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L16;
        if (r3[r2] != null) goto L14;
        r4.l();
    L15:
        r2 = r2 + 1;
        goto L10
    L14:
        r4.b(r3[r2]);
        goto L15
    }

    private void a(String[] r3, com.fasterxml.jackson.a.h r4, ac r5, com.fasterxml.jackson.databind.p<Object> r6) {
        int r2 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L9;
        if (r3[r0] != null) goto L7;
        r5.a(r4);
    L8:
        r0 = r0 + 1;
        goto L3
    L7:
        r6.a(r3[r0], r4, r5);
        goto L8
    }
}
