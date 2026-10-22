package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/s;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "", "Lcom/bytedance/android/livesdk/chatroom/model/b3;", "data", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s extends BaseResponse {

    @SerializedName("data")
    private final List<b3> data;

    public s() {
        this.data = CollectionsKt.emptyList();
    }

    public final List<b3> a() {
        return this.data;
    }
}
