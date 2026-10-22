package com.bytedance.android.live.core.tetris.template.delegate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import h70.b;
import j70.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l70.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\b\u001a\u00020\u0007H\u0017J\b\u0010\t\u001a\u00020\u0007H\u0017J\b\u0010\n\u001a\u00020\u0007H\u0017J\b\u0010\u000b\u001a\u00020\u0007H\u0017J\b\u0010\f\u001a\u00020\u0007H\u0017J\b\u0010\r\u001a\u00020\u0007H\u0017¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/core/tetris/template/delegate/BaseTemplateDelegate;", "Lh70/b;", "C", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "", "Lcom/bytedance/android/live/core/tetris/layer/core/data/b;", "", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTemplateDelegate<C extends b> implements LifecycleOwnerCompat, LifecycleObserver, com.bytedance.android.live.core.tetris.layer.core.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.data.b f65929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C f65930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<f, Element<?>> f65931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<f, a<C>> f65932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleRegistry f65933e;

    public abstract void a(Element<?> r100);

    public abstract void b(Element<?> r100);

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f65933e.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f65933e.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.f65933e.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f65933e.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f65933e.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f65933e.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public BaseTemplateDelegate() {
        this.f65931c = new LinkedHashMap();
        this.f65932d = new LinkedHashMap();
        this.f65933e = new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f65933e;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
    public final <T extends ViewModel> T getViewModel(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        com.bytedance.android.live.core.tetris.layer.core.data.b r101 = this.f65929a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return (T) r101.getViewModel(r100);
    }
}
