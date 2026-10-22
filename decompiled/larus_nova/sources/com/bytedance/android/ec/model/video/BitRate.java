package com.bytedance.android.ec.model.video;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R \u0010,\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001e\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00062"}, d2 = {"Lcom/bytedance/android/ec/model/video/BitRate;", "Ljava/io/Serializable;", "()V", "bitRate", "", "getBitRate", "()I", "setBitRate", "(I)V", "fps", "", "getFps", "()Ljava/lang/Long;", "setFps", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "gearName", "", "getGearName", "()Ljava/lang/String;", "setGearName", "(Ljava/lang/String;)V", "hdrBit", "getHdrBit", "setHdrBit", "hdrType", "getHdrType", "setHdrType", "isBytevc1", "()Ljava/lang/Integer;", "setBytevc1", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isH265", "setH265", "playAddr", "Lcom/bytedance/android/ec/model/video/UrlModel;", "getPlayAddr", "()Lcom/bytedance/android/ec/model/video/UrlModel;", "setPlayAddr", "(Lcom/bytedance/android/ec/model/video/UrlModel;)V", "playAddr265", "getPlayAddr265", "setPlayAddr265", "playAddrBytevc1", "getPlayAddrBytevc1", "setPlayAddrBytevc1", "qualityType", "getQualityType", "setQualityType", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BitRate implements Serializable {

    @SerializedName("bit_rate")
    private int bitRate;

    @SerializedName("FPS")
    private Long fps;

    @SerializedName("gear_name")
    private String gearName;

    @SerializedName("HDR_bit")
    private String hdrBit;

    @SerializedName("HDR_type")
    private String hdrType;

    @SerializedName("is_bytevc1")
    private Integer isBytevc1;

    @SerializedName("is_h265")
    private int isH265;

    @SerializedName("play_addr")
    private UrlModel playAddr;

    @SerializedName("play_addr_265")
    private UrlModel playAddr265;

    @SerializedName("play_addr_bytevc1")
    private UrlModel playAddrBytevc1;

    @SerializedName("quality_type")
    private int qualityType;

    public BitRate() {
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public final Long getFps() {
        return this.fps;
    }

    public final String getGearName() {
        return this.gearName;
    }

    public final String getHdrBit() {
        return this.hdrBit;
    }

    public final String getHdrType() {
        return this.hdrType;
    }

    public final UrlModel getPlayAddr() {
        return this.playAddr;
    }

    public final UrlModel getPlayAddr265() {
        return this.playAddr265;
    }

    public final UrlModel getPlayAddrBytevc1() {
        return this.playAddrBytevc1;
    }

    public final int getQualityType() {
        return this.qualityType;
    }

    public final Integer isBytevc1() {
        return this.isBytevc1;
    }

    public final int isH265() {
        return this.isH265;
    }

    public final void setBitRate(int r100) {
        this.bitRate = r100;
    }

    public final void setBytevc1(Integer r100) {
        this.isBytevc1 = r100;
    }

    public final void setFps(Long r100) {
        this.fps = r100;
    }

    public final void setGearName(String r100) {
        this.gearName = r100;
    }

    public final void setH265(int r100) {
        this.isH265 = r100;
    }

    public final void setHdrBit(String r100) {
        this.hdrBit = r100;
    }

    public final void setHdrType(String r100) {
        this.hdrType = r100;
    }

    public final void setPlayAddr(UrlModel r100) {
        this.playAddr = r100;
    }

    public final void setPlayAddr265(UrlModel r100) {
        this.playAddr265 = r100;
    }

    public final void setPlayAddrBytevc1(UrlModel r100) {
        this.playAddrBytevc1 = r100;
    }

    public final void setQualityType(int r100) {
        this.qualityType = r100;
    }
}
