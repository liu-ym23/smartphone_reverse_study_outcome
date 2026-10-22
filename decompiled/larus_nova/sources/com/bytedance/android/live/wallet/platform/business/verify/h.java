package com.bytedance.android.live.wallet.platform.business.verify;

import android.app.Activity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.e4;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements ObservableTransformer<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f102729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f102730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f102731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f102732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f102733e;

    @Override // io.reactivex.ObservableTransformer
    public final ObservableSource<T> apply(Observable<T> r100) {
        du2.a r101 = (du2.a) r100.as(new du2.b());
        Function r102 = new b(this);
        r101.getClass();
        return RxJavaPlugins.onAssembly(new ObservableRetryWhen(r101.f470023a, r102));
    }

    public h(Activity r100, Map<String, Object> r101) {
        this.f102729a = e4.a();
        this.f102730b = false;
        this.f102731c = r100;
        this.f102732d = r101;
        this.f102733e = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
    }

    public final void b(boolean r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("user_id", this.f102733e);
        if (r100 == false) goto L5;
        String r103 = "pass";
    L6:
        r102.put("certification_result", r103);
        r102.put("failure_reason", r101);
        ed1.a.a("livesdk_real_name_authentication_result_return", r102);
        return;
    L5:
        r103 = "fail";
        goto L6
    }

    public final void a(com.bytedance.android.live.wallet.model.k r100, boolean r101, PublishSubject<Integer> r110, ApiServerException r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.d() != null) goto L6;
        return;
    L6:
        if (r100.c() == null) goto L14;
        int r102 = a.f102713a;
        Activity r103 = this.f102731c;
        String r104 = r100.d();
        String r105 = r100.c();
        String r106 = r100.e();
        f r107 = new f(this, r101, r111, r110);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "scene");
        Intrinsics.checkNotNullParameter(r105, BytedCertConstant.CertKey.FLOW);
        ALogger.i("DiamondBuyVerifier", "start to verify with certification version 3.0");
        Pair[] r108 = new Pair[3];
        r108[0] = TuplesKt.to("scene", r104);
        r108[1] = TuplesKt.to(BytedCertConstant.CertKey.FLOW, r105);
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r108[2] = TuplesKt.to("ticket", r106);
        HashMap r109 = MapsKt.hashMapOf(r108);
        ((dr2.i) vh6.c.b(dr2.i.class)).po(r103, r109, new JSONObject(), r101, r107);
        return;
    }
}
