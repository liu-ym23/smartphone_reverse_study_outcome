package v7;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final e f14845f;

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f14846g;

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f14847h;

    /* renamed from: c, reason: collision with root package name */
    public f f14848c;

    static {
        e eVar = new e();
        eVar.f14848c = new f("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        VarHandle.storeStoreFence();
        f14845f = eVar;
        f14846g = Pattern.compile("\\d{1,3}");
        f14847h = Pattern.compile("[^\\s/%]+");
    }

    public final boolean a(String str) {
        String[] strArrA = this.f14848c.a(str);
        if (strArrA == null) {
            return false;
        }
        for (String str2 : strArrA) {
            if (str2 != null && !str2.isEmpty()) {
                try {
                    if (Integer.parseInt(str2) > 255) {
                        return false;
                    }
                    if (str2.length() > 1 && str2.startsWith("0")) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return true;
    }
}
