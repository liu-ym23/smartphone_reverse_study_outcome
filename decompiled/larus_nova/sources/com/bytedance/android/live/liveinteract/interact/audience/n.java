package com.bytedance.android.live.liveinteract.interact.audience;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n extends FrameLayout {
    public n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_interact_empty_guest_window, this);
    }
}
