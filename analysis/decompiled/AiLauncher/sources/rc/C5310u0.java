package rc;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* renamed from: rc.u0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5310u0 {
    public static final Map<String, String> a(String str) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, Const.STR_MART_COMMA);
            while (stringTokenizer.hasMoreTokens()) {
                String[] strArrSplit = stringTokenizer.nextToken().trim().split("=");
                if (strArrSplit != null) {
                    if (strArrSplit.length == 2) {
                        map.put(strArrSplit[0].trim(), strArrSplit[1].trim());
                    } else if (strArrSplit.length == 1) {
                        map.put(strArrSplit[0].trim(), null);
                    }
                }
            }
        }
        return map;
    }
}
