package com.obric.autogui.agents.stateprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.session.c;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AgentStateProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AgentStateProviderImpl extends PluginContentProvider {
    private static final String AUTHORITY = "com.obric.autoaction.AgentStateProvider";
    public static final a Companion = null;
    private static final String METHOD_GET_CURRENT_STATE = "get_current_state";
    private static final String TAG = "AS-Provider";
    private static final String URI_AGENT_STATE_POSTFIX = "AgentStateProvider";

    /* JADX INFO: compiled from: AgentStateProviderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(String r3) {
            o.e(r3, "reason");
            Loog.INSTANCE.i(AgentStateProviderImpl.TAG, "notifyAgentStateChanged for " + r3);
            ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), com.obric.autogui.agents.stateprovider.a.a("content://com.obric.autoaction.AgentStateProvider"), null, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public AgentStateProviderImpl() {
    }

    public Bundle call(String r2, String r3, Bundle r4) {
        o.e(r2, "method");
        Loog.INSTANCE.i(TAG, "called AgentStateProvider, meth=" + r2);
        if (o.a(r2, METHOD_GET_CURRENT_STATE) == true) goto L5;
        return null;
    L5:
        return methGetCurrentState();
    }

    private final Bundle methGetCurrentState() {
        Bundle r7 = new Bundle();
        com.obric.autogui.session.a r0 = c.f30777a.b();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r7.putBoolean("has_ongoing_task", r3);
        if (r3 == true) goto L12;
    L30:
        return r7;
    L12:
        if (r0 == null) goto L16;
        AutoOperateTask r2 = r0.l();
        if (r2 == null) goto L16;
        String r4 = r2.getUserTask();
    L17:
        r7.putString("task_query", r4);
        IAutoActionAgentEventListener.OperatingAppInfo r5 = AgentStateProviderEventListener.Companion.a();
        if (r5 == null) goto L20;
        String r6 = r5.getPackageName();
    L21:
        r7.putString("operating_app_pkg", r6);
        IAutoActionAgentEventListener.AgentStepInfo r8 = AgentStateProviderEventListener.Companion.b();
        if (r8 == null) goto L28;
        String r9 = r8.getActionProtocolType();
        if (r9 == null) goto L28;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("call_user", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L28;
    L29:
        r7.putBoolean("in_call_user", r1);
    L28:
        r1 = false;
        goto L29
    L20:
        r6 = null;
    L16:
        r4 = null;
        goto L17
    L5:
        if (r0.J().e() == true) goto L7;
        r3 = true;
        goto L8
    }

    public boolean onCreate() {
        Loog.INSTANCE.i(TAG, "created AgentStateProvider.");
        return true;
    }
}
