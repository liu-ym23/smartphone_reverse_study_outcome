package com.bytedance.android.livesdk.livecommerce.playback.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB5\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J7\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/model/EnterRoomInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "roomId", "enterRoomSchema", "enterRoomText", "liveStatus", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "getEnterRoomSchema", "getEnterRoomText", "Z", "getLiveStatus", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterRoomInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final String enterRoomSchema;
    private final String enterRoomText;
    private final boolean liveStatus;
    private final String roomId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EnterRoomInfo() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ EnterRoomInfo copy$default(EnterRoomInfo r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.roomId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.enterRoomSchema;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enterRoomText;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.liveStatus;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.enterRoomSchema;
    }

    public final String component3() {
        return this.enterRoomText;
    }

    public final boolean component4() {
        return this.liveStatus;
    }

    public final EnterRoomInfo copy(String r100, String r101, String r102, boolean r103) {
        return new EnterRoomInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EnterRoomInfo) == false) goto L14;
        EnterRoomInfo r101 = (EnterRoomInfo) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterRoomSchema, r101.enterRoomSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterRoomText, r101.enterRoomText) == true) goto L12;
        return false;
    L12:
        if (this.liveStatus == r101.liveStatus) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterRoomSchema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterRoomText;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.liveStatus;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EnterRoomInfo(roomId=" + this.roomId + ", enterRoomSchema=" + this.enterRoomSchema + ", enterRoomText=" + this.enterRoomText + ", liveStatus=" + this.liveStatus + ")";
    }

    public final String getEnterRoomSchema() {
        return this.enterRoomSchema;
    }

    public final String getEnterRoomText() {
        return this.enterRoomText;
    }

    public final boolean getLiveStatus() {
        return this.liveStatus;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public EnterRoomInfo(String r100, String r101, String r102, boolean r103) {
        this.roomId = r100;
        this.enterRoomSchema = r101;
        this.enterRoomText = r102;
        this.liveStatus = r103;
    }

    public /* synthetic */ EnterRoomInfo(String r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
