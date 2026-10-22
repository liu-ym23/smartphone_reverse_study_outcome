package ao9;

import android.view.View;
import com.larus.network.HttpConst;
import com.larus.search.api.IBrowserService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kub.b;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements b {
    public a() {
    }

    @Override // kub.b
    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IBrowserService r101 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r101 == null) goto L6;
        HttpConst.f359979a.getClass();
        IBrowserService.a.a(r101, r100, HttpConst.E);
        return;
    }
}
