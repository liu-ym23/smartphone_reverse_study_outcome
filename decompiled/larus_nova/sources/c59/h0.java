package c59;

import com.bytedance.keva.Keva;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f22511a = null;

    static {
        f22511a = new ConcurrentHashMap();
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        g49.d.a("DslUrlRepo", "save dsl url ");
        Iterator r101 = r100.entrySet().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L16;
        Map.Entry r103 = (Map.Entry) r101.next();
        ConcurrentHashMap<String, String> r104 = f22511a;
        if (Intrinsics.areEqual(r104.get(r103.getKey()), r103.getValue()) == true) goto L11;
        if (r103.getValue() == null) goto L11;
        r102 = true;
    L11:
        if (r103.getValue() == null) goto L4;
        Object r105 = r103.getKey();
        String r106 = (String) r103.getValue();
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r104.put((String) r105, r106);
        goto L4
    L16:
        if (r102 == false) goto L26;
        Lazy r107 = s.f22521a;
        String r108 = s.d(f22511a);
        if (r108 == null) goto L27;
        Keva r109 = g49.c.f480007a;
        Intrinsics.checkNotNullParameter(r108, "value");
        g49.c.f480007a.storeString("key_dora_kv_starling", r108);
        return;
    L27:
        return;
    }
}
