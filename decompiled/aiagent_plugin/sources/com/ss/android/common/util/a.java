package com.ss.android.common.util;

import com.bytedance.applog.log.l;
import com.ss.android.common.applog.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogDevToolsUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static String a(String r1) {
        if ("event_v3".equalsIgnoreCase(r1) == false) goto L6;
        return "EVENT_V3";
    L6:
        return r1;
    }

    public static void a(final String r4, final p r5) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r0 = b(r5);
        if (r0 > 0) goto L8;
        return;
    L8:
        l.a("event_save_db", new AnonymousClass1(r4, r0, r5));
    }

    public static void a(final String r5, final JSONObject r6) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r3 = r6.optLong("event_id", 0);
        if (r3 > 0) goto L8;
        return;
    L8:
        l.a("event_save_db", new AnonymousClass2(r6, r3, r5));
    }

    public static void b(final String r4, final p r5) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r0 = b(r5);
        if (r0 > 0) goto L8;
        return;
    L8:
        l.a("event_receive", new AnonymousClass3(r4, r0, r5));
    }

    public static void a(final JSONObject r5) {
        if (l.a() == true) goto L11;
        if (r5 == null) goto L12;
        final long r3 = r5.optLong("event_id", 0);
        if (r3 > 0) goto L9;
        return;
    L9:
        l.a("event_receive", new AnonymousClass4(r5, r3));
        return;
    L12:
        return;
    }

    public static void b(final JSONObject r5) {
        if (l.a() == true) goto L11;
        if (r5 == null) goto L12;
        final long r3 = r5.optLong("event_id", 0);
        if (r3 > 0) goto L9;
        return;
    L9:
        l.a("event_receive", new AnonymousClass5(r5, r3));
        return;
    L12:
        return;
    }

    public static void a(p r4) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r0 = b(r4);
        if (r0 > 0) goto L8;
        return;
    L8:
        l.a("event_realtime_eid", new AnonymousClass6(r0));
    }

    public static void a(p r4, final boolean r5) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final long r0 = b(r4);
        if (r0 > 0) goto L8;
        return;
    L8:
        l.a("event_upload_eid", new AnonymousClass7(r0, r5));
    }

    public static void a(JSONObject r2, final boolean r3) {
        if (l.a() == false) goto L5;
        return;
    L5:
        final JSONArray r0 = new JSONArray();
        a(r2, "launch", r0);
        a(r2, "terminate", r0);
        a(r2, "log_data", r0);
        a(r2, "event", r0);
        a(r2, "event_v3", r0);
        if (r0.length() != 0) goto L8;
        return;
    L8:
        l.a("event_upload_eid", new AnonymousClass8(r0, r3));
    }

    private static void a(JSONObject r4, String r5, JSONArray r6) {
        JSONArray r7 = r4.optJSONArray(r5);
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.length() <= 0) goto L20;
        int r8 = 0;
    L8:
        if (r8 >= r7.length()) goto L21;
        JSONObject r0 = r7.optJSONObject(r8);
        if (r0 == null) goto L14;
        long r1 = r0.optLong("event_id", 0);
        if (r1 <= 0) goto L14;
        r6.put(r1);
    L14:
        r8 = r8 + 1;
        goto L8
    L21:
        return;
    }

    private static long b(p r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (r4.f37197a > 0) goto L7;
        return 0;
    L7:
        return r4.f37197a;
    }
}
