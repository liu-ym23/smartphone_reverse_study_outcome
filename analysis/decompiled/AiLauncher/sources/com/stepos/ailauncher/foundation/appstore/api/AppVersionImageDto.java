package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionImageDto;", "", "image", "", "small", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getImage", "()Ljava/lang/String;", "getSmall", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionImageDto {

    @SerializedName("height")
    private final int height;

    @SerializedName("image")
    private final String image;

    @SerializedName("small")
    private final String small;

    @SerializedName("width")
    private final int width;

    public AppVersionImageDto() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ AppVersionImageDto copy$default(AppVersionImageDto appVersionImageDto, String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = appVersionImageDto.image;
        }
        if ((i12 & 2) != 0) {
            str2 = appVersionImageDto.small;
        }
        if ((i12 & 4) != 0) {
            i10 = appVersionImageDto.width;
        }
        if ((i12 & 8) != 0) {
            i11 = appVersionImageDto.height;
        }
        return appVersionImageDto.copy(str, str2, i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSmall() {
        return this.small;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final AppVersionImageDto copy(String image, String small, int width, int height) {
        return new AppVersionImageDto(image, small, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionImageDto)) {
            return false;
        }
        AppVersionImageDto appVersionImageDto = (AppVersionImageDto) other;
        return p.d(this.image, appVersionImageDto.image) && p.d(this.small, appVersionImageDto.small) && this.width == appVersionImageDto.width && this.height == appVersionImageDto.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getSmall() {
        return this.small;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.image;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.small;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "AppVersionImageDto(image=" + this.image + ", small=" + this.small + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public AppVersionImageDto(String str, String str2, int i10, int i11) {
        this.image = str;
        this.small = str2;
        this.width = i10;
        this.height = i11;
    }

    public /* synthetic */ AppVersionImageDto(String str, String str2, int i10, int i11, int i12, i iVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
