package com.stepos.ame.sdk;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import Y8.t;
import android.content.Context;
import android.util.Log;
import com.stepos.ame.AMEngineNative;
import com.stepos.ame.sdk.AMEngineResult;
import com.stepos.deepbinder.core.constant.Constants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineClient;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/ame/sdk/AMEngineResult;", "Lcom/stepos/ame/sdk/AMEngineSession;", Constants.METHOD_CONNECT, "(Le9/c;)Ljava/lang/Object;", "LY8/t;", "disconnect", "()V", "Landroid/content/Context;", "connectionLock", "Ljava/lang/Object;", "_session", "Lcom/stepos/ame/sdk/AMEngineSession;", "getSession", "()Lcom/stepos/ame/sdk/AMEngineSession;", "session", "", "isConnected", "()Z", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AMEngineClient {
    public static final int LOCAL_ENGINE_PROTOCOL_VERSION = 5;
    private static final String TAG = "AMEngineClient";
    private volatile AMEngineSession _session;
    private final Object connectionLock;
    private final Context context;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, AMEngineClient> instances = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineClient$Companion;", "", "<init>", "()V", "TAG", "", "LOCAL_ENGINE_PROTOCOL_VERSION", "", "instances", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ame/sdk/AMEngineClient;", "getInstance", "context", "Landroid/content/Context;", "servicePackage", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AMEngineClient getInstance(Context context) {
            p.i(context, "context");
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            ConcurrentHashMap concurrentHashMap = AMEngineClient.instances;
            Object aMEngineClient = concurrentHashMap.get(packageName);
            if (aMEngineClient == null) {
                p.f(applicationContext);
                aMEngineClient = new AMEngineClient(applicationContext, null);
                Object objPutIfAbsent = concurrentHashMap.putIfAbsent(packageName, aMEngineClient);
                if (objPutIfAbsent != null) {
                    aMEngineClient = objPutIfAbsent;
                }
            }
            p.h(aMEngineClient, "getOrPut(...)");
            return (AMEngineClient) aMEngineClient;
        }

        private Companion() {
        }

        public final AMEngineClient getInstance(Context context, String servicePackage) {
            p.i(context, "context");
            p.i(servicePackage, "servicePackage");
            return getInstance(context);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "Lcom/stepos/ame/sdk/AMEngineSession;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineClient$connect$4", f = "AMEngineClient.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineClient$connect$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super AMEngineResult<? extends AMEngineSession>>, Object> {
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineClient.this.new AnonymousClass4(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<AMEngineSession>> interfaceC4014c) {
            return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            try {
                AMEngineNative.Companion.c(AMEngineNative.INSTANCE, AMEngineClient.this.context, null, 2, null);
                Context applicationContext = AMEngineClient.this.context.getApplicationContext();
                p.h(applicationContext, "getApplicationContext(...)");
                AMEngineSession aMEngineSession = new AMEngineSession(applicationContext);
                Object obj2 = AMEngineClient.this.connectionLock;
                AMEngineClient aMEngineClient = AMEngineClient.this;
                synchronized (obj2) {
                    aMEngineClient._session = aMEngineSession;
                    t tVar = t.f7040a;
                }
                return AMEngineResult.INSTANCE.ok(aMEngineSession);
            } catch (Exception e10) {
                Log.e(AMEngineClient.TAG, "connect / initialize failed", e10);
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                AMEError aMEError = AMEError.SERVICE_INTERNAL_ERROR;
                String message = e10.getMessage();
                if (message == null) {
                    message = "引擎初始化失败";
                }
                return companion.failure(aMEError, message, e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends AMEngineSession>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<AMEngineSession>>) interfaceC4014c);
        }
    }

    public /* synthetic */ AMEngineClient(Context context, i iVar) {
        this(context);
    }

    public static final AMEngineClient getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    public final Object connect(InterfaceC4014c<? super AMEngineResult<AMEngineSession>> interfaceC4014c) {
        AMEngineSession aMEngineSession = this._session;
        if (aMEngineSession != null) {
            if (!aMEngineSession.getActive()) {
                aMEngineSession = null;
            }
            if (aMEngineSession != null) {
                return AMEngineResult.INSTANCE.ok(aMEngineSession);
            }
        }
        return C1056g.j(Y.b(), new AnonymousClass4(null), interfaceC4014c);
    }

    public final void disconnect() {
        synchronized (this.connectionLock) {
            try {
                AMEngineSession aMEngineSession = this._session;
                if (aMEngineSession != null) {
                    aMEngineSession.invalidate$vector_release();
                }
                this._session = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i(TAG, "disconnect: session cleared (embedded SDK)");
    }

    /* renamed from: getSession, reason: from getter */
    public final AMEngineSession get_session() {
        return this._session;
    }

    public final boolean isConnected() {
        AMEngineSession aMEngineSession = this._session;
        return aMEngineSession != null && aMEngineSession.getActive();
    }

    private AMEngineClient(Context context) {
        this.context = context;
        this.connectionLock = new Object();
    }

    public static final AMEngineClient getInstance(Context context, String str) {
        return INSTANCE.getInstance(context, str);
    }
}
