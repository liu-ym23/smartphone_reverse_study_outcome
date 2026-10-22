package com.bytedance.android.ec.host.api.ui.xelement;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/host/api/ui/xelement/LynxEcomHorizonListCardData;", "Ljava/io/Serializable;", "()V", "awemeStruct", "Lcom/google/gson/JsonObject;", "getAwemeStruct", "()Lcom/google/gson/JsonObject;", "setAwemeStruct", "(Lcom/google/gson/JsonObject;)V", "backgroundImage", "getBackgroundImage", "setBackgroundImage", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "horizontalCardName", "", "getHorizontalCardName", "()Ljava/lang/String;", "setHorizontalCardName", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "width", "getWidth", "setWidth", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxEcomHorizonListCardData implements Serializable {

    @SerializedName("aweme_struct")
    private JsonObject awemeStruct;

    @SerializedName("background_image")
    private JsonObject backgroundImage;

    @SerializedName("height")
    private Integer height;

    @SerializedName("horizontal_card_name")
    private String horizontalCardName;

    @SerializedName("schema")
    private String schema;

    @SerializedName("width")
    private Integer width;

    public LynxEcomHorizonListCardData() {
    }

    public final JsonObject getAwemeStruct() {
        return this.awemeStruct;
    }

    public final JsonObject getBackgroundImage() {
        return this.backgroundImage;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getHorizontalCardName() {
        return this.horizontalCardName;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setAwemeStruct(JsonObject r100) {
        this.awemeStruct = r100;
    }

    public final void setBackgroundImage(JsonObject r100) {
        this.backgroundImage = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setHorizontalCardName(String r100) {
        this.horizontalCardName = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }
}
