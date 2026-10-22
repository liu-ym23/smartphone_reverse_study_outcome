package com.bytedance.android.ec.common.impl.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/common/ECHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lkotlin/Function0;", "", "listener", "setOnScrollBeginListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHorizontalScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f42879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42880c;

    public static final class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHorizontalScrollView f42881a;

        public a(ECHorizontalScrollView r100) {
            this.f42881a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            int r100 = this.f42881a.getScrollX();
            ECHorizontalScrollView r101 = this.f42881a;
            if (r100 != r101.f42880c) goto L5;
            return;
        L5:
            if (r101.f42878a == false) goto L11;
            r101.f42880c = r101.getScrollX();
            ECHorizontalScrollView r102 = this.f42881a;
            r102.f42878a = false;
            Function0<Unit> r103 = r102.f42879b;
            if (r103 == null) goto L12;
            Unit r104 = r103.invoke();
            return;
        L12:
            return;
        }
    }

    public ECHorizontalScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECHorizontalScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L6;
        this.f42878a = true;
    L6:
        return super.onTouchEvent(r100);
    }

    public final void setOnScrollBeginListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f42879b = r100;
    }

    public ECHorizontalScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f42880c = -1;
        getViewTreeObserver().addOnScrollChangedListener(new a(this));
    }

    public /* synthetic */ ECHorizontalScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
