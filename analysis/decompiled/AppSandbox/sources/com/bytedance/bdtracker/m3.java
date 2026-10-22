package com.bytedance.bdtracker;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m3 extends g4 {
    public int[] I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public List<m3> N;

    public m3(g4 g4Var) {
        String str = g4Var.v;
        String str2 = g4Var.w;
        String str3 = g4Var.x;
        String str4 = g4Var.y;
        String str5 = g4Var.z;
        int i = g4Var.C;
        int i2 = g4Var.D;
        int i3 = g4Var.E;
        int i4 = g4Var.F;
        ArrayList<String> arrayList = g4Var.A;
        ArrayList<String> arrayList2 = g4Var.B;
        ArrayList<String> arrayList3 = g4Var.H;
        this.v = str;
        this.w = str2;
        this.x = str3;
        this.y = str4;
        this.z = str5;
        this.A = arrayList;
        this.B = arrayList2;
        this.C = i;
        this.D = i2;
        this.E = i3;
        this.F = i4;
        this.H = arrayList3;
        this.N = new ArrayList();
        this.v = g4Var.v;
        this.x = g4Var.x;
        this.B = g4Var.B;
        this.A = g4Var.A;
    }

    public JSONObject l() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            int[] iArr = this.I;
            if (iArr != null && iArr.length > 1) {
                jSONObject.put("x", iArr[0]);
                jSONObject.put("y", this.I[1]);
            }
            jSONObject.put("width", this.J);
            jSONObject.put("height", this.K);
            return jSONObject;
        } catch (JSONException e) {
            d().error(this.a, "JSON handle failed", e, new Object[0]);
            return null;
        }
    }
}
