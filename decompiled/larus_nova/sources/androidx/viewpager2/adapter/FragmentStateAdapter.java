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
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
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

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        public /* synthetic */ DataSetChangeObserver(AnonymousClass1 r100) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            onChanged();
        }
    }

    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId;
        private ViewPager2 mViewPager;
        final /* synthetic */ FragmentStateAdapter this$0;

        public FragmentMaxLifecycleEnforcer(FragmentStateAdapter r100) {
            this.this$0 = r100;
            this.mPrimaryItemId = -1;
        }

        private ViewPager2 inferViewPager(RecyclerView r100) {
            ViewParent r101 = r100.getParent();
            if ((r101 instanceof ViewPager2) == false) goto L7;
            return (ViewPager2) r101;
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r101);
        }

        public void register(RecyclerView r100) {
            this.mViewPager = inferViewPager(r100);
            ViewPager2.OnPageChangeCallback r101 = new AnonymousClass1(this);
            this.mPageChangeCallback = r101;
            this.mViewPager.registerOnPageChangeCallback(r101);
            DataSetChangeObserver r102 = new AnonymousClass2(this);
            this.mDataObserver = r102;
            this.this$0.registerAdapterDataObserver(r102);
            LifecycleEventObserver r103 = new AnonymousClass3(this);
            this.mLifecycleObserver = r103;
            this.this$0.mLifecycle.addObserver(r103);
        }

        public void unregister(RecyclerView r100) {
            inferViewPager(r100).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
            this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean r110) {
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
            int r100 = this.mViewPager.getCurrentItem();
            if (r100 < this.this$0.getItemCount()) goto L16;
            return;
        L16:
            long r101 = this.this$0.getItemId(r100);
            if (r101 != this.mPrimaryItemId) goto L20;
            if (r110 == true) goto L20;
            return;
        L20:
            Fragment r111 = this.this$0.mFragments.get(r101);
            if (r111 != null) goto L23;
            return;
        L23:
            if (r111.isAdded() == false) goto L54;
            this.mPrimaryItemId = r101;
            FragmentTransaction r112 = this.this$0.mFragmentManager.beginTransaction();
            Fragment r102 = null;
            int r103 = 0;
        L27:
            if (r103 >= this.this$0.mFragments.size()) goto L41;
            long r104 = this.this$0.mFragments.keyAt(r103);
            Fragment r105 = this.this$0.mFragments.valueAt(r103);
            if (r105.isAdded() == false) goto L40;
            if (r104 == this.mPrimaryItemId) goto L34;
            r112.setMaxLifecycle(r105, Lifecycle.State.STARTED);
        L36:
            if (r104 != this.mPrimaryItemId) goto L38;
            boolean r106 = true;
        L39:
            r105.setMenuVisibility(r106);
            goto L40
        L38:
            r106 = false;
            goto L39
        L34:
            r102 = r105;
        L40:
            r103 = r103 + 1;
            goto L27
        L41:
            if (r102 == null) goto L44;
            r112.setMaxLifecycle(r102, Lifecycle.State.RESUMED);
        L44:
            if (r112.isEmpty() == true) goto L52;
            r112.commitNow();
            return;
        L52:
            return;
        L54:
            return;
        }
    }

    public abstract Fragment createFragment(int r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder r100) {
        return true;
    }

    private void scheduleGracePeriodEnd() {
        final Handler r100 = new Handler(Looper.getMainLooper());
        final Runnable r101 = new AnonymousClass4(this);
        this.mLifecycle.addObserver(new AnonymousClass5(this, r100, r101));
        r100.postDelayed(r101, 10000);
    }

    public void gcFragments() {
        if (this.mHasStaleFragments == true) goto L5;
        return;
    L5:
        if (shouldDelayFragmentTransactions() == true) goto L35;
        ArraySet r100 = new ArraySet();
        int r101 = 0;
        int r102 = 0;
    L9:
        if (r102 >= this.mFragments.size()) goto L15;
        long r103 = this.mFragments.keyAt(r102);
        if (containsItem(r103) == true) goto L13;
        r100.add(Long.valueOf(r103));
        this.mItemIdToViewHolder.remove(r103);
    L13:
        r102 = r102 + 1;
        goto L9
    L15:
        if (this.mIsInGracePeriod == true) goto L23;
        this.mHasStaleFragments = false;
    L18:
        if (r101 >= this.mFragments.size()) goto L23;
        long r104 = this.mFragments.keyAt(r101);
        if (isFragmentViewBound(r104) == true) goto L22;
        r100.add(Long.valueOf(r104));
    L22:
        r101 = r101 + 1;
    L23:
        Iterator<E> r105 = r100.iterator();
    L25:
        if (r105.hasNext() == false) goto L36;
        removeFragment(((Long) r105.next()).longValue());
        goto L25
    L36:
        return;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable saveState() {
        Bundle r100 = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.mFragments.size()) goto L12;
        long r103 = this.mFragments.keyAt(r102);
        Fragment r104 = this.mFragments.get(r103);
        if (r104 == null) goto L10;
        if (r104.isAdded() == false) goto L10;
        String r105 = createKey(KEY_PREFIX_FRAGMENT, r103);
        this.mFragmentManager.putFragment(r100, r105, r104);
    L10:
        r102 = r102 + 1;
    L12:
        if (r101 >= this.mSavedStates.size()) goto L17;
        long r106 = this.mSavedStates.keyAt(r101);
        if (containsItem(r106) == false) goto L16;
        r100.putParcelable(createKey(KEY_PREFIX_STATE, r106), this.mSavedStates.get(r106));
    L16:
        r101 = r101 + 1;
        goto L12
    L17:
        return r100;
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public FragmentStateAdapter(Fragment r100) {
        this(r100.getChildFragmentManager(), r100.getLifecycle());
    }

    private void ensureFragment(int r100) {
        long r101 = getItemId(r100);
        if (this.mFragments.containsKey(r101) == true) goto L6;
        Fragment r102 = createFragment(r100);
        r102.setInitialSavedState(this.mSavedStates.get(r101));
        this.mFragments.put(r101, r102);
        return;
    }

    private boolean isFragmentViewBound(long r100) {
        if (this.mItemIdToViewHolder.containsKey(r100) == false) goto L5;
        return true;
    L5:
        Fragment r101 = this.mFragments.get(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        View r102 = r101.getView();
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.getParent() != null) goto L16;
        return false;
    L16:
        return true;
    }

    private Long itemForViewHolder(int r100) {
        Long r101 = null;
        int r102 = 0;
    L4:
        if (r102 >= this.mItemIdToViewHolder.size()) goto L12;
        if (this.mItemIdToViewHolder.valueAt(r102).intValue() != r100) goto L11;
        if (r101 != null) goto L10;
        r101 = Long.valueOf(this.mItemIdToViewHolder.keyAt(r102));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r102 = r102 + 1;
        goto L4
    L12:
        return r101;
    }

    private void removeFragment(long r100) {
        Fragment r101 = this.mFragments.get(r100);
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getView() == null) goto L11;
        ViewParent r102 = r101.getView().getParent();
        if (r102 == null) goto L11;
        ((FrameLayout) r102).removeAllViews();
    L11:
        if (containsItem(r100) == true) goto L14;
        this.mSavedStates.remove(r100);
    L14:
        if (r101.isAdded() == true) goto L18;
        this.mFragments.remove(r100);
        return;
    L18:
        if (shouldDelayFragmentTransactions() == false) goto L22;
        this.mHasStaleFragments = true;
        return;
    L22:
        if (r101.isAdded() == true) goto L24;
    L26:
        this.mFragmentManager.beginTransaction().remove(r101).commitNow();
        this.mFragments.remove(r100);
        return;
    L24:
        if (containsItem(r100) == false) goto L26;
        this.mSavedStates.put(r100, this.mFragmentManager.saveFragmentInstanceState(r101));
        goto L26
    }

    public boolean containsItem(long r100) {
        if (r100 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= getItemCount()) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        if (this.mFragmentMaxLifecycleEnforcer != null) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101);
        FragmentMaxLifecycleEnforcer r102 = new FragmentMaxLifecycleEnforcer(this);
        this.mFragmentMaxLifecycleEnforcer = r102;
        r102.register(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r100) {
        this.mFragmentMaxLifecycleEnforcer.unregister(r100);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        return onFailedToRecycleView((FragmentViewHolder) r100);
    }

    public final void onViewAttachedToWindow(FragmentViewHolder r100) {
        placeFragmentInViewHolder(r100);
        gcFragments();
    }

    public final void onViewRecycled(FragmentViewHolder r100) {
        Long r101 = itemForViewHolder(r100.getContainer().getId());
        if (r101 == null) goto L6;
        removeFragment(r101.longValue());
        this.mItemIdToViewHolder.remove(r101.longValue());
        return;
    }

    public void placeFragmentInViewHolder(final FragmentViewHolder r100) {
        Fragment r101 = this.mFragments.get(r100.getItemId());
        if (r101 == null) goto L36;
        FrameLayout r102 = r100.getContainer();
        View r103 = r101.getView();
        if (r101.isAdded() == true) goto L11;
        if (r103 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r101.isAdded() == false) goto L16;
        if (r103 != null) goto L16;
        scheduleViewAttach(r101, r102);
        return;
    L16:
        if (r101.isAdded() == false) goto L24;
        if (r103.getParent() == null) goto L24;
        if (r103.getParent() == r102) goto L37;
        addViewToContainer(r103, r102);
        return;
    L37:
        return;
    L24:
        if (r101.isAdded() == false) goto L28;
        addViewToContainer(r103, r102);
        return;
    L28:
        if (shouldDelayFragmentTransactions() == true) goto L31;
        scheduleViewAttach(r101, r102);
        INVOKEVIRTUAL_androidx_viewpager2_adapter_FragmentStateAdapter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this.mFragmentManager.beginTransaction(), r101, "f" + r100.getItemId()).setMaxLifecycle(r101, Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        return;
    L31:
        if (this.mFragmentManager.isDestroyed() == false) goto L33;
        return;
    L33:
        this.mLifecycle.addObserver(new AnonymousClass2(this, r100));
        return;
    L36:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(Parcelable r100) {
        if (this.mSavedStates.isEmpty() == false) goto L27;
        if (this.mFragments.isEmpty() == false) goto L27;
        Bundle r101 = (Bundle) r100;
        if (r101.getClassLoader() != null) goto L9;
        r101.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r102 = r101.keySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L23;
        String r103 = r102.next();
        if (isValidKey(r103, KEY_PREFIX_FRAGMENT) == true) goto L14;
        if (isValidKey(r103, KEY_PREFIX_STATE) == false) goto L21;
        long r104 = parseIdFromKey(r103, KEY_PREFIX_STATE);
        Fragment.SavedState r105 = (Fragment.SavedState) r101.getParcelable(r103);
        if (containsItem(r104) == false) goto L11;
        this.mSavedStates.put(r104, r105);
        goto L11
    L21:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r103);
    L14:
        this.mFragments.put(parseIdFromKey(r103, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(r101, r103));
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r100) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public FragmentStateAdapter(FragmentActivity r100) {
        this(r100.getSupportFragmentManager(), r100.getLifecycle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        onViewAttachedToWindow((FragmentViewHolder) r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r100) {
        onViewRecycled((FragmentViewHolder) r100);
    }

    public FragmentStateAdapter(FragmentManager r100, Lifecycle r101) {
        this.mFragments = new LongSparseArray();
        this.mSavedStates = new LongSparseArray();
        this.mItemIdToViewHolder = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = r100;
        this.mLifecycle = r101;
        super.setHasStableIds(true);
    }

    private static String createKey(String r100, long r101) {
        return r100 + r101;
    }

    private static boolean isValidKey(String r100, String r101) {
        if (r100.startsWith(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.length() <= r101.length()) goto L7;
        return true;
    }

    private static long parseIdFromKey(String r100, String r101) {
        return CastLongProtector.parseLong(r100.substring(r101.length()));
    }

    private void scheduleViewAttach(final Fragment r100, final FrameLayout r101) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new AnonymousClass3(this, r100, r101), false);
    }

    public void addViewToContainer(View r100, FrameLayout r101) {
        if (r101.getChildCount() > 1) goto L16;
        if (r100.getParent() != r101) goto L8;
        return;
    L8:
        if (r101.getChildCount() <= 0) goto L11;
        r101.removeAllViews();
    L11:
        if (r100.getParent() == null) goto L13;
        ((ViewGroup) r100.getParent()).removeView(r100);
    L13:
        r101.addView(r100);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void onBindViewHolder(final FragmentViewHolder r100, int r101) {
        long r102 = r100.getItemId();
        int r103 = r100.getContainer().getId();
        Long r104 = itemForViewHolder(r103);
        if (r104 != null) goto L5;
    L7:
        this.mItemIdToViewHolder.put(r102, Integer.valueOf(r103));
        ensureFragment(r101);
        final FrameLayout r105 = r100.getContainer();
        if (ViewCompat.isAttachedToWindow(r105) == true) goto L10;
    L14:
        gcFragments();
        return;
    L10:
        if (r105.getParent() != null) goto L13;
        r105.addOnLayoutChangeListener(new AnonymousClass1(this, r105, r100));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r104.longValue() == r102) goto L7;
        removeFragment(r104.longValue());
        this.mItemIdToViewHolder.remove(r104.longValue());
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return onCreateViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((FragmentViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FragmentViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return FragmentViewHolder.create(r100);
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_viewpager2_adapter_FragmentStateAdapter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }
}
