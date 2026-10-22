package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n0;", "", "Lcom/bytedance/android/livesdk/chatroom/model/c3;", "roleInfo", "Lcom/bytedance/android/livesdk/chatroom/model/c3;", "d", "()Lcom/bytedance/android/livesdk/chatroom/model/c3;", "setRoleInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/c3;)V", "Lcom/bytedance/android/livesdk/chatroom/model/b2;", "liveInfo", "Lcom/bytedance/android/livesdk/chatroom/model/b2;", "c", "()Lcom/bytedance/android/livesdk/chatroom/model/b2;", "setLiveInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/b2;)V", "Lcom/bytedance/android/livesdk/chatroom/model/o;", "battleInfo", "Lcom/bytedance/android/livesdk/chatroom/model/o;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/chatroom/model/o;", "setBattleInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/o;)V", "Lcom/bytedance/android/livesdk/chatroom/model/p;", "battleStickerConfig", "Lcom/bytedance/android/livesdk/chatroom/model/p;", "b", "()Lcom/bytedance/android/livesdk/chatroom/model/p;", "setBattleStickerConfig", "(Lcom/bytedance/android/livesdk/chatroom/model/p;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("battle_info")
    private o battleInfo;

    @SerializedName("battle_sticker_config")
    private p battleStickerConfig;

    @SerializedName("live_info")
    private b2 liveInfo;

    @SerializedName("role_info")
    private c3 roleInfo;

    public n0() {
    }

    public final o a() {
        return this.battleInfo;
    }

    public final p b() {
        return this.battleStickerConfig;
    }

    public final b2 c() {
        return this.liveInfo;
    }

    public final c3 d() {
        return this.roleInfo;
    }
}
