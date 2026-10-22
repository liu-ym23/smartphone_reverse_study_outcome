package com.bytedance.bdtracker;

import com.bytedance.bdtracker.t2;
import com.stepos.pps.data.util.Constants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import stepos.com.android.internal.os.StatsdConfigProto;

/* loaded from: classes.dex */
public final class a3 implements e3 {
    public long a;

    public a3(long j) {
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
        return "db_delay_interval";
    }

    @Override // com.bytedance.bdtracker.s2
    public int c() {
        return 23;
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
    public List<Integer> f() {
        return CollectionsKt.listOf((Object[]) new Integer[]{0, Integer.valueOf(StatsdConfigProto.TimeUnit.CTS_VALUE), Integer.valueOf(Constants.LOGCAT_MAX_LINES), 60000, Integer.valueOf(Constants.MTK_LOG_UPLOAD_TIME_INTERVAL), 1200000, 3600000, 21600000});
    }

    @Override // com.bytedance.bdtracker.t2
    public Object g() {
        return Long.valueOf(h());
    }

    public long h() {
        return this.a;
    }
}
