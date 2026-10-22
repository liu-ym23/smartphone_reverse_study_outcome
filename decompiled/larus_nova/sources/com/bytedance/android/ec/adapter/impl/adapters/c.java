package com.bytedance.android.ec.adapter.impl.adapters;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdkapi.CommerceFragmentDispatcher;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements com.bytedance.android.ec.adapter.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommerceFragmentDispatcher f42751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f42752b = null;

    public c() {
    }

    static {
        f42752b = new c();
        f42751a = CommerceFragmentDispatcher.INSTANCE;
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void a(ECBaseDialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        f42751a.onCreate(r100);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onActivityCreated(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        f42751a.onActivityCreated(r100);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroy(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        f42751a.onDestroy(r100);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDestroyView(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onDestroyView(r100, r101);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onDismiss(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onDismiss(r100, r101);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onPause(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onPause(r100, r101);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onResume(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onResume(r100, r101);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStart(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onStart(r100, r101);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onStop(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onStop(r100, r101);
    }

    @Override // com.bytedance.android.ec.adapter.api.e
    public final void onViewCreated(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        f42751a.onViewCreated(r100, r101);
    }
}
