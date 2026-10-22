package b43;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.shopping.buynow.utils.n;
import com.bytedance.android.shopping.utils.l0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f17507a = null;

    public c() {
    }

    static {
        f17507a = new c();
    }

    public static boolean c(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (StringsKt.isBlank(r100) != true) goto L6;
        return true;
    }

    public static Map d(String r100) {
        if (r100 != null) goto L8;
    L5:
        return null;
    L8:
        int r101 = t0.f45720a;     // Catch: Exception -> L7
        return (Map) t0.a.f45721a.fromJson(r100, new b().getType());
    }

    public static String e(Object r100) {
        return com.bytedance.android.shopping.extensions.k.x(r100);
    L4:
        return null;
    }

    public static String a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator r102 = r101.entrySet().iterator();
        String r103 = r100;
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r102.next();
        r103 = l0.a(r100, (String) r104.getKey(), (String) r104.getValue());
        goto L4
    L6:
        return r103;
    }

    public final Object b(Map r100, String r110) {
        if (r110 == null) goto L5;
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
    L6:
        Object r101 = n.a(r100, r111, 0);
        if ((r101 instanceof Object) == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r111 = null;
        goto L6
    }
}
