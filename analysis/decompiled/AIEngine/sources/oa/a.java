package oa;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f10835a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10836b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10837c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10838d;

    public a(String str, boolean z, boolean z3, boolean z10) {
        this.f10835a = str;
        this.f10836b = z;
        this.f10837c = z3;
        this.f10838d = z10;
    }

    public final String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.f10835a);
            jSONObject.put("e_active", this.f10836b);
            jSONObject.put("e_realtime", this.f10837c);
            jSONObject.put("e_neartime", this.f10838d);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
