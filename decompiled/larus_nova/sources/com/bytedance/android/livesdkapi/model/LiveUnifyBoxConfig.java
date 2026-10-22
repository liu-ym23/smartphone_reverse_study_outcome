package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveUnifyBoxConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "handleRoomMove", "getHandleRoomMove", "setHandleRoomMove", "pullStreamNodes", "", "", "getPullStreamNodes", "()Ljava/util/List;", "setPullStreamNodes", "(Ljava/util/List;)V", "qosConstraintMove", "getQosConstraintMove", "setQosConstraintMove", "resolutionMove", "getResolutionMove", "setResolutionMove", "spMove", "getSpMove", "setSpMove", "srMove", "getSrMove", "setSrMove", "volumeBalanceMove", "getVolumeBalanceMove", "setVolumeBalanceMove", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveUnifyBoxConfig {
    public static final Companion Companion = null;
    private static boolean unifyServiceInit;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("handle_room_move")
    private boolean handleRoomMove;

    @SerializedName("pull_stream_nodes")
    private List<String> pullStreamNodes;

    @SerializedName("qos_constraint_move")
    private boolean qosConstraintMove;

    @SerializedName("resolution_move")
    private boolean resolutionMove;

    @SerializedName("sp_move")
    private boolean spMove;

    @SerializedName("sr_move")
    private boolean srMove;

    @SerializedName("volume_balance_move")
    private boolean volumeBalanceMove;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveUnifyBoxConfig$Companion;", "", "()V", "unifyServiceInit", "", "getUnifyServiceInit", "()Z", "setUnifyServiceInit", "(Z)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final boolean getUnifyServiceInit() {
            return LiveUnifyBoxConfig.access$getUnifyServiceInit$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setUnifyServiceInit(boolean r100) {
            LiveUnifyBoxConfig.access$setUnifyServiceInit$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LiveUnifyBoxConfig() {
        this.pullStreamNodes = new ArrayList();
    }

    public static final /* synthetic */ boolean access$getUnifyServiceInit$cp() {
        return unifyServiceInit;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getHandleRoomMove() {
        return this.handleRoomMove;
    }

    public final List<String> getPullStreamNodes() {
        return this.pullStreamNodes;
    }

    public final boolean getQosConstraintMove() {
        return this.qosConstraintMove;
    }

    public final boolean getResolutionMove() {
        return this.resolutionMove;
    }

    public final boolean getSpMove() {
        return this.spMove;
    }

    public final boolean getSrMove() {
        return this.srMove;
    }

    public final boolean getVolumeBalanceMove() {
        return this.volumeBalanceMove;
    }

    public static final /* synthetic */ void access$setUnifyServiceInit$cp(boolean r100) {
        unifyServiceInit = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setHandleRoomMove(boolean r100) {
        this.handleRoomMove = r100;
    }

    public final void setPullStreamNodes(List<String> r100) {
        this.pullStreamNodes = r100;
    }

    public final void setQosConstraintMove(boolean r100) {
        this.qosConstraintMove = r100;
    }

    public final void setResolutionMove(boolean r100) {
        this.resolutionMove = r100;
    }

    public final void setSpMove(boolean r100) {
        this.spMove = r100;
    }

    public final void setSrMove(boolean r100) {
        this.srMove = r100;
    }

    public final void setVolumeBalanceMove(boolean r100) {
        this.volumeBalanceMove = r100;
    }
}
