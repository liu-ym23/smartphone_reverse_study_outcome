package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/p3;", "", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "getExtra", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "log_extra", "getLog_extra", "setLog_extra", "", "react_id", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setReact_id", "(Ljava/lang/String;)V", "enter_from", "getEnter_from", "setEnter_from", SimilarProductParam.AWEME_ID, "getAweme_id", "setAweme_id", "", "init_index", "Ljava/lang/Integer;", "getInit_index", "()Ljava/lang/Integer;", "setInit_index", "(Ljava/lang/Integer;)V", "current_time", "getCurrent_time", "setCurrent_time", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p3 {

    @SerializedName(SimilarProductParam.AWEME_ID)
    private String aweme_id;

    @SerializedName("current_time")
    private Integer current_time;

    @SerializedName("enter_from")
    private String enter_from;

    @SerializedName("extra")
    private JsonObject extra;

    @SerializedName("init_index")
    private Integer init_index;

    @SerializedName("log_extra")
    private JsonObject log_extra;

    @SerializedName("react_id")
    private String react_id;

    public p3() {
    }

    public final String a() {
        return this.react_id;
    }
}
