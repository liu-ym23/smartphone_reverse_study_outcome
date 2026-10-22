package com.bytedance.crash.npth_repair.a;

import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RepairPortrait.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f7642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f7643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f7644c;

    public static b a(JSONArray r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() >= 2) goto L7;
        return null;
    L7:
        return new b(r2);
    }

    public b(JSONArray r8) {
        this.f7642a = r8.optString(0).split(",");     // Catch: Throwable -> L14
        this.f7643b = r8.optString(1).split(",");     // Catch: Throwable -> L14
        this.f7644c = new JSONObject();     // Catch: Throwable -> L14
        int r3 = 2;
    L5:
        if (r3 >= r8.length()) goto L21;
        String r4 = r8.optString(r3);     // Catch: Throwable -> L14
        if ("".equals(r4) == true) goto L12;
        String[] r5 = r4.split(":");     // Catch: Throwable -> L14
        if (r5.length != 2) goto L12;
        this.f7644c.putOpt(r5[0], r5[1]);     // Catch: Throwable -> L14
    L12:
        r3 = r3 + 1;
        goto L5
    L21:
        return;
    }

    private static boolean a(String[] r5, String r6) {
        if (r5 != null) goto L5;
    L19:
        return false;
    L5:
        if (r5.length == 0) goto L19;
        if (OProtocolTextEffectTextView.EffectNameNone.equals(r5[0]) == false) goto L11;
        return false;
    L11:
        if ("all".equals(r5[0]) == false) goto L13;
        return true;
    L13:
        int r1 = r5.length;
        int r3 = 0;
    L14:
        if (r3 >= r1) goto L19;
        if (r5[r3].equals(r6) == true) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        return true;
    }

    public boolean a(int r1) {
        return a(this.f7642a, String.valueOf(r1));
    }

    public boolean a(String r1) {
        return a(this.f7643b, r1);
    }

    public JSONArray b(String r3) {
        if (this.f7644c == null) goto L14;
        if (r3 != null) goto L6;
        return null;
    L6:
        if ("".equals(r3) == true) goto L16;
        return new JSONArray(this.f7644c.optString(r3));
    L17:
        return null;
    L16:
        return null;
    L14:
        return null;
    }
}
