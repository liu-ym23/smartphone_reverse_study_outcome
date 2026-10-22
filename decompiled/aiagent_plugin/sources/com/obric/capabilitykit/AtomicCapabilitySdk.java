package com.obric.capabilitykit;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.EntityInitParam;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.ILogger;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class AtomicCapabilitySdk {
    public static final int ERROR_INVALID_ACTION_NAME = -1;
    public static final int ERROR_NO_ERROR = 0;
    public static final AtomicCapabilitySdk INSTANCE = null;
    private static final int MAX_PENDING_FUN_CALL = 1024;
    public static final String TAG = "AtomicCapabilitySdk";
    private static final CopyOnWriteArraySet<d.h.a.a<x>> connectionListeners = null;
    private static int extBindFlags;
    private static boolean mPendingCallsExecuted;
    private static final List<a> mPendingCals = null;
    private static com.obric.capabilitykit.a mSendResultApi;

    public static final class InitConfig {
        private final Application app;
        private final String entityProcessName;
        private final EntitySupplier entitySupplier;
        private final EntitySyncDataSupplier entitySyncDataSupplier;
        private final int extBindFlags;

        public InitConfig(Application r3, EntitySupplier r4, String r5, EntitySyncDataSupplier r6, int r7) {
            Application r8 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            EntitySupplier r9 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySupplier.class, "com.obric.aiagent.plugin");
            EntitySyncDataSupplier r10 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r6, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "app");
            this.app = r8;
            this.entitySupplier = r9;
            this.entityProcessName = r5;
            this.entitySyncDataSupplier = r10;
            this.extBindFlags = r7;
        }

        public /* synthetic */ InitConfig(Application r4, EntitySupplier r5, String r6, EntitySyncDataSupplier r7, int r8, int r9, d.h.b.h r10) {
            Application r11 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.aiagent.plugin");
            EntitySupplier r12 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r5, EntitySupplier.class, "com.obric.aiagent.plugin");
            EntitySyncDataSupplier r13 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r7, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
            EntitySyncDataSupplier r0 = null;
            if ((r9 & 2) == 0) goto L5;
            EntitySupplier r14 = null;
        L7:
            if ((r9 & 4) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r9 & 8) != 0) goto L15;
            r0 = r13;
        L15:
            if ((r9 & 16) == 0) goto L17;
            r8 = 0;
        L17:
            this(r11, r14, r1, r0, r8);
            return;
        L9:
            r1 = r6;
            goto L11
        L5:
            r14 = r12;
            goto L7
        }

        public static /* synthetic */ InitConfig copy$default(InitConfig r6, Application r7, EntitySupplier r8, String r9, EntitySyncDataSupplier r10, int r11, int r12, Object r13) {
            Application r14 = (Application) ZeusTransformUtils.wrapperContextForParams(r7, Application.class, "com.obric.aiagent.plugin");
            EntitySupplier r15 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r8, EntitySupplier.class, "com.obric.aiagent.plugin");
            EntitySyncDataSupplier r16 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r10, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
            if ((r12 & 1) == 0) goto L5;
            r14 = r6.app;
        L5:
            Application r1 = r14;
            if ((r12 & 2) == 0) goto L8;
            r15 = r6.entitySupplier;
        L8:
            EntitySupplier r2 = r15;
            if ((r12 & 4) == 0) goto L11;
            r9 = r6.entityProcessName;
        L11:
            String r3 = r9;
            if ((r12 & 8) == 0) goto L14;
            r16 = r6.entitySyncDataSupplier;
        L14:
            EntitySyncDataSupplier r4 = r16;
            if ((r12 & 16) == 0) goto L18;
            r11 = r6.extBindFlags;
        L18:
            return r6.copy(r1, r2, r3, r4, r11);
        }

        public final Application component1() {
            return this.app;
        }

        public final EntitySupplier component2() {
            return this.entitySupplier;
        }

        public final String component3() {
            return this.entityProcessName;
        }

        public final EntitySyncDataSupplier component4() {
            return this.entitySyncDataSupplier;
        }

        public final int component5() {
            return this.extBindFlags;
        }

        public final InitConfig copy(Application r8, EntitySupplier r9, String r10, EntitySyncDataSupplier r11, int r12) {
            Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r8, Application.class, "com.obric.aiagent.plugin");
            EntitySupplier r3 = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r9, EntitySupplier.class, "com.obric.aiagent.plugin");
            EntitySyncDataSupplier r5 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r11, EntitySyncDataSupplier.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r2, "app");
            return new InitConfig(r2, r3, r10, r5, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, InitConfig.class) == true) goto L8;
            return false;
        L8:
            InitConfig r6 = (InitConfig) ZeusTransformUtils.preCheckCast(r5, InitConfig.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.app, r6.app) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.entitySupplier, r6.entitySupplier) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.entityProcessName, r6.entityProcessName) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.entitySyncDataSupplier, r6.entitySyncDataSupplier) == true) goto L21;
            return false;
        L21:
            if (this.extBindFlags == r6.extBindFlags) goto L23;
            return false;
        L23:
            return true;
        }

        public final Application getApp() {
            return this.app;
        }

        public final String getEntityProcessName() {
            return this.entityProcessName;
        }

        public final EntitySupplier getEntitySupplier() {
            return this.entitySupplier;
        }

        public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
            return this.entitySyncDataSupplier;
        }

        public final int getExtBindFlags() {
            return this.extBindFlags;
        }

        public int hashCode() {
            int r0 = this.app.hashCode() * 31;
            EntitySupplier r1 = this.entitySupplier;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.entityProcessName;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            EntitySyncDataSupplier r8 = this.entitySyncDataSupplier;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return ((r7 + r2) * 31) + Integer.hashCode(this.extBindFlags);
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "InitConfig(app=" + this.app + ", entitySupplier=" + this.entitySupplier + ", entityProcessName=" + this.entityProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ", extBindFlags=" + this.extBindFlags + ')';
        }
    }

    public interface a {
        void a();
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.h.a.b<com.obric.capabilitykit.a, x> f31929a;

        public b(d.h.a.b<? super com.obric.capabilitykit.a, x> r3) {
            this.f31929a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capabilitykit.AtomicCapabilitySdk.a
        public void a() {
            this.f31929a.invoke(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE));
        }
    }

    public static final class c extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f31930a;

        public c(long r1) {
            this.f31930a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.f31930a);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class d extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<PendingIntent> f31931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f31932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f31933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FloatingIntentParams f31934d;

        public d(d.c.d<? super PendingIntent> r3, DispatchContext r4, Intent r5, FloatingIntentParams r6) {
            this.f31931a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31932b = r4;
            this.f31933c = r5;
            this.f31934d = r6;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            this.f31931a.resumeWith(d.n.f(AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.f31932b, this.f31933c, this.f31934d)));
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class e extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f31935a;

        public e(long r1) {
            this.f31935a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31935a);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class f extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.c.d<Boolean> f31936a;

        public f(d.c.d<? super Boolean> r3) {
            this.f31936a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            this.f31936a.resumeWith(d.n.f(Boolean.valueOf(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a())));
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class g extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<?, ?> f31937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31938b;

        public g(IntentFunction<?, ?> r3, String r4) {
            this.f31937a = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntentFunction.class, "com.obric.aiagent.plugin");
            this.f31938b = r4;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            com.obric.capabilitykit.a r5 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r0 = this.f31937a.getName();
            String r1 = this.f31937a.getClass().getName();
            d.h.b.o.c(r1, "function.javaClass.name");
            r5.a(r0, r1, this.f31938b);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class h extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorCodeCallback f31939a;

        public h(ErrorCodeCallback r1) {
            this.f31939a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31939a);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class i extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskStateInfo f31941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskStateChangeCallback f31942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f31943d;

        public i(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4) {
            this.f31940a = r1;
            this.f31941b = r2;
            this.f31942c = r3;
            this.f31943d = r4;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31940a, this.f31941b, this.f31942c, this.f31943d);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class j extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f31944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IUriFileReceiver f31946c;

        public j(Uri r3, String r4, IUriFileReceiver r5) {
            IUriFileReceiver r6 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r5, IUriFileReceiver.class, "com.obric.aiagent.plugin");
            this.f31944a = r3;
            this.f31945b = r4;
            this.f31946c = r6;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31944a, this.f31945b, this.f31946c);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class k extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMAppAction f31947a;

        public k(IMAppAction r1) {
            this.f31947a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31947a);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class l extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentResult<?> f31948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMAppAction f31949b;

        public l(IntentResult<?> r1, IMAppAction r2) {
            this.f31948a = r1;
            this.f31949b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31948a, this.f31949b);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class m extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f31950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f31951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FloatingIntentParams f31952c;

        public m(DispatchContext r1, Intent r2, FloatingIntentParams r3) {
            this.f31950a = r1;
            this.f31951b = r2;
            this.f31952c = r3;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r4) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            PendingIntent r3 = AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.f31950a, this.f31951b, this.f31952c);     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
            if (r3 == null) goto L15;
            r3.send();     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
        L16:
            return;
        L15:
            return;
        L9:
            e = move-exception;
            Logger r5 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("PendingIntent was canceled: ");
            String r6 = e.getMessage();
        L11:
            r5.e(AtomicCapabilitySdk.TAG, r1.append(r6).toString());
            return;
        L7:
            e = move-exception;
            r5 = Logger.INSTANCE;
            r1 = new StringBuilder().append("Error sending PendingIntent: ");
            r6 = e.getMessage();
            goto L11
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class n extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f31953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31954b;

        public n(Uri r1, String r2) {
            this.f31953a = r1;
            this.f31954b = r2;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31953a, this.f31954b);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class o extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<?, ?> f31955a;

        public o(IntentFunction<?, ?> r3) {
            this.f31955a = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntentFunction.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            com.obric.capabilitykit.a r4 = AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE);
            String r0 = this.f31955a.getName();
            String r2 = this.f31955a.getClass().getName();
            d.h.b.o.c(r2, "function.javaClass.name");
            r4.a(r0, r2);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class p extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorCodeCallback f31956a;

        public p(ErrorCodeCallback r1) {
            this.f31956a = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r3) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).b(this.f31956a);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    public static final class q extends d.h.b.p implements d.h.a.b<com.obric.capabilitykit.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntentResult<?> f31957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f31958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f31959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f31960d;

        public q(IntentResult<?> r3, long r4, boolean r6, Map<String, String> r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            this.f31957a = r3;
            this.f31958b = r4;
            this.f31959c = r6;
            this.f31960d = r8;
            super(1);
        }

        public final void a(com.obric.capabilitykit.a r7) {
            d.h.b.o.e((com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"), "it");
            AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a(this.f31957a, this.f31958b, this.f31959c, this.f31960d);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.capabilitykit.a r3) {
            a((com.obric.capabilitykit.a) ZeusTransformUtils.preCheckCast(r3, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        INSTANCE = new AtomicCapabilitySdk();
        mPendingCals = new ArrayList();
        connectionListeners = new CopyOnWriteArraySet();
    }

    private AtomicCapabilitySdk() {
    }

    public static final /* synthetic */ com.obric.capabilitykit.a access$getApi(AtomicCapabilitySdk r0) {
        return r0.getApi();
    }

    public static final void addConnectionListener(d.h.a.a<x> r2) {
        d.h.a.a<x> r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "listener");
        connectionListeners.add(r3);
    }

    private final void addPendingCall(a r4) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        Logger r5 = Logger.INSTANCE;
        r5.i(TAG, "addPendingCall");
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mPendingCallsExecuted == false) goto L10;
        r5.w(TAG, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L19
        r3.a();     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L10:
        if (r0.size() <= 1024) goto L14;
        r5.w(TAG, "addPendingCall too may pending call, drop");     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L14:
        r0.add(r3);     // Catch: Throwable -> L19
        r5.i(TAG, "addPendingCall: queued, pendingSize=" + r0.size() + ", mPendingCallsExecuted=" + mPendingCallsExecuted);     // Catch: Throwable -> L19
        monitor-exit(r0);
    }

    private final void callOrAddPendingCall(d.h.a.b<? super com.obric.capabilitykit.a, x> r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.capabilitykit.a r0 = getApi();
        if (d.h.b.o.a(r0, com.obric.capabilitykit.e.f32077a) == true) goto L5;
        r5.invoke(r0);
        return;
    L5:
        Logger.INSTANCE.i(TAG, "callOrAddPendingCall: api unavailable (Empty), enqueue pending call");
        addPendingCall(new b(r5));
    }

    private final Application checkInit() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    private final void execPendingCalls() {
        Logger r5 = Logger.INSTANCE;
        r5.i(TAG, "execPendingCalls");
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        r5.i(TAG, "execPendingCalls: flush start, pendingSize=" + r0.size());     // Catch: Throwable -> L12
        Iterator<T> r6 = r0.iterator();     // Catch: Throwable -> L12
    L7:
        if (r6.hasNext() == false) goto L9;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Logger.INSTANCE.i(TAG, "exec foreach call");     // Catch: Throwable -> L12
        r1.a();     // Catch: Throwable -> L12
        goto L7
    L9:
        mPendingCals.clear();     // Catch: Throwable -> L12
        mPendingCallsExecuted = true;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final com.obric.capabilitykit.a getApi() {
        return com.obric.capabilitykit.c.f32017a.a(extBindFlags);
    }

    public static final void init(InitConfig r5) {
        d.h.b.o.e(r5, "config");
        Logger.INSTANCE.i(TAG, "AtomicCapabilitySdk init");
        AppHost.Companion.setAppHost(new com.obric.capabilitykit.i((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApp(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")));
        EntityProvider.INSTANCE.init$capabilitykit_release(new EntityInitParam(r5.getEntitySupplier(), r5.getEntityProcessName(), r5.getEntitySyncDataSupplier()));
        extBindFlags = r5.getExtBindFlags();
    }

    public static final void registerIntent(IntentFunction<?, ?> r4, String r5) {
        IntentFunction r6 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntentFunction.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.checkInit(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        r0.callOrAddPendingCall(new g(r6, r5));
    }

    public static /* synthetic */ void registerIntent$default(IntentFunction r1, String r2, int r3, Object r4) {
        IntentFunction r5 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r1, IntentFunction.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        registerIntent(r5, r2);
    }

    public static final void removeConnectionListener(d.h.a.a<x> r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "listener");
        connectionListeners.remove(r3);
    }

    public static /* synthetic */ Object requestStateChanged$default(AtomicCapabilitySdk r6, String r7, TaskStateInfo r8, TaskStateChangeCallback r9, Long r10, d.c.d r11, int r12, Object r13) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L5;
        TaskStateChangeCallback r3 = null;
    L7:
        if ((r12 & 8) == 0) goto L9;
        Long r4 = null;
    L11:
        return r6.requestStateChanged(r7, r8, r3, r4, r5);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static final void setLogger(ILogger r2) {
        ILogger r3 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "logger");
        Logger r0 = Logger.INSTANCE;
        r0.setLogger(r3);
        r0.i(TAG, "AtomicCapabilitySdk setLogger");
    }

    public static final void unregisterIntent(IntentFunction<?, ?> r4) {
        IntentFunction r5 = (IntentFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntentFunction.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "function");
        AtomicCapabilitySdk r0 = INSTANCE;
        Application r1 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.checkInit(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        r0.callOrAddPendingCall(new o(r5));
    }

    public static /* synthetic */ void updateIntentResult$default(AtomicCapabilitySdk r6, IntentResult r7, long r8, boolean r10, Map r11, int r12, Object r13) {
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r6.updateIntentResult(r7, r8, r10, r14);
    }

    public final void finishFloatingActivity(long r2) {
        callOrAddPendingCall(new c(r2));
    }

    public final Object getFloatingPendingIntent(DispatchContext r3, Intent r4, FloatingIntentParams r5, d.c.d<? super PendingIntent> r6) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new d(r7, r3, r4, r5));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r8;
    }

    public final PendingIntent getFloatingPendingIntentNonBlock(DispatchContext r2, Intent r3, FloatingIntentParams r4) {
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r3, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r4, "params");
        Long r1 = r2.getQuestionId();
        if (r1 == null) goto L5;
        long r5 = r1.longValue();
        return INSTANCE.getApi().a(r5, r3, r4);
    L5:
        return null;
    }

    public final void hideIntentResultCard(long r2) {
        callOrAddPendingCall(new e(r2));
    }

    public final Boolean isCardViewVisible(long r1) {
        return getApi().c(r1);
    }

    public final Object isKeyguardReallyLocked(d.c.d<? super Boolean> r3) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r4 = new d.c.i(d.c.a.b.a(r2));
        INSTANCE.callOrAddPendingCall(new f(r4));
        Object r5 = r4.a();
        if (r5 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r2);
    L5:
        return r5;
    }

    public final void onApiInitComplete$capabilitykit_release() {
        execPendingCalls();
    }

    public final void onConnectionClosed$capabilitykit_release() {
        Iterator<T> r4 = connectionListeners.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r4.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Throwable -> L8
        Object r0 = d.n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = d.n.c(r0);
        if (r1 == null) goto L4;
        Logger.INSTANCE.e(TAG, "connectionListener throw exception: " + d.a.a(r1));
    L8:
        th = move-exception;
        r0 = d.n.f(d.o.a(th));
        goto L10
    }

    public final Object openFileDescriptorPrivileged(String r2, Uri r3, d.c.d<? super UriFileAccessSession> r4) {
        d.c.d<? super UriFileAccessSession> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return r.f32199a.a(r2, r3, r1);
    }

    public final Object openInputStream(AppEntity r2, Uri r3, d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r4, d.c.d<? super Integer> r5) {
        d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r1 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d<? super Integer> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return r.f32199a.a(r2, r3, r1, r6);
    }

    public final Object openInputStreamPrivileged(String r2, Uri r3, d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r4, d.c.d<? super Integer> r5) {
        d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r1 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d<? super Integer> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return r.f32199a.a(r2, r3, r1, r6);
    }

    public final void registerResultCallback(ErrorCodeCallback r2) {
        d.h.b.o.e(r2, "listener");
        callOrAddPendingCall(new h(r2));
    }

    public final Object requestStateChanged(String r3, TaskStateInfo r4, TaskStateChangeCallback r5, Long r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        callOrAddPendingCall(new i(r3, r4, r5, r6));
        return x.f38692a;
    }

    public final void requestUriFileAccess$capabilitykit_release(Uri r3, String r4, IUriFileReceiver r5) {
        IUriFileReceiver r6 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r5, IUriFileReceiver.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "uri");
        d.h.b.o.e(r4, "packageName");
        d.h.b.o.e(r6, "requester");
        callOrAddPendingCall(new j(r3, r4, r6));
    }

    public final void sendActionExecuteResult$capabilitykit_release(IMAppAction r2) {
        d.h.b.o.e(r2, "result");
        callOrAddPendingCall(new k(r2));
    }

    public final void sendIntentExecutionResult$capabilitykit_release(IntentResult<?> r2, IMAppAction r3) {
        d.h.b.o.e(r2, "result");
        d.h.b.o.e(r3, "oldResult");
        callOrAddPendingCall(new l(r2, r3));
    }

    public final void setPendingCallsExecuted$capabilitykit_release(boolean r1) {
        List<a> r0 = mPendingCals;
        monitor-enter(r0);
        mPendingCallsExecuted = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void startFloatingActivity(DispatchContext r2, Intent r3, FloatingIntentParams r4) {
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r3, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r4, "params");
        Long r1 = r2.getQuestionId();
        if (r1 == null) goto L6;
        r1.longValue();
        INSTANCE.callOrAddPendingCall(new m(r2, r3, r4));
        return;
    }

    public final void stopUriFileAccess$capabilitykit_release(Uri r2, String r3) {
        d.h.b.o.e(r2, "uri");
        d.h.b.o.e(r3, "packageName");
        callOrAddPendingCall(new n(r2, r3));
    }

    public final void unregisterResultCallback(ErrorCodeCallback r2) {
        d.h.b.o.e(r2, "listener");
        callOrAddPendingCall(new p(r2));
    }

    public final void updateIntentResult(IntentResult<?> r7, long r8, boolean r10, Map<String, String> r11) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "result");
        callOrAddPendingCall(new q(r7, r8, r10, r5));
    }

    public final void updateIntentResult(IntentResult<?> r9, DispatchContext r10, boolean r11) {
        d.h.b.o.e(r9, "result");
        d.h.b.o.e(r10, "dispatchContext");
        Long r0 = r10.getQuestionId();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        updateIntentResult(r9, r1, r11, r10.getExt());
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
