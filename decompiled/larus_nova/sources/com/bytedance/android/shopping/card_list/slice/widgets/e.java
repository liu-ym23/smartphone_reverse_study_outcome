package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends SlcRoundFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ti.l f171829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f171830d;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ti.l r100 = this.f171829c;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f171829c = null;
    }

    public final boolean getEnableLargeTextMode() {
        return this.f171830d;
    }

    public final void b(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L4;
        String r101 = com.bytedance.android.ec.hybrid.list.util.k.d(r100);
    L6:
        if (a2.b(r101) == false) goto L11;
        ti.l r102 = this.f171829c;
        if (r102 == null) goto L12;
        r102.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("pass_param", r101)));
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r101 = null;
        goto L6
    }

    public e(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f171830d = r101;
    }
}
