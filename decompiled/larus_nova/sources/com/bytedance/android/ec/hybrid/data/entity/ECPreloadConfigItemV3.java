package com.bytedance.android.ec.hybrid.data.entity;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R&\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u00062"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigItemV3;", "Ljava/io/Serializable;", "()V", "columnNum", "", "getColumnNum", "()Ljava/lang/Integer;", "setColumnNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "deviceScore", "Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDeviceScore;", "getDeviceScore", "()Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDeviceScore;", "setDeviceScore", "(Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDeviceScore;)V", "itemGapH", "", "getItemGapH", "()Ljava/lang/Double;", "setItemGapH", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "itemType", "getItemType", "setItemType", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "os", "", "getOs", "()Ljava/util/List;", "setOs", "(Ljava/util/List;)V", "preloadNum", "getPreloadNum", "setPreloadNum", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "schemaType", "getSchemaType", "setSchemaType", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPreloadConfigItemV3 implements Serializable {

    @SerializedName("column_num")
    private Integer columnNum;

    @SerializedName("device_score")
    private ECPreloadConfigDeviceScore deviceScore;

    @SerializedName("item_gap_h")
    private Double itemGapH;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("margin_left")
    private Double marginLeft;

    @SerializedName("margin_right")
    private Double marginRight;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @SerializedName("os")
    private List<Integer> f46678os;

    @SerializedName("preload_num")
    private Integer preloadNum;

    @SerializedName("schema")
    private String schema;

    @SerializedName("schema_type")
    private String schemaType;

    public ECPreloadConfigItemV3() {
        this.preloadNum = 1;
        this.columnNum = 1;
        Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.marginLeft = r100;
        this.marginRight = r100;
        this.itemGapH = r100;
    }

    public final Integer getColumnNum() {
        return this.columnNum;
    }

    public final ECPreloadConfigDeviceScore getDeviceScore() {
        return this.deviceScore;
    }

    public final Double getItemGapH() {
        return this.itemGapH;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final Double getMarginLeft() {
        return this.marginLeft;
    }

    public final Double getMarginRight() {
        return this.marginRight;
    }

    public final List<Integer> getOs() {
        return this.f46678os;
    }

    public final Integer getPreloadNum() {
        return this.preloadNum;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSchemaType() {
        return this.schemaType;
    }

    public final void setColumnNum(Integer r100) {
        this.columnNum = r100;
    }

    public final void setDeviceScore(ECPreloadConfigDeviceScore r100) {
        this.deviceScore = r100;
    }

    public final void setItemGapH(Double r100) {
        this.itemGapH = r100;
    }

    public final void setItemType(Integer r100) {
        this.itemType = r100;
    }

    public final void setMarginLeft(Double r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(Double r100) {
        this.marginRight = r100;
    }

    public final void setOs(List<Integer> r100) {
        this.f46678os = r100;
    }

    public final void setPreloadNum(Integer r100) {
        this.preloadNum = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSchemaType(String r100) {
        this.schemaType = r100;
    }
}
