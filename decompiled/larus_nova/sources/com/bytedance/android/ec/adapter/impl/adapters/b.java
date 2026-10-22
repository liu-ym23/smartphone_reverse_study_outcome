package com.bytedance.android.ec.adapter.impl.adapters;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f42740a = null;

    public b() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void a(DialogFragment r100, FrameLayout r101, com.bytedance.android.ec.adapter.api.a r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "extra");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void c(Activity r100, com.bytedance.android.ec.adapter.api.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extra");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final boolean checkWindowConflict() {
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void e(Activity r100, com.bytedance.android.ec.adapter.api.a r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void g(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final boolean isFloatWindowShowing() {
        return false;
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void setFloatWindowBottomMargin(int r100) {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowFloat() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowFloatInNextLifecycle() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void stopShowNow() {
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final void toggleLiveAudio(boolean r100) {
    }

    static {
        f42740a = new b();
    }

    @Override // com.bytedance.android.ec.adapter.api.j
    public final Object f(com.bytedance.android.ec.model.j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        return new Object();
    }
}
