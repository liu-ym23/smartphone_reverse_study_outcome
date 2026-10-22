package b09;

import android.os.Handler;
import com.bytedance.sdk.account.impl.d0;
import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import ta7.j;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {
    public /* synthetic */ a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler r100 = e.f16894a;
        if (e.f16898e == true) goto L5;
    L11:
        e.c();
        return;
    L5:
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L11;
        if (e.f16899f == true) goto L14;
        e.f16899f = true;
        int r101 = e.f16900g;
        FLogger.f375446a.i("SecurityTokenBeatScheduler", "request heartbeat");
        j r102 = d0.c();
        d0 r103 = (d0) r102;
        r103.b("/passport/doubao/security_token_beat/", null, null, new h(r101));
        return;
    }
}
