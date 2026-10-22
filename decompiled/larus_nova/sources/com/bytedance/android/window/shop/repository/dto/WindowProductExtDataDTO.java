package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0007\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0006\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003J%\u0010\b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R,\u0010\u0007\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowProductExtDataDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "", "Lcom/bytedance/android/window/shop/repository/dto/PromotionId;", "Lcom/bytedance/android/window/shop/repository/dto/y0;", "component1", "allRefreshInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/Map;", "getAllRefreshInfo", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductExtDataDTO extends CommerceBaseResponse {

    @SerializedName("refresh_info")
    private final Map<String, y0> allRefreshInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowProductExtDataDTO copy$default(WindowProductExtDataDTO r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.allRefreshInfo;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, y0> component1() {
        return this.allRefreshInfo;
    }

    public final WindowProductExtDataDTO copy(Map<String, y0> r100) {
        return new WindowProductExtDataDTO(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowProductExtDataDTO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.allRefreshInfo, ((WindowProductExtDataDTO) r100).allRefreshInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, y0> r100 = this.allRefreshInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "WindowProductExtDataDTO(allRefreshInfo=" + this.allRefreshInfo + ")";
    }

    public final Map<String, y0> getAllRefreshInfo() {
        return this.allRefreshInfo;
    }

    public WindowProductExtDataDTO(Map<String, y0> r100) {
        this.allRefreshInfo = r100;
    }
}
