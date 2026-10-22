package com.bytedance.android.live.ktv.common.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f70687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f70688b = null;

    static {
        String r100 = s1.B(R.string.ttlive_ktv_sort_type_score_des);
        if (r100 != null) goto L5;
        r100 = "演唱得分";
    L5:
        f70687a = r100;
        String r101 = s1.B(R.string.ttlive_ktv_sort_type_time_des);
        if (r101 != null) goto L8;
        r101 = "演唱时间";
    L8:
        f70688b = r101;
    }

    public static final View a(Context r100, kb0.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "tabTextView");
        View r102 = new View(r100);
        r102.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(-2, -2);
        r103.topToTop = r101.getId();
        r103.startToEnd = r101.getId();
        ((ViewGroup.MarginLayoutParams) r103).width = (int) UtilityKotlinExtentionsKt.h(6.0f);
        ((ViewGroup.MarginLayoutParams) r103).height = (int) UtilityKotlinExtentionsKt.h(6.0f);
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        r102.setBackgroundResource(R.drawable.ttlive_ktv_order_dialog_tab_yellow_red_bg);
        UtilityKotlinExtentionsKt.t(r102);
        return r102;
    }
}
