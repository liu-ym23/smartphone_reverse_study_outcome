package com.bytedance.android.livesdkapi.model;

import com.amap.api.services.core.AMapException;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveGameUniversalLayoutConfig;", "", "multiRenderLegalId", "", "", "singleRenderLegalId", "multiStyleThreshold", "", "disableOpt", "", "seiOpt", "handleRoom", "(Ljava/util/List;Ljava/util/List;FZZZ)V", "getDisableOpt", "()Z", "getHandleRoom", "getMultiRenderLegalId", "()Ljava/util/List;", "getMultiStyleThreshold", "()F", "getSeiOpt", "getSingleRenderLegalId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveGameUniversalLayoutConfig {

    @SerializedName("disable_opt")
    private final boolean disableOpt;

    @SerializedName("handle_room")
    private final boolean handleRoom;

    @SerializedName("multi_legal_id")
    private final List<Integer> multiRenderLegalId;

    @SerializedName("multi_style_threshold")
    private final float multiStyleThreshold;

    @SerializedName("sei_opt")
    private final boolean seiOpt;

    @SerializedName("single_legal_id")
    private final List<Integer> singleRenderLegalId;

    public LiveGameUniversalLayoutConfig() {
        this(null, null, 0.0f, false, false, false, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveGameUniversalLayoutConfig copy$default(LiveGameUniversalLayoutConfig r100, List r101, List r102, float r103, boolean r104, boolean r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.multiRenderLegalId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.singleRenderLegalId;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.multiStyleThreshold;
    L11:
        float r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.disableOpt;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.seiOpt;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.handleRoom;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<Integer> component1() {
        return this.multiRenderLegalId;
    }

    public final List<Integer> component2() {
        return this.singleRenderLegalId;
    }

    public final float component3() {
        return this.multiStyleThreshold;
    }

    public final boolean component4() {
        return this.disableOpt;
    }

    public final boolean component5() {
        return this.seiOpt;
    }

    public final boolean component6() {
        return this.handleRoom;
    }

    public final LiveGameUniversalLayoutConfig copy(List<Integer> r100, List<Integer> r110, float r111, boolean r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "multiRenderLegalId");
        return new LiveGameUniversalLayoutConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveGameUniversalLayoutConfig) == false) goto L18;
        LiveGameUniversalLayoutConfig r101 = (LiveGameUniversalLayoutConfig) r100;
        if (Intrinsics.areEqual(this.multiRenderLegalId, r101.multiRenderLegalId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.singleRenderLegalId, r101.singleRenderLegalId) == true) goto L10;
        return false;
    L10:
        if (Float.compare(this.multiStyleThreshold, r101.multiStyleThreshold) == 0) goto L12;
        return false;
    L12:
        if (this.disableOpt == r101.disableOpt) goto L14;
        return false;
    L14:
        if (this.seiOpt == r101.seiOpt) goto L16;
        return false;
    L16:
        if (this.handleRoom == r101.handleRoom) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        List<Integer> r100 = this.multiRenderLegalId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.singleRenderLegalId;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((r103 + r101) * 31) + Float.floatToIntBits(this.multiStyleThreshold)) * 31;
        boolean r106 = this.disableOpt;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.seiOpt;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.handleRoom;
        if (r113 == true) goto L20;
        r107 = r113;
    L20:
        return r112 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveGameUniversalLayoutConfig(multiRenderLegalId=" + this.multiRenderLegalId + ", singleRenderLegalId=" + this.singleRenderLegalId + ", multiStyleThreshold=" + this.multiStyleThreshold + ", disableOpt=" + this.disableOpt + ", seiOpt=" + this.seiOpt + ", handleRoom=" + this.handleRoom + ")";
    }

    public final boolean getDisableOpt() {
        return this.disableOpt;
    }

    public final boolean getHandleRoom() {
        return this.handleRoom;
    }

    public final List<Integer> getMultiRenderLegalId() {
        return this.multiRenderLegalId;
    }

    public final float getMultiStyleThreshold() {
        return this.multiStyleThreshold;
    }

    public final boolean getSeiOpt() {
        return this.seiOpt;
    }

    public final List<Integer> getSingleRenderLegalId() {
        return this.singleRenderLegalId;
    }

    public LiveGameUniversalLayoutConfig(List<Integer> r100, List<Integer> r101, float r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "multiRenderLegalId");
        this.multiRenderLegalId = r100;
        this.singleRenderLegalId = r101;
        this.multiStyleThreshold = r102;
        this.disableOpt = r103;
        this.seiOpt = r104;
        this.handleRoom = r105;
    }

    public /* synthetic */ LiveGameUniversalLayoutConfig(List r100, List r101, float r102, boolean r103, boolean r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        boolean r105 = true;
        if ((r111 & 1) == 0) goto L6;
        r100 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(DataLoaderHelper.DATALOADER_KEY_INT_DEV_DISK_SIZE_MB), Integer.valueOf(AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT), 2003});
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = CollectionsKt.listOf(1105);
    L8:
        List r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        float r106 = 0.75f;
    L13:
        if ((r111 & 8) == 0) goto L15;
        boolean r107 = true;
    L17:
        if ((r111 & 16) == 0) goto L19;
        boolean r108 = true;
    L21:
        if ((r111 & 32) != 0) goto L24;
        r105 = r110;
    L24:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L19:
        r108 = r104;
        goto L21
    L15:
        r107 = r103;
        goto L17
    L11:
        r106 = r102;
        goto L13
    }
}
