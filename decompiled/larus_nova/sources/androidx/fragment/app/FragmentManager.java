package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.larus.nova.R;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String SAVED_STATE_TAG = "android:support:fragments";
    public static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private final Map<String, BackStackState> mBackStackStates;
    private FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory;
    ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions;
    Fragment mPrimaryNav;
    private ActivityResultLauncher<String[]> mRequestPermissions;
    private final Map<String, LifecycleAwareResultListener> mResultListeners;
    private final Map<String, Bundle> mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory;
    private ActivityResultLauncher<Intent> mStartActivityForResult;
    private ActivityResultLauncher<IntentSenderRequest> mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private FragmentStrictMode.Policy mStrictModePolicy;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    /* JADX INFO: loaded from: classes17.dex */
    public interface BackStackEntry {
        CharSequence getBreadCrumbShortTitle();

        int getBreadCrumbShortTitleRes();

        CharSequence getBreadCrumbTitle();

        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    /* JADX INFO: loaded from: classes17.dex */
    public class ClearBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        public ClearBackStackState(FragmentManager r100, String r101) {
            this.this$0 = r100;
            this.mName = r101;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101) {
            return this.this$0.clearBackStackState(r100, r101, this.mName);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public FragmentIntentSenderContract() {
        }

        public static Bundle INVOKEVIRTUAL_androidx_fragment_app_FragmentManager$FragmentIntentSenderContract_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r100, String r101) {
            Bundle r102 = r100.getBundleExtra(r101);
            Context r103 = BadParcelableCrashOptimizer.getContext();
            if (r102 == null) goto L6;
            if (r103 == null) goto L6;
            r102.setClassLoader(r103.getClassLoader());
        L6:
            return r102;
        }

        /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context r100, IntentSenderRequest r101) {
            Intent r102 = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent r103 = r101.getFillInIntent();
            if (r103 == null) goto L9;
            Bundle r104 = INVOKEVIRTUAL_androidx_fragment_app_FragmentManager$FragmentIntentSenderContract_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r103, ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r104 == null) goto L9;
            r102.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r104);
            r103.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            if (r103.getBooleanExtra(FragmentManager.EXTRA_CREATED_FILLIN_INTENT, false) == false) goto L9;
            r101 = new IntentSenderRequest.Builder(r101.getIntentSender()).setFillInIntent(null).setFlags(r101.getFlagsValues(), r101.getFlagsMask()).build();
        L9:
            r102.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, r101);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L12;
            r102.toString();
        L12:
            return r102;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int r100, Intent r101) {
            return new ActivityResult(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context r100, IntentSenderRequest r101) {
            return createIntent2(r100, r101);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ ActivityResult parseResult(int r100, Intent r101) {
            return parseResult(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public static abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
        }

        public void onFragmentActivityCreated(FragmentManager r100, Fragment r101, Bundle r102) {
        }

        public void onFragmentAttached(FragmentManager r100, Fragment r101, Context r102) {
        }

        public void onFragmentCreated(FragmentManager r100, Fragment r101, Bundle r102) {
        }

        public void onFragmentDestroyed(FragmentManager r100, Fragment r101) {
        }

        public void onFragmentDetached(FragmentManager r100, Fragment r101) {
        }

        public void onFragmentPaused(FragmentManager r100, Fragment r101) {
        }

        public void onFragmentPreAttached(FragmentManager r100, Fragment r101, Context r102) {
        }

        public void onFragmentPreCreated(FragmentManager r100, Fragment r101, Bundle r102) {
        }

        public void onFragmentResumed(FragmentManager r100, Fragment r101) {
        }

        public void onFragmentSaveInstanceState(FragmentManager r100, Fragment r101, Bundle r102) {
        }

        public void onFragmentStarted(FragmentManager r100, Fragment r101) {
        }

        public void onFragmentStopped(FragmentManager r100, Fragment r101) {
        }

        public void onFragmentViewCreated(FragmentManager r100, Fragment r101, View r102, Bundle r103) {
        }

        public void onFragmentViewDestroyed(FragmentManager r100, Fragment r101) {
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public LaunchedFragmentInfo(Parcel r100) {
            this.mWho = r100.readString();
            this.mRequestCode = r100.readInt();
        }

        public LaunchedFragmentInfo(String r100, int r101) {
            this.mWho = r100;
            this.mRequestCode = r101;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.mWho);
            r100.writeInt(this.mRequestCode);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class LifecycleAwareResultListener implements FragmentResultListener {
        private final Lifecycle mLifecycle;
        private final FragmentResultListener mListener;
        private final LifecycleEventObserver mObserver;

        public void removeObserver() {
            this.mLifecycle.removeObserver(this.mObserver);
        }

        public boolean isAtLeast(Lifecycle.State r100) {
            return this.mLifecycle.getCurrentState().isAtLeast(r100);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(String r100, Bundle r101) {
            this.mListener.onFragmentResult(r100, r101);
        }

        public LifecycleAwareResultListener(Lifecycle r100, FragmentResultListener r101, LifecycleEventObserver r102) {
            this.mLifecycle = r100;
            this.mListener = r101;
            this.mObserver = r102;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;
        final /* synthetic */ FragmentManager this$0;

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101) {
            Fragment r102 = this.this$0.mPrimaryNav;
            if (r102 == null) goto L13;
            if (this.mId >= 0) goto L13;
            if (this.mName != null) goto L13;
            if (r102.getChildFragmentManager().popBackStackImmediate() == false) goto L13;
            return false;
        L13:
            return this.this$0.popBackStackState(r100, r101, this.mName, this.mId, this.mFlags);
        }

        public PopBackStackState(FragmentManager r100, String r101, int r102, int r103) {
            this.this$0 = r100;
            this.mName = r101;
            this.mId = r102;
            this.mFlags = r103;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public class RestoreBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        public RestoreBackStackState(FragmentManager r100, String r101) {
            this.this$0 = r100;
            this.mName = r101;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101) {
            return this.this$0.restoreBackStackState(r100, r101, this.mName);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public class SaveBackStackState implements OpGenerator {
        private final String mName;
        final /* synthetic */ FragmentManager this$0;

        public SaveBackStackState(FragmentManager r100, String r101) {
            this.this$0 = r100;
            this.mName = r101;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101) {
            return this.this$0.saveBackStackState(r100, r101, this.mName);
        }
    }

    public static /* synthetic */ Bundle a(FragmentManager r100) {
        return r100.lambda$attachController$0();
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public static int reverseTransit(int r100) {
        if (r100 == 4097) goto L15;
        if (r100 != 8194) goto L6;
        return 4097;
    L6:
        if (r100 != 8197) goto L8;
        return 4100;
    L8:
        if (r100 == 4099) goto L12;
        if (r100 == 4100) goto L11;
        return 0;
    L11:
        return 8197;
    L12:
        return 4099;
    L15:
        return 8194;
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(4);
    }

    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(0);
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(1);
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        clearBackStackStateViewModels();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher == null) goto L5;
        this.mOnBackPressedCallback.remove();
        this.mOnBackPressedDispatcher = null;
    L5:
        ActivityResultLauncher<Intent> r100 = this.mStartActivityForResult;
        if (r100 == null) goto L9;
        r100.unregister();
        this.mStartIntentSenderForResult.unregister();
        this.mRequestPermissions.unregister();
        return;
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchPause() {
        dispatchStateChange(5);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(7);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        dispatchStateChange(5);
    }

    public void dispatchStop() {
        this.mStopped = true;
        this.mNonConfig.setIsStateSaved(true);
        dispatchStateChange(4);
    }

    public void dispatchViewCreated() {
        dispatchStateChange(2);
    }

    public boolean executePendingTransactions() {
        boolean r100 = execPendingActions(true);
        forcePostponedTransactions();
        return r100;
    }

    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled() == false) goto L5;
        popBackStackImmediate();
        return;
    L5:
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate(null, -1, 0);
    }

    private void clearBackStackStateViewModels() {
        FragmentHostCallback<?> r100 = this.mHost;
        if ((r100 instanceof ViewModelStoreOwner) == false) goto L6;
        boolean r101 = this.mFragmentStore.getNonConfig().isCleared();
    L9:
        if (r101 == false) goto L17;
        Iterator<BackStackState> r102 = this.mBackStackStates.values().iterator();
    L12:
        if (r102.hasNext() == false) goto L20;
        Iterator<String> r103 = r102.next().mFragments.iterator();
    L15:
        if (r103.hasNext() == false) goto L12;
        this.mFragmentStore.getNonConfig().clearNonConfigState(r103.next());
        goto L15
    L20:
        return;
    L17:
        return;
    L6:
        if ((r100.getContext() instanceof Activity) == false) goto L8;
        r101 = !((Activity) this.mHost.getContext()).isChangingConfigurations();
        goto L9
    L8:
        r101 = true;
        goto L9
    }

    private Set<SpecialEffectsController> collectAllSpecialEffectsController() {
        HashSet r100 = new HashSet();
        Iterator<FragmentStateManager> r101 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        ViewGroup r102 = r101.next().getFragment().mContainer;
        if (r102 == null) goto L4;
        r100.add(SpecialEffectsController.getOrCreateController(r102, getSpecialEffectsControllerFactory()));
        goto L4
    L8:
        return r100;
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart == false) goto L6;
        this.mHavePendingDeferredStart = false;
        startPendingDeferredFragments();
        return;
    }

    private /* synthetic */ Bundle lambda$attachController$0() {
        Bundle r100 = new Bundle();
        Parcelable r101 = saveAllStateInternal();
        if (r101 == null) goto L5;
        r100.putParcelable(SAVED_STATE_TAG, r101);
    L5:
        return r100;
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners == null) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.mBackStackChangeListeners.size()) goto L10;
        ((OnBackStackChangedListener) ListProtector.get(this.mBackStackChangeListeners, r100)).onBackStackChanged();
        r100 = r100 + 1;
        goto L6
    L10:
        return;
    }

    private void startPendingDeferredFragments() {
        Iterator<FragmentStateManager> r100 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        performPendingDeferredStart(r100.next());
        goto L4
    }

    private void updateOnBackPressedCallbackEnabled() {
        ArrayList<OpGenerator> r100 = this.mPendingActions;
        monitor-enter(r100);
        boolean r101 = true;
        if (this.mPendingActions.isEmpty() == true) goto L9;
        this.mOnBackPressedCallback.setEnabled(true);     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L18
        OnBackPressedCallback r102 = this.mOnBackPressedCallback;
        if (getBackStackEntryCount() > 0) goto L13;
    L15:
        r101 = false;
    L16:
        r102.setEnabled(r101);
        return;
    L13:
        if (isPrimaryNavigation(this.mParent) == false) goto L15;
    L18:
        th = move-exception;
        throw th;
    }

    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public boolean checkForMenus() {
        Iterator<Fragment> r100 = this.mFragmentStore.getActiveFragments().iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L11;
        Fragment r102 = r100.next();
        if (r102 == null) goto L8;
        r101 = isMenuAvailable(r102);
    L8:
        if (r101 == false) goto L4;
        return true;
    L11:
        return false;
    }

    public void dispatchLowMemory() {
        Iterator<Fragment> r100 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Fragment r101 = r100.next();
        if (r101 == null) goto L4;
        r101.performLowMemory();
        goto L4
    }

    public void dispatchOnHiddenChanged() {
        Iterator<Fragment> r100 = this.mFragmentStore.getActiveFragments().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Fragment r101 = r100.next();
        if (r101 == null) goto L4;
        r101.onHiddenChanged(r101.isHidden());
        r101.mChildFragmentManager.dispatchOnHiddenChanged();
        goto L4
    }

    public int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    public List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> r100 = this.mBackStack;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory r100 = this.mFragmentFactory;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Fragment r101 = this.mParent;
        if (r101 == null) goto L10;
        return r101.mFragmentManager.getFragmentFactory();
    L10:
        return this.mHostFragmentFactory;
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    public SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        SpecialEffectsControllerFactory r100 = this.mSpecialEffectsControllerFactory;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Fragment r101 = this.mParent;
        if (r101 == null) goto L10;
        return r101.mFragmentManager.getSpecialEffectsControllerFactory();
    L10:
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public boolean isStateSaved() {
        if (this.mStateSaved == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mStopped == true) goto L8;
        return false;
    }

    public void noteStateNotSaved() {
        if (this.mHost != null) goto L5;
        return;
    L5:
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        Iterator<Fragment> r100 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        Fragment r101 = r100.next();
        if (r101 == null) goto L7;
        r101.noteStateNotSaved();
        goto L7
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(this, null, -1, 0), false);
    }

    public FragmentManagerNonConfig retainNonConfig() {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    L6:
        return this.mNonConfig.getSnapshot();
    }

    public Parcelable saveAllState() {
        if ((this.mHost instanceof SavedStateRegistryOwner) == false) goto L6;
        throwException(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L6:
        return saveAllStateInternal();
    }

    public void scheduleCommit() {
        ArrayList<OpGenerator> r100 = this.mPendingActions;
        monitor-enter(r100);
        boolean r101 = true;
        if (this.mPendingActions.size() == 1) goto L8;
        r101 = false;
    L8:
        if (r101 == false) goto L10;
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L12
        this.mHost.getHandler().post(this.mExecCommit);     // Catch: Throwable -> L12
        updateOnBackPressedCallbackEnabled();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder(128);
        r100.append("FragmentManager{");
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append(" in ");
        Fragment r101 = this.mParent;
        if (r101 == null) goto L5;
        r100.append(r101.getClass().getSimpleName());
        r100.append("{");
        r100.append(Integer.toHexString(System.identityHashCode(this.mParent)));
        r100.append(i.f25855d);
    L9:
        r100.append("}}");
        return r100.toString();
    L5:
        FragmentHostCallback<?> r102 = this.mHost;
        if (r102 == null) goto L8;
        r100.append(r102.getClass().getSimpleName());
        r100.append("{");
        r100.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        r100.append(i.f25855d);
        goto L9
    L8:
        r100.append("null");
        goto L9
    }

    public FragmentManager() {
        this.mPendingActions = new ArrayList();
        this.mFragmentStore = new FragmentStore();
        this.mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
        final boolean r100 = false;
        this.mOnBackPressedCallback = new AnonymousClass1(this, r100);
        this.mBackStackIndex = new AtomicInteger();
        this.mBackStackStates = Collections.synchronizedMap(new HashMap());
        this.mResults = Collections.synchronizedMap(new HashMap());
        this.mResultListeners = Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mCurState = -1;
        this.mFragmentFactory = null;
        this.mHostFragmentFactory = new AnonymousClass2(this);
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = new AnonymousClass3(this);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new AnonymousClass4(this);
    }

    private void checkStateLoss() {
        if (isStateSaved() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void endAnimatingAwayFragments() {
        Iterator<SpecialEffectsController> r100 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().forceCompleteAllOperations();
        goto L4
    }

    private void forcePostponedTransactions() {
        Iterator<SpecialEffectsController> r100 = collectAllSpecialEffectsController().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().forcePostponedExecutePendingOperations();
        goto L4
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public Parcelable saveAllStateInternal() {
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.setIsStateSaved(true);
        ArrayList<String> r100 = this.mFragmentStore.saveActiveFragments();
        ArrayList<FragmentState> r101 = this.mFragmentStore.getAllSavedState();
        BackStackRecordState[] r102 = null;
        if (r101.isEmpty() == false) goto L6;
        isLoggingEnabled(2);
        return null;
    L6:
        ArrayList<String> r103 = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> r104 = this.mBackStack;
        if (r104 == null) goto L16;
        int r105 = r104.size();
        if (r105 <= 0) goto L16;
        r102 = new BackStackRecordState[r105];
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L16;
        r102[r106] = new BackStackRecordState((BackStackRecord) ListProtector.get(this.mBackStack, r106));
        if (isLoggingEnabled(2) == false) goto L15;
        Objects.toString(ListProtector.get(this.mBackStack, r106));
    L15:
        r106 = r106 + 1;
    L16:
        FragmentManagerState r107 = new FragmentManagerState();
        r107.mSavedState = r101;
        r107.mActive = r100;
        r107.mAdded = r103;
        r107.mBackStack = r102;
        r107.mBackStackIndex = this.mBackStackIndex.get();
        Fragment r108 = this.mPrimaryNav;
        if (r108 == null) goto L19;
        r107.mPrimaryNavActiveWho = r108.mWho;
    L19:
        r107.mBackStackStateKeys.addAll(this.mBackStackStates.keySet());
        r107.mBackStackStates.addAll(this.mBackStackStates.values());
        r107.mResultKeys.addAll(this.mResults.keySet());
        r107.mResults.addAll(this.mResults.values());
        r107.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
        return r107;
    }

    public FragmentContainer getContainer() {
        return this.mContainer;
    }

    public FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public FragmentHostCallback<?> getHost() {
        return this.mHost;
    }

    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    public Fragment getParent() {
        return this.mParent;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    public FragmentStrictMode.Policy getStrictModePolicy() {
        return this.mStrictModePolicy;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public static /* synthetic */ Map access$000(FragmentManager r100) {
        return r100.mResults;
    }

    public static /* synthetic */ Map access$100(FragmentManager r100) {
        return r100.mResultListeners;
    }

    public static /* synthetic */ FragmentStore access$200(FragmentManager r100) {
        return r100.mFragmentStore;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(findActiveFragment(r100.mWho)) == false) goto L8;
        r100.performPrimaryNavigationFragmentChanged();
        return;
    }

    private void dispatchStateChange(int r100) {
        this.mExecutingActions = true;     // Catch: Throwable -> L10
        this.mFragmentStore.dispatchStateChange(r100);     // Catch: Throwable -> L10
        moveToState(r100, false);     // Catch: Throwable -> L10
        Iterator<SpecialEffectsController> r101 = collectAllSpecialEffectsController().iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L8;
        r101.next().forceCompleteAllOperations();     // Catch: Throwable -> L10
        goto L5
    L8:
        this.mExecutingActions = false;
        execPendingActions(true);
        return;
    L10:
        th = move-exception;
        this.mExecutingActions = false;
        throw th;
    }

    public static void enableDebugLogging(boolean r100) {
        DEBUG = r100;
    }

    private void ensureExecReady(boolean r100) {
        if (this.mExecutingActions == true) goto L23;
        if (this.mHost != null) goto L13;
        if (this.mDestroyed == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) goto L21;
        if (r100 == true) goto L17;
        checkStateLoss();
    L17:
        if (this.mTmpRecords != null) goto L24;
        this.mTmpRecords = new ArrayList();
        this.mTmpIsPop = new ArrayList();
        return;
    L24:
        return;
    L21:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L23:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public static <F extends Fragment> F findFragment(View r100) {
        F r101 = (F) findViewFragment(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("View " + r100 + " does not have a Fragment set");
    }

    public static FragmentManager findFragmentManager(View r100) {
        Fragment r101 = findViewFragment(r100);
        if (r101 != null) goto L5;
        Context r102 = r100.getContext();
    L11:
        if ((r102 instanceof ContextWrapper) == false) goto L16;
        if ((r102 instanceof FragmentActivity) == true) goto L14;
        r102 = ((ContextWrapper) r102).getBaseContext();
        goto L11
    L14:
        FragmentActivity r103 = (FragmentActivity) r102;
    L17:
        if (r103 == null) goto L21;
        return r103.getSupportFragmentManager();
    L21:
        throw new IllegalStateException("View " + r100 + " is not within a subclass of FragmentActivity.");
    L16:
        r103 = null;
        goto L17
    L5:
        if (r101.isAdded() == false) goto L8;
        return r101.getChildFragmentManager();
    L8:
        throw new IllegalStateException("The Fragment " + r101 + " that owns View " + r100 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
    }

    private static Fragment findViewFragment(View r100) {
    L3:
        if (r100 == null) goto L11;
        Fragment r101 = getViewFragment(r100);
        if (r101 != null) goto L6;
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == true) goto L9;
        r100 = null;
        goto L3
    L9:
        r100 = (View) r102;
        goto L3
    L6:
        return r101;
    L11:
        return null;
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment r100) {
        return this.mNonConfig.getChildNonConfig(r100);
    }

    private ViewGroup getFragmentContainer(Fragment r100) {
        ViewGroup r101 = r100.mContainer;
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100.mContainerId > 0) goto L9;
        return null;
    L9:
        if (this.mContainer.onHasView() == false) goto L14;
        View r102 = this.mContainer.onFindViewById(r100.mContainerId);
        if ((r102 instanceof ViewGroup) == false) goto L14;
        return (ViewGroup) r102;
    L14:
        return null;
    }

    public static Fragment getViewFragment(View r100) {
        Object r101 = r100.getTag(R.id.fragment_container_view_tag);
        if ((r101 instanceof Fragment) == true) goto L5;
        return null;
    L5:
        return (Fragment) r101;
    }

    public static boolean isLoggingEnabled(int r100) {
        if (DEBUG == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(TAG, r100) == true) goto L8;
        return false;
    }

    private boolean isMenuAvailable(Fragment r100) {
        if (r100.mHasMenu == false) goto L7;
        if (r100.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r100.mChildFragmentManager.checkForMenus() == true) goto L8;
        return false;
    }

    private void setVisibleRemovingFragment(Fragment r100) {
        ViewGroup r101 = getFragmentContainer(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((((r100.getEnterAnim() + r100.getExitAnim()) + r100.getPopEnterAnim()) + r100.getPopExitAnim()) > 0) goto L7;
        return;
    L7:
        if (r101.getTag(R.id.visible_removing_fragment_view_tag) != null) goto L9;
        r101.setTag(R.id.visible_removing_fragment_view_tag, r100);
    L9:
        ((Fragment) r101.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(r100.getPopDirection());
    }

    private void throwException(RuntimeException r100) {
        r100.getMessage();
        PrintWriter r101 = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> r102 = this.mHost;
        if (r102 == null) goto L5;
        r102.onDump(tb2.c.DEFAULT_TEXT, null, r101, new String[0]);     // Catch: Exception -> L7
    L8:
        throw r100;
    L5:
        dump(tb2.c.DEFAULT_TEXT, null, r101, new String[0]);     // Catch: Exception -> L7
    L11:
        throw r100;
    }

    public void addBackStackState(BackStackRecord r100) {
        if (this.mBackStack != null) goto L5;
        this.mBackStack = new ArrayList();
    L5:
        this.mBackStack.add(r100);
    }

    public FragmentStateManager addFragment(Fragment r100) {
        String r101 = r100.mPreviousWho;
        if (r101 == null) goto L6;
        FragmentStrictMode.onFragmentReuse(r100, r101);
    L6:
        if (isLoggingEnabled(2) == false) goto L8;
        r100.toString();
    L8:
        FragmentStateManager r102 = createOrGetFragmentStateManager(r100);
        r100.mFragmentManager = this;
        this.mFragmentStore.makeActive(r102);
        if (r100.mDetached == true) goto L16;
        this.mFragmentStore.addFragment(r100);
        r100.mRemoving = false;
        if (r100.mView != null) goto L14;
        r100.mHiddenChanged = false;
    L14:
        if (isMenuAvailable(r100) == false) goto L16;
        this.mNeedMenuInvalidate = true;
    L16:
        return r102;
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener r100) {
        this.mOnAttachListeners.add(r100);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener r100) {
        if (this.mBackStackChangeListeners != null) goto L5;
        this.mBackStackChangeListeners = new ArrayList();
    L5:
        this.mBackStackChangeListeners.add(r100);
    }

    public void addRetainedFragment(Fragment r100) {
        this.mNonConfig.addRetainedFragment(r100);
    }

    public void attachFragment(Fragment r100) {
        if (isLoggingEnabled(2) == false) goto L6;
        Objects.toString(r100);
    L6:
        if (r100.mDetached == false) goto L16;
        r100.mDetached = false;
        if (r100.mAdded == true) goto L17;
        this.mFragmentStore.addFragment(r100);
        if (isLoggingEnabled(2) == false) goto L13;
        r100.toString();
    L13:
        if (isMenuAvailable(r100) == false) goto L18;
        this.mNeedMenuInvalidate = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    public void clearBackStack(String r100) {
        enqueueAction(new ClearBackStackState(this, r100), false);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(String r100) {
        this.mResults.remove(r100);
        if (isLoggingEnabled(2) == true) goto L5;
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(String r100) {
        LifecycleAwareResultListener r101 = this.mResultListeners.remove(r100);
        if (r101 == null) goto L6;
        r101.removeObserver();
    L6:
        if (isLoggingEnabled(2) == true) goto L8;
        return;
    }

    public FragmentStateManager createOrGetFragmentStateManager(Fragment r100) {
        FragmentStateManager r101 = this.mFragmentStore.getFragmentStateManager(r100.mWho);
        if (r101 == null) goto L5;
        return r101;
    L5:
        FragmentStateManager r102 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r100);
        r102.restoreState(this.mHost.getContext().getClassLoader());
        r102.setFragmentManagerState(this.mCurState);
        return r102;
    }

    public void detachFragment(Fragment r100) {
        if (isLoggingEnabled(2) == false) goto L6;
        Objects.toString(r100);
    L6:
        if (r100.mDetached == true) goto L17;
        r100.mDetached = true;
        if (r100.mAdded == true) goto L10;
        return;
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        r100.toString();
    L12:
        this.mFragmentStore.removeFragment(r100);
        if (isMenuAvailable(r100) == false) goto L15;
        this.mNeedMenuInvalidate = true;
    L15:
        setVisibleRemovingFragment(r100);
        return;
    }

    public void dispatchConfigurationChanged(Configuration r100) {
        Iterator<Fragment> r101 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Fragment r102 = r101.next();
        if (r102 == null) goto L4;
        r102.performConfigurationChanged(r100);
        goto L4
    }

    public boolean dispatchContextItemSelected(MenuItem r100) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r101 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Fragment r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.performContextItemSelected(r100) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public void dispatchMultiWindowModeChanged(boolean r100) {
        Iterator<Fragment> r101 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Fragment r102 = r101.next();
        if (r102 == null) goto L4;
        r102.performMultiWindowModeChanged(r100);
        goto L4
    }

    public void dispatchOnAttachFragment(Fragment r100) {
        Iterator<FragmentOnAttachListener> r101 = this.mOnAttachListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onAttachFragment(this, r100);
        goto L4
    }

    public boolean dispatchOptionsItemSelected(MenuItem r100) {
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r101 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Fragment r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.performOptionsItemSelected(r100) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu r100) {
        if (this.mCurState >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r101 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Fragment r102 = r101.next();
        if (r102 == null) goto L7;
        r102.performOptionsMenuClosed(r100);
        goto L7
    }

    public void dispatchPictureInPictureModeChanged(boolean r100) {
        Iterator<Fragment> r101 = this.mFragmentStore.getFragments().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Fragment r102 = r101.next();
        if (r102 == null) goto L4;
        r102.performPictureInPictureModeChanged(r100);
        goto L4
    }

    public boolean dispatchPrepareOptionsMenu(Menu r100) {
        boolean r101 = false;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r102 = this.mFragmentStore.getFragments().iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        Fragment r103 = r102.next();
        if (r103 == null) goto L7;
        if (isParentMenuVisible(r103) == false) goto L7;
        if (r103.performPrepareOptionsMenu(r100) == false) goto L7;
        r101 = true;
        goto L7
    L15:
        return r101;
    }

    public boolean execPendingActions(boolean r100) {
        ensureExecReady(r100);
        boolean r101 = false;
    L4:
        if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop) == false) goto L11;
        r101 = true;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L8
        cleanupExec();
    L8:
        th = move-exception;
        cleanupExec();
        throw th;
    L11:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r101;
    }

    public Fragment findActiveFragment(String r100) {
        return this.mFragmentStore.findActiveFragment(r100);
    }

    public Fragment findFragmentById(int r100) {
        return this.mFragmentStore.findFragmentById(r100);
    }

    public Fragment findFragmentByTag(String r100) {
        return this.mFragmentStore.findFragmentByTag(r100);
    }

    public Fragment findFragmentByWho(String r100) {
        return this.mFragmentStore.findFragmentByWho(r100);
    }

    public BackStackEntry getBackStackEntryAt(int r100) {
        return (BackStackEntry) ListProtector.get(this.mBackStack, r100);
    }

    public ViewModelStore getViewModelStore(Fragment r100) {
        return this.mNonConfig.getViewModelStore(r100);
    }

    public void hideFragment(Fragment r100) {
        if (isLoggingEnabled(2) == false) goto L6;
        Objects.toString(r100);
    L6:
        if (r100.mHidden == true) goto L9;
        r100.mHidden = true;
        r100.mHiddenChanged = true ^ r100.mHiddenChanged;
        setVisibleRemovingFragment(r100);
        return;
    }

    public void invalidateMenuForFragment(Fragment r100) {
        if (r100.mAdded == true) goto L5;
        return;
    L5:
        if (isMenuAvailable(r100) == false) goto L9;
        this.mNeedMenuInvalidate = true;
        return;
    }

    public boolean isParentHidden(Fragment r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.isHidden();
    }

    public boolean isParentMenuVisible(Fragment r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return r100.isMenuVisible();
    }

    public boolean isPrimaryNavigation(Fragment r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        FragmentManager r101 = r100.mFragmentManager;
        if (r100.equals(r101.getPrimaryNavigationFragment()) == true) goto L8;
    L10:
        return false;
    L8:
        if (isPrimaryNavigation(r101.mParent) == false) goto L10;
        return true;
    }

    public boolean isStateAtLeast(int r100) {
        if (this.mCurState < r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void onContainerAvailable(FragmentContainerView r100) {
        Iterator<FragmentStateManager> r101 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        FragmentStateManager r102 = r101.next();
        Fragment r103 = r102.getFragment();
        if (r103.mContainerId != r100.getId()) goto L4;
        View r104 = r103.mView;
        if (r104 == null) goto L4;
        if (r104.getParent() != null) goto L4;
        r103.mContainer = r100;
        r102.addViewToContainer();
        goto L4
    }

    public void performPendingDeferredStart(FragmentStateManager r100) {
        Fragment r101 = r100.getFragment();
        if (r101.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.mExecutingActions == false) goto L8;
        this.mHavePendingDeferredStart = true;
        return;
    L8:
        r101.mDeferStart = false;
        r100.moveToExpectedState();
    }

    public void removeFragment(Fragment r100) {
        if (isLoggingEnabled(2) == false) goto L5;
        Objects.toString(r100);
        int r101 = r100.mBackStackNesting;
    L5:
        boolean r102 = !r100.isInBackStack();
        if (r100.mDetached == false) goto L8;
        if (r102 == true) goto L8;
        return;
    L8:
        this.mFragmentStore.removeFragment(r100);
        if (isMenuAvailable(r100) == false) goto L11;
        this.mNeedMenuInvalidate = true;
    L11:
        r100.mRemoving = true;
        setVisibleRemovingFragment(r100);
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener r100) {
        this.mOnAttachListeners.remove(r100);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener r100) {
        ArrayList<OnBackStackChangedListener> r101 = this.mBackStackChangeListeners;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeRetainedFragment(Fragment r100) {
        this.mNonConfig.removeRetainedFragment(r100);
    }

    public void restoreBackStack(String r100) {
        enqueueAction(new RestoreBackStackState(this, r100), false);
    }

    public void restoreSaveState(Parcelable r100) {
        if ((this.mHost instanceof SavedStateRegistryOwner) == false) goto L5;
        throwException(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
    L5:
        restoreSaveStateInternal(r100);
    }

    public void restoreSaveStateInternal(Parcelable r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        FragmentManagerState r111 = (FragmentManagerState) r110;
        ArrayList<FragmentState> r100 = r111.mSavedState;
        if (r100 != null) goto L7;
        return;
    L7:
        this.mFragmentStore.restoreSaveState(r100);
        this.mFragmentStore.resetActiveFragments();
        Iterator<String> r101 = r111.mActive.iterator();
    L9:
        if (r101.hasNext() == false) goto L23;
        String r102 = r101.next();
        FragmentState r112 = this.mFragmentStore.setSavedState(r102, null);
        if (r112 == null) goto L9;
        Fragment r103 = this.mNonConfig.findRetainedFragmentByWho(r112.mWho);
        if (r103 != null) goto L15;
        FragmentStateManager r104 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.getContext().getClassLoader(), getFragmentFactory(), r112);
    L19:
        Fragment r105 = r104.getFragment();
        r105.mFragmentManager = this;
        if (isLoggingEnabled(2) == false) goto L22;
        r105.toString();
    L22:
        r104.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(r104);
        r104.setFragmentManagerState(this.mCurState);
        goto L9
    L15:
        if (isLoggingEnabled(2) == false) goto L17;
        r103.toString();
    L17:
        r104 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r103, r112);
        goto L19
    L23:
        Iterator<Fragment> r106 = this.mNonConfig.getRetainedFragments().iterator();
    L25:
        if (r106.hasNext() == false) goto L32;
        Fragment r107 = r106.next();
        if (this.mFragmentStore.containsActiveFragment(r107.mWho) == true) goto L25;
        if (isLoggingEnabled(2) == false) goto L31;
        r107.toString();
        Objects.toString(r111.mActive);
    L31:
        this.mNonConfig.removeRetainedFragment(r107);
        r107.mFragmentManager = this;
        FragmentStateManager r108 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, r107);
        r108.setFragmentManagerState(1);
        r108.moveToExpectedState();
        r107.mRemoving = true;
        r108.moveToExpectedState();
        goto L25
    L32:
        this.mFragmentStore.restoreAddedFragments(r111.mAdded);
        int r109 = 0;
        if (r111.mBackStack == null) goto L41;
        this.mBackStack = new ArrayList(r111.mBackStack.length);
        int r113 = 0;
    L35:
        BackStackRecordState[] r114 = r111.mBackStack;
        if (r113 >= r114.length) goto L42;
        BackStackRecord r115 = r114[r113].instantiate(this);
        if (isLoggingEnabled(2) == false) goto L40;
        int r116 = r115.mIndex;
        r115.toString();
        PrintWriter r117 = new PrintWriter(new LogWriter(TAG));
        r115.dump(tb2.c.DEFAULT_TEXT, r117, false);
        r117.close();
    L40:
        this.mBackStack.add(r115);
        r113 = r113 + 1;
    L42:
        this.mBackStackIndex.set(r111.mBackStackIndex);
        String r118 = r111.mPrimaryNavActiveWho;
        if (r118 == null) goto L45;
        Fragment r119 = findActiveFragment(r118);
        this.mPrimaryNav = r119;
        dispatchParentPrimaryNavigationFragmentChanged(r119);
    L45:
        ArrayList<String> r120 = r111.mBackStackStateKeys;
        if (r120 == null) goto L51;
        int r121 = 0;
    L49:
        if (r121 >= r120.size()) goto L51;
        this.mBackStackStates.put((String) ListProtector.get(r120, r121), (BackStackState) ListProtector.get(r111.mBackStackStates, r121));
        r121 = r121 + 1;
    L51:
        ArrayList<String> r122 = r111.mResultKeys;
        if (r122 != null) goto L54;
    L56:
        this.mLaunchedFragments = new ArrayDeque(r111.mLaunchedFragments);
        return;
    L54:
        if (r109 >= r122.size()) goto L56;
        Bundle r123 = (Bundle) ListProtector.get(r111.mResults, r109);
        r123.setClassLoader(this.mHost.getContext().getClassLoader());
        this.mResults.put((String) ListProtector.get(r122, r109), r123);
        r109 = r109 + 1;
        goto L54
    L41:
        this.mBackStack = null;
        goto L42
    }

    public void saveBackStack(String r100) {
        enqueueAction(new SaveBackStackState(this, r100), false);
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment r100) {
        FragmentStateManager r101 = this.mFragmentStore.getFragmentStateManager(r100.mWho);
        if (r101 != null) goto L5;
    L6:
        throwException(new IllegalStateException("Fragment " + r100 + " is not currently in the FragmentManager"));
    L8:
        return r101.saveInstanceState();
    L5:
        if (r101.getFragment().equals(r100) == true) goto L8;
        goto L6
    }

    public void setFragmentFactory(FragmentFactory r100) {
        this.mFragmentFactory = r100;
    }

    public void setPrimaryNavigationFragment(Fragment r100) {
        if (r100 != null) goto L4;
    L12:
        Fragment r101 = this.mPrimaryNav;
        this.mPrimaryNav = r100;
        dispatchParentPrimaryNavigationFragmentChanged(r101);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
        return;
    L4:
        if (r100.equals(findActiveFragment(r100.mWho)) == false) goto L11;
        if (r100.mHost == null) goto L12;
        if (r100.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r100 + " is not an active fragment of FragmentManager " + this);
    }

    public void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory r100) {
        this.mSpecialEffectsControllerFactory = r100;
    }

    public void setStrictModePolicy(FragmentStrictMode.Policy r100) {
        this.mStrictModePolicy = r100;
    }

    public void showFragment(Fragment r100) {
        if (isLoggingEnabled(2) == false) goto L6;
        Objects.toString(r100);
    L6:
        if (r100.mHidden == false) goto L9;
        r100.mHidden = false;
        r100.mHiddenChanged = !r100.mHiddenChanged;
        return;
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks r100) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(r100);
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101) {
        ArrayList<OpGenerator> r102 = this.mPendingActions;
        monitor-enter(r102);
        int r103 = 0;
        if (this.mPendingActions.isEmpty() == false) goto L21;
        monitor-exit(r102);     // Catch: Throwable -> L18
        return false;
    L21:
        int r104 = this.mPendingActions.size();     // Catch: Throwable -> L15
        boolean r105 = false;
    L9:
        if (r103 >= r104) goto L12;
        r105 = r105 | this.mPendingActions.get(r103).generateOps(r100, r101);
        r103 = r103 + 1;
        goto L9
    L12:
        this.mPendingActions.clear();     // Catch: Throwable -> L18
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        monitor-exit(r102);     // Catch: Throwable -> L18
        return r105;
    L15:
        th = move-exception;
        this.mPendingActions.clear();     // Catch: Throwable -> L18
        this.mHost.getHandler().removeCallbacks(this.mExecCommit);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101) {
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (r100.size() != r101.size()) goto L27;
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= r102) goto L23;
        if (((BackStackRecord) ListProtector.get(r100, r103)).mReorderingAllowed == true) goto L22;
        if (r104 == r103) goto L13;
        executeOpsTogether(r100, r101, r104, r103);
    L13:
        r104 = r103 + 1;
        if (((Boolean) ListProtector.get(r101, r103)).booleanValue() == false) goto L21;
    L15:
        if (r104 >= r102) goto L21;
        if (((Boolean) ListProtector.get(r101, r104)).booleanValue() == false) goto L21;
        if (((BackStackRecord) ListProtector.get(r100, r104)).mReorderingAllowed == true) goto L21;
        r104 = r104 + 1;
    L21:
        executeOpsTogether(r100, r101, r103, r104);
        r103 = r104 - 1;
    L22:
        r103 = r103 + 1;
        goto L8
    L23:
        if (r104 == r102) goto L34;
        executeOpsTogether(r100, r101, r104, r102);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public boolean dispatchCreateOptionsMenu(Menu r100, MenuInflater r101) {
        int r102 = 0;
        if (this.mCurState >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r103 = this.mFragmentStore.getFragments().iterator();
        ArrayList<Fragment> r104 = null;
        boolean r105 = false;
    L7:
        if (r103.hasNext() == false) goto L18;
        Fragment r106 = r103.next();
        if (r106 == null) goto L7;
        if (isParentMenuVisible(r106) == false) goto L7;
        if (r106.performCreateOptionsMenu(r100, r101) == false) goto L7;
        if (r104 != null) goto L16;
        r104 = new ArrayList();
    L16:
        r104.add(r106);
        r105 = true;
        goto L7
    L18:
        if (this.mCreatedMenus != null) goto L20;
    L27:
        this.mCreatedMenus = r104;
        return r105;
    L20:
        if (r102 >= this.mCreatedMenus.size()) goto L27;
        Fragment r107 = (Fragment) ListProtector.get(this.mCreatedMenus, r102);
        if (r104 != null) goto L24;
    L25:
        r107.onDestroyOptionsMenu();
    L26:
        r102 = r102 + 1;
        goto L20
    L24:
        if (r104.contains(r107) == true) goto L26;
        goto L25
    }

    public void enqueueAction(OpGenerator r100, boolean r101) {
        if (r101 == false) goto L4;
    L12:
        ArrayList<OpGenerator> r102 = this.mPendingActions;
        monitor-enter(r102);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (this.mHost != null) goto L21;
        if (r101 == false) goto L20;
        monitor-exit(r102);     // Catch: Throwable -> L24
        return;
    L20:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L24
    L21:
        this.mPendingActions.add(r100);     // Catch: Throwable -> L24
        scheduleCommit();     // Catch: Throwable -> L24
        monitor-exit(r102);     // Catch: Throwable -> L24
        return;
    L4:
        if (this.mHost == null) goto L6;
        checkStateLoss();
        goto L12
    L6:
        if (this.mDestroyed == false) goto L10;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L10:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    public void execSingleAction(OpGenerator r100, boolean r101) {
        if (r101 == true) goto L4;
    L8:
        ensureExecReady(r101);
        if (r100.generateOps(this.mTmpRecords, this.mTmpIsPop) == false) goto L16;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L13
        cleanupExec();
    L13:
        th = move-exception;
        cleanupExec();
        throw th;
    L16:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return;
    L4:
        if (this.mHost != null) goto L6;
        return;
    L6:
        if (this.mDestroyed == false) goto L8;
    }

    public Fragment getFragment(Bundle r100, String r101) {
        String r102 = r100.getString(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        Fragment r103 = findActiveFragment(r102);
        if (r103 != null) goto L9;
        throwException(new IllegalStateException("Fragment no longer exists for key " + r101 + ": unique id " + r102));
    L9:
        return r103;
    }

    public void moveToState(int r100, boolean r101) {
        if (this.mHost == null) goto L5;
    L9:
        if (r101 == false) goto L11;
    L13:
        this.mCurState = r100;
        this.mFragmentStore.moveToExpectedState();
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate == false) goto L21;
        FragmentHostCallback<?> r102 = this.mHost;
        if (r102 != null) goto L18;
        return;
    L18:
        if (this.mCurState != 7) goto L23;
        r102.onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
    L23:
        return;
    L21:
        return;
    L11:
        if (r100 != this.mCurState) goto L13;
        return;
    L5:
        if (r100 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    public void popBackStack(String r100, int r101) {
        enqueueAction(new PopBackStackState(this, r100, -1, r101), false);
    }

    public boolean popBackStackImmediate(int r100, int r101) {
        if (r100 < 0) goto L6;
        return popBackStackImmediate(null, r100, r101);
    L6:
        throw new IllegalArgumentException("Bad id: " + r100);
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks r100, boolean r101) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(r100, r101);
    }

    public void restoreAllState(Parcelable r100, FragmentManagerNonConfig r101) {
        if ((this.mHost instanceof ViewModelStoreOwner) == false) goto L5;
        throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    L5:
        this.mNonConfig.restoreFromSnapshot(r101);
        restoreSaveStateInternal(r100);
    }

    public void setExitAnimationOrder(Fragment r100, boolean r101) {
        ViewGroup r102 = getFragmentContainer(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof FragmentContainerView) == false) goto L9;
        ((FragmentContainerView) r102).setDrawDisappearingViewsLast(!r101);
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(String r100, Bundle r101) {
        LifecycleAwareResultListener r102 = this.mResultListeners.get(r100);
        if (r102 != null) goto L5;
    L7:
        this.mResults.put(r100, r101);
    L9:
        if (isLoggingEnabled(2) == false) goto L12;
        Objects.toString(r101);
        return;
    L12:
        return;
    L5:
        if (r102.isAtLeast(Lifecycle.State.STARTED) == false) goto L7;
        r102.onFragmentResult(r100, r101);
        goto L9
    }

    public void setMaxLifecycle(Fragment r100, Lifecycle.State r101) {
        if (r100.equals(findActiveFragment(r100.mWho)) == false) goto L11;
        if (r100.mHost != null) goto L7;
    L8:
        r100.mMaxState = r101;
        return;
    L7:
        if (r100.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r100 + " is not an active fragment of FragmentManager " + this);
    }

    public void popBackStack(int r100, int r101) {
        popBackStack(r100, r101, false);
    }

    public boolean popBackStackImmediate(String r100, int r101) {
        return popBackStackImmediate(r100, -1, r101);
    }

    private Set<SpecialEffectsController> collectChangedControllers(ArrayList<BackStackRecord> r100, int r101, int r102) {
        HashSet r103 = new HashSet();
    L3:
        if (r101 >= r102) goto L13;
        Iterator<FragmentTransaction.Op> r104 = ((BackStackRecord) ListProtector.get(r100, r101)).mOps.iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        Fragment r105 = r104.next().mFragment;
        if (r105 == null) goto L6;
        ViewGroup r106 = r105.mContainer;
        if (r106 == null) goto L6;
        r103.add(SpecialEffectsController.getOrCreateController(r106, this));
        goto L6
    L12:
        r101 = r101 + 1;
        goto L3
    L13:
        return r103;
    }

    private int findBackStackIndex(String r100, int r101, boolean r102) {
        ArrayList<BackStackRecord> r103 = this.mBackStack;
        if (r103 != null) goto L5;
    L43:
        return -1;
    L5:
        if (r103.isEmpty() == true) goto L43;
        if (r100 != null) goto L14;
        if (r101 >= 0) goto L14;
        if (r102 == false) goto L13;
        return 0;
    L13:
        return this.mBackStack.size() - 1;
    L14:
        int r104 = this.mBackStack.size() - 1;
    L15:
        if (r104 < 0) goto L26;
        BackStackRecord r105 = (BackStackRecord) ListProtector.get(this.mBackStack, r104);
        if (r100 != null) goto L19;
    L21:
        if (r101 < 0) goto L25;
        if (r101 == r105.mIndex) goto L26;
    L25:
        r104 = r104 - 1;
        goto L15
    L19:
        if (r100.equals(r105.getName()) == false) goto L21;
    L26:
        if (r104 >= 0) goto L28;
        return r104;
    L28:
        if (r102 == false) goto L39;
    L29:
        if (r104 <= 0) goto L56;
        BackStackRecord r106 = (BackStackRecord) ListProtector.get(this.mBackStack, r104 - 1);
        if (r100 != null) goto L33;
    L34:
        if (r101 < 0) goto L54;
        if (r101 == r106.mIndex) goto L37;
        return r104;
    L37:
        r104 = r104 - 1;
        goto L29
    L54:
        return r104;
    L33:
        if (r100.equals(r106.getName()) == true) goto L37;
    L56:
        return r104;
    L39:
        if (r104 != (this.mBackStack.size() - 1)) goto L42;
        return -1;
    L42:
        return r104 + 1;
    }

    private boolean popBackStackImmediate(String r100, int r110, int r111) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment r101 = this.mPrimaryNav;
        if (r101 == null) goto L9;
        if (r110 >= 0) goto L9;
        if (r100 != null) goto L9;
        if (r101.getChildFragmentManager().popBackStackImmediate() == false) goto L9;
        return true;
    L9:
        boolean r102 = popBackStackState(this.mTmpRecords, this.mTmpIsPop, r100, r110, r111);
        if (r102 == false) goto L17;
        this.mExecutingActions = true;
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);     // Catch: Throwable -> L14
        cleanupExec();
    L14:
        th = move-exception;
        cleanupExec();
        throw th;
    L17:
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void attachController(FragmentHostCallback<?> r100, FragmentContainer r101, final Fragment r102) {
        if (this.mHost != null) goto L40;
        this.mHost = r100;
        this.mContainer = r101;
        this.mParent = r102;
        if (r102 == null) goto L8;
        addFragmentOnAttachListener(new AnonymousClass6(this, r102));
    L11:
        if (this.mParent == null) goto L14;
        updateOnBackPressedCallbackEnabled();
    L14:
        if ((r100 instanceof OnBackPressedDispatcherOwner) == false) goto L19;
        OnBackPressedDispatcherOwner r103 = (OnBackPressedDispatcherOwner) r100;
        OnBackPressedDispatcher r104 = r103.getOnBackPressedDispatcher();
        this.mOnBackPressedDispatcher = r104;
        LifecycleOwner r105 = r103;
        if (r102 == null) goto L18;
        r105 = r102;
    L18:
        r104.addCallback(r105, this.mOnBackPressedCallback);
    L19:
        if (r102 == null) goto L22;
        this.mNonConfig = r102.mFragmentManager.getChildNonConfig(r102);
    L25:
        this.mNonConfig.setIsStateSaved(isStateSaved());
        this.mFragmentStore.setNonConfig(this.mNonConfig);
        Object r106 = this.mHost;
        if ((r106 instanceof SavedStateRegistryOwner) == false) goto L31;
        if (r102 != null) goto L31;
        SavedStateRegistry r107 = ((SavedStateRegistryOwner) r106).getSavedStateRegistry();
        r107.registerSavedStateProvider(SAVED_STATE_TAG, new d(this));
        Bundle r108 = r107.consumeRestoredStateForKey(SAVED_STATE_TAG);
        if (r108 == null) goto L31;
        restoreSaveStateInternal(r108.getParcelable(SAVED_STATE_TAG));
    L31:
        Object r109 = this.mHost;
        if ((r109 instanceof ActivityResultRegistryOwner) == false) goto L41;
        ActivityResultRegistry r110 = ((ActivityResultRegistryOwner) r109).getActivityResultRegistry();
        if (r102 == null) goto L36;
        String r111 = r102.mWho + ":";
    L37:
        String r112 = "FragmentManager:" + r111;
        this.mStartActivityForResult = r110.register(r112 + "StartActivityForResult", new ActivityResultContracts.StartActivityForResult(), new AnonymousClass7(this));
        this.mStartIntentSenderForResult = r110.register(r112 + "StartIntentSenderForResult", new FragmentIntentSenderContract(), new AnonymousClass8(this));
        this.mRequestPermissions = r110.register(r112 + "RequestPermissions", new ActivityResultContracts.RequestMultiplePermissions(), new AnonymousClass9(this));
        return;
    L36:
        r111 = "";
        goto L37
    L41:
        return;
    L22:
        if ((r100 instanceof ViewModelStoreOwner) == false) goto L24;
        this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner) r100).getViewModelStore());
        goto L25
    L24:
        this.mNonConfig = new FragmentManagerViewModel(false);
        goto L25
    L8:
        if ((r100 instanceof FragmentOnAttachListener) == false) goto L11;
        addFragmentOnAttachListener((FragmentOnAttachListener) r100);
        goto L11
    L40:
        throw new IllegalStateException("Already attached");
    }

    public boolean clearBackStackState(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101, String r102) {
        if (restoreBackStackState(r100, r101, r102) == true) goto L7;
        return false;
    L7:
        return popBackStackState(r100, r101, r102, -1, 1);
    }

    public void launchRequestPermissions(Fragment r100, String[] r101, int r102) {
        if (this.mRequestPermissions == null) goto L5;
        LaunchedFragmentInfo r103 = new LaunchedFragmentInfo(r100.mWho, r102);
        this.mLaunchedFragments.addLast(r103);
        this.mRequestPermissions.launch(r101);
        return;
    L5:
        this.mHost.onRequestPermissionsFromFragment(r100, r101, r102);
    }

    public void popBackStack(int r100, int r101, boolean r102) {
        if (r100 < 0) goto L6;
        enqueueAction(new PopBackStackState(this, null, r100, r101), r102);
        return;
    L6:
        throw new IllegalArgumentException("Bad id: " + r100);
    }

    public void putFragment(Bundle r100, String r101, Fragment r102) {
        if (r102.mFragmentManager == this) goto L5;
        throwException(new IllegalStateException("Fragment " + r102 + " is not currently in the FragmentManager"));
    L5:
        r100.putString(r101, r102.mWho);
    }

    public boolean restoreBackStackState(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101, String r102) {
        BackStackState r103 = this.mBackStackStates.remove(r102);
        if (r103 != null) goto L5;
        return false;
    L5:
        HashMap r104 = new HashMap();
        Iterator<BackStackRecord> r105 = r100.iterator();
    L7:
        if (r105.hasNext() == false) goto L16;
        BackStackRecord r106 = r105.next();
        if (r106.mBeingSaved == false) goto L7;
        Iterator<FragmentTransaction.Op> r107 = r106.mOps.iterator();
    L12:
        if (r107.hasNext() == false) goto L7;
        Fragment r108 = r107.next().mFragment;
        if (r108 == null) goto L12;
        r104.put(r108.mWho, r108);
        goto L12
    L16:
        Iterator<BackStackRecord> r109 = r103.instantiate(this, r104).iterator();
    L17:
        boolean r110 = false;
    L19:
        if (r109.hasNext() == false) goto L24;
        if (r109.next().generateOps(r100, r101) == true) goto L23;
        if (r110 == false) goto L17;
    L23:
        r110 = true;
        goto L19
    L24:
        return r110;
    }

    public boolean saveBackStackState(ArrayList<BackStackRecord> r110, ArrayList<Boolean> r111, String r112) {
        int r100 = findBackStackIndex(r112, -1, true);
        if (r100 >= 0) goto L6;
        return false;
    L6:
        int r101 = r100;
    L8:
        if (r101 >= this.mBackStack.size()) goto L13;
        BackStackRecord r102 = (BackStackRecord) ListProtector.get(this.mBackStack, r101);
        if (r102.mReorderingAllowed == true) goto L12;
        throwException(new IllegalArgumentException("saveBackStack(\"" + r112 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + r102 + " that did not use setReorderingAllowed(true)."));
    L12:
        r101 = r101 + 1;
        goto L8
    L13:
        HashSet r103 = new HashSet();
        int r104 = r100;
    L15:
        if (r104 >= this.mBackStack.size()) goto L42;
        BackStackRecord r105 = (BackStackRecord) ListProtector.get(this.mBackStack, r104);
        HashSet r106 = new HashSet();
        HashSet r107 = new HashSet();
        Iterator<FragmentTransaction.Op> r113 = r105.mOps.iterator();
    L18:
        if (r113.hasNext() == false) goto L34;
        FragmentTransaction.Op r114 = r113.next();
        Fragment r115 = r114.mFragment;
        if (r115 == null) goto L18;
        if (r114.mFromExpandedOp == false) goto L29;
        int r116 = r114.mCmd;
        if (r116 == 1) goto L29;
        if (r116 == 2) goto L29;
        if (r116 == 8) goto L29;
    L30:
        int r117 = r114.mCmd;
        if (r117 == 1) goto L33;
        if (r117 != 2) goto L18;
    L33:
        r107.add(r115);
    L29:
        r103.add(r115);
        r106.add(r115);
        goto L30
    L34:
        r106.removeAll(r107);
        if (r106.isEmpty() == true) goto L41;
        StringBuilder r118 = new StringBuilder("saveBackStack(\"");
        r118.append(r112);
        r118.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
        if (r106.size() != 1) goto L39;
        String r108 = " " + r106.iterator().next();
    L40:
        r118.append(r108);
        r118.append(" in ");
        r118.append(r105);
        r118.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
        throwException(new IllegalArgumentException(r118.toString()));
        goto L41
    L39:
        r108 = "s " + r106;
    L41:
        r104 = r104 + 1;
        goto L15
    L42:
        ArrayDeque r109 = new ArrayDeque(r103);
    L44:
        if (r109.isEmpty() == true) goto L58;
        Fragment r119 = (Fragment) r109.removeFirst();
        if (r119.mRetainInstance == false) goto L52;
        StringBuilder r120 = new StringBuilder("saveBackStack(\"");
        r120.append(r112);
        r120.append("\") must not contain retained fragments. Found ");
        if (r103.contains(r119) == false) goto L50;
        String r121 = "direct reference to retained ";
    L51:
        r120.append(r121);
        r120.append("fragment ");
        r120.append(r119);
        throwException(new IllegalArgumentException(r120.toString()));
        goto L52
    L50:
        r121 = "retained child ";
    L52:
        Iterator<Fragment> r122 = r119.mChildFragmentManager.getActiveFragments().iterator();
    L54:
        if (r122.hasNext() == false) goto L44;
        Fragment r123 = r122.next();
        if (r123 == null) goto L54;
        r109.addLast(r123);
        goto L54
    L58:
        ArrayList r124 = new ArrayList();
        Iterator r125 = r103.iterator();
    L60:
        if (r125.hasNext() == false) goto L62;
        r124.add(((Fragment) r125.next()).mWho);
        goto L60
    L62:
        ArrayList r126 = new ArrayList(this.mBackStack.size() - r100);
        int r127 = r100;
    L64:
        if (r127 >= this.mBackStack.size()) goto L66;
        r126.add(null);
        r127 = r127 + 1;
        goto L64
    L66:
        BackStackState r128 = new BackStackState(r124, r126);
        int r129 = this.mBackStack.size() - 1;
    L67:
        if (r129 < r100) goto L69;
        BackStackRecord r130 = (BackStackRecord) ListProtector.remove(this.mBackStack, r129);
        BackStackRecord r131 = new BackStackRecord(r130);
        r131.collapseOps();
        ListProtector.set(r126, r129 - r100, new BackStackRecordState(r131));
        r130.mBeingSaved = true;
        r110.add(r130);
        r111.add(Boolean.TRUE);
        r129 = r129 - 1;
        goto L67
    L69:
        this.mBackStackStates.put(r112, r128);
        return true;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(final String r100, LifecycleOwner r101, final FragmentResultListener r102) {
        final Lifecycle r103 = r101.getLifecycle();
        if (r103.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        LifecycleEventObserver r104 = new AnonymousClass5(this, r100, r102, r103);
        r103.addObserver(r104);
        LifecycleAwareResultListener r105 = this.mResultListeners.put(r100, new LifecycleAwareResultListener(r103, r102, r104));
        if (r105 == null) goto L9;
        r105.removeObserver();
    L9:
        if (isLoggingEnabled(2) == false) goto L12;
        r103.toString();
        Objects.toString(r102);
        return;
    }

    private static void executeOps(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101, int r102, int r103) {
    L2:
        if (r102 >= r103) goto L8;
        BackStackRecord r104 = (BackStackRecord) ListProtector.get(r100, r102);
        if (((Boolean) ListProtector.get(r101, r102)).booleanValue() == false) goto L6;
        r104.bumpBackStackNesting(-1);
        r104.executePopOps();
    L7:
        r102 = r102 + 1;
        goto L2
    L6:
        r104.bumpBackStackNesting(1);
        r104.executeOps();
        goto L7
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r110, int r111, int r112) {
        boolean r101 = ((BackStackRecord) ListProtector.get(r100, r111)).mReorderingAllowed;
        ArrayList<Fragment> r102 = this.mTmpAddedFragments;
        if (r102 != null) goto L5;
        this.mTmpAddedFragments = new ArrayList();
    L6:
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment r103 = getPrimaryNavigationFragment();
        int r104 = r111;
        boolean r105 = false;
    L8:
        if (r104 >= r112) goto L20;
        BackStackRecord r106 = (BackStackRecord) ListProtector.get(r100, r104);
        if (((Boolean) ListProtector.get(r110, r104)).booleanValue() == true) goto L12;
        r103 = r106.expandOps(this.mTmpAddedFragments, r103);
    L13:
        if (r105 == false) goto L15;
    L18:
        r105 = true;
    L19:
        r104 = r104 + 1;
        goto L8
    L15:
        if (r106.mAddToBackStack == true) goto L18;
        r105 = false;
        goto L19
    L12:
        r103 = r106.trackAddedFragmentsInPop(this.mTmpAddedFragments, r103);
        goto L13
    L20:
        this.mTmpAddedFragments.clear();
        if (r101 == false) goto L23;
    L35:
        executeOps(r100, r110, r111, r112);
        boolean r107 = ((Boolean) ListProtector.get(r110, r112 - 1)).booleanValue();
        int r108 = r111;
    L36:
        if (r108 >= r112) goto L52;
        BackStackRecord r109 = (BackStackRecord) ListProtector.get(r100, r108);
        if (r107 == false) goto L45;
        int r113 = r109.mOps.size() - 1;
    L40:
        if (r113 < 0) goto L51;
        Fragment r114 = ((FragmentTransaction.Op) ListProtector.get(r109.mOps, r113)).mFragment;
        if (r114 == null) goto L44;
        createOrGetFragmentStateManager(r114).moveToExpectedState();
    L44:
        r113 = r113 - 1;
    L51:
        r108 = r108 + 1;
        goto L36
    L45:
        Iterator<FragmentTransaction.Op> r115 = r109.mOps.iterator();
    L47:
        if (r115.hasNext() == false) goto L51;
        Fragment r116 = r115.next().mFragment;
        if (r116 == null) goto L47;
        createOrGetFragmentStateManager(r116).moveToExpectedState();
        goto L47
    L52:
        moveToState(this.mCurState, true);
        Iterator<SpecialEffectsController> r117 = collectChangedControllers(r100, r111, r112).iterator();
    L54:
        if (r117.hasNext() == false) goto L56;
        SpecialEffectsController r118 = r117.next();
        r118.updateOperationDirection(r107);
        r118.markPostponedState();
        r118.executePendingOperations();
    L56:
        if (r111 >= r112) goto L63;
        BackStackRecord r119 = (BackStackRecord) ListProtector.get(r100, r111);
        if (((Boolean) ListProtector.get(r110, r111)).booleanValue() == false) goto L62;
        if (r119.mIndex < 0) goto L62;
        r119.mIndex = -1;
    L62:
        r119.runOnCommitRunnables();
        r111 = r111 + 1;
        goto L56
    L63:
        if (r105 == false) goto L91;
        reportBackStackChanged();
        return;
    L91:
        return;
    L23:
        if (this.mCurState < 1) goto L35;
        int r120 = r111;
    L25:
        if (r120 >= r112) goto L35;
        Iterator<FragmentTransaction.Op> r121 = ((BackStackRecord) ListProtector.get(r100, r120)).mOps.iterator();
    L28:
        if (r121.hasNext() == false) goto L34;
        Fragment r122 = r121.next().mFragment;
        if (r122 == null) goto L28;
        if (r122.mFragmentManager == null) goto L28;
        this.mFragmentStore.makeActive(createOrGetFragmentStateManager(r122));
        goto L28
    L34:
        r120 = r120 + 1;
        goto L25
    L5:
        r102.clear();
        goto L6
    }

    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        String r104 = r100 + LineContent.FOUR_SPACE;
        this.mFragmentStore.dump(r100, r101, r102, r103);
        ArrayList<Fragment> r105 = this.mCreatedMenus;
        int r106 = 0;
        if (r105 == null) goto L9;
        int r107 = r105.size();
        if (r107 <= 0) goto L9;
        r102.print(r100);
        r102.println("Fragments Created Menus:");
        int r108 = 0;
    L7:
        if (r108 >= r107) goto L9;
        Fragment r109 = (Fragment) ListProtector.get(this.mCreatedMenus, r108);
        r102.print(r100);
        r102.print("  #");
        r102.print(r108);
        r102.print(": ");
        r102.println(r109.toString());
        r108 = r108 + 1;
    L9:
        ArrayList<BackStackRecord> r110 = this.mBackStack;
        if (r110 == null) goto L16;
        int r111 = r110.size();
        if (r111 <= 0) goto L16;
        r102.print(r100);
        r102.println("Back Stack:");
        int r112 = 0;
    L14:
        if (r112 >= r111) goto L16;
        BackStackRecord r113 = (BackStackRecord) ListProtector.get(this.mBackStack, r112);
        r102.print(r100);
        r102.print("  #");
        r102.print(r112);
        r102.print(": ");
        r102.println(r113.toString());
        r113.dump(r104, r102);
        r112 = r112 + 1;
    L16:
        r102.print(r100);
        r102.println("Back Stack Index: " + this.mBackStackIndex.get());
        ArrayList<OpGenerator> r114 = this.mPendingActions;
        monitor-enter(r114);
        int r115 = this.mPendingActions.size();     // Catch: Throwable -> L31
        if (r115 <= 0) goto L23;
        r102.print(r100);     // Catch: Throwable -> L31
        r102.println("Pending Actions:");     // Catch: Throwable -> L31
    L21:
        if (r106 >= r115) goto L23;
        OpGenerator r116 = this.mPendingActions.get(r106);     // Catch: Throwable -> L31
        r102.print(r100);     // Catch: Throwable -> L31
        r102.print("  #");     // Catch: Throwable -> L31
        r102.print(r106);     // Catch: Throwable -> L31
        r102.print(": ");     // Catch: Throwable -> L31
        r102.println(r116);     // Catch: Throwable -> L31
        r106 = r106 + 1;     // Catch: Throwable -> L31
    L23:
        monitor-exit(r114);     // Catch: Throwable -> L31
        r102.print(r100);
        r102.println("FragmentManager misc state:");
        r102.print(r100);
        r102.print("  mHost=");
        r102.println(this.mHost);
        r102.print(r100);
        r102.print("  mContainer=");
        r102.println(this.mContainer);
        if (this.mParent == null) goto L27;
        r102.print(r100);
        r102.print("  mParent=");
        r102.println(this.mParent);
    L27:
        r102.print(r100);
        r102.print("  mCurState=");
        r102.print(this.mCurState);
        r102.print(" mStateSaved=");
        r102.print(this.mStateSaved);
        r102.print(" mStopped=");
        r102.print(this.mStopped);
        r102.print(" mDestroyed=");
        r102.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate == false) goto L39;
        r102.print(r100);
        r102.print("  mNeedMenuInvalidate=");
        r102.println(this.mNeedMenuInvalidate);
        return;
    L39:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    public void launchStartActivityForResult(Fragment r100, Intent r101, int r102, Bundle r103) {
        if (this.mStartActivityForResult == null) goto L9;
        LaunchedFragmentInfo r104 = new LaunchedFragmentInfo(r100.mWho, r102);
        this.mLaunchedFragments.addLast(r104);
        if (r101 == null) goto L8;
        if (r103 == null) goto L8;
        r101.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r103);
    L8:
        this.mStartActivityForResult.launch(r101);
        return;
    L9:
        this.mHost.onStartActivityFromFragment(r100, r101, r102, r103);
    }

    public boolean popBackStackState(ArrayList<BackStackRecord> r100, ArrayList<Boolean> r101, String r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        boolean r105 = true;
    L6:
        int r106 = findBackStackIndex(r102, r103, r105);
        if (r106 >= 0) goto L9;
        return false;
    L9:
        int r107 = this.mBackStack.size() - 1;
    L10:
        if (r107 < r106) goto L12;
        r100.add((BackStackRecord) ListProtector.remove(this.mBackStack, r107));
        r101.add(Boolean.TRUE);
        r107 = r107 - 1;
        goto L10
    L12:
        return true;
    L5:
        r105 = false;
        goto L6
    }

    public void launchStartIntentSenderForResult(Fragment r110, IntentSender r111, int r112, Intent r113, int r114, int r115, int r116, Bundle r117) throws IntentSender.SendIntentException {
        if (this.mStartIntentSenderForResult != null) goto L5;
        this.mHost.onStartIntentSenderFromFragment(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    L5:
        if (r117 == null) goto L13;
        if (r113 != null) goto L8;
        Intent r100 = new Intent();
        r100.putExtra(EXTRA_CREATED_FILLIN_INTENT, true);
    L10:
        if (isLoggingEnabled(2) == false) goto L12;
        r117.toString();
        r100.toString();
        Objects.toString(r110);
    L12:
        r100.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, r117);
    L14:
        IntentSenderRequest r101 = new IntentSenderRequest.Builder(r111).setFillInIntent(r100).setFlags(r115, r114).build();
        LaunchedFragmentInfo r102 = new LaunchedFragmentInfo(r110.mWho, r112);
        this.mLaunchedFragments.addLast(r102);
        if (isLoggingEnabled(2) == false) goto L17;
        r110.toString();
    L17:
        this.mStartIntentSenderForResult.launch(r101);
        return;
    L8:
        r100 = r113;
        goto L10
    L13:
        r100 = r113;
        goto L14
    }
}
