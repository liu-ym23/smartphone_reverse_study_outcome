package com.bytedance.android.livesdk.drawer;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import ut1.i;

/* JADX INFO: loaded from: classes8.dex */
public class LiveDrawerLayout extends DrawerLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f122346g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f122347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f122348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f122349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f122350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ILiveDrawerLayoutInterceptor f122351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<DrawerLayout.DrawerListener> f122352f;

    public LiveDrawerLayout(Context r100) {
        this(r100, null);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public final void addDrawerListener(DrawerLayout.DrawerListener r100) {
        super.addDrawerListener(r100);
        if (this.f122352f != null) goto L5;
        this.f122352f = new ArrayList();
    L5:
        this.f122352f.add(r100);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        float r101 = r100.getX();     // Catch: IllegalArgumentException -> L42
        float r102 = r100.getY();     // Catch: IllegalArgumentException -> L42
        int r103 = r100.getAction();     // Catch: IllegalArgumentException -> L42
        if (r103 != 0) goto L6;
        this.f122348b = r101;     // Catch: IllegalArgumentException -> L42
        this.f122349c = r102;     // Catch: IllegalArgumentException -> L42
    L35:
        ILiveDrawerLayoutInterceptor r104 = this.f122351e;     // Catch: IllegalArgumentException -> L42
        if (r104 == null) goto L41;
        if (r104.onInterceptTouchEvent(r100) == true) goto L41;
        return false;
    L41:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r103 != 2) goto L35;
        float r105 = this.f122348b;     // Catch: IllegalArgumentException -> L42
        if (r101 > r105) goto L11;
    L13:
        int r106 = (int) Math.abs(r101 - r105);     // Catch: IllegalArgumentException -> L42
        int r107 = (int) Math.abs(r102 - this.f122349c);     // Catch: IllegalArgumentException -> L42
        int r108 = (r106 * r106) + (r107 * r107);     // Catch: IllegalArgumentException -> L42
        int r109 = this.f122347a;     // Catch: IllegalArgumentException -> L42
        if (r108 <= (r109 * r109)) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == true) goto L19;
    L23:
        if (r110 == false) goto L35;
        if (this.f122350d == false) goto L35;
        if (r106 <= (r107 * 4)) goto L46;
        ILiveDrawerLayoutInterceptor r111 = this.f122351e;     // Catch: IllegalArgumentException -> L42
        if (r111 != null) goto L31;
    L32:
        return true;
    L31:
        if (r111.onInterceptTouchEvent(r100) == false) goto L32;
        return false;
    L46:
        return false;
    L19:
        if (this.f122350d == true) goto L23;
        if (r106 >= (r107 * 4)) goto L23;
        return false;
    L16:
        r110 = false;
        goto L17
    L11:
        if (this.f122350d == true) goto L13;
        return false;
    L42:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public final void removeDrawerListener(DrawerLayout.DrawerListener r100) {
        super.removeDrawerListener(r100);
        List<DrawerLayout.DrawerListener> r101 = this.f122352f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r101).contains(r100) == false) goto L9;
        ((ArrayList) this.f122352f).remove(r100);
        return;
    }

    public void setDrawerLayoutInterceptor(ILiveDrawerLayoutInterceptor r100) {
        this.f122351e = r100;
    }

    public LiveDrawerLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveDrawerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        ViewConfiguration r103 = ViewConfiguration.get(getContext());
        Resources r104 = r100.getResources();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        this.f122347a = r103.getScaledTouchSlop();
        addDrawerListener(new i(this));
    }
}
