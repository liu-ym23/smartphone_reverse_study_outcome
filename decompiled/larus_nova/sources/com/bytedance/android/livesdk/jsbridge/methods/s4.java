package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "live.updateCacheData", owner = "chenweizhuo@bytedance.com")
public final class s4 extends u<t4, UpdateCacheDataResultModel> {
    public s4() {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r12v13, types: [T, io.reactivex.disposables.Disposable] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        t4 r112 = (t4) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r113 = r112.b();
        String r100 = r112.a();
        if (r113 == null) goto L15;
        if (r100 == null) goto L15;
        Integer r114 = r112.c();
        int r101 = com.bytedance.android.live.schema.helper.f.f100518a;
        if (r114 == null) goto L9;
        long r102 = r114.intValue();
    L10:
        Intrinsics.checkNotNullParameter(r113, "key");
        Intrinsics.checkNotNullParameter(r100, "data");
        Keva r115 = Keva.getRepo("lynx_common_cache");
        Keva r103 = Keva.getRepo("lynx_cache_valid_time");
        r115.storeString(r113, r100);
        if (r102 != 0) goto L13;
        r102 = 86400;
        long r104 = System.currentTimeMillis() / ((long) 1000);
    L14:
        r103.storeLong(r113, r102 + r104);
        Keva r116 = Keva.getRepo("lynx_cache_valid_time");
        Ref.ObjectRef r117 = new Ref.ObjectRef();
        r117.element = Disposables.disposed();
        r117.element = Single.just(Long.valueOf(r116.getLong("last_clean_timestamp", 0))).flatMapCompletable(new com.bytedance.android.live.schema.helper.b(r116)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).doOnComplete(new com.bytedance.android.live.schema.helper.c(r117)).subscribe(com.bytedance.android.live.schema.helper.d.f100516a, com.bytedance.android.live.schema.helper.e.f100517a);
        finishWithSuccess();
        return;
    L13:
        r104 = System.currentTimeMillis() / ((long) 1000);
        goto L14
    L9:
        r102 = 0;
    L15:
        finishWithFailure();
    }
}
