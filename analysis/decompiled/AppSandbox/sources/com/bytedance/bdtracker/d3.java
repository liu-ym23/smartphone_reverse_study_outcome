package com.bytedance.bdtracker;

import com.bytedance.bdtracker.t2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d3 implements e3 {
    public final long a;

    public d3(long j) {
        this.a = j;
    }

    @Override // com.bytedance.bdtracker.s2
    public List<String> a() {
        return r.a();
    }

    @Override // com.bytedance.bdtracker.t2
    public void a(JSONObject params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        r.a((e3) this, params);
    }

    @Override // com.bytedance.bdtracker.t2
    public String b() {
        return "sdk_init";
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
        return "sdk_usage";
    }

    @Override // com.bytedance.bdtracker.s2
    public List<Number> f() {
        return r.d();
    }

    @Override // com.bytedance.bdtracker.t2
    public Object g() {
        return Long.valueOf(h());
    }

    public long h() {
        return this.a;
    }
}
