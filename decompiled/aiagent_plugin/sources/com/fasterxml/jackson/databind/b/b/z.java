package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StackTraceElementDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class z extends ae<StackTraceElement> {
    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    public z() {
        super(StackTraceElement.class);
    }

    public StackTraceElement b(com.fasterxml.jackson.a.k r13, com.fasterxml.jackson.databind.h r14) {
        com.fasterxml.jackson.a.n r0 = r13.l();
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L45;
        int r8 = -1;
        String r9 = null;
        String r10 = null;
        String r11 = null;
        String r5 = "";
        String r6 = r5;
        String r7 = r6;
    L5:
        com.fasterxml.jackson.a.n r1 = r13.h();
        if (r1 == com.fasterxml.jackson.a.n.f12153c) goto L43;
        String r2 = r13.w();
        if ("className".equals(r2) == false) goto L11;
        r5 = r13.x();
    L41:
        r13.k();
        goto L5
    L11:
        if ("classLoaderName".equals(r2) == false) goto L14;
        r11 = r13.x();
        goto L41
    L14:
        if ("fileName".equals(r2) == false) goto L17;
        r7 = r13.x();
        goto L41
    L17:
        if ("lineNumber".equals(r2) == false) goto L24;
        if (r1.d() == false) goto L21;
        int r3 = r13.H();
    L22:
        r8 = r3;
        goto L41
    L21:
        r3 = w(r13, r14);
        goto L22
    L24:
        if ("methodName".equals(r2) == false) goto L27;
        r6 = r13.x();
        goto L41
    L27:
        if ("nativeMethod".equals(r2) == true) goto L41;
        if ("moduleName".equals(r2) == false) goto L33;
        r9 = r13.x();
        goto L41
    L33:
        if ("moduleVersion".equals(r2) == false) goto L36;
        r10 = r13.x();
        goto L41
    L36:
        if ("declaringClass".equals(r2) == true) goto L41;
        if ("format".equals(r2) == true) goto L41;
        b(r13, r14, this.B, r2);
        goto L41
    L43:
        return a(r14, r5, r6, r7, r8, r9, r10, r11);
    L45:
        if (r0 != com.fasterxml.jackson.a.n.f12154d) goto L53;
        if (r14.a(com.fasterxml.jackson.databind.i.r) == false) goto L53;
        r13.g();
        StackTraceElement r4 = b(r13, r14);
        if (r13.g() == com.fasterxml.jackson.a.n.f12155e) goto L51;
        D(r13, r14);
    L51:
        return r4;
    L53:
        return (StackTraceElement) ZeusTransformUtils.preCheckCast(r14.a(this.B, r13), StackTraceElement.class, "com.obric.aiagent.plugin");
    }

    public StackTraceElement a(com.fasterxml.jackson.databind.h r1, String r2, String r3, String r4, int r5, String r6, String r7, String r8) {
        return new StackTraceElement(r2, r3, r4, r5);
    }
}
