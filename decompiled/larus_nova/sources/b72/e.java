package b72;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f17914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h f17915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f17916c;

    public e(Context r100, com.bytedance.android.live.base.model.message.h r101, String r102) {
        this.f17914a = r100;
        this.f17915b = r101;
        this.f17916c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Bitmap) r100, SimplayerImageStrategy.RESULT_BITMAP);
        int r101 = com.bytedance.android.livesdk.interactivity.api.expression.h.f133214a;
        return TuplesKt.to(com.bytedance.android.livesdk.interactivity.api.expression.h.a(this.f17914a, this.f17915b, this.f17916c), this.f17915b);
    }
}
