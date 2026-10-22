package io.ktor.server.config;

import La.C;
import La.H;
import La.K;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0006\u001a+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", Parameters.ROOT, "", "relative", "combine", "(Ljava/lang/String;I)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "input", "", "listElements", "LY8/t;", "findListElements", "(Ljava/lang/String;Ljava/util/Map;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapApplicationConfigKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String combine(String str, int i10) {
        return combine(str, String.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void findListElements(String str, Map<String, Integer> map) {
        int iT0 = H.t0(str, '.', 0, false, 6, null);
        while (iT0 != str.length()) {
            int i10 = iT0 + 1;
            int iT02 = H.t0(str, '.', i10, false, 4, null);
            if (iT02 == -1) {
                iT02 = str.length();
            }
            String strSubstring = str.substring(i10, iT02);
            p.h(strSubstring, "substring(...)");
            Integer numW = C.w(strSubstring);
            if (numW != null) {
                int iIntValue = numW.intValue();
                String strR1 = K.R1(str, iT0);
                int iMax = iIntValue + 1;
                Integer num = map.get(strR1);
                if (num != null) {
                    iMax = Math.max(num.intValue(), iMax);
                }
                map.put(strR1, Integer.valueOf(iMax));
            }
            iT0 = iT02;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String combine(String str, String str2) {
        if (str.length() == 0) {
            return str2;
        }
        return str + '.' + str2;
    }
}
