package io.ktor.websocket;

import La.H;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", UxipConstants.f30680s, "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "parseWebSocketExtensions", "(Ljava/lang/String;)Ljava/util/List;", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketExtensionHeaderKt {
    public static final List<WebSocketExtensionHeader> parseWebSocketExtensions(String value) {
        p.i(value, "value");
        List listB1 = H.b1(value, new String[]{Const.STR_MART_COMMA}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(C1174w.x(listB1, 10));
        Iterator it = listB1.iterator();
        while (it.hasNext()) {
            List listB12 = H.b1((String) it.next(), new String[]{Const.STR_MART_SEMICOLON}, false, 0, 6, null);
            String string = H.D1((String) F.q0(listB12)).toString();
            List listH0 = F.h0(listB12, 1);
            ArrayList arrayList2 = new ArrayList(C1174w.x(listH0, 10));
            Iterator it2 = listH0.iterator();
            while (it2.hasNext()) {
                arrayList2.add(H.D1((String) it2.next()).toString());
            }
            arrayList.add(new WebSocketExtensionHeader(string, arrayList2));
        }
        return arrayList;
    }
}
