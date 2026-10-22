package b72;

import android.content.Context;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f17917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h f17918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f17919c;

    public f(Context r100, com.bytedance.android.live.base.model.message.h r101, String r102) {
        this.f17917a = r100;
        this.f17918b = r101;
        this.f17919c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Throwable) r100, "it");
        int r101 = com.bytedance.android.livesdk.interactivity.api.expression.h.f133214a;
        return TuplesKt.to(com.bytedance.android.livesdk.interactivity.api.expression.h.a(this.f17917a, this.f17918b, this.f17919c), this.f17918b);
    }
}
