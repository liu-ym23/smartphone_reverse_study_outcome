package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/q3;", "", "", "gameState", "I", "b", "()I", "setGameState", "(I)V", "Lcom/bytedance/android/livesdk/chatroom/model/t3;", "roleInfo", "Lcom/bytedance/android/livesdk/chatroom/model/t3;", "d", "()Lcom/bytedance/android/livesdk/chatroom/model/t3;", "setRoleInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/t3;)V", "", "Lcom/bytedance/android/livesdk/chatroom/model/r3;", "liveInfoList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setLiveInfoList", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/chatroom/model/p3;", "displayConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDisplayConfig", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q3 {

    @SerializedName("display_config")
    private List<p3> displayConfig;

    @SerializedName("game_state")
    private int gameState;

    @SerializedName("live_info_list")
    private List<r3> liveInfoList;

    @SerializedName("role_info")
    private t3 roleInfo;

    public q3() {
        this.gameState = -1;
    }

    public final List<p3> a() {
        return this.displayConfig;
    }

    public final int b() {
        return this.gameState;
    }

    public final List<r3> c() {
        return this.liveInfoList;
    }

    public final t3 d() {
        return this.roleInfo;
    }
}
