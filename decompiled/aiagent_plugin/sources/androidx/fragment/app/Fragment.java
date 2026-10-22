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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ag;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import androidx.lifecycle.aq;
import androidx.lifecycle.ar;
import androidx.lifecycle.v;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, ap, androidx.lifecycle.g, androidx.lifecycle.p, androidx.savedstate.c {
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
    a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    am.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    e<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.r mLifecycleRegistry;
    androidx.lifecycle.i.b mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<c> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    androidx.savedstate.b mSavedStateRegistryController;
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
    q mViewLifecycleOwner;
    v<androidx.lifecycle.p> mViewLifecycleOwnerLiveData;
    String mWho;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState(Bundle r1) {
            this.mState = r1;
        }

        SavedState(Parcel r1, ClassLoader r2) {
            Bundle r3 = r1.readBundle();
            this.mState = r3;
            if (r2 == null) goto L7;
            if (r3 == null) goto L8;
            r3.setClassLoader(r2);
            return;
        L8:
            return;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeBundle(this.mState);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f1718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Animator f1719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1722e;
        int f;
        int g;
        int h;
        ArrayList<String> i;
        ArrayList<String> j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Object p;
        Boolean q;
        Boolean r;
        androidx.core.app.q s;
        androidx.core.app.q t;
        float u;
        View v;
        boolean w;
        d x;
        boolean y;

        a() {
            this.k = null;
            this.l = Fragment.USE_DEFAULT_TRANSITION;
            this.m = null;
            this.n = Fragment.USE_DEFAULT_TRANSITION;
            this.o = null;
            this.p = Fragment.USE_DEFAULT_TRANSITION;
            this.s = null;
            this.t = null;
            this.u = 1.0f;
            this.v = null;
        }
    }

    public static class b extends RuntimeException {
        public b(String r1, Exception r2) {
            super(r1, r2);
        }
    }

    private static abstract class c {
        abstract void a();

        private c() {
        }

        /* synthetic */ c(AnonymousClass1 r1) {
            this();
        }
    }

    interface d {
        void a();

        void b();
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.v(r0, r1);
    }

    @Deprecated
    public void onAttachFragment(Fragment r1) {
    }

    public boolean onContextItemSelected(MenuItem r2) {
        MenuItem r1 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        return false;
    }

    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        return null;
    }

    public Animator onCreateAnimator(int r1, boolean r2, int r3) {
        return null;
    }

    public void onCreateOptionsMenu(Menu r1, MenuInflater r2) {
        Menu r0 = (Menu) ZeusTransformUtils.wrapperContextForParams(r1, Menu.class, "com.obric.aiagent.plugin");
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean r1) {
    }

    public void onMultiWindowModeChanged(boolean r1) {
    }

    public boolean onOptionsItemSelected(MenuItem r2) {
        MenuItem r1 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        return false;
    }

    public void onOptionsMenuClosed(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.aiagent.plugin");
    }

    public void onPictureInPictureModeChanged(boolean r1) {
    }

    public void onPrepareOptionsMenu(Menu r2) {
        Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.aiagent.plugin");
    }

    public void onPrimaryNavigationFragmentChanged(boolean r1) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
    }

    public void onSaveInstanceState(Bundle r1) {
    }

    public void onViewCreated(View r1, Bundle r2) {
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    @Override // androidx.lifecycle.p
    public androidx.lifecycle.i getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public androidx.lifecycle.p getViewLifecycleOwner() {
        q r1 = this.mViewLifecycleOwner;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<androidx.lifecycle.p> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ap
    public ao getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (getMinimumMaxLifecycleState() == androidx.lifecycle.i.b.f2055b.ordinal()) goto L9;
        return this.mFragmentManager.c(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    private int getMinimumMaxLifecycleState() {
        if (this.mMaxState == androidx.lifecycle.i.b.f2055b) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(this.mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    L10:
        return this.mMaxState.ordinal();
    }

    @Override // androidx.lifecycle.g
    public am.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L21;
        if (this.mDefaultFactory != null) goto L19;
        Application r0 = null;
        Object r1 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        Context r2 = (Context) r1;
        if (ZeusTransformUtils.instanceOf(r2, ContextWrapper.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r2, Application.class) == true) goto L11;
        r1 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r2, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L7
    L11:
        r0 = (Application) ZeusTransformUtils.preCheckCast(r2, Application.class, "com.obric.aiagent.plugin");
    L13:
        if (r0 == null) goto L15;
    L17:
        this.mDefaultFactory = new ag(r0, this, getArguments());
        goto L19
    L15:
        if (FragmentManager.a(3) == false) goto L17;
        INVOKESTATIC_androidx_fragment_app_Fragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("FragmentManager", "Could not find Application instance from Context " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
    L19:
        return this.mDefaultFactory;
    L21:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new g();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new AnonymousClass1(this);
        this.mMaxState = androidx.lifecycle.i.b.f2058e;
        this.mViewLifecycleOwnerLiveData = new v();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        initLifecycle();
    }

    public Fragment(int r1) {
        this();
        this.mContentLayoutId = r1;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.r(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context r2, String r3) {
        return instantiate((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, null);
    }

    @Deprecated
    public static Fragment instantiate(Context r5, String r6, Bundle r7) {
        Fragment r8 = (Fragment) ZeusTransformUtils.preCheckCast(FragmentFactory.b(((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getClassLoader(), r6).getConstructor(new Class[0]).newInstance(new Object[0]), Fragment.class, "com.obric.aiagent.plugin");     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
        if (r7 == null) goto L6;
        r7.setClassLoader(r8.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
        r8.setArguments(r7);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
    L6:
        return r8;
    L13:
        e = move-exception;
        throw new b("Unable to instantiate fragment " + r6 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new b("Unable to instantiate fragment " + r6 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new b("Unable to instantiate fragment " + r6 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new b("Unable to instantiate fragment " + r6 + ": calling Fragment constructor caused an exception", e);
    }

    final void restoreViewState(Bundle r4) {
        SparseArray<Parcelable> r0 = this.mSavedViewState;
        if (r0 == null) goto L6;
        this.mView.restoreHierarchyState(r0);
        this.mSavedViewState = null;
    L6:
        if (this.mView == null) goto L8;
        this.mViewLifecycleOwner.a(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    L8:
        this.mCalled = false;
        onViewStateRestored(r4);
        if (this.mCalled == false) goto L15;
        if (this.mView == null) goto L16;
        this.mViewLifecycleOwner.a(androidx.lifecycle.i.a.ON_CREATE);
        return;
    L16:
        return;
    L15:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append("}");
        r0.append(" (");
        r0.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r0.append(" id=0x");
        r0.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r0.append(" tag=");
        r0.append(this.mTag);
    L8:
        r0.append(")");
        return r0.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle r2) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r2;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final Bundle requireArguments() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.h();
    }

    public void setInitialSavedState(SavedState r2) {
        if (this.mFragmentManager != null) goto L12;
        if (r2 != null) goto L6;
    L8:
        Bundle r3 = null;
    L9:
        this.mSavedFragmentState = r3;
        return;
    L6:
        if (r2.mState == null) goto L8;
        r3 = r2.mState;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    @Deprecated
    public void setTargetFragment(Fragment r4, int r5) {
        FragmentManager r0 = this.mFragmentManager;
        if (r4 == null) goto L5;
        FragmentManager r2 = r4.mFragmentManager;
    L6:
        if (r0 == null) goto L12;
        if (r2 == null) goto L12;
        if (r0 == r2) goto L12;
        throw new IllegalArgumentException("Fragment " + r4 + " must share the same FragmentManager to be set as a target fragment");
    L12:
        Fragment r1 = r4;
    L13:
        if (r1 == null) goto L19;
        if (r1.equals(this) == true) goto L18;
        r1 = r1.getTargetFragment();
        goto L13
    L18:
        throw new IllegalArgumentException("Setting " + r4 + " as the target of " + this + " would create a target cycle");
    L19:
        if (r4 != null) goto L22;
        this.mTargetWho = null;
        this.mTarget = null;
    L27:
        this.mTargetRequestCode = r5;
        return;
    L22:
        if (this.mFragmentManager != null) goto L24;
    L26:
        this.mTargetWho = null;
        this.mTarget = r4;
        goto L27
    L24:
        if (r4.mFragmentManager == null) goto L26;
        this.mTargetWho = r4.mWho;
        this.mTarget = null;
        goto L27
    L5:
        r2 = null;
        goto L6
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        Fragment r0 = this.mTarget;
        if (r0 == null) goto L5;
        return r0;
    L5:
        FragmentManager r1 = this.mFragmentManager;
        if (r1 == null) goto L11;
        String r2 = this.mTargetWho;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r1.d(r2);
    L11:
        return null;
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        e<?> r2 = this.mHost;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    public final Context requireContext() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentActivity getActivity() {
        e<?> r2 = this.mHost;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getActivity(r2, "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object getHost() {
        e<?> r0 = this.mHost;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.e();
    }

    public final Object requireHost() {
        Object r0 = getHost();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Resources getResources() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public final CharSequence getText(int r2) {
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getText(r2);
    }

    public final String getString(int r2) {
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2);
    }

    public final String getString(int r2, Object... r3) {
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getString(r2, r3);
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final Fragment requireParentFragment() {
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
    }

    public final boolean isAdded() {
        if (this.mHost != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdded == false) goto L7;
        return true;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment r1 = getParentFragment();
        if (r1 != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.isRemoving() == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.isRemovingParent() == false) goto L9;
        goto L8
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r0 = this.mView;
        if (r0 == null) goto L13;
        if (r0.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 != null) goto L7;
    L8:
        return true;
    L7:
        if (r0.b(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    @Deprecated
    public void setRetainInstance(boolean r2) {
        this.mRetainInstance = r2;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L7;
        if (r2 == false) goto L6;
        r0.d(this);
        return;
    L6:
        r0.e(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean r2) {
        if (this.mHasMenu == r2) goto L10;
        this.mHasMenu = r2;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.d();
        return;
    L12:
        return;
    }

    public void setMenuVisibility(boolean r2) {
        if (this.mMenuVisible == r2) goto L12;
        this.mMenuVisible = r2;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.d();
        return;
    L15:
        return;
    }

    @Deprecated
    public void setUserVisibleHint(boolean r4) {
        if (this.mUserVisibleHint == true) goto L14;
        if (r4 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r0 = this.mFragmentManager;
        r0.a(r0.i(this));
    L14:
        this.mUserVisibleHint = r4;
        if (this.mState >= 5) goto L18;
        if (r4 == true) goto L18;
        boolean r1 = true;
    L19:
        this.mDeferStart = r1;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r4);
        return;
    L23:
        return;
    L18:
        r1 = false;
        goto L19
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public androidx.loader.a.a getLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    public void startActivity(Intent r3) {
        ZeusTransformUtils.startActivity(this, r3, null, "com.obric.aiagent.plugin");
    }

    public void startActivity(Intent r3, Bundle r4) {
        e<?> r0 = this.mHost;
        if (r0 == null) goto L7;
        r0.a(this, r3, -1, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(Intent r3, int r4) {
        ZeusTransformUtils.startActivityForResult(this, r3, r4, null, "com.obric.aiagent.plugin");
    }

    @Deprecated
    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().a(this, r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender r10, int r11, Intent r12, int r13, int r14, int r15, Bundle r16) {
        if (this.mHost == null) goto L11;
        if (FragmentManager.a(2) == false) goto L8;
        INVOKESTATIC_androidx_fragment_app_Fragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
    L8:
        getParentFragmentManager().a(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (FragmentManager.a(2) == false) goto L6;
        INVOKESTATIC_androidx_fragment_app_Fragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r3 + " resultCode: " + r4 + " data: " + r5);
        return;
    }

    @Deprecated
    public final void requestPermissions(String[] r2, int r3) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().a(this, r2, r3);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public boolean shouldShowRequestPermissionRationale(String r1) {
        e<?> r0 = this.mHost;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a(r1);
    }

    public LayoutInflater onGetLayoutInflater(Bundle r1) {
        return getLayoutInflater(r1);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r0 = this.mLayoutInflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return performGetLayoutInflater(null);
    }

    LayoutInflater performGetLayoutInflater(Bundle r1) {
        LayoutInflater r2 = onGetLayoutInflater(r1);
        this.mLayoutInflater = r2;
        return r2;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle r1) {
        e<?> r2 = this.mHost;
        if (r2 == null) goto L7;
        LayoutInflater r3 = r2.b();
        LayoutInflaterCompat.a(r3, this.mChildFragmentManager.H());
        return r3;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void onInflate(Context r3, AttributeSet r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        this.mCalled = true;
        e<?> r8 = this.mHost;
        if (r8 != null) goto L5;
        Activity r9 = null;
    L6:
        if (r9 == null) goto L9;
        this.mCalled = false;
        onInflate(r9, r7, r5);
        return;
    L9:
        return;
    L5:
        r9 = ZeusTransformUtils.getActivity(r8, "com.obric.aiagent.plugin");
        goto L6
    }

    @Deprecated
    public void onInflate(Activity r2, AttributeSet r3, Bundle r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        this.mCalled = true;
    }

    public void onAttach(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.mCalled = true;
        e<?> r5 = this.mHost;
        if (r5 != null) goto L5;
        Activity r6 = null;
    L6:
        if (r6 == null) goto L9;
        this.mCalled = false;
        onAttach(r6);
        return;
    L9:
        return;
    L5:
        r6 = ZeusTransformUtils.getActivity(r5, "com.obric.aiagent.plugin");
        goto L6
    }

    @Deprecated
    public void onAttach(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.mCalled = true;
    }

    public void onCreate(Bundle r2) {
        this.mCalled = true;
        restoreChildFragmentState(r2);
        if (this.mChildFragmentManager.b(1) == true) goto L6;
        this.mChildFragmentManager.r();
        return;
    }

    void restoreChildFragmentState(Bundle r2) {
        if (r2 == null) goto L7;
        Parcelable r3 = r2.getParcelable("android:support:fragments");
        if (r3 == null) goto L8;
        this.mChildFragmentManager.a(r3);
        this.mChildFragmentManager.r();
        return;
    L8:
        return;
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r1 = this.mContentLayoutId;
        if (r1 != 0) goto L5;
        return null;
    L5:
        return ZeusTransformUtils.inflate(r2, r1, r3, false, "com.obric.aiagent.plugin");
    }

    public View getView() {
        return this.mView;
    }

    public final View requireView() {
        View r0 = getView();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @Deprecated
    public void onActivityCreated(Bundle r1) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle r1) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new g();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu r3, View r4, ContextMenu.ContextMenuInfo r5) {
        ContextMenu r6 = (ContextMenu) ZeusTransformUtils.wrapperContextForParams(r3, ContextMenu.class, "com.obric.aiagent.plugin");
        ContextMenu.ContextMenuInfo r7 = (ContextMenu.ContextMenuInfo) ZeusTransformUtils.wrapperContextForParams(r5, ContextMenu.ContextMenuInfo.class, "com.obric.aiagent.plugin");
        ((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin")).onCreateContextMenu(r6, r4, r7);
    }

    public void registerForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View r1) {
        r1.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(androidx.core.app.q r1) {
        ensureAnimationInfo().s = r1;
    }

    public void setExitSharedElementCallback(androidx.core.app.q r1) {
        ensureAnimationInfo().t = r1;
    }

    public void setEnterTransition(Object r1) {
        ensureAnimationInfo().k = r1;
    }

    public Object getEnterTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k;
    }

    public void setReturnTransition(Object r1) {
        ensureAnimationInfo().l = r1;
    }

    public Object getReturnTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.l != USE_DEFAULT_TRANSITION) goto L10;
        return getEnterTransition();
    L10:
        return this.mAnimationInfo.l;
    }

    public void setExitTransition(Object r1) {
        ensureAnimationInfo().m = r1;
    }

    public Object getExitTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
    }

    public void setReenterTransition(Object r1) {
        ensureAnimationInfo().n = r1;
    }

    public Object getReenterTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.n != USE_DEFAULT_TRANSITION) goto L10;
        return getExitTransition();
    L10:
        return this.mAnimationInfo.n;
    }

    public void setSharedElementEnterTransition(Object r1) {
        ensureAnimationInfo().o = r1;
    }

    public Object getSharedElementEnterTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.o;
    }

    public void setSharedElementReturnTransition(Object r1) {
        ensureAnimationInfo().p = r1;
    }

    public Object getSharedElementReturnTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.p != USE_DEFAULT_TRANSITION) goto L10;
        return getSharedElementEnterTransition();
    L10:
        return this.mAnimationInfo.p;
    }

    public void setAllowEnterTransitionOverlap(boolean r1) {
        a r0 = ensureAnimationInfo();
        r0.r = Boolean.valueOf(r1);
    }

    public boolean getAllowEnterTransitionOverlap() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.r == null) goto L8;
        return this.mAnimationInfo.r.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean r1) {
        a r0 = ensureAnimationInfo();
        r0.q = Boolean.valueOf(r1);
    }

    public boolean getAllowReturnTransitionOverlap() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.q == null) goto L8;
        return this.mAnimationInfo.q.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().w = true;
    }

    public final void postponeEnterTransition(long r3, TimeUnit r5) {
        ensureAnimationInfo().w = true;
        FragmentManager r0 = this.mFragmentManager;
        if (r0 == null) goto L5;
        Handler r1 = r0.l().f();
    L6:
        r1.removeCallbacks(this.mPostponedDurationRunnable);
        r1.postDelayed(this.mPostponedDurationRunnable, r5.toMillis(r3));
        return;
    L5:
        r1 = new Handler(Looper.getMainLooper());
        goto L6
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (ensureAnimationInfo().w == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        ensureAnimationInfo().w = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.f().getLooper()) goto L13;
        this.mHost.f().postAtFrontOfQueue(new AnonymousClass2(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    void callStartTransitionListener(boolean r4) {
        a r0 = this.mAnimationInfo;
        d r1 = null;
        if (r0 == null) goto L6;
        r0.w = false;
        d r2 = this.mAnimationInfo.x;
        this.mAnimationInfo.x = null;
        r1 = r2;
    L6:
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        if (FragmentManager.f1731a == true) goto L11;
        return;
    L11:
        if (this.mView == null) goto L23;
        ViewGroup r3 = this.mContainer;
        if (r3 == null) goto L24;
        FragmentManager r5 = this.mFragmentManager;
        if (r5 == null) goto L25;
        final t r6 = t.a(r3, r5);
        r6.b();
        if (r4 == false) goto L19;
        this.mHost.f().post(new AnonymousClass3(this, r6));
        return;
    L19:
        r6.d();
        return;
    L25:
        return;
    L24:
        return;
    }

    public void dump(String r4, FileDescriptor r5, PrintWriter r6, String[] r7) {
        r6.print(r4);
        r6.print("mFragmentId=#");
        r6.print(Integer.toHexString(this.mFragmentId));
        r6.print(" mContainerId=#");
        r6.print(Integer.toHexString(this.mContainerId));
        r6.print(" mTag=");
        r6.println(this.mTag);
        r6.print(r4);
        r6.print("mState=");
        r6.print(this.mState);
        r6.print(" mWho=");
        r6.print(this.mWho);
        r6.print(" mBackStackNesting=");
        r6.println(this.mBackStackNesting);
        r6.print(r4);
        r6.print("mAdded=");
        r6.print(this.mAdded);
        r6.print(" mRemoving=");
        r6.print(this.mRemoving);
        r6.print(" mFromLayout=");
        r6.print(this.mFromLayout);
        r6.print(" mInLayout=");
        r6.println(this.mInLayout);
        r6.print(r4);
        r6.print("mHidden=");
        r6.print(this.mHidden);
        r6.print(" mDetached=");
        r6.print(this.mDetached);
        r6.print(" mMenuVisible=");
        r6.print(this.mMenuVisible);
        r6.print(" mHasMenu=");
        r6.println(this.mHasMenu);
        r6.print(r4);
        r6.print("mRetainInstance=");
        r6.print(this.mRetainInstance);
        r6.print(" mUserVisibleHint=");
        r6.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r6.print(r4);
        r6.print("mFragmentManager=");
        r6.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r6.print(r4);
        r6.print("mHost=");
        r6.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r6.print(r4);
        r6.print("mParentFragment=");
        r6.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r6.print(r4);
        r6.print("mArguments=");
        r6.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r6.print(r4);
        r6.print("mSavedFragmentState=");
        r6.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r6.print(r4);
        r6.print("mSavedViewState=");
        r6.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r6.print(r4);
        r6.print("mSavedViewRegistryState=");
        r6.println(this.mSavedViewRegistryState);
    L23:
        Fragment r0 = getTargetFragment();
        if (r0 == null) goto L26;
        r6.print(r4);
        r6.print("mTarget=");
        r6.print(r0);
        r6.print(" mTargetRequestCode=");
        r6.println(this.mTargetRequestCode);
    L26:
        r6.print(r4);
        r6.print("mPopDirection=");
        r6.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r6.print(r4);
        r6.print("getEnterAnim=");
        r6.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r6.print(r4);
        r6.print("getExitAnim=");
        r6.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r6.print(r4);
        r6.print("getPopEnterAnim=");
        r6.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r6.print(r4);
        r6.print("getPopExitAnim=");
        r6.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r6.print(r4);
        r6.print("mContainer=");
        r6.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r6.print(r4);
        r6.print("mView=");
        r6.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r6.print(r4);
        r6.print("mAnimatingAway=");
        r6.println(getAnimatingAway());
    L48:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L50;
        androidx.loader.a.a.a(this).a(r4, r5, r6, r7);
    L50:
        r6.print(r4);
        r6.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.a(r4 + "  ", r5, r6, r7);
    }

    Fragment findFragmentByWho(String r2) {
        if (r2.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.c(r2);
    }

    androidx.fragment.app.c createFragmentContainer() {
        return new AnonymousClass4(this);
    }

    void performAttach() {
        Iterator<c> r0 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin")).a();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.a(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHost.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.q(this);
        this.mChildFragmentManager.q();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performCreate(Bundle r4) {
        this.mChildFragmentManager.p();
        this.mState = 1;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        this.mLifecycleRegistry.a(new AnonymousClass5(this));
    L5:
        this.mSavedStateRegistryController.a(r4);
        onCreate(r4);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.a(androidx.lifecycle.i.a.ON_CREATE);
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    void performCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mChildFragmentManager.p();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new q(this, getViewModelStore());
        View r6 = onCreateView(r3, r4, r5);
        this.mView = r6;
        if (r6 == null) goto L6;
        this.mViewLifecycleOwner.a();
        aq.a(this.mView, this.mViewLifecycleOwner);
        ar.a(this.mView, this.mViewLifecycleOwner);
        androidx.savedstate.d.a(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.b(this.mViewLifecycleOwner);
        return;
    L6:
        if (this.mViewLifecycleOwner.b() == true) goto L10;
        this.mViewLifecycleOwner = null;
        return;
    L10:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.s();
    }

    void performActivityCreated(Bundle r3) {
        this.mChildFragmentManager.p();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r3);
        if (this.mCalled == false) goto L7;
        restoreViewState();
        this.mChildFragmentManager.t();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    private void restoreViewState() {
        if (FragmentManager.a(3) == false) goto L6;
        INVOKESTATIC_androidx_fragment_app_Fragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L8;
        restoreViewState(this.mSavedFragmentState);
    L8:
        this.mSavedFragmentState = null;
    }

    void performStart() {
        this.mChildFragmentManager.p();
        this.mChildFragmentManager.a(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.a(androidx.lifecycle.i.a.ON_START);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.a(androidx.lifecycle.i.a.ON_START);
    L7:
        this.mChildFragmentManager.u();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    void performResume() {
        this.mChildFragmentManager.p();
        this.mChildFragmentManager.a(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        this.mLifecycleRegistry.a(androidx.lifecycle.i.a.ON_RESUME);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.a(androidx.lifecycle.i.a.ON_RESUME);
    L7:
        this.mChildFragmentManager.v();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.p();
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean r0 = this.mFragmentManager.a(this);
        Boolean r1 = this.mIsPrimaryNavigationFragment;
        if (r1 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r0);
        onPrimaryNavigationFragmentChanged(r0);
        this.mChildFragmentManager.B();
        return;
    L5:
        if (r1.booleanValue() != r0) goto L6;
    }

    void performMultiWindowModeChanged(boolean r1) {
        onMultiWindowModeChanged(r1);
        this.mChildFragmentManager.b(r1);
    }

    void performPictureInPictureModeChanged(boolean r1) {
        onPictureInPictureModeChanged(r1);
        this.mChildFragmentManager.c(r1);
    }

    void performConfigurationChanged(Configuration r1) {
        onConfigurationChanged(r1);
        this.mChildFragmentManager.a(r1);
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.A();
    }

    boolean performCreateOptionsMenu(Menu r3, MenuInflater r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r1 = true;
        onCreateOptionsMenu(r5, r4);
    L10:
        return r1 | this.mChildFragmentManager.a(r5, r4);
    }

    boolean performPrepareOptionsMenu(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        r1 = true;
        onPrepareOptionsMenu(r4);
    L10:
        return r1 | this.mChildFragmentManager.a(r4);
    }

    boolean performOptionsItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r4) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.a(r4);
    }

    boolean performContextItemSelected(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r4) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.b(r4);
    }

    void performOptionsMenuClosed(Menu r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.aiagent.plugin");
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.b(r4);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r4);
        goto L9
    }

    void performSaveInstanceState(Bundle r2) {
        onSaveInstanceState(r2);
        this.mSavedStateRegistryController.b(r2);
        Parcelable r1 = this.mChildFragmentManager.k();
        if (r1 == null) goto L6;
        r2.putParcelable("android:support:fragments", r1);
        return;
    }

    void performPause() {
        this.mChildFragmentManager.w();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.a(androidx.lifecycle.i.a.ON_PAUSE);
    L5:
        this.mLifecycleRegistry.a(androidx.lifecycle.i.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    void performStop() {
        this.mChildFragmentManager.x();
        if (this.mView == null) goto L5;
        this.mViewLifecycleOwner.a(androidx.lifecycle.i.a.ON_STOP);
    L5:
        this.mLifecycleRegistry.a(androidx.lifecycle.i.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled == false) goto L9;
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.y();
        if (this.mView != null) goto L5;
    L7:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L12;
        androidx.loader.a.a.a(this).a();
        this.mPerformedCreateView = false;
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().b().a(androidx.lifecycle.i.b.f2056c) == false) goto L7;
        this.mViewLifecycleOwner.a(androidx.lifecycle.i.a.ON_DESTROY);
        goto L7
    }

    void performDestroy() {
        this.mChildFragmentManager.z();
        this.mLifecycleRegistry.a(androidx.lifecycle.i.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled == false) goto L6;
        return;
    L6:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        if (this.mChildFragmentManager.g() == true) goto L10;
        this.mChildFragmentManager.z();
        this.mChildFragmentManager = new g();
        return;
    L10:
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    void setOnStartEnterTransitionListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        ensureAnimationInfo();
        if (r4 != this.mAnimationInfo.x) goto L5;
        return;
    L5:
        if (r4 == null) goto L12;
        if (this.mAnimationInfo.x == null) goto L12;
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
    L12:
        if (this.mAnimationInfo.w == false) goto L14;
        this.mAnimationInfo.x = r4;
    L14:
        if (r4 == null) goto L17;
        r4.b();
        return;
    }

    private a ensureAnimationInfo() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new a();
    L6:
        return this.mAnimationInfo;
    }

    void setAnimations(int r2, int r3, int r4, int r5) {
        if (this.mAnimationInfo != null) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        if (r5 != 0) goto L9;
        return;
    L9:
        ensureAnimationInfo().f1721d = r2;
        ensureAnimationInfo().f1722e = r3;
        ensureAnimationInfo().f = r4;
        ensureAnimationInfo().g = r5;
    }

    int getEnterAnim() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f1721d;
    }

    int getExitAnim() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f1722e;
    }

    int getPopEnterAnim() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f;
    }

    int getPopExitAnim() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.g;
    }

    boolean getPopDirection() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f1720c;
    }

    void setPopDirection(boolean r2) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        ensureAnimationInfo().f1720c = r2;
    }

    int getNextTransition() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.h;
    }

    void setNextTransition(int r2) {
        if (this.mAnimationInfo != null) goto L6;
        if (r2 != 0) goto L6;
        return;
    L6:
        ensureAnimationInfo();
        this.mAnimationInfo.h = r2;
    }

    ArrayList<String> getSharedElementSourceNames() {
        a r0 = this.mAnimationInfo;
        if (r0 == null) goto L10;
        if (r0.i == null) goto L10;
        return this.mAnimationInfo.i;
    L10:
        return new ArrayList();
    }

    ArrayList<String> getSharedElementTargetNames() {
        a r0 = this.mAnimationInfo;
        if (r0 == null) goto L10;
        if (r0.j == null) goto L10;
        return this.mAnimationInfo.j;
    L10:
        return new ArrayList();
    }

    void setSharedElementNames(ArrayList<String> r2, ArrayList<String> r3) {
        ensureAnimationInfo();
        this.mAnimationInfo.i = r2;
        this.mAnimationInfo.j = r3;
    }

    androidx.core.app.q getEnterTransitionCallback() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.s;
    }

    androidx.core.app.q getExitTransitionCallback() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.t;
    }

    View getAnimatingAway() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f1718a;
    }

    void setAnimatingAway(View r1) {
        ensureAnimationInfo().f1718a = r1;
    }

    void setAnimator(Animator r1) {
        ensureAnimationInfo().f1719b = r1;
    }

    Animator getAnimator() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f1719b;
    }

    void setPostOnViewCreatedAlpha(float r1) {
        ensureAnimationInfo().u = r1;
    }

    float getPostOnViewCreatedAlpha() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.u;
    }

    void setFocusedView(View r1) {
        ensureAnimationInfo().v = r1;
    }

    View getFocusedView() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.v;
    }

    boolean isPostponed() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.w;
    }

    boolean isHideReplaced() {
        a r0 = this.mAnimationInfo;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.y;
    }

    void setHideReplaced(boolean r1) {
        ensureAnimationInfo().y = r1;
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> r3, androidx.activity.result.a<O> r4) {
        androidx.activity.result.a<O> r5 = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
        return prepareCallInternal(r3, new AnonymousClass6(this), r5);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> r3, final androidx.activity.result.c r4, androidx.activity.result.a<O> r5) {
        androidx.activity.result.a<O> r6 = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
        return prepareCallInternal(r3, new AnonymousClass7(this, r4), r6);
    }

    private <I, O> androidx.activity.result.b<I> prepareCallInternal(final androidx.activity.result.a.a<I, O> r9, androidx.a.a.c.a<Void, androidx.activity.result.c> r10, androidx.activity.result.a<O> r11) {
        final androidx.a.a.c.a r4 = (androidx.a.a.c.a) ZeusTransformUtils.wrapperContextForParams(r10, androidx.a.a.c.a.class, "com.obric.aiagent.plugin");
        final androidx.activity.result.a r7 = (androidx.activity.result.a) ZeusTransformUtils.wrapperContextForParams(r11, androidx.activity.result.a.class, "com.obric.aiagent.plugin");
        if (this.mState > 1) goto L7;
        final AtomicReference r12 = new AtomicReference();
        registerOnPreAttachListener(new AnonymousClass8(this, r4, r12, r9, r7));
        return new AnonymousClass9(this, r12, r9);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(c r2) {
        if (this.mState < 0) goto L5;
        r2.a();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r2);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_fragment_app_Fragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_fragment_app_Fragment_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
