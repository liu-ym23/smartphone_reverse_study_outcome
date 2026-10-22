package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J@\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003J\u0095\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u0007HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0014¨\u0006L"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppDetailGiftEntity;", "Landroid/os/Parcelable;", ServerElements.CONTENT, "", "endTime", "id", "ifReceived", "", ServerElements.GAME_GIFT_INSTUCTION, "name", "pkgId", "restCount", "startTime", "status", "storeId", "totalNum", "updateTime", ServerElements.CODE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getContent", "getEndTime", "getId", "getIfReceived", "()I", "setIfReceived", "(I)V", "getInstruction", "getName", "getPkgId", "getRestCount", "setRestCount", "getStartTime", "getStatus", "getStoreId", "getTotalNum", "getUpdateTime", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertGiftMyEntity", "Lcom/bytedanceos/appstore/buss/entity/GiftMyEntity;", "appName", "packageName", ServerElements.LOGO, "appDownloadUrl", "fileMd5", "fileSize", "versionCode", "copy", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppDetailGiftEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AppDetailGiftEntity> CREATOR = null;

    @NotNull
    private String code;

    @NotNull
    private final String content;

    @SerializedName("end_time")
    @NotNull
    private final String endTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8426id;

    @SerializedName(ServerElements.GAME_GIFT_RECEIVED)
    private int ifReceived;

    @NotNull
    private final String instruction;

    @NotNull
    private final String name;

    @SerializedName("pkg_id")
    @NotNull
    private final String pkgId;

    @SerializedName(ServerElements.GAME_GIFT_PACK_COUNT)
    @NotNull
    private String restCount;

    @SerializedName("start_time")
    @NotNull
    private final String startTime;

    @NotNull
    private final String status;

    @SerializedName("store_id")
    @NotNull
    private final String storeId;

    @SerializedName("total_num")
    @NotNull
    private final String totalNum;

    @SerializedName(ServerElements.UPDATE_TIME)
    @NotNull
    private final String updateTime;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AppDetailGiftEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppDetailGiftEntity createFromParcel(@NotNull Parcel r17) {
            q.g(r17, "parcel");
            return new AppDetailGiftEntity(r17.readString(), r17.readString(), r17.readString(), r17.readInt(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppDetailGiftEntity[] newArray(int r10) {
            return new AppDetailGiftEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppDetailGiftEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppDetailGiftEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public AppDetailGiftEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, int r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17, @NotNull String r18, @NotNull String r19, @NotNull String r110, @NotNull String r111, @NotNull String r112, @NotNull String r113) {
        q.g(r10, ServerElements.CONTENT);
        q.g(r11, "endTime");
        q.g(r12, "id");
        q.g(r14, ServerElements.GAME_GIFT_INSTUCTION);
        q.g(r15, "name");
        q.g(r16, "pkgId");
        q.g(r17, "restCount");
        q.g(r18, "startTime");
        q.g(r19, "status");
        q.g(r110, "storeId");
        q.g(r111, "totalNum");
        q.g(r112, "updateTime");
        q.g(r113, ServerElements.CODE);
        this.content = r10;
        this.endTime = r11;
        this.f8426id = r12;
        this.ifReceived = r13;
        this.instruction = r14;
        this.name = r15;
        this.pkgId = r16;
        this.restCount = r17;
        this.startTime = r18;
        this.status = r19;
        this.storeId = r110;
        this.totalNum = r111;
        this.updateTime = r112;
        this.code = r113;
    }

    public static /* synthetic */ AppDetailGiftEntity copy$default(AppDetailGiftEntity r15, String r16, String r17, String r18, int r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r10 = r15.content;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r11 = r15.endTime;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r12 = r15.f8426id;
    L15:
        if ((r30 & 8) == 0) goto L17;
        int r13 = r15.ifReceived;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r14 = r15.instruction;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r32 = r15.name;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r33 = r15.pkgId;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r34 = r15.restCount;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r110 = r15.startTime;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r111 = r15.status;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r112 = r15.storeId;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r113 = r15.totalNum;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r114 = r15.updateTime;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r35 = r15.code;
    L59:
        return r15.copy(r10, r11, r12, r13, r14, r32, r33, r34, r110, r111, r112, r113, r114, r35);
    L57:
        r35 = r29;
        goto L59
    L53:
        r114 = r28;
        goto L55
    L49:
        r113 = r27;
        goto L51
    L45:
        r112 = r26;
        goto L47
    L41:
        r111 = r25;
        goto L43
    L37:
        r110 = r24;
        goto L39
    L33:
        r34 = r23;
        goto L35
    L29:
        r33 = r22;
        goto L31
    L25:
        r32 = r21;
        goto L27
    L21:
        r14 = r20;
        goto L23
    L17:
        r13 = r19;
        goto L19
    L13:
        r12 = r18;
        goto L15
    L9:
        r11 = r17;
        goto L11
    L5:
        r10 = r16;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    @NotNull
    public final String component10() {
        return this.status;
    }

    @NotNull
    public final String component11() {
        return this.storeId;
    }

    @NotNull
    public final String component12() {
        return this.totalNum;
    }

    @NotNull
    public final String component13() {
        return this.updateTime;
    }

    @NotNull
    public final String component14() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.endTime;
    }

    @NotNull
    public final String component3() {
        return this.f8426id;
    }

    public final int component4() {
        return this.ifReceived;
    }

    @NotNull
    public final String component5() {
        return this.instruction;
    }

    @NotNull
    public final String component6() {
        return this.name;
    }

    @NotNull
    public final String component7() {
        return this.pkgId;
    }

    @NotNull
    public final String component8() {
        return this.restCount;
    }

    @NotNull
    public final String component9() {
        return this.startTime;
    }

    @NotNull
    public final GiftMyEntity convertGiftMyEntity(@NotNull String r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, @Nullable String r22, @NotNull String r23, @NotNull String r24) {
        q.g(r18, "appName");
        q.g(r19, "packageName");
        q.g(r20, ServerElements.LOGO);
        q.g(r21, "appDownloadUrl");
        q.g(r23, "fileSize");
        q.g(r24, "versionCode");
        if (TextUtils.isEmpty(this.code) == false) goto L5;
        String r12 = r24;
    L7:
        return new GiftMyEntity(this.f8426id, this.name, r18, r19, this.startTime, this.endTime, this.content, this.instruction, r20, r12, r21, r22, this.restCount, r23);
    L5:
        r12 = this.code;
        goto L7
    }

    @NotNull
    public final AppDetailGiftEntity copy(@NotNull String r17, @NotNull String r18, @NotNull String r19, int r20, @NotNull String r21, @NotNull String r22, @NotNull String r23, @NotNull String r24, @NotNull String r25, @NotNull String r26, @NotNull String r27, @NotNull String r28, @NotNull String r29, @NotNull String r30) {
        q.g(r17, ServerElements.CONTENT);
        q.g(r18, "endTime");
        q.g(r19, "id");
        q.g(r21, ServerElements.GAME_GIFT_INSTUCTION);
        q.g(r22, "name");
        q.g(r23, "pkgId");
        q.g(r24, "restCount");
        q.g(r25, "startTime");
        q.g(r26, "status");
        q.g(r27, "storeId");
        q.g(r28, "totalNum");
        q.g(r29, "updateTime");
        q.g(r30, ServerElements.CODE);
        return new AppDetailGiftEntity(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppDetailGiftEntity) == true) goto L8;
        return false;
    L8:
        AppDetailGiftEntity r11 = (AppDetailGiftEntity) r10;
        if (q.b(this.content, r11.content) == true) goto L12;
        return false;
    L12:
        if (q.b(this.endTime, r11.endTime) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f8426id, r11.f8426id) == true) goto L18;
        return false;
    L18:
        if (this.ifReceived == r11.ifReceived) goto L21;
        return false;
    L21:
        if (q.b(this.instruction, r11.instruction) == true) goto L24;
        return false;
    L24:
        if (q.b(this.name, r11.name) == true) goto L27;
        return false;
    L27:
        if (q.b(this.pkgId, r11.pkgId) == true) goto L30;
        return false;
    L30:
        if (q.b(this.restCount, r11.restCount) == true) goto L33;
        return false;
    L33:
        if (q.b(this.startTime, r11.startTime) == true) goto L36;
        return false;
    L36:
        if (q.b(this.status, r11.status) == true) goto L39;
        return false;
    L39:
        if (q.b(this.storeId, r11.storeId) == true) goto L42;
        return false;
    L42:
        if (q.b(this.totalNum, r11.totalNum) == true) goto L45;
        return false;
    L45:
        if (q.b(this.updateTime, r11.updateTime) == true) goto L48;
        return false;
    L48:
        if (q.b(this.code, r11.code) == true) goto L50;
        return false;
    L50:
        return true;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getId() {
        return this.f8426id;
    }

    public final int getIfReceived() {
        return this.ifReceived;
    }

    @NotNull
    public final String getInstruction() {
        return this.instruction;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPkgId() {
        return this.pkgId;
    }

    @NotNull
    public final String getRestCount() {
        return this.restCount;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getStoreId() {
        return this.storeId;
    }

    @NotNull
    public final String getTotalNum() {
        return this.totalNum;
    }

    @NotNull
    public final String getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.content.hashCode() * 31) + this.endTime.hashCode()) * 31) + this.f8426id.hashCode()) * 31) + Integer.hashCode(this.ifReceived)) * 31) + this.instruction.hashCode()) * 31) + this.name.hashCode()) * 31) + this.pkgId.hashCode()) * 31) + this.restCount.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.status.hashCode()) * 31) + this.storeId.hashCode()) * 31) + this.totalNum.hashCode()) * 31) + this.updateTime.hashCode()) * 31) + this.code.hashCode();
    }

    public final void setCode(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.code = r10;
    }

    public final void setIfReceived(int r10) {
        this.ifReceived = r10;
    }

    public final void setRestCount(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.restCount = r10;
    }

    @NotNull
    public String toString() {
        return "AppDetailGiftEntity(content=" + this.content + ", endTime=" + this.endTime + ", id=" + this.f8426id + ", ifReceived=" + this.ifReceived + ", instruction=" + this.instruction + ", name=" + this.name + ", pkgId=" + this.pkgId + ", restCount=" + this.restCount + ", startTime=" + this.startTime + ", status=" + this.status + ", storeId=" + this.storeId + ", totalNum=" + this.totalNum + ", updateTime=" + this.updateTime + ", code=" + this.code + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeString(this.content);
        r10.writeString(this.endTime);
        r10.writeString(this.f8426id);
        r10.writeInt(this.ifReceived);
        r10.writeString(this.instruction);
        r10.writeString(this.name);
        r10.writeString(this.pkgId);
        r10.writeString(this.restCount);
        r10.writeString(this.startTime);
        r10.writeString(this.status);
        r10.writeString(this.storeId);
        r10.writeString(this.totalNum);
        r10.writeString(this.updateTime);
        r10.writeString(this.code);
    }
}
