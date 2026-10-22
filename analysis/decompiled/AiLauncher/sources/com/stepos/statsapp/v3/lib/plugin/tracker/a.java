package com.stepos.statsapp.v3.lib.plugin.tracker;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f30970a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f30971b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f30972c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f30973d;

    public a(String str, boolean z10, boolean z11, boolean z12) {
        this.f30970a = str;
        this.f30971b = z10;
        this.f30972c = z11;
        this.f30973d = z12;
    }

    public String a() {
        return this.f30970a;
    }

    public boolean b() {
        return this.f30971b;
    }

    public boolean c() {
        return this.f30973d;
    }

    public boolean d() {
        return this.f30972c;
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.f30970a);
            jSONObject.put("e_active", this.f30971b);
            jSONObject.put("e_realtime", this.f30972c);
            jSONObject.put("e_neartime", this.f30973d);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static a a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new a(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
