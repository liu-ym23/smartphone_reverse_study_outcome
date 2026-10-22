package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010A\u001a\u00020\rHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0017HÆ\u0003J\t\u0010I\u001a\u00020\rHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010K\u001a\u00020\rHÆ\u0003J\t\u0010L\u001a\u00020\rHÆ\u0003Jë\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\rHÆ\u0001J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\rHÖ\u0001J\t\u0010R\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0018\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u001b\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0016\u0010\u001c\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*¨\u0006S"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetailDto;", "", "id", "", "name", "", "packageName", "publisher", "categoryName", "description", "recommendDesc", "versionName", "versionCode", "", "versionTime", ContentDisposition.Parameters.Size, "icon", "images", "", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionImageDto;", "downloadCount", "evaluateCount", "avgScore", "", "star", "qualityLabel", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionQualityLabelDto;", "icpStatus", "status", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;Ljava/util/List;JJDILcom/stepos/ailauncher/foundation/appstore/api/AppVersionQualityLabelDto;II)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getPackageName", "getPublisher", "getCategoryName", "getDescription", "getRecommendDesc", "getVersionName", "getVersionCode", "()I", "getVersionTime", "getSize", "getIcon", "getImages", "()Ljava/util/List;", "getDownloadCount", "getEvaluateCount", "getAvgScore", "()D", "getStar", "getQualityLabel", "()Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionQualityLabelDto;", "getIcpStatus", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionDetailDto {

    @SerializedName("avg_score")
    private final double avgScore;

    @SerializedName("category_name")
    private final String categoryName;

    @SerializedName("description")
    private final String description;

    @SerializedName("download_count")
    private final long downloadCount;

    @SerializedName("evaluate_count")
    private final long evaluateCount;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icp_status")
    private final int icpStatus;

    @SerializedName("id")
    private final long id;

    @SerializedName("images")
    private final List<AppVersionImageDto> images;

    @SerializedName("name")
    private final String name;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("publisher")
    private final String publisher;

    @SerializedName("quality_label")
    private final AppVersionQualityLabelDto qualityLabel;

    @SerializedName("recommend_desc")
    private final String recommendDesc;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final long size;

    @SerializedName("star")
    private final int star;

    @SerializedName("status")
    private final int status;

    @SerializedName("version_code")
    private final int versionCode;

    @SerializedName("version_name")
    private final String versionName;

    @SerializedName("version_time")
    private final long versionTime;

    public AppVersionDetailDto() {
        this(0L, null, null, null, null, null, null, null, 0, 0L, 0L, null, null, 0L, 0L, 0.0d, 0, null, 0, 0, 1048575, null);
    }

    public static /* synthetic */ AppVersionDetailDto copy$default(AppVersionDetailDto appVersionDetailDto, long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, long j11, long j12, String str8, List list, long j13, long j14, double d10, int i11, AppVersionQualityLabelDto appVersionQualityLabelDto, int i12, int i13, int i14, Object obj) {
        int i15;
        AppVersionQualityLabelDto appVersionQualityLabelDto2;
        long j15 = (i14 & 1) != 0 ? appVersionDetailDto.id : j10;
        String str9 = (i14 & 2) != 0 ? appVersionDetailDto.name : str;
        String str10 = (i14 & 4) != 0 ? appVersionDetailDto.packageName : str2;
        String str11 = (i14 & 8) != 0 ? appVersionDetailDto.publisher : str3;
        String str12 = (i14 & 16) != 0 ? appVersionDetailDto.categoryName : str4;
        String str13 = (i14 & 32) != 0 ? appVersionDetailDto.description : str5;
        String str14 = (i14 & 64) != 0 ? appVersionDetailDto.recommendDesc : str6;
        String str15 = (i14 & 128) != 0 ? appVersionDetailDto.versionName : str7;
        int i16 = (i14 & 256) != 0 ? appVersionDetailDto.versionCode : i10;
        long j16 = (i14 & 512) != 0 ? appVersionDetailDto.versionTime : j11;
        long j17 = (i14 & 1024) != 0 ? appVersionDetailDto.size : j12;
        long j18 = j15;
        String str16 = (i14 & 2048) != 0 ? appVersionDetailDto.icon : str8;
        List list2 = (i14 & 4096) != 0 ? appVersionDetailDto.images : list;
        long j19 = (i14 & b.THRESHOLD) != 0 ? appVersionDetailDto.downloadCount : j13;
        long j20 = (i14 & 16384) != 0 ? appVersionDetailDto.evaluateCount : j14;
        double d11 = (i14 & 32768) != 0 ? appVersionDetailDto.avgScore : d10;
        int i17 = (i14 & 65536) != 0 ? appVersionDetailDto.star : i11;
        double d12 = d11;
        AppVersionQualityLabelDto appVersionQualityLabelDto3 = (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? appVersionDetailDto.qualityLabel : appVersionQualityLabelDto;
        int i18 = (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? appVersionDetailDto.icpStatus : i12;
        if ((i14 & 524288) != 0) {
            appVersionQualityLabelDto2 = appVersionQualityLabelDto3;
            i15 = appVersionDetailDto.status;
        } else {
            i15 = i13;
            appVersionQualityLabelDto2 = appVersionQualityLabelDto3;
        }
        return appVersionDetailDto.copy(j18, str9, str10, str11, str12, str13, str14, str15, i16, j16, j17, str16, list2, j19, j20, d12, i17, appVersionQualityLabelDto2, i18, i15);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final long getVersionTime() {
        return this.versionTime;
    }

    /* renamed from: component11, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component12, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final List<AppVersionImageDto> component13() {
        return this.images;
    }

    /* renamed from: component14, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component15, reason: from getter */
    public final long getEvaluateCount() {
        return this.evaluateCount;
    }

    /* renamed from: component16, reason: from getter */
    public final double getAvgScore() {
        return this.avgScore;
    }

    /* renamed from: component17, reason: from getter */
    public final int getStar() {
        return this.star;
    }

    /* renamed from: component18, reason: from getter */
    public final AppVersionQualityLabelDto getQualityLabel() {
        return this.qualityLabel;
    }

    /* renamed from: component19, reason: from getter */
    public final int getIcpStatus() {
        return this.icpStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component20, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPublisher() {
        return this.publisher;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRecommendDesc() {
        return this.recommendDesc;
    }

    /* renamed from: component8, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component9, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    public final AppVersionDetailDto copy(long id, String name, String packageName, String publisher, String categoryName, String description, String recommendDesc, String versionName, int versionCode, long versionTime, long size, String icon, List<AppVersionImageDto> images, long downloadCount, long evaluateCount, double avgScore, int star, AppVersionQualityLabelDto qualityLabel, int icpStatus, int status) {
        return new AppVersionDetailDto(id, name, packageName, publisher, categoryName, description, recommendDesc, versionName, versionCode, versionTime, size, icon, images, downloadCount, evaluateCount, avgScore, star, qualityLabel, icpStatus, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionDetailDto)) {
            return false;
        }
        AppVersionDetailDto appVersionDetailDto = (AppVersionDetailDto) other;
        return this.id == appVersionDetailDto.id && p.d(this.name, appVersionDetailDto.name) && p.d(this.packageName, appVersionDetailDto.packageName) && p.d(this.publisher, appVersionDetailDto.publisher) && p.d(this.categoryName, appVersionDetailDto.categoryName) && p.d(this.description, appVersionDetailDto.description) && p.d(this.recommendDesc, appVersionDetailDto.recommendDesc) && p.d(this.versionName, appVersionDetailDto.versionName) && this.versionCode == appVersionDetailDto.versionCode && this.versionTime == appVersionDetailDto.versionTime && this.size == appVersionDetailDto.size && p.d(this.icon, appVersionDetailDto.icon) && p.d(this.images, appVersionDetailDto.images) && this.downloadCount == appVersionDetailDto.downloadCount && this.evaluateCount == appVersionDetailDto.evaluateCount && Double.compare(this.avgScore, appVersionDetailDto.avgScore) == 0 && this.star == appVersionDetailDto.star && p.d(this.qualityLabel, appVersionDetailDto.qualityLabel) && this.icpStatus == appVersionDetailDto.icpStatus && this.status == appVersionDetailDto.status;
    }

    public final double getAvgScore() {
        return this.avgScore;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final long getEvaluateCount() {
        return this.evaluateCount;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getIcpStatus() {
        return this.icpStatus;
    }

    public final long getId() {
        return this.id;
    }

    public final List<AppVersionImageDto> getImages() {
        return this.images;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPublisher() {
        return this.publisher;
    }

    public final AppVersionQualityLabelDto getQualityLabel() {
        return this.qualityLabel;
    }

    public final String getRecommendDesc() {
        return this.recommendDesc;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getStar() {
        return this.star;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final long getVersionTime() {
        return this.versionTime;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.publisher;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.categoryName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.recommendDesc;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.versionName;
        int iHashCode8 = (((((((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.versionCode)) * 31) + Long.hashCode(this.versionTime)) * 31) + Long.hashCode(this.size)) * 31;
        String str8 = this.icon;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<AppVersionImageDto> list = this.images;
        int iHashCode10 = (((((((((iHashCode9 + (list == null ? 0 : list.hashCode())) * 31) + Long.hashCode(this.downloadCount)) * 31) + Long.hashCode(this.evaluateCount)) * 31) + Double.hashCode(this.avgScore)) * 31) + Integer.hashCode(this.star)) * 31;
        AppVersionQualityLabelDto appVersionQualityLabelDto = this.qualityLabel;
        return ((((iHashCode10 + (appVersionQualityLabelDto != null ? appVersionQualityLabelDto.hashCode() : 0)) * 31) + Integer.hashCode(this.icpStatus)) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        return "AppVersionDetailDto(id=" + this.id + ", name=" + this.name + ", packageName=" + this.packageName + ", publisher=" + this.publisher + ", categoryName=" + this.categoryName + ", description=" + this.description + ", recommendDesc=" + this.recommendDesc + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", versionTime=" + this.versionTime + ", size=" + this.size + ", icon=" + this.icon + ", images=" + this.images + ", downloadCount=" + this.downloadCount + ", evaluateCount=" + this.evaluateCount + ", avgScore=" + this.avgScore + ", star=" + this.star + ", qualityLabel=" + this.qualityLabel + ", icpStatus=" + this.icpStatus + ", status=" + this.status + ")";
    }

    public AppVersionDetailDto(long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, long j11, long j12, String str8, List<AppVersionImageDto> list, long j13, long j14, double d10, int i11, AppVersionQualityLabelDto appVersionQualityLabelDto, int i12, int i13) {
        this.id = j10;
        this.name = str;
        this.packageName = str2;
        this.publisher = str3;
        this.categoryName = str4;
        this.description = str5;
        this.recommendDesc = str6;
        this.versionName = str7;
        this.versionCode = i10;
        this.versionTime = j11;
        this.size = j12;
        this.icon = str8;
        this.images = list;
        this.downloadCount = j13;
        this.evaluateCount = j14;
        this.avgScore = d10;
        this.star = i11;
        this.qualityLabel = appVersionQualityLabelDto;
        this.icpStatus = i12;
        this.status = i13;
    }

    public /* synthetic */ AppVersionDetailDto(long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, long j11, long j12, String str8, List list, long j13, long j14, double d10, int i11, AppVersionQualityLabelDto appVersionQualityLabelDto, int i12, int i13, int i14, i iVar) {
        this((i14 & 1) != 0 ? 0L : j10, (i14 & 2) != 0 ? null : str, (i14 & 4) != 0 ? null : str2, (i14 & 8) != 0 ? null : str3, (i14 & 16) != 0 ? null : str4, (i14 & 32) != 0 ? null : str5, (i14 & 64) != 0 ? null : str6, (i14 & 128) != 0 ? null : str7, (i14 & 256) != 0 ? 0 : i10, (i14 & 512) != 0 ? 0L : j11, (i14 & 1024) != 0 ? 0L : j12, (i14 & 2048) != 0 ? null : str8, (i14 & 4096) != 0 ? null : list, (i14 & b.THRESHOLD) != 0 ? 0L : j13, (i14 & 16384) != 0 ? 0L : j14, (32768 & i14) != 0 ? 0.0d : d10, (65536 & i14) != 0 ? 0 : i11, (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : appVersionQualityLabelDto, (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? 0 : i12, (i14 & 524288) != 0 ? 0 : i13);
    }
}
