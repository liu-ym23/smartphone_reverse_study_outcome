package com.bytedance.android.livesdk.revenue.service.largefont;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;
import com.bytedance.android.livesdk.revenue.util.f;

/* JADX INFO: loaded from: classes11.dex */
public final class RevLargeFontService extends f<IHostContext> implements a {
    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public RevLargeFontService() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.largefont.a
    public final boolean isLargeFontMode() {
        IHostContext r100 = k();
        if (r100 == null) goto L7;
        HostLargeFontParam r101 = r100.getHostLargeFontModeParams();
        if (r101 == null) goto L7;
        return r101.isLargeFontMode();
    L7:
        return false;
    }
}
