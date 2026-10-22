package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StringDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class ai extends ae<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ai f12400a = null;

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return "";
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return b(r1, r2, r3);
    }

    static {
        f12400a = new ai();
    }

    public ai() {
        super(String.class);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.j;
    }

    public String b(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        if (r5.a(com.fasterxml.jackson.a.n.h) == true) goto L5;
        com.fasterxml.jackson.a.n r1 = r5.l();
        if (r1 != com.fasterxml.jackson.a.n.f12154d) goto L11;
        return (String) ZeusTransformUtils.preCheckCast(e(r5, r6), String.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 != com.fasterxml.jackson.a.n.g) goto L23;
        Object r4 = r5.N();
        if (r4 != null) goto L17;
        return null;
    L17:
        if ((r4 instanceof byte[]) == false) goto L21;
        return r6.k().a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"), false);
    L21:
        return r4.toString();
    L23:
        if (r1 != com.fasterxml.jackson.a.n.f12152b) goto L27;
        return r6.a(r5, this, this.B);
    L27:
        if (r1.g() == false) goto L32;
        String r0 = r5.R();
        if (r0 == null) goto L32;
        return r0;
    L32:
        return (String) ZeusTransformUtils.preCheckCast(r6.a(this.B, r5), String.class, "com.obric.aiagent.plugin");
    L5:
        return r5.x();
    }

    public String b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return b(r1, r2);
    }
}
