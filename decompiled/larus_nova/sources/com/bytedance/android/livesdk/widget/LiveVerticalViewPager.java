package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.camera.video.AudioStats;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.t5;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.config.LiveScrollSwitchConfigHelper;
import com.bytedance.android.livesdk.config.gb1;
import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.config.y51;
import com.bytedance.android.livesdk.live.listprovider.DrawRoomListProvider;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.y8;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveDrawOverlayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j40.f4;
import j40.q3;
import j40.t3;
import j40.v3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
public class LiveVerticalViewPager extends ViewGroup implements cs1.b {

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final int[] f161122h3 = null;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final a f161123i3 = null;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public static final b f161124j3 = null;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public static final c f161125k3 = null;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public static final d f161126l3 = null;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public static final Field f161127m3 = null;
    public boolean A;
    public boolean B;
    public r C;
    public int D;
    public Drawable E;
    public final boolean E2;
    public int F;
    public k F2;
    public int G;
    public boolean G1;
    public ViewPager.OnPageChangeListener G2;
    public float H;
    public int H0;
    public com.bytedance.android.livesdk.widget.n H1;
    public com.bytedance.android.livesdk.vs.a H2;
    public float I;
    public n I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f161128J;
    public Method J2;
    public boolean K;
    public e0 K2;
    public boolean L;
    public final Boolean L0;
    public com.bytedance.android.livesdk.widget.n L1;
    public float L2;
    public boolean M;
    public boolean M1;
    public boolean M2;
    public int N;
    public boolean N2;
    public int O;
    public final boolean O2;
    public int P;
    public VelocityTracker P0;
    public boolean P1;
    public boolean P2;
    public boolean Q;
    public q Q1;
    public boolean Q2;
    public boolean R;
    public boolean R2;
    public int S;
    public boolean S1;
    public final e S2;
    public int T;
    public boolean T1;
    public int T2;
    public int U;
    public int U2;
    public float V;
    public int V0;
    public boolean V1;
    public int V2;
    public float W;
    public int W2;
    public float X2;
    public float Y2;
    public int Z2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f161129a;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public long f161130a3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f161131b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f161132b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public int f161133b2;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public float f161134b3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f161135c;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public float f161136c3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f161137d;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public boolean f161138d3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f161139e;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public final ArrayList<j> f161140e3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f161141f;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public final ArrayList<cs1.b.a> f161142f3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f161143g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f161144g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public boolean f161145g2;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public View f161146g3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f161147h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f161148h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public boolean f161149h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f161150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f161151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f161152k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f161153k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f161154k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MediatorLiveData f161155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Observer<Pair<Double, Double>> f161156m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f161157n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f161158o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f161159p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f161160p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public float f161161p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public boolean f161162p2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<m> f161163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final m f161164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f161165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PagerAdapter f161166t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f161167u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f161168v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f161169v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f161170v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f161171w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Parcelable f161172x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public long f161173x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public final int f161174x2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ClassLoader f161175y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f161176y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public boolean f161177y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Scroller f161178z;

    public interface IExtPageChangeListener extends ViewPager.OnPageChangeListener {
        void TD(boolean r100);

        boolean in(int r100);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f161179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f161180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f161181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f161182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f161183e;

        public LayoutParams() {
            super(-1, -1);
            this.f161181c = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f161181c = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, LiveVerticalViewPager.f161122h3);
            this.f161180b = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f161184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f161185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ClassLoader f161186c;

