package bl9;

import android.util.Pair;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f19513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, List<String>> f19514b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, List<String>> f19515c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, List<Pair<String, List<String>>>> f19516d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, List<String>> f19517e = null;

    static {
        f19513a = new HashMap();
        f19514b = new HashMap();
        f19515c = new HashMap();
        f19516d = new HashMap();
        f19517e = new HashMap();
        AppHost.f326268a.getApplication().getPackageName();
        HashMap r100 = new HashMap();
        int r101 = dl9.a.f469162a;
        Iterator r102 = MapsKt.emptyMap().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Map r105 = (Map) r103.getValue();
        ((HashMap) f19515c).put(r104, CollectionsKt.toList(r105.keySet()));
        Iterator r106 = r105.entrySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L4;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        List r109 = (List) r107.getValue();
        f19513a.put(r108, r104);
        r100.put(r108, r109);
        goto L7
    L9:
        Iterator r110 = ((HashMap) f19515c).entrySet().iterator();
    L11:
        if (r110.hasNext() == false) goto L45;
        Map.Entry r111 = (Map.Entry) r110.next();
        String r112 = (String) r111.getKey();
        List r113 = (List) r111.getValue();
        LinkedHashSet r114 = new LinkedHashSet();
        Iterator r115 = r113.iterator();
    L14:
        if (r115.hasNext() == false) goto L29;
        String r116 = (String) r115.next();
        List r117 = (List) r100.get(r116);
        if (r117 == null) goto L18;
        r114.addAll(r117);
    L18:
        a(r116, r100);
        Set r118 = SetsKt.mutableSetOf(new String[]{r112});
        List r119 = (List) ((HashMap) f19517e).get(r116);
        if (r119 == null) goto L28;
        Iterator r120 = r119.iterator();
    L22:
        if (r120.hasNext() == false) goto L28;
        String r121 = f19513a.get((String) r120.next());
        if (r121 == null) goto L27;
        r118.add(r121);
        goto L22
    L27:
        throw new NotImplementedError("An operation is not implemented: 找不到Owner");
    L28:
        ((HashMap) f19514b).put(r116, CollectionsKt.toList(r118));
        goto L14
    L29:
        Map<String, List<Pair<String, List<String>>>> r122 = f19516d;
        LinkedHashMap r123 = new LinkedHashMap();
        Iterator r124 = r114.iterator();
    L31:
        if (r124.hasNext() == false) goto L40;
        Object r125 = r124.next();
        String r126 = f19513a.get((String) r125);
        if (r126 == null) goto L39;
        Object r127 = r123.get(r126);
        if (r127 != null) goto L37;
        r127 = new ArrayList();
        r123.put(r126, r127);
    L37:
        ((List) r127).add(r125);
        goto L31
    L39:
        throw new NotImplementedError("An operation is not implemented: 找不到Owner");
    L40:
        ArrayList r128 = new ArrayList(r123.size());
        Iterator r129 = r123.entrySet().iterator();
    L42:
        if (r129.hasNext() == false) goto L44;
        Map.Entry r130 = (Map.Entry) r129.next();
        r128.add(new Pair(r130.getKey(), r130.getValue()));
        goto L42
    L44:
        ((HashMap) r122).put(r112, r128);
        goto L11
    }

    public static void a(String r100, Map r101) {
        if (((HashMap) f19517e).get(r100) != null) goto L29;
        HashMap r102 = (HashMap) r101;
        Collection r103 = (Collection) r102.get(r100);
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L30;
        LinkedHashSet r105 = new LinkedHashSet();
        List r106 = (List) r102.get(r100);
        if (r106 == null) goto L22;
        Iterator r107 = r106.iterator();
    L17:
        if (r107.hasNext() == false) goto L22;
        String r108 = (String) r107.next();
        r105.add(r108);
        a(r108, r101);
        List r109 = (List) ((HashMap) f19517e).get(r108);
        if (r109 == null) goto L17;
        r105.addAll(r109);
    L22:
        Map<String, List<String>> r110 = f19517e;
        HashMap r111 = (HashMap) r110;
        r111.put(r100, CollectionsKt.toList(r105));
        return;
    L30:
        return;
    L7:
        if (r103.isEmpty() == true) goto L10;
        r104 = false;
        goto L11
    }
}
