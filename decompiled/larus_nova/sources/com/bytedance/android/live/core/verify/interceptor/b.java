package com.bytedance.android.live.core.verify.interceptor;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements t80.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f66479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t80.a f66480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f66481c;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f66482a = null;

        static {
            f66482a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    @Override // t80.a
    public final void onVerifyResult(int r100) {
        ALogger.i("MinorInterceptor", "verify with old live certification，verifyTypes: " + this.f66479a + ", resultCode：" + r100);
        t80.a r101 = this.f66480b;
        if (r101 == null) goto L7;
        r101.onVerifyResult(r100);
        return;
    L7:
        if (r100 != 3) goto L9;
    L18:
        int r102 = do0.a.f469399a;
        do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_RESULT, r100, "", "", "");
        return;
    L9:
        if (r100 != 2) goto L18;
        Activity r103 = this.f66481c;
        String r104 = s1.B(R.string.ttlive_minor_intercept_content);
        String r105 = s1.B(R.string.ttlive_I_know);
        a r106 = a.f66482a;
        x0.d r107 = new x0.d();
        r107.f162243b = r103;
        r107.f162242a = 0;
        r107.f162245d = r104;
        x0.c[] r108 = r107.f162248g;
        x0.c r109 = r108[0];
        if (r109 != null) goto L13;
        r109 = new x0.c();
        r108[0] = r109;
    L13:
        r109.f162239a = r105;
        r109.f162240b = r106;
        x0 r110 = new x0(r107.f162243b, r107);
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r110);
        goto L18
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L18
    }

    public b(int r100, t80.a r101, Activity r102) {
        this.f66479a = r100;
        this.f66480b = r101;
        this.f66481c = r102;
    }
}
