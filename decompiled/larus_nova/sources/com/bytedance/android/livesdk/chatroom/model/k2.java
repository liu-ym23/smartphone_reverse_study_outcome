package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/k2;", "", "", "playerInfo", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setPlayerInfo", "(Ljava/lang/String;)V", "compInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCompInfo", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k2 {

    @SerializedName("comp_info")
    private String compInfo;

    @SerializedName("player_info")
    private String playerInfo;

    public k2() {
        this.playerInfo = "";
        this.compInfo = "";
    }

    public final String a() {
        return this.compInfo;
    }

    public final String b() {
        return this.playerInfo;
    }
}
