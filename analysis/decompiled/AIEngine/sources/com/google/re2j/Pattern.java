package com.google.re2j;

import java.io.Serializable;
import l5.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Pattern implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f5492a;

    /* renamed from: b, reason: collision with root package name */
    public final transient h f5493b;

    public Pattern(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("pattern is null");
        }
        this.f5492a = str;
        this.f5493b = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01b8, code lost:
    
        if (r9 >= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ba, code lost:
    
        if (r10 == false) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01bc, code lost:
    
        r7 = ~r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bd, code lost:
    
        if (r11 != 58) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01bf, code lost:
    
        r3.j(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c2, code lost:
    
        r3.f5483b = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01d1, code lost:
    
        throw new com.google.re2j.PatternSyntaxException("invalid or unsupported Perl syntax", r8.a(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0274, code lost:
    
        throw new com.google.re2j.PatternSyntaxException("invalid repeat count", r8.a(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0446, code lost:
    
        r8.f5491b = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0451, code lost:
    
        throw new com.google.re2j.PatternSyntaxException("invalid character class range", r8.g());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0171, code lost:
    
        throw new com.google.re2j.PatternSyntaxException("invalid named capture", r9.substring(0, r4));
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.re2j.Pattern a(java.lang.String r25) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 1638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.re2j.Pattern.a(java.lang.String):com.google.re2j.Pattern");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Pattern.class == obj.getClass() && this.f5492a.equals(((Pattern) obj).f5492a);
    }

    public final int hashCode() {
        return (this.f5492a.hashCode() * 31) + 1;
    }

    public Object readResolve() {
        return a(this.f5492a);
    }

    public final String toString() {
        return this.f5492a;
    }
}
