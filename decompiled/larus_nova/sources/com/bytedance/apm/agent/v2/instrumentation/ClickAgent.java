package com.bytedance.apm.agent.v2.instrumentation;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ClickAgent {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickAgent() {
    }

    public static void onClick(View r100) {
        if (r100 != null) goto L29;
        return;
    L29:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L24
        Resources r102 = r100.getContext().getResources();     // Catch: Exception -> L24
        if (r100.getId() == (-1)) goto L9;
        r101.put("view_id", r100.getId());     // Catch: Exception -> L24
        r101.put(VIEW_NAME, r102.getResourceEntryName(r100.getId()));     // Catch: Exception -> L24
    L9:
        if ((r100 instanceof TextView) == false) goto L17;
        CharSequence r103 = ((TextView) r100).getText();     // Catch: Exception -> L24
        if (r103 == null) goto L17;
        String r104 = r103.toString();     // Catch: Exception -> L24
        if (r104.length() <= 100) goto L15;
        r104 = r104.substring(0, 100);     // Catch: Exception -> L24
    L15:
        r101.put(VIEW_TEXT, r104);     // Catch: Exception -> L24
    L17:
        if (r100.getParent() == null) goto L22;
        String r105 = r100.getParent().getClass().getSimpleName();     // Catch: Exception -> L24
        if (r100.getParent().getParent() == null) goto L21;
        r105 = r100.getParent().getParent().getClass().getSimpleName() + "#" + r105 + "#" + r100.getClass().getSimpleName();     // Catch: Exception -> L24
    L21:
        r101.put("view_path", r105);     // Catch: Exception -> L24
    L22:
        r101.put("click_type", "View#OnClick");     // Catch: Exception -> L24
        MonitorTool.monitorUIAction(ACTION_NAME, "", r101);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        if (d.j() == false) goto L31;
        e.printStackTrace();
        return;
    }

    public static void onTabChanged(String r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L4
        r101.put(VIEW_NAME, r100);     // Catch: Exception -> L4
        r101.put("click_type", "TabHost#OnTabChanged");     // Catch: Exception -> L4
        MonitorTool.monitorUIAction(ACTION_NAME, "", r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
