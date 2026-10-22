package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Fragment.SavedState> mSavedState;

    public b0(FragmentManager r10) {
        this(r10, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        Fragment r13 = (Fragment) r12;
        if (this.mCurTransaction != null) goto L6;
        this.mCurTransaction = this.mFragmentManager.o();
    L6:
        if (this.mSavedState.size() > r11) goto L8;
        this.mSavedState.add(null);
        goto L6
    L8:
        ArrayList<Fragment.SavedState> r14 = this.mSavedState;
        if (r13.isAdded() == false) goto L11;
        Fragment.SavedState r15 = this.mFragmentManager.z1(r13);
    L12:
        r14.set(r11, r15);
        this.mFragments.set(r11, null);
        this.mCurTransaction.t(r13);
        if (r13.equals(this.mCurrentPrimaryItem) == false) goto L18;
        this.mCurrentPrimaryItem = null;
        return;
    L18:
        return;
    L11:
        r15 = null;
        goto L12
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup r10) {
        FragmentTransaction r11 = this.mCurTransaction;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.mExecutingFinishUpdate == false) goto L14;
    L12:
        this.mCurTransaction = null;
        return;
    L14:
        this.mExecutingFinishUpdate = true;     // Catch: Throwable -> L9
        r11.m();     // Catch: Throwable -> L9
        this.mExecutingFinishUpdate = false;
    L9:
        th = move-exception;
        this.mExecutingFinishUpdate = false;
        throw th;
    }

    public abstract Fragment getItem(int r10);

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r10, int r11) {
        if (this.mFragments.size() <= r11) goto L8;
        Fragment r12 = this.mFragments.get(r11);
        if (r12 == null) goto L8;
        return r12;
    L8:
        if (this.mCurTransaction != null) goto L10;
        this.mCurTransaction = this.mFragmentManager.o();
    L10:
        Fragment r13 = getItem(r11);
        if (this.mSavedState.size() <= r11) goto L16;
        Fragment.SavedState r14 = this.mSavedState.get(r11);
        if (r14 == null) goto L16;
        r13.setInitialSavedState(r14);
    L16:
        if (this.mFragments.size() > r11) goto L18;
        this.mFragments.add(null);
        goto L16
    L18:
        r13.setMenuVisibility(false);
        if (this.mBehavior != 0) goto L21;
        r13.setUserVisibleHint(false);
    L21:
        this.mFragments.set(r11, r13);
        this.mCurTransaction.a(r10.getId(), r13);
        if (this.mBehavior != 1) goto L24;
        this.mCurTransaction.x(r13, Lifecycle.State.STARTED);
    L24:
        return r13;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r10, @NonNull Object r11) {
        if (((Fragment) r11).getView() != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable r10, @Nullable ClassLoader r11) {
        if (r10 == null) goto L21;
        Bundle r12 = (Bundle) r10;
        r12.setClassLoader(r11);
        Parcelable[] r13 = r12.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        if (r13 == null) goto L9;
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L9;
        this.mSavedState.add((Fragment.SavedState) r13[r14]);
        r14 = r14 + 1;
    L9:
        Iterator<T> r15 = r12.keySet().iterator();
    L11:
        if (r15.hasNext() == false) goto L32;
        String r16 = (String) r15.next();
        if (r16.startsWith("f") == false) goto L11;
        int r17 = Integer.parseInt(r16.substring(1));
        Fragment r18 = this.mFragmentManager.t0(r12, r16);
        if (r18 != null) goto L17;
        Log.w(TAG, "Bad fragment at key " + r16);
    L17:
        if (this.mFragments.size() > r17) goto L19;
        this.mFragments.add(null);
        goto L17
    L19:
        r18.setMenuVisibility(false);
        this.mFragments.set(r17, r18);
        goto L11
    L32:
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        if (this.mSavedState.size() <= 0) goto L5;
        Bundle r10 = new Bundle();
        Fragment.SavedState[] r11 = new Fragment.SavedState[this.mSavedState.size()];
        this.mSavedState.toArray(r11);
        r10.putParcelableArray("states", r11);
    L6:
        int r12 = 0;
    L8:
        if (r12 >= this.mFragments.size()) goto L17;
        Fragment r13 = this.mFragments.get(r12);
        if (r13 == null) goto L16;
        if (r13.isAdded() == false) goto L16;
        if (r10 != null) goto L15;
        r10 = new Bundle();
    L15:
        this.mFragmentManager.m1(r10, "f" + r12, r13);
    L16:
        r12 = r12 + 1;
        goto L8
    L17:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup r10, int r11, @NonNull Object r12) {
        Fragment r13 = (Fragment) r12;
        Fragment r14 = this.mCurrentPrimaryItem;
        if (r13 != r14) goto L5;
        return;
    L5:
        if (r14 == null) goto L13;
        r14.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.o();
    L11:
        this.mCurTransaction.x(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r13.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r13.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r13;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.o();
    L18:
        this.mCurTransaction.x(r13, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup r10) {
        if (r10.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public b0(FragmentManager r10, int r11) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r10;
        this.mBehavior = r11;
    }
}