        public class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f161184a + com.alipay.sdk.m.u.i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f161184a = r100.readInt();
            this.f161185b = r100.readParcelable(r101);
            this.f161186c = r101;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f161184a);
            r100.writeParcelable(this.f161185b, r101);
        }
    }

    public class a implements Comparator<m> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(m r100, m r101) {
            return r100.f161197b - r101.f161197b;
        }
    }

    public class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class c implements Interpolator {
        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((r101 * r101) * r101) + 1.0f;
        }
    }

    public class d implements Interpolator {
        public d() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((-r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161187a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f161188a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f161188a.f161187a.y();     // Catch: Throwable -> L4
                this.f161188a.f161187a.N2 = false;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100) {
                this.f161188a = r100;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveVerticalViewPager.f(this.f161187a);     // Catch: Throwable -> L7
            LiveVerticalViewPager r100 = this.f161187a;     // Catch: Throwable -> L7
            r100.f161162p2 = true;     // Catch: Throwable -> L7
            if (r100.O2 == false) goto L5;
            r100.N2 = true;     // Catch: Throwable -> L7
            r100.M2 = true;     // Catch: Throwable -> L7
            com.bytedance.android.live.core.utils.i0.f(new a(this));     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            r100.y();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public e(LiveVerticalViewPager r100) {
            this.f161187a = r100;
        }
    }

    public class f implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f161189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161190b;

        public f(LiveVerticalViewPager r100) {
            this.f161190b = r100;
            this.f161189a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
            if (r102.isConsumed() == false) goto L5;
            return r102;
        L5:
            Rect r103 = this.f161189a;
            r103.left = r102.getSystemWindowInsetLeft();
            r103.top = r102.getSystemWindowInsetTop();
            r103.right = r102.getSystemWindowInsetRight();
            r103.bottom = r102.getSystemWindowInsetBottom();
            int r104 = this.f161190b.getChildCount();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L9;
            WindowInsetsCompat r106 = ViewCompat.dispatchApplyWindowInsets(this.f161190b.getChildAt(r105), r102);
            r103.left = Math.min(r106.getSystemWindowInsetLeft(), r103.left);
            r103.top = Math.min(r106.getSystemWindowInsetTop(), r103.top);
            r103.right = Math.min(r106.getSystemWindowInsetRight(), r103.right);
            r103.bottom = Math.min(r106.getSystemWindowInsetBottom(), r103.bottom);
            r105 = r105 + 1;
            goto L6
        L9:
            return r102.replaceSystemWindowInsets(r103.left, r103.top, r103.right, r103.bottom);
        }
    }

    public class g implements io.reactivex.Observer<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f161191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f161192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161193c;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
        }

        public g(LiveVerticalViewPager r100) {
            this.f161193c = r100;
            this.f161191a = null;
            this.f161192b = 2;
        }

        @Override // io.reactivex.Observer
        public final void onNext(Long r100) {
            this.f161193c.f161178z.getCurrY();
            this.f161193c.getScrollY();
            if (this.f161193c.f161178z.getCurrY() != this.f161193c.getScrollY()) goto L11;
            this.f161192b--;
            Disposable r101 = this.f161191a;
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101.isDisposed() == false) goto L9;
            return;
        L9:
            if (this.f161192b > 0) goto L15;
            this.f161193c.f161178z.getCurrY();
            this.f161191a.dispose();
            return;
        L15:
            return;
        L11:
            LiveVerticalViewPager r102 = this.f161193c;
            r102.scrollTo(r102.f161178z.getCurrX(), this.f161193c.f161178z.getCurrY());
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f161191a = r100;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161194a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f161194a.Q1 == null) goto L10;
            com.bytedance.android.livesdk.log.u.l().d("top", new Object[]{new am2.x(), Room.class});     // Catch: Throwable -> L7
            return;
        }

        public h(LiveVerticalViewPager r100) {
            this.f161194a = r100;
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161195a;

        public final void a() {
            q r100 = this.f161195a.Q1;
            if (r100 != null) goto L5;
            return;
        L5:
            wi1.g.a r101 = (wi1.g.a) r100;
            ui1.e.b(r101.f559746c.h(), r101.f559746c.g(), r101.f559745b.f490235k, ((ck1.d) r101.f559746c.h().a(ck1.d.class)).jn());
            if ((System.currentTimeMillis() - r101.f559744a) <= 2500) goto L17;
            r101.f559744a = System.currentTimeMillis();
            Fragment r102 = r101.f559746c.h().f510524m;
            if (r102 != null) goto L11;
        L15:
            ui1.e.c();
            return;
        L11:
            if (r102.isAdded() == false) goto L15;
            if (r102.getContext() == null) goto L15;
            com.bytedance.android.live.core.utils.f2.i(r102.getContext(), r102.getString(R.string.ttlive_swipe_room_no_more_below_tips), 0);
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(LiveVerticalViewPager r100) {
            this.f161195a = r100;
        }
    }

    public interface j {
        void a(MotionEvent r100);
    }

    public interface k {
    }

    public interface l {
        boolean a(MotionEvent r100);

        boolean r();

        boolean s();
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f161196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f161197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f161198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f161199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f161200e;

        public m() {
        }
    }

    public interface n {
    }

    public class o extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161201a;

        public o(LiveVerticalViewPager r100) {
            this.f161201a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat r102 = AccessibilityRecordCompat.obtain();
            PagerAdapter r103 = this.f161201a.f161166t;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.getCount() <= 1) goto L7;
        L8:
            r102.setScrollable(r104);
            if (r101.getEventType() != 4096) goto L14;
            PagerAdapter r105 = this.f161201a.f161166t;
            if (r105 == null) goto L15;
            r102.setItemCount(r105.getCount());
            r102.setFromIndex(this.f161201a.f161167u);
            r102.setToIndex(this.f161201a.f161167u);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r104 = false;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            PagerAdapter r102 = this.f161201a.f161166t;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.setScrollable(r103);
            if (this.f161201a.canScrollVertically(1) == false) goto L12;
            r101.addAction(4096);
        L12:
            if (this.f161201a.canScrollVertically(-1) == false) goto L15;
            r101.addAction(8192);
            return;
        L15:
            return;
        L5:
            if (r102.getCount() <= 1) goto L7;
            r103 = true;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L6;
            return true;
        L6:
            if (r101 == 4096) goto L16;
            if (r101 == 8192) goto L11;
            return false;
        L11:
            if (this.f161201a.canScrollVertically(-1) == false) goto L14;
            LiveVerticalViewPager r103 = this.f161201a;
            r103.setCurrentItem(r103.f161167u - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f161201a.canScrollVertically(1) == false) goto L19;
            LiveVerticalViewPager r104 = this.f161201a;
            r104.setCurrentItem(r104.f161167u + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface p {
    }

    public interface q {
    }

    public class r extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f161202a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f161202a.l();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f161202a.l();
        }

        public r(LiveVerticalViewPager r100) {
            this.f161202a = r100;
        }
    }

    static {
        f161122h3 = new int[]{android.R.attr.layout_gravity};
        f161123i3 = new a();
        f161124j3 = new b();
        f161125k3 = new c();
        f161126l3 = new d();
        Field r100 = PagerAdapter.class.getDeclaredField("mViewPagerObserver");     // Catch: NoSuchFieldException -> L5
        f161127m3 = r100;     // Catch: NoSuchFieldException -> L5
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final boolean B() {
        this.H0 = -1;
        this.Q = false;
        this.R = false;
        setIgnoreSpeed(false);
        VelocityTracker r100 = this.P0;
        if (r100 == null) goto L5;
        r100.recycle();
        this.P0 = null;
    L5:
        com.bytedance.android.livesdk.widget.n r101 = this.H1;
        r101.f161867a.onRelease();
        boolean r102 = r101.f161867a.isFinished();
        com.bytedance.android.livesdk.widget.n r103 = this.L1;
        r103.f161867a.onRelease();
        return r102 | r103.f161867a.isFinished();
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.A = true;
        if (this.f161178z.isFinished() == false) goto L5;
    L14:
        k(true);
        return;
    L5:
        if (this.f161178z.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f161178z.getCurrX();
        int r103 = this.f161178z.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (w(r103) == true) goto L12;
        this.f161178z.abortAnimation();
        scrollTo(r102, 0);
        goto L12
    }

    public int getNextItem() {
        int r100 = -1;
        int r101 = 0;
    L4:
        if (r101 >= this.f161163q.size()) goto L12;
        if (((m) ListProtector.get(this.f161163q, r101)).f161197b != this.f161167u) goto L11;
        if (r101 < (this.f161163q.size() - 1)) goto L10;
        r100 = this.f161167u;
        goto L11
    L10:
        r100 = ((m) ListProtector.get(this.f161163q, r101 + 1)).f161197b;
    L11:
        r101 = r101 + 1;
        goto L4
    L12:
        return r100;
    }

    public ViewGroup getViewGroup() {
        return this;
    }

    public void setDispatchTouchListener(b2 r100) {
    }

    public void setOnAdapterChangeListener(p r100) {
    }

    public final void t() {
        int r100 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r101 = getContext();
        if (LiveScrollSwitchConfigHelper.a().c() == false) goto L5;
        int r102 = LiveScrollSwitchConfigHelper.a().d();
    L7:
        if (r102 != 1) goto L10;
        ALogger.e("LiveVerticalViewPager", "S_INTERPOLATOR_1");
        this.f161178z = new Scroller(r101, f161125k3);
    L16:
        ViewConfiguration r103 = ViewConfiguration.get(r101);
        Resources r104 = r101.getResources();
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        this.U = ViewConfigurationCompat.getScaledPagingTouchSlop(r103);
        DrawScrollStrategy.f160812c = (int) (DrawScrollStrategy.d() * r105);
        DrawScrollStrategy.f160813d = DrawScrollStrategy.b();
        DrawScrollStrategy.f160814e = DrawScrollStrategy.e();
        DrawScrollStrategy.f160815f = DrawScrollStrategy.a();
        DrawScrollStrategy.f160816g = (int) (DrawScrollStrategy.c() * r105);
        DrawScrollStrategy.f160811b = r105;
        this.V0 = (int) (400.0f * r105);
        this.f161161p1 = 0.6f;
        this.f161154k1 = 0.4f;
        this.f161144g1 = (int) (25.0f * r105);
        this.f161132b1 = r103.getScaledMaximumFlingVelocity();
        this.H1 = new com.bytedance.android.livesdk.widget.n(r101);
        this.L1 = new com.bytedance.android.livesdk.widget.n(r101);
        this.f161148h1 = (int) (2.0f * r105);
        this.S = (int) (r105 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new o(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L20;
        ViewCompat.setImportantForAccessibility(this, 1);
    L20:
        if (j40.h0.f497231a.getValue().booleanValue() == false) goto L22;
        ALogger.d("LiveVerticalViewPager", "set inset listener null");
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        return;
    L22:
        ALogger.d("LiveVerticalViewPager", "set inset listener origin");
        ViewCompat.setOnApplyWindowInsetsListener(this, new f(this));
        return;
    L10:
        if (LiveScrollSwitchConfigHelper.a().c() == false) goto L13;
        r100 = LiveScrollSwitchConfigHelper.a().d();
    L13:
        if (r100 != 2) goto L15;
        this.f161178z = new Scroller(r101, f161126l3);
        ALogger.e("LiveVerticalViewPager", "S_INTERPOLATOR_2");
        goto L16
    L15:
        this.f161178z = new Scroller(r101, f161124j3);
        ALogger.e("LiveVerticalViewPager", "S_INTERPOLATOR");
        goto L16
    L5:
        r102 = 0;
        goto L7
    }

    private float getDownDistance() {
        boolean r100 = DrawScrollStrategy.f160810a;
        if (DrawScrollStrategy.f160810a == false) goto L14;
        if (DrawScrollStrategy.f160817h > 0) goto L7;
    L11:
        float r101 = 1;
        return r101 - ((r101 - DrawScrollStrategy.f160813d) * DrawScrollStrategy.f160815f);
    L7:
        if (DrawScrollStrategy.f160819j <= 0) goto L11;
        if ((System.currentTimeMillis() - DrawScrollStrategy.f160817h) <= ((DrawScrollStrategy.f160819j * DrawScrollStrategy.f160820k.h()) * 1000)) goto L11;
        return DrawScrollStrategy.f160813d;
    L14:
        return this.f161161p1;
    }

    private int getFlingDistance() {
        boolean r100 = DrawScrollStrategy.f160810a;
        if (DrawScrollStrategy.f160810a == false) goto L7;
        return DrawScrollStrategy.f160816g;
    L7:
        return this.f161144g1;
    }

    private int getFlingVelocity() {
        boolean r100 = DrawScrollStrategy.f160810a;
        if (DrawScrollStrategy.f160810a == false) goto L7;
        return DrawScrollStrategy.f160812c;
    L7:
        return this.V0;
    }

    private float getUpDistance() {
        boolean r100 = DrawScrollStrategy.f160810a;
        if (DrawScrollStrategy.f160810a == false) goto L14;
        if (DrawScrollStrategy.f160817h <= 0) goto L12;
        if (DrawScrollStrategy.f160819j <= 0) goto L12;
        if ((System.currentTimeMillis() - DrawScrollStrategy.f160817h) <= ((DrawScrollStrategy.f160819j * DrawScrollStrategy.f160820k.h()) * 1000)) goto L12;
        return DrawScrollStrategy.f160814e;
    L12:
        return DrawScrollStrategy.f160814e * DrawScrollStrategy.f160815f;
    L14:
        return this.f161154k1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // cs1.b
    public float getViewTouchSlop() {
        return this.U;
    }

    public final void i() {
        if (this.Q == false) goto L5;
        return;
    L5:
        this.f161169v1 = true;
        setScrollState(1);
        this.W = 0.0f;
        this.f161160p0 = 0.0f;
        VelocityTracker r100 = this.P0;
        if (r100 != null) goto L8;
        this.P0 = VelocityTracker.obtain();
    L9:
        long r101 = SystemClock.uptimeMillis();
        MotionEvent r102 = MotionEvent.obtain(r101, r101, 0, 0.0f, 0.0f, 0);
        this.P0.addMovement(r102);
        r102.recycle();
        this.f161173x1 = r101;
        return;
    L8:
        r100.clear();
        goto L9
    }

    public final void l() {
        int r100 = this.f161166t.getCount();
        if (y8.f162554c == false) goto L10;
        if (this.f161163q.size() < ((this.O + this.P) + 1)) goto L7;
    L14:
        boolean r101 = false;
    L15:
        int r102 = this.f161167u;
        int r103 = 0;
        boolean r104 = false;
    L17:
        if (r103 >= this.f161163q.size()) goto L37;
        m r105 = (m) ListProtector.get(this.f161163q, r103);
        int r106 = this.f161166t.getItemPosition(r105.f161196a);
        if (r106 == (-1)) goto L36;
        if (r106 != (-2)) goto L29;
        ListProtector.remove(this.f161163q, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L26;
        this.f161166t.startUpdate(this);
        r104 = true;
    L26:
        this.f161166t.destroyItem(this, r105.f161197b, r105.f161196a);
        int r107 = this.f161167u;
        if (r107 != r105.f161197b) goto L35;
        r102 = Math.max(0, Math.min(r107, (-1) + r100));
    L35:
        r101 = true;
        goto L36
    L29:
        int r108 = r105.f161197b;
        if (r108 == r106) goto L36;
        if (r108 != this.f161167u) goto L34;
        r102 = r106;
    L34:
        r105.f161197b = r106;
    L36:
        r103 = r103 + 1;
        goto L17
    L37:
        if (r104 == false) goto L39;
        this.f161166t.finishUpdate(this);
    L39:
        Collections.sort(this.f161163q, f161123i3);
        if (y8.f162552a.booleanValue() == false) goto L42;
        this.V1 = true;
    L42:
        if (r101 == false) goto L61;
        int r109 = getChildCount();
        int r110 = 0;
    L44:
        if (r110 >= r109) goto L50;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.f161179a == true) goto L48;
        r111.f161181c = 0.0f;
    L48:
        r110 = r110 + 1;
        goto L44
    L50:
        if (j40.l0.f497255a.getValue().booleanValue() == false) goto L52;
        this.V1 = true;
    L52:
        E(r102, false, true, 0);
        requestLayout();
        return;
    L61:
        return;
    L7:
        if (this.f161163q.size() >= r100) goto L14;
    L13:
        r101 = true;
        goto L15
    L10:
        if (this.f161163q.size() >= ((this.N * 2) + 1)) goto L14;
        if (this.f161163q.size() >= r100) goto L14;
        goto L13
    }

    public final void n() {
        if (this.f161169v1 == false) goto L13;
        if (this.f161166t == null) goto L7;
        VelocityTracker r100 = this.P0;
        r100.computeCurrentVelocity(1000, this.f161132b1);
        int r101 = (int) VelocityTrackerCompat.getYVelocity(r100, this.H0);
        this.M = true;
        int r102 = getClientHeight();
        int r103 = getScrollY();
        m r104 = r();
        E(m(r104.f161197b, ((r103 / r102) - r104.f161200e) / r104.f161199d, r101, (int) (this.W - this.f161160p0)), true, true, r101);
    L7:
        this.Q = false;
        this.R = false;
        setIgnoreSpeed(false);
        VelocityTracker r105 = this.P0;
        if (r105 == null) goto L10;
        r105.recycle();
        this.P0 = null;
    L10:
        this.f161169v1 = false;
        return;
    L13:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f161157n == true) goto L7;
        MediatorLiveData r100 = this.f161155l;
        if (r100 == null) goto L7;
        r100.removeObserver(this.f161156m);
        this.f161155l = null;
    L7:
        removeCallbacks(this.S2);
        Scroller r101 = this.f161178z;
        if (r101 != null) goto L10;
    L12:
        super.onDetachedFromWindow();
        this.f161146g3 = null;
        return;
    L10:
        if (r101.isFinished() == true) goto L12;
        this.f161178z.abortAnimation();
        goto L12
    }

    public final void y() {
        z(this.f161167u);
    }

    private int getClickPosition() {
        int r100 = getMeasuredWidth();
        int r101 = getMeasuredHeight();
        int r102 = r100 / 3;
        int r103 = 2;
        int r104 = (r100 * 2) / 3;
        int r105 = r101 / 3;
        int r106 = (r101 * 2) / 3;
        float r107 = this.f161153k0;
        if (0.0f > r107) goto L8;
        if (r107 > r102) goto L8;
        r103 = 1;
    L13:
        float r108 = this.f161160p0;
        if (0.0f > r108) goto L19;
        if (r108 > r105) goto L19;
        return r103;
    L19:
        if (r105 >= r108) goto L24;
        if (r108 > r106) goto L24;
        return r103 + 3;
    L24:
        return r103 + 6;
    L8:
        if (r102 < r107) goto L10;
    L12:
        r103 = 3;
        goto L13
    L10:
        if (r107 > r104) goto L12;
        goto L12
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final int C() {
        int r100 = getClientHeight();
        int r101 = getScrollY();
        m r102 = r();
        float r103 = r100;
        float r104 = this.D / r103;
        int r105 = r102.f161197b;
        float r106 = ((r101 / r103) - r102.f161200e) / (r102.f161199d + r104);
        if (r105 < this.f161167u) goto L5;
        float r107 = LiveScrollSwitchConfigHelper.a().a();
    L6:
        int r108 = (int) ((r105 + r106) + r107);
        if (this.f161163q.size() <= 0) goto L10;
        m r109 = (m) ListProtector.get(this.f161163q, 0);
        ArrayList<m> r110 = this.f161163q;
        return Math.max(r109.f161197b, Math.min(r108, ((m) ListProtector.get(r110, r110.size() - 1)).f161197b));
    L10:
        return r108;
    L5:
        r107 = LiveScrollSwitchConfigHelper.a().g();
        goto L6
    }

    @Override // cs1.b
    public final MotionEvent c() {
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), this.Z2, this.X2, this.Y2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.E;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S1 = true;
        if (LiveScrollSwitchConfigHelper.a().c() == false) goto L5;
        int r100 = LiveScrollSwitchConfigHelper.a().e();
    L6:
        this.f161129a = r100;
        if (this.f161157n == true) goto L11;
        MediatorLiveData r101 = this.f161155l;
        if (r101 == null) goto L11;
        r101.observeForever(this.f161156m);
    L16:
        Double r102 = j40.f1.f497195a.getValue();
        if (r102.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        return;
    L19:
        if (r102.doubleValue() >= 180.0d) goto L23;
        double r103 = r102.doubleValue();
        this.f161143g = r103;
        this.f161147h = Math.tan(Math.toRadians(90.0d - (r103 / 2.0d)));
        ALogger.i("InnerSlideStrategyHelper", "Current landScrollAngle is " + this.f161143g);
        return;
    L23:
        return;
    L11:
        Double r104 = j40.p2.f497281a.getValue();
        if (r104.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        if (r104.doubleValue() >= 180.0d) goto L16;
        double r105 = r104.doubleValue();
        this.f161131b = r105;
        this.f161135c = Math.tan(Math.toRadians(90.0d - (r105 / 2.0d)));
        goto L16
    L5:
        r100 = 600;
        goto L6
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f161184a = this.f161167u;
        PagerAdapter r101 = this.f161166t;
        if (r101 == null) goto L5;
        r100.f161185b = r101.saveState();
    L5:
        return r100;
    }

    public final m r() {
        int r100 = getClientHeight();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollY() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.D / r100;
    L9:
        m r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.f161163q.size()) goto L30;
        m r110 = (m) ListProtector.get(this.f161163q, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.f161197b == r109) goto L17;
        r110 = this.f161164r;
        r110.f161200e = (r101 + r105) + r103;
        r110.f161197b = r109;
        r110.f161199d = this.f161166t.getPageWidth(r109);
        r107 = r107 - 1;
    L17:
        m r111 = r110;
        r101 = r111.f161200e;
        float r112 = (r111.f161199d + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.f161163q.size() - 1)) goto L29;
        int r113 = r111.f161197b;
        float r114 = r111.f161199d;
        r107 = r107 + 1;
        r108 = false;
        r106 = r113;
        r105 = r114;
        r104 = r111;
    L29:
        return r111;
    L30:
        return r104;
    L8:
        r103 = 0.0f;
        goto L9
    L5:
        r102 = 0.0f;
        goto L6
    }

    public PagerAdapter getAdapter() {
        return this.f161166t;
    }

    public int getCurrentItem() {
        return this.f161167u;
    }

    public float getInitialMotionY() {
        return this.f161160p0;
    }

    public int getOffscreenPageLimit() {
        return this.N;
    }

    public int getOffscreenPageLimitHigh() {
        return this.P;
    }

    public int getOffscreenPageLimitLow() {
        return this.O;
    }

    public int getPageMargin() {
        return this.D;
    }

    public int getPreItem() {
        return this.f161168v;
    }

    public int getScrollSource() {
        return this.U2;
    }

    public int getScrollState() {
        return this.T2;
    }

    public double getTanValue() {
        return this.f161135c;
    }

    public int getWatchedIndex() {
        return this.W2;
    }

    public LiveVerticalViewPager(Context r100) {
        super(r100);
        this.f161129a = 600;
        this.f161131b = -1.0d;
        this.f161135c = 1.0d;
        this.f161137d = 1.0d;
        this.f161139e = j40.q2.f497287a.getValue().booleanValue();
        this.f161141f = 1.0d;
        this.f161143g = -1.0d;
        this.f161147h = -1.0d;
        this.f161150i = false;
        this.f161155l = com.bytedance.android.livesdk.utils.q2.a();
        this.f161156m = new w1(this);
        this.f161158o = true;
        this.f161159p = true;
        this.f161163q = new ArrayList();
        this.f161164r = new m();
        this.f161165s = new Rect();
        this.f161171w = -1;
        this.f161172x = null;
        this.f161175y = null;
        this.H = -3.4028235E38f;
        this.I = Float.MAX_VALUE;
        this.N = 1;
        this.O = 1;
        this.P = 1;
        this.H0 = -1;
        this.L0 = Boolean.valueOf(j40.t.f497299a.getValue().a());
        this.f161154k1 = 0.4f;
        this.f161161p1 = 0.6f;
        this.f161176y1 = true;
        this.G1 = true;
        this.M1 = false;
        this.P1 = false;
        this.Q1 = null;
        this.S1 = true;
        this.V1 = false;
        this.f161145g2 = false;
        this.f161149h2 = true;
        this.f161162p2 = false;
        this.f161170v2 = -1;
        this.f161174x2 = LandscapeLiveMonitor.sampleInterval();
        this.f161177y2 = false;
        this.E2 = com.bytedance.android.livesdk.x0.f162533a.getValue().getEnterFromLimit();
        LiveDrawOverlayConfig r101 = t5.f65417a.getValue();
        this.L2 = 1.0f;
        this.M2 = false;
        this.N2 = false;
        this.O2 = com.bytedance.android.livesdk.y2.f162546a.getValue().booleanValue();
        this.P2 = false;
        this.Q2 = false;
        this.R2 = false;
        this.S2 = new e(this);
        this.T2 = 0;
        this.U2 = 0;
        this.V2 = 0;
        this.W2 = 0;
        this.X2 = 0.0f;
        this.Y2 = 0.0f;
        this.Z2 = 0;
        this.f161130a3 = 0;
        this.f161134b3 = 0.0f;
        this.f161136c3 = 0.0f;
        this.f161138d3 = false;
        this.f161140e3 = new ArrayList();
        this.f161142f3 = new ArrayList();
        this.f161146g3 = null;
        t();
    }

    public static /* synthetic */ void f(LiveVerticalViewPager r100) {
        r100.setScrollState(0);
    }

    private void setScrollState(int r100) {
        if (this.T2 != r100) goto L5;
        return;
    L5:
        this.T2 = r100;
        ViewPager.OnPageChangeListener r101 = this.G2;
        if (r101 == null) goto L9;
        r101.onPageScrollStateChanged(r100);
        return;
    }

    private void setScrollingCacheEnabled(boolean r100) {
        if (this.L == r100) goto L6;
        this.L = r100;
        return;
    }

    @Override // cs1.b
    public final void a(com.bytedance.android.livesdk.tetris.e r100) {
        this.f161142f3.add(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L12;
        m r103 = q(r102);
        if (r103 == null) goto L12;
        if (r103.f161197b != this.f161167u) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    @Override // cs1.b
    public final void b(com.bytedance.android.livesdk.tetris.e r100) {
        this.f161142f3.remove(r100);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f161166t != null) goto L5;
        return false;
    L5:
        int r101 = getClientHeight();
        int r102 = getScrollY();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.I))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.H))) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r100) == false) goto L7;
        return true;
    }

    @Override // cs1.b
    public final boolean d(MotionEvent r100) {
        this.U2 = 1;
        return dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets r100) {
        if (j40.h0.f497231a.getValue().booleanValue() == false) goto L6;
        return r100;
    L6:
        return super.dispatchApplyWindowInsets(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
        return true;
    L5:
        if (r100.getAction() != 0) goto L21;
        int r101 = r100.getKeyCode();
        if (r101 != 21) goto L9;
        boolean r102 = h(17);
    L22:
        if (r102 == true) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r101 != 22) goto L11;
        r102 = h(66);
        goto L22
    L11:
        if (r101 != 61) goto L21;
        if (r100.hasNoModifiers() == false) goto L17;
        r102 = h(2);
        goto L22
    L17:
        if (r100.hasModifiers(1) == false) goto L21;
        r102 = h(1);
    L21:
        r102 = false;
        goto L22
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        if (r100.getEventType() == 4096) goto L5;
        int r101 = getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L19;
        View r103 = getChildAt(r102);
        if (r103.getVisibility() != 0) goto L18;
        m r104 = q(r103);
        if (r104 == null) goto L18;
        if (r104.f161197b != this.f161167u) goto L18;
        if (r103.dispatchPopulateAccessibilityEvent(r100) == false) goto L18;
        return true;
    L18:
        r102 = r102 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        boolean r101 = false;
        if (r100 == 0) goto L41;
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L43;
    L45:
        this.X2 = r110.getX();
        this.Y2 = r110.getY();
        this.Z2 = r110.getAction();
        if (r110.getAction() != 3) goto L48;
    L49:
        this.U2 = 0;
    L51:
        if (r110.getAction() != 0) goto L58;
        ArrayList<j> r102 = this.f161140e3;
        if (r102 == null) goto L58;
        Iterator<j> r103 = r102.iterator();
    L56:
        if (r103.hasNext() == false) goto L58;
        r103.next().a(r110);
    L58:
        Iterator<cs1.b.a> r104 = this.f161142f3.iterator();
    L60:
        if (r104.hasNext() == false) goto L62;
        r104.next().c(r110);
        goto L60
    L62:
        gb1 r105 = y51.f121658b;
        if (r105.enableMoveSampling == true) goto L65;
    L67:
        if (r101 == false) goto L89;
        int r106 = r110.getAction();
        int r107 = r105.policy;
        int r108 = r105.interval;
        if (r107 != 0) goto L76;
        long r109 = System.currentTimeMillis();
        if (r106 == 2) goto L73;
    L75:
        this.f161130a3 = r109;
    L87:
        return super.dispatchTouchEvent(r110);
    L73:
        if ((r109 - this.f161130a3) >= r108) goto L75;
        ALogger.d("MoveSampling", "drop[span: " + (r109 - this.f161130a3) + "]");
        return true;
    L76:
        if (r107 != 1) goto L87;
        if (r106 != 2) goto L85;
        long r111 = System.currentTimeMillis();
        long r112 = this.f161130a3;
        if (r112 > 0) goto L82;
    L84:
        this.f161130a3 = r111;
        goto L87
    L82:
        if ((r111 - r112) >= r108) goto L84;
        ALogger.d("MoveSampling", "drop[span: " + (r111 - this.f161130a3) + "]");
        return true;
    L85:
        this.f161130a3 = 0;
        goto L87
    L89:
        return super.dispatchTouchEvent(r110);
    L65:
        if (y51.f121657a == false) goto L67;
        r101 = true;
        goto L67
    L48:
        if (r110.getAction() != 1) goto L51;
    L43:
        if (Math.abs(r110.getY() - this.f161134b3) < this.f161144g1) goto L45;
        this.f161138d3 = true;
        goto L45
    L8:
        if (r110.getY() <= this.f161134b3) goto L10;
        int r113 = 1;
    L12:
        if (this.L0.booleanValue() == false) goto L14;
    L16:
        float r114 = r110.getY() - this.f161134b3;
        if (Math.abs(r110.getX() - this.f161136c3) <= this.U) goto L19;
    L20:
        n r115 = this.I2;
        if (r115 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.community.innerfeed.g r116 = ((com.bytedance.android.livesdk.chatroom.newcontainer.business.community.innerfeed.a) r115).f107322a;
        if (r114 >= 0.0f) goto L40;
        ((ik1.b) r116.f526494a).B.getClass();
        if (com.bytedance.android.livesdk.live.f.a() == false) goto L45;
        ILiveRoomListProvider r117 = ((ik1.b) r116.f526494a).f490186c;
        if ((r117 instanceof DrawRoomListProvider) == false) goto L45;
        if (r116.f107328b.f510527p != (r117.size() - 1)) goto L45;
        com.bytedance.android.livesdk.live.f r118 = ((ik1.b) r116.f526494a).B;
        if (r118.f147478b == true) goto L45;
        com.bytedance.android.livesdk.model.q r119 = ge.f120273a.getValue().b();
        if (r119 == null) goto L45;
        if (r119.a(r118.f147479c) == false) goto L45;
        r118.f147478b = true;
        r118.f147480d.removeMessages(10086);
        Message r120 = Message.obtain(r118.f147480d, 10086);
        r120.arg1 = 2;
        r118.f147480d.sendMessage(r120);
        goto L45
    L40:
        r116.getClass();
        goto L45
    L19:
        if (Math.abs(r114) <= this.U) goto L45;
    L14:
        if (this.f161138d3 == false) goto L16;
        xs2.b.a().post(new zg1.y(true, r113, getClickPosition(), getCurrentItem()));
        goto L16
    L10:
        r113 = 2;
        goto L12
    L41:
        this.f161138d3 = false;
        this.f161134b3 = r110.getY();
        this.f161136c3 = r110.getX();
        goto L43
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        super.draw(r110);     // Catch: Throwable -> L35
        int r100 = ViewCompat.getOverScrollMode(this);     // Catch: Throwable -> L35
        if (r100 == 0) goto L12;
        if (r100 != 1) goto L10;
        PagerAdapter r101 = this.f161166t;     // Catch: Throwable -> L35
        if (r101 == null) goto L10;
        if (r101.getCount() > 1) goto L12;
    L10:
        this.H1.f161867a.finish();     // Catch: Throwable -> L35
        this.L1.f161867a.finish();     // Catch: Throwable -> L35
        boolean r102 = false;
    L26:
        if (r102 == false) goto L29;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: Throwable -> L35
        return;
    L29:
        if (this.M1 == false) goto L32;
        this.M1 = false;     // Catch: Throwable -> L35
    L32:
        if (this.P1 == false) goto L40;
        this.P1 = false;     // Catch: Throwable -> L35
        return;
    L40:
        return;
    L12:
        if (this.H1.f161867a.isFinished() == true) goto L18;
        int r103 = r110.save();     // Catch: Throwable -> L35
        int r104 = getHeight();     // Catch: Throwable -> L35
        int r105 = (getWidth() - getPaddingLeft()) - getPaddingRight();     // Catch: Throwable -> L35
        r110.translate(getPaddingLeft(), this.H * r104);     // Catch: Throwable -> L35
        this.H1.f161867a.setSize(r105, r104);     // Catch: Throwable -> L35
        r102 = this.H1.f161867a.draw(r110) | false;     // Catch: Throwable -> L35
        r110.restoreToCount(r103);     // Catch: Throwable -> L35
        if (this.M1 == true) goto L20;
        this.M1 = true;     // Catch: Throwable -> L35
        if (this.Q1 == null) goto L20;
        post(new h(this));     // Catch: Throwable -> L35
    L20:
        if (this.L1.f161867a.isFinished() == true) goto L26;
        int r106 = r110.save();     // Catch: Throwable -> L35
        int r107 = getHeight();     // Catch: Throwable -> L35
        int r108 = (getWidth() - getPaddingLeft()) - getPaddingRight();     // Catch: Throwable -> L35
        r110.rotate(180.0f);     // Catch: Throwable -> L35
        r110.translate((-r108) - getPaddingLeft(), (-(this.I + 1.0f)) * r107);     // Catch: Throwable -> L35
        this.L1.f161867a.setSize(r108, r107);     // Catch: Throwable -> L35
        r102 = r102 | this.L1.f161867a.draw(r110);     // Catch: Throwable -> L35
        r110.restoreToCount(r106);     // Catch: Throwable -> L35
        if (this.P1 == true) goto L26;
        this.P1 = true;     // Catch: Throwable -> L35
        if (this.Q1 == null) goto L26;
        post(new i(this));     // Catch: Throwable -> L35
        goto L26
    L18:
        r102 = false;
    L35:
        th = move-exception;
        ALogger.e("LiveVerticalViewPager", th);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final boolean h(int r100) {
        View r101 = findFocus();
        boolean r102 = true;
        boolean r103 = false;
        if (r101 == this) goto L19;
        if (r101 == null) goto L20;
        ViewParent r104 = r101.getParent();
    L8:
        if ((r104 instanceof ViewGroup) == false) goto L12;
        if (r104 == this) goto L10;
        r104 = r104.getParent();
        goto L8
    L10:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L20;
        ViewParent r106 = r101.getParent();
    L16:
        if ((r106 instanceof ViewGroup) == false) goto L19;
        r106.getClass();
        r106 = r106.getParent();
        goto L16
    L12:
        r105 = false;
    L20:
        View r107 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        if (r107 == null) goto L42;
        if (r107 == r101) goto L42;
        if (r100 != 33) goto L32;
        int r108 = p(this.f161165s, r107).top;
        int r109 = p(this.f161165s, r101).top;
        if (r101 == null) goto L30;
        if (r108 < r109) goto L30;
        int r110 = this.f161167u;
        if (r110 <= 0) goto L56;
        setCurrentItem(r110 - 1, true);
    L57:
        r103 = r102;
    L58:
        if (r103 == false) goto L60;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r100));
    L60:
        return r103;
    L56:
        r102 = false;
    L30:
        boolean r111 = r107.requestFocus();
    L31:
        r103 = r111;
        goto L58
    L32:
        if (r100 != 130) goto L58;
        int r112 = p(this.f161165s, r107).bottom;
        int r113 = p(this.f161165s, r101).bottom;
        if (r101 == null) goto L41;
        if (r112 > r113) goto L41;
        PagerAdapter r114 = this.f161166t;
        if (r114 == null) goto L56;
        if (this.f161167u >= (r114.getCount() - 1)) goto L56;
        setCurrentItem(this.f161167u + 1, true);
    L41:
        r111 = r107.requestFocus();
    L42:
        if (r100 == 33) goto L53;
        if (r100 == 1) goto L53;
        if (r100 != 130) goto L47;
    L48:
        PagerAdapter r115 = this.f161166t;
        if (r115 == null) goto L56;
        if (this.f161167u >= (r115.getCount() - 1)) goto L56;
        setCurrentItem(this.f161167u + 1, true);
        goto L57
    L47:
        if (r100 != 2) goto L58;
    L53:
        int r116 = this.f161167u;
        if (r116 <= 0) goto L56;
        setCurrentItem(r116 - 1, true);
    L19:
        r101 = null;
        goto L20
    }

    public final void k(boolean r100) {
        if (this.T2 != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        setScrollingCacheEnabled(false);
        if ((!this.f161178z.isFinished()) == false) goto L16;
        this.f161178z.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.f161178z.getCurrX();
        int r105 = this.f161178z.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L18;
    L12:
        scrollTo(r104, r105);
        if (r105 == r103) goto L18;
        w(r105);
        goto L18
    L16:
        if (this.f161178z.getCurrY() == getScrollY()) goto L18;
        this.f161178z.getCurrY();
        getScrollY();
        scrollTo(this.f161178z.getCurrX(), this.f161178z.getCurrY());
        com.bytedance.android.live.core.utils.rxutils.j.a r106 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        com.bytedance.android.live.core.utils.rxutils.j.c(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
    L18:
        this.M = false;
        int r107 = 0;
    L20:
        if (r107 >= this.f161163q.size()) goto L25;
        m r108 = (m) ListProtector.get(this.f161163q, r107);
        if (r108.f161198c == false) goto L24;
        r108.f161198c = false;
        r101 = true;
    L24:
        r107 = r107 + 1;
        goto L20
    L25:
        if (r101 == false) goto L33;
        if (r100 == false) goto L28;
        ViewCompat.postOnAnimation(this, this.S2);
        return;
    L28:
        this.S2.run();
        return;
    L33:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void o(float r110) {
        if (this.f161169v1 == false) goto L22;
        if (this.f161166t != null) goto L7;
        return;
    L7:
        this.W += r110;
        float r100 = getScrollY() - r110;
        float r111 = getClientHeight();
        float r101 = this.H * r111;
        float r102 = this.I * r111;
        m r103 = (m) ListProtector.get(this.f161163q, 0);
        ArrayList<m> r104 = this.f161163q;
        m r105 = (m) ListProtector.get(r104, r104.size() - 1);
        if (r103.f161197b == 0) goto L11;
        r101 = r103.f161200e * r111;
    L11:
        if (r105.f161197b == (this.f161166t.getCount() - 1)) goto L14;
        r102 = r105.f161200e * r111;
    L14:
        if (r100 >= r101) goto L17;
        r100 = r101;
    L19:
        int r106 = (int) r100;
        this.W += r100 - r106;
        scrollTo(getScrollX(), r106);
        w(r106);
        MotionEvent r112 = MotionEvent.obtain(this.f161173x1, SystemClock.uptimeMillis(), 2, 0.0f, this.W, 0);
        this.P0.addMovement(r112);
        r112.recycle();
        return;
    L17:
        if (r100 <= r102) goto L19;
        r100 = r102;
        goto L19
    L22:
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.D > 0) goto L5;
        return;
    L5:
        if (this.E != null) goto L7;
        return;
    L7:
        if (this.f161163q.size() > 0) goto L9;
        return;
    L9:
        if (this.f161166t == null) goto L34;
        int r100 = getScrollY();
        int r101 = getHeight();
        float r102 = r101;
        float r103 = this.D / r102;
        int r104 = 0;
        m r105 = (m) ListProtector.get(this.f161163q, 0);
        float r106 = r105.f161200e;
        int r107 = this.f161163q.size();
        int r108 = r105.f161197b;
        int r111 = ((m) ListProtector.get(this.f161163q, r107 - 1)).f161197b;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.f161197b;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (m) ListProtector.get(this.f161163q, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.f161200e;
        float r113 = r105.f161199d;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L19:
        int r115 = this.D;
        if ((r115 + r114) <= r100) goto L24;
        this.E.setBounds(this.F, (int) r114, this.G, (int) ((r115 + r114) + 0.5f));
        this.E.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        float r116 = this.f161166t.getPageWidth(r108);
        r114 = (r106 + r116) * r102;
        r106 = r106 + (r116 + r103);
        goto L19
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        com.bytedance.android.livesdk.vs.a r100 = this.H2;
        if (r100 == null) goto L8;
        if (r100.onInterceptTouchEvent(r110) == false) goto L8;
        return false;
    L8:
        if (isEnabled() == true) goto L11;
        return false;
    L11:
        if (this.f161176y1 == true) goto L14;
        return false;
    L14:
        if (this.G1 == true) goto L17;
        return false;
    L17:
        if (r110.getAction() != 0) goto L26;
        float r101 = r110.getY();
        if (r101 > this.f161151j) goto L21;
    L23:
        boolean r102 = false;
    L24:
        this.B = r102;
        goto L26
    L21:
        if (r101 >= this.f161152k) goto L23;
        r102 = true;
    L26:
        if (this.B == false) goto L181;
        return false;
    L181:
    L177:
        e = move-exception;
        e.printStackTrace();
    L180:
        return this.Q;
    L29:
        if (this.f161169v1 == false) goto L31;
        return false;
    L31:
        int r103 = r110.getAction() & 255;     // Catch: IllegalArgumentException -> L177
        if (r103 == 3) goto L174;
        if (r103 == 1) goto L174;
        if (r103 == 0) goto L43;
        if (this.Q == false) goto L40;
        return true;
    L40:
        if (this.R == false) goto L43;
        return false;
    L43:
        if (r103 == 0) goto L154;
        if (r103 != 2) goto L46;
        int r104 = this.H0;     // Catch: IllegalArgumentException -> L177
        if (r104 == (-1)) goto L171;
        int r105 = MotionEventCompat.findPointerIndex(r110, r104);     // Catch: IllegalArgumentException -> L177
        float r106 = MotionEventCompat.getY(r110, r105);     // Catch: IllegalArgumentException -> L177
        float r107 = r106 - this.W;     // Catch: IllegalArgumentException -> L177
        float r108 = Math.abs(r107);     // Catch: IllegalArgumentException -> L177
        float r109 = MotionEventCompat.getX(r110, r105);     // Catch: IllegalArgumentException -> L177
        float r111 = Math.abs(r109 - this.f161153k0);     // Catch: IllegalArgumentException -> L177
        int r112 = (r107 > 0.0f ? 1 : (r107 == 0.0f ? 0 : -1));
        if (r112 == 0) goto L69;
        float r113 = this.W;     // Catch: IllegalArgumentException -> L177
        if (r113 >= this.T) goto L58;
        if (r112 <= 0) goto L58;
    L61:
        boolean r114 = true;
    L63:
        if (r114 == true) goto L69;
        if (j(this, false, (int) r107, (int) r109, (int) r106) == false) goto L69;
        this.V = r109;     // Catch: IllegalArgumentException -> L177
        this.W = r106;     // Catch: IllegalArgumentException -> L177
        this.R = true;     // Catch: IllegalArgumentException -> L177
        return false;
    L58:
        if (r113 > (getHeight() - this.T)) goto L60;
    L62:
        r114 = false;
        goto L63
    L60:
        if (r107 >= 0.0f) goto L62;
    L69:
        if (this.f161150i == true) goto L71;
    L86:
        int r115 = r112;
        if (this.f161131b > AudioStats.AUDIO_AMPLITUDE_NONE) goto L89;
    L114:
        float r116 = this.U;     // Catch: IllegalArgumentException -> L177
        if (r108 > r116) goto L117;
    L119:
        boolean r117 = false;
    L121:
        if (r111 <= r116) goto L124;
    L122:
        boolean r118 = r117;
    L123:
        boolean r119 = true;
    L126:
        if (r118 == false) goto L143;
        this.Q = true;     // Catch: IllegalArgumentException -> L177
        ViewParent r120 = getParent();     // Catch: IllegalArgumentException -> L177
        if (r120 == null) goto L130;
        r120.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L177
    L130:
        setScrollState(1);     // Catch: IllegalArgumentException -> L177
        if (r107 >= 0.0f) goto L133;
        boolean r121 = true;
    L134:
        ViewPager.OnPageChangeListener r122 = this.G2;     // Catch: IllegalArgumentException -> L177
        if (r122 != null) goto L137;
    L139:
        if (r115 <= 0) goto L141;
        float r123 = this.f161160p0 + this.U;     // Catch: IllegalArgumentException -> L177
    L142:
        this.W = r123;     // Catch: IllegalArgumentException -> L177
        this.V = r109;     // Catch: IllegalArgumentException -> L177
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L177
    L146:
        if (this.Q == false) goto L171;
        e0 r124 = this.K2;     // Catch: IllegalArgumentException -> L177
        if (r124 == null) goto L151;
        ((pg2.h) r124).a(r110);     // Catch: IllegalArgumentException -> L177
    L151:
        if (x(r106) == false) goto L171;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalArgumentException -> L177
        goto L171
    L141:
        r123 = this.f161160p0 - this.U;     // Catch: IllegalArgumentException -> L177
        goto L142
    L137:
        if ((r122 instanceof IExtPageChangeListener) == false) goto L139;
        ((IExtPageChangeListener) r122).TD(r121);     // Catch: IllegalArgumentException -> L177
        goto L139
    L133:
        r121 = false;
        goto L134
    L143:
        if (r119 == false) goto L146;
        this.R = true;     // Catch: IllegalArgumentException -> L177
    L124:
        r118 = r117;
    L125:
        r119 = false;
        goto L126
    L117:
        if ((r108 * 0.5f) <= r111) goto L119;
        r117 = true;
        goto L121
    L89:
        if (this.f161157n == true) goto L114;
        if (this.f161139e == false) goto L103;
        float r125 = this.U;     // Catch: IllegalArgumentException -> L177
        if (r108 > r125) goto L95;
    L97:
        r117 = false;
    L99:
        if (r111 <= r125) goto L124;
        if (r108 >= (((double) r111) * this.f161141f)) goto L124;
    L95:
        if (r108 < (((double) r111) * this.f161141f)) goto L97;
        r117 = true;
        goto L99
    L103:
        float r126 = this.U;     // Catch: IllegalArgumentException -> L177
        if (r108 > r126) goto L106;
    L108:
        r117 = false;
    L110:
        if (r111 <= r126) goto L124;
        if (r108 >= (((double) r111) * this.f161135c)) goto L124;
    L106:
        if (r108 < (((double) r111) * this.f161135c)) goto L108;
        r117 = true;
        goto L110
    L71:
        if (this.f161143g <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L86;
        if (this.f161157n == true) goto L86;
        float r127 = this.U;     // Catch: IllegalArgumentException -> L177
        if (r108 <= r127) goto L79;
        r115 = r112;
        if (r108 < (((double) r111) * this.f161147h)) goto L80;
        r118 = true;
    L82:
        if (r111 <= r127) goto L125;
        if (r108 >= (((double) r111) * this.f161147h)) goto L125;
    L80:
        r118 = false;
        goto L82
    L79:
        r115 = r112;
    L171:
        if (this.P0 != null) goto L173;
        this.P0 = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L177
    L173:
        this.P0.addMovement(r110);     // Catch: IllegalArgumentException -> L177
        goto L180
    L46:
        if (r103 != 6) goto L171;
        v(r110);     // Catch: IllegalArgumentException -> L177
        goto L171
    L154:
        if (this.f161137d > AudioStats.AUDIO_AMPLITUDE_NONE) goto L156;
    L160:
        this.f161141f = this.f161135c;     // Catch: IllegalArgumentException -> L177
    L161:
        ALogger.i("InnerSlideStrategyHelper", "realTanValue " + this.f161141f);     // Catch: IllegalArgumentException -> L177
        this.V = r110.getX();     // Catch: IllegalArgumentException -> L177
        this.f161153k0 = r110.getX();     // Catch: IllegalArgumentException -> L177
        this.W = r110.getY();     // Catch: IllegalArgumentException -> L177
        this.f161160p0 = r110.getY();     // Catch: IllegalArgumentException -> L177
        this.H0 = MotionEventCompat.getPointerId(r110, 0);     // Catch: IllegalArgumentException -> L177
        this.R = false;     // Catch: IllegalArgumentException -> L177
        getClickPosition();     // Catch: IllegalArgumentException -> L177
        com.bytedance.android.livesdk.sharedpref.e<Integer> r128 = f4.f497199b;     // Catch: IllegalArgumentException -> L177
        Integer r129 = Integer.valueOf(getClickPosition());     // Catch: IllegalArgumentException -> L177
        r128.getClass();     // Catch: IllegalArgumentException -> L177
        com.bytedance.android.livesdk.sharedpref.f.d(r128, r129);     // Catch: IllegalArgumentException -> L177
        this.A = true;     // Catch: IllegalArgumentException -> L177
        this.f161178z.computeScrollOffset();     // Catch: IllegalArgumentException -> L177
        if (this.T2 == 2) goto L164;
    L169:
        k(false);     // Catch: IllegalArgumentException -> L177
        this.Q = false;     // Catch: IllegalArgumentException -> L177
        goto L171
    L164:
        if (Math.abs(this.f161178z.getFinalY() - this.f161178z.getCurrY()) <= this.f161148h1) goto L169;
        this.f161178z.abortAnimation();     // Catch: IllegalArgumentException -> L177
        this.M = false;     // Catch: IllegalArgumentException -> L177
        y();     // Catch: IllegalArgumentException -> L177
        this.Q = true;     // Catch: IllegalArgumentException -> L177
        ViewParent r130 = getParent();     // Catch: IllegalArgumentException -> L177
        if (r130 == null) goto L168;
        r130.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L177
    L168:
        setScrollState(1);     // Catch: IllegalArgumentException -> L177
        goto L171
    L156:
        if (r110.getX() >= (getWidth() / 3.0f)) goto L158;
    L159:
        this.f161141f = this.f161137d;     // Catch: IllegalArgumentException -> L177
        goto L161
    L158:
        if (r110.getX() <= ((getWidth() * 2.0f) / 3.0f)) goto L160;
    L174:
        B();     // Catch: IllegalArgumentException -> L177
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        PagerAdapter r102 = this.f161166t;
        if (r102 == null) goto L9;
        r102.restoreState(r101.f161185b, r101.f161186c);
        E(r101.f161184a, false, true, 0);
        return;
    L9:
        this.f161171w = r101.f161184a;
        this.f161172x = r101.f161185b;
        this.f161175y = r101.f161186c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        com.bytedance.android.livesdk.vs.a r100 = this.H2;
        boolean r101 = false;
        r101 = false;
        r101 = false;
        r101 = false;
        r101 = false;
        char r102 = 0;
        r102 = 0;
        r101 = false;
        int r103 = 0;
        r101 = false;
        if (r100 == null) goto L8;
        if (r100.onTouchEvent(r110) == false) goto L8;
        return false;
    L8:
        if (isEnabled() == true) goto L11;
        return false;
    L11:
        if (this.f161176y1 == true) goto L14;
        return false;
    L14:
        if (this.G1 == true) goto L145;
        return false;
    L145:
        e0 r104 = this.K2;     // Catch: IllegalArgumentException -> L142
        if (r104 == null) goto L21;
        ((pg2.h) r104).b(r110);     // Catch: IllegalArgumentException -> L142
    L21:
        if (this.f161169v1 == false) goto L24;
        return true;
    L24:
        if (r110.getAction() == 0) goto L26;
    L28:
        PagerAdapter r105 = this.f161166t;     // Catch: IllegalArgumentException -> L142
        if (r105 != null) goto L31;
    L141:
        return false;
    L31:
        if (r105.getCount() == 0) goto L141;
        if (this.P0 != null) goto L36;
        this.P0 = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L142
    L36:
        this.P0.addMovement(r110);     // Catch: IllegalArgumentException -> L142
        int r106 = r110.getAction() & 255;     // Catch: IllegalArgumentException -> L142
        if (r106 == 0) goto L137;
        int r107 = 2;
        if (r106 == 1) goto L117;
        if (r106 == 2) goto L55;
        if (r106 == 3) goto L51;
        if (r106 != 5) goto L46;
        int r108 = MotionEventCompat.getActionIndex(r110);     // Catch: IllegalArgumentException -> L142
        this.W = MotionEventCompat.getY(r110, r108);     // Catch: IllegalArgumentException -> L142
        this.H0 = MotionEventCompat.getPointerId(r110, r108);     // Catch: IllegalArgumentException -> L142
    L138:
        if (r101 == false) goto L144;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalArgumentException -> L142
    L144:
        return true;
    L46:
        if (r106 != 6) goto L138;
        v(r110);     // Catch: IllegalArgumentException -> L142
        this.W = MotionEventCompat.getY(r110, MotionEventCompat.findPointerIndex(r110, this.H0));     // Catch: IllegalArgumentException -> L142
        goto L138
    L51:
        if (this.Q == false) goto L53;
        D(this.f161167u, true, 0, false);     // Catch: IllegalArgumentException -> L142
        r101 = B();     // Catch: IllegalArgumentException -> L142
    L53:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r111 = f4.f497198a;     // Catch: IllegalArgumentException -> L142
        Boolean r109 = Boolean.TRUE;     // Catch: IllegalArgumentException -> L142
        r111.getClass();     // Catch: IllegalArgumentException -> L142
        com.bytedance.android.livesdk.sharedpref.f.d(r111, r109);     // Catch: IllegalArgumentException -> L142
        goto L138
    L55:
        if (this.Q == true) goto L102;
        int r112 = MotionEventCompat.findPointerIndex(r110, this.H0);     // Catch: IllegalArgumentException -> L142
        if (r112 != (-1)) goto L59;
        r101 = B();     // Catch: IllegalArgumentException -> L142
        goto L138
    L59:
        float r113 = MotionEventCompat.getY(r110, r112);     // Catch: IllegalArgumentException -> L142
        float r114 = Math.abs(r113 - this.W);     // Catch: IllegalArgumentException -> L142
        float r115 = MotionEventCompat.getX(r110, r112);     // Catch: IllegalArgumentException -> L142
        float r116 = Math.abs(r115 - this.V);     // Catch: IllegalArgumentException -> L142
        if (this.f161150i == false) goto L69;
        if (this.f161143g <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L69;
        if (this.f161157n == true) goto L69;
        if (r114 >= (((double) r116) * this.f161147h)) goto L77;
    L78:
        boolean r117 = false;
    L80:
        if (r114 <= this.U) goto L102;
        if (r117 == false) goto L102;
        this.Q = true;     // Catch: IllegalArgumentException -> L142
        ViewParent r118 = getParent();     // Catch: IllegalArgumentException -> L142
        if (r118 == null) goto L85;
        r118.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L142
    L85:
        float r119 = this.f161160p0;     // Catch: IllegalArgumentException -> L142
        if ((r113 - r119) <= 0.0f) goto L88;
        float r120 = r119 + this.U;     // Catch: IllegalArgumentException -> L142
    L89:
        this.W = r120;     // Catch: IllegalArgumentException -> L142
        this.V = r115;     // Catch: IllegalArgumentException -> L142
        setScrollState(1);     // Catch: IllegalArgumentException -> L142
        if ((r113 - this.W) >= 0.0f) goto L92;
        boolean r121 = true;
    L93:
        ViewPager.OnPageChangeListener r122 = this.G2;     // Catch: IllegalArgumentException -> L142
        if (r122 != null) goto L96;
    L98:
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L142
        ViewParent r123 = getParent();     // Catch: IllegalArgumentException -> L142
        if (r123 == null) goto L102;
        r123.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L142
        goto L102
    L96:
        if ((r122 instanceof IExtPageChangeListener) == false) goto L98;
        ((IExtPageChangeListener) r122).TD(r121);     // Catch: IllegalArgumentException -> L142
        goto L98
    L92:
        r121 = false;
        goto L93
    L88:
        r120 = r119 - this.U;     // Catch: IllegalArgumentException -> L142
    L77:
        r117 = true;
    L69:
        if (this.f161131b <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L76;
        if (this.f161157n == true) goto L76;
        if (r114 < (((double) r116) * this.f161135c)) goto L78;
    L76:
        if (r114 <= r116) goto L78;
    L102:
        if (this.Q == false) goto L115;
        boolean r124 = x(MotionEventCompat.getY(r110, MotionEventCompat.findPointerIndex(r110, this.H0))) | false;     // Catch: IllegalArgumentException -> L142
        if (LiveScrollSwitchConfigHelper.a().c() == true) goto L106;
    L108:
        if (r102 == 0) goto L114;
        ViewPager.OnPageChangeListener r125 = this.G2;     // Catch: IllegalArgumentException -> L142
        if (r125 == null) goto L114;
        if ((r125 instanceof IExtPageChangeListener) == false) goto L114;
        ((IExtPageChangeListener) this.G2).in(C());     // Catch: IllegalArgumentException -> L142
    L114:
        r101 = r124;
        goto L115
    L106:
        if (LiveScrollSwitchConfigHelper.a().f() == false) goto L108;
        r102 = 1;
    L115:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r126 = f4.f497198a;     // Catch: IllegalArgumentException -> L142
        Boolean r127 = Boolean.FALSE;     // Catch: IllegalArgumentException -> L142
        r126.getClass();     // Catch: IllegalArgumentException -> L142
        com.bytedance.android.livesdk.sharedpref.f.d(r126, r127);     // Catch: IllegalArgumentException -> L142
        goto L138
    L117:
        if (r110.getY() <= this.f161134b3) goto L120;
        r107 = 1;
    L120:
        if (this.L0.booleanValue() == true) goto L125;
        if (this.f161138d3 == false) goto L125;
        xs2.b.a().post(new zg1.y(false, r107, getClickPosition(), getCurrentItem()));     // Catch: IllegalArgumentException -> L142
    L125:
        if (this.Q == false) goto L136;
        VelocityTracker r128 = this.P0;     // Catch: IllegalArgumentException -> L142
        r128.computeCurrentVelocity(1000, this.f161132b1);     // Catch: IllegalArgumentException -> L142
        int r129 = (int) VelocityTrackerCompat.getYVelocity(r128, this.H0);     // Catch: IllegalArgumentException -> L142
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L129;
    L131:
        r103 = r129;
    L132:
        this.M = true;     // Catch: IllegalArgumentException -> L142
        int r130 = getClientHeight();     // Catch: IllegalArgumentException -> L142
        int r131 = getScrollY();     // Catch: IllegalArgumentException -> L142
        m r132 = r();     // Catch: IllegalArgumentException -> L142
        float r133 = r130;
        float r134 = this.D / r133;     // Catch: IllegalArgumentException -> L142
        int r135 = r132.f161197b;     // Catch: IllegalArgumentException -> L142
        float r136 = ((r131 / r133) - r132.f161200e) / (r132.f161199d + r134);     // Catch: IllegalArgumentException -> L142
        int r137 = (int) (MotionEventCompat.getY(r110, MotionEventCompat.findPointerIndex(r110, this.H0)) - this.f161160p0);     // Catch: IllegalArgumentException -> L142
        if (this.f161159p == false) goto L135;
        E(m(r135, r136, r103, r137), true, true, r103);     // Catch: IllegalArgumentException -> L142
    L135:
        boolean r138 = B();     // Catch: IllegalArgumentException -> L142
        this.f161159p = true;     // Catch: IllegalArgumentException -> L142
        r101 = r138;
        goto L136
    L129:
        if (this.f161145g2 == false) goto L131;
    L136:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r139 = f4.f497198a;     // Catch: IllegalArgumentException -> L142
        Boolean r140 = Boolean.TRUE;     // Catch: IllegalArgumentException -> L142
        r139.getClass();     // Catch: IllegalArgumentException -> L142
        com.bytedance.android.livesdk.sharedpref.f.d(r139, r140);     // Catch: IllegalArgumentException -> L142
        goto L138
    L137:
        this.f161178z.abortAnimation();     // Catch: IllegalArgumentException -> L142
        this.M = false;     // Catch: IllegalArgumentException -> L142
        y();     // Catch: IllegalArgumentException -> L142
        this.f161153k0 = r110.getX();     // Catch: IllegalArgumentException -> L142
        this.V = r110.getX();     // Catch: IllegalArgumentException -> L142
        this.W = r110.getY();     // Catch: IllegalArgumentException -> L142
        this.f161160p0 = r110.getY();     // Catch: IllegalArgumentException -> L142
        this.H0 = MotionEventCompat.getPointerId(r110, 0);     // Catch: IllegalArgumentException -> L142
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r141 = f4.f497198a;     // Catch: IllegalArgumentException -> L142
        Boolean r142 = Boolean.FALSE;     // Catch: IllegalArgumentException -> L142
        r141.getClass();     // Catch: IllegalArgumentException -> L142
        com.bytedance.android.livesdk.sharedpref.f.d(r141, r142);     // Catch: IllegalArgumentException -> L142
        goto L138
    L26:
        if (r110.getEdgeFlags() == 0) goto L28;
        return false;
    L142:
        e = move-exception;
        e.printStackTrace();
        goto L144
    }

    public final m q(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f161163q.size()) goto L9;
        m r102 = (m) ListProtector.get(this.f161163q, r101);
        if (this.f161166t.isViewFromObject(r100, r102.f161196a) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
    L7:
        e = move-exception;
        ALogger.e("ttlive_exception", e);
        return;
    L3:
        if (this.K == false) goto L5;
        removeViewInLayout(r100);     // Catch: NullPointerException -> L7
    L10:
        return;
    L5:
        super.removeView(r100);     // Catch: NullPointerException -> L7
        goto L10
    }

    public final m s(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f161163q.size()) goto L9;
        m r102 = (m) ListProtector.get(this.f161163q, r101);
        if (r102.f161197b == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public void setAdapter(PagerAdapter r100) {
        PagerAdapter r101 = this.f161166t;
        if (r101 != null) goto L37;
    L20:
        this.f161166t = r100;
        if (r100 != null) goto L23;
        return;
    L23:
        if (this.C != null) goto L39;
        this.C = new r(this);
    L39:
        f161127m3.set(this.f161166t, this.C);     // Catch: IllegalAccessException -> L33
        this.M = false;
        boolean r102 = this.S1;
        this.S1 = true;
        this.f161166t.getCount();
        if (this.f161171w < 0) goto L30;
        this.f161166t.restoreState(this.f161172x, this.f161175y);
        E(this.f161171w, false, true, 0);
        this.f161171w = -1;
        this.f161172x = null;
        this.f161175y = null;
        return;
    L30:
        if (r102 == true) goto L32;
        y();
        return;
    L32:
        requestLayout();
        return;
    L33:
        e = move-exception;
        throw new RuntimeException(e);
    L37:
        f161127m3.set(r101, null);     // Catch: IllegalAccessException -> L17
        this.f161166t.startUpdate(this);
        int r103 = 0;
    L7:
        if (r103 >= this.f161163q.size()) goto L9;
        m r104 = (m) ListProtector.get(this.f161163q, r103);
        this.f161166t.destroyItem(this, r104.f161197b, r104.f161196a);
        r103 = r103 + 1;
        goto L7
    L9:
        this.f161166t.finishUpdate(this);
        this.f161163q.clear();
        int r105 = 0;
    L11:
        if (r105 >= getChildCount()) goto L16;
        if (((LayoutParams) getChildAt(r105).getLayoutParams()).f161179a == true) goto L15;
        removeViewAt(r105);
        r105 = r105 - 1;
    L15:
        r105 = r105 + 1;
        goto L11
    L16:
        this.f161167u = 0;
        this.f161168v = 0;
        scrollTo(0, 0);
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setCanChangePage(boolean r100) {
        this.f161159p = r100;
    }

    public void setCanScroll(boolean r100) {
        this.f161176y1 = r100;
    }

    public void setCanScrollByRecord(boolean r100) {
        this.G1 = r100;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean r100) {
        if (this.J2 == null) goto L11;
    L9:
        this.J2.invoke(this, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    L11:
        this.J2 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L7
        goto L9
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean r100) {
        super.setClipChildren(r100);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        SafetyGuard.a(null, new Throwable("LiveVerticalViewPager"), "VP setClipChildren invoke");
        return;
    }

    public void setCommonTouchListener(e0 r100) {
        this.K2 = r100;
    }

    public void setCurrentItem(int r100) {
        this.M = false;
        E(r100, !this.S1, false, 0);
    }

    public void setCurrentItemWithDefaultVelocity(int r100) {
        this.M = false;
        E(r100, true, true, 1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        StringBuilder r101 = new StringBuilder("live_touch_conflict:");
        q3 r102 = q3.f497288a;
        r101.append(r102.getValue());
        ALogger.e("LiveVerticalViewPager", r101.toString());
        if (isEnabled() == false) goto L10;
        if (r100 == true) goto L10;
        if (this.Q == false) goto L10;
        if (r102.getValue().booleanValue() == false) goto L10;
        D(this.f161167u, true, 0, false);
    L10:
        super.setEnabled(r100);
    }

    public void setIgnoreSpeed(boolean r100) {
        this.f161145g2 = r100;
    }

    public void setIsLandSlideEnable(boolean r100) {
        this.f161150i = r100;
    }

    public void setIsPortrait(boolean r100) {
        this.f161149h2 = r100;
    }

    public void setMoveDistanceCallBack(n r100) {
        this.I2 = r100;
    }

    public void setNestedOutSide(boolean r100) {
        this.f161157n = r100;
    }

    public void setOffscreenPageLimit(int r100) {
        if (y8.f162552a.booleanValue() == true) goto L8;
        if (r100 >= 1) goto L8;
        r100 = 1;
    L8:
        if (r100 == this.N) goto L11;
        this.N = r100;
        this.O = r100;
        this.P = r100;
        y();
        return;
    }

    public void setOffscreenPageLimitHigh(int r100) {
        if (y8.f162552a.booleanValue() == true) goto L8;
        if (r100 >= 1) goto L8;
        r100 = 1;
    L8:
        if (r100 == this.P) goto L11;
        this.P = r100;
        y();
        return;
    }

    public void setOffscreenPageLimitLow(int r100) {
        if (y8.f162552a.booleanValue() == true) goto L8;
        if (r100 >= 1) goto L8;
        r100 = 1;
    L8:
        if (r100 == this.O) goto L11;
        this.O = r100;
        y();
        return;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.G2 = r100;
    }

    public void setOverScrollListener(q r100) {
        this.Q1 = r100;
    }

    public void setPageMargin(int r100) {
        int r101 = this.D;
        this.D = r100;
        int r102 = getHeight();
        A(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.E = r100;
        if (r100 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r100 != null) goto L7;
        boolean r101 = true;
    L8:
        setWillNotDraw(r101);
        invalidate();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public void setPageScrollFinishedListener(k r100) {
        this.F2 = r100;
    }

    public void setTouchInterceptListener(com.bytedance.android.livesdk.vs.a r100) {
        this.H2 = r100;
    }

    public final void v(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r101) != this.H0) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.W = MotionEventCompat.getY(r100, r102);
        this.H0 = MotionEventCompat.getPointerId(r100, r102);
        VelocityTracker r103 = this.P0;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.E) goto L8;
        return false;
    }

    public final boolean w(int r110) {
        boolean r100 = false;
        if (this.f161163q.size() == 0) goto L5;
        m r101 = r();
        int r102 = getClientHeight();
        int r103 = this.D;
        float r104 = r102;
        int r105 = r101.f161197b;
        float r111 = ((r110 / r104) - r101.f161200e) / (r101.f161199d + (r103 / r104));
        this.T1 = false;
        u(r105, r111, (int) ((r102 + r103) * r111));
        if (r102 <= 0) goto L15;
        float r112 = getScrollY() / r104;
    L17:
        if ((r112 % 1.0f) != 0.0f) goto L20;
        r100 = true;
    L20:
        if (this.T2 != 2) goto L32;
        if (r100 == false) goto L32;
        k r113 = this.F2;
        if (r113 == null) goto L32;
        jo2.e r114 = ((ik1.b) ((com.bytedance.android.livesdk.chatroom.newcontainer.business.community.innerfeed.b) r113).f107323a.f526494a).P;
        if (r114 == null) goto L32;
        if (r114.f499894d.e() == false) goto L32;
        jo2.b r115 = r114.f499893c;
        if (r115 == null) goto L32;
        r115.d();
    L32:
        if (this.T1 == false) goto L35;
        return true;
    L35:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L15:
        r112 = 0.0f;
        goto L17
    L5:
        if (this.S1 == false) goto L7;
        return false;
    L7:
        this.T1 = false;
        u(0, 0.0f, 0);
        if (this.T1 == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean x(float r110) {
        float r100 = (this.W - r110) * this.L2;
        this.W = r110;
        float r111 = getScrollY() + r100;
        float r101 = getClientHeight();
        float r102 = this.H * r101;
        float r103 = this.I * r101;
        boolean r104 = false;
        m r105 = (m) ListProtector.get(this.f161163q, 0);
        ArrayList<m> r106 = this.f161163q;
        m r107 = (m) ListProtector.get(r106, r106.size() - 1);
        if (r105.f161197b == 0) goto L5;
        r102 = r105.f161200e * r101;
        boolean r108 = false;
    L7:
        if (r107.f161197b == (this.f161166t.getCount() - 1)) goto L9;
        r103 = r107.f161200e * r101;
        boolean r109 = false;
    L11:
        if (r111 >= r102) goto L16;
        if (r108 == false) goto L14;
        com.bytedance.android.livesdk.widget.n r112 = this.H1;
        r112.f161867a.onPull(Math.abs(r102 - r111) / r101);
        r104 = true;
    L14:
        r111 = r102;
    L20:
        int r113 = (int) r111;
        this.V += r111 - r113;
        if (this.f161158o == false) goto L23;
        scrollTo(getScrollX(), r113);
        w(r113);
    L23:
        return r104;
    L16:
        if (r111 <= r103) goto L20;
        if (r109 == false) goto L19;
        com.bytedance.android.livesdk.widget.n r114 = this.L1;
        r114.f161867a.onPull(Math.abs(r111 - r103) / r101);
        r104 = true;
    L19:
        r111 = r103;
        goto L20
    L9:
        r109 = true;
        goto L11
    L5:
        r108 = true;
        goto L7
    }

    public final void z(int r210) {
        int r100 = this.f161167u;
        if (r100 == r210) goto L9;
        if (r100 >= r210) goto L6;
        int r101 = 130;
    L7:
        m r102 = s(r100);
        this.f161167u = r210;
        this.W2 = Math.max(r210, this.W2);
    L15:
        if (this.f161166t != null) goto L18;
        return;
    L18:
        if (this.M == false) goto L21;
        return;
    L21:
        if (getWindowToken() != null) goto L23;
        return;
    L23:
        long r103 = System.currentTimeMillis();
        this.f161166t.startUpdate(this);
        int r104 = this.f161166t.getCount();
        if (y8.f162554c == false) goto L26;
        int r105 = Math.max(0, this.f161167u - this.O);
        int r106 = Math.min(r104 - 1, this.f161167u + this.P);
    L27:
        int r107 = 0;
    L29:
        if (r107 >= this.f161163q.size()) goto L35;
        m r110 = (m) ListProtector.get(this.f161163q, r107);
        int r111 = r110.f161197b;
        int r112 = this.f161167u;
        if (r111 >= r112) goto L32;
        r107 = r107 + 1;
        goto L29
    L32:
        if (r111 != r112) goto L35;
    L36:
        if (r110 != null) goto L39;
        if (r104 <= 0) goto L39;
        r110 = g(this.f161167u, r107);
    L39:
        if (r110 != null) goto L41;
    L224:
        PagerAdapter r108 = this.f161166t;
        int r109 = this.f161167u;
        if (r110 == null) goto L227;
        Object r113 = r110.f161196a;
    L228:
        r108.setPrimaryItem(this, r109, r113);
        this.f161166t.finishUpdate(this);
        int r114 = getChildCount();
        int r115 = 0;
    L229:
        if (r115 >= r114) goto L239;
        View r116 = getChildAt(r115);
        LayoutParams r117 = (LayoutParams) r116.getLayoutParams();
        r117.f161183e = r115;
        if (r117.f161179a == true) goto L237;
        if (r117.f161181c != 0.0f) goto L237;
        m r118 = q(r116);
        if (r118 == null) goto L237;
        r117.f161181c = r118.f161199d;
        int r119 = r118.f161197b;
        r117.getClass();
    L237:
        r115 = r115 + 1;
        goto L229
    L239:
        if (hasFocus() == false) goto L266;
        View r120 = findFocus();
        if (r120 == null) goto L250;
    L242:
        Object r121 = r120.getParent();
        if (r121 == this) goto L249;
        if (r121 == null) goto L250;
        if ((r121 instanceof View) == false) goto L250;
        r120 = (View) r121;
        goto L242
    L249:
        m r122 = q(r120);
    L251:
        if (r122 != null) goto L253;
    L254:
        int r123 = 0;
    L256:
        if (r123 >= getChildCount()) goto L266;
        View r124 = getChildAt(r123);
        m r125 = q(r124);
        if (r125 == null) goto L264;
        if (r125.f161197b != this.f161167u) goto L264;
        if (r124.requestFocus(r101) == true) goto L266;
    L264:
        r123 = r123 + 1;
        goto L256
    L253:
        if (r122.f161197b == this.f161167u) goto L266;
    L250:
        r122 = null;
    L266:
        if (this.f161162p2 == false) goto L329;
        boolean r126 = this.f161149h2;
        if (r126 == false) goto L275;
        int r127 = this.f161170v2;
        if (r127 > this.f161174x2) goto L275;
        if (r127 == (-1)) goto L275;
        this.f161170v2 = r127 + 1;
        return;
    L275:
        if (r126 == false) goto L277;
        this.f161170v2 = 0;
    L277:
        int r128 = (int) (System.currentTimeMillis() - r103);
        if (r128 <= 10) goto L330;
        LandscapeLiveMonitor.methodCost(r128, "view_pager_populate");
        return;
    L330:
        return;
    L329:
        return;
    L227:
        r113 = null;
        goto L228
    L41:
        if (j40.l0.f497255a.getValue().booleanValue() == false) goto L47;
        Object r129 = r110.f161196a;
        if ((r129 instanceof BaseFragment) == false) goto L47;
        if (((BaseFragment) r129).getArguments().getBoolean("is_follow_cover") == true) goto L47;
        this.V1 = true;
    L47:
        int r130 = r107 - 1;
        if (r130 < 0) goto L50;
        m r131 = (m) ListProtector.get(this.f161163q, r130);
    L51:
        int r132 = getClientHeight();
        if (r132 > 0) goto L54;
        float r133 = 0.0f;
    L55:
        int r134 = this.f161167u - 1;
        float r135 = 0.0f;
    L56:
        if (r134 < 0) goto L104;
        if (r134 < r105) goto L59;
    L71:
        int r136 = r105;
        if (r131 != null) goto L74;
    L79:
        j40.l0 r137 = j40.l0.f497255a;
        if (r137.getValue().booleanValue() == true) goto L82;
    L85:
        boolean r138 = y8.f162554c;
        m r139 = r131;
        if (r138 == true) goto L88;
    L89:
        if (r138 == false) goto L91;
    L93:
        boolean r140 = false;
    L95:
        if (y8.f162552a.booleanValue() == false) goto L99;
        if (r140 == true) goto L99;
        r131 = r139;
    L103:
        r134 = r134 - 1;
        r105 = r136;
    L99:
        r135 = r135 + g(r134, r130 + 1).f161199d;
        r107 = r107 + 1;
        if (r130 >= 0) goto L101;
    L78:
        m r141 = null;
    L102:
        r131 = r141;
        goto L103
    L101:
        r141 = (m) ListProtector.get(this.f161163q, r130);
        goto L102
    L91:
        if (this.N <= 0) goto L93;
    L92:
        r140 = true;
        goto L95
    L88:
        if (this.O > 0) goto L92;
    L82:
        if (r137.getValue().booleanValue() == false) goto L103;
        if (this.V1 == false) goto L103;
    L74:
        if (r134 != r131.f161197b) goto L79;
        r135 = r135 + r131.f161199d;
        r130 = r130 - 1;
        if (r130 < 0) goto L78;
        r141 = (m) ListProtector.get(this.f161163q, r130);
        goto L102
    L59:
        if (y8.f162555d == false) goto L61;
    L62:
        if (r131 == null) goto L104;
        r136 = r105;
        if (r134 != r131.f161197b) goto L103;
        if (r131.f161198c == true) goto L103;
        ListProtector.remove(this.f161163q, r130);
        this.f161166t.destroyItem(this, r134, r131.f161196a);
        r130 = r130 - 1;
        r107 = r107 - 1;
        if (r130 < 0) goto L78;
        r141 = (m) ListProtector.get(this.f161163q, r130);
        goto L102
    L61:
        if (r135 < r133) goto L71;
    L104:
        float r142 = r110.f161199d;
        int r143 = r107 + 1;
        if (r142 < 2.0f) goto L107;
    L160:
        int r144 = this.f161166t.getCount();
        int r145 = getClientHeight();
        if (r145 <= 0) goto L163;
        float r146 = this.D / r145;
    L164:
        if (r102 == null) goto L196;
        int r147 = r102.f161197b;
        int r148 = r110.f161197b;
        if (r147 >= r148) goto L182;
        float r149 = (r102.f161200e + r102.f161199d) + r146;
        int r150 = r147 + 1;
        int r151 = 0;
    L169:
        if (r150 > r110.f161197b) goto L196;
        if (r151 >= this.f161163q.size()) goto L196;
        Object r152 = ListProtector.get(this.f161163q, r151);
    L173:
        m r153 = (m) r152;
        if (r150 <= r153.f161197b) goto L179;
        if (r151 >= (this.f161163q.size() - 1)) goto L179;
        r151 = r151 + 1;
        r152 = ListProtector.get(this.f161163q, r151);
    L179:
        if (r150 >= r153.f161197b) goto L181;
        r149 = r149 + (this.f161166t.getPageWidth(r150) + r146);
        r150 = r150 + 1;
        goto L179
    L181:
        r153.f161200e = r149;
        r149 = r149 + (r153.f161199d + r146);
        r150 = r150 + 1;
        goto L169
    L182:
        if (r147 <= r148) goto L196;
        int r154 = this.f161163q.size() - 1;
        float r155 = r102.f161200e;
    L184:
        r147 = r147 - 1;
        if (r147 < r110.f161197b) goto L196;
        if (r154 < 0) goto L196;
        Object r156 = ListProtector.get(this.f161163q, r154);
    L188:
        m r157 = (m) r156;
        if (r147 >= r157.f161197b) goto L193;
        if (r154 <= 0) goto L193;
        r154 = r154 - 1;
        r156 = ListProtector.get(this.f161163q, r154);
    L193:
        if (r147 <= r157.f161197b) goto L195;
        r155 = r155 - (this.f161166t.getPageWidth(r147) + r146);
        r147 = r147 - 1;
        goto L193
    L195:
        r155 = r155 - (r157.f161199d + r146);
        r157.f161200e = r155;
    L196:
        int r158 = this.f161163q.size();
        float r159 = r110.f161200e;
        int r160 = r110.f161197b;
        int r161 = r160 - 1;
        if (r160 != 0) goto L199;
        float r162 = r159;
    L200:
        this.H = r162;
        int r163 = r144 - 1;
        if (r160 != r163) goto L203;
        float r164 = (r110.f161199d + r159) - 1.0f;
    L204:
        this.I = r164;
        int r165 = r107 - 1;
    L205:
        if (r165 < 0) goto L214;
        m r166 = (m) ListProtector.get(this.f161163q, r165);
    L207:
        int r167 = r166.f161197b;
        if (r161 <= r167) goto L210;
        r159 = r159 - (this.f161166t.getPageWidth(r161) + r146);
        r161 = r161 - 1;
        goto L207
    L210:
        r159 = r159 - (r166.f161199d + r146);
        r166.f161200e = r159;
        if (r167 != 0) goto L213;
        this.H = r159;
    L213:
        r165 = r165 - 1;
        r161 = r161 - 1;
        goto L205
    L214:
        float r168 = (r110.f161200e + r110.f161199d) + r146;
        int r169 = r110.f161197b;
    L215:
        r169 = r169 + 1;
        if (r143 >= r158) goto L224;
        m r170 = (m) ListProtector.get(this.f161163q, r143);
    L218:
        int r171 = r170.f161197b;
        if (r169 >= r171) goto L221;
        r168 = r168 + (this.f161166t.getPageWidth(r169) + r146);
        r169 = r169 + 1;
        goto L218
    L221:
        if (r171 != r163) goto L223;
        this.I = (r170.f161199d + r168) - 1.0f;
    L223:
        r170.f161200e = r168;
        r168 = r168 + (r170.f161199d + r146);
        r143 = r143 + 1;
        goto L215
    L203:
        r164 = Float.MAX_VALUE;
        goto L204
    L199:
        r162 = -3.4028235E38f;
        goto L200
    L163:
        r146 = 0.0f;
        goto L164
    L107:
        if (r143 >= this.f161163q.size()) goto L109;
        m r172 = (m) ListProtector.get(this.f161163q, r143);
    L110:
        if (r132 > 0) goto L112;
        float r173 = 0.0f;
    L113:
        int r174 = this.f161167u + 1;
        int r175 = r143;
    L114:
        if (r174 >= r104) goto L160;
        if (r142 < r173) goto L127;
        if (r174 <= r106) goto L127;
        if (r172 == null) goto L160;
        if (r174 == r172.f161197b) goto L123;
    L141:
        int r211 = r104;
    L159:
        r174 = r174 + 1;
        r104 = r211;
        goto L114
    L123:
        if (r172.f161198c == true) goto L141;
        ListProtector.remove(this.f161163q, r175);
        this.f161166t.destroyItem(this, r174, r172.f161196a);
        if (r175 >= this.f161163q.size()) goto L133;
        r172 = (m) ListProtector.get(this.f161163q, r175);
    L133:
        r172 = null;
    L127:
        if (r172 != null) goto L129;
    L134:
        j40.l0 r176 = j40.l0.f497255a;
        if (r176.getValue().booleanValue() == true) goto L137;
    L142:
        boolean r177 = y8.f162554c;
        r211 = r104;
        if (r177 == true) goto L145;
    L146:
        if (r177 == false) goto L148;
    L150:
        boolean r178 = false;
    L152:
        if (y8.f162552a.booleanValue() == false) goto L154;
        if (r178 == false) goto L159;
    L154:
        m r179 = g(r174, r175);
        r175 = r175 + 1;
        r142 = r142 + r179.f161199d;
        if (r175 >= this.f161163q.size()) goto L157;
        m r180 = (m) ListProtector.get(this.f161163q, r175);
    L158:
        r172 = r180;
        goto L159
    L157:
        r180 = null;
        goto L158
    L148:
        if (this.N <= 0) goto L150;
    L149:
        r178 = true;
        goto L152
    L145:
        if (this.P > 0) goto L149;
    L137:
        if (r176.getValue().booleanValue() == false) goto L141;
        if (this.V1 == false) goto L141;
    L129:
        if (r174 != r172.f161197b) goto L134;
        r142 = r142 + r172.f161199d;
        r175 = r175 + 1;
        if (r175 >= this.f161163q.size()) goto L133;
        r172 = (m) ListProtector.get(this.f161163q, r175);
        goto L141
    L112:
        r173 = 2.0f + (getPaddingRight() / r132);
        goto L113
    L109:
        r172 = null;
        goto L110
    L54:
        r133 = (2.0f - r110.f161199d) + (getPaddingLeft() / r132);
        goto L55
    L50:
        r131 = null;
    L35:
        r110 = null;
        goto L36
    L26:
        int r181 = this.N;
        int r182 = Math.max(0, this.f161167u - r181);
        r106 = Math.min(r104 - 1, this.f161167u + r181);
        r105 = r182;
        goto L27
    L6:
        r101 = 33;
        goto L7
    L9:
        if (this.E2 == false) goto L11;
    L13:
        r101 = 2;
        r102 = null;
        goto L15
    L11:
        if (this.f161177y2 == true) goto L13;
        this.f161177y2 = true;
        this.W2 = Math.max(r100, this.W2);
        goto L13
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(getContext().getResources().getDrawable(r100));
    }

    public LiveVerticalViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f161129a = 600;
        this.f161131b = -1.0d;
        this.f161135c = 1.0d;
        this.f161137d = 1.0d;
        this.f161139e = j40.q2.f497287a.getValue().booleanValue();
        this.f161141f = 1.0d;
        this.f161143g = -1.0d;
        this.f161147h = -1.0d;
        this.f161150i = false;
        this.f161155l = com.bytedance.android.livesdk.utils.q2.a();
        this.f161156m = new w1(this);
        this.f161158o = true;
        this.f161159p = true;
        this.f161163q = new ArrayList();
        this.f161164r = new m();
        this.f161165s = new Rect();
        this.f161171w = -1;
        this.f161172x = null;
        this.f161175y = null;
        this.H = -3.4028235E38f;
        this.I = Float.MAX_VALUE;
        this.N = 1;
        this.O = 1;
        this.P = 1;
        this.H0 = -1;
        this.L0 = Boolean.valueOf(j40.t.f497299a.getValue().a());
        this.f161154k1 = 0.4f;
        this.f161161p1 = 0.6f;
        this.f161176y1 = true;
        this.G1 = true;
        this.M1 = false;
        this.P1 = false;
        this.Q1 = null;
        this.S1 = true;
        this.V1 = false;
        this.f161145g2 = false;
        this.f161149h2 = true;
        this.f161162p2 = false;
        this.f161170v2 = -1;
        this.f161174x2 = LandscapeLiveMonitor.sampleInterval();
        this.f161177y2 = false;
        this.E2 = com.bytedance.android.livesdk.x0.f162533a.getValue().getEnterFromLimit();
        LiveDrawOverlayConfig r102 = t5.f65417a.getValue();
        this.L2 = 1.0f;
        this.M2 = false;
        this.N2 = false;
        this.O2 = com.bytedance.android.livesdk.y2.f162546a.getValue().booleanValue();
        this.P2 = false;
        this.Q2 = false;
        this.R2 = false;
        this.S2 = new e(this);
        this.T2 = 0;
        this.U2 = 0;
        this.V2 = 0;
        this.W2 = 0;
        this.X2 = 0.0f;
        this.Y2 = 0.0f;
        this.Z2 = 0;
        this.f161130a3 = 0;
        this.f161134b3 = 0.0f;
        this.f161136c3 = 0.0f;
        this.f161138d3 = false;
        this.f161140e3 = new ArrayList();
        this.f161142f3 = new ArrayList();
        this.f161146g3 = null;
        t();
    }

    public static /* synthetic */ void e(LiveVerticalViewPager r110, Pair r111) {
        r110.getClass();
        if (r111 != null) goto L5;
        ALogger.i("InnerSlideStrategyHelper", "NPE angle");
        return;
    L5:
        Double r100 = (Double) r111.getFirst();
        Double r112 = (Double) r111.getSecond();
        if (r100 == null) goto L21;
        if (r112 != null) goto L10;
        return;
    L10:
        if (r100.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        if (r100.doubleValue() >= 180.0d) goto L15;
        double r101 = r100.doubleValue();
        r110.f161131b = r101;
        double r102 = Math.tan(Math.toRadians(90.0d - (r101 / 2.0d)));
        r110.f161135c = r102;
        r110.f161141f = r102;
    L15:
        if (r110.f161139e == false) goto L17;
        r110.f161137d = Math.tan(Math.toRadians(90.0d - ((r110.f161131b / 2.0d) + r112.doubleValue())));
    L18:
        ALogger.i("InnerSlideStrategyHelper", "Current scrollAngle is " + r110.f161131b + "tanValue:" + r110.f161135c + "areaTanValue" + r110.f161137d);
        return;
    L17:
        r110.f161137d = r110.f161135c;
        goto L18
    }

    public final m g(int r100, int r101) {
        m r102 = new m();
        r102.f161197b = r100;
        r102.f161196a = this.f161166t.instantiateItem(this, r100);
        r102.f161199d = this.f161166t.getPageWidth(r100);
        if (r101 >= 0) goto L5;
    L8:
        this.f161163q.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.f161163q.size()) goto L8;
        ListProtector.add(this.f161163q, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return ((LayoutParams) ((View) ListProtector.get(null, r101)).getLayoutParams()).f161183e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View r100, View r101) {
        if (this.P2 == false) goto L6;
        return;
    L6:
        if (this.Q2 == false) goto L21;
        if (r100.getParent() != this) goto L21;
        if (r101 == r100) goto L21;
        if (this.f161146g3 != r101) goto L13;
        return;
    L13:
        m r102 = q(r100);
        if (r102 != null) goto L16;
    L19:
        this.f161146g3 = null;
        goto L21
    L16:
        if (r102.f161197b == getCurrentItem()) goto L19;
        this.f161146g3 = r101;
        return;
    L21:
        if (v3.f497313a.getValue().booleanValue() == true) goto L23;
    L27:
        super.onDescendantInvalidated(r100, r101);
        return;
    L23:
        if (this.R2 == false) goto L27;
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r103);
        if (r103[1] <= (getHeight() / 2)) goto L27;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r110), ViewGroup.getDefaultSize(0, r111));
        int r112 = getMeasuredHeight();
        this.T = Math.min(r112 / 10, this.S);
        int r113 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r114 = (r112 - getPaddingTop()) - getPaddingBottom();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        boolean r103 = true;
        int r104 = 1073741824;
        if (r102 >= r101) goto L49;
        View r105 = getChildAt(r102);
        if (r105.getVisibility() == 8) goto L48;
        LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
        if (r106 == null) goto L48;
        if (r106.f161179a == false) goto L48;
        int r107 = r106.f161180b;
        int r108 = r107 & 7;
        int r109 = r107 & 112;
        if (r109 != 48) goto L14;
    L17:
        boolean r115 = true;
    L19:
        if (r108 != 3) goto L21;
    L24:
        int r116 = Integer.MIN_VALUE;
        if (r115 == false) goto L27;
        r116 = 1073741824;
    L29:
        int r117 = Integer.MIN_VALUE;
    L30:
        int r118 = ((ViewGroup.LayoutParams) r106).width;
        if (r118 == (-2)) goto L36;
        if (r118 != (-1)) goto L35;
        r118 = r113;
    L35:
        r116 = 1073741824;
    L37:
        int r119 = ((ViewGroup.LayoutParams) r106).height;
        if (r119 == (-2)) goto L42;
        if (r119 != (-1)) goto L43;
        r119 = r114;
    L43:
        r105.measure(View.MeasureSpec.makeMeasureSpec(r118, r116), View.MeasureSpec.makeMeasureSpec(r119, r104));
        if (r115 == false) goto L46;
        r114 = r114 - r105.getMeasuredHeight();
        goto L48
    L46:
        if (r103 == false) goto L48;
        r113 = r113 - r105.getMeasuredWidth();
        goto L48
    L42:
        r119 = r114;
        r104 = r117;
        goto L43
    L36:
        r118 = r113;
        goto L37
    L27:
        if (r103 == false) goto L29;
        r117 = 1073741824;
        goto L30
    L21:
        if (r108 == 5) goto L24;
        r103 = false;
        goto L24
    L14:
        if (r109 == 80) goto L17;
        r115 = false;
    L48:
        r102 = r102 + 1;
        goto L3
    L49:
        this.f161128J = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.K = true;
        if (this.O2 == true) goto L52;
    L56:
        y();
    L57:
        this.K = false;
        int r120 = getChildCount();
    L58:
        if (r100 >= r120) goto L67;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L66;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L64;
    L65:
        r121.measure(this.f161128J, View.MeasureSpec.makeMeasureSpec((int) (r114 * r122.f161181c), 1073741824));
        goto L66
    L64:
        if (r122.f161179a == false) goto L65;
    L66:
        r100 = r100 + 1;
        goto L58
    L67:
        return;
    L52:
        if (this.N2 == false) goto L56;
        if (this.M2 == false) goto L56;
        ALogger.i("SkipMeasureOpt", "onMeasure skip populate");
        this.M2 = false;
        goto L57
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r100, Rect r110) {
        int r101 = getChildCount();
        if ((r100 & 2) == 0) goto L5;
        int r102 = r101;
        int r103 = 0;
        int r104 = 1;
    L6:
        if (r103 == r102) goto L17;
        View r105 = getChildAt(r103);
        if (r105.getVisibility() != 0) goto L16;
        m r106 = q(r105);
        if (r106 == null) goto L16;
        if (r106.f161197b != this.f161167u) goto L16;
        if (r105.requestFocus(r100, r110) == false) goto L16;
        return true;
    L16:
        r103 = r103 + r104;
        goto L6
    L17:
        return false;
    L5:
        r103 = r101 - 1;
        r102 = -1;
        r104 = -1;
        goto L6
    }

    public final Rect p(Rect r100, View r101) {
        if (r100 != null) goto L4;
        r100 = new Rect();
    L4:
        if (r101 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return r100;
    L7:
        r100.left = r101.getLeft();
        r100.right = r101.getRight();
        r100.top = r101.getTop();
        r100.bottom = r101.getBottom();
        ViewParent r102 = r101.getParent();
    L9:
        if ((r102 instanceof ViewGroup) == false) goto L12;
        if (r102 == this) goto L12;
        ViewGroup r103 = (ViewGroup) r102;
        r100.left += r103.getLeft();
        r100.right += r103.getRight();
        r100.top += r103.getTop();
        r100.bottom += r103.getBottom();
        r102 = r103.getParent();
    L12:
        return r100;
    }

    public final void setCurrentItem(int r100, boolean r101) {
        this.M = false;
        E(r100, r101, false, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> r100, int r101, int r102) {
        int r103 = r100.size();
        int r104 = getDescendantFocusability();
        if (r104 == 393216) goto L16;
        int r105 = 0;
    L6:
        if (r105 >= getChildCount()) goto L16;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() != 0) goto L14;
        m r107 = q(r106);
        if (r107 == null) goto L14;
        if (r107.f161197b != this.f161167u) goto L14;
        r106.addFocusables(r100, r101, r102);
    L14:
        r105 = r105 + 1;
    L16:
        if (r104 != 262144) goto L20;
        if (r103 == r100.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r102 & 1) == 1) goto L25;
    L29:
        r100.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (checkLayoutParams(r102) == true) goto L5;
        r102 = generateLayoutParams(r102);
    L5:
        LayoutParams r103 = (LayoutParams) r102;
        boolean r104 = r103.f161179a | false;
        r103.f161179a = r104;
        if (this.K == false) goto L11;
        if (r104 == true) goto L10;
        r103.f161182d = true;
        addViewInLayout(r100, r101, r102);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r100, r101, r102);
    }

    public final void u(int r110, float r111, int r112) {
        if (this.f161133b2 <= 0) goto L25;
        int r100 = getScrollY();
        int r101 = getPaddingTop();
        int r102 = getPaddingBottom();
        int r103 = getHeight();
        int r104 = getChildCount();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L25;
        View r106 = getChildAt(r105);
        LayoutParams r107 = (LayoutParams) r106.getLayoutParams();
        if (r107.f161179a == false) goto L24;
        int r108 = r107.f161180b & 112;
        if (r108 != 16) goto L12;
        int r109 = Math.max((r103 - r106.getMeasuredHeight()) / 2, r101);
    L19:
        int r113 = r109;
        int r114 = r101;
        r101 = r113;
    L20:
        int r115 = (r101 + r100) - r106.getTop();
        if (r115 == 0) goto L23;
        r106.offsetTopAndBottom(r115);
    L23:
        r101 = r114;
        goto L24
    L12:
        if (r108 != 48) goto L14;
        r114 = r106.getHeight() + r101;
        goto L20
    L14:
        if (r108 == 80) goto L16;
        r114 = r101;
        goto L20
    L16:
        r109 = (r103 - r102) - r106.getMeasuredHeight();
        r102 = r102 + r106.getMeasuredHeight();
    L24:
        r105 = r105 + 1;
    L25:
        ViewPager.OnPageChangeListener r116 = this.G2;
        if (r116 == null) goto L28;
        r116.onPageScrolled(r110, r111, r112);
    L28:
        this.T1 = true;
    }

    public final void A(int r100, int r101, int r102, int r103) {
        if (r101 > 0) goto L4;
    L9:
        m r104 = s(this.f161167u);
        if (r104 == null) goto L12;
        float r105 = Math.min(r104.f161200e, this.I);
    L13:
        int r106 = (int) (r105 * ((r100 - getPaddingTop()) - getPaddingBottom()));
        if (r106 == getScrollY()) goto L19;
        k(false);
        scrollTo(getScrollX(), r106);
        return;
    L19:
        return;
    L12:
        r105 = 0.0f;
        goto L13
    L4:
        if (this.f161163q.isEmpty() == true) goto L9;
        if (this.f161178z.isFinished() == true) goto L8;
        this.f161178z.setFinalY(getCurrentItem() * getClientHeight());
        return;
    L8:
        scrollTo(getScrollX(), (int) ((getScrollY() / (((r101 - getPaddingTop()) - getPaddingBottom()) + r103)) * (((r100 - getPaddingTop()) - getPaddingBottom()) + r102)));
    }

    public final void D(int r110, boolean r111, int r112, boolean r113) {
        t3 r100 = t3.f497303a;
        if (r100.getValue().mEnable == false) goto L7;
        int r101 = r100.getValue().mTimeoutEnterRoomDraw;
        IMiddlewareHostAction r102 = (IMiddlewareHostAction) jc1.k.f(IMiddlewareHostAction.class);
        if (r102 == null) goto L7;
        r102.startVBoost(1, r101);
    L7:
        m r103 = s(r110);
        if (r103 == null) goto L10;
        int r104 = (int) (getClientHeight() * Math.max(this.H, Math.min(r103.f161200e, this.I)));
    L11:
        if (r111 == true) goto L13;
        if (r113 == false) goto L52;
        ViewPager.OnPageChangeListener r105 = this.G2;
        if (r105 == null) goto L52;
        r105.onPageSelected(r110);
    L52:
        k(false);
        scrollTo(0, r104);
        w(r104);
        return;
    L13:
        if (getChildCount() != 0) goto L15;
        setScrollingCacheEnabled(false);
    L44:
        if (r113 == false) goto L54;
        ViewPager.OnPageChangeListener r106 = this.G2;
        if (r106 == null) goto L55;
        r106.onPageSelected(r110);
        return;
    L55:
        return;
    L54:
        return;
    L15:
        Scroller r107 = this.f161178z;
        if (r107 != null) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == true) goto L23;
        int r109 = getScrollY();
    L28:
        int r114 = r109;
        int r115 = getScrollX();
        int r116 = 0 - r115;
        int r117 = r104 - r114;
        if (r116 != 0) goto L32;
        if (r117 != 0) goto L32;
        k(false);
        y();
        setScrollState(0);
    L32:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r118 = getClientHeight();
        int r119 = r118 / 2;
        float r120 = 1.0f;
        float r121 = r118;
        float r122 = r119;
        float r123 = r122 + (((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(r116) * 1.0f) / r121) - 0.5f)) * 0.4712389167638204d))) * r122);
        int r124 = Math.abs(r112);
        if (r124 <= 0) goto L35;
        int r125 = Math.round(Math.abs(r123 / r124) * 1000.0f) * 4;
    L36:
        int r126 = Math.min(r125, this.f161129a);
        o2.f161903a = o2.f161903a + ((long) r126);
        this.A = false;
        int r127 = this.V2;
        if (r127 <= 0) goto L39;
        int r128 = r127;
    L43:
        ALogger.d("SlideTaskDelay", "smoothScrollTo real duration=" + r128);
        this.f161178z.startScroll(r115, r114, r116, r117, r128);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L44
    L39:
        float r129 = r126;
        if (LiveScrollSwitchConfigHelper.a().c() == false) goto L42;
        r120 = LiveScrollSwitchConfigHelper.a().b();
    L42:
        r128 = (int) (r129 * r120);
        goto L43
    L35:
        r125 = (int) (((Math.abs(r116) / ((r121 * this.f161166t.getPageWidth(this.f161167u)) + this.D)) + 1.0f) * 100.0f);
        goto L36
    L23:
        if (this.A == false) goto L25;
        r109 = this.f161178z.getCurrY();
    L26:
        this.f161178z.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L28
    L25:
        r109 = this.f161178z.getStartY();
        goto L26
    L18:
        if (r107.isFinished() == true) goto L20;
        r108 = true;
        goto L21
    L10:
        r104 = 0;
        goto L11
    }

    public final void E(int r100, boolean r101, boolean r102, int r103) {
        PagerAdapter r104 = this.f161166t;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L51:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.getCount() <= 0) goto L51;
        if (r102 == false) goto L9;
    L14:
        this.f161168v = this.f161167u;
        if (r100 >= 0) goto L18;
        r100 = 0;
    L21:
        if (y8.f162554c == false) goto L30;
        int r106 = this.f161167u;
        if (r100 <= (this.P + r106)) goto L25;
    L26:
        int r107 = 0;
    L28:
        if (r107 >= this.f161163q.size()) goto L39;
        ((m) ListProtector.get(this.f161163q, r107)).f161198c = true;
        r107 = r107 + 1;
    L39:
        if (this.f161167u == r100) goto L42;
        r105 = true;
    L42:
        if (this.S1 == false) goto L49;
        this.f161167u = r100;
        if (r105 == false) goto L48;
        ViewPager.OnPageChangeListener r108 = this.G2;
        if (r108 == null) goto L48;
        r108.onPageSelected(r100);
    L48:
        requestLayout();
        return;
    L49:
        z(r100);
        D(r100, r101, r103, r105);
        return;
    L25:
        if (r100 >= (r106 - this.O)) goto L39;
    L30:
        int r109 = this.N;
        int r110 = this.f161167u;
        if (r100 <= (r110 + r109)) goto L33;
    L34:
        int r111 = 0;
    L36:
        if (r111 >= this.f161163q.size()) goto L39;
        ((m) ListProtector.get(this.f161163q, r111)).f161198c = true;
        r111 = r111 + 1;
        goto L36
    L33:
        if (r100 >= (r110 - r109)) goto L39;
    L18:
        if (r100 < this.f161166t.getCount()) goto L21;
        r100 = this.f161166t.getCount() - 1;
        goto L21
    L9:
        if (this.f161167u != r100) goto L14;
        if (this.f161163q.size() == 0) goto L14;
        setScrollingCacheEnabled(false);
    }

    public final int m(int r100, float r101, int r102, int r103) {
        if (Math.abs((int) (r103 * this.L2)) <= getFlingDistance()) goto L12;
        if (Math.abs(r102) <= getFlingVelocity()) goto L12;
        if (this.L2 < 1.0d) goto L12;
        if (r102 > 0) goto L17;
        r100 = r100 + 1;
    L17:
        if (this.f161163q.size() <= 0) goto L20;
        m r104 = (m) ListProtector.get(this.f161163q, 0);
        ArrayList<m> r105 = this.f161163q;
        return Math.max(r104.f161197b, Math.min(r100, ((m) ListProtector.get(r105, r105.size() - 1)).f161197b));
    L20:
        return r100;
    L12:
        if (r100 < this.f161167u) goto L14;
        float r106 = getDownDistance();
    L15:
        r100 = (int) ((r100 + r101) + r106);
        goto L17
    L14:
        r106 = getUpDistance();
        goto L15
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        System.out.println("onSizeChanged:h " + r101 + " oldh:" + r103);
        if (r101 == r103) goto L6;
        int r104 = this.D;
        A(r101, r103, r104, r104);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean j(View r110, boolean r111, int r112, int r113, int r114) {
        boolean r100 = r110 instanceof l;
        if (r100 == false) goto L8;
        if (((l) r110).r() == false) goto L8;
        return true;
    L8:
        if (r100 == false) goto L13;
        if (((l) r110).s() == false) goto L13;
        return false;
    L13:
        if ((r110 instanceof ViewGroup) == false) goto L28;
        ViewGroup r101 = (ViewGroup) r110;
        int r102 = r110.getScrollX();
        int r103 = r110.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L15:
        if (r104 < 0) goto L28;
        View r105 = r101.getChildAt(r104);
        int r106 = r114 + r103;
        if (r106 < r105.getTop()) goto L27;
        if (r106 >= r105.getBottom()) goto L27;
        int r107 = r113 + r102;
        if (r107 < r105.getLeft()) goto L27;
        if (r107 >= r105.getRight()) goto L27;
        if (j(r105, true, r112, r107 - r105.getLeft(), r106 - r105.getTop()) == false) goto L27;
        return true;
    L27:
        r104 = r104 - 1;
    L28:
        if (r111 == true) goto L30;
    L32:
        return false;
    L30:
        if (ViewCompat.canScrollVertically(r110, -r112) == false) goto L32;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        int r100 = getChildCount();
        int r101 = r212 - r210;
        int r102 = r213 - r211;
        int r103 = getPaddingLeft();
        int r104 = getPaddingTop();
        int r105 = getPaddingRight();
        int r106 = getPaddingBottom();
        int r107 = getScrollY();
        int r111 = 0;
        int r112 = 0;
    L4:
        if (r111 >= r100) goto L33;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L32;
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.f161179a == false) goto L32;
        int r115 = r114.f161180b;
        int r116 = r115 & 7;
        int r117 = r115 & 112;
        if (r116 != 1) goto L12;
        int r118 = Math.max((r101 - r113.getMeasuredWidth()) / 2, r103);
    L19:
        int r119 = r118;
        int r120 = r103;
        r103 = r119;
    L21:
        if (r117 != 16) goto L23;
        int r121 = Math.max((r102 - r113.getMeasuredHeight()) / 2, r104);
    L30:
        int r122 = r121;
        int r123 = r104;
        r104 = r122;
    L31:
        int r108 = r104 + r107;
        r113.layout(r103, r108, r113.getMeasuredWidth() + r103, r108 + r113.getMeasuredHeight());
        r112 = r112 + 1;
        r104 = r123;
        r103 = r120;
        goto L32
    L23:
        if (r117 != 48) goto L25;
        r123 = r113.getMeasuredHeight() + r104;
        goto L31
    L25:
        if (r117 == 80) goto L27;
        r123 = r104;
        goto L31
    L27:
        r121 = (r102 - r106) - r113.getMeasuredHeight();
        r106 = r106 + r113.getMeasuredHeight();
        goto L30
    L12:
        if (r116 != 3) goto L14;
        r120 = r113.getMeasuredWidth() + r103;
        goto L21
    L14:
        if (r116 == 5) goto L16;
        r120 = r103;
        goto L21
    L16:
        r118 = (r101 - r105) - r113.getMeasuredWidth();
        r105 = r105 + r113.getMeasuredWidth();
    L32:
        r111 = r111 + 1;
        goto L4
    L33:
        int r109 = (r102 - r104) - r106;
        int r124 = 0;
    L34:
        if (r124 >= r100) goto L45;
        View r125 = getChildAt(r124);
        if (r125.getVisibility() == 8) goto L44;
        LayoutParams r126 = (LayoutParams) r125.getLayoutParams();
        m r127 = q(r125);
        if (r126.f161179a == true) goto L44;
        if (r127 == null) goto L44;
        float r128 = r109;
        int r129 = ((int) (r127.f161200e * r128)) + r104;
        if (r126.f161182d == false) goto L43;
        r126.f161182d = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((r101 - r103) - r105, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.f161181c), 1073741824));
    L43:
        r125.layout(r103, r129, r125.getMeasuredWidth() + r103, r125.getMeasuredHeight() + r129);
    L44:
        r124 = r124 + 1;
        goto L34
    L45:
        this.F = r103;
        this.G = r101 - r105;
        this.f161133b2 = r112;
        if (this.S1 == false) goto L48;
        boolean r130 = false;
        D(this.f161167u, false, 0, false);
    L49:
        this.S1 = r130;
        if (this.O2 == true) goto L52;
        return;
    L52:
        if (this.M2 == false) goto L65;
        this.M2 = r130;
        ALogger.i("SkipMeasureOpt", "onLayout mSkipMeasure reset false");
        return;
    L65:
        return;
    L48:
        r130 = false;
        goto L49
    }
}
