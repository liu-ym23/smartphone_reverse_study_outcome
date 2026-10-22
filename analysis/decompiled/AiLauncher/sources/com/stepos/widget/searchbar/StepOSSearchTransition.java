package com.stepos.widget.searchbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.view.D;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.widget.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004OPQRB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0013J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0003¢\u0006\u0004\b&\u0010%J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0004\b*\u0010)J\u0017\u0010+\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0004\b+\u0010)J\u0017\u0010,\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b/\u0010\u0019J\u0019\u00101\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u00102J'\u00104\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0016H\u0002¢\u0006\u0004\b4\u00105R\u0014\u00106\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u0010:\u001a\u0002098\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00107R\u0014\u0010=\u001a\u0002098\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010>\u001a\u0002098\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010;R\u0014\u0010?\u001a\u0002098\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010;R\u0014\u0010@\u001a\u0002098\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010;R\u0014\u0010B\u001a\u00020A8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020A8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010CR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006S"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchTransition;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lcom/stepos/widget/searchbar/StepOSSearchBar;", "searchBar", "Landroid/content/Intent;", "intent", "", "sharedElementName", "LY8/t;", "startSearchActivity", "(Landroid/app/Activity;Lcom/stepos/widget/searchbar/StepOSSearchBar;Landroid/content/Intent;Ljava/lang/String;)V", "Landroid/view/View;", "sharedElement", "(Landroid/app/Activity;Landroid/view/View;Ljava/lang/String;Landroid/content/Intent;)V", "freezeOutgoingWindow", "(Landroid/app/Activity;)V", "Landroid/transition/Transition$TransitionListener;", "listener", "Landroid/transition/Transition;", "setupSearchEnterTransition", "(Landroid/app/Activity;Lcom/stepos/widget/searchbar/StepOSSearchBar;Landroid/transition/Transition$TransitionListener;)Landroid/transition/Transition;", "(Landroid/app/Activity;Landroid/transition/Transition$TransitionListener;)Landroid/transition/Transition;", "finishSearchActivity", "", "isSearchSharedElementTransition", "(Landroid/app/Activity;)Z", "interceptSystemBack", "holdReturnBackdrop", "releaseReturnBackdrop", "Landroid/window/OnBackInvokedDispatcher;", "dispatcher", "Landroid/window/OnBackInvokedCallback;", "legacyBackCallback", "(Landroid/app/Activity;Landroid/window/OnBackInvokedDispatcher;)Landroid/window/OnBackInvokedCallback;", "predictiveBackCallback", "view", "startSearchEnterAnimation", "(Landroid/view/View;)V", "startSearchExitAnimation", "startSearchEmptyEnterAnimation", "startSearchEmptyExitAnimation", "sharedElementNameFromIntent", "(Landroid/app/Activity;)Ljava/lang/String;", "buildAndInstallTransition", Parameters.ROOT, "findSearchBar", "(Landroid/view/View;)Lcom/stepos/widget/searchbar/StepOSSearchBar;", "transition", "armEnterBackdrop", "(Landroid/app/Activity;Lcom/stepos/widget/searchbar/StepOSSearchBar;Landroid/transition/Transition;)V", "EXTRA_SHARED_ELEMENT_NAME", "Ljava/lang/String;", "DEFAULT_SHARED_ELEMENT_NAME", "", "SHARED_ELEMENT_TARGET_TIMEOUT_MS", "J", "TAG", "SEARCH_TRANSLATION_DURATION", "SEARCH_ALPHA_DURATION", "SEARCH_ALPHA_SEARCH_DURATION", "SEARCH_ALPHA_DELAY", "", "SEARCH_ACTION_BAR_TRANSLATION_Y", "F", "SEARCH_CONTENT_TRANSLATION_Y", "Landroid/view/animation/PathInterpolator;", "PATH_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "PATH_INTERPOLATOR_Y", "", "backIntercepted", "Ljava/util/Set;", "Landroid/app/SharedElementCallback;", "whiteSnapshotCallback", "Landroid/app/SharedElementCallback;", "SearchBarTargetStarter", "TreeSearchTargetStarter", "UnfreezeOnResume", "ReleaseSearchBackdropOnResume", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSSearchTransition {
    public static final String DEFAULT_SHARED_ELEMENT_NAME = "stepos_search_capsule";
    private static final String EXTRA_SHARED_ELEMENT_NAME = "com.stepos.widget.extra.SEARCH_SHARED_ELEMENT_NAME";
    public static final StepOSSearchTransition INSTANCE = new StepOSSearchTransition();
    private static final PathInterpolator PATH_INTERPOLATOR = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    private static final PathInterpolator PATH_INTERPOLATOR_Y = new PathInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
    private static final float SEARCH_ACTION_BAR_TRANSLATION_Y = 224.0f;
    private static final long SEARCH_ALPHA_DELAY = 50;
    private static final long SEARCH_ALPHA_DURATION = 100;
    private static final long SEARCH_ALPHA_SEARCH_DURATION = 250;
    private static final float SEARCH_CONTENT_TRANSLATION_Y = 512.0f;
    private static final long SEARCH_TRANSLATION_DURATION = 350;
    private static final long SHARED_ELEMENT_TARGET_TIMEOUT_MS = 2000;
    private static final String TAG = "StepOSGlass";
    private static final Set<Activity> backIntercepted;
    private static final SharedElementCallback whiteSnapshotCallback;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0010R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00040\u00040\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchTransition$ReleaseSearchBackdropOnResume;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Lcom/stepos/widget/searchbar/StepOSSearchBar;", "searchBar", "<init>", "(Landroid/app/Activity;Lcom/stepos/widget/searchbar/StepOSSearchBar;)V", "LY8/t;", "release", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "activityRef", "Ljava/lang/ref/WeakReference;", "searchBarRef", "", "done", "Z", "returnStarted", "Landroid/transition/Transition;", "returnTransition", "Landroid/transition/Transition;", "Landroid/transition/Transition$TransitionListener;", "returnListener", "Landroid/transition/Transition$TransitionListener;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ReleaseSearchBackdropOnResume implements Application.ActivityLifecycleCallbacks {
        private final WeakReference<Activity> activityRef;
        private boolean done;
        private Transition.TransitionListener returnListener;
        private boolean returnStarted;
        private Transition returnTransition;
        private final WeakReference<StepOSSearchBar> searchBarRef;

        public ReleaseSearchBackdropOnResume(Activity activity, StepOSSearchBar searchBar) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(searchBar, "searchBar");
            this.activityRef = new WeakReference<>(activity);
            this.searchBarRef = new WeakReference<>(searchBar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void release() {
            Application application;
            if (this.done) {
                return;
            }
            this.done = true;
            StepOSSearchBar stepOSSearchBar = this.searchBarRef.get();
            if (stepOSSearchBar != null) {
                stepOSSearchBar.setTransitionBackdropHolding$StepOSWidget_release(false);
            }
            Activity activity = this.activityRef.get();
            if (activity != null) {
                activity.setExitSharedElementCallback(null);
            }
            Activity activity2 = this.activityRef.get();
            if (activity2 == null || (application = activity2.getApplication()) == null) {
                return;
            }
            application.unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            if (activity == this.activityRef.get()) {
                release();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            if (activity != this.activityRef.get() || this.done || this.returnStarted) {
                return;
            }
            Transition transition = this.returnTransition;
            Transition.TransitionListener transitionListener = this.returnListener;
            if (transition != null && transitionListener != null) {
                transition.removeListener(transitionListener);
            }
            this.returnTransition = null;
            this.returnListener = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            if (activity == this.activityRef.get() && !this.done && this.returnListener == null) {
                Transition sharedElementReenterTransition = activity.getWindow().getSharedElementReenterTransition();
                if (sharedElementReenterTransition == null && (sharedElementReenterTransition = activity.getWindow().getSharedElementReturnTransition()) == null) {
                    sharedElementReenterTransition = activity.getWindow().getSharedElementExitTransition();
                }
                if (sharedElementReenterTransition == null) {
                    release();
                    return;
                }
                StepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1 stepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1 = new StepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1(this, activity);
                this.returnTransition = sharedElementReenterTransition;
                this.returnListener = stepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1;
                sharedElementReenterTransition.addListener(stepOSSearchTransition$ReleaseSearchBackdropOnResume$onActivityResumed$listener$1);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00030\u00030\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00050\u00050\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR'\u0010\u001f\u001a\u0015\u0012\u0011\u0012\u000f \u001a*\u0004\u0018\u00010\u000b0\u000b¢\u0006\u0002\b\u001e0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010 \u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchTransition$SearchBarTargetStarter;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Ljava/lang/Runnable;", "Landroid/app/Activity;", "activity", "Lcom/stepos/widget/searchbar/StepOSSearchBar;", "searchBar", "", "sharedElementName", "<init>", "(Landroid/app/Activity;Lcom/stepos/widget/searchbar/StepOSSearchBar;Ljava/lang/String;)V", "Landroid/view/View;", "currentDecor", "()Landroid/view/View;", "", "startTransition", "LY8/t;", "complete", "(Z)V", "attach", "()V", "onPreDraw", "()Z", "run", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "activityRef", "Ljava/lang/ref/WeakReference;", "searchBarRef", "Lkotlin/jvm/internal/EnhancedNullability;", "decorRef", "completed", "Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SearchBarTargetStarter implements ViewTreeObserver.OnPreDrawListener, Runnable {
        private final WeakReference<Activity> activityRef;
        private boolean completed;
        private final WeakReference<View> decorRef;
        private final WeakReference<StepOSSearchBar> searchBarRef;
        private final String sharedElementName;

        public SearchBarTargetStarter(Activity activity, StepOSSearchBar searchBar, String sharedElementName) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(searchBar, "searchBar");
            kotlin.jvm.internal.p.i(sharedElementName, "sharedElementName");
            this.sharedElementName = sharedElementName;
            this.activityRef = new WeakReference<>(activity);
            this.searchBarRef = new WeakReference<>(searchBar);
            this.decorRef = new WeakReference<>(activity.getWindow().getDecorView());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void complete(boolean startTransition) {
            Activity activity;
            ViewTreeObserver viewTreeObserver;
            if (this.completed) {
                return;
            }
            this.completed = true;
            View viewCurrentDecor = currentDecor();
            if (viewCurrentDecor != null && (viewTreeObserver = viewCurrentDecor.getViewTreeObserver()) != null) {
                if (!viewTreeObserver.isAlive()) {
                    viewTreeObserver = null;
                }
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
            }
            if (viewCurrentDecor != null) {
                viewCurrentDecor.removeCallbacks(this);
            }
            if (!startTransition || (activity = this.activityRef.get()) == null) {
                return;
            }
            Activity activity2 = activity.isFinishing() ? null : activity;
            if (activity2 != null) {
                activity2.startPostponedEnterTransition();
            }
        }

        private final View currentDecor() {
            Window window;
            View decorView;
            Activity activity = this.activityRef.get();
            return (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? this.decorRef.get() : decorView;
        }

        public final void attach() {
            View viewCurrentDecor;
            Activity activity = this.activityRef.get();
            if (activity == null || activity.isFinishing() || (viewCurrentDecor = currentDecor()) == null) {
                return;
            }
            activity.postponeEnterTransition();
            viewCurrentDecor.getViewTreeObserver().addOnPreDrawListener(this);
            viewCurrentDecor.postDelayed(this, 2000L);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Activity activity = this.activityRef.get();
            StepOSSearchBar stepOSSearchBar = this.searchBarRef.get();
            if (activity == null || activity.isFinishing() || stepOSSearchBar == null) {
                complete(false);
                return true;
            }
            View transitionSharedElement$StepOSWidget_release = stepOSSearchBar.getTransitionSharedElement$StepOSWidget_release();
            if (transitionSharedElement$StepOSWidget_release.isAttachedToWindow() && transitionSharedElement$StepOSWidget_release.getWidth() > 0 && transitionSharedElement$StepOSWidget_release.getHeight() > 0) {
                transitionSharedElement$StepOSWidget_release.setTransitionName(this.sharedElementName);
                transitionSharedElement$StepOSWidget_release.post(new Runnable() { // from class: com.stepos.widget.searchbar.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31360a.complete(true);
                    }
                });
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            complete(true);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\"\u0010 \u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00030\u00030\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R'\u0010#\u001a\u0015\u0012\u0011\u0012\u000f \u001f*\u0004\u0018\u00010\u000b0\u000b¢\u0006\u0002\b\"0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchTransition$TreeSearchTargetStarter;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Ljava/lang/Runnable;", "Landroid/app/Activity;", "activity", "", "sharedElementName", "Landroid/transition/Transition;", "transition", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Landroid/transition/Transition;)V", "Landroid/view/View;", "currentDecor", "()Landroid/view/View;", "", "startTransition", "LY8/t;", "complete", "(Z)V", Parameters.ROOT, "Lcom/stepos/widget/searchbar/StepOSSearchBar;", "findSearchBar", "(Landroid/view/View;)Lcom/stepos/widget/searchbar/StepOSSearchBar;", "attach", "()V", "onPreDraw", "()Z", "run", "Ljava/lang/String;", "Landroid/transition/Transition;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "activityRef", "Ljava/lang/ref/WeakReference;", "Lkotlin/jvm/internal/EnhancedNullability;", "decorRef", "completed", "Z", "backdropArmed", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TreeSearchTargetStarter implements ViewTreeObserver.OnPreDrawListener, Runnable {
        private final WeakReference<Activity> activityRef;
        private boolean backdropArmed;
        private boolean completed;
        private final WeakReference<View> decorRef;
        private final String sharedElementName;
        private final Transition transition;

        public TreeSearchTargetStarter(Activity activity, String sharedElementName, Transition transition) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(sharedElementName, "sharedElementName");
            kotlin.jvm.internal.p.i(transition, "transition");
            this.sharedElementName = sharedElementName;
            this.transition = transition;
            this.activityRef = new WeakReference<>(activity);
            this.decorRef = new WeakReference<>(activity.getWindow().getDecorView());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void complete(boolean startTransition) {
            Activity activity;
            ViewTreeObserver viewTreeObserver;
            if (this.completed) {
                return;
            }
            this.completed = true;
            View viewCurrentDecor = currentDecor();
            if (viewCurrentDecor != null && (viewTreeObserver = viewCurrentDecor.getViewTreeObserver()) != null) {
                if (!viewTreeObserver.isAlive()) {
                    viewTreeObserver = null;
                }
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
            }
            if (viewCurrentDecor != null) {
                viewCurrentDecor.removeCallbacks(this);
            }
            if (!startTransition || (activity = this.activityRef.get()) == null) {
                return;
            }
            Activity activity2 = activity.isFinishing() ? null : activity;
            if (activity2 != null) {
                activity2.startPostponedEnterTransition();
            }
        }

        private final View currentDecor() {
            Window window;
            View decorView;
            Activity activity = this.activityRef.get();
            return (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? this.decorRef.get() : decorView;
        }

        private final StepOSSearchBar findSearchBar(View root) {
            if (root instanceof StepOSSearchBar) {
                return (StepOSSearchBar) root;
            }
            if (!(root instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                StepOSSearchBar stepOSSearchBarFindSearchBar = findSearchBar(childAt);
                if (stepOSSearchBarFindSearchBar != null) {
                    return stepOSSearchBarFindSearchBar;
                }
            }
            return null;
        }

        public final void attach() {
            View viewCurrentDecor;
            Activity activity = this.activityRef.get();
            if (activity == null || activity.isFinishing() || (viewCurrentDecor = currentDecor()) == null) {
                return;
            }
            activity.postponeEnterTransition();
            viewCurrentDecor.getViewTreeObserver().addOnPreDrawListener(this);
            viewCurrentDecor.postDelayed(this, 2000L);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            StepOSSearchBar stepOSSearchBarFindSearchBar;
            Activity activity = this.activityRef.get();
            if (activity == null || activity.isFinishing()) {
                complete(false);
                return true;
            }
            View viewCurrentDecor = currentDecor();
            if (viewCurrentDecor == null || (stepOSSearchBarFindSearchBar = findSearchBar(viewCurrentDecor)) == null) {
                return true;
            }
            View transitionSharedElement$StepOSWidget_release = stepOSSearchBarFindSearchBar.getTransitionSharedElement$StepOSWidget_release();
            if (transitionSharedElement$StepOSWidget_release.isAttachedToWindow() && transitionSharedElement$StepOSWidget_release.getWidth() > 0 && transitionSharedElement$StepOSWidget_release.getHeight() > 0) {
                if (!this.backdropArmed) {
                    this.backdropArmed = true;
                    StepOSSearchTransition.INSTANCE.armEnterBackdrop(activity, stepOSSearchBarFindSearchBar, this.transition);
                }
                transitionSharedElement$StepOSWidget_release.setTransitionName(this.sharedElementName);
                transitionSharedElement$StepOSWidget_release.post(new Runnable() { // from class: com.stepos.widget.searchbar.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31361a.complete(true);
                    }
                });
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            complete(true);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0010R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00040\u00040\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/widget/searchbar/StepOSSearchTransition$UnfreezeOnResume;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/view/View;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(Landroid/app/Activity;Landroid/view/View;)V", "LY8/t;", "unfreeze", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "activityRef", "Ljava/lang/ref/WeakReference;", "contentRef", "", "done", "Z", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class UnfreezeOnResume implements Application.ActivityLifecycleCallbacks {
        private final WeakReference<Activity> activityRef;
        private final WeakReference<View> contentRef;
        private boolean done;

        public UnfreezeOnResume(Activity activity, View content) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(content, "content");
            this.activityRef = new WeakReference<>(activity);
            this.contentRef = new WeakReference<>(content);
        }

        private final void unfreeze() {
            Application application;
            if (this.done) {
                return;
            }
            this.done = true;
            View view = this.contentRef.get();
            if (view != null && view.getLayerType() == 2) {
                view.setLayerType(0, null);
                Log.i(StepOSSearchTransition.TAG, "unfreeze outgoing window " + view.getWidth() + "x" + view.getHeight());
            }
            Activity activity = this.activityRef.get();
            if (activity == null || (application = activity.getApplication()) == null) {
                return;
            }
            application.unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            if (activity == this.activityRef.get()) {
                unfreeze();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            if (activity == this.activityRef.get()) {
                unfreeze();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }
    }

    static {
        Set<Activity> setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        kotlin.jvm.internal.p.h(setNewSetFromMap, "newSetFromMap(...)");
        backIntercepted = setNewSetFromMap;
        whiteSnapshotCallback = new StepOSSearchTransition$whiteSnapshotCallback$1();
    }

    private StepOSSearchTransition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void armEnterBackdrop(final Activity activity, final StepOSSearchBar searchBar, Transition transition) {
        searchBar.setTransitionBackdropHolding$StepOSWidget_release(true);
        activity.setEnterSharedElementCallback(whiteSnapshotCallback);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.widget.searchbar.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSSearchTransition.armEnterBackdrop$lambda$17(ref$BooleanRef, searchBar, activity);
            }
        };
        transition.addListener(new Transition.TransitionListener() { // from class: com.stepos.widget.searchbar.StepOSSearchTransition.armEnterBackdrop.1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition t10) {
                kotlin.jvm.internal.p.i(t10, "t");
                onTransitionEnd(t10);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition t10) {
                kotlin.jvm.internal.p.i(t10, "t");
                t10.removeListener(this);
                interfaceC5063a.invoke();
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition t10) {
                kotlin.jvm.internal.p.i(t10, "t");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition t10) {
                kotlin.jvm.internal.p.i(t10, "t");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition t10) {
                kotlin.jvm.internal.p.i(t10, "t");
            }
        });
        searchBar.postDelayed(new Runnable() { // from class: com.stepos.widget.searchbar.p
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC5063a.invoke();
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t armEnterBackdrop$lambda$17(Ref$BooleanRef ref$BooleanRef, StepOSSearchBar stepOSSearchBar, Activity activity) {
        if (!ref$BooleanRef.f34815a) {
            ref$BooleanRef.f34815a = true;
            stepOSSearchBar.setTransitionBackdropHolding$StepOSWidget_release(false);
            activity.setEnterSharedElementCallback(null);
        }
        return Y8.t.f7040a;
    }

    private final Transition buildAndInstallTransition(Activity activity, Transition.TransitionListener listener) {
        Transition transitionInflateTransition = TransitionInflater.from(activity).inflateTransition(R.transition.stepos_search_enter_scale);
        if (listener != null) {
            transitionInflateTransition.addListener(listener);
        }
        activity.getWindow().setSharedElementEnterTransition(transitionInflateTransition);
        kotlin.jvm.internal.p.f(transitionInflateTransition);
        return transitionInflateTransition;
    }

    private final StepOSSearchBar findSearchBar(View root) {
        if (root instanceof StepOSSearchBar) {
            return (StepOSSearchBar) root;
        }
        if (!(root instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) root;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            StepOSSearchBar stepOSSearchBarFindSearchBar = findSearchBar(childAt);
            if (stepOSSearchBarFindSearchBar != null) {
                return stepOSSearchBarFindSearchBar;
            }
        }
        return null;
    }

    public static final void finishSearchActivity(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        Object systemService = activity.getSystemService("input_method");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 1);
        if (!isSearchSharedElementTransition(activity)) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
            return;
        }
        StepOSSearchTransition stepOSSearchTransition = INSTANCE;
        View decorView = activity.getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        StepOSSearchBar stepOSSearchBarFindSearchBar = stepOSSearchTransition.findSearchBar(decorView);
        if (stepOSSearchBarFindSearchBar != null) {
            stepOSSearchBarFindSearchBar.setTransitionBackdropHolding$StepOSWidget_release(true);
        }
        activity.setExitSharedElementCallback(whiteSnapshotCallback);
        activity.finishAfterTransition();
    }

    private final void freezeOutgoingWindow(Activity activity) {
        View viewFindViewById;
        Object objB;
        if (activity.isFinishing() || (viewFindViewById = activity.findViewById(android.R.id.content)) == null) {
            return;
        }
        viewFindViewById.setLayerType(2, null);
        if (viewFindViewById.isAttachedToWindow() && viewFindViewById.getWidth() > 0 && viewFindViewById.getHeight() > 0) {
            try {
                Result.Companion companion = Result.INSTANCE;
                viewFindViewById.buildLayer();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "buildLayer failed, leaving HARDWARE layer without forced raster", thE);
            }
        }
        Log.i(TAG, "freeze outgoing window " + viewFindViewById.getWidth() + "x" + viewFindViewById.getHeight() + " layerType=" + viewFindViewById.getLayerType() + " attached=" + viewFindViewById.isAttachedToWindow());
        activity.getApplication().registerActivityLifecycleCallbacks(new UnfreezeOnResume(activity, viewFindViewById));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void holdReturnBackdrop(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        StepOSSearchBar stepOSSearchBarFindSearchBar = findSearchBar(decorView);
        if (stepOSSearchBarFindSearchBar != null) {
            stepOSSearchBarFindSearchBar.setTransitionBackdropHolding$StepOSWidget_release(true);
        }
    }

    private final void interceptSystemBack(Activity activity) {
        if (backIntercepted.add(activity)) {
            activity.setExitSharedElementCallback(whiteSnapshotCallback);
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            kotlin.jvm.internal.p.h(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            onBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, predictiveBackCallback(activity, onBackInvokedDispatcher));
        }
    }

    public static final boolean isSearchSharedElementTransition(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        return INSTANCE.sharedElementNameFromIntent(activity).length() > 0;
    }

    private final OnBackInvokedCallback legacyBackCallback(final Activity activity, final OnBackInvokedDispatcher dispatcher) {
        return new OnBackInvokedCallback() { // from class: com.stepos.widget.searchbar.StepOSSearchTransition.legacyBackCallback.1
            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                dispatcher.unregisterOnBackInvokedCallback(this);
                StepOSSearchTransition.backIntercepted.remove(activity);
                StepOSSearchTransition.finishSearchActivity(activity);
            }
        };
    }

    private final OnBackInvokedCallback predictiveBackCallback(final Activity activity, final OnBackInvokedDispatcher dispatcher) {
        return new OnBackAnimationCallback() { // from class: com.stepos.widget.searchbar.StepOSSearchTransition.predictiveBackCallback.1
            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                StepOSSearchTransition.INSTANCE.releaseReturnBackdrop(activity);
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                dispatcher.unregisterOnBackInvokedCallback(this);
                StepOSSearchTransition.backIntercepted.remove(activity);
                StepOSSearchTransition.finishSearchActivity(activity);
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.p.i(backEvent, "backEvent");
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.p.i(backEvent, "backEvent");
                StepOSSearchTransition.INSTANCE.holdReturnBackdrop(activity);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseReturnBackdrop(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        StepOSSearchBar stepOSSearchBarFindSearchBar = findSearchBar(decorView);
        if (stepOSSearchBarFindSearchBar != null) {
            stepOSSearchBarFindSearchBar.setTransitionBackdropHolding$StepOSWidget_release(false);
        }
    }

    public static final Transition setupSearchEnterTransition(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        return setupSearchEnterTransition$default(activity, null, 2, null);
    }

    public static /* synthetic */ Transition setupSearchEnterTransition$default(Activity activity, StepOSSearchBar stepOSSearchBar, Transition.TransitionListener transitionListener, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            transitionListener = null;
        }
        return setupSearchEnterTransition(activity, stepOSSearchBar, transitionListener);
    }

    private final String sharedElementNameFromIntent(Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra(EXTRA_SHARED_ELEMENT_NAME);
        return stringExtra == null ? "" : stringExtra;
    }

    public static final void startSearchActivity(Activity activity, StepOSSearchBar searchBar, Intent intent) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(searchBar, "searchBar");
        kotlin.jvm.internal.p.i(intent, "intent");
        startSearchActivity$default(activity, searchBar, intent, null, 8, null);
    }

    public static /* synthetic */ void startSearchActivity$default(Activity activity, StepOSSearchBar stepOSSearchBar, Intent intent, String str, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str = DEFAULT_SHARED_ELEMENT_NAME;
        }
        startSearchActivity(activity, stepOSSearchBar, intent, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSearchActivity$lambda$0(Activity activity, StepOSSearchBar stepOSSearchBar, View view, String str, Intent intent) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            stepOSSearchBar.setTransitionBackdropHolding$StepOSWidget_release(false);
            return;
        }
        androidx.core.app.c cVarB = androidx.core.app.c.b(activity, view, str);
        kotlin.jvm.internal.p.h(cVarB, "makeSceneTransitionAnimation(...)");
        activity.startActivity(intent, cVarB.d());
    }

    public static final void startSearchEmptyEnterAnimation(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setStartDelay(50L);
        objectAnimatorOfFloat.setInterpolator(PATH_INTERPOLATOR);
        Y8.t tVar = Y8.t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, SEARCH_CONTENT_TRANSLATION_Y, 0.0f);
        objectAnimatorOfFloat2.setDuration(350L);
        objectAnimatorOfFloat2.setInterpolator(PATH_INTERPOLATOR_Y);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public static final void startSearchEmptyExitAnimation(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, SEARCH_CONTENT_TRANSLATION_Y);
        objectAnimatorOfFloat.setDuration(350L);
        objectAnimatorOfFloat.setInterpolator(PATH_INTERPOLATOR);
        Y8.t tVar = Y8.t.f7040a;
        animatorSet.playTogether(objectAnimatorOfFloat);
        animatorSet.start();
    }

    public static final void startSearchEnterAnimation(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setStartDelay(50L);
        objectAnimatorOfFloat.setInterpolator(PATH_INTERPOLATOR);
        Y8.t tVar = Y8.t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, -512.0f, 0.0f);
        objectAnimatorOfFloat2.setDuration(350L);
        objectAnimatorOfFloat2.setInterpolator(PATH_INTERPOLATOR_Y);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public static final void startSearchExitAnimation(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(PATH_INTERPOLATOR);
        Y8.t tVar = Y8.t.f7040a;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, -224.0f);
        objectAnimatorOfFloat2.setDuration(350L);
        objectAnimatorOfFloat2.setInterpolator(PATH_INTERPOLATOR_Y);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public static final Transition setupSearchEnterTransition(Activity activity, StepOSSearchBar searchBar) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(searchBar, "searchBar");
        return setupSearchEnterTransition$default(activity, searchBar, null, 4, null);
    }

    public static /* synthetic */ Transition setupSearchEnterTransition$default(Activity activity, Transition.TransitionListener transitionListener, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            transitionListener = null;
        }
        return setupSearchEnterTransition(activity, transitionListener);
    }

    public static final void startSearchActivity(final Activity activity, final StepOSSearchBar searchBar, final Intent intent, final String sharedElementName) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(searchBar, "searchBar");
        kotlin.jvm.internal.p.i(intent, "intent");
        kotlin.jvm.internal.p.i(sharedElementName, "sharedElementName");
        searchBar.setTransitionBackdropHolding$StepOSWidget_release(true);
        final View transitionSharedElement$StepOSWidget_release = searchBar.getTransitionSharedElement$StepOSWidget_release();
        transitionSharedElement$StepOSWidget_release.setTransitionName(sharedElementName);
        intent.putExtra(EXTRA_SHARED_ELEMENT_NAME, sharedElementName);
        activity.setExitSharedElementCallback(whiteSnapshotCallback);
        activity.getApplication().registerActivityLifecycleCallbacks(new ReleaseSearchBackdropOnResume(activity, searchBar));
        final Runnable runnable = new Runnable() { // from class: com.stepos.widget.searchbar.q
            @Override // java.lang.Runnable
            public final void run() {
                StepOSSearchTransition.startSearchActivity$lambda$0(activity, searchBar, transitionSharedElement$StepOSWidget_release, sharedElementName, intent);
            }
        };
        if (searchBar.isAttachedToWindow()) {
            kotlin.jvm.internal.p.f(D.a(searchBar, new Runnable() { // from class: com.stepos.widget.searchbar.r
                @Override // java.lang.Runnable
                public final void run() {
                    searchBar.post(runnable);
                }
            }));
        } else {
            runnable.run();
        }
    }

    public static final Transition setupSearchEnterTransition(Activity activity, StepOSSearchBar searchBar, Transition.TransitionListener listener) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(searchBar, "searchBar");
        StepOSSearchTransition stepOSSearchTransition = INSTANCE;
        Transition transitionBuildAndInstallTransition = stepOSSearchTransition.buildAndInstallTransition(activity, listener);
        String strSharedElementNameFromIntent = stepOSSearchTransition.sharedElementNameFromIntent(activity);
        if (strSharedElementNameFromIntent.length() > 0) {
            stepOSSearchTransition.armEnterBackdrop(activity, searchBar, transitionBuildAndInstallTransition);
            new SearchBarTargetStarter(activity, searchBar, strSharedElementNameFromIntent).attach();
            stepOSSearchTransition.interceptSystemBack(activity);
        }
        return transitionBuildAndInstallTransition;
    }

    public static final Transition setupSearchEnterTransition(Activity activity, Transition.TransitionListener listener) {
        kotlin.jvm.internal.p.i(activity, "activity");
        StepOSSearchTransition stepOSSearchTransition = INSTANCE;
        Transition transitionBuildAndInstallTransition = stepOSSearchTransition.buildAndInstallTransition(activity, listener);
        String strSharedElementNameFromIntent = stepOSSearchTransition.sharedElementNameFromIntent(activity);
        if (strSharedElementNameFromIntent.length() > 0) {
            new TreeSearchTargetStarter(activity, strSharedElementNameFromIntent, transitionBuildAndInstallTransition).attach();
            stepOSSearchTransition.interceptSystemBack(activity);
        }
        return transitionBuildAndInstallTransition;
    }

    public static final void startSearchActivity(Activity activity, View sharedElement, String sharedElementName, Intent intent) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(sharedElement, "sharedElement");
        kotlin.jvm.internal.p.i(sharedElementName, "sharedElementName");
        kotlin.jvm.internal.p.i(intent, "intent");
        INSTANCE.freezeOutgoingWindow(activity);
        androidx.core.app.c cVarC = androidx.core.app.c.c(activity, new B0.d[0]);
        kotlin.jvm.internal.p.h(cVarC, "makeSceneTransitionAnimation(...)");
        activity.startActivity(intent, cVarC.d());
    }
}
