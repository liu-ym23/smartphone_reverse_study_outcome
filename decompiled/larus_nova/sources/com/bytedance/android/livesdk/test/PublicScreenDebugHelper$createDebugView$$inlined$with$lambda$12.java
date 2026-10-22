package com.bytedance.android.livesdk.test;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/test/PublicScreenDebugHelper$createDebugView$1$2$3$3", "com/bytedance/android/livesdk/test/PublicScreenDebugHelper$$special$$inlined$linear$lambda$12", "com/bytedance/android/livesdk/test/PublicScreenDebugHelper$$special$$inlined$block$lambda$12"}, k = 3, mv = {1, 4, 3})
final class PublicScreenDebugHelper$createDebugView$$inlined$with$lambda$12 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ CompositeDisposable $cd$inlined;
    final /* synthetic */ d $plugin$inlined;
    final /* synthetic */ l $publicScreenContext$inlined;

    public PublicScreenDebugHelper$createDebugView$$inlined$with$lambda$12(l r100, CompositeDisposable r101, d r102) {
        this.$publicScreenContext$inlined = r100;
        this.$cd$inlined = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        throw null;
    }
}
