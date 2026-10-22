package com.bytedance.android.ec.model.response;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/CancelAction;", "Ljava/io/Serializable;", "", ReportConstant.COMMON_ACTION_TYPE, "I", "getActionType", "()I", "setActionType", "(I)V", "", "isSingleRoom", "Z", "()Z", "setSingleRoom", "(Z)V", "Lcom/bytedance/android/ec/model/response/TimeLimitScope;", "cancelScope", "Lcom/bytedance/android/ec/model/response/TimeLimitScope;", "getCancelScope", "()Lcom/bytedance/android/ec/model/response/TimeLimitScope;", "setCancelScope", "(Lcom/bytedance/android/ec/model/response/TimeLimitScope;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CancelAction implements Serializable {
    public static final int ACTION_CLICK_CART = 1;
    public static final a Companion = null;

    @SerializedName("action_type")
    private int actionType;

    @SerializedName("cancel_scope")
    private TimeLimitScope cancelScope;

    @SerializedName("is_single_room")
    private boolean isSingleRoom;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CancelAction() {
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final TimeLimitScope getCancelScope() {
        return this.cancelScope;
    }

    public final boolean isSingleRoom() {
        return this.isSingleRoom;
    }

    public final void setActionType(int r100) {
        this.actionType = r100;
    }

    public final void setCancelScope(TimeLimitScope r100) {
        this.cancelScope = r100;
    }

    public final void setSingleRoom(boolean r100) {
        this.isSingleRoom = r100;
    }
}
