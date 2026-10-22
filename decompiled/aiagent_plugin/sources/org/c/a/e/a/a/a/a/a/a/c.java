package org.c.a.e.a.a.a.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UnicodeEscaper.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f40414a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<char[]> f40415b = null;

    public abstract char[] a(int r1);

    public c() {
    }

    public int a(CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    L3:
        if (r4 >= r5) goto L14;
        int r0 = b(r6, r4, r5);
        if (r0 < 0) goto L14;
        if (a(r0) != null) goto L14;
        if (Character.isSupplementaryCodePoint(r0) == false) goto L12;
        int r1 = 2;
    L13:
        r4 = r4 + r1;
        goto L3
    L12:
        r1 = 1;
    L14:
        return r4;
    }

    @Override // org.c.a.e.a.a.a.a.a.a.a
    public String a(String r3) {
        int r0 = r3.length();
        int r1 = a(r3, 0, r0);
        if (r1 != r0) goto L6;
        return r3;
    L6:
        return a(r3, r1);
    }

    public final String a(String r12, int r13) {
        int r0 = r12.length();
        char[] r1 = (char[]) ZeusTransformUtils.preCheckCast(f40415b.get(), char[].class, "com.obric.aiagent.plugin");
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r13 >= r0) goto L23;
        int r5 = b(r12, r13, r0);
        if (r5 < 0) goto L22;
        char[] r6 = a(r5);
        if (r6 == null) goto L17;
        int r7 = r13 - r3;
        int r8 = r4 + r7;
        int r9 = r6.length + r8;
        if (r1.length >= r9) goto L11;
        r1 = a(r1, r4, (r9 + (r0 - r13)) + 32);
    L11:
        if (r7 <= 0) goto L14;
        r12.getChars(r3, r13, r1, r4);
        r4 = r8;
    L14:
        if (r6.length <= 0) goto L17;
        System.arraycopy(r6, 0, r1, r4, r6.length);
        r4 = r4 + r6.length;
    L17:
        if (Character.isSupplementaryCodePoint(r5) == false) goto L19;
        int r10 = 2;
    L20:
        r3 = r10 + r13;
        r13 = a(r12, r3, r0);
        goto L3
    L19:
        r10 = 1;
        goto L20
    L22:
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
    L23:
        int r11 = r0 - r3;
        if (r11 <= 0) goto L30;
        int r14 = r11 + r4;
        if (r1.length >= r14) goto L28;
        r1 = a(r1, r4, r14);
    L28:
        r12.getChars(r3, r0, r1, r4);
        r4 = r14;
    L30:
        return new String(r1, 0, r4);
    }

    public static final int b(CharSequence r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 >= r6) goto L24;
        int r0 = r5 + 1;
        char r8 = r7.charAt(r5);
        if (r8 >= 55296) goto L7;
    L22:
        return r8;
    L7:
        if (r8 > 57343) goto L22;
        if (r8 > 56319) goto L21;
        if (r0 == r6) goto L13;
        char r9 = r7.charAt(r0);
        if (Character.isLowSurrogate(r9) == false) goto L19;
        return Character.toCodePoint(r8, r9);
    L19:
        throw new IllegalArgumentException("Expected low surrogate but got char '" + r9 + "' with value " + r9 + " at index " + r0);
    L13:
        return -r8;
    L21:
        throw new IllegalArgumentException("Unexpected low surrogate character '" + r8 + "' with value " + r8 + " at index " + (r0 - 1));
    L24:
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static final char[] a(char[] r1, int r2, int r3) {
        char[] r4 = new char[r3];
        if (r2 <= 0) goto L5;
        System.arraycopy(r1, 0, r4, 0, r2);
    L5:
        return r4;
    }

    static {
        f40415b = new AnonymousClass1();
    }
}
