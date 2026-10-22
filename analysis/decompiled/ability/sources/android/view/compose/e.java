package android.view.compose;

import S7.k;
import android.view.LifecycleOwner;
import android.view.OnBackPressedCallback;
import android.view.OnBackPressedDispatcher;
import androidx.compose.runtime.DisposableEffectScope;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1661a;
    public final /* synthetic */ OnBackPressedDispatcher b;
    public final /* synthetic */ LifecycleOwner c;
    public final /* synthetic */ OnBackPressedCallback d;

    public /* synthetic */ e(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback, int i) {
        this.f1661a = i;
        this.b = onBackPressedDispatcher;
        this.c = lifecycleOwner;
        this.d = onBackPressedCallback;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1661a) {
            case 0:
                return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$7$lambda$6(this.b, this.c, (PredictiveBackHandlerCallback) this.d, (DisposableEffectScope) obj);
            default:
                return BackHandlerKt.BackHandler$lambda$7$lambda$6(this.b, this.c, (BackHandlerKt$BackHandler$backCallback$1$1) this.d, (DisposableEffectScope) obj);
        }
    }
}
