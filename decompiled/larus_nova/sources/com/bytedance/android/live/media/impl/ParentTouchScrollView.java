package com.bytedance.android.live.media.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0014R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/media/impl/ParentTouchScrollView;", "Lcom/bytedance/android/live/media/impl/FadingEdgeScrollView;", "", "getTopFadingEdgeStrength", "Lkotlin/Function0;", "", "b", "Lkotlin/jvm/functions/Function0;", "getGetContentBottom", "()Lkotlin/jvm/functions/Function0;", "setGetContentBottom", "(Lkotlin/jvm/functions/Function0;)V", "getContentBottom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParentTouchScrollView extends FadingEdgeScrollView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Integer> f82905b;

    public ParentTouchScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ParentTouchScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.live.media.impl.FadingEdgeScrollView, android.widget.ScrollView, android.view.View
    public float getTopFadingEdgeStrength() {
        return super.getTopFadingEdgeStrength() * getTopFading();
    }

    public final Function0<Integer> getGetContentBottom() {
        return this.f82905b;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Function0<Integer> r101 = this.f82905b;
        if (r101 == null) goto L18;
        if (r100 == null) goto L18;
        if (r101 == null) goto L9;
        int r102 = r101.invoke().intValue();
    L11:
        if (r100.getAction() != 0) goto L16;
        if (r100.getY() <= r102) goto L16;
        return false;
    L16:
        return super.onTouchEvent(r100);
    L9:
        r102 = 0;
    L18:
        return super.onTouchEvent(r100);
    }

    public final void setGetContentBottom(Function0<Integer> r100) {
        this.f82905b = r100;
    }

    public ParentTouchScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ParentTouchScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
