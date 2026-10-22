package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/a0;", "", "", "anchor_url", "Ljava/lang/String;", "getAnchor_url", "()Ljava/lang/String;", "audience_url", "getAudience_url", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("anchor_url")
    private final String anchor_url;

    @SerializedName("audience_url")
    private final String audience_url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L10;
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.anchor_url, r101.anchor_url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.audience_url, r101.audience_url) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.anchor_url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.audience_url;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxCdnRepo(anchor_url=" + this.anchor_url + ", audience_url=" + this.audience_url + ")";
    }
}
