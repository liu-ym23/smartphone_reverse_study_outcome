package com.stepos.ailauncher.foundation.appstore.api;

import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0016HÆ\u0003J\t\u0010F\u001a\u00020\rHÆ\u0003J\t\u0010G\u001a\u00020\u0019HÆ\u0003J\t\u0010H\u001a\u00020\rHÆ\u0003JÝ\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\rHÆ\u0001J\u0013\u0010J\u001a\u00020\u00192\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\rHÖ\u0001J\t\u0010M\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(¨\u0006N"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;", "", "id", "", "name", "", "packageName", "publisher", "categoryName", "description", "recommendDesc", "versionName", "versionCode", "", "versionTime", ContentDisposition.Parameters.Size, "iconUrl", "imageUrls", "", "downloadCount", "evaluateCount", "avgScore", "", "star", "verified", "", "status", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;Ljava/util/List;JJDIZI)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getPackageName", "getPublisher", "getCategoryName", "getDescription", "getRecommendDesc", "getVersionName", "getVersionCode", "()I", "getVersionTime", "getSize", "getIconUrl", "getImageUrls", "()Ljava/util/List;", "getDownloadCount", "getEvaluateCount", "getAvgScore", "()D", "getStar", "getVerified", "()Z", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionDetail {
    private final double avgScore;
    private final String categoryName;
    private final String description;
    private final long downloadCount;
    private final long evaluateCount;
    private final String iconUrl;
    private final long id;
    private final List<String> imageUrls;
    private final String name;
    private final String packageName;
    private final String publisher;
    private final String recommendDesc;
    private final long size;
    private final int star;
    private final int status;
    private final boolean verified;
    private final int versionCode;
    private final String versionName;
    private final long versionTime;

    public AppVersionDetail(long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, long j11, long j12, String str8, List<String> imageUrls, long j13, long j14, double d10, int i11, boolean z10, int i12) {
        p.i(imageUrls, "imageUrls");
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
        this.iconUrl = str8;
        this.imageUrls = imageUrls;
        this.downloadCount = j13;
        this.evaluateCount = j14;
        this.avgScore = d10;
        this.star = i11;
        this.verified = z10;
        this.status = i12;
    }

    public static /* synthetic */ AppVersionDetail copy$default(AppVersionDetail appVersionDetail, long j10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, long j11, long j12, String str8, List list, long j13, long j14, double d10, int i11, boolean z10, int i12, int i13, Object obj) {
        long j15 = (i13 & 1) != 0 ? appVersionDetail.id : j10;
        return appVersionDetail.copy(j15, (i13 & 2) != 0 ? appVersionDetail.name : str, (i13 & 4) != 0 ? appVersionDetail.packageName : str2, (i13 & 8) != 0 ? appVersionDetail.publisher : str3, (i13 & 16) != 0 ? appVersionDetail.categoryName : str4, (i13 & 32) != 0 ? appVersionDetail.description : str5, (i13 & 64) != 0 ? appVersionDetail.recommendDesc : str6, (i13 & 128) != 0 ? appVersionDetail.versionName : str7, (i13 & 256) != 0 ? appVersionDetail.versionCode : i10, (i13 & 512) != 0 ? appVersionDetail.versionTime : j11, (i13 & 1024) != 0 ? appVersionDetail.size : j12, (i13 & 2048) != 0 ? appVersionDetail.iconUrl : str8, (i13 & 4096) != 0 ? appVersionDetail.imageUrls : list, (i13 & b.THRESHOLD) != 0 ? appVersionDetail.downloadCount : j13, (i13 & 16384) != 0 ? appVersionDetail.evaluateCount : j14, (i13 & 32768) != 0 ? appVersionDetail.avgScore : d10, (i13 & 65536) != 0 ? appVersionDetail.star : i11, (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? appVersionDetail.verified : z10, (i13 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? appVersionDetail.status : i12);
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
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<String> component13() {
        return this.imageUrls;
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
    public final boolean getVerified() {
        return this.verified;
    }

    /* renamed from: component19, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
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

    public final AppVersionDetail copy(long id, String name, String packageName, String publisher, String categoryName, String description, String recommendDesc, String versionName, int versionCode, long versionTime, long size, String iconUrl, List<String> imageUrls, long downloadCount, long evaluateCount, double avgScore, int star, boolean verified, int status) {
        p.i(imageUrls, "imageUrls");
        return new AppVersionDetail(id, name, packageName, publisher, categoryName, description, recommendDesc, versionName, versionCode, versionTime, size, iconUrl, imageUrls, downloadCount, evaluateCount, avgScore, star, verified, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionDetail)) {
            return false;
        }
        AppVersionDetail appVersionDetail = (AppVersionDetail) other;
        return this.id == appVersionDetail.id && p.d(this.name, appVersionDetail.name) && p.d(this.packageName, appVersionDetail.packageName) && p.d(this.publisher, appVersionDetail.publisher) && p.d(this.categoryName, appVersionDetail.categoryName) && p.d(this.description, appVersionDetail.description) && p.d(this.recommendDesc, appVersionDetail.recommendDesc) && p.d(this.versionName, appVersionDetail.versionName) && this.versionCode == appVersionDetail.versionCode && this.versionTime == appVersionDetail.versionTime && this.size == appVersionDetail.size && p.d(this.iconUrl, appVersionDetail.iconUrl) && p.d(this.imageUrls, appVersionDetail.imageUrls) && this.downloadCount == appVersionDetail.downloadCount && this.evaluateCount == appVersionDetail.evaluateCount && Double.compare(this.avgScore, appVersionDetail.avgScore) == 0 && this.star == appVersionDetail.star && this.verified == appVersionDetail.verified && this.status == appVersionDetail.status;
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

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final long getId() {
        return this.id;
    }

    public final List<String> getImageUrls() {
        return this.imageUrls;
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

    public final boolean getVerified() {
        return this.verified;
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
        String str8 = this.iconUrl;
        return ((((((((((((((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.imageUrls.hashCode()) * 31) + Long.hashCode(this.downloadCount)) * 31) + Long.hashCode(this.evaluateCount)) * 31) + Double.hashCode(this.avgScore)) * 31) + Integer.hashCode(this.star)) * 31) + Boolean.hashCode(this.verified)) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        return "AppVersionDetail(id=" + this.id + ", name=" + this.name + ", packageName=" + this.packageName + ", publisher=" + this.publisher + ", categoryName=" + this.categoryName + ", description=" + this.description + ", recommendDesc=" + this.recommendDesc + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", versionTime=" + this.versionTime + ", size=" + this.size + ", iconUrl=" + this.iconUrl + ", imageUrls=" + this.imageUrls + ", downloadCount=" + this.downloadCount + ", evaluateCount=" + this.evaluateCount + ", avgScore=" + this.avgScore + ", star=" + this.star + ", verified=" + this.verified + ", status=" + this.status + ")";
    }
}
