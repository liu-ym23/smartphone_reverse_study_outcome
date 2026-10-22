package com.bytedance.android.livesdkapi.model;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class CropSeiData {

    @SerializedName("crop_h")
    public int cropH;

    @SerializedName("crop_w")
    public int cropW;

    @SerializedName("crop_x")
    public int cropX;

    @SerializedName("crop_y")
    public int cropY;

    @SerializedName("stride_h")
    public int strideH;

    @SerializedName("stride_w")
    public int strideW;

    public CropSeiData() {
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.cropX, this.cropY, this.cropW, this.cropH, this.strideW, this.strideH});
    }

    public boolean isLegalCropSei() {
        int r100 = this.cropH;
        if (r100 <= 0) goto L26;
        int r101 = this.cropW;
        if (r101 <= 0) goto L27;
        int r102 = this.strideW;
        if (r102 <= 0) goto L28;
        int r103 = this.strideH;
        if (r103 <= 0) goto L33;
        int r104 = this.cropX;
        if (r104 < 0) goto L29;
        if (r104 > r102) goto L34;
        int r105 = this.cropY;
        if (r105 < 0) goto L30;
        if (r105 > r103) goto L35;
        if (r101 > r102) goto L31;
        if (r100 > r103) goto L36;
        if (r100 < r103) goto L24;
        if (r101 < r102) goto L24;
        return false;
    L24:
        return true;
    L36:
        return false;
    L31:
        return false;
    L35:
        return false;
    L30:
        return false;
    L34:
        return false;
    L29:
        return false;
    L33:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public boolean isValid() {
        if (this.strideW >= 0) goto L6;
        return false;
    L6:
        if (this.cropW >= 0) goto L9;
        return false;
    L9:
        if (this.strideH >= 0) goto L12;
        return false;
    L12:
        if (this.cropH >= 0) goto L14;
        return false;
    L14:
        return true;
    }

    public String toString() {
        return "CropSeiData{cropX=" + this.cropX + ", cropY=" + this.cropY + ", cropW=" + this.cropW + ", cropH=" + this.cropH + ", strideW=" + this.strideW + ", strideH=" + this.strideH + '}';
    }

    public static CropSeiData parseCropSei(JSONObject r100) {
        if (r100 == null) goto L25;
        CropSeiData r101 = new CropSeiData();
        if (r100.has("crop_x") == false) goto L18;
        r101.cropX = r100.optInt("crop_x");
        if (r100.has("crop_y") == false) goto L20;
        r101.cropY = r100.optInt("crop_y");
        if (r100.has("crop_w") == false) goto L21;
        r101.cropW = r100.optInt("crop_w");
        if (r100.has("crop_h") == false) goto L22;
        r101.cropH = r100.optInt("crop_h");
        if (r100.has("stride_w") == false) goto L23;
        r101.strideW = r100.optInt("stride_w");
        if (r100.has("stride_h") == false) goto L24;
        r101.strideH = r100.optInt("stride_h");
        return r101;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    L18:
        return null;
    L25:
        return null;
    }

    public static CropSeiData parseCropSeiFromStr(String r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L9
        if (r101.has("live_crop") == false) goto L14;
        return parseCropSei(JSONObjectProtectorUtils.getJSONObject(r101, "live_crop"));
    L14:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        CropSeiData r101 = (CropSeiData) r100;
        if (this.cropX == r101.cropX) goto L13;
    L23:
        return false;
    L13:
        if (this.cropY != r101.cropY) goto L23;
        if (this.cropW != r101.cropW) goto L23;
        if (this.cropH != r101.cropH) goto L23;
        if (this.strideW != r101.strideW) goto L23;
        if (this.strideH != r101.strideH) goto L23;
        return true;
    }
}
