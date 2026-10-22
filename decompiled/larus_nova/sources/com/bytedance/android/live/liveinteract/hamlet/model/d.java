package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/d;", "", "", com.heytap.mcssdk.constant.b.f276353c, "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class d {

    @SerializedName(com.heytap.mcssdk.constant.b.f276353c)
    private final Integer messageID;

    public d() {
        this(null);
    }

    public final Integer a() {
        return this.messageID;
    }

    public d(Integer r100) {
        this.messageID = r100;
    }
}
