package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemAction;", "Ljava/io/Serializable;", "()V", "base", "", "getBase", "()Ljava/lang/String;", "setBase", "(Ljava/lang/String;)V", "jointFilter", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridListItemAction implements Serializable {

    @SerializedName("base")
    private String base;

    public ECHybridListItemAction() {
    }

    public final String getBase() {
        return this.base;
    }

    public final String jointFilter() {
        return this.base;
    }

    public final void setBase(String r100) {
        this.base = r100;
    }
}
