package com.bytedance.android.livesdk.vscore_api.schema;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/schema/HorizonXTabSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "tabId", "", "getTabId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSchemaHost", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizonXTabSchemaModel extends BaseSchemaModel {

    @SerializedName("tab_id")
    private final Integer tabId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.HORIZON_XTAB;
    }

    public HorizonXTabSchemaModel() {
        this.tabId = 0;
    }

    public final Integer getTabId() {
        return this.tabId;
    }
}
