package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;", "Ljava/io/Serializable;", "()V", "entryText", "", "getEntryText", "()Ljava/lang/String;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "schema", "getSchema", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolEntryInfo implements Serializable {

    @SerializedName("entry_text")
    private final String entryText;

    @SerializedName("entry_icon")
    private final ECUrlModel icon;

    @SerializedName("entry_schema")
    private final String schema;

    public ToolEntryInfo() {
    }

    public final String getEntryText() {
        return this.entryText;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }
}
