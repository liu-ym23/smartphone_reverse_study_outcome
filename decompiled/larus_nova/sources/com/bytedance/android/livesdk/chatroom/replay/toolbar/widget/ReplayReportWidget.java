package com.bytedance.android.livesdk.chatroom.replay.toolbar.widget;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/widget/ReplayReportWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayReportWidget extends LiveWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogFragment f110197a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        DialogFragment r100 = this.f110197a;
        if (r100 == null) goto L20;
        if (r100 == null) goto L21;
        Dialog r101 = r100.getDialog();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isShowing() != true) goto L23;
        DialogFragment r102 = this.f110197a;
        if (r102 == null) goto L24;
        r102.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L25;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    }

    public ReplayReportWidget() {
    }
}
