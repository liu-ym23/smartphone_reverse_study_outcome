package com.bytedance.android.shopping.sku.common.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/data/SpecState;", "Ljava/io/Serializable;", "curShowMode", "", "selectedSpecItemId", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurShowMode", "()Ljava/lang/String;", "getSelectedSpecItemId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecState implements Serializable {

    @SerializedName("cur_show_mode")
    private final String curShowMode;

    @SerializedName("selected_spec_item_id")
    private final String selectedSpecItemId;

    /* JADX WARN: Multi-variable type inference failed */
    public SpecState() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getCurShowMode() {
        return this.curShowMode;
    }

    public final String getSelectedSpecItemId() {
        return this.selectedSpecItemId;
    }

    public SpecState(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "curShowMode");
        Intrinsics.checkNotNullParameter(r101, "selectedSpecItemId");
        this.curShowMode = r100;
        this.selectedSpecItemId = r101;
    }

    public /* synthetic */ SpecState(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
