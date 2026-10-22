package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.utils.d0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ti.l f169596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.j f169597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u f169598c;

    public static final class a {
    }

    static {
    }

    public b(Context r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "headerDependency");
        super(r100);
        this.f169598c = r101;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = d0.a();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.j r106 = this.f169597b;
        if (r106 == null) goto L5;
        String r107 = r106.a();
    L7:
        if (Intrinsics.areEqual(r107, "ai_combination") == false) goto L10;
        int r108 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        wg.a.f(this, 0, -r105, 0, -com.bytedance.android.ec.hybrid.list.util.c.d(20));
        return;
    L10:
        return;
    L5:
        r107 = null;
        goto L7
    }
}
