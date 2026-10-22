package ac2;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.interactivity.service.uplink.FrontierTransformConfig;

/* JADX INFO: loaded from: classes9.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FrontierTransformConfig f2659a = null;

    static {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L9;
        HostBoeParams r101 = r100.getHostBoeParams();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.getBoeEnable() != true) goto L9;
    L10:
        if (r102 == false) goto L12;
        FrontierTransformConfig r103 = FrontierTransformConfig.BOE_DOUYIN_DOULITE;
    L13:
        f2659a = r103;
        return;
    L12:
        r103 = FrontierTransformConfig.ONLINE_DOUYIN_DOULITE;
    L9:
        r102 = false;
        goto L10
    }
}
