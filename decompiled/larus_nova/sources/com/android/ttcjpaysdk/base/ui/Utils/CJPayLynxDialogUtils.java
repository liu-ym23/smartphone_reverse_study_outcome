package com.android.ttcjpaysdk.base.ui.Utils;

import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayGeckoService;
import com.android.ttcjpaysdk.base.service.ICJPayOfflineHelper;
import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayLynxDialogUtils;", "", "()V", "lynx_dialog_channel", "", "isLynxPackageReady", "", "channel", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLynxDialogUtils {
    public static final CJPayLynxDialogUtils INSTANCE = null;
    public static final String lynx_dialog_channel = "fe_lynx_cashdesk_dynamic";

    static {
        INSTANCE = new CJPayLynxDialogUtils();
    }

    private CJPayLynxDialogUtils() {
    }

    public final boolean isLynxPackageReady(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        a.f554342a.getClass();
        IContainerHostDepend r101 = (IContainerHostDepend) a.a(IContainerHostDepend.class);
        Boolean r102 = null;
        if (r101 == null) goto L7;
        ILivePluginHelper r103 = r101.getLivePluginHelper();
        if (r103 == null) goto L7;
        Boolean r104 = Boolean.valueOf(r103.hasPluginLoaded());
    L9:
        if (r104 == null) goto L11;
        boolean r105 = r104.booleanValue();
    L12:
        ICJPayGeckoService r106 = (ICJPayGeckoService) CJPayServiceManager.getInstance().getIService(ICJPayGeckoService.class);
        if (r106 == null) goto L17;
        ICJPayOfflineHelper r107 = r106.getOfflineHelper();
        if (r107 == null) goto L17;
        r102 = Boolean.valueOf(r107.checkLiveChannelUseful(r100));
    L17:
        if (r102 == null) goto L19;
        boolean r108 = r102.booleanValue();
    L20:
        if (r105 == false) goto L24;
        if (r108 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L19:
        r108 = false;
        goto L20
    L11:
        r105 = false;
    L7:
        r104 = null;
        goto L9
    }
}
