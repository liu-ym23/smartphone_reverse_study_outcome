package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/o;", "", "Lcom/bytedance/android/livesdk/chatroom/model/j0;", "equipState", "Lcom/bytedance/android/livesdk/chatroom/model/j0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/chatroom/model/j0;", "setEquipState", "(Lcom/bytedance/android/livesdk/chatroom/model/j0;)V", "Lcom/bytedance/android/livesdk/chatroom/model/k2;", "moneyCount", "Lcom/bytedance/android/livesdk/chatroom/model/k2;", "b", "()Lcom/bytedance/android/livesdk/chatroom/model/k2;", "setMoneyCount", "(Lcom/bytedance/android/livesdk/chatroom/model/k2;)V", "", "camp", "J", "getCamp", "()J", "setCamp", "(J)V", "heroConfigId", "getHeroConfigId", "setHeroConfigId", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("camp")
    private long camp;

    @SerializedName("equip_state")
    private j0 equipState;

    @SerializedName("hero_config_id")
    private long heroConfigId;

    @SerializedName("money_count")
    private k2 moneyCount;

    public o() {
    }

    public final j0 a() {
        return this.equipState;
    }

    public final k2 b() {
        return this.moneyCount;
    }
}
