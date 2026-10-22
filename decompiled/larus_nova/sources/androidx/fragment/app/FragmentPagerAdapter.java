package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: classes17.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    public abstract Fragment getItem(int r100);

    public long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r100, ClassLoader r101) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    public FragmentPagerAdapter(FragmentManager r100) {
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

    public FragmentPagerAdapter(FragmentManager r100, int r101) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r100;
        this.mBehavior = r101;
    }

    private static String makeFragmentName(int r100, long r101) {
        return "android:switcher:" + r100 + ":" + r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        long r102 = getItemId(r101);
        String r103 = makeFragmentName(r100.getId(), r102);
        Fragment r104 = this.mFragmentManager.findFragmentByTag(r103);
        if (r104 == null) goto L8;
        this.mCurTransaction.attach(r104);
    L10:
        if (r104 == this.mCurrentPrimaryItem) goto L15;
        r104.setMenuVisibility(false);
        if (this.mBehavior != 1) goto L14;
        this.mCurTransaction.setMaxLifecycle(r104, Lifecycle.State.STARTED);
        goto L15
    L14:
        r104.setUserVisibleHint(false);
    L15:
        return r104;
    L8:
        r104 = getItem(r101);
        INVOKEVIRTUAL_androidx_fragment_app_FragmentPagerAdapter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this.mCurTransaction, r100.getId(), r104, makeFragmentName(r100.getId(), r102));
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r100, Object r101) {
        if (((Fragment) r101).getView() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        Fragment r103 = (Fragment) r102;
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        this.mCurTransaction.detach(r103);
        if (r103.equals(this.mCurrentPrimaryItem) == false) goto L9;
        this.mCurrentPrimaryItem = null;
        return;
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

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_FragmentPagerAdapter_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102, String r103) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102, r103);
    }
}
