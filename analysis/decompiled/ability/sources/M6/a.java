package M6;

import K9.c;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f971a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    public static final c b = new c(1);

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f971a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
