package androidx.compose.material3.internal;

import S7.k;
import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AccessibilityServiceStateProvider_androidKt$ObserveState$3$1 extends Lambda implements k {
    final /* synthetic */ k $handleEvent;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ S7.a $onDispose;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityServiceStateProvider_androidKt$ObserveState$3$1(LifecycleOwner lifecycleOwner, k kVar, S7.a aVar) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$handleEvent = kVar;
        this.$onDispose = aVar;
    }

    @Override // S7.k
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        final k kVar = this.$handleEvent;
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.compose.material3.internal.a
            @Override // android.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                kVar.invoke(event);
            }
        };
        this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        final S7.a aVar = this.$onDispose;
        final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$ObserveState$3$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                aVar.invoke();
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }
}
