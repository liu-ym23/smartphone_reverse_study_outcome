package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/u3;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "", "teenModeType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u3 extends BaseResponse {

    @SerializedName("TeenModeType")
    private final int teenModeType;

    public u3() {
    }

    public final int a() {
        return this.teenModeType;
    }
}
