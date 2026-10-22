package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
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
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.AnimRes;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.core.app.AbstractC0242c;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.InterfaceC0321s;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import androidx.room.AbstractC0351g;
import b0.AbstractC0357c;
import b0.C0356b;
import b0.C0359e;
import b0.C0360f;
import b0.C0362h;
import b0.C0363i;
import b0.EnumC0355a;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import d.AbstractC0528b;
import d0.AbstractC0533c;
import d0.C0534d;
import e.EnumC0546d;
import e0.AbstractC0548a;
import j0.C0631f;
import j0.C0632g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import n.InterfaceC0773a;

/* loaded from: classes.dex */
public abstract class D implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.G, u0, InterfaceC0321s, j0.h {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    C0303z mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;

    @LayoutRes
    private int mContentLayoutId;
    androidx.lifecycle.q0 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    Y mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    L mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.I mLifecycleRegistry;
    D mParentFragment;
    boolean mPerformedCreateView;

    @Nullable
    @RestrictTo({EnumC0546d.f12492a})
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    C0632g mSavedStateRegistryController;

    @Nullable
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    D mTarget;
    int mTargetRequestCode;
    View mView;

    @Nullable
    n0 mViewLifecycleOwner;
    int mState = -1;

    @NonNull
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;

    @NonNull
    Y mChildFragmentManager = new Z();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new RunnableC0296s(this, 0);
    EnumC0327y mMaxState = EnumC0327y.f3987e;
    androidx.lifecycle.U mViewLifecycleOwnerLiveData = new androidx.lifecycle.U();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<B> mOnPreAttachedListeners = new ArrayList<>();
    private final B mSavedStateAttachListener = new C0297t(this);

    public D() {
        e();
    }

    @NonNull
    @Deprecated
    public static D instantiate(@NonNull Context context, @NonNull String str) {
        return instantiate(context, str, null);
    }

    public final C0303z b() {
        if (this.mAnimationInfo == null) {
            C0303z c0303z = new C0303z();
            c0303z.f3851i = null;
            Object obj = USE_DEFAULT_TRANSITION;
            c0303z.f3852j = obj;
            c0303z.f3853k = null;
            c0303z.f3854l = obj;
            c0303z.f3855m = null;
            c0303z.f3856n = obj;
            c0303z.f3859q = 1.0f;
            c0303z.f3860r = null;
            this.mAnimationInfo = c0303z;
        }
        return this.mAnimationInfo;
    }

    public final int c() {
        EnumC0327y enumC0327y = this.mMaxState;
        return (enumC0327y == EnumC0327y.f3984b || this.mParentFragment == null) ? enumC0327y.ordinal() : Math.min(enumC0327y.ordinal(), this.mParentFragment.c());
    }

