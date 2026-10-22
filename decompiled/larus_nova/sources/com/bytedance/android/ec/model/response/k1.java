package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/k1;", "", "Lcom/bytedance/android/ec/model/response/s1;", "click", "Lcom/bytedance/android/ec/model/response/s1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/s1;", "setClick", "(Lcom/bytedance/android/ec/model/response/s1;)V", "show", "c", "setShow", "Lcom/bytedance/android/ec/model/response/TrackEventType;", "eventType", "Lcom/bytedance/android/ec/model/response/TrackEventType;", "b", "()Lcom/bytedance/android/ec/model/response/TrackEventType;", "setEventType", "(Lcom/bytedance/android/ec/model/response/TrackEventType;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class k1 {

    @SerializedName("click")
    private s1 click;

    @SerializedName("event_type")
    private TrackEventType eventType;

    @SerializedName("show")
    private s1 show;

    public k1() {
    }

    public final s1 a() {
        return this.click;
    }

    public final TrackEventType b() {
        return this.eventType;
    }

    public final s1 c() {
        return this.show;
    }
}
