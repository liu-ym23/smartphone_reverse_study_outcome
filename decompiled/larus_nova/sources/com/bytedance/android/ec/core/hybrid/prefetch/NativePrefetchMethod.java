package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.common.utility.Logger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativePrefetchMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f44213f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44214e;

    public static final class a {
        public static void a(ECBaseBridgeMethod.a r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "$this$onFinish");
            Intrinsics.checkNotNullParameter(r101, "errMsg");
            Intrinsics.checkNotNullParameter(r102, "data");
            JSONObject r103 = new JSONObject();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
            r103.putOpt("code", 0);     // Catch: Throwable -> L5
            r103.putOpt("status", 2);     // Catch: Throwable -> L5
            r103.putOpt("errorMessage", r101);     // Catch: Throwable -> L5
            Result.m9449constructorimpl(r103.putOpt("data", r102));     // Catch: Throwable -> L5
        L7:
            r100.a(r103);
            return;
        L5:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class b implements ECBaseBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NativePrefetchMethod f44215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECBaseBridgeMethod.a f44216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f44217c;

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void a(JSONObject r100) {
            NativePrefetchMethod r101 = this.f44215a;
            JSONObject r102 = this.f44217c;
            int r103 = NativePrefetchMethod.f44213f;
            r101.getClass();
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
            boolean r105 = false;
            if (r102 == null) goto L6;
            Integer r106 = Integer.valueOf(r102.optInt("jsb_invoke_back_mode", 0));     // Catch: Throwable -> L17
        L8:
            if (r106 != null) goto L10;
        L12:
            if (r105 == false) goto L15;
            if (r100 == null) goto L15;
            r100.putOpt("__jsb_invoke_back_mode", 1);     // Catch: Throwable -> L17
        L15:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            this.f44216b.a(r100);
            return;
        L10:
            if (r106.intValue() <= 0) goto L12;
            r105 = true;
            goto L12
        L6:
            r106 = null;
        L17:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L19
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void b(Object r100) {
            this.f44216b.b(r100);
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void onSuccess(Object r100) {
            this.f44216b.onSuccess(r100);
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void onFailed(int r100, String r101) {
            this.f44216b.onFailed(r100, r101);
        }

        public b(NativePrefetchMethod r100, ECBaseBridgeMethod.a r101, JSONObject r102) {
            this.f44215a = r100;
            this.f44216b = r101;
            this.f44217c = r102;
        }
    }

    static {
    }

    public NativePrefetchMethod() {
        this(0);
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44214e;
    }

    public NativePrefetchMethod(int r100) {
        Intrinsics.checkNotNullParameter("nativePrefetch", "name");
        this.f44214e = "nativePrefetch";
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("requestId");
        String r103 = r100.optString("api_key");
        boolean r104 = r100.optBoolean("fix_callback", false);
        if (com.bytedance.forest.utils.h.a(r102) == true) goto L5;
    L45:
        Logger.i("NativePrefetchMethod", "get data error request id is " + r102 + ", api_key is " + r103);
        if (r104 == false) goto L52;
        a.a(r101, "invalid params! request_id=" + r102 + ", api_key=" + r103, new JSONObject());
        return;
    L52:
        return;
    L5:
        if (com.bytedance.forest.utils.h.a(r103) == false) goto L45;
        ConcurrentHashMap<String, NativePrefetch> r105 = NativePrefetchUtil.f44218a;
        b r106 = new b(this, r101, r100);
        Intrinsics.checkNotNullParameter(r102, "requestId");
        Intrinsics.checkNotNullParameter(r103, "apiKey");
        Intrinsics.checkNotNullParameter(r106, "callback");
        NativePrefetch r107 = NativePrefetchUtil.f44218a.get(r102);
        if (r107 != null) goto L10;
        if (r104 == false) goto L10;
        a.a(r106, "prefetch task not found! request_id=" + r102 + ", api_key=" + r103, new JSONObject());
        return;
    L10:
        if (r107 == null) goto L51;
        monitor-enter(r107);
        Intrinsics.checkNotNullParameter(r103, "apiKey");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r106, "callback");     // Catch: Throwable -> L42
        q r108 = r107.r(r103);     // Catch: Throwable -> L42
        r108.e(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
        NativePrefetch.a r109 = (NativePrefetch.a) ((LinkedHashMap) r107.f44187c).get(r103);     // Catch: Throwable -> L42
        if (r109 == null) goto L16;
        r109.f44195c = r108;     // Catch: Throwable -> L42
    L16:
        if (r107.f44187c.containsKey(r103) == false) goto L39;
        NativePrefetch.a r110 = (NativePrefetch.a) ((LinkedHashMap) r107.f44187c).get(r103);     // Catch: Throwable -> L42
        if (r110 == null) goto L20;
        o r111 = r110.f44194b;     // Catch: Throwable -> L42
    L21:
        if (r111 != null) goto L25;
        NativePrefetch.a r112 = (NativePrefetch.a) ((LinkedHashMap) r107.f44187c).get(r103);     // Catch: Throwable -> L42
        if (r112 == null) goto L36;
        r112.f44193a = r106;     // Catch: Throwable -> L42
    L36:
        NativePrefetch.a r113 = (NativePrefetch.a) ((LinkedHashMap) r107.f44187c).get(r103);     // Catch: Throwable -> L42
        if (r113 == null) goto L40;
        r113.f44194b = null;     // Catch: Throwable -> L42
    L40:
        monitor-exit(r107);
        return;
    L25:
        int r114 = r111.f44253b;     // Catch: Throwable -> L42
        if (r114 != 1) goto L31;
        q r115 = r107.r(r103);     // Catch: Throwable -> L42
        r115.d(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
        NativePrefetch.a r116 = (NativePrefetch.a) ((LinkedHashMap) r107.f44187c).get(r103);     // Catch: Throwable -> L42
        if (r116 == null) goto L30;
        r116.f44195c = r115;     // Catch: Throwable -> L42
    L30:
        r107.G(r103, r111, r106);     // Catch: Throwable -> L42
        goto L36
    L31:
        Integer r117 = Integer.valueOf(r114);     // Catch: Throwable -> L42
        if (r117 == null) goto L34;
        int r118 = r117.intValue();     // Catch: Throwable -> L42
    L35:
        r107.l(r103, r118, r106, "");     // Catch: Throwable -> L42
        goto L36
    L34:
        r118 = 2;
        goto L35
    L20:
        r111 = null;
        goto L21
    L39:
        r107.l(r103, 3, r106, "not find this request id");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }
}
