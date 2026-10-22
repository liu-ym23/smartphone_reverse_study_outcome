package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.base.model.user.UploadResult;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialog;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ReportSubmitControl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TokenCert f59935n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReqResultFragment f59936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f59937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f59938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UploadResult f59939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentActivity f59940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q.a f59941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f59942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f59943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f59944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f59945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f59946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f59947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OpenGameReportDialog.InnerPageParams f59948m;

    public static final class a {
    }

    static {
        f59935n = TokenCert.Companion.with("bpea-live_reportsubmitcontrol_open_gallery");
    }

    public final void a() {
        FragmentManager r100 = this.f59940e.getSupportFragmentManager();
        if (r100.findFragmentByTag(OpenGameReportSubmitDialog.class.getName()) != null) goto L9;
        FragmentTransaction r101 = r100.beginTransaction();
        ReqResultFragment r102 = this.f59936a;
        String r103 = OpenGameReportSubmitDialog.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, 0) == true) goto L8;
        r101 = r101.add(r102, r103);
    L8:
        r101.commitNow();
        Unit r104 = Unit.INSTANCE;
    L9:
        com.bytedance.android.live.core.utils.q.l(this.f59940e, this.f59936a, 40003, f59935n, null);
    }

    public final FragmentActivity getActivity() {
        return this.f59940e;
    }

    public ReportSubmitControl(FragmentActivity r100, q.a r101, String r102, long r103, String r104, boolean r105, int r106, boolean r110, OpenGameReportDialog.InnerPageParams r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "reasonInfo");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r104, "appName");
        this.f59940e = r100;
        this.f59941f = r101;
        this.f59942g = r102;
        this.f59943h = r103;
        this.f59944i = r104;
        this.f59945j = r105;
        this.f59946k = r106;
        this.f59947l = r110;
        this.f59948m = r111;
        ReqResultFragment r107 = new ReqResultFragment();
        this.f59936a = r107;
        this.f59938c = new g();
        Function2<Integer, Intent, Unit> r108 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r108, "callback");
        r107.f59949d = r108;
    }
}
