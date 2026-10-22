package com.bytedance.android.livesdkapi.model;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 G2\u00020\u0001:\u0005GHIJKB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0013\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u0004\u0018\u00010\u0003J\u0012\u0010D\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010E\u001a\u00020:H\u0016J\b\u0010F\u001a\u00020+H\u0016R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R:\u0010)\u001a\"\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010*j\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u0001`,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0018\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerContextEntity;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/DialogFragment;", "rootView", "Landroid/widget/FrameLayout;", "enterExtra", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "(Landroidx/fragment/app/DialogFragment;Landroid/widget/FrameLayout;Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "isWrapper", "", "(Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;Landroid/widget/FrameLayout;Z)V", "activityRef", "Ljava/lang/ref/WeakReference;", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "setActivityRef", "(Ljava/lang/ref/WeakReference;)V", "autoFloatContext", "getAutoFloatContext", "()Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "setAutoFloatContext", "(Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;)V", "dataSource", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$FloatWindowDataSource;", "getDataSource", "()Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$FloatWindowDataSource;", "setDataSource", "(Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$FloatWindowDataSource;)V", "getEnterExtra", "()Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "setEnterExtra", "(Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;)V", "fragmentRef", "getFragmentRef", "setFragmentRef", "mobParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMobParams", "()Ljava/util/HashMap;", "setMobParams", "(Ljava/util/HashMap;)V", "requestPage", "getRequestPage", "()Ljava/lang/String;", "setRequestPage", "(Ljava/lang/String;)V", "getRootView", "()Landroid/widget/FrameLayout;", "rootViewRef", "type", "", "getType", "()I", "setType", "(I)V", "equals", "other", VideoEventOneOutSync.END_TYPE_FINISH, "", "getActivity", "getActivityRoot", "hashCode", "toString", "Companion", "FloatWindowDataSource", "InnerFloatExtra", "RoomEnterConfig", "UserCustomJump", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerContextEntity {
    public static final Companion Companion = null;
    public static final int TYPE_ACTIVITY = 1;
    public static final int TYPE_AUTO = 3;
    public static final int TYPE_FRAGMENT = 2;
    private WeakReference<Activity> activityRef;
    private IVideoFloatManager.AutoFloatEnable autoFloatContext;
    private FloatWindowDataSource dataSource;
    private InnerFloatExtra enterExtra;
    private WeakReference<DialogFragment> fragmentRef;
    private HashMap<String, String> mobParams;
    private String requestPage;
    private WeakReference<FrameLayout> rootViewRef;
    private int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$Companion;", "", "()V", "TYPE_ACTIVITY", "", "TYPE_AUTO", "TYPE_FRAGMENT", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$FloatWindowDataSource;", "", "getRoomData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "runAfterDataReady", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface FloatWindowDataSource {
        IRoom getRoomData();

        void runAfterDataReady(LifecycleOwner r100, Function1<? super Room, Unit> r101);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010x\u001a\u00020IR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R:\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR\u001a\u00105\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\u001a\u00108\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR\u001a\u0010;\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u000eR\u001a\u0010>\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR:\u0010A\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010&\"\u0004\bC\u0010(R\u001a\u0010D\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\"\u0010G\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\f\"\u0004\b\\\u0010\u000eR\u001a\u0010]\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0015\"\u0004\b_\u0010\u0017R\u001c\u0010`\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0015\"\u0004\bb\u0010\u0017R\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\f\"\u0004\bk\u0010\u000eR\u001a\u0010l\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\f\"\u0004\bn\u0010\u000eR\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\f\"\u0004\bw\u0010\u000e¨\u0006y"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "", "()V", "businessLine", "Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;", "getBusinessLine", "()Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;", "setBusinessLine", "(Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;)V", "enableChangePosition", "", "getEnableChangePosition", "()Z", "setEnableChangePosition", "(Z)V", "enableExtParams", "getEnableExtParams", "setEnableExtParams", "enterFromMerge", "", "getEnterFromMerge", "()Ljava/lang/String;", "setEnterFromMerge", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "enterRoomId", "", "getEnterRoomId", "()Ljava/lang/Long;", "setEnterRoomId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "extParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExtParams", "()Ljava/util/HashMap;", "setExtParams", "(Ljava/util/HashMap;)V", "finishOnClick", "getFinishOnClick", "setFinishOnClick", "floatViewHorizontalMargin", "", "getFloatViewHorizontalMargin", "()I", "setFloatViewHorizontalMargin", "(I)V", "forceNewActivityWhenJumpRoom", "getForceNewActivityWhenJumpRoom", "setForceNewActivityWhenJumpRoom", "forceNotSharedLiveClient", "getForceNotSharedLiveClient", "setForceNotSharedLiveClient", "forceResumeWhenStop", "getForceResumeWhenStop", "setForceResumeWhenStop", "forceUseSpecialRootView", "getForceUseSpecialRootView", "setForceUseSpecialRootView", "inBackGroud", "getInBackGroud", "setInBackGroud", "mobParams", "getMobParams", "setMobParams", ITTVideoEngineEventSource.KEY_MUTE, "getMute", "setMute", "onClickListener", "Lkotlin/Function0;", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "outerRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getOuterRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setOuterRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "params", "Landroid/widget/RelativeLayout$LayoutParams;", "getParams", "()Landroid/widget/RelativeLayout$LayoutParams;", "setParams", "(Landroid/widget/RelativeLayout$LayoutParams;)V", "reportFloatRoomReturnFull", "getReportFloatRoomReturnFull", "setReportFloatRoomReturnFull", "requestPage", "getRequestPage", "setRequestPage", "resolution", "getResolution", "setResolution", "roomEnterConfig", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$RoomEnterConfig;", "getRoomEnterConfig", "()Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$RoomEnterConfig;", "setRoomEnterConfig", "(Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$RoomEnterConfig;)V", "skipCheckResumed", "getSkipCheckResumed", "setSkipCheckResumed", "useNormalMode", "getUseNormalMode", "setUseNormalMode", "userCustomJump", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$UserCustomJump;", "getUserCustomJump", "()Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$UserCustomJump;", "setUserCustomJump", "(Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$UserCustomJump;)V", "whetherUnMuteWhenStop", "getWhetherUnMuteWhenStop", "setWhetherUnMuteWhenStop", "clear", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerFloatExtra {
        private FloatWindowBusinessLine businessLine;
        private boolean enableChangePosition;
        private boolean enableExtParams;
        private String enterFromMerge;
        private String enterMethod;
        private Long enterRoomId;
        private HashMap<String, String> extParams;
        private boolean finishOnClick;
        private int floatViewHorizontalMargin;
        private boolean forceNewActivityWhenJumpRoom;
        private boolean forceNotSharedLiveClient;
        private boolean forceResumeWhenStop;
        private boolean forceUseSpecialRootView;
        private boolean inBackGroud;
        private HashMap<String, String> mobParams;
        private boolean mute;
        private Function0<Unit> onClickListener;
        private Room outerRoom;
        private RelativeLayout.LayoutParams params;
        private boolean reportFloatRoomReturnFull;
        private String requestPage;
        private String resolution;
        private RoomEnterConfig roomEnterConfig;
        private boolean skipCheckResumed;
        private boolean useNormalMode;
        private UserCustomJump userCustomJump;
        private boolean whetherUnMuteWhenStop;

        public final void clear() {
            this.enterRoomId = null;
            this.mobParams = null;
            this.mute = false;
        }

        public InnerFloatExtra() {
            this.requestPage = "";
            this.finishOnClick = true;
            this.inBackGroud = true;
            this.whetherUnMuteWhenStop = true;
            this.enterFromMerge = "";
            this.enterMethod = "";
        }

        public final FloatWindowBusinessLine getBusinessLine() {
            return this.businessLine;
        }

        public final boolean getEnableChangePosition() {
            return this.enableChangePosition;
        }

        public final boolean getEnableExtParams() {
            return this.enableExtParams;
        }

        public final String getEnterFromMerge() {
            return this.enterFromMerge;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final Long getEnterRoomId() {
            return this.enterRoomId;
        }

        public final HashMap<String, String> getExtParams() {
            return this.extParams;
        }

        public final boolean getFinishOnClick() {
            return this.finishOnClick;
        }

        public final int getFloatViewHorizontalMargin() {
            return this.floatViewHorizontalMargin;
        }

        public final boolean getForceNewActivityWhenJumpRoom() {
            return this.forceNewActivityWhenJumpRoom;
        }

        public final boolean getForceNotSharedLiveClient() {
            return this.forceNotSharedLiveClient;
        }

        public final boolean getForceResumeWhenStop() {
            return this.forceResumeWhenStop;
        }

        public final boolean getForceUseSpecialRootView() {
            return this.forceUseSpecialRootView;
        }

        public final boolean getInBackGroud() {
            return this.inBackGroud;
        }

        public final HashMap<String, String> getMobParams() {
            return this.mobParams;
        }

        public final boolean getMute() {
            return this.mute;
        }

        public final Function0<Unit> getOnClickListener() {
            return this.onClickListener;
        }

        public final Room getOuterRoom() {
            return this.outerRoom;
        }

        public final RelativeLayout.LayoutParams getParams() {
            return this.params;
        }

        public final boolean getReportFloatRoomReturnFull() {
            return this.reportFloatRoomReturnFull;
        }

        public final String getRequestPage() {
            return this.requestPage;
        }

        public final String getResolution() {
            return this.resolution;
        }

        public final RoomEnterConfig getRoomEnterConfig() {
            return this.roomEnterConfig;
        }

        public final boolean getSkipCheckResumed() {
            return this.skipCheckResumed;
        }

        public final boolean getUseNormalMode() {
            return this.useNormalMode;
        }

        public final UserCustomJump getUserCustomJump() {
            return this.userCustomJump;
        }

        public final boolean getWhetherUnMuteWhenStop() {
            return this.whetherUnMuteWhenStop;
        }

        public final void setBusinessLine(FloatWindowBusinessLine r100) {
            this.businessLine = r100;
        }

        public final void setEnableChangePosition(boolean r100) {
            this.enableChangePosition = r100;
        }

        public final void setEnableExtParams(boolean r100) {
            this.enableExtParams = r100;
        }

        public final void setEnterFromMerge(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.enterFromMerge = r100;
        }

        public final void setEnterMethod(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.enterMethod = r100;
        }

        public final void setEnterRoomId(Long r100) {
            this.enterRoomId = r100;
        }

        public final void setExtParams(HashMap<String, String> r100) {
            this.extParams = r100;
        }

        public final void setFinishOnClick(boolean r100) {
            this.finishOnClick = r100;
        }

        public final void setFloatViewHorizontalMargin(int r100) {
            this.floatViewHorizontalMargin = r100;
        }

        public final void setForceNewActivityWhenJumpRoom(boolean r100) {
            this.forceNewActivityWhenJumpRoom = r100;
        }

        public final void setForceNotSharedLiveClient(boolean r100) {
            this.forceNotSharedLiveClient = r100;
        }

        public final void setForceResumeWhenStop(boolean r100) {
            this.forceResumeWhenStop = r100;
        }

        public final void setForceUseSpecialRootView(boolean r100) {
            this.forceUseSpecialRootView = r100;
        }

        public final void setInBackGroud(boolean r100) {
            this.inBackGroud = r100;
        }

        public final void setMobParams(HashMap<String, String> r100) {
            this.mobParams = r100;
        }

        public final void setMute(boolean r100) {
            this.mute = r100;
        }

        public final void setOnClickListener(Function0<Unit> r100) {
            this.onClickListener = r100;
        }

        public final void setOuterRoom(Room r100) {
            this.outerRoom = r100;
        }

        public final void setParams(RelativeLayout.LayoutParams r100) {
            this.params = r100;
        }

        public final void setReportFloatRoomReturnFull(boolean r100) {
            this.reportFloatRoomReturnFull = r100;
        }

        public final void setRequestPage(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.requestPage = r100;
        }

        public final void setResolution(String r100) {
            this.resolution = r100;
        }

        public final void setRoomEnterConfig(RoomEnterConfig r100) {
            this.roomEnterConfig = r100;
        }

        public final void setSkipCheckResumed(boolean r100) {
            this.skipCheckResumed = r100;
        }

        public final void setUseNormalMode(boolean r100) {
            this.useNormalMode = r100;
        }

        public final void setUserCustomJump(UserCustomJump r100) {
            this.userCustomJump = r100;
        }

        public final void setWhetherUnMuteWhenStop(boolean r100) {
            this.whetherUnMuteWhenStop = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$RoomEnterConfig;", "", "eventParams", "", "businessLiveParams", "businessExtra", "localLifeParams", "enterBundleParams", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "getBusinessExtra", "()Ljava/lang/String;", "getBusinessLiveParams", "getEnterBundleParams", "()Landroid/os/Bundle;", "getEventParams", "getLocalLifeParams", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RoomEnterConfig {
        private final String businessExtra;
        private final String businessLiveParams;
        private final Bundle enterBundleParams;
        private final String eventParams;
        private final String localLifeParams;

        public RoomEnterConfig() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ RoomEnterConfig copy$default(RoomEnterConfig r100, String r101, String r102, String r103, String r104, Bundle r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.eventParams;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.businessLiveParams;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.businessExtra;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.localLifeParams;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.enterBundleParams;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.eventParams;
        }

        public final String component2() {
            return this.businessLiveParams;
        }

        public final String component3() {
            return this.businessExtra;
        }

        public final String component4() {
            return this.localLifeParams;
        }

        public final Bundle component5() {
            return this.enterBundleParams;
        }

        public final RoomEnterConfig copy(String r100, String r101, String r110, String r111, Bundle r112) {
            return new RoomEnterConfig(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof RoomEnterConfig) == false) goto L16;
            RoomEnterConfig r101 = (RoomEnterConfig) r100;
            if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.businessLiveParams, r101.businessLiveParams) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.businessExtra, r101.businessExtra) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.localLifeParams, r101.localLifeParams) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.enterBundleParams, r101.enterBundleParams) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            String r100 = this.eventParams;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.businessLiveParams;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.businessExtra;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.localLifeParams;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Bundle r113 = this.enterBundleParams;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "RoomEnterConfig(eventParams=" + this.eventParams + ", businessLiveParams=" + this.businessLiveParams + ", businessExtra=" + this.businessExtra + ", localLifeParams=" + this.localLifeParams + ", enterBundleParams=" + this.enterBundleParams + ")";
        }

        public final String getBusinessExtra() {
            return this.businessExtra;
        }

        public final String getBusinessLiveParams() {
            return this.businessLiveParams;
        }

        public final Bundle getEnterBundleParams() {
            return this.enterBundleParams;
        }

        public final String getEventParams() {
            return this.eventParams;
        }

        public final String getLocalLifeParams() {
            return this.localLifeParams;
        }

        public RoomEnterConfig(String r100, String r101, String r102, String r103, Bundle r104) {
            this.eventParams = r100;
            this.businessLiveParams = r101;
            this.businessExtra = r102;
            this.localLifeParams = r103;
            this.enterBundleParams = r104;
        }

        public /* synthetic */ RoomEnterConfig(String r100, String r101, String r102, String r103, Bundle r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            String r112 = null;
        L7:
            if ((r110 & 2) == 0) goto L9;
            String r105 = null;
        L11:
            if ((r110 & 4) == 0) goto L13;
            String r106 = null;
        L15:
            if ((r110 & 8) == 0) goto L17;
            String r107 = null;
        L19:
            if ((r110 & 16) == 0) goto L21;
            Bundle r113 = null;
        L22:
            this(r112, r105, r106, r107, r113);
            return;
        L21:
            r113 = r104;
            goto L22
        L17:
            r107 = r103;
            goto L19
        L13:
            r106 = r102;
            goto L15
        L9:
            r105 = r101;
            goto L11
        L5:
            r112 = r100;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$UserCustomJump;", "", "()V", "action", "Lkotlin/Function0;", "", "getAction", "()Lkotlin/jvm/functions/Function0;", "setAction", "(Lkotlin/jvm/functions/Function0;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableClickActionPredict", "getEnableClickActionPredict", "setEnableClickActionPredict", "enableClickAnimPredict", "getEnableClickAnimPredict", "setEnableClickAnimPredict", "isImmersed", "setImmersed", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UserCustomJump {
        private Function0<Unit> action;
        private boolean enable;
        private Function0<Boolean> enableClickActionPredict;
        private Function0<Boolean> enableClickAnimPredict;
        private boolean isImmersed;

        public String toString() {
            return "InnerContextEntity.UserCustomJump(enable=" + this.enable + ", enableClickActionPredict=" + this.enableClickActionPredict + ", action=" + this.action + ", enableClickAnim=" + this.enableClickAnimPredict + ", isImmersed=" + this.isImmersed + ')';
        }

        public UserCustomJump() {
            this.enableClickActionPredict = InnerContextEntity$UserCustomJump$enableClickActionPredict$1.INSTANCE;
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final Function0<Boolean> getEnableClickActionPredict() {
            return this.enableClickActionPredict;
        }

        public final Function0<Boolean> getEnableClickAnimPredict() {
            return this.enableClickAnimPredict;
        }

        public final boolean isImmersed() {
            return this.isImmersed;
        }

        public final void setAction(Function0<Unit> r100) {
            this.action = r100;
        }

        public final void setEnable(boolean r100) {
            this.enable = r100;
        }

        public final void setEnableClickActionPredict(Function0<Boolean> r100) {
            this.enableClickActionPredict = r100;
        }

        public final void setEnableClickAnimPredict(Function0<Boolean> r100) {
            this.enableClickAnimPredict = r100;
        }

        public final void setImmersed(boolean r100) {
            this.isImmersed = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void finish() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        WeakReference<Activity> r101 = this.activityRef;
        if (r101 == null) goto L34;
        Activity r102 = r101.get();
        if (r102 == null) goto L35;
        r102.finish();
        return;
    L35:
        return;
    L34:
        return;
    L5:
        if (r100 != 2) goto L7;
        WeakReference<DialogFragment> r103 = this.fragmentRef;
        if (r103 == null) goto L29;
        DialogFragment r104 = r103.get();
        if (r104 == null) goto L30;
        FragmentManager r105 = r104.getFragmentManager();
        if (r105 != null) goto L19;
        return;
    L19:
        if (r105.isDestroyed() == true) goto L32;
        INVOKEVIRTUAL_com_bytedance_android_livesdkapi_model_InnerContextEntity_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r104);
        return;
    L32:
        return;
    L30:
        return;
    L29:
        return;
    L7:
        if (r100 != 3) goto L36;
        IVideoFloatManager.AutoFloatEnable r106 = this.autoFloatContext;
        if (r106 == null) goto L27;
        r106.finish();
        return;
    L27:
        return;
    }

    public final Activity getActivity() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        WeakReference<Activity> r101 = this.activityRef;
        if (r101 != null) goto L15;
        return null;
    L15:
        return r101.get();
    L5:
        if (r100 != 2) goto L20;
        WeakReference<DialogFragment> r102 = this.fragmentRef;
        if (r102 == null) goto L16;
        DialogFragment r103 = r102.get();
        if (r103 != null) goto L18;
        return null;
    L18:
        return r103.getActivity();
    L16:
        return null;
    L20:
        return null;
    }

    public final FrameLayout getRootView() {
        WeakReference<FrameLayout> r100 = this.rootViewRef;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public int hashCode() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        WeakReference<Activity> r101 = this.activityRef;
        if (r101 == null) goto L25;
        Activity r102 = r101.get();
        if (r102 == null) goto L25;
        return r102.hashCode();
    L25:
        return super.hashCode();
    L5:
        if (r100 != 2) goto L7;
        WeakReference<DialogFragment> r103 = this.fragmentRef;
        if (r103 == null) goto L30;
        DialogFragment r104 = r103.get();
        if (r104 == null) goto L30;
        return r104.hashCode();
    L30:
        return super.hashCode();
    L7:
        if (r100 != 3) goto L26;
        IVideoFloatManager.AutoFloatEnable r105 = this.autoFloatContext;
        if (r105 == null) goto L28;
        return r105.hashCode();
    L28:
        return super.hashCode();
    L26:
        return super.hashCode();
    }

    public String toString() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        WeakReference<Activity> r101 = this.activityRef;
        if (r101 == null) goto L28;
        Activity r102 = r101.get();
        if (r102 == null) goto L28;
        String r103 = r102.toString();
        if (r103 == null) goto L28;
        return r103;
    L28:
        return super.toString();
    L5:
        if (r100 != 2) goto L7;
        WeakReference<DialogFragment> r104 = this.fragmentRef;
        if (r104 == null) goto L33;
        DialogFragment r105 = r104.get();
        if (r105 == null) goto L33;
        String r106 = r105.toString();
        if (r106 == null) goto L33;
        return r106;
    L33:
        return super.toString();
    L7:
        if (r100 != 3) goto L29;
        IVideoFloatManager.AutoFloatEnable r107 = this.autoFloatContext;
        if (r107 == null) goto L31;
        String r108 = r107.toString();
        if (r108 == null) goto L31;
        return r108;
    L31:
        return super.toString();
    L29:
        return super.toString();
    }

    public final WeakReference<Activity> getActivityRef() {
        return this.activityRef;
    }

    public final IVideoFloatManager.AutoFloatEnable getAutoFloatContext() {
        return this.autoFloatContext;
    }

    public final FloatWindowDataSource getDataSource() {
        return this.dataSource;
    }

    public final InnerFloatExtra getEnterExtra() {
        return this.enterExtra;
    }

    public final WeakReference<DialogFragment> getFragmentRef() {
        return this.fragmentRef;
    }

    public final HashMap<String, String> getMobParams() {
        return this.mobParams;
    }

    public final String getRequestPage() {
        return this.requestPage;
    }

    public final int getType() {
        return this.type;
    }

    public InnerContextEntity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.type = 1;
        this.requestPage = "";
        this.activityRef = new WeakReference(r100);
        this.rootViewRef = new WeakReference(getActivityRoot(r100));
        this.type = 1;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_livesdkapi_model_InnerContextEntity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdkapi_model_InnerContextEntity_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    private final FrameLayout getActivityRoot(Activity r100) {
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        View r102 = INVOKEVIRTUAL_com_bytedance_android_livesdkapi_model_InnerContextEntity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
        if (r102 == null) goto L7;
        FrameLayout r103 = (FrameLayout) r102.findViewById(R.id.content);
    L9:
        if ((r103 instanceof FrameLayout) == true) goto L12;
        return null;
    L12:
        return r103;
    L7:
        r103 = null;
        goto L9
    }

    public boolean equals(Object r100) {
        Activity r101 = null;
        if ((r100 instanceof InnerContextEntity) == true) goto L5;
        Object r102 = null;
    L6:
        InnerContextEntity r103 = (InnerContextEntity) r102;
        if (r103 == null) goto L36;
        int r104 = r103.type;
        int r105 = this.type;
        if (r104 == r105) goto L12;
        return false;
    L12:
        if (r105 != 1) goto L14;
        WeakReference<Activity> r106 = ((InnerContextEntity) r100).activityRef;
        if (r106 == null) goto L30;
        Activity r107 = r106.get();
    L31:
        WeakReference<Activity> r108 = this.activityRef;
        if (r108 == null) goto L35;
        r101 = r108.get();
    L35:
        return Intrinsics.areEqual(r107, r101);
    L30:
        r107 = null;
        goto L31
    L14:
        if (r105 != 2) goto L16;
        WeakReference<DialogFragment> r109 = ((InnerContextEntity) r100).fragmentRef;
        if (r109 == null) goto L22;
        DialogFragment r110 = r109.get();
    L23:
        WeakReference<DialogFragment> r111 = this.fragmentRef;
        if (r111 == null) goto L40;
        r101 = r111.get();
    L40:
        return Intrinsics.areEqual(r110, r101);
    L22:
        r110 = null;
        goto L23
    L16:
        if (r105 == 3) goto L39;
        return super.equals(r100);
    L39:
        return Intrinsics.areEqual(((InnerContextEntity) r100).autoFloatContext, this.autoFloatContext);
    L36:
        return false;
    L5:
        r102 = r100;
        goto L6
    }

    public final void setActivityRef(WeakReference<Activity> r100) {
        this.activityRef = r100;
    }

    public final void setAutoFloatContext(IVideoFloatManager.AutoFloatEnable r100) {
        this.autoFloatContext = r100;
    }

    public final void setDataSource(FloatWindowDataSource r100) {
        this.dataSource = r100;
    }

    public final void setEnterExtra(InnerFloatExtra r100) {
        this.enterExtra = r100;
    }

    public final void setFragmentRef(WeakReference<DialogFragment> r100) {
        this.fragmentRef = r100;
    }

    public final void setMobParams(HashMap<String, String> r100) {
        this.mobParams = r100;
    }

    public final void setRequestPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestPage = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public InnerContextEntity(DialogFragment r100, FrameLayout r101, InnerFloatExtra r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.type = 1;
        this.requestPage = "";
        this.fragmentRef = new WeakReference(r100);
        if (r102 != null) goto L5;
    L7:
        Dialog r103 = r100.getDialog();
        View r104 = null;
        if (r103 == null) goto L12;
        Window r105 = r103.getWindow();
        if (r105 == null) goto L12;
        View r106 = INVOKEVIRTUAL_com_bytedance_android_livesdkapi_model_InnerContextEntity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r105);
    L14:
        if ((r106 instanceof FrameLayout) == false) goto L17;
        r104 = r106;
    L17:
        FrameLayout r107 = (FrameLayout) r104;
        if (r107 == null) goto L21;
        r101 = r107;
    L21:
        this.rootViewRef = new WeakReference(r101);
        this.type = 2;
        return;
    L12:
        r106 = null;
        goto L14
    L5:
        if (r102.getForceUseSpecialRootView() != true) goto L7;
        goto L7
    }

    public InnerContextEntity(IVideoFloatManager.AutoFloatEnable r100, FrameLayout r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        this.type = 1;
        this.requestPage = "";
        this.autoFloatContext = r100;
        this.rootViewRef = new WeakReference(r101);
        this.type = 3;
    }

    public /* synthetic */ InnerContextEntity(DialogFragment r100, FrameLayout r101, InnerFloatExtra r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
