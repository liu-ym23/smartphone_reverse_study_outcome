package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
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

    public abstract Fragment getItem(int r1);

    @Deprecated
    public FragmentStatePagerAdapter(FragmentManager r2) {
        this(r2, 0);
    }

    public FragmentStatePagerAdapter(FragmentManager r3, int r4) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r3;
        this.mBehavior = r4;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup r3) {
        if (r3.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r4, int r5) {
        if (this.mFragments.size() <= r5) goto L8;
        Fragment r0 = this.mFragments.get(r5);
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (this.mCurTransaction != null) goto L10;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L10:
        Fragment r1 = getItem(r5);
        if (this.mSavedState.size() <= r5) goto L16;
        Fragment.SavedState r2 = this.mSavedState.get(r5);
        if (r2 == null) goto L16;
        r1.setInitialSavedState(r2);
    L16:
        if (this.mFragments.size() > r5) goto L18;
        this.mFragments.add(null);
        goto L16
    L18:
        r1.setMenuVisibility(false);
        if (this.mBehavior != 0) goto L21;
        r1.setUserVisibleHint(false);
    L21:
        this.mFragments.set(r5, r1);
        this.mCurTransaction.add(r4.getId(), r1);
        if (this.mBehavior != 1) goto L24;
        this.mCurTransaction.setMaxLifecycle(r1, Lifecycle.State.STARTED);
    L24:
        return r1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r3, int r4, Object r5) {
        Fragment r6 = (Fragment) r5;
        if (this.mCurTransaction != null) goto L6;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L6:
        if (this.mSavedState.size() > r4) goto L8;
        this.mSavedState.add(null);
        goto L6
    L8:
        ArrayList<Fragment.SavedState> r7 = this.mSavedState;
        if (r6.isAdded() == false) goto L11;
        Fragment.SavedState r1 = this.mFragmentManager.saveFragmentInstanceState(r6);
    L12:
        r7.set(r4, r1);
        this.mFragments.set(r4, null);
        this.mCurTransaction.remove(r6);
        if (r6.equals(this.mCurrentPrimaryItem) == false) goto L18;
        this.mCurrentPrimaryItem = null;
        return;
    L18:
        return;
    L11:
        r1 = null;
        goto L12
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r3, int r4, Object r5) {
        Fragment r6 = (Fragment) r5;
        Fragment r7 = this.mCurrentPrimaryItem;
        if (r6 != r7) goto L5;
        return;
    L5:
        if (r7 == null) goto L13;
        r7.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L11:
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r6.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r6.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r6;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L18:
        this.mCurTransaction.setMaxLifecycle(r6, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup r3) {
        FragmentTransaction r4 = this.mCurTransaction;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mExecutingFinishUpdate == false) goto L14;
    L12:
        this.mCurTransaction = null;
        return;
    L14:
        this.mExecutingFinishUpdate = true;     // Catch: Throwable -> L9
        r4.commitNowAllowingStateLoss();     // Catch: Throwable -> L9
        this.mExecutingFinishUpdate = false;
    L9:
        th = move-exception;
        this.mExecutingFinishUpdate = false;
        throw th;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r1, Object r2) {
        if (((Fragment) r2).getView() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        if (this.mSavedState.size() <= 0) goto L5;
        Bundle r0 = new Bundle();
        Fragment.SavedState[] r1 = new Fragment.SavedState[this.mSavedState.size()];
        this.mSavedState.toArray(r1);
        r0.putParcelableArray("states", r1);
    L6:
        int r2 = 0;
    L8:
        if (r2 >= this.mFragments.size()) goto L17;
        Fragment r3 = this.mFragments.get(r2);
        if (r3 == null) goto L16;
        if (r3.isAdded() == false) goto L16;
        if (r0 != null) goto L15;
        r0 = new Bundle();
    L15:
        this.mFragmentManager.putFragment(r0, "f" + r2, r3);
    L16:
        r2 = r2 + 1;
        goto L8
    L17:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r6, ClassLoader r7) {
        if (r6 == null) goto L21;
        Bundle r8 = (Bundle) r6;
        r8.setClassLoader(r7);
        Parcelable[] r9 = r8.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        if (r9 == null) goto L9;
        int r1 = 0;
    L7:
        if (r1 >= r9.length) goto L9;
        this.mSavedState.add((Fragment.SavedState) r9[r1]);
        r1 = r1 + 1;
    L9:
        Iterator<T> r10 = r8.keySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L32;
        String r2 = (String) r10.next();
        if (r2.startsWith("f") == false) goto L11;
        int r3 = Integer.parseInt(r2.substring(1));
        Fragment r4 = this.mFragmentManager.getFragment(r8, r2);
        if (r4 != null) goto L17;
        Log.w(TAG, "Bad fragment at key " + r2);
    L17:
        if (this.mFragments.size() > r3) goto L19;
        this.mFragments.add(null);
        goto L17
    L19:
        r4.setMenuVisibility(false);
        this.mFragments.set(r3, r4);
        goto L11
    L32:
        return;
    }
}
