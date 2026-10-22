package com.bytedance.bdtracker;

import com.bytedance.applog.monitor.MonitorSampling;
import com.bytedance.bdtracker.t2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class x2 implements y2 {
    public int a = -1;
    public final long b;
    public final String c;
    public final long d;

    public x2(long j, String str, long j2) {
        this.b = j;
        this.c = str;
        this.d = j2;
    }

    @Override // com.bytedance.bdtracker.s2
    public List<String> a() {
        return this.a == -1 ? CollectionsKt.listOf((Object[]) new String[]{"metrics_category", "metrics_name", "dims_0", "launch_id", "process_id"}) : CollectionsKt.listOf((Object[]) new String[]{"metrics_category", "metrics_name", "dims_0", "launch_id", "process_id", "err_code"});
    }

    @Override // com.bytedance.bdtracker.t2
    public void a(JSONObject params) throws JSONException {
        Intrinsics.checkParameterIsNotNull(params, "params");
        params.put("dims_0", this.b);
        params.put("process_id", this.c);
        params.put("launch_id", MonitorSampling.INSTANCE.getGlobalColdLaunchId$agent_pickerChinaRelease());
        if (this.b == 13) {
            params.put("err_code", this.a);
        }
    }

    @Override // com.bytedance.bdtracker.t2
    public String b() {
        return "event_process";
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
        return "event";
    }

    @Override // com.bytedance.bdtracker.s2
    public List<Number> f() {
        return r.d();
    }

    @Override // com.bytedance.bdtracker.t2
    public Object g() {
        return Long.valueOf(this.d);
    }
}
