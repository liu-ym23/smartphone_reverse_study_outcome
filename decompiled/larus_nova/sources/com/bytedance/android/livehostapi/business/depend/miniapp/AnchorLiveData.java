package com.bytedance.android.livehostapi.business.depend.miniapp;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u001e\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u001e\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\"\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\fR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\fR\u0013\u0010.\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\fR\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010+R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R \u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010+R \u00109\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010+R \u0010<\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010+R \u0010?\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010+¨\u0006B"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/miniapp/AnchorLiveData;", "", "type", "", "anchorJsonStr", "", "title", "name", "icon", "id", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorJsonStr", "()Ljava/lang/String;", "canModifyMiniappCover", "", "getCanModifyMiniappCover", "()Z", "setCanModifyMiniappCover", "(Z)V", "coverReviewStatus", "Lcom/bytedance/android/livehostapi/business/depend/miniapp/ReviewStatus;", "getCoverReviewStatus", "()Lcom/bytedance/android/livehostapi/business/depend/miniapp/ReviewStatus;", "setCoverReviewStatus", "(Lcom/bytedance/android/livehostapi/business/depend/miniapp/ReviewStatus;)V", "extra", "getExtra", "hadUserChosenCover", "getHadUserChosenCover", "setHadUserChosenCover", "getIcon", "getId", "isIntroducingStamp", "setIntroducingStamp", "isSensitiveTitle", "()Ljava/lang/Boolean;", "setSensitiveTitle", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "oldCoverMiniappImageUri", "getOldCoverMiniappImageUri", "setOldCoverMiniappImageUri", "(Ljava/lang/String;)V", "schema", "getSchema", "snapShotLocalPath", "getSnapShotLocalPath", "stampJson", "Lorg/json/JSONObject;", "getTitle", d.f25925o, "getType", "()I", "uploadedMiniappCoverPath", "getUploadedMiniappCoverPath", "setUploadedMiniappCoverPath", "uploadedMiniappCoverUrl", "getUploadedMiniappCoverUrl", "setUploadedMiniappCoverUrl", "uploadedSnapshotPath", "getUploadedSnapshotPath", "setUploadedSnapshotPath", "uploadedSnapshotUrl", "getUploadedSnapshotUrl", "setUploadedSnapshotUrl", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLiveData {

    @SerializedName("anchorJsonStr")
    private final String anchorJsonStr;

    @SerializedName("canModifyMiniappCover")
    private boolean canModifyMiniappCover;

    @SerializedName("coverReviewStatus")
    private ReviewStatus coverReviewStatus;
    private final String extra;

    @SerializedName("hadUserChosenCover")
    private boolean hadUserChosenCover;

    @SerializedName("icon")
    private final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f102933id;

    @SerializedName("isIntroducingStamp")
    private boolean isIntroducingStamp;

    @SerializedName("isSensitiveTitle")
    private Boolean isSensitiveTitle;

    @SerializedName("name")
    private final String name;

    @SerializedName("oldCoverMiniappImageUri")
    private String oldCoverMiniappImageUri;
    private final String schema;
    private final String snapShotLocalPath;
    private JSONObject stampJson;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private final int type;

    @SerializedName("uploadedMiniappCoverPath")
    private String uploadedMiniappCoverPath;

    @SerializedName("uploadedMiniappCoverUrl")
    private String uploadedMiniappCoverUrl;

    @SerializedName("uploadedSnapshotPath")
    private String uploadedSnapshotPath;

    @SerializedName("uploadedSnapshotUrl")
    private String uploadedSnapshotUrl;

    public AnchorLiveData(int r110) {
        this(r110, null, null, null, null, null, 62, null);
    }

    public AnchorLiveData(int r110, String r111) {
        this(r110, r111, null, null, null, null, 60, null);
    }

    public AnchorLiveData(int r110, String r111, String r112) {
        this(r110, r111, r112, null, null, null, 56, null);
    }

    public AnchorLiveData(int r110, String r111, String r112, String r113) {
        this(r110, r111, r112, r113, null, null, 48, null);
    }

    public AnchorLiveData(int r110, String r111, String r112, String r113, String r114) {
        this(r110, r111, r112, r113, r114, null, 32, null);
    }

    public final String getAnchorJsonStr() {
        return this.anchorJsonStr;
    }

    public final boolean getCanModifyMiniappCover() {
        return this.canModifyMiniappCover;
    }

    public final ReviewStatus getCoverReviewStatus() {
        return this.coverReviewStatus;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final boolean getHadUserChosenCover() {
        return this.hadUserChosenCover;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f102933id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOldCoverMiniappImageUri() {
        return this.oldCoverMiniappImageUri;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSnapShotLocalPath() {
        return this.snapShotLocalPath;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUploadedMiniappCoverPath() {
        return this.uploadedMiniappCoverPath;
    }

    public final String getUploadedMiniappCoverUrl() {
        return this.uploadedMiniappCoverUrl;
    }

    public final String getUploadedSnapshotPath() {
        return this.uploadedSnapshotPath;
    }

    public final String getUploadedSnapshotUrl() {
        return this.uploadedSnapshotUrl;
    }

    public final boolean isIntroducingStamp() {
        return this.isIntroducingStamp;
    }

    public final Boolean isSensitiveTitle() {
        return this.isSensitiveTitle;
    }

    public final void setCanModifyMiniappCover(boolean r100) {
        this.canModifyMiniappCover = r100;
    }

    public final void setCoverReviewStatus(ReviewStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverReviewStatus = r100;
    }

    public final void setHadUserChosenCover(boolean r100) {
        this.hadUserChosenCover = r100;
    }

    public final void setIntroducingStamp(boolean r100) {
        this.isIntroducingStamp = r100;
    }

    public final void setOldCoverMiniappImageUri(String r100) {
        this.oldCoverMiniappImageUri = r100;
    }

    public final void setSensitiveTitle(Boolean r100) {
        this.isSensitiveTitle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUploadedMiniappCoverPath(String r100) {
        this.uploadedMiniappCoverPath = r100;
    }

    public final void setUploadedMiniappCoverUrl(String r100) {
        this.uploadedMiniappCoverUrl = r100;
    }

    public final void setUploadedSnapshotPath(String r100) {
        this.uploadedSnapshotPath = r100;
    }

    public final void setUploadedSnapshotUrl(String r100) {
        this.uploadedSnapshotUrl = r100;
    }

    public AnchorLiveData(int r100, String r101, String r102, String r103, String r104, String r105) {
        this.type = r100;
        this.anchorJsonStr = r101;
        this.title = r102;
        this.name = r103;
        this.icon = r104;
        this.f102933id = r105;
        this.uploadedSnapshotUrl = "";
        this.uploadedSnapshotPath = "";
        this.isSensitiveTitle = Boolean.FALSE;
        this.uploadedMiniappCoverUrl = "";
        this.uploadedMiniappCoverPath = "";
        this.canModifyMiniappCover = true;
        this.oldCoverMiniappImageUri = "";
        this.coverReviewStatus = ReviewStatus.REVIEW_PASS;
        JSONObject r106 = new JSONObject(r101);
        this.stampJson = r106;
        this.snapShotLocalPath = r106.optString("snapShotUrl");
        JSONObject r107 = this.stampJson;
        String r108 = null;
        if (r107 == null) goto L5;
        String r109 = r107.optString("schema");
    L6:
        this.schema = r109;
        JSONObject r110 = this.stampJson;
        if (r110 == null) goto L9;
        r108 = r110.optString("extra");
    L9:
        this.extra = r108;
        return;
    L5:
        r109 = null;
        goto L6
    }

    public /* synthetic */ AnchorLiveData(int r100, String r101, String r102, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        String r103 = "";
        if ((r113 & 2) == 0) goto L5;
        String r104 = "";
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r113 & 8) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r113 & 16) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r113 & 32) != 0) goto L22;
        r103 = r112;
    L22:
        this(r100, r104, r105, r106, r107, r103);
        return;
    L17:
        r107 = r111;
        goto L19
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r102;
        goto L11
    L5:
        r104 = r101;
        goto L7
    }
}
