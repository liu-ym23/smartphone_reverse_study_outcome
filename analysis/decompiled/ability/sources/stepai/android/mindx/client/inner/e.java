package stepai.android.mindx.client.inner;

import S7.n;
import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.taskrobot.llmapi.stepfun.g;
import j9.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import stepai.android.llm.base.LLMRequest;
import stepai.android.llm.base.log.ILLMLogger;
import stepai.android.mindx.base.ILLMCallbackHandler;
import stepai.android.mindx.base.LLMInterface;
import stepai.android.mindx.client.config.ClientConfig;
import stepai.android.mindx.client.config.ConfigsKt;

/* loaded from: classes4.dex */
public final class e implements ILLMLogger, Ma.a {

    /* renamed from: a, reason: collision with root package name */
    public long f6211a = 60000;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ArrayList d = new ArrayList();
    public final c e = new c(new g(this, 11), new ILLMCallbackHandler.Stub() { // from class: stepai.android.mindx.client.inner.StepInnerClient$iCallback$1
        @Override // stepai.android.mindx.base.ILLMCallbackHandler
        public void onChatReceive(int code, String data, String requestId) {
            k.f(data, "data");
            k.f(requestId, "requestId");
            AbstractC1683A.n(ConfigsKt.getLLMClientScope(), null, new StepInnerClient$iCallback$1$onChatReceive$1(this.this$0, requestId, code, data, null), 3);
        }

        @Override // stepai.android.mindx.base.ILLMCallbackHandler
        public void onInitResult(int code, String message) {
            AbstractC1683A.n(ConfigsKt.getLLMClientScope(), null, new StepInnerClient$iCallback$1$onInitResult$1(code, this.this$0, message, null), 3);
        }

        @Override // stepai.android.mindx.base.ILLMCallbackHandler
        public void onStreamReceive(int code, String data, String requestId) {
            k.f(data, "data");
            k.f(requestId, "requestId");
            AbstractC1683A.n(ConfigsKt.getLLMClientScope(), null, new StepInnerClient$iCallback$1$onStreamReceive$1(this.this$0, requestId, code, data, null), 3);
        }
    });
    public final String f = ConfigsKt.TAG;

    public final String a(stepai.android.mindx.base.d resourceType) {
        k.f(resourceType, "resourceType");
        if (!isServiceConnected()) {
            return "当前service没有链接";
        }
        LLMInterface lLMInterface = this.e.d;
        if (lLMInterface == null) {
            return "当前的binder链接为空";
        }
        k.c(lLMInterface);
        if (lLMInterface.checkResourceSupport(S0.b.s1(resourceType))) {
            return "";
        }
        return "当前包不支持该请求类型，当前请求类型:" + resourceType;
    }

