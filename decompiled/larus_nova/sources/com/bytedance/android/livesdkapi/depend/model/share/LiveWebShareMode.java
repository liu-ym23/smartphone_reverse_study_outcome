package com.bytedance.android.livesdkapi.depend.model.share;

import com.google.gson.annotations.SerializedName;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/share/LiveWebShareMode;", "", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "", "mode", "", "(Ljava/lang/String;I)V", "getMode", "()I", "getPlatformId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveWebShareMode {

    @SerializedName("mode")
    private final int mode;

    @SerializedName("platform_id")
    private final String platformId;

    public static /* synthetic */ LiveWebShareMode copy$default(LiveWebShareMode r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.platformId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.mode;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.platformId;
    }

    public final int component2() {
        return this.mode;
    }

    public final LiveWebShareMode copy(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        return new LiveWebShareMode(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveWebShareMode) == false) goto L10;
        LiveWebShareMode r101 = (LiveWebShareMode) r100;
        if (Intrinsics.areEqual(this.platformId, r101.platformId) == true) goto L8;
        return false;
    L8:
        if (this.mode == r101.mode) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.platformId;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.mode;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "LiveWebShareMode(platformId=" + this.platformId + ", mode=" + this.mode + ")";
    }

    public final int getMode() {
        return this.mode;
    }

    public final String getPlatformId() {
        return this.platformId;
    }

    public LiveWebShareMode(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        this.platformId = r100;
        this.mode = r101;
    }
}
