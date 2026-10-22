package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public interface o {

    public static final class a {
        public static void a(o r110, LinkMonitorData r111, String r112, int r113, Integer r114, String r115, Boolean r116, Map r117, int r118) {
            Map r100 = null;
            if ((r118 & 2) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r118 & 4) == 0) goto L9;
            int r102 = 0;
        L11:
            if ((r118 & 8) == 0) goto L13;
            Integer r103 = null;
        L15:
            if ((r118 & 16) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r118 & 32) == 0) goto L21;
            Boolean r105 = null;
        L23:
            if ((r118 & 64) != 0) goto L26;
            r100 = r117;
        L26:
            Intrinsics.checkNotNullParameter(r111, "linkMonitorData");
            LinkMonitorData r106 = LinkMonitorData.StartXPlayBasic;
            if (r106 != r111) goto L30;
            ff0.g.f476652d = System.currentTimeMillis();
        L30:
            if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L34;
            if (r106 != r111) goto L34;
            ff0.g.f476651c = false;
        L34:
            if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L38;
            if (r106 != r111) goto L38;
            ff0.g.f476651c = true;
        L38:
            if (LinkMonitorData.LoadXplayBasic != r111) goto L42;
            if (r102 != 0) goto L42;
            ff0.g.f476651c = true;
        L42:
            if (LinkMonitorData.XplayShowAndFirstFrameSuccess == r111) goto L44;
        L46:
            if (r105 == null) goto L48;
            r105.booleanValue();
            ff0.g.f476649a = r105.booleanValue();
        L48:
            if (r101 == null) goto L50;
            ff0.g.f476650b = r101;
        L50:
            JSONObject r107 = new JSONObject();
            if (ff0.g.f476649a == false) goto L53;
            String r108 = SoloKtvContext.SOLO_PAGE_FIRST;
        L54:
            r107.put("create_type", r108);
            r107.put("game_id", ff0.g.f476650b);
            if (r103 == null) goto L57;
            r103.intValue();
            r107.put("reason", r103.intValue());
        L57:
            if (r104 == null) goto L59;
            r107.put("failure_reason", r104);
        L59:
            if (r100 == null) goto L64;
            Iterator r109 = r100.entrySet().iterator();
        L62:
            if (r109.hasNext() == false) goto L64;
            Map.Entry r119 = (Map.Entry) r109.next();
            r107.put((String) r119.getKey(), r119.getValue());
        L64:
            r107.put("duration", System.currentTimeMillis() - ff0.g.f476652d);
            nd0.c.p(nd0.c.f518746a, r111, r107, MultiLinkEventModule.INTERACT_XPLAY, r102, null, false, null, 112);
            return;
        L53:
            r108 = EventConstant.Value.RETRY;
            goto L54
        L44:
            if (ff0.g.f476651c == true) goto L46;
            return;
        L21:
            r105 = r116;
            goto L23
        L17:
            r104 = r115;
            goto L19
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }
}
