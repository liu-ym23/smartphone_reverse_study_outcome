package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;
import com.bytedance.apm.internal.ApmDelegate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class PageShowCallback {
    public PageShowCallback() {
    }

    public static void onPageShowHideAction(Object r100, boolean r101) {
        if (InstructOperationSwitch.sUiSwitch == true) goto L6;
        return;
    L6:
        if ((r100 instanceof String) == false) goto L8;
        String r102 = (String) r100;
    L9:
        JSONObject r103 = new JSONObject();
        if ((r100 instanceof IPageMonitor) == false) goto L15;
        r103.put("label", ((IPageMonitor) r100).getMonitorLabel());     // Catch: Exception -> L14
    L15:
        if (r101 == false) goto L17;
        String r104 = "page_show";
    L18:
        if (r101 == false) goto L20;
        ApmDelegate.g.f190592a.a().getClass();
    L20:
        MonitorTool.monitorUIAction(r104, r102, r103);
        return;
    L17:
        r104 = "page_hide";
        goto L18
    L8:
        r102 = r100.getClass().getName();
        goto L9
    }
}
