package com.bytedance.ai.bridge.protocol;

import android.content.Context;
import androidx.core.util.Consumer;
import com.bytedance.ai.utils.j;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m4.h;
import s4.c;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0007J\u001d\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/WorkerModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "param", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "getContext", "()Landroid/content/Context;", "jsWorker", "Lcom/bytedance/vmsdk/worker/JsWorker;", "remoteBridgeMessages", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "setMessageHandle", "", "handle", "Landroidx/core/util/Consumer;", "postMessage", "message", "sendMessage", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", RemoteMessageConst.MSGID, "", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;Ljava/lang/Long;)V", "Companion", "WorkerReceiveMsgFunc", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkerModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "AppletBridgeModule";
    private final Context context;
    private JsWorker jsWorker;
    private final Object param;
    private final c<ReadableMap> remoteBridgeMessages;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/WorkerModule$WorkerReceiveMsgFunc;", "Lcom/bytedance/vmsdk/registry/JavaScriptFunction;", "onWorkerMessage", "", "message", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface WorkerReceiveMsgFunc extends com.bytedance.vmsdk.registry.a {
        void onWorkerMessage(JavaOnlyMap r100);
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(Long r100, WorkerModule r101, JavaOnlyMap r102) {
        sendMessage$lambda$2(r100, r101, r102);
    }

    public final Context getContext() {
        return this.context;
    }

    @JSMethod
    public final void postMessage(ReadableMap r100) {
        if (r100 == null) goto L5;
        this.remoteBridgeMessages.b(r100);
        return;
    }

    public final void setMessageHandle(Consumer<ReadableMap> r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        this.remoteBridgeMessages.d(r100);
    }

    public WorkerModule(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "param");
        super(r100, r101);
        this.context = r100;
        this.param = r101;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.vmsdk.worker.JsWorker");
        this.jsWorker = (JsWorker) r101;
        this.remoteBridgeMessages = new c();
    }

    public final void sendMessage(final JavaOnlyMap r100, final Long r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.jsWorker.postOnJSRunner(new h(r101, this, r100));
    }

    private static final void sendMessage$lambda$2(Long r100, WorkerModule r101, JavaOnlyMap r102) {
        if (r100 == null) goto L8;
        r100.longValue();
        j.a r103 = j.b(r100);
        if (r103 == null) goto L8;
        j.c r104 = r103.f37655o;
        if (r104 == null) goto L8;
        r104.a();
    L8:
        ((WorkerReceiveMsgFunc) r101.jsWorker.getJavaScriptFunction(WorkerReceiveMsgFunc.class)).onWorkerMessage(r102);
        if (r100 == null) goto L16;
        r100.longValue();
        j.a r105 = j.b(r100);
        if (r105 == null) goto L17;
        j.c r106 = r105.f37656p;
        if (r106 == null) goto L18;
        r106.a();
        return;
    L18:
        return;
    L17:
        return;
    }
}
