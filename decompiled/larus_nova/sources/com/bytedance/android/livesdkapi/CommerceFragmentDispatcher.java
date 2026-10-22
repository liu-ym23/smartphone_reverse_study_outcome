package com.bytedance.android.livesdkapi;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/CommerceFragmentDispatcher;", "Lcom/bytedance/android/livesdkapi/service/IDialogFragmentLifecycle;", "()V", "listeners", "", "onActivityCreated", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/DialogFragment;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", "rootView", "Landroid/widget/FrameLayout;", "onDismiss", "onPause", "onResume", WidgetCostModule.TYPE_ON_START, "onStop", "onViewCreated", "registerListener", "listener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceFragmentDispatcher implements IDialogFragmentLifecycle {
    public static final CommerceFragmentDispatcher INSTANCE = null;
    private static final List<IDialogFragmentLifecycle> listeners = null;

    private CommerceFragmentDispatcher() {
    }

    static {
        INSTANCE = new CommerceFragmentDispatcher();
        listeners = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onActivityCreated(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Iterator<T> r101 = listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r101.next()).onActivityCreated(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onCreate(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Iterator<T> r101 = listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r101.next()).onCreate(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onDestroy(DialogFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Iterator<T> r101 = listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r101.next()).onDestroy(r100);
        goto L4
    }

    public final void registerListener(IDialogFragmentLifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<IDialogFragmentLifecycle> r101 = listeners;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onDestroyView(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onDestroyView(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onDismiss(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onDismiss(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onPause(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onPause(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onResume(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onResume(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onStart(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onStart(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onStop(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onStop(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle
    public void onViewCreated(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Iterator<T> r102 = listeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IDialogFragmentLifecycle) r102.next()).onViewCreated(r100, r101);
        goto L4
    }
}
