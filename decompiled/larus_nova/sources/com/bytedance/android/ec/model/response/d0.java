package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/d0;", "", "", "trackName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setTrackName", "(Ljava/lang/String;)V", "", "trackParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("track_name")
    private String trackName;

    @SerializedName("track_param")
    private Map<String, String> trackParams;

    public d0() {
        this.trackName = null;
        this.trackParams = null;
    }

    public final String a() {
        return this.trackName;
    }

    public final Map<String, String> b() {
        return this.trackParams;
    }
}
