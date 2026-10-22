package ch.qos.logback.core.pattern.util;

import B0.g;

/* loaded from: classes.dex */
public class RegularEscapeUtil implements IEscapeUtil {
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[PHI: r3
      0x003c: PHI (r3v8 char) = (r3v5 char), (r3v6 char), (r3v7 char) binds: [B:19:0x003a, B:22:0x0040, B:25:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String basicEscape(java.lang.String r6) {
        /*
            int r0 = r6.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
        La:
            if (r2 >= r0) goto L51
            int r3 = r2 + 1
            char r4 = r6.charAt(r2)
            r5 = 92
            if (r4 != r5) goto L4c
            int r2 = r2 + 2
            char r4 = r6.charAt(r3)
            r3 = 110(0x6e, float:1.54E-43)
            if (r4 != r3) goto L23
            r4 = 10
            goto L4d
        L23:
            r3 = 114(0x72, float:1.6E-43)
            if (r4 != r3) goto L2a
            r4 = 13
            goto L4d
        L2a:
            r3 = 116(0x74, float:1.63E-43)
            if (r4 != r3) goto L31
            r4 = 9
            goto L4d
        L31:
            r3 = 102(0x66, float:1.43E-43)
            if (r4 != r3) goto L38
            r4 = 12
            goto L4d
        L38:
            r3 = 8
            if (r4 != r3) goto L3e
        L3c:
            r4 = r3
            goto L4d
        L3e:
            r3 = 34
            if (r4 != r3) goto L43
            goto L3c
        L43:
            r3 = 39
            if (r4 != r3) goto L48
            goto L3c
        L48:
            if (r4 != r5) goto L4d
            r4 = r5
            goto L4d
        L4c:
            r2 = r3
        L4d:
            r1.append(r4)
            goto La
        L51:
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.pattern.util.RegularEscapeUtil.basicEscape(java.lang.String):java.lang.String");
    }

    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c4, int i4) {
        if (str.indexOf(c4) >= 0) {
            stringBuffer.append(c4);
            return;
        }
        if (c4 == '\\') {
            stringBuffer.append(c4);
            return;
        }
        if (c4 != '_') {
            if (c4 == 'n') {
                stringBuffer.append('\n');
                return;
            }
            if (c4 == 'r') {
                stringBuffer.append('\r');
                return;
            }
            if (c4 == 't') {
                stringBuffer.append('\t');
                return;
            }
            String escapeCharsForListing = formatEscapeCharsForListing(str);
            StringBuilder sb = new StringBuilder("Illegal char '");
            sb.append(c4);
            sb.append(" at column ");
            sb.append(i4);
            sb.append(". Only \\\\, \\_");
            throw new IllegalArgumentException(g.r(sb, escapeCharsForListing, ", \\t, \\n, \\r combinations are allowed as escape characters."));
        }
    }

    public String formatEscapeCharsForListing(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < str.length(); i4++) {
            sb.append(", \\");
            sb.append(str.charAt(i4));
        }
        return sb.toString();
    }
}
