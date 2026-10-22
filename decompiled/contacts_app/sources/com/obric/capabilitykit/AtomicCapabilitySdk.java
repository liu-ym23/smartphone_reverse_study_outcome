package com.obric.capabilitykit;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
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
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002klB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001c\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0002J+\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J \u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0007J\u0015\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010.J\r\u0010/\u001a\u00020\u0011H\u0000¢\u0006\u0002\b0J!\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u000205H\u0087@ø\u0001\u0000¢\u0006\u0002\u00106JE\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u0002052\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110=\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010>JE\u0010?\u001a\u00020\u00042\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u0002052\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110=\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010@J$\u0010A\u001a\u00020\u00112\u000e\u0010B\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020GJ9\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010OJ%\u0010P\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u00103\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RH\u0000¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\u00112\u0006\u0010L\u001a\u00020UH\u0000¢\u0006\u0002\bVJ!\u0010W\u001a\u00020\u00112\n\u0010L\u001a\u0006\u0012\u0002\b\u00030X2\u0006\u0010Y\u001a\u00020UH\u0000¢\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]H\u0007J\u0015\u0010^\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\nH\u0000¢\u0006\u0002\b`J\u001e\u0010a\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u001d\u0010b\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0006\u00103\u001a\u00020\bH\u0000¢\u0006\u0002\bcJ\u0018\u0010d\u001a\u00020\u00112\u000e\u0010B\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030CH\u0007J\u000e\u0010e\u001a\u00020\u00112\u0006\u0010F\u001a\u00020GJ\"\u0010f\u001a\u00020\u00112\n\u0010L\u001a\u0006\u0012\u0002\b\u00030X2\u0006\u0010g\u001a\u00020 2\u0006\u0010h\u001a\u00020\nJ:\u0010f\u001a\u00020\u00112\n\u0010L\u001a\u0006\u0012\u0002\b\u00030X2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020\n2\u0016\b\u0002\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010jR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk;", "", "()V", "ERROR_INVALID_ACTION_NAME", "", "ERROR_NO_ERROR", "MAX_PENDING_FUN_CALL", "TAG", "", "mPendingCallsExecuted", "", "mPendingCals", "", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "mSendResultApi", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "addPendingCall", "", "call", "callOrAddPendingCall", "func", "Lkotlin/Function1;", "checkInit", "Landroid/app/Application;", "execPendingCalls", "finishFloatingActivity", "questionId", "", "getApi", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", "context", "Lcom/obric/capabilitykit/common/DispatchContext;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "params", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "(Lcom/obric/capabilitykit/common/DispatchContext;Landroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFloatingPendingIntentNonBlock", "hideIntentResultCard", "init", "config", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "isCardViewVisible", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onApiInitComplete", "onApiInitComplete$capabilitykit_release", "openFileDescriptorPrivileged", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "packageName", "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStream", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "onGranted", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamPrivileged", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerIntent", "function", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "serviceName", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "requestStateChanged", "id", "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "result", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", "timeout", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUriFileAccess", "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "requestUriFileAccess$capabilitykit_release", "sendActionExecuteResult", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendActionExecuteResult$capabilitykit_release", "sendIntentExecutionResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "sendIntentExecutionResult$capabilitykit_release", "setLogger", "logger", "Lcom/obric/capabilitykit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$capabilitykit_release", "startFloatingActivity", "stopUriFileAccess", "stopUriFileAccess$capabilitykit_release", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "dispatchContext", "isStatusChange", "ext", "", "ApiCall", "InitConfig", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AtomicCapabilitySdk {
    public static final int ERROR_INVALID_ACTION_NAME = -1;
    public static final int ERROR_NO_ERROR = 0;
    public static final AtomicCapabilitySdk INSTANCE = null;
    private static final int MAX_PENDING_FUN_CALL = 1024;
    public static final String TAG = "AtomicCapabilitySdk";
    private static boolean mPendingCallsExecuted;
    private static final List<a> mPendingCals = null;
    private static com.obric.capabilitykit.a mSendResultApi;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "", "app", "Landroid/app/Application;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "entityProcessName", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "(Landroid/app/Application;Lcom/obric/capabilitykit/EntitySupplier;Ljava/lang/String;Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;)V", "getApp", "()Landroid/app/Application;", "getEntityProcessName", "()Ljava/lang/String;", "getEntitySupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "()Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InitConfig {
        private final Application app;
        private final String entityProcessName;
        private final EntitySupplier entitySupplier;
        private final EntitySyncDataSupplier entitySyncDataSupplier;

        public InitConfig(Application r2, EntitySupplier r3, String r4, EntitySyncDataSupplier r5) {
            Intrinsics.checkNotNullParameter(r2, "app");
            this.app = r2;
            this.entitySupplier = r3;
            this.entityProcessName = r4;
            this.entitySyncDataSupplier = r5;
        }

        public /* synthetic */ InitConfig(Application r2, EntitySupplier r3, String r4, EntitySyncDataSupplier r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = null;
        L11:
            this(r2, r3, r4, r5);
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r0, Application r1, EntitySupplier r2, String r3, EntitySyncDataSupplier r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.app;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.entitySupplier;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.entityProcessName;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.entitySyncDataSupplier;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final Application component1() {
            return this.app;
        }

        public final EntitySupplier component2() {
            return this.entitySupplier;
        }

        public final String component3() {
            return this.entityProcessName;
        }

        public final EntitySyncDataSupplier component4() {
            return this.entitySyncDataSupplier;
        }

        public final InitConfig copy(Application r1, EntitySupplier r2, String r3, EntitySyncDataSupplier r4) {
            Intrinsics.checkNotNullParameter(r1, "app");
            return new InitConfig(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof InitConfig) == true) goto L8;
            return false;
        L8:
            InitConfig r6 = (InitConfig) r5;
            if (Intrinsics.areEqual(this.app, r6.app) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entitySupplier, r6.entitySupplier) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.entityProcessName, r6.entityProcessName) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.entitySyncDataSupplier, r6.entitySyncDataSupplier) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final Application getApp() {
            return this.app;
        }

        public final String getEntityProcessName() {
            return this.entityProcessName;
        }

        public final EntitySupplier getEntitySupplier() {
            return this.entitySupplier;
        }

        public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
            return this.entitySyncDataSupplier;
        }

        public int hashCode() {
            int r0 = this.app.hashCode() * 31;
            EntitySupplier r1 = this.entitySupplier;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.entityProcessName;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            EntitySyncDataSupplier r8 = this.entitySyncDataSupplier;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "InitConfig(app=" + this.app + ", entitySupplier=" + this.entitySupplier + ", entityProcessName=" + this.entityProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "", "call", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/AtomicCapabilitySdk$callOrAddPendingCall$1", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "call", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements a {
        public final /* synthetic */ Function1<com.obric.capabilitykit.a, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super com.obric.capabilitykit.a, Unit> r1) {
            this.a = r1;
        }

        @Override // com.obric.capabilitykit.AtomicCapabilitySdk.a
        public void a() {
            this.a.invoke(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ Continuation<PendingIntent> a;
        public final /* synthetic */ DispatchContext b;
        public final /* synthetic */ Intent c;
        public final /* synthetic */ FloatingIntentParams d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Continuation<? super PendingIntent> r1, DispatchContext r2, Intent r3, FloatingIntentParams r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.resumeWith(Result.m803constructorimpl(AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.b, this.c, this.d)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ long a;

        public e(long r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ Continuation<Boolean> a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Continuation<? super Boolean> r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            this.a.resumeWith(Result.m803constructorimpl(Boolean.valueOf(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a())));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ IntentFunction<?, ?> a;
        public final /* synthetic */ String b;

        public g(IntentFunction<?, ?> r1, String r2) {
            this.a = r1;
            this.b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            com.obric.capabilitykit.a r5 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r0 = this.a.getName();
            String r1 = this.a.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(r1, "function.javaClass.name");
            r5.a(r0, r1, this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ ErrorCodeCallback a;

        public h(ErrorCodeCallback r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ TaskStateInfo b;
        public final /* synthetic */ TaskStateChangeCallback c;
        public final /* synthetic */ Long d;

        public i(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a, this.b, this.c, this.d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ String b;
        public final /* synthetic */ IUriFileReceiver c;

        public j(Uri r1, String r2, IUriFileReceiver r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a, this.b, this.c);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ IMAppAction a;

        public k(IMAppAction r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ IntentResult<?> a;
        public final /* synthetic */ IMAppAction b;

        public l(IntentResult<?> r1, IMAppAction r2) {
            this.a = r1;
            this.b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a, this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ DispatchContext a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ FloatingIntentParams c;

        public m(DispatchContext r1, Intent r2, FloatingIntentParams r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            PendingIntent r3 = AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.a, this.b, this.c);     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
            if (r3 == null) goto L15;
            r3.send();     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
        L16:
            return;
        L15:
            return;
        L9:
            e = move-exception;
            Logger r5 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder("PendingIntent was canceled: ");
            String r6 = e.getMessage();
        L11:
            r5.e(AtomicCapabilitySdk.TAG, r1.append(r6).toString());
            return;
        L7:
            e = move-exception;
            r5 = Logger.INSTANCE;
            r1 = new StringBuilder("Error sending PendingIntent: ");
            r6 = e.getMessage();
            goto L11
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ String b;

        public n(Uri r1, String r2) {
            this.a = r1;
            this.b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a, this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ IntentFunction<?, ?> a;

        public o(IntentFunction<?, ?> r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            com.obric.capabilitykit.a r4 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r0 = this.a.getName();
            String r2 = this.a.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(r2, "function.javaClass.name");
            r4.a(r0, r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ ErrorCodeCallback a;

        public p(ErrorCodeCallback r1) {
            this.a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function1<com.obric.capabilitykit.a, Unit> {
        public final /* synthetic */ IntentResult<?> a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Map<String, String> d;

        public q(IntentResult<?> r1, long r2, boolean r4, Map<String, String> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r7) {
            Intrinsics.checkNotNullParameter(r7, "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.a, this.b, this.c, this.d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.obric.capabilitykit.a r1) {
            a(r1);
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new AtomicCapabilitySdk();
        mPendingCals = new ArrayList();
    }

    private AtomicCapabilitySdk() {
    }

    public static final /* synthetic */ com.obric.capabilitykit.a access$getApi(AtomicCapabilitySdk r0) {
        return r0.getApi();
    }

    private final void addPendingCall(a r5) {
        Logger r0 = Logger.INSTANCE;
        r0.i(TAG, "addPendingCall");
        List<a> r1 = mPendingCals;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L10;
        r0.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L19
        r5.a();     // Catch: Throwable -> L19
        monitor-exit(r1);
        return;
    L10:
        if (r1.size() <= 1024) goto L14;
        r0.w(TAG, "addPendingCall too may pending call, drop");     // Catch: Throwable -> L19
        monitor-exit(r1);
        return;
    L14:
        r1.add(r5);     // Catch: Throwable -> L19
        r0.i(TAG, "addPendingCall: queued, pendingSize=" + r1.size() + ", mPendingCallsExecuted=" + mPendingCallsExecuted);     // Catch: Throwable -> L19
        monitor-exit(r1);
    }

    private final void callOrAddPendingCall(Function1<? super com.obric.capabilitykit.a, Unit> r4) {
        com.obric.capabilitykit.a r0 = getApi();
        if (Intrinsics.areEqual(r0, com.obric.capabilitykit.f.a) == true) goto L5;
        r4.invoke(r0);
        return;
    L5:
        Logger.INSTANCE.i(TAG, "callOrAddPendingCall: api unavailable (Empty), enqueue pending call");
        addPendingCall(new b(r4));
    }

    private final Application checkInit() {
        return AppHost.Companion.getApplication();
    }

    private final void execPendingCalls() {
        Logger r0 = Logger.INSTANCE;
        r0.i(TAG, "execPendingCalls");
        List<a> r1 = mPendingCals;
        monitor-enter(r1);
        r0.i(TAG, "execPendingCalls: flush start, pendingSize=" + r1.size());     // Catch: Throwable -> L12
        Iterator<T> r5 = r1.iterator();     // Catch: Throwable -> L12
    L7:
        if (r5.hasNext() == false) goto L9;
        a r2 = (a) r5.next();     // Catch: Throwable -> L12
        Logger.INSTANCE.i(TAG, "exec foreach call");     // Catch: Throwable -> L12
        r2.a();     // Catch: Throwable -> L12
        goto L7
    L9:
        mPendingCals.clear();     // Catch: Throwable -> L12
        mPendingCallsExecuted = true;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final com.obric.capabilitykit.a getApi() {
        return com.obric.capabilitykit.c.a.c();
    }

    @JvmStatic
    public static final void init(InitConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Logger.INSTANCE.i(TAG, "AtomicCapabilitySdk init");
        AppHost.Companion.setAppHost(new com.obric.capabilitykit.l(r4.getApp()));
        EntityProvider.INSTANCE.init$capabilitykit_release(new EntityInitParam(r4.getEntitySupplier(), r4.getEntityProcessName(), r4.getEntitySyncDataSupplier()));
    }

    @JvmStatic
    public static final void registerIntent(IntentFunction<?, ?> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        r0.checkInit();
        r0.callOrAddPendingCall(new g(r2, r3));
    }

    public static /* synthetic */ void registerIntent$default(IntentFunction r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        registerIntent(r0, r1);
    }

    public static /* synthetic */ Object requestStateChanged$default(AtomicCapabilitySdk r7, String r8, TaskStateInfo r9, TaskStateChangeCallback r10, Long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        TaskStateChangeCallback r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        Long r5 = null;
    L11:
        return r7.requestStateChanged(r8, r9, r4, r5, r12);
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    @JvmStatic
    public static final void setLogger(ILogger r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Logger r0 = Logger.INSTANCE;
        r0.setLogger(r2);
        r0.i(TAG, "AtomicCapabilitySdk setLogger");
    }

    @JvmStatic
    public static final void unregisterIntent(IntentFunction<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        r0.checkInit();
        r0.callOrAddPendingCall(new o(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateIntentResult$default(AtomicCapabilitySdk r6, IntentResult r7, long r8, boolean r10, Map r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r6.updateIntentResult(r7, r8, r10, r11);
    }

    public final void finishFloatingActivity(long r2) {
        callOrAddPendingCall(new c(r2));
    }

    public final Object getFloatingPendingIntent(DispatchContext r3, Intent r4, FloatingIntentParams r5, Continuation<? super PendingIntent> r6) {
        SafeContinuation r2 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        INSTANCE.callOrAddPendingCall(new d(r2, r3, r4, r5));
        Object r7 = r2.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final PendingIntent getFloatingPendingIntentNonBlock(DispatchContext r2, Intent r3, FloatingIntentParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r4, "params");
        Long r1 = r2.getQuestionId();
        if (r1 == null) goto L5;
        long r5 = r1.longValue();
        return INSTANCE.getApi().a(r5, r3, r4);
    L5:
        return null;
    }

    public final void hideIntentResultCard(long r2) {
        callOrAddPendingCall(new e(r2));
    }

    public final Boolean isCardViewVisible(long r1) {
        return getApi().c(r1);
    }

    public final Object isKeyguardReallyLocked(Continuation<? super Boolean> r3) {
        SafeContinuation r2 = new SafeContinuation(IntrinsicsKt.intercepted(r3));
        INSTANCE.callOrAddPendingCall(new f(r2));
        Object r4 = r2.getOrThrow();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L5:
        return r4;
    }

    public final void onApiInitComplete$capabilitykit_release() {
        execPendingCalls();
    }

    @v
    public final Object openFileDescriptorPrivileged(String r1, Uri r2, Continuation<? super UriFileAccessSession> r3) {
        return w.a.a(r1, r2, r3);
    }

    public final Object openInputStream(AppEntity r1, Uri r2, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super Integer> r4) {
        return w.a.a(r1, r2, r3, r4);
    }

    @v
    public final Object openInputStreamPrivileged(String r1, Uri r2, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super Integer> r4) {
        return w.a.a(r1, r2, r3, r4);
    }

    public final void registerResultCallback(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new h(r2));
    }

    public final Object requestStateChanged(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4, Continuation<? super Unit> r5) {
        callOrAddPendingCall(new i(r1, r2, r3, r4));
        return Unit.INSTANCE;
    }

    public final void requestUriFileAccess$capabilitykit_release(Uri r2, String r3, IUriFileReceiver r4) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "requester");
        callOrAddPendingCall(new j(r2, r3, r4));
    }

    public final void sendActionExecuteResult$capabilitykit_release(IMAppAction r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        callOrAddPendingCall(new k(r2));
    }

    public final void sendIntentExecutionResult$capabilitykit_release(IntentResult<?> r2, IMAppAction r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "oldResult");
        callOrAddPendingCall(new l(r2, r3));
    }

    public final void setPendingCallsExecuted$capabilitykit_release(boolean r1) {
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        mPendingCallsExecuted = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void startFloatingActivity(DispatchContext r2, Intent r3, FloatingIntentParams r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r4, "params");
        Long r1 = r2.getQuestionId();
        if (r1 == null) goto L6;
        r1.longValue();
        INSTANCE.callOrAddPendingCall(new m(r2, r3, r4));
        return;
    }

    public final void stopUriFileAccess$capabilitykit_release(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        callOrAddPendingCall(new n(r2, r3));
    }

    public final void unregisterResultCallback(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        callOrAddPendingCall(new p(r2));
    }

    public final void updateIntentResult(IntentResult<?> r8, long r9, boolean r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r8, "result");
        callOrAddPendingCall(new q(r8, r9, r11, r12));
    }

    public final void updateIntentResult(IntentResult<?> r9, DispatchContext r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r10, "dispatchContext");
        Long r0 = r10.getQuestionId();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        updateIntentResult(r9, r1, r11, r10.getExt());
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
