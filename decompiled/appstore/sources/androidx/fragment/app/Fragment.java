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
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.AnimRes;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.o0;
import androidx.lifecycle.p0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
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

    @NonNull
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;

    @LayoutRes
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
    FragmentHostCallback mHost;
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
    Handler mPostponedHandler;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final OnPreAttachedListener mSavedStateAttachListener;
    SavedStateRegistryController mSavedStateRegistryController;

    @Nullable
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

    @Nullable
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData mViewLifecycleOwnerLiveData;

    @NonNull
    String mWho;

    public static class AnimationInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f3134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3140g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ArrayList f3141h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ArrayList f3142i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f3143j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f3144k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f3145l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f3146m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f3147n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f3148o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Boolean f3149p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Boolean f3150q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public SharedElementCallback f3151r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public SharedElementCallback f3152s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f3153t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public View f3154u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f3155v;

        public AnimationInfo() {
            this.f3143j = null;
            Object r10 = Fragment.USE_DEFAULT_TRANSITION;
            this.f3144k = r10;
            this.f3145l = null;
            this.f3146m = r10;
            this.f3147n = null;
            this.f3148o = r10;
            this.f3151r = null;
            this.f3152s = null;
            this.f3153t = 1.0f;
            this.f3154u = null;
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String r10, @Nullable Exception r11) {
            super(r10, r11);
        }
    }

    public static abstract class OnPreAttachedListener {
        public OnPreAttachedListener() {
        }

        public abstract void a();

        public /* synthetic */ OnPreAttachedListener(b r10) {
            this();
        }
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final Bundle mState;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Bundle r10) {
            this.mState = r10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            r10.writeBundle(this.mState);
        }

        public SavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            Bundle r12 = r10.readBundle();
            this.mState = r12;
            if (r11 == null) goto L7;
            if (r12 == null) goto L8;
            r12.setClassLoader(r11);
            return;
        L8:
            return;
        }
    }

    public class a extends ActivityResultLauncher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f3156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f3157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f3158c;

        public a(Fragment r10, AtomicReference r11, ActivityResultContract r12) {
            this.f3158c = r10;
            this.f3156a = r11;
            this.f3157b = r12;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void b(Object r10, androidx.core.app.b r11) {
            ActivityResultLauncher r12 = (ActivityResultLauncher) this.f3156a.get();
            if (r12 == null) goto L7;
            r12.b(r10, r11);
            return;
        L7:
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void c() {
            ActivityResultLauncher r10 = (ActivityResultLauncher) this.f3156a.getAndSet(null);
            if (r10 == null) goto L6;
            r10.c();
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3159a;

        public b(Fragment r10) {
            this.f3159a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3159a.startPostponedEnterTransition();
        }
    }

    public class c extends OnPreAttachedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3160a;

        public c(Fragment r10) {
            this.f3160a = r10;
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
        public void a() {
            this.f3160a.mSavedStateRegistryController.c();
            androidx.lifecycle.e0.c(this.f3160a);
            Bundle r10 = this.f3160a.mSavedFragmentState;
            if (r10 == null) goto L5;
            Bundle r11 = r10.getBundle("registryState");
        L6:
            this.f3160a.mSavedStateRegistryController.d(r11);
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3161a;

        public d(Fragment r10) {
            this.f3161a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3161a.callStartTransitionListener(false);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController f3162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f3163b;

        public e(Fragment r10, SpecialEffectsController r11) {
            this.f3163b = r10;
            this.f3162a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3162a.k();
        }
    }

    public class f extends FragmentContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3164a;

        public f(Fragment r10) {
            this.f3164a = r10;
        }

        @Override // androidx.fragment.app.FragmentContainer
        public View b(int r10) {
            View r11 = this.f3164a.mView;
            if (r11 == null) goto L7;
            return r11.findViewById(r10);
        L7:
            throw new IllegalStateException("Fragment " + this.f3164a + " does not have a view");
        }

        @Override // androidx.fragment.app.FragmentContainer
        public boolean c() {
            if (this.f3164a.mView == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public class g implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3165a;

        public g(Fragment r10) {
            this.f3165a = r10;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (r11 != Lifecycle.Event.ON_STOP) goto L8;
            View r12 = this.f3165a.mView;
            if (r12 == null) goto L9;
            k.a(r12);
            return;
        L9:
            return;
        }
    }

    public class h implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3166a;

        public h(Fragment r10) {
            this.f3166a = r10;
        }

        public ActivityResultRegistry a(Void r10) {
            Fragment r11 = this.f3166a;
            Object r12 = r11.mHost;
            if ((r12 instanceof ActivityResultRegistryOwner) == false) goto L7;
            return ((ActivityResultRegistryOwner) r12).getActivityResultRegistry();
        L7:
            return r11.requireActivity().getActivityResultRegistry();
        }

        @Override // androidx.arch.core.util.Function
        public /* bridge */ /* synthetic */ Object apply(Object r10) {
            return a((Void) r10);
        }
    }

    public class i implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f3167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f3168b;

        public i(Fragment r10, ActivityResultRegistry r11) {
            this.f3168b = r10;
            this.f3167a = r11;
        }

        public ActivityResultRegistry a(Void r10) {
            return this.f3167a;
        }

        @Override // androidx.arch.core.util.Function
        public /* bridge */ /* synthetic */ Object apply(Object r10) {
            return a((Void) r10);
        }
    }

    public class j extends OnPreAttachedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f3169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f3170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ActivityResultContract f3171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ActivityResultCallback f3172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Fragment f3173e;

        public j(Fragment r10, Function r11, AtomicReference r12, ActivityResultContract r13, ActivityResultCallback r14) {
            this.f3173e = r10;
            this.f3169a = r11;
            this.f3170b = r12;
            this.f3171c = r13;
            this.f3172d = r14;
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
        public void a() {
            String r10 = this.f3173e.generateActivityResultKey();
            ActivityResultRegistry r11 = (ActivityResultRegistry) this.f3169a.apply(null);
            this.f3170b.set(r11.j(r10, this.f3173e, this.f3171c, this.f3172d));
        }
    }

    public static class k {
        public static void a(View r10) {
            r10.cancelPendingInputEvents();
        }
    }

    static {
        USE_DEFAULT_TRANSITION = new Object();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new x();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new b(this);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        this.mSavedStateAttachListener = new c(this);
        e();
    }

    public static /* synthetic */ void a(Fragment r10) {
        r10.f();
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r10, @NonNull String r11) {
        return instantiate(r10, r11, null);
    }

    private void registerOnPreAttachListener(@NonNull OnPreAttachedListener r10) {
        if (this.mState < 0) goto L5;
        r10.a();
        return;
    L5:
        this.mOnPreAttachedListeners.add(r10);
    }

    public final AnimationInfo b() {
        if (this.mAnimationInfo != null) goto L6;
        this.mAnimationInfo = new AnimationInfo();
    L6:
        return this.mAnimationInfo;
    }

    public final int c() {
        Lifecycle.State r10 = this.mMaxState;
        if (r10 == Lifecycle.State.INITIALIZED) goto L10;
        if (this.mParentFragment == null) goto L10;
        return Math.min(r10.ordinal(), this.mParentFragment.c());
    L10:
        return r10.ordinal();
    }

    public void callStartTransitionListener(boolean r10) {
        AnimationInfo r11 = this.mAnimationInfo;
        if (r11 == null) goto L6;
        r11.f3155v = false;
    L6:
        if (this.mView == null) goto L19;
        ViewGroup r12 = this.mContainer;
        if (r12 == null) goto L20;
        FragmentManager r13 = this.mFragmentManager;
        if (r13 == null) goto L21;
        SpecialEffectsController r14 = SpecialEffectsController.r(r12, r13);
        r14.t();
        if (r10 == false) goto L14;
        this.mHost.f().post(new e(this, r14));
    L15:
        Handler r15 = this.mPostponedHandler;
        if (r15 == null) goto L22;
        r15.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler = null;
        return;
    L22:
        return;
    L14:
        r14.k();
        goto L15
    L21:
        return;
    L20:
        return;
    }

    @NonNull
    public FragmentContainer createFragmentContainer() {
        return new f(this);
    }

    public final Fragment d(boolean r10) {
        if (r10 == false) goto L4;
        FragmentStrictMode.l(this);
    L4:
        Fragment r11 = this.mTarget;
        if (r11 == null) goto L7;
        return r11;
    L7:
        FragmentManager r12 = this.mFragmentManager;
        if (r12 == null) goto L13;
        String r13 = this.mTargetWho;
        if (r13 != null) goto L12;
        return null;
    L12:
        return r12.f0(r13);
    L13:
        return null;
    }

    public void dump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
        r12.print(r10);
        r12.print("mFragmentId=#");
        r12.print(Integer.toHexString(this.mFragmentId));
        r12.print(" mContainerId=#");
        r12.print(Integer.toHexString(this.mContainerId));
        r12.print(" mTag=");
        r12.println(this.mTag);
        r12.print(r10);
        r12.print("mState=");
        r12.print(this.mState);
        r12.print(" mWho=");
        r12.print(this.mWho);
        r12.print(" mBackStackNesting=");
        r12.println(this.mBackStackNesting);
        r12.print(r10);
        r12.print("mAdded=");
        r12.print(this.mAdded);
        r12.print(" mRemoving=");
        r12.print(this.mRemoving);
        r12.print(" mFromLayout=");
        r12.print(this.mFromLayout);
        r12.print(" mInLayout=");
        r12.println(this.mInLayout);
        r12.print(r10);
        r12.print("mHidden=");
        r12.print(this.mHidden);
        r12.print(" mDetached=");
        r12.print(this.mDetached);
        r12.print(" mMenuVisible=");
        r12.print(this.mMenuVisible);
        r12.print(" mHasMenu=");
        r12.println(this.mHasMenu);
        r12.print(r10);
        r12.print("mRetainInstance=");
        r12.print(this.mRetainInstance);
        r12.print(" mUserVisibleHint=");
        r12.println(this.mUserVisibleHint);
        if (this.mFragmentManager == null) goto L6;
        r12.print(r10);
        r12.print("mFragmentManager=");
        r12.println(this.mFragmentManager);
    L6:
        if (this.mHost == null) goto L9;
        r12.print(r10);
        r12.print("mHost=");
        r12.println(this.mHost);
    L9:
        if (this.mParentFragment == null) goto L12;
        r12.print(r10);
        r12.print("mParentFragment=");
        r12.println(this.mParentFragment);
    L12:
        if (this.mArguments == null) goto L15;
        r12.print(r10);
        r12.print("mArguments=");
        r12.println(this.mArguments);
    L15:
        if (this.mSavedFragmentState == null) goto L18;
        r12.print(r10);
        r12.print("mSavedFragmentState=");
        r12.println(this.mSavedFragmentState);
    L18:
        if (this.mSavedViewState == null) goto L21;
        r12.print(r10);
        r12.print("mSavedViewState=");
        r12.println(this.mSavedViewState);
    L21:
        if (this.mSavedViewRegistryState == null) goto L23;
        r12.print(r10);
        r12.print("mSavedViewRegistryState=");
        r12.println(this.mSavedViewRegistryState);
    L23:
        Fragment r14 = d(false);
        if (r14 == null) goto L26;
        r12.print(r10);
        r12.print("mTarget=");
        r12.print(r14);
        r12.print(" mTargetRequestCode=");
        r12.println(this.mTargetRequestCode);
    L26:
        r12.print(r10);
        r12.print("mPopDirection=");
        r12.println(getPopDirection());
        if (getEnterAnim() == 0) goto L30;
        r12.print(r10);
        r12.print("getEnterAnim=");
        r12.println(getEnterAnim());
    L30:
        if (getExitAnim() == 0) goto L33;
        r12.print(r10);
        r12.print("getExitAnim=");
        r12.println(getExitAnim());
    L33:
        if (getPopEnterAnim() == 0) goto L36;
        r12.print(r10);
        r12.print("getPopEnterAnim=");
        r12.println(getPopEnterAnim());
    L36:
        if (getPopExitAnim() == 0) goto L39;
        r12.print(r10);
        r12.print("getPopExitAnim=");
        r12.println(getPopExitAnim());
    L39:
        if (this.mContainer == null) goto L42;
        r12.print(r10);
        r12.print("mContainer=");
        r12.println(this.mContainer);
    L42:
        if (this.mView == null) goto L45;
        r12.print(r10);
        r12.print("mView=");
        r12.println(this.mView);
    L45:
        if (getAnimatingAway() == null) goto L48;
        r12.print(r10);
        r12.print("mAnimatingAway=");
        r12.println(getAnimatingAway());
    L48:
        if (getContext() == null) goto L50;
        LoaderManager.b(this).a(r10, r11, r12, r13);
    L50:
        r12.print(r10);
        r12.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.W(r10 + "  ", r11, r12, r13);
    }

    public final void e() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.a(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener) == true) goto L6;
        registerOnPreAttachListener(this.mSavedStateAttachListener);
        return;
    }

    public final boolean equals(@Nullable Object r10) {
        return super.equals(r10);
    }

    public final /* synthetic */ void f() {
        this.mViewLifecycleOwner.c(this.mSavedViewRegistryState);
        this.mSavedViewRegistryState = null;
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String r10) {
        if (r10.equals(this.mWho) == false) goto L6;
        return this;
    L6:
        return this.mChildFragmentManager.j0(r10);
    }

    public final ActivityResultLauncher g(ActivityResultContract r10, Function r11, ActivityResultCallback r12) {
        if (this.mState > 1) goto L7;
        AtomicReference r13 = new AtomicReference();
        registerOnPreAttachListener(new j(this, r11, r13, r10, r12));
        return new a(this, r13, r10);
    L7:
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    @NonNull
    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback r10 = this.mHost;
        if (r10 != null) goto L6;
        return null;
    L6:
        return (FragmentActivity) r10.d();
    }

    public boolean getAllowEnterTransitionOverlap() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L8;
        Boolean r11 = r10.f3150q;
        if (r11 == null) goto L8;
        return r11.booleanValue();
    L8:
        return true;
    }

    public boolean getAllowReturnTransitionOverlap() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L8;
        Boolean r11 = r10.f3149p;
        if (r11 == null) goto L8;
        return r11.booleanValue();
    L8:
        return true;
    }

    public View getAnimatingAway() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3134a;
    }

    @Nullable
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) goto L7;
        return this.mChildFragmentManager;
    L7:
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback r10 = this.mHost;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.e();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    @CallSuper
    public CreationExtras getDefaultViewModelCreationExtras() {
        Context r10 = requireContext().getApplicationContext();
    L4:
        if ((r10 instanceof ContextWrapper) == false) goto L9;
        if ((r10 instanceof Application) == true) goto L7;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L4
    L7:
        Application r11 = (Application) r10;
    L10:
        if (r11 == null) goto L12;
    L14:
        androidx.lifecycle.viewmodel.a r12 = new androidx.lifecycle.viewmodel.a();
        if (r11 == null) goto L17;
        r12.c(ViewModelProvider.a.f3486g, r11);
    L17:
        r12.c(androidx.lifecycle.e0.f3520a, this);
        r12.c(androidx.lifecycle.e0.f3521b, this);
        if (getArguments() == null) goto L20;
        r12.c(androidx.lifecycle.e0.f3522c, getArguments());
    L20:
        return r12;
    L12:
        if (FragmentManager.L0(3) == false) goto L14;
        Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L14
    L9:
        r11 = null;
        goto L10
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager == null) goto L22;
        if (this.mDefaultFactory != null) goto L20;
        Context r10 = requireContext().getApplicationContext();
    L8:
        if ((r10 instanceof ContextWrapper) == false) goto L13;
        if ((r10 instanceof Application) == true) goto L11;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L8
    L11:
        Application r11 = (Application) r10;
    L14:
        if (r11 == null) goto L16;
    L18:
        this.mDefaultFactory = new androidx.lifecycle.g0(r11, this, getArguments());
        goto L20
    L16:
        if (FragmentManager.L0(3) == false) goto L18;
        Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
        goto L18
    L13:
        r11 = null;
    L20:
        return this.mDefaultFactory;
    L22:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @AnimRes
    public int getEnterAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.f3136c;
    }

    @Nullable
    public Object getEnterTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3143j;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3151r;
    }

    @AnimRes
    public int getExitAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.f3137d;
    }

    @Nullable
    public Object getExitTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3145l;
    }

    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3152s;
    }

    public View getFocusedView() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3154u;
    }

    @Nullable
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback r10 = this.mHost;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.h();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater r10 = this.mLayoutInflater;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return performGetLayoutInflater(null);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.b(this);
    }

    public int getNextTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.f3140g;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager r10 = this.mFragmentManager;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public boolean getPopDirection() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f3135b;
    }

    @AnimRes
    public int getPopEnterAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.f3138e;
    }

    @AnimRes
    public int getPopExitAnim() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.f3139f;
    }

    public float getPostOnViewCreatedAlpha() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return 1.0f;
    L7:
        return r10.f3153t;
    }

    @Nullable
    public Object getReenterTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        Object r11 = r10.f3146m;
        if (r11 == USE_DEFAULT_TRANSITION) goto L9;
        return r11;
    L9:
        return getExitTransition();
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.j(this);
        return this.mRetainInstance;
    }

    @Nullable
    public Object getReturnTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        Object r11 = r10.f3144k;
        if (r11 == USE_DEFAULT_TRANSITION) goto L9;
        return r11;
    L9:
        return getEnterTransition();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f3147n;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        Object r11 = r10.f3148o;
        if (r11 == USE_DEFAULT_TRANSITION) goto L9;
        return r11;
    L9:
        return getSharedElementEnterTransition();
    }

    @NonNull
    public ArrayList<String> getSharedElementSourceNames() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L9;
        ArrayList<String> r11 = r10.f3141h;
        if (r11 == null) goto L9;
        return r11;
    L9:
        return new ArrayList();
    }

    @NonNull
    public ArrayList<String> getSharedElementTargetNames() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 == null) goto L9;
        ArrayList<String> r11 = r10.f3142i;
        if (r11 == null) goto L9;
        return r11;
    L9:
        return new ArrayList();
    }

    @NonNull
    public final String getString(@StringRes int r10) {
        return getResources().getString(r10);
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    @Nullable
    @Deprecated
    public final Fragment getTargetFragment() {
        return d(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.k(this);
        return this.mTargetRequestCode;
    }

    @NonNull
    public final CharSequence getText(@StringRes int r10) {
        return getResources().getText(r10);
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
    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner r10 = this.mViewLifecycleOwner;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner for " + this + " when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) goto L11;
        if (c() == Lifecycle.State.INITIALIZED.ordinal()) goto L9;
        return this.mFragmentManager.G0(this);
    L9:
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    L11:
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final void h() {
        if (FragmentManager.L0(3) == false) goto L6;
        Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
    L6:
        if (this.mView == null) goto L12;
        Bundle r10 = this.mSavedFragmentState;
        if (r10 == null) goto L10;
        Bundle r11 = r10.getBundle("savedInstanceState");
    L11:
        restoreViewState(r11);
        goto L12
    L10:
        r11 = null;
    L12:
        this.mSavedFragmentState = null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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
        this.mChildFragmentManager = new x();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
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

    public final boolean isHidden() {
        if (this.mHidden == true) goto L10;
        FragmentManager r10 = this.mFragmentManager;
        if (r10 != null) goto L7;
    L9:
        return false;
    L7:
        if (r10.O0(this.mParentFragment) == false) goto L9;
    L10:
        return true;
    }

    public final boolean isInBackStack() {
        if (this.mBackStackNesting <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        if (this.mMenuVisible == false) goto L9;
        FragmentManager r10 = this.mFragmentManager;
        if (r10 != null) goto L7;
    L8:
        return true;
    L7:
        if (r10.P0(this.mParentFragment) == true) goto L8;
    L9:
        return false;
    }

    public boolean isPostponed() {
        AnimationInfo r10 = this.mAnimationInfo;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f3155v;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        if (this.mState < 7) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isStateSaved() {
        FragmentManager r10 = this.mFragmentManager;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.S0();
    }

    public final boolean isVisible() {
        if (isAdded() == true) goto L5;
    L13:
        return false;
    L5:
        if (isHidden() == true) goto L13;
        View r10 = this.mView;
        if (r10 == null) goto L13;
        if (r10.getWindowToken() == null) goto L13;
        if (this.mView.getVisibility() != 0) goto L13;
        return true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.c1();
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle r10) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int r10, int r11, @Nullable Intent r12) {
        if (FragmentManager.L0(2) == false) goto L6;
        Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + r10 + " resultCode: " + r11 + " data: " + r12);
        return;
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context r10) {
        this.mCalled = true;
        FragmentHostCallback r11 = this.mHost;
        if (r11 != null) goto L5;
        Activity r12 = null;
    L6:
        if (r12 == null) goto L9;
        this.mCalled = false;
        onAttach(r12);
        return;
    L9:
        return;
    L5:
        r12 = r11.d();
        goto L6
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment r10) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration r10) {
        this.mCalled = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem r10) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle r10) {
        this.mCalled = true;
        restoreChildFragmentState();
        if (this.mChildFragmentManager.R0(1) == true) goto L6;
        this.mChildFragmentManager.B();
        return;
    }

    @Nullable
    @MainThread
    public Animation onCreateAnimation(int r10, boolean r11, int r12) {
        return null;
    }

    @Nullable
    @MainThread
    public Animator onCreateAnimator(int r10, boolean r11, int r12) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu r10, @NonNull View r11, @Nullable ContextMenu.ContextMenuInfo r12) {
        requireActivity().onCreateContextMenu(r10, r11, r12);
    }

    @MainThread
    @Deprecated
    public void onCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
    }

    @Nullable
    @MainThread
    public View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        int r13 = this.mContentLayoutId;
        if (r13 != 0) goto L5;
        return null;
    L5:
        return r10.inflate(r13, r11, false);
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

    @CallSuper
    @MainThread
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.mCalled = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r10) {
        return getLayoutInflater(r10);
    }

    @MainThread
    public void onHiddenChanged(boolean r10) {
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context r10, @NonNull AttributeSet r11, @Nullable Bundle r12) {
        this.mCalled = true;
        FragmentHostCallback r13 = this.mHost;
        if (r13 != null) goto L5;
        Activity r14 = null;
    L6:
        if (r14 == null) goto L9;
        this.mCalled = false;
        onInflate(r14, r11, r12);
        return;
    L9:
        return;
    L5:
        r14 = r13.d();
        goto L6
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean r10) {
    }

    @MainThread
    @Deprecated
    public boolean onOptionsItemSelected(@NonNull MenuItem r10) {
        return false;
    }

    @MainThread
    @Deprecated
    public void onOptionsMenuClosed(@NonNull Menu r10) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean r10) {
    }

    @MainThread
    @Deprecated
    public void onPrepareOptionsMenu(@NonNull Menu r10) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean r10) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int r10, @NonNull String[] r11, @NonNull int[] r12) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.mCalled = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r10) {
    }

    @CallSuper
    @MainThread
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    @MainThread
    public void onStop() {
        this.mCalled = true;
    }

    @MainThread
    public void onViewCreated(@NonNull View r10, @Nullable Bundle r11) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r10) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle r10) {
        this.mChildFragmentManager.c1();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(r10);
        if (this.mCalled == false) goto L7;
        h();
        this.mChildFragmentManager.x();
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void performAttach() {
        Iterator<OnPreAttachedListener> r10 = this.mOnPreAttachedListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().a();
        goto L4
    L6:
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.m(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.e());
        if (this.mCalled == false) goto L11;
        this.mFragmentManager.H(this);
        this.mChildFragmentManager.y();
        return;
    L11:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    public void performConfigurationChanged(@NonNull Configuration r10) {
        onConfigurationChanged(r10);
    }

    public boolean performContextItemSelected(@NonNull MenuItem r10) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (onContextItemSelected(r10) == false) goto L9;
        return true;
    L9:
        return this.mChildFragmentManager.A(r10);
    }

    public void performCreate(Bundle r10) {
        this.mChildFragmentManager.c1();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new g(this));
        onCreate(r10);
        this.mIsCreated = true;
        if (this.mCalled == false) goto L7;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L7:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean performCreateOptionsMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
        boolean r12 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onCreateOptionsMenu(r10, r11);
        r12 = true;
    L10:
        return r12 | this.mChildFragmentManager.C(r10, r11);
    }

    public void performCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        this.mChildFragmentManager.c1();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore(), new androidx.fragment.app.j(this));
        View r13 = onCreateView(r10, r11, r12);
        this.mView = r13;
        if (r13 == null) goto L9;
        this.mViewLifecycleOwner.a();
        if (FragmentManager.L0(3) == false) goto L7;
        Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.mView + " for Fragment " + this);
    L7:
        o0.a(this.mView, this.mViewLifecycleOwner);
        p0.a(this.mView, this.mViewLifecycleOwner);
        androidx.savedstate.c.a(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.p(this.mViewLifecycleOwner);
        return;
    L9:
        if (this.mViewLifecycleOwner.b() == true) goto L13;
        this.mViewLifecycleOwner = null;
        return;
    L13:
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.D();
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
        this.mChildFragmentManager.E();
        if (this.mView != null) goto L5;
    L7:
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled == false) goto L12;
        LoaderManager.b(this).c();
        this.mPerformedCreateView = false;
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    L5:
        if (this.mViewLifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        goto L7
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled == false) goto L9;
        if (this.mChildFragmentManager.K0() == true) goto L10;
        this.mChildFragmentManager.D();
        this.mChildFragmentManager = new x();
        return;
    L10:
        return;
    L9:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle r10) {
        LayoutInflater r11 = onGetLayoutInflater(r10);
        this.mLayoutInflater = r11;
        return r11;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean r10) {
        onMultiWindowModeChanged(r10);
    }

    public boolean performOptionsItemSelected(@NonNull MenuItem r10) {
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L13;
        if (this.mMenuVisible == false) goto L13;
        if (onOptionsItemSelected(r10) == false) goto L13;
        return true;
    L13:
        return this.mChildFragmentManager.J(r10);
    }

    public void performOptionsMenuClosed(@NonNull Menu r10) {
        if (this.mHidden == false) goto L5;
        return;
    L5:
        if (this.mHasMenu == true) goto L7;
    L9:
        this.mChildFragmentManager.K(r10);
        return;
    L7:
        if (this.mMenuVisible == false) goto L9;
        onOptionsMenuClosed(r10);
        goto L9
    }

    public void performPause() {
        this.mChildFragmentManager.M();
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

    public void performPictureInPictureModeChanged(boolean r10) {
        onPictureInPictureModeChanged(r10);
    }

    public boolean performPrepareOptionsMenu(@NonNull Menu r10) {
        boolean r11 = false;
        if (this.mHidden == false) goto L5;
        return false;
    L5:
        if (this.mHasMenu == false) goto L10;
        if (this.mMenuVisible == false) goto L10;
        onPrepareOptionsMenu(r10);
        r11 = true;
    L10:
        return r11 | this.mChildFragmentManager.O(r10);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean r10 = this.mFragmentManager.Q0(this);
        Boolean r11 = this.mIsPrimaryNavigationFragment;
        if (r11 != null) goto L5;
    L6:
        this.mIsPrimaryNavigationFragment = Boolean.valueOf(r10);
        onPrimaryNavigationFragmentChanged(r10);
        this.mChildFragmentManager.P();
        return;
    L5:
        if (r11.booleanValue() != r10) goto L6;
    }

    public void performResume() {
        this.mChildFragmentManager.c1();
        this.mChildFragmentManager.a0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r10 = this.mLifecycleRegistry;
        Lifecycle.Event r11 = Lifecycle.Event.ON_RESUME;
        r10.handleLifecycleEvent(r11);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r11);
    L7:
        this.mChildFragmentManager.Q();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    public void performSaveInstanceState(Bundle r10) {
        onSaveInstanceState(r10);
    }

    public void performStart() {
        this.mChildFragmentManager.c1();
        this.mChildFragmentManager.a0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled == false) goto L10;
        LifecycleRegistry r10 = this.mLifecycleRegistry;
        Lifecycle.Event r11 = Lifecycle.Event.ON_START;
        r10.handleLifecycleEvent(r11);
        if (this.mView == null) goto L7;
        this.mViewLifecycleOwner.handleLifecycleEvent(r11);
    L7:
        this.mChildFragmentManager.R();
        return;
    L10:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    public void performStop() {
        this.mChildFragmentManager.T();
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
        Bundle r10 = this.mSavedFragmentState;
        if (r10 == null) goto L5;
        Bundle r11 = r10.getBundle("savedInstanceState");
    L6:
        onViewCreated(this.mView, r11);
        this.mChildFragmentManager.U();
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void postponeEnterTransition() {
        b().f3155v = true;
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher registerForActivityResult(@NonNull ActivityResultContract r10, @NonNull ActivityResultCallback<O> r11) {
        return g(r10, new h(this), r11);
    }

    public void registerForContextMenu(@NonNull View r10) {
        r10.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] r10, int r11) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().Y0(this, r10, r11);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle r10 = getArguments();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @NonNull
    public final Context requireContext() {
        Context r10 = getContext();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object r10 = getHost();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment r10 = getParentFragment();
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (getContext() != null) goto L9;
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
    L9:
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View r10 = getView();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void restoreChildFragmentState() {
        Bundle r10 = this.mSavedFragmentState;
        if (r10 == null) goto L8;
        Bundle r11 = r10.getBundle("childFragmentManager");
        if (r11 == null) goto L9;
        this.mChildFragmentManager.u1(r11);
        this.mChildFragmentManager.B();
        return;
    L9:
        return;
    }

    public final void restoreViewState(Bundle r10) {
        SparseArray<Parcelable> r11 = this.mSavedViewState;
        if (r11 == null) goto L5;
        this.mView.restoreHierarchyState(r11);
        this.mSavedViewState = null;
    L5:
        this.mCalled = false;
        onViewStateRestored(r10);
        if (this.mCalled == false) goto L12;
        if (this.mView == null) goto L13;
        this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L13:
        return;
    L12:
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public void setAllowEnterTransitionOverlap(boolean r10) {
        AnimationInfo r11 = b();
        r11.f3150q = Boolean.valueOf(r10);
    }

    public void setAllowReturnTransitionOverlap(boolean r10) {
        AnimationInfo r11 = b();
        r11.f3149p = Boolean.valueOf(r10);
    }

    public void setAnimations(@AnimRes int r10, @AnimRes int r11, @AnimRes int r12, @AnimRes int r13) {
        if (this.mAnimationInfo != null) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        if (r13 != 0) goto L9;
        return;
    L9:
        b().f3136c = r10;
        b().f3137d = r11;
        b().f3138e = r12;
        b().f3139f = r13;
    }

    public void setArguments(@Nullable Bundle r10) {
        if (this.mFragmentManager != null) goto L5;
    L9:
        this.mArguments = r10;
        return;
    L5:
        if (isStateSaved() == false) goto L9;
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback r10) {
        b().f3151r = r10;
    }

    public void setEnterTransition(@Nullable Object r10) {
        b().f3143j = r10;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback r10) {
        b().f3152s = r10;
    }

    public void setExitTransition(@Nullable Object r10) {
        b().f3145l = r10;
    }

    public void setFocusedView(View r10) {
        b().f3154u = r10;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean r10) {
        if (this.mHasMenu == r10) goto L10;
        this.mHasMenu = r10;
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (isHidden() == true) goto L12;
        this.mHost.n();
        return;
    L12:
        return;
    }

    public void setInitialSavedState(@Nullable SavedState r10) {
        if (this.mFragmentManager != null) goto L12;
        if (r10 == null) goto L8;
        Bundle r11 = r10.mState;
        if (r11 == null) goto L8;
    L9:
        this.mSavedFragmentState = r11;
        return;
    L8:
        r11 = null;
        goto L9
    L12:
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean r10) {
        if (this.mMenuVisible == r10) goto L12;
        this.mMenuVisible = r10;
        if (this.mHasMenu == true) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (isHidden() == true) goto L15;
        this.mHost.n();
        return;
    L15:
        return;
    }

    public void setNextTransition(int r10) {
        if (this.mAnimationInfo != null) goto L6;
        if (r10 != 0) goto L6;
        return;
    L6:
        b();
        this.mAnimationInfo.f3140g = r10;
    }

    public void setPopDirection(boolean r10) {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        b().f3135b = r10;
    }

    public void setPostOnViewCreatedAlpha(float r10) {
        b().f3153t = r10;
    }

    public void setReenterTransition(@Nullable Object r10) {
        b().f3146m = r10;
    }

    @Deprecated
    public void setRetainInstance(boolean r10) {
        FragmentStrictMode.m(this);
        this.mRetainInstance = r10;
        FragmentManager r11 = this.mFragmentManager;
        if (r11 == null) goto L7;
        if (r10 == false) goto L6;
        r11.k(this);
        return;
    L6:
        r11.q1(this);
        return;
    L7:
        this.mRetainInstanceChangedWhileDetached = true;
    }

    public void setReturnTransition(@Nullable Object r10) {
        b().f3144k = r10;
    }

    public void setSharedElementEnterTransition(@Nullable Object r10) {
        b().f3147n = r10;
    }

    public void setSharedElementNames(@Nullable ArrayList<String> r10, @Nullable ArrayList<String> r11) {
        b();
        AnimationInfo r12 = this.mAnimationInfo;
        r12.f3141h = r10;
        r12.f3142i = r11;
    }

    public void setSharedElementReturnTransition(@Nullable Object r10) {
        b().f3148o = r10;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment r10, int r11) {
        if (r10 == null) goto L4;
        FragmentStrictMode.n(this, r10, r11);
    L4:
        FragmentManager r12 = this.mFragmentManager;
        if (r10 == null) goto L7;
        FragmentManager r13 = r10.mFragmentManager;
    L8:
        if (r12 == null) goto L14;
        if (r13 == null) goto L14;
        if (r12 == r13) goto L14;
        throw new IllegalArgumentException("Fragment " + r10 + " must share the same FragmentManager to be set as a target fragment");
    L14:
        Fragment r14 = r10;
    L15:
        if (r14 == null) goto L21;
        if (r14.equals(this) == true) goto L20;
        r14 = r14.d(false);
        goto L15
    L20:
        throw new IllegalArgumentException("Setting " + r10 + " as the target of " + this + " would create a target cycle");
    L21:
        if (r10 != null) goto L24;
        this.mTargetWho = null;
        this.mTarget = null;
    L29:
        this.mTargetRequestCode = r11;
        return;
    L24:
        if (this.mFragmentManager != null) goto L26;
    L28:
        this.mTargetWho = null;
        this.mTarget = r10;
        goto L29
    L26:
        if (r10.mFragmentManager == null) goto L28;
        this.mTargetWho = r10.mWho;
        this.mTarget = null;
        goto L29
    L7:
        r13 = null;
        goto L8
    }

    @Deprecated
    public void setUserVisibleHint(boolean r10) {
        FragmentStrictMode.o(this, r10);
        if (this.mUserVisibleHint == true) goto L14;
        if (r10 == false) goto L14;
        if (this.mState >= 5) goto L14;
        if (this.mFragmentManager == null) goto L14;
        if (isAdded() == false) goto L14;
        if (this.mIsCreated == false) goto L14;
        FragmentManager r11 = this.mFragmentManager;
        r11.e1(r11.v(this));
    L14:
        this.mUserVisibleHint = r10;
        if (this.mState >= 5) goto L18;
        if (r10 == true) goto L18;
        boolean r12 = true;
    L19:
        this.mDeferStart = r12;
        if (this.mSavedFragmentState == null) goto L23;
        this.mSavedUserVisibleHint = Boolean.valueOf(r10);
        return;
    L23:
        return;
    L18:
        r12 = false;
        goto L19
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String r10) {
        FragmentHostCallback r11 = this.mHost;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.k(r10);
    }

    public void startActivity(@NonNull Intent r10) {
        startActivity(r10, null);
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent r10, int r11) {
        startActivityForResult(r10, r11, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@NonNull IntentSender r10, int r11, @Nullable Intent r12, int r13, int r14, int r15, @Nullable Bundle r16) throws IntentSender.SendIntentException {
        if (this.mHost == null) goto L11;
        if (FragmentManager.L0(2) == false) goto L8;
        Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + r11 + " IntentSender: " + r10 + " fillInIntent: " + r12 + " options: " + r16);
    L8:
        getParentFragmentManager().a1(this, r10, r11, r12, r13, r14, r15, r16);
        return;
    L11:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) goto L5;
        return;
    L5:
        if (b().f3155v == true) goto L8;
        return;
    L8:
        if (this.mHost != null) goto L11;
        b().f3155v = false;
        return;
    L11:
        if (Looper.myLooper() == this.mHost.f().getLooper()) goto L13;
        this.mHost.f().postAtFrontOfQueue(new d(this));
        return;
    L13:
        callStartTransitionListener(true);
    }

    @NonNull
    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append(getClass().getSimpleName());
        r10.append("{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("}");
        r10.append(" (");
        r10.append(this.mWho);
        if (this.mFragmentId == 0) goto L6;
        r10.append(" id=0x");
        r10.append(Integer.toHexString(this.mFragmentId));
    L6:
        if (this.mTag == null) goto L8;
        r10.append(" tag=");
        r10.append(this.mTag);
    L8:
        r10.append(")");
        return r10.toString();
    }

    public void unregisterForContextMenu(@NonNull View r10) {
        r10.setOnCreateContextMenuListener(null);
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context r10, @NonNull String r11, @Nullable Bundle r12) {
        Fragment r13 = (Fragment) p.d(r10.getClassLoader(), r11).getConstructor(null).newInstance(null);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
        if (r12 == null) goto L15;
        r12.setClassLoader(r13.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
        r13.setArguments(r12);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L9 IllegalAccessException -> L11 java.lang.InstantiationException -> L13
    L15:
        return r13;
    L11:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L9:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": could not find Fragment constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate fragment " + r11 + ": calling Fragment constructor caused an exception", e);
    }

    @NonNull
    public final String getString(@StringRes int r10, @Nullable Object... r11) {
        return getResources().getString(r10, r11);
    }

    public final void postponeEnterTransition(long r10, @NonNull TimeUnit r11) {
        b().f3155v = true;
        Handler r12 = this.mPostponedHandler;
        if (r12 == null) goto L5;
        r12.removeCallbacks(this.mPostponedDurationRunnable);
    L5:
        FragmentManager r13 = this.mFragmentManager;
        if (r13 == null) goto L8;
        this.mPostponedHandler = r13.y0().f();
    L9:
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, r11.toMillis(r10));
        return;
    L8:
        this.mPostponedHandler = new Handler(Looper.getMainLooper());
        goto L9
    }

    @Override // androidx.activity.result.ActivityResultCaller
    @NonNull
    @MainThread
    public final <I, O> ActivityResultLauncher registerForActivityResult(@NonNull ActivityResultContract r10, @NonNull ActivityResultRegistry r11, @NonNull ActivityResultCallback<O> r12) {
        return g(r10, new i(this, r11), r12);
    }

    public void startActivity(@NonNull Intent r10, @Nullable Bundle r11) {
        FragmentHostCallback r12 = this.mHost;
        if (r12 == null) goto L7;
        r12.l(this, r10, -1, r11);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@NonNull Intent r10, int r11, @Nullable Bundle r12) {
        if (this.mHost == null) goto L7;
        getParentFragmentManager().Z0(this, r10, r11, r12);
        return;
    L7:
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle r10) {
        FragmentHostCallback r11 = this.mHost;
        if (r11 == null) goto L7;
        LayoutInflater r12 = r11.i();
        androidx.core.view.d.a(r12, this.mChildFragmentManager.z0());
        return r12;
    L7:
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity r10) {
        this.mCalled = true;
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity r10, @NonNull AttributeSet r11, @Nullable Bundle r12) {
        this.mCalled = true;
    }
}
