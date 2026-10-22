package com.stepos.ailauncher.foundation.appstore.api;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "", "id", "", "name", "", "packageName", "iconUrl", Const.JSON_KEY_DESC, "publisher", ContentDisposition.Parameters.Size, "downloadCount", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getPackageName", "getIconUrl", "getDesc", "getPublisher", "getSize", "getDownloadCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionItem {
    private final String desc;
    private final long downloadCount;
    private final String iconUrl;
    private final long id;
    private final String name;
    private final String packageName;
    private final String publisher;
    private final long size;

    public AppVersionItem(long j10, String str, String str2, String str3, String str4, String str5, long j11, long j12) {
        this.id = j10;
        this.name = str;
        this.packageName = str2;
        this.iconUrl = str3;
        this.desc = str4;
        this.publisher = str5;
        this.size = j11;
        this.downloadCount = j12;
    }

    public static /* synthetic */ AppVersionItem copy$default(AppVersionItem appVersionItem, long j10, String str, String str2, String str3, String str4, String str5, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = appVersionItem.id;
        }
        return appVersionItem.copy(j10, (i10 & 2) != 0 ? appVersionItem.name : str, (i10 & 4) != 0 ? appVersionItem.packageName : str2, (i10 & 8) != 0 ? appVersionItem.iconUrl : str3, (i10 & 16) != 0 ? appVersionItem.desc : str4, (i10 & 32) != 0 ? appVersionItem.publisher : str5, (i10 & 64) != 0 ? appVersionItem.size : j11, (i10 & 128) != 0 ? appVersionItem.downloadCount : j12);
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
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPublisher() {
        return this.publisher;
    }

    /* renamed from: component7, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component8, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final AppVersionItem copy(long id, String name, String packageName, String iconUrl, String desc, String publisher, long size, long downloadCount) {
        return new AppVersionItem(id, name, packageName, iconUrl, desc, publisher, size, downloadCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionItem)) {
            return false;
        }
        AppVersionItem appVersionItem = (AppVersionItem) other;
        return this.id == appVersionItem.id && p.d(this.name, appVersionItem.name) && p.d(this.packageName, appVersionItem.packageName) && p.d(this.iconUrl, appVersionItem.iconUrl) && p.d(this.desc, appVersionItem.desc) && p.d(this.publisher, appVersionItem.publisher) && this.size == appVersionItem.size && this.downloadCount == appVersionItem.downloadCount;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final String getIconUrl() {
        return this.iconUrl;
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

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.packageName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.publisher;
        return ((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.downloadCount);
    }

    public String toString() {
        return "AppVersionItem(id=" + this.id + ", name=" + this.name + ", packageName=" + this.packageName + ", iconUrl=" + this.iconUrl + ", desc=" + this.desc + ", publisher=" + this.publisher + ", size=" + this.size + ", downloadCount=" + this.downloadCount + ")";
    }
}
