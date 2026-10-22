package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.ILiveDuxPopupNotice;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements DuxPopupNoticeConfig.HideCallback {
    public b() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig.HideCallback
    public final /* synthetic */ void beforeHide(ILiveDuxPopupNotice r100, int r101) {
        DuxPopupNoticeConfig.HideCallback.CC.$default$beforeHide(this, r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig.HideCallback
    public final void onHide(ILiveDuxPopupNotice r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        int r102 = qo0.a.f534145a;
        qo0.a.c("PreviewShelfManagementActivity", "on explain notice hide, reason: " + r101);
        int r103 = xq0.a.f564792a;
        e<Integer> r104 = com.bytedance.android.livesdk.sharedpref.b.G3;
        f.d(r104, Integer.valueOf(r104.getValue().intValue() + 1));
    }
}
