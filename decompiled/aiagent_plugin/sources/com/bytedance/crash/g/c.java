package com.bytedance.crash.g;

import com.bytedance.crash.o.l;
import com.obric.capabilitykit.entity.EntityContentProvider;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: LooperMessageParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static String a(int r6, long r7, long r9) {
        if (r6 != 1) goto L15;
        if (r7 > 1) goto L8;
        return "idle";
    L8:
        if ((2 * r7) <= r9) goto L11;
        return "native_busy";
    L11:
        if ((r7 * 10) >= r9) goto L13;
        return "native_lock";
    L13:
        return "native_unknown";
    L15:
        if (r6 == 8) goto L17;
        return "normal";
    L17:
        if ((2 * r7) <= r9) goto L20;
        return "java_busy";
    L20:
        if ((r7 * 10) >= r9) goto L22;
        return "java_lock";
    L22:
        return "java_unknown";
    }

    private static String a(JSONArray r6, long r7, long r9) {
        if (r6 != null) goto L5;
        return null;
    L5:
        long r10 = r9 + r7;
        int r1 = 0;
    L7:
        if (r1 >= r6.length()) goto L15;
        JSONObject r2 = r6.optJSONObject(r1);
        long r3 = r2.optLong("time");
        if (r3 < r7) goto L14;
        if (r3 > r10) goto L14;
        return r2.optString("trace");
    L14:
        r1 = r1 + 1;
        goto L7
    L15:
        return null;
    }

    public static void a(JSONArray r2, JSONObject r3, long r4, boolean r6) {
        if (r6 == false) goto L4;
        long r0 = r3.optLong("currentMessageCost");     // Catch: Throwable -> L9
    L5:
        String r5 = a(r2, r4, r0);     // Catch: Throwable -> L9
        if (r5 == null) goto L12;
        l.a(r3, "block_stack", r5);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L4:
        r0 = r3.optLong("duration");     // Catch: Throwable -> L9
    }

    public static void a(JSONObject r29) {
        JSONArray r1 = r29.optJSONArray("history_message");
        JSONObject r2 = r29.optJSONObject("current_message");
        JSONObject r4 = r29.optJSONObject("history_details");
        String r5 = "block_stack";
        JSONArray r6 = r29.optJSONArray("block_stack");
        if (r4 != null) goto L6;
        JSONObject r3 = new JSONObject();
        l.a(r3, "longestMsgType", "no_details");
        l.a(r3, "longestMsg", "no_details");
        l.a(r29, "history_details", r3);
        return;
    L6:
        if (r1 != null) goto L8;
    L59:
        l.a(r4, "longestMsgType", "no_history");
        l.a(r4, "longestMsg", "no_history");
        return;
    L8:
        if (r1.length() == 0) goto L59;
        long r9 = r29.optLong("crash_time");
        long r11 = r4.optLong("last_wall_time");
        long r13 = r4.optLong("last_cpu_time");
        long r15 = 0;
        if (r9 != 0) goto L13;
    L57:
        l.a(r4, "longestMsgType", "no_last_times");
        l.a(r4, "longestMsg", "no_last_times");
        return;
    L13:
        if (r11 == 0) goto L57;
        if (r13 == 0) goto L57;
        l.a(r4, "longestMsgType", "not_found");
        l.a(r4, "longestMsg", "not_found");
        if (r9 <= r11) goto L25;
        if (r2 == null) goto L25;
        r15 = r2.optLong("currentMessageCost");
        long r17 = r9 - r11;
        if (r17 >= r15) goto L23;
        r15 = r17;
    L23:
        a(r6, r2, r11, true);
    L25:
        if (r15 >= 5000) goto L40;
        long r18 = r9 - r11;
        int r0 = r1.length() - 1;
        long r21 = r15;
        int r20 = -1;
    L27:
        if (r0 < 0) goto L39;
        if (r18 >= 10000) goto L39;
        long r23 = r11;
        JSONObject r12 = r1.optJSONObject(r0);
        if (r12 != null) goto L33;
        long r27 = r13;
    L38:
        r0 = r0 - 1;
        r11 = r23;
        r13 = r27;
        goto L27
    L33:
        long r25 = r12.optLong("duration");
        r18 = r18 + r25;
        r27 = r13;
        a(r6, r12, r9 - r18, false);
        if (r18 <= EntityContentProvider.g) goto L38;
        if (r25 <= r21) goto L38;
        r20 = r0;
        r21 = r25;
    L39:
        long r24 = r11;
        long r28 = r13;
        int r7 = r20;
    L41:
        long r19 = r15;
        if (r7 < 0) goto L54;
        int r8 = r1.length() - 1;
    L45:
        if (r8 < r7) goto L50;
        String r16 = r5;
        JSONObject r10 = r1.optJSONObject(r8);
        if (r10 == null) goto L49;
        r24 = r24 - r10.optLong("duration");
        r28 = r28 - r10.optLong("cpuDuration");
    L49:
        r8 = r8 - 1;
        r5 = r16;
        goto L45
    L50:
        String r110 = r5;
        JSONObject r14 = r1.optJSONObject(r7);
        if (r14 == null) goto L70;
        long r22 = r14.optLong("duration");
        long r26 = r14.optLong("cpuDuration");
        l.a(r4, "longestMsgWallDuration", Long.valueOf(r22));
        l.a(r4, "longestMessageCpuDuration", Long.valueOf(r26));
        l.a(r4, "longestMsgStartCpuTime", Long.valueOf(r28));
        l.a(r4, "longestMsgEndCpuTime", Long.valueOf(r28 + r26));
        l.a(r4, "longestMsgStartWallTime", Long.valueOf(r24));
        l.a(r4, "longestMsgEndWallTime", Long.valueOf(r24 + r22));
        l.a(r4, "longestMsgType", a(r14.optInt("type"), r26, r22));
        l.a(r4, "longestMsg", r14.optString("message"));
        l.a(r4, "longestMsgBlockStack", r14.optString(r110));
        return;
    L70:
        return;
    L54:
        if (r2 == null) goto L72;
        l.a(r4, "longestMsgWallDuration", Long.valueOf(r19));
        l.a(r4, "longestMessageCpuDuration", -1);
        l.a(r4, "longestMsgStartCpuTime", Long.valueOf(r28));
        l.a(r4, "longestMsgEndCpuTime", -1);
        l.a(r4, "longestMsgStartWallTime", Long.valueOf(r24));
        l.a(r4, "longestMsgEndWallTime", Long.valueOf(r24 + r19));
        l.a(r4, "longestMsgType", "current");
        l.a(r4, "longestMsg", r2.optString("message"));
        l.a(r4, "longestMsgBlockStack", r2.optString("block_stack"));
        return;
    L72:
        return;
    L40:
        r24 = r11;
        r28 = r13;
        r7 = -1;
        goto L41
    }

    private static boolean b(JSONObject r8, JSONObject r9) {
        long r0 = r8.optLong("main_thread_cpu_tick") * ((long) r8.optInt("jiffy"));
        long r2 = r9.optLong("longestMsgStartCpuTime");
        long r10 = r9.optLong("longestMsgEndCpuTime");
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (r2 == 0) goto L16;
        long r11 = (r10 / 10) * 10;
        if (r0 >= ((r2 / 10) * 10)) goto L10;
        return false;
    L10:
        if (r0 >= r11) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static void a(JSONObject r3, JSONObject r4) {
        JSONArray r0 = r3.optJSONArray("history_message");
        if (r0 != null) goto L5;
    L7:
        l.a(r4, "has_history_message", "false");
    L8:
        JSONArray r1 = r3.optJSONArray("pending_messages");
        if (r1 != null) goto L11;
    L15:
        JSONObject r2 = r3.optJSONObject("history_details");
        if (r2 == null) goto L19;
        l.a(r4, "npth_message_longest_msg", r2.optString("longestMsg"));
        l.a(r4, "npth_message_longest_msg_type", r2.optString("longestMsgType"));
        l.a(r4, "npth_message_trace_is_evil", String.valueOf(b(r3, r2)));
        l.a(r4, "npth_message_has_block_stack", String.valueOf(!"".equals(r2.optString("longestMsgBlockStack"))));
        return;
    L19:
        return;
    L11:
        if (r1.length() <= 0) goto L15;
        JSONObject r5 = r1.optJSONObject(0);
        if (r5 == null) goto L15;
        l.a(r4, "npth_message_anr_with_barrier_new", String.valueOf(r5.optString("target").isEmpty()));
        goto L15
    L5:
        if (r0.length() <= 0) goto L7;
        l.a(r4, "has_history_message", "true");
        goto L8
    }
}
