package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/a;", "", "", "jumpUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "itemsJumpUrl", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("items_jump_url")
    private final List<String> itemsJumpUrl;

    @SerializedName("jump_url")
    private final String jumpUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.itemsJumpUrl, r101.itemsJumpUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.jumpUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.itemsJumpUrl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4AskAroundLink(jumpUrl=" + this.jumpUrl + ", itemsJumpUrl=" + this.itemsJumpUrl + ")";
    }

    public a() {
        this.jumpUrl = "";
        this.itemsJumpUrl = null;
    }

    public final List<String> a() {
        return this.itemsJumpUrl;
    }

    public final String b() {
        return this.jumpUrl;
    }
}
