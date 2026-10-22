package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "Ljava/io/Serializable;", "()V", "grey", "", "getGrey", "()Ljava/lang/Boolean;", "setGrey", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "isDiffModel", "isFetchModel", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PrefetchOrder implements Serializable {

    @SerializedName("grey")
    private Boolean grey;

    @SerializedName("schema")
    private String schema;

    public PrefetchOrder() {
    }

    public final boolean isDiffModel() {
        return Intrinsics.areEqual(this.grey, Boolean.TRUE);
    }

    public final boolean isFetchModel() {
        return !Intrinsics.areEqual(this.grey, Boolean.TRUE);
    }

    public final Boolean getGrey() {
        return this.grey;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setGrey(Boolean r100) {
        this.grey = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }
}
