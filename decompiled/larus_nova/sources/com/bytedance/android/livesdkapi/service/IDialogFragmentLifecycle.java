package com.bytedance.android.livesdkapi.service;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IDialogFragmentLifecycle;", "", "onActivityCreated", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/DialogFragment;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", "rootView", "Landroid/widget/FrameLayout;", "onDismiss", "onPause", "onResume", WidgetCostModule.TYPE_ON_START, "onStop", "onViewCreated", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDialogFragmentLifecycle {
    void onActivityCreated(DialogFragment r100);

    void onCreate(DialogFragment r100);

    void onDestroy(DialogFragment r100);

    void onDestroyView(DialogFragment r100, FrameLayout r101);

    void onDismiss(DialogFragment r100, FrameLayout r101);

    void onPause(DialogFragment r100, FrameLayout r101);

    void onResume(DialogFragment r100, FrameLayout r101);

    void onStart(DialogFragment r100, FrameLayout r101);

    void onStop(DialogFragment r100, FrameLayout r101);

    void onViewCreated(DialogFragment r100, FrameLayout r101);
}
