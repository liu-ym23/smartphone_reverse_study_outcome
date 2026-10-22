package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import com.bytedance.android.shopping.feed.widget.InflowSimpleAbilityView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f175638a = 0;

    static {
    }

    public static InflowSimpleAbilityView a(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "text");
        InflowSimpleAbilityView r103 = new InflowSimpleAbilityView(r100, null, 6, 0);
        r103.setIcon(r101);
        r103.setText(r102);
        return r103;
    }
}
