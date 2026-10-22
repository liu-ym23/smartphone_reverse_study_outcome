package s2;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class i {
    public static void a(StringBuilder sb2, HashMap<String, String> map) {
        sb2.append(Const.STR_MART_JSON_BEGIN);
        boolean z10 = true;
        for (String str : map.keySet()) {
            if (!z10) {
                sb2.append(Const.STR_MART_COMMA);
            }
            String str2 = map.get(str);
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (str2 == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\"");
            }
            z10 = false;
        }
        sb2.append("}");
    }
}
