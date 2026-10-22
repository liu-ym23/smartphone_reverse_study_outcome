package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolListAdapter f177868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f177869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ToolVO f177870c;

    public f(ToolListAdapter r100, int r101, ToolVO r102) {
        this.f177868a = r100;
        this.f177869b = r101;
        this.f177870c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        Logger.d("ToolListAdapter", "reportToolItemOnScroll newShowIndex=" + this.f177869b);
        final h r100 = this.f177868a.f177826b;
        final int r101 = this.f177869b;
        final ToolVO r102 = this.f177870c;
        r100.getClass();
        kk.d.c(new ToolReporter$reportItemShow$2(r100, r102, r101));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
