package com.bytedance.android.live.ai.api.business.asr;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;", "", "type", "", "modelPath", "", "modelVersion", "", "needUpdateModel", "", "extraParams", "", "(ILjava/lang/String;JZLjava/util/Map;)V", "getExtraParams", "()Ljava/util/Map;", "getModelPath", "()Ljava/lang/String;", "getModelVersion", "()J", "getNeedUpdateModel", "()Z", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsrResultStrategy {

    @SerializedName("extra_params")
    private final Map<String, Object> extraParams;

    @SerializedName("model_path")
    private final String modelPath;

    @SerializedName("model_version")
    private final long modelVersion;

    @SerializedName("need_update_model")
    private final boolean needUpdateModel;

    @SerializedName("type")
    private final int type;

    public AsrResultStrategy() {
        this(0, null, 0, false, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AsrResultStrategy copy$default(AsrResultStrategy r100, int r101, String r102, long r103, boolean r104, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.modelPath;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.modelVersion;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.needUpdateModel;
    L14:
        boolean r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.extraParams;
    L17:
        int r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.modelPath;
    }

    public final long component3() {
        return this.modelVersion;
    }

    public final boolean component4() {
        return this.needUpdateModel;
    }

    public final Map<String, Object> component5() {
        return this.extraParams;
    }

    public final AsrResultStrategy copy(int r100, String r110, long r111, boolean r112, Map<String, ? extends Object> r113) {
        return new AsrResultStrategy(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AsrResultStrategy) == false) goto L16;
        AsrResultStrategy r101 = (AsrResultStrategy) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.modelPath, r101.modelPath) == true) goto L10;
        return false;
    L10:
        if (this.modelVersion == r101.modelVersion) goto L12;
        return false;
    L12:
        if (this.needUpdateModel == r101.needUpdateModel) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.modelPath;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.modelVersion;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        boolean r106 = this.needUpdateModel;
        ?? r107 = r106;
        if (r106 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r105 + r107) * 31;
        Map<String, Object> r109 = this.extraParams;
        if (r109 == null) goto L13;
        r102 = r109.hashCode();
    L13:
        return r108 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "AsrResultStrategy(type=" + this.type + ", modelPath=" + this.modelPath + ", modelVersion=" + this.modelVersion + ", needUpdateModel=" + this.needUpdateModel + ", extraParams=" + this.extraParams + ")";
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final boolean getNeedUpdateModel() {
        return this.needUpdateModel;
    }

    public final int getType() {
        return this.type;
    }

    public AsrResultStrategy(int r100, String r101, long r102, boolean r103, Map<String, ? extends Object> r104) {
        this.type = r100;
        this.modelPath = r101;
        this.modelVersion = r102;
        this.needUpdateModel = r103;
        this.extraParams = r104;
    }

    public /* synthetic */ AsrResultStrategy(int r100, String r101, long r102, boolean r103, Map r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = "";
    L8:
        String r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = -1;
    L11:
        long r104 = r102;
        if ((r111 & 8) == 0) goto L14;
        boolean r105 = true;
    L16:
        if ((r111 & 16) == 0) goto L18;
        r110 = null;
    L18:
        int r106 = r100;
        boolean r114 = r105;
        this(r106, r113, r104, r114, r110);
        return;
    L14:
        r105 = r103;
        goto L16
    }
}
