package com.bytedance.android.shopping.anchorv4.bottomnav;

import com.bytedance.android.ecom.arch.slice.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\tR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottomnav/BottomNavVO;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ecom/arch/slice/g;", "slices", "Ljava/util/List;", "getSlices", "()Ljava/util/List;", "setSlices", "(Ljava/util/List;)V", "<init>", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomNavVO implements Serializable {

    @SerializedName("slices")
    private List<? extends g> slices;

    /* JADX WARN: Multi-variable type inference failed */
    public BottomNavVO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<g> getSlices() {
        return this.slices;
    }

    public BottomNavVO(List<? extends g> r100) {
        this.slices = r100;
    }

    public final void setSlices(List<? extends g> r100) {
        this.slices = r100;
    }

    public /* synthetic */ BottomNavVO(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
