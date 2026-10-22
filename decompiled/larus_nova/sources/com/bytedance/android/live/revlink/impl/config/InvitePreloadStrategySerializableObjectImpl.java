package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.d;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/InvitePreloadStrategySerializableObjectImpl;", "Lr11/d;", "", "aggressivePreload", "Z", "l4", "()Z", "checkPkTime", "J1", "checkMuteState", "X", "checkNeverOpenInvite", "B2", "checkActiveUser", "O5", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InvitePreloadStrategySerializableObjectImpl implements d {

    @SerializedName("aggressive_preload")
    private final boolean aggressivePreload;

    @SerializedName("check_active_user")
    private final boolean checkActiveUser;

    @SerializedName("check_mute_state")
    private final boolean checkMuteState;

    @SerializedName("check_never_open_invite")
    private final boolean checkNeverOpenInvite;

    @SerializedName("check_pk_time")
    private final boolean checkPkTime;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/InvitePreloadStrategySerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(InvitePreloadStrategySerializableObjectImpl.class);
        }
    }

    public InvitePreloadStrategySerializableObjectImpl() {
        this.aggressivePreload = true;
        this.checkPkTime = true;
        this.checkMuteState = true;
        this.checkNeverOpenInvite = true;
        this.checkActiveUser = true;
    }

    @Override // r11.d
    public final boolean B2() {
        return this.checkNeverOpenInvite;
    }

    @Override // r11.d
    public final boolean J1() {
        return this.checkPkTime;
    }

    @Override // r11.d
    public final boolean O5() {
        return this.checkActiveUser;
    }

    @Override // r11.d
    public final boolean X() {
        return this.checkMuteState;
    }

    @Override // r11.d
    public final boolean l4() {
        return this.aggressivePreload;
    }
}
