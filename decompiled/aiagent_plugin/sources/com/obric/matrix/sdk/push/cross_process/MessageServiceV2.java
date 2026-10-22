package com.obric.matrix.sdk.push.cross_process;

import android.content.Context;
import com.obric.matrix.push.common.a.c;
import com.obric.matrix.push.common.cross_process.ICrossProcessCallbackInterface;
import com.obric.matrix.push.common.cross_process.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: MessageServiceV2.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MessageServiceV2 extends CrossProcessService implements com.obric.matrix.sdk.push.a {

    /* JADX INFO: compiled from: MessageServiceV2.kt */
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MessageServiceV2 f33771a;

        @Override // com.obric.matrix.push.common.cross_process.a.b
        public String a() {
            return ".action.MESSAGE_EVENT";
        }

        a(MessageServiceV2 r3) {
            this.f33771a = (MessageServiceV2) ZeusTransformUtils.wrapperContextForParams(r3, MessageServiceV2.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.matrix.push.common.cross_process.a.b
        public void a(String r3, List<Object> r4, ICrossProcessCallbackInterface r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            ICrossProcessCallbackInterface r7 = (ICrossProcessCallbackInterface) ZeusTransformUtils.wrapperContextForParams(r5, ICrossProcessCallbackInterface.class, "com.obric.aiagent.plugin");
            o.e(r3, "originPkgName");
            if (r6 != null) goto L5;
        L21:
            c.c("message service v2 args is null or size < 2");
            return;
        L5:
            if (r6.size() < 2) goto L21;
            Object r8 = r6.get(0);     // Catch: Throwable -> L18
            if (r8 == null) goto L17;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
            Object r10 = r6.get(1);     // Catch: Throwable -> L18
            if (r10 == null) goto L15;
            this.f33771a.onReceiveMsg(new com.obric.matrix.sdk.push.a.a(r9, (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L18
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            c.c("message service v2 error: " + th);
        }
    }

    public MessageServiceV2() {
    }

    @Override // com.obric.matrix.sdk.push.cross_process.CrossProcessService
    public void registerCrossProcessMethod() {
        com.obric.matrix.push.common.a.f33752a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).a((b) ZeusTransformUtils.preCheckCast(new a(this), b.class, "com.obric.aiagent.plugin"));
    }
}
