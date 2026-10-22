package com.stepos.ailauncher.foundation.appstore.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "", "name", "", "sizeText", "iconUrl", "description", "publisher", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getSizeText", "getIconUrl", "getDescription", "getPublisher", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppDetail {
    private final String description;
    private final String iconUrl;
    private final String name;
    private final String publisher;
    private final String sizeText;

    public AppDetail(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.sizeText = str2;
        this.iconUrl = str3;
        this.description = str4;
        this.publisher = str5;
    }

    public static /* synthetic */ AppDetail copy$default(AppDetail appDetail, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appDetail.name;
        }
        if ((i10 & 2) != 0) {
            str2 = appDetail.sizeText;
        }
        if ((i10 & 4) != 0) {
            str3 = appDetail.iconUrl;
        }
        if ((i10 & 8) != 0) {
            str4 = appDetail.description;
        }
        if ((i10 & 16) != 0) {
            str5 = appDetail.publisher;
        }
        String str6 = str5;
        String str7 = str3;
        return appDetail.copy(str, str2, str7, str4, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSizeText() {
        return this.sizeText;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPublisher() {
        return this.publisher;
    }

    public final AppDetail copy(String name, String sizeText, String iconUrl, String description, String publisher) {
        return new AppDetail(name, sizeText, iconUrl, description, publisher);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppDetail)) {
            return false;
        }
        AppDetail appDetail = (AppDetail) other;
        return p.d(this.name, appDetail.name) && p.d(this.sizeText, appDetail.sizeText) && p.d(this.iconUrl, appDetail.iconUrl) && p.d(this.description, appDetail.description) && p.d(this.publisher, appDetail.publisher);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPublisher() {
        return this.publisher;
    }

    public final String getSizeText() {
        return this.sizeText;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sizeText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.publisher;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "AppDetail(name=" + this.name + ", sizeText=" + this.sizeText + ", iconUrl=" + this.iconUrl + ", description=" + this.description + ", publisher=" + this.publisher + ")";
    }

    public /* synthetic */ AppDetail(String str, String str2, String str3, String str4, String str5, int i10, i iVar) {
        this(str, str2, str3, str4, (i10 & 16) != 0 ? null : str5);
    }
}
