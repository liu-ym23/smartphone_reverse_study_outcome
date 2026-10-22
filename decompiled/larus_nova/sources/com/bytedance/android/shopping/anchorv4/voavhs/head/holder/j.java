package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.FloatingTagLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FloatingTagLayout f168689i;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeVO");
        return new h83.c(r100.f168529b, r100.f168534g, r100.f168548u, r100.f168549v);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b, com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void i(float r100) {
        FloatingTagLayout r101 = this.f168689i;
        if (r101 == null) goto L8;
        Iterator r102 = ((ArrayList) r101.f165187c).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((Function1) r102.next()).invoke(Float.valueOf(r100));
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r100) {
        h83.c r101 = (h83.c) r100;
        AttributeSet r102 = null;
        if (r101 == null) goto L5;
        CombinationVO r103 = r101.f484076b;
    L6:
        if (r103 == null) goto L10;
        FloatingTagLayout r104 = new FloatingTagLayout(getContext(), r102, 6, 0);
        r104.a(r101.f484076b, r101.f484077c, new i(this), r101.f484078d, this.f168516g);
        this.f168689i = r104;
        return r104;
    L10:
        return null;
    L5:
        r103 = null;
        goto L6
    }

    public j(Context r100, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
