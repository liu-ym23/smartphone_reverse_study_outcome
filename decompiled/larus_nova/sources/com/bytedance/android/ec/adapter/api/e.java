package com.bytedance.android.ec.adapter.api;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;

/* JADX INFO: loaded from: classes43.dex */
public interface e {
    void a(ECBaseDialogFragment r100);

    void onActivityCreated(DialogFragment r100);

    void onDestroy(DialogFragment r100);

    void onDestroyView(DialogFragment r100, FrameLayout r101);

    void onDismiss(DialogFragment r100, FrameLayout r101);

    void onPause(DialogFragment r100, FrameLayout r101);

    void onResume(DialogFragment r100, FrameLayout r101);

    void onStart(DialogFragment r100, FrameLayout r101);

    void onStop(DialogFragment r100, FrameLayout r101);

    void onViewCreated(DialogFragment r100, FrameLayout r101);
}
