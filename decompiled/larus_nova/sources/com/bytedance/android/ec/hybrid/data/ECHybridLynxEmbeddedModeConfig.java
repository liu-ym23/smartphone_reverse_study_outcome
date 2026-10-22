package com.bytedance.android.ec.hybrid.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/ECHybridLynxEmbeddedModeConfig;", "Ljava/io/Serializable;", "()V", "embeddedMode", "", "getEmbeddedMode", "()I", "enabledPages", "", "", "getEnabledPages", "()Ljava/util/List;", "enabledTypes", "getEnabledTypes", "isEnable", "", "pageName", "itemType", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridLynxEmbeddedModeConfig implements Serializable {

    @SerializedName("embedded_mode")
    private final int embeddedMode;

    @SerializedName("enabled_pages")
    private final List<String> enabledPages;

    @SerializedName("enabled_types")
    private final List<Integer> enabledTypes;

    public ECHybridLynxEmbeddedModeConfig() {
        this.embeddedMode = 5;
    }

    public final int getEmbeddedMode() {
        return this.embeddedMode;
    }

    public final List<String> getEnabledPages() {
        return this.enabledPages;
    }

    public final List<Integer> getEnabledTypes() {
        return this.enabledTypes;
    }

    public final boolean isEnable(String r100, Integer r101) {
        if (r100 == null) goto L29;
        if (r101 == null) goto L33;
        List<String> r102 = this.enabledPages;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L30;
        List<Integer> r104 = this.enabledTypes;
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L24;
        return false;
    L24:
        if (this.enabledPages.contains(r100) == true) goto L26;
        return false;
    L26:
        if (this.enabledTypes.contains(r101) == false) goto L32;
        return true;
    L32:
        return false;
    L17:
        if (r104.isEmpty() == true) goto L20;
        r105 = false;
        goto L21
    L30:
        return false;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L33:
        return false;
    L29:
        return false;
    }
}
