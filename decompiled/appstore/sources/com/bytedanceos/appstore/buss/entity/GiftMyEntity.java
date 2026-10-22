package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0006\u0010/\u001a\u000200J\u0097\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00068"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/GiftMyEntity;", "", "id", "", "name", "appName", "packageName", "startTime", "endTime", ServerElements.CONTENT, ServerElements.GAME_GIFT_INSTUCTION, ServerElements.LOGO, ServerElements.CODE, "appDownloadUrl", ServerElements.FILE_MD5, "restCount", "fileSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppDownloadUrl", "()Ljava/lang/String;", "getAppName", "getCode", "getContent", "getEndTime", "getFileSize", "getFilemd5", "getId", "getInstruction", "getLogo", "getName", "getPackageName", "getRestCount", "getStartTime", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertAppInfo", "Lcom/bytedanceos/common/model/AppInfo;", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GiftMyEntity {

    @SerializedName("app_download_url")
    @NotNull
    private final String appDownloadUrl;

    @SerializedName("app_name")
    @NotNull
    private final String appName;

    @NotNull
    private final String code;

    @NotNull
    private final String content;

    @SerializedName("end_time")
    @NotNull
    private final String endTime;

    @SerializedName(ServerElements.FILESIZE)
    @NotNull
    private final String fileSize;

    @Nullable
    private final String filemd5;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8432id;

    @NotNull
    private final String instruction;

    @NotNull
    private final String logo;

    @NotNull
    private final String name;

    @SerializedName("package")
    @NotNull
    private final String packageName;

    @SerializedName(ServerElements.GAME_GIFT_PACK_COUNT)
    @NotNull
    private final String restCount;

    @SerializedName("start_time")
    @NotNull
    private final String startTime;

    public GiftMyEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17, @NotNull String r18, @NotNull String r19, @NotNull String r110, @Nullable String r111, @NotNull String r112, @NotNull String r113) {
        q.g(r10, "id");
        q.g(r11, "name");
        q.g(r12, "appName");
        q.g(r13, "packageName");
        q.g(r14, "startTime");
        q.g(r15, "endTime");
        q.g(r16, ServerElements.CONTENT);
        q.g(r17, ServerElements.GAME_GIFT_INSTUCTION);
        q.g(r18, ServerElements.LOGO);
        q.g(r19, ServerElements.CODE);
        q.g(r110, "appDownloadUrl");
        q.g(r112, "restCount");
        q.g(r113, "fileSize");
        this.f8432id = r10;
        this.name = r11;
        this.appName = r12;
        this.packageName = r13;
        this.startTime = r14;
        this.endTime = r15;
        this.content = r16;
        this.instruction = r17;
        this.logo = r18;
        this.code = r19;
        this.appDownloadUrl = r110;
        this.filemd5 = r111;
        this.restCount = r112;
        this.fileSize = r113;
    }

    public static /* synthetic */ GiftMyEntity copy$default(GiftMyEntity r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r10 = r15.f8432id;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r11 = r15.name;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r12 = r15.appName;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r13 = r15.packageName;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r14 = r15.startTime;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r32 = r15.endTime;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r33 = r15.content;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r34 = r15.instruction;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r110 = r15.logo;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r111 = r15.code;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r112 = r15.appDownloadUrl;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r113 = r15.filemd5;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r114 = r15.restCount;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r35 = r15.fileSize;
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
        return this.f8432id;
    }

    @NotNull
    public final String component10() {
        return this.code;
    }

    @NotNull
    public final String component11() {
        return this.appDownloadUrl;
    }

    @Nullable
    public final String component12() {
        return this.filemd5;
    }

    @NotNull
    public final String component13() {
        return this.restCount;
    }

    @NotNull
    public final String component14() {
        return this.fileSize;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.appName;
    }

    @NotNull
    public final String component4() {
        return this.packageName;
    }

    @NotNull
    public final String component5() {
        return this.startTime;
    }

    @NotNull
    public final String component6() {
        return this.endTime;
    }

    @NotNull
    public final String component7() {
        return this.content;
    }

    @NotNull
    public final String component8() {
        return this.instruction;
    }

    @NotNull
    public final String component9() {
        return this.logo;
    }

    @NotNull
    public final AppInfo convertAppInfo() {
        CommonAppEntity r10 = new CommonAppEntity();
        r10.setId(this.f8432id);
        r10.setName(this.appName);
        r10.setPkg(this.packageName);
        r10.setLogo(this.logo);
        r10.setFilesize(Long.parseLong(this.fileSize));
        r10.setDownload_url(this.appDownloadUrl);
        r10.setFilemd5(this.filemd5);
        AppInfo r11 = r10.convertAppInfo();
        q.f(r11, "convertAppInfo(...)");
        return r11;
    }

    @NotNull
    public final GiftMyEntity copy(@NotNull String r17, @NotNull String r18, @NotNull String r19, @NotNull String r20, @NotNull String r21, @NotNull String r22, @NotNull String r23, @NotNull String r24, @NotNull String r25, @NotNull String r26, @NotNull String r27, @Nullable String r28, @NotNull String r29, @NotNull String r30) {
        q.g(r17, "id");
        q.g(r18, "name");
        q.g(r19, "appName");
        q.g(r20, "packageName");
        q.g(r21, "startTime");
        q.g(r22, "endTime");
        q.g(r23, ServerElements.CONTENT);
        q.g(r24, ServerElements.GAME_GIFT_INSTUCTION);
        q.g(r25, ServerElements.LOGO);
        q.g(r26, ServerElements.CODE);
        q.g(r27, "appDownloadUrl");
        q.g(r29, "restCount");
        q.g(r30, "fileSize");
        return new GiftMyEntity(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GiftMyEntity) == true) goto L8;
        return false;
    L8:
        GiftMyEntity r11 = (GiftMyEntity) r10;
        if (q.b(this.f8432id, r11.f8432id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.appName, r11.appName) == true) goto L18;
        return false;
    L18:
        if (q.b(this.packageName, r11.packageName) == true) goto L21;
        return false;
    L21:
        if (q.b(this.startTime, r11.startTime) == true) goto L24;
        return false;
    L24:
        if (q.b(this.endTime, r11.endTime) == true) goto L27;
        return false;
    L27:
        if (q.b(this.content, r11.content) == true) goto L30;
        return false;
    L30:
        if (q.b(this.instruction, r11.instruction) == true) goto L33;
        return false;
    L33:
        if (q.b(this.logo, r11.logo) == true) goto L36;
        return false;
    L36:
        if (q.b(this.code, r11.code) == true) goto L39;
        return false;
    L39:
        if (q.b(this.appDownloadUrl, r11.appDownloadUrl) == true) goto L42;
        return false;
    L42:
        if (q.b(this.filemd5, r11.filemd5) == true) goto L45;
        return false;
    L45:
        if (q.b(this.restCount, r11.restCount) == true) goto L48;
        return false;
    L48:
        if (q.b(this.fileSize, r11.fileSize) == true) goto L50;
        return false;
    L50:
        return true;
    }

    @NotNull
    public final String getAppDownloadUrl() {
        return this.appDownloadUrl;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
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
    public final String getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public final String getFilemd5() {
        return this.filemd5;
    }

    @NotNull
    public final String getId() {
        return this.f8432id;
    }

    @NotNull
    public final String getInstruction() {
        return this.instruction;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getRestCount() {
        return this.restCount;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int r10 = ((((((((((((((((((((this.f8432id.hashCode() * 31) + this.name.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.content.hashCode()) * 31) + this.instruction.hashCode()) * 31) + this.logo.hashCode()) * 31) + this.code.hashCode()) * 31) + this.appDownloadUrl.hashCode()) * 31;
        String r11 = this.filemd5;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return ((((r10 + r12) * 31) + this.restCount.hashCode()) * 31) + this.fileSize.hashCode();
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    @NotNull
    public String toString() {
        return "GiftMyEntity(id=" + this.f8432id + ", name=" + this.name + ", appName=" + this.appName + ", packageName=" + this.packageName + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", content=" + this.content + ", instruction=" + this.instruction + ", logo=" + this.logo + ", code=" + this.code + ", appDownloadUrl=" + this.appDownloadUrl + ", filemd5=" + this.filemd5 + ", restCount=" + this.restCount + ", fileSize=" + this.fileSize + ')';
    }

    public /* synthetic */ GiftMyEntity(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 2048) == 0) goto L5;
        String r13 = "";
    L6:
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r13, r29, r30);
        return;
    L5:
        r13 = r28;
        goto L6
    }
}
