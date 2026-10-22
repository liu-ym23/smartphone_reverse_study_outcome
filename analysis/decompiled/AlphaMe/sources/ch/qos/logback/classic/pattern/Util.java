package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ClassPackagingData;
import java.util.HashMap;
import java.util.Map;
import n3.e;
import o3.a;

/* loaded from: classes.dex */
public class Util {
    static Map<String, ClassPackagingData> cache = new HashMap();

    public static boolean match(e eVar, e[] eVarArr) {
        if (eVarArr == null) {
            throw new IllegalArgumentException("markerArray should not be null");
        }
        for (e eVar2 : eVarArr) {
            if (((a) eVar).a(eVar2)) {
                return true;
            }
        }
        return false;
    }
}
