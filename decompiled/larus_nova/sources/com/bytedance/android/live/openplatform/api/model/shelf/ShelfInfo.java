package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ShelfInfo")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\"\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010$\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010%\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/b;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "appInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "cardInfoList", "Ljava/util/List;", "", "startId", "J", "source", "status", "", "punishStatus", "I", "mountType", "", "", "startPageQuery", "Ljava/util/Map;", "imExtra", "Ljava/lang/String;", "logExtra", "clientExtra", "coexistRoom", "coexistKAAnchor", "coexistLogExtra", "shelfInfoToken", "schema", "", "isAutoMount", "Z", "openExtra", "entryPagePath", "mpLiveChannel", "MountType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfInfo implements Parcelable, b, h {
    public static final Parcelable.Creator<ShelfInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f83972a;

    @SerializedName("app_info")
    public ShelfMicroAppInfo appInfo;

    @SerializedName("card_info_list")
    public List<ShelfCardInfo> cardInfoList;

    @SerializedName("client_extra")
    public String clientExtra;

    @SerializedName("coexist_ka_anchor")
    public int coexistKAAnchor;

    @SerializedName("coexist_log_extra")
    public String coexistLogExtra;

    @SerializedName("coexist_room")
    public int coexistRoom;

    @IgnoreProtoFieldCheck
    @SerializedName("entry_page_path")
    public final String entryPagePath;

    @SerializedName("im_extra")
    public String imExtra;

    @IgnoreProtoFieldCheck
    @SerializedName("is_auto_mount")
    public final boolean isAutoMount;

    @SerializedName("log_extra")
    public String logExtra;

    @SerializedName("mount_type")
    public int mountType;

    @IgnoreProtoFieldCheck
    @SerializedName("mp_live_channel")
    public final String mpLiveChannel;

    @IgnoreProtoFieldCheck
    @SerializedName("open_extra")
    public final String openExtra;

    @SerializedName("punish_status")
    public int punishStatus;

    @SerializedName("schema")
    public String schema;

    @SerializedName("shelf_info_token")
    public String shelfInfoToken;

    @SerializedName("source")
    public long source;

    @SerializedName("start_id")
    public long startId;

    @SerializedName("start_page_query")
    public Map<String, String> startPageQuery;

    @SerializedName("status")
    public long status;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo$MountType;", "", "", "value", "I", "getValue", "()I", "UnsetMount", "NormalMount", "AdStarMount", "TalentMount", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MountType extends Enum<MountType> {
        public static final MountType AdStarMount = null;
        public static final MountType NormalMount = null;
        public static final MountType TalentMount = null;
        public static final MountType UnsetMount = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MountType[] f83973a = null;
        private final int value;

        static {
            MountType r100 = new MountType("UnsetMount", 0, 0);
            UnsetMount = r100;
            MountType r101 = new MountType("NormalMount", 1, 1);
            NormalMount = r101;
            MountType r102 = new MountType("AdStarMount", 2, 2);
            AdStarMount = r102;
            MountType r103 = new MountType("TalentMount", 3, 3);
            TalentMount = r103;
            f83973a = new MountType[]{r100, r101, r102, r103};
        }

        public static MountType valueOf(String r100) {
            return (MountType) r27.a.a(MountType.class, r100);
        }

        public static MountType[] values() {
            return (MountType[]) f83973a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public MountType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a implements Parcelable.Creator<ShelfInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfInfo createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "in");
            LinkedHashMap r100 = null;
            if (r210.readInt() == 0) goto L5;
            ShelfMicroAppInfo r101 = ShelfMicroAppInfo.CREATOR.createFromParcel(r210);
        L7:
            if (r210.readInt() == 0) goto L11;
            int r102 = r210.readInt();
            ArrayList r103 = new ArrayList(r102);
        L9:
            if (r102 == 0) goto L12;
            r103.add(ShelfCardInfo.CREATOR.createFromParcel(r210));
            r102 = r102 - 1;
        L12:
            long r104 = r210.readLong();
            long r105 = r210.readLong();
            long r110 = r210.readLong();
            int r111 = r210.readInt();
            int r112 = r210.readInt();
            if (r210.readInt() == 0) goto L17;
            int r106 = r210.readInt();
            r100 = new LinkedHashMap(r106);
        L15:
            if (r106 == 0) goto L17;
            r100.put(r210.readString(), r210.readString());
            r106 = r106 - 1;
        L17:
            LinkedHashMap r113 = r100;
            String r114 = r210.readString();
            String r115 = r210.readString();
            String r116 = r210.readString();
            int r117 = r210.readInt();
            int r118 = r210.readInt();
            String r211 = r210.readString();
            String r212 = r210.readString();
            String r213 = r210.readString();
            if (r210.readInt() == 0) goto L20;
            boolean r214 = true;
        L22:
            return new ShelfInfo(r101, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r211, r212, r213, r214, r210.readString(), r210.readString(), r210.readString());
        L20:
            r214 = false;
            goto L22
        L11:
            r103 = null;
            goto L12
        L5:
            r101 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfInfo[] newArray(int r100) {
            return new ShelfInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShelfInfo(ShelfMicroAppInfo r100, List<ShelfCardInfo> r101, long r102, long r103, long r110, int r111, int r112, Map<String, String> r113, String r114, String r115, String r116, int r117, int r118, String r210, String r211, String r212, boolean r213, String r214, String r215, String r216) {
        this.appInfo = r100;
        this.cardInfoList = r101;
        this.startId = r102;
        this.source = r103;
        this.status = r110;
        this.punishStatus = r111;
        this.mountType = r112;
        this.startPageQuery = r113;
        this.imExtra = r114;
        this.logExtra = r115;
        this.clientExtra = r116;
        this.coexistRoom = r117;
        this.coexistKAAnchor = r118;
        this.coexistLogExtra = r210;
        this.shelfInfoToken = r211;
        this.schema = r212;
        this.isAutoMount = r213;
        this.openExtra = r214;
        this.entryPagePath = r215;
        this.mpLiveChannel = r216;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShelfInfo) == false) goto L46;
        ShelfInfo r101 = (ShelfInfo) r100;
        if (Intrinsics.areEqual(this.appInfo, r101.appInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cardInfoList, r101.cardInfoList) == true) goto L10;
        return false;
    L10:
        if (this.startId == r101.startId) goto L12;
        return false;
    L12:
        if (this.source == r101.source) goto L14;
        return false;
    L14:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        if (this.punishStatus == r101.punishStatus) goto L18;
        return false;
    L18:
        if (this.mountType == r101.mountType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.startPageQuery, r101.startPageQuery) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.imExtra, r101.imExtra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.clientExtra, r101.clientExtra) == true) goto L28;
        return false;
    L28:
        if (this.coexistRoom == r101.coexistRoom) goto L30;
        return false;
    L30:
        if (this.coexistKAAnchor == r101.coexistKAAnchor) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.coexistLogExtra, r101.coexistLogExtra) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.shelfInfoToken, r101.shelfInfoToken) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L38;
        return false;
    L38:
        if (this.isAutoMount == r101.isAutoMount) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.openExtra, r101.openExtra) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.entryPagePath, r101.entryPagePath) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.mpLiveChannel, r101.mpLiveChannel) == true) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v54 */
    public final int hashCode() {
        ShelfMicroAppInfo r100 = this.appInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ShelfCardInfo> r104 = this.cardInfoList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.startId;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.source;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.status;
        int r112 = (((((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.punishStatus) * 31) + this.mountType) * 31;
        Map<String, String> r113 = this.startPageQuery;
        if (r113 == null) goto L13;
        int r114 = r113.hashCode();
    L14:
        int r115 = (r112 + r114) * 31;
        String r116 = this.imExtra;
        if (r116 == null) goto L17;
        int r117 = r116.hashCode();
    L18:
        int r118 = (r115 + r117) * 31;
        String r119 = this.logExtra;
        if (r119 == null) goto L21;
        int r120 = r119.hashCode();
    L22:
        int r121 = (r118 + r120) * 31;
        String r122 = this.clientExtra;
        if (r122 == null) goto L25;
        int r123 = r122.hashCode();
    L26:
        int r124 = (((((r121 + r123) * 31) + this.coexistRoom) * 31) + this.coexistKAAnchor) * 31;
        String r125 = this.coexistLogExtra;
        if (r125 == null) goto L29;
        int r126 = r125.hashCode();
    L30:
        int r127 = (r124 + r126) * 31;
        String r128 = this.shelfInfoToken;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        String r131 = this.schema;
        if (r131 == null) goto L37;
        int r132 = r131.hashCode();
    L38:
        int r133 = (r130 + r132) * 31;
        boolean r134 = this.isAutoMount;
        ?? r135 = r134;
        if (r134 == false) goto L41;
        r135 = 1;
    L41:
        int r136 = (r133 + r135) * 31;
        String r137 = this.openExtra;
        if (r137 == null) goto L44;
        int r138 = r137.hashCode();
    L45:
        int r139 = (r136 + r138) * 31;
        String r140 = this.entryPagePath;
        if (r140 == null) goto L48;
        int r141 = r140.hashCode();
    L49:
        int r142 = (r139 + r141) * 31;
        String r143 = this.mpLiveChannel;
        if (r143 == null) goto L53;
        r101 = r143.hashCode();
    L53:
        return r142 + r101;
    L48:
        r141 = 0;
        goto L49
    L44:
        r138 = 0;
        goto L45
    L37:
        r132 = 0;
        goto L38
    L33:
        r129 = 0;
        goto L34
    L29:
        r126 = 0;
        goto L30
    L25:
        r123 = 0;
        goto L26
    L21:
        r120 = 0;
        goto L22
    L17:
        r117 = 0;
        goto L18
    L13:
        r114 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfInfo(appInfo=" + this.appInfo + ", cardInfoList=" + this.cardInfoList + ", startId=" + this.startId + ", source=" + this.source + ", status=" + this.status + ", punishStatus=" + this.punishStatus + ", mountType=" + this.mountType + ", startPageQuery=" + this.startPageQuery + ", imExtra=" + this.imExtra + ", logExtra=" + this.logExtra + ", clientExtra=" + this.clientExtra + ", coexistRoom=" + this.coexistRoom + ", coexistKAAnchor=" + this.coexistKAAnchor + ", coexistLogExtra=" + this.coexistLogExtra + ", shelfInfoToken=" + this.shelfInfoToken + ", schema=" + this.schema + ", isAutoMount=" + this.isAutoMount + ", openExtra=" + this.openExtra + ", entryPagePath=" + this.entryPagePath + ", mpLiveChannel=" + this.mpLiveChannel + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        ShelfMicroAppInfo r102 = this.appInfo;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r102.writeToParcel(r100, 0);
    L6:
        List<ShelfCardInfo> r103 = this.cardInfoList;
        if (r103 == null) goto L12;
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<ShelfCardInfo> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L13;
        r104.next().writeToParcel(r100, 0);
    L13:
        r100.writeLong(this.startId);
        r100.writeLong(this.source);
        r100.writeLong(this.status);
        r100.writeInt(this.punishStatus);
        r100.writeInt(this.mountType);
        Map<String, String> r105 = this.startPageQuery;
        if (r105 == null) goto L19;
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, String> r107 = r106.next();
        r100.writeString(r107.getKey());
        r100.writeString(r107.getValue());
    L20:
        r100.writeString(this.imExtra);
        r100.writeString(this.logExtra);
        r100.writeString(this.clientExtra);
        r100.writeInt(this.coexistRoom);
        r100.writeInt(this.coexistKAAnchor);
        r100.writeString(this.coexistLogExtra);
        r100.writeString(this.shelfInfoToken);
        r100.writeString(this.schema);
        r100.writeInt(this.isAutoMount ? 1 : 0);
        r100.writeString(this.openExtra);
        r100.writeString(this.entryPagePath);
        r100.writeString(this.mpLiveChannel);
        return;
    L19:
        r100.writeInt(0);
        goto L20
    L12:
        r100.writeInt(0);
        goto L13
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final String b() {
        Intrinsics.checkNotNullParameter("coexist_module", "key");
        if (this.f83972a != null) goto L9;
        String r100 = this.coexistLogExtra;     // Catch: JSONException -> L15
        if (r100 != null) goto L8;
        r100 = SliceInitService.DEFAULT_SWITCH;
    L8:
        this.f83972a = new JSONObject(r100);     // Catch: JSONException -> L15
    L9:
        JSONObject r101 = this.f83972a;     // Catch: JSONException -> L15
        if (r101 == null) goto L13;
        String r102 = r101.optString("coexist_module");     // Catch: JSONException -> L15
        if (r102 == null) goto L13;
        return r102;
    L13:
        return "";
    }

    public final String c() {
        SchemaInfo.b r100 = SchemaInfo.f83978s;
        List<ShelfCardInfo> r101 = this.cardInfoList;
        if (r101 == null) goto L7;
        ShelfCardInfo r102 = (ShelfCardInfo) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L7;
        String r103 = r102.schema;
    L8:
        r100.getClass();
        SchemaInfo r104 = SchemaInfo.b.b(r103);
        if (r104 == null) goto L14;
        JSONObject r105 = r104.b();
        if (r105 == null) goto L14;
        String r106 = r105.optString(BdpAppEventConstant.PARAMS_ENTER_POSITION);
        if (r106 == null) goto L14;
        return r106;
    L14:
        return "";
    L7:
        r103 = null;
        goto L8
    }

    public final boolean d() {
        if (this.mountType != MountType.AdStarMount.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.mountType != MountType.TalentMount.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public ShelfInfo() {
        this.appInfo = null;
        this.cardInfoList = null;
        this.startId = 0;
        this.source = 0;
        this.status = 0;
        this.punishStatus = 0;
        this.mountType = MountType.UnsetMount.getValue();
        this.startPageQuery = null;
        this.imExtra = null;
        this.logExtra = null;
        this.clientExtra = null;
        this.coexistRoom = 0;
        this.coexistKAAnchor = 0;
        this.coexistLogExtra = null;
        this.shelfInfoToken = null;
        this.schema = null;
    }

    public ShelfInfo(am3.g r110) {
        this.cardInfoList = new ArrayList();
        this.startPageQuery = new HashMap();
        long r100 = r110.c();
        int r101 = 0;
    L3:
        int r102 = r110.f();
        String r103 = null;
        if (r102 == (-1)) goto L42;
        switch(r102) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L6;
        };
    L35:
        this.mountType = r110.i();
        r101 = r101 | 16;
        goto L3
    L36:
        this.punishStatus = r110.i();
        r101 = r101 | 8;
        goto L3
    L37:
        this.status = r110.i();
        r101 = r101 | 4;
        goto L3
    L38:
        this.source = r110.i();
        r101 = r101 | 2;
        goto L3
    L39:
        this.startId = r110.j();
        r101 = r101 | 1;
        goto L3
    L40:
        this.cardInfoList.add(new ShelfCardInfo(r110));
        goto L3
    L41:
        this.appInfo = new ShelfMicroAppInfo(r110);
        goto L3
    L6:
        switch(r102) {
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            default: goto L7;
        };
    L32:
        this.coexistKAAnchor = r110.i();
        r101 = r101 | 64;
        goto L3
    L33:
        this.coexistRoom = r110.i();
        r101 = r101 | 32;
        goto L3
    L34:
        this.clientExtra = am3.h.c(r110);
        goto L3
    L7:
        switch(r102) {
            case 95: goto L31;
            case 96: goto L13;
            case 97: goto L12;
            case 98: goto L11;
            case 99: goto L10;
            case 100: goto L9;
            default: goto L8;
        };
    L9:
        this.schema = am3.h.c(r110);
        goto L3
    L10:
        this.shelfInfoToken = am3.h.c(r110);
        goto L3
    L11:
        this.logExtra = am3.h.c(r110);
        goto L3
    L12:
        this.imExtra = am3.h.c(r110);
        goto L3
    L13:
        long r104 = r110.c();
        String r105 = null;
    L14:
        int r106 = r110.f();
        if (r106 == (-1)) goto L23;
        if (r106 != 1) goto L19;
        r103 = am3.h.c(r110);
        goto L14
    L19:
        if (r106 != 2) goto L20;
        r105 = am3.h.c(r110);
        goto L14
    L20:
        am3.h.e(r110);
        goto L14
    L23:
        r110.d(r104);
        Map<String, String> r107 = this.startPageQuery;
        if (r103 == null) goto L30;
        if (r105 == null) goto L28;
        r107.put(r103, r105);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L31:
        this.coexistLogExtra = am3.h.c(r110);
        goto L3
    L8:
        am3.h.e(r110);
        goto L3
    L42:
        r110.d(r100);
        if (this.appInfo != null) goto L46;
        this.appInfo = null;
    L46:
        if (this.cardInfoList.isEmpty() == false) goto L49;
        this.cardInfoList = null;
    L49:
        if ((r101 & 1) != 0) goto L52;
        this.startId = 0;
    L52:
        if ((r101 & 2) != 0) goto L55;
        this.source = 0;
    L55:
        if ((r101 & 4) != 0) goto L58;
        this.status = 0;
    L58:
        if ((r101 & 8) != 0) goto L61;
        this.punishStatus = 0;
    L61:
        if ((r101 & 16) != 0) goto L64;
        this.mountType = MountType.UnsetMount.getValue();
    L64:
        if (this.startPageQuery != null) goto L67;
        this.startPageQuery = null;
    L67:
        if (this.imExtra != null) goto L70;
        this.imExtra = null;
    L70:
        if (this.logExtra != null) goto L73;
        this.logExtra = null;
    L73:
        if (this.clientExtra != null) goto L76;
        this.clientExtra = null;
    L76:
        if ((r101 & 32) != 0) goto L79;
        this.coexistRoom = 0;
    L79:
        if ((r101 & 64) != 0) goto L82;
        this.coexistKAAnchor = 0;
    L82:
        if (this.coexistLogExtra != null) goto L85;
        this.coexistLogExtra = null;
    L85:
        if (this.shelfInfoToken != null) goto L88;
        this.shelfInfoToken = null;
    L88:
        if (this.schema != null) goto L140;
        this.schema = null;
        return;
    }

    public /* synthetic */ ShelfInfo(ShelfMicroAppInfo r210, List r211, int r212, String r310, String r311, String r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        ShelfMicroAppInfo r100 = null;
    L7:
        if ((r313 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r313 & 64) == 0) goto L13;
        int r110 = MountType.UnsetMount.getValue();
    L15:
        if ((r313 & 131072) == 0) goto L17;
        String r213 = null;
    L19:
        if ((r313 & 262144) == 0) goto L21;
        String r214 = null;
    L23:
        if ((r313 & 524288) == 0) goto L25;
        String r215 = null;
    L26:
        this(r100, r101, 0, 0, 0, 0, r110, null, null, null, null, 0, 0, null, null, null, false, r213, r214, r215);
        return;
    L25:
        r215 = r312;
        goto L26
    L21:
        r214 = r311;
        goto L23
    L17:
        r213 = r310;
        goto L19
    L13:
        r110 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static ShelfInfo a(ShelfInfo r210, ShelfMicroAppInfo r211, List r212, boolean r310, String r311, String r312, String r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        ShelfMicroAppInfo r100 = r210.appInfo;
    L7:
        if ((r314 & 2) == 0) goto L9;
        List r101 = r210.cardInfoList;
    L11:
        if ((r314 & 4) == 0) goto L13;
        long r102 = r210.startId;
    L15:
        if ((r314 & 8) == 0) goto L17;
        long r110 = r210.source;
    L19:
        if ((r314 & 16) == 0) goto L21;
        long r111 = r210.status;
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r103 = r210.punishStatus;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r112 = r210.mountType;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Map<String, String> r113 = r210.startPageQuery;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r114 = r210.imExtra;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r115 = r210.logExtra;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r116 = r210.clientExtra;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        int r117 = r210.coexistRoom;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r213 = r210.coexistKAAnchor;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r214 = r210.coexistLogExtra;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r215 = r210.shelfInfoToken;
    L63:
        if ((32768 & r314) == 0) goto L65;
        String r216 = r210.schema;
    L67:
        if ((65536 & r314) == 0) goto L69;
        boolean r217 = r210.isAutoMount;
    L71:
        if ((131072 & r314) == 0) goto L73;
        String r218 = r210.openExtra;
    L75:
        if ((262144 & r314) == 0) goto L77;
        String r219 = r210.entryPagePath;
    L79:
        if ((r314 & 524288) == 0) goto L81;
        String r104 = r210.mpLiveChannel;
    L82:
        r210.getClass();
        return new ShelfInfo(r100, r101, r102, r110, r111, r103, r112, r113, r114, r115, r116, r117, r213, r214, r215, r216, r217, r218, r219, r104);
    L81:
        r104 = r313;
        goto L82
    L77:
        r219 = r312;
        goto L79
    L73:
        r218 = r311;
        goto L75
    L69:
        r217 = r310;
        goto L71
    L65:
        r216 = null;
        goto L67
    L61:
        r215 = null;
        goto L63
    L57:
        r214 = null;
        goto L59
    L53:
        r213 = 0;
        goto L55
    L49:
        r117 = 0;
        goto L51
    L45:
        r116 = null;
        goto L47
    L41:
        r115 = null;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = null;
        goto L35
    L29:
        r112 = 0;
        goto L31
    L25:
        r103 = 0;
        goto L27
    L21:
        r111 = 0;
        goto L23
    L17:
        r110 = 0;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
