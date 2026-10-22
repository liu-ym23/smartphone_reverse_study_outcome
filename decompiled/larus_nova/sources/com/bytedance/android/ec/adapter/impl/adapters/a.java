package com.bytedance.android.ec.adapter.impl.adapters;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements com.bytedance.android.ec.adapter.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f42739a = null;

    public a() {
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void a(ECBaseDialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onActivityCreated(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroy(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroyView(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDismiss(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onPause(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onResume(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStart(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStop(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onViewCreated(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    static {
        f42739a = new a();
    }
}
