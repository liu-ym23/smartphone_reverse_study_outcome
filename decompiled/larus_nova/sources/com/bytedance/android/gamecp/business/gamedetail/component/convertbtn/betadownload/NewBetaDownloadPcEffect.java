package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import com.bytedance.ies.sve_core.Store;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class NewBetaDownloadPcEffect extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f53943f = 0;

    public static final class a {
    }

    static {
    }

    public NewBetaDownloadPcEffect(Store r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r100);
        new CompositeDisposable();
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(final com.bytedance.ies.sve_core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof d) == false) goto L9;
        Map<String, String> r101 = h();     // Catch: Exception -> L6
        int r102 = com.bytedance.android.gamecp.business.hybrid.a.f55974a;     // Catch: Exception -> L6
        com.bytedance.android.gamecp.business.hybrid.a.b(((d) r100).f53985a, ((d) r100).f53986b, r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        yr.c.b("NewBetaDownloadPcEffect", e.toString());
        return;
    L9:
        if ((r100 instanceof f) == false) goto L15;
        g(((f) r100).f53996a, new NewBetaDownloadPcEffect$receiveAction$1(this, r100));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        yr.c.b("NewBetaDownloadPcEffect", e.toString());
        return;
    L15:
        if ((r100 instanceof c) == false) goto L29;
        final c r103 = (c) r100;     // Catch: Exception -> L18
        g(r103.f53979a, new NewBetaDownloadPcEffect$handleFCFGIntent$1(this, r103));     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        yr.c.b("NewBetaDownloadPcEffect", e.toString());
        return;
    }
}
