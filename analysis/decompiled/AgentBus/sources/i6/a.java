package i6;

import fb.c;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4730a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* renamed from: b, reason: collision with root package name */
    public static final c f4731b = new c(5);

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = f4730a;
            sb2.append(strArr[i2 / 16]);
            sb2.append(strArr[i2 % 16]);
            stringBuffer.append(sb2.toString());
        }
        return stringBuffer.toString();
    }
}
