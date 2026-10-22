package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Deprecated(message = "using for ppx")
@XBridgeMethod(biz = "webcast", name = "openZmCert")
public final class ge extends com.bytedance.ies.web.jsbridge2.f<b30.g0, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f63406a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f63406a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public ge() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(b30.g0 r100, CallContext r101) {
        b30.g0 r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L27;
        String r106 = r102.a();
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == true) goto L27;
        String r108 = r102.c();
        if (r108 != null) goto L21;
    L24:
        if (r104 == true) goto L27;
        this.f63406a = xs2.b.a().b(b30.h0.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new ee(this), new fe(this));
        xs2.b.a().post(r102);
        return;
    L21:
        if (r108.length() == 0) goto L24;
        r104 = false;
        goto L24
    L13:
        if (r106.length() == 0) goto L16;
        r107 = false;
    L27:
        finishWithFailure();
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
