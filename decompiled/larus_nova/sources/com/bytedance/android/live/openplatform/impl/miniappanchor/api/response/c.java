package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.GetIconBackGroundResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/c;", "", "", "iconBackgroundColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "textPosterTitleColor", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("RGB")
    protected String iconBackgroundColor;

    @SerializedName("word_RGB")
    protected String textPosterTitleColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.iconBackgroundColor, r101.iconBackgroundColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textPosterTitleColor, r101.textPosterTitleColor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.iconBackgroundColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textPosterTitleColor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetIconBackgroundResponse(iconBackgroundColor=" + this.iconBackgroundColor + ", textPosterTitleColor=" + this.textPosterTitleColor + ")";
    }

    public c() {
        this.iconBackgroundColor = null;
        this.textPosterTitleColor = null;
    }

    public final String a() {
        return this.iconBackgroundColor;
    }

    public final String b() {
        return this.textPosterTitleColor;
    }

    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.iconBackgroundColor = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.textPosterTitleColor = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.iconBackgroundColor != null) goto L16;
        this.iconBackgroundColor = null;
    L16:
        if (this.textPosterTitleColor != null) goto L28;
        this.textPosterTitleColor = null;
        return;
    }
}
