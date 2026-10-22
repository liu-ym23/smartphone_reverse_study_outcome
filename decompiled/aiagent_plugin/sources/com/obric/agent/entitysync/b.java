package com.obric.agent.entitysync;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.agent.IEntityManager;
import com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.AppletBlock;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.BlockContent;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.search.EntityChangeMonitorRequest;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.obric.capabilitykit.search.IAppEntityChangeCallback;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import d.r;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "AppEntityCardSync";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.agent.entitysync.h f14471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LinkedHashMap<String, a> f14472d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f14473e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static final LinkedHashMap<com.obric.agent.entitysync.c, AppEntity> i = null;
    private static boolean j;
    private static boolean k;
    private static final am l = null;
    private static final f m = null;
    private static final Set<String> n = null;
    private static final Set<String> o = null;

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f14477d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14474a, r6.f14474a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14475b, r6.f14475b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14476c, r6.f14476c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f14477d, r6.f14477d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14474a.hashCode() * 31) + this.f14475b.hashCode()) * 31) + this.f14476c.hashCode()) * 31) + this.f14477d.hashCode();
        }

        public String toString() {
            return "WidgetContext(localMessageId=" + this.f14474a + ", blockId=" + this.f14475b + ", widgetId=" + this.f14476c + ", renderData=" + this.f14477d + ')';
        }

        public a(String r2, String r3, String r4, String r5) {
            o.e(r2, "localMessageId");
            o.e(r3, "blockId");
            o.e(r4, "widgetId");
            o.e(r5, "renderData");
            this.f14474a = r2;
            this.f14475b = r3;
            this.f14476c = r4;
            this.f14477d = r5;
        }

        public final String a() {
            return this.f14474a;
        }

        public final String b() {
            return this.f14475b;
        }

        public final String c() {
            return this.f14476c;
        }

        public final void a(String r2) {
            o.e(r2, "<set-?>");
            this.f14477d = r2;
        }

        public final String d() {
            return this.f14477d;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.entitysync.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    private static final class C0289b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14480c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0289b.class) == true) goto L8;
            return false;
        L8:
            C0289b r6 = (C0289b) ZeusTransformUtils.preCheckCast(r5, C0289b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14478a, r6.f14478a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14479b, r6.f14479b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14480c, r6.f14480c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f14478a.hashCode() * 31) + this.f14479b.hashCode()) * 31) + this.f14480c.hashCode();
        }

        public String toString() {
            return "WidgetUpdate(localMessageId=" + this.f14478a + ", blockId=" + this.f14479b + ", renderData=" + this.f14480c + ')';
        }

        public C0289b(String r2, String r3, String r4) {
            o.e(r2, "localMessageId");
            o.e(r3, "blockId");
            o.e(r4, "renderData");
            this.f14478a = r2;
            this.f14479b = r3;
            this.f14480c = r4;
        }

        public final String a() {
            return this.f14478a;
        }

        public final String b() {
            return this.f14479b;
        }

        public final String c() {
            return this.f14480c;
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    @d.c.b.a.f(b = "AppEntityCardSyncManager.kt", c = {769}, d = "invokeSuspend", e = "com.obric.agent.entitysync.AppEntityCardSyncManager$fetchLatestMessages$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends IMMessage>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f14483c;

        c(int r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14483c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<IMMessage>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14483c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends IMMessage>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14482b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L17:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            int r8 = this.f14483c;
            this.f14481a = r8;
            this.f14482b = 1;
            kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r4.e();
            final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
            if (r3 != null) goto L11;
            ILogDepend.Companion.e(b.TAG, "fetchLatestMessages: IPC not available");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r9.resumeWith(d.n.f(null));
        L12:
            r7 = r4.h();
            if (r7 != d.c.a.b.a()) goto L15;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L15:
            if (r7 != r0) goto L17;
            return r0;
        L11:
            r3.fetchLatestMessages(r8, (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.preCheckCast(new AppEntityCardSyncManager$fetchLatestMessages$2$1$1(r2), IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin"));
            goto L12
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    @d.c.b.a.f(b = "AppEntityCardSyncManager.kt", c = {769}, d = "invokeSuspend", e = "com.obric.agent.entitysync.AppEntityCardSyncManager$fetchMessageById$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super IMMessage>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14486c;

        d(String r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14486c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super IMMessage> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14486c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IMMessage> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14485b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f14484a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
        L17:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            String r8 = this.f14486c;
            this.f14484a = r8;
            this.f14485b = 1;
            kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r4.e();
            final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
            if (r3 != null) goto L11;
            ILogDepend.Companion.e(b.TAG, "fetchMessageById: IPC not available");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r9.resumeWith(d.n.f(null));
        L12:
            r7 = r4.h();
            if (r7 != d.c.a.b.a()) goto L15;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L15:
            if (r7 != r0) goto L17;
            return r0;
        L11:
            r3.findMessagebyId(r8, (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new AppEntityCardSyncManager$fetchMessageById$2$1$1(r2), IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin"));
            goto L12
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    @d.c.b.a.f(b = "AppEntityCardSyncManager.kt", c = {355}, d = "invokeSuspend", e = "com.obric.agent.entitysync.AppEntityCardSyncManager$launchStartupHistoryRestore$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14487a;

        e(d.c.d<? super e> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14487a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r10);     // Catch: Throwable -> L7
        L15:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            if (r9 != null) goto L18;
            ILogDepend.Companion.i(b.TAG, "startup history restore failed, latest messages unavailable");     // Catch: Throwable -> L7
        L35:
            b.a(b.f14469a);
            return x.f38692a;
        L18:
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L7
            int r2 = 0;
        L20:
            if (r11.hasNext() == false) goto L32;
            IMMessage r5 = (IMMessage) ZeusTransformUtils.preCheckCast(r11.next(), IMMessage.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            List<Block> r6 = r5.getContentBlock();     // Catch: Throwable -> L7
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.getLocalMessageId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L20;
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            if (r7 != null) goto L26;
        L29:
            boolean r8 = true;
        L30:
            if (r8 == true) goto L20;
            b.f14469a.a(r5.getLocalMessageId(), r6);     // Catch: Throwable -> L7
            r2 = r2 + 1;     // Catch: Throwable -> L7
            goto L20
        L26:
            if (r7.isEmpty() == true) goto L29;
            r8 = false;
            goto L30
        L32:
            ILogDepend.Companion.i(b.TAG, "startup history restore finished, fetchedMessage=" + r9.size() + ", registeredMessage=" + r2);     // Catch: Throwable -> L7
            goto L35
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r10);
            b r12 = b.f14469a;     // Catch: Throwable -> L7
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f14487a = 1;     // Catch: Throwable -> L7
            r10 = b.a(r12, 10, r13);     // Catch: Throwable -> L7
            if (r10 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            ILogDepend.Companion.e(b.TAG, "startup history restore failed", th);     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            b.a(b.f14469a);
            throw th;
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    public static final class f implements com.obric.agent.im.d {
        f() {
        }

        @Override // com.obric.agent.im.d
        public void onInsertMessageList(List<IMMessage> r3) {
            com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.agent.im.d
        public void onSendMessage(IMMessage r2) {
            o.e(r2, "message");
            if (r2.getUserType() == 1) goto L5;
            return;
        L5:
            if (r2.getMessageStatusLocal() != 11) goto L10;
            b.a(b.f14469a, b.f14469a.b(r2.getExt()));
            return;
        }

        @Override // com.obric.agent.im.d
        public void onReceiveMessage(IMMessage r1) {
            o.e(r1, "message");
            b.a(b.f14469a, r1);
        }

        @Override // com.obric.agent.im.d
        public void onUpdateMessage(IMMessage r1) {
            o.e(r1, "message");
            b.a(b.f14469a, r1);
        }

        @Override // com.obric.agent.im.d
        public void onRegenMessage(IMMessage r1) {
            o.e(r1, "message");
            b.a(b.f14469a, r1);
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    @d.c.b.a.f(b = "AppEntityCardSyncManager.kt", c = {BDAbstractUpload.KeyIsSDKRetryPolicy}, d = "invokeSuspend", e = "com.obric.agent.entitysync.AppEntityCardSyncManager$reconcileDeleteWithHistory$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<AppEntity> f14489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.entitysync.e f14490c;

        g(List<? extends AppEntity> r3, com.obric.agent.entitysync.e r4, d.c.d<? super g> r5) {
            List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14489b = r6;
            this.f14490c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f14489b, this.f14490c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14488a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            List r11 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L14;
        L17:
            boolean r3 = true;
        L19:
            if (r3 == false) goto L22;
            ILogDepend.Companion.i(b.TAG, "delete reconcile skipped, no history messages fetched");
            return x.f38692a;
        L22:
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            int r4 = 0;
        L24:
            if (r12.hasNext() == false) goto L36;
            IMMessage r5 = (IMMessage) ZeusTransformUtils.preCheckCast(r12.next(), IMMessage.class, "com.obric.aiagent.plugin");
            List<Block> r6 = r5.getContentBlock();
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.getLocalMessageId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L24;
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L30;
        L33:
            boolean r8 = true;
        L34:
            if (r8 == true) goto L24;
            b.f14469a.a(r5.getLocalMessageId(), r6);
            r4 = r4 + 1;
            goto L24
        L30:
            if (r7.isEmpty() == true) goto L33;
            r8 = false;
            goto L34
        L36:
            if (r4 != 0) goto L39;
            ILogDepend.Companion.i(b.TAG, "delete reconcile skipped, no widget message in history");
            return x.f38692a;
        L39:
            List r9 = b.a(b.f14469a, com.obric.agent.entitysync.g.f14509c, b.a(b.f14469a, this.f14489b), true, this.f14490c);
            b.b(b.f14469a, r9);
            ILogDepend.Companion.i(b.TAG, "delete reconcile persisted after history registration, registeredMessage=" + r4 + ", cardUpdateCount=" + r9.size());
            return x.f38692a;
        L14:
            if (r2.isEmpty() == true) goto L17;
            r3 = false;
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            b r13 = b.f14469a;
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14488a = 1;
            r10 = b.a(r13, 10, r14);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    @d.c.b.a.f(b = "AppEntityCardSyncManager.kt", c = {467, 485}, d = "invokeSuspend", e = "com.obric.agent.entitysync.AppEntityCardSyncManager$reconcileMessageSendStateWithHistory$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14494d;

        h(String r3, String r4, String r5, d.c.d<? super h> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14492b = r3;
            this.f14493c = r4;
            this.f14494d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f14492b, this.f14493c, this.f14494d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14491a;
            IMMessage r3 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r11);
        L29:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L32;
        L35:
            boolean r4 = true;
        L36:
            if (r4 == false) goto L39;
            ILogDepend.Companion.i(b.TAG, "message send state reconcile skipped, no history messages fetched");
            return x.f38692a;
        L39:
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            int r5 = 0;
        L41:
            if (r13.hasNext() == false) goto L53;
            IMMessage r6 = (IMMessage) ZeusTransformUtils.preCheckCast(r13.next(), IMMessage.class, "com.obric.aiagent.plugin");
            List<Block> r7 = r6.getContentBlock();
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6.getLocalMessageId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L41;
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L47;
        L50:
            boolean r9 = true;
        L51:
            if (r9 == true) goto L41;
            b.f14469a.a(r6.getLocalMessageId(), r7);
            r5 = r5 + 1;
            goto L41
        L47:
            if (r8.isEmpty() == true) goto L50;
            r9 = false;
            goto L51
        L53:
            if (r5 != 0) goto L56;
            ILogDepend.Companion.i(b.TAG, "message send state reconcile skipped, no widget message in history");
            return x.f38692a;
        L56:
            List r14 = b.a(b.f14469a, this.f14493c, this.f14494d);
            b.b(b.f14469a, r14);
            ILogDepend.Companion.i(b.TAG, "message send state reconcile finished, entityId=" + this.f14493c + ", state=" + this.f14494d + ", registeredMessage=" + r5 + ", cardUpdateCount=" + r14.size());
            return x.f38692a;
        L32:
            if (r2.isEmpty() == true) goto L35;
            r4 = false;
            goto L36
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r11);
        L20:
            r3 = (IMMessage) ZeusTransformUtils.preCheckCast(r11, IMMessage.class, "com.obric.aiagent.plugin");
        L21:
            if (r3 == null) goto L26;
            b.f14469a.a(r3.getLocalMessageId(), r3.getContentBlock());
            List r15 = b.a(b.f14469a, this.f14493c, this.f14494d);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L26;
            b.b(b.f14469a, r15);
            ILogDepend.Companion.i(b.TAG, "message send state reconciled by target message, entityId=" + this.f14493c + ", messageIdentifier=" + this.f14492b + ", cardUpdateCount=" + r15.size());
            return x.f38692a;
        L26:
            b r16 = b.f14469a;
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14491a = 2;
            r11 = b.a(r16, 10, r10);
            if (r11 != r0) goto L29;
            return r0;
        L10:
            d.o.a(r11);
            String r17 = this.f14492b;
            if (r17 == null) goto L21;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
            r17 = null;
        L16:
            if (r17 == null) goto L21;
            b r18 = b.f14469a;
            this.f14491a = 1;
            r11 = b.a(r18, r17, this);
            if (r11 != r0) goto L20;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    public static final class i implements IAppEntityChangeCallback {
        i() {
        }

        @Override // com.obric.capabilitykit.search.IAppEntityChangeCallback
        public void onChange(EntityChangeResult r1) {
            o.e(r1, "result");
            b.f14469a.a(r1);
        }

        @Override // com.obric.capabilitykit.search.IAppEntityChangeCallback
        public void onError(int r4, String r5) {
            o.e(r5, "errorMsg");
            Object r3 = b.b();
            monitor-enter(r3);
            b r0 = b.f14469a;     // Catch: Throwable -> L8
            b.a(false);     // Catch: Throwable -> L8
            x r1 = x.f38692a;     // Catch: Throwable -> L8
            monitor-exit(r3);
            ILogDepend.Companion.e(b.TAG, "register alarm entity observer failed, code=" + r4 + ", message=" + r5);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: AppEntityCardSyncManager.kt */
    public static final class j extends PluginBroadcastReceiver {
        j() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (o.a(r4, "com.obric.memorydata.appentity.restart") == true) goto L9;
            return;
        L9:
            Object r5 = b.b();
            monitor-enter(r5);
            b r6 = b.f14469a;     // Catch: Throwable -> L15
            b.a(false);     // Catch: Throwable -> L15
            x r7 = x.f38692a;     // Catch: Throwable -> L15
            monitor-exit(r5);
            b.b(b.f14469a);
            return;
        L15:
            th = move-exception;
            throw th;
        L5:
            r4 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: lambda$LSlJJ0T-xYbkJOuQn17m-vO839Q, reason: not valid java name */
    public static /* synthetic */ void m74lambda$LSlJJ0TxYbkJOuQn17mvO839Q(IFlowMessageIDL r0) {
        a(r0);
    }

    public static /* synthetic */ Thread lambda$U1x3lzYuW9G2TeKvoHP3YOaWjHk(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$fbByuuIsLExjdbkhHK-jHvK12-g, reason: not valid java name */
    public static /* synthetic */ boolean m75lambda$fbByuuIsLExjdbkhHKjHvK12g(Set r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$yab4McpI1bGitEcsuFu3yI1yCB4(String r0, AppEntity r1) {
        return a(r0, r1);
    }

    private b() {
    }

    public static final /* synthetic */ Object a(b r2, int r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ List a(b r2, com.obric.agent.entitysync.g r3, List r4, boolean r5, com.obric.agent.entitysync.e r6) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    public static final /* synthetic */ List a(b r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ List a(b r2, List r3) {
        return r2.d((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(b r0) {
        r0.e();
    }

    public static final /* synthetic */ void a(b r0, IMMessage r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(b r0, String r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(boolean r0) {
        f14473e = r0;
    }

    public static final /* synthetic */ Object b() {
        return f14470b;
    }

    public static final /* synthetic */ void b(b r0) {
        r0.g();
    }

    public static final /* synthetic */ void b(b r2, List r3) {
        r2.e((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    static {
        f14469a = new b();
        f14470b = new Object();
        f14471c = new com.obric.agent.entitysync.h(5);
        f14472d = new LinkedHashMap();
        i = new LinkedHashMap();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$b$U1x3lzYuW9G2TeKvoHP3YOaWjHk.INSTANCE);
        o.c(r0, "newSingleThreadExecutor(...)");
        l = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
        m = new f();
        n = ax.a(new String[]{"appintent_message", "appintent_office"});
        o = ax.a(new String[]{"success", "failed"});
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "app-entity-persistence-reconcile");
    }

    public final void a() {
        Object r0 = f14470b;
        monitor-enter(r0);
        boolean r2 = true;
        if (f == false) goto L7;
        r2 = false;
    L8:
        monitor-exit(r0);
        if (r2 == true) goto L11;
        return;
    L11:
        f();
        h();
        g();
        c();
        return;
    L7:
        f = true;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(String r9, List<Block> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r9, "localMessageId");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
        r11 = p.b();
    L7:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L42;
        Block r1 = (Block) ZeusTransformUtils.preCheckCast(r13.next(), Block.class, "com.obric.aiagent.plugin");
        r r4 = null;
        if (r1.getBlockType() != 10017) goto L40;
        String r2 = r1.getBlockId();
        if (r2 == null) goto L40;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L40;
        BlockContent r3 = r1.getContent();
        if (r3 == null) goto L40;
        AppletBlock r5 = r3.getAppletBlock();
        if (r5 == null) goto L40;
        String r6 = r5.renderData;
        if (r6 == null) goto L40;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L31;
        r6 = null;
    L31:
        if (r6 == null) goto L40;
        l.a r7 = l.f14534a.a(r6);
        if (r7 == null) goto L40;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7.b(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L38;
        r7 = null;
    L38:
        if (r7 == null) goto L40;
        r4 = new r(r2, r6, r7);
    L40:
        if (r4 == null) goto L9;
        r0.add(r4);
        goto L9
    L42:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if (r14.isEmpty() == false) goto L45;
        return;
    L45:
        Object r8 = f14470b;
        monitor-enter(r8);
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L55
    L49:
        if (r15.hasNext() == false) goto L51;
        r r16 = (r) ZeusTransformUtils.preCheckCast(r15.next(), r.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.d(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
        String r18 = (String) ZeusTransformUtils.preCheckCast(r16.e(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
        l.a r19 = (l.a) ZeusTransformUtils.preCheckCast(r16.f(), l.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L55
        String r20 = f14469a.b(r9, r17);     // Catch: Throwable -> L55
        ((Map) ZeusTransformUtils.preCheckCast(f14472d, Map.class, "com.obric.aiagent.plugin")).put(r20, new a(r9, r17, r19.a(), r18));     // Catch: Throwable -> L55
        f14471c.a(r20, r19.b());     // Catch: Throwable -> L55
        goto L49
    L51:
        x r21 = x.f38692a;     // Catch: Throwable -> L55
        monitor-exit(r8);
        g();
        return;
    L55:
        th = move-exception;
        throw th;
    }

    public final Map<String, String> a(Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "queryExt");
        m r4 = f14471c.a(b(r6));
        String r7 = k.f14533a.a(r4.c());
        if (r7 == null) goto L5;
        ILogDepend.Companion.i(TAG, "prepare query ext, round=" + r4.a() + ", updateCount=" + r4.c().size());
        return ao.a(s.a("o_entity_update", r7));
    L5:
        return ao.b();
    }

    public final void a(EntityChangeResult r3) {
        o.e(r3, "result");
        com.obric.agent.a.b.f14218a.a(r3);
        int r0 = r3.getChangeType();
        if (r0 != 1) goto L5;
        com.obric.agent.entitysync.g r1 = com.obric.agent.entitysync.g.f14507a;
    L13:
        if (r1 == com.obric.agent.entitysync.g.f14508b) goto L15;
    L17:
        a(r1, r3.getEntities());
        return;
    L15:
        if (c(r3.getEntities()) == false) goto L17;
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = com.obric.agent.entitysync.g.f14508b;
        goto L13
    L7:
        if (r0 == 3) goto L9;
        return;
    L9:
        r1 = com.obric.agent.entitysync.g.f14509c;
        goto L13
    }

    private final void a(com.obric.agent.entitysync.g r8, List<? extends AppEntity> r9) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        com.obric.agent.entitysync.i r2 = f14469a.a((AppEntity) ZeusTransformUtils.preCheckCast(r11.next(), AppEntity.class, "com.obric.aiagent.plugin"), r8);
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if (r12.isEmpty() == false) goto L11;
        return;
    L11:
        List<C0289b> r1 = a(this, r8, r12, false, com.obric.agent.entitysync.e.f14504d, 4, null);
        e(r1);
        ILogDepend.Companion.i(TAG, "entity change handled, change=" + r8 + ", entityCount=" + r12.size() + ", cardUpdateCount=" + r1.size());
    }

    public final void a(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "entities");
        a(r4, com.obric.agent.entitysync.e.f14503c);
    }

    public final void b(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "entities");
        a(r4, com.obric.agent.entitysync.e.f14504d);
    }

    private final void a(List<? extends AppEntity> r5, com.obric.agent.entitysync.e r6) {
        List<? extends AppEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        com.obric.agent.a.b.f14218a.a(new EntityChangeResult(3, r7));
        List<C0289b> r0 = a(com.obric.agent.entitysync.g.f14509c, d(r7), true, r6);
        e(r0);
        ILogDepend.Companion.i(TAG, "explicit delete persisted, entityCount=" + r7.size() + ", cardUpdateCount=" + r0.size());
        b(r7, r6);
    }

    public final void a(String r7, String r8, String r9) {
        o.e(r7, "entityId");
        o.e(r8, "state");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L11:
        ILogDepend.Companion.e(TAG, "update message send state rejected, entityId=" + r7 + ", state=" + r8);
        return;
    L5:
        if (o.contains(r8) == false) goto L11;
        List<C0289b> r0 = a(r7, r8);
        e(r0);
        ILogDepend.Companion.i(TAG, "message send state persisted, entityId=" + r7 + ", state=" + r8 + ", cardUpdateCount=" + r0.size());
        if (r0.isEmpty() == false) goto L13;
        b(r7, r8, r9);
        return;
    }

    private final Object a(String r3, d.c.d<? super IMMessage> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(WsConstants.EXIT_DELAY_TIME, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    private final void c() {
        ak.a(aa.b(IFlowMessageIDL.class), true, true, $$Lambda$b$LSlJJ0TxYbkJOuQn17mvO839Q.INSTANCE);
    }

    private static final void a(IFlowMessageIDL r2) {
        o.e((IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageIDL.class, "com.obric.aiagent.plugin"), "it");
        ILogDepend.Companion.i(TAG, "startup history restore triggered, message IPC available");
        f14469a.d();
    }

    private final boolean c(List<? extends AppEntity> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Object r8 = f14470b;
        monitor-enter(r8);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (j == false) goto L7;
        boolean r9 = false;
    L15:
        monitor-exit(r8);
        return r9;
    L7:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L17
    L9:
        if (r10.hasNext() == false) goto L13;
        AppEntity r0 = (AppEntity) ZeusTransformUtils.preCheckCast(r10.next(), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0.getId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        ((Map) ZeusTransformUtils.preCheckCast(i, Map.class, "com.obric.aiagent.plugin")).put(new com.obric.agent.entitysync.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0.get_packageName(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), r0.getType(), r0.getId()), r0);     // Catch: Throwable -> L17
        goto L9
    L13:
        r9 = !((Map) ZeusTransformUtils.preCheckCast(i, Map.class, "com.obric.aiagent.plugin")).isEmpty();
        goto L15
    }

    private final void d() {
        Object r8 = f14470b;
        monitor-enter(r8);
        boolean r1 = true;
        if (j == false) goto L7;
    L11:
        r1 = false;
    L12:
        monitor-exit(r8);
        if (r1 == true) goto L15;
        return;
    L15:
        kotlinx.coroutines.i.a(l, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L7:
        if (k == true) goto L11;
        k = true;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private final void e() {
    L2:
        Object r0 = f14470b;
        monitor-enter(r0);
        LinkedHashMap<com.obric.agent.entitysync.c, AppEntity> r1 = i;     // Catch: Throwable -> L20
        if (r1.isEmpty() == false) goto L7;
        j = true;     // Catch: Throwable -> L20
        k = false;     // Catch: Throwable -> L20
        List<? extends AppEntity> r2 = p.b();     // Catch: Throwable -> L20
    L9:
        monitor-exit(r0);
        if (r2.isEmpty() == true) goto L12;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L15
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).a(com.obric.agent.entitysync.g.f14508b, r2);     // Catch: Throwable -> L15
        Object r4 = d.n.f(x.f38692a);     // Catch: Throwable -> L15
    L17:
        Throwable r5 = d.n.c(r4);
        if (r5 == null) goto L2;
        ILogDepend.Companion.e(TAG, "replay update after startup history restore failed, entityCount=" + r2.size(), r5);
    L15:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L17
    L12:
        return;
    L7:
        Collection<AppEntity> r7 = r1.values();     // Catch: Throwable -> L20
        o.c(r7, "<get-values>(...)");     // Catch: Throwable -> L20
        List<? extends AppEntity> r8 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20
        r1.clear();     // Catch: Throwable -> L20
        r2 = r8;
    L20:
        th = move-exception;
        throw th;
    }

    private final void b(List<? extends AppEntity> r8, com.obric.agent.entitysync.e r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(l, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r7, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void b(String r7, String r8, String r9) {
        kotlinx.coroutines.i.a(l, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r9, r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final List<com.obric.agent.entitysync.i> d(List<? extends AppEntity> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r7.next(), AppEntity.class, "com.obric.aiagent.plugin");
        com.obric.agent.entitysync.i r2 = f14469a.a(r1, com.obric.agent.entitysync.g.f14509c);
        if (r2 == null) goto L4;
        r6.add(r2);
        goto L4
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    }

    private final Object a(int r3, d.c.d<? super List<IMMessage>> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(WsConstants.EXIT_DELAY_TIME, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    static /* synthetic */ List a(b r1, com.obric.agent.entitysync.g r2, List r3, boolean r4, com.obric.agent.entitysync.e r5, int r6, Object r7) {
        List<com.obric.agent.entitysync.i> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = com.obric.agent.entitysync.e.f14503c;
    L9:
        return r1.a(r2, r8, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<C0289b> a(com.obric.agent.entitysync.g r9, List<com.obric.agent.entitysync.i> r10, boolean r11, com.obric.agent.entitysync.e r12) {
        List<com.obric.agent.entitysync.i> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Object r13 = f14470b;
        monitor-enter(r13);
        com.obric.agent.entitysync.h r0 = f14471c;     // Catch: Throwable -> L30
        Set<String> r1 = r0.a(r9);     // Catch: Throwable -> L30
        if (r11 == false) goto L7;
        List<com.obric.agent.entitysync.a> r14 = r0.a(r8);     // Catch: Throwable -> L30
    L8:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L30
    L10:
        if (r17.hasNext() == false) goto L27;
        com.obric.agent.entitysync.a r2 = (com.obric.agent.entitysync.a) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.agent.entitysync.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        C0289b r3 = null;
        if (r1.contains(r2.a()) == false) goto L25;
        a r4 = (a) ZeusTransformUtils.preCheckCast(f14472d.get(r2.a()), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        if (r4 == null) goto L25;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r2.b(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(d.l.n.c(ao.a(p.a(r5, 10)), 16)), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L30
    L19:
        if (r7.hasNext() == false) goto L21;
        com.obric.agent.entitysync.d r18 = (com.obric.agent.entitysync.d) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.agent.entitysync.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        d.m r19 = s.a(r18.a().a(), com.obric.agent.entitysync.f.f14506a.a(r9, r18, r12));     // Catch: Throwable -> L30
        r6.put(r19.a(), r19.b());     // Catch: Throwable -> L30
        goto L19
    L21:
        String r20 = l.f14534a.a(r4.d(), r6);     // Catch: Throwable -> L30
        if (r20 == null) goto L25;
        r4.a(r20);     // Catch: Throwable -> L30
        r3 = new C0289b(r4.a(), r4.b(), r20);     // Catch: Throwable -> L30
    L25:
        if (r3 == null) goto L10;
        r16.add(r3);     // Catch: Throwable -> L30
        goto L10
    L27:
        List<C0289b> r21 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
        monitor-exit(r13);
        return r21;
    L7:
        r14 = r0.a(r9, r8);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private final List<C0289b> a(String r8, String r9) {
        Object r7 = f14470b;
        monitor-enter(r7);
        Collection<a> r0 = f14472d.values();     // Catch: Throwable -> L19
        o.c(r0, "<get-values>(...)");     // Catch: Throwable -> L19
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L19
    L6:
        if (r3.hasNext() == false) goto L16;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        Set<String> r5 = n;     // Catch: Throwable -> L19
        C0289b r6 = null;
        if (r5.contains(r4.c()) == false) goto L14;
        String r10 = l.f14534a.a(r4.d(), r8, r9, r5);     // Catch: Throwable -> L19
        if (r10 == null) goto L14;
        r4.a(r10);     // Catch: Throwable -> L19
        r6 = new C0289b(r4.a(), r4.b(), r10);     // Catch: Throwable -> L19
    L14:
        if (r6 == null) goto L6;
        r2.add(r6);     // Catch: Throwable -> L19
        goto L6
    L16:
        List<C0289b> r11 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        monitor-exit(r7);
        return r11;
    L19:
        th = move-exception;
        throw th;
    }

    private final void e(List<C0289b> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        IFlowMessageIDL r8 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r8 != null) goto L9;
        ILogDepend.Companion.e(TAG, "persist widget updates failed: message IPC unavailable, cardUpdateCount=" + r6.size());
        return;
    L9:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        C0289b r2 = (C0289b) ZeusTransformUtils.preCheckCast(r9.next(), C0289b.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "persist widget update dispatched, localMessageId=" + r2.a() + ", blockId=" + r2.b());
        r8.updateMutableWidgetRenderData(r2.a(), r2.b(), r2.c());
        goto L11
    }

    private final com.obric.agent.entitysync.i a(AppEntity r7, com.obric.agent.entitysync.g r8) {
        Object r1 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7.getId(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return null;
    L5:
        com.obric.agent.entitysync.h r0 = f14471c;
        com.obric.agent.entitysync.c r3 = r0.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7.get_packageName(), CharSequence.class, "com.obric.aiagent.plugin")).toString(), r7.getType(), r7.getId());
        if (r3 != null) goto L8;
        return null;
    L8:
        com.obric.agent.entitysync.i r2 = r0.a(r3);
        if (r2 != null) goto L11;
        return null;
    L11:
        n r4 = n.f14546a;
        if (r8 == com.obric.agent.entitysync.g.f14509c) goto L14;
        boolean r9 = true;
    L15:
        String r10 = r4.a(r2, r7, r9, $$Lambda$b$yab4McpI1bGitEcsuFu3yI1yCB4.INSTANCE);
        if (r10 != null) goto L29;
        ILogDepend.Companion.e(TAG, "allocate replacement ecaId failed, type=" + r7.getType() + ", id=" + r7.getId());
        return null;
    L29:
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L21
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Object r11 = d.n.f(com.obric.agent.entitysync.i.f14527a.a(r7, r3.a(), r10));     // Catch: Throwable -> L21
    L24:
        if (d.n.b(r11) == true) goto L28;
        r1 = r11;
    L28:
        return (com.obric.agent.entitysync.i) ZeusTransformUtils.preCheckCast(r1, com.obric.agent.entitysync.i.class, "com.obric.aiagent.plugin");
    L21:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L24
    L14:
        r9 = false;
        goto L15
    }

    private static final String a(String r3, AppEntity r4) {
        o.e(r3, "previousEcaId");
        o.e(r4, "realEntity");
        IEntityManager r0 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.replaceEntity(r3, r4);
    }

    private final void a(String r5) {
        Object r0 = f14470b;
        monitor-enter(r0);
        com.obric.agent.entitysync.h r1 = f14471c;     // Catch: Throwable -> L8
        r1.b(r5);     // Catch: Throwable -> L8
        final Set<String> r6 = r1.a();     // Catch: Throwable -> L8
        Set<String> r2 = f14472d.keySet();     // Catch: Throwable -> L8
        o.c(r2, "<get-keys>(...)");     // Catch: Throwable -> L8
        p.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"), new $$Lambda$b$fbByuuIsLExjdbkhHKjHvK12g(r6));     // Catch: Throwable -> L8
        monitor-exit(r0);
        g();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static final boolean a(Set r2, String r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        return !r4.contains(r3);
    }

    private final void a(IMMessage r5) {
        boolean r1 = true;
        if (r5.getUserType() == 1) goto L14;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r5.getContentBlock(), Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
    L10:
        if (r1 == true) goto L15;
        a(r5.getLocalMessageId(), r5.getContentBlock());
        return;
    L15:
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
        goto L10
    }

    private final void f() {
        Object r3 = f14470b;
        monitor-enter(r3);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (g == false) goto L9;
        monitor-exit(r3);
        return;
    L9:
        g = true;     // Catch: Throwable -> L13
        x r0 = x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r3);
        com.obric.agent.k.f15191a.a((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(m, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
    }

    private final void g() {
        Object r4 = f14470b;
        monitor-enter(r4);
        boolean r1 = true;
        if (f14473e == false) goto L7;
        r1 = false;
    L8:
        monitor-exit(r4);
        if (r1 == true) goto L11;
        return;
    L11:
        InAppSearchClient.INSTANCE.unregisterEntityObserver();
        InAppSearchClient.INSTANCE.registerEntityObserver(new EntityChangeMonitorRequest(p.a(Integer.valueOf(EntityType.ALARM))), (IAppEntityChangeCallback) ZeusTransformUtils.preCheckCast(new i(), IAppEntityChangeCallback.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.i(TAG, "register entity observer, types=[701]");
        return;
    L7:
        f14473e = true;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private final void h() {
        Object r0 = f14470b;
        monitor-enter(r0);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (h == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        h = true;     // Catch: Throwable -> L32
        x r1 = x.f38692a;     // Catch: Throwable -> L32
        monitor-exit(r0);
        j r2 = new j();
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L18
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        IntentFilter r5 = new IntentFilter("com.obric.memorydata.appentity.restart");     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 33) goto L15;
        Intent r6 = ZeusTransformUtils.registerReceiver((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r2, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r5, 4, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L16:
        Object r7 = d.n.f(r6);     // Catch: Throwable -> L18
    L20:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L31;
        Object r9 = f14470b;
        monitor-enter(r9);
        h = false;     // Catch: Throwable -> L28
        x r10 = x.f38692a;     // Catch: Throwable -> L28
        monitor-exit(r9);
        ILogDepend.Companion.e(TAG, "register memory restart receiver failed", r8);
        return;
    L28:
        th = move-exception;
        throw th;
    L31:
        return;
    L15:
        r6 = ZeusTransformUtils.registerReceiver((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r2, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r5, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L20
    }

    public final String b(Map<String, String> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        boolean r7 = true;
        if (r5 == null) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r5.get("collection_id"), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L18;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 == null) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L18;
        return r4;
    L11:
        r8 = false;
    L18:
        if (r5 == null) goto L31;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_query_did"), String.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L32;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r10 != null) goto L24;
        return null;
    L24:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L27;
        r7 = false;
    L27:
        if (r7 == true) goto L29;
        return null;
    L29:
        return r10;
    L32:
        return null;
    L31:
        return null;
    }

    private final String b(String r1, String r2) {
        return r1 + ':' + r2;
    }
}
