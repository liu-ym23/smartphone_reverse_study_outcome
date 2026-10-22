package com.bytedance.android.livesdk.gift.framework.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.d;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseGiftMVIViewChildNode<SUPER_STATE extends MVIState<SUPER_STATE>, STATE extends MVIState<STATE>, ACTION extends p> extends d<SUPER_STATE, STATE, ACTION> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f126230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j1 f126231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f126232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f126233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f126234l;

    public void q() {
    }

    public final View r() {
        return (View) this.f126232j.getValue();
    }

    public abstract int s();

    public final Context getContext() {
        return this.f126233k;
    }

    public void p(int r100) {
        r().setVisibility(r100);
        if (this.f126230h == true) goto L6;
        this.f126230h = true;
        q();
        return;
    }

    public BaseGiftMVIViewChildNode(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        this.f126233k = r100;
        this.f126234l = r101;
        this.f126231i = a0.e();
        this.f126232j = LazyKt.lazy(new BaseGiftMVIViewChildNode$contentView$2(this));
    }
}
