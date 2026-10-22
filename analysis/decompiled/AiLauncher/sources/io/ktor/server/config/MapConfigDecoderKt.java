package io.ktor.server.config;

import La.D;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "", "path", "", "listSize", "(Ljava/util/Map;Ljava/lang/String;)I", "prefix", "", "containsPrefix", "(Ljava/util/Map;Ljava/lang/String;)Z", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapConfigDecoderKt {
    public static final boolean containsPrefix(Map<String, String> map, String prefix) {
        p.i(map, "<this>");
        p.i(prefix, "prefix");
        if (prefix.length() == 0 || map.containsKey(prefix)) {
            return true;
        }
        if (map.containsKey(prefix + ".size")) {
            return true;
        }
        Set<String> setKeySet = map.keySet();
        if (!(setKeySet instanceof Collection) || !setKeySet.isEmpty()) {
            for (String str : setKeySet) {
                if (D.X(str, prefix, false, 2, null) && str.length() > prefix.length() && str.charAt(prefix.length()) == '.') {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int listSize(Map<String, String> map, String str) {
        String str2 = map.get(str + ".size");
        if (str2 == null) {
            str2 = "0";
        }
        return Integer.parseInt(str2);
    }
}
