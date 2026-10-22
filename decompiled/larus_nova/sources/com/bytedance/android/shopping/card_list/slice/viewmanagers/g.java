package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/card_list/slice/viewmanagers/g;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "height", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "width", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("height")
    private final int height;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final int width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (this.width == r101.width) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.url;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.height) * 31) + this.width;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "ImgStruct(url=" + this.url + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public g() {
        this.url = null;
        this.height = 0;
        this.width = 0;
    }

    public final int a() {
        return this.height;
    }

    public final String b() {
        return this.url;
    }

    public final int c() {
        return this.width;
    }
}
