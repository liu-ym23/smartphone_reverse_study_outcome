package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f177871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ToolVO f177872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ToolListAdapter f177873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f177874d;

    public g(int r100, ToolVO r101, ToolListAdapter r102, Map r103) {
        this.f177871a = r100;
        this.f177872b = r101;
        this.f177873c = r102;
        this.f177874d = r103;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        h r100 = this.f177873c.f177826b;
        int r101 = this.f177871a;
        ToolVO r102 = this.f177872b;
        Map r103 = this.f177874d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "globalProps");
        kk.d.c(new ToolReporter$reportItemShow$1(r100, r102, r101, r103));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
