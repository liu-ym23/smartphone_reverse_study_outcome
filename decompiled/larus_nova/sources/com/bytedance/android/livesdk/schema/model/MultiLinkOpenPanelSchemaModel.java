package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/MultiLinkOpenPanelSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "type", "", "subType", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getSchemaHost", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkOpenPanelSchemaModel extends BaseSchemaModel {

    @SerializedName("sub_type")
    private final Integer subType;

    @SerializedName("type")
    private final Integer type;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.MULTI_LINK_PANEL;
    }

    public final Integer getSubType() {
        return this.subType;
    }

    public final Integer getType() {
        return this.type;
    }

    public MultiLinkOpenPanelSchemaModel(Integer r100, Integer r101) {
        this.type = r100;
        this.subType = r101;
    }
}
