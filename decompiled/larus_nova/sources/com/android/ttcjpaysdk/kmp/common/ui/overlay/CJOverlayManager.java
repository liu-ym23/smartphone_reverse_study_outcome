package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.kmp.common.ui.CJHostUi;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayManager;", "", "<init>", "()V", "show", "", ExifInterface.GPS_DIRECTION_TRUE, CloudControlInf.ROUTE, "Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayRoute;", "entryId", "", "entry", WsConstants.KEY_PAYLOAD, "", BuyNowCloseMethod.MASK, "Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;", "(Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayRoute;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;)Z", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayManager {
    public static final int $stable = 0;
    public static final CJOverlayManager INSTANCE = null;

    static {
        INSTANCE = new CJOverlayManager();
    }

    private CJOverlayManager() {
    }

    public final <T> boolean show(CJOverlayRoute<T> r100, String r101, T r102, Map<String, ? extends Object> r103, CJOverlayMask r104) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r101, "entryId");
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r104, BuyNowCloseMethod.MASK);
        r100.getStore().register(r101, r102);
        String r105 = CJOverlayParamsCodec.INSTANCE.encodeV1(r101, r104, r103);
        String r106 = CJHostUi.INSTANCE.showOverlay(r100.getName(), r105);
        if (r106.length() != 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L9;
        r100.getStore().remove(r101);
        return false;
    L9:
        r100.getStore().bindOverlayId(r101, r106);
        return true;
    L5:
        r107 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean show$default(CJOverlayManager r100, CJOverlayRoute r101, String r102, Object r103, Map r110, CJOverlayMask r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = MapsKt.emptyMap();
    L5:
        Map r104 = r110;
        if ((r112 & 16) == 0) goto L9;
        r111 = r101.getDefaultMask();
    L9:
        return r100.show(r101, r102, r103, r104, r111);
    }
}
