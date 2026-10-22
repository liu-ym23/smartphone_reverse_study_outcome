package zc;

import com.fasterxml.jackson.core.JsonFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f16577a;

    static {
        String[] strArr = new String[93];
        for (int i = 0; i < 32; i++) {
            strArr[i] = "\\u" + b(i >> 12) + b(i >> 8) + b(i >> 4) + b(i);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f16577a = strArr;
        byte[] bArr = new byte[93];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr[i3] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
    }

    public static final void a(StringBuilder sb2, String str) {
        str.getClass();
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = str.length();
        int i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            String[] strArr = f16577a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb2.append((CharSequence) str, i, i3);
                sb2.append(strArr[cCharAt]);
                i = i3 + 1;
            }
        }
        if (i != 0) {
            sb2.append((CharSequence) str, i, str.length());
        } else {
            sb2.append(str);
        }
        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    public static final char b(int i) {
        int i3 = i & 15;
        return (char) (i3 < 10 ? i3 + 48 : i3 + 87);
    }
}
