package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends com.bytedance.android.shopping.anchorv3.detail.widget.l implements com.bytedance.android.shopping.anchorv4.vm.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f168509c;

    @Override // com.bytedance.android.shopping.anchorv4.vm.h
    public final void S2(float r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.vm.h
    public final void a2(boolean r100) {
    }

    public void b2(boolean r100) {
    }

    public abstract List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f();

    public abstract p g();

    public a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f168509c = r101;
    }
}
