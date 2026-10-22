package D9;

import com.fasterxml.jackson.core.JsonFactory;

/* loaded from: classes4.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f448a;
    public static final byte[] b;

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
        f448a = strArr;
        byte[] bArr = new byte[93];
        for (int i6 = 0; i6 < 32; i6++) {
            bArr[i6] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        b = bArr;
    }

    public static final void a(StringBuilder sb, String value) {
        kotlin.jvm.internal.k.f(value, "value");
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = value.length();
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = value.charAt(i6);
            String[] strArr = f448a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i, i6);
                sb.append(strArr[cCharAt]);
                i = i6 + 1;
            }
        }
        if (i != 0) {
            sb.append((CharSequence) value, i, value.length());
        } else {
            sb.append(value);
        }
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    public static final char b(int i) {
        int i6 = i & 15;
        return (char) (i6 < 10 ? i6 + 48 : i6 + 87);
    }
}
