package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import obric.util.Utils;
import org.json.JSONObject;

/* JADX INFO: compiled from: MatrixTeaManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017*\u0003\n\r\u0018\u0018\u0000 F2\u00020\u0001:\u0002FGB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u0004\u0018\u00010\"J\b\u0010$\u001a\u0004\u0018\u00010\"J\b\u0010%\u001a\u0004\u0018\u00010\"J\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020*J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020-J\"\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010-J\u000e\u00103\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020*J\u000e\u00104\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020*J\u0016\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\u0011J\u001a\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\"2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\"J\u0016\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020-J\u0018\u0010>\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020-H\u0002J\u001e\u0010?\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010@\u001a\u00020-J\"\u0010?\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010'\u001a\u00020*J\b\u0010B\u001a\u00020\u001dH\u0002J\u0006\u0010C\u001a\u00020\u001dJ\u000e\u0010D\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014J\f\u0010E\u001a\u00020-*\u00020-H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;", "(Landroid/content/Context;Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;)V", "backgroundHandler", "Landroid/os/Handler;", WsConstants.KEY_CONNECTION, "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$connection$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$connection$1;", "deviceInfoCallback", "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$deviceInfoCallback$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$deviceInfoCallback$1;", "handler", "isBound", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/DeviceInfoListener;", "pendingEvents", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$PendingEvent;", "retryRunnable", "com/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$retryRunnable$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$retryRunnable$1;", "service", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDataService;", "addDeviceInfoListener", "", "listener", "bindService", "bindServiceInternal", Utils.METHOD_GET_DEVICE_ID, "", "getInstallId", "getOAID", "getUDID", "onApmColdLaunchFirstFrameEvent", "duration", "", "onApmColdLaunchFirstFrameEventTail", "", "onApmColdLaunchUserCompleteEvent", "extraInfo", "Lorg/json/JSONObject;", "onApmFpsEvent", "pageName", "fps", "", "frameDrop", "onApmHotLaunchEvent", "onApmHotLaunchEventTail", "onApmMemoryEvent", "memorySize", "isForeGround", "onButtonClickEvent", "componentName", "scene", "onEvent", "eventName", "jsonObject", "onEventInternal", "onPageShowEvent", "extra", "prevPageName", "processPendingEvents", "rebindService", "removeDeviceInfoListener", "copyJson", "Companion", "PendingEvent", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixTeaManager {
    private static final long BIND_RETRY_INTERVAL = 5000;
    public static final Companion Companion = null;
    private static final String EVENT_APM_COLD_LAUNCH_FIRST_FRAME = "apm_event_coldlaunch_first_frame";
    private static final String EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL = "apm_event_coldlaunch_first_frame_tail";
    private static final String EVENT_APM_COLD_USER_COMPLETE = "apm_event_coldlaunch_user_complete";
    private static final String EVENT_APM_FPS = "apm_event_fps";
    private static final String EVENT_APM_HOT_LAUNCH = "apm_event_hotlaunch";
    private static final String EVENT_APM_HOT_LAUNCH_TAIL = "apm_event_hotlaunch_tail";
    private static final String EVENT_APM_MEMORY = "apm_event_memory";
    private static final String EVENT_BUTTON_CLICK = "button_click";
    private static final String EVENT_PAGE_SHOW = "page_show";
    private static final String TAG = "MatrixTeaManager";
    private static String did;
    private static MatrixTeaManager instance;
    private static final AtomicBoolean isInited = null;
    private static String mUDid;
    private static String myInstallId;
    private final Handler backgroundHandler;
    private final MatrixTeaConfig config;
    private final MatrixTeaManager$connection$1 connection;
    private final Context context;
    private final MatrixTeaManager$deviceInfoCallback$1 deviceInfoCallback;
    private final Handler handler;
    private boolean isBound;
    private final CopyOnWriteArrayList<DeviceInfoListener> listeners;
    private final CopyOnWriteArrayList<PendingEvent> pendingEvents;
    private final MatrixTeaManager$retryRunnable$1 retryRunnable;
    private IDataService service;

    /* JADX INFO: compiled from: MatrixTeaManager.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u0013\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$Companion;", "", "()V", "BIND_RETRY_INTERVAL", "", "EVENT_APM_COLD_LAUNCH_FIRST_FRAME", "", "EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL", "EVENT_APM_COLD_USER_COMPLETE", "EVENT_APM_FPS", "EVENT_APM_HOT_LAUNCH", "EVENT_APM_HOT_LAUNCH_TAIL", "EVENT_APM_MEMORY", "EVENT_BUTTON_CLICK", "EVENT_PAGE_SHOW", "TAG", "did", "instance", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager;", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mUDid", "myInstallId", "getInstance", "init", "", "context", "Landroid/content/Context;", "config", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void init(Context r3, MatrixTeaConfig r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "config");
            if (MatrixTeaManager.access$getInstance$cp() == null) goto L5;
        L15:
            MatrixTeaManager r2 = MatrixTeaManager.access$getInstance$cp();
            Intrinsics.checkNotNull(r2);
            r2.bindService();
            return;
        L5:
            monitor-enter(MatrixTeaManager.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (MatrixTeaManager.access$getInstance$cp() != null) goto L9;
            Companion r0 = MatrixTeaManager.Companion;     // Catch: Throwable -> L12
            MatrixTeaManager.access$setInstance$cp(new MatrixTeaManager(r3, r4, null));     // Catch: Throwable -> L12
        L9:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(MatrixTeaManager.class);
            goto L15
        }

        public final boolean isInited() {
            return MatrixTeaManager.access$isInited$cp().get();
        }

        public final MatrixTeaManager getInstance() {
            if (MatrixTeaManager.access$getInstance$cp() == null) goto L7;
            MatrixTeaManager r1 = MatrixTeaManager.access$getInstance$cp();
            Intrinsics.checkNotNull(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }
    }

    /* JADX INFO: compiled from: MatrixTeaManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager$PendingEvent;", "", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getEventName", "()Ljava/lang/String;", "getJsonObject", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PendingEvent {
        private final String eventName;
        private final JSONObject jsonObject;

        public static /* synthetic */ PendingEvent copy$default(PendingEvent r0, String r1, JSONObject r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.eventName;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.jsonObject;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.eventName;
        }

        public final JSONObject component2() {
            return this.jsonObject;
        }

        public final PendingEvent copy(String r1, JSONObject r2) {
            Intrinsics.checkNotNullParameter(r1, "eventName");
            Intrinsics.checkNotNullParameter(r2, "jsonObject");
            return new PendingEvent(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PendingEvent) == true) goto L8;
            return false;
        L8:
            PendingEvent r6 = (PendingEvent) r5;
            if (Intrinsics.areEqual(this.eventName, r6.eventName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.jsonObject, r6.jsonObject) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.eventName.hashCode() * 31) + this.jsonObject.hashCode();
        }

        public String toString() {
            return "PendingEvent(eventName=" + this.eventName + ", jsonObject=" + this.jsonObject + ')';
        }

        public PendingEvent(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "jsonObject");
            this.eventName = r2;
            this.jsonObject = r3;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final JSONObject getJsonObject() {
            return this.jsonObject;
        }
    }

    public static /* synthetic */ void $r8$lambda$So8abkGVc91xOzRC9Ai8jF5conw(MatrixTeaManager r0, String r1, JSONObject r2, JSONObject r3) {
        m364onEventInternal$lambda8(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Yby3-m2jtIiB7jOf-XGQ2hf6TpA, reason: not valid java name */
    public static /* synthetic */ void m363$r8$lambda$Yby3m2jtIiB7jOfXGQ2hf6TpA(MatrixTeaManager r0) {
        m365rebindService$lambda1(r0);
    }

    public /* synthetic */ MatrixTeaManager(Context r1, MatrixTeaConfig r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$retryRunnable$1] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$deviceInfoCallback$1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$connection$1] */
    private MatrixTeaManager(Context r1, MatrixTeaConfig r2) {
        this.context = r1;
        this.config = r2;
        this.listeners = new CopyOnWriteArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        this.pendingEvents = new CopyOnWriteArrayList();
        this.retryRunnable = new MatrixTeaManager$retryRunnable$1(this);
        HandlerThread r3 = new HandlerThread("MatrixTeaBackgroundThread");
        r3.start();
        this.backgroundHandler = new Handler(r3.getLooper());
        this.deviceInfoCallback = new MatrixTeaManager$deviceInfoCallback$1(this);
        this.connection = new MatrixTeaManager$connection$1(this);
    }

    public static final /* synthetic */ MatrixTeaManager$deviceInfoCallback$1 access$getDeviceInfoCallback$p(MatrixTeaManager r0) {
        return r0.deviceInfoCallback;
    }

    public static final /* synthetic */ Handler access$getHandler$p(MatrixTeaManager r0) {
        return r0.handler;
    }

    public static final /* synthetic */ MatrixTeaManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListeners$p(MatrixTeaManager r0) {
        return r0.listeners;
    }

    public static final /* synthetic */ IDataService access$getService$p(MatrixTeaManager r0) {
        return r0.service;
    }

    public static final /* synthetic */ boolean access$isBound$p(MatrixTeaManager r0) {
        return r0.isBound;
    }

    public static final /* synthetic */ AtomicBoolean access$isInited$cp() {
        return isInited;
    }

    public static final /* synthetic */ void access$processPendingEvents(MatrixTeaManager r0) {
        r0.processPendingEvents();
    }

    public static final /* synthetic */ void access$setBound$p(MatrixTeaManager r0, boolean r1) {
        r0.isBound = r1;
    }

    public static final /* synthetic */ void access$setDid$cp(String r0) {
        did = r0;
    }

    public static final /* synthetic */ void access$setInstance$cp(MatrixTeaManager r0) {
        instance = r0;
    }

    public static final /* synthetic */ void access$setMyInstallId$cp(String r0) {
        myInstallId = r0;
    }

    public static final /* synthetic */ void access$setService$p(MatrixTeaManager r0, IDataService r1) {
        r0.service = r1;
    }

    static {
        Companion = new Companion(null);
        isInited = new AtomicBoolean(false);
    }

    private final void processPendingEvents() {
        if (this.pendingEvents.isEmpty() == false) goto L6;
        MLog.i$default(TAG, "没有暂存的事件需要处理", null, 4, null);
        return;
    L6:
        MLog.i$default(TAG, "开始处理 " + this.pendingEvents.size() + " 个暂存事件", null, 4, null);
        CopyOnWriteArrayList<PendingEvent> r0 = this.pendingEvents;
        ArrayList r4 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L20;
        Object r5 = r1.next();
        PendingEvent r6 = (PendingEvent) r5;
        boolean r7 = true;
        JSONObject r8 = new JSONObject(r6.getJsonObject().toString());     // Catch: Exception -> L16
        r8.put("app_package_name", this.config.getPkgName());     // Catch: Exception -> L16
        r8.put("app_version_code", this.config.getVersionCode());     // Catch: Exception -> L16
        r8.put("app_version_name", this.config.getVersionName());     // Catch: Exception -> L16
        if (this.config.isBoe() == false) goto L13;
        int r10 = 1;
    L14:
        r8.put("app_is_boe", r10);     // Catch: Exception -> L16
        onEventInternal(r6.getEventName(), r8);     // Catch: Exception -> L16
        MLog.i$default(TAG, "成功发送暂存事件: " + r6.getEventName(), null, 4, null);     // Catch: Exception -> L16
        r7 = false;
    L18:
        if (r7 == false) goto L8;
        r4.add(r5);
        goto L8
    L13:
        r10 = 0;
    L16:
        e = move-exception;
        MLog.e(TAG, "发送暂存事件 " + r6.getEventName() + " 失败", e);
        goto L18
    L20:
        this.pendingEvents.clear();
        this.pendingEvents.addAll(r4);
    }

    public final void rebindService() {
        this.isBound = false;     // Catch: Exception -> L5
        this.service = null;     // Catch: Exception -> L5
        this.handler.postDelayed(new MatrixTeaManager$$ExternalSyntheticLambda1(this), WsConstants.EXIT_DELAY_TIME);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "rebindService error", e);
    }

    /* JADX INFO: renamed from: rebindService$lambda-1, reason: not valid java name */
    private static final void m365rebindService$lambda1(MatrixTeaManager r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.bindService();
    }

    public final void bindService() {
        if (isInited.compareAndSet(false, true) == true) goto L6;
        MLog.i("tea has inited");
        return;
    L6:
        bindServiceInternal();
        this.handler.postDelayed(this.retryRunnable, 5000);
    }

    public final void bindServiceInternal() {
        if (this.isBound == false) goto L6;
        MLog.i$default(TAG, "bindServiceInternal: service is already bound", null, 4, null);
        return;
    L6:
        Intent r0 = new Intent();
        r0.setAction("com.obric.matrix.dataanalysis.service");
        r0.setPackage("com.obric.matrix");
        this.context.bindService(r0, this.connection, 1);
    }

    public final String getDeviceId() {
        String r0 = did;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        MLog.i$default(TAG, "getDeviceId 有值，立即回调 " + did, null, 4, null);
        return did;
    L14:
        if (this.isBound == true) goto L26;
        MLog.e$default(TAG, "getDeviceId error,Service not bounded", null, 4, null);
        return null;
    L26:
        IDataService r4 = this.service;     // Catch: Exception -> L21
        if (r4 == null) goto L18;
        String r5 = r4.getDeviceId();     // Catch: Exception -> L21
    L19:
        did = r5;     // Catch: Exception -> L21
        return r5;
    L18:
        r5 = null;
    L21:
        e = move-exception;
        MLog.e(TAG, "getDeviceId error", e);
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final String getInstallId() {
        String r0 = myInstallId;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        MLog.i$default(TAG, "getInstallId 有值，立即回调 " + myInstallId, null, 4, null);
        return myInstallId;
    L14:
        if (this.isBound == true) goto L26;
        MLog.e$default(TAG, "getInstallId error,Service not bounded", null, 4, null);
        return null;
    L26:
        IDataService r4 = this.service;     // Catch: Exception -> L21
        if (r4 == null) goto L18;
        String r5 = r4.getInstallId();     // Catch: Exception -> L21
    L19:
        myInstallId = r5;     // Catch: Exception -> L21
        return r5;
    L18:
        r5 = null;
    L21:
        e = move-exception;
        MLog.e(TAG, "getInstallId error", e);
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public final String getOAID() {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        MatrixTeaManager r4 = this;     // Catch: Throwable -> L18
        Bundle r6 = this.context.getContentResolver().call(Uri.parse("content://com.bytedance.securityserver.oaidprovider"), "get_oaid", null, null);     // Catch: Throwable -> L18
        if (r6 == null) goto L17;
        Intrinsics.checkNotNullExpressionValue(r6, "context.contentResolver.…r(\"provider return null\")");     // Catch: Throwable -> L18
        String r5 = r6.getString(Utils.KEY_OA_ID);     // Catch: Throwable -> L18
        String r7 = r5;     // Catch: Throwable -> L18
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L15;
        StringBuilder r9 = new StringBuilder("oaid not empty, return ");     // Catch: Throwable -> L18
        String r1 = r5.substring(0, 2);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Throwable -> L18
        StringBuilder r10 = r9.append(r1).append("****");     // Catch: Throwable -> L18
        String r0 = r5.substring(r5.length() - 2);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L18
        MLog.i(r10.append(r0).toString());     // Catch: Throwable -> L18
        Object r11 = Result.m803constructorimpl(r5);     // Catch: Throwable -> L18
    L20:
        Throwable r12 = Result.m806exceptionOrNullimpl(r11);
        if (r12 == null) goto L24;
        MLog.e(TAG, "getOAID error", r12);
    L24:
        if (Result.m809isFailureimpl(r11) == true) goto L28;
        r2 = r11;
    L28:
        return (String) r2;
    L15:
        throw new IllegalStateException(("get oaid failed, errorCode = " + r6.getString("errCode") + ", errorMsg = " + r6.getString("errMsg")).toString());     // Catch: Throwable -> L18
    L8:
        if (r7.length() == 0) goto L11;
        r8 = false;
        goto L12
    L17:
        throw new IllegalStateException("provider return null".toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public final String getUDID() {
        String r2 = mUDid;
        String r3 = r2;
        boolean r4 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        Object r11 = null;
        if (r5 == true) goto L38;
        StringBuilder r12 = new StringBuilder("getUDID 有值，立即回调 ");
        String r0 = r2.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String…ing(startIndex, endIndex)");
        StringBuilder r13 = r12.append(r0).append("****");
        String r1 = r2.substring(r2.length() - 2);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).substring(startIndex)");
        MLog.i$default(TAG, r13.append(r1).toString(), null, 4, null);
        return r2;
    L38:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L27
        MatrixTeaManager r7 = this;     // Catch: Throwable -> L27
        Bundle r14 = this.context.getContentResolver().call(Uri.parse("content://com.bytedance.securityserver.udidprovider"), "get_udid", null, null);     // Catch: Throwable -> L27
        if (r14 == null) goto L26;
        Intrinsics.checkNotNullExpressionValue(r14, "context.contentResolver.…r(\"provider return null\")");     // Catch: Throwable -> L27
        String r8 = r14.getString("udid");     // Catch: Throwable -> L27
        String r9 = r8;     // Catch: Throwable -> L27
        if (r9 != null) goto L18;
    L21:
        if (r4 == true) goto L24;
        mUDid = r8;     // Catch: Throwable -> L27
        StringBuilder r15 = new StringBuilder("udid not empty, return ");     // Catch: Throwable -> L27
        String r10 = r8.substring(0, 2);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Throwable -> L27
        StringBuilder r16 = r15.append(r10).append("****");     // Catch: Throwable -> L27
        String r17 = r8.substring(r8.length() - 2);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L27
        MLog.i(r16.append(r17).toString());     // Catch: Throwable -> L27
        Object r18 = Result.m803constructorimpl(r8);     // Catch: Throwable -> L27
    L29:
        Throwable r19 = Result.m806exceptionOrNullimpl(r18);
        if (r19 == null) goto L33;
        MLog.e(TAG, "getUDID error", r19);
    L33:
        if (Result.m809isFailureimpl(r18) == true) goto L37;
        r11 = r18;
    L37:
        return (String) r11;
    L24:
        throw new IllegalStateException(("get udid failed, errorCode = " + r14.getString("errCode") + ", errorMsg = " + r14.getString("errMsg")).toString());     // Catch: Throwable -> L27
    L18:
        if (r9.length() == 0) goto L21;
        r4 = false;
        goto L21
    L26:
        throw new IllegalStateException("provider return null".toString());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L29
    L5:
        if (r3.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final void onEvent(String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "jsonObject");
        String r2 = r8.toString();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r2, "jsonObject.toString()");     // Catch: Throwable -> L23
        byte[] r3 = r2.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L23
        int r4 = r3.length;     // Catch: Throwable -> L23
        if (r4 <= 204800) goto L9;
        MLog.e$default(TAG, "事件 " + r7 + " 数据大小 " + r4 + " 字节超过200KB限制，已丢弃", null, 4, null);
        return;
    L9:
        if (this.isBound == false) goto L28;
        r8.put("app_package_name", this.config.getPkgName());     // Catch: Exception -> L16
        r8.put("app_version_code", this.config.getVersionCode());     // Catch: Exception -> L16
        r8.put("app_version_name", this.config.getVersionName());     // Catch: Exception -> L16
        if (this.config.isBoe() == false) goto L13;
        int r5 = 1;
    L14:
        r8.put("app_is_boe", r5);     // Catch: Exception -> L16
        onEventInternal(r7, r8);     // Catch: Exception -> L16
        return;
    L13:
        r5 = 0;
    L16:
        e = move-exception;
        MLog.e(TAG, "onEvent error", e);
        return;
    L28:
        this.pendingEvents.add(new PendingEvent(r7, new JSONObject(r8.toString())));     // Catch: Exception -> L20
        MLog.i$default(TAG, "服务未绑定，暂存事件: " + r7 + " 成功，当前暂存数量: " + this.pendingEvents.size(), null, 4, null);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        MLog.e(TAG, "服务未绑定，暂存事件 " + r7 + " 失败", e);
        return;
    L23:
        th = move-exception;
        MLog.e(TAG, "计算事件大小失败，已丢弃事件 " + r7, th);
    }

    private final void onEventInternal(final String r4, final JSONObject r5) {
        final JSONObject r0 = copyJson(r5);
        this.backgroundHandler.post(new MatrixTeaManager$$ExternalSyntheticLambda0(this, r4, r0, r5));
    }

    /* JADX INFO: renamed from: onEventInternal$lambda-8, reason: not valid java name */
    private static final void m364onEventInternal$lambda8(MatrixTeaManager r1, String r2, JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$eventName");
        Intrinsics.checkNotNullParameter(r3, "$copyJson");
        Intrinsics.checkNotNullParameter(r4, "$jsonObject");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        IDataService r5 = r1.service;     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r5.onEvent(r2, r3.toString());     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.m803constructorimpl(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.m806exceptionOrNullimpl(r7);
        if (r8 == null) goto L17;
        r1.pendingEvents.add(new PendingEvent(r2, r4));
        MLog.e(TAG, "onEvent error", r8);
        return;
    L17:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final JSONObject copyJson(JSONObject r4) {
        LinkedList r3 = new LinkedList();
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L22;
        String r1 = r0.next();
        Intrinsics.checkNotNullExpressionValue(r1, "keysIterable.next()");
        r3.add(r1);
        goto L4
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object[] r5 = r3.toArray(new String[0]);     // Catch: Throwable -> L11
        if (r5 == null) goto L10;
        Object r6 = Result.m803constructorimpl(new JSONObject(r4, (String[]) r5));     // Catch: Throwable -> L11
    L13:
        Throwable r7 = Result.m806exceptionOrNullimpl(r6);
        if (r7 == null) goto L16;
        MLog.e(TAG, "copyJson error", r7);
    L16:
        Object r8 = r4;
        if (Result.m809isFailureimpl(r6) == true) goto L21;
        r8 = r6;
    L21:
        return (JSONObject) r8;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static /* synthetic */ void onApmFpsEvent$default(MatrixTeaManager r0, String r1, float r2, JSONObject r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.onApmFpsEvent(r1, r2, r3);
    }

    public final void onApmFpsEvent(String r2, float r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        if (r4 != null) goto L5;
        r4 = new JSONObject();
    L5:
        r4.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r2);
        r4.put("fps", Float.valueOf(r3));
        onEvent(EVENT_APM_FPS, r4);
    }

    public final void onApmColdLaunchUserCompleteEvent(long r3, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "extraInfo");
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        Iterator<String> r4 = r5.keys();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r6 = r4.next();
        r0.put(r6, r5.get(r6));
        goto L4
    L6:
        onEvent(EVENT_APM_COLD_USER_COMPLETE, r0);
    }

    public final void onApmColdLaunchFirstFrameEvent(long r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_COLD_LAUNCH_FIRST_FRAME, r0);
    }

    public final void onApmColdLaunchFirstFrameEventTail(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL, r0);
    }

    public final void onApmHotLaunchEvent(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_HOT_LAUNCH, r0);
    }

    public final void onApmHotLaunchEventTail(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_HOT_LAUNCH_TAIL, r0);
    }

    public final void onApmMemoryEvent(int r3, boolean r4) {
        JSONObject r0 = new JSONObject();
        r0.put("memory_size", r3);
        r0.put("type", !r4 ? 1 : 0);
        onEvent(EVENT_APM_MEMORY, r0);
    }

    public static /* synthetic */ void onPageShowEvent$default(MatrixTeaManager r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.onPageShowEvent(r1, r2, r3);
    }

    public final void onPageShowEvent(String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "pageName");
        JSONObject r0 = new JSONObject();
        r0.put("duration", r5);
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r3);
        r0.put("prev_page_name", r4);
        onEvent(EVENT_PAGE_SHOW, r0);
    }

    public final void onPageShowEvent(String r3, long r4, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r3, "pageName");
        Intrinsics.checkNotNullParameter(r6, "extra");
        JSONObject r0 = new JSONObject();
        r0.put("duration", r4);
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r3);
        Iterator<String> r5 = r6.keys();
        Intrinsics.checkNotNullExpressionValue(r5, "extra.keys()");
    L4:
        if (r5.hasNext() == false) goto L6;
        String r7 = r5.next();
        r0.put(r7, r6.get(r7));
        goto L4
    L6:
        onEvent(EVENT_PAGE_SHOW, r0);
    }

    public static /* synthetic */ void onButtonClickEvent$default(MatrixTeaManager r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.onButtonClickEvent(r1, r2);
    }

    public final void onButtonClickEvent(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "componentName");
        JSONObject r0 = new JSONObject();
        r0.put("click_for", r3);
        r0.put("scene", r4);
        onEvent(EVENT_BUTTON_CLICK, r0);
    }

    public final void addDeviceInfoListener(DeviceInfoListener r7) {
        Intrinsics.checkNotNullParameter(r7, "listener");
        MLog.i$default(TAG, "addDeviceInfoListener " + r7, null, 4, null);
        if (this.listeners.contains(r7) == true) goto L5;
        this.listeners.add(r7);
        MLog.i$default(TAG, "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.listeners.size(), null, 4, null);
    L5:
        String r6 = did;
        boolean r0 = false;
        if (r6 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        MLog.i$default(TAG, "注册deviceInfoListener时did有值，立即回调 " + did, null, 4, null);
        String r9 = did;
        Intrinsics.checkNotNull(r9);
        r7.onDeviceIdLoaded(r9);
    L14:
        String r10 = myInstallId;
        if (r10 != null) goto L17;
    L18:
        r0 = true;
    L19:
        if (r0 == true) goto L22;
        MLog.i$default(TAG, "注册deviceInfoListener时installId有值，立即回调 " + myInstallId, null, 4, null);
        String r11 = myInstallId;
        Intrinsics.checkNotNull(r11);
        r7.onInstallIdLoaded(r11);
        return;
    L22:
        return;
    L17:
        if (r10.length() != 0) goto L19;
    L8:
        if (r6.length() == 0) goto L11;
        r8 = false;
        goto L12
    }

    public final void removeDeviceInfoListener(DeviceInfoListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.listeners.remove(r4);     // Catch: Exception -> L5
        MLog.i$default(TAG, "removeDeviceInfoListener " + r4 + ", size = " + this.listeners.size(), null, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "removeDeviceInfoListener error", e);
    }
}
