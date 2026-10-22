package com.bytedance.android.ec.model.promotion;

import com.bytedance.keva.KevaImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR,\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR,\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR2\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECResourceConfig;", "Ljava/io/Serializable;", "()V", "colors", "", "", "", "getColors", "()Ljava/util/Map;", "setColors", "(Ljava/util/Map;)V", KevaImpl.PrivateConstants.FILES_DIR_NAME, "getFiles", "setFiles", "fontSize", "", "getFontSize", "setFontSize", "radius", "", "getRadius", "setRadius", "size", "getSize", "setSize", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECResourceConfig implements Serializable {

    @SerializedName("colors")
    private Map<String, ? extends List<String>> colors;

    @SerializedName(KevaImpl.PrivateConstants.FILES_DIR_NAME)
    private Map<String, String> files;

    @SerializedName("font_size")
    private Map<String, Integer> fontSize;

    @SerializedName("radius")
    private Map<String, Float> radius;

    @SerializedName("size")
    private Map<String, ? extends List<Integer>> size;

    public ECResourceConfig() {
    }

    public final Map<String, List<String>> getColors() {
        return this.colors;
    }

    public final Map<String, String> getFiles() {
        return this.files;
    }

    public final Map<String, Integer> getFontSize() {
        return this.fontSize;
    }

    public final Map<String, Float> getRadius() {
        return this.radius;
    }

    public final Map<String, List<Integer>> getSize() {
        return this.size;
    }

    public final void setColors(Map<String, ? extends List<String>> r100) {
        this.colors = r100;
    }

    public final void setFiles(Map<String, String> r100) {
        this.files = r100;
    }

    public final void setFontSize(Map<String, Integer> r100) {
        this.fontSize = r100;
    }

    public final void setRadius(Map<String, Float> r100) {
        this.radius = r100;
    }

    public final void setSize(Map<String, ? extends List<Integer>> r100) {
        this.size = r100;
    }
}
