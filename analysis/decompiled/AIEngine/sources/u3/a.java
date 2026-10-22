package u3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {
    public static void a(HashSet hashSet, Map map) {
        Map map2;
        List list = t3.a.f12936a;
        if (hashSet.isEmpty()) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!s3.a.a(str)) {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                Map map3 = map;
                for (int i10 = 0; i10 < length; i10++) {
                    char c9 = charArray[i10];
                    Object obj = map3.get(Character.valueOf(c9));
                    if (obj == null) {
                        HashMap map4 = new HashMap(8);
                        map4.put("ED", Boolean.FALSE);
                        map3.put(Character.valueOf(c9), map4);
                        map2 = map4;
                    } else {
                        map2 = (Map) obj;
                    }
                    map3 = map2;
                    if (i10 == length - 1) {
                        map3.put("ED", Boolean.TRUE);
                    }
                }
            }
        }
    }
}
