package com.amap.api.col.jmsl;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.maps.AMapCallback;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.FPoint;
import java.util.HashMap;

/* loaded from: classes.dex */
public class X0 extends ViewGroup implements G0 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16446a;

    /* renamed from: b, reason: collision with root package name */
    public W1 f16447b;

    /* renamed from: c, reason: collision with root package name */
    public Context f16448c;

    /* renamed from: d, reason: collision with root package name */
    public View f16449d;

    /* renamed from: e, reason: collision with root package name */
    public BasePointOverlay f16450e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f16451f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16452g;

    /* renamed from: h, reason: collision with root package name */
    public View f16453h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16454i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16455j;

    /* renamed from: k, reason: collision with root package name */
    public P0 f16456k;

    /* renamed from: l, reason: collision with root package name */
    public AMapCallback<Point> f16457l;

    /* renamed from: m, reason: collision with root package name */
    public Runnable f16458m;

    public class a implements AMapCallback<Point> {
        public a() {
        }

        @Override // com.amap.api.maps.AMapCallback
        public void onCallback(Point point) {
            try {
                X0.f(X0.this, point);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (X0.this.f16449d != null) {
                    X0.this.f16449d.clearFocus();
                    X0 x02 = X0.this;
                    x02.removeView(x02.f16449d);
                    Drawable background = X0.this.f16449d.getBackground();
                    HashMap<String, Long> map = C1570k.f16700b;
                    if (background != null) {
                        background.setCallback(null);
                    }
                    Drawable drawable = X0.this.f16451f;
                    if (drawable != null) {
                        drawable.setCallback(null);
                    }
                    X0.b(X0.this, null);
                    if (C1623x1.f17030a) {
                        r.f(111, getClass().getSimpleName(), "hideInfoWindow finish  infoView visible", X0.this.f16449d == null ? "null" : Integer.valueOf(X0.this.f16449d.getVisibility()));
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public FPoint f16461a;

        /* renamed from: b, reason: collision with root package name */
        public int f16462b;

        /* renamed from: c, reason: collision with root package name */
        public int f16463c;

        /* renamed from: d, reason: collision with root package name */
        public int f16464d;

        public c(int i10, int i11, float f10, float f11, int i12, int i13, int i14) {
            super(i10, i11);
            FPoint fPoint = new FPoint();
            this.f16461a = fPoint;
            ((PointF) fPoint).x = f10;
            ((PointF) fPoint).y = f11;
            this.f16462b = i12;
            this.f16463c = i13;
            this.f16464d = i14;
        }
    }

    public X0(Context context, InterfaceC1552f1 interfaceC1552f1, W1 w12) {
        super(context);
        this.f16451f = null;
        this.f16452g = true;
        this.f16455j = true;
        this.f16457l = new a();
        this.f16458m = new b();
        try {
            this.f16447b = w12;
            this.f16446a = interfaceC1552f1;
            this.f16448c = context;
            new C1622x0(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            N0 n02 = (N0) interfaceC1552f1;
            if (n02.T() != null) {
                addView(n02.T(), 0, layoutParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1570k.j(th);
        }
    }

    public static /* synthetic */ View b(X0 x02, View view) {
        x02.f16449d = null;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(com.amap.api.col.jmsl.X0 r26, android.graphics.Point r27) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.X0.f(com.amap.api.col.jmsl.X0, android.graphics.Point):void");
    }

    public void c() {
        this.f16446a.m(this.f16458m);
        this.f16450e = null;
    }

    public final void d(View view, int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16 = i14 & 7;
        int i17 = i14 & 112;
        if (i16 == 5) {
            i12 -= i10;
        } else if (i16 == 1) {
            i12 -= i10 / 2;
        }
        if (i17 == 80) {
            i13 -= i11;
        } else {
            if (i17 == 17) {
                i15 = i11 / 2;
            } else if (i17 == 16) {
                i13 /= 2;
                i15 = i11 / 2;
            }
            i13 -= i15;
        }
        view.layout(i12, i13, i10 + i12, i11 + i13);
    }

    public final void e(View view, int i10, int i11, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i10 <= 0 || i11 <= 0) {
            view.measure(0, 0);
        }
        if (i10 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i10 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i10;
        }
        if (i11 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i11 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i11;
        }
    }

    public void g(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            P0 p02 = this.f16456k;
            if ((p02 == null || !p02.r() || basePointOverlay.getTitle() != null || basePointOverlay.getSnippet() != null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f16450e;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    c();
                    if (C1623x1.f17030a) {
                        r.f(111, getClass().getSimpleName(), "showInfoWindow show other marker's InfoWindow, hide the last one");
                    }
                }
                if (this.f16456k != null) {
                    this.f16450e = basePointOverlay;
                    this.f16454i = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean h(MotionEvent motionEvent) {
        if (this.f16449d != null && this.f16450e != null) {
            Rect rect = new Rect(this.f16449d.getLeft(), this.f16449d.getTop(), this.f16449d.getRight(), this.f16449d.getBottom());
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            HashMap<String, Long> map = C1570k.f16700b;
            if (rect.contains(x10, y10)) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        BasePointOverlay basePointOverlay = this.f16450e;
        return basePointOverlay != null && basePointOverlay.isInfoWindowEnable();
    }

    public void k() {
        try {
            BasePointOverlay basePointOverlay = this.f16450e;
            if (basePointOverlay == null) {
                View view = this.f16449d;
                if (view == null || view.getVisibility() != 0) {
                    return;
                }
                this.f16449d.setVisibility(8);
                return;
            }
            W1 w12 = this.f16447b;
            basePointOverlay.getId();
            w12.getClass();
            if (this.f16452g) {
                if (((Marker) this.f16450e).isViewMode()) {
                    this.f16446a.a().toScreenLocation(this.f16450e.getPosition(), this.f16457l);
                } else {
                    this.f16446a.a().toScreenLocation(this.f16450e.getPosition(), this.f16457l);
                }
            }
        } catch (Throwable th) {
            C1541c2.b(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        X0 x02;
        try {
            int childCount = getChildCount();
            int i14 = 0;
            while (i14 < childCount) {
                View childAt = this.getChildAt(i14);
                if (childAt == null) {
                    x02 = this;
                } else if (childAt.getLayoutParams() instanceof c) {
                    c cVar = (c) childAt.getLayoutParams();
                    int[] iArr = new int[2];
                    this.e(childAt, ((ViewGroup.LayoutParams) cVar).width, ((ViewGroup.LayoutParams) cVar).height, iArr);
                    FPoint fPoint = cVar.f16461a;
                    if (fPoint != null) {
                        X0 x03 = this;
                        x03.d(childAt, iArr[0], iArr[1], (int) (cVar.f16462b + ((PointF) fPoint).x), (int) (cVar.f16463c + ((PointF) fPoint).y), cVar.f16464d);
                        this = x03;
                    }
                    x02 = this;
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int[] iArr2 = new int[2];
                    this.e(childAt, layoutParams.width, layoutParams.height, iArr2);
                    x02 = this;
                    x02.d(childAt, iArr2[0], iArr2[1], 0, 0, 51);
                }
                i14++;
                this = x02;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
