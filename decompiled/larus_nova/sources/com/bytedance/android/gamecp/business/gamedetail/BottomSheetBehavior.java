package com.bytedance.android.gamecp.business.gamedetail;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/BottomSheetBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "SaveFlags", "SavedState", "d", "State", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final /* synthetic */ int G = 0;
    public int A;
    public int B;
    public boolean C;
    public Map<View, Integer> D;
    public c E;
    public final BottomSheetBehavior$dragCallback$1 F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f53403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f53404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f53406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f53407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f53408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BottomSheetBehavior<V>.d f53409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f53410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f53413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f53414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f53415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f53416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f53417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f53418p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewDragHelper f53419q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f53420r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f53421s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f53422t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f53423u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f53424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public WeakReference<V> f53425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WeakReference<View> f53426x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<a> f53427y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public VelocityTracker f53428z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/BottomSheetBehavior$SaveFlags;", "", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SaveFlags {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/BottomSheetBehavior$SavedState;", "Landroidx/customview/view/AbsSavedState;", "b", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f53430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f53431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f53432d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f53433e;

        public static final class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "in");
                return new SavedState(r100, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                Intrinsics.checkNotNullParameter(r100, "in");
                return new SavedState(r100, r101);
            }
        }

        public static final class b {
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100, r101);
            this.f53429a = r100.readInt();
            this.f53430b = r100.readInt();
            boolean r102 = false;
            if (r100.readInt() != 1) goto L5;
            boolean r103 = true;
        L6:
            this.f53431c = r103;
            if (r100.readInt() != 1) goto L9;
            boolean r104 = true;
        L10:
            this.f53432d = r104;
            if (r100.readInt() != 1) goto L13;
            r102 = true;
        L13:
            this.f53433e = r102;
            return;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f53429a);
            r100.writeInt(this.f53430b);
            r100.writeInt(this.f53431c ? 1 : 0);
            r100.writeInt(this.f53432d ? 1 : 0);
            r100.writeInt(this.f53433e ? 1 : 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/BottomSheetBehavior$State;", "", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
    }

    public static abstract class a {
        public a() {
        }

        public abstract void a(View r100, float r101);

        public abstract void b(View r100, int r101);
    }

    public static final class b {
        public static BottomSheetBehavior a(View r100) {
            if (r100 == null) goto L4;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        L6:
            if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L17;
            CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
            if ((r102 instanceof BottomSheetBehavior) == false) goto L15;
            if (r102 == null) goto L13;
            return (BottomSheetBehavior) r102;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.business.gamedetail.BottomSheetBehavior<V>");
        L15:
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior".toString());
        L17:
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout".toString());
        L4:
            r101 = null;
            goto L6
        }
    }

    public interface c {
        void onTouch(View r100, MotionEvent r101);
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f53434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f53435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f53436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f53437d;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f53437d.f53419q;     // Catch: Throwable -> L10
            if (r100 == null) goto L7;
            Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L10
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f53434a, this);     // Catch: Throwable -> L10
        L8:
            this.f53435b = false;     // Catch: Throwable -> L10
            return;
        L7:
            this.f53437d.setStateInternal(this.f53436c);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }

        public d(BottomSheetBehavior r100, View r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f53437d = r100;
            this.f53434a = r101;
            this.f53436c = r102;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f53439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f53440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f53441c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f53439a.settleToState(this.f53440b, this.f53441c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(BottomSheetBehavior r100, View r101, int r102) {
            this.f53439a = r100;
            this.f53440b = r101;
            this.f53441c = r102;
        }
    }

    static {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "state");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        return null;
    }

    public final void calculateCollapsedOffset() {
        if (this.f53406d == false) goto L5;
        int r100 = (int) Math.max(this.f53407e, this.f53424v - ((this.f53423u * 9) / 16));
    L7:
        if (this.f53403a == false) goto L9;
        this.f53415m = (int) Math.max(this.f53424v - r100, this.f53412j);
        return;
    L9:
        this.f53415m = this.f53424v - r100;
        return;
    L5:
        r100 = this.f53405c + 0;
        goto L7
    }

    public final int getExpandedOffset() {
        if (this.f53403a == false) goto L6;
        return this.f53412j;
    L6:
        return this.f53411i;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.gamecp.business.gamedetail.BottomSheetBehavior$dragCallback$1] */
    public BottomSheetBehavior() {
        this.f53403a = true;
        this.f53414l = 0.5f;
        this.f53417o = true;
        this.f53418p = 4;
        this.f53427y = new ArrayList();
        this.F = new BottomSheetBehavior$dragCallback$1(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f53425w = null;
        this.f53419q = null;
    }

    public final void dispatchOnSlide(int r100) {
        WeakReference<V> r101 = this.f53425w;
        Intrinsics.checkNotNull(r101);
        V r102 = r101.get();
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f53427y.isEmpty() == true) goto L18;
        int r103 = this.f53415m;
        if (r100 <= r103) goto L9;
    L12:
        int r104 = this.f53415m;
        float r105 = r104 - r100;
        float r106 = this.f53424v - r104;
    L13:
        float r107 = r105 / r106;
        int r108 = this.f53427y.size();
        int r109 = 0;
    L14:
        if (r109 >= r108) goto L19;
        Object r110 = ListProtector.get(this.f53427y, r109);
        Intrinsics.checkNotNull(r110);
        ((a) r110).a(r102, r107);
        r109 = r109 + 1;
        goto L14
    L19:
        return;
    L9:
        if (r103 == getExpandedOffset()) goto L12;
        int r111 = this.f53415m;
        r105 = r111 - r100;
        r106 = r111 - getExpandedOffset();
        goto L13
    }

    public final View findScrollingChild(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L13;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return r104;
    L17:
        return null;
    L13:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        super.onAttachedToLayoutParams(r100);
        this.f53425w = null;
        this.f53419q = null;
    }

    public final void setStateInternal(int r100) {
        if (this.f53418p != r100) goto L5;
        return;
    L5:
        this.f53418p = r100;
        WeakReference<V> r101 = this.f53425w;
        if (r101 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r101);
        V r102 = r101.get();
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = 0;
        boolean r104 = true;
        if (r100 != 3) goto L15;
        updateImportantForAccessibility(true);
    L22:
        if (r100 == 2) goto L30;
        if (r100 == 3) goto L28;
        r104 = false;
    L28:
        if (this.f53408f == r104) goto L30;
        this.f53408f = r104;
    L30:
        int r105 = this.f53427y.size();
    L31:
        if (r103 >= r105) goto L33;
        Object r106 = ListProtector.get(this.f53427y, r103);
        Intrinsics.checkNotNull(r106);
        ((a) r106).b(r102, r100);
        r103 = r103 + 1;
        goto L31
    L33:
        return;
    L15:
        if (r100 != 6) goto L17;
    L20:
        updateImportantForAccessibility(false);
        goto L22
    L17:
        if (r100 == 5) goto L20;
        if (r100 != 4) goto L22;
        goto L20
    }

    public final void settleToStatePendingLayout(int r100) {
        WeakReference<V> r101 = this.f53425w;
        Intrinsics.checkNotNull(r101);
        V r102 = r101.get();
        if (r102 != null) goto L5;
        return;
    L5:
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L8;
    L12:
        settleToState(r102, r100);
        return;
    L8:
        if (r103.isLayoutRequested() == false) goto L12;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L12;
        r102.post(new e(this, r102, r100));
    }

    public final void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.f53425w;
        if (r101 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        V r102 = r101.get();
        Intrinsics.checkNotNull(r102);
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r104 = (CoordinatorLayout) r103;
        int r105 = r104.getChildCount();
        if (r100 == true) goto L11;
    L14:
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L22;
        View r107 = r104.getChildAt(r106);
        WeakReference<V> r108 = this.f53425w;
        Intrinsics.checkNotNull(r108);
        if (r107 == r108.get()) goto L21;
        if (r100 == false) goto L21;
        Map<View, Integer> r109 = this.D;
        Intrinsics.checkNotNull(r109);
        r109.put(r107, Integer.valueOf(r107.getImportantForAccessibility()));
    L21:
        r106 = r106 + 1;
        goto L15
    L22:
        if (r100 == true) goto L29;
        this.D = null;
        return;
    L29:
        return;
    L11:
        if (this.D != null) goto L13;
        this.D = new HashMap(r105);
        goto L14
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.android.gamecp.business.gamedetail.BottomSheetBehavior$dragCallback$1] */
    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f53403a = true;
        this.f53414l = 0.5f;
        this.f53417o = true;
        this.f53418p = 4;
        this.f53427y = new ArrayList();
        this.F = new BottomSheetBehavior$dragCallback$1(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f53410h = r103;
        Intrinsics.checkNotNull(r103);
        r103.setDuration(500);
        ValueAnimator r104 = this.f53410h;
        Intrinsics.checkNotNull(r104);
        r104.addUpdateListener(new com.bytedance.android.gamecp.business.gamedetail.e(this));
        TypedValue r105 = r102.peekValue(2);
        if (r105 == null) goto L7;
        int r106 = r105.data;
        if (r106 != (-1)) goto L7;
        setPeekHeight(r106, false);
    L8:
        boolean r107 = r102.getBoolean(1, false);
        if (this.f53416n == r107) goto L21;
        this.f53416n = r107;
        if (r107 == true) goto L21;
        int r108 = this.f53418p;
        if (r108 != 5) goto L21;
        if (4 == r108) goto L21;
        if (this.f53425w != null) goto L19;
        this.f53418p = 4;
        goto L21
    L19:
        settleToStatePendingLayout(4);
    L21:
        if (this.f53403a == true) goto L33;
        this.f53403a = true;
        if (this.f53425w == null) goto L27;
        calculateCollapsedOffset();
    L27:
        if (this.f53403a == true) goto L29;
    L31:
        int r109 = this.f53418p;
    L32:
        setStateInternal(r109);
        goto L33
    L29:
        if (this.f53418p != 6) goto L31;
        r109 = 3;
    L33:
        this.f53417o = true;
        if (0.5f > 0) goto L36;
    L38:
        boolean r110 = false;
    L39:
        if (r110 == false) goto L46;
        this.f53414l = 0.5f;
        if (this.f53425w == null) goto L43;
        this.f53413k = (int) (this.f53424v * (1 - 0.5f));
    L43:
        this.f53411i = 0;
        r102.recycle();
        this.f53404b = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L46:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1".toString());
    L36:
        if (0.5f >= 1) goto L38;
        r110 = true;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1), false);
        goto L8
    }

    public final void setPeekHeight(int r100, boolean r101) {
        boolean r102 = true;
        if (r100 != (-1)) goto L8;
        if (this.f53406d == true) goto L12;
        this.f53406d = true;
    L14:
        if (r102 == true) goto L16;
        return;
    L16:
        if (this.f53425w == null) goto L24;
        calculateCollapsedOffset();
        if (this.f53418p != 4) goto L25;
        WeakReference<V> r103 = this.f53425w;
        Intrinsics.checkNotNull(r103);
        V r104 = r103.get();
        if (r104 == null) goto L26;
        r104.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r102 = false;
        goto L14
    L8:
        if (this.f53406d == false) goto L10;
    L13:
        this.f53406d = false;
        this.f53405c = (int) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, r100);
        goto L14
    L10:
        if (this.f53405c == r100) goto L12;
        goto L12
    }

    public final void settleToState(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r101 != 4) goto L6;
        int r102 = this.f53415m;
    L19:
        startSettlingAnimation(r100, r101, r102, false);
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f53413k;
        if (this.f53403a == false) goto L19;
        int r103 = this.f53412j;
        if (r102 > r103) goto L19;
        r102 = r103;
        r101 = 3;
        goto L19
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L19
    L15:
        if (this.f53416n == false) goto L22;
        if (r101 != 5) goto L22;
        r102 = this.f53424v;
    L22:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    public final boolean shouldHide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r100.getTop() >= this.f53415m) goto L6;
        return false;
    L6:
        if (this.f53406d == false) goto L8;
        int r102 = (int) Math.max(this.f53407e, this.f53424v - ((this.f53423u * 9) / 16));
    L10:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f53415m) / ((double) r102)) <= 0.5f) goto L13;
        return true;
    L13:
        return false;
    L8:
        r102 = this.f53405c + 0;
        goto L10
    }

    public static boolean a(View r100, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if ((r100 instanceof ViewGroup) == false) goto L19;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getScrollX();
        int r103 = r101.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L19;
        View r105 = r101.getChildAt(r104);
        int r106 = r110 + r102;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r111 + r103;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (a(r105, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L19:
        if (r100.canScrollHorizontally(0) == false) goto L21;
        return true;
    L21:
        if (r100.canScrollVertically(-1) == true) goto L33;
        return false;
    L33:
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r112, "event");
        if (r111.isShown() == true) goto L5;
    L84:
        this.f53420r = true;
        return false;
    L5:
        if (this.f53417o == false) goto L84;
        int r100 = r112.getActionMasked();
        View r101 = null;
        if (r100 != 0) goto L13;
        this.A = -1;
        VelocityTracker r102 = this.f53428z;
        if (r102 == null) goto L13;
        Intrinsics.checkNotNull(r102);
        r102.recycle();
        this.f53428z = null;
    L13:
        if (this.f53428z != null) goto L15;
        this.f53428z = VelocityTracker.obtain();
    L15:
        VelocityTracker r103 = this.f53428z;
        Intrinsics.checkNotNull(r103);
        r103.addMovement(r112);
        if (r100 == 0) goto L43;
        if (r100 != 1) goto L19;
    L39:
        this.C = false;
        this.A = -1;
        if (this.f53420r == false) goto L61;
        this.f53420r = false;
        return false;
    L61:
        if (this.f53420r == true) goto L67;
        ViewDragHelper r113 = this.f53419q;
        if (r113 == null) goto L67;
        Intrinsics.checkNotNull(r113);
        if (r113.shouldInterceptTouchEvent(r112) == false) goto L67;
        return true;
    L67:
        WeakReference<View> r114 = this.f53426x;
        if (r114 == null) goto L70;
        Intrinsics.checkNotNull(r114);
        r101 = r114.get();
    L70:
        if (r100 != 2) goto L86;
        if (r101 != null) goto L73;
        return false;
    L73:
        if (this.f53420r == false) goto L75;
        return false;
    L75:
        if (this.f53418p != 1) goto L77;
        return false;
    L77:
        if (r110.isPointInChildBounds(r101, (int) r112.getX(), (int) r112.getY()) == false) goto L79;
        return false;
    L79:
        if (this.f53419q == null) goto L91;
        double r115 = Math.abs(this.B - r112.getY());
        ViewDragHelper r116 = this.f53419q;
        Intrinsics.checkNotNull(r116);
        if (r115 <= r116.getTouchSlop()) goto L92;
        return true;
    L92:
        return false;
    L91:
        return false;
    L86:
        return false;
    L19:
        if (r100 == 2) goto L23;
        if (r100 == 3) goto L39;
    L23:
        if (this.f53417o == false) goto L61;
        ViewDragHelper r104 = this.f53419q;
        if (r104 == null) goto L61;
        if ((((int) r112.getY()) - this.B) <= r104.getTouchSlop()) goto L35;
        if (p0.a() == false) goto L32;
        return false;
    L32:
        if (a(r111, (int) r112.getX(), (int) r112.getY()) == true) goto L35;
        return true;
    L35:
        if (this.f53418p == 3) goto L61;
        if ((this.B - r112.getY()) <= r104.getTouchSlop()) goto L61;
        return true;
    L43:
        int r105 = (int) r112.getX();
        this.B = (int) r112.getY();
        if (this.f53418p == 2) goto L54;
        WeakReference<View> r106 = this.f53426x;
        if (r106 == null) goto L48;
        Intrinsics.checkNotNull(r106);
        View r107 = r106.get();
    L49:
        if (r107 == null) goto L54;
        if (r110.isPointInChildBounds(r107, r105, this.B) == false) goto L54;
        this.A = r112.getPointerId(r112.getActionIndex());
        this.C = true;
        goto L54
    L48:
        r107 = null;
    L54:
        if (this.A == (-1)) goto L56;
    L58:
        boolean r117 = false;
    L59:
        this.f53420r = r117;
        goto L61
    L56:
        if (r110.isPointInChildBounds(r111, r105, this.B) == true) goto L58;
        r117 = true;
        goto L59
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (ViewCompat.getFitsSystemWindows(r100) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L8;
        r101.setFitsSystemWindows(true);
    L8:
        if (this.f53425w != null) goto L13;
        this.f53407e = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        this.f53425w = new WeakReference(r101);
        if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(r101, 1);
    L13:
        if (this.f53419q != null) goto L15;
        this.f53419q = ViewDragHelper.create(r100, this.F);
    L15:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.f53423u = r100.getWidth();
        int r104 = r100.getHeight();
        this.f53424v = r104;
        this.f53412j = (int) Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, r104 - r101.getHeight());
        this.f53413k = (int) (this.f53424v * (1 - this.f53414l));
        calculateCollapsedOffset();
        int r105 = this.f53418p;
        if (r105 != 3) goto L19;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L33:
        this.f53426x = new WeakReference(findScrollingChild(r101));
        return true;
    L19:
        if (r105 != 6) goto L22;
        ViewCompat.offsetTopAndBottom(r101, this.f53413k);
        goto L33
    L22:
        if (this.f53416n == false) goto L27;
        if (r105 != 5) goto L27;
        ViewCompat.offsetTopAndBottom(r101, this.f53424v);
    L27:
        if (r105 != 4) goto L29;
        ViewCompat.offsetTopAndBottom(r101, this.f53415m);
        goto L33
    L29:
        if (r105 != 1) goto L31;
    L32:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L33
    L31:
        if (r105 != 2) goto L33;
        goto L32
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        c r103 = this.E;
        if (r103 == null) goto L6;
        r103.onTouch(r100, r102);
    L6:
        if (r101.isShown() == true) goto L9;
        return false;
    L9:
        int r104 = r102.getActionMasked();
        if (this.f53418p != 1) goto L13;
        if (r104 != 0) goto L13;
        return true;
    L13:
        ViewDragHelper r105 = this.f53419q;
        if (r105 == null) goto L16;
        Intrinsics.checkNotNull(r105);
        r105.processTouchEvent(r102);
    L16:
        if (r104 != 0) goto L21;
        this.A = -1;
        VelocityTracker r106 = this.f53428z;
        if (r106 == null) goto L21;
        Intrinsics.checkNotNull(r106);
        r106.recycle();
        this.f53428z = null;
    L21:
        if (this.f53428z != null) goto L23;
        this.f53428z = VelocityTracker.obtain();
    L23:
        VelocityTracker r107 = this.f53428z;
        Intrinsics.checkNotNull(r107);
        r107.addMovement(r102);
        if (r104 != 2) goto L31;
        if (this.f53420r == true) goto L31;
        double r108 = Math.abs(this.B - r102.getY());
        ViewDragHelper r109 = this.f53419q;
        Intrinsics.checkNotNull(r109);
        if (r108 <= r109.getTouchSlop()) goto L31;
        ViewDragHelper r110 = this.f53419q;
        Intrinsics.checkNotNull(r110);
        r110.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L31:
        return !this.f53420r;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r105 = this.f53426x;
        if (r105 == null) goto L60;
        Intrinsics.checkNotNull(r105);
        if (r102 == r105.get()) goto L11;
        return;
    L11:
        if (this.f53422t == true) goto L14;
        return;
    L14:
        if (this.f53421s <= 0) goto L23;
        if (this.f53403a == false) goto L18;
        int r106 = this.f53412j;
    L58:
        startSettlingAnimation(r101, r104, r106, false);
        this.f53422t = false;
        return;
    L18:
        int r107 = r101.getTop();
        int r108 = this.f53413k;
        if (r107 <= r108) goto L21;
        r106 = r108;
    L56:
        r104 = 6;
        goto L58
    L21:
        r106 = this.f53411i;
        goto L58
    L23:
        if (this.f53416n == false) goto L32;
        VelocityTracker r109 = this.f53428z;
        if (r109 != null) goto L27;
        float r110 = 0.0f;
    L29:
        if (shouldHide(r101, r110) == false) goto L32;
        r106 = this.f53424v;
        r104 = 5;
        goto L58
    L27:
        Intrinsics.checkNotNull(r109);
        r109.computeCurrentVelocity(1000, this.f53404b);
        VelocityTracker r111 = this.f53428z;
        Intrinsics.checkNotNull(r111);
        r110 = r111.getYVelocity(this.A);
    L32:
        if (this.f53421s != 0) goto L50;
        int r112 = r101.getTop();
        if (this.f53403a == true) goto L36;
        int r113 = this.f53413k;
        if (r112 >= r113) goto L46;
        if (r112 >= Math.abs(r112 - this.f53415m)) goto L44;
        r106 = this.f53411i;
        goto L58
    L44:
        r106 = this.f53413k;
        goto L56
    L46:
        if (Math.abs(r112 - r113) >= Math.abs(r112 - this.f53415m)) goto L48;
        r106 = this.f53413k;
        goto L56
    L48:
        r106 = this.f53415m;
    L52:
        r104 = 4;
        goto L58
    L36:
        if (Math.abs(r112 - this.f53412j) >= Math.abs(r112 - this.f53415m)) goto L38;
        r106 = this.f53412j;
        goto L58
    L38:
        r106 = this.f53415m;
        goto L52
    L50:
        if (this.f53403a == false) goto L53;
        r106 = this.f53415m;
        goto L52
    L53:
        int r114 = r101.getTop();
        if (Math.abs(r114 - this.f53413k) >= Math.abs(r114 - this.f53415m)) goto L57;
        r106 = this.f53413k;
        goto L56
    L57:
        r106 = this.f53415m;
        goto L52
    }

    public final void startSettlingAnimation(View r100, int r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (r103 == false) goto L5;
        ViewDragHelper r104 = this.f53419q;
        Intrinsics.checkNotNull(r104);
        boolean r105 = r104.settleCapturedViewAt(r100.getLeft(), r102);
    L6:
        if (r105 == false) goto L29;
        setStateInternal(2);
        if (r101 == 2) goto L18;
        if (r101 != 3) goto L13;
        boolean r106 = true;
    L15:
        if (this.f53408f == r106) goto L18;
        this.f53408f = r106;
        goto L18
    L13:
        r106 = false;
    L18:
        if (this.f53409g != null) goto L20;
        this.f53409g = new d(this, r100, r101);
    L20:
        BottomSheetBehavior<V>.d r107 = this.f53409g;
        if (r107 != null) goto L23;
    L27:
        if (r107 == null) goto L33;
        r107.f53436c = r101;
        return;
    L33:
        return;
    L23:
        if (r107.f53435b == true) goto L27;
        r107.f53436c = r101;
        Intrinsics.checkNotNull(r107);
        ViewCompat.postOnAnimation(r100, r107);
        BottomSheetBehavior<V>.d r108 = this.f53409g;
        if (r108 == null) goto L31;
        r108.f53435b = true;
        return;
    L31:
        return;
    L29:
        setStateInternal(r101);
        return;
    L5:
        ViewDragHelper r109 = this.f53419q;
        Intrinsics.checkNotNull(r109);
        r105 = r109.smoothSlideViewTo(r100, r100.getLeft(), r102);
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        WeakReference<View> r105 = this.f53426x;
        if (r105 == null) goto L12;
        Intrinsics.checkNotNull(r105);
        if (r102 == r105.get()) goto L7;
        return false;
    L7:
        if (this.f53418p == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == true) goto L10;
        return false;
    L12:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        this.f53421s = 0;
        this.f53422t = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        if (r106 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r107 = this.f53426x;
        if (r107 == null) goto L8;
        Intrinsics.checkNotNull(r107);
        View r108 = r107.get();
    L9:
        if (r102 == r108) goto L11;
        return;
    L11:
        int r109 = r101.getTop();
        int r110 = r109 - r104;
        if (r104 > 0) goto L14;
        if (r104 < 0) goto L22;
    L33:
        dispatchOnSlide(r101.getTop());
        this.f53421s = r104;
        this.f53422t = true;
        return;
    L22:
        if (r102.canScrollVertically(-1) == true) goto L33;
        int r111 = this.f53415m;
        if (r110 <= r111) goto L30;
        if (this.f53416n == true) goto L30;
        int r112 = r109 - r111;
        r105[1] = r112;
        ViewCompat.offsetTopAndBottom(r101, -r112);
        setStateInternal(4);
    L30:
        if (this.f53417o == true) goto L32;
        return;
    L32:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L14:
        if (r110 >= getExpandedOffset()) goto L17;
        int r113 = r109 - getExpandedOffset();
        r105[1] = r113;
        ViewCompat.offsetTopAndBottom(r101, -r113);
        setStateInternal(3);
        goto L33
    L17:
        if (this.f53417o == true) goto L19;
        return;
    L19:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L33
    L8:
        r108 = null;
        goto L9
    }
}
