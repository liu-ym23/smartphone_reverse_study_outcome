package com.bytedance.android.livesdkapi.minigame;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/Fansclub;", "Ljava/io/Serializable;", "level", "", "clubName", "", IAllianceService.CONTENT_TYPE_BADGE, "Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "(ILjava/lang/String;Lcom/bytedance/android/livesdkapi/minigame/ImageModel;)V", "getBadge", "()Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "setBadge", "(Lcom/bytedance/android/livesdkapi/minigame/ImageModel;)V", "getClubName", "()Ljava/lang/String;", "setClubName", "(Ljava/lang/String;)V", "getLevel", "()I", "setLevel", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Fansclub implements Serializable {

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    private ImageModel badge;

    @SerializedName("club_name")
    private String clubName;

    @SerializedName("level")
    private int level;

    public Fansclub() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ Fansclub copy$default(Fansclub r100, int r101, String r102, ImageModel r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.level;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.clubName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.badge;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.level;
    }

    public final String component2() {
        return this.clubName;
    }

    public final ImageModel component3() {
        return this.badge;
    }

    public final Fansclub copy(int r100, String r101, ImageModel r102) {
        return new Fansclub(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Fansclub) == false) goto L12;
        Fansclub r101 = (Fansclub) r100;
        if (this.level == r101.level) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clubName, r101.clubName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.badge, r101.badge) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.level * 31;
        String r101 = this.clubName;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ImageModel r105 = this.badge;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "Fansclub(level=" + this.level + ", clubName=" + this.clubName + ", badge=" + this.badge + ")";
    }

    public final ImageModel getBadge() {
        return this.badge;
    }

    public final String getClubName() {
        return this.clubName;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setBadge(ImageModel r100) {
        this.badge = r100;
    }

    public final void setClubName(String r100) {
        this.clubName = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public Fansclub(int r100, String r101, ImageModel r102) {
        this.level = r100;
        this.clubName = r101;
        this.badge = r102;
    }

    public /* synthetic */ Fansclub(int r100, String r101, ImageModel r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
