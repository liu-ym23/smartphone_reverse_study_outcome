package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CharSequence f135300a;

    public b(CharSequence r100) {
        this.f135300a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d r102 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.model.d) r101.data;
        if (r102 == null) goto L5;
        r102.f133482a = this.f135300a.toString();
    L5:
        return r101;
    }
}
