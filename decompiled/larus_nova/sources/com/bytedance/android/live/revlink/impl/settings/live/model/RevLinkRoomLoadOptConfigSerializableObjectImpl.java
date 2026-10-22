package com.bytedance.android.live.revlink.impl.settings.live.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w41.b;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkRoomLoadOptConfigSerializableObjectImpl;", "Lw41/b;", "", "enterPkUseSei", "Z", "getEnterPkUseSei", "()Z", "enterPkCheckIllegalSei", "getEnterPkCheckIllegalSei", "disableJustEnterRoomSeiLoad", "M2", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkRoomLoadOptConfigSerializableObjectImpl implements b {

    @SerializedName("disable_just_enter_room_sei_load")
    private final boolean disableJustEnterRoomSeiLoad;

    @SerializedName("enter_pk_check_illegal_sei")
    private final boolean enterPkCheckIllegalSei;

    @SerializedName("enter_pk_use_sei")
    private final boolean enterPkUseSei;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkRoomLoadOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLinkRoomLoadOptConfigSerializableObjectImpl.class);
        }
    }

    public RevLinkRoomLoadOptConfigSerializableObjectImpl() {
        this.enterPkUseSei = false;
        this.enterPkCheckIllegalSei = false;
        this.disableJustEnterRoomSeiLoad = false;
    }

    @Override // w41.b
    public final boolean M2() {
        return this.disableJustEnterRoomSeiLoad;
    }
}
