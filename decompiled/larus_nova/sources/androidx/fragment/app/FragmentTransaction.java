package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE = 8197;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN = 4100;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    String mName;
    ArrayList<Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    public static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        boolean mFromExpandedOp;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        public Op() {
        }

        public Op(Op r100) {
            this.mCmd = r100.mCmd;
            this.mFragment = r100.mFragment;
            this.mFromExpandedOp = r100.mFromExpandedOp;
            this.mEnterAnim = r100.mEnterAnim;
            this.mExitAnim = r100.mExitAnim;
            this.mPopEnterAnim = r100.mPopEnterAnim;
            this.mPopExitAnim = r100.mPopExitAnim;
            this.mOldMaxState = r100.mOldMaxState;
            this.mCurrentMaxState = r100.mCurrentMaxState;
        }

        public Op(int r100, Fragment r101) {
            this.mCmd = r100;
            this.mFragment = r101;
            this.mFromExpandedOp = false;
            Lifecycle.State r102 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r102;
            this.mCurrentMaxState = r102;
        }

        public Op(int r100, Fragment r101, Lifecycle.State r102) {
            this.mCmd = r100;
            this.mFragment = r101;
            this.mFromExpandedOp = false;
            this.mOldMaxState = r101.mMaxState;
            this.mCurrentMaxState = r102;
        }

        public Op(int r100, Fragment r101, boolean r102) {
            this.mCmd = r100;
            this.mFragment = r101;
            this.mFromExpandedOp = r102;
            Lifecycle.State r103 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r103;
            this.mCurrentMaxState = r103;
        }
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public FragmentTransaction setTransitionStyle(int r100) {
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack == true) goto L7;
        this.mAllowAddToBackStack = false;
        return this;
    L7:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public FragmentTransaction() {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public void addOp(Op r100) {
        this.mOps.add(r100);
        r100.mEnterAnim = this.mEnterAnim;
        r100.mExitAnim = this.mExitAnim;
        r100.mPopEnterAnim = this.mPopEnterAnim;
        r100.mPopExitAnim = this.mPopExitAnim;
    }

    public FragmentTransaction addToBackStack(String r100) {
        if (this.mAllowAddToBackStack == false) goto L7;
        this.mAddToBackStack = true;
        this.mName = r100;
        return this;
    L7:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public FragmentTransaction attach(Fragment r100) {
        addOp(new Op(7, r100));
        return this;
    }

    public FragmentTransaction detach(Fragment r100) {
        addOp(new Op(6, r100));
        return this;
    }

    public FragmentTransaction hide(Fragment r100) {
        addOp(new Op(4, r100));
        return this;
    }

    public FragmentTransaction remove(Fragment r100) {
        addOp(new Op(3, r100));
        return this;
    }

    public FragmentTransaction runOnCommit(Runnable r100) {
        disallowAddToBackStack();
        if (this.mCommitRunnables != null) goto L5;
        this.mCommitRunnables = new ArrayList();
    L5:
        this.mCommitRunnables.add(r100);
        return this;
    }

    public FragmentTransaction setAllowOptimization(boolean r100) {
        return setReorderingAllowed(r100);
    }

    public FragmentTransaction setBreadCrumbShortTitle(int r100) {
        this.mBreadCrumbShortTitleRes = r100;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int r100) {
        this.mBreadCrumbTitleRes = r100;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment r100) {
        addOp(new Op(8, r100));
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean r100) {
        this.mReorderingAllowed = r100;
        return this;
    }

    public FragmentTransaction setTransition(int r100) {
        this.mTransition = r100;
        return this;
    }

    public FragmentTransaction show(Fragment r100) {
        addOp(new Op(5, r100));
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence r100) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = r100;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence r100) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = r100;
        return this;
    }

    public FragmentTransaction(FragmentFactory r100, ClassLoader r101) {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = r100;
        this.mClassLoader = r101;
    }

    private Fragment createFragment(Class<? extends Fragment> r100, Bundle r101) {
        FragmentFactory r102 = this.mFragmentFactory;
        if (r102 == null) goto L13;
        ClassLoader r103 = this.mClassLoader;
        if (r103 == null) goto L11;
        Fragment r104 = r102.instantiate(r103, r100.getName());
        if (r101 == null) goto L9;
        r104.setArguments(r101);
    L9:
        return r104;
    L11:
        throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
    L13:
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    public FragmentTransaction add(int r100, Fragment r101) {
        doAddOp(r100, r101, null, 1);
        return this;
    }

    public FragmentTransaction addSharedElement(View r100, String r101) {
        if (FragmentTransition.supportsTransition() == false) goto L20;
        String r102 = ViewCompat.getTransitionName(r100);
        if (r102 == null) goto L19;
        if (this.mSharedElementSourceNames != null) goto L10;
        this.mSharedElementSourceNames = new ArrayList();
        this.mSharedElementTargetNames = new ArrayList();
    L13:
        this.mSharedElementSourceNames.add(r102);
        this.mSharedElementTargetNames.add(r101);
        goto L20
    L10:
        if (this.mSharedElementTargetNames.contains(r101) == true) goto L17;
        if (this.mSharedElementSourceNames.contains(r102) == false) goto L13;
        throw new IllegalArgumentException("A shared element with the source name '" + r102 + "' has already been added to the transaction.");
    L17:
        throw new IllegalArgumentException("A shared element with the target name '" + r101 + "' has already been added to the transaction.");
    L19:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    L20:
        return this;
    }

    public FragmentTransaction replace(int r100, Fragment r101) {
        return INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this, r100, r101, null);
    }

    public FragmentTransaction setCustomAnimations(int r100, int r101) {
        return setCustomAnimations(r100, r101, 0, 0);
    }

    public FragmentTransaction setMaxLifecycle(Fragment r100, Lifecycle.State r101) {
        addOp(new Op(10, r100, r101));
        return this;
    }

    public FragmentTransaction add(Fragment r100, String r101) {
        doAddOp(0, r100, r101, 1);
        return this;
    }

    public FragmentTransaction(FragmentFactory r100, ClassLoader r101, FragmentTransaction r102) {
        this(r100, r101);
        Iterator<Op> r103 = r102.mOps.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Op r104 = r103.next();
        this.mOps.add(new Op(r104));
        goto L4
    L6:
        this.mEnterAnim = r102.mEnterAnim;
        this.mExitAnim = r102.mExitAnim;
        this.mPopEnterAnim = r102.mPopEnterAnim;
        this.mPopExitAnim = r102.mPopExitAnim;
        this.mTransition = r102.mTransition;
        this.mAddToBackStack = r102.mAddToBackStack;
        this.mAllowAddToBackStack = r102.mAllowAddToBackStack;
        this.mName = r102.mName;
        this.mBreadCrumbShortTitleRes = r102.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r102.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = r102.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r102.mBreadCrumbTitleText;
        if (r102.mSharedElementSourceNames == null) goto L10;
        ArrayList<String> r105 = new ArrayList();
        this.mSharedElementSourceNames = r105;
        r105.addAll(r102.mSharedElementSourceNames);
    L10:
        if (r102.mSharedElementTargetNames == null) goto L12;
        ArrayList<String> r106 = new ArrayList();
        this.mSharedElementTargetNames = r106;
        r106.addAll(r102.mSharedElementTargetNames);
    L12:
        this.mReorderingAllowed = r102.mReorderingAllowed;
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    public FragmentTransaction add(ViewGroup r100, Fragment r101, String r102) {
        r101.mContainer = r100;
        return INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this, r100.getId(), r101, r102);
    }

    public FragmentTransaction replace(int r100, Fragment r101, String r102) {
        if (r100 == 0) goto L6;
        doAddOp(r100, r101, r102, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    public final FragmentTransaction add(int r100, Class<? extends Fragment> r101, Bundle r102) {
        return INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this, r100, createFragment(r101, r102));
    }

    public final FragmentTransaction replace(int r100, Class<? extends Fragment> r101, Bundle r102) {
        return replace(r100, r101, r102, null);
    }

    public final FragmentTransaction add(Class<? extends Fragment> r100, Bundle r101, String r102) {
        return INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this, createFragment(r100, r101), r102);
    }

    public FragmentTransaction add(int r100, Fragment r101, String r102) {
        doAddOp(r100, r101, r102, 1);
        return this;
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102, String r103) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r103, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102, r103);
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r100, int r101, Fragment r102, String r103) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r103, r101) == false) goto L6;
        return r100;
    L6:
        return r100.replace(r101, r102, r103);
    }

    public final FragmentTransaction add(int r100, Class<? extends Fragment> r101, Bundle r102, String r103) {
        return INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this, r100, createFragment(r101, r102), r103);
    }

    public void doAddOp(int r100, Fragment r101, String r102, int r103) {
        String r104 = r101.mPreviousWho;
        if (r104 == null) goto L5;
        FragmentStrictMode.onFragmentReuse(r101, r104);
    L5:
        Class<?> r105 = r101.getClass();
        int r106 = r105.getModifiers();
        if (r105.isAnonymousClass() == true) goto L38;
        if (Modifier.isPublic(r106) == false) goto L38;
        if (r105.isMemberClass() == false) goto L14;
        if (Modifier.isStatic(r106) == false) goto L38;
    L14:
        if (r102 == null) goto L23;
        String r107 = r101.mTag;
        if (r107 != null) goto L18;
    L22:
        r101.mTag = r102;
        goto L23
    L18:
        if (r102.equals(r107) == true) goto L22;
        throw new IllegalStateException("Can't change tag of fragment " + r101 + ": was " + r101.mTag + " now " + r102);
    L23:
        if (r100 != 0) goto L25;
    L35:
        addOp(new Op(r103, r101));
        return;
    L25:
        if (r100 == (-1)) goto L34;
        int r108 = r101.mFragmentId;
        if (r108 == 0) goto L32;
        if (r108 == r100) goto L32;
        throw new IllegalStateException("Can't change container ID of fragment " + r101 + ": was " + r101.mFragmentId + " now " + r100);
    L32:
        r101.mFragmentId = r100;
        r101.mContainerId = r100;
        goto L35
    L34:
        throw new IllegalArgumentException("Can't add fragment " + r101 + " with tag " + r102 + " to container view with no id");
    L38:
        throw new IllegalStateException("Fragment " + r105.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final FragmentTransaction replace(int r100, Class<? extends Fragment> r101, Bundle r102, String r103) {
        return INVOKEVIRTUAL_androidx_fragment_app_FragmentTransaction_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this, r100, createFragment(r101, r102), r103);
    }

    public FragmentTransaction setCustomAnimations(int r100, int r101, int r102, int r103) {
        this.mEnterAnim = r100;
        this.mExitAnim = r101;
        this.mPopEnterAnim = r102;
        this.mPopExitAnim = r103;
        return this;
    }
}
