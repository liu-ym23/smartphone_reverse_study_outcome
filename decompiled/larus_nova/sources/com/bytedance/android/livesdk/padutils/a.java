package com.bytedance.android.livesdk.padutils;

import android.content.Context;
import android.view.OrientationEventListener;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f154211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f154212b;

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        if (Math.abs(r100 - 90) >= this.f154211a) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        this.f154212b.invoke();
        return;
    L12:
        return;
    L5:
        if (Math.abs(r100 + ECStoreJsbErrorCode.PATTERN_EXCEPTION) < this.f154211a) goto L8;
        r101 = false;
        goto L9
    }

    public a(Context r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "invoker");
        super(r100);
        this.f154211a = 45;
        this.f154212b = r101;
    }
}
