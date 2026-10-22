package com.bytedance.bdtracker;

import com.bytedance.bdtracker.t2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class v2 implements u2 {
    public final int a;

    public v2(int i) {
        this.a = i;
    }

    @Override // com.bytedance.bdtracker.s2
    public List<String> a() {
        return r.a();
    }

    @Override // com.bytedance.bdtracker.t2
    public String b() {
        return "data_storage_count";
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
        return Integer.valueOf(this.a);
    }

    @Override // com.bytedance.bdtracker.t2
    public void a(JSONObject params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(params, "params");
        t2.a.a(params);
    }
}
