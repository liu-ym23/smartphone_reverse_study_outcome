package a19;

import android.content.ClipData;
import android.content.Context;
import com.larus.timonkit.api.ITimonKitService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements hi7.a {
    public d() {
    }

    @Override // hi7.a
    public final ClipData a() {
        FLogger.f375446a.i("ZlinkSdkManager", "zlink clipboard check");
        ITimonKitService r100 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);
        if (r100 == null) goto L5;
        ClipData r101 = r100.f("bpea-zlink-sdk");
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return ClipData.newPlainText(null, "");
    L5:
        r101 = null;
        goto L6
    }

    @Override // hi7.a
    public final void b(Context r100, CharSequence r101, CharSequence r102) {
        FLogger.f375446a.i("ZlinkSdkManager", "appendTextToClipboard outside title=" + r101 + " text=" + r102);
        ci7.g.i(ci7.g.g(r100), ClipData.newPlainText(r101, r102));     // Catch: Throwable -> L5
        return;
    }

    @Override // hi7.a
    public final void c(Context r100, String r101, ClipData r102) {
        ci7.g.a(r100, r101, r102);
    }
}
