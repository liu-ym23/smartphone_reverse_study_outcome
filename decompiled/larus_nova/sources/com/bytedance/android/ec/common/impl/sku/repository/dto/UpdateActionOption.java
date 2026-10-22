package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "Ljava/io/Serializable;", SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/APIAction;", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateActionOption implements Serializable {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<APIAction> actions;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateActionOption() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<APIAction> getActions() {
        return this.actions;
    }

    public UpdateActionOption(List<APIAction> r100) {
        this.actions = r100;
    }

    public /* synthetic */ UpdateActionOption(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
