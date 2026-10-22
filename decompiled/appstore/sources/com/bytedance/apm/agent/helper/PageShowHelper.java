package com.bytedance.apm.agent.helper;

import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedanceos.common.toolbox.ServerElements;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PageShowHelper {
    public PageShowHelper() {
    }

    public static void onPageShowHideAction(Object r10, boolean r11) {
        if ((r10 instanceof String) == false) goto L5;
        String r12 = (String) r10;
    L6:
        JSONObject r13 = new JSONObject();
        if ((r10 instanceof IPageMonitor) == false) goto L10;
        r13.put(ServerElements.LABEL, ((IPageMonitor) r10).getMonitorLabel());     // Catch: Exception -> L19
    L10:
        if (r11 == false) goto L12;
        String r14 = "page_show";
    L13:
        if (r11 == true) goto L15;
    L17:
        MonitorTool.monitorUIAction(r14, r12, r13);
        return;
    L15:
        if (ApmDelegate.j().h().m() == null) goto L17;
        ApmDelegate.j().h().m().pageShow(r12, true);
        goto L17
    L12:
        r14 = "page_hide";
        goto L13
    L5:
        r12 = r10.getClass().getName();
        goto L6
    }
}
