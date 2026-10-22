package com.android.ttcjpaysdk.base.ui.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import cd4.m;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayExperimentValue;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.android.ttcjpaysdk.base.settings.bean.LynxSchemaParamsConfig;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.caijing.sdk.infra.base.api.container.annieXCard.ICJAnnieCardService;
import com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalEventService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ed4.b;
import ed4.g;
import ed4.h;
import ed4.i;
import id4.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0005SRTUVB\u0011\b\u0016\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NB\u001b\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\bM\u0010QJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0002J\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0016J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\tJ\u001a\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012J\u001a\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0012J\u001c\u0010(\u001a\u00020\u00062\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ1\u0010.\u001a\u00020\u0006\"\b\b\u0000\u0010**\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+2\b\u0010-\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b.\u0010/J)\u00100\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010**\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016¢\u0006\u0004\b0\u00101J \u00102\u001a\u00020\u0006\"\b\b\u0000\u0010**\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0016J\b\u00103\u001a\u00020\u0006H\u0016R\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0018\u0010F\u001a\u00060ER\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u00109¨\u0006W"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard;", "Landroid/widget/FrameLayout;", "Lid4/c;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "getLayoutId", "", "bind", "registerJsb", "", "schema", "Led4/b;", "buildCJAnnieLynxCardModel", "", "", "buildGlobalProps", "", "buildInitData", "Lorg/json/JSONObject;", "getABTestMap", "registerDefaultSubscriber", "Led4/i;", "getAnnieXCardLifeCycle", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ErrorInfo;", "error", "onLoadFail", "onSuccess", "CJTag", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ICJAnnieXCardView;", "annieXCardView", "setConfig", "load", SendEventContainerMethodParamModel.EventKinds.onShow, "onHide", "getContainerId", "eventName", "params", "sendEvent", "dispatchEvent", "globalProps", "updateGlobalProps", "Ljd4/a;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "instance", "putCtx", "(Ljava/lang/Class;Ljd4/a;)V", "getCtx", "(Ljava/lang/Class;)Ljd4/a;", "removeCtx", "release", "Lcom/bytedance/caijing/sdk/infra/base/api/container/annieXCard/ICJAnnieCardService;", "annieService", "Lcom/bytedance/caijing/sdk/infra/base/api/container/annieXCard/ICJAnnieCardService;", "rootView", "Landroid/widget/FrameLayout;", "Ljava/lang/String;", "cjAnnieXCardView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ICJAnnieXCardView;", "Led4/g;", "cjAnnieCard", "Led4/g;", "cjAnnieLifeCycle", "Led4/i;", "", "loadSuccess", "Z", "hasCallbackLoadStatus", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$AnnieXCardActivityLifecycle;", "activityLifecycleCallback", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$AnnieXCardActivityLifecycle;", "defaultSubscriber", "Ljava/lang/Object;", "annieViewTag", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "AnnieXCardActivityLifecycle", "ErrorInfo", "GlobalPropsBuildParams", "ICJAnnieXCardView", "base-context_release"}, k = 1, mv = {1, 6, 0})
public class CJAnnieXCard extends FrameLayout implements c, ICJTag {
    private static final String ANNIEX_VIEW_TAG = "cj_anniex_view_tag";
    public static final Companion Companion = null;
    public static final String EVENT_NAME = "cjpay_event_name";
    public static final String EVENT_NATIVE_TO_LYNX = "cjpay_lynxcard_common_event_from_native";
    public static final String LYNX_CARD_COMMENT_EVENT = "cjpay_lynxcard_common_event";
    public static final String TAG = "CJAnnieXCard";
    private final AnnieXCardActivityLifecycle activityLifecycleCallback;
    private final ICJAnnieCardService annieService;
    private String annieViewTag;
    private g cjAnnieCard;
    private i cjAnnieLifeCycle;
    private ICJAnnieXCardView cjAnnieXCardView;
    private Object defaultSubscriber;
    private boolean hasCallbackLoadStatus;
    private boolean loadSuccess;
    private FrameLayout rootView;
    private String schema;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$AnnieXCardActivityLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "(Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class AnnieXCardActivityLifecycle implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ CJAnnieXCard this$0;

        public AnnieXCardActivityLifecycle(CJAnnieXCard r100) {
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$Companion;", "", "()V", "ANNIEX_VIEW_TAG", "", "EVENT_NAME", "EVENT_NATIVE_TO_LYNX", "LYNX_CARD_COMMENT_EVENT", "TAG", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ErrorInfo;", "", "(Ljava/lang/String;I)V", "TIMEOUT", SpeechEngineDefines.LOG_LEVEL_FATAL, "UNKNOWN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ErrorInfo extends Enum<ErrorInfo> {
        private static final /* synthetic */ ErrorInfo[] $VALUES = null;
        public static final ErrorInfo FATAL = null;
        public static final ErrorInfo TIMEOUT = null;
        public static final ErrorInfo UNKNOWN = null;

        private static final /* synthetic */ ErrorInfo[] $values() {
            return new ErrorInfo[]{TIMEOUT, FATAL, UNKNOWN};
        }

        public static ErrorInfo valueOf(String r100) {
            return (ErrorInfo) a.a(ErrorInfo.class, r100);
        }

        public static ErrorInfo[] values() {
            return (ErrorInfo[]) $VALUES.clone();
        }

        static {
            TIMEOUT = new ErrorInfo("TIMEOUT", 0);
            FATAL = new ErrorInfo(SpeechEngineDefines.LOG_LEVEL_FATAL, 1);
            UNKNOWN = new ErrorInfo("UNKNOWN", 2);
            $VALUES = $values();
        }

        private ErrorInfo(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$GlobalPropsBuildParams;", "", "needGlobalProps", "", "onlyBasicProps", "additionalGlobalProps", "", "", "cjData", "(ZZLjava/util/Map;Ljava/lang/Object;)V", "getAdditionalGlobalProps", "()Ljava/util/Map;", "getCjData", "()Ljava/lang/Object;", "getNeedGlobalProps", "()Z", "getOnlyBasicProps", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H\u0017J\n\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0017J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ICJAnnieXCardView;", "", "", "getSchema", "getTag", "", "getInitData", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$GlobalPropsBuildParams;", "getGlobalPropsBuildParams", "getGlobalProps", "getCJData", "", "Lcd4/m;", "getJSB", "eventName", "Lorg/json/JSONObject;", "params", "", "onEvent", "onLoadSuccess", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXCard$ErrorInfo;", "error", "onLoadFailed", "", "getLoadTimeout", "", "needTimeoutCallback", "Led4/i;", "getLifeCycle", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public interface ICJAnnieXCardView {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated(message = "use getGlobalPropsBuildParams instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
            public static Object getCJData(ICJAnnieXCardView r100) {
                return null;
            }

            @Deprecated(message = "use getGlobalPropsBuildParams instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
            public static Map<String, Object> getGlobalProps(ICJAnnieXCardView r100) {
                return null;
            }

            public static GlobalPropsBuildParams getGlobalPropsBuildParams(ICJAnnieXCardView r100) {
                return null;
            }

            public static Map<String, Object> getInitData(ICJAnnieXCardView r100) {
                return null;
            }

            public static List<m> getJSB(ICJAnnieXCardView r100) {
                return null;
            }

            public static i getLifeCycle(ICJAnnieXCardView r100) {
                return null;
            }

            public static long getLoadTimeout(ICJAnnieXCardView r100) {
                return 5000;
            }

            public static String getTag(ICJAnnieXCardView r100) {
                return "";
            }

            public static boolean needTimeoutCallback(ICJAnnieXCardView r100) {
                return false;
            }

            public static void onEvent(ICJAnnieXCardView r100, String r101, JSONObject r102) {
                Intrinsics.checkNotNullParameter(r101, "eventName");
                Intrinsics.checkNotNullParameter(r102, "params");
            }

            public static void onLoadSuccess(ICJAnnieXCardView r100) {
            }

            public static /* synthetic */ void onLoadFailed$default(ICJAnnieXCardView r100, ErrorInfo r101, int r102, Object r103) {
                if (r103 != null) goto L9;
                if ((r102 & 1) == 0) goto L6;
                r101 = ErrorInfo.UNKNOWN;
            L6:
                r100.onLoadFailed(r101);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadFailed");
            }
        }

        @Deprecated(message = "use getGlobalPropsBuildParams instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
        Object getCJData();

        @Deprecated(message = "use getGlobalPropsBuildParams instead", replaceWith = @ReplaceWith(expression = "getGlobalPropsBuildParams", imports = {}))
        Map<String, Object> getGlobalProps();

        GlobalPropsBuildParams getGlobalPropsBuildParams();

        Map<String, Object> getInitData();

        List<m> getJSB();

        i getLifeCycle();

        long getLoadTimeout();

        String getSchema();

        String getTag();

        boolean needTimeoutCallback();

        void onEvent(String r100, JSONObject r101);

        void onLoadFailed(ErrorInfo r100);

        void onLoadSuccess();
    }

    static {
        Companion = new Companion(null);
    }

    private final Map<String, Object> buildGlobalProps() {
        Map<? extends String, ? extends Object> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_annie_card", "1"), TuplesKt.to("cj_timestamp", Long.valueOf(System.currentTimeMillis())), TuplesKt.to("cj_sdk_version", KtSafeMethodExtensionKt.or(CJPayBasicUtils.getRealVersion(), "unknown"))});
        ICJAnnieXCardView r101 = this.cjAnnieXCardView;
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
        ICJAnnieXCardView r106 = this.cjAnnieXCardView;
        if (r106 == null) goto L19;
        GlobalPropsBuildParams r107 = r106.getGlobalPropsBuildParams();
        if (r107 == null) goto L19;
        Map<String, Object> r108 = r107.getAdditionalGlobalProps();
        if (r108 == null) goto L19;
    L23:
        if (r108 == null) goto L25;
        r108.putAll(r100);
    L26:
        ICJAnnieXCardView r109 = this.cjAnnieXCardView;
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
        ICJAnnieXCardView r113 = this.cjAnnieXCardView;
        if (r113 == null) goto L37;
        r102 = r113.getCJData();
        goto L37
    L25:
        r108 = r100;
    L19:
        ICJAnnieXCardView r114 = this.cjAnnieXCardView;
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

    private final Map<String, Object> buildInitData() {
        ICJAnnieXCardView r100 = this.cjAnnieXCardView;
        if (r100 == null) goto L6;
        Map<String, Object> r101 = r100.getInitData();
        if (r101 == null) goto L6;
    L7:
        Object r102 = null;
        if ((!r101.containsKey("cj_initial_props")) == false) goto L10;
        Map<String, Object> r103 = r101;
    L11:
        if (r103 == null) goto L20;
        Pair[] r104 = new Pair[1];
        ICJAnnieXCardView r105 = this.cjAnnieXCardView;
        if (r105 == null) goto L19;
        GlobalPropsBuildParams r106 = r105.getGlobalPropsBuildParams();
        if (r106 == null) goto L18;
        r102 = r106.getCjData();
        if (r102 != null) goto L19;
    L18:
        r102 = r105.getCJData();
    L19:
        r104[0] = TuplesKt.to("cj_data", r102);
        r103.put("cj_initial_props", MapsKt.mutableMapOf(r104));
    L20:
        return r101;
    L10:
        r103 = null;
    L6:
        r101 = new LinkedHashMap();
        goto L7
    }

    private final i getAnnieXCardLifeCycle() {
        i r100 = this.cjAnnieLifeCycle;
        if (r100 != null) goto L6;
        cd4.a r101 = new AnonymousClass1(this);
        this.cjAnnieLifeCycle = r101;
        return r101;
    L6:
        return r100;
    }

    private final void onSuccess() {
        if (this.hasCallbackLoadStatus == true) goto L8;
        this.hasCallbackLoadStatus = true;
        this.loadSuccess = true;
        ICJAnnieXCardView r100 = this.cjAnnieXCardView;
        if (r100 == null) goto L9;
        r100.onLoadSuccess();
        return;
    L9:
        return;
    }

    private final void registerDefaultSubscriber() {
        g r100 = this.cjAnnieCard;
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
        this.defaultSubscriber = ((CJExternalEventService) ve4.a.d(CJExternalEventService.class)).registerSubscriber(r102, System.currentTimeMillis(), "cjpay_lynxcard_common_event", new C89191(r102, this));
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void registerJsb() {
        g r100 = this.cjAnnieCard;
        if (r100 == null) goto L10;
        ICJAnnieXCardView r101 = this.cjAnnieXCardView;
        if (r101 == null) goto L7;
        List<m> r102 = r101.getJSB();
    L8:
        r100.c(r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        ICJAnnieXCardView r100 = this.cjAnnieXCardView;
        if (r100 == null) goto L5;
        String r101 = r100.getTag();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return "CJAnnieXCard-".concat(r101);
    L5:
        r101 = null;
        goto L6
    }

    public final String getContainerId() {
        g r100 = this.cjAnnieCard;
        if (r100 == null) goto L5;
        String r101 = r100.getContainerID();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final void load() {
        if (this.cjAnnieXCardView == null) goto L8;
        g r100 = this.cjAnnieCard;
        if (r100 == null) goto L9;
        r100.h(getAnnieXCardLifeCycle());
        return;
    L9:
        return;
    }

    public final void onHide() {
        g r100 = this.cjAnnieCard;
        if (r100 == null) goto L6;
        r100.onHide();
        return;
    }

    public final void onShow() {
        g r100 = this.cjAnnieCard;
        if (r100 == null) goto L6;
        r100.onShow();
        return;
    }

    private final void bind() {
        View r100 = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        FrameLayout r101 = null;
        if ((r100 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = (FrameLayout) r102.findViewById(R.id.cj_pay_annie_x_card_root);
    L8:
        this.rootView = r101;
        return;
    L5:
        r102 = null;
        goto L6
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
        g r103 = this.cjAnnieCard;
        if (r103 == null) goto L12;
        r103.release();
    L12:
        View r104 = findViewWithTag(this.annieViewTag);
        if (r104 == null) goto L16;
        removeView(r104);
    L16:
        if (CJPayOptimizeSwitch.Companion.get().lynxEventMemoryLeakFix == false) goto L23;
        Object r105 = this.defaultSubscriber;
        if (r105 == null) goto L24;
        ve4.a.f554342a.getClass();
        CJExternalEventService r106 = (CJExternalEventService) ve4.a.a(CJExternalEventService.class);
        if (r106 == null) goto L25;
        r106.unregisterSubscriber(r105, "cjpay_lynxcard_common_event");
        return;
    L25:
        return;
    L24:
        return;
    }

    public CJAnnieXCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ve4.a.f554342a.getClass();
        this.annieService = (ICJAnnieCardService) ve4.a.a(ICJAnnieCardService.class);
        this.schema = "";
        this.activityLifecycleCallback = new AnnieXCardActivityLifecycle(this);
        this.annieViewTag = "";
        bind();
    }

    public static final /* synthetic */ ICJAnnieXCardView access$getCjAnnieXCardView$p(CJAnnieXCard r100) {
        return r100.cjAnnieXCardView;
    }

    public static final /* synthetic */ boolean access$getLoadSuccess$p(CJAnnieXCard r100) {
        return r100.loadSuccess;
    }

    public static final /* synthetic */ void access$onSuccess(CJAnnieXCard r100) {
        r100.onSuccess();
    }

    private final b buildCJAnnieLynxCardModel(String r100) {
        b r101 = new b(r100);
        ICJAnnieXCardView r102 = this.cjAnnieXCardView;
        if (r102 == null) goto L7;
        GlobalPropsBuildParams r103 = r102.getGlobalPropsBuildParams();
        if (r103 == null) goto L7;
        Boolean r104 = Boolean.valueOf(r103.getNeedGlobalProps());
    L8:
        if (r104 == null) goto L10;
        boolean r105 = r104.booleanValue();
    L11:
        if (r105 == false) goto L13;
        r101.f472202c = buildGlobalProps();
    L13:
        r101.f472201b = buildInitData();
        return r101;
    L10:
        r105 = true;
    L7:
        r104 = null;
        goto L8
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

    private final void onLoadFail(ErrorInfo r100) {
        if (this.hasCallbackLoadStatus == true) goto L8;
        this.hasCallbackLoadStatus = true;
        this.loadSuccess = false;
        ICJAnnieXCardView r101 = this.cjAnnieXCardView;
        if (r101 == null) goto L9;
        r101.onLoadFailed(r100);
        return;
    L9:
        return;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // id4.c
    public <T extends jd4.a> T getCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        g r101 = this.cjAnnieCard;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.getCtx(r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Deprecated(message = "use setConfig and load")
    public final void load(ICJAnnieXCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "annieXCardView");
        setConfig(r100);
        load();
    }

    @Override // id4.c
    public <T extends jd4.a> void removeCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        g r101 = this.cjAnnieCard;
        if (r101 == null) goto L6;
        r101.removeCtx(r100);
        return;
    }

    public final void setConfig(ICJAnnieXCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "annieXCardView");
        Context r101 = getContext();
        if (r101 == null) goto L9;
        Activity r102 = CJPayBasicExtensionKt.toActivity(r101);
        if (r102 == null) goto L9;
        Application r103 = r102.getApplication();
        if (r103 == null) goto L9;
        r103.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallback);
    L9:
        Context r104 = getContext();
        if (r104 == null) goto L16;
        Activity r105 = CJPayBasicExtensionKt.toActivity(r104);
        if (r105 == null) goto L16;
        Application r106 = r105.getApplication();
        if (r106 == null) goto L16;
        r106.registerActivityLifecycleCallbacks(this.activityLifecycleCallback);
    L16:
        this.cjAnnieXCardView = r100;
        this.schema = r100.getSchema();
        ICJAnnieCardService r107 = this.annieService;
        if (r107 == null) goto L21;
        h r108 = r107.getCJAnnieCardFactory(new ed4.a(getContext()), buildCJAnnieLynxCardModel(this.schema));
        if (r108 == null) goto L21;
        com.bytedance.caijing.sdk.infra.base.impl.container.anniex_card.a r109 = r108.b();
    L22:
        this.cjAnnieCard = r109;
        registerJsb();
        registerDefaultSubscriber();
        g r110 = this.cjAnnieCard;
        if (r110 == null) goto L28;
        View r111 = r110.getView();
        if (r111 == null) goto L29;
        String r112 = ANNIEX_VIEW_TAG + UUID.randomUUID();
        this.annieViewTag = r112;
        r111.setTag(r112);
        addView(r111, new FrameLayout.LayoutParams(-1, -1));
        return;
    L29:
        return;
    L28:
        return;
    L21:
        r109 = null;
        goto L22
    }

    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        g r101 = this.cjAnnieCard;
        if (r101 == null) goto L6;
        r101.updateGlobalProps(r100);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public CJAnnieXCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ve4.a.f554342a.getClass();
        this.annieService = (ICJAnnieCardService) ve4.a.a(ICJAnnieCardService.class);
        this.schema = "";
        this.activityLifecycleCallback = new AnnieXCardActivityLifecycle(this);
        this.annieViewTag = "";
        bind();
    }

    public static final /* synthetic */ void access$onLoadFail(CJAnnieXCard r100, ErrorInfo r101) {
        r100.onLoadFail(r101);
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(CJAnnieXCard r100, boolean r101) {
        r100.loadSuccess = r101;
    }

    public final void dispatchEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        g r102 = this.cjAnnieCard;
        if (r102 == null) goto L6;
        r102.sendEvent(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // id4.c
    public <T extends jd4.a> void putCtx(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        g r102 = this.cjAnnieCard;
        if (r102 == null) goto L6;
        r102.putCtx(r100, r101);
        return;
    }

    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        g r102 = this.cjAnnieCard;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        KtSafeMethodExtensionKt.safePut(r101, "cjpay_event_name", r100);
        Unit r103 = Unit.INSTANCE;
        r102.sendEvent("cjpay_lynxcard_common_event_from_native", r101);
        return;
    }

    public static /* synthetic */ void onLoadFail$default(CJAnnieXCard r100, ErrorInfo r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = ErrorInfo.UNKNOWN;
    L6:
        r100.onLoadFail(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLoadFail");
    }

    public static /* synthetic */ void dispatchEvent$default(CJAnnieXCard r100, String r101, JSONObject r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.dispatchEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchEvent");
    }

    public static /* synthetic */ void sendEvent$default(CJAnnieXCard r100, String r101, JSONObject r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.sendEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
    }
}
