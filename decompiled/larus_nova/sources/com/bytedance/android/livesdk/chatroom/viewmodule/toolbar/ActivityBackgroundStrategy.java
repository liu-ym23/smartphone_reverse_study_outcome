package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ActivityBackgroundStrategy;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/b0;", "Landroidx/lifecycle/LifecycleObserver;", "", WidgetCostModule.TYPE_ON_START, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityBackgroundStrategy implements b0, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0<?> f115591a;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onStart() {
        a0<?> r100 = this.f115591a;
        if (r100 == null) goto L6;
        r100.tryStartNextBubble();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final boolean a(a0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        return Lifecycle.State.RESUMED.isAtLeast(Lifecycle.State.STARTED);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void b(a0<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.f115591a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void c(a0<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.f115591a = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void d(ToolbarBubbleManager.BubbleInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r100, "info");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b0
    public final void e(ToolbarBubbleManager.BubbleInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r100, "info");
    }
}
