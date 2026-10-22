package com.bytedance.applet.utils;

import com.bytedance.ai.api.OperateResult;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.b0;
import com.larus.login.api.g0;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.service.i0;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<OperateResult, String, Unit> f192313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f192314b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192315a = null;

        static {
            int[] r100 = new int[DouYinBindStatus.values().length];
            r100[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DouYinBindStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DouYinBindStatus.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f192315a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function2<? super OperateResult, ? super String, Unit> r100, Map<String, ? extends Object> r101) {
        this.f192313a = r100;
        this.f192314b = r101;
    }

    /* JADX WARN: Type inference failed for: r9v7, types: [com.bytedance.applet.utils.q] */
    @Override // com.larus.login.api.b0
    public final void a(DouYinBindStatus r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "status");
        FLogger.f375446a.i("FirstPartyAuthManager", "onDouYinBind, status:" + r100 + ", errorCode:" + r101 + ", errorMsg:" + r110);
        int r102 = a.f192315a[r100.ordinal()];
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L9;
        if (r102 == 3) goto L8;
        OperateResult r103 = OperateResult.REJECT;
    L10:
        JSONObject r104 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r105 = this.f192314b.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, Object> r106 = r105.next();
        r104.put(r106.getKey(), r106.getValue());
        goto L12
    L14:
        int r107 = a.f192315a[r100.ordinal()];
        if (r107 == 1) goto L18;
        if (r107 == 2) goto L18;
        r104.put("success", "0");
        r104.put("bind_fail_step", "douyin_verify");
    L19:
        com.larus.platform.service.o.f365780a.reportEvent("bind_with_account", r104);
        if (r103 != OperateResult.SUCCESS) goto L27;
        WeakReference<g0> r108 = o.f192308b;
        final Function2<OperateResult, String, Unit> r109 = this.f192313a;
        ?? r111 = new q(r109);
        FLogger.f375446a.i("FirstPartyAuthManager", "handleAuthSuccess, tryHeartBeatRequest with delay=0, immediate=true");
        ISdkDouyinAuth r112 = i0.a();
        if (r112 == null) goto L24;
        boolean r113 = ISdkDouyinAuth.a.a(r112, new p(r111), 4);
    L25:
        if (r113 == true) goto L30;
        r111.invoke(Boolean.FALSE);
        return;
    L30:
        return;
    L24:
        r113 = false;
        goto L25
    L27:
        this.f192313a.invoke(r103, r110);
        return;
    L18:
        r104.put("success", "1");
        goto L19
    L8:
        r103 = OperateResult.CANCEL;
    L9:
        r103 = OperateResult.SUCCESS;
        goto L10
    }
}
