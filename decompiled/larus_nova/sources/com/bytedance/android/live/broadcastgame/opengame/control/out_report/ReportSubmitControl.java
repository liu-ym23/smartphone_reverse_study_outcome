package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReqResultFragment;
import com.bytedance.android.live.broadcastgame.opengame.control.report.g;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ReportSubmitControl {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final TokenCert f59900i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReqResultFragment f59901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.control.report.c f59902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f59903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UploadResult f59904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f59905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q.a f59906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f59907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f59908h;

    public static final class a {
    }

    static {
        f59900i = TokenCert.Companion.with("bpea-live_reportsubmitcontrol_open_gallery");
    }

    public final void a() {
        FragmentManager r100 = this.f59905e.getSupportFragmentManager();
        if (r100.findFragmentByTag(com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog.class.getName()) != null) goto L9;
        FragmentTransaction r101 = r100.beginTransaction();
        ReqResultFragment r102 = this.f59901a;
        String r103 = com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, 0) == true) goto L8;
        r101 = r101.add(r102, r103);
    L8:
        r101.commitNow();
        Unit r104 = Unit.INSTANCE;
    L9:
        com.bytedance.android.live.core.utils.q.l(this.f59905e, this.f59901a, 40003, f59900i, null);
    }

    public final FragmentActivity getActivity() {
        return this.f59905e;
    }

    public ReportSubmitControl(FragmentActivity r100, q.a r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "reasonInfo");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "appName");
        this.f59905e = r100;
        this.f59906f = r101;
        this.f59907g = r102;
        this.f59908h = r103;
        ReqResultFragment r104 = new ReqResultFragment();
        this.f59901a = r104;
        this.f59903c = new g();
        Function2<Integer, Intent, Unit> r105 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r105, "callback");
        r104.f59949d = r105;
    }
}
