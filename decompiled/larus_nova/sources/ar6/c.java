package ar6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lar6/c;", "", "", "src", "Ljava/lang/String;", "getSrc", "()Ljava/lang/String;", "srcDark", "getSrcDark", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    @SerializedName("src")
    private final String f16023src;

    @SerializedName("src_dark")
    private final String srcDark;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f16023src, r101.f16023src) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.srcDark, r101.srcDark) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f16023src;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.srcDark;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "StdImageVO(src=" + this.f16023src + ", srcDark=" + this.srcDark + ')';
    }

    public c() {
        this.f16023src = null;
        this.srcDark = null;
    }
}
