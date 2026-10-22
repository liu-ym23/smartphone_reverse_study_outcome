package com.bytedance.android.livesdkapi.minigame;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/UserHonor;", "Ljava/io/Serializable;", "level", "", "badgeWithLevel", "Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "(ILcom/bytedance/android/livesdkapi/minigame/ImageModel;)V", "getBadgeWithLevel", "()Lcom/bytedance/android/livesdkapi/minigame/ImageModel;", "setBadgeWithLevel", "(Lcom/bytedance/android/livesdkapi/minigame/ImageModel;)V", "getLevel", "()I", "setLevel", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserHonor implements Serializable {

    @SerializedName("badge_with_level")
    private ImageModel badgeWithLevel;

    @SerializedName("level")
    private int level;

    /* JADX WARN: Multi-variable type inference failed */
    public UserHonor() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UserHonor copy$default(UserHonor r100, int r101, ImageModel r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.level;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.badgeWithLevel;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.level;
    }

    public final ImageModel component2() {
        return this.badgeWithLevel;
    }

    public final UserHonor copy(int r100, ImageModel r101) {
        return new UserHonor(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof UserHonor) == false) goto L10;
        UserHonor r101 = (UserHonor) r100;
        if (this.level == r101.level) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.badgeWithLevel, r101.badgeWithLevel) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.level * 31;
        ImageModel r101 = this.badgeWithLevel;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "UserHonor(level=" + this.level + ", badgeWithLevel=" + this.badgeWithLevel + ")";
    }

    public final ImageModel getBadgeWithLevel() {
        return this.badgeWithLevel;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setBadgeWithLevel(ImageModel r100) {
        this.badgeWithLevel = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public UserHonor(int r100, ImageModel r101) {
        this.level = r100;
        this.badgeWithLevel = r101;
    }

    public /* synthetic */ UserHonor(int r100, ImageModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
