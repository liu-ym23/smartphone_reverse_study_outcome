package com.android.ttcjpaysdk.base.ui.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import cd4.m;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJSchemaExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayExperimentValue;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.settings.bean.LynxSchemaParamsConfig;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.caijing.sdk.infra.base.api.container.annieXCard.ICJAnnieCardService;
import com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import ed4.d;
import ed4.f;
import ed4.j;
import ed4.k;
import ed4.l;
import fd4.a;
import id4.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004UTVWB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PB\u001b\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0004\bO\u0010SJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010 \u001a\u00020\u0015J\u001c\u0010\"\u001a\u00020\r2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006J\u000e\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#J1\u0010+\u001a\u00020\r\"\b\b\u0000\u0010'*\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\b\u0010*\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b+\u0010,J)\u0010-\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010'*\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0004\b-\u0010.J \u0010/\u001a\u00020\r\"\b\b\u0000\u0010'*\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016J\u0006\u00100\u001a\u00020\rJ\u0006\u00101\u001a\u00020\rR\u0016\u00103\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00106R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010<R\u0018\u0010>\u001a\u00060=R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010\n\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010J\"\u0004\bK\u0010L¨\u0006X"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;", "Landroid/widget/FrameLayout;", "Lid4/c;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "getLayoutId", "", "", "", "buildGlobalProps", "schema", "Lorg/json/JSONObject;", "getABTestMap", "", "registerDefaultSubscriber", "registerDefaultCJCardContext", "Led4/l;", "getAnnieXCardLifeCycle", "CJTag", "bind", "release", "", "useBulletCard", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$ICJAnnieXCardView;", "webCardView", "setConfig", "load", "eventName", "params", "sendEvent", SendEventContainerMethodParamModel.EventKinds.onShow, "onHide", "isPreRender", SlcElement.KEY_PROPS, "setWindowProps", "Led4/f;", "delegate", "addWebViewScrollDelegate", "Ljd4/a;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "instance", "putCtx", "(Ljava/lang/Class;Ljd4/a;)V", "getCtx", "(Ljava/lang/Class;)Ljd4/a;", "removeCtx", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "Lcom/bytedance/caijing/sdk/infra/base/api/container/annieXCard/ICJAnnieCardService;", "annieService", "Lcom/bytedance/caijing/sdk/infra/base/api/container/annieXCard/ICJAnnieCardService;", "rootView", "Landroid/widget/FrameLayout;", "loadingRootView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "loadingView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "cardContainer", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$ICJAnnieXCardView;", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$AnnieXCardActivityLifecycle;", "activityLifecycleCallback", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$AnnieXCardActivityLifecycle;", "Led4/k;", "cjAnnieWebCardFactory", "Led4/k;", "Led4/j;", "cjAnnieWebCard", "Led4/j;", "Z", "defaultSubscriber", "Ljava/lang/Object;", "value", "Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "AnnieXCardActivityLifecycle", "GlobalPropsBuildParams", "ICJAnnieXCardView", "base-context_release"}, k = 1, mv = {1, 6, 0})
public class CJAnnieXWebCard extends FrameLayout implements c, ICJTag {
    public static final String CARD_COMMENT_EVENT = "cjpay_card_common_event";
    public static final Companion Companion = null;
    public static final String EVENT_NAME = "cjpay_event_name";
    public static final String EVENT_NATIVE_TO_CARD = "cjpay_card_common_event_from_native";
    public static final String TAG = "CJAnnieXWebCard";
    private final AnnieXCardActivityLifecycle activityLifecycleCallback;
    private final ICJAnnieCardService annieService;
    private FrameLayout cardContainer;
    private j cjAnnieWebCard;
    private k cjAnnieWebCardFactory;
    private Object defaultSubscriber;
    private FrameLayout loadingRootView;
    private CJPayTextLoadingView loadingView;
    private FrameLayout rootView;
    private String schema;
    private boolean useBulletCard;
    private ICJAnnieXCardView webCardView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$AnnieXCardActivityLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "(Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class AnnieXCardActivityLifecycle implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ CJAnnieXWebCard this$0;

