package com.bytedance.android.shopping.deepfeed.data.repo;

import android.content.Context;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoEarlyWarmCenter;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends fe3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f173195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f173196d;

    public final void a() {
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r100 = DeepFeedSliceVideoEarlyWarmCenter.f173641a;
        Context r101 = this.f173195c;
        List r102 = this.f173196d;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "products");
        tc3.c r103 = tc3.d.f545399a;
        if (r103.a() == true) goto L6;
        r103 = null;
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.b() != null) goto L11;
        return;
    L11:
        if (r103.b().longValue() <= 0) goto L44;
        int r104 = 0;
        int r105 = RangesKt.coerceAtLeast(r103.c(), 0);
        if (r105 == 0) goto L45;
        Iterator r106 = r102.iterator();
    L18:
        if (r106.hasNext() == false) goto L46;
        Object r107 = r106.next();
        int r108 = r104 + 1;
        if (r104 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        InFeedProductV2 r109 = (InFeedProductV2) r107;
        if (r104 <= (-1)) goto L34;
        if (r104 > ((-1) + r105)) goto L34;
        if (r109.isSkeletonData() == true) goto L34;
        com.bytedance.android.shopping.deepfeed.slice.view.video.c r110 = DeepFeedSliceVideoEarlyWarmCenter.c(r109);
        if (r110 == null) goto L34;
        DeepFeedSliceVideoEarlyWarmCenter.e(r101, r110, r103.f());
        if (r103.e() == false) goto L34;
        DeepFeedSliceVideoEarlyWarmCenter.f(r101, r110);
    L34:
        r104 = r108;
        goto L18
    L46:
        return;
    L45:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(Context r100, List r101) {
        this.f173195c = r100;
        this.f173196d = r101;
    }
}
