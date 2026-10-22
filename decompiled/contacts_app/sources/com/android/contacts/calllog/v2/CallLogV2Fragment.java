package com.android.contacts.calllog.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import com.GlobalProxyLancet;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.ReflectUtils;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.calllog.CallLogNotificationsService;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.list.BottomDeleteLayoutListener;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsFpsMonitorFactory;
import com.android.contacts.util.ContactsFpsScenes;
import com.android.contacts.util.CubicInterpolator;
import com.obric.anim.ListAnimator;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.immersive.Immersive;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSSceneMonitor;
import com.obric.model.CallFeatureModel;
import com.obric.notification.NotificationHelper;
import com.obric.oui.orecyclerview.widget.DefaultItemAnimator;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import obric.app.tracker.Agent;

/* JADX INFO: compiled from: CallLogV2Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0003\n\r\u0010\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0082\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020$H\u0016J\u0012\u0010I\u001a\u00020D2\b\b\u0002\u0010J\u001a\u00020$H\u0002J \u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u0002032\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020DH\u0002J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0002J\"\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u0002032\u0006\u0010U\u001a\u0002032\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0010\u0010X\u001a\u00020D2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0012\u0010[\u001a\u00020D2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J$\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010c\u001a\u00020DH\u0016J\b\u0010d\u001a\u00020DH\u0016J\b\u0010e\u001a\u00020DH\u0016J\b\u0010f\u001a\u00020DH\u0016J\b\u0010g\u001a\u00020DH\u0002J\b\u0010h\u001a\u00020DH\u0016J\u001a\u0010i\u001a\u00020D2\u0006\u0010G\u001a\u00020\u001e2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010j\u001a\u00020D2\u0006\u0010k\u001a\u00020$H\u0016J\u0010\u0010l\u001a\u00020D2\u0006\u0010m\u001a\u00020nH\u0002J\u0010\u0010o\u001a\u00020D2\u0006\u0010p\u001a\u000208H\u0002J\u0010\u0010q\u001a\u00020D2\u0006\u0010p\u001a\u000208H\u0002J\u0010\u0010r\u001a\u00020D2\b\u0010s\u001a\u0004\u0018\u00010\bJ\u000e\u0010t\u001a\u00020D2\u0006\u0010Y\u001a\u00020ZJ\u0018\u0010u\u001a\u00020D2\u0006\u0010k\u001a\u00020$2\u0006\u0010v\u001a\u00020$H\u0016J\u0010\u0010w\u001a\u00020D2\b\u0010x\u001a\u0004\u0018\u00010\"J\b\u0010y\u001a\u00020DH\u0002J\b\u0010z\u001a\u00020DH\u0002J\b\u0010{\u001a\u00020DH\u0002J\u0010\u0010|\u001a\u00020D2\u0006\u0010G\u001a\u00020\u001eH\u0002J\u0006\u0010}\u001a\u00020DJ\b\u0010~\u001a\u00020DH\u0002J\b\u0010\u007f\u001a\u00020DH\u0002J\t\u0010\u0080\u0001\u001a\u00020DH\u0002J\t\u0010\u0081\u0001\u001a\u00020DH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0083\u0001"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogV2Fragment;", "Landroidx/fragment/app/Fragment;", "Lcom/android/contacts/activities/DialtactsActivity$ViewPagerVisibilityListener;", "Lcom/android/contacts/activities/DialtactsActivity$PageEnableListener;", "Lcom/android/contacts/activities/DialtactsActivity$onBackPressListener;", "Lcom/android/contacts/DSUtils$DSFatureStatusListener;", "()V", "bottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "callFeatureListener", "com/android/contacts/calllog/v2/CallLogV2Fragment$callFeatureListener$1", "Lcom/android/contacts/calllog/v2/CallLogV2Fragment$callFeatureListener$1;", "callSummaryFinishedListener", "com/android/contacts/calllog/v2/CallLogV2Fragment$callSummaryFinishedListener$1", "Lcom/android/contacts/calllog/v2/CallLogV2Fragment$callSummaryFinishedListener$1;", "callSummaryStartedListener", "com/android/contacts/calllog/v2/CallLogV2Fragment$callSummaryStartedListener$1", "Lcom/android/contacts/calllog/v2/CallLogV2Fragment$callSummaryStartedListener$1;", "contactInfoCache", "Lcom/android/contacts/calllog/v2/ContactInfoCache;", "currentVisibleContact", "", "", "getCurrentVisibleContact", "()Ljava/util/List;", "deleteHelper", "Lcom/android/contacts/calllog/v2/CallLogDeleteHelper;", "editAnimator", "Lcom/obric/anim/ListAnimator;", "emptyView", "Landroid/view/View;", "emptyViewStub", "Landroid/view/ViewStub;", "fragmentsCallback", "Lcom/android/contacts/ContactFragmentsCallback;", "isPageVisible", "", "isScrollFpsSampling", "isTabSwitching", "itemActionHelper", "Lcom/android/contacts/calllog/v2/CallLogItemActionHelper;", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "listAdapter", "Lcom/android/contacts/calllog/v2/CallLogListAdapter;", "navigationBarObserver", "Landroidx/lifecycle/Observer;", "", "numberMarkHelper", "Lcom/android/contacts/calllog/v2/CallLogNumberMarkHelper;", "pendingClearMissedCall", "pendingSubmitState", "Lcom/android/contacts/calllog/v2/CallLogUiState;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "repository", "Lcom/android/contacts/calllog/v2/CallLogRepository;", "scrollFpsMonitor", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "titleBarHelper", "Lcom/android/contacts/calllog/v2/CallLogTitleBarHelper;", "viewModel", "Lcom/android/contacts/calllog/v2/CallLogViewModel;", "animateSwipeDelete", "", "item", "Lcom/android/contacts/calllog/v2/CallLogItem;", "view", "backToTopState", "exitEditMode", "skipListAnimation", "isItemVisible", "child", "rvHeight", "proportionLevel", "", "markMissedCallsAsRead", "notifySummarizingItemsChanged", "observeState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onContactInfoUpdated", "number", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDSFeatureStatusChanged", "onDestroyView", "onPause", "onResume", "onSelectAllClick", "onStop", "onViewCreated", "onVisibilityChanged", "visible", "renderEditMode", "editState", "Lcom/android/contacts/calllog/v2/EditModeState;", "renderEmptyView", "state", "renderList", "setBottomDeleteLayoutListener", "listener", "setContactNumber", "setEnable", "shouldTrigger", "setFragmentsCallback", "callback", "setupDualSim", "setupHelpers", "setupRecyclerView", "setupViews", "showDeleteCallLogDialog", "startEditMode", "startScrollFpsSampling", "stopScrollFpsSampling", "updateVoicemailNotifications", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogV2Fragment extends Fragment implements DialtactsActivity.ViewPagerVisibilityListener, DialtactsActivity.PageEnableListener, DialtactsActivity.onBackPressListener, DSUtils.DSFatureStatusListener {
    public static final Companion Companion = null;
    private static final String TAG = "CallLogV2Fragment";
    public static final boolean USE_CONTACT_INFO_CACHE = true;
    private BottomDeleteLayoutListener bottomDeleteLayoutListener;
    private final CallLogV2Fragment$callFeatureListener$1 callFeatureListener;
    private final CallLogV2Fragment$callSummaryFinishedListener$1 callSummaryFinishedListener;
    private final CallLogV2Fragment$callSummaryStartedListener$1 callSummaryStartedListener;
    private ContactInfoCache contactInfoCache;
    private CallLogDeleteHelper deleteHelper;
    private final ListAnimator editAnimator;
    private View emptyView;
    private ViewStub emptyViewStub;
    private ContactFragmentsCallback fragmentsCallback;
    private boolean isPageVisible;
    private boolean isScrollFpsSampling;
    private boolean isTabSwitching;
    private CallLogItemActionHelper itemActionHelper;
    private final Lazy keyguardManager$delegate;
    private CallLogListAdapter listAdapter;
    private final Observer<Integer> navigationBarObserver;
    private CallLogNumberMarkHelper numberMarkHelper;
    private boolean pendingClearMissedCall;
    private CallLogUiState pendingSubmitState;
    private RecyclerView recyclerView;
    private CallLogRepository repository;
    private final FPSSceneMonitor scrollFpsMonitor;
    private CallLogTitleBarHelper titleBarHelper;
    private CallLogViewModel viewModel;

    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogV2Fragment$Companion;", "", "()V", "TAG", "", "USE_CONTACT_INFO_CACHE", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$animateSwipeDelete$1, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/android/contacts/calllog/v2/CallLogV2Fragment$animateSwipeDelete$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ CallLogItem $item;
        final /* synthetic */ RecyclerView $rv;
        final /* synthetic */ View $view;
        final /* synthetic */ CallLogV2Fragment this$0;

        public static /* synthetic */ void $r8$lambda$z1EOi7zBts3ngJhVTywXb0vOKo4(RecyclerView r0) {
            onAnimationEnd$lambda$1(r0);
        }

        AnonymousClass1(View r1, RecyclerView r2, CallLogV2Fragment r3, CallLogItem r4) {
            this.$view = r1;
            this.$rv = r2;
            this.this$0 = r3;
            this.$item = r4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallLogV2Fragment.TAG, "[DEL-ANIM] swipe: Phase1 END, setting ItemAnimator(move=200)");
            this.$view.setAlpha(0.0f);
            this.$view.setTranslationX(0.0f);
            DefaultItemAnimator r5 = new DefaultItemAnimator();
            r5.setAddDuration(0);
            r5.setRemoveDuration(0);
            r5.setChangeDuration(0);
            r5.setMoveDuration(200);
            this.$rv.setItemAnimator(r5);
            CallLogListAdapter r6 = CallLogV2Fragment.access$getListAdapter$p(this.this$0);
            CallLogViewModel r1 = null;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            r6 = null;
        L5:
            r6.clearSwipeState();
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallLogV2Fragment.TAG, "[DEL-ANIM] swipe: calling optimisticDelete, ids=" + this.$item.getChildIds());
            CallLogViewModel r7 = CallLogV2Fragment.access$getViewModel$p(this.this$0);
            if (r7 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L9:
            r1.optimisticDelete(CollectionsKt.toSet(this.$item.getChildIds()));
            final RecyclerView r3 = this.$rv;
            r3.postDelayed(new CallLogV2Fragment$animateSwipeDelete$1$$ExternalSyntheticLambda0(r3), 250);
            return;
        L8:
            r1 = r7;
            goto L9
        }

        private static final void onAnimationEnd$lambda$1(RecyclerView r2) {
            Intrinsics.checkNotNullParameter(r2, "$rv");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallLogV2Fragment.TAG, "[DEL-ANIM] swipe: postDelayed -> itemAnimator = null");
            r2.setItemAnimator(null);
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$markMissedCallsAsRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogV2Fragment$markMissedCallsAsRead$1", f = "CallLogV2Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentResolver $cr;
        int label;
        final /* synthetic */ CallLogV2Fragment this$0;

        C01721(ContentResolver r1, CallLogV2Fragment r2, Continuation<? super C01721> r3) {
            this.$cr = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01721(this.$cr, this.this$0, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01721) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r6);
            ContentValues r7 = new ContentValues(1);
            r7.put("new", Boxing.boxInt(0));
            int r8 = this.$cr.update(CallLog.Calls.CONTENT_URI, r7, "new = 1", null);
            ContentValues r1 = new ContentValues(1);
            r1.put("is_read", Boxing.boxInt(1));
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallLogV2Fragment.TAG, "[MISSED] markMissedCallsAsRead: NEW=1->0 rows=" + r8 + ", IS_READ=0->1 rows=" + this.$cr.update(CallLog.Calls.CONTENT_URI, r1, "is_read = 0 AND type = 3", null));
            ReflectUtils.cancelMissedCallsNotification(this.this$0.getActivity());
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallLogV2Fragment.TAG, "[MISSED] cancelMissedCallsNotification called");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$observeState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogV2Fragment$observeState$1", f = "CallLogV2Fragment.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    static final class C01731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CallLogV2Fragment this$0;

        /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$observeState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CallLogV2Fragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogV2Fragment$observeState$1$1", f = "CallLogV2Fragment.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
        static final class C00221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ CallLogV2Fragment this$0;

            C00221(CallLogV2Fragment r1, Continuation<? super C00221> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new C00221(this.this$0, r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00221) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L15:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                CallLogViewModel r6 = CallLogV2Fragment.access$getViewModel$p(this.this$0);
                if (r6 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r6 = null;
            L11:
                StateFlow<CallLogUiState> r7 = r6.getUiState();
                final CallLogV2Fragment r3 = this.this$0;
                this.label = 1;
                if (r7.collect(new C00231(r3), this) != r0) goto L15;
                return r0;
            }
        }

        C01731(CallLogV2Fragment r1, Continuation<? super C01731> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01731(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01731) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(r8, "viewLifecycleOwner");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, Lifecycle.State.STARTED, new C00221(this.this$0, null), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$setupDualSim$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogV2Fragment$setupDualSim$1", f = "CallLogV2Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        private /* synthetic */ Object L$0;
        int label;

        C01741(Context r1, Continuation<? super C01741> r2) {
            this.$appContext = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C01741 r0 = new C01741(this.$appContext, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01741) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r3);
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            Context r2 = this.$appContext;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
            ContentValues r6 = new ContentValues(1);     // Catch: Throwable -> L7
            r6.put(CallLogQuery.COLUMN_SHOW_SIM_ICON, Boxing.boxInt(1));     // Catch: Throwable -> L7
            Object r7 = Result.m803constructorimpl(Boxing.boxInt(r2.getContentResolver().update(CallLog.Calls.CONTENT_URI, r6, null, null)));     // Catch: Throwable -> L7
        L9:
            Throwable r8 = Result.m806exceptionOrNullimpl(r7);
            if (r8 == null) goto L13;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallLogV2Fragment.TAG, "updateShowSimId failed", r8);
        L13:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$setupHelpers$2, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object r8) {
            super(0, r8, CallLogV2Fragment.class, "startEditMode", "startEditMode()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CallLogV2Fragment.access$startEditMode((CallLogV2Fragment) this.receiver);
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$setupHelpers$3, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends AdaptedFunctionReference implements Function0<Unit> {
        AnonymousClass3(Object r8) {
            super(0, r8, CallLogV2Fragment.class, "exitEditMode", "exitEditMode(Z)V", 0);
        }

        public static final /* synthetic */ Object access$getReceiver$p(AnonymousClass3 r0) {
            return r0.receiver;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CallLogV2Fragment.exitEditMode$default((CallLogV2Fragment) access$getReceiver$p(this), false, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogV2Fragment$setupHelpers$4, reason: invalid class name */
    /* JADX INFO: compiled from: CallLogV2Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass4(Object r8) {
            super(0, r8, CallLogV2Fragment.class, "onSelectAllClick", "onSelectAllClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CallLogV2Fragment.access$onSelectAllClick((CallLogV2Fragment) this.receiver);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$82a2C1fKd_0Xj6Gzepx8gkL-7pk, reason: not valid java name */
    public static /* synthetic */ boolean m157$r8$lambda$82a2C1fKd_0Xj6Gzepx8gkL7pk(CallLogV2Fragment r0, View r1, MotionEvent r2) {
        return setupRecyclerView$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$FGsTUwqYS97K87tI9w1zUurCVB0(CallLogV2Fragment r0) {
        renderList$lambda$9(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ReaAe4-bS-I8skV269Cn2WnxQ9U, reason: not valid java name */
    public static /* synthetic */ void m158$r8$lambda$ReaAe4bSI8skV269Cn2WnxQ9U(CallLogV2Fragment r0) {
        renderList$lambda$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$mt5aMjlTSQO9q86NUKaJBAVml_Q(CallLogV2Fragment r0) {
        renderList$lambda$11$lambda$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$nE3C5_ftvFC5lQzeNUQONlDPwKk(CallLogV2Fragment r0, int r1) {
        navigationBarObserver$lambda$1(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public CallLogV2Fragment() {
        this.scrollFpsMonitor = ContactsFpsMonitorFactory.INSTANCE.create(ContactsFpsScenes.CALL_LOG_V2_SCROLL);
        this.editAnimator = new ListAnimator(new int[]{R.id.top_container, R.id.call_log_summary_card_view, R.id.item_divider}, new int[]{R.id.end_icon}, new int[]{R.id.icon_container, R.id.end_icon});
        this.navigationBarObserver = new CallLogV2Fragment$$ExternalSyntheticLambda2(this);
        this.callFeatureListener = new CallLogV2Fragment$callFeatureListener$1(this);
        this.callSummaryFinishedListener = new CallLogV2Fragment$callSummaryFinishedListener$1(this);
        this.callSummaryStartedListener = new CallLogV2Fragment$callSummaryStartedListener$1(this);
        this.keyguardManager$delegate = LazyKt.lazy(new CallLogV2Fragment$keyguardManager$2(this));
    }

    public static final /* synthetic */ void access$animateSwipeDelete(CallLogV2Fragment r0, CallLogItem r1, View r2) {
        r0.animateSwipeDelete(r1, r2);
    }

    public static final /* synthetic */ void access$exitEditMode(CallLogV2Fragment r0, boolean r1) {
        r0.exitEditMode(r1);
    }

    public static final /* synthetic */ ContactInfoCache access$getContactInfoCache$p(CallLogV2Fragment r0) {
        return r0.contactInfoCache;
    }

    public static final /* synthetic */ CallLogItemActionHelper access$getItemActionHelper$p(CallLogV2Fragment r0) {
        return r0.itemActionHelper;
    }

    public static final /* synthetic */ CallLogListAdapter access$getListAdapter$p(CallLogV2Fragment r0) {
        return r0.listAdapter;
    }

    public static final /* synthetic */ CallLogNumberMarkHelper access$getNumberMarkHelper$p(CallLogV2Fragment r0) {
        return r0.numberMarkHelper;
    }

    public static final /* synthetic */ CallLogUiState access$getPendingSubmitState$p(CallLogV2Fragment r0) {
        return r0.pendingSubmitState;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(CallLogV2Fragment r0) {
        return r0.recyclerView;
    }

    public static final /* synthetic */ CallLogRepository access$getRepository$p(CallLogV2Fragment r0) {
        return r0.repository;
    }

    public static final /* synthetic */ CallLogViewModel access$getViewModel$p(CallLogV2Fragment r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$onContactInfoUpdated(CallLogV2Fragment r0, String r1) {
        r0.onContactInfoUpdated(r1);
    }

    public static final /* synthetic */ void access$onSelectAllClick(CallLogV2Fragment r0) {
        r0.onSelectAllClick();
    }

    public static final /* synthetic */ void access$renderEditMode(CallLogV2Fragment r0, EditModeState r1) {
        r0.renderEditMode(r1);
    }

    public static final /* synthetic */ void access$renderEmptyView(CallLogV2Fragment r0, CallLogUiState r1) {
        r0.renderEmptyView(r1);
    }

    public static final /* synthetic */ void access$renderList(CallLogV2Fragment r0, CallLogUiState r1) {
        r0.renderList(r1);
    }

    public static final /* synthetic */ void access$setPendingSubmitState$p(CallLogV2Fragment r0, CallLogUiState r1) {
        r0.pendingSubmitState = r1;
    }

    public static final /* synthetic */ void access$setTabSwitching$p(CallLogV2Fragment r0, boolean r1) {
        r0.isTabSwitching = r1;
    }

    public static final /* synthetic */ void access$startEditMode(CallLogV2Fragment r0) {
        r0.startEditMode();
    }

    public static final /* synthetic */ void access$startScrollFpsSampling(CallLogV2Fragment r0) {
        r0.startScrollFpsSampling();
    }

    public static final /* synthetic */ void access$stopScrollFpsSampling(CallLogV2Fragment r0) {
        r0.stopScrollFpsSampling();
    }

    private static final void navigationBarObserver$lambda$1(CallLogV2Fragment r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        CallLogViewModel r0 = r3.viewModel;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (r0.isSingleContactMode() == false) goto L11;
        RecyclerView r5 = r3.recyclerView;
        if (r5 == null) goto L12;
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r4);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        Context r0 = requireContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r0, "requireContext().applicationContext");
        this.repository = new CallLogRepository(r0);
        CallLogV2Fragment r1 = this;
        CallLogRepository r2 = this.repository;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        r2 = null;
    L5:
        this.viewModel = (CallLogViewModel) new ViewModelProvider(r1, new CallLogViewModel.Factory(r2)).get(CallLogViewModel.class);
        setupDualSim();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onCreate: ViewModel initialized");
        Agent.getInstance().onAttach(TAG, TAG);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onCreateView");
        View r0 = r1.inflate(R.layout.call_log_fragment_v2, r2, false);
        Intrinsics.checkNotNullExpressionValue(r0, "inflater.inflate(R.layou…ent_v2, container, false)");
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        setupHelpers();
        setupViews(r2);
        CallLogTitleBarHelper r4 = this.titleBarHelper;
        if (r4 == null) goto L5;
        r4.setup(r2);
    L5:
        setupRecyclerView();
        observeState();
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L9;
        Immersive.Companion.getImmersive(r5).getNavigationBarHeight().observeForever(this.navigationBarObserver);
        return;
    }

    private final void setupHelpers() {
        CallLogV2Fragment r8 = this;
        CallLogViewModel r1 = this.viewModel;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        this.numberMarkHelper = new CallLogNumberMarkHelper(r8, r1, new C01751(this));
        CallLogViewModel r2 = this.viewModel;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        CallLogViewModel r3 = null;
    L9:
        this.titleBarHelper = new CallLogTitleBarHelper(r8, r3, new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this), new AnonymousClass5(this));
        CallLogViewModel r4 = this.viewModel;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        CallLogViewModel r5 = null;
    L13:
        this.itemActionHelper = new CallLogItemActionHelper(r8, r5, new AnonymousClass6(this), new AnonymousClass7(this), new AnonymousClass8(this), new AnonymousClass9(this));
        CallLogViewModel r6 = this.viewModel;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        CallLogViewModel r7 = null;
    L17:
        this.deleteHelper = new CallLogDeleteHelper(r8, r7, new AnonymousClass10(this), new AnonymousClass11(this), new AnonymousClass12(this));
        CallLogItemActionHelper r11 = this.itemActionHelper;
        if (r11 == null) goto L21;
        r11.init();
        return;
    L21:
        return;
    L16:
        r7 = r6;
        goto L17
    L12:
        r5 = r4;
        goto L13
    L8:
        r3 = r2;
        goto L9
    }

    private final void setupViews(View r2) {
        this.recyclerView = (RecyclerView) r2.findViewById(R.id.recycler_view);
        View r3 = r2.findViewById(R.id.listview_emptyview_stub);
        if ((r3 instanceof ViewStub) == false) goto L5;
        ViewStub r4 = (ViewStub) r3;
    L6:
        this.emptyViewStub = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void startEditMode() {
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L5;
        this.editAnimator.startEdit(r0);
    L5:
        CallLogViewModel r1 = this.viewModel;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L8:
        r1.enterEditMode();
        CallLogTitleBarHelper r2 = this.titleBarHelper;
        if (r2 == null) goto L11;
        r2.switchToEditState();
    L11:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_CALL_LOG);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "startEditMode");
    }

    static /* synthetic */ void exitEditMode$default(CallLogV2Fragment r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.exitEditMode(r1);
    }

    private final void exitEditMode(boolean r2) {
        CallLogViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.exitEditMode();
        CallLogTitleBarHelper r1 = this.titleBarHelper;
        if (r1 == null) goto L8;
        r1.switchToNormalState();
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "exitEditMode skipAnim=" + r2);
    }

    private final void onSelectAllClick() {
        CallLogViewModel r0 = this.viewModel;
        CallLogViewModel r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (r0.getUiState().getValue().getEditMode().getSelectAllChecked() == false) goto L12;
        CallLogViewModel r3 = this.viewModel;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r1.deselectAll();
        return;
    L10:
        r1 = r3;
        goto L11
    L12:
        CallLogViewModel r4 = this.viewModel;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        r1.selectAll();
        return;
    L15:
        r1 = r4;
        goto L16
    }

    private final void setupRecyclerView() {
        this.listAdapter = new CallLogListAdapter(new C01761(this), new C01772(this), new C01783(this), new C01794(this));
        Context r0 = getContext();
        CallLogListAdapter r2 = null;
        if (r0 == null) goto L8;
        ContactInfoCache r3 = new ContactInfoCache(r0);
        CallLogListAdapter r1 = this.listAdapter;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r1 = null;
    L7:
        r1.setContactInfoCache(r3);
        LifecycleOwner r4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r4, "viewLifecycleOwner");
        r3.startProcessing(LifecycleOwnerKt.getLifecycleScope(r4), new CallLogV2Fragment$setupRecyclerView$5$1$1(this), new CallLogV2Fragment$setupRecyclerView$5$1$2(this));
        this.contactInfoCache = r3;
    L8:
        RecyclerView r5 = this.recyclerView;
        if (r5 == null) goto L14;
        r5.setLayoutManager(new LinearLayoutManager(requireContext()));
        CallLogListAdapter r6 = this.listAdapter;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r6 = null;
    L13:
        r5.setAdapter(r6);
        r5.setItemAnimator(null);
        r5.setOnTouchListener(new CallLogV2Fragment$$ExternalSyntheticLambda1(this));
    L14:
        CallLogListAdapter r7 = this.listAdapter;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L18:
        r2.registerAdapterDataObserver(new C01807(this));
        RecyclerView r8 = this.recyclerView;
        if (r8 == null) goto L21;
        r8.addOnScrollListener(new C01818(this));
    L21:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setupRecyclerView: done");
        return;
    L17:
        r2 = r7;
        goto L18
    }

    private static final boolean setupRecyclerView$lambda$7$lambda$6(CallLogV2Fragment r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r3.getActionMasked() != 0) goto L12;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.RecyclerView");
        RecyclerView r4 = (RecyclerView) r2;
        if (r4.findChildViewUnder(r3.getX(), r3.getY()) != null) goto L13;
        CallLogListAdapter r5 = r1.listAdapter;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r5 = null;
    L9:
        r5.closeAllSwipes(r4);
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    private final void onContactInfoUpdated(String r9) {
        CallLogListAdapter r0 = this.listAdapter;
        CallLogViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r0 = null;
    L5:
        r0.notifyContactInfoChanged(r9);
        ContactInfoCache r1 = this.contactInfoCache;
        if (r1 != null) goto L8;
        return;
    L8:
        CallLogListAdapter r3 = this.listAdapter;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r3 = null;
    L11:
        List<CallLogItem> r4 = r3.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(r4, "listAdapter.currentList");
        List<CallLogItem> r5 = r4;
        boolean r6 = false;
        if ((r5 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r7 = r5.iterator();
    L18:
        if (r7.hasNext() == false) goto L32;
        CallLogItem r8 = (CallLogItem) r7.next();
        if (Intrinsics.areEqual(r8.getNumber(), r9) == true) goto L22;
    L21:
        boolean r10 = false;
    L30:
        if (r10 == false) goto L18;
        r6 = true;
        goto L32
    L22:
        ContactInfo r11 = r1.get(r8.getNumber(), r8.getCountryIso());
        if (r11 == null) goto L25;
        Boolean r12 = Boolean.valueOf(r11.hasMarked);
    L26:
        if (r12 == null) goto L21;
        if (Intrinsics.areEqual(r12, Boolean.valueOf(r8.isMarked())) == true) goto L21;
        r10 = true;
        goto L30
    L25:
        r12 = null;
    L32:
        if (r6 == false) goto L44;
        CallLogViewModel r13 = this.viewModel;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r2.refresh();
        return;
    L36:
        r2 = r13;
        goto L37
    L44:
        return;
    L14:
        if (r5.isEmpty() == false) goto L16;
        goto L16
    }

    private final void observeState() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "viewLifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new C01731(this, null), 3, null);
    }

    private final void renderList(CallLogUiState r7) {
        CallLogListAdapter r0 = this.listAdapter;
        CallLogListAdapter r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r0 = null;
    L5:
        int r1 = r0.getCurrentList().size();
        CallLogListAdapter r3 = this.listAdapter;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r3 = null;
    L8:
        boolean r4 = false;
        if (r3.getListScrollState() == 0) goto L23;
        if (this.isTabSwitching == true) goto L23;
        CallLogDeleteHelper r5 = this.deleteHelper;
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == true) goto L23;
        if (r1 <= 0) goto L23;
        this.pendingSubmitState = r7;
        return;
    L15:
        if (r5.isPendingExitAfterDelete() != true) goto L17;
        r6 = true;
    L23:
        if (this.isTabSwitching == false) goto L33;
        RecyclerView r8 = this.recyclerView;
        if (r8 == null) goto L28;
        r8.setItemAnimator(null);
    L28:
        CallLogListAdapter r9 = this.listAdapter;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L32:
        r2.submitList(r7.getItems(), new CallLogV2Fragment$$ExternalSyntheticLambda3(this));
    L49:
        CallLogTitleBarHelper r10 = this.titleBarHelper;
        if (r10 == null) goto L53;
        r10.setEditEnabled(!r7.getItems().isEmpty());
        return;
    L53:
        return;
    L31:
        r2 = r9;
        goto L32
    L33:
        CallLogDeleteHelper r11 = this.deleteHelper;
        if (r11 != null) goto L36;
    L38:
        if (r4 == false) goto L44;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[DEL-ANIM] renderList: DIFF_PENDING path, submitList size=" + r7.getItems().size() + ", prev=" + r1);
        CallLogListAdapter r12 = this.listAdapter;
        if (r12 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L43:
        r2.submitList(r7.getItems(), new CallLogV2Fragment$$ExternalSyntheticLambda4(this));
        goto L49
    L42:
        r2 = r12;
        goto L43
    L44:
        CallLogListAdapter r13 = this.listAdapter;
        if (r13 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L48:
        r2.submitList(r7.getItems());
        goto L49
    L47:
        r2 = r13;
        goto L48
    L36:
        if (r11.isPendingExitAfterDelete() != true) goto L38;
        r4 = true;
        goto L38
    }

    private static final void renderList$lambda$9(CallLogV2Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.isTabSwitching = false;
    }

    private static final void renderList$lambda$11(final CallLogV2Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[DEL-ANIM] renderList: submitList committed, clearing ItemAnimator after delay");
        RecyclerView r0 = r4.recyclerView;
        if (r0 == null) goto L5;
        r0.postDelayed(new CallLogV2Fragment$$ExternalSyntheticLambda0(r4), 250);
    L5:
        CallLogDeleteHelper r5 = r4.deleteHelper;
        if (r5 == null) goto L9;
        r5.onDiffCompleted();
        return;
    }

    private static final void renderList$lambda$11$lambda$10(CallLogV2Fragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        RecyclerView r2 = r1.recyclerView;
        if (r2 == null) goto L7;
        r2.setItemAnimator(null);
        return;
    }

    private final void renderEditMode(EditModeState r7) {
        CallLogListAdapter r0 = this.listAdapter;
        CallLogListAdapter r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r0 = null;
    L6:
        if (r0.getEditModeState().isActive() == true) goto L8;
    L23:
        CallLogListAdapter r1 = this.listAdapter;
        if (r1 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r1 = null;
    L26:
        r1.setEditModeState(r7);
        if (r7.isActive() == false) goto L50;
        RecyclerView r3 = this.recyclerView;
        if (r3 == null) goto L35;
        CallLogListAdapter r4 = this.listAdapter;
        if (r4 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L34:
        r2.closeAllSwipes(r3);
        goto L35
    L33:
        r2 = r4;
    L35:
        BottomDeleteLayoutListener r5 = this.bottomDeleteLayoutListener;
        if (r5 == null) goto L38;
        r5.startTransition(true);
    L38:
        BottomDeleteLayoutListener r6 = this.bottomDeleteLayoutListener;
        if (r6 == null) goto L41;
        String r8 = getString(R.string.delete_btn);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(R.string.delete_btn)");
        r6.setButtonText(r8);
    L41:
        BottomDeleteLayoutListener r9 = this.bottomDeleteLayoutListener;
        if (r9 == null) goto L44;
        r9.setLayoutVisible(true);
    L44:
        BottomDeleteLayoutListener r10 = this.bottomDeleteLayoutListener;
        if (r10 == null) goto L47;
        r10.setBottomBtnEnable(!r7.getSelectedIds().isEmpty());
    L47:
        CallLogTitleBarHelper r11 = this.titleBarHelper;
        if (r11 == null) goto L57;
        r11.renderEditMode(r7);
        return;
    L57:
        return;
    L50:
        BottomDeleteLayoutListener r12 = this.bottomDeleteLayoutListener;
        if (r12 == null) goto L53;
        r12.startTransition(false);
    L53:
        BottomDeleteLayoutListener r13 = this.bottomDeleteLayoutListener;
        if (r13 == null) goto L59;
        r13.setLayoutVisible(false);
        return;
    L59:
        return;
    L8:
        if (r7.isActive() == true) goto L23;
        RecyclerView r14 = this.recyclerView;
        if (r14 == null) goto L13;
        r14.setItemAnimator(null);
    L13:
        CallLogDeleteHelper r15 = this.deleteHelper;
        if (r15 != null) goto L16;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == true) goto L23;
        RecyclerView r17 = this.recyclerView;
        if (r17 == null) goto L23;
        this.editAnimator.finishEdit(r17);
        goto L23
    L16:
        if (r15.getShouldSkipExitAnimation() != true) goto L18;
        r16 = true;
        goto L19
    }

    private final void renderEmptyView(CallLogUiState r5) {
        if (r5.isLoading() == false) goto L5;
    L37:
        View r6 = this.emptyView;
        if (r6 == null) goto L41;
        r6.setVisibility(8);
    L41:
        RecyclerView r4 = this.recyclerView;
        if (r4 == null) goto L48;
        r4.setVisibility(0);
        return;
    L48:
        return;
    L5:
        if (r5.getItems().isEmpty() == false) goto L37;
        if (this.emptyView != null) goto L29;
        ViewStub r7 = this.emptyViewStub;
        CallLogViewModel r0 = null;
        if (r7 == null) goto L11;
        View r8 = r7.inflate();
    L12:
        this.emptyView = r8;
        if (r8 == null) goto L15;
        OPageStatus r9 = (OPageStatus) r8.findViewById(R.id.black_view);
    L16:
        if (r9 == null) goto L18;
        r9.setTitle(getString(R.string.call_log_empty));
    L18:
        CallLogViewModel r3 = this.viewModel;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        if (r0.isSingleContactMode() == false) goto L25;
        String r1 = getString(R.string.single_recentCalls_empty_secondary);
    L26:
        Intrinsics.checkNotNullExpressionValue(r1, "if (viewModel.isSingleCo…ondary)\n                }");
        if (r9 == null) goto L29;
        r9.setMessage(r1);
        goto L29
    L25:
        r1 = getString(R.string.call_log_empty_secondary);
        goto L26
    L21:
        r0 = r3;
        goto L23
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = null;
    L29:
        View r10 = this.emptyView;
        if (r10 == null) goto L33;
        r10.setVisibility(0);
    L33:
        RecyclerView r11 = this.recyclerView;
        if (r11 == null) goto L47;
        r11.setVisibility(8);
        return;
    }

    private final void animateSwipeDelete(CallLogItem r6, View r7) {
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = r7.getWidth();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[DEL-ANIM] swipe: Phase1 START, item=" + r6.getId() + ", translationX=" + r7.getTranslationX() + ", width=" + r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r7, "translationX", new float[]{r7.getTranslationX(), -r1});
        r2.setDuration(250);
        r2.setInterpolator(CubicInterpolator.OUT);
        r2.addListener(new AnonymousClass1(r7, r0, this, r6));
        r2.start();
    }

    public final List<Long> getCurrentVisibleContact() {
        RecyclerView r0 = this.recyclerView;
        if (r0 != null) goto L5;
        return null;
    L5:
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r3 = (LinearLayoutManager) r2;
    L9:
        if (r3 != null) goto L11;
        return null;
    L11:
        int r4 = r3.findFirstVisibleItemPosition();
        int r5 = r3.findLastVisibleItemPosition();
        if (r4 != (-1)) goto L14;
        return null;
    L14:
        ArrayList r6 = new ArrayList();
        if (r4 > r5) goto L33;
    L16:
        CallLogListAdapter r7 = this.listAdapter;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r7 = null;
    L19:
        List<CallLogItem> r8 = r7.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(r8, "listAdapter.currentList");
        CallLogItem r9 = (CallLogItem) CollectionsKt.getOrNull(r8, r4);
        if (r9 == null) goto L31;
        View r10 = r3.findViewByPosition(r4);
        if (r10 == null) goto L31;
        if (r4 != r5) goto L27;
        double r11 = 0.6d;
    L29:
        if (isItemVisible(r10, r0.getHeight(), r11) == false) goto L31;
        r6.add(Long.valueOf(r9.getId()));
        goto L31
    L27:
        r11 = 0.65d;
    L31:
        if (r4 == r5) goto L33;
        r4 = r4 + 1;
    L33:
        return r6;
    L8:
        r3 = null;
        goto L9
    }

    private final boolean isItemVisible(View r4, int r5, double r6) {
        int r3 = r4.getMeasuredHeight();
        if (r3 != 0) goto L5;
        return false;
    L5:
        int r1 = r4.getTop();
        int r7 = r4.getBottom();
        if (r1 >= 0) goto L9;
        double r8 = r1 + r3;
    L8:
        double r9 = r8 / ((double) r3);
    L13:
        if (r9 <= r6) goto L16;
        return true;
    L16:
        return false;
    L9:
        if (r7 <= r5) goto L11;
        r8 = r3 - (r7 - r5);
        goto L8
    L11:
        r9 = 1.0d;
        goto L13
    }

    public final void setFragmentsCallback(ContactFragmentsCallback r1) {
        this.fragmentsCallback = r1;
    }

    public final void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r1) {
        this.bottomDeleteLayoutListener = r1;
    }

    public final void setContactNumber(String r3) {
        Intrinsics.checkNotNullParameter(r3, "number");
        CallLogViewModel r2 = this.viewModel;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L5:
        r2.setContactNumber(r3);
        if (ContactsUtils.USER_LOG_ON == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setContactNumber: " + r3);
        return;
    L8:
        StringBuilder r4 = new StringBuilder("setContactNumber: hasNumber=");
        if (r3.length() <= 0) goto L11;
        boolean r5 = true;
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r4.append(r5).toString());
        return;
    L11:
        r5 = false;
        goto L12
    }

    public final void showDeleteCallLogDialog() {
        CallLogDeleteHelper r0 = this.deleteHelper;
        if (r0 == null) goto L6;
        r0.showDeleteDialog();
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r6) {
        if (this.viewModel != null) goto L5;
        return;
    L5:
        boolean r0 = this.isPageVisible;
        this.isPageVisible = r6;
        CallLogViewModel r4 = null;
        if (r6 == false) goto L23;
        if (r0 == true) goto L23;
        ContactInfoCache r7 = this.contactInfoCache;
        if (r7 == null) goto L11;
        r7.resumeProcessing();
    L11:
        ContactInfoCache r8 = this.contactInfoCache;
        if (r8 == null) goto L14;
        r8.invalidate();
    L14:
        CallLogViewModel r9 = this.viewModel;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r4.refresh();
        if (getKeyguardManager().isKeyguardLocked() == false) goto L21;
        this.pendingClearMissedCall = true;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onVisibilityChanged: visible, refreshing");
        return;
    L21:
        markMissedCallsAsRead();
        updateVoicemailNotifications();
        goto L22
    L17:
        r4 = r9;
    L23:
        if (r6 == true) goto L43;
        if (r0 == false) goto L44;
        ContactInfoCache r10 = this.contactInfoCache;
        if (r10 == null) goto L28;
        r10.pauseProcessing();
    L28:
        CallLogViewModel r11 = this.viewModel;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L32:
        if (r11.getUiState().getValue().getEditMode().isActive() == false) goto L34;
        exitEditMode$default(this, false, 1, null);
    L34:
        CallLogTitleBarHelper r12 = this.titleBarHelper;
        if (r12 == null) goto L37;
        r12.dismissPopover();
    L37:
        CallLogItemActionHelper r5 = this.itemActionHelper;
        if (r5 == null) goto L40;
        r5.dismissMenu();
    L40:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onVisibilityChanged: hidden, cleanup");
        return;
    L44:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r2, boolean r3) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable: visible=" + r2 + ", shouldTrigger=" + r3);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        CallLogViewModel r0 = this.viewModel;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L9:
        if (r0.getUiState().getValue().getEditMode().isActive() == false) goto L12;
        exitEditMode$default(this, false, 1, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "backToTopState: exited edit mode");
        return false;
    L12:
        return true;
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) this.keyguardManager$delegate.getValue();
    }

    private final void notifySummarizingItemsChanged() {
        Iterator<T> r0 = CallFeatureModel.INSTANCE.getSummarizingDataSet().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Pair r1 = (Pair) r0.next();
        CallLogListAdapter r2 = this.listAdapter;
        CallLogListAdapter r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r2 = null;
    L8:
        Integer r4 = r2.findPositionByDateNumber(((Number) r1.getFirst()).longValue(), (String) r1.getSecond());
        if (r4 == null) goto L4;
        int r5 = r4.intValue();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "fragment notifyResumeSummarizing date=" + ((Number) r1.getFirst()).longValue() + " pos=" + r5);
        CallLogListAdapter r6 = this.listAdapter;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
    L14:
        r3.notifyItemChanged(r5);
        goto L4
    L13:
        r3 = r6;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ContactsUtils.fatchVoiceMailNumber();
        Context r0 = getContext();
        if (r0 == null) goto L5;
        NotificationHelper.INSTANCE.cancelAllRecordNotification(r0);
    L5:
        CallLogViewModel r1 = this.viewModel;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L9:
        if (r1.getUiState().getValue().getEditMode().isActive() == false) goto L13;
        CallLogTitleBarHelper r2 = this.titleBarHelper;
        if (r2 == null) goto L16;
        r2.switchToEditState();
    L16:
        ContactInfoCache r3 = this.contactInfoCache;
        if (r3 == null) goto L19;
        r3.invalidate();
    L19:
        CallFeatureModel.INSTANCE.addCallFeatureModelListener(this.callFeatureListener);
        CallFeatureModel.INSTANCE.addCallSummaryStartedListener(this.callSummaryStartedListener);
        CallFeatureModel.INSTANCE.addCallSummaryFinishedListener(this.callSummaryFinishedListener);
        notifySummarizingItemsChanged();
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent("", TAG, null, null, 12, null));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[MISSED] onResume: keyguardLocked=" + getKeyguardManager().isKeyguardLocked());
        if (getKeyguardManager().isKeyguardLocked() == false) goto L22;
        this.pendingClearMissedCall = true;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[MISSED] onResume: keyguard locked, set pendingClearMissedCall=true");
        return;
    L22:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[MISSED] onResume: calling markMissedCallsAsRead + updateVoicemailNotifications");
        markMissedCallsAsRead();
        updateVoicemailNotifications();
        return;
    L13:
        CallLogTitleBarHelper r4 = this.titleBarHelper;
        if (r4 == null) goto L16;
        r4.switchToNormalState();
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopScrollFpsSampling();
        if (this.pendingClearMissedCall == true) goto L5;
    L7:
        CallFeatureModel.INSTANCE.removeCallFeatureModelListener(this.callFeatureListener);
        CallFeatureModel.INSTANCE.removeCallSummaryStartedListener(this.callSummaryStartedListener);
        CallFeatureModel.INSTANCE.removeCallSummaryFinishedListener(this.callSummaryFinishedListener);
        CallLogTitleBarHelper r2 = this.titleBarHelper;
        if (r2 == null) goto L10;
        r2.dismissPopover();
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onPause");
        return;
    L5:
        if (getKeyguardManager().isKeyguardLocked() == true) goto L7;
        this.pendingClearMissedCall = false;
        markMissedCallsAsRead();
        updateVoicemailNotifications();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        CallLogViewModel r0 = this.viewModel;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (r0.getUiState().getValue().getEditMode().isActive() == false) goto L8;
        exitEditMode$default(this, false, 1, null);
    L8:
        CallLogDeleteHelper r1 = this.deleteHelper;
        if (r1 == null) goto L11;
        r1.destroy();
    L11:
        CallLogItemActionHelper r3 = this.itemActionHelper;
        if (r3 == null) goto L14;
        r3.dismissMenu();
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onStop");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r4, int r5, Intent r6) {
        CallLogNumberMarkHelper r0 = this.numberMarkHelper;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        super.onActivityResult(r4, r5, r6);
        return;
    L5:
        if (r0.handleActivityResult(r4, r5, r6) != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.android.contacts.DSUtils.DSFatureStatusListener
    public void onDSFeatureStatusChanged() {
        if (CallLogTitleBarHelper.Companion.getFEATURE_CMCC_CU$app_QssiCnRelease() == false) goto L7;
        CallLogTitleBarHelper r0 = this.titleBarHelper;
        if (r0 == null) goto L7;
        r0.updateCallLogFilter();
    L7:
        CallLogViewModel r1 = this.viewModel;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L10:
        r1.refresh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopScrollFpsSampling();
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.unregisterDSFeatureStatusListener(this);
    L5:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L8;
        Immersive.Companion.getImmersive(r0).getNavigationBarHeight().removeObserver(this.navigationBarObserver);
    L8:
        ContactInfoCache r1 = this.contactInfoCache;
        if (r1 == null) goto L11;
        r1.stopProcessing();
    L11:
        this.contactInfoCache = null;
        this.recyclerView = null;
        this.emptyViewStub = null;
        this.emptyView = null;
        CallLogTitleBarHelper r2 = this.titleBarHelper;
        if (r2 == null) goto L14;
        r2.destroy();
    L14:
        this.titleBarHelper = null;
        CallLogDeleteHelper r3 = this.deleteHelper;
        if (r3 == null) goto L17;
        r3.destroy();
    L17:
        this.deleteHelper = null;
        CallLogItemActionHelper r4 = this.itemActionHelper;
        if (r4 == null) goto L20;
        r4.destroy();
    L20:
        this.itemActionHelper = null;
        this.numberMarkHelper = null;
        Agent.getInstance().onDetach(TAG, TAG);
        Agent.getInstance().flush();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onDestroyView");
    }

    private final void startScrollFpsSampling() {
        if (this.isScrollFpsSampling == false) goto L5;
        return;
    L5:
        this.isScrollFpsSampling = true;
        this.scrollFpsMonitor.start();
    }

    private final void stopScrollFpsSampling() {
        if (this.isScrollFpsSampling == true) goto L5;
        return;
    L5:
        this.isScrollFpsSampling = false;
        this.scrollFpsMonitor.stop();
    }

    private final void setupDualSim() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setupDualSim: multiSim=" + DSUtils.isMultiSimEnabled() + ", shouldUpdate=" + DSUtils.sShouldUpdateShowSimIcon + ", useDSFeature=" + DSUtils.useDSFeature());
        if (DSUtils.isMultiSimEnabled() == true) goto L6;
        return;
    L6:
        if (DSUtils.sShouldUpdateShowSimIcon == true) goto L8;
    L10:
        DSUtils.registerDSFeatureStatusListener(this);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setupDualSim: DSFeatureStatusListener registered");
        return;
    L8:
        if (DSUtils.useDSFeature() == false) goto L10;
        DSUtils.sShouldUpdateShowSimIcon = false;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C01741(requireContext().getApplicationContext(), null), 2, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setupDualSim: show_sim_icon update dispatched");
        goto L10
    }

    private final void markMissedCallsAsRead() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        ContentResolver r1 = r0.getContentResolver();
    L6:
        if (r1 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "[MISSED] markMissedCallsAsRead: activity null, abort");
        return;
    L9:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C01721(r1, this, null), 2, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void updateVoicemailNotifications() {
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.isDestroyed() == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failure to updateVoicemailNotifications, activity is destroyed");
        return;
    L9:
        Intent r0 = new Intent(r3, CallLogNotificationsService.class);
        r0.setAction(CallLogNotificationsService.ACTION_UPDATE_NOTIFICATIONS);
        r3.startService(r0);
    }
}
