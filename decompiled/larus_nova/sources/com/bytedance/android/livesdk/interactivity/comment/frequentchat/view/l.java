package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.c
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        ((TextView) r100.findViewById(R.id.cancel)).setText(s1.B(R.string.frequent_chat_unsave));
        ((TextView) r100.findViewById(R.id.confirm)).setText(s1.B(R.string.frequent_chat_save));
        ((TextView) r100.findViewById(R.id.title)).setText(s1.B(R.string.frequent_chat_save_confirm_text));
    }

    public l(Context r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cancelOperation");
        Intrinsics.checkNotNullParameter(r102, "confirmOperation");
        super(r100, r101, r102);
    }
}
