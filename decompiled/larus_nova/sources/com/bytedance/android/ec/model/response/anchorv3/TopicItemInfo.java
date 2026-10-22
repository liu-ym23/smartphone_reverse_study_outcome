package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/TopicItemInfo;", "Ljava/io/Serializable;", "()V", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "id", "getId", "labelInfo", "getLabelInfo", "name", "getName", "propertyId", "getPropertyId", "propertyName", "getPropertyName", "schema", "getSchema", "selected", "getSelected", "setSelected", "(Ljava/lang/String;)V", "type", "getType", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class TopicItemInfo implements Serializable {

    @SerializedName("category_id")
    private final String categoryId;

    @SerializedName("icon")
    private final ECUrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f47944id;

    @SerializedName("info")
    private final String labelInfo;

    @SerializedName("name")
    private final String name;

    @SerializedName("property_id")
    private final String propertyId;

    @SerializedName("property_name")
    private final String propertyName;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("selected")
    private String selected;

    @SerializedName("type")
    private final String type;

    public TopicItemInfo() {
        this.selected = "0";
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f47944id;
    }

    public final String getLabelInfo() {
        return this.labelInfo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPropertyId() {
        return this.propertyId;
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSelected() {
        return this.selected;
    }

    public final String getType() {
        return this.type;
    }

    public final void setSelected(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selected = r100;
    }
}
