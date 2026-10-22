package com.bytedance.android.livesdkapi.vr;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/vr/VrEffectLayerInfo;", "", "unicId", "", "roomId", "type", "playerStreamFormat", "layerStatus", "", "", "layerCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getLayerCount", "()I", "getLayerStatus", "()Ljava/util/List;", "getPlayerStreamFormat", "()Ljava/lang/String;", "getRoomId", "getType", "getUnicId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrEffectLayerInfo {

    @SerializedName("layer_count")
    private final int layerCount;

    @SerializedName("layer_status")
    private final List<Integer> layerStatus;

    @SerializedName("player_stream_format")
    private final String playerStreamFormat;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("type")
    private final String type;

    @SerializedName("unic_id")
    private final String unicId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VrEffectLayerInfo copy$default(VrEffectLayerInfo r100, String r101, String r102, String r103, String r104, List r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.unicId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.roomId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.type;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.playerStreamFormat;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.layerStatus;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.layerCount;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.unicId;
    }

    public final String component2() {
        return this.roomId;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.playerStreamFormat;
    }

    public final List<Integer> component5() {
        return this.layerStatus;
    }

    public final int component6() {
        return this.layerCount;
    }

    public final VrEffectLayerInfo copy(String r100, String r110, String r111, String r112, List<Integer> r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "unicId");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "playerStreamFormat");
        return new VrEffectLayerInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VrEffectLayerInfo) == false) goto L18;
        VrEffectLayerInfo r101 = (VrEffectLayerInfo) r100;
        if (Intrinsics.areEqual(this.unicId, r101.unicId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.playerStreamFormat, r101.playerStreamFormat) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.layerStatus, r101.layerStatus) == true) goto L16;
        return false;
    L16:
        if (this.layerCount == r101.layerCount) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.unicId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.type;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.playerStreamFormat;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = this.layerStatus;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.layerCount;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "VrEffectLayerInfo(unicId=" + this.unicId + ", roomId=" + this.roomId + ", type=" + this.type + ", playerStreamFormat=" + this.playerStreamFormat + ", layerStatus=" + this.layerStatus + ", layerCount=" + this.layerCount + ")";
    }

    public final int getLayerCount() {
        return this.layerCount;
    }

    public final List<Integer> getLayerStatus() {
        return this.layerStatus;
    }

    public final String getPlayerStreamFormat() {
        return this.playerStreamFormat;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUnicId() {
        return this.unicId;
    }

    public VrEffectLayerInfo(String r100, String r101, String r102, String r103, List<Integer> r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "unicId");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "playerStreamFormat");
        this.unicId = r100;
        this.roomId = r101;
        this.type = r102;
        this.playerStreamFormat = r103;
        this.layerStatus = r104;
        this.layerCount = r105;
    }

    public /* synthetic */ VrEffectLayerInfo(String r100, String r101, String r110, String r111, List r112, int r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 4) == 0) goto L5;
        r110 = "vrLayerInfo";
    L5:
        String r102 = r110;
        if ((r114 & 8) == 0) goto L8;
        r111 = LiveVrEffectInfo.STREAM_FORMAT_LITE_MODE_6DOF_ON_SEPERATED;
    L8:
        String r103 = r111;
        if ((r114 & 16) == 0) goto L11;
        r112 = null;
    L11:
        List r104 = r112;
        if ((r114 & 32) == 0) goto L14;
        int r105 = 0;
    L15:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L14:
        r105 = r113;
        goto L15
    }
}
