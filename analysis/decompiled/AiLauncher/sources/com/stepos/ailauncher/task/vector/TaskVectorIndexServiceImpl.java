package com.stepos.ailauncher.task.vector;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.contract.api.vector.IVectorIndexService;
import com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/task/vector/TaskVectorIndexServiceImpl;", "Lcom/stepos/ailauncher/contract/api/vector/IVectorIndexService;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "installIfPrivacyAgreed", "()V", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "LUa/M;", "scope", "LUa/M;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "installRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskVectorIndexServiceImpl implements IVectorIndexService {
    private static final a Companion = new a(null);
    private static final String TAG = "TaskVectorIndexService";
    private final Context appContext;
    private final AtomicBoolean installRequested;
    private final M scope;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/vector/TaskVectorIndexServiceImpl$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.vector.TaskVectorIndexServiceImpl$installIfPrivacyAgreed$1", f = "TaskVectorIndexServiceImpl.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.vector.TaskVectorIndexServiceImpl$installIfPrivacyAgreed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = TaskVectorIndexServiceImpl.this.new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            TaskVectorIndexServiceImpl taskVectorIndexServiceImpl = TaskVectorIndexServiceImpl.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                Log.d(TaskVectorIndexServiceImpl.TAG, "Vector index install requested");
                TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
                Context context = taskVectorIndexServiceImpl.appContext;
                kotlin.jvm.internal.p.h(context, "access$getAppContext$p(...)");
                taskStoreModule.q(context);
                TaskStoreVectorIndexBridge taskStoreVectorIndexBridge = TaskStoreVectorIndexBridge.INSTANCE;
                Context context2 = taskVectorIndexServiceImpl.appContext;
                kotlin.jvm.internal.p.h(context2, "access$getAppContext$p(...)");
                taskStoreVectorIndexBridge.b(context2);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            TaskVectorIndexServiceImpl taskVectorIndexServiceImpl2 = TaskVectorIndexServiceImpl.this;
            Throwable thE = Result.e(objB);
            if (thE != null) {
                taskVectorIndexServiceImpl2.installRequested.set(false);
                Log.w(TaskVectorIndexServiceImpl.TAG, "Vector index install failed: " + thE.getMessage(), thE);
            }
            return t.f7040a;
        }
    }

    public TaskVectorIndexServiceImpl(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.appContext = context.getApplicationContext();
        this.scope = d.a(L0.b(null, 1, null).plus(Y.b()));
        this.installRequested = new AtomicBoolean(false);
    }

    @Override // com.stepos.ailauncher.contract.api.vector.IVectorIndexService
    public void installIfPrivacyAgreed() {
        if (!AuthManager.INSTANCE.Y()) {
            Log.d(TAG, "Vector index install deferred until privacy agreed");
        } else if (this.installRequested.compareAndSet(false, true)) {
            C1060i.d(this.scope, null, null, new AnonymousClass1(null), 3, null);
        } else {
            Log.d(TAG, "Vector index install already requested");
        }
    }
}
