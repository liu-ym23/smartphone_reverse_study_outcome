package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends TextView implements e {
    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.e
    public void setColor(int r100) {
        setTextColor(r100);
    }

    public f(Context r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
        super(r100);
        setGravity(16);
        setTypeface(Typeface.DEFAULT_BOLD);
        setText(r101);
    }
}
