package g5;

import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public static final g f4316c = new g(1);

    @Override // xb.l
    public final Object invoke(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        StringBuilder sbV = k0.a.v(str, " : ");
        if (value instanceof Object[]) {
            value = Arrays.toString((Object[]) value);
            value.getClass();
        }
        sbV.append(value);
        return sbV.toString();
    }
}
