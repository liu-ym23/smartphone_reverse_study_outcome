package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/SoloKtvSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", "songId", "", "getSongId", "()Ljava/lang/Long;", "setSongId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "sourceParams", "getSourceParams", "setSourceParams", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SoloKtvSchemaModel extends BaseSchemaModel {

    @SerializedName("top_song_id")
    private Long songId;

    @SerializedName("source")
    private String source;

    @SerializedName("source_params")
    private String sourceParams;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.ENTER_SOLO_KTV;
    }

    public SoloKtvSchemaModel() {
    }

    public final Long getSongId() {
        return this.songId;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getSourceParams() {
        return this.sourceParams;
    }

    public final void setSongId(Long r100) {
        this.songId = r100;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }

    public final void setSourceParams(String r100) {
        this.sourceParams = r100;
    }
}
