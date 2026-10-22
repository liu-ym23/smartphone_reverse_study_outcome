package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class BannerSwipeRefreshLayout extends I18nSwipeRefreshLayout {
    public ViewPager E;
    public View F;
    public RecyclerView G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f123410J;
    public float K;
    public float L;
    public int M;

    public interface a {
        void a(ViewPager r100, View r101);

        void b(RecyclerView r100);
    }

    public BannerSwipeRefreshLayout(Context r100) {
        super(r100);
        new ArrayList();
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r100));
        this.I = false;
    }

    @Override // com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
    L77:
        return false;
    L4:
        if (this.E == null) goto L8;
        if (this.F == null) goto L8;
    L9:
        int r100 = r110.getAction();     // Catch: IllegalArgumentException -> L77
        if (r100 != 0) goto L12;
        float r101 = r110.getX();     // Catch: IllegalArgumentException -> L77
        this.f123410J = r101;     // Catch: IllegalArgumentException -> L77
        this.K = r101;     // Catch: IllegalArgumentException -> L77
        this.L = r110.getY();     // Catch: IllegalArgumentException -> L77
        this.I = false;     // Catch: IllegalArgumentException -> L77
        this.M = MotionEventCompat.getPointerId(r110, 0);     // Catch: IllegalArgumentException -> L77
    L76:
        return super.onInterceptTouchEvent(r110);
    L12:
        if (r100 != 2) goto L76;
        if (this.I == true) goto L73;
        int r102 = MotionEventCompat.findPointerIndex(r110, this.M);     // Catch: IllegalArgumentException -> L77
        float r103 = MotionEventCompat.getX(r110, r102);     // Catch: IllegalArgumentException -> L77
        float r104 = Math.abs(r103 - this.K);     // Catch: IllegalArgumentException -> L77
        float r105 = MotionEventCompat.getY(r110, r102);     // Catch: IllegalArgumentException -> L77
        float r106 = Math.abs(r105 - this.L);     // Catch: IllegalArgumentException -> L77
        float r107 = r105 - this.L;     // Catch: IllegalArgumentException -> L77
        ViewPager r108 = this.E;     // Catch: IllegalArgumentException -> L77
        if (r108 != null) goto L19;
    L41:
        RecyclerView r109 = this.G;     // Catch: IllegalArgumentException -> L77
        if (r109 == null) goto L76;
        r109.canScrollVertically(-1);     // Catch: IllegalArgumentException -> L77
        if ((r103 - this.K) <= 0.0f) goto L51;
        if (r104 <= r106) goto L51;
        if (this.G.getScrollX() != 0) goto L51;
    L65:
        int r111 = this.H;     // Catch: IllegalArgumentException -> L77
        if (r106 >= (r111 + 100)) goto L68;
        return false;
    L68:
        float r112 = this.f123410J;     // Catch: IllegalArgumentException -> L77
        if ((r103 - r112) <= 0.0f) goto L71;
        float r113 = r112 + r111;     // Catch: IllegalArgumentException -> L77
    L72:
        this.K = r113;     // Catch: IllegalArgumentException -> L77
        this.L = r105;     // Catch: IllegalArgumentException -> L77
        goto L76
    L71:
        r113 = r112 - r111;     // Catch: IllegalArgumentException -> L77
    L51:
        if (r104 <= this.H) goto L59;
        if ((0.5f * r104) <= r106) goto L59;
        if (this.G.getBottom() <= r105) goto L59;
        this.I = true;     // Catch: IllegalArgumentException -> L77
        return false;
    L59:
        if (r106 <= r104) goto L65;
        if (r107 <= 0.0f) goto L65;
        if (this.G.canScrollVertically(-1) == false) goto L65;
        return false;
    L19:
        if (this.F == null) goto L41;
        if ((r103 - this.K) <= 0.0f) goto L26;
        if (r108.getCurrentItem() != 0) goto L26;
    L33:
        int r114 = this.H;     // Catch: IllegalArgumentException -> L77
        if (r106 >= (r114 + 100)) goto L36;
        return false;
    L36:
        float r115 = this.f123410J;     // Catch: IllegalArgumentException -> L77
        if ((r103 - r115) <= 0.0f) goto L39;
        float r116 = r115 + r114;     // Catch: IllegalArgumentException -> L77
    L40:
        this.K = r116;     // Catch: IllegalArgumentException -> L77
        this.L = r105;     // Catch: IllegalArgumentException -> L77
        goto L76
    L39:
        r116 = r115 - r114;     // Catch: IllegalArgumentException -> L77
    L26:
        if (r104 <= this.H) goto L33;
        if ((r104 * 0.5f) <= r106) goto L33;
        if (this.F.getBottom() <= r105) goto L33;
        this.I = true;     // Catch: IllegalArgumentException -> L77
        return false;
    L73:
        return false;
    L8:
        if (this.G == null) goto L76;
        goto L9
    }

    public BannerSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        new ArrayList();
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r100));
        this.I = false;
    }
}
