package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/RedirectSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "entry", "", "defaultSchema", "schemeQuery", "urlQuery", "decodeQueryValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDecodeQueryValue", "()Ljava/lang/String;", "getDefaultSchema", "getEntry", "getSchemeQuery", "getUrlQuery", "getSchemaHost", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedirectSchemaModel extends BaseSchemaModel {

    @SerializedName("decode_query_value")
    private final String decodeQueryValue;

    @SerializedName("default_schema")
    private final String defaultSchema;

    @SerializedName("entry")
    private final String entry;

    @SerializedName("scheme_query")
    private final String schemeQuery;

    @SerializedName("url_query")
    private final String urlQuery;

    public RedirectSchemaModel() {
        this(null, null, null, null, null);
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return "webcast_redirect";
    }

    public final String getDecodeQueryValue() {
        return this.decodeQueryValue;
    }

    public final String getDefaultSchema() {
        return this.defaultSchema;
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getSchemeQuery() {
        return this.schemeQuery;
    }

    public final String getUrlQuery() {
        return this.urlQuery;
    }

    public RedirectSchemaModel(String r100, String r101, String r102, String r103, String r104) {
        this.entry = r100;
        this.defaultSchema = r101;
        this.schemeQuery = r102;
        this.urlQuery = r103;
        this.decodeQueryValue = r104;
    }
}
