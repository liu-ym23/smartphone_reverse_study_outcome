package com.bytedance.android.livesdk.gift.grouplive.component.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupComponentRepo f126335a;

    public a(GroupComponentRepo r100) {
        this.f126335a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return GroupComponentRepo.a(this.f126335a, (List) r101.data, System.currentTimeMillis());
    }
}
