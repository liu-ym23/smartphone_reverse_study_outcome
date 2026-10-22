package com.bytedance.bdtracker;

import com.bytedance.bdtracker.t2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class z2 implements u2 {
    public String a;
    public long b;
    public int c = 1;

    @Override // com.bytedance.bdtracker.s2
    public List<String> a() {
        return r.a();
    }

    @Override // com.bytedance.bdtracker.t2
    public void a(JSONObject params) throws JSONException {
        Intrinsics.checkParameterIsNotNull(params, "params");
        params.put("api_name", this.a);
        params.put("api_time", this.b);
    }

    @Override // com.bytedance.bdtracker.t2
    public String b() {
        return "api_call";
    }

    @Override // com.bytedance.bdtracker.s2
    public int c() {
        return 7;
    }

    @Override // com.bytedance.bdtracker.t2
    public JSONObject d() {
        return t2.a.a(this);
    }

    @Override // com.bytedance.bdtracker.t2
    public String e() {
        return "data_statistics";
    }

    @Override // com.bytedance.bdtracker.s2
    public List<Number> f() {
        return r.d();
    }

    @Override // com.bytedance.bdtracker.t2
    public Object g() {
        return Integer.valueOf(this.c);
    }
}
