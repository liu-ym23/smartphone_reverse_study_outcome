package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/v;", "", "", SlcFlexDirection.FLEX_ROW, "I", "b", "()I", "", "lyrics", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v {

    @SerializedName("lyrics")
    private final String lyrics;

    @SerializedName(SlcFlexDirection.FLEX_ROW)
    private final int row;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        if (this.row == r101.row) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lyrics, r101.lyrics) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.row * 31;
        String r101 = this.lyrics;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "SeiLyricsInfo(row=" + this.row + ", lyrics=" + this.lyrics + ")";
    }

    public v() {
        this.row = 0;
        this.lyrics = null;
    }

    public final String a() {
        return this.lyrics;
    }

    public final int b() {
        return this.row;
    }
}
