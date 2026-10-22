package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "observeShakeMobile")
public final class g8 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f63392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f63393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TokenCert f63395d;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r100, int r101) {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        SensorManager r100 = this.f63392a;
        if (r100 == null) goto L5;
        j(r100, this);
    L5:
        Disposable r101 = this.f63393b;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isDisposed() == true) goto L14;
        Disposable r102 = this.f63393b;
        if (r102 == null) goto L15;
        r102.dispose();
        return;
    L15:
        return;
    }

    public g8() {
        this.f63395d = TokenCert.Companion.with("bpea-live_observeShakeMobile_jsb_observe_shake_mobile");
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        SensorManager r100 = this.f63392a;
        if (r100 == null) goto L5;
        j(r100, this);
    L5:
        Disposable r101 = this.f63393b;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isDisposed() == true) goto L14;
        Disposable r102 = this.f63393b;
        if (r102 == null) goto L15;
        r102.dispose();
        return;
    L15:
        return;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r100) {
        if (r100 == null) goto L19;
        Sensor r101 = r100.sensor;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getType() != 1) goto L26;
        float[] r102 = r100.values;
        if (r102 == null) goto L27;
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L28;
        if (Math.abs(r102[r104]) <= 25) goto L18;
        if (this.f63394c == true) goto L18;
        this.f63394c = true;
        JSONObject r105 = new JSONObject();
        r105.put("code", 1);
        finishWithResult(r105);
        SensorManager r106 = this.f63392a;
        if (r106 == null) goto L18;
        j(r106, this);
    L18:
        r104 = r104 + 1;
        goto L10
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public static void j(SensorManager r100, SensorEventListener r101) {
        if (fna.g.d() == true) goto L6;
        r100.unregisterListener(r101);
        return;
    L6:
        r100.unregisterListener(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        ona.b.c(new ona.a(r102, null));
        return;
    L9:
        r102 = 0;
        goto L10
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r103 = r102.optLong("time", 0);
        String r104 = r102.optString("token", "");
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        TokenCert r106 = this.f63395d;
    L13:
        if (r103 > 0) goto L15;
        finishWithFailure();
        return;
    L15:
        Sensor r107 = null;
        if (this.f63392a != null) goto L22;
        Context r108 = r101.getContext();
        if (r108 == null) goto L20;
        Object r109 = r108.getSystemService(faceverify.w.BLOB_ELEM_TYPE_SENSOR);
    L21:
        this.f63392a = (SensorManager) r109;
        goto L22
    L20:
        r109 = null;
    L22:
        this.f63394c = false;
        SensorManager r110 = this.f63392a;
        if (r110 == null) goto L25;
        j(r110, this);
    L25:
        SensorManager r111 = this.f63392a;
        if (r111 == null) goto L28;
        r107 = g80.f.a(r111, 1, r106);
    L28:
        if (r107 == null) goto L32;
        SensorManager r112 = this.f63392a;
        if (r112 == null) goto L32;
        r112.registerListener(this, r107, 2);
    L32:
        this.f63393b = Observable.timer(r103, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f8(this));
        return;
    L11:
        r106 = TokenCert.Companion.with(r104);
        goto L13
    L5:
        if (StringsKt.isBlank(r104) == true) goto L8;
        r105 = false;
        goto L9
    }
}
