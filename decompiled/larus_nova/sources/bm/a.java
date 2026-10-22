package bm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f19537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f19538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, b> f19539c;

    public final JSONObject b() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L13
        Iterator r103 = ((LinkedHashMap) this.f19537a).entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L13
        r102.putOpt((String) r104.getKey(), r104.getValue());     // Catch: Throwable -> L13
        goto L5
    L7:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r100.putOpt("common", r102);     // Catch: Throwable -> L13
        JSONArray r106 = new JSONArray();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, b>> r107 = this.f19539c.entrySet().iterator();     // Catch: Throwable -> L13
    L9:
        if (r107.hasNext() == false) goto L11;
        r106.put(r107.next().getValue().a());     // Catch: Throwable -> L13
        goto L9
    L11:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L13
        Result.m9449constructorimpl(r100.putOpt("stages", r106));     // Catch: Throwable -> L13
    L15:
        return r100;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public a() {
        this.f19537a = new LinkedHashMap();
        this.f19538b = new LinkedHashMap();
        this.f19539c = new LinkedHashMap();
    }

    public final a a(String r100) {
        a r101 = new a();
        r101.f19538b.putAll(this.f19538b);
        r101.f19537a.putAll(this.f19537a);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L15;
        LinkedHashMap<String, b> r103 = this.f19539c;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
        Iterator<T> r105 = r103.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry r106 = (Map.Entry) r105.next();
        Object r107 = r106.getKey();
        b r108 = (b) r106.getValue();
        r108.getClass();
        b r109 = new b(r108.f19542c, r108.f19543d);
        r109.f19540a = r108.f19540a;
        r109.update(r108.f19541b);
        r104.put(r107, r109);
        goto L12
    L14:
        r101.f19539c.putAll(r104);
    L18:
        return r101;
    L15:
        b r110 = this.f19539c.get(r100);
        if (r110 == null) goto L18;
        LinkedHashMap<String, b> r111 = r101.f19539c;
        b r112 = new b(r110.f19542c, r110.f19543d);
        r112.f19540a = r110.f19540a;
        r112.update(r110.f19541b);
        b r113 = r111.put(r100, r112);
        goto L18
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
