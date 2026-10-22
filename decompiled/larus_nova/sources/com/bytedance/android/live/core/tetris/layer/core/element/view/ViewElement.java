package com.bytedance.android.live.core.tetris.layer.core.element.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import j70.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o70.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/view/ViewElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Landroid/view/View;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewElement extends Element<View> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f65706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f65707m;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View i() {
        View r100 = this.f65706l;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final a j() {
        View r100 = this.f65706l;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L6:
        if ((r100 instanceof a) == false) goto L15;
        KeyEvent.Callback r101 = this.f65706l;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L10:
        if (r101 == null) goto L14;
        return (a) r101;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r100) {
        if (r100 == null) goto L5;
        this.f65706l = r100;
        return;
    }

    public ViewElement(b r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "viewElementAttribute");
        super(r100);
        this.f65707m = r101;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = this.f65707m.getView(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        this.f65707m.getLayoutId();
        Integer r103 = 0;
        if (r103.intValue() == 0) goto L8;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 != null) goto L15;
        return null;
    L15:
        return LayoutInflater.from(r100).inflate(r103.intValue(), r101, false);
    L8:
        r104 = false;
        goto L10
    }
}
