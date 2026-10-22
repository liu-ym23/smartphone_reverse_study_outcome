package com.ss.android.deviceregister.base;

import android.text.TextUtils;
import com.bytedance.bdturing.localstorage.DbHelper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OaidModel.java */
/* JADX INFO: loaded from: classes4.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f37382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f37383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Boolean f37384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Long f37385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Long f37386e;
    final Integer f;
    final Long g;

    q(String r1, String r2, Boolean r3, Long r4, Long r5, Integer r6, Long r7) {
        this.f37382a = r1;
        this.f37383b = r2;
        this.f37384c = r3;
        this.f37385d = r4;
        this.f37386e = r5;
        this.f = r6;
        this.g = r7;
    }

    public String toString() {
        return b().toString();
    }

    Map<String, String> a() {
        HashMap r0 = new HashMap();
        t.a(r0, DbHelper.COL_ID, this.f37382a);
        t.a(r0, "req_id", this.f37383b);
        t.a(r0, "is_track_limited", String.valueOf(this.f37384c));
        t.a(r0, "take_ms", String.valueOf(this.f37385d));
        t.a(r0, "time", String.valueOf(this.f37386e));
        t.a(r0, "query_times", String.valueOf(this.f));
        t.a(r0, "hw_id_version_code", String.valueOf(this.g));
        return r0;
    }

    JSONObject b() {
        JSONObject r0 = new JSONObject();
        t.a(r0, DbHelper.COL_ID, this.f37382a);
        t.a(r0, "req_id", this.f37383b);
        t.a(r0, "is_track_limited", this.f37384c);
        t.a(r0, "take_ms", this.f37385d);
        t.a(r0, "time", this.f37386e);
        t.a(r0, "query_times", this.f);
        t.a(r0, "hw_id_version_code", this.g);
        return r0;
    }

    static q a(String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L30;
        return null;
    L30:
        JSONObject r5 = new JSONObject(r15);     // Catch: JSONException -> L27
        String r8 = r5.optString(DbHelper.COL_ID, null);     // Catch: JSONException -> L27
        String r9 = r5.optString("req_id", null);     // Catch: JSONException -> L27
        if (r5.has("is_track_limited") == false) goto L8;
        Boolean r10 = Boolean.valueOf(r5.optBoolean("is_track_limited"));     // Catch: JSONException -> L27
    L10:
        if (r5.has("take_ms") == false) goto L12;
        Long r16 = Long.valueOf(r5.optLong("take_ms", -1));     // Catch: JSONException -> L27
    L14:
        if (r5.has("time") == false) goto L16;
        Long r2 = Long.valueOf(r5.optLong("time", -1));     // Catch: JSONException -> L27
    L18:
        if (r5.has("query_times") == false) goto L20;
        Integer r13 = Integer.valueOf(r5.optInt("query_times", -1));     // Catch: JSONException -> L27
    L22:
        if (r5.has("hw_id_version_code") == false) goto L24;
        Long r14 = Long.valueOf(r5.optLong("hw_id_version_code", -1));     // Catch: JSONException -> L27
    L25:
        return new q(r8, r9, r10, r16, r2, r13, r14);
    L24:
        r14 = null;
        goto L25
    L20:
        r13 = null;
        goto L22
    L16:
        r2 = null;
        goto L18
    L12:
        r16 = null;
        goto L14
    L8:
        r10 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
