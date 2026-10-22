package a19;

import com.bytedance.router.SmartRouter;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.larus.common.apphost.AppHost;
import com.larus.common.zlinksdk.api.IZlinkConfigs;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements CallBackForAppLink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1400a;

    @Override // com.bytedance.ug.sdk.deeplink.CallBackForAppLink
    public final void dealWithSchemaIsEmpty() {
        FLogger.f375446a.i("ZlinkSdkManager", "dealWithSchemaIsEmpty");
    }

    @Override // com.bytedance.ug.sdk.deeplink.CallBackForAppLink
    public final List<String> getHostList() {
        IZlinkConfigs r100 = (IZlinkConfigs) ServiceManager.get().getService(IZlinkConfigs.class);
        if (r100 == null) goto L7;
        List<String> r101 = r100.getHostList();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public g(c r100) {
        this.f1400a = r100;
    }

    @Override // com.bytedance.ug.sdk.deeplink.CallBackForAppLink
    public final boolean dealWithSchema(String r100) {
        this.f1400a.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        FLogger.f375446a.i("ZlinkSdkManager", "tryGotoPage scheme:" + r100);     // Catch: Throwable -> L17
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
    L19:
        return true;
    L13:
        if (SmartRouter.canOpen(r100) == false) goto L19;
        SmartRouter.buildRoute(AppHost.f326268a.a().getCurrentActivity(), r100).d();     // Catch: Throwable -> L17
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        goto L19
    L6:
        if (r100.length() == 0) goto L9;
        r102 = false;
    L17:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
