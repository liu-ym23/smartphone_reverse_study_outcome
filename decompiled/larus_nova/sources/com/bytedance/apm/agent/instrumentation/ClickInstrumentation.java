package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm.agent.helper.ApmAgentHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ClickInstrumentation {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickInstrumentation() {
    }

    public static void onClick(View r100) {
        if (r100 != null) goto L45;
        return;
    L45:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L42
        Resources r102 = r100.getContext().getResources();     // Catch: Exception -> L42
        if (r100.getId() == (-1)) goto L9;
        r101.put("view_id", r100.getId());     // Catch: Exception -> L42
        r101.put(VIEW_NAME, r102.getResourceEntryName(r100.getId()));     // Catch: Exception -> L42
    L9:
        if ((r100 instanceof TextView) == false) goto L17;
        CharSequence r103 = ((TextView) r100).getText();     // Catch: Exception -> L42
        if (r103 == null) goto L17;
        String r104 = r103.toString();     // Catch: Exception -> L42
        if (r104.length() <= 100) goto L15;
        r104 = r104.substring(0, 100);     // Catch: Exception -> L42
    L15:
        r101.put(VIEW_TEXT, r104);     // Catch: Exception -> L42
    L17:
        if (r100.getParent() == null) goto L23;
        String r105 = r100.getParent().getClass().getSimpleName();     // Catch: Exception -> L42
        if (r100.getParent().getParent() == null) goto L21;
        r105 = r100.getParent().getParent().getClass().getSimpleName() + "#" + r105 + "#" + r100.getClass().getSimpleName();     // Catch: Exception -> L42
    L21:
        r101.put("view_path", r105);     // Catch: Exception -> L42
    L23:
        if (r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_1) == null) goto L28;
        if (TextUtils.isEmpty(r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_1).toString()) == true) goto L28;
        r101.put("view_tag_1", r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_1).toString());     // Catch: Exception -> L42
    L28:
        if (r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_2) == null) goto L33;
        if (TextUtils.isEmpty(r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_2).toString()) == true) goto L33;
        r101.put("view_tag_2", r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_2).toString());     // Catch: Exception -> L42
    L33:
        if (r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP) != null) goto L35;
    L40:
        r101.put("click_type", "View#OnClick");     // Catch: Exception -> L42
        MonitorTool.monitorUIAction(ACTION_NAME, "", r101);     // Catch: Exception -> L42
        return;
    L35:
        if ((r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP) instanceof Map) == false) goto L40;
        Iterator r106 = ((Map) r100.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP)).entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r106.hasNext() == false) goto L40;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Exception -> L42
        r101.put("view_tag_map_" + r107.getKey().toString(), r107.getValue().toString());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
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
