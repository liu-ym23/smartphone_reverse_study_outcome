package com.bytedance.android.shopping.store.tabkit.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.utils.CommonUtils;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004\u000b\f\r\u000eB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Companion", "SavedState", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final /* synthetic */ int H = 0;
    public int A;
    public int B;
    public VelocityTracker C;
    public boolean D;
    public final Set<a> E;
    public boolean F;
    public final TabKitBottomSheetBehavior$dragCallback$1 G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f186658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f186659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f186660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f186661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f186662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f186663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f186664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f186665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f186666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f186667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f186668k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f186669l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f186670m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f186671n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f186672o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f186673p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f186674q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f186675r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WeakReference<View> f186676s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewDragHelper f186677t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f186678u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f186679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f186680w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f186681x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f186682y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f186683z;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetBehavior$Companion$State;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface State {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitBottomSheetBehavior$SavedState;", "Landroid/view/AbsSavedState;", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f186684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f186685b;

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
            this.f186684a = r100.readInt();
            this.f186685b = r100.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f186684a);
            r100.writeInt(this.f186685b);
        }

        public SavedState(Parcelable r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "superState");
            super(r100);
            this.f186684a = r101;
            this.f186685b = r102;
        }
    }

    public interface a {
        void a(View r100, int r101);

        void b(View r100, float r101);

        void c(View r100, float r101, int r102, int r103, int r104);
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f186686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f186687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TabKitBottomSheetBehavior f186688c;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (TabKitBottomSheetBehavior.a(this.f186688c).continueSettling(true) == false) goto L5;
            this.f186686a.postOnAnimation(this);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.f186688c.setStateInternal(this.f186687b);     // Catch: Throwable -> L7
            goto L12
        }

        public b(TabKitBottomSheetBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f186688c = r100;
            this.f186686a = r101;
            this.f186687b = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f186689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TabKitBottomSheetBehavior f186690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f186691c;

        public c(View r100, TabKitBottomSheetBehavior r101, int r102) {
            this.f186689a = r100;
            this.f186690b = r101;
            this.f186691c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TabKitBottomSheetBehavior r100 = this.f186690b;     // Catch: Throwable -> L4
            View r101 = this.f186689a;     // Catch: Throwable -> L4
            int r102 = this.f186691c;     // Catch: Throwable -> L4
            int r103 = TabKitBottomSheetBehavior.H;     // Catch: Throwable -> L4
            r100.startSettlingAnimation(r101, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$onLayoutChild$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C104051 extends MutablePropertyReference0Impl {
        public C104051(TabKitBottomSheetBehavior r100) {
            super(r100, TabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return TabKitBottomSheetBehavior.a((TabKitBottomSheetBehavior) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ViewDragHelper r101 = (ViewDragHelper) r100;
            ((TabKitBottomSheetBehavior) this.receiver).f186677t = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$onTouchEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C104061 extends MutablePropertyReference0Impl {
        public C104061(TabKitBottomSheetBehavior r100) {
            super(r100, TabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return TabKitBottomSheetBehavior.a((TabKitBottomSheetBehavior) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ViewDragHelper r101 = (ViewDragHelper) r100;
            ((TabKitBottomSheetBehavior) this.receiver).f186677t = r101;
        }
    }

    static {
    }

    public final int getExpandedOffset() {
        if (this.f186659b == true) goto L7;
        return 0;
    L7:
        return this.f186673p;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$dragCallback$1] */
    public TabKitBottomSheetBehavior() {
        this.f186658a = 4;
        this.f186659b = true;
        this.f186662e = true;
        this.f186663f = true;
        this.f186664g = true;
        this.f186682y = -1;
        this.f186683z = true;
        this.E = new LinkedHashSet();
        this.G = new TabKitBottomSheetBehavior$dragCallback$1(this);
    }

    public static final /* synthetic */ ViewDragHelper a(TabKitBottomSheetBehavior r100) {
        ViewDragHelper r101 = r100.f186677t;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L5:
        return r101;
    }

    public final void setHideable(boolean r100) {
        if (this.f186661d == r100) goto L10;
        this.f186661d = r100;
        if (r100 == false) goto L7;
        return;
    L7:
        if (this.f186658a != 5) goto L12;
        setState(4);
        return;
    L12:
        return;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f186669l == true) goto L12;
        this.f186669l = true;
    L14:
        if (r101 == false) goto L25;
        int r102 = this.f186658a;
        if (r102 != 4) goto L18;
    L19:
        WeakReference<View> r103 = this.f186676s;
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
        if (this.f186669l == false) goto L10;
    L13:
        this.f186669l = false;
        this.f186660c = Math.max(0, r100);
        this.f186675r = this.f186672o - r100;
        goto L14
    L10:
        if (this.f186660c == r100) goto L12;
        goto L12
    }

    public final void setState(int r100) {
        if (this.f186658a != r100) goto L5;
        return;
    L5:
        WeakReference<View> r101 = this.f186676s;
        if (r101 != null) goto L19;
        this.F = true;
        if (r100 != 4) goto L10;
    L17:
        this.f186658a = r100;
        return;
    L10:
        if (r100 == 3) goto L17;
        if (r100 == 6) goto L17;
        if (this.f186661d == true) goto L16;
        return;
    L16:
        if (r100 == 5) goto L17;
        return;
    L19:
        this.F = false;
        if (r101 == null) goto L34;
        View r102 = r101.get();
        if (r102 == null) goto L35;
        this.f186666i = true;
        if (r102.getParent() != null) goto L26;
    L30:
        startSettlingAnimation(r102, r100);
        return;
    L26:
        if (r102.getParent().isLayoutRequested() == false) goto L30;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L30;
        r102.post(new c(r102, this, r100));
        return;
    L35:
        return;
    }

    public final void setStateInternal(int r100) {
        if (r100 != 4) goto L8;
        if (this.f186664g == true) goto L8;
        r100 = 3;
    L8:
        if (this.f186658a == r100) goto L17;
        this.f186658a = r100;
        WeakReference<View> r101 = this.f186676s;
        if (r101 == null) goto L19;
        View r102 = r101.get();
        if (r102 == null) goto L20;
        Iterator<T> r103 = this.E.iterator();
    L15:
        if (r103.hasNext() == false) goto L21;
        ((a) r103.next()).a(r102, r100);
        goto L15
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior$dragCallback$1] */
    public TabKitBottomSheetBehavior(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f186658a = 4;
        this.f186659b = true;
        this.f186662e = true;
        this.f186663f = true;
        this.f186664g = true;
        this.f186682y = -1;
        this.f186683z = true;
        this.E = new LinkedHashSet();
        this.G = new TabKitBottomSheetBehavior$dragCallback$1(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
    L8:
        setPeekHeight(r104);
        setHideable(r102.getBoolean(1, false));
        boolean r105 = r102.getBoolean(0, true);
        if (this.f186659b == r105) goto L23;
        this.f186659b = r105;
        if (this.f186676s == null) goto L17;
        if (r105 == false) goto L14;
        int r106 = Math.max(this.f186672o - this.f186671n, this.f186673p);
    L15:
        this.f186675r = r106;
        goto L17
    L14:
        r106 = this.f186672o - this.f186671n;
    L17:
        if (this.f186659b == true) goto L19;
    L21:
        int r107 = this.f186658a;
    L22:
        setStateInternal(r107);
        goto L23
    L19:
        if (this.f186658a != 6) goto L21;
        r107 = 3;
    L23:
        this.f186667j = r102.getBoolean(3, false);
        r102.recycle();
        Handler r108 = CommonUtils.f186901a;
        CommonUtils.c(false, new AnonymousClass1(this, r100));
        return;
    L7:
        r104 = r102.getDimensionPixelSize(2, -1);
        goto L8
    }

    public final void b(int r110, int r111) {
        WeakReference<View> r100 = this.f186676s;
        if (r100 == null) goto L17;
        View r101 = r100.get();
        if (r101 == null) goto L24;
        int r102 = this.f186675r;
        if (r110 <= r102) goto L9;
        int r103 = this.f186672o - r102;
    L10:
        int r104 = r103;
        Iterator<T> r105 = this.E.iterator();
    L12:
        if (r105.hasNext() == false) goto L25;
        a r106 = (a) r105.next();
        if (r104 == 0) goto L15;
        float r107 = r104;
        r106.b(r101, (this.f186675r - r110) / r107);
        int r108 = this.f186675r - r110;
        r106.c(r101, r108 / r107, r108, r111, this.f186658a);
        goto L12
    L15:
        r106.b(r101, 0.0f);
        r106.c(r101, 0.0f, this.f186675r - r110, r111, this.f186658a);
        goto L12
    L25:
        return;
    L9:
        r103 = r102 - getExpandedOffset();
        goto L10
    L24:
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Parcelable r102 = super.onSaveInstanceState(r100, r101);
        if (r102 != null) goto L5;
        r102 = Bundle.EMPTY;
    L5:
        int r103 = this.f186658a;
        if (this.f186669l == false) goto L8;
        int r104 = -1;
    L10:
        return new SavedState(r102, r103, r104);
    L8:
        r104 = this.f186660c;
        goto L10
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f186675r;
    L21:
        ViewDragHelper r103 = this.f186677t;
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
        int r104 = this.f186674q;
        if (this.f186659b == false) goto L15;
        int r105 = this.f186673p;
        if (r104 > r105) goto L15;
        r102 = r105;
        r101 = 3;
    L15:
        r102 = r104;
        goto L21
    L17:
        if (r101 != 5) goto L30;
        if (this.f186661d == false) goto L30;
        r102 = this.f186672o;
    L30:
        throw new IllegalArgumentException("Invalid state: " + r101);
    }

    public final void c(View r100, float r110, boolean r111) {
        boolean r101 = true;
        int r102 = 0;
        if (Math.abs(r110) <= this.A) goto L5;
        boolean r103 = true;
    L6:
        int r104 = r100.getTop();
        int r105 = 6;
        if (r103 == false) goto L23;
        if (r110 >= 0) goto L23;
        if (this.f186659b == true) goto L13;
        int r112 = r100.getTop();
        int r106 = this.f186674q;
        if (r112 > r106) goto L74;
    L66:
        r105 = 3;
        r106 = r102;
    L74:
        if (r111 == false) goto L79;
        ViewDragHelper r113 = this.f186677t;
        if (r113 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L78:
        boolean r114 = r113.smoothSlideViewTo(r100, r100.getLeft(), r106);
    L83:
        if (r114 == false) goto L85;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new b(this, r100, r105));
        return;
    L85:
        setStateInternal(r105);
        return;
    L79:
        ViewDragHelper r115 = this.f186677t;
        if (r115 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L82:
        r114 = r115.settleCapturedViewAt(r100.getLeft(), r106);
        goto L83
    L13:
        if (this.f186662e == false) goto L16;
        r102 = this.f186673p;
        goto L66
    L16:
        if (this.f186667j == false) goto L18;
        int r116 = this.f186672o;
    L59:
        r106 = r116;
    L60:
        r105 = 5;
        goto L74
    L18:
        int r117 = this.f186675r;
    L50:
        r106 = r117;
        r105 = 4;
    L23:
        if (this.f186661d == false) goto L40;
        float r107 = 0.1f * r110;
        if (this.f186667j == false) goto L30;
        if (r107 <= this.f186675r) goto L30;
    L36:
        if (r101 == false) goto L40;
        if (this.f186668k == true) goto L40;
        r116 = this.f186672o;
    L30:
        if (r100.getTop() >= this.f186675r) goto L33;
    L35:
        r101 = false;
        goto L36
    L33:
        if ((Math.abs((r100.getTop() + r107) - this.f186675r) / this.f186660c) <= 0.5f) goto L35;
    L40:
        if (r103 == false) goto L52;
        if (r110 <= 0) goto L52;
        if (this.f186667j == false) goto L49;
        r102 = this.f186672o;
        if (this.f186668k == true) goto L66;
        r106 = r102;
        goto L60
    L49:
        r117 = this.f186675r;
    L52:
        if (this.f186659b == true) goto L54;
        int r118 = this.f186674q;
        if (r104 >= r118) goto L69;
        if (r104 < Math.abs(r104 - this.f186675r)) goto L66;
        r106 = this.f186674q;
        goto L74
    L69:
        if (Math.abs(r104 - r118) >= Math.abs(r104 - this.f186675r)) goto L71;
        r106 = this.f186674q;
        goto L74
    L71:
        r117 = this.f186675r;
        goto L50
    L54:
        if (Math.abs(r104 - this.f186673p) >= Math.abs(r104 - this.f186675r)) goto L57;
        r102 = this.f186673p;
        goto L66
    L57:
        if (this.f186667j == false) goto L61;
        r116 = this.f186672o;
        goto L59
    L61:
        r117 = this.f186675r;
        goto L50
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.f186663f == true) goto L5;
    L43:
        this.f186683z = false;
        return false;
    L5:
        if (r101.isShown() == false) goto L43;
        int r103 = r102.getActionMasked();
        this.f186678u = (int) r102.getX();
        this.f186679v = (int) r102.getY();
        if (r103 != 0) goto L14;
        this.f186682y = -1;
        VelocityTracker r104 = this.C;
        if (r104 == null) goto L12;
        r104.recycle();
    L12:
        this.C = null;
    L14:
        if (this.C != null) goto L16;
        this.C = VelocityTracker.obtain();
    L16:
        VelocityTracker r105 = this.C;
        if (r105 == null) goto L20;
        r105.addMovement(r102);
    L20:
        if (r103 == 0) goto L29;
        if (r103 != 1) goto L23;
    L25:
        this.f186682y = -1;
        if (this.f186683z == true) goto L36;
        this.f186683z = true;
        return false;
    L36:
        if (this.f186683z == false) goto L45;
        ViewDragHelper r106 = this.f186677t;
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
        this.f186682y = r102.getPointerId(r102.getActionIndex());
        this.f186680w = (int) r102.getY();
        this.f186681x = (int) r102.getX();
        ViewDragHelper r107 = this.f186677t;
        if (r107 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L32:
        r107.abort();
        this.D = false;
        if (r100.isPointInChildBounds(r101, this.f186678u, this.f186680w) == true) goto L36;
        dm.a.a("shop_bottom_sheet").a("Not touching the sheet. parent=" + r100 + "\nchild=" + r101 + "\n,lastTouchX=" + this.f186678u + "\n,initialTouchY=" + this.f186680w);
        this.f186683z = false;
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
        this.f186672o = r100.getHeight();
        if (this.f186669l == true) goto L10;
        this.f186671n = this.f186660c;
    L14:
        int r104 = Math.max(0, this.f186672o - r101.getHeight());
        this.f186673p = r104;
        int r105 = this.f186672o;
        this.f186674q = r105 / 2;
        if (this.f186659b == false) goto L17;
        int r106 = Math.max(r105 - this.f186671n, r104);
    L18:
        this.f186675r = r106;
        switch(this.f186658a) {
            case 1: goto L25;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            default: goto L26;
        };
    L21:
        ViewCompat.offsetTopAndBottom(r101, this.f186674q);
        goto L26
    L22:
        ViewCompat.offsetTopAndBottom(r101, this.f186672o);
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
        this.f186676s = new WeakReference(r101);
        if (this.f186677t != null) goto L29;
        this.f186677t = ViewDragHelper.create(r100, this.G);
    L29:
        r101.getTop();
        if (this.F == false) goto L39;
        this.F = false;
        WeakReference<View> r107 = this.f186676s;
        if (r107 == null) goto L39;
        View r108 = r107.get();
        if (r108 == null) goto L39;
        Iterator<T> r109 = this.E.iterator();
    L37:
        if (r109.hasNext() == false) goto L39;
        ((a) r109.next()).a(r108, this.f186658a);
    L39:
        return true;
    L17:
        r106 = r105 - this.f186671n;
        goto L18
    L10:
        if (this.f186670m != 0) goto L12;
        this.f186670m = ExtensionsKt.a(64);
    L12:
        this.f186671n = Math.max(this.f186670m, this.f186672o - ((r100.getWidth() * 9) / 16));
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
        setPeekHeight(r103.f186685b);
        int r105 = r103.f186684a;
        if (r105 != 1) goto L8;
    L9:
        r105 = 4;
    L10:
        this.f186658a = r105;
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
        if (this.f186663f == true) goto L5;
    L48:
        return false;
    L5:
        if (r101.isShown() == false) goto L48;
        dm.a.a("shop_bottom_sheet").a("onTouchEvent lastTouchY=" + this.f186679v + ", initialTouchY=" + this.f186680w + ", currentY=" + r102.getY() + ",child.top=" + r101.getTop() + ",state=" + this.f186658a + ",collapsedOffset=" + this.f186675r);
        int r103 = r102.getActionMasked();
        boolean r104 = true;
        if (r103 == 0) goto L10;
    L12:
        this.f186678u = (int) r102.getX();
        this.f186679v = (int) r102.getY();
        if (r103 != 0) goto L19;
        this.f186682y = -1;
        VelocityTracker r105 = this.C;
        if (r105 == null) goto L17;
        r105.recycle();
    L17:
        this.C = null;
    L19:
        if (this.C != null) goto L21;
        this.C = VelocityTracker.obtain();
    L21:
        VelocityTracker r106 = this.C;
        if (r106 == null) goto L24;
        r106.addMovement(r102);
    L24:
        ViewDragHelper r107 = this.f186677t;
        if (r107 == null) goto L31;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L28
        r107.processTouchEvent(r102);     // Catch: Throwable -> L28
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        if (this.f186683z == true) goto L33;
    L46:
        this.f186666i = false;
        return this.f186683z;
    L33:
        if (r103 != 2) goto L46;
        int r110 = Math.abs(this.f186680w - this.f186679v);
        ViewDragHelper r111 = this.f186677t;
        if (r111 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L38:
        if (r110 >= r111.getTouchSlop()) goto L41;
        r104 = false;
    L41:
        if (r104 == false) goto L46;
        ViewDragHelper r112 = this.f186677t;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
    L45:
        r112.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
        goto L46
    L10:
        if (this.f186658a != 1) goto L12;
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
        if (this.D == false) goto L18;
        VelocityTracker r104 = this.C;
        if (r104 == null) goto L14;
        r104.computeCurrentVelocity(1000, this.B);
        float r105 = r104.getYVelocity(this.f186682y);
    L15:
        c(r101, r105, true);
        this.D = false;
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
        if (this.f186663f == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r102, null) == false) goto L11;
        if (this.f186658a == 3) goto L9;
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
        this.D = false;
        dm.a.a("shop_bottom_sheet").a("onStartNestedScroll ,child.top=" + r101.getTop() + ",state=" + this.f186658a);
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
        dm.a.a("shop_bottom_sheet").a("onNestedPreScroll ,child.top=" + r101.getTop() + ",state=" + this.f186658a + ", dy=" + r104);
        int r107 = r101.getTop();
        int r108 = r107 - r104;
        if (r104 > 0) goto L11;
        if (r104 < 0) goto L16;
    L24:
        b(r101.getTop(), r104);
        this.D = true;
        return;
    L16:
        if (r102.canScrollVertically(-1) == true) goto L24;
        int r109 = this.f186675r;
        if (r108 > r109) goto L20;
    L23:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    L20:
        if (this.f186661d == true) goto L23;
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
