package cb;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import java.lang.reflect.Proxy;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.obric.capabilitykit.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f6082c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICapabilityManager f6083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6084b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f6082c = new a(null);
    }

    public o(ICapabilityManager r10) {
        kotlin.jvm.internal.q.g(r10, "api");
        Object r11 = Proxy.newProxyInstance(ICapabilityManager.class.getClassLoader(), new Class[]{ICapabilityManager.class}, new BinderExceptionHandlerProxy(r10, "CapabilityManagerClient", ICapabilityManager.class));     // Catch: Throwable -> L6
        if (r11 == null) goto L9;
        r10 = (ICapabilityManager) r11;     // Catch: Throwable -> L6
    L13:
        this.f6083a = r10;
        int r12 = r10.getVersion();
        Logger.INSTANCE.i("CapabilityManagerClient", "ICapabilityManager version: " + r12);
        this.f6084b = r12;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityManager");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Throwable r13 = Result.m38exceptionOrNullimpl(Result.m35constructorimpl(kotlin.c.a(th)));
        if (r13 == null) goto L13;
        Log.e("CapabilityManagerClient", "BinderExceptionHandlerProxy createProxyInstance for " + r10.getClass() + " fail", r13);
        goto L13
    }

    @Override // com.obric.capabilitykit.a
    public PendingIntent a(long r10, Intent r11, FloatingIntentParams r12) {
        kotlin.jvm.internal.q.g(r11, MemorySourceLinkType.INTENT);
        kotlin.jvm.internal.q.g(r12, "params");
        return this.f6083a.getFloatingPendingIntent(r10, r11, r12);
    }

    @Override // com.obric.capabilitykit.a
    public void b(long r10) {
        this.f6083a.finishFloatingActivity(r10);
    }

    @Override // com.obric.capabilitykit.a
    public Boolean c(long r10) {
        return Boolean.valueOf(this.f6083a.isCardViewVisible(r10));
    }

    @Override // com.obric.capabilitykit.a
    public void a(long r10) {
        this.f6083a.hideIntentResultCard(r10);
    }

    @Override // com.obric.capabilitykit.a
    public void b(ErrorCodeCallback r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        this.f6083a.registerResultCallback(r10);
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "uri");
        kotlin.jvm.internal.q.g(r11, "packageName");
        this.f6083a.requestCloseFile(r11, r10);
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r10, String r11, IUriFileReceiver r12) {
        kotlin.jvm.internal.q.g(r10, "uri");
        kotlin.jvm.internal.q.g(r11, "packageName");
        kotlin.jvm.internal.q.g(r12, "requester");
        if (this.f6083a.requestOpenFile(r12, r10, r11) == true) goto L6;
        r12.onSessionReady(new UriFileAccessSession(1, "无权限或无法访问 URI。", null, 4, null));
        return;
    }

    @Override // com.obric.capabilitykit.a
    public void a(ErrorCodeCallback r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        this.f6083a.unregisterResultCallback(r10);
    }

    @Override // com.obric.capabilitykit.a
    public void a(IMAppAction r10) {
        kotlin.jvm.internal.q.g(r10, "result");
        this.f6083a.sendActionExecuteResult(UtilsKt.getGson().toJson(r10));
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult r10, long r11, boolean r12, Map r13) {
        kotlin.jvm.internal.q.g(r10, "result");
        this.f6083a.updateIntentResult(r10, r11, r12, r13);
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult r10, IMAppAction r11) {
        kotlin.jvm.internal.q.g(r10, "intentResult");
        kotlin.jvm.internal.q.g(r11, "oldResult");
        this.f6083a.sendIntentExecutionResult(r10, UtilsKt.getGson().toJson(r11));
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r10, TaskStateInfo r11, TaskStateChangeCallback r12, Long r13) {
        kotlin.jvm.internal.q.g(r10, "id");
        kotlin.jvm.internal.q.g(r11, "stateInfo");
        ICapabilityManager r14 = this.f6083a;
        if (r13 == null) goto L6;
        long r15 = r13.longValue();
    L7:
        r14.requestStateChanged(r10, r11, r12, r15);
        return;
    L6:
        r15 = 0;
        goto L7
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "implClassName");
        this.f6083a.unregisterIntent(r10, r11);
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "implClassName");
        this.f6083a.registerIntent(r10, r11, r12);
    }

    @Override // com.obric.capabilitykit.a
    public boolean a() {
        return this.f6083a.isKeyguardReallyLocked();
    }
}