    public void callStartTransitionListener(boolean z4) {
        ViewGroup viewGroup;
        Y y4;
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z != null) {
            c0303z.f3861s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (y4 = this.mFragmentManager) == null) {
            return;
        }
        r0 r0VarG = r0.g(viewGroup, y4);
        r0VarG.h();
        if (z4) {
            this.mHost.f3627c.post(new RunnableC0287i(1, this, r0VarG));
        } else {
            r0VarG.c();
        }
    }

    @NonNull
    public J createFragmentContainer() {
        return new C0298u(this);
    }

    public final D d(boolean z4) {
        String str;
        if (z4) {
            C0356b c0356b = AbstractC0357c.f4364a;
            Intrinsics.checkNotNullParameter(this, "fragment");
            C0360f c0360f = new C0360f(this, 1);
            AbstractC0357c.c(c0360f);
            C0356b c0356bA = AbstractC0357c.a(this);
            if (c0356bA.f4362a.contains(EnumC0355a.f4358g) && AbstractC0357c.e(c0356bA, getClass(), C0360f.class)) {
                AbstractC0357c.b(c0356bA, c0360f);
            }
        }
        D d4 = this.mTarget;
        if (d4 != null) {
            return d4;
        }
        Y y4 = this.mFragmentManager;
        if (y4 == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return y4.f3664c.b(str);
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        D d4 = d(false);
        if (d4 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(d4);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            AbstractC0548a.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + AwarenessDataItem.USERID_SPLITTER);
        this.mChildFragmentManager.u(AbstractC0351g.p(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final void e() {
        this.mLifecycleRegistry = new androidx.lifecycle.I(this);
        this.mSavedStateRegistryController = E3.b.e(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        B b4 = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            b4.a();
        } else {
            this.mOnPreAttachedListeners.add(b4);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public final androidx.activity.result.d f(AbstractC0528b abstractC0528b, InterfaceC0773a interfaceC0773a, androidx.activity.result.a aVar) {
        if (this.mState > 1) {
            throw new IllegalStateException(B0.g.l("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        C0302y c0302y = new C0302y(this, interfaceC0773a, atomicReference, abstractC0528b, aVar);
        if (this.mState >= 0) {
            c0302y.a();
        } else {
            this.mOnPreAttachedListeners.add(c0302y);
        }
        return new androidx.activity.result.d(this, atomicReference, abstractC0528b, 2);
    }

    @Nullable
    public D findFragmentByWho(@NonNull String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f3664c.c(str);
    }

    @NonNull
    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Nullable
    /* renamed from: getActivity, reason: merged with bridge method [inline-methods] */
    public final G a() {
        L l4 = this.mHost;
        if (l4 == null) {
            return null;
        }
        return (G) l4.f3625a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null || (bool = c0303z.f3858p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null || (bool = c0303z.f3857o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        c0303z.getClass();
        return null;
    }

    @Nullable
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @NonNull
    public final Y getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " has not been attached yet."));
    }

    @Nullable
    public Context getContext() {
        L l4 = this.mHost;
        if (l4 == null) {
            return null;
        }
        return l4.f3626b;
    }

    @Override // androidx.lifecycle.InterfaceC0321s
    @NonNull
    @CallSuper
    public AbstractC0533c getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        C0534d c0534d = new C0534d();
        if (application != null) {
            c0534d.b(androidx.lifecycle.o0.f3973a, application);
        }
        c0534d.b(androidx.lifecycle.h0.f3945a, this);
        c0534d.b(androidx.lifecycle.h0.f3946b, this);
        if (getArguments() != null) {
            c0534d.b(androidx.lifecycle.h0.f3947c, getArguments());
        }
        return c0534d;
    }

    @Override // androidx.lifecycle.InterfaceC0321s
    @NonNull
    public androidx.lifecycle.q0 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.k0(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    @AnimRes
    public int getEnterAnim() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return 0;
        }
        return c0303z.f3844b;
    }

    @Nullable
    public Object getEnterTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        return c0303z.f3851i;
    }

    public androidx.core.app.C getEnterTransitionCallback() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        c0303z.getClass();
        return null;
    }

    @AnimRes
    public int getExitAnim() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return 0;
        }
        return c0303z.f3845c;
    }

    @Nullable
    public Object getExitTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        return c0303z.f3853k;
    }

    public androidx.core.app.C getExitTransitionCallback() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        c0303z.getClass();
        return null;
    }

    public View getFocusedView() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        return c0303z.f3860r;
    }

    @Nullable
    @Deprecated
    public final Y getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        L l4 = this.mHost;
        if (l4 == null) {
            return null;
        }
        return ((F) l4).f3587e;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.G
    @NonNull
    public AbstractC0328z getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    @Deprecated
    public AbstractC0548a getLoaderManager() {
        return AbstractC0548a.a(this);
    }

    public int getNextTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return 0;
        }
        return c0303z.f3848f;
    }

    @Nullable
    public final D getParentFragment() {
        return this.mParentFragment;
    }

    @NonNull
    public final Y getParentFragmentManager() {
        Y y4 = this.mFragmentManager;
        if (y4 != null) {
            return y4;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return false;
        }
        return c0303z.f3843a;
    }

    @AnimRes
    public int getPopEnterAnim() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return 0;
        }
        return c0303z.f3846d;
    }

    @AnimRes
    public int getPopExitAnim() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return 0;
        }
        return c0303z.f3847e;
    }

    public float getPostOnViewCreatedAlpha() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return 1.0f;
        }
        return c0303z.f3859q;
    }

    @Nullable
    public Object getReenterTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        Object obj = c0303z.f3854l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        C0356b c0356b = AbstractC0357c.f4364a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        C0359e c0359e = new C0359e(this, 0);
        AbstractC0357c.c(c0359e);
        C0356b c0356bA = AbstractC0357c.a(this);
        if (c0356bA.f4362a.contains(EnumC0355a.f4356e) && AbstractC0357c.e(c0356bA, getClass(), C0359e.class)) {
            AbstractC0357c.b(c0356bA, c0359e);
        }
        return this.mRetainInstance;
    }

    @Nullable
    public Object getReturnTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        Object obj = c0303z.f3852j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // j0.h
    @NonNull
    public final C0631f getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f13127b;
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        return c0303z.f3855m;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return null;
        }
        Object obj = c0303z.f3856n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    @NonNull
    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        C0303z c0303z = this.mAnimationInfo;
        return (c0303z == null || (arrayList = c0303z.f3849g) == null) ? new ArrayList<>() : arrayList;
    }

    @NonNull
    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        C0303z c0303z = this.mAnimationInfo;
        return (c0303z == null || (arrayList = c0303z.f3850h) == null) ? new ArrayList<>() : arrayList;
    }

    @NonNull
    public final String getString(@StringRes int i4) {
        return getResources().getString(i4);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Nullable
    @Deprecated
    public final D getTargetFragment() {
        return d(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        C0356b c0356b = AbstractC0357c.f4364a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        C0360f c0360f = new C0360f(this, 0);
        AbstractC0357c.c(c0360f);
        C0356b c0356bA = AbstractC0357c.a(this);
        if (c0356bA.f4362a.contains(EnumC0355a.f4358g) && AbstractC0357c.e(c0356bA, getClass(), C0360f.class)) {
            AbstractC0357c.b(c0356bA, c0360f);
        }
        return this.mTargetRequestCode;
    }

    @NonNull
    public final CharSequence getText(@StringRes int i4) {
        return getResources().getText(i4);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    @NonNull
    @MainThread
    public androidx.lifecycle.G getViewLifecycleOwner() {
        n0 n0Var = this.mViewLifecycleOwner;
        if (n0Var != null) {
            return n0Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public androidx.lifecycle.P getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.u0
    @NonNull
    public t0 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (c() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.mFragmentManager.f3660M.f3710c;
        t0 t0Var = (t0) map.get(this.mWho);
        if (t0Var != null) {
            return t0Var;
        }
        t0 t0Var2 = new t0();
        map.put(this.mWho, t0Var2);
        return t0Var2;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({EnumC0546d.f12494c})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        e();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new Z();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (!this.mHidden) {
            Y y4 = this.mFragmentManager;
            if (y4 != null) {
                D d4 = this.mParentFragment;
                y4.getClass();
                if (d4 != null && d4.isHidden()) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public final boolean isMenuVisible() {
        D d4;
        return this.mMenuVisible && (this.mFragmentManager == null || (d4 = this.mParentFragment) == null || d4.isMenuVisible());
    }

    public boolean isPostponed() {
        C0303z c0303z = this.mAnimationInfo;
        if (c0303z == null) {
            return false;
        }
        return c0303z.f3861s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        Y y4 = this.mFragmentManager;
        if (y4 == null) {
            return false;
        }
        return y4.f3653F || y4.f3654G;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.K();
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i4 + " resultCode: " + i5 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        L l4 = this.mHost;
        Activity activity = l4 == null ? null : l4.f3625a;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull D d4) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.mCalled = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        Y y4 = this.mChildFragmentManager;
        if (y4.f3681t >= 1) {
            return;
        }
        y4.f3653F = false;
        y4.f3654G = false;
        y4.f3660M.f3713f = false;
        y4.t(1);
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int i4, boolean z4, int i5) {
        return null;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int i4, boolean z4, int i5) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @MainThread
    @Deprecated
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i4 = this.mContentLayoutId;
        if (i4 != 0) {
            return layoutInflater.inflate(i4, viewGroup, false);
        }
        return null;
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.mCalled = true;
    }

    @MainThread
    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @MainThread
    public void onHiddenChanged(boolean z4) {
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.mCalled = true;
        L l4 = this.mHost;
        Activity activity = l4 == null ? null : l4.f3625a;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z4) {
    }

    @MainThread
    @Deprecated
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @MainThread
    @Deprecated
    public void onOptionsMenuClosed(@NonNull Menu menu) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z4) {
    }

    @MainThread
    @Deprecated
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean z4) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.mCalled = true;
    }

    public abstract void onSaveInstanceState(Bundle bundle);

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.K();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        Y y4 = this.mChildFragmentManager;
        y4.f3653F = false;
        y4.f3654G = false;
        y4.f3660M.f3713f = false;
        y4.t(4);
    }

    public void performAttach() {
        Iterator<B> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f3626b);
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.f3675n.iterator();
        while (it2.hasNext()) {
            ((b0) it2.next()).a(this);
        }
        Y y4 = this.mChildFragmentManager;
        y4.f3653F = false;
        y4.f3654G = false;
        y4.f3660M.f3713f = false;
        y4.t(0);
    }

    public void performConfigurationChanged(@NonNull Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(@NonNull MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.i(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.K();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new C0299v(this));
        this.mSavedStateRegistryController.b(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.e(EnumC0326x.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z4 = true;
        }
        return z4 | this.mChildFragmentManager.j(menu, menuInflater);
    }

    public void performCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mChildFragmentManager.K();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new n0(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.f3789d != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        B0.f.r0(this.mView, this.mViewLifecycleOwner);
        View view = this.mView;
        n0 n0Var = this.mViewLifecycleOwner;
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, n0Var);
        com.airbnb.lottie.h.E(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.g(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.k();
        this.mLifecycleRegistry.e(EnumC0326x.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.t(1);
        if (this.mView != null) {
            n0 n0Var = this.mViewLifecycleOwner;
            n0Var.b();
            if (n0Var.f3789d.f3871d.a(EnumC0327y.f3985c)) {
                this.mViewLifecycleOwner.a(EnumC0326x.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        q.m mVar = AbstractC0548a.a(this).f12500b.f12498a;
        if (mVar.f13973c <= 0) {
            this.mPerformedCreateView = false;
        } else {
            B0.g.y(mVar.f13972b[0]);
            throw null;
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onDetach()"));
        }
        Y y4 = this.mChildFragmentManager;
        if (y4.f3655H) {
            return;
        }
        y4.k();
        this.mChildFragmentManager = new Z();
    }

    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z4) {
        onMultiWindowModeChanged(z4);
    }

    public boolean performOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.o(menuItem);
    }

    public void performOptionsMenuClosed(@NonNull Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.p(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.t(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0326x.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(EnumC0326x.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z4) {
        onPictureInPictureModeChanged(z4);
    }

    public boolean performPrepareOptionsMenu(@NonNull Menu menu) {
        boolean z4 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z4 = true;
        }
        return z4 | this.mChildFragmentManager.s(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zI = Y.I(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zI) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zI);
            onPrimaryNavigationFragmentChanged(zI);
            Y y4 = this.mChildFragmentManager;
            y4.Z();
            y4.q(y4.f3685x);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.K();
        this.mChildFragmentManager.x(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onResume()"));
        }
        androidx.lifecycle.I i4 = this.mLifecycleRegistry;
        EnumC0326x enumC0326x = EnumC0326x.ON_RESUME;
        i4.e(enumC0326x);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f3789d.e(enumC0326x);
        }
        Y y4 = this.mChildFragmentManager;
        y4.f3653F = false;
        y4.f3654G = false;
        y4.f3660M.f3713f = false;
        y4.t(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
        bundle.putParcelable("android:support:fragments", this.mChildFragmentManager.R());
    }

    public void performStart() {
        this.mChildFragmentManager.K();
        this.mChildFragmentManager.x(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.I i4 = this.mLifecycleRegistry;
        EnumC0326x enumC0326x = EnumC0326x.ON_START;
        i4.e(enumC0326x);
        if (this.mView != null) {
            this.mViewLifecycleOwner.f3789d.e(enumC0326x);
        }
        Y y4 = this.mChildFragmentManager;
        y4.f3653F = false;
        y4.f3654G = false;
        y4.f3660M.f3713f = false;
        y4.t(5);
    }

    public void performStop() {
        Y y4 = this.mChildFragmentManager;
        y4.f3654G = true;
        y4.f3660M.f3713f = true;
        y4.t(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0326x.ON_STOP);
        }
        this.mLifecycleRegistry.e(EnumC0326x.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.t(2);
    }

    public void postponeEnterTransition() {
        b().f3861s = true;
    }

    @NonNull
    @MainThread
    public final <I, O> androidx.activity.result.b registerForActivityResult(@NonNull AbstractC0528b abstractC0528b, @NonNull androidx.activity.result.a aVar) {
        return f(abstractC0528b, new C0300w(this), aVar);
    }

    public void registerForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] strArr, int i4) {
        if (this.mHost == null) {
            throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to Activity"));
        }
        Y parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f3650C == null) {
            parentFragmentManager.f3682u.getClass();
            return;
        }
        parentFragmentManager.f3651D.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i4));
        parentFragmentManager.f3650C.a(strArr);
    }

    @NonNull
    public final G requireActivity() {
        G gA = a();
        if (gA != null) {
            return gA;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to an activity."));
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " does not have any arguments."));
    }

    @NonNull
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to a context."));
    }

    @NonNull
    @Deprecated
    public final Y requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to a host."));
    }

    @NonNull
    public final D requireParentFragment() {
        D parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(B0.g.l("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(B0.g.l("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(@Nullable Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.Q(parcelable);
        Y y4 = this.mChildFragmentManager;
        y4.f3653F = false;
        y4.f3654G = false;
        y4.f3660M.f3713f = false;
        y4.t(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            n0 n0Var = this.mViewLifecycleOwner;
            n0Var.f3790e.b(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new s0(B0.g.l("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC0326x.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z4) {
        b().f3858p = Boolean.valueOf(z4);
    }

    public void setAllowReturnTransitionOverlap(boolean z4) {
        b().f3857o = Boolean.valueOf(z4);
    }

    public void setAnimations(@AnimRes int i4, @AnimRes int i5, @AnimRes int i6, @AnimRes int i7) {
        if (this.mAnimationInfo == null && i4 == 0 && i5 == 0 && i6 == 0 && i7 == 0) {
            return;
        }
        b().f3844b = i4;
        b().f3845c = i5;
        b().f3846d = i6;
        b().f3847e = i7;
    }

    public void setArguments(@Nullable Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(@Nullable androidx.core.app.C c4) {
        b().getClass();
    }

    public void setEnterTransition(@Nullable Object obj) {
        b().f3851i = obj;
    }

    public void setExitSharedElementCallback(@Nullable androidx.core.app.C c4) {
        b().getClass();
    }

    public void setExitTransition(@Nullable Object obj) {
        b().f3853k = obj;
    }

    public void setFocusedView(View view) {
        b().f3860r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z4) {
        if (this.mHasMenu != z4) {
            this.mHasMenu = z4;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((F) this.mHost).f3587e.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(@Nullable Fragment$SavedState fragment$SavedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (fragment$SavedState == null || (bundle = fragment$SavedState.f3588a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z4) {
        if (this.mMenuVisible != z4) {
            this.mMenuVisible = z4;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((F) this.mHost).f3587e.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i4) {
        if (this.mAnimationInfo == null && i4 == 0) {
            return;
        }
        b();
        this.mAnimationInfo.f3848f = i4;
    }

    public void setPopDirection(boolean z4) {
        if (this.mAnimationInfo == null) {
            return;
        }
        b().f3843a = z4;
    }

    public void setPostOnViewCreatedAlpha(float f4) {
        b().f3859q = f4;
    }

    public void setReenterTransition(@Nullable Object obj) {
        b().f3854l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z4) {
        C0356b c0356b = AbstractC0357c.f4364a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        C0359e c0359e = new C0359e(this, 1);
        AbstractC0357c.c(c0359e);
        C0356b c0356bA = AbstractC0357c.a(this);
        if (c0356bA.f4362a.contains(EnumC0355a.f4356e) && AbstractC0357c.e(c0356bA, getClass(), C0359e.class)) {
            AbstractC0357c.b(c0356bA, c0359e);
        }
        this.mRetainInstance = z4;
        Y y4 = this.mFragmentManager;
        if (y4 == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z4) {
            y4.f3660M.c(this);
        } else {
            y4.f3660M.f(this);
        }
    }

    public void setReturnTransition(@Nullable Object obj) {
        b().f3852j = obj;
    }

    public void setSharedElementEnterTransition(@Nullable Object obj) {
        b().f3855m = obj;
    }

    public void setSharedElementNames(@Nullable ArrayList<String> arrayList, @Nullable ArrayList<String> arrayList2) {
        b();
        C0303z c0303z = this.mAnimationInfo;
        c0303z.f3849g = arrayList;
        c0303z.f3850h = arrayList2;
    }

    public void setSharedElementReturnTransition(@Nullable Object obj) {
        b().f3856n = obj;
    }

    @Deprecated
    public void setTargetFragment(@Nullable D targetFragment, int i4) {
        if (targetFragment != null) {
            C0356b c0356b = AbstractC0357c.f4364a;
            Intrinsics.checkNotNullParameter(this, "violatingFragment");
            Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
            Intrinsics.checkNotNullParameter(this, "fragment");
            Intrinsics.checkNotNullParameter(targetFragment, "targetFragment");
            C0362h c0362h = new C0362h(1, this, "Attempting to set target fragment " + targetFragment + " with request code " + i4 + " for fragment " + this);
            AbstractC0357c.c(c0362h);
            C0356b c0356bA = AbstractC0357c.a(this);
            if (c0356bA.f4362a.contains(EnumC0355a.f4358g) && AbstractC0357c.e(c0356bA, getClass(), C0362h.class)) {
                AbstractC0357c.b(c0356bA, c0362h);
            }
        }
        Y y4 = this.mFragmentManager;
        Y y5 = targetFragment != null ? targetFragment.mFragmentManager : null;
        if (y4 != null && y5 != null && y4 != y5) {
            throw new IllegalArgumentException(B0.g.l("Fragment ", targetFragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (D d4 = targetFragment; d4 != null; d4 = d4.d(false)) {
            if (d4.equals(this)) {
                throw new IllegalArgumentException("Setting " + targetFragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (targetFragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || targetFragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = targetFragment;
        } else {
            this.mTargetWho = targetFragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i4;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z4) {
        C0356b c0356b = AbstractC0357c.f4364a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(this, "fragment");
        C0363i c0363i = new C0363i(this, "Attempting to set user visible hint to " + z4 + " for fragment " + this);
        AbstractC0357c.c(c0363i);
        C0356b c0356bA = AbstractC0357c.a(this);
        if (c0356bA.f4362a.contains(EnumC0355a.f4357f) && AbstractC0357c.e(c0356bA, getClass(), C0363i.class)) {
            AbstractC0357c.b(c0356bA, c0363i);
        }
        boolean z5 = false;
        if (!this.mUserVisibleHint && z4 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            Y y4 = this.mFragmentManager;
            c0 c0VarF = y4.f(this);
            D d4 = c0VarF.f3722c;
            if (d4.mDeferStart) {
                if (y4.f3663b) {
                    y4.f3656I = true;
                } else {
                    d4.mDeferStart = false;
                    c0VarF.j();
                }
            }
        }
        this.mUserVisibleHint = z4;
        if (this.mState < 5 && !z4) {
            z5 = true;
        }
        this.mDeferStart = z5;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z4);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        L l4 = this.mHost;
        if (l4 != null) {
            return AbstractC0242c.a(((F) l4).f3587e, str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i4) {
        startActivityForResult(intent, i4, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i4, @Nullable Intent intent, int i5, int i6, int i7, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2 = intent;
        if (this.mHost == null) {
            throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to Activity"));
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i4 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        Y parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f3649B == null) {
            L l4 = parentFragmentManager.f3682u;
            if (i4 == -1) {
                l4.f3625a.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
                return;
            } else {
                l4.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent2 == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent2, i5, i6);
        parentFragmentManager.f3651D.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i4));
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.f3649B.a(intentSenderRequest);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !b().f3861s) {
            return;
        }
        if (this.mHost == null) {
            b().f3861s = false;
        } else if (Looper.myLooper() != this.mHost.f3627c.getLooper()) {
            this.mHost.f3627c.postAtFrontOfQueue(new RunnableC0296s(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @NonNull
    @Deprecated
    public static D instantiate(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        try {
            D d4 = (D) T.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(d4.getClass().getClassLoader());
                d4.setArguments(bundle);
            }
            return d4;
        } catch (IllegalAccessException e4) {
            throw new A(B0.g.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), 0, e4);
        } catch (InstantiationException e5) {
            throw new A(B0.g.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), 0, e5);
        } catch (NoSuchMethodException e6) {
            throw new A(B0.g.n("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), 0, e6);
        } catch (InvocationTargetException e7) {
            throw new A(B0.g.n("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), 0, e7);
        }
    }

    @NonNull
    public final String getString(@StringRes int i4, @Nullable Object... objArr) {
        return getResources().getString(i4, objArr);
    }

    public final void postponeEnterTransition(long j4, @NonNull TimeUnit timeUnit) {
        b().f3861s = true;
        Y y4 = this.mFragmentManager;
        Handler handler = y4 != null ? y4.f3682u.f3627c : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j4));
    }

    @NonNull
    @MainThread
    public final <I, O> androidx.activity.result.b registerForActivityResult(@NonNull AbstractC0528b abstractC0528b, @NonNull androidx.activity.result.g gVar, @NonNull androidx.activity.result.a aVar) {
        return f(abstractC0528b, new C0301x(this, gVar), aVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, @Nullable Bundle bundle) {
        L l4 = this.mHost;
        if (l4 == null) {
            throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to Activity"));
        }
        l4.f3626b.startActivity(intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i4, @Nullable Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(B0.g.l("Fragment ", this, " not attached to Activity"));
        }
        Y parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f3648A == null) {
            L l4 = parentFragmentManager.f3682u;
            if (i4 == -1) {
                l4.f3626b.startActivity(intent, bundle);
                return;
            } else {
                l4.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        parentFragmentManager.f3651D.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i4));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        parentFragmentManager.f3648A.a(intent);
    }

    @NonNull
    @RestrictTo({EnumC0546d.f12494c})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        L l4 = this.mHost;
        if (l4 != null) {
            G g4 = ((F) l4).f3587e;
            LayoutInflater layoutInflaterCloneInContext = g4.getLayoutInflater().cloneInContext(g4);
            layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f3667f);
            return layoutInflaterCloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity activity) {
        this.mCalled = true;
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.mCalled = true;
    }
}
