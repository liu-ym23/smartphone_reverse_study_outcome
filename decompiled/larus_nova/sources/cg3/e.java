package cg3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcg3/e;", "", "", "shareTitle", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "shareContent", "b", "", "rankType", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("rank_type")
    private final Integer rankType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT)
    private final String shareContent;

    @SerializedName("share_title")
    private final String shareTitle;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.shareTitle, r101.shareTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shareContent, r101.shareContent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rankType, r101.rankType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.shareTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.shareContent;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.rankType;
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
        return "CommentShareInfoStruct(shareTitle=" + this.shareTitle + ", shareContent=" + this.shareContent + ", rankType=" + this.rankType + ")";
    }

    public final Integer a() {
        return this.rankType;
    }

    public final String b() {
        return this.shareContent;
    }

    public final String c() {
        return this.shareTitle;
    }

    public e(int r100) {
        this.shareTitle = null;
        this.shareContent = null;
        this.rankType = null;
    }
}
