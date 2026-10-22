package androidx.viewpager2.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
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
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    a mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.b mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private androidx.viewpager2.widget.b mExternalPageChangeCallbacks;
    private androidx.viewpager2.widget.d mFakeDragger;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private androidx.viewpager2.widget.b mPageChangeEventDispatcher;
    private androidx.viewpager2.widget.f mPageTransformerAdapter;
    private v mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerView mRecyclerView;
    private RecyclerView.e mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    androidx.viewpager2.widget.g mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    private class RecyclerViewImpl extends RecyclerView {
        final /* synthetic */ ViewPager2 this$0;

        RecyclerViewImpl(ViewPager2 r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (this.this$0.mAccessibilityProvider.h() == false) goto L7;
            return this.this$0.mAccessibilityProvider.i();
        L7:
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r2);
            r2.setFromIndex(this.this$0.mCurrentItem);
            r2.setToIndex(this.this$0.mCurrentItem);
            this.this$0.mAccessibilityProvider.a(r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public boolean onTouchEvent(MotionEvent r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onTouchEvent(r2) == false) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r2) {
            if (this.this$0.isUserInputEnabled() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onInterceptTouchEvent(r2) == false) goto L7;
            return true;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            readValues(r1, r2);
        }

        SavedState(Parcel r2) {
            super(r2);
            readValues(r2, null);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        private void readValues(Parcel r2, ClassLoader r3) {
            this.mRecyclerViewId = r2.readInt();
            this.mCurrentItem = r2.readInt();
            this.mAdapterState = r2.readParcelable(r3);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.mRecyclerViewId);
            r2.writeInt(this.mCurrentItem);
            r2.writeParcelable(this.mAdapterState, r3);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f2940a;

        void a(AccessibilityEvent r1) {
        }

        void a(AccessibilityNodeInfo r1) {
        }

        void a(androidx.core.view.accessibility.b r1) {
        }

        void a(RecyclerView.a<?> r1) {
        }

        void a(androidx.viewpager2.widget.b r1, RecyclerView r2) {
        }

        boolean a() {
            return false;
        }

        boolean a(int r1) {
            return false;
        }

        boolean a(int r1, Bundle r2) {
            return false;
        }

        void b(RecyclerView.a<?> r1) {
        }

        void c() {
        }

        void d() {
        }

        void e() {
        }

        void f() {
        }

        void g() {
        }

        boolean h() {
            return false;
        }

        private a(ViewPager2 r1) {
            this.f2940a = r1;
        }

        /* synthetic */ a(ViewPager2 r1, AnonymousClass1 r2) {
            this(r1);
        }

        String b() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean b(int r1, Bundle r2) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean b(int r1) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence i() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f2941b;

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean h() {
            return true;
        }

        b(ViewPager2 r2) {
            this.f2941b = r2;
            super(r2, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean a(int r2) {
            if (r2 == 8192) goto L7;
            if (r2 == 4096) goto L7;
        L9:
            return false;
        L7:
            if (this.f2941b.isUserInputEnabled() == true) goto L9;
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean b(int r1) {
            if (a(r1) == false) goto L7;
            return false;
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(androidx.core.view.accessibility.b r1) {
            if (this.f2941b.isUserInputEnabled() == true) goto L6;
            r1.b(androidx.core.view.accessibility.b.a.n);
            r1.b(androidx.core.view.accessibility.b.a.m);
            r1.k(false);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public CharSequence i() {
            if (h() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }
    }

    private static abstract class c extends RecyclerView.b {
        @Override // androidx.recyclerview.widget.RecyclerView.b
        public abstract void a();

        private c() {
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, Object r3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void b(int r1, int r2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void c(int r1, int r2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, int r3) {
            a();
        }
    }

    private class d extends LinearLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f2942a;

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public boolean a(RecyclerView r1, View r2, Rect r3, boolean r4, boolean r5) {
            return false;
        }

        d(ViewPager2 r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f2942a = r3;
            super(r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public boolean a(RecyclerView.n r2, RecyclerView.r r3, int r4, Bundle r5) {
            if (this.f2942a.mAccessibilityProvider.a(r4) == false) goto L7;
            return this.f2942a.mAccessibilityProvider.b(r4);
        L7:
            return super.a(r2, r3, r4, r5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void a(RecyclerView.n r1, RecyclerView.r r2, androidx.core.view.accessibility.b r3) {
            super.a(r1, r2, r3);
            this.f2942a.mAccessibilityProvider.a(r3);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void a(RecyclerView.r r3, int[] r4) {
            int r0 = this.f2942a.getOffscreenPageLimit();
            if (r0 != (-1)) goto L6;
            super.a(r3, r4);
            return;
        L6:
            int r2 = this.f2942a.getPageSize() * r0;
            r4[0] = r2;
            r4[1] = r2;
        }
    }

    public static abstract class e {
        public void a(int r1) {
        }

        public void a(int r1, float r2, int r3) {
        }

        public void b(int r1) {
        }

        public e() {
        }
    }

    class f extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f2943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.core.view.accessibility.d f2944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final androidx.core.view.accessibility.d f2945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private RecyclerView.b f2946e;

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean a(int r1, Bundle r2) {
            if (r1 != 8192) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 4096) goto L8;
            return false;
        }

        f(ViewPager2 r2) {
            this.f2943b = r2;
            super(r2, null);
            this.f2944c = new AnonymousClass1(this);
            this.f2945d = new AnonymousClass2(this);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(androidx.viewpager2.widget.b r1, RecyclerView r2) {
            ViewCompat.c(r2, 2);
            this.f2946e = new AnonymousClass3(this);
            if (ViewCompat.g(this.f2943b) != 0) goto L6;
            ViewCompat.c(this.f2943b, 1);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public String b() {
            if (a() == false) goto L7;
            return "androidx.viewpager.widget.ViewPager";
        L7:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void c() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(RecyclerView.a<?> r1) {
            j();
            if (r1 == null) goto L6;
            r1.a(this.f2946e);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void b(RecyclerView.a<?> r1) {
            if (r1 == null) goto L5;
            r1.b(this.f2946e);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void d() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void e() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void f() {
            j();
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            this.f2943b.sendAccessibilityEvent(2048);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void g() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(AccessibilityNodeInfo r3) {
            b(r3);
            if (Build.VERSION.SDK_INT < 16) goto L6;
            c(r3);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean b(int r2, Bundle r3) {
            if (a(r2, r3) == false) goto L11;
            if (r2 != 8192) goto L7;
            int r4 = this.f2943b.getCurrentItem() - 1;
        L8:
            c(r4);
            return true;
        L7:
            r4 = this.f2943b.getCurrentItem() + 1;
            goto L8
        L11:
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(AccessibilityEvent r2) {
            r2.setSource(this.f2943b);
            r2.setClassName(b());
        }

        void c(int r2) {
            if (this.f2943b.isUserInputEnabled() == false) goto L6;
            this.f2943b.setCurrentItemInternal(r2, true);
            return;
        }

        void j() {
            ViewPager2 r0 = this.f2943b;
            int r1 = R.id.accessibilityActionPageLeft;
            ViewCompat.d(r0, R.id.accessibilityActionPageLeft);
            ViewCompat.d(r0, R.id.accessibilityActionPageRight);
            ViewCompat.d(r0, R.id.accessibilityActionPageUp);
            ViewCompat.d(r0, R.id.accessibilityActionPageDown);
            if (this.f2943b.getAdapter() != null) goto L5;
            return;
        L5:
            int r5 = this.f2943b.getAdapter().a();
            if (r5 != 0) goto L9;
            return;
        L9:
            if (this.f2943b.isUserInputEnabled() == true) goto L12;
            return;
        L12:
            if (this.f2943b.getOrientation() != 0) goto L26;
            boolean r3 = this.f2943b.isRtl();
            if (r3 == false) goto L16;
            int r4 = 16908360;
        L17:
            if (r3 == false) goto L20;
            r1 = 16908361;
        L20:
            if (this.f2943b.mCurrentItem >= (r5 - 1)) goto L23;
            ViewCompat.a(r0, new androidx.core.view.accessibility.b.a(r4, null), null, this.f2944c);
        L23:
            if (this.f2943b.mCurrentItem <= 0) goto L32;
            ViewCompat.a(r0, new androidx.core.view.accessibility.b.a(r1, null), null, this.f2945d);
            return;
        L32:
            return;
        L16:
            r4 = 16908361;
            goto L17
        L26:
            if (this.f2943b.mCurrentItem >= (r5 - 1)) goto L29;
            ViewCompat.a(r0, new androidx.core.view.accessibility.b.a(R.id.accessibilityActionPageDown, null), null, this.f2944c);
        L29:
            if (this.f2943b.mCurrentItem <= 0) goto L34;
            ViewCompat.a(r0, new androidx.core.view.accessibility.b.a(R.id.accessibilityActionPageUp, null), null, this.f2945d);
            return;
        }

        private void b(AccessibilityNodeInfo r4) {
            if (this.f2943b.getAdapter() != null) goto L5;
            int r3 = 0;
            int r0 = 0;
        L9:
            androidx.core.view.accessibility.b.a(r4).b(androidx.core.view.accessibility.b.f.a(r3, r0, false, 0));
            return;
        L5:
            if (this.f2943b.getOrientation() != 1) goto L7;
            r3 = this.f2943b.getAdapter().a();
            r0 = 0;
            goto L9
        L7:
            r0 = this.f2943b.getAdapter().a();
            r3 = 0;
            goto L9
        }

        private void c(AccessibilityNodeInfo r3) {
            RecyclerView.a r0 = this.f2943b.getAdapter();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.a();
            if (r1 != 0) goto L8;
            return;
        L8:
            if (this.f2943b.isUserInputEnabled() == true) goto L11;
            return;
        L11:
            if (this.f2943b.mCurrentItem <= 0) goto L14;
            r3.addAction(8192);
        L14:
            if (this.f2943b.mCurrentItem >= (r1 - 1)) goto L16;
            r3.addAction(4096);
        L16:
            r3.setScrollable(true);
        }
    }

    public interface g {
        void a(View r1, float r2);
    }

    private class h extends v {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f2950b;

        h(ViewPager2 r1) {
            this.f2950b = r1;
        }

        @Override // androidx.recyclerview.widget.v, androidx.recyclerview.widget.z
        public View a(RecyclerView.h r2) {
            if (this.f2950b.isFakeDragging() == false) goto L6;
            return null;
        L6:
            return super.a(r2);
        }
    }

    private static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f2952b;

        i(int r1, RecyclerView r2) {
            this.f2951a = r1;
            this.f2952b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2952b.smoothScrollToPosition(this.f2951a);
        }
    }

    static {
    }

    public ViewPager2(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.b(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r5, null);
    }

    public ViewPager2(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.b(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r6, r7);
    }

    public ViewPager2(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.b(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r6, r7);
    }

    public ViewPager2(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r5, r6);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.b(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new AnonymousClass1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(r7, r8);
    }

    private void initialize(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if (sFeatureEnhancedA11yEnabled == false) goto L5;
        a r0 = new f(this);
    L6:
        this.mAccessibilityProvider = r0;
        RecyclerViewImpl r1 = new RecyclerViewImpl(this, r5);
        this.mRecyclerView = r1;
        r1.setId(ViewCompat.a());
        this.mRecyclerView.setDescendantFocusability(UiType.FLAG_PHONE_CARD);
        d r2 = new d(this, r5);
        this.mLayoutManager = r2;
        this.mRecyclerView.setLayoutManager(r2);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(r5, r6);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        this.mScrollEventAdapter = new androidx.viewpager2.widget.g(this);
        this.mFakeDragger = new androidx.viewpager2.widget.d(this, this.mScrollEventAdapter, this.mRecyclerView);
        h r7 = new h(this);
        this.mPagerSnapHelper = r7;
        r7.a(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        androidx.viewpager2.widget.b r8 = new androidx.viewpager2.widget.b(3);
        this.mPageChangeEventDispatcher = r8;
        this.mScrollEventAdapter.a(r8);
        e r9 = new AnonymousClass2(this);
        e r10 = new AnonymousClass3(this);
        this.mPageChangeEventDispatcher.a(r9);
        this.mPageChangeEventDispatcher.a(r10);
        this.mAccessibilityProvider.a(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.a(this.mExternalPageChangeCallbacks);
        androidx.viewpager2.widget.f r11 = new androidx.viewpager2.widget.f(this.mLayoutManager);
        this.mPageTransformerAdapter = r11;
        this.mPageChangeEventDispatcher.a(r11);
        RecyclerView r12 = this.mRecyclerView;
        attachViewToParent(r12, 0, r12.getLayoutParams());
        return;
    L5:
        r0 = new b(this);
        goto L6
    }

    private RecyclerView.i enforceChildFillListener() {
        return new AnonymousClass4(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.a() == false) goto L7;
        return this.mAccessibilityProvider.b();
    L7:
        return super.getAccessibilityClassName();
    }

    private void setOrientation(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r12 = r3.obtainStyledAttributes(r5, com.obric.aiagent.plugin.R.styleable.ViewPager2);
        if (Build.VERSION.SDK_INT < 29) goto L11;
        saveAttributeDataForStyleable(r3, com.obric.aiagent.plugin.R.styleable.ViewPager2, r5, r12, 0, 0);
    L11:
        setOrientation(r12.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.ViewPager2_android_orientation, "styleable", "ViewPager2_android_orientation"), 0));     // Catch: Throwable -> L8
        r12.recycle();
        return;
    L8:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.mRecyclerViewId = this.mRecyclerView.getId();
        int r0 = this.mPendingCurrentItem;
        if (r0 != (-1)) goto L5;
        r0 = this.mCurrentItem;
    L5:
        r1.mCurrentItem = r0;
        Parcelable r2 = this.mPendingAdapterState;
        if (r2 == null) goto L8;
        r1.mAdapterState = r2;
    L11:
        return r1;
    L8:
        RecyclerView.a r3 = this.mRecyclerView.getAdapter();
        if (ZeusTransformUtils.instanceOf(r3, androidx.viewpager2.adapter.c.class) == false) goto L11;
        r1.mAdapterState = ((androidx.viewpager2.adapter.c) ZeusTransformUtils.preCheckCast(r3, androidx.viewpager2.adapter.c.class, "com.obric.aiagent.plugin")).i();
        goto L11
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.mPendingCurrentItem = r5.mCurrentItem;
        this.mPendingAdapterState = r5.mAdapterState;
    }

    private void restorePendingState() {
        if (this.mPendingCurrentItem != (-1)) goto L5;
        return;
    L5:
        RecyclerView.a r0 = getAdapter();
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.mPendingAdapterState != null) goto L11;
    L14:
        int r1 = Math.max(0, Math.min(this.mPendingCurrentItem, r0.a() - 1));
        this.mCurrentItem = r1;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(r1);
        this.mAccessibilityProvider.c();
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r0, androidx.viewpager2.adapter.c.class) == false) goto L13;
        ((androidx.viewpager2.adapter.c) ZeusTransformUtils.preCheckCast(r0, androidx.viewpager2.adapter.c.class, "com.obric.aiagent.plugin")).a(this.mPendingAdapterState);
    L13:
        this.mPendingAdapterState = null;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r4) {
        Parcelable r0 = (Parcelable) ZeusTransformUtils.preCheckCast(r4.get(getId()), Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, SavedState.class) == false) goto L5;
        int r1 = ((SavedState) ZeusTransformUtils.preCheckCast(r0, SavedState.class, "com.obric.aiagent.plugin")).mRecyclerViewId;
        r4.put(this.mRecyclerView.getId(), r4.get(r1));
        r4.remove(r1);
    L5:
        super.dispatchRestoreInstanceState(r4);
        restorePendingState();
    }

    public void setAdapter(RecyclerView.a r3) {
        RecyclerView.a r0 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.b(r0);
        unregisterCurrentItemDataSetTracker(r0);
        this.mRecyclerView.setAdapter(r3);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.a(r3);
        registerCurrentItemDataSetTracker(r3);
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.a<?> r1) {
        if (r1 == null) goto L5;
        r1.a(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.a<?> r1) {
        if (r1 == null) goto L5;
        r1.b(this.mCurrentItemDataSetChangeObserver);
        return;
    }

    public RecyclerView.a getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r2) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public void onMeasure(int r6, int r7) {
        measureChild(this.mRecyclerView, r6, r7);
        int r0 = this.mRecyclerView.getMeasuredWidth();
        int r1 = this.mRecyclerView.getMeasuredHeight();
        int r2 = this.mRecyclerView.getMeasuredState();
        int r3 = r0 + (getPaddingLeft() + getPaddingRight());
        int r4 = r1 + (getPaddingTop() + getPaddingBottom());
        int r5 = Math.max(r3, getSuggestedMinimumWidth());
        int r8 = Math.max(r4, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(r5, r6, r2), resolveSizeAndState(r8, r7, r2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = this.mRecyclerView.getMeasuredWidth();
        int r0 = this.mRecyclerView.getMeasuredHeight();
        Rect r1 = this.mTmpContainerRect;
        r1.left = getPaddingLeft();
        Rect r2 = this.mTmpContainerRect;
        r2.right = (r7 - r5) - getPaddingRight();
        Rect r10 = this.mTmpContainerRect;
        r10.top = getPaddingTop();
        Rect r11 = this.mTmpContainerRect;
        r11.bottom = (r8 - r6) - getPaddingBottom();
        Gravity.apply(8388659, r9, r0, this.mTmpContainerRect, this.mTmpChildRect);
        this.mRecyclerView.layout(this.mTmpChildRect.left, this.mTmpChildRect.top, this.mTmpChildRect.right, this.mTmpChildRect.bottom);
        if (this.mCurrentItemDirty == false) goto L6;
        updateCurrentItem();
        return;
    }

    void updateCurrentItem() {
        v r0 = this.mPagerSnapHelper;
        if (r0 == null) goto L15;
        View r1 = r0.a(this.mLayoutManager);
        if (r1 != null) goto L7;
        return;
    L7:
        int r2 = this.mLayoutManager.d(r1);
        if (r2 != this.mCurrentItem) goto L10;
    L12:
        this.mCurrentItemDirty = false;
        return;
    L10:
        if (getScrollState() != 0) goto L12;
        this.mPageChangeEventDispatcher.b(r2);
        goto L12
    L15:
        throw new IllegalStateException("Design assumption violated.");
    }

    int getPageSize() {
        RecyclerView r0 = this.mRecyclerView;
        if (getOrientation() != 0) goto L5;
        int r2 = r0.getWidth() - r0.getPaddingLeft();
        int r1 = r0.getPaddingRight();
    L7:
        return r2 - r1;
    L5:
        r2 = r0.getHeight() - r0.getPaddingTop();
        r1 = r0.getPaddingBottom();
        goto L7
    }

    public void setOrientation(int r2) {
        this.mLayoutManager.b(r2);
        this.mAccessibilityProvider.d();
    }

    public int getOrientation() {
        return this.mLayoutManager.h();
    }

    boolean isRtl() {
        if (this.mLayoutManager.v() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setCurrentItem(int r2) {
        setCurrentItem(r2, true);
    }

    public void setCurrentItem(int r2, boolean r3) {
        if (isFakeDragging() == true) goto L7;
        setCurrentItemInternal(r2, r3);
        return;
    L7:
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    void setCurrentItemInternal(int r9, boolean r10) {
        RecyclerView.a r0 = getAdapter();
        if (r0 != null) goto L9;
        if (this.mPendingCurrentItem == (-1)) goto L36;
        this.mPendingCurrentItem = Math.max(r9, 0);
        return;
    L36:
        return;
    L9:
        if (r0.a() > 0) goto L11;
        return;
    L11:
        int r11 = Math.min(Math.max(r9, 0), r0.a() - 1);
        if (r11 == this.mCurrentItem) goto L14;
    L16:
        int r1 = this.mCurrentItem;
        if (r11 != r1) goto L20;
        if (r10 == false) goto L20;
        return;
    L20:
        double r2 = r1;
        this.mCurrentItem = r11;
        this.mAccessibilityProvider.e();
        if (this.mScrollEventAdapter.e() == true) goto L23;
        r2 = this.mScrollEventAdapter.h();
    L23:
        this.mScrollEventAdapter.a(r11, r10);
        if (r10 == true) goto L27;
        this.mRecyclerView.scrollToPosition(r11);
        return;
    L27:
        double r3 = r11;
        if (Math.abs(r3 - r2) <= 3.0d) goto L34;
        RecyclerView r12 = this.mRecyclerView;
        if (r3 <= r2) goto L32;
        int r4 = r11 - 3;
    L33:
        r12.scrollToPosition(r4);
        this.mRecyclerView.post(new i(r11, this.mRecyclerView));
        return;
    L32:
        r4 = r11 + 3;
        goto L33
    L34:
        this.mRecyclerView.smoothScrollToPosition(r11);
        return;
    L14:
        if (this.mScrollEventAdapter.e() == false) goto L16;
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.d();
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.b();
    }

    public boolean fakeDragBy(float r1) {
        return this.mFakeDragger.a(r1);
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.c();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.a();
    }

    void snapToPage() {
        View r0 = this.mPagerSnapHelper.a(this.mLayoutManager);
        if (r0 != null) goto L5;
        return;
    L5:
        int[] r1 = this.mPagerSnapHelper.a(this.mLayoutManager, r0);
        if (r1[0] == 0) goto L8;
    L9:
        this.mRecyclerView.smoothScrollBy(r1[0], r1[1]);
        return;
    L8:
        if (r1[1] != 0) goto L9;
    }

    public void setUserInputEnabled(boolean r1) {
        this.mUserInputEnabled = r1;
        this.mAccessibilityProvider.f();
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 < 1) goto L5;
    L9:
        this.mOffscreenPageLimit = r2;
        this.mRecyclerView.requestLayout();
        return;
    L5:
        if (r2 == (-1)) goto L9;
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r1) {
        return this.mRecyclerView.canScrollHorizontally(r1);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int r1) {
        return this.mRecyclerView.canScrollVertically(r1);
    }

    public void registerOnPageChangeCallback(e r1) {
        this.mExternalPageChangeCallbacks.a(r1);
    }

    public void unregisterOnPageChangeCallback(e r1) {
        this.mExternalPageChangeCallbacks.b(r1);
    }

    public void setPageTransformer(g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        if (this.mSavedItemAnimatorPresent == true) goto L7;
        this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
        this.mSavedItemAnimatorPresent = true;
    L7:
        this.mRecyclerView.setItemAnimator(null);
    L12:
        if (r5 != this.mPageTransformerAdapter.a()) goto L14;
        return;
    L14:
        this.mPageTransformerAdapter.a(r5);
        requestTransform();
        return;
    L9:
        if (this.mSavedItemAnimatorPresent == false) goto L12;
        this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        goto L12
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.a() != null) goto L5;
        return;
    L5:
        double r0 = this.mScrollEventAdapter.h();
        int r2 = (int) r0;
        float r1 = (float) (r0 - ((double) r2));
        this.mPageTransformerAdapter.a(r2, r1, Math.round(getPageSize() * r1));
    }

    @Override // android.view.View
    public void setLayoutDirection(int r1) {
        super.setLayoutDirection(r1);
        this.mAccessibilityProvider.g();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        this.mAccessibilityProvider.a(r1);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int r2, Bundle r3) {
        if (this.mAccessibilityProvider.a(r2, r3) == false) goto L7;
        return this.mAccessibilityProvider.b(r2, r3);
    L7:
        return super.performAccessibilityAction(r2, r3);
    }

    public void addItemDecoration(RecyclerView.g r1) {
        this.mRecyclerView.addItemDecoration(r1);
    }

    public void addItemDecoration(RecyclerView.g r1, int r2) {
        this.mRecyclerView.addItemDecoration(r1, r2);
    }

    public RecyclerView.g getItemDecorationAt(int r1) {
        return this.mRecyclerView.getItemDecorationAt(r1);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public void removeItemDecorationAt(int r1) {
        this.mRecyclerView.removeItemDecorationAt(r1);
    }

    public void removeItemDecoration(RecyclerView.g r1) {
        this.mRecyclerView.removeItemDecoration(r1);
    }
}
