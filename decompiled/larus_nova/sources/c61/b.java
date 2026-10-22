package c61;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f22531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22532b;

    public final a a() {
        String r100 = this.f22532b;
        HashMap r101 = (HashMap) this.f22531a;
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        Object r106 = r104.getValue();
        if (r106 == null) goto L9;
        String r107 = r106.toString();
        if (r107 == null) goto L9;
    L10:
        r102.put(r105, r107);
    L9:
        r107 = "";
        goto L10
    L12:
        return new a(r100, r102);
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f22532b = r100;
        this.f22531a = new HashMap();
    }

    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ((HashMap) this.f22531a).put(r100, r101);
    }
}
