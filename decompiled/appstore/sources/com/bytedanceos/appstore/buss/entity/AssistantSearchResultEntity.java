package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010d\u001a\u000208HÖ\u0001J\u0019\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u000208HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001c\u0010@\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR \u0010C\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001c\u0010F\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001c\u0010I\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001c\u0010U\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001c\u0010X\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001c\u0010[\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001c\u0010^\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\b¨\u0006j"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AssistantSearchResultEntity;", "Landroid/os/Parcelable;", "()V", "apk_file", "", "getApk_file", "()Ljava/lang/String;", "setApk_file", "(Ljava/lang/String;)V", "category", "getCategory", "setCategory", "channel", "getChannel", "setChannel", "cid_1", "getCid_1", "setCid_1", "cid_2", "getCid_2", "setCid_2", ServerElements.DEVELOPER, "getDeveloper", "setDeveloper", ServerElements.DEVER_ID, "getDever_id", "setDever_id", ServerElements.DIFF_APK, "getDiff_apk", "setDiff_apk", ServerElements.DM_URL, "getDm_url", "setDm_url", ServerElements.DOWNLOAD_URL, "getDownload_url", "setDownload_url", ServerElements.FILE_MD5, "getFilemd5", "setFilemd5", ServerElements.FILESIZE, "getFilesize", "setFilesize", "game_type", "getGame_type", "setGame_type", "grade_desc", "getGrade_desc", "setGrade_desc", "id", "getId", "setId", ServerElements.IFGMS, "getIfgms", "setIfgms", ServerElements.LABEL, "", "", "getLabel", "()Ljava/util/List;", "setLabel", "(Ljava/util/List;)V", ServerElements.LOGO, "getLogo", "setLogo", "name", "getName", "setName", AppPermissionActivity.EXTRA_APP_PKG, "getPkg", "setPkg", ServerElements.RECMD_BRIEF, "getRecmd_brief", "setRecmd_brief", ServerElements.SCORES, "getScores", "setScores", "soft_type", "getSoft_type", "setSoft_type", "source", "getSource", "setSource", "status", "getStatus", "setStatus", TraceStatsConsts.STATS_KEY_TRACE, "getTrace", "setTrace", "version", "getVersion", "setVersion", "version_code", "getVersion_code", "setVersion_code", ServerElements.VIDEO_IMG, "getVideo_img", "setVideo_img", ServerElements.VIDEO_PATH, "getVideo_url", "setVideo_url", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AssistantSearchResultEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AssistantSearchResultEntity> CREATOR = null;

    @Nullable
    private String apk_file;

    @Nullable
    private String category;

    @Nullable
    private String channel;

    @Nullable
    private String cid_1;

    @Nullable
    private String cid_2;

    @Nullable
    private String developer;

    @Nullable
    private String dever_id;

    @Nullable
    private String diff_apk;

    @Nullable
    private String dm_url;

    @Nullable
    private String download_url;

    @Nullable
    private String filemd5;

    @Nullable
    private String filesize;

    @Nullable
    private String game_type;

    @Nullable
    private String grade_desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Nullable
    private String f8429id;

    @Nullable
    private String ifgms;

    @Nullable
    private List<Integer> label;

    @Nullable
    private String logo;

    @Nullable
    private String name;

    @SerializedName("package")
    @Nullable
    private String pkg;

    @Nullable
    private String recmd_brief;

    @Nullable
    private String scores;

    @Nullable
    private String soft_type;

    @Nullable
    private String source;

    @Nullable
    private String status;

    @Nullable
    private String trace;

    @Nullable
    private String version;

    @Nullable
    private String version_code;

    @Nullable
    private String video_img;

    @Nullable
    private String video_url;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AssistantSearchResultEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AssistantSearchResultEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            r10.readInt();
            return new AssistantSearchResultEntity();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AssistantSearchResultEntity[] newArray(int r10) {
            return new AssistantSearchResultEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AssistantSearchResultEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AssistantSearchResultEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public AssistantSearchResultEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getApk_file() {
        return this.apk_file;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getChannel() {
        return this.channel;
    }

    @Nullable
    public final String getCid_1() {
        return this.cid_1;
    }

    @Nullable
    public final String getCid_2() {
        return this.cid_2;
    }

    @Nullable
    public final String getDeveloper() {
        return this.developer;
    }

    @Nullable
    public final String getDever_id() {
        return this.dever_id;
    }

    @Nullable
    public final String getDiff_apk() {
        return this.diff_apk;
    }

    @Nullable
    public final String getDm_url() {
        return this.dm_url;
    }

    @Nullable
    public final String getDownload_url() {
        return this.download_url;
    }

    @Nullable
    public final String getFilemd5() {
        return this.filemd5;
    }

    @Nullable
    public final String getFilesize() {
        return this.filesize;
    }

    @Nullable
    public final String getGame_type() {
        return this.game_type;
    }

    @Nullable
    public final String getGrade_desc() {
        return this.grade_desc;
    }

    @Nullable
    public final String getId() {
        return this.f8429id;
    }

    @Nullable
    public final String getIfgms() {
        return this.ifgms;
    }

    @Nullable
    public final List<Integer> getLabel() {
        return this.label;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPkg() {
        return this.pkg;
    }

    @Nullable
    public final String getRecmd_brief() {
        return this.recmd_brief;
    }

    @Nullable
    public final String getScores() {
        return this.scores;
    }

    @Nullable
    public final String getSoft_type() {
        return this.soft_type;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTrace() {
        return this.trace;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    public final String getVersion_code() {
        return this.version_code;
    }

    @Nullable
    public final String getVideo_img() {
        return this.video_img;
    }

    @Nullable
    public final String getVideo_url() {
        return this.video_url;
    }

    public final void setApk_file(@Nullable String r10) {
        this.apk_file = r10;
    }

    public final void setCategory(@Nullable String r10) {
        this.category = r10;
    }

    public final void setChannel(@Nullable String r10) {
        this.channel = r10;
    }

    public final void setCid_1(@Nullable String r10) {
        this.cid_1 = r10;
    }

    public final void setCid_2(@Nullable String r10) {
        this.cid_2 = r10;
    }

    public final void setDeveloper(@Nullable String r10) {
        this.developer = r10;
    }

    public final void setDever_id(@Nullable String r10) {
        this.dever_id = r10;
    }

    public final void setDiff_apk(@Nullable String r10) {
        this.diff_apk = r10;
    }

    public final void setDm_url(@Nullable String r10) {
        this.dm_url = r10;
    }

    public final void setDownload_url(@Nullable String r10) {
        this.download_url = r10;
    }

    public final void setFilemd5(@Nullable String r10) {
        this.filemd5 = r10;
    }

    public final void setFilesize(@Nullable String r10) {
        this.filesize = r10;
    }

    public final void setGame_type(@Nullable String r10) {
        this.game_type = r10;
    }

    public final void setGrade_desc(@Nullable String r10) {
        this.grade_desc = r10;
    }

    public final void setId(@Nullable String r10) {
        this.f8429id = r10;
    }

    public final void setIfgms(@Nullable String r10) {
        this.ifgms = r10;
    }

    public final void setLabel(@Nullable List<Integer> r10) {
        this.label = r10;
    }

    public final void setLogo(@Nullable String r10) {
        this.logo = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setPkg(@Nullable String r10) {
        this.pkg = r10;
    }

    public final void setRecmd_brief(@Nullable String r10) {
        this.recmd_brief = r10;
    }

    public final void setScores(@Nullable String r10) {
        this.scores = r10;
    }

    public final void setSoft_type(@Nullable String r10) {
        this.soft_type = r10;
    }

    public final void setSource(@Nullable String r10) {
        this.source = r10;
    }

    public final void setStatus(@Nullable String r10) {
        this.status = r10;
    }

    public final void setTrace(@Nullable String r10) {
        this.trace = r10;
    }

    public final void setVersion(@Nullable String r10) {
        this.version = r10;
    }

    public final void setVersion_code(@Nullable String r10) {
        this.version_code = r10;
    }

    public final void setVideo_img(@Nullable String r10) {
        this.video_img = r10;
    }

    public final void setVideo_url(@Nullable String r10) {
        this.video_url = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeInt(1);
    }
}
