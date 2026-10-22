package com.bytedance.android.shopping.mall.feed.help;

import android.os.Build;
import android.os.Debug;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.ss.android.common.lib.AppLogNewUtils;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f176973e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f176974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f176975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECHybridListEngine f176976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f176977d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.help.a$a, reason: collision with other inner class name */
    public static final class C2624a {
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f176978a;

        public b(a r100) {
            this.f176978a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final Result<? extends Unit> call() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
            if (Build.VERSION.SDK_INT <= 23) goto L12;
            long r101 = Runtime.getRuntime().totalMemory();     // Catch: Throwable -> L14
            long r102 = Runtime.getRuntime().maxMemory();     // Catch: Throwable -> L14
            double r103 = r101 / r102;     // Catch: Throwable -> L14
            ECHybridListEngine r104 = this.f176978a.f176976c;     // Catch: Throwable -> L14
            int r105 = 0;
            if (r104 == null) goto L7;
            int r106 = r104.i();     // Catch: Throwable -> L14
        L8:
            Integer r107 = StringsKt.toIntOrNull(Debug.getRuntimeStat("art.gc.gc-count"));     // Catch: Throwable -> L14
            if (r107 == null) goto L11;
            r105 = r107.intValue();     // Catch: Throwable -> L14
        L11:
            JSONObject r108 = new JSONObject();     // Catch: Throwable -> L14
            r108.putOpt("used_memory", Long.valueOf(r101));     // Catch: Throwable -> L14
            r108.putOpt("max_memory", Long.valueOf(r102));     // Catch: Throwable -> L14
            r108.putOpt("used_percent", Double.valueOf(r103));     // Catch: Throwable -> L14
            r108.putOpt("item_count", Integer.valueOf(r106));     // Catch: Throwable -> L14
            r108.putOpt("gc_count", Integer.valueOf(r105 - this.f176978a.f176974a));     // Catch: Throwable -> L14
            r108.putOpt("page_name", this.f176978a.f176977d);     // Catch: Throwable -> L14
            AppLogNewUtils.onEventV3("ec_mall_memory_monitor", r108);     // Catch: Throwable -> L14
            goto L12
        L7:
            r106 = 0;
        L12:
            Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L17:
            return Result.m9448boximpl(r109);
        L14:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L17
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        int r100 = s93.c.f541066a;
        Object r101 = 50;
        IHybridHostService r102 = com.bytedance.android.ec.hybrid.a.h();
        if (r102 == null) goto L10;
        yj.g r103 = r102.getHostAB();
        if (r103 == null) goto L10;
        Object r104 = r103.a("mall_memory_check_item_interval", r101);
        if (r104 == null) goto L10;
        r101 = r104;
    L10:
        Lazy r105 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : mall_memory_check_item_interval, Value: " + r101);
        f176973e = ((Number) r101).intValue();
    }

    public final void a() {
        Single.fromCallable(new b(this)).subscribeOn(Schedulers.single()).subscribe();
    }

    public a(ECHybridListEngine r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pageName");
        this.f176976c = r100;
        this.f176977d = r101;
    }
}