        public AnnieXCardActivityLifecycle(CJAnnieXWebCard r100) {
            this.this$0 = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivityDestroyed, " + r100);
            this.this$0.release();
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivityPaused, " + r100);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivityResumed, " + r100);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivityStarted, " + r100);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivityStopped, " + r100);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivityCreated, " + r100);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
            if (Intrinsics.areEqual(this.this$0.getContext(), r100) == false) goto L6;
            CJLogger.d(this.this$0.CJTag(), "onActivitySaveInstanceState, " + r100);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$Companion;", "", "()V", "CARD_COMMENT_EVENT", "", "EVENT_NAME", "EVENT_NATIVE_TO_CARD", "TAG", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$GlobalPropsBuildParams;", "", "needGlobalProps", "", "onlyBasicProps", "additionalGlobalProps", "", "", "cjData", "(ZZLjava/util/Map;Ljava/lang/Object;)V", "getAdditionalGlobalProps", "()Ljava/util/Map;", "getCjData", "()Ljava/lang/Object;", "getNeedGlobalProps", "()Z", "getOnlyBasicProps", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GlobalPropsBuildParams {
        private final Map<String, Object> additionalGlobalProps;
        private final Object cjData;
        private final boolean needGlobalProps;
        private final boolean onlyBasicProps;

        public GlobalPropsBuildParams() {
            this(false, false, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GlobalPropsBuildParams copy$default(GlobalPropsBuildParams r100, boolean r101, boolean r102, Map r103, Object r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.needGlobalProps;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.onlyBasicProps;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.additionalGlobalProps;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.cjData;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final boolean component1() {
            return this.needGlobalProps;
        }

        public final boolean component2() {
            return this.onlyBasicProps;
        }

        public final Map<String, Object> component3() {
            return this.additionalGlobalProps;
        }

        public final Object component4() {
            return this.cjData;
        }

        public final GlobalPropsBuildParams copy(boolean r100, boolean r101, Map<String, Object> r102, Object r103) {
            return new GlobalPropsBuildParams(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GlobalPropsBuildParams) == true) goto L8;
            return false;
        L8:
            GlobalPropsBuildParams r101 = (GlobalPropsBuildParams) r100;
            if (this.needGlobalProps == r101.needGlobalProps) goto L12;
            return false;
        L12:
            if (this.onlyBasicProps == r101.onlyBasicProps) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.additionalGlobalProps, r101.additionalGlobalProps) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.cjData, r101.cjData) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = 1231;
            if (this.needGlobalProps == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.onlyBasicProps == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            Map<String, Object> r104 = this.additionalGlobalProps;
            int r105 = 0;
            if (r104 != null) goto L13;
            int r106 = 0;
        L14:
            int r107 = (r103 + r106) * 31;
            Object r108 = this.cjData;
            if (r108 == null) goto L19;
            r105 = r108.hashCode();
        L19:
            return r107 + r105;
        L13:
            r106 = r104.hashCode();
            goto L14
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "GlobalPropsBuildParams(needGlobalProps=" + this.needGlobalProps + ", onlyBasicProps=" + this.onlyBasicProps + ", additionalGlobalProps=" + this.additionalGlobalProps + ", cjData=" + this.cjData + ')';
        }

        public final Map<String, Object> getAdditionalGlobalProps() {
            return this.additionalGlobalProps;
        }

        public final Object getCjData() {
            return this.cjData;
        }

        public final boolean getNeedGlobalProps() {
            return this.needGlobalProps;
        }

        public final boolean getOnlyBasicProps() {
            return this.onlyBasicProps;
        }

        public GlobalPropsBuildParams(boolean r100, boolean r101, Map<String, Object> r102, Object r103) {
            this.needGlobalProps = r100;
            this.onlyBasicProps = r101;
            this.additionalGlobalProps = r102;
            this.cjData = r103;
        }

        public /* synthetic */ GlobalPropsBuildParams(boolean r100, boolean r101, Map r102, Object r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = true;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0017J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0017J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$ICJAnnieXCardView;", "", "", "getSchema", "getTag", "", "Lcd4/m;", "getJSB", "eventName", "Lorg/json/JSONObject;", "params", "", "onEvent", "Led4/l;", "getLifecycle", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard$GlobalPropsBuildParams;", "getGlobalPropsBuildParams", "", "getGlobalProps", "getCJData", "", "getPageHeight", "()Ljava/lang/Integer;", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public interface ICJAnnieXCardView {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated(message = "use getGlobalPropsBuildParams() instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
            public static Object getCJData(ICJAnnieXCardView r100) {
                return null;
            }

            @Deprecated(message = "use getGlobalPropsBuildParams() instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
            public static Map<String, Object> getGlobalProps(ICJAnnieXCardView r100) {
                return null;
            }

            public static GlobalPropsBuildParams getGlobalPropsBuildParams(ICJAnnieXCardView r100) {
                return null;
            }

            public static List<m> getJSB(ICJAnnieXCardView r100) {
                return null;
            }

            public static l getLifecycle(ICJAnnieXCardView r100) {
                return null;
            }

            public static Integer getPageHeight(ICJAnnieXCardView r100) {
                return null;
            }

            public static String getTag(ICJAnnieXCardView r100) {
                return "";
            }

            public static void onEvent(ICJAnnieXCardView r100, String r101, JSONObject r102) {
                Intrinsics.checkNotNullParameter(r101, "eventName");
                Intrinsics.checkNotNullParameter(r102, "params");
            }
        }

        @Deprecated(message = "use getGlobalPropsBuildParams() instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
        Object getCJData();

        @Deprecated(message = "use getGlobalPropsBuildParams() instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
        Map<String, Object> getGlobalProps();

        GlobalPropsBuildParams getGlobalPropsBuildParams();

        List<m> getJSB();

        l getLifecycle();

        Integer getPageHeight();

        String getSchema();

        String getTag();

        void onEvent(String r100, JSONObject r101);
    }

    static {
        Companion = new Companion(null);
    }

    private final Map<String, Object> buildGlobalProps() {
        Map<? extends String, ? extends Object> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_annie_card", "1"), TuplesKt.to("cj_timestamp", Long.valueOf(System.currentTimeMillis())), TuplesKt.to("cj_sdk_version", KtSafeMethodExtensionKt.or(CJPayBasicUtils.getRealVersion(), "unknown"))});
        ICJAnnieXCardView r101 = this.webCardView;
        Object r102 = null;
        if (r101 == null) goto L7;
        GlobalPropsBuildParams r103 = r101.getGlobalPropsBuildParams();
        if (r103 == null) goto L7;
        Boolean r104 = Boolean.valueOf(r103.getOnlyBasicProps());
    L8:
        if (r104 == null) goto L10;
        boolean r105 = r104.booleanValue();
    L11:
        if (r105 == true) goto L13;
        r100.put("cj_bio_info", KtSafeMethodExtensionKt.safeCreate(CJPayBasicUtils.getBiometricsInfo("")));
        r100.put("cj_ab_test", getABTestMap(this.schema));
    L13:
        ICJAnnieXCardView r106 = this.webCardView;
        if (r106 == null) goto L19;
        GlobalPropsBuildParams r107 = r106.getGlobalPropsBuildParams();
        if (r107 == null) goto L19;
        Map<String, Object> r108 = r107.getAdditionalGlobalProps();
        if (r108 == null) goto L19;
    L23:
        if (r108 == null) goto L25;
        r108.putAll(r100);
    L26:
        ICJAnnieXCardView r109 = this.webCardView;
        if (r109 == null) goto L34;
        GlobalPropsBuildParams r110 = r109.getGlobalPropsBuildParams();
        if (r110 == null) goto L34;
        Object r111 = r110.getCjData();
        if (r111 == null) goto L34;
        r102 = r111;
    L37:
        if (r102 != null) goto L39;
    L41:
        return r108;
    L39:
        if (r108.containsKey("cj_initial_props") == true) goto L41;
        Map r112 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_data", r102)});
        r112.putAll(r100);
        r108.put("cj_initial_props", r112);
    L34:
        ICJAnnieXCardView r113 = this.webCardView;
        if (r113 == null) goto L37;
        r102 = r113.getCJData();
        goto L37
    L25:
        r108 = r100;
    L19:
        ICJAnnieXCardView r114 = this.webCardView;
        if (r114 == null) goto L22;
        r108 = r114.getGlobalProps();
        goto L23
    L22:
        r108 = null;
        goto L23
    L10:
        r105 = false;
    L7:
        r104 = null;
        goto L8
    }

    private final int getLayoutId() {
        return R.layout.cj_pay_annie_x_card_layout;
    }

    private final l getAnnieXCardLifeCycle() {
        return new AnonymousClass1(this);
    }

    private final void registerDefaultCJCardContext() {
        putCtx(a.class, new C89201(this));
    }

    private final void registerDefaultSubscriber() {
        j r100 = this.cjAnnieWebCard;
        if (r100 == null) goto L5;
        String r101 = r100.getContainerID();
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        final String r102 = r101;
        if (StringsKt.isBlank(r102) == false) goto L12;
        CJLogger.b(CJTag(), "registerDefaultSubscriber-containerId is empty");
        return;
    L12:
        ve4.a.f554342a.getClass();
        this.defaultSubscriber = ((CJExternalEventService) ve4.a.d(CJExternalEventService.class)).registerSubscriber(r102, System.currentTimeMillis(), CARD_COMMENT_EVENT, new C89211(r102, this));
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        ICJAnnieXCardView r100 = this.webCardView;
        if (r100 == null) goto L5;
        String r101 = r100.getTag();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return "CJAnnieXWebCard-".concat(r101);
    L5:
        r101 = null;
        goto L6
    }

    public final void hideLoading() {
        FrameLayout r100 = this.loadingRootView;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        CJPayTextLoadingView r101 = this.loadingView;
        if (r101 == null) goto L10;
        r101.hide();
        return;
    }

    public final boolean isPreRender() {
        j r100 = this.cjAnnieWebCard;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPreRender();
    }

    public final void load() {
        if (this.webCardView == null) goto L8;
        j r100 = this.cjAnnieWebCard;
        if (r100 == null) goto L9;
        r100.a(getAnnieXCardLifeCycle());
        return;
    L9:
        return;
    }

    public final void onHide() {
        j r100 = this.cjAnnieWebCard;
        if (r100 == null) goto L6;
        r100.onHide();
        return;
    }

    public final void onShow() {
        j r100 = this.cjAnnieWebCard;
        if (r100 == null) goto L6;
        r100.onShow();
        return;
    }

    public final void showLoading() {
        FrameLayout r100 = this.loadingRootView;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L6:
        if (r101 == null) goto L15;
        ICJAnnieXCardView r102 = this.webCardView;
        if (r102 == null) goto L13;
        Integer r103 = r102.getPageHeight();
        if (r103 == null) goto L13;
        int r104 = CJPayBasicExtensionKt.dip2px(r103.intValue(), getContext());
    L14:
        r101.height = r104;
    L13:
        r104 = -1;
    L15:
        FrameLayout r105 = this.loadingRootView;
        if (r105 == null) goto L19;
        r105.setLayoutParams(r101);
    L19:
        FrameLayout r106 = this.loadingRootView;
        if (r106 == null) goto L23;
        r106.setVisibility(0);
    L23:
        CJPayTextLoadingView r107 = this.loadingView;
        if (r107 == null) goto L27;
        r107.show(false);
        return;
    L27:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void bind() {
        Context r100 = getContext();
        if (r100 == null) goto L9;
        Activity r101 = CJPayBasicExtensionKt.toActivity(r100);
        if (r101 == null) goto L9;
        Application r102 = r101.getApplication();
        if (r102 == null) goto L9;
        r102.registerActivityLifecycleCallbacks(this.activityLifecycleCallback);
    L9:
        View r103 = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        FrameLayout r104 = null;
        if ((r103 instanceof FrameLayout) == false) goto L12;
        FrameLayout r105 = (FrameLayout) r103;
    L13:
        if (r105 == null) goto L15;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.cj_pay_annie_x_card_root);
    L16:
        this.rootView = r106;
        if (r105 == null) goto L19;
        FrameLayout r107 = (FrameLayout) r105.findViewById(R.id.loading_root_view);
    L20:
        this.loadingRootView = r107;
        if (r105 == null) goto L23;
        CJPayTextLoadingView r108 = (CJPayTextLoadingView) r105.findViewById(R.id.loading_view);
    L24:
        this.loadingView = r108;
        if (r105 == null) goto L27;
        r104 = (FrameLayout) r105.findViewById(R.id.card_container);
    L27:
        this.cardContainer = r104;
        return;
    L23:
        r108 = null;
        goto L24
    L19:
        r107 = null;
        goto L20
    L15:
        r106 = null;
        goto L16
    L12:
        r105 = null;
        goto L13
    }

    @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
    public void release() {
        Context r100 = getContext();
        if (r100 == null) goto L9;
        Activity r101 = CJPayBasicExtensionKt.toActivity(r100);
        if (r101 == null) goto L9;
        Application r102 = r101.getApplication();
        if (r102 == null) goto L9;
        r102.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallback);
    L9:
        j r103 = this.cjAnnieWebCard;
        if (r103 == null) goto L13;
        r103.release();
    L13:
        if (CJPayOptimizeSwitch.Companion.get().lynxEventMemoryLeakFix == false) goto L20;
        Object r104 = this.defaultSubscriber;
        if (r104 == null) goto L21;
        ve4.a.f554342a.getClass();
        CJExternalEventService r105 = (CJExternalEventService) ve4.a.a(CJExternalEventService.class);
        if (r105 == null) goto L22;
        r105.unregisterSubscriber(r104, CARD_COMMENT_EVENT);
        return;
    L22:
        return;
    L21:
        return;
    }

    public CJAnnieXWebCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ve4.a.f554342a.getClass();
        this.annieService = (ICJAnnieCardService) ve4.a.a(ICJAnnieCardService.class);
        this.activityLifecycleCallback = new AnnieXCardActivityLifecycle(this);
        this.schema = "";
        bind();
    }

    public static final /* synthetic */ String access$getSchema$p(CJAnnieXWebCard r100) {
        return r100.schema;
    }

    public static final /* synthetic */ ICJAnnieXCardView access$getWebCardView$p(CJAnnieXWebCard r100) {
        return r100.webCardView;
    }

    private final JSONObject getABTestMap(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        LynxSchemaParamsConfig r102 = CJPaySettingsManager.getInstance().getLynxSchemaParamsConfig();     // Catch: Throwable -> L17
        ArrayList<String> r103 = null;
        if (r102 == null) goto L5;
        ArrayList<String> r104 = r102.getABTestKeys(r100);     // Catch: Throwable -> L17
    L6:
        if (r104 == null) goto L16;
        if ((!r104.isEmpty()) == false) goto L10;
        r103 = r104;
    L10:
        if (r103 == null) goto L16;
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L17
        Iterator<T> r106 = r103.iterator();     // Catch: Throwable -> L17
    L13:
        if (r106.hasNext() == false) goto L22;
        String r107 = (String) r106.next();     // Catch: Throwable -> L17
        KtSafeMethodExtensionKt.safePut(r105, r107, (String) new CJPayExperimentValue(r107, String.class, "").value(false));     // Catch: Throwable -> L17
        goto L13
    L22:
        return r105;
    L16:
        return new JSONObject();
    L5:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return new JSONObject();
    }

    private final void setSchema(String r100) {
        this.schema = CJSchemaExtensionKt.appendQueryParameter(r100, MapsKt.mapOf(TuplesKt.to("reload_after_process_gone", "1")));
    }

    public final void addWebViewScrollDelegate(f r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        j r101 = this.cjAnnieWebCard;
        if (r101 == null) goto L6;
        r101.addWebViewScrollDelegate(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // id4.c
    public <T extends jd4.a> T getCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        j r101 = this.cjAnnieWebCard;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.getCtx(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    public final void load(ICJAnnieXCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "webCardView");
        setConfig(r100);
        load();
    }

    @Override // id4.c
    public <T extends jd4.a> void removeCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        j r101 = this.cjAnnieWebCard;
        if (r101 == null) goto L6;
        r101.removeCtx(r100);
        return;
    }

    public final void setConfig(ICJAnnieXCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "webCardView");
        this.webCardView = r100;
        setSchema(r100.getSchema());
        ed4.c r101 = new ed4.c(getContext());
        d r102 = new d(this.schema);
        GlobalPropsBuildParams r103 = r100.getGlobalPropsBuildParams();
        j r104 = null;
        if (r103 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r103.getNeedGlobalProps());
    L6:
        if (r105 == null) goto L8;
        boolean r106 = r105.booleanValue();
    L9:
        if (r106 == false) goto L12;
        r102.f472205b = buildGlobalProps();
    L12:
        if (this.useBulletCard == false) goto L16;
        ICJAnnieCardService r107 = this.annieService;
        if (r107 == null) goto L19;
        k r108 = r107.getCJBulletCardFactory(r101, r102);
    L20:
        this.cjAnnieWebCardFactory = r108;
        if (r108 == null) goto L23;
        r104 = r108.g();
    L23:
        this.cjAnnieWebCard = r104;
        if (r104 == null) goto L30;
        View r109 = r104.getWebView();
        if (r109 == null) goto L30;
        FrameLayout r110 = this.cardContainer;
        if (r110 == null) goto L30;
        r110.addView(r109, new FrameLayout.LayoutParams(-1, -1));
    L30:
        registerDefaultSubscriber();
        registerDefaultCJCardContext();
        return;
    L19:
        r108 = null;
        goto L20
    L16:
        ICJAnnieCardService r111 = this.annieService;
        if (r111 == null) goto L19;
        r108 = r111.getCJAnnieWebCardFactory(r101, r102);
        goto L20
    L8:
        r106 = true;
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    public final void setWindowProps(Map<String, ? extends Object> r100) {
        j r101 = this.cjAnnieWebCard;
        if (r101 == null) goto L6;
        r101.setWindowProps(r100);
        return;
    }

    public final void useBulletCard(boolean r100) {
        this.useBulletCard = r100;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public CJAnnieXWebCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ve4.a.f554342a.getClass();
        this.annieService = (ICJAnnieCardService) ve4.a.a(ICJAnnieCardService.class);
        this.activityLifecycleCallback = new AnnieXCardActivityLifecycle(this);
        this.schema = "";
        bind();
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // id4.c
    public <T extends jd4.a> void putCtx(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        j r102 = this.cjAnnieWebCard;
        if (r102 == null) goto L6;
        r102.putCtx(r100, r101);
        return;
    }

    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        j r102 = this.cjAnnieWebCard;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        KtSafeMethodExtensionKt.safePut(r101, "cjpay_event_name", r100);
        r102.sendEvent(EVENT_NATIVE_TO_CARD, Unit.INSTANCE);
        return;
    }
}
