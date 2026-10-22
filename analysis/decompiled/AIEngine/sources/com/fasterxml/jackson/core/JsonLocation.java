package com.fasterxml.jackson.core;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonLocation implements Serializable {
    public static final JsonLocation h = new JsonLocation(-1, -1, -1, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final long f3552a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3553b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3554c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3555d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object f3556e;

    public JsonLocation(int i10, long j10, long j11, int i11, Object obj) {
        this.f3556e = obj;
        this.f3552a = j10;
        this.f3553b = j11;
        this.f3554c = i10;
        this.f3555d = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        Object obj2 = jsonLocation.f3556e;
        Object obj3 = this.f3556e;
        if (obj3 == null) {
            if (obj2 != null) {
                return false;
            }
        } else if (!obj3.equals(obj2)) {
            return false;
        }
        return this.f3554c == jsonLocation.f3554c && this.f3555d == jsonLocation.f3555d && this.f3553b == jsonLocation.f3553b && this.f3552a == jsonLocation.f3552a;
    }

    public final int hashCode() {
        Object obj = this.f3556e;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.f3554c) + this.f3555d) ^ ((int) this.f3553b)) + ((int) this.f3552a);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 80
            r0.<init>(r1)
            java.lang.String r1 = "[Source: "
            r0.append(r1)
            r1 = 93
            java.lang.Object r2 = r9.f3556e
            if (r2 != 0) goto L19
            java.lang.String r2 = "UNKNOWN"
            r0.append(r2)
            goto Lcf
        L19:
            boolean r3 = r2 instanceof java.lang.Class
            if (r3 == 0) goto L21
            r3 = r2
            java.lang.Class r3 = (java.lang.Class) r3
            goto L25
        L21:
            java.lang.Class r3 = r2.getClass()
        L25:
            java.lang.String r4 = r3.getName()
            java.lang.String r5 = "java."
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L36
            java.lang.String r4 = r3.getSimpleName()
            goto L43
        L36:
            boolean r3 = r2 instanceof byte[]
            if (r3 == 0) goto L3d
            java.lang.String r4 = "byte[]"
            goto L43
        L3d:
            boolean r3 = r2 instanceof char[]
            if (r3 == 0) goto L43
            java.lang.String r4 = "char[]"
        L43:
            r3 = 40
            r0.append(r3)
            r0.append(r4)
            r3 = 41
            r0.append(r3)
            boolean r3 = r2 instanceof java.lang.CharSequence
            r4 = 34
            r5 = 500(0x1f4, float:7.0E-43)
            r6 = 0
            java.lang.String r7 = " chars"
            if (r3 == 0) goto L7d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r3 = r2.length()
            int r5 = java.lang.Math.min(r3, r5)
            java.lang.CharSequence r2 = r2.subSequence(r6, r5)
            java.lang.String r2 = r2.toString()
            r0.append(r4)
            r0.append(r2)
            r0.append(r4)
            int r2 = r2.length()
        L7a:
            int r6 = r3 - r2
            goto Lbf
        L7d:
            boolean r3 = r2 instanceof char[]
            if (r3 == 0) goto L9b
            char[] r2 = (char[]) r2
            int r3 = r2.length
            java.lang.String r8 = new java.lang.String
            int r5 = java.lang.Math.min(r3, r5)
            r8.<init>(r2, r6, r5)
            r0.append(r4)
            r0.append(r8)
            r0.append(r4)
            int r2 = r8.length()
            goto L7a
        L9b:
            boolean r3 = r2 instanceof byte[]
            if (r3 == 0) goto Lbf
            byte[] r2 = (byte[]) r2
            int r3 = r2.length
            int r3 = java.lang.Math.min(r3, r5)
            java.lang.String r5 = new java.lang.String
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)
            r5.<init>(r2, r6, r3, r7)
            r0.append(r4)
            r0.append(r5)
            r0.append(r4)
            int r2 = r2.length
            int r6 = r2 - r3
            java.lang.String r7 = " bytes"
        Lbf:
            if (r6 <= 0) goto Lcf
            java.lang.String r2 = "[truncated "
            r0.append(r2)
            r0.append(r6)
            r0.append(r7)
            r0.append(r1)
        Lcf:
            java.lang.String r2 = "; line: "
            r0.append(r2)
            int r2 = r9.f3554c
            r0.append(r2)
            java.lang.String r2 = ", column: "
            r0.append(r2)
            int r9 = r9.f3555d
            java.lang.String r9 = a0.a.l(r0, r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.JsonLocation.toString():java.lang.String");
    }
}
