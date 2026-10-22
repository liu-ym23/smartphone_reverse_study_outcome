package com.bytedance.android.livesdkapi.model;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveRealNameOptConfig;", "", "()V", "enable", "", "getEnable", "()Z", "interceptorRegexList", "", "", "getInterceptorRegexList", "()Ljava/util/List;", "lynxSchema", "getLynxSchema", "()Ljava/lang/String;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRealNameOptConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("interceptor_regex_list")
    private final List<String> interceptorRegexList;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private final String lynxSchema;

    public LiveRealNameOptConfig() {
        this.lynxSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fwebcast_native_lynx_wallet_douyin%2Fpages%2Fverify%2Ftwo_factor%2Ftemplate.js&type=fullscreen&hide_more=0&hide_nav_bar=1&hide_status_bar=0";
        this.interceptorRegexList = new ArrayList();
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getInterceptorRegexList() {
        return this.interceptorRegexList;
    }

    public final String getLynxSchema() {
        return this.lynxSchema;
    }
}
