package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class v extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f167650a;

    public v(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ImageView r101 = new ImageView(r100);
        this.f167650a = r101;
        Unit r102 = Unit.INSTANCE;
        addView(r101);
    }

    public final void setImageResource(int r100) {
        this.f167650a.setImageResource(r100);
    }
}
