package com.bytedance.apm.agent.v2.instrumentation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.bytedance.apm.agent.b.a;
import com.bytedance.apm.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ClickAgent {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickAgent() {
    }

    public static void onClick(View r6) {
        if (r6 != null) goto L29;
        return;
    L29:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L24
        Resources r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (r6.getId() == (-1)) goto L9;
        r2.put(VIEW_ID, r6.getId());     // Catch: Exception -> L24
        r2.put(VIEW_NAME, r3.getResourceEntryName(r6.getId()));     // Catch: Exception -> L24
    L9:
        if (ZeusTransformUtils.instanceOf(r6, TextView.class) == false) goto L17;
        CharSequence r1 = ((TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin")).getText();     // Catch: Exception -> L24
        if (r1 == null) goto L17;
        String r4 = r1.toString();     // Catch: Exception -> L24
        if (r4.length() <= 100) goto L15;
        r4 = r4.substring(0, 100);     // Catch: Exception -> L24
    L15:
        r2.put(VIEW_TEXT, r4);     // Catch: Exception -> L24
    L17:
        if (r6.getParent() == null) goto L22;
        String r5 = r6.getParent().getClass().getSimpleName();     // Catch: Exception -> L24
        if (r6.getParent().getParent() == null) goto L21;
        r5 = r6.getParent().getParent().getClass().getSimpleName() + "#" + r5 + "#" + r6.getClass().getSimpleName();     // Catch: Exception -> L24
    L21:
        r2.put("view_path", r5);     // Catch: Exception -> L24
    L22:
        r2.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L24
        a.a(ACTION_NAME, "", r2);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        if (c.i() == false) goto L31;
        e.printStackTrace();
        return;
    }

    public static void onTabChanged(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(VIEW_NAME, r2);     // Catch: Exception -> L4
        r0.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        a.a(ACTION_NAME, "", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
