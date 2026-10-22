package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u001bJ\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR,\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/model/response/LynxCellData;", "Ljava/io/Serializable;", "type", "", "config", "Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;", "content", "", ControlRule.KEY_EXTRA_DATA, "", "(ILcom/bytedance/android/ec/model/response/LynxCellDataConfig;Ljava/lang/String;Ljava/util/Map;)V", "getConfig", "()Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;", "getContent", "()Ljava/lang/String;", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "dataValid", "", "equals", "other", "", "hashCode", "isAiSummary", "isNewNps", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LynxCellData implements Serializable {

    @SerializedName("config")
    private final LynxCellDataConfig config;

    @SerializedName("content")
    private final String content;

    @SerializedName("extra_data")
    private Map<String, String> extraData;

    @SerializedName("type")
    private final int type;

    public LynxCellData() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxCellData copy$default(LynxCellData r100, int r101, LynxCellDataConfig r102, String r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.config;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extraData;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.type;
    }

    public final LynxCellDataConfig component2() {
        return this.config;
    }

    public final String component3() {
        return this.content;
    }

    public final Map<String, String> component4() {
        return this.extraData;
    }

    public final LynxCellData copy(int r100, LynxCellDataConfig r101, String r102, Map<String, String> r103) {
        return new LynxCellData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LynxCellData) == false) goto L14;
        LynxCellData r101 = (LynxCellData) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        LynxCellDataConfig r101 = this.config;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.content;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.extraData;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "LynxCellData(type=" + this.type + ", config=" + this.config + ", content=" + this.content + ", extraData=" + this.extraData + ")";
    }

    public final boolean dataValid() {
        if (this.type == LynxCellDataType.TYPE_INVALID.getType()) goto L13;
        LynxCellDataConfig r100 = this.config;
        if (r100 == null) goto L13;
        if (r100.dataValid() != true) goto L13;
        String r101 = this.content;
        if (r101 == null) goto L13;
        if (com.bytedance.android.shopping.anchorv3.a.b(r101) != true) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean isAiSummary() {
        if (this.type != LynxCellDataType.TYPE_AI.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNewNps() {
        if (this.type != LynxCellDataType.TYPE_NPS.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final LynxCellDataConfig getConfig() {
        return this.config;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getExtraData() {
        return this.extraData;
    }

    public final int getType() {
        return this.type;
    }

    public final void setExtraData(Map<String, String> r100) {
        this.extraData = r100;
    }

    public LynxCellData(int r100, LynxCellDataConfig r101, String r102, Map<String, String> r103) {
        this.type = r100;
        this.config = r101;
        this.content = r102;
        this.extraData = r103;
    }

    public /* synthetic */ LynxCellData(int r100, LynxCellDataConfig r101, String r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = LynxCellDataType.TYPE_INVALID.getType();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
