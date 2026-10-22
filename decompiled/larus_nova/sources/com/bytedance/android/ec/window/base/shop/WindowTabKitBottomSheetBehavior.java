package com.bytedance.android.ec.window.base.shop;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.window.base.common.uiext.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004\u000b\f\r\u000eB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowTabKitBottomSheetBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Companion", "SavedState", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabKitBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final /* synthetic */ int D = 0;
    public final Set<a> A;
    public boolean B;
    public final WindowTabKitBottomSheetBehavior$dragCallback$1 C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f49596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f49599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f49600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f49601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49608n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference<View> f49609o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewDragHelper f49610p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f49611q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f49612r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f49613s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f49614t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f49615u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f49616v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f49617w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f49618x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public VelocityTracker f49619y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f49620z;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowTabKitBottomSheetBehavior$Companion$State;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface State {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/WindowTabKitBottomSheetBehavior$SavedState;", "Landroid/view/AbsSavedState;", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49622b;

        public static final class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "source");
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                Intrinsics.checkNotNullParameter(r100, "source");
                Intrinsics.checkNotNullParameter(r101, "loader");
                return new SavedState(r100);
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            this.f49621a = r100.readInt();
            this.f49622b = r100.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f49621a);
            r100.writeInt(this.f49622b);
        }

        public SavedState(Parcelable r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "superState");
            super(r100);
            this.f49621a = r101;
            this.f49622b = r102;
        }
    }

    public interface a {
        void a();

        void b();

        void onSlide();
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f49623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WindowTabKitBottomSheetBehavior f49625c;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (WindowTabKitBottomSheetBehavior.a(this.f49625c).continueSettling(true) == false) goto L5;
            this.f49623a.postOnAnimation(this);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.f49625c.setStateInternal(this.f49624b);     // Catch: Throwable -> L7
            goto L12
        }

        public b(WindowTabKitBottomSheetBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f49625c = r100;
            this.f49623a = r101;
            this.f49624b = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.shop.WindowTabKitBottomSheetBehavior$onLayoutChild$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(WindowTabKitBottomSheetBehavior r100) {
            super(r100, WindowTabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return WindowTabKitBottomSheetBehavior.a((WindowTabKitBottomSheetBehavior) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ViewDragHelper r101 = (ViewDragHelper) r100;
            ((WindowTabKitBottomSheetBehavior) this.receiver).f49610p = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.shop.WindowTabKitBottomSheetBehavior$onTouchEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C98571 extends MutablePropertyReference0Impl {
        public C98571(WindowTabKitBottomSheetBehavior r100) {
            super(r100, WindowTabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return WindowTabKitBottomSheetBehavior.a((WindowTabKitBottomSheetBehavior) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ViewDragHelper r101 = (ViewDragHelper) r100;
            ((WindowTabKitBottomSheetBehavior) this.receiver).f49610p = r101;
        }
    }

    static {
    }

    public final int getExpandedOffset() {
        if (this.f49596b == true) goto L7;
        return 0;
    L7:
        return this.f49606l;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.ec.window.base.shop.WindowTabKitBottomSheetBehavior$dragCallback$1] */
    public WindowTabKitBottomSheetBehavior() {
        this.f49595a = 4;
        this.f49596b = true;
        this.f49599e = true;
        this.f49600f = true;
        this.f49615u = -1;
        this.f49616v = true;
        this.A = new LinkedHashSet();
        this.C = new WindowTabKitBottomSheetBehavior$dragCallback$1(this);
    }

    public static final /* synthetic */ ViewDragHelper a(WindowTabKitBottomSheetBehavior r100) {
        ViewDragHelper r101 = r100.f49610p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L5:
        return r101;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f49602h == true) goto L12;
        this.f49602h = true;
    L14:
        if (r101 == false) goto L25;
        int r102 = this.f49595a;
        if (r102 != 4) goto L18;
    L19:
        WeakReference<View> r103 = this.f49609o;
        if (r103 == null) goto L27;
        View r104 = r103.get();
        if (r104 == null) goto L28;
        r104.requestLayout();
        return;
    L28:
        return;
    L27:
        return;
    L18:
        if (r102 == 5) goto L19;
        return;
    L25:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.f49602h == false) goto L10;
    L13:
        this.f49602h = false;
        this.f49597c = Math.max(0, r100);
        this.f49608n = this.f49605k - r100;
        goto L14
    L10:
        if (this.f49597c == r100) goto L12;
        goto L12
    }

    public final void setStateInternal(int r100) {
        if (this.f49595a == r100) goto L12;
        this.f49595a = r100;
        WeakReference<View> r101 = this.f49609o;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.get() == null) goto L15;
        Iterator<T> r102 = this.A.iterator();
    L10:
        if (r102.hasNext() == false) goto L16;
        ((a) r102.next()).a();
        goto L10
    L16:
        return;
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.android.ec.window.base.shop.WindowTabKitBottomSheetBehavior$dragCallback$1] */
    public WindowTabKitBottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f49595a = 4;
        this.f49596b = true;
        this.f49599e = true;
        this.f49600f = true;
        this.f49615u = -1;
        this.f49616v = true;
        this.A = new LinkedHashSet();
        this.C = new WindowTabKitBottomSheetBehavior$dragCallback$1(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
    L8:
        setPeekHeight(r104);
        boolean r105 = r102.getBoolean(1, false);
        if (this.f49598d == r105) goto L29;
        this.f49598d = r105;
        if (r105 == true) goto L29;
        int r106 = this.f49595a;
        if (r106 != 5) goto L29;
        if (r106 == 4) goto L29;
        WeakReference<View> r107 = this.f49609o;
        if (r107 != null) goto L19;
        this.B = true;
        this.f49595a = 4;
        goto L29
    L19:
        this.B = false;
        View r108 = r107.get();
        if (r108 == null) goto L29;
        if (r108.getParent() != null) goto L24;
    L28:
        startSettlingAnimation(r108, 4);
        goto L29
    L24:
        if (r108.getParent().isLayoutRequested() == false) goto L28;
        if (ViewCompat.isAttachedToWindow(r108) == false) goto L28;
        r108.post(new m(r108, this));
    L29:
        boolean r109 = r102.getBoolean(0, true);
        if (this.f49596b == r109) goto L44;
        this.f49596b = r109;
        if (this.f49609o == null) goto L38;
        if (r109 == false) goto L35;
        int r110 = Math.max(this.f49605k - this.f49604j, this.f49606l);
    L36:
        this.f49608n = r110;
        goto L38
    L35:
        r110 = this.f49605k - this.f49604j;
    L38:
        if (this.f49596b == true) goto L40;
    L42:
        int r111 = this.f49595a;
    L43:
        setStateInternal(r111);
        goto L44
    L40:
        if (this.f49595a != 6) goto L42;
        r111 = 3;
    L44:
        this.f49601g = r102.getBoolean(3, false);
        r102.recycle();
        ViewConfiguration r112 = ViewConfiguration.get(r100);
        this.f49617w = r112.getScaledMinimumFlingVelocity();
        this.f49618x = r112.getScaledMaximumFlingVelocity();
        return;
    L7:
        r104 = r102.getDimensionPixelSize(2, -1);
        goto L8
    }

    public final void b(int r100, int r101) {
        WeakReference<View> r102 = this.f49609o;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.get() == null) goto L24;
        int r103 = this.f49608n;
        if (r100 <= r103) goto L9;
        int r104 = this.f49605k - r103;
    L10:
        Iterator<T> r105 = this.A.iterator();
    L12:
        if (r105.hasNext() == false) goto L25;
        a r106 = (a) r105.next();
        if (r104 == 0) goto L15;
        r106.onSlide();
        r106.b();
        goto L12
    L15:
        r106.onSlide();
        r106.b();
        goto L12
    L25:
        return;
    L9:
        r104 = r103 - getExpandedOffset();
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Parcelable r102 = super.onSaveInstanceState(r100, r101);
        if (r102 != null) goto L5;
        r102 = Bundle.EMPTY;
    L5:
        int r103 = this.f49595a;
        if (this.f49602h == false) goto L8;
        int r104 = -1;
    L10:
        return new SavedState(r102, r103, r104);
    L8:
        r104 = this.f49597c;
        goto L10
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f49608n;
    L21:
        ViewDragHelper r103 = this.f49610p;
        if (r103 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L25:
        if (r103.smoothSlideViewTo(r100, r100.getLeft(), r102) == false) goto L27;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new b(this, r100, r101));
        return;
    L27:
        setStateInternal(r101);
        return;
    L6:
        if (r101 != 3) goto L9;
        r102 = getExpandedOffset();
        goto L21
    L9:
        if (r101 != 6) goto L17;
        int r104 = this.f49607m;
        if (this.f49596b == false) goto L15;
        int r105 = this.f49606l;
        if (r104 > r105) goto L15;
        r102 = r105;
        r101 = 3;
    L15:
        r102 = r104;
        goto L21
    L17:
        if (r101 != 5) goto L30;
        if (this.f49598d == false) goto L30;
        r102 = this.f49605k;
    L30:
        throw new IllegalArgumentException("Invalid state: " + r101);
    }

    public final void c(View r100, float r110, boolean r111) {
        boolean r101 = true;
        int r102 = 0;
        if (Math.abs(r110) <= this.f49617w) goto L5;
        boolean r103 = true;
    L6:
        int r104 = r100.getTop();
        int r105 = 6;
        if (r103 == false) goto L23;
        if (r110 >= 0) goto L23;
        if (this.f49596b == true) goto L13;
        int r112 = r100.getTop();
        int r106 = this.f49607m;
        if (r112 > r106) goto L69;
    L61:
        r105 = 3;
        r106 = r102;
    L69:
        if (r111 == false) goto L74;
        ViewDragHelper r113 = this.f49610p;
        if (r113 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L73:
        boolean r114 = r113.smoothSlideViewTo(r100, r100.getLeft(), r106);
    L78:
        if (r114 == false) goto L80;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new b(this, r100, r105));
        return;
    L80:
        setStateInternal(r105);
        return;
    L74:
        ViewDragHelper r115 = this.f49610p;
        if (r115 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L77:
        r114 = r115.settleCapturedViewAt(r100.getLeft(), r106);
        goto L78
    L13:
        if (this.f49599e == false) goto L16;
        r102 = this.f49606l;
        goto L61
    L16:
        if (this.f49601g == false) goto L18;
        int r116 = this.f49605k;
    L44:
        r106 = r116;
        r105 = 5;
        goto L69
    L18:
        int r117 = this.f49608n;
    L46:
        r106 = r117;
        r105 = 4;
    L23:
        if (this.f49598d == false) goto L38;
        float r107 = 0.1f * r110;
        if (this.f49601g == false) goto L30;
        if (r107 <= this.f49608n) goto L30;
    L36:
        if (r101 == false) goto L38;
        r116 = this.f49605k;
    L30:
        if (r100.getTop() >= this.f49608n) goto L33;
    L35:
        r101 = false;
        goto L36
    L33:
        if ((Math.abs((r100.getTop() + r107) - this.f49608n) / this.f49597c) <= 0.5f) goto L35;
    L38:
        if (r103 == false) goto L48;
        if (r110 <= 0) goto L48;
        if (this.f49601g == false) goto L45;
        r116 = this.f49605k;
        goto L44
    L45:
        r117 = this.f49608n;
    L48:
        if (this.f49596b == true) goto L50;
        int r118 = this.f49607m;
        if (r104 >= r118) goto L64;
        if (r104 < Math.abs(r104 - this.f49608n)) goto L61;
        r106 = this.f49607m;
        goto L69
    L64:
        if (Math.abs(r104 - r118) >= Math.abs(r104 - this.f49608n)) goto L66;
        r106 = this.f49607m;
        goto L69
    L66:
        r117 = this.f49608n;
        goto L46
    L50:
        if (Math.abs(r104 - this.f49606l) >= Math.abs(r104 - this.f49608n)) goto L53;
        r102 = this.f49606l;
        goto L61
    L53:
        if (this.f49601g == false) goto L56;
        r116 = this.f49605k;
        goto L44
    L56:
        r117 = this.f49608n;
        goto L46
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.f49600f == true) goto L5;
    L43:
        this.f49616v = false;
        return false;
    L5:
        if (r101.isShown() == false) goto L43;
        int r103 = r102.getActionMasked();
        this.f49611q = (int) r102.getX();
        this.f49612r = (int) r102.getY();
        if (r103 != 0) goto L14;
        this.f49615u = -1;
        VelocityTracker r104 = this.f49619y;
        if (r104 == null) goto L12;
        r104.recycle();
    L12:
        this.f49619y = null;
    L14:
        if (this.f49619y != null) goto L16;
        this.f49619y = VelocityTracker.obtain();
    L16:
        VelocityTracker r105 = this.f49619y;
        if (r105 == null) goto L20;
        r105.addMovement(r102);
    L20:
        if (r103 == 0) goto L29;
        if (r103 != 1) goto L23;
    L25:
        this.f49615u = -1;
        if (this.f49616v == true) goto L36;
        this.f49616v = true;
        return false;
    L36:
        if (this.f49616v == false) goto L45;
        ViewDragHelper r106 = this.f49610p;
        if (r106 != null) goto L40;
        return false;
    L40:
        if (r106.shouldInterceptTouchEvent(r102) == false) goto L47;
        return true;
    L47:
        return false;
    L45:
        return false;
    L23:
        if (r103 == 3) goto L25;
    L29:
        this.f49615u = r102.getPointerId(r102.getActionIndex());
        this.f49613s = (int) r102.getY();
        this.f49614t = (int) r102.getX();
        ViewDragHelper r107 = this.f49610p;
        if (r107 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L32:
        r107.abort();
        this.f49620z = false;
        if (r100.isPointInChildBounds(r101, this.f49611q, this.f49613s) == true) goto L36;
        dm.a.a("shop_bottom_sheet").a("Not touching the sheet. parent=" + r100 + "\nchild=" + r101 + "\n,lastTouchX=" + this.f49611q + "\n,initialTouchY=" + this.f49613s);
        this.f49616v = false;
        goto L36
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r100.getFitsSystemWindows() == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.f49605k = r100.getHeight();
        if (this.f49602h == true) goto L10;
        this.f49604j = this.f49597c;
    L14:
        int r104 = Math.max(0, this.f49605k - r101.getHeight());
        this.f49606l = r104;
        int r105 = this.f49605k;
        this.f49607m = r105 / 2;
        if (this.f49596b == false) goto L17;
        int r106 = Math.max(r105 - this.f49604j, r104);
    L18:
        this.f49608n = r106;
        switch(this.f49595a) {
            case 1: goto L25;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            default: goto L26;
        };
    L21:
        ViewCompat.offsetTopAndBottom(r101, this.f49607m);
        goto L26
    L22:
        ViewCompat.offsetTopAndBottom(r101, this.f49605k);
        goto L26
    L23:
        ViewCompat.offsetTopAndBottom(r101, r106);
        goto L26
    L24:
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
        goto L26
    L25:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
    L26:
        this.f49609o = new WeakReference(r101);
        if (this.f49610p != null) goto L29;
        this.f49610p = ViewDragHelper.create(r100, this.C);
    L29:
        r101.getTop();
        if (this.B == false) goto L39;
        this.B = false;
        WeakReference<View> r107 = this.f49609o;
        if (r107 == null) goto L39;
        if (r107.get() == null) goto L39;
        Iterator<T> r108 = this.A.iterator();
    L37:
        if (r108.hasNext() == false) goto L39;
        ((a) r108.next()).a();
    L39:
        return true;
    L17:
        r106 = r105 - this.f49604j;
        goto L18
    L10:
        if (this.f49603i != 0) goto L12;
        this.f49603i = ExtensionsKt.a(64);
    L12:
        this.f49604j = Math.max(this.f49603i, this.f49605k - ((r100.getWidth() * 9) / 16));
        goto L14
    L5:
        if (r101.getFitsSystemWindows() == true) goto L7;
        r101.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "state");
        SavedState r103 = (SavedState) r102;
        Parcelable r104 = r103.getSuperState();
        if (r104 != null) goto L5;
        r104 = Bundle.EMPTY;
    L5:
        super.onRestoreInstanceState(r100, r101, r104);
        setPeekHeight(r103.f49622b);
        int r105 = r103.f49621a;
        if (r105 != 1) goto L8;
    L9:
        r105 = 4;
    L10:
        this.f49595a = r105;
        return;
    L8:
        if (r105 != 2) goto L10;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        boolean r103 = false;
        if (this.f49600f == true) goto L5;
    L47:
        return false;
    L5:
        if (r101.isShown() == false) goto L47;
        dm.a.a("shop_bottom_sheet").a("onTouchEvent lastTouchY=" + this.f49612r + ", initialTouchY=" + this.f49613s + ", currentY=" + r102.getY() + ",child.top=" + r101.getTop() + ",state=" + this.f49595a);
        int r104 = r102.getActionMasked();
        if (r104 == 0) goto L10;
    L12:
        this.f49611q = (int) r102.getX();
        this.f49612r = (int) r102.getY();
        if (r104 != 0) goto L19;
        this.f49615u = -1;
        VelocityTracker r105 = this.f49619y;
        if (r105 == null) goto L17;
        r105.recycle();
    L17:
        this.f49619y = null;
    L19:
        if (this.f49619y != null) goto L21;
        this.f49619y = VelocityTracker.obtain();
    L21:
        VelocityTracker r106 = this.f49619y;
        if (r106 == null) goto L24;
        r106.addMovement(r102);
    L24:
        ViewDragHelper r107 = this.f49610p;
        if (r107 == null) goto L31;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L28
        r107.processTouchEvent(r102);     // Catch: Throwable -> L28
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        if (this.f49616v == false) goto L46;
        if (r104 != 2) goto L46;
        int r110 = Math.abs(this.f49613s - this.f49612r);
        ViewDragHelper r111 = this.f49610p;
        if (r111 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L38:
        if (r110 < r111.getTouchSlop()) goto L40;
        r103 = true;
    L40:
        if (r103 == false) goto L46;
        ViewDragHelper r112 = this.f49610p;
        if (r112 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L44:
        r112.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L46:
        return this.f49616v;
    L10:
        if (this.f49595a != 1) goto L12;
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (r101.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if ((!Intrinsics.areEqual(r102, null)) == false) goto L9;
        return;
    L9:
        if (this.f49620z == false) goto L18;
        VelocityTracker r104 = this.f49619y;
        if (r104 == null) goto L14;
        r104.computeCurrentVelocity(1000, this.f49618x);
        float r105 = r104.getYVelocity(this.f49615u);
    L15:
        c(r101, r105, true);
        this.f49620z = false;
        return;
    L14:
        r105 = 0.0f;
        goto L15
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (this.f49600f == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r102, null) == false) goto L11;
        if (this.f49595a == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L11;
        goto L10
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        this.f49620z = false;
        dm.a.a("shop_bottom_sheet").a("onStartNestedScroll ,child.top=" + r101.getTop() + ",state=" + this.f49595a);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        if (r106 != 1) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r102, null)) == false) goto L8;
        return;
    L8:
        dm.a.a("shop_bottom_sheet").a("onNestedPreScroll ,child.top=" + r101.getTop() + ",state=" + this.f49595a + ", dy=" + r104);
        int r107 = r101.getTop();
        int r108 = r107 - r104;
        if (r104 > 0) goto L11;
        if (r104 < 0) goto L16;
    L24:
        b(r101.getTop(), r104);
        this.f49620z = true;
        return;
    L16:
        if (r102.canScrollVertically(-1) == true) goto L24;
        int r109 = this.f49608n;
        if (r108 > r109) goto L20;
    L23:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    L20:
        if (this.f49598d == true) goto L23;
        int r110 = r107 - r109;
        r105[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(4);
        goto L24
    L11:
        if (r108 >= getExpandedOffset()) goto L13;
        int r111 = r107 - getExpandedOffset();
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(3);
        goto L24
    L13:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    }
}
