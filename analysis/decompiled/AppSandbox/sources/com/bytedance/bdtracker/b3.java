package com.bytedance.bdtracker;

import com.bytedance.bdtracker.t2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import stepos.com.android.internal.os.StatsdConfigProto;

/* loaded from: classes.dex */
public final class b3 implements t2 {
    public int a;
    public Integer b;
    public String c;
    public String d;
    public long e;

    @Override // com.bytedance.bdtracker.s2
    public List<String> a() {
        return this.b == null ? r.a() : CollectionsKt.listOf((Object[]) new String[]{"metrics_category", "metrics_name", "err_underlying_code"});
    }

    @Override // com.bytedance.bdtracker.t2
    public void a(JSONObject params) throws JSONException {
        Intrinsics.checkParameterIsNotNull(params, "params");
        if (this.c != null) {
            params.put("err_code", 2003);
            params.put("err_message", this.c);
            params.put("err_underlying_code", this.b);
        }
        params.put("dim_success", this.a);
    }

    @Override // com.bytedance.bdtracker.t2
    public String b() {
        String strSubstring = this.d;
        if (strSubstring == null) {
            return "";
        }
        if (StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) "?", false, 2, (Object) null)) {
            strSubstring = strSubstring.substring(0, StringsKt.indexOf$default((CharSequence) strSubstring, "?", 0, false, 6, (Object) null));
            Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return strSubstring != null ? strSubstring : "";
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
        return "network_service";
    }

    @Override // com.bytedance.bdtracker.s2
    public List<Integer> f() {
        return CollectionsKt.listOf((Object[]) new Integer[]{0, 500, Integer.valueOf(StatsdConfigProto.TimeUnit.CTS_VALUE), 1500, 2000, 2500, 5000});
    }

    @Override // com.bytedance.bdtracker.t2
    public Object g() {
        return Long.valueOf(this.e);
    }
}
