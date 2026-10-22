package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.helper.ApmAgentHelper;
import com.bytedance.apm.agent.monitor.MonitorTool;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ClickInstrumentation {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickInstrumentation() {
    }

    @Keep
    public static void onClick(View r10) {
        if (r10 != null) goto L46;
        return;
    L46:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L8
        Resources r12 = r10.getContext().getResources();     // Catch: Exception -> L8
        if (r10.getId() == (-1)) goto L11;
        r11.put(VIEW_ID, r10.getId());     // Catch: Exception -> L8
        r11.put(VIEW_NAME, r12.getResourceEntryName(r10.getId()));     // Catch: Exception -> L8
    L11:
        if ((r10 instanceof TextView) == false) goto L19;
        CharSequence r13 = ((TextView) r10).getText();     // Catch: Exception -> L8
        if (r13 == null) goto L19;
        String r14 = r13.toString();     // Catch: Exception -> L8
        if (r14.length() <= 100) goto L17;
        r14 = r14.substring(0, 100);     // Catch: Exception -> L8
    L17:
        r11.put(VIEW_TEXT, r14);     // Catch: Exception -> L8
    L19:
        if (r10.getParent() == null) goto L25;
        String r15 = r10.getParent().getClass().getSimpleName();     // Catch: Exception -> L8
        if (r10.getParent().getParent() == null) goto L23;
        r15 = r10.getParent().getParent().getClass().getSimpleName() + "#" + r15 + "#" + r10.getClass().getSimpleName();     // Catch: Exception -> L8
    L23:
        r11.put("view_path", r15);     // Catch: Exception -> L8
    L25:
        if (r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_1) == null) goto L30;
        if (TextUtils.isEmpty(r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_1).toString()) == true) goto L30;
        r11.put("view_tag_1", r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_1).toString());     // Catch: Exception -> L8
    L30:
        if (r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_2) == null) goto L35;
        if (TextUtils.isEmpty(r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_2).toString()) == true) goto L35;
        r11.put("view_tag_2", r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_2).toString());     // Catch: Exception -> L8
    L35:
        if (r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP) != null) goto L37;
    L42:
        r11.put("click_type", "View#OnClick");     // Catch: Exception -> L8
        MonitorTool.monitorUIAction(ACTION_NAME, "", r11);     // Catch: Exception -> L8
        return;
    L37:
        if ((r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP) instanceof Map) == false) goto L42;
        Iterator r16 = ((Map) r10.getTag(ApmAgentHelper.VIEW_DATA_KEY_MAP)).entrySet().iterator();     // Catch: Exception -> L8
    L40:
        if (r16.hasNext() == false) goto L42;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Exception -> L8
        r11.put("view_tag_map_" + r17.getKey().toString(), r17.getValue().toString());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Keep
    public static void onTabChanged(String r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put(VIEW_NAME, r10);     // Catch: Exception -> L4
        r11.put("click_type", "TabHost#OnTabChanged");     // Catch: Exception -> L4
        MonitorTool.monitorUIAction(ACTION_NAME, "", r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
