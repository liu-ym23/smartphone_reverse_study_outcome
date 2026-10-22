package com.bytedance.android.live.liveinteract.widget.widget;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkUserFollowGuideDialog f81088a;

    public r(LinkUserFollowGuideDialog r100) {
        this.f81088a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "sec");
        return Long.valueOf(((long) this.f81088a.f81003b) - r101.longValue());
    }
}
