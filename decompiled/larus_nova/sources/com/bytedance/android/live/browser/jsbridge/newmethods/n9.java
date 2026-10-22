package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openHostVerify")
public final class n9 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f63567a;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallContext f63568a;

        public a(CallContext r100) {
            this.f63568a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CallContext r101 = this.f63568a;
            JSONObject r102 = new JSONObject();
            ((b30.s) r100).getClass();
            r102.put("code", 0);
            Unit r103 = Unit.INSTANCE;
            r101.b("H5_signStatus", r102);
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f63567a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public n9() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r102 = ContextUtil.contextToActivity(r101.getContext());
        if (r102 != null) goto L6;
        finishWithFailure();
        return;
    L6:
        r102.startActivity(((IHostVerify) jc1.k.n(IHostVerify.class)).getVerifyActivityIntent(r102));
        this.f63567a = xs2.b.a().b(b30.s.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r101));
        xs2.b.a().post(b30.r.class);
    }
}
