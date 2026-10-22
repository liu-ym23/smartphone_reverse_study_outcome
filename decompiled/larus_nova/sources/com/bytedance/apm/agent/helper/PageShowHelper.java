package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class PageShowHelper {
    public PageShowHelper() {
    }

    public static void onPageShowHideAction(Object r100, boolean r101) {
        if ((r100 instanceof String) == false) goto L5;
        String r102 = (String) r100;
    L6:
        JSONObject r103 = new JSONObject();
        if ((r100 instanceof IPageMonitor) == false) goto L12;
        r103.put("label", ((IPageMonitor) r100).getMonitorLabel());     // Catch: Exception -> L11
    L12:
        if (r101 == false) goto L14;
        String r104 = "page_show";
    L15:
        if (r101 == false) goto L17;
        ApmDelegate.g.f190592a.a().getClass();
    L17:
        MonitorTool.monitorUIAction(r104, r102, r103);
        return;
    L14:
        r104 = "page_hide";
        goto L15
    L5:
        r102 = r100.getClass().getName();
        goto L6
    }
}
