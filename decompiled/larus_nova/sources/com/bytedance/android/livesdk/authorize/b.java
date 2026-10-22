package com.bytedance.android.livesdk.authorize;

import com.bytedance.android.live.user.VcdAuthorizationSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VcdAuthorizationSource f104201a;

    public b(VcdAuthorizationSource r100) {
        this.f104201a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new com.bytedance.android.live.user.a(this.f104201a, r101.booleanValue());
    }
}
