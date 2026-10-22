package com.fasterxml.jackson.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: ContentReference.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final d f11995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final transient Object f11996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f11997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f11998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f11999e;

    public int f() {
        return 500;
    }

    static {
        f11995a = new d(false, null);
    }

    public d(boolean r2, Object r3) {
        this(r2, r3, -1, -1);
    }

    public d(boolean r1, Object r2, int r3, int r4) {
        this.f11999e = r1;
        this.f11996b = r2;
        this.f11997c = r3;
        this.f11998d = r4;
    }

    public static d a() {
        return f11995a;
    }

    public static d a(boolean r1, Object r2) {
        return new d(r1, r2);
    }

    public static d b(boolean r2, Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L7;
        return (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
    L7:
        return new d(r2, r3);
    }

    public static d a(Object r1) {
        return b(false, r1);
    }

    public boolean b() {
        return this.f11999e;
    }

    public Object c() {
        return this.f11996b;
    }

    public int d() {
        return this.f11997c;
    }

    public int e() {
        return this.f11998d;
    }

    public String g() {
        return a(new StringBuilder(200)).toString();
    }

    public StringBuilder a(StringBuilder r10) {
        Object r2 = c();
        if (r2 != null) goto L7;
        r10.append("UNKNOWN");
        return r10;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Class.class) == false) goto L9;
        Class<?> r3 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.aiagent.plugin");
    L10:
        String r5 = r3.getName();
        if (r5.startsWith("java.") == false) goto L14;
        r5 = r3.getSimpleName();
    L19:
        r10.append('(').append(r5).append(')');
        if (b() == false) goto L36;
        int r4 = f();
        int[] r6 = {d(), e()};
        String r8 = " chars";
        if (ZeusTransformUtils.instanceOf(r2, CharSequence.class) == false) goto L25;
        String r0 = a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), r6, r4);
    L31:
        if (r0 == null) goto L41;
        a(r10, r0);
        if (r6[1] <= r4) goto L41;
        r10.append("[truncated ").append(r6[1] - r4).append(r8).append(']');
    L41:
        return r10;
    L25:
        if ((r2 instanceof char[]) == false) goto L28;
        r0 = a((char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r2, char[].class, "com.obric.aiagent.plugin"), char[].class, "com.obric.aiagent.plugin"), r6, r4);
        goto L31
    L28:
        if ((r2 instanceof byte[]) == false) goto L30;
        r0 = a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin"), r6, r4);
        r8 = " bytes";
        goto L31
    L30:
        r0 = null;
        goto L31
    L36:
        if ((r2 instanceof byte[]) == false) goto L41;
        int r9 = e();
        if (r9 >= 0) goto L40;
        r9 = ((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin")).length;
    L40:
        r10.append('[').append(r9).append(" bytes]");
        goto L41
    L14:
        if ((r2 instanceof byte[]) == false) goto L17;
        r5 = "byte[]";
        goto L19
    L17:
        if ((r2 instanceof char[]) == false) goto L19;
        r5 = "char[]";
        goto L19
    L9:
        r3 = r2.getClass();
        goto L10
    }

    public String a(CharSequence r3, int[] r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        a(r4, r6.length());
        int r2 = r4[0];
        return r6.subSequence(r2, Math.min(r4[1], r5) + r2).toString();
    }

    public String a(char[] r2, int[] r3, int r4) {
        a(r3, r2.length);
        return new String(r2, r3[0], Math.min(r3[1], r4));
    }

    public String a(byte[] r2, int[] r3, int r4) {
        a(r3, r2.length);
        return new String(r2, r3[0], Math.min(r3[1], r4), Charset.forName("UTF-8"));
    }

    public void a(int[] r3, int r4) {
        int r0 = r3[0];
        if (r0 >= 0) goto L5;
        r0 = 0;
    L7:
        r3[0] = r0;
        int r1 = r3[1];
        int r5 = r4 - r0;
        if (r1 < 0) goto L10;
        if (r1 > r5) goto L10;
        return;
    L10:
        r3[1] = r5;
        return;
    L5:
        if (r0 < r4) goto L7;
        r0 = r4;
        goto L7
    }

    public int a(StringBuilder r6, String r7) {
        r6.append('\"');
        int r1 = r7.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        char r3 = r7.charAt(r2);
        if (Character.isISOControl(r3) == true) goto L7;
    L8:
        r6.append(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    L7:
        if (a(r6, r3) == true) goto L9;
    L10:
        r6.append('\"');
        return r7.length();
    }

    public boolean a(StringBuilder r1, int r2) {
        if (r2 != 13) goto L5;
        return false;
    L5:
        if (r2 == 10) goto L11;
        r1.append('\\');
        r1.append('u');
        r1.append(b.c((r2 >> 12) & 15));
        r1.append(b.c((r2 >> 8) & 15));
        r1.append(b.c((r2 >> 4) & 15));
        r1.append(b.c(r2 & 15));
        return true;
    L11:
        return false;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, d.class) == true) goto L11;
        return false;
    L11:
        d r7 = (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.aiagent.plugin");
        if (this.f11997c == r7.f11997c) goto L14;
    L38:
        return false;
    L14:
        if (this.f11998d != r7.f11998d) goto L38;
        Object r0 = r7.f11996b;
        Object r3 = this.f11996b;
        if (r3 != null) goto L22;
        if (r0 != null) goto L21;
        return true;
    L21:
        return false;
    L22:
        if (r0 != null) goto L25;
        return false;
    L25:
        if (ZeusTransformUtils.instanceOf(r3, File.class) == true) goto L37;
        if (ZeusTransformUtils.instanceOf(this.f11996b, URL.class) == true) goto L37;
        if (ZeusTransformUtils.instanceOf(this.f11996b, URI.class) == true) goto L37;
        if (this.f11996b != r7.f11996b) goto L35;
        return true;
    L35:
        return false;
    L37:
        return this.f11996b.equals(r0);
    }

    public int hashCode() {
        return Objects.hashCode(this.f11996b);
    }
}
