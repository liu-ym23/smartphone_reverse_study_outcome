package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.bdtracker.t2;
import com.stepos.pps.data.util.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c3 implements u2 {
    public final Throwable a;

    public c3(Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        this.a = throwable;
    }

    @Override // com.bytedance.bdtracker.s2
    public List<String> a() {
        return TextUtils.isEmpty(this.a.getMessage()) ? r.a() : CollectionsKt.listOf((Object[]) new String[]{"metrics_category", "metrics_name", "err_underlying_code"});
    }

    @Override // com.bytedance.bdtracker.t2
    public void a(JSONObject params) throws JSONException {
        Intrinsics.checkParameterIsNotNull(params, "params");
        StringWriter stringWriter = new StringWriter();
        this.a.printStackTrace(new PrintWriter(stringWriter));
        String message = this.a.getMessage();
        if (message == null) {
            message = Constants.UNKNOWN;
        }
        params.put("err_underlying_code", message);
        params.put("err_message", stringWriter.toString());
    }

    @Override // com.bytedance.bdtracker.t2
    public String b() {
        return "sdk_exception";
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
        return 1;
    }
}
