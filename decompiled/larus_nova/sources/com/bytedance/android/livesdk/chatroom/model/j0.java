package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/j0;", "", "", "Lcom/bytedance/android/livesdk/chatroom/model/i0;", "equips", "Ljava/util/List;", "b", "()Ljava/util/List;", "setEquips", "(Ljava/util/List;)V", "", "equipCapacity", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setEquipCapacity", "(J)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("equip_capacity")
    private long equipCapacity;

    @SerializedName("equips")
    private List<i0> equips;

    public j0() {
    }

    public final long a() {
        return this.equipCapacity;
    }

    public final List<i0> b() {
        return this.equips;
    }
}
