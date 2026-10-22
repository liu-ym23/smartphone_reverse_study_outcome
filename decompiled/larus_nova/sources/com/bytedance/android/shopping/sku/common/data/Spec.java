package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/Spec;", "Ljava/io/Serializable;", "specIndex", "", "name", "specItemList", "", "Lcom/bytedance/android/shopping/sku/common/data/SpecItem;", "canShowBigPic", "", "canShowSmallPic", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanShowBigPic", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanShowSmallPic", "getName", "()Ljava/lang/String;", "getSpecIndex", "getSpecItemList", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Spec implements Serializable {

    @SerializedName("can_show_big_pic")
    private final Boolean canShowBigPic;

    @SerializedName("can_show_small_pic")
    private final Boolean canShowSmallPic;

    @SerializedName("name")
    private final String name;

    @SerializedName("spec_index")
    private final String specIndex;

    @SerializedName("spec_item_list")
    private final List<SpecItem> specItemList;

    public Spec() {
        this(null, null, null, null, null, 31, null);
    }

    public final Boolean getCanShowBigPic() {
        return this.canShowBigPic;
    }

    public final Boolean getCanShowSmallPic() {
        return this.canShowSmallPic;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSpecIndex() {
        return this.specIndex;
    }

    public final List<SpecItem> getSpecItemList() {
        return this.specItemList;
    }

    public Spec(String r100, String r101, List<SpecItem> r102, Boolean r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "specIndex");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "specItemList");
        this.specIndex = r100;
        this.name = r101;
        this.specItemList = r102;
        this.canShowBigPic = r103;
        this.canShowSmallPic = r104;
    }

    public /* synthetic */ Spec(String r100, String r101, List r102, Boolean r103, Boolean r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        r102 = CollectionsKt.emptyList();
    L13:
        List r107 = r102;
        if ((r105 & 8) == 0) goto L16;
        Boolean r108 = null;
    L18:
        if ((r105 & 16) == 0) goto L20;
        Boolean r109 = null;
    L21:
        this(r111, r106, r107, r108, r109);
        return;
    L20:
        r109 = r104;
        goto L21
    L16:
        r108 = r103;
        goto L18
    L5:
        r111 = r100;
        goto L7
    }
}
