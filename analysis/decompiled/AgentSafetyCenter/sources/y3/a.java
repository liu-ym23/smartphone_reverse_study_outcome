package y3;

import java.util.Map;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public static final a f15882c = new a(1);

    @Override // xb.l
    public final Object invoke(Object obj) {
        String strValueOf;
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((CharSequence) "[");
            int i = 0;
            for (byte b10 : (byte[]) value) {
                i++;
                if (i > 1) {
                    sb2.append((CharSequence) ", ");
                }
                sb2.append((CharSequence) String.valueOf((int) b10));
            }
            sb2.append((CharSequence) "]");
            strValueOf = sb2.toString();
        } else {
            strValueOf = String.valueOf(entry.getValue());
        }
        return "  " + ((e) entry.getKey()).f15891a + " = " + strValueOf;
    }
}
