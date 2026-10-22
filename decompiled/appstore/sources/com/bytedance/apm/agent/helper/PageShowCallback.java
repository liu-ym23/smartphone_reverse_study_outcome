package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedanceos.common.toolbox.ServerElements;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PageShowCallback {
    public PageShowCallback() {
    }

    public static void onPageShowHideAction(Object r10, boolean r11) {
        if (InstructOperationSwitch.sUiSwitch == true) goto L6;
        return;
    L6:
        if ((r10 instanceof String) == false) goto L8;
        String r12 = (String) r10;
    L9:
        JSONObject r13 = new JSONObject();
        if ((r10 instanceof IPageMonitor) == false) goto L13;
        r13.put(ServerElements.LABEL, ((IPageMonitor) r10).getMonitorLabel());     // Catch: Exception -> L22
    L13:
        if (r11 == false) goto L15;
        String r14 = "page_show";
    L16:
        if (r11 == true) goto L18;
    L20:
        MonitorTool.monitorUIAction(r14, r12, r13);
        return;
    L18:
        if (ApmDelegate.j().h().m() == null) goto L20;
        ApmDelegate.j().h().m().pageShow(r12, true);
        goto L20
    L15:
        r14 = "page_hide";
        goto L16
    L8:
        r12 = r10.getClass().getName();
        goto L9
    }
}
