package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class UIViewGroup<VG extends ViewGroup, LP extends ViewGroup.LayoutParams, SELFLP extends ViewGroup.LayoutParams, GROUPOPTION> extends k<VG, LP> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f49284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final vo.b<VG> f49285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JsonObject f49286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<k<? extends View, SELFLP>> f49287m;

    public GROUPOPTION f() {
        return null;
    }

    @Override // vo.a
    public final Object c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (ViewGroup) this.f49285k.a(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UIViewGroup(String r100, int r101, j r102, vo.b<VG> r110, JsonObject r111, String r112, g<LP, Object> r113, List<? extends k<? extends View, SELFLP>> r114) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        Intrinsics.checkNotNullParameter(r102, "uiParam");
        Intrinsics.checkNotNullParameter(r110, "groupMaker");
        Intrinsics.checkNotNullParameter(r112, "viewType");
        Intrinsics.checkNotNullParameter(r113, "filler");
        Intrinsics.checkNotNullParameter(r114, "uiViewElements");
        super(r100, r101, r102, r112, r113);
        this.f49285k = r110;
        this.f49286l = r111;
        this.f49287m = r114;
        this.f49284j = LazyKt.lazy(new UIViewGroup$option$2(this));
    }
}
