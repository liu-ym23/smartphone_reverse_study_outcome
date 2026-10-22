package com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.a$a, reason: collision with other inner class name */
    public static final class C2295a {
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setOrientation(1);
        setGravity(48);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
    }
}
