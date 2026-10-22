package com.bytedance.android.live.soloktv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/soloktv/view/NotInterceptMoveNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;", "Landroid/view/View;", "view", "", "setScrollChildView", "", "getmScrollY", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NotInterceptMoveNestedScrollView extends NestedScrollView implements NestedScrollView.OnScrollChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f101752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f101753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f101754c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f101755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f101756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f101757c;

        public a(int r100, int r101, int r102) {
            this.f101755a = r100;
            this.f101756b = r101;
            this.f101757c = r102;
        }
    }

    public final int getmScrollY() {
        return this.f101754c;
    }

    public NotInterceptMoveNestedScrollView(Context r100) {
        this(r100, null);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        float r100 = r110.getX();
        float r101 = r110.getY();
        if (r110.getActionMasked() != 0) goto L20;
        Iterator<T> r102 = this.f101752a.iterator();
    L6:
        if (r102.hasNext() == false) goto L28;
        a r103 = (a) r102.next();
        View r104 = findViewById(r103.f101755a);
        int r105 = r103.f101756b;
        int r106 = r103.f101757c;
        if (r100 > r104.getLeft()) goto L10;
    L16:
        boolean r107 = false;
    L17:
        if (r107 == false) goto L6;
        this.f101753b = true;
        goto L6
    L10:
        if (r100 >= r104.getRight()) goto L16;
        if (r101 <= (((r104.getTop() + getPaddingTop()) - r105) - this.f101754c)) goto L16;
        if (r101 >= (((r104.getBottom() + getPaddingTop()) + r106) - this.f101754c)) goto L16;
        r107 = true;
    L28:
        if (this.f101753b == false) goto L31;
        return false;
    L31:
        return super.onInterceptTouchEvent(r110);
    L20:
        if (r110.getActionMasked() == 1) goto L24;
        if (r110.getActionMasked() != 3) goto L28;
    L24:
        if (this.f101753b == false) goto L28;
        this.f101753b = false;
        return false;
    }

    public final void setScrollChildView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof RecyclerView) == true) goto L5;
        r100 = null;
    L5:
        RecyclerView r101 = (RecyclerView) r100;
    }

    public NotInterceptMoveNestedScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f101752a = new ArrayList();
        setOnScrollChangeListener(this);
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(NestedScrollView r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f101754c = r102;
    }
}
