package com.obric.autoaction.vdplayer.legacy.c;

import android.os.Bundle;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: VDPlayerTrackerUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "VDPlayerTrackerUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f25682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f25683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f25684c = null;

    /* JADX INFO: compiled from: VDPlayerTrackerUtil.kt */
    public static final class a extends LinkedHashMap<String, Long> {
        a() {
            super(16);
        }

        public Long a(String r2) {
            return (Long) ZeusTransformUtils.preCheckCast(super.get(r2), Long.class, "com.obric.aiagent.plugin");
        }

        public Long a(String r1, Long r2) {
            return (Long) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), Long.class, "com.obric.aiagent.plugin");
        }

        public Collection<Long> a() {
            return super.values();
        }

        public boolean a(Long r1) {
            return super.containsValue(r1);
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r1, Long r2) {
            return super.remove(r1, r2);
        }

        public Long c(String r2) {
            return (Long) ZeusTransformUtils.preCheckCast(super.remove(r2), Long.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, Long>> c() {
            return super.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Long.class) == true) goto L7;
            return false;
        L7:
            return a((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, Long>> entrySet() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, Long.class) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<Long> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Long> r3) {
            o.e((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin"), "eldest");
            if (size() <= 16) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private b() {
    }

    static {
        f25682a = new b();
        f25683b = "";
        f25684c = new a();
    }

    public final void a(String r5, long r6) {
        o.e(r5, "omniTaskId");
        a r4 = f25684c;
        Object r0 = r4.getOrDefault(r5, 0L);
        o.c(r0, "getOrDefault(...)");
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue();
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(r5, Long.valueOf(r1 + r6));
    }

    public final void a(String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        f25683b = r2;
        Loog.INSTANCE.i(TAG, "updateSourceFrom sourceFrom=" + f25683b);
    }

    public final void a(IAutoActionAgentEventListener.SessionInfo r12, boolean r13) {
        if (r12 != null) goto L6;
        Loog.INSTANCE.w(TAG, "reportTakeOverEvent ignored: sessionInfo is null");
        return;
    L6:
        if (r13 == false) goto L8;
        String r14 = "model";
    L9:
        Bundle r0 = r12.getTask().getTaskExtras();
        if (r0 == null) goto L14;
        Object r1 = r0.get("doubao_message_id");
        if (r1 == null) goto L14;
        String r2 = r1.toString();
    L15:
        String r3 = "";
        if (r2 != null) goto L18;
        r2 = "";
    L18:
        JSONObject r5 = new JSONObject();
        r5.put("source_from", f25683b);
        String r4 = r12.getToolName();
        if (r4 != null) goto L21;
        r4 = "";
    L21:
        r5.put("current_tool_name", r4);
        String r6 = r12.getInstructionType();
        if (r6 != null) goto L24;
        r6 = "";
    L24:
        r5.put("instruction_type", r6);
        String r7 = r12.getSessionId();
        if (r7 != null) goto L27;
        r7 = r12.getSessionKey();
    L27:
        r5.put("instruction_id", r7);
        r5.put("call_user_type", r14);
        r5.put("doubao_message_id", r2);
        String r15 = r12.getToolId();
        if (r15 != null) goto L30;
        r15 = "";
    L30:
        r5.put("current_tool_id", r15);
        String r16 = r12.getActionType();
        if (r16 == null) goto L34;
        r3 = r16;
    L34:
        r5.put("action_type", r3);
        Loog.INSTANCE.i(TAG, "reportTakeOverEvent event=obric_omni_call_user_operate, params=" + r5);
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "obric_omni_call_user_operate", r5, false, false, null, 16, null);
        return;
    L14:
        r2 = null;
        goto L15
    L8:
        r14 = "user";
        goto L9
    }

    public final void a(IAutoActionAgentEventListener.SessionInfo r12) {
        if (r12 != null) goto L6;
        Loog.INSTANCE.w(TAG, "reportStopClick ignored: sessionInfo is null");
        return;
    L6:
        Bundle r0 = r12.getTask().getTaskExtras();
        String r1 = "";
        if (r0 == null) goto L13;
        Object r2 = r0.get("doubao_message_id");
        if (r2 == null) goto L13;
        String r3 = r2.toString();
        if (r3 == null) goto L13;
    L17:
        JSONObject r5 = new JSONObject();
        r5.put("source_from", "virtual_screen");
        String r4 = r12.getInstructionType();
        if (r4 == null) goto L21;
        r1 = r4;
    L21:
        r5.put("instruction_type", r1);
        String r6 = r12.getSessionId();
        if (r6 != null) goto L24;
        r6 = r12.getSessionKey();
    L24:
        r5.put("instruction_id", r6);
        r5.put("doubao_message_id", r3);
        Loog.INSTANCE.i(TAG, "reportStopClick event=obric_omni_user_stop_click, params=" + r5);
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "obric_omni_user_stop_click", r5, false, false, null, 16, null);
        return;
    L13:
        Long r7 = r12.getRefMsgId();
        if (r7 == null) goto L16;
        r3 = r7.toString();
        goto L17
    L16:
        r3 = "";
        goto L17
    }
}
