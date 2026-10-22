package com.stepos.agentframework.chatui;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/s1;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "data", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)Ljava/lang/String;", "", "Lcom/stepos/agentframework/chatui/J1;", "parts", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.s1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2047s1 {
    public static final C2047s1 INSTANCE = new C2047s1();

    public final void a(List<DisplayChatMessage> parts) {
        kotlin.jvm.internal.p.i(parts, "parts");
        HashMap map = new HashMap();
        Iterator<T> it = parts.iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF == null) {
                listF = C1173v.m();
            }
            for (DisplayTool displayTool : listF) {
                String strB = INSTANCE.b(displayTool.getAppUIData());
                if (strB != null) {
                    DisplayTool displayTool2 = (DisplayTool) map.get(strB);
                    if (displayTool2 == null) {
                        map.put(strB, displayTool);
                    } else {
                        displayTool2.n(displayTool.getAppUIData());
                        displayTool.n(null);
                    }
                }
            }
        }
    }

    public final String b(AppUIData data) {
        if (!kotlin.jvm.internal.p.d(data != null ? data.getAppUIName() : null, TripartiteAppUiCoercion.CARD_CENTER_ALIAS)) {
            return null;
        }
        Object structuredContent = data.getStructuredContent();
        Map map = structuredContent instanceof Map ? (Map) structuredContent : null;
        if (map == null) {
            return null;
        }
        Object obj = map.get("taskId");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || La.H.x0(str)) {
            return null;
        }
        return str;
    }
}
