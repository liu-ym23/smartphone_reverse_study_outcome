package com.bytedance.android.live.ktv.common.search.view;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonSearchContainer f70308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f70309b;

    public h(CommonSearchContainer r100, List r101) {
        this.f70308a = r100;
        this.f70309b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        CommonSearchResultView r101 = CommonSearchContainer.b(this.f70308a);
        if (r101 == null) goto L6;
        r101.a(this.f70309b);
        return;
    }
}
