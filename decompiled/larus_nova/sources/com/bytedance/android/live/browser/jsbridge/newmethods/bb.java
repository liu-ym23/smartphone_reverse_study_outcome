package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "requestOrientationPermission")
public final class bb extends r<cb, RequestOrientationPermissionResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.web.jsbridge2.d0 f63324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IHybridComponent f63325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TokenCert f63326c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        l30.d.f507219h.c();
        this.f63324a = null;
        this.f63325b = null;
    }

    public bb(com.bytedance.ies.web.jsbridge2.d0 r100) {
        this.f63324a = r100;
        this.f63326c = TokenCert.Companion.with("bpea-requestOrientationPermission_jsb_request_gyroscope_orientation");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        cb r102 = (cb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r103 = r102.a();
        Integer r104 = r102.b();
        if (r104 == null) goto L5;
        long r105 = r104.intValue();
    L7:
        if (r105 >= 10) goto L9;
        r105 = 10;
    L9:
        String r106 = r102.c();
        if (r106 == null) goto L13;
        TokenCert r107 = TokenCert.Companion.with(r106);
        if (r107 == null) goto L13;
    L15:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == true) goto L17;
    L43:
        l30.d.f507219h.c();
    L44:
        finishWithSuccess();
        return;
    L17:
        if (r105 < 0) goto L43;
        l30.d r108 = l30.d.f507219h;
        Context r109 = r101.getContext();
        int r110 = (int) r105;
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r107, "tokenCert");
        r108.c();
        if (l30.d.f507212a != null) goto L26;
        Object r111 = r109.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);
        if (r111 == null) goto L24;
        l30.d.f507212a = (SensorManager) r111;
        goto L26
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    L26:
        if (l30.d.f507213b != null) goto L32;
        SensorManager r112 = l30.d.f507212a;
        if (r112 == null) goto L30;
        Sensor r113 = g80.f.a(r112, 15, r107);
    L31:
        l30.d.f507213b = r113;
        goto L32
    L30:
        r113 = null;
    L32:
        SensorManager r114 = l30.d.f507212a;
        if (r114 == null) goto L35;
        r114.registerListener(r108, l30.d.f507213b, r110 * 1000);
    L35:
        com.bytedance.ies.web.jsbridge2.d0 r115 = this.f63324a;
        IHybridComponent r116 = this.f63325b;
        Disposable r117 = l30.d.f507218g;
        if (r117 != null) goto L38;
    L42:
        com.bytedance.android.live.core.utils.rxutils.j.a r118 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        l30.d.f507218g = com.bytedance.android.live.core.utils.rxutils.j.c(r105, TimeUnit.MILLISECONDS).subscribe(new l30.b(r115, r116), l30.c.f507211a);
        goto L44
    L38:
        if (r117.isDisposed() == true) goto L42;
        Disposable r119 = l30.d.f507218g;
        if (r119 == null) goto L42;
        r119.dispose();
    L13:
        r107 = this.f63326c;
        goto L15
    L5:
        r105 = 100;
        goto L7
    }
}
