package com.obric.capabilitykit;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.ILogger;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002klB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001c\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0002J+\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J \u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0007J\u0015\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010.J\r\u0010/\u001a\u00020\u0011H\u0000¢\u0006\u0002\b0J!\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u000205H\u0087@ø\u0001\u0000¢\u0006\u0002\u00106JE\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u0002052\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110=\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010>JE\u0010?\u001a\u00020\u00042\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u0002052\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110=\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010@J$\u0010A\u001a\u00020\u00112\u000e\u0010B\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020GJ9\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010OJ%\u0010P\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u00103\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RH\u0000¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\u00112\u0006\u0010L\u001a\u00020UH\u0000¢\u0006\u0002\bVJ!\u0010W\u001a\u00020\u00112\n\u0010L\u001a\u0006\u0012\u0002\b\u00030X2\u0006\u0010Y\u001a\u00020UH\u0000¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]H\u0007J\u0015\u0010^\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\nH\u0000¢\u0006\u0002\b`J\u001e\u0010a\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u001d\u0010b\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u00103\u001a\u00020\bH\u0000¢\u0006\u0002\bcJ\u0018\u0010d\u001a\u00020\u00112\u000e\u0010B\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030CH\u0007J\u000e\u0010e\u001a\u00020\u00112\u0006\u0010F\u001a\u00020GJ\"\u0010f\u001a\u00020\u00112\n\u0010L\u001a\u0006\u0012\u0002\b\u00030X2\u0006\u0010g\u001a\u00020 2\u0006\u0010h\u001a\u00020\nJ:\u0010f\u001a\u00020\u00112\n\u0010L\u001a\u0006\u0012\u0002\b\u00030X2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020\n2\u0016\b\u0002\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010jR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk;", "", "()V", "ERROR_INVALID_ACTION_NAME", "", "ERROR_NO_ERROR", "MAX_PENDING_FUN_CALL", "TAG", "", "mPendingCallsExecuted", "", "mPendingCals", "", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "mSendResultApi", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "addPendingCall", "", "call", "callOrAddPendingCall", "func", "Lkotlin/Function1;", "checkInit", "Landroid/app/Application;", "execPendingCalls", "finishFloatingActivity", "questionId", "", "getApi", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", "context", "Lcom/obric/capabilitykit/common/DispatchContext;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "params", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "(Lcom/obric/capabilitykit/common/DispatchContext;Landroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFloatingPendingIntentNonBlock", "hideIntentResultCard", "init", "config", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "isCardViewVisible", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onApiInitComplete", "onApiInitComplete$capabilitykit_release", "openFileDescriptorPrivileged", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "packageName", "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStream", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onGranted", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamPrivileged", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerIntent", "function", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "serviceName", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "requestStateChanged", "id", "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "result", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", "timeout", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUriFileAccess", "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "requestUriFileAccess$capabilitykit_release", "sendActionExecuteResult", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendActionExecuteResult$capabilitykit_release", "sendIntentExecutionResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "sendIntentExecutionResult$capabilitykit_release", "setLogger", "logger", "Lcom/obric/capabilitykit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$capabilitykit_release", "startFloatingActivity", "stopUriFileAccess", "stopUriFileAccess$capabilitykit_release", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "dispatchContext", "isStatusChange", "ext", "", "ApiCall", "InitConfig", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AtomicCapabilitySdk {
    public static final int ERROR_INVALID_ACTION_NAME = -1;
    public static final int ERROR_NO_ERROR = 0;

    @NotNull
    public static final AtomicCapabilitySdk INSTANCE = null;
    private static final int MAX_PENDING_FUN_CALL = 1024;

    @NotNull
    public static final String TAG = "AtomicCapabilitySdk";
    private static boolean mPendingCallsExecuted;

    @NotNull
    private static final List<a> mPendingCals = null;

    @Nullable
    private static com.obric.capabilitykit.a mSendResultApi;

    @Keep
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "", ServerElements.APP, "Landroid/app/Application;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entityProcessName", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "(Landroid/app/Application;Lcom/obric/capabilitykit/EntitySupplier;Ljava/lang/String;Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;)V", "getApp", "()Landroid/app/Application;", "getEntityProcessName", "()Ljava/lang/String;", "getEntitySupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "()Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitConfig {

        @NotNull
        private final Application app;

        @Nullable
        private final String entityProcessName;

        @Nullable
        private final EntitySupplier entitySupplier;

        @Nullable
        private final EntitySyncDataSupplier entitySyncDataSupplier;

        public InitConfig(@NotNull Application r10, @Nullable EntitySupplier r11, @Nullable String r12, @Nullable EntitySyncDataSupplier r13) {
            kotlin.jvm.internal.q.g(r10, ServerElements.APP);
            this.app = r10;
            this.entitySupplier = r11;
            this.entityProcessName = r12;
            this.entitySyncDataSupplier = r13;
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r10, Application r11, EntitySupplier r12, String r13, EntitySyncDataSupplier r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r11 = r10.app;
        L6:
            if ((r15 & 2) == 0) goto L9;
            r12 = r10.entitySupplier;
        L9:
            if ((r15 & 4) == 0) goto L12;
            r13 = r10.entityProcessName;
        L12:
            if ((r15 & 8) == 0) goto L15;
            r14 = r10.entitySyncDataSupplier;
        L15:
            return r10.copy(r11, r12, r13, r14);
        }

        @NotNull
        public final Application component1() {
            return this.app;
        }

        @Nullable
        public final EntitySupplier component2() {
            return this.entitySupplier;
        }

        @Nullable
        public final String component3() {
            return this.entityProcessName;
        }

        @Nullable
        public final EntitySyncDataSupplier component4() {
            return this.entitySyncDataSupplier;
        }

        @NotNull
        public final InitConfig copy(@NotNull Application r10, @Nullable EntitySupplier r11, @Nullable String r12, @Nullable EntitySyncDataSupplier r13) {
            kotlin.jvm.internal.q.g(r10, ServerElements.APP);
            return new InitConfig(r10, r11, r12, r13);
        }

        public boolean equals(@Nullable Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof InitConfig) == true) goto L8;
            return false;
        L8:
            InitConfig r11 = (InitConfig) r10;
            if (kotlin.jvm.internal.q.b(this.app, r11.app) == true) goto L12;
            return false;
        L12:
            if (kotlin.jvm.internal.q.b(this.entitySupplier, r11.entitySupplier) == true) goto L15;
            return false;
        L15:
            if (kotlin.jvm.internal.q.b(this.entityProcessName, r11.entityProcessName) == true) goto L18;
            return false;
        L18:
            if (kotlin.jvm.internal.q.b(this.entitySyncDataSupplier, r11.entitySyncDataSupplier) == true) goto L20;
            return false;
        L20:
            return true;
        }

        @NotNull
        public final Application getApp() {
            return this.app;
        }

        @Nullable
        public final String getEntityProcessName() {
            return this.entityProcessName;
        }

        @Nullable
        public final EntitySupplier getEntitySupplier() {
            return this.entitySupplier;
        }

        @Nullable
        public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
            return this.entitySyncDataSupplier;
        }

        public int hashCode() {
            int r10 = this.app.hashCode() * 31;
            EntitySupplier r11 = this.entitySupplier;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.entityProcessName;
            if (r15 != null) goto L9;
            int r16 = 0;
        L10:
            int r17 = (r14 + r16) * 31;
            EntitySyncDataSupplier r18 = this.entitySyncDataSupplier;
            if (r18 == null) goto L15;
            r12 = r18.hashCode();
        L15:
            return r17 + r12;
        L9:
            r16 = r15.hashCode();
            goto L10
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        @NotNull
        public String toString() {
            return "InitConfig(app=" + this.app + ", entitySupplier=" + this.entitySupplier + ", entityProcessName=" + this.entityProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ')';
        }

        public /* synthetic */ InitConfig(Application r10, EntitySupplier r11, String r12, EntitySyncDataSupplier r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 2) == 0) goto L6;
            r11 = null;
        L6:
            if ((r14 & 4) == 0) goto L9;
            r12 = null;
        L9:
            if ((r14 & 8) == 0) goto L11;
            r13 = null;
        L11:
            this(r10, r11, r12, r13);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "", "call", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f11148a;

        public b(Function1 r10) {
            this.f11148a = r10;
        }

        @Override // com.obric.capabilitykit.AtomicCapabilitySdk.a
        public void a() {
            this.f11148a.invoke(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f11149a;

        public c(long r10) {
            this.f11149a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.f11149a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<PendingIntent> f11150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f11151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f11152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FloatingIntentParams f11153d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Continuation<? super PendingIntent> r10, DispatchContext r11, Intent r12, FloatingIntentParams r13) {
            this.f11150a = r10;
            this.f11151b = r11;
            this.f11152c = r12;
            this.f11153d = r13;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            this.f11150a.resumeWith(Result.m35constructorimpl(AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.f11151b, this.f11152c, this.f11153d)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f11154a;

        public e(long r10) {
            this.f11154a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11154a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation<Boolean> f11155a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Continuation<? super Boolean> r10) {
            this.f11155a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            this.f11155a.resumeWith(Result.m35constructorimpl(Boolean.valueOf(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a())));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<?, ?> f11156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11157b;

        public g(IntentFunction<?, ?> r10, String r11) {
            this.f11156a = r10;
            this.f11157b = r11;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            com.obric.capabilitykit.a r11 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r12 = this.f11156a.getName();
            String r13 = this.f11156a.getClass().getName();
            kotlin.jvm.internal.q.f(r13, "function.javaClass.name");
            r11.a(r12, r13, this.f11157b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorCodeCallback f11158a;

        public h(ErrorCodeCallback r10) {
            this.f11158a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.f11158a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskStateInfo f11160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskStateChangeCallback f11161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f11162d;

        public i(String r10, TaskStateInfo r11, TaskStateChangeCallback r12, Long r13) {
            this.f11159a = r10;
            this.f11160b = r11;
            this.f11161c = r12;
            this.f11162d = r13;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11159a, this.f11160b, this.f11161c, this.f11162d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f11163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IUriFileReceiver f11165c;

        public j(Uri r10, String r11, IUriFileReceiver r12) {
            this.f11163a = r10;
            this.f11164b = r11;
            this.f11165c = r12;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11163a, this.f11164b, this.f11165c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMAppAction f11166a;

        public k(IMAppAction r10) {
            this.f11166a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11166a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentResult<?> f11167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMAppAction f11168b;

        public l(IntentResult<?> r10, IMAppAction r11) {
            this.f11167a = r10;
            this.f11168b = r11;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11167a, this.f11168b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f11169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f11170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FloatingIntentParams f11171c;

        public m(DispatchContext r10, Intent r11, FloatingIntentParams r12) {
            this.f11169a = r10;
            this.f11170b = r11;
            this.f11171c = r12;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            PendingIntent r11 = AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.f11169a, this.f11170b, this.f11171c);     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
            if (r11 == null) goto L14;
            r11.send();     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
        L18:
            return;
        L14:
            return;
        L9:
            e = move-exception;
            Logger r12 = Logger.INSTANCE;
            StringBuilder r13 = new StringBuilder();
            r13.append("PendingIntent was canceled: ");
            String r14 = e.getMessage();
        L12:
            r13.append(r14);
            r12.e(AtomicCapabilitySdk.TAG, r13.toString());
            return;
        L7:
            e = move-exception;
            r12 = Logger.INSTANCE;
            r13 = new StringBuilder();
            r13.append("Error sending PendingIntent: ");
            r14 = e.getMessage();
            goto L12
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f11172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f11173b;

        public n(Uri r10, String r11) {
            this.f11172a = r10;
            this.f11173b = r11;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11172a, this.f11173b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<?, ?> f11174a;

        public o(IntentFunction<?, ?> r10) {
            this.f11174a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            com.obric.capabilitykit.a r11 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r12 = this.f11174a.getName();
            String r13 = this.f11174a.getClass().getName();
            kotlin.jvm.internal.q.f(r13, "function.javaClass.name");
            r11.a(r12, r13);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorCodeCallback f11175a;

        public p(ErrorCodeCallback r10) {
            this.f11175a = r10;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11175a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentResult<?> f11176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f11177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f11178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f11179d;

        public q(IntentResult<?> r10, long r11, boolean r12, Map<String, String> r13) {
            this.f11176a = r10;
            this.f11177b = r11;
            this.f11178c = r12;
            this.f11179d = r13;
            super(1);
        }

        public final void a(@NotNull com.obric.capabilitykit.a r10) {
            kotlin.jvm.internal.q.g(r10, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f11176a, this.f11177b, this.f11178c, this.f11179d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r10) {
            a(r10);
            return Unit.f21064a;
        }
    }

    static {
        INSTANCE = new AtomicCapabilitySdk();
        mPendingCals = new ArrayList();
    }

    private AtomicCapabilitySdk() {
    }

    public static final /* synthetic */ com.obric.capabilitykit.a access$getApi(AtomicCapabilitySdk r10) {
        return r10.getApi();
    }

    private final void addPendingCall(a r10) {
        Logger r11 = Logger.INSTANCE;
        r11.i(TAG, "addPendingCall");
        List<a> r12 = mPendingCals;
        monitor-enter(r12);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L12;
        r11.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L9
        r10.a();     // Catch: Throwable -> L9
        monitor-exit(r12);
        return;
    L12:
        if (r12.size() <= 1024) goto L16;
        r11.w(TAG, "addPendingCall too may pending call, drop");     // Catch: Throwable -> L9
        monitor-exit(r12);
        return;
    L16:
        r12.add(r10);     // Catch: Throwable -> L9
        r11.i(TAG, "addPendingCall: queued, pendingSize=" + r12.size() + ", mPendingCallsExecuted=" + mPendingCallsExecuted);     // Catch: Throwable -> L9
        monitor-exit(r12);
    }

    private final void callOrAddPendingCall(Function1<? super com.obric.capabilitykit.a, Unit> r10) {
        com.obric.capabilitykit.a r11 = getApi();
        if (kotlin.jvm.internal.q.b(r11, cb.p.f6085a) == true) goto L5;
        r10.invoke(r11);
        return;
    L5:
        Logger.INSTANCE.i(TAG, "callOrAddPendingCall: api unavailable (Empty), enqueue pending call");
        addPendingCall(new b(r10));
    }

    private final Application checkInit() {
        return AppHost.Companion.getApplication();
    }

    private final void execPendingCalls() {
        Logger r10 = Logger.INSTANCE;
        r10.i(TAG, "execPendingCalls");
        List<a> r11 = mPendingCals;
        monitor-enter(r11);
        r10.i(TAG, "execPendingCalls: flush start, pendingSize=" + r11.size());     // Catch: Throwable -> L9
        Iterator<T> r12 = r11.iterator();     // Catch: Throwable -> L9
    L7:
        if (r12.hasNext() == false) goto L11;
        a r13 = (a) r12.next();     // Catch: Throwable -> L9
        Logger.INSTANCE.i(TAG, "exec foreach call");     // Catch: Throwable -> L9
        r13.a();     // Catch: Throwable -> L9
        goto L7
    L11:
        mPendingCals.clear();     // Catch: Throwable -> L9
        mPendingCallsExecuted = true;     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final com.obric.capabilitykit.a getApi() {
        return com.obric.capabilitykit.c.f11239a.f();
    }

    @JvmStatic
    public static final void init(@NotNull InitConfig r10) {
        kotlin.jvm.internal.q.g(r10, "config");
        Logger.INSTANCE.i(TAG, "AtomicCapabilitySdk init");
        AppHost.Companion.setAppHost(new cb.s(r10.getApp()));
        EntityProvider.INSTANCE.init$capabilitykit_release(new EntityInitParam(r10.getEntitySupplier(), r10.getEntityProcessName(), r10.getEntitySyncDataSupplier()));
    }

    @JvmStatic
    public static final void registerIntent(@NotNull IntentFunction<?, ?> r10, @Nullable String r11) {
        kotlin.jvm.internal.q.g(r10, "function");
        AtomicCapabilitySdk r12 = INSTANCE;
        r12.checkInit();
        r12.callOrAddPendingCall(new g(r10, r11));
    }

    public static /* synthetic */ void registerIntent$default(IntentFunction r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        registerIntent(r10, r11);
    }

    public static /* synthetic */ Object requestStateChanged$default(AtomicCapabilitySdk r10, String r11, TaskStateInfo r12, TaskStateChangeCallback r13, Long r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        TaskStateChangeCallback r18 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        Long r19 = null;
    L11:
        return r10.requestStateChanged(r11, r12, r18, r19, r15);
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }

    @JvmStatic
    public static final void setLogger(@NotNull ILogger r10) {
        kotlin.jvm.internal.q.g(r10, "logger");
        Logger r11 = Logger.INSTANCE;
        r11.setLogger(r10);
        r11.i(TAG, "AtomicCapabilitySdk setLogger");
    }

    @JvmStatic
    public static final void unregisterIntent(@NotNull IntentFunction<?, ?> r10) {
        kotlin.jvm.internal.q.g(r10, "function");
        AtomicCapabilitySdk r11 = INSTANCE;
        r11.checkInit();
        r11.callOrAddPendingCall(new o(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateIntentResult$default(AtomicCapabilitySdk r10, IntentResult r11, long r12, boolean r13, Map r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r10.updateIntentResult(r11, r12, r13, r14);
    }

    public final void finishFloatingActivity(long r10) {
        callOrAddPendingCall(new c(r10));
    }

    @Nullable
    public final Object getFloatingPendingIntent(@NotNull DispatchContext r10, @NotNull Intent r11, @NotNull FloatingIntentParams r12, @NotNull Continuation<? super PendingIntent> r13) {
        kotlin.coroutines.d r14 = new kotlin.coroutines.d(IntrinsicsKt__IntrinsicsJvmKt.c(r13));
        INSTANCE.callOrAddPendingCall(new d(r14, r10, r11, r12));
        Object r15 = r14.a();
        if (r15 != kotlin.coroutines.intrinsics.a.d()) goto L5;
        tf.d.c(r13);
    L5:
        return r15;
    }

    @Nullable
    public final PendingIntent getFloatingPendingIntentNonBlock(@NotNull DispatchContext r10, @NotNull Intent r11, @NotNull FloatingIntentParams r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, MemorySourceLinkType.INTENT);
        kotlin.jvm.internal.q.g(r12, "params");
        Long r13 = r10.getQuestionId();
        if (r13 == null) goto L5;
        long r14 = r13.longValue();
        return INSTANCE.getApi().a(r14, r11, r12);
    L5:
        return null;
    }

    public final void hideIntentResultCard(long r10) {
        callOrAddPendingCall(new e(r10));
    }

    @Nullable
    public final Boolean isCardViewVisible(long r10) {
        return getApi().c(r10);
    }

    @Nullable
    public final Object isKeyguardReallyLocked(@NotNull Continuation<? super Boolean> r10) {
        kotlin.coroutines.d r11 = new kotlin.coroutines.d(IntrinsicsKt__IntrinsicsJvmKt.c(r10));
        INSTANCE.callOrAddPendingCall(new f(r11));
        Object r12 = r11.a();
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L5;
        tf.d.c(r10);
    L5:
        return r12;
    }

    public final void onApiInitComplete$capabilitykit_release() {
        execPendingCalls();
    }

    @v
    @Nullable
    public final Object openFileDescriptorPrivileged(@NotNull String r10, @NotNull Uri r11, @NotNull Continuation<? super UriFileAccessSession> r12) {
        return w.f11433a.h(r10, r11, r12);
    }

    @Nullable
    public final Object openInputStream(@NotNull AppEntity r10, @NotNull Uri r11, @NotNull Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r12, @NotNull Continuation<? super Integer> r13) {
        return w.f11433a.e(r10, r11, r12, r13);
    }

    @v
    @Nullable
    public final Object openInputStreamPrivileged(@NotNull String r10, @NotNull Uri r11, @NotNull Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r12, @NotNull Continuation<? super Integer> r13) {
        return w.f11433a.i(r10, r11, r12, r13);
    }

    public final void registerResultCallback(@NotNull ErrorCodeCallback r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        callOrAddPendingCall(new h(r10));
    }

    @Nullable
    public final Object requestStateChanged(@NotNull String r10, @NotNull TaskStateInfo r11, @Nullable TaskStateChangeCallback r12, @Nullable Long r13, @NotNull Continuation<? super Unit> r14) {
        callOrAddPendingCall(new i(r10, r11, r12, r13));
        return Unit.f21064a;
    }

    public final void requestUriFileAccess$capabilitykit_release(@NotNull Uri r10, @NotNull String r11, @NotNull IUriFileReceiver r12) {
        kotlin.jvm.internal.q.g(r10, "uri");
        kotlin.jvm.internal.q.g(r11, "packageName");
        kotlin.jvm.internal.q.g(r12, "requester");
        callOrAddPendingCall(new j(r10, r11, r12));
    }

    public final void sendActionExecuteResult$capabilitykit_release(@NotNull IMAppAction r10) {
        kotlin.jvm.internal.q.g(r10, "result");
        callOrAddPendingCall(new k(r10));
    }

    public final void sendIntentExecutionResult$capabilitykit_release(@NotNull IntentResult<?> r10, @NotNull IMAppAction r11) {
        kotlin.jvm.internal.q.g(r10, "result");
        kotlin.jvm.internal.q.g(r11, "oldResult");
        callOrAddPendingCall(new l(r10, r11));
    }

    public final void setPendingCallsExecuted$capabilitykit_release(boolean r10) {
        List<a> r11 = mPendingCals;
        monitor-enter(r11);
        mPendingCallsExecuted = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void startFloatingActivity(@NotNull DispatchContext r10, @NotNull Intent r11, @NotNull FloatingIntentParams r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, MemorySourceLinkType.INTENT);
        kotlin.jvm.internal.q.g(r12, "params");
        if (r10.getQuestionId() == null) goto L6;
        INSTANCE.callOrAddPendingCall(new m(r10, r11, r12));
        return;
    }

    public final void stopUriFileAccess$capabilitykit_release(@NotNull Uri r10, @NotNull String r11) {
        kotlin.jvm.internal.q.g(r10, "uri");
        kotlin.jvm.internal.q.g(r11, "packageName");
        callOrAddPendingCall(new n(r10, r11));
    }

    public final void unregisterResultCallback(@NotNull ErrorCodeCallback r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        callOrAddPendingCall(new p(r10));
    }

    public final void updateIntentResult(@NotNull IntentResult<?> r10, long r11, boolean r12, @Nullable Map<String, String> r13) {
        kotlin.jvm.internal.q.g(r10, "result");
        callOrAddPendingCall(new q(r10, r11, r12, r13));
    }

    public final void updateIntentResult(@NotNull IntentResult<?> r10, @NotNull DispatchContext r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "result");
        kotlin.jvm.internal.q.g(r11, "dispatchContext");
        Long r13 = r11.getQuestionId();
        if (r13 == null) goto L6;
        long r14 = r13.longValue();
    L5:
        long r15 = r14;
        updateIntentResult(r10, r15, r12, r11.getExt());
        return;
    L6:
        r14 = 0;
        goto L5
    }
}
