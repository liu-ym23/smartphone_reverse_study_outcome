package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = null;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    /* JADX INFO: loaded from: classes17.dex */
    public static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        int mEnterAnim;
        Object mEnterTransition;
        SharedElementCallback mEnterTransitionCallback;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition;
        SharedElementCallback mExitTransitionCallback;
        View mFocusedView;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;

        public AnimationInfo() {
            this.mEnterTransition = null;
            Object r100 = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = r100;
            this.mExitTransition = null;
            this.mReenterTransition = r100;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = r100;
            this.mEnterTransitionCallback = null;
            this.mExitTransitionCallback = null;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        public static void cancelPendingInputEvents(View r100) {
            r100.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String r100, Exception r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        public abstract void onPreAttached();

        public /* synthetic */ OnPreAttachedListener(AnonymousClass1 r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Bundle r100) {
            this.mState = r100;
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            Bundle r102 = r100.readBundle();
            this.mState = r102;
            if (r101 == null) goto L7;
            if (r102 == null) goto L8;
            r102.setClassLoader(r101);
            return;
        L8:
            return;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeBundle(this.mState);
        }
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        toString();
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return HasDefaultViewModelProviderFactory.CC.$default$getDefaultViewModelCreationExtras(this);
    }

    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    public void onAttachFragment(Fragment r100) {
    }

    public boolean onContextItemSelected(MenuItem r100) {
        return false;
    }

    public Animation onCreateAnimation(int r100, boolean r101, int r102) {
        return null;
    }

    public Animator onCreateAnimator(int r100, boolean r101, int r102) {
        return null;
    }

    public void onCreateOptionsMenu(Menu r100, MenuInflater r101) {
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onHiddenChanged(boolean r100) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r100) {
    }

    public boolean onOptionsItemSelected(MenuItem r100) {
        return false;
    }

    public void onOptionsMenuClosed(Menu r100) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r100) {
    }

    public void onPrepareOptionsMenu(Menu r100) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean r100) {
    }

    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle r100) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View r100, Bundle r101) {
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        if (this.mChildFragmentManager.isDestroyed() == true) goto L10;
        this.mChildFragmentManager.dispatchDestroy();
        this.mChildFragmentManager = new FragmentManagerImpl();
        return;
    L10:
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State r100 = this.mMaxState;
        if (r100 == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r100.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return r100.ordinal();
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    public FragmentContainer createFragmentContainer() {
        return new AnonymousClass4(this);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> r100 = this.mHost;
        if (r100 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r100.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 == null) goto L8;
        Boolean r101 = r100.mAllowEnterTransitionOverlap;
        if (r101 == null) goto L8;
        return r101.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 == null) goto L8;
        Boolean r101 = r100.mAllowReturnTransitionOverlap;
        if (r101 == null) goto L8;
        return r101.booleanValue();
    L8:
        return true;
    }

    public View getAnimatingAway() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mAnimatingAway;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        FragmentHostCallback<?> r100 = this.mHost;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getContext();
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L22;
        if (this.mDefaultFactory != null) goto L20;
        Context r100 = requireContext().getApplicationContext();
    L8:
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        if ((r100 instanceof Application) == true) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L8
    L11:
        Application r101 = (Application) r100;
    L14:
        if (r101 == null) goto L16;
    L18:
        this.mDefaultFactory = new SavedStateViewModelFactory(r101, this, getArguments());
        goto L20
    L16:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L18;
        Objects.toString(requireContext().getApplicationContext());
        goto L18
    L13:
        r101 = null;
    L20:
        return this.mDefaultFactory;
    L22:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    int getEnterAnim() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.mEnterAnim;
    }

    public Object getEnterTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mEnterTransition;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mEnterTransitionCallback;
    }

    int getExitAnim() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.mExitAnim;
    }

    public Object getExitTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mExitTransition;
    }

    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mExitTransitionCallback;
    }

    public View getFocusedView() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mFocusedView;
    }

    public final Object getHost() {
        FragmentHostCallback<?> r100 = this.mHost;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.onGetHost();
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r100 = this.mLayoutInflater;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return performGetLayoutInflater(null);
    }

    public int getNextTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.mNextTransition;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager r100 = this.mFragmentManager;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.mIsPop;
    }

    public int getPopEnterAnim() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.mPopExitAnim;
    }

    public float getPostOnViewCreatedAlpha() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return r100.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        Object r101 = r100.mReenterTransition;
        if (r101 == USE_DEFAULT_TRANSITION) goto L9;
        return r101;
    L9:
        return getExitTransition();
    }

    public Object getReturnTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        Object r101 = r100.mReturnTransition;
        if (r101 == USE_DEFAULT_TRANSITION) goto L9;
        return r101;
    L9:
        return getEnterTransition();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        Object r101 = r100.mSharedElementReturnTransition;
        if (r101 == USE_DEFAULT_TRANSITION) goto L9;
        return r101;
    L9:
        return getSharedElementEnterTransition();
    }

    public ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 == null) goto L9;
        ArrayList<String> r101 = r100.mSharedElementSourceNames;
        if (r101 == null) goto L9;
        return r101;
    L9:
        return new ArrayList();
    }

    public ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 == null) goto L9;
        ArrayList<String> r101 = r100.mSharedElementTargetNames;
        if (r101 == null) goto L9;
        return r101;
    L9:
        return new ArrayList();
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r100 = this.mViewLifecycleOwner;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.getViewModelStore(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean isAdded() {
        if (this.mHost != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdded == false) goto L7;
        return true;
    }

    public final boolean isHidden() {
        if (this.mHidden == true) goto L10;
        FragmentManager r100 = this.mFragmentManager;
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if (r100.isParentHidden(this.mParentFragment) == false) goto L9;
    L10:
        return true;
    }

    public final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r100 = this.mFragmentManager;
        if (r100 != null) goto L7;
    L8:
        return true;
    L7:
        if (r100.isParentMenuVisible(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    public boolean isPostponed() {
        AnimationInfo r100 = this.mAnimationInfo;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.mEnterTransitionPostponed;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r100 = this.mFragmentManager;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isStateSaved();
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    public void performAttach() {
        Iterator<OnPreAttachedListener> r100 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onPreAttached();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.dispatchOnAttachFragment(this);
        this.mChildFragmentManager.dispatchAttach();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null) goto L5;
    L7:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L12;
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        goto L7
    }

    public void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean r100 = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean r101 = this.mIsPrimaryNavigationFragment;
        if (r101 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r100);
        onPrimaryNavigationFragmentChanged(r100);
        this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        return;
    L5:
        if (r101.booleanValue() != r100) goto L6;
    }

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r100 = this.mLifecycleRegistry;
        Lifecycle.Event r101 = Lifecycle.Event.ON_RESUME;
        r100.handleLifecycleEvent(r101);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r101);
    L7:
        this.mChildFragmentManager.dispatchResume();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r100 = this.mLifecycleRegistry;
        Lifecycle.Event r101 = Lifecycle.Event.ON_START;
        r100.handleLifecycleEvent(r101);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r101);
    L7:
        this.mChildFragmentManager.dispatchStart();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    L5:
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (ensureAnimationInfo().mEnterTransitionPostponed == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        ensureAnimationInfo().mEnterTransitionPostponed = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.getHandler().getLooper()) goto L13;
        this.mHost.getHandler().postAtFrontOfQueue(new AnonymousClass2(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(128);
        r100.append(getClass().getSimpleName());
        r100.append("{");
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append("} (");
        r100.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r100.append(" id=0x");
        r100.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r100.append(" tag=");
        r100.append(this.mTag);
    L8:
        r100.append(")");
        return r100.toString();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new AnonymousClass1(this);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        initLifecycle();
    }

    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    public final int getTargetRequestCode() {
        FragmentStrictMode.onGetTargetFragmentRequestCodeUsage(this);
        return this.mTargetRequestCode;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r100 = this.mView;
        if (r100 == null) goto L13;
        if (r100.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context r100 = getContext();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object r100 = getHost();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment r100 = getParentFragment();
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View r100 = getView();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final String getTag() {
        return this.mTag;
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public Fragment(int r100) {
        this();
        this.mContentLayoutId = r100;
    }

    private Fragment getTargetFragment(boolean r100) {
        if (r100 == false) goto L4;
        FragmentStrictMode.onGetTargetFragmentUsage(this);
    L4:
        Fragment r101 = this.mTarget;
        if (r101 == null) goto L7;
        return r101;
    L7:
        FragmentManager r102 = this.mFragmentManager;
        if (r102 == null) goto L13;
        String r103 = this.mTargetWho;
        if (r103 != null) goto L12;
        return null;
    L12:
        return r102.findActiveFragment(r103);
    L13:
        return null;
    }

    private void registerOnPreAttachListener(OnPreAttachedListener r100) {
        if (this.mState < 0) goto L5;
        r100.onPreAttached();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r100);
    }

    public void callStartTransitionListener(boolean r100) {
        AnimationInfo r101 = this.mAnimationInfo;
        if (r101 == null) goto L6;
        r101.mEnterTransitionPostponed = false;
    L6:
        if (this.mView == null) goto L16;
        ViewGroup r102 = this.mContainer;
        if (r102 == null) goto L17;
        FragmentManager r103 = this.mFragmentManager;
        if (r103 == null) goto L18;
        final SpecialEffectsController r104 = SpecialEffectsController.getOrCreateController(r102, r103);
        r104.markPostponedState();
        if (r100 == false) goto L14;
        this.mHost.getHandler().post(new AnonymousClass3(this, r104));
        return;
    L14:
        r104.executePendingOperations();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final boolean equals(Object r100) {
        return super.equals(r100);
    }

    public Fragment findFragmentByWho(String r100) {
        if (r100.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.findFragmentByWho(r100);
    }

    public LayoutInflater getLayoutInflater(Bundle r100) {
        FragmentHostCallback<?> r101 = this.mHost;
        if (r101 == null) goto L7;
        LayoutInflater r102 = r101.onGetLayoutInflater();
        LayoutInflaterCompat.setFactory2(r102, this.mChildFragmentManager.getLayoutInflaterFactory());
        return r102;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public final String getString(int r100) {
        return getResources().getString(r100);
    }

    public final CharSequence getText(int r100) {
        return getResources().getText(r100);
    }

    public void onActivityCreated(Bundle r100) {
        this.mCalled = true;
    }

    public void onAttach(Context r100) {
        this.mCalled = true;
        FragmentHostCallback<?> r101 = this.mHost;
        if (r101 != null) goto L5;
        Activity r102 = null;
    L6:
        if (r102 == null) goto L9;
        this.mCalled = false;
        onAttach(r102);
        return;
    L9:
        return;
    L5:
        r102 = r101.getActivity();
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        this.mCalled = true;
    }

    public void onCreate(Bundle r100) {
        this.mCalled = true;
        restoreChildFragmentState(r100);
        if (this.mChildFragmentManager.isStateAtLeast(1) == true) goto L6;
        this.mChildFragmentManager.dispatchCreate();
        return;
    }

    public LayoutInflater onGetLayoutInflater(Bundle r100) {
        return getLayoutInflater(r100);
    }

    public void onViewStateRestored(Bundle r100) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle r100) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r100);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.dispatchActivityCreated();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void performConfigurationChanged(Configuration r100) {
        onConfigurationChanged(r100);
        this.mChildFragmentManager.dispatchConfigurationChanged(r100);
    }

    public boolean performContextItemSelected(MenuItem r100) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r100) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.dispatchContextItemSelected(r100);
    }

    public void performCreate(Bundle r100) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new AnonymousClass5(this));
        this.mSavedStateRegistryController.performRestore(r100);
        onCreate(r100);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public LayoutInflater performGetLayoutInflater(Bundle r100) {
        LayoutInflater r101 = onGetLayoutInflater(r100);
        this.mLayoutInflater = r101;
        return r101;
    }

    public void performMultiWindowModeChanged(boolean r100) {
        onMultiWindowModeChanged(r100);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(r100);
    }

    public boolean performOptionsItemSelected(MenuItem r100) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r100) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.dispatchOptionsItemSelected(r100);
    }

    public void performOptionsMenuClosed(Menu r100) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.dispatchOptionsMenuClosed(r100);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r100);
        goto L9
    }

    public void performPictureInPictureModeChanged(boolean r100) {
        onPictureInPictureModeChanged(r100);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(r100);
    }

    public boolean performPrepareOptionsMenu(Menu r100) {
        boolean r101 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onPrepareOptionsMenu(r100);
        r101 = true;
    L10:
        return r101 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(r100);
    }

    public void performSaveInstanceState(Bundle r100) {
        onSaveInstanceState(r100);
        this.mSavedStateRegistryController.performSave(r100);
        Parcelable r101 = this.mChildFragmentManager.saveAllStateInternal();
        if (r101 == null) goto L6;
        r100.putParcelable("android:support:fragments", r101);
        return;
    }

    public void registerForContextMenu(View r100) {
        r100.setOnCreateContextMenuListener(this);
    }

    public void restoreChildFragmentState(Bundle r100) {
        if (r100 == null) goto L7;
        Parcelable r101 = r100.getParcelable("android:support:fragments");
        if (r101 == null) goto L8;
        this.mChildFragmentManager.restoreSaveStateInternal(r101);
        this.mChildFragmentManager.dispatchCreate();
        return;
    L8:
        return;
    }

    public final void restoreViewState(Bundle r100) {
        SparseArray<Parcelable> r101 = this.mSavedViewState;
        if (r101 == null) goto L6;
        this.mView.restoreHierarchyState(r101);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r100);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean r100) {
        AnimationInfo r101 = ensureAnimationInfo();
        r101.mAllowEnterTransitionOverlap = Boolean.valueOf(r100);
    }

    public void setAllowReturnTransitionOverlap(boolean r100) {
        AnimationInfo r101 = ensureAnimationInfo();
        r101.mAllowReturnTransitionOverlap = Boolean.valueOf(r100);
    }

    public void setArguments(Bundle r100) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r100;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(SharedElementCallback r100) {
        ensureAnimationInfo().mEnterTransitionCallback = r100;
    }

    public void setEnterTransition(Object r100) {
        ensureAnimationInfo().mEnterTransition = r100;
    }

    public void setExitSharedElementCallback(SharedElementCallback r100) {
        ensureAnimationInfo().mExitTransitionCallback = r100;
    }

    public void setExitTransition(Object r100) {
        ensureAnimationInfo().mExitTransition = r100;
    }

    public void setFocusedView(View r100) {
        ensureAnimationInfo().mFocusedView = r100;
    }

    public void setHasOptionsMenu(boolean r100) {
        if (this.mHasMenu == r100) goto L10;
        this.mHasMenu = r100;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L12:
        return;
    }

    public void setInitialSavedState(SavedState r100) {
        if (this.mFragmentManager != null) goto L12;
        if (r100 == null) goto L8;
        Bundle r101 = r100.mState;
        if (r101 == null) goto L8;
    L9:
        this.mSavedFragmentState = r101;
        return;
    L8:
        r101 = null;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r100) {
        if (this.mMenuVisible == r100) goto L12;
        this.mMenuVisible = r100;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.onSupportInvalidateOptionsMenu();
        return;
    L15:
        return;
    }

    public void setNextTransition(int r100) {
        if (this.mAnimationInfo != null) goto L6;
        if (r100 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = r100;
    }

    public void setPopDirection(boolean r100) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().mIsPop = r100;
    }

    public void setPostOnViewCreatedAlpha(float r100) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = r100;
    }

    public void setReenterTransition(Object r100) {
        ensureAnimationInfo().mReenterTransition = r100;
    }

    public void setRetainInstance(boolean r100) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = r100;
        FragmentManager r101 = this.mFragmentManager;
        if (r101 == null) goto L7;
        if (r100 == false) goto L6;
        r101.addRetainedFragment(this);
        return;
    L6:
        r101.removeRetainedFragment(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(Object r100) {
        ensureAnimationInfo().mReturnTransition = r100;
    }

    public void setSharedElementEnterTransition(Object r100) {
        ensureAnimationInfo().mSharedElementEnterTransition = r100;
    }

    public void setSharedElementReturnTransition(Object r100) {
        ensureAnimationInfo().mSharedElementReturnTransition = r100;
    }

    public void setUserVisibleHint(boolean r100) {
        FragmentStrictMode.onSetUserVisibleHint(this, r100);
        if (this.mUserVisibleHint == true) goto L14;
        if (r100 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r101 = this.mFragmentManager;
        r101.performPendingDeferredStart(r101.createOrGetFragmentStateManager(this));
    L14:
        this.mUserVisibleHint = r100;
        if (this.mState >= 5) goto L18;
        if (r100 == true) goto L18;
        boolean r102 = true;
    L19:
        this.mDeferStart = r102;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r100);
        return;
    L23:
        return;
    L18:
        r102 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(String r100) {
        FragmentHostCallback<?> r101 = this.mHost;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.onShouldShowRequestPermissionRationale(r100);
    }

    public void startActivity(Intent r100) {
        startActivity(r100, null);
    }

    public void unregisterForContextMenu(View r100) {
        r100.setOnCreateContextMenuListener(null);
    }

    public void onAttach(Activity r100) {
        this.mCalled = true;
    }

    public static Fragment instantiate(Context r100, String r101) {
        return instantiate(r100, r101, null);
    }

    public final String getString(int r100, Object... r101) {
        return getResources().getString(r100, r101);
    }

    public boolean performCreateOptionsMenu(Menu r100, MenuInflater r101) {
        boolean r102 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onCreateOptionsMenu(r100, r101);
        r102 = true;
    L10:
        return r102 | this.mChildFragmentManager.dispatchCreateOptionsMenu(r100, r101);
    }

    public final void postponeEnterTransition(long r100, TimeUnit r101) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager r102 = this.mFragmentManager;
        if (r102 == null) goto L5;
        Handler r103 = r102.getHost().getHandler();
    L6:
        r103.removeCallbacks(this.mPostponedDurationRunnable);
        r103.postDelayed(this.mPostponedDurationRunnable, r101.toMillis(r100));
        return;
    L5:
        r103 = new Handler(Looper.getMainLooper());
        goto L6
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r100, ActivityResultCallback<O> r101) {
        return prepareCallInternal(r100, new AnonymousClass6(this), r101);
    }

    public final void requestPermissions(String[] r100, int r101) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchRequestPermissions(this, r100, r101);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void setSharedElementNames(ArrayList<String> r100, ArrayList<String> r101) {
        ensureAnimationInfo();
        AnimationInfo r102 = this.mAnimationInfo;
        r102.mSharedElementSourceNames = r100;
        r102.mSharedElementTargetNames = r101;
    }

    public void setTargetFragment(Fragment r100, int r101) {
        if (r100 == null) goto L4;
        FragmentStrictMode.onSetTargetFragmentUsage(this, r100, r101);
    L4:
        FragmentManager r102 = this.mFragmentManager;
        if (r100 == null) goto L7;
        FragmentManager r103 = r100.mFragmentManager;
    L8:
        if (r102 == null) goto L14;
        if (r103 == null) goto L14;
        if (r102 == r103) goto L14;
        throw new IllegalArgumentException("Fragment " + r100 + " must share the same FragmentManager to be set as a target fragment");
    L14:
        Fragment r104 = r100;
    L15:
        if (r104 == null) goto L21;
        if (r104.equals(this) == true) goto L20;
        r104 = r104.getTargetFragment(false);
        goto L15
    L20:
        throw new IllegalArgumentException("Setting " + r100 + " as the target of " + this + " would create a target cycle");
    L21:
        if (r100 != null) goto L24;
        this.mTargetWho = null;
        this.mTarget = null;
    L29:
        this.mTargetRequestCode = r101;
        return;
    L24:
        if (this.mFragmentManager != null) goto L26;
    L28:
        this.mTargetWho = null;
        this.mTarget = r100;
        goto L29
    L26:
        if (r100.mFragmentManager == null) goto L28;
        this.mTargetWho = r100.mWho;
        this.mTarget = null;
        goto L29
    L7:
        r103 = null;
        goto L8
    }

    public void startActivity(Intent r100, Bundle r101) {
        FragmentHostCallback<?> r102 = this.mHost;
        if (r102 == null) goto L7;
        r102.onStartActivityFromFragment(this, r100, -1, r101);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startActivityForResult(Intent r100, int r101) {
        startActivityForResult(r100, r101, null);
    }

    public static Fragment instantiate(Context r100, String r101, Bundle r102) {
        Fragment r103 = FragmentFactory.loadFragmentClass(r100.getClassLoader(), r101).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        if (r102 == null) goto L6;
        r102.setClassLoader(r103.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        r103.setArguments(r102);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
    L6:
        return r103;
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r101 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r101 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r101 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r101 + ": calling Fragment constructor caused an exception", e);
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(final ActivityResultContract<I, O> r100, final Function<Void, ActivityResultRegistry> r110, final ActivityResultCallback<O> r111) {
        if (this.mState > 1) goto L7;
        final AtomicReference r101 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass8(this, r110, r101, r100, r111));
        return new AnonymousClass9(this, r101, r100);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    public void onActivityResult(int r100, int r101, Intent r102) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L6;
        toString();
        Objects.toString(r102);
        return;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r100, View r101, ContextMenu.ContextMenuInfo r102) {
        requireActivity().onCreateContextMenu(r100, r101, r102);
    }

    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        int r103 = this.mContentLayoutId;
        if (r103 != 0) goto L5;
        return null;
    L5:
        return r100.inflate(r103, r101, false);
    }

    public void onInflate(Context r100, AttributeSet r101, Bundle r102) {
        this.mCalled = true;
        FragmentHostCallback<?> r103 = this.mHost;
        if (r103 != null) goto L5;
        Activity r104 = null;
    L6:
        if (r104 == null) goto L9;
        this.mCalled = false;
        onInflate(r104, r101, r102);
        return;
    L9:
        return;
    L5:
        r104 = r103.getActivity();
        goto L6
    }

    public void performCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View r103 = onCreateView(r100, r101, r102);
        this.mView = r103;
        if (r103 == null) goto L6;
        this.mViewLifecycleOwner.initialize();
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.isInitialized() == true) goto L10;
        this.mViewLifecycleOwner = null;
        return;
    L10:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    @Override // androidx.activity.result.ActivityResultCaller
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r100, final ActivityResultRegistry r101, ActivityResultCallback<O> r102) {
        return prepareCallInternal(r100, new AnonymousClass7(this, r101), r102);
    }

    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().launchStartActivityForResult(this, r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void onInflate(Activity r100, AttributeSet r101, Bundle r102) {
        this.mCalled = true;
    }

    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        r102.print(r100);
        r102.print("mFragmentId=#");
        r102.print(Integer.toHexString(this.mFragmentId));
        r102.print(" mContainerId=#");
        r102.print(Integer.toHexString(this.mContainerId));
        r102.print(" mTag=");
        r102.println(this.mTag);
        r102.print(r100);
        r102.print("mState=");
        r102.print(this.mState);
        r102.print(" mWho=");
        r102.print(this.mWho);
        r102.print(" mBackStackNesting=");
        r102.println(this.mBackStackNesting);
        r102.print(r100);
        r102.print("mAdded=");
        r102.print(this.mAdded);
        r102.print(" mRemoving=");
        r102.print(this.mRemoving);
        r102.print(" mFromLayout=");
        r102.print(this.mFromLayout);
        r102.print(" mInLayout=");
        r102.println(this.mInLayout);
        r102.print(r100);
        r102.print("mHidden=");
        r102.print(this.mHidden);
        r102.print(" mDetached=");
        r102.print(this.mDetached);
        r102.print(" mMenuVisible=");
        r102.print(this.mMenuVisible);
        r102.print(" mHasMenu=");
        r102.println(this.mHasMenu);
        r102.print(r100);
        r102.print("mRetainInstance=");
        r102.print(this.mRetainInstance);
        r102.print(" mUserVisibleHint=");
        r102.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r102.print(r100);
        r102.print("mFragmentManager=");
        r102.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r102.print(r100);
        r102.print("mHost=");
        r102.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r102.print(r100);
        r102.print("mParentFragment=");
        r102.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r102.print(r100);
        r102.print("mArguments=");
        r102.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r102.print(r100);
        r102.print("mSavedFragmentState=");
        r102.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r102.print(r100);
        r102.print("mSavedViewState=");
        r102.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r102.print(r100);
        r102.print("mSavedViewRegistryState=");
        r102.println(this.mSavedViewRegistryState);
    L23:
        Fragment r104 = getTargetFragment(false);
        if (r104 == null) goto L26;
        r102.print(r100);
        r102.print("mTarget=");
        r102.print(r104);
        r102.print(" mTargetRequestCode=");
        r102.println(this.mTargetRequestCode);
    L26:
        r102.print(r100);
        r102.print("mPopDirection=");
        r102.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r102.print(r100);
        r102.print("getEnterAnim=");
        r102.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r102.print(r100);
        r102.print("getExitAnim=");
        r102.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r102.print(r100);
        r102.print("getPopEnterAnim=");
        r102.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r102.print(r100);
        r102.print("getPopExitAnim=");
        r102.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r102.print(r100);
        r102.print("mContainer=");
        r102.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r102.print(r100);
        r102.print("mView=");
        r102.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r102.print(r100);
        r102.print("mAnimatingAway=");
        r102.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        LoaderManager.getInstance(this).dump(r100, r101, r102, r103);
    L50:
        r102.print(r100);
        r102.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(r100 + tb2.c.DEFAULT_TEXT, r101, r102, r103);
    }

    public void setAnimations(int r100, int r101, int r102, int r103) {
        if (this.mAnimationInfo != null) goto L9;
        if (r100 != 0) goto L9;
        if (r101 != 0) goto L9;
        if (r102 != 0) goto L9;
        if (r103 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().mEnterAnim = r100;
        ensureAnimationInfo().mExitAnim = r101;
        ensureAnimationInfo().mPopEnterAnim = r102;
        ensureAnimationInfo().mPopExitAnim = r103;
    }

    public void startIntentSenderForResult(IntentSender r110, int r111, Intent r112, int r113, int r114, int r115, Bundle r116) throws IntentSender.SendIntentException {
        if (this.mHost == null) goto L10;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        toString();
        Objects.toString(r110);
        Objects.toString(r112);
        Objects.toString(r116);
    L7:
        getParentFragmentManager().launchStartIntentSenderForResult(this, r110, r111, r112, r113, r114, r115, r116);
        return;
    L10:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
}
