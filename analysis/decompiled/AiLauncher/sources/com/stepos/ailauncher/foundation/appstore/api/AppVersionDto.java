package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDto;", "", "id", "", "name", "", "packageName", "icon", "publisher", "recommendDesc", ContentDisposition.Parameters.Size, "downloadCount", QueryAlgorithmBundle.KEY_CATEGORY, "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJI)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getPackageName", "getIcon", "getPublisher", "getRecommendDesc", "getSize", "getDownloadCount", "getCategory", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionDto {

    @SerializedName(QueryAlgorithmBundle.KEY_CATEGORY)
    private final int category;

    @SerializedName("download_count")
    private final long downloadCount;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("id")
    private final long id;

    @SerializedName("name")
    private final String name;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("publisher")
    private final String publisher;

    @SerializedName("recommend_desc")
    private final String recommendDesc;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final long size;

    public AppVersionDto() {
        this(0L, null, null, null, null, null, 0L, 0L, 0, 511, null);
    }

    public static /* synthetic */ AppVersionDto copy$default(AppVersionDto appVersionDto, long j10, String str, String str2, String str3, String str4, String str5, long j11, long j12, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = appVersionDto.id;
        }
        return appVersionDto.copy(j10, (i11 & 2) != 0 ? appVersionDto.name : str, (i11 & 4) != 0 ? appVersionDto.packageName : str2, (i11 & 8) != 0 ? appVersionDto.icon : str3, (i11 & 16) != 0 ? appVersionDto.publisher : str4, (i11 & 32) != 0 ? appVersionDto.recommendDesc : str5, (i11 & 64) != 0 ? appVersionDto.size : j11, (i11 & 128) != 0 ? appVersionDto.downloadCount : j12, (i11 & 256) != 0 ? appVersionDto.category : i10);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
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
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPublisher() {
        return this.publisher;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRecommendDesc() {
        return this.recommendDesc;
    }

    /* renamed from: component7, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component8, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component9, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    public final AppVersionDto copy(long id, String name, String packageName, String icon, String publisher, String recommendDesc, long size, long downloadCount, int category) {
        return new AppVersionDto(id, name, packageName, icon, publisher, recommendDesc, size, downloadCount, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionDto)) {
            return false;
        }
        AppVersionDto appVersionDto = (AppVersionDto) other;
        return this.id == appVersionDto.id && p.d(this.name, appVersionDto.name) && p.d(this.packageName, appVersionDto.packageName) && p.d(this.icon, appVersionDto.icon) && p.d(this.publisher, appVersionDto.publisher) && p.d(this.recommendDesc, appVersionDto.recommendDesc) && this.size == appVersionDto.size && this.downloadCount == appVersionDto.downloadCount && this.category == appVersionDto.category;
    }

    public final int getCategory() {
        return this.category;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
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

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.publisher;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.recommendDesc;
        return ((((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.downloadCount)) * 31) + Integer.hashCode(this.category);
    }

    public String toString() {
        return "AppVersionDto(id=" + this.id + ", name=" + this.name + ", packageName=" + this.packageName + ", icon=" + this.icon + ", publisher=" + this.publisher + ", recommendDesc=" + this.recommendDesc + ", size=" + this.size + ", downloadCount=" + this.downloadCount + ", category=" + this.category + ")";
    }

    public AppVersionDto(long j10, String str, String str2, String str3, String str4, String str5, long j11, long j12, int i10) {
        this.id = j10;
        this.name = str;
        this.packageName = str2;
        this.icon = str3;
        this.publisher = str4;
        this.recommendDesc = str5;
        this.size = j11;
        this.downloadCount = j12;
        this.category = i10;
    }

    public /* synthetic */ AppVersionDto(long j10, String str, String str2, String str3, String str4, String str5, long j11, long j12, int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0L : j10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) == 0 ? str5 : null, (i11 & 64) != 0 ? 0L : j11, (i11 & 128) == 0 ? j12 : 0L, (i11 & 256) != 0 ? 0 : i10);
    }
}
