package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.obric.capabilitykit.common.UiType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f5157u = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f5158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f5159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.viewpager2.widget.b f5160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f5163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f5164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Parcelable f5166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f5167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.recyclerview.widget.k f5168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.viewpager2.widget.f f5169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public androidx.viewpager2.widget.b f5170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.viewpager2.widget.d f5171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.viewpager2.widget.e f5172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecyclerView.ItemAnimator f5173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5176s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f5177t;

    public class LinearLayoutManagerImpl extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5178a;

        public LinearLayoutManagerImpl(ViewPager2 r10, Context r11) {
            this.f5178a = r10;
            super(r11);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.State r10, int[] r11) {
            int r12 = this.f5178a.getOffscreenPageLimit();
            if (r12 != (-1)) goto L6;
            super.calculateExtraLayoutSpace(r10, r11);
            return;
        L6:
            int r13 = this.f5178a.getPageSize() * r12;
            r11[0] = r13;
            r11[1] = r13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r10, RecyclerView.State r11, AccessibilityNodeInfoCompat r12) {
            super.onInitializeAccessibilityNodeInfo(r10, r11, r12);
            this.f5178a.f5177t.j(r12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, Bundle r13) {
            if (this.f5178a.f5177t.b(r12) == false) goto L7;
            return this.f5178a.f5177t.k(r12);
        L7:
            return super.performAccessibilityAction(r10, r11, r12, r13);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView r10, View r11, Rect r12, boolean r13, boolean r14) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OffscreenPageLimit {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@NonNull View r10, float r11);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        public static class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return b(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        @RequiresApi(24)
        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            readValues(r10, r11);
        }

        private void readValues(Parcel r10, ClassLoader r11) {
            this.mRecyclerViewId = r10.readInt();
            this.mCurrentItem = r10.readInt();
            this.mAdapterState = r10.readParcelable(r11);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.mRecyclerViewId);
            r10.writeInt(this.mCurrentItem);
            r10.writeParcelable(this.mAdapterState, r11);
        }

        public SavedState(Parcel r10) {
            super(r10);
            readValues(r10, null);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollState {
    }

    public class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5179a;

        public a(ViewPager2 r10) {
            this.f5179a = r10;
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            ViewPager2 r10 = this.f5179a;
            r10.f5162e = true;
            r10.f5169l.j();
        }
    }

    public class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5180a;

        public b(ViewPager2 r10) {
            this.f5180a = r10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageScrollStateChanged(int r10) {
            if (r10 != 0) goto L5;
            this.f5180a.o();
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageSelected(int r10) {
            ViewPager2 r11 = this.f5180a;
            if (r11.f5161d == r10) goto L6;
            r11.f5161d = r10;
            r11.f5177t.p();
            return;
        }
    }

    public class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5181a;

        public c(ViewPager2 r10) {
            this.f5181a = r10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageSelected(int r10) {
            this.f5181a.clearFocus();
            if (this.f5181a.hasFocus() == false) goto L6;
            this.f5181a.f5167j.requestFocus(2);
            return;
        }
    }

    public class d implements RecyclerView.OnChildAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5182a;

        public d(ViewPager2 r10) {
            this.f5182a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View r10) {
            RecyclerView.LayoutParams r11 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) r11).width != (-1)) goto L8;
            if (((ViewGroup.MarginLayoutParams) r11).height != (-1)) goto L8;
            return;
        L8:
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View r10) {
        }
    }

    public abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5183a;

        public e(ViewPager2 r10) {
            this.f5183a = r10;
        }

        public boolean a() {
            return false;
        }

        public boolean b(int r10) {
            return false;
        }

        public boolean c(int r10, Bundle r11) {
            return false;
        }

        public boolean d() {
            return false;
        }

        public void e(RecyclerView.Adapter r10) {
        }

        public void f(RecyclerView.Adapter r10) {
        }

        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        public void h(androidx.viewpager2.widget.b r10, RecyclerView r11) {
        }

        public void i(AccessibilityNodeInfo r10) {
        }

        public void j(AccessibilityNodeInfoCompat r10) {
        }

        public boolean k(int r10) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean l(int r10, Bundle r11) {
            throw new IllegalStateException("Not implemented.");
        }

        public void m() {
        }

        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        public void o() {
        }

        public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        }

        public void p() {
        }

        public void q() {
        }

        public void r() {
        }

        public /* synthetic */ e(ViewPager2 r10, a r11) {
            this(r10);
        }
    }

    public class f extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5184b;

        public f(ViewPager2 r10) {
            this.f5184b = r10;
            super(r10, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int r10) {
            if (r10 == 8192) goto L7;
            if (r10 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.f5184b.e() == true) goto L9;
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(AccessibilityNodeInfoCompat r10) {
            if (this.f5184b.e() == true) goto L6;
            r10.O(AccessibilityNodeInfoCompat.a.f2751r);
            r10.O(AccessibilityNodeInfoCompat.a.f2750q);
            r10.r0(false);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int r10) {
            if (b(r10) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }
    }

    public static abstract class g extends RecyclerView.AdapterDataObserver {
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r10, int r11, int r12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r10, int r11) {
            onChanged();
        }

        public /* synthetic */ g(a r10) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r10, int r11, Object r12) {
            onChanged();
        }
    }

    public static abstract class h {
        public h() {
        }

        public void onPageScrollStateChanged(int r10) {
        }

        public void onPageScrolled(int r10, float r11, int r12) {
        }

        public abstract void onPageSelected(int r10);
    }

    public class i extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AccessibilityViewCommand f5185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AccessibilityViewCommand f5186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView.AdapterDataObserver f5187d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5188e;

        public class a implements AccessibilityViewCommand {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f5189a;

            public a(i r10) {
                this.f5189a = r10;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View r10, AccessibilityViewCommand.a r11) {
                this.f5189a.u(((ViewPager2) r10).getCurrentItem() + 1);
                return true;
            }
        }

        public class b implements AccessibilityViewCommand {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f5190a;

            public b(i r10) {
                this.f5190a = r10;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View r10, AccessibilityViewCommand.a r11) {
                this.f5190a.u(((ViewPager2) r10).getCurrentItem() - 1);
                return true;
            }
        }

        public class c extends g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f5191a;

            public c(i r10) {
                this.f5191a = r10;
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                this.f5191a.v();
            }
        }

        public i(ViewPager2 r10) {
            this.f5188e = r10;
            super(r10, null);
            this.f5185b = new a(this);
            this.f5186c = new b(this);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int r10, Bundle r11) {
            if (r10 != 8192) goto L5;
        L8:
            return true;
        L5:
            if (r10 == 4096) goto L8;
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter r10) {
            v();
            if (r10 == null) goto L6;
            r10.registerAdapterDataObserver(this.f5187d);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter r10) {
            if (r10 == null) goto L5;
            r10.unregisterAdapterDataObserver(this.f5187d);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b r10, RecyclerView r11) {
            ViewCompat.A0(r11, 2);
            this.f5187d = new c(this);
            if (ViewCompat.y(this.f5188e) != 0) goto L6;
            ViewCompat.A0(this.f5188e, 1);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo r10) {
            s(r10);
            t(r10);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int r10, Bundle r11) {
            if (c(r10, r11) == false) goto L11;
            if (r10 != 8192) goto L7;
            int r12 = this.f5188e.getCurrentItem() - 1;
        L8:
            u(r12);
            return true;
        L7:
            r12 = this.f5188e.getCurrentItem() + 1;
            goto L8
        L11:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            v();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o() {
            v();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            r10.setSource(this.f5188e);
            r10.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            v();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            v();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            v();
        }

        public final void s(AccessibilityNodeInfo r10) {
            if (this.f5188e.getAdapter() != null) goto L5;
            int r11 = 0;
            int r12 = 0;
        L9:
            AccessibilityNodeInfoCompat.B0(r10).X(AccessibilityNodeInfoCompat.b.b(r11, r12, false, 0));
            return;
        L5:
            if (this.f5188e.getOrientation() != 1) goto L7;
            r11 = this.f5188e.getAdapter().getItemCount();
            r12 = 0;
            goto L9
        L7:
            r12 = this.f5188e.getAdapter().getItemCount();
            r11 = 0;
            goto L9
        }

        public final void t(AccessibilityNodeInfo r10) {
            RecyclerView.Adapter r11 = this.f5188e.getAdapter();
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r11.getItemCount();
            if (r12 != 0) goto L8;
            return;
        L8:
            if (this.f5188e.e() == true) goto L11;
            return;
        L11:
            if (this.f5188e.f5161d <= 0) goto L14;
            r10.addAction(8192);
        L14:
            if (this.f5188e.f5161d >= (r12 - 1)) goto L16;
            r10.addAction(4096);
        L16:
            r10.setScrollable(true);
        }

        public void u(int r10) {
            if (this.f5188e.e() == false) goto L6;
            this.f5188e.k(r10, true);
            return;
        }

        public void v() {
            ViewPager2 r10 = this.f5188e;
            int r11 = R.id.accessibilityActionPageLeft;
            ViewCompat.j0(r10, R.id.accessibilityActionPageLeft);
            ViewCompat.j0(r10, R.id.accessibilityActionPageRight);
            ViewCompat.j0(r10, R.id.accessibilityActionPageUp);
            ViewCompat.j0(r10, R.id.accessibilityActionPageDown);
            if (this.f5188e.getAdapter() != null) goto L5;
            return;
        L5:
            int r12 = this.f5188e.getAdapter().getItemCount();
            if (r12 != 0) goto L9;
            return;
        L9:
            if (this.f5188e.e() == true) goto L12;
            return;
        L12:
            if (this.f5188e.getOrientation() != 0) goto L26;
            boolean r13 = this.f5188e.d();
            if (r13 == false) goto L16;
            int r14 = 16908360;
        L17:
            if (r13 == false) goto L20;
            r11 = 16908361;
        L20:
            if (this.f5188e.f5161d >= (r12 - 1)) goto L23;
            ViewCompat.l0(r10, new AccessibilityNodeInfoCompat.a(r14, null), null, this.f5185b);
        L23:
            if (this.f5188e.f5161d <= 0) goto L32;
            ViewCompat.l0(r10, new AccessibilityNodeInfoCompat.a(r11, null), null, this.f5186c);
            return;
        L32:
            return;
        L16:
            r14 = 16908361;
            goto L17
        L26:
            if (this.f5188e.f5161d >= (r12 - 1)) goto L29;
            ViewCompat.l0(r10, new AccessibilityNodeInfoCompat.a(R.id.accessibilityActionPageDown, null), null, this.f5185b);
        L29:
            if (this.f5188e.f5161d <= 0) goto L34;
            ViewCompat.l0(r10, new AccessibilityNodeInfoCompat.a(R.id.accessibilityActionPageUp, null), null, this.f5186c);
            return;
        }
    }

    public class j extends androidx.recyclerview.widget.k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5192f;

        public j(ViewPager2 r10) {
            this.f5192f = r10;
        }

        @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.n
        public View g(RecyclerView.LayoutManager r10) {
            if (this.f5192f.c() == false) goto L6;
            return null;
        L6:
            return super.g(r10);
        }
    }

    public class k extends RecyclerView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f5193a;

        public k(ViewPager2 r10, Context r11) {
            this.f5193a = r10;
            super(r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (this.f5193a.f5177t.d() == false) goto L7;
            return this.f5193a.f5177t.n();
        L7:
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r10);
            r10.setFromIndex(this.f5193a.f5161d);
            r10.setToIndex(this.f5193a.f5161d);
            this.f5193a.f5177t.onRvInitializeAccessibilityEvent(r10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r10) {
            if (this.f5193a.e() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r10) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent r10) {
            if (this.f5193a.e() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r10) == false) goto L7;
            return true;
        }
    }

    public static class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView f5195b;

        public l(int r10, RecyclerView r11) {
            this.f5194a = r10;
            this.f5195b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5195b.smoothScrollToPosition(this.f5194a);
        }
    }

    static {
    }

    public ViewPager2(@NonNull Context r10) {
        super(r10);
        this.f5158a = new Rect();
        this.f5159b = new Rect();
        this.f5160c = new androidx.viewpager2.widget.b(3);
        this.f5162e = false;
        this.f5163f = new a(this);
        this.f5165h = -1;
        this.f5173p = null;
        this.f5174q = false;
        this.f5175r = true;
        this.f5176s = -1;
        b(r10, null);
    }

    public final RecyclerView.OnChildAttachStateChangeListener a() {
        return new d(this);
    }

    public final void b(Context r10, AttributeSet r11) {
        if (f5157u == false) goto L5;
        e r12 = new i(this);
    L6:
        this.f5177t = r12;
        k r13 = new k(this, r10);
        this.f5167j = r13;
        r13.setId(ViewCompat.k());
        this.f5167j.setDescendantFocusability(UiType.FLAG_PHONE_CARD);
        LinearLayoutManagerImpl r14 = new LinearLayoutManagerImpl(this, r10);
        this.f5164g = r14;
        this.f5167j.setLayoutManager(r14);
        this.f5167j.setScrollingTouchSlop(1);
        l(r10, r11);
        this.f5167j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f5167j.addOnChildAttachStateChangeListener(a());
        androidx.viewpager2.widget.f r15 = new androidx.viewpager2.widget.f(this);
        this.f5169l = r15;
        this.f5171n = new androidx.viewpager2.widget.d(this, r15, this.f5167j);
        j r16 = new j(this);
        this.f5168k = r16;
        r16.b(this.f5167j);
        this.f5167j.addOnScrollListener(this.f5169l);
        androidx.viewpager2.widget.b r17 = new androidx.viewpager2.widget.b(3);
        this.f5170m = r17;
        this.f5169l.m(r17);
        b r18 = new b(this);
        c r19 = new c(this);
        this.f5170m.a(r18);
        this.f5170m.a(r19);
        this.f5177t.h(this.f5170m, this.f5167j);
        this.f5170m.a(this.f5160c);
        androidx.viewpager2.widget.e r20 = new androidx.viewpager2.widget.e(this.f5164g);
        this.f5172o = r20;
        this.f5170m.a(r20);
        RecyclerView r21 = this.f5167j;
        attachViewToParent(r21, 0, r21.getLayoutParams());
        return;
    L5:
        r12 = new f(this);
        goto L6
    }

    public boolean c() {
        return this.f5171n.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r10) {
        return this.f5167j.canScrollHorizontally(r10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r10) {
        return this.f5167j.canScrollVertically(r10);
    }

    public boolean d() {
        if (this.f5164g.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray r10) {
        Parcelable r11 = (Parcelable) r10.get(getId());
        if ((r11 instanceof SavedState) == false) goto L5;
        int r12 = ((SavedState) r11).mRecyclerViewId;
        r10.put(this.f5167j.getId(), r10.get(r12));
        r10.remove(r12);
    L5:
        super.dispatchRestoreInstanceState(r10);
        i();
    }

    public boolean e() {
        return this.f5175r;
    }

    public final void f(RecyclerView.Adapter r10) {
        if (r10 == null) goto L5;
        r10.registerAdapterDataObserver(this.f5163f);
        return;
    }

    public void g(h r10) {
        this.f5160c.a(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.f5177t.a() == false) goto L7;
        return this.f5177t.g();
    L7:
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f5167j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f5161d;
    }

    public int getItemDecorationCount() {
        return this.f5167j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f5176s;
    }

    public int getOrientation() {
        return this.f5164g.getOrientation();
    }

    public int getPageSize() {
        RecyclerView r10 = this.f5167j;
        if (getOrientation() != 0) goto L6;
        int r11 = r10.getWidth() - r10.getPaddingLeft();
        int r12 = r10.getPaddingRight();
    L7:
        return r11 - r12;
    L6:
        r11 = r10.getHeight() - r10.getPaddingTop();
        r12 = r10.getPaddingBottom();
        goto L7
    }

    public int getScrollState() {
        return this.f5169l.f();
    }

    public void h() {
        if (this.f5172o.a() != null) goto L5;
        return;
    L5:
        double r10 = this.f5169l.e();
        int r11 = (int) r10;
        float r12 = (float) (r10 - ((double) r11));
        this.f5172o.onPageScrolled(r11, r12, Math.round(getPageSize() * r12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        if (this.f5165h != (-1)) goto L5;
        return;
    L5:
        RecyclerView.Adapter r10 = getAdapter();
        if (r10 != 0) goto L8;
        return;
    L8:
        Parcelable r11 = this.f5166i;
        if (r11 != null) goto L11;
    L14:
        int r12 = Math.max(0, Math.min(this.f5165h, r10.getItemCount() - 1));
        this.f5161d = r12;
        this.f5165h = -1;
        this.f5167j.scrollToPosition(r12);
        this.f5177t.m();
        return;
    L11:
        if ((r10 instanceof StatefulAdapter) == false) goto L13;
        ((StatefulAdapter) r10).restoreState(r11);
    L13:
        this.f5166i = null;
        goto L14
    }

    public void j(int r10, boolean r11) {
        if (c() == true) goto L7;
        k(r10, r11);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void k(int r10, boolean r11) {
        RecyclerView.Adapter r12 = getAdapter();
        if (r12 != null) goto L9;
        if (this.f5165h == (-1)) goto L36;
        this.f5165h = Math.max(r10, 0);
        return;
    L36:
        return;
    L9:
        if (r12.getItemCount() > 0) goto L11;
        return;
    L11:
        int r13 = Math.min(Math.max(r10, 0), r12.getItemCount() - 1);
        if (r13 == this.f5161d) goto L14;
    L16:
        int r14 = this.f5161d;
        if (r13 != r14) goto L20;
        if (r11 == false) goto L20;
        return;
    L20:
        double r15 = r14;
        this.f5161d = r13;
        this.f5177t.p();
        if (this.f5169l.h() == true) goto L23;
        r15 = this.f5169l.e();
    L23:
        this.f5169l.k(r13, r11);
        if (r11 == true) goto L27;
        this.f5167j.scrollToPosition(r13);
        return;
    L27:
        double r16 = r13;
        if (Math.abs(r16 - r15) <= 3.0d) goto L34;
        RecyclerView r17 = this.f5167j;
        if (r16 <= r15) goto L32;
        int r18 = r13 - 3;
    L33:
        r17.scrollToPosition(r18);
        RecyclerView r19 = this.f5167j;
        r19.post(new l(r13, r19));
        return;
    L32:
        r18 = r13 + 3;
        goto L33
    L34:
        this.f5167j.smoothScrollToPosition(r13);
        return;
    L14:
        if (this.f5169l.h() == false) goto L16;
    }

    public final void l(Context r10, AttributeSet r11) {
        int[] r12 = R$styleable.ViewPager2;
        TypedArray r13 = r10.obtainStyledAttributes(r11, r12);
        saveAttributeDataForStyleable(r10, r12, r11, r13, 0, 0);
        setOrientation(r13.getInt(R$styleable.ViewPager2_android_orientation, 0));     // Catch: Throwable -> L6
        r13.recycle();
        return;
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    }

    public final void m(RecyclerView.Adapter r10) {
        if (r10 == null) goto L5;
        r10.unregisterAdapterDataObserver(this.f5163f);
        return;
    }

    public void n(h r10) {
        this.f5160c.b(r10);
    }

    public void o() {
        androidx.recyclerview.widget.k r10 = this.f5168k;
        if (r10 == null) goto L15;
        View r11 = r10.g(this.f5164g);
        if (r11 != null) goto L7;
        return;
    L7:
        int r12 = this.f5164g.getPosition(r11);
        if (r12 != this.f5161d) goto L10;
    L12:
        this.f5162e = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.f5170m.onPageSelected(r12);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        this.f5177t.i(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = this.f5167j.getMeasuredWidth();
        int r16 = this.f5167j.getMeasuredHeight();
        Rect r17 = this.f5158a;
        r17.left = getPaddingLeft();
        Rect r18 = this.f5158a;
        r18.right = (r13 - r11) - getPaddingRight();
        Rect r19 = this.f5158a;
        r19.top = getPaddingTop();
        Rect r20 = this.f5158a;
        r20.bottom = (r14 - r12) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, r15, r16, this.f5158a, this.f5159b);
        RecyclerView r21 = this.f5167j;
        Rect r22 = this.f5159b;
        r21.layout(r22.left, r22.top, r22.right, r22.bottom);
        if (this.f5162e == false) goto L6;
        o();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        measureChild(this.f5167j, r10, r11);
        int r12 = this.f5167j.getMeasuredWidth();
        int r13 = this.f5167j.getMeasuredHeight();
        int r14 = this.f5167j.getMeasuredState();
        int r15 = r12 + (getPaddingLeft() + getPaddingRight());
        int r16 = r13 + (getPaddingTop() + getPaddingBottom());
        int r17 = Math.max(r15, getSuggestedMinimumWidth());
        int r18 = Math.max(r16, getSuggestedMinimumHeight());
        setMeasuredDimension(ViewGroup.resolveSizeAndState(r17, r10, r14), ViewGroup.resolveSizeAndState(r18, r11, r14 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.f5165h = r11.mCurrentItem;
        this.f5166i = r11.mAdapterState;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.mRecyclerViewId = this.f5167j.getId();
        int r11 = this.f5165h;
        if (r11 != (-1)) goto L5;
        r11 = this.f5161d;
    L5:
        r10.mCurrentItem = r11;
        Parcelable r12 = this.f5166i;
        if (r12 == null) goto L8;
        r10.mAdapterState = r12;
    L11:
        return r10;
    L8:
        Object r13 = this.f5167j.getAdapter();
        if ((r13 instanceof StatefulAdapter) == false) goto L11;
        r10.mAdapterState = ((StatefulAdapter) r13).saveState();
        goto L11
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int r10, Bundle r11) {
        if (this.f5177t.c(r10, r11) == false) goto L7;
        return this.f5177t.l(r10, r11);
    L7:
        return super.performAccessibilityAction(r10, r11);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter r10) {
        RecyclerView.Adapter r11 = this.f5167j.getAdapter();
        this.f5177t.f(r11);
        m(r11);
        this.f5167j.setAdapter(r10);
        this.f5161d = 0;
        i();
        this.f5177t.e(r10);
        f(r10);
    }

    public void setCurrentItem(int r10) {
        j(r10, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int r10) {
        super.setLayoutDirection(r10);
        this.f5177t.o();
    }

    public void setOffscreenPageLimit(int r10) {
        if (r10 < 1) goto L5;
    L9:
        this.f5176s = r10;
        this.f5167j.requestLayout();
        return;
    L5:
        if (r10 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int r10) {
        this.f5164g.setOrientation(r10);
        this.f5177t.q();
    }

    public void setPageTransformer(@Nullable PageTransformer r10) {
        if (r10 == null) goto L9;
        if (this.f5174q == true) goto L7;
        this.f5173p = this.f5167j.getItemAnimator();
        this.f5174q = true;
    L7:
        this.f5167j.setItemAnimator(null);
    L12:
        if (r10 != this.f5172o.a()) goto L14;
        return;
    L14:
        this.f5172o.b(r10);
        h();
        return;
    L9:
        if (this.f5174q == false) goto L12;
        this.f5167j.setItemAnimator(this.f5173p);
        this.f5173p = null;
        this.f5174q = false;
        goto L12
    }

    public void setUserInputEnabled(boolean r10) {
        this.f5175r = r10;
        this.f5177t.r();
    }

    public ViewPager2(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f5158a = new Rect();
        this.f5159b = new Rect();
        this.f5160c = new androidx.viewpager2.widget.b(3);
        this.f5162e = false;
        this.f5163f = new a(this);
        this.f5165h = -1;
        this.f5173p = null;
        this.f5174q = false;
        this.f5175r = true;
        this.f5176s = -1;
        b(r10, r11);
    }

    public ViewPager2(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f5158a = new Rect();
        this.f5159b = new Rect();
        this.f5160c = new androidx.viewpager2.widget.b(3);
        this.f5162e = false;
        this.f5163f = new a(this);
        this.f5165h = -1;
        this.f5173p = null;
        this.f5174q = false;
        this.f5175r = true;
        this.f5176s = -1;
        b(r10, r11);
    }
}
