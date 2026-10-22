package ay9;

import android.app.Application;
import by7.g;
import dy7.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Function0<Object>> f16771a = null;

    public static final class a implements cy7.b {
        public a() {
        }

        @Override // cy7.b
        public final void intercept(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Iterator r102 = ((LinkedHashMap) b.f16771a).entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Map.Entry r103 = (Map.Entry) r102.next();
            if (r101 == null) goto L4;
            r101.put((String) r103.getKey(), ((Function0) r103.getValue()).invoke());
            goto L4
        }
    }

    static {
        f16771a = new LinkedHashMap();
    }

    public static void a(Application r100, by7.b r101) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "sender");
        g.f21470a = r101;
        r100.registerActivityLifecycleCallbacks(c.f470548b);
        MapsKt.putAll(g.f21472c, new Pair[]{TuplesKt.to("current_page", "previous_page")});
        g.a(new a());
    }
}
