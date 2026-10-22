package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        /* synthetic */ DataSetChangeObserver(AnonymousClass1 r1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r1, int r2, Object r3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r1, int r2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r1, int r2, int r3) {
            onChanged();
        }
    }

    class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId;
        private ViewPager2 mViewPager;
        final /* synthetic */ FragmentStateAdapter this$0;

        FragmentMaxLifecycleEnforcer(FragmentStateAdapter r3) {
            this.this$0 = r3;
            this.mPrimaryItemId = -1;
        }

        void register(RecyclerView r2) {
            this.mViewPager = inferViewPager(r2);
            ViewPager2.OnPageChangeCallback r3 = new AnonymousClass1(this);
            this.mPageChangeCallback = r3;
            this.mViewPager.registerOnPageChangeCallback(r3);
            DataSetChangeObserver r4 = new AnonymousClass2(this);
            this.mDataObserver = r4;
            this.this$0.registerAdapterDataObserver(r4);
            this.mLifecycleObserver = new AnonymousClass3(this);
            this.this$0.mLifecycle.addObserver(this.mLifecycleObserver);
        }

        void unregister(RecyclerView r2) {
            inferViewPager(r2).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
            this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean r9) {
            if (this.this$0.shouldDelayFragmentTransactions() == false) goto L6;
            return;
        L6:
            if (this.mViewPager.getScrollState() == 0) goto L9;
            return;
        L9:
            if (this.this$0.mFragments.isEmpty() == false) goto L11;
            return;
        L11:
            if (this.this$0.getItemCount() == 0) goto L53;
            int r0 = this.mViewPager.getCurrentItem();
            if (r0 < this.this$0.getItemCount()) goto L16;
            return;
        L16:
            long r1 = this.this$0.getItemId(r0);
            if (r1 != this.mPrimaryItemId) goto L20;
            if (r9 == true) goto L20;
            return;
        L20:
            Fragment r10 = this.this$0.mFragments.get(r1);
            if (r10 != null) goto L23;
            return;
        L23:
            if (r10.isAdded() == false) goto L54;
            this.mPrimaryItemId = r1;
            FragmentTransaction r11 = this.this$0.mFragmentManager.beginTransaction();
            Fragment r2 = null;
            int r3 = 0;
        L27:
            if (r3 >= this.this$0.mFragments.size()) goto L41;
            long r4 = this.this$0.mFragments.keyAt(r3);
            Fragment r5 = this.this$0.mFragments.valueAt(r3);
            if (r5.isAdded() == false) goto L40;
            if (r4 == this.mPrimaryItemId) goto L34;
            r11.setMaxLifecycle(r5, Lifecycle.State.STARTED);
        L36:
            if (r4 != this.mPrimaryItemId) goto L38;
            boolean r6 = true;
        L39:
            r5.setMenuVisibility(r6);
            goto L40
        L38:
            r6 = false;
            goto L39
        L34:
            r2 = r5;
        L40:
            r3 = r3 + 1;
            goto L27
        L41:
            if (r2 == null) goto L44;
            r11.setMaxLifecycle(r2, Lifecycle.State.RESUMED);
        L44:
            if (r11.isEmpty() == true) goto L52;
            r11.commitNow();
            return;
        L52:
            return;
        L54:
            return;
        }

        private ViewPager2 inferViewPager(RecyclerView r3) {
            ViewParent r2 = r3.getParent();
            if ((r2 instanceof ViewPager2) == false) goto L7;
            return (ViewPager2) r2;
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r2);
        }
    }

    public abstract Fragment createFragment(int r1);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder r1) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((FragmentViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder r1) {
        return onFailedToRecycleView((FragmentViewHolder) r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        onViewAttachedToWindow((FragmentViewHolder) r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r1) {
        onViewRecycled((FragmentViewHolder) r1);
    }

    public FragmentStateAdapter(FragmentActivity r2) {
        this(r2.getSupportFragmentManager(), r2.getLifecycle());
    }

    public FragmentStateAdapter(Fragment r2) {
        this(r2.getChildFragmentManager(), r2.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager r2, Lifecycle r3) {
        this.mFragments = new LongSparseArray();
        this.mSavedStates = new LongSparseArray();
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = r2;
        this.mLifecycle = r3;
        super.setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r2) {
        if (this.mFragmentMaxLifecycleEnforcer != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        FragmentMaxLifecycleEnforcer r1 = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer = r1;
        r1.register(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r2) {
        this.mFragmentMaxLifecycleEnforcer.unregister(r2);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FragmentViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return FragmentViewHolder.create(r1);
    }

    public final void onBindViewHolder(final FragmentViewHolder r8, int r9) {
        long r0 = r8.getItemId();
        int r2 = r8.getContainer().getId();
        Long r3 = itemForViewHolder(r2);
        if (r3 != null) goto L5;
    L7:
        this.mItemIdToViewHolder.put(r0, Integer.valueOf(r2));
        ensureFragment(r9);
        final FrameLayout r10 = r8.getContainer();
        if (ViewCompat.isAttachedToWindow(r10) == true) goto L10;
    L14:
        gcFragments();
        return;
    L10:
        if (r10.getParent() != null) goto L13;
        r10.addOnLayoutChangeListener(new AnonymousClass1(this, r10, r8));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r3.longValue() == r0) goto L7;
        removeFragment(r3.longValue());
        this.mItemIdToViewHolder.remove(r3.longValue());
        goto L7
    }

    void gcFragments() {
        if (this.mHasStaleFragments == true) goto L5;
        return;
    L5:
        if (shouldDelayFragmentTransactions() == true) goto L35;
        ArraySet r0 = new ArraySet();
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= this.mFragments.size()) goto L15;
        long r3 = this.mFragments.keyAt(r2);
        if (containsItem(r3) == true) goto L13;
        r0.add(Long.valueOf(r3));
        this.mItemIdToViewHolder.remove(r3);
    L13:
        r2 = r2 + 1;
        goto L9
    L15:
        if (this.mIsInGracePeriod == true) goto L23;
        this.mHasStaleFragments = false;
    L18:
        if (r1 >= this.mFragments.size()) goto L23;
        long r4 = this.mFragments.keyAt(r1);
        if (isFragmentViewBound(r4) == true) goto L22;
        r0.add(Long.valueOf(r4));
    L22:
        r1 = r1 + 1;
    L23:
        Iterator<E> r5 = r0.iterator();
    L25:
        if (r5.hasNext() == false) goto L36;
        removeFragment(((Long) r5.next()).longValue());
        goto L25
    L36:
        return;
    }

    private boolean isFragmentViewBound(long r3) {
        if (this.mItemIdToViewHolder.containsKey(r3) == false) goto L5;
        return true;
    L5:
        Fragment r2 = this.mFragments.get(r3);
        if (r2 != null) goto L8;
        return false;
    L8:
        View r4 = r2.getView();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private Long itemForViewHolder(int r5) {
        Long r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= this.mItemIdToViewHolder.size()) goto L12;
        if (this.mItemIdToViewHolder.valueAt(r1).intValue() != r5) goto L11;
        if (r0 != null) goto L10;
        r0 = Long.valueOf(this.mItemIdToViewHolder.keyAt(r1));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }

    private void ensureFragment(int r4) {
        long r0 = getItemId(r4);
        if (this.mFragments.containsKey(r0) == true) goto L6;
        Fragment r5 = createFragment(r4);
        r5.setInitialSavedState(this.mSavedStates.get(r0));
        this.mFragments.put(r0, r5);
        return;
    }

    public final void onViewAttachedToWindow(FragmentViewHolder r1) {
        placeFragmentInViewHolder(r1);
        gcFragments();
    }

    void placeFragmentInViewHolder(final FragmentViewHolder r6) {
        Fragment r0 = this.mFragments.get(r6.getItemId());
        if (r0 == null) goto L36;
        FrameLayout r2 = r6.getContainer();
        View r3 = r0.getView();
        if (r0.isAdded() == true) goto L11;
        if (r3 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r0.isAdded() == false) goto L16;
        if (r3 != null) goto L16;
        scheduleViewAttach(r0, r2);
        return;
    L16:
        if (r0.isAdded() == false) goto L24;
        if (r3.getParent() == null) goto L24;
        if (r3.getParent() == r2) goto L37;
        addViewToContainer(r3, r2);
        return;
    L37:
        return;
    L24:
        if (r0.isAdded() == false) goto L28;
        addViewToContainer(r3, r2);
        return;
    L28:
        if (shouldDelayFragmentTransactions() == true) goto L31;
        scheduleViewAttach(r0, r2);
        this.mFragmentManager.beginTransaction().add(r0, "f" + r6.getItemId()).setMaxLifecycle(r0, Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        return;
    L31:
        if (this.mFragmentManager.isDestroyed() == false) goto L33;
        return;
    L33:
        this.mLifecycle.addObserver(new AnonymousClass2(this, r6));
        return;
    L36:
        throw new IllegalStateException("Design assumption violated.");
    }

    private void scheduleViewAttach(final Fragment r3, final FrameLayout r4) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new AnonymousClass3(this, r3, r4), false);
    }

    void addViewToContainer(View r2, FrameLayout r3) {
        if (r3.getChildCount() > 1) goto L16;
        if (r2.getParent() != r3) goto L8;
        return;
    L8:
        if (r3.getChildCount() <= 0) goto L11;
        r3.removeAllViews();
    L11:
        if (r2.getParent() == null) goto L13;
        ((ViewGroup) r2.getParent()).removeView(r2);
    L13:
        r3.addView(r2);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void onViewRecycled(FragmentViewHolder r3) {
        Long r4 = itemForViewHolder(r3.getContainer().getId());
        if (r4 == null) goto L6;
        removeFragment(r4.longValue());
        this.mItemIdToViewHolder.remove(r4.longValue());
        return;
    }

    private void removeFragment(long r4) {
        Fragment r0 = this.mFragments.get(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getView() == null) goto L11;
        ViewParent r1 = r0.getView().getParent();
        if (r1 == null) goto L11;
        ((FrameLayout) r1).removeAllViews();
    L11:
        if (containsItem(r4) == true) goto L14;
        this.mSavedStates.remove(r4);
    L14:
        if (r0.isAdded() == true) goto L18;
        this.mFragments.remove(r4);
        return;
    L18:
        if (shouldDelayFragmentTransactions() == false) goto L22;
        this.mHasStaleFragments = true;
        return;
    L22:
        if (r0.isAdded() == true) goto L24;
    L26:
        this.mFragmentManager.beginTransaction().remove(r0).commitNow();
        this.mFragments.remove(r4);
        return;
    L24:
        if (containsItem(r4) == false) goto L26;
        this.mSavedStates.put(r4, this.mFragmentManager.saveFragmentInstanceState(r0));
        goto L26
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public boolean containsItem(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3 >= getItemCount()) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r1) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable saveState() {
        Bundle r0 = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.mFragments.size()) goto L12;
        long r3 = this.mFragments.keyAt(r2);
        Fragment r5 = this.mFragments.get(r3);
        if (r5 == null) goto L10;
        if (r5.isAdded() == false) goto L10;
        this.mFragmentManager.putFragment(r0, createKey(KEY_PREFIX_FRAGMENT, r3), r5);
    L10:
        r2 = r2 + 1;
    L12:
        if (r1 >= this.mSavedStates.size()) goto L17;
        long r4 = this.mSavedStates.keyAt(r1);
        if (containsItem(r4) == false) goto L16;
        r0.putParcelable(createKey(KEY_PREFIX_STATE, r4), this.mSavedStates.get(r4));
    L16:
        r1 = r1 + 1;
        goto L12
    L17:
        return r0;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(Parcelable r6) {
        if (this.mSavedStates.isEmpty() == false) goto L27;
        if (this.mFragments.isEmpty() == false) goto L27;
        Bundle r7 = (Bundle) r6;
        if (r7.getClassLoader() != null) goto L9;
        r7.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r0 = r7.keySet().iterator();
    L11:
        if (r0.hasNext() == false) goto L23;
        String r1 = r0.next();
        if (isValidKey(r1, KEY_PREFIX_FRAGMENT) == true) goto L14;
        if (isValidKey(r1, KEY_PREFIX_STATE) == false) goto L21;
        long r2 = parseIdFromKey(r1, KEY_PREFIX_STATE);
        Fragment.SavedState r3 = (Fragment.SavedState) r7.getParcelable(r1);
        if (containsItem(r2) == false) goto L11;
        this.mSavedStates.put(r2, r3);
        goto L11
    L21:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r1);
    L14:
        this.mFragments.put(parseIdFromKey(r1, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(r7, r1));
        goto L11
    L23:
        if (this.mFragments.isEmpty() == true) goto L37;
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
        return;
    L37:
        return;
    L27:
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    private void scheduleGracePeriodEnd() {
        final Handler r0 = new Handler(Looper.getMainLooper());
        final Runnable r1 = new AnonymousClass4(this);
        this.mLifecycle.addObserver(new AnonymousClass5(this, r0, r1));
        r0.postDelayed(r1, GRACE_WINDOW_TIME_MS);
    }

    private static String createKey(String r1, long r2) {
        return r1 + r2;
    }

    private static boolean isValidKey(String r1, String r2) {
        if (r1.startsWith(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.length() <= r2.length()) goto L7;
        return true;
    }

    private static long parseIdFromKey(String r0, String r1) {
        return Long.parseLong(r0.substring(r1.length()));
    }
}
