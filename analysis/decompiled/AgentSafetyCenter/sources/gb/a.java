package gb;

import ae.b;
import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f4675a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* renamed from: b, reason: collision with root package name */
    public static final b f4676b = new b(3);

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH;
            }
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = f4675a;
            sb2.append(strArr[i / 16]);
            sb2.append(strArr[i % 16]);
            stringBuffer.append(sb2.toString());
        }
        return stringBuffer.toString();
    }
}
