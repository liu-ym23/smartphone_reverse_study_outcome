package com.bytedance.android.livesdk.floatview;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class a implements IDialogFragmentLifecycle {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public final void onActivityCreated(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public final void onCreate(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onDestroy(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public final void onDestroyView(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public final void onDismiss(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onPause(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onResume(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onStart(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onStop(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public final void onViewCreated(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
    }
}
