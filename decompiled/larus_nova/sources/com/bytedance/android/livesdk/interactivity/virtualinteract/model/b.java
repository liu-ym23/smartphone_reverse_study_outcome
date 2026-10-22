package com.bytedance.android.livesdk.interactivity.virtualinteract.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/virtualinteract/model/b;", "", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "", "actorId", "Ljava/lang/Long;", "getActorId", "()Ljava/lang/Long;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("actor_id")
    private final Long actorId;

    @SerializedName("status")
    private final Integer status;

    public b(Integer r100, Long r101) {
        this.status = r100;
        this.actorId = r101;
    }
}
