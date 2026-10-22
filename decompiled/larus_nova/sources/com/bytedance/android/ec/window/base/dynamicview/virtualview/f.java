package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f<V extends View, LP extends ViewGroup.LayoutParams> extends k<V, LP> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ vo.a<V> f49303j;

    @Override // vo.a
    public final Object c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f49303j.c(r100);
    }

    public f(String r100, int r101, j r102, String r110, vo.a<V> r111, g<LP, Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        Intrinsics.checkNotNullParameter(r102, "uiParam");
        Intrinsics.checkNotNullParameter(r110, "viewType");
        Intrinsics.checkNotNullParameter(r111, "viewMaker");
        Intrinsics.checkNotNullParameter(r112, "filler");
        super(r100, r101, r102, r110, r112);
        this.f49303j = r111;
    }
}
