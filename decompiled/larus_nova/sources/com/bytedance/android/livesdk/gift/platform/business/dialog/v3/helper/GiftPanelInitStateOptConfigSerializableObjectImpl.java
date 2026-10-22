package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelInitStateOptConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/b0;", "", "disableQueryUserHonor", "Z", "r0", "()Z", "stateTransitionOpt", "l8", "selectTypeChangeOpt", DiagnoseResult.DIAGNOSE_LEVEL_P2, "changeReceiverModeOpt", "o5", "disableDialogResume", "E0", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelInitStateOptConfigSerializableObjectImpl implements b0 {

    @SerializedName("change_receiver_mode_opt")
    private final boolean changeReceiverModeOpt;

    @SerializedName("disable_dialog_resume")
    private final boolean disableDialogResume;

    @SerializedName("disable_query_user_honor")
    private final boolean disableQueryUserHonor;

    @SerializedName("select_type_change_opt")
    private final boolean selectTypeChangeOpt;

    @SerializedName("state_transition_opt")
    private final boolean stateTransitionOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelInitStateOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftPanelInitStateOptConfigSerializableObjectImpl.class);
        }
    }

    public GiftPanelInitStateOptConfigSerializableObjectImpl() {
        this.disableQueryUserHonor = false;
        this.stateTransitionOpt = false;
        this.selectTypeChangeOpt = false;
        this.changeReceiverModeOpt = false;
        this.disableDialogResume = false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b0
    public final boolean E0() {
        return this.disableDialogResume;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b0
    public final boolean P2() {
        return this.selectTypeChangeOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b0
    public final boolean l8() {
        return this.stateTransitionOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b0
    public final boolean o5() {
        return this.changeReceiverModeOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b0
    public final boolean r0() {
        return this.disableQueryUserHonor;
    }
}