    @Override // Ma.a
    public final boolean bindService(Context context) {
        k.f(context, "context");
        return this.e.a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3 A[Catch: all -> 0x00d9, Exception -> 0x00db, TimeoutCancellationException -> 0x011f, TryCatch #1 {TimeoutCancellationException -> 0x011f, blocks: (B:31:0x00ab, B:33:0x00b3, B:38:0x00dd, B:41:0x00e7, B:26:0x0078, B:27:0x0088, B:28:0x008c), top: B:54:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd A[Catch: all -> 0x00d9, Exception -> 0x00db, TimeoutCancellationException -> 0x011f, TryCatch #1 {TimeoutCancellationException -> 0x011f, blocks: (B:31:0x00ab, B:33:0x00b3, B:38:0x00dd, B:41:0x00e7, B:26:0x0078, B:27:0x0088, B:28:0x008c), top: B:54:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // Ma.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object chat(stepai.android.llm.base.LLMRequest r12, stepai.android.mindx.base.d r13, H7.c r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.android.mindx.client.inner.e.chat(stepai.android.llm.base.LLMRequest, stepai.android.mindx.base.d, H7.c):java.lang.Object");
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final String getChildTag() {
        return this.f;
    }

    @Override // Ma.a
    public final String getTraceById(String id) {
        k.f(id, "id");
        stepai.android.mindx.base.b bVar = stepai.android.mindx.base.b.f6198a;
        if (m.s0(id)) {
            ILLMLogger.DefaultImpls.printI(bVar, "traceId is null or blank", "mindx");
            return null;
        }
        String str = (String) stepai.android.mindx.base.b.b.get(id);
        ILLMLogger.DefaultImpls.printI(bVar, "getRequestResponseByResponseId: responseId=" + id + ", found=" + (str != null), "mindx");
        return str;
    }

    @Override // Ma.a
    public final boolean isServiceConnected() {
        IBinder iBinderAsBinder;
        LLMInterface lLMInterface = this.e.d;
        if (lLMInterface == null || (iBinderAsBinder = lLMInterface.asBinder()) == null) {
            return false;
        }
        return iBinderAsBinder.isBinderAlive();
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printE(String str, String str2) {
        ILLMLogger.DefaultImpls.printE(this, str, str2);
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printI(String str, String str2) {
        ILLMLogger.DefaultImpls.printI(this, str, str2);
    }

    @Override // stepai.android.llm.base.log.ILLMLogger
    public final void printV(String str, String str2) {
        ILLMLogger.DefaultImpls.printV(this, str, str2);
    }

    @Override // Ma.a
    public final void recordPathList(String str) throws RemoteException {
        if (!isServiceConnected()) {
            throw new IllegalStateException("recordPathList service 没有连接!!");
        }
        LLMInterface lLMInterface = this.e.d;
        k.c(lLMInterface);
        lLMInterface.recordPathList(str);
    }

    @Override // Ma.a
    public final void registerErrorListener(n listener) {
        k.f(listener, "listener");
        synchronized (this.d) {
            this.d.add(listener);
        }
    }

    @Override // Ma.a
    public final p9.c stream(LLMRequest param, stepai.android.mindx.base.d resourceType) {
        k.f(param, "param");
        k.f(resourceType, "resourceType");
        return new p9.m(new StepInnerClient$stream$1(this, resourceType, param, null));
    }

    @Override // Ma.a
    public final boolean syncTraceBuffer() throws RemoteException {
        if (!isServiceConnected()) {
            throw new IllegalStateException("syncTraceBuffer service 没有连接!!");
        }
        LLMInterface lLMInterface = this.e.d;
        k.c(lLMInterface);
        Map<String, String> map = lLMInterface.syncTraceBuffer();
        if (map == null || map.isEmpty()) {
            ILLMLogger.DefaultImpls.printE(this, "syncTraceBuffer trace is null or empty", ConfigsKt.TAG);
            return false;
        }
        ILLMLogger.DefaultImpls.printI(this, "syncTraceBuffer trace set done", ConfigsKt.TAG);
        stepai.android.mindx.base.b bVar = stepai.android.mindx.base.b.f6198a;
        k.f(map, "map");
        stepai.android.mindx.base.b.b = map;
        return true;
    }

    @Override // Ma.a
    public final void unbindService() {
        IBinder iBinderAsBinder;
        c cVar = this.e;
        cVar.getClass();
        try {
            LLMInterface lLMInterface = cVar.d;
            if (lLMInterface != null && (iBinderAsBinder = lLMInterface.asBinder()) != null) {
                iBinderAsBinder.unlinkToDeath(cVar.g, 0);
            }
            Application application = cVar.c;
            if (application != null) {
                application.unbindService(cVar.f);
            }
            cVar.d = null;
            cVar.f6209a.invoke(null);
            ILLMLogger.DefaultImpls.printI(cVar, "unbind service", ConfigsKt.TAG);
        } catch (Exception e) {
            ILLMLogger.DefaultImpls.printE(cVar, "unbind service error: " + e, ConfigsKt.TAG);
        }
    }

    @Override // Ma.a
    public final void updateSetting(ClientConfig config) {
        k.f(config, "config");
        this.f6211a = config.getTimeoutMillis();
    }
}
