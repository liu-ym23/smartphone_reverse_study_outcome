package com.bytedance.android.live.livepkaudience.emoji;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/LinkCommonBottomDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LinkCommonBottomDialog extends CommonBottomDialog {
    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public void show() {
        Activity r100 = ContextUtil.contextToActivity(getContext());
        if (r100 == null) goto L9;
        if (r100.isFinishing() != true) goto L9;
        int r101 = com.bytedance.android.live.liveinteract.plantform.utils.x.f77572a;
        com.bytedance.android.live.liveinteract.plantform.utils.x.G(r100.toString());
        return;
    L9:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public LinkCommonBottomDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
