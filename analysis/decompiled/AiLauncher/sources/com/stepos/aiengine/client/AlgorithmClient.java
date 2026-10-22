package com.stepos.aiengine.client;

import O6.l;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.U;
import Ua.Y;
import Y8.t;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.AdapterFactory;
import com.stepos.aiengine.api.IAlgorithmProperties;
import com.stepos.aiengine.api.task.IAlgorithmListener;
import com.stepos.aiengine.args.LoadParamBundle;
import com.stepos.aiengine.client.ModelType;
import com.stepos.aiengine.flow.ModelFlowCallback;
import com.stepos.aiengine.model.IModelManager;
import com.stepos.aiengine.model.SdkConfirmHost;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.aiengine.update.OtaServiceClient;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.manager.AIEngineManager;
import com.stepos.core.ota.confirmui.ConfirmUiHost;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.net.exception.ApiErrorCode;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.LinkHeader;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.d;
import kotlinx.coroutines.g;
import p9.p;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0080\u0001*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0080\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u000bJ\u0015\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001a\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b!\u0010\"J!\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J)\u0010*\u001a\u00020\t2\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010'¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\t¢\u0006\u0004\b0\u0010\u000bJ\u0015\u00101\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b3\u00102J\u0015\u00104\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b4\u00102J\u0015\u00105\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b5\u00106J%\u0010;\u001a\u00028\u0001\"\b\b\u0001\u00108*\u0002072\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000109¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0005¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0005¢\u0006\u0004\b@\u0010?J!\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0005H\u0007¢\u0006\u0004\bA\u0010?J%\u0010C\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005¢\u0006\u0004\bC\u0010DJ\u001d\u0010F\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u0005¢\u0006\u0004\bF\u0010GJ'\u0010J\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010I¢\u0006\u0004\bJ\u0010KJ+\u0010P\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010NH\u0007¢\u0006\u0004\bP\u0010QJ+\u0010R\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010NH\u0007¢\u0006\u0004\bR\u0010QJ\u001d\u0010S\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bS\u0010TJ\u0015\u0010V\u001a\u00020U2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bV\u0010WR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010XR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010Y\u001a\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010|\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR*\u0010\u007f\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~¨\u0006\u0081\u0001"}, d2 = {"Lcom/stepos/aiengine/client/AlgorithmClient;", "", "I", "Lw9/d;", "interfaceClass", "", "algorithmId", "<init>", "(Lw9/d;Ljava/lang/String;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Landroid/content/Context;", "context", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "c", "(Landroid/content/Context;)Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "Landroid/os/Bundle;", "params", "loadAlgorithm", "(Landroid/content/Context;Landroid/os/Bundle;)Ljava/lang/Object;", "obtain", "()Lcom/stepos/aiengine/client/AlgorithmClient;", "releaseClient", "releaseAlgorithm", "(Landroid/content/Context;)V", "", "immediate", "(Landroid/content/Context;Z)V", "isClientAlive", "()Z", LinkHeader.Rel.PreLoad, "(Landroid/content/Context;Landroid/os/Bundle;)Z", "action", "Lcom/stepos/core/data/base/Content;", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "Lkotlin/Function2;", "", "listener", "setOnModelReleased", "(Lp9/p;)V", "", "delayMs", "scheduleDelayRelease", "(J)V", "cancelDelayRelease", "isSupported", "(Landroid/content/Context;)Z", "isEnabled", "isCloudSupported", "checkResources", "(Landroid/content/Context;)I", "Lcom/stepos/aiengine/client/BaseModel;", "M", "Lcom/stepos/aiengine/client/ModelType;", "type", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "(Lcom/stepos/aiengine/client/ModelType;)Lcom/stepos/aiengine/client/BaseModel;", "key", "getInitialProperty", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getRuntimeProperty", "getBundleProperty", UxipConstants.f30680s, "setAlgorithmProperty", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "pluginKey", "checkPluginResources", "(Landroid/content/Context;Ljava/lang/String;)I", e.f30860s, "Lcom/stepos/aiengine/api/task/IAlgorithmListener;", "setAlgorithmListener", "(Landroid/content/Context;JLcom/stepos/aiengine/api/task/IAlgorithmListener;)V", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "callback", "Lcom/stepos/core/download/IDownloadCallback;", "progressCallback", "checkAndDownload", "(Landroid/content/Context;Lcom/stepos/aiengine/flow/ModelFlowCallback;Lcom/stepos/core/download/IDownloadCallback;)V", "checkAndUpdate", "prepareInference", "(Landroid/content/Context;Lcom/stepos/aiengine/flow/ModelFlowCallback;)V", "Lcom/stepos/aiengine/model/IModelManager;", "getModelManager", "(Landroid/content/Context;)Lcom/stepos/aiengine/model/IModelManager;", "Lw9/d;", "Ljava/lang/String;", "getAlgorithmId", "()Ljava/lang/String;", "Ljava/lang/Object;", "adapter", "Lcom/stepos/core/AbilityHandle;", "Lcom/stepos/core/AbilityHandle;", "handle", "LUa/M;", "e", "LUa/M;", "scope", "Lkotlinx/coroutines/g;", "f", "Lkotlinx/coroutines/g;", "delayReleaseJob", "Lcom/stepos/aiengine/client/LocalModelImpl;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/aiengine/client/LocalModelImpl;", "local", "Lcom/stepos/aiengine/client/RemoteModelImpl;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/aiengine/client/RemoteModelImpl;", "remote", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/content/Context;", "listenerRegisteredContext", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lcom/stepos/core/download/IDownloadCallback;", "algorithmListenerProxy", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "k", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "providerStateListener", "l", "connectionStateListener", "m", "Lp9/p;", "modelReleasedListener", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AlgorithmClient<I> {

    /* renamed from: n, reason: collision with root package name */
    public static final ComponentName f23715n = new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<I> interfaceClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String algorithmId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public I adapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public AbilityHandle handle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public g delayReleaseJob;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final LocalModelImpl local;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final RemoteModelImpl remote;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Context listenerRegisteredContext;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public IDownloadCallback algorithmListenerProxy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public ProviderStateListener providerStateListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public ProviderStateListener connectionStateListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public p<? super Integer, ? super String, t> modelReleasedListener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.aiengine.client.AlgorithmClient$scheduleDelayRelease$1", f = "AlgorithmClient.kt", l = {224}, m = "invokeSuspend")
    /* renamed from: com.stepos.aiengine.client.AlgorithmClient$scheduleDelayRelease$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f23730a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f23731b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AlgorithmClient<I> f23732c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j10, AlgorithmClient<I> algorithmClient, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f23731b = j10;
            this.f23732c = algorithmClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f23731b, this.f23732c, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f23730a;
            if (i10 == 0) {
                C4849c.b(obj);
                long j10 = this.f23731b;
                this.f23730a = 1;
                if (U.a(j10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            AlgorithmClient<I> algorithmClient = this.f23732c;
            synchronized (algorithmClient) {
                try {
                    AbilityHandle abilityHandle = algorithmClient.handle;
                    if (abilityHandle != null) {
                        abilityHandle.release();
                    }
                    algorithmClient.handle = null;
                    algorithmClient.adapter = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return t.f7040a;
        }
    }

    public AlgorithmClient(InterfaceC5745d<I> interfaceClass, String algorithmId) {
        kotlin.jvm.internal.p.i(interfaceClass, "interfaceClass");
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        this.interfaceClass = interfaceClass;
        this.algorithmId = algorithmId;
        this.scope = d.a(Y.a().plus(L0.b(null, 1, null)));
        this.local = new LocalModelImpl(algorithmId);
        this.remote = new RemoteModelImpl(algorithmId);
    }

    public static /* synthetic */ void checkAndDownload$default(AlgorithmClient algorithmClient, Context context, ModelFlowCallback modelFlowCallback, IDownloadCallback iDownloadCallback, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            iDownloadCallback = null;
        }
        algorithmClient.checkAndDownload(context, modelFlowCallback, iDownloadCallback);
    }

    public static /* synthetic */ void checkAndUpdate$default(AlgorithmClient algorithmClient, Context context, ModelFlowCallback modelFlowCallback, IDownloadCallback iDownloadCallback, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            iDownloadCallback = null;
        }
        algorithmClient.checkAndUpdate(context, modelFlowCallback, iDownloadCallback);
    }

    public static /* synthetic */ Object loadAlgorithm$default(AlgorithmClient algorithmClient, Context context, Bundle bundle, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        return algorithmClient.loadAlgorithm(context, bundle);
    }

    public static /* synthetic */ boolean preload$default(AlgorithmClient algorithmClient, Context context, Bundle bundle, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        return algorithmClient.preload(context, bundle);
    }

    public static /* synthetic */ void scheduleDelayRelease$default(AlgorithmClient algorithmClient, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 5000;
        }
        algorithmClient.scheduleDelayRelease(j10);
    }

    public final void a() {
        IDownloadCallback iDownloadCallback = this.algorithmListenerProxy;
        if (iDownloadCallback == null) {
            return;
        }
        Context context = this.listenerRegisteredContext;
        t tVar = null;
        this.algorithmListenerProxy = null;
        this.listenerRegisteredContext = null;
        ProviderStateListener providerStateListener = this.providerStateListener;
        if (providerStateListener != null) {
            DeepBinderClient.INSTANCE.unRegisterProviderStateListener(providerStateListener);
            this.providerStateListener = null;
        }
        if (context != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
                if (iOtaDeepBinderService != null) {
                    iOtaDeepBinderService.unregisterDownloadCallback(this.algorithmId, iDownloadCallback);
                    tVar = t.f7040a;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void b() {
        ProviderStateListener providerStateListener = this.connectionStateListener;
        if (providerStateListener != null) {
            DeepBinderClient.INSTANCE.unRegisterProviderStateListener(providerStateListener);
            this.connectionStateListener = null;
        }
    }

    public final ConfirmUiHost c(Context context) {
        return SdkConfirmHost.INSTANCE.hostFor(context);
    }

    public final void cancelDelayRelease() {
        g gVar = this.delayReleaseJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.delayReleaseJob = null;
    }

    public final void checkAndDownload(Context context, ModelFlowCallback callback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        checkAndDownload$default(this, context, callback, null, 4, null);
    }

    public final void checkAndUpdate(Context context, ModelFlowCallback callback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        checkAndUpdate$default(this, context, callback, null, 4, null);
    }

    public final int checkPluginResources(Context context, String pluginKey) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(pluginKey, "pluginKey");
        return this.local.checkPluginResources(context, pluginKey);
    }

    public final int checkResources(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.local.checkResources(context);
    }

    public final void d() {
        if (this.connectionStateListener != null) {
            return;
        }
        ProviderStateListener providerStateListener = new ProviderStateListener(this) { // from class: com.stepos.aiengine.client.AlgorithmClient$ensureConnectionStateListener$listener$1

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlgorithmClient<I> f23729a;

            {
                this.f23729a = this;
            }

            @Override // com.stepos.deepbinder.client.api.ProviderStateListener
            public void onProviderStart(ComponentName componentName) {
                kotlin.jvm.internal.p.i(componentName, "componentName");
            }

            @Override // com.stepos.deepbinder.client.api.ProviderStateListener
            public void onProviderStop(ComponentName componentName) {
                kotlin.jvm.internal.p.i(componentName, "componentName");
                if (kotlin.jvm.internal.p.d(componentName, AlgorithmClient.f23715n)) {
                    Log.w("AlgorithmClient", "onProviderStop: server died, clearing cached adapter/handle for " + this.f23729a.getAlgorithmId());
                    AlgorithmClient<I> algorithmClient = this.f23729a;
                    synchronized (algorithmClient) {
                        try {
                            algorithmClient.cancelDelayRelease();
                            AbilityHandle abilityHandle = algorithmClient.handle;
                            if (abilityHandle != null) {
                                abilityHandle.failAllPending(ApiErrorCode.NETWORK_UNAVAILABLE, "AIEngine service died");
                            }
                            algorithmClient.handle = null;
                            algorithmClient.adapter = null;
                            t tVar = t.f7040a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        };
        DeepBinderClient.INSTANCE.registerProviderStateListener(providerStateListener);
        this.connectionStateListener = providerStateListener;
    }

    public final Content execute(String action, Content params) {
        Content contentExecute;
        kotlin.jvm.internal.p.i(action, "action");
        synchronized (this) {
            AbilityHandle abilityHandle = this.handle;
            contentExecute = abilityHandle != null ? abilityHandle.execute(action, params) : null;
        }
        return contentExecute;
    }

    public final String getAlgorithmId() {
        return this.algorithmId;
    }

    public final String getBundleProperty(Context context, String key) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(key, "key");
        Bundle bundle = new Bundle();
        bundle.putInt(LoadParamBundle.KEY_INIT_STRATEGY, 0);
        t tVar = t.f7040a;
        loadAlgorithm(context, bundle);
        return AbilityServiceClient.INSTANCE.get(context).getAbilityProperty(this.algorithmId, key);
    }

    public final String getInitialProperty(Context context, String key) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(key, "key");
        IAIEngineDeepBinderService iAIEngineDeepBinderService = AbilityServiceClient.INSTANCE.get(context);
        int iHashCode = key.hashCode();
        if (iHashCode == -1714660125) {
            if (key.equals(IAlgorithmProperties.CURRENT_MODEL)) {
                return iAIEngineDeepBinderService.getAbilityProperty(this.algorithmId, IAlgorithmProperties.CURRENT_MODEL);
            }
            return null;
        }
        if (iHashCode == -475629664) {
            if (key.equals(IAlgorithmProperties.PLUGINS)) {
                return iAIEngineDeepBinderService.getAbilityProperty(this.algorithmId, IAlgorithmProperties.PLUGINS);
            }
            return null;
        }
        if (iHashCode == 1736037254 && key.equals(IAlgorithmProperties.MAX_TOKEN_LIMIT)) {
            return "4096";
        }
        return null;
    }

    public final IModelManager getModelManager(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.local.getModelManager(context);
    }

    public final String getRuntimeProperty(Context context, String key) {
        boolean z10;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(key, "key");
        if (!kotlin.jvm.internal.p.d(key, IAlgorithmProperties.IS_BUSY)) {
            return null;
        }
        synchronized (this) {
            z10 = this.adapter != null;
        }
        return String.valueOf(z10);
    }

    public final boolean isClientAlive() {
        boolean z10;
        synchronized (this) {
            z10 = this.adapter != null;
        }
        return z10;
    }

    public final boolean isCloudSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.remote.isSupported(context);
    }

    public final boolean isEnabled(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.local.isEnabled(context);
    }

    public final boolean isSupported(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return this.local.isSupported(context);
    }

    public final I loadAlgorithm(Context context, Bundle params) {
        String str;
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        synchronized (this) {
            I i10 = this.adapter;
            if (i10 != null) {
                cancelDelayRelease();
                return i10;
            }
            AIEngineManager companion = AIEngineManager.INSTANCE.getInstance(context);
            String string = params != null ? params.getString("plugin") : null;
            if (string != null) {
                str = this.algorithmId + l.DATE_SEPARATOR + string;
                if (!AbilityServiceClient.INSTANCE.get(context).containsAbility(str)) {
                    str = this.algorithmId;
                }
            } else {
                str = this.algorithmId;
            }
            AbilityHandle abilityHandleCreateAbility = companion.createAbility(str);
            if (abilityHandleCreateAbility == null) {
                throw new IllegalStateException(("Ability not found or service unavailable: " + str).toString());
            }
            abilityHandleCreateAbility.prepare();
            this.handle = abilityHandleCreateAbility;
            I i11 = (I) AdapterFactory.INSTANCE.create(this.interfaceClass, abilityHandleCreateAbility, str, params);
            this.adapter = i11;
            long j10 = params != null ? params.getLong(LoadParamBundle.KEY_IDLE_TIMEOUT, -1L) : -1L;
            if (j10 > 0) {
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(abilityHandleCreateAbility.execute("setIdleTimeout", new TextContent(String.valueOf(j10))));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w("AlgorithmClient", "setIdleTimeout(" + j10 + ") failed (old service?), fallback default", thE);
                }
            }
            d();
            p<? super Integer, ? super String, t> pVar = this.modelReleasedListener;
            if (pVar != null) {
                abilityHandleCreateAbility.setOnModelReleased(pVar);
            }
            return i11;
        }
    }

    public final <M extends BaseModel> M model(ModelType<M> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, ModelType.Local.INSTANCE)) {
            LocalModelImpl localModelImpl = this.local;
            kotlin.jvm.internal.p.g(localModelImpl, "null cannot be cast to non-null type M of com.stepos.aiengine.client.AlgorithmClient.model");
            return localModelImpl;
        }
        if (!kotlin.jvm.internal.p.d(type, ModelType.Remote.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        RemoteModelImpl remoteModelImpl = this.remote;
        kotlin.jvm.internal.p.g(remoteModelImpl, "null cannot be cast to non-null type M of com.stepos.aiengine.client.AlgorithmClient.model");
        return remoteModelImpl;
    }

    public final AlgorithmClient<I> obtain() {
        return new AlgorithmClient<>(this.interfaceClass, this.algorithmId);
    }

    public final boolean preload(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return preload$default(this, context, null, 2, null);
    }

    public final void prepareInference(Context context, ModelFlowCallback callback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        new ModelConfirmFlow(this.algorithmId, ModelConfirmFlow.Mode.DOWNLOAD, null, 0L, null, c(context), null, false, 220, null).startInferencePreflight(context, OtaServiceClient.INSTANCE.get(context), callback, this.scope);
    }

    public final void releaseAlgorithm(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        releaseClient();
    }

    public final void releaseClient() {
        synchronized (this) {
            try {
                a();
                b();
                cancelDelayRelease();
                AbilityHandle abilityHandle = this.handle;
                if (abilityHandle != null) {
                    abilityHandle.release();
                }
                this.handle = null;
                this.adapter = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleDelayRelease(long delayMs) {
        cancelDelayRelease();
        this.delayReleaseJob = C1060i.d(this.scope, null, null, new AnonymousClass1(delayMs, this, null), 3, null);
    }

    public final void setAlgorithmListener(Context context, final long identity, final IAlgorithmListener listener) {
        kotlin.jvm.internal.p.i(context, "context");
        synchronized (this) {
            a();
            if (listener == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            OtaServiceClient otaServiceClient = OtaServiceClient.INSTANCE;
            kotlin.jvm.internal.p.f(applicationContext);
            IOtaDeepBinderService iOtaDeepBinderService = otaServiceClient.get(applicationContext);
            if (iOtaDeepBinderService == null) {
                return;
            }
            IDownloadCallback iDownloadCallback = new IDownloadCallback() { // from class: com.stepos.aiengine.client.AlgorithmClient$setAlgorithmListener$1$cb$1
                @Override // com.stepos.core.download.IDownloadCallback
                public void onComplete(String localFilePath) {
                    kotlin.jvm.internal.p.i(localFilePath, "localFilePath");
                    IAlgorithmListener iAlgorithmListener = listener;
                    long j10 = identity;
                    Bundle bundle = new Bundle();
                    bundle.putString("algorithmId", this.getAlgorithmId());
                    bundle.putString("localFilePath", localFilePath);
                    t tVar = t.f7040a;
                    iAlgorithmListener.onPrepared(j10, bundle);
                }

                @Override // com.stepos.core.download.IDownloadCallback
                public void onError(int code, String message) {
                    kotlin.jvm.internal.p.i(message, "message");
                    listener.onFailed(identity, code, message);
                }

                @Override // com.stepos.core.download.IDownloadCallback
                public void onProgress(int i10, long j10, long j11) {
                    IDownloadCallback.DefaultImpls.onProgress(this, i10, j10, j11);
                }

                @Override // com.stepos.core.download.IDownloadCallback
                public void onUpdate(int state, int progress) {
                    listener.onUpdate(identity, state, progress);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                iOtaDeepBinderService.registerDownloadCallback(this.algorithmId, iDownloadCallback);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            this.algorithmListenerProxy = iDownloadCallback;
            this.listenerRegisteredContext = applicationContext;
            ProviderStateListener providerStateListener = new ProviderStateListener(this) { // from class: com.stepos.aiengine.client.AlgorithmClient$setAlgorithmListener$1$stateListener$1

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AlgorithmClient<I> f23736a;

                {
                    this.f23736a = this;
                }

                @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                public void onProviderStart(ComponentName componentName) {
                    Object objB;
                    t tVar;
                    kotlin.jvm.internal.p.i(componentName, "componentName");
                    if (kotlin.jvm.internal.p.d(componentName, AlgorithmClient.f23715n)) {
                        AlgorithmClient<I> algorithmClient = this.f23736a;
                        synchronized (algorithmClient) {
                            IDownloadCallback iDownloadCallback2 = algorithmClient.algorithmListenerProxy;
                            if (iDownloadCallback2 == null) {
                                return;
                            }
                            Context context2 = algorithmClient.listenerRegisteredContext;
                            if (context2 == null) {
                                return;
                            }
                            try {
                                Result.Companion companion3 = Result.INSTANCE;
                                IOtaDeepBinderService iOtaDeepBinderService2 = OtaServiceClient.INSTANCE.get(context2);
                                if (iOtaDeepBinderService2 != null) {
                                    iOtaDeepBinderService2.registerDownloadCallback(algorithmClient.getAlgorithmId(), iDownloadCallback2);
                                    tVar = t.f7040a;
                                } else {
                                    tVar = null;
                                }
                                objB = Result.b(tVar);
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.INSTANCE;
                                objB = Result.b(C4849c.a(th2));
                            }
                            Throwable thE = Result.e(objB);
                            if (thE != null) {
                                Log.w("AlgorithmClient", "re-register download callback failed for " + algorithmClient.getAlgorithmId(), thE);
                            }
                        }
                    }
                }

                @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                public void onProviderStop(ComponentName componentName) {
                    kotlin.jvm.internal.p.i(componentName, "componentName");
                }
            };
            DeepBinderClient.INSTANCE.registerProviderStateListener(providerStateListener);
            this.providerStateListener = providerStateListener;
            t tVar = t.f7040a;
        }
    }

    public final void setAlgorithmProperty(Context context, String key, String value) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
    }

    public final void setOnModelReleased(p<? super Integer, ? super String, t> listener) {
        synchronized (this) {
            this.modelReleasedListener = listener;
            AbilityHandle abilityHandle = this.handle;
            if (abilityHandle != null) {
                abilityHandle.setOnModelReleased(listener);
                t tVar = t.f7040a;
            }
        }
    }

    public final void checkAndDownload(Context context, ModelFlowCallback callback, IDownloadCallback progressCallback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        new ModelConfirmFlow(this.algorithmId, ModelConfirmFlow.Mode.DOWNLOAD, null, 0L, null, c(context), null, false, 220, null).start(context, OtaServiceClient.INSTANCE.get(context), callback, progressCallback, this.scope);
    }

    public final void checkAndUpdate(Context context, ModelFlowCallback callback, IDownloadCallback progressCallback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        new ModelConfirmFlow(this.algorithmId, ModelConfirmFlow.Mode.UPDATE, null, 0L, null, c(context), null, true, 92, null).start(context, OtaServiceClient.INSTANCE.get(context), callback, progressCallback, this.scope);
    }

    public final boolean preload(Context context, Bundle params) {
        Object objB;
        AbilityHandle abilityHandle;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            loadAlgorithm(context, params);
            synchronized (this) {
                abilityHandle = this.handle;
            }
            objB = Result.b(Boolean.valueOf(abilityHandle != null ? abilityHandle.prepare() : false));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("AlgorithmClient", "preload failed: algorithmId=" + this.algorithmId + ", " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void releaseAlgorithm(Context context, boolean immediate) {
        kotlin.jvm.internal.p.i(context, "context");
        releaseClient();
    }
}
