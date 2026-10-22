package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.depend.IScanResultHandler;
import com.bytedance.android.livehostapi.platform.depend.QrScanResult;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class nb implements IScanResultHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ob f63573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w20.sd f63574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallContext f63575c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ nb f63576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f63577b;

        public a(nb r100, JSONObject r101) {
            this.f63576a = r100;
            this.f63577b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f63576a.f63573a.finishWithResult(this.f63577b);     // Catch: Throwable -> L4
            ALogger.i("ScanCodeMethod", "finishWithResult： " + this.f63577b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IScanResultHandler
    public final String getMobLoadingPage() {
        return "live_ScanCodeMethod";
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.IScanResultHandler
    public final boolean handleResult(QrScanResult r100) {
        if (r100 != null) goto L6;
        this.f63573a.finishWithFailure();
        return false;
    L6:
        if (Intrinsics.areEqual(this.f63574b.b(), Boolean.TRUE) == false) goto L8;
        r100.getExtraParam().putBoolean(QrScanResult.DISABLE_BRIDGE_AUTO_JUMP, true);
    L8:
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        r102.put("result", r100.getResult());
        r101.put("data", r102);
        r101.put("code", 1);
        View r103 = this.f63575c.f249269d;
        if (r103 == null) goto L11;
        r103.post(new a(this, r101));
    L11:
        return true;
    }

    public nb(ob r100, w20.sd r101, CallContext r102) {
        this.f63573a = r100;
        this.f63574b = r101;
        this.f63575c = r102;
    }
}
