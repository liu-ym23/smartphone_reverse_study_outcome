package com.obric.agent.trace.omni;

import com.google.gson.Gson;
import com.obric.agent.w;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniMessageObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements com.obric.agent.im.d {
    private static final String TAG = "OmniMessageObserver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15645a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicReference<String> f15646d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f15647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, String>, Boolean, x> f15648c;

    /* JADX INFO: compiled from: OmniMessageObserver.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniMessageObserver.kt */
    @d.c.b.a.f(b = "OmniMessageObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniMessageObserver$onReceiveMessage$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f15650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15653e;

        b(i r3, String r4, String r5, Map<String, String> r6, d.c.d<? super b> r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15650b = r3;
            this.f15651c = r4;
            this.f15652d = r5;
            this.f15653e = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f15650b, this.f15651c, this.f15652d, this.f15653e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15649a != 0) goto L7;
            d.o.a(r3);
            i.a(this.f15650b, this.f15651c, this.f15652d, this.f15653e);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniMessageObserver.kt */
    @d.c.b.a.f(b = "OmniMessageObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniMessageObserver$onReceiveMessage$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f15655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15658e;
        final /* synthetic */ IMMessage f;

        c(i r3, String r4, String r5, Map<String, String> r6, IMMessage r7, d.c.d<? super c> r8) {
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15655b = r3;
            this.f15656c = r4;
            this.f15657d = r5;
            this.f15658e = r9;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f15655b, this.f15656c, this.f15657d, this.f15658e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15654a != 0) goto L7;
            d.o.a(r4);
            i.a(this.f15655b, this.f15656c, this.f15657d, this.f15658e, this.f);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniMessageObserver.kt */
    @d.c.b.a.f(b = "OmniMessageObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniMessageObserver$onSendMessage$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f15660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15662d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15663e;
        final /* synthetic */ long f;
        final /* synthetic */ n g;

        d(i r3, String r4, String r5, Map<String, String> r6, long r7, n r9, d.c.d<? super d> r10) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15660b = r3;
            this.f15661c = r4;
            this.f15662d = r5;
            this.f15663e = r8;
            this.f = r7;
            this.g = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f15660b, this.f15661c, this.f15662d, this.f15663e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f15659a != 0) goto L7;
            d.o.a(r8);
            i.a(this.f15660b, this.f15661c, this.f15662d, this.f15663e, this.f);
            p.f15699a.a(this.g);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniMessageObserver.kt */
    @d.c.b.a.f(b = "OmniMessageObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniMessageObserver$onUpdateMessage$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f15665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15668e;

        e(i r3, String r4, String r5, Map<String, String> r6, d.c.d<? super e> r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15665b = r3;
            this.f15666c = r4;
            this.f15667d = r5;
            this.f15668e = r8;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15665b, this.f15666c, this.f15667d, this.f15668e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15664a != 0) goto L7;
            d.o.a(r3);
            i.a(this.f15665b, this.f15666c, this.f15667d, this.f15668e);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniMessageObserver.kt */
    @d.c.b.a.f(b = "OmniMessageObserver.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.omni.OmniMessageObserver$onUpdateMessage$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f15670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15673e;
        final /* synthetic */ IMMessage f;

        f(i r3, String r4, String r5, Map<String, String> r6, IMMessage r7, d.c.d<? super f> r8) {
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15670b = r3;
            this.f15671c = r4;
            this.f15672d = r5;
            this.f15673e = r9;
            this.f = r7;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f15670b, this.f15671c, this.f15672d, this.f15673e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15669a != 0) goto L7;
            d.o.a(r4);
            i.a(this.f15670b, this.f15671c, this.f15672d, this.f15673e, this.f);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Map lambda$CrfPOMVGhdMwr9Y8rC5IK78t9Uw(Map r0, com.obric.agent.trace.omni.a r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Map lambda$XnxrkFDS3Q1YJyuXGp58qVovy5M(String r0, Map r1, com.obric.agent.trace.omni.a r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ZM1AThg60eHiIPLRz3D9Gmy-sWU, reason: not valid java name */
    public static /* synthetic */ Map m108lambda$ZM1AThg60eHiIPLRz3D9GmysWU(String r0, long r1, Map r3, com.obric.agent.trace.omni.a r4) {
        return a(r0, r1, r3, r4);
    }

    @Override // com.obric.agent.im.d
    public void onRegenMessage(IMMessage r1) {
        d.h.b.o.e(r1, "message");
    }

    public i(am r3, d.h.a.r<? super String, ? super com.obric.agent.trace.omni.a, ? super Map<String, String>, ? super Boolean, x> r4) {
        am r5 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        d.h.a.r<String, com.obric.agent.trace.omni.a, Map<String, String>, Boolean, x> r6 = (d.h.a.r) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.r.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "scope");
        d.h.b.o.e(r6, "doReportWithCommonParams");
        this.f15647b = r5;
        this.f15648c = r6;
    }

    public static final /* synthetic */ void a(i r2, String r3, String r4, Map r5) {
        r2.a(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(i r6, String r7, String r8, Map r9, long r10) {
        r6.a(r7, r8, (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin"), r10);
    }

    public static final /* synthetic */ void a(i r2, String r3, String r4, Map r5, IMMessage r6) {
        r2.a(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.agent.im.d
    public void onInsertMessageList(List<IMMessage> r3) {
        com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    static {
        f15645a = new a(null);
        f15646d = new AtomicReference(null);
    }

    @Override // com.obric.agent.im.d
    public void onSendMessage(IMMessage r17) {
        d.h.b.o.e(r17, "message");
        String r0 = r17.getLocalMessageId();
        int r2 = r17.getMessageStatusLocal();
        String r5 = r17.getMessageId();
        String r6 = r17.getReplyId();
        Map<String, String> r3 = r17.getExt();
        if (r3 == null) goto L5;
        Map<String, String> r4 = ao.d(r3);
    L6:
        Map<String, String> r7 = r4;
        long r8 = System.currentTimeMillis();
        ISecureLogDepend.Companion.i(TAG, "onSendMessage " + r0 + ", " + r2);
        o r1 = o.f15698a;
        boolean r9 = true;
        if (r2 != 11) goto L9;
        boolean r11 = true;
    L10:
        n r10 = r1.a(r11, r5, r17.getUserType(), r7);
        if (r2 != 11) goto L21;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L15;
    L18:
        if (r9 == true) goto L22;
        kotlinx.coroutines.i.a(this.f15647b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, r5, r6, r7, r8, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L22:
        return;
    L15:
        if (r12.length() == 0) goto L18;
        r9 = false;
        goto L18
    L21:
        return;
    L9:
        r11 = false;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.agent.im.d
    public void onReceiveMessage(IMMessage r15) {
        d.h.b.o.e(r15, "message");
        String r3 = r15.getReplyId();
        String r2 = r15.getMessageId();
        int r0 = r15.getMessageStatusLocal();
        Map<String, String> r4 = r15.getExt();
        if (r4 == null) goto L5;
        Map r5 = ao.d(r4);
    L6:
        if (r3 == null) goto L24;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L17;
        return;
    L17:
        if (r0 != 20) goto L19;
        kotlinx.coroutines.i.a(this.f15647b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r2, r3, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L19:
        if (r0 != 21) goto L27;
        kotlinx.coroutines.i.a(this.f15647b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r2, r3, r5, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L27:
        return;
    L10:
        if (r6.length() == 0) goto L13;
        r7 = false;
        goto L14
    L24:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.obric.agent.im.d
    public void onUpdateMessage(IMMessage r15) {
        d.h.b.o.e(r15, "message");
        String r3 = r15.getReplyId();
        String r2 = r15.getMessageId();
        int r0 = r15.getMessageStatusLocal();
        Map<String, String> r4 = r15.getExt();
        if (r4 == null) goto L5;
        Map r5 = ao.d(r4);
    L6:
        if (r3 == null) goto L24;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L17;
        return;
    L17:
        if (r0 != 20) goto L19;
        kotlinx.coroutines.i.a(this.f15647b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, r2, r3, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L19:
        if (r0 != 21) goto L27;
        kotlinx.coroutines.i.a(this.f15647b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r2, r3, r5, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L27:
        return;
    L10:
        if (r6.length() == 0) goto L13;
        r7 = false;
        goto L14
    L24:
        return;
    L5:
        r5 = null;
        goto L6
    }

    private final void a(String r5, String r6, Map<String, String> r7, long r8) {
        Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "onSendMessageSuccess " + r5 + ", " + r6 + ", " + new Gson().toJson(r9));
        a(r5, r9, r8);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (d.h.b.o.a(r6, r5) == true) goto L15;
        a(r6, r9, r8);
        return;
    L15:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void a(final String r2, Map<String, String> r3, final long r4) {
        final Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        k.f15686a.a(r2, new $$Lambda$i$ZM1AThg60eHiIPLRz3D9GmysWU(r2, r4, r1));
    }

    private static final Map a(String r3, long r4, Map r6, com.obric.agent.trace.omni.a r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L6:
        r0.put("doubao_message_id", r3);
    L8:
        if (r7 != null) goto L10;
    L11:
        r0.put("message_send_success", Long.valueOf(r4));
    L12:
        r0.putAll(h.f15634a.a(r7, r8));
        return r0;
    L10:
        if (r7.b().containsKey("message_send_success") == true) goto L12;
    L5:
        if (r7.b().containsKey("doubao_message_id") == true) goto L8;
        goto L6
    }

    private final void a(String r5, String r6, Map<String, String> r7) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion r8 = ISecureLogDepend.Companion;
        StringBuilder r9 = new StringBuilder().append("onMsgReceiving ").append(r5).append(", ").append(r6).append(", ");
        String r10 = null;
        if (r4 == null) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L6:
        StringBuilder r11 = r9.append(r2).append(", ");
        if (r4 == null) goto L9;
        r10 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L9:
        r8.i(TAG, r11.append(r10).toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void a(String r6, String r7, Map<String, String> r8, IMMessage r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion r0 = ISecureLogDepend.Companion;
        StringBuilder r2 = new StringBuilder().append("onMsgReceived ").append(r6).append(", ").append(r7).append(", ");
        if (r10 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L6:
        r0.i(TAG, r2.append(r1).toString());
        a(r6, r10);
        String r11 = a(r10);
        if (a(r7, r11) == false) goto L9;
        return;
    L9:
        b(r7, r10);
        a(r7, r10, r9, r11);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void a(String r5, Map<String, String> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.get("expose_scene"), String.class, "com.obric.aiagent.plugin");
    L7:
        if (d.h.b.o.a(r7, "review-exposeResponse-refuse_answer_cn") == true) goto L9;
        return;
    L9:
        ISecureLogDepend.Companion.i(TAG, "reportDoubaoRefuseExposeIfNeeded " + r5 + ", " + new Gson().toJson(r4));
        AtomicReference<String> r8 = f15646d;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r8.get(), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r1, r5) == false) goto L13;
        ISecureLogDepend.Companion.i(TAG, "query_expose_doubao_refuse ignored: duplicate " + r5);
        return;
    L13:
        r8.compareAndSet(r1, r5);
        JSONObject r9 = new JSONObject();
        r9.put("doubao_message_id", r5);
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        r9.put("log_id", r10);
        ISecureLogDepend.Companion.i(TAG, "report query_expose_doubao_refuse: " + r9);
        IAppLog r11 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        r11.reportToFlow("query_expose_doubao_refuse", r9);
        return;
    L20:
        return;
    L5:
        r7 = null;
        goto L7
    }

    private final void b(String r7, Map<String, String> r8) {
        final Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        ISecureLogDepend.Companion.w(TAG, "handleMsgReceive ignored: replyId is blank");
        return;
    L13:
        ISecureLogDepend.Companion.i(TAG, "handleMsgReceive " + r7 + ", " + new Gson().toJson(r9));
        if (r9 == null) goto L16;
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r9.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L17:
        if (r2 != null) goto L19;
    L24:
        k.f15686a.a(r7, new $$Lambda$i$CrfPOMVGhdMwr9Y8rC5IK78t9Uw(r9));
        return;
    L19:
        if (k.f15686a.a(r7, "instruction_id") == true) goto L24;
        ISecureLogDepend.Companion.i(TAG, "handleMsgReceive, on first msg with oTaskId");
        com.obric.agent.trace.omni.a r3 = k.f15686a.a(r7, new $$Lambda$i$XnxrkFDS3Q1YJyuXGp58qVovy5M(r2, r9));
        if (r3 == null) goto L23;
        this.f15648c.a("obric_omni_instruction_start", r3, ao.b(), false);
        goto L24
    L23:
        ISecureLogDepend.Companion.w(TAG, "handleMsgReceive ignored: snapshot not found");
        goto L24
    L16:
        r2 = null;
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private static final Map a(String r2, Map r3, com.obric.agent.trace.omni.a r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.m[] r6 = new d.m[2];
        r6[0] = d.s.a("instruction_id", r2);
        if (r5 == null) goto L5;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
    L6:
        r6[1] = d.s.a("log_id", r7);
        return ao.a(r6);
    L5:
        r7 = null;
        goto L6
    }

    private static final Map a(Map r10, com.obric.agent.trace.omni.a r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L99;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r11.b().get("instruction_type"), List.class, "com.obric.aiagent.plugin");
        Object r4 = null;
        if (r2 == null) goto L12;
        Object r3 = d.a.p.n(r2);
        if (r3 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L12;
    L13:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L25;
        if (r12 == null) goto L25;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r12.get("o_omni_instruction_type"), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L25;
        r0.put("instruction_type", r7);
    L25:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r11.b().get("instruction_entry"), List.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L33;
        Object r9 = d.a.p.n(r8);
        if (r9 == null) goto L33;
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L33;
    L34:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L37;
    L40:
        boolean r14 = true;
    L41:
        if (r14 == false) goto L46;
        if (r12 == null) goto L46;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r12.get("o_instruction_entry"), String.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L46;
        r0.put("instruction_entry", r15);
    L46:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r11.b().get("o_omni_track"), List.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L54;
        Object r17 = d.a.p.n(r16);
        if (r17 == null) goto L54;
        if (ZeusTransformUtils.instanceOf(r17, String.class) == false) goto L54;
    L55:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L58;
    L61:
        boolean r19 = true;
    L63:
        if (r19 == false) goto L68;
        if (r12 == null) goto L68;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r12.get("o_omni_track"), String.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L68;
        ISecureLogDepend.Companion.i(TAG, "handleMsgReceive, get server o_omni_track");
        r0.put("o_omni_track", r20);
    L68:
        if (r12 == null) goto L99;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r12.get("o_omni_err_code"), String.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L99;
        if (w.a(r110) == true) goto L75;
        r110 = null;
    L75:
        if (r110 == null) goto L99;
        ISecureLogDepend.Companion.i(TAG, "handleMsgReceive, get server o_omni_err_code: " + r110);
        r0.put("is_interrupted", true);
        r0.put("mark_interrupted_position", "server");
        r0.put("error_code", r110);
        if (d.o.o.b(r110, "1005", false, 2, null) == false) goto L99;
        long r21 = System.currentTimeMillis();
        List r111 = (List) ZeusTransformUtils.preCheckCast(r11.b().get("prepare_end"), List.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L86;
        Object r112 = d.a.p.n(r111);
        if (r112 == null) goto L86;
        if (ZeusTransformUtils.instanceOf(r112, Long.class) == false) goto L86;
    L87:
        if (r112 != null) goto L89;
        r0.put("prepare_end", Long.valueOf(r21));
    L89:
        List r113 = (List) ZeusTransformUtils.preCheckCast(r11.b().get("prepare_request_server_end"), List.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L97;
        Object r114 = d.a.p.n(r113);
        if (r114 == null) goto L97;
        if (ZeusTransformUtils.instanceOf(r114, Long.class) == false) goto L97;
        r4 = r114;
    L97:
        if (r4 != null) goto L99;
        r0.put("prepare_request_server_end", Long.valueOf(r21));
    L86:
        r112 = null;
        goto L87
    L58:
        if (r18.length() == 0) goto L61;
        r19 = false;
    L54:
        r17 = null;
        goto L55
    L37:
        if (r13.length() == 0) goto L40;
        r14 = false;
    L33:
        r9 = null;
        goto L34
    L16:
        if (r5.length() == 0) goto L19;
        r6 = false;
    L12:
        r3 = null;
    L99:
        return r0;
    }

    private final void a(String r15, Map<String, String> r16, IMMessage r17, String r18) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        ISecureLogDepend.Companion.w(TAG, "tryReportFinishFromTerminalMessage replyId is null");
        return;
    L13:
        if (r7 != null) goto L15;
        return;
    L15:
        if (r18 != null) goto L17;
        return;
    L17:
        TaskId r3 = TaskId.Companion.a(r15, TaskType.COMPLEX);
        if (a(r15) == true) goto L21;
        ISecureLogDepend.Companion.w(TAG, "tryReportFinishFromTerminalMessage ignored: local query start missing, replyId=" + r15 + ", taskId=" + r3.getValue() + ", state=" + r18);
        return;
    L21:
        IDialogStateManager r4 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L40;
        DMState r5 = r4.getCurrentDMState();
        if (r5 == null) goto L40;
        List<State> r6 = r5.getActiveTasks();
        if (r6 == null) goto L40;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L30;
    L32:
        Iterator r9 = r8.iterator();
    L34:
        if (r9.hasNext() == false) goto L31;
        if (d.h.b.o.a(((State) ZeusTransformUtils.preCheckCast(r9.next(), State.class, "com.obric.aiagent.plugin")).getTaskId(), r3) == false) goto L34;
        boolean r10 = true;
    L38:
        if (r10 != true) goto L40;
    L41:
        if (r2 == false) goto L44;
        ISecureLogDepend.Companion.i(TAG, "tryReportFinishFromTerminalMessage ignored: active task still exists, replyId=" + r15 + ", taskId=" + r3.getValue());
        return;
    L44:
        ISecureLogDepend.Companion.i(TAG, "tryReportFinishFromTerminalMessage fallback triggered, replyId=" + r15 + ", taskId=" + r3.getValue() + ", state=" + r18 + ", reportType=fallback");
        m r11 = m.f15694a;
        String r12 = r3.getValue();
        long r13 = System.currentTimeMillis();
        String r14 = new Gson().toJson(r17);
        d.h.b.o.c(r14, "toJson(...)");
        ISecureLogDepend.Companion.i(TAG, "tryReportFinishFromTerminalMessage result=" + r11.a(r15, r12, r13, r14, r17, r7, ao.a(d.s.a("report_type", "fallback")), this.f15648c) + ", replyId=" + r15 + ", state=" + r18);
        return;
    L31:
        r10 = false;
        goto L38
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L32;
    L40:
        r2 = false;
        goto L41
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final String a(Map<String, String> r9) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L6;
        ISecureLogDepend.Companion.i(TAG, "getTerminalComplexTaskState ignored: ext is null");
        return null;
    L6:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
        boolean r10 = d.h.b.o.a(r8.get("is_finish"), "1");
        if (d.h.b.o.a(r2, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == true) goto L10;
        ISecureLogDepend.Companion.i(TAG, "getTerminalComplexTaskState ignored: taskType=" + r2 + ", state=" + r4 + ", omniTaskId=" + r3);
        return null;
    L10:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (r0 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L20;
        ISecureLogDepend.Companion.i(TAG, "getTerminalComplexTaskState ignored: omniTaskId is blank, state=" + r4);
        return null;
    L20:
        if (r4 != null) goto L22;
    L29:
        String r6 = null;
    L31:
        if (r6 != null) goto L34;
        ISecureLogDepend.Companion.i(TAG, "getTerminalComplexTaskState ignored: non-terminal state=" + r4 + ", omniTaskId=" + r3 + ", isFinish=" + r10);
        return null;
    L34:
        ISecureLogDepend.Companion.i(TAG, "getTerminalComplexTaskState matched: state=" + r6 + ", omniTaskId=" + r3 + ", isFinish=" + r10);
        return r6;
    L22:
        if (d.h.b.o.a(r4, "complete") == false) goto L24;
    L26:
        r5 = true;
    L27:
        if (r5 == false) goto L29;
        r6 = r4;
        goto L31
    L24:
        if (d.h.b.o.a(r4, "cancel_complex_task") == false) goto L27;
        if (r10 == false) goto L27;
    L13:
        if (r0.length() == 0) goto L16;
        r1 = false;
        goto L17
    }

    private final boolean a(String r7, String r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        ISecureLogDepend.Companion.i(TAG, "shouldSkipTerminalReportWithoutLocalSnapshot skipped: replyId is blank, state=" + r8);
        return false;
    L13:
        if (r8 != null) goto L17;
        ISecureLogDepend.Companion.i(TAG, "shouldSkipTerminalReportWithoutLocalSnapshot skipped: terminal state missing, replyId=" + r7);
        return false;
    L17:
        if (a(r7) == false) goto L21;
        ISecureLogDepend.Companion.i(TAG, "shouldSkipTerminalReportWithoutLocalSnapshot skipped: local query start found, replyId=" + r7 + ", state=" + r8);
        return false;
    L21:
        if (k.f15686a.b(r7) == null) goto L23;
        r2 = true;
    L23:
        ISecureLogDepend.Companion.w(TAG, "terminal task message ignored: local query start missing before receive, replyId=" + r7 + ", state=" + r8 + ", snapshotFound=" + r2);
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final boolean a(String r3) {
        com.obric.agent.trace.omni.a r2 = k.f15686a.b(r3);
        Long r4 = null;
        Object r5 = null;
        r5 = null;
        r5 = null;
        if (r2 == null) goto L13;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2.b().get("message_send_success"), List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        Object r7 = d.a.p.n(r6);
        if (r7 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == false) goto L12;
        r5 = r7;
    L12:
        r4 = (Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin");
    L13:
        if (r4 != null) goto L15;
    L17:
        return false;
    L15:
        if (r4.longValue() <= 0) goto L17;
        return true;
    }
}
