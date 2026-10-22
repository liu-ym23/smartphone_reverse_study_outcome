package com.obric.funcall_impl;

import android.graphics.Bitmap;
import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.Gson;
import com.obric.aiagent.assistant.idl.IFlowFrontierDataListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowFrontierIDL;
import com.obric.aiagent.assistant.idl.IFlowFrontierStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowIsMessageInterruptedCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.ad;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.OAppAction;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.common.Ext;
import com.obric.funcall_api.bean.AppActionRequest;
import com.obric.funcall_api.bean.IntentAppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.h;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.a.q;
import d.h.b.aa;
import d.o;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.f.a;
import kotlinx.coroutines.f.c;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AppActionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppActionHandler {
    public static final AppActionHandler INSTANCE = null;
    private static final int REPEAT_TIMES = 2;
    private static final long SEND_ACTION_TIMEOUT = 2000;
    private static final int SERVICE_ID = 33555568;
    private static final String TAG = "AppActionHandler";
    private static final Gson gson = null;
    private static final am ioScope = null;
    private static final am mainScope = null;
    private static final a mutex = null;
    private static final bp networkDispatcher = null;
    private static final AppActionHandler$wsReceiveListener$1 wsReceiveListener = null;
    private static final AppActionHandler$wsStatusListener$1 wsStatusListener = null;

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$init$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        int label;

        AnonymousClass1(d<? super AnonymousClass1> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public static /* synthetic */ void lambda$IMkzG3x6Gs17DVHZk822YIkMzdE(IFlowFrontierIDL r0) {
            invokeSuspend$lambda$0(r0);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            b.a();
            if (this.label != 0) goto L7;
            o.a(r7);
            ILogDepend.Companion.i(AppActionHandler.TAG, "onIPCRegister, begin");
            ad.a(aa.b(IFlowFrontierIDL.class), false, false, $$Lambda$AppActionHandler$init$1$IMkzG3x6Gs17DVHZk822YIkMzdE.INSTANCE, 3, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final void invokeSuspend$lambda$0(IFlowFrontierIDL r4) {
            IFlowFrontierIDL r5 = (IFlowFrontierIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowFrontierIDL.class, "com.obric.aiagent.plugin");
            ILogDepend.Companion.i(AppActionHandler.TAG, "onIPCRegister, register listener");
            r5.registerStateListener(AppActionHandler.SERVICE_ID, (IFlowFrontierStateListenerIDL) ZeusTransformUtils.preCheckCast(AppActionHandler.access$getWsStatusListener$p(), IFlowFrontierStateListenerIDL.class, "com.obric.aiagent.plugin"));
            r5.registerDataListener(AppActionHandler.SERVICE_ID, (IFlowFrontierDataListenerIDL) ZeusTransformUtils.preCheckCast(AppActionHandler.access$getWsReceiveListener$p(), IFlowFrontierDataListenerIDL.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$notifyUserOperateQueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$notifyUserOperateQueue$1")
    static final class C11621 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ m<Boolean, String, x> $callback;
        final /* synthetic */ String $data;
        int label;

        C11621(m<? super Boolean, ? super String, x> r3, String r4, d<? super C11621> r5) {
            m<Boolean, String, x> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$callback = r6;
            this.$data = r4;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11621(this.$callback, this.$data, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11621) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11621.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            b.a();
            if (this.label != 0) goto L24;
            o.a(r7);
            IFlowNetworkIDL r8 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Throwable -> L9 Exception -> L11
            if (r8 == null) goto L8;
            String r2 = this.$data;     // Catch: Throwable -> L9 Exception -> L11
            final m<Boolean, String, x> r3 = this.$callback;     // Catch: Throwable -> L9 Exception -> L11
            r8.notifyUserOperateQueue(r2, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$notifyUserOperateQueue$1$1$1(r3), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9 Exception -> L11
        L8:
            ILogDepend.Companion.i(AppActionHandler.TAG, "notifyUserOperateQueue: called, Send ack finished");
            return x.f38692a;
        L9:
            th = move-exception;
            ILogDepend.Companion.i(AppActionHandler.TAG, "notifyUserOperateQueue: called, Send ack finished");
            throw th;
        L11:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "notifyUserOperateQueue: called, Failed to send : " + e.getMessage());     // Catch: Throwable -> L9
            m<Boolean, String, x> r6 = this.$callback;     // Catch: Throwable -> L9
            if (r6 == null) goto L8;
            Boolean r4 = d.c.b.a.b.a(false);     // Catch: Throwable -> L9
            String r9 = e.getMessage();     // Catch: Throwable -> L9
            if (r9 != null) goto L17;
            r9 = "";
        L17:
            r6.invoke(r4, r9);     // Catch: Throwable -> L9
            goto L8
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$replyAskUserUploadByHttp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$replyAskUserUploadByHttp$1")
    static final class C11631 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ m<Boolean, String, x> $callback;
        final /* synthetic */ Map<?, ?> $ext;
        final /* synthetic */ String $messageId;
        final /* synthetic */ String $question;
        final /* synthetic */ String $replyContent;
        int label;

        C11631(m<? super Boolean, ? super String, x> r3, String r4, String r5, String r6, Map<?, ?> r7, d<? super C11631> r8) {
            m<Boolean, String, x> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            Map<?, ?> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
            this.$callback = r9;
            this.$messageId = r4;
            this.$question = r5;
            this.$replyContent = r6;
            this.$ext = r10;
            super(1, r11);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r10) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11631(this.$callback, this.$messageId, this.$question, this.$replyContent, this.$ext, r8), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11631) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11631.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            b.a();
            if (this.label != 0) goto L25;
            o.a(r10);
            IFlowNetworkIDL r2 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Throwable -> L10 Exception -> L12
            if (r2 == null) goto L8;
            String r3 = this.$messageId;     // Catch: Throwable -> L10 Exception -> L12
            String r4 = this.$question;     // Catch: Throwable -> L10 Exception -> L12
            String r5 = this.$replyContent;     // Catch: Throwable -> L10 Exception -> L12
            Map<?, ?> r6 = this.$ext;     // Catch: Throwable -> L10 Exception -> L12
            final m<Boolean, String, x> r11 = this.$callback;     // Catch: Throwable -> L10 Exception -> L12
            r2.sendReplyAskUserByHttp(r3, r4, r5, r6, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$replyAskUserUploadByHttp$1$1$1(r11), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10 Exception -> L12
        L8:
            ILogDepend.Companion r12 = ILogDepend.Companion;
            StringBuilder r7 = new StringBuilder();
        L9:
            r12.i(AppActionHandler.TAG, r7.append("replyAskUserUploadByHttp: called, Send ack finished for messageId: ").append(this.$messageId).toString());
            return x.f38692a;
        L10:
            th = move-exception;
            ILogDepend.Companion.i(AppActionHandler.TAG, "replyAskUserUploadByHttp: called, Send ack finished for messageId: " + this.$messageId);
            throw th;
        L12:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "replyAskUserUploadByHttp: called, Failed to send app action: " + e.getMessage());     // Catch: Throwable -> L10
            m<Boolean, String, x> r8 = this.$callback;     // Catch: Throwable -> L10
            if (r8 == null) goto L19;
            Boolean r9 = d.c.b.a.b.a(false);     // Catch: Throwable -> L10
            String r13 = e.getMessage();     // Catch: Throwable -> L10
            if (r13 != null) goto L18;
            r13 = "";
        L18:
            r8.invoke(r9, r13);     // Catch: Throwable -> L10
        L19:
            r12 = ILogDepend.Companion;
            r7 = new StringBuilder();
            goto L9
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendAppAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {196}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$sendAppAction$1")
    static final class C11641 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ m<Boolean, String, x> $callback;
        final /* synthetic */ Map<String, String> $frontierHeaders;
        final /* synthetic */ OPushEvent $pushEvent;
        int label;

        C11641(OPushEvent r3, Map<String, String> r4, m<? super Boolean, ? super String, x> r5, d<? super C11641> r6) {
            Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            m<Boolean, String, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$pushEvent = r3;
            this.$frontierHeaders = r7;
            this.$callback = r8;
            super(1, r9);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11641(this.$pushEvent, this.$frontierHeaders, this.$callback, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11641) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11641.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = b.a();
            int r1 = this.label;
            Long r4 = null;
            boolean r5 = true;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            o.a(r12);     // Catch: Throwable -> L7 Exception -> L9
        L17:
            d.m r13 = (d.m) ZeusTransformUtils.preCheckCast(r12, d.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9
            boolean r2 = ((Boolean) ZeusTransformUtils.preCheckCast(r13.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L7 Exception -> L9
            String r14 = (String) ZeusTransformUtils.preCheckCast(r13.d(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9
            m<Boolean, String, x> r3 = this.$callback;     // Catch: Throwable -> L7 Exception -> L9
            if (r3 == null) goto L23;
            if (r2 == true) goto L22;
            r5 = false;
        L22:
            r3.invoke(d.c.b.a.b.a(r5), r14);     // Catch: Throwable -> L7 Exception -> L9
        L23:
            OAppAction r11 = this.$pushEvent.getAction();
            if (r11 == null) goto L26;
            r4 = d.c.b.a.b.a(r11.getMessageId());
        L26:
            ILogDepend.Companion r15 = ILogDepend.Companion;
            StringBuilder r16 = new StringBuilder();
        L37:
            r15.d(AppActionHandler.TAG, r16.append("sendAppAction: called, Send ack finished for messageId: ").append(r4).toString());
            return x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            o.a(r12);
            String r17 = AppActionHandler.access$getGson$p().toJson(this.$pushEvent);     // Catch: Throwable -> L7 Exception -> L9
            d.h.b.o.c(r17, "toJson(...)");     // Catch: Throwable -> L7 Exception -> L9
            byte[] r18 = r17.getBytes(d.o.d.f38623b);     // Catch: Throwable -> L7 Exception -> L9
            d.h.b.o.c(r18, "getBytes(...)");     // Catch: Throwable -> L7 Exception -> L9
            AppActionHandler r6 = AppActionHandler.INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
            Map<String, String> r8 = this.$frontierHeaders;     // Catch: Throwable -> L7 Exception -> L9
            d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9
            this.label = 1;     // Catch: Throwable -> L7 Exception -> L9
            r12 = AppActionHandler.access$sendPayloadWithRetry(r6, r18, r8, 2, r10);     // Catch: Throwable -> L7 Exception -> L9
            if (r12 != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "sendAppAction: called, Failed to send app action: " + e.getMessage());     // Catch: Throwable -> L7
            String r19 = e.getMessage();     // Catch: Throwable -> L7
            if (r19 != null) goto L30;
            r19 = "";
        L30:
            m<Boolean, String, x> r7 = this.$callback;     // Catch: Throwable -> L7
            if (r7 == null) goto L33;
            r7.invoke(d.c.b.a.b.a(false), r19);     // Catch: Throwable -> L7
        L33:
            OAppAction r110 = this.$pushEvent.getAction();
            if (r110 == null) goto L36;
            r4 = d.c.b.a.b.a(r110.getMessageId());
        L36:
            r15 = ILogDepend.Companion;
            r16 = new StringBuilder();
        L7:
            th = move-exception;
            OAppAction r111 = this.$pushEvent.getAction();
            if (r111 == null) goto L42;
            r4 = d.c.b.a.b.a(r111.getMessageId());
        L42:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppAction: called, Send ack finished for messageId: " + r4);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendAppActionForAsyncNotifyByHttp$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$sendAppActionForAsyncNotifyByHttp$2")
    static final class AnonymousClass2 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ q<Boolean, String, Map<String, String>, x> $callback;
        final /* synthetic */ boolean $isNeedRetry;
        final /* synthetic */ List<OPushEvent> $pushEventList;
        int label;

        AnonymousClass2(q<? super Boolean, ? super String, ? super Map<String, String>, x> r3, List<OPushEvent> r4, boolean r5, d<? super AnonymousClass2> r6) {
            q<Boolean, String, Map<String, String>, x> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
            List<OPushEvent> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$callback = r7;
            this.$pushEventList = r8;
            this.$isNeedRetry = r5;
            super(1, r9);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$callback, this.$pushEventList, this.$isNeedRetry, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            b.a();
            if (this.label != 0) goto L49;
            o.a(r10);
            IFlowNetworkIDL r4 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Throwable -> L20 Exception -> L22
            if (r4 == null) goto L12;
            List<OPushEvent> r5 = this.$pushEventList;     // Catch: Throwable -> L20 Exception -> L22
            boolean r6 = this.$isNeedRetry;     // Catch: Throwable -> L20 Exception -> L22
            final q<Boolean, String, Map<String, String>, x> r7 = this.$callback;     // Catch: Throwable -> L20 Exception -> L22
            if (r6 == false) goto L10;
            boolean r8 = true;
        L11:
            r4.sendIntentResultForAsyncNotifyByHttp(r5, r8, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$sendAppActionForAsyncNotifyByHttp$2$1$1(r7), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20 Exception -> L22
        L10:
            r8 = false;
        L12:
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$pushEventList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L14:
            if (r9.hasNext() == false) goto L38;
            OAppAction r11 = ((OPushEvent) ZeusTransformUtils.preCheckCast(r9.next(), OPushEvent.class, "com.obric.aiagent.plugin")).getAction();
            if (r11 == null) goto L18;
            Long r12 = d.c.b.a.b.a(r11.getMessageId());
        L19:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppActionForAsyncNotifyByHttp: called, Send ack finished for messageId: " + r12);
            goto L14
        L18:
            r12 = null;
        L38:
            return x.f38692a;
        L20:
            th = move-exception;
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$pushEventList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L41:
            if (r13.hasNext() == false) goto L47;
            OAppAction r14 = ((OPushEvent) ZeusTransformUtils.preCheckCast(r13.next(), OPushEvent.class, "com.obric.aiagent.plugin")).getAction();
            if (r14 == null) goto L45;
            Long r15 = d.c.b.a.b.a(r14.getMessageId());
        L46:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppActionForAsyncNotifyByHttp: called, Send ack finished for messageId: " + r15);
            goto L41
        L45:
            r15 = null;
            goto L46
        L47:
            throw th;
        L22:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "sendAppActionForAsyncNotifyByHttp: called, Failed to send app action: " + e.getMessage());     // Catch: Throwable -> L20
            String r16 = e.getMessage();     // Catch: Throwable -> L20
            if (r16 != null) goto L26;
            r16 = "";
        L26:
            q<Boolean, String, Map<String, String>, x> r17 = this.$callback;     // Catch: Throwable -> L20
            if (r17 == null) goto L29;
            r17.invoke(d.c.b.a.b.a(false), r16, ao.b());     // Catch: Throwable -> L20
        L29:
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$pushEventList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L31:
            if (r18.hasNext() == false) goto L38;
            OAppAction r19 = ((OPushEvent) ZeusTransformUtils.preCheckCast(r18.next(), OPushEvent.class, "com.obric.aiagent.plugin")).getAction();
            if (r19 == null) goto L35;
            Long r110 = d.c.b.a.b.a(r19.getMessageId());
        L36:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppActionForAsyncNotifyByHttp: called, Send ack finished for messageId: " + r110);
            goto L31
        L35:
            r110 = null;
            goto L36
        L49:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendAppActionForCompensationByHttp$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$sendAppActionForCompensationByHttp$2")
    static final class C11652 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ q<Boolean, String, Map<String, String>, x> $callback;
        final /* synthetic */ boolean $isNeedRetry;
        final /* synthetic */ List<OPushEvent> $pushEventList;
        int label;

        C11652(q<? super Boolean, ? super String, ? super Map<String, String>, x> r3, List<OPushEvent> r4, boolean r5, d<? super C11652> r6) {
            q<Boolean, String, Map<String, String>, x> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
            List<OPushEvent> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$callback = r7;
            this.$pushEventList = r8;
            this.$isNeedRetry = r5;
            super(1, r9);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11652(this.$callback, this.$pushEventList, this.$isNeedRetry, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11652) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11652.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            b.a();
            if (this.label != 0) goto L49;
            o.a(r10);
            IFlowNetworkIDL r4 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Throwable -> L20 Exception -> L22
            if (r4 == null) goto L12;
            List<OPushEvent> r5 = this.$pushEventList;     // Catch: Throwable -> L20 Exception -> L22
            boolean r6 = this.$isNeedRetry;     // Catch: Throwable -> L20 Exception -> L22
            final q<Boolean, String, Map<String, String>, x> r7 = this.$callback;     // Catch: Throwable -> L20 Exception -> L22
            if (r6 == false) goto L10;
            boolean r8 = true;
        L11:
            r4.sendIntentResultForCompensationByHttp(r5, r8, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$sendAppActionForCompensationByHttp$2$1$1(r7), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20 Exception -> L22
        L10:
            r8 = false;
        L12:
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$pushEventList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L14:
            if (r9.hasNext() == false) goto L38;
            OAppAction r11 = ((OPushEvent) ZeusTransformUtils.preCheckCast(r9.next(), OPushEvent.class, "com.obric.aiagent.plugin")).getAction();
            if (r11 == null) goto L18;
            Long r12 = d.c.b.a.b.a(r11.getMessageId());
        L19:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppActionForCompensationByHttp: called, Send ack finished for messageId: " + r12);
            goto L14
        L18:
            r12 = null;
        L38:
            return x.f38692a;
        L20:
            th = move-exception;
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$pushEventList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L41:
            if (r13.hasNext() == false) goto L47;
            OAppAction r14 = ((OPushEvent) ZeusTransformUtils.preCheckCast(r13.next(), OPushEvent.class, "com.obric.aiagent.plugin")).getAction();
            if (r14 == null) goto L45;
            Long r15 = d.c.b.a.b.a(r14.getMessageId());
        L46:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppActionForCompensationByHttp: called, Send ack finished for messageId: " + r15);
            goto L41
        L45:
            r15 = null;
            goto L46
        L47:
            throw th;
        L22:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "sendAppActionForCompensationByHttp: called, Failed to send app action: " + e.getMessage());     // Catch: Throwable -> L20
            String r16 = e.getMessage();     // Catch: Throwable -> L20
            if (r16 != null) goto L26;
            r16 = "";
        L26:
            q<Boolean, String, Map<String, String>, x> r17 = this.$callback;     // Catch: Throwable -> L20
            if (r17 == null) goto L29;
            r17.invoke(d.c.b.a.b.a(false), r16, ao.b());     // Catch: Throwable -> L20
        L29:
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(this.$pushEventList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L31:
            if (r18.hasNext() == false) goto L38;
            OAppAction r19 = ((OPushEvent) ZeusTransformUtils.preCheckCast(r18.next(), OPushEvent.class, "com.obric.aiagent.plugin")).getAction();
            if (r19 == null) goto L35;
            Long r110 = d.c.b.a.b.a(r19.getMessageId());
        L36:
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendAppActionForCompensationByHttp: called, Send ack finished for messageId: " + r110);
            goto L31
        L35:
            r110 = null;
            goto L36
        L49:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendNormalRouterByHttp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$sendNormalRouterByHttp$1")
    static final class C11661 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ m<Boolean, String, x> $callback;
        final /* synthetic */ String $passThrough;
        final /* synthetic */ String $scene;
        int label;

        C11661(m<? super Boolean, ? super String, x> r3, String r4, String r5, d<? super C11661> r6) {
            m<Boolean, String, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$callback = r7;
            this.$scene = r4;
            this.$passThrough = r5;
            super(1, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11661(this.$callback, this.$scene, this.$passThrough, r6), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11661) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11661.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            b.a();
            if (this.label != 0) goto L25;
            o.a(r8);
            IFlowNetworkIDL r9 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Throwable -> L10 Exception -> L12
            if (r9 == null) goto L8;
            String r2 = this.$scene;     // Catch: Throwable -> L10 Exception -> L12
            String r3 = this.$passThrough;     // Catch: Throwable -> L10 Exception -> L12
            final m<Boolean, String, x> r4 = this.$callback;     // Catch: Throwable -> L10 Exception -> L12
            r9.sendNormalRouterByHttp(r2, r3, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$sendNormalRouterByHttp$1$1$1(r4), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10 Exception -> L12
        L8:
            ILogDepend.Companion r10 = ILogDepend.Companion;
            StringBuilder r5 = new StringBuilder();
        L9:
            r10.d(AppActionHandler.TAG, r5.append("sendNormalRouterByHttp: called, Send ack finished for scene: ").append(this.$scene).toString());
            return x.f38692a;
        L12:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "sendNormalRouterByHttp: called, Failed to send app action: " + e.getMessage());     // Catch: Throwable -> L10
            m<Boolean, String, x> r6 = this.$callback;     // Catch: Throwable -> L10
            if (r6 == null) goto L19;
            Boolean r7 = d.c.b.a.b.a(false);     // Catch: Throwable -> L10
            String r11 = e.getMessage();     // Catch: Throwable -> L10
            if (r11 != null) goto L18;
            r11 = "";
        L18:
            r6.invoke(r7, r11);     // Catch: Throwable -> L10
        L19:
            r10 = ILogDepend.Companion;
            r5 = new StringBuilder();
        L10:
            th = move-exception;
            ILogDepend.Companion.d(AppActionHandler.TAG, "sendNormalRouterByHttp: called, Send ack finished for scene: " + this.$scene);
            throw th;
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendPayload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {143}, d = "sendPayload", e = "com.obric.funcall_impl.AppActionHandler")
    static final class C11671 extends d.c.b.a.d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AppActionHandler this$0;

        C11671(AppActionHandler r3, d<? super C11671> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return AppActionHandler.access$sendPayload(this.this$0, null, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendPayload$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {406}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$sendPayload$2")
    static final class C11682 extends l implements m<am, d<? super Boolean>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ byte[] $payload;
        Object L$0;
        Object L$1;
        int label;

        C11682(byte[] r3, Map<String, String> r4, d<? super C11682> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$payload = r3;
            this.$headers = r6;
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11682(this.$payload, this.$headers, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super Boolean> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super Boolean> r4) {
            return ((C11682) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11682.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.L$1, Map.class, "com.obric.aiagent.plugin");
            byte[] r7 = (byte[]) ZeusTransformUtils.preCheckCast(this.L$0, byte[].class, "com.obric.aiagent.plugin");
            o.a(r8);
        L13:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            byte[] r9 = this.$payload;
            Map<String, String> r3 = this.$headers;
            this.L$0 = r9;
            this.L$1 = r3;
            this.label = 1;
            kotlinx.coroutines.o r5 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")), 1);
            r5.e();
            final n r4 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
            AppActionHandler.access$sendByWsChannel(AppActionHandler.INSTANCE, r9, r3, (d.h.a.b) ZeusTransformUtils.preCheckCast(new AppActionHandler$sendPayload$2$1$1(r4), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r8 = r5.h();
            if (r8 != b.a()) goto L11;
            h.c((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        L11:
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$sendPayloadWithRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {163}, d = "sendPayloadWithRetry", e = "com.obric.funcall_impl.AppActionHandler")
    static final class C11691 extends d.c.b.a.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AppActionHandler this$0;

        C11691(AppActionHandler r3, d<? super C11691> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return AppActionHandler.access$sendPayloadWithRetry(this.this$0, null, null, 0, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$singleRun$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {410, 67}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$singleRun$1")
    static final class C11701 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ d.h.a.b<d<? super x>, Object> $block;
        Object L$0;
        Object L$1;
        int label;

        C11701(d.h.a.b<? super d<? super x>, ? extends Object> r3, d<? super C11701> r4) {
            d.h.a.b<d<? super x>, Object> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$block = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11701(this.$block, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11701) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11701.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            a r8 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.aiagent.plugin");
            o.a(r9);     // Catch: Throwable -> L9
        L21:
            x r10 = x.f38692a;     // Catch: Throwable -> L9
            r8.b(null);
            return x.f38692a;
        L9:
            Throwable th = th;
        L26:
            r8.b(null);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.h.a.b<d<? super x>, Object> r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(this.L$1, d.h.a.b.class, "com.obric.aiagent.plugin");
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.aiagent.plugin");
            o.a(r9);
            a r11 = r3;
        L28:
            this.L$0 = r11;     // Catch: Throwable -> L24
            this.L$1 = null;     // Catch: Throwable -> L24
            this.label = 2;     // Catch: Throwable -> L24
            if (r2.invoke(this) != r0) goto L20;
            return r0;
        L20:
            r8 = r11;
        L24:
            th = move-exception;
            a r7 = r11;
            th = th;
            r8 = r7;
            goto L26
        L14:
            o.a(r9);
            r11 = AppActionHandler.access$getMutex$p();
            r2 = this.$block;
            d<? super x> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.L$0 = r11;
            this.L$1 = r2;
            this.label = 1;
            if (r11.a(null, r4) != r0) goto L28;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.funcall_impl.AppActionHandler$uploadUserTakeOverByHttp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppActionHandler.kt */
    @f(b = "AppActionHandler.kt", c = {}, d = "invokeSuspend", e = "com.obric.funcall_impl.AppActionHandler$uploadUserTakeOverByHttp$1")
    static final class C11711 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ m<Boolean, String, x> $callback;
        final /* synthetic */ String $content;
        final /* synthetic */ Map<String, String> $ext;
        final /* synthetic */ String $id;
        final /* synthetic */ String $scene;
        final /* synthetic */ long $timeout;
        int label;

        C11711(m<? super Boolean, ? super String, x> r3, String r4, String r5, String r6, long r7, Map<String, String> r9, d<? super C11711> r10) {
            m<Boolean, String, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            d r12 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
            this.$callback = r8;
            this.$id = r4;
            this.$content = r5;
            this.$scene = r6;
            this.$timeout = r7;
            this.$ext = r11;
            super(1, r12);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r12) {
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11711(this.$callback, this.$id, this.$content, this.$scene, this.$timeout, this.$ext, r10), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11711) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11711.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            b.a();
            if (this.label != 0) goto L24;
            o.a(r12);
            IFlowNetworkIDL r2 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));     // Catch: Throwable -> L9 Exception -> L11
            if (r2 == null) goto L8;
            String r3 = this.$id;     // Catch: Throwable -> L9 Exception -> L11
            String r4 = this.$content;     // Catch: Throwable -> L9 Exception -> L11
            String r5 = this.$scene;     // Catch: Throwable -> L9 Exception -> L11
            long r6 = this.$timeout;     // Catch: Throwable -> L9 Exception -> L11
            Map<String, String> r8 = this.$ext;     // Catch: Throwable -> L9 Exception -> L11
            final m<Boolean, String, x> r13 = this.$callback;     // Catch: Throwable -> L9 Exception -> L11
            r2.uploadUserTakeOverByHttp(r3, r4, r5, r6, r8, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$uploadUserTakeOverByHttp$1$1$1(r13), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9 Exception -> L11
        L8:
            ILogDepend.Companion.i(AppActionHandler.TAG, "replyAskUserUploadByHttp: called, Send ack finished");
            return x.f38692a;
        L11:
            e = move-exception;
            ILogDepend.Companion.e(AppActionHandler.TAG, "uploadRouterByHttp: called, Failed to send : " + e.getMessage());     // Catch: Throwable -> L9
            m<Boolean, String, x> r11 = this.$callback;     // Catch: Throwable -> L9
            if (r11 == null) goto L8;
            Boolean r7 = d.c.b.a.b.a(false);     // Catch: Throwable -> L9
            String r14 = e.getMessage();     // Catch: Throwable -> L9
            if (r14 != null) goto L17;
            r14 = "";
        L17:
            r11.invoke(r7, r14);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            ILogDepend.Companion.i(AppActionHandler.TAG, "replyAskUserUploadByHttp: called, Send ack finished");
            throw th;
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Thread lambda$ussOuCtVGSDpOkizmPJ_h7abY84(Runnable r0) {
        return networkDispatcher$lambda$1(r0);
    }

    private AppActionHandler() {
    }

    public static final /* synthetic */ Gson access$getGson$p() {
        return gson;
    }

    public static final /* synthetic */ a access$getMutex$p() {
        return mutex;
    }

    public static final /* synthetic */ AppActionHandler$wsReceiveListener$1 access$getWsReceiveListener$p() {
        return wsReceiveListener;
    }

    public static final /* synthetic */ AppActionHandler$wsStatusListener$1 access$getWsStatusListener$p() {
        return wsStatusListener;
    }

    public static final /* synthetic */ void access$onReceivePushEvent(AppActionHandler r0, byte[] r1) {
        r0.onReceivePushEvent(r1);
    }

    public static final /* synthetic */ void access$sendByWsChannel(AppActionHandler r2, byte[] r3, Map r4, d.h.a.b r5) {
        r2.sendByWsChannel(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$sendPayload(AppActionHandler r2, byte[] r3, Map r4, d r5) {
        return r2.sendPayload(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$sendPayloadWithRetry(AppActionHandler r2, byte[] r3, Map r4, int r5, d r6) {
        return r2.sendPayloadWithRetry(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), r5, (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Map access$toStringMap(AppActionHandler r2, Map r3) {
        return r2.toStringMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.funcall_impl.AppActionHandler$wsStatusListener$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.obric.funcall_impl.AppActionHandler$wsReceiveListener$1] */
    static {
        INSTANCE = new AppActionHandler();
        gson = new Gson();
        mainScope = an.a();
        ioScope = an.a(bd.c().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")).plus((g) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new AppActionHandler$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.f38768a), CoroutineExceptionHandler.class, "com.obric.aiagent.plugin"), g.class, "com.obric.aiagent.plugin")));
        mutex = c.a(false, 1, null);
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$AppActionHandler$ussOuCtVGSDpOkizmPJ_h7abY84.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        networkDispatcher = br.a(r0);
        wsStatusListener = new AppActionHandler$wsStatusListener$1();
        wsReceiveListener = new AppActionHandler$wsReceiveListener$1();
    }

    private static final Thread networkDispatcher$lambda$1(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "AppAction#frontier_data_handler");
    }

    private final void singleRun(d.h.a.b<? super d<? super x>, ? extends Object> r8) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        i.a(ioScope, (g) ZeusTransformUtils.preCheckCast(networkDispatcher, g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C11701(r7, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void init() {
        ILogDepend.Companion.i(TAG, "init: called");
        i.a(mainScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final boolean isFrontierConnected() {
        IFlowFrontierIDL r2 = ad.a(aa.b(IFlowFrontierIDL.class));
        if (r2 == null) goto L8;
        if (r2.getState() != 1) goto L8;
        return true;
    L8:
        return false;
    }

    private final void onReceivePushEvent(byte[] r4) {
        ISecureLogDepend.Companion.i(TAG, "onReceivePushEvent: called, received payload: " + new String(r4, d.o.d.f38623b));
        OPushEvent r3 = com.obric.aiagent.assistant.idl.bean.a.a(r4);
        if (r3 == null) goto L20;
        ISecureLogDepend.Companion.i(TAG, "onReceivePushEvent: called, to pushEvent: " + r3);
        OAppAction r5 = r3.getAction();
        if (r5 == null) goto L21;
        final IntentAppAction r6 = com.obric.funcall_impl.a.a.a(r5);
        if (r6 == null) goto L22;
        ISecureLogDepend.Companion.i(TAG, "onReceivePushEvent: called, to intentAppAction: " + r6);
        ConcurrentHashMap<String, String> r7 = r6.getExt();
        if (r7 == null) goto L11;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_complex_task"), String.class, "com.obric.aiagent.plugin");
    L13:
        if (d.h.b.o.a(r8, "1") == false) goto L16;
        AppActionDispatcher.INSTANCE.notifyAppActionReceived(r6);
        return;
    L16:
        IFlowMessageIDL r9 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r9 == null) goto L23;
        r9.isMessageLocalInterrupted(String.valueOf(r6.getQuestionId()), (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.preCheckCast(new AppActionHandler$onReceivePushEvent$1$1$1(r6), IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    L23:
        return;
    L11:
        r8 = null;
        goto L13
    L22:
        return;
    L21:
        return;
    }

    static /* synthetic */ void sendByWsChannel$default(AppActionHandler r1, byte[] r2, Map r3, d.h.a.b r4, int r5, Object r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super Boolean, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r8 = null;
    L8:
        r1.sendByWsChannel(r2, r7, r8);
    }

    private final void sendByWsChannel(byte[] r4, Map<String, String> r5, d.h.a.b<? super Boolean, x> r6) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "sendByWsChannel: called, send payload: " + new String(r4, d.o.d.f38623b));
        if (r7 == null) goto L10;
        IFlowFrontierIDL r8 = ad.a(aa.b(IFlowFrontierIDL.class));
        if (r8 == null) goto L7;
        r8.sendData(SERVICE_ID, r4, r3);
        boolean r9 = true;
    L8:
        r7.invoke(Boolean.valueOf(r9));
        return;
    L7:
        r9 = false;
        goto L8
    }

    private final Object sendPayload(byte[] r7, Map<String, String> r8, d<? super Boolean> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C11671.class) == false) goto L7;
        C11671 r0 = (C11671) ZeusTransformUtils.preCheckCast(r11, C11671.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r12 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r6);
    L17:
        Boolean r13 = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L20;
        boolean r14 = r13.booleanValue();
    L22:
        return d.c.b.a.b.a(r14);
    L20:
        r14 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        m r15 = (m) ZeusTransformUtils.preCheckCast(new C11682(r7, r10, null), m.class, "com.obric.aiagent.plugin");
        r0.label = 1;
        r6 = dg.b(SEND_ACTION_TIMEOUT, r15, r0);
        if (r6 != r12) goto L17;
        return r12;
    L7:
        r0 = new C11671(this, r11);
        goto L8
    }

    static /* synthetic */ Object sendPayload$default(AppActionHandler r1, byte[] r2, Map r3, d r4, int r5, Object r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d<? super Boolean> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return r1.sendPayload(r2, r7, r8);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0092 -> B:28:0x0096). Please report as a decompilation issue!!! */
    private final Object sendPayloadWithRetry(byte[] r9, Map<String, String> r10, int r11, d<? super d.m<Boolean, String>> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C11691.class) == false) goto L7;
        C11691 r0 = (C11691) ZeusTransformUtils.preCheckCast(r14, C11691.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r15 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        int r16 = r0.I$2;
        int r17 = r0.I$1;
        r11 = r0.I$0;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(r0.L$1, Map.class, "com.obric.aiagent.plugin");
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r0.L$0, byte[].class, "com.obric.aiagent.plugin");
        o.a(r8);     // Catch: Throwable -> L14 Exception -> L16
    L29:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L32;
        ILogDepend.Companion.d(TAG, "sendPayloadWithRetry: called, Send ack succeeded on attempt " + (r16 + 1));     // Catch: Throwable -> L14 Exception -> L16
        return s.a(d.c.b.a.b.a(true), "");
    L32:
        r16 = r17 + 1;     // Catch: Throwable -> L14 Exception -> L16
        r13 = r3;
        byte[] r18 = r6;
    L21:
        if (r16 >= r11) goto L36;
        AppActionHandler r4 = INSTANCE;     // Catch: Throwable -> L14 Exception -> L16
        if (r4.isFrontierConnected() == false) goto L34;
        r0.L$0 = r18;     // Catch: Throwable -> L14 Exception -> L16
        r0.L$1 = r13;     // Catch: Throwable -> L14 Exception -> L16
        r0.I$0 = r11;     // Catch: Throwable -> L14 Exception -> L16
        r0.I$1 = r16;     // Catch: Throwable -> L14 Exception -> L16
        r0.I$2 = r16;     // Catch: Throwable -> L14 Exception -> L16
        r0.label = 1;     // Catch: Throwable -> L14 Exception -> L16
        Object r5 = r4.sendPayload(r18, r13, r0);     // Catch: Throwable -> L14 Exception -> L16
        if (r5 != r15) goto L27;
        return r15;
    L27:
        r6 = r18;
        r8 = r5;
        r3 = r13;
        r17 = r16;
        goto L29
    L34:
        throw new IllegalStateException("Frontier disconnected");     // Catch: Throwable -> L14 Exception -> L16
    L36:
        throw new IllegalStateException("Send ack failed after " + r11 + " retries");     // Catch: Throwable -> L14 Exception -> L16
    L16:
        e = move-exception;
        String r19 = "sendPayloadWithRetry: called, Send ack failed: " + e.getMessage();     // Catch: Throwable -> L14
        ILogDepend.Companion.e(TAG, r19);     // Catch: Throwable -> L14
        return s.a(d.c.b.a.b.a(false), r19);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        o.a(r8);
        r18 = r9;
        r16 = 0;
    L14:
        th = move-exception;
        throw th;
    L7:
        r0 = new C11691(this, r14);
        goto L8
    }

    static /* synthetic */ Object sendPayloadWithRetry$default(AppActionHandler r1, byte[] r2, Map r3, int r4, d r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d<? super d.m<Boolean, String>> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 2;
    L9:
        return r1.sendPayloadWithRetry(r2, r8, r4, r9);
    }

    public final void sendAppAction(AppActionRequest r10, m<? super Boolean, ? super String, x> r11) {
        m r12 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, Ext.KEY_REQUEST);
        ISecureLogDepend.Companion.i(TAG, "sendAppAction: called, request = " + r10);
        boolean r4 = true;
        OPushEvent r0 = new OPushEvent(null, com.obric.funcall_impl.a.a.a(r10), 1, null);
        ConcurrentHashMap<String, String> r2 = r10.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("has_screenshot"), String.class, "com.obric.aiagent.plugin");
    L7:
        if (d.h.b.o.a(r3, "1") == false) goto L9;
    L12:
        if (r4 == false) goto L14;
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r5.put("message_id", String.valueOf(r10.getMessageId()));
        r5.put("has_screenshot", "1");
    L15:
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11641(r0, r5, r12, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        r5 = null;
        goto L15
    L9:
        if (r10.getScreenshot() != null) goto L12;
        r4 = false;
        goto L12
    L5:
        r3 = null;
        goto L7
    }

    public final void cacheScreenshot(Bitmap r2, Map<String, String> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "bitmap");
        d.h.b.o.e(r1, "headers");
        IFlowFrontierIDL r4 = ad.a(aa.b(IFlowFrontierIDL.class));     // Catch: Exception -> L7
        if (r4 == null) goto L12;
        r4.cacheScreenshot(SERVICE_ID, r2, r1);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "cacheScreenshot: called, Failed to cache screenshot: " + e.getMessage());
    }

    public static /* synthetic */ void sendAppActionForCompensationByHttp$default(AppActionHandler r1, List r2, boolean r3, q r4, int r5, Object r6) {
        List<AppActionRequest> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        q<? super Boolean, ? super String, ? super Map<String, String>, x> r8 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.sendAppActionForCompensationByHttp(r7, r3, r8);
    }

    public final void sendAppActionForCompensationByHttp(List<AppActionRequest> r7, boolean r8, q<? super Boolean, ? super String, ? super Map<String, String>, x> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        q r11 = (q) ZeusTransformUtils.wrapperContextForParams(r9, q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "requests");
        ILogDepend.Companion.d(TAG, "sendAppActionForCompensationByHttp: called, IFlowNetworkIDL::class.getIPC(): " + com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class)) + ", requests = " + r10.size());
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r0.add(new OPushEvent(null, com.obric.funcall_impl.a.a.a((AppActionRequest) ZeusTransformUtils.preCheckCast(r12.next(), AppActionRequest.class, "com.obric.aiagent.plugin")), 1, null));
        goto L4
    L6:
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11652(r11, r0, r8, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void sendAppActionForAsyncNotifyByHttp$default(AppActionHandler r1, List r2, boolean r3, q r4, int r5, Object r6) {
        List<AppActionRequest> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        q<? super Boolean, ? super String, ? super Map<String, String>, x> r8 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.sendAppActionForAsyncNotifyByHttp(r7, r3, r8);
    }

    public final void sendAppActionForAsyncNotifyByHttp(List<AppActionRequest> r7, boolean r8, q<? super Boolean, ? super String, ? super Map<String, String>, x> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        q r11 = (q) ZeusTransformUtils.wrapperContextForParams(r9, q.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "requests");
        ILogDepend.Companion.d(TAG, "sendAppActionForAsyncNotifyByHttp: called, IFlowNetworkIDL::class.getIPC(): " + com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class)) + ", requests = " + r10.size());
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r0.add(new OPushEvent(null, com.obric.funcall_impl.a.a.a((AppActionRequest) ZeusTransformUtils.preCheckCast(r12.next(), AppActionRequest.class, "com.obric.aiagent.plugin")), 1, null));
        goto L4
    L6:
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r11, r0, r8, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ void sendNormalRouterByHttp$default(AppActionHandler r1, String r2, String r3, boolean r4, m r5, int r6, Object r7) {
        m<? super Boolean, ? super String, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r1.sendNormalRouterByHttp(r2, r3, r4, r8);
    }

    public final void sendNormalRouterByHttp(String r4, String r5, boolean r6, m<? super Boolean, ? super String, x> r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SCENE);
        d.h.b.o.e(r5, "passThrough");
        ILogDepend.Companion.d(TAG, "sendNormalRouterByHttp: called, IFlowNetworkIDL::class.getIPC(): " + com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class)) + ", scene = " + r4);
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11661(r8, r4, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void replyAskUserUploadByHttp(String r10, String r11, String r12, Map<?, ?> r13, m<? super Boolean, ? super String, x> r14) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r14, m.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(TAG, "replyAskUserUploadByHttp: called, IFlowNetworkIDL::class.getIPC(): " + com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class)) + ", messageId = " + r10);
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11631(r3, r10, r11, r12, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void uploadUserTakeOverByHttp(String r12, String r13, String r14, long r15, Map<String, String> r17, m<? super Boolean, ? super String, x> r18) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r18, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r14, DBHelper.BATTERY_COL_SCENE);
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11711(r3, r12, r13, r14, r15, r9, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final void notifyUserOperateQueue(String r4, m<? super Boolean, ? super String, x> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "data");
        singleRun((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11621(r6, r4, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final Map<String, String> toStringMap(Map<?, ?> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = ao.b();
    L5:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L7:
        if (r8.hasNext() == false) goto L21;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        d.m r9 = null;
        if (r2 == null) goto L18;
        String r10 = r2.toString();
        if (r10 == null) goto L18;
        if (r3 == null) goto L18;
        String r11 = r3.toString();
        if (r11 == null) goto L18;
        r9 = s.a(r10, r11);
    L18:
        if (r9 == null) goto L7;
        r7.add(r9);
        goto L7
    L21:
        return ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }
}
