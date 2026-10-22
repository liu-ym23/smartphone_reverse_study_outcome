package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import com.bytedance.ies.sve_core.Store;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class l extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f54029f = 0;

    public static final class a {
    }

    static {
    }

    public l(Store r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        super(r100);
        new CompositeDisposable();
    }

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof b) == false) goto L9;
        final b r101 = (b) r100;     // Catch: Exception -> L6
        g(r101.f53972a, new NewBetaDownloadEffect$handleOpenIntent$1(this, r101));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        yr.c.b("NewBetaDownloadEffect", e.toString());
        return;
    L9:
        if ((r100 instanceof e) == false) goto L15;
        final e r102 = (e) r100;     // Catch: Exception -> L12
        g(r102.f53987a, new NewBetaDownloadEffect$handleQuestionnaireIntent$1(this, r102));     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        yr.c.b("NewBetaDownloadEffect", e.toString());
        return;
    L15:
        if ((r100 instanceof com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.a) == false) goto L29;
        final com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.a r103 = (com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.a) r100;     // Catch: Exception -> L18
        g(r103.f53962a, new NewBetaDownloadEffect$handleFCFGIntent$1(this, r103));     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        yr.c.b("NewBetaDownloadEffect", e.toString());
        return;
    }

    public static final void j(l r100, Context r101, String r102, boolean r103, String r104, String r105, int r106, int r107, String r108, int r110) {
        Map<String, String> r109 = r100.h();
        r109.put("show_reverved_info", String.valueOf(r103));
        r109.put("reserved_status", r104);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r109.put("plan_id", r105);
        r109.put("test_plan_open_type", String.valueOf(r106));
        r109.put("test_qualification_type", String.valueOf(r107));
        if (r108 != null) goto L8;
        r108 = "";
    L8:
        r109.put("activation_code", r108);
        r109.put("beta_game_stage", String.valueOf(r110));
        com.bytedance.android.gamecp.business.hybrid.a.d(r101, r102, r109);
    }
}
