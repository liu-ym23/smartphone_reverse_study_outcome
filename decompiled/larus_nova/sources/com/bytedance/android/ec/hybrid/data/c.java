package com.bytedance.android.ec.hybrid.data;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.gecko.KevaGeckoDataLoader;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.m;
import com.bytedance.common.utility.Logger;
import com.bytedance.forest.model.ResourceFrom;
import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements com.bytedance.android.ec.hybrid.data.gecko.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.hybrid.data.gecko.c f46653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f46655c;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHybridConfigDTO f46656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f46657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ResourceFrom f46658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f46659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f46660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f46661f;

        public a(ECHybridConfigDTO r100, c r101, ResourceFrom r102, Long r103, Map r104, String r105) {
            this.f46656a = r100;
            this.f46657b = r101;
            this.f46658c = r102;
            this.f46659d = r103;
            this.f46660e = r104;
            this.f46661f = r105;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            Lazy r100 = ECMallLogUtil.f47441a;
            ECMallLogUtil.a(m.b.f47508b, "ECHybridDataEngine#checkValidInner(), write config to keva");
            KevaGeckoDataLoader r101 = KevaGeckoDataLoader.f46704i;
            String r102 = this.f46657b.f46655c;
            String r103 = this.f46661f;
            ECHybridConfigDTO r104 = this.f46656a;
            ResourceFrom r105 = this.f46658c;
            Long r106 = this.f46659d;
            r101.getClass();
            KevaGeckoDataLoader.e(r102, r103, r104, r105, r106);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public c(d r100, String r101, String r102) {
        this.f46653a = r100;
        this.f46654b = r101;
        this.f46655c = r102;
    }

    @Override // com.bytedance.android.ec.hybrid.data.gecko.b
    public final void a(boolean r100, String r110, ResourceFrom r111, Long r112, Map<String, Object> r113) {
        String r101 = null;
        if (r100 == true) goto L56;
        com.bytedance.android.ec.hybrid.data.gecko.c r102 = this.f46653a;
        Throwable r114 = new Throwable(r110);
        if (r111 == null) goto L7;
        r101 = r111.name();
    L7:
        r102.a(r114, r101, r112);
        return;
    L56:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl((ECHybridConfigDTO) new Gson().fromJson(r110, ECHybridConfigDTO.class));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == false) goto L16;
        r104 = null;
    L16:
        ECHybridConfigDTO r105 = (ECHybridConfigDTO) r104;
        if (r105 == null) goto L51;
        String r106 = r105.getMinSupportAppVersion();
        if (r106 != null) goto L25;
        com.bytedance.android.ec.hybrid.data.gecko.c r107 = this.f46653a;
        Throwable r115 = new Throwable("illegal gecko data");
        if (r111 == null) goto L23;
        r101 = r111.name();
    L23:
        r107.a(r115, r101, r112);
        return;
    L25:
        int r108 = com.bytedance.android.ec.hybrid.data.utils.b.a(this.f46654b, r106);
        Logger.d("ECHybridDataEngine", "appVersion: " + this.f46654b + ", minVersion: " + r106 + ", compareResult: " + r108);
        if (r108 < 0) goto L46;
        com.bytedance.android.ec.hybrid.data.gecko.c r109 = this.f46653a;
        if (r111 == null) goto L30;
        String r116 = r111.name();
    L31:
        r109.c(r116, r112, r105, r113);
        ECHybridDataEngine.b r117 = ECHybridDataEngine.f46626x;
        r117.getClass();
        if (ECHybridDataEngine.b.b() == true) goto L34;
        return;
    L34:
        if (((Boolean) ECHybridDataEngine.f46620r.getValue()).booleanValue() == true) goto L59;
        if (r113 == null) goto L37;
        Object r118 = r113.get("is_from_keva");
    L39:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L41;
        ECHybridDataEngine.b.a(r117, this.f46655c, this.f46654b);
        return;
    L41:
        if (r111 == null) goto L44;
        r101 = r111.name();
    L44:
        if (StringsKt.equals(String.valueOf(r101), "gecko", true) == false) goto L61;
        Single.fromCallable(new a(r105, this, r111, r112, r113, r110)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        return;
    L61:
        return;
    L37:
        r118 = null;
        goto L39
    L59:
        return;
    L30:
        r116 = null;
        goto L31
    L46:
        com.bytedance.android.ec.hybrid.data.gecko.c r119 = this.f46653a;
        Throwable r120 = new Throwable("minVersion is: " + r106 + ", appVersion is: " + this.f46654b);
        if (r111 == null) goto L49;
        r101 = r111.name();
    L49:
        r119.a(r120, r101, r112);
        return;
    L51:
        com.bytedance.android.ec.hybrid.data.gecko.c r121 = this.f46653a;
        Throwable r122 = new Throwable(r110);
        if (r111 == null) goto L54;
        r101 = r111.name();
    L54:
        r121.a(r122, r101, r112);
        return;
    L11:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
