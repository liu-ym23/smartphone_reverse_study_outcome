package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/SliceItemAction;", "Ljava/io/Serializable;", "()V", SlcCommonAction.KEY_ACTIONS, "", "getActions", "()Ljava/util/List;", "disable", "", "getDisable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", SlcCommonAction.KEY_PARAMS, "", "", "", "getFields", "()Ljava/util/Map;", "type", "getType", "()Ljava/lang/String;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceItemAction implements Serializable {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<SliceItemAction> actions;

    @SerializedName("disable")
    private final Boolean disable;

    @SerializedName(SlcCommonAction.KEY_PARAMS)
    private final Map<String, Object> fields;

    @SerializedName("type")
    private final String type;

    public SliceItemAction() {
    }

    public final List<SliceItemAction> getActions() {
        return this.actions;
    }

    public final Boolean getDisable() {
        return this.disable;
    }

    public final Map<String, Object> getFields() {
        return this.fields;
    }

    public final String getType() {
        return this.type;
    }
}
