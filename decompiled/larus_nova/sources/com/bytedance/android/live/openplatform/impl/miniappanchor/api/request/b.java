package com.bytedance.android.live.openplatform.impl.miniappanchor.api.request;

import am3.g;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.constant.OpenPlatformConstants$LaunchSource;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.ModifyShelfRequest")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/request/b;", "", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "", "roomId", "J", "getRoomId", "()J", "startId", "getStartId", "launchSource", "getLaunchSource", "schema", "getSchema", "", "isBeforeStart", "Z", "()Z", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "cardInfoList", "Ljava/util/List;", "getCardInfoList", "()Ljava/util/List;", "", "mountType", "I", "getMountType", "()I", "mpLiveChannel", "getMpLiveChannel", "openExtra", "getOpenExtra", "clientExtra", "getClientExtra", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("card_info_list")
    protected List<ShelfCardInfo> cardInfoList;

    @SerializedName("client_extra")
    protected String clientExtra;

    @SerializedName("is_before_start")
    protected boolean isBeforeStart;

    @SerializedName("launch_source")
    protected long launchSource;

    @SerializedName("mount_type")
    protected int mountType;

    @SerializedName("mp_live_channel")
    protected String mpLiveChannel;

    @SerializedName("open_extra")
    protected String openExtra;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("start_id")
    protected long startId;

    public b(String r100, long r101, long r102, long r103, String r104, boolean r105, List<ShelfCardInfo> r110, int r111, String r112, String r113, String r114) {
        this.appId = r100;
        this.roomId = r101;
        this.startId = r102;
        this.launchSource = r103;
        this.schema = r104;
        this.isBeforeStart = r105;
        this.cardInfoList = r110;
        this.mountType = r111;
        this.mpLiveChannel = r112;
        this.openExtra = r113;
        this.clientExtra = r114;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L28;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L8;
        return false;
    L8:
        if (this.roomId == r101.roomId) goto L10;
        return false;
    L10:
        if (this.startId == r101.startId) goto L12;
        return false;
    L12:
        if (this.launchSource == r101.launchSource) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L16;
        return false;
    L16:
        if (this.isBeforeStart == r101.isBeforeStart) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cardInfoList, r101.cardInfoList) == true) goto L20;
        return false;
    L20:
        if (this.mountType == r101.mountType) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.mpLiveChannel, r101.mpLiveChannel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.openExtra, r101.openExtra) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.clientExtra, r101.clientExtra) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    public final int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.roomId;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.startId;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.launchSource;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.schema;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.isBeforeStart;
        ?? r113 = r112;
        if (r112 == false) goto L13;
        r113 = 1;
    L13:
        int r114 = (r111 + r113) * 31;
        List<ShelfCardInfo> r115 = this.cardInfoList;
        if (r115 == null) goto L16;
        int r116 = r115.hashCode();
    L17:
        int r117 = (((r114 + r116) * 31) + this.mountType) * 31;
        String r118 = this.mpLiveChannel;
        if (r118 == null) goto L20;
        int r119 = r118.hashCode();
    L21:
        int r120 = (r117 + r119) * 31;
        String r121 = this.openExtra;
        if (r121 == null) goto L24;
        int r122 = r121.hashCode();
    L25:
        int r123 = (r120 + r122) * 31;
        String r124 = this.clientExtra;
        if (r124 == null) goto L29;
        r101 = r124.hashCode();
    L29:
        return r123 + r101;
    L24:
        r122 = 0;
        goto L25
    L20:
        r119 = 0;
        goto L21
    L16:
        r116 = 0;
        goto L17
    L9:
        r110 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ModifyShelfRequest(appId=" + this.appId + ", roomId=" + this.roomId + ", startId=" + this.startId + ", launchSource=" + this.launchSource + ", schema=" + this.schema + ", isBeforeStart=" + this.isBeforeStart + ", cardInfoList=" + this.cardInfoList + ", mountType=" + this.mountType + ", mpLiveChannel=" + this.mpLiveChannel + ", openExtra=" + this.openExtra + ", clientExtra=" + this.clientExtra + ")";
    }

    public b() {
        this.appId = null;
        this.roomId = -1;
        this.startId = -1;
        this.launchSource = OpenPlatformConstants$LaunchSource.Panel.getValue();
        this.schema = null;
        this.isBeforeStart = false;
        this.cardInfoList = null;
        this.mountType = ShelfInfo.MountType.UnsetMount.getValue();
        this.mpLiveChannel = null;
        this.openExtra = null;
        this.clientExtra = null;
    }

    public b(g r100) {
        this.cardInfoList = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 99) goto L7;
        this.openExtra = am3.h.c(r100);
        goto L3
    L7:
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L8;
        };
    L9:
        this.mpLiveChannel = am3.h.c(r100);
        goto L3
    L10:
        this.clientExtra = am3.h.c(r100);
        goto L3
    L11:
        this.mountType = r100.i();
        r102 = r102 | 16;
        goto L3
    L12:
        this.startId = r100.j();
        r102 = r102 | 2;
        goto L3
    L13:
        this.cardInfoList.add(new ShelfCardInfo(r100));
        goto L3
    L14:
        this.isBeforeStart = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L15:
        this.schema = am3.h.c(r100);
        goto L3
    L16:
        this.launchSource = r100.j();
        r102 = r102 | 4;
        goto L3
    L17:
        this.roomId = r100.j();
        r102 = r102 | 1;
        goto L3
    L18:
        this.appId = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this.appId != null) goto L24;
        this.appId = null;
    L24:
        if ((r102 & 1) != 0) goto L27;
        this.roomId = -1;
    L27:
        if ((r102 & 2) != 0) goto L30;
        this.startId = -1;
    L30:
        if ((r102 & 4) != 0) goto L33;
        this.launchSource = OpenPlatformConstants$LaunchSource.Panel.getValue();
    L33:
        if (this.schema != null) goto L36;
        this.schema = null;
    L36:
        if ((r102 & 8) != 0) goto L39;
        this.isBeforeStart = false;
    L39:
        if (this.cardInfoList.isEmpty() == false) goto L42;
        this.cardInfoList = null;
    L42:
        if ((r102 & 16) != 0) goto L45;
        this.mountType = ShelfInfo.MountType.UnsetMount.getValue();
    L45:
        if (this.mpLiveChannel != null) goto L48;
        this.mpLiveChannel = null;
    L48:
        if (this.openExtra != null) goto L51;
        this.openExtra = null;
    L51:
        if (this.clientExtra != null) goto L81;
        this.clientExtra = null;
        return;
    }
}
