package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionQualityLabelDto;", "", "superior", "", "official", "<init>", "(II)V", "getSuperior", "()I", "getOfficial", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppVersionQualityLabelDto {

    @SerializedName("official")
    private final int official;

    @SerializedName("superior")
    private final int superior;

    /* JADX WARN: Illegal instructions before constructor call */
    public AppVersionQualityLabelDto() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public static /* synthetic */ AppVersionQualityLabelDto copy$default(AppVersionQualityLabelDto appVersionQualityLabelDto, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = appVersionQualityLabelDto.superior;
        }
        if ((i12 & 2) != 0) {
            i11 = appVersionQualityLabelDto.official;
        }
        return appVersionQualityLabelDto.copy(i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSuperior() {
        return this.superior;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOfficial() {
        return this.official;
    }

    public final AppVersionQualityLabelDto copy(int superior, int official) {
        return new AppVersionQualityLabelDto(superior, official);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppVersionQualityLabelDto)) {
            return false;
        }
        AppVersionQualityLabelDto appVersionQualityLabelDto = (AppVersionQualityLabelDto) other;
        return this.superior == appVersionQualityLabelDto.superior && this.official == appVersionQualityLabelDto.official;
    }

    public final int getOfficial() {
        return this.official;
    }

    public final int getSuperior() {
        return this.superior;
    }

    public int hashCode() {
        return (Integer.hashCode(this.superior) * 31) + Integer.hashCode(this.official);
    }

    public String toString() {
        return "AppVersionQualityLabelDto(superior=" + this.superior + ", official=" + this.official + ")";
    }

    public AppVersionQualityLabelDto(int i10, int i11) {
        this.superior = i10;
        this.official = i11;
    }

    public /* synthetic */ AppVersionQualityLabelDto(int i10, int i11, int i12, i iVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
    }
}
