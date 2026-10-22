package com.bytedance.android.live.liveinteract.revenue.fight.view;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TeamFightPKProgressLayout f78277a;

    public c(TeamFightPKProgressLayout r100) {
        this.f78277a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        UtilityKotlinExtentionsKt.t(this.f78277a.f78236z);
        this.f78277a.f78219i = false;
    }
}
