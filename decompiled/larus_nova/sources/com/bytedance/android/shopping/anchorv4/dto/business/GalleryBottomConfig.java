package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryBottomConfig;", "Ljava/io/Serializable;", RemoteMessageConst.Notification.VISIBILITY, "", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GallerySliceVisibilityConfig;", "addCartToast", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "(Ljava/util/Map;Lcom/bytedance/android/ecom/arch/slice/action/IAction;)V", "getAddCartToast", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getVisibility", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryBottomConfig implements Serializable {

    @SerializedName("add_cart_toast")
    private final IAction addCartToast;

    @SerializedName(RemoteMessageConst.Notification.VISIBILITY)
    private final Map<String, GallerySliceVisibilityConfig> visibility;

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryBottomConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final IAction getAddCartToast() {
        return this.addCartToast;
    }

    public final Map<String, GallerySliceVisibilityConfig> getVisibility() {
        return this.visibility;
    }

    public GalleryBottomConfig(Map<String, GallerySliceVisibilityConfig> r100, IAction r101) {
        this.visibility = r100;
        this.addCartToast = r101;
    }

    public /* synthetic */ GalleryBottomConfig(Map r100, IAction r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
