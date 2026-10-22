package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/BasicTestSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "funcType", "", "funcEnable", "", "funcParams", "funcAction", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getFuncAction", "()Ljava/lang/String;", "getFuncEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFuncParams", "getFuncType", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BasicTestSchemaModel extends BaseSchemaModel {

    @SerializedName("funcAction")
    private final String funcAction;

    @SerializedName("funcEnable")
    private final Boolean funcEnable;

    @SerializedName("funcParams")
    private final String funcParams;

    @SerializedName("funcType")
    private final String funcType;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.TEST_MOCK;
    }

    public final String getFuncAction() {
        return this.funcAction;
    }

    public final Boolean getFuncEnable() {
        return this.funcEnable;
    }

    public final String getFuncParams() {
        return this.funcParams;
    }

    public final String getFuncType() {
        return this.funcType;
    }

    public BasicTestSchemaModel(String r100, Boolean r101, String r102, String r103) {
        this.funcType = r100;
        this.funcEnable = r101;
        this.funcParams = r102;
        this.funcAction = r103;
    }
}
