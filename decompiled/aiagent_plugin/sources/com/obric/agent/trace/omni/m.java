package com.obric.agent.trace.omni;

import com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniTaskFinishReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private static final String TAG = "OmniTaskFinishReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f15694a = null;

    static {
        f15694a = new m();
    }

    public static /* synthetic */ Map lambda$0Bwtyg2bMgu4mSvVI9urig63wjU(long r0, boolean r2, String r3, a r4) {
        return a(r0, r2, r3, r4);
    }

    private m() {
    }

    public final boolean a(String r43, String r44, final long r45, String r47, IMMessage r48, Map<String, String> r49, Map<String, String> r50, d.h.a.r<? super String, ? super a, ? super Map<String, String>, ? super Boolean, x> r51) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r49, Map.class, "com.obric.aiagent.plugin");
        Map<? extends String, ? extends String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r50, Map.class, "com.obric.aiagent.plugin");
        d.h.a.r r10 = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r51, d.h.a.r.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r44, DBDefinition.TASK_ID);
        d.h.b.o.e(r47, "messageJson");
        d.h.b.o.e(r9, "extraReportParams");
        d.h.b.o.e(r10, "reportWithCommonParams");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r43, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L13;
        ISecureLogDepend.Companion.w(TAG, "reportTaskEnd ignored: messageId is blank, taskId: " + r44);
        return false;
    L13:
        ISecureLogDepend.Companion.i(TAG, "reportTaskEnd, messageId: " + r43 + ", " + r47);
        if (r48 == null) goto L18;
        Map<String, String> r13 = r48.getExt();
        if (r13 == null) goto L18;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get("o_complete_result"), String.class, "com.obric.aiagent.plugin");
    L19:
        final boolean r15 = d.h.b.o.a(r14, "success");
        final String r16 = a(r48, r7);
        a r5 = k.f15686a.b(r43, new $$Lambda$m$0Bwtyg2bMgu4mSvVI9urig63wjU(r45, r15, r16));
        if (r5 != null) goto L23;
        ISecureLogDepend.Companion.e(TAG, "reportTaskEnd ignored: snapshot already drained or missing, messageId: " + r43);
        return false;
    L23:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("message_send_success"), List.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L31;
        Object r18 = d.a.p.n(r17);
        if (r18 == null) goto L31;
        if (ZeusTransformUtils.instanceOf(r18, Long.class) == false) goto L31;
    L32:
        Long r19 = (Long) ZeusTransformUtils.preCheckCast(r18, Long.class, "com.obric.aiagent.plugin");
        long r110 = 0;
        if (r19 == null) goto L35;
        long r111 = r19.longValue();
    L36:
        long r3 = r45 - r111;
        List r112 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("queueing_start"), List.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L44;
        Object r113 = d.a.p.n(r112);
        if (r113 == null) goto L44;
        if (ZeusTransformUtils.instanceOf(r113, Long.class) == false) goto L44;
    L45:
        Long r114 = (Long) ZeusTransformUtils.preCheckCast(r113, Long.class, "com.obric.aiagent.plugin");
        if (r114 == null) goto L48;
        long r115 = r114.longValue();
    L49:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("queueing_end"), List.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L57;
        Object r2 = d.a.p.n(r1);
        if (r2 == null) goto L57;
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L57;
    L58:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L61;
        long r21 = r4.longValue();
    L62:
        long r22 = r21 - r115;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("prepare_end"), List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L70;
        Object r8 = d.a.p.n(r6);
        if (r8 == null) goto L70;
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L70;
    L71:
        Long r20 = (Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L74;
        long r116 = r20.longValue();
    L75:
        long r117 = r116 - r111;
        List r23 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("prepare_request_server_end"), List.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L83;
        Object r24 = d.a.p.n(r23);
        if (r24 == null) goto L83;
        if (ZeusTransformUtils.instanceOf(r24, Long.class) == false) goto L83;
    L84:
        Long r25 = (Long) ZeusTransformUtils.preCheckCast(r24, Long.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L87;
        long r26 = r25.longValue();
    L88:
        long r27 = r26 - r111;
        long r28 = r117 - r27;
        List r29 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("dispatch_intent_end"), List.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L121;
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r210 = 0;
        long r211 = 0;
        long r31 = 0;
    L92:
        if (r30.hasNext() == false) goto L109;
        long r46 = r117;
        Object r118 = r30.next();
        if (ZeusTransformUtils.instanceOf(r118, t.class) == false) goto L96;
        t r119 = (t) ZeusTransformUtils.preCheckCast(r118, t.class, "com.obric.aiagent.plugin");
    L97:
        if (r119 == null) goto L108;
        String r32 = r119.b().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r32, "toLowerCase(...)");
        if (d.o.o.b(r32, "gui_", false, 2, null) == false) goto L101;
        r210 = r210 + r119.h();
    L101:
        String r33 = r119.b().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r33, "toLowerCase(...)");
        if (d.o.o.b(r33, "pc_", false, 2, null) == true) goto L105;
        String r34 = r119.b().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r34, "toLowerCase(...)");
        if (d.o.o.b(r34, "personalcontext_", false, 2, null) == true) goto L105;
    L106:
        r211 = r211 + r119.h();
        x r35 = x.f38692a;
        x r36 = x.f38692a;
    L105:
        r31 = r31 + r119.h();
    L108:
        r117 = r46;
        r30 = r30;
        r3 = r3;
        r111 = r111;
        goto L92
    L96:
        r119 = null;
        goto L97
    L109:
        long r37 = r3;
        long r38 = r111;
        long r410 = r117;
        Object r120 = null;
        Object r39 = d.a.p.l(r29);
        if (ZeusTransformUtils.instanceOf(r39, t.class) == false) goto L112;
        t r40 = (t) ZeusTransformUtils.preCheckCast(r39, t.class, "com.obric.aiagent.plugin");
    L113:
        Object r41 = d.a.p.n(r29);
        if (ZeusTransformUtils.instanceOf(r41, t.class) == false) goto L116;
        t r42 = (t) ZeusTransformUtils.preCheckCast(r41, t.class, "com.obric.aiagent.plugin");
    L117:
        if (r40 == null) goto L120;
        if (r42 == null) goto L120;
        r110 = r42.e() - r40.c();
    L120:
        x r52 = x.f38692a;
        x r53 = x.f38692a;
        long r54 = r211;
    L122:
        List r55 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("is_interrupted"), List.class, "com.obric.aiagent.plugin");
        if (r55 == null) goto L130;
        Object r56 = d.a.p.n(r55);
        if (r56 == null) goto L130;
        if (ZeusTransformUtils.instanceOf(r56, Boolean.class) == false) goto L130;
    L131:
        String r121 = "0";
        if (d.h.b.o.a(r56, true) == false) goto L170;
        List r122 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("error_code"), List.class, "com.obric.aiagent.plugin");
        if (r122 == null) goto L141;
        Object r123 = d.a.p.n(r122);
        if (r123 == null) goto L141;
        if (ZeusTransformUtils.instanceOf(r123, String.class) == false) goto L141;
    L142:
        String r124 = (String) ZeusTransformUtils.preCheckCast(r123, String.class, "com.obric.aiagent.plugin");
        if (r124 != null) goto L145;
        r124 = "199999";
    L145:
        List r125 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("mark_interrupted_position"), List.class, "com.obric.aiagent.plugin");
        if (r125 == null) goto L153;
        Object r126 = d.a.p.n(r125);
        if (r126 == null) goto L153;
        if (ZeusTransformUtils.instanceOf(r126, String.class) == false) goto L153;
    L154:
        String r127 = (String) ZeusTransformUtils.preCheckCast(r126, String.class, "com.obric.aiagent.plugin");
        if (r127 != null) goto L157;
        r127 = "server";
    L157:
        List r128 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("finish_reason"), List.class, "com.obric.aiagent.plugin");
        if (r128 == null) goto L165;
        Object r129 = d.a.p.n(r128);
        if (r129 == null) goto L165;
        if (ZeusTransformUtils.instanceOf(r129, String.class) == false) goto L165;
    L166:
        String r130 = (String) ZeusTransformUtils.preCheckCast(r129, String.class, "com.obric.aiagent.plugin");
        if (r130 != null) goto L169;
        r130 = "interrupted with no error msg";
    L169:
        d.r r57 = new d.r(r124, r127, r130);
    L171:
        String r131 = (String) ZeusTransformUtils.preCheckCast(r57.d(), String.class, "com.obric.aiagent.plugin");
        String r132 = (String) ZeusTransformUtils.preCheckCast(r57.e(), String.class, "com.obric.aiagent.plugin");
        String r58 = (String) ZeusTransformUtils.preCheckCast(r57.f(), String.class, "com.obric.aiagent.plugin");
        List r133 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("instruction_id"), List.class, "com.obric.aiagent.plugin");
        if (r133 == null) goto L179;
        Object r134 = d.a.p.n(r133);
        if (r134 == null) goto L179;
        if (ZeusTransformUtils.instanceOf(r134, String.class) == false) goto L179;
    L180:
        String r135 = b((String) ZeusTransformUtils.preCheckCast(r134, String.class, "com.obric.aiagent.plugin"));
        if (r135 != null) goto L185;
        r135 = b(r44);
        if (r135 != null) goto L185;
        r135 = "";
    L185:
        if (r42 == null) goto L187;
        String r59 = r42.d();
    L188:
        String r60 = b(r59);
        if (r60 == null) goto L191;
        r121 = "0";
        String r411 = r132;
    L219:
        t r136 = r42;
        Map<String, String> r0 = h.f15634a.a(r5, r38);
        d.m[] r61 = new d.m[23];
        r61[0] = d.s.a("all_duration", String.valueOf(r37));
        r61[1] = d.s.a("all_duration_exclude_wait_queue", String.valueOf(r37 - r22));
        r61[2] = d.s.a("wait_queue_duration", String.valueOf(r22));
        r61[3] = d.s.a("prepare_duration", String.valueOf(r410));
        r61[4] = d.s.a("prepare_server_duration", String.valueOf(r27));
        r61[5] = d.s.a("prepare_client_duration", String.valueOf(r28));
        r61[6] = d.s.a("gui_exec_all_duration", String.valueOf(r210));
        r61[7] = d.s.a("memory_exec_all_duration", String.valueOf(r31));
        r61[8] = d.s.a("tool_exec_stage_duration", String.valueOf(r110));
        r61[9] = d.s.a("client_tool_duration", String.valueOf(r54));
        r61[10] = d.s.a("error_code", r131);
        List r62 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("log_id"), List.class, "com.obric.aiagent.plugin");
        if (r62 == null) goto L227;
        Object r63 = d.a.p.n(r62);
        if (r63 == null) goto L227;
        if (ZeusTransformUtils.instanceOf(r63, String.class) == false) goto L227;
    L228:
        String r64 = (String) ZeusTransformUtils.preCheckCast(r63, String.class, "com.obric.aiagent.plugin");
        if (r64 != null) goto L231;
        r64 = "";
    L231:
        r61[11] = d.s.a("log_id", r64);
        r61[12] = d.s.a("instruction_id", r135);
        r61[13] = d.s.a("execute_id", r60);
        r61[14] = d.s.a("finish_reason", r58);
        if (r48 == null) goto L237;
        Map<String, String> r137 = r48.getExt();
        if (r137 == null) goto L237;
        String r65 = (String) ZeusTransformUtils.preCheckCast(r137.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        if (r65 == null) goto L237;
    L240:
        if (r65 != null) goto L242;
        r65 = "";
    L242:
        r61[15] = d.s.a("o_reference_msg_id", r65);
        if (r48 == null) goto L247;
        Map<String, String> r66 = r48.getExt();
        if (r66 == null) goto L247;
        String r67 = (String) ZeusTransformUtils.preCheckCast(r66.get("stop_scene"), String.class, "com.obric.aiagent.plugin");
    L248:
        if (r67 != null) goto L250;
        r67 = "";
    L250:
        r61[16] = d.s.a("stop_scene", r67);
        if (r136 == null) goto L253;
        String r68 = r136.b();
    L254:
        if (r68 != null) goto L256;
        r68 = "";
    L256:
        r61[17] = d.s.a("last_tool_name", r68);
        if (r136 == null) goto L259;
        String r69 = r136.g();
    L260:
        if (r69 != null) goto L262;
        r69 = "";
    L262:
        r61[18] = d.s.a("last_tool_action_type", r69);
        if (r136 == null) goto L265;
        String r70 = r136.f();
    L266:
        if (r70 != null) goto L268;
        r70 = "";
    L268:
        r61[19] = d.s.a("last_tool_args", r70);
        if (r136 == null) goto L272;
        String r71 = Long.valueOf(r136.h()).toString();
        if (r71 == null) goto L272;
    L273:
        r61[20] = d.s.a("last_tool_duration", r71);
        if (r136 == null) goto L276;
        String r72 = r136.a();
    L277:
        if (r72 != null) goto L279;
        r72 = "";
    L279:
        r61[21] = d.s.a("last_tool_id", r72);
        r61[22] = d.s.a("feature", a());
        Map<String, String> r73 = ao.b(r61);
        r73.putAll(r9);
        if (d.h.b.o.a(r131, r121) == true) goto L282;
        r73.put("mark_interrupted_position", r411);
    L282:
        IAgentAppIntentIDLSPI r74 = (IAgentAppIntentIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAppIntentIDLSPI.class), IAgentAppIntentIDLSPI.class, "com.obric.aiagent.plugin");
        if (r74 == null) goto L287;
        Map r75 = r74.getOmniExtraLog(r43);
        if (r75 == null) goto L287;
        r73.putAll(com.obric.aiagent.ipc.utils.f.a(r75));
        x r76 = x.f38692a;
        x r77 = x.f38692a;
    L287:
        List r78 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("o_omni_track"), List.class, "com.obric.aiagent.plugin");
        if (r78 == null) goto L295;
        Object r79 = d.a.p.n(r78);
        if (r79 == null) goto L295;
        if (ZeusTransformUtils.instanceOf(r79, String.class) == false) goto L295;
    L296:
        String r80 = (String) ZeusTransformUtils.preCheckCast(r79, String.class, "com.obric.aiagent.plugin");
        if (r80 == null) goto L309;
        JSONObject r81 = new JSONObject(r80);
        Iterator<String> r82 = r81.keys();
    L300:
        if (r82.hasNext() == false) goto L307;
        String r138 = (String) ZeusTransformUtils.preCheckCast(r82.next(), String.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r138);
        Object r139 = r81.opt(r138);
        if (r139 == null) goto L305;
        String r140 = r139.toString();
        if (r140 == null) goto L305;
    L306:
        r73.put(r138, r140);
    L305:
        r140 = "";
        goto L306
    L307:
        int r141 = r81.optInt("server_tool_duration", 0);
        r73.put("tool_all_exec_duration", String.valueOf(((long) r141) + r54));
        r73.put("server_tool_duration", String.valueOf(r141));
        String r83 = (String) ZeusTransformUtils.preCheckCast(r73.put("server_tool_count", String.valueOf(r81.optInt("server_tool_count", 0))), String.class, "com.obric.aiagent.plugin");
    L309:
        m r84 = f15694a;
        String r85 = r84.b(r135);
        if (r85 == null) goto L312;
        String r86 = (String) ZeusTransformUtils.preCheckCast(r73.put("instruction_id", r85), String.class, "com.obric.aiagent.plugin");
    L312:
        String r87 = r84.b(r60);
        if (r87 == null) goto L315;
        String r88 = (String) ZeusTransformUtils.preCheckCast(r73.put("execute_id", r87), String.class, "com.obric.aiagent.plugin");
    L315:
        r73.putAll(r0);
        com.obric.agent.trace.q.f15713a.a(r43, r5, r73);
        com.obric.agent.trace.m.f15526a.a((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.e(r43), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r43, com.obric.agent.trace.o.A, false, 4, null);
        ISecureLogDepend.Companion r89 = ISecureLogDepend.Companion;
        StringBuilder r90 = new StringBuilder().append("reportTaskEnd emit finish, messageId=").append(r43).append(", errCode=").append(r131).append(", finishReason=").append(r58).append(", lastTool=");
        if (r136 == null) goto L318;
        String r91 = r136.b();
    L319:
        if (r91 != null) goto L321;
        String r142 = "";
    L322:
        r89.i(TAG, r90.append(r142).append(", clientToolDuration=").append(r54).toString());
        l.f15693a.a(r5, r73, r136);
        r10.a("obric_omni_instruction_finish", r5, r73, true);
        return true;
    L321:
        r142 = r91;
        goto L322
    L318:
        r91 = null;
    L295:
        r79 = null;
        goto L296
    L276:
        r72 = null;
    L272:
        r71 = r121;
        goto L273
    L265:
        r70 = null;
        goto L266
    L259:
        r69 = null;
        goto L260
    L253:
        r68 = null;
    L247:
        r67 = null;
    L237:
        if (r7 == null) goto L239;
        r65 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        goto L240
    L239:
        r65 = null;
    L227:
        r63 = null;
        goto L228
    L191:
        if (r48 == null) goto L196;
        r411 = r132;
        Map<String, String> r143 = r48.getExt();
        if (r143 == null) goto L197;
        r121 = "0";
        String r144 = (String) ZeusTransformUtils.preCheckCast(r143.get("o_execute_id"), String.class, "com.obric.aiagent.plugin");
    L198:
        String r145 = b(r144);
        if (r145 != null) goto L217;
        if (r7 == null) goto L202;
        String r92 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_execute_id"), String.class, "com.obric.aiagent.plugin");
    L203:
        r60 = b(r92);
        if (r60 != null) goto L219;
        List r93 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("execute_id"), List.class, "com.obric.aiagent.plugin");
        if (r93 == null) goto L213;
        Object r94 = d.a.p.n(r93);
        if (r94 == null) goto L213;
        if (ZeusTransformUtils.instanceOf(r94, String.class) == false) goto L213;
    L214:
        r60 = b((String) ZeusTransformUtils.preCheckCast(r94, String.class, "com.obric.aiagent.plugin"));
        if (r60 != null) goto L219;
        r60 = "";
    L213:
        r94 = null;
        goto L214
    L202:
        r92 = null;
        goto L203
    L217:
        r60 = r145;
    L197:
        r144 = null;
        goto L198
    L196:
        r411 = r132;
        goto L197
    L187:
        r59 = null;
    L179:
        r134 = null;
    L165:
        r129 = null;
    L153:
        r126 = null;
    L141:
        r123 = null;
        goto L142
    L170:
        r57 = new d.r("0", "", "success");
    L130:
        r56 = r120;
        goto L131
    L116:
        r42 = null;
        goto L117
    L112:
        r40 = null;
        goto L113
    L121:
        r37 = r3;
        r38 = r111;
        r410 = r117;
        r120 = null;
        r42 = null;
        r54 = 0;
        r210 = 0;
        r31 = 0;
        goto L122
    L87:
        r26 = 0;
    L83:
        r24 = null;
        goto L84
    L74:
        r116 = 0;
    L70:
        r8 = null;
        goto L71
    L61:
        r21 = 0;
    L57:
        r2 = null;
        goto L58
    L48:
        r115 = 0;
    L44:
        r113 = null;
        goto L45
    L35:
        r111 = 0;
    L31:
        r18 = null;
    L18:
        r14 = null;
        goto L19
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L10
    }

    private static final Map a(long r7, boolean r9, String r10, a r11) {
        d.h.b.o.e(r11, "currentSnapshot");
        return f15694a.a(r11, r7, r9, r10);
    }

    private final String a() {
        JSONObject r2 = new JSONObject();
        if (com.obric.autogui.common.a.d.f28974a.s() == false) goto L5;
        r2.put("heif", 1);
    L5:
        String r3 = r2.toString();
        d.h.b.o.c(r3, "toString(...)");
        return r3;
    }

    private final Map<String, Object> a(a r2, long r3, boolean r5, String r6) {
        Map<String, Object> r4 = ao.b(new d.m[]{d.s.a("task_end", Long.valueOf(r3)), d.s.a("finish_reason", r6)});
        if (r2.b().containsKey("error_code") == true) goto L7;
        if (r5 == true) goto L7;
        r4.put("is_interrupted", true);
        r4.put("mark_interrupted_position", "task end");
        r4.put("error_code", a(r6));
    L7:
        return r4;
    }

    private final String a(IMMessage r4, Map<String, String> r5) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        Map<String, String> r6 = r4.getExt();
        if (r6 == null) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.get("stop_reason"), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
    L17:
        return r7;
    L10:
        if (r3 == null) goto L12;
        r7 = (String) ZeusTransformUtils.preCheckCast(r3.get("stop_reason"), String.class, "com.obric.aiagent.plugin");
    L13:
        if (r7 != null) goto L17;
        if (r3 != null) goto L16;
        return null;
    L16:
        return (String) ZeusTransformUtils.preCheckCast(r3.get("stop_scene"), String.class, "com.obric.aiagent.plugin");
    L12:
        r7 = null;
        goto L13
    }

    private final String a(String r3) {
        ILogDepend.Companion.i(TAG, "resolveErrorCode, stopReason=" + r3);
        if (r3 != null) goto L5;
    L47:
        return "199999";
    L5:
        switch(r3.hashCode()) {
            case -1834332621: goto L44;
            case -1792184895: goto L40;
            case -1226589444: goto L36;
            case -1097329270: goto L32;
            case -731040180: goto L28;
            case 503000675: goto L24;
            case 770760647: goto L20;
            case 1538716985: goto L16;
            case 1941444800: goto L12;
            case 2027510459: goto L8;
            default: goto L47;
        };
    L8:
        if (r3.equals("clear_login_success") == false) goto L47;
        return "100515";
    L12:
        if (r3.equals("Message DELETED") == false) goto L47;
        return "100510";
    L16:
        if (r3.equals("RECEIVE_FAILED") == false) goto L47;
        return "100514";
    L20:
        if (r3.equals("RECEIVE_INTERRUPT") == false) goto L47;
        return "100512";
    L24:
        if (r3.equals("interrupt") == false) goto L47;
        return "100500";
    L28:
        if (r3.equals("SEND_INTERRUPT") == false) goto L47;
        return "100513";
    L32:
        if (r3.equals("logout") == false) goto L47;
        return "100505";
    L36:
        if (r3.equals("addition") == false) goto L47;
        return "100511";
    L40:
        if (r3.equals("omni_task_client_timeout") == false) goto L47;
        return "100203";
    L44:
        if (r3.equals("start_new_topic") == false) goto L47;
        return "100509";
    }

    private final String b(String r3) {
        if (r3 == null) goto L15;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L15;
        return r3;
    L7:
        if (d.h.b.o.a(r3, "0") == true) goto L11;
        if (d.h.b.o.a(r3, "null") == true) goto L11;
    L15:
        return null;
    }
}
