package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f169401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.helper.n f169402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<com.bytedance.android.ecom.arch.slice.g, View, Unit> f169403c;

    public t0(FragmentActivity r100, SlcContext r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcContext");
        Intrinsics.checkNotNullParameter(r102, "onSliceViewCreated");
        this.f169403c = r102;
        FrameLayout r103 = new FrameLayout(r100);
        this.f169401a = r103;
        this.f169402b = new com.bytedance.android.shopping.anchorv4.helper.n(r103, r101, new s0(this));
    }
}
