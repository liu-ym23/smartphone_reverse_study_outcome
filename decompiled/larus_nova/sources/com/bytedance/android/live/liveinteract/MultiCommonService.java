package com.bytedance.android.live.liveinteract;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/MultiCommonService;", "Lcom/bytedance/android/live/liveinteract/IMultiCommonService;", "()V", "checkCommonSetting", "", InvRouter.SCENES, "", "", "useGalileoData", "multilink-host-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MultiCommonService implements IMultiCommonService {
    public MultiCommonService() {
    }

    @Override // com.bytedance.android.live.liveinteract.IMultiCommonService
    public boolean useGalileoData() {
        if (((Number) vm2.d.J2.getValue(null, vm2.d.f555776a[189(0xbd, float:2.65E-43)])).intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.IMultiCommonService
    public boolean checkCommonSetting(Set<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, InvRouter.SCENES);
        if (tb1.c.f545235g == true) goto L6;
        return false;
    L6:
        if (r100.contains(Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene())) == true) goto L8;
        return false;
    L8:
        return true;
    }
}
