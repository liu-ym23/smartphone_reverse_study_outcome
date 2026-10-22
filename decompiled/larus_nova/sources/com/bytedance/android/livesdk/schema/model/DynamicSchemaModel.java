package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/DynamicSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "enterFromMerge", "", "enterMethod", "userId", "requestPage", "secUid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnterFromMerge", "()Ljava/lang/String;", "getEnterMethod", "getRequestPage", "getSecUid", "getUserId", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicSchemaModel extends BaseSchemaModel {

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("request_page")
    private final String requestPage;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("user_id")
    private final String userId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return "webcast_dynamic";
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getRequestPage() {
        return this.requestPage;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getUserId() {
        return this.userId;
    }

    public DynamicSchemaModel(String r100, String r101, String r102, String r103, String r104) {
        this.enterFromMerge = r100;
        this.enterMethod = r101;
        this.userId = r102;
        this.requestPage = r103;
        this.secUid = r104;
    }
}
