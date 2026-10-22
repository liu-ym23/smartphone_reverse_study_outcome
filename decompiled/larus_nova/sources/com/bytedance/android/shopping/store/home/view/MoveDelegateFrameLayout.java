package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/MoveDelegateFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View;", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "delegateView", "Lkotlin/Pair;", "", "b", "Lkotlin/Pair;", "getOffsetLocation", "()Lkotlin/Pair;", "setOffsetLocation", "(Lkotlin/Pair;)V", "offsetLocation", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MoveDelegateFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f184646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Pair<Float, Float> f184647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f184648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f184649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f184650e;

    public final View getDelegateView() {
        return this.f184646a;
    }

    public final Pair<Float, Float> getOffsetLocation() {
        return this.f184647b;
    }

    public final void a(MotionEvent r100) {
        Pair<Float, Float> r101 = this.f184647b;
        float r102 = 0.0f;
        if (r101 == null) goto L7;
        Float r103 = r101.getFirst();
        if (r103 == null) goto L7;
        float r104 = r103.floatValue();
    L8:
        Pair<Float, Float> r105 = this.f184647b;
        if (r105 == null) goto L13;
        Float r106 = r105.getSecond();
        if (r106 == null) goto L13;
        r102 = r106.floatValue();
    L13:
        r100.offsetLocation(r104, r102);
        return;
    L7:
        r104 = 0.0f;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f184646a == null) goto L27;
        if (r100.getAction() != 2) goto L16;
        if (this.f184648c == r100.getX()) goto L9;
    L10:
        a(r100);
        View r101 = this.f184646a;
        if (r101 == null) goto L13;
        r101.dispatchTouchEvent(r100);
    L13:
        this.f184650e = true;
    L14:
        return true;
    L9:
        if (this.f184649d == r100.getY()) goto L14;
    L16:
        if (r100.getAction() != 0) goto L19;
        this.f184648c = r100.getX();
        this.f184649d = r100.getY();
        this.f184650e = false;
        goto L27
    L19:
        if (r100.getAction() != 1) goto L27;
        if (this.f184650e == false) goto L27;
        a(r100);
        View r102 = this.f184646a;
        if (r102 == null) goto L25;
        r102.dispatchTouchEvent(r100);
    L25:
        r100.setAction(3);
    L27:
        return super.dispatchTouchEvent(r100);
    }

    public final void setDelegateView(View r100) {
        this.f184646a = r100;
    }

    public final void setOffsetLocation(Pair<Float, Float> r100) {
        this.f184647b = r100;
    }

    public MoveDelegateFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public MoveDelegateFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
