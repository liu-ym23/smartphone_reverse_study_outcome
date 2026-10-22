package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f77318a;

    public e(a r100) {
        this.f77318a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        final Map r101 = (Map) r100;
        UtilityKotlinExtentionsKt.s(0, false, false, new MultiLinkAllPerfAbilityManager$initSourceCombined$2$1(this, r101), 7);
    }
}
