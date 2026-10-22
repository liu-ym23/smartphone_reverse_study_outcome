package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    /* JADX INFO: loaded from: classes17.dex */
    public class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener {
        final /* synthetic */ FragmentActivity this$0;

        @Override // androidx.activity.result.ActivityResultRegistryOwner
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.this$0.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.this$0.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.this$0.getOnBackPressedDispatcher();
        }

        @Override // androidx.savedstate.SavedStateRegistryOwner
        public SavedStateRegistry getSavedStateRegistry() {
            return this.this$0.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public ViewModelStore getViewModelStore() {
            return this.this$0.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public LayoutInflater onGetLayoutInflater() {
            return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public int onGetWindowAnimations() {
            Window r100 = this.this$0.getWindow();
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            Window r100 = this.this$0.getWindow();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.peekDecorView() == null) goto L7;
            return true;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onHasWindowAnimations() {
            if (this.this$0.getWindow() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onSupportInvalidateOptionsMenu() {
            this.this$0.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public /* bridge */ /* synthetic */ FragmentActivity onGetHost() {
            return onGetHost();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.fragment.app.FragmentHostCallback
        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        public HostCallbacks(FragmentActivity r100) {
            this.this$0 = r100;
            super(r100);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        public View onFindViewById(int r100) {
            return this.this$0.findViewById(r100);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldSaveFragmentState(Fragment r100) {
            return !this.this$0.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public boolean onShouldShowRequestPermissionRationale(String r100) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, r100);
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(FragmentManager r100, Fragment r101) {
            this.this$0.onAttachFragment(r101);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public void onDump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
            this.this$0.dump(r100, r101, r102, r103);
        }
    }

    public static /* synthetic */ void access$000(ComponentActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    public static /* synthetic */ void w1(FragmentActivity r100, Context r101) {
        r100.lambda$init$1(r101);
    }

    public static /* synthetic */ Bundle x1(FragmentActivity r100) {
        return r100.lambda$init$0();
    }

    public void androidx_fragment_app_FragmentActivity__finish$___twin___() {
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        androidx_fragment_app_FragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onAttachFragment(Fragment r100) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        androidx_fragment_app_FragmentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    public final void validateRequestPermissionsRequestCode(int r100) {
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (this.mCreated == true) goto L5;
        this.mCreated = true;
        this.mFragments.dispatchActivityCreated();
    L5:
        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mFragments.dispatchStart();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    public FragmentActivity() {
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(LIFECYCLE_TAG, new a(this));
        addOnContextAvailableListener(new b(this));
    }

    private /* synthetic */ Bundle lambda$init$0() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void markFragmentsCreated() {
    L3:
        if (markState(getSupportFragmentManager(), Lifecycle.State.CREATED) == true) goto L3;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    public FragmentActivity(int r100) {
        super(r100);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    public static void androidx_fragment_app_FragmentActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(FragmentActivity r110) {
        r110.androidx_fragment_app_FragmentActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$init$1(Context r100) {
        this.mFragments.attachHost(null);
    }

    public void androidx_fragment_app_FragmentActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        this.mFragments.noteStateNotSaved();
        INVOKESPECIAL_androidx_fragment_app_FragmentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        this.mFragments.dispatchConfigurationChanged(r100);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean r100) {
        this.mFragments.dispatchMultiWindowModeChanged(r100);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r100) {
        this.mFragments.noteStateNotSaved();
        super.onNewIntent(r100);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean r100) {
        this.mFragments.dispatchPictureInPictureModeChanged(r100);
    }

    public void setEnterSharedElementCallback(SharedElementCallback r100) {
        ActivityCompat.setEnterSharedElementCallback(this, r100);
    }

    public void setExitSharedElementCallback(SharedElementCallback r100) {
        ActivityCompat.setExitSharedElementCallback(this, r100);
    }

    public static void INVOKESPECIAL_androidx_fragment_app_FragmentActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(ComponentActivity r100, Configuration r101) {
        access$000(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static void androidx_fragment_app_FragmentActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(FragmentActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.androidx_fragment_app_FragmentActivity__onCreate$___twin___(r101);
    }

    private static boolean markState(FragmentManager r100, Lifecycle.State r101) {
        Iterator<Fragment> r102 = r100.getFragments().iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L19;
        Fragment r104 = r102.next();
        if (r104 == null) goto L4;
        if (r104.getHost() == null) goto L11;
        r103 = r103 | markState(r104.getChildFragmentManager(), r101);
    L11:
        FragmentViewLifecycleOwner r105 = r104.mViewLifecycleOwner;
        if (r105 == null) goto L17;
        if (r105.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L17;
        r104.mViewLifecycleOwner.setCurrentState(r101);
        r103 = true;
    L17:
        if (r104.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L4;
        r104.mLifecycleRegistry.setCurrentState(r101);
        r103 = true;
        goto L4
    L19:
        return r103;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r100, Menu r101) {
        if (r100 != 0) goto L6;
        return super.onCreatePanelMenu(r100, r101) | this.mFragments.dispatchCreateOptionsMenu(r101, getMenuInflater());
    L6:
        return super.onCreatePanelMenu(r100, r101);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r100, MenuItem r101) {
        if (super.onMenuItemSelected(r100, r101) == false) goto L6;
        return true;
    L6:
        if (r100 == 0) goto L14;
        if (r100 == 6) goto L12;
        return false;
    L12:
        return this.mFragments.dispatchContextItemSelected(r101);
    L14:
        return this.mFragments.dispatchOptionsItemSelected(r101);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r100, Menu r101) {
        if (r100 != 0) goto L4;
        this.mFragments.dispatchOptionsMenuClosed(r101);
    L4:
        super.onPanelClosed(r100, r101);
    }

    public boolean onPrepareOptionsPanel(View r100, Menu r101) {
        return super.onPreparePanel(0, r100, r101);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r100, int r101, Intent r102) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(r100, r101, r102);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String r100, Context r101, AttributeSet r102) {
        View r103 = dispatchFragmentsOnCreateView(null, r100, r101, r102);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return super.onCreateView(r100, r101, r102);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r100, View r101, Menu r102) {
        if (r100 != 0) goto L6;
        return onPrepareOptionsPanel(r101, r102) | this.mFragments.dispatchPrepareOptionsMenu(r102);
    L6:
        return super.onPreparePanel(r100, r101, r102);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        this.mFragments.noteStateNotSaved();
        androidx_fragment_app_FragmentActivity_androidx_activity_ComponentActivity_onRequestPermissionsResult_super(this, r100, r101, r102);
    }

    public void startActivityFromFragment(Fragment r100, Intent r101, int r102) {
        startActivityFromFragment(r100, r101, r102, null);
    }

    private static void androidx_fragment_app_FragmentActivity_androidx_activity_ComponentActivity_onRequestPermissionsResult_super(ComponentActivity r110, int r111, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102611);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102611, "androidx/activity/ComponentActivity", "onRequestPermissionsResult", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final View dispatchFragmentsOnCreateView(View r100, String r101, Context r102, AttributeSet r103) {
        return this.mFragments.onCreateView(r100, r101, r102, r103);
    }

    @Override // android.app.Activity
    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        super.dump(r100, r101, r102, r103);
        r102.print(r100);
        r102.print("Local FragmentActivity ");
        r102.print(Integer.toHexString(System.identityHashCode(this)));
        r102.println(" State:");
        String r104 = r100 + tb2.c.DEFAULT_TEXT;
        r102.print(r104);
        r102.print("mCreated=");
        r102.print(this.mCreated);
        r102.print(" mResumed=");
        r102.print(this.mResumed);
        r102.print(" mStopped=");
        r102.print(this.mStopped);
        if (getApplication() == null) goto L5;
        LoaderManager.getInstance(this).dump(r104, r101, r102, r103);
    L5:
        this.mFragments.getSupportFragmentManager().dump(r100, r101, r102, r103);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r100, String r101, Context r102, AttributeSet r103) {
        View r104 = dispatchFragmentsOnCreateView(r100, r101, r102, r103);
        if (r104 == null) goto L5;
        return r104;
    L5:
        return super.onCreateView(r100, r101, r102, r103);
    }

    public void startActivityFromFragment(Fragment r100, Intent r101, int r102, Bundle r103) {
        if (r102 != (-1)) goto L6;
        ActivityCompat.startActivityForResult(this, r101, -1, r103);
        return;
    L6:
        r100.startActivityForResult(r101, r102, r103);
    }

    public void startIntentSenderFromFragment(Fragment r110, IntentSender r111, int r112, Intent r113, int r114, int r115, int r116, Bundle r117) throws IntentSender.SendIntentException {
        if (r112 != (-1)) goto L6;
        ActivityCompat.startIntentSenderForResult(this, r111, r112, r113, r114, r115, r116, r117);
        return;
    L6:
        r110.startIntentSenderForResult(r111, r112, r113, r114, r115, r116, r117);
    }
}
