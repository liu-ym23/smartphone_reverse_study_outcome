package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
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

    public abstract Fragment getItem(int r100);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        if (this.mSavedState.size() <= 0) goto L5;
        Bundle r100 = new Bundle();
        Fragment.SavedState[] r101 = new Fragment.SavedState[this.mSavedState.size()];
        this.mSavedState.toArray(r101);
        r100.putParcelableArray("states", r101);
    L6:
        int r102 = 0;
    L8:
        if (r102 >= this.mFragments.size()) goto L17;
        Fragment r103 = (Fragment) ListProtector.get(this.mFragments, r102);
        if (r103 == null) goto L16;
        if (r103.isAdded() == false) goto L16;
        if (r100 != null) goto L15;
        r100 = new Bundle();
    L15:
        this.mFragmentManager.putFragment(r100, "f" + r102, r103);
    L16:
        r102 = r102 + 1;
        goto L8
    L17:
        return r100;
    L5:
        r100 = null;
        goto L6
    }

    public FragmentStatePagerAdapter(FragmentManager r100) {
        this(r100, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup r100) {
        FragmentTransaction r101 = this.mCurTransaction;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mExecutingFinishUpdate == false) goto L14;
    L12:
        this.mCurTransaction = null;
        return;
    L14:
        this.mExecutingFinishUpdate = true;     // Catch: Throwable -> L9
        r101.commitNowAllowingStateLoss();     // Catch: Throwable -> L9
        this.mExecutingFinishUpdate = false;
    L9:
        th = move-exception;
        this.mExecutingFinishUpdate = false;
        throw th;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup r100) {
        if (r100.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentStatePagerAdapter(FragmentManager r100, int r101) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r100;
        this.mBehavior = r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        if (this.mFragments.size() <= r101) goto L8;
        Fragment r102 = (Fragment) ListProtector.get(this.mFragments, r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        if (this.mCurTransaction != null) goto L10;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L10:
        Fragment r103 = getItem(r101);
        if (this.mSavedState.size() <= r101) goto L16;
        Fragment.SavedState r104 = (Fragment.SavedState) ListProtector.get(this.mSavedState, r101);
        if (r104 == null) goto L16;
        r103.setInitialSavedState(r104);
    L16:
        if (this.mFragments.size() > r101) goto L18;
        this.mFragments.add(null);
        goto L16
    L18:
        r103.setMenuVisibility(false);
        if (this.mBehavior != 0) goto L21;
        r103.setUserVisibleHint(false);
    L21:
        ListProtector.set(this.mFragments, r101, r103);
        INVOKEVIRTUAL_androidx_fragment_app_FragmentStatePagerAdapter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this.mCurTransaction, r100.getId(), r103);
        if (this.mBehavior != 1) goto L24;
        this.mCurTransaction.setMaxLifecycle(r103, Lifecycle.State.STARTED);
    L24:
        return r103;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r100, Object r101) {
        if (((Fragment) r101).getView() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r100, ClassLoader r101) {
        if (r100 == null) goto L21;
        Bundle r102 = (Bundle) r100;
        r102.setClassLoader(r101);
        Parcelable[] r103 = r102.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        if (r103 == null) goto L9;
        int r104 = 0;
    L7:
        if (r104 >= r103.length) goto L9;
        this.mSavedState.add((Fragment.SavedState) r103[r104]);
        r104 = r104 + 1;
    L9:
        Iterator<T> r105 = r102.keySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L32;
        String r106 = (String) r105.next();
        if (r106.startsWith("f") == false) goto L11;
        int r107 = CastIntegerProtector.parseInt(r106.substring(1));
        Fragment r108 = this.mFragmentManager.getFragment(r102, r106);
        if (r108 == null) goto L11;
    L17:
        if (this.mFragments.size() > r107) goto L19;
        this.mFragments.add(null);
        goto L17
    L19:
        r108.setMenuVisibility(false);
        ListProtector.set(this.mFragments, r107, r108);
        goto L11
    L32:
        return;
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_FragmentStatePagerAdapter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        Fragment r103 = (Fragment) r102;
        if (this.mCurTransaction != null) goto L6;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L6:
        if (this.mSavedState.size() > r101) goto L8;
        this.mSavedState.add(null);
        goto L6
    L8:
        ArrayList<Fragment.SavedState> r104 = this.mSavedState;
        if (r103.isAdded() == false) goto L11;
        Fragment.SavedState r105 = this.mFragmentManager.saveFragmentInstanceState(r103);
    L12:
        ListProtector.set(r104, r101, r105);
        ListProtector.set(this.mFragments, r101, null);
        this.mCurTransaction.remove(r103);
        if (r103.equals(this.mCurrentPrimaryItem) == false) goto L18;
        this.mCurrentPrimaryItem = null;
        return;
    L18:
        return;
    L11:
        r105 = null;
        goto L12
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Fragment r103 = (Fragment) r102;
        Fragment r104 = this.mCurrentPrimaryItem;
        if (r103 != r104) goto L5;
        return;
    L5:
        if (r104 == null) goto L13;
        r104.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L11:
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r103.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r103.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r103;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L18:
        this.mCurTransaction.setMaxLifecycle(r103, Lifecycle.State.RESUMED);
        goto L20
    }
}
