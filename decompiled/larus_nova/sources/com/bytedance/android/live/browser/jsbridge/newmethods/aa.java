package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "liveLoading")
public final class aa extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.utils.k5 f63298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f63299b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f63299b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        com.bytedance.android.livesdk.utils.k5 r101 = this.f63298a;
        if (r101 == null) goto L9;
        j(r101);
        return;
    }

    public aa() {
    }

    public static void j(ProgressDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = JSONObjectProtectorUtils.getString(r102, "type");
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r102, "args");
        r103.getClass();
        if (r103.equals("show") == false) goto L5;
        com.bytedance.android.livesdk.utils.k5 r105 = this.f63298a;
        if (r105 == null) goto L17;
        j(r105);
    L17:
        Context r106 = r101.getContext();
        String r107 = JSONObjectProtectorUtils.getString(r104, "message");
        com.bytedance.android.livesdk.utils.k5 r108 = new com.bytedance.android.livesdk.utils.k5(r106);
        r108.setMessage(r107);
        this.f63298a = r108;
        r108.setCancelable(false);
        com.bytedance.android.livesdk.utils.k5 r109 = this.f63298a;
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r109);
    L22:
        this.f63299b = Single.timer(8, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y9(this), new z9());
    L23:
        finishWithSuccess();
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L21:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        goto L22
    L5:
        if (r103.equals("dismiss") == false) goto L23;
        Disposable r110 = this.f63299b;
        if (r110 == null) goto L10;
        r110.dispose();
    L10:
        com.bytedance.android.livesdk.utils.k5 r111 = this.f63298a;
        if (r111 == null) goto L13;
        j(r111);
    L13:
        this.f63299b = null;
        this.f63298a = null;
        goto L23
    }
}
