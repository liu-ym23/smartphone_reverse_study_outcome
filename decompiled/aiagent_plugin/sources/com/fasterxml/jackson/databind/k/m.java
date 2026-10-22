package com.fasterxml.jackson.databind.k;

import com.fasterxml.jackson.databind.ac;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TypeBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends com.fasterxml.jackson.databind.k implements com.fasterxml.jackson.databind.o {
    private static final n f = null;
    private static final com.fasterxml.jackson.databind.k[] g = null;
    protected final com.fasterxml.jackson.databind.k h;
    protected final com.fasterxml.jackson.databind.k[] i;
    protected final n j;
    volatile transient String k;

    static {
        f = n.a();
        g = new com.fasterxml.jackson.databind.k[0];
    }

    public m(Class<?> r7, n r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.k[] r10, int r11, Object r12, Object r13, boolean r14) {
        super(r7, r11, r12, r13, r14);
        if (r8 != null) goto L5;
        r8 = f;
    L5:
        this.j = r8;
        this.h = r9;
        this.i = r10;
    }

    @Override // com.fasterxml.jackson.a.g.a
    public String c() {
        String r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return I();
    }

    public String I() {
        return this.f12956a.getName();
    }

    @Override // com.fasterxml.jackson.databind.k
    public n A() {
        return this.j;
    }

    @Override // com.fasterxml.jackson.databind.k
    public int z() {
        return this.j.c();
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(int r1) {
        return this.j.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k B() {
        return this.h;
    }

    @Override // com.fasterxml.jackson.databind.k
    public List<com.fasterxml.jackson.databind.k> C() {
        com.fasterxml.jackson.databind.k[] r2 = this.i;
        if (r2 == null) goto L5;
        int r0 = r2.length;
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L13;
        return Arrays.asList(r2);
    L13:
        return Collections.singletonList(r2[0]);
    L15:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }

    @Override // com.fasterxml.jackson.databind.k
    public final com.fasterxml.jackson.databind.k d(Class<?> r4) {
        if (r4 != this.f12956a) goto L6;
        return this;
    L6:
        if (r4.isInterface() == false) goto L15;
        com.fasterxml.jackson.databind.k[] r0 = this.i;
        if (r0 == null) goto L15;
        int r1 = 0;
        int r2 = r0.length;
    L10:
        if (r1 >= r2) goto L15;
        com.fasterxml.jackson.databind.k r3 = this.i[r1].d(r4);
        if (r3 != null) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        return r3;
    L15:
        com.fasterxml.jackson.databind.k r5 = this.h;
        if (r5 == null) goto L20;
        com.fasterxml.jackson.databind.k r6 = r5.d(r4);
        if (r6 == null) goto L24;
        return r6;
    L24:
        return null;
    L20:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r3, ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = new com.fasterxml.jackson.a.g.b(this, com.fasterxml.jackson.a.n.h);
        r5.a(r3, r0);
        a(r3, r4);
        r5.b(r3, r0);
    }

    @Override // com.fasterxml.jackson.databind.o
    public void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.b(c());
    }

    public static StringBuilder a(Class<?> r4, StringBuilder r5, boolean r6) {
        if (r4.isPrimitive() == true) goto L5;
        r5.append('L');
        String r7 = r4.getName();
        int r0 = 0;
        int r1 = r7.length();
    L34:
        if (r0 >= r1) goto L39;
        char r2 = r7.charAt(r0);
        if (r2 != '.') goto L38;
        r2 = '/';
    L38:
        r5.append(r2);
        r0 = r0 + 1;
        goto L34
    L39:
        if (r6 == false) goto L41;
        r5.append(';');
    L41:
        return r5;
    L5:
        if (r4 != Boolean.TYPE) goto L8;
        r5.append('Z');
        goto L41
    L8:
        if (r4 != Byte.TYPE) goto L11;
        r5.append('B');
        goto L41
    L11:
        if (r4 != Short.TYPE) goto L14;
        r5.append('S');
        goto L41
    L14:
        if (r4 != Character.TYPE) goto L17;
        r5.append('C');
        goto L41
    L17:
        if (r4 != Integer.TYPE) goto L20;
        r5.append('I');
        goto L41
    L20:
        if (r4 != Long.TYPE) goto L23;
        r5.append('J');
        goto L41
    L23:
        if (r4 != Float.TYPE) goto L26;
        r5.append('F');
        goto L41
    L26:
        if (r4 != Double.TYPE) goto L29;
        r5.append('D');
        goto L41
    L29:
        if (r4 != Void.TYPE) goto L32;
        r5.append('V');
        goto L41
    L32:
        throw new IllegalStateException("Unrecognized primitive type: " + r4.getName());
    }

    public boolean c(int r1) {
        if (this.f12956a.getTypeParameters().length != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
