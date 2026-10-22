package t;

import K.E0;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LK/E0;", "", "", "", Const.INTENT_KEY_APIKEY, "(LK/E0;)Ljava/util/Map;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r0 {
    public static final Map<String, Object> a(E0 e02) {
        kotlin.jvm.internal.p.i(e02, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> setE = e02.e();
        kotlin.jvm.internal.p.h(setE, "listKeys(...)");
        for (String str : setE) {
            Object objD = e02.d(str);
            kotlin.jvm.internal.p.g(objD, "null cannot be cast to non-null type kotlin.Any");
            linkedHashMap.put(str, objD);
        }
        return linkedHashMap;
    }
}
