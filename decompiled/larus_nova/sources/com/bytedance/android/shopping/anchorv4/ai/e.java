package com.bytedance.android.shopping.anchorv4.ai;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f165654b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f165655a;

    public static final class a {
    }

    static {
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View r101 = new View(r100);
        r101.setBackgroundColor(-1);
        Unit r102 = Unit.INSTANCE;
        this.f165655a = r101;
        setId(View.generateViewId());
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        setElevation(10000.0f);
        addView(r101, new FrameLayout.LayoutParams(-1, 0, 80));
    }

    public final void setInputBackgroundHeight(int r100) {
        View r101 = this.f165655a;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = r100;
        Unit r103 = Unit.INSTANCE;
        r101.setLayoutParams(r102);
    }
}
