package com.bytedance.android.gamecp.business.gamedetail.component.relativeminigame;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/relativeminigame/c;", "", "", "gameDescription", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "gameIcon", "b", "Lcom/bytedance/android/gamecp/business/gamedetail/component/relativeminigame/a;", "miniGameInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/relativeminigame/a;", "c", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/relativeminigame/a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("description")
    private final String gameDescription;

    @SerializedName("icon")
    private final String gameIcon;

    @SerializedName("mini_game_meta")
    private final a miniGameInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.gameDescription, r101.gameDescription) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameIcon, r101.gameIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.miniGameInfo, r101.miniGameInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.gameDescription;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.gameIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.miniGameInfo;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RelativeMiniGameData(gameDescription=" + this.gameDescription + ", gameIcon=" + this.gameIcon + ", miniGameInfo=" + this.miniGameInfo + ")";
    }

    public c() {
        this.gameDescription = null;
        this.gameIcon = null;
        this.miniGameInfo = null;
    }

    public final String a() {
        return this.gameDescription;
    }

    public final String b() {
        return this.gameIcon;
    }

    public final a c() {
        return this.miniGameInfo;
    }
}
