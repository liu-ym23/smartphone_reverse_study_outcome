package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {
    public static final void a(View r100, Context r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 != null) goto L5;
        return;
    L5:
        BackgroundDrawable r103 = new BackgroundDrawable(r101, r102, false, 4, null);
        r103.setBgColor(ContextCompat.getColor(r101, R.color.shopping_home_color_FFFFFF));
        int r104 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r103.setCornerRadius(com.bytedance.android.ec.hybrid.list.util.c.c(12, r101, true));
        r103.invalidate();
        Unit r105 = Unit.INSTANCE;
        r100.setBackground(r103);
    }
}
