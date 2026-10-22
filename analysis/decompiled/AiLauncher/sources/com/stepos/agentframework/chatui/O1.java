package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "", "source", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class O1 {
    public static final AppUIData b(AppUIData appUIData, String str) {
        if (!kotlin.jvm.internal.p.d(str, "realtime")) {
            return appUIData;
        }
        Object structuredContent = appUIData.getStructuredContent();
        Map map = structuredContent instanceof Map ? (Map) structuredContent : null;
        if (map == null) {
            return appUIData;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && !kotlin.jvm.internal.p.d(key, "__client_render_source")) {
                linkedHashMap.put(key, value);
            }
        }
        linkedHashMap.put("__client_render_source", "realtime");
        return appUIData.copy((65407 & 1) != 0 ? appUIData.id : null, (65407 & 2) != 0 ? appUIData.uiType : 0, (65407 & 4) != 0 ? appUIData.title : null, (65407 & 8) != 0 ? appUIData.isFixed : false, (65407 & 16) != 0 ? appUIData.appUIName : null, (65407 & 32) != 0 ? appUIData.description : null, (65407 & 64) != 0 ? appUIData.content : null, (65407 & 128) != 0 ? appUIData.structuredContent : linkedHashMap, (65407 & 256) != 0 ? appUIData.url : null, (65407 & 512) != 0 ? appUIData.html : null, (65407 & 1024) != 0 ? appUIData.packageName : null, (65407 & 2048) != 0 ? appUIData.widgetCls : null, (65407 & 4096) != 0 ? appUIData.widgetAction : null, (65407 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? appUIData.guiAgentModelName : null, (65407 & 16384) != 0 ? appUIData.holdUntilComplete : false, (65407 & 32768) != 0 ? appUIData.holdAtTop : false);
    }
}
