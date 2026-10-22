package com.bytedance.android.shopping.mall.feed.opt;

import android.content.Context;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class MallRequestEndManager implements com.bytedance.android.shopping.mall.feed.opt.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f177172b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f177173c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.mall.feed.opt.a> f177174a;

    public static final class a {
    }

    static {
        f177172b = LazyKt.lazy(MallRequestEndManager$Companion$liveOptPage$2.INSTANCE);
        f177173c = LazyKt.lazy(MallRequestEndManager$Companion$imageOptPage$2.INSTANCE);
    }

    public MallRequestEndManager(String r100) {
        ArrayList r101 = new ArrayList();
        this.f177174a = r101;
        if (((ArrayList) f177172b.getValue()).contains(r100) == false) goto L6;
        r101.add(new MallLiveCardOpt());
    L6:
        if (((ArrayList) f177173c.getValue()).contains(r100) == false) goto L9;
        r101.add(new c());
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void a(Context r100, HomePageDTO r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r102 = this.f177174a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.mall.feed.opt.a) r102.next()).a(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.shopping.mall.feed.opt.a
    public final void b(Context r100, HomePageDTO r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r102 = this.f177174a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.mall.feed.opt.a) r102.next()).b(r100, r101);
        goto L4
    }
}
