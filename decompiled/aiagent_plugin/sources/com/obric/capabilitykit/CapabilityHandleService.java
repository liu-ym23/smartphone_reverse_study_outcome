package com.obric.capabilitykit;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityActionHandler;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.ca;

/* JADX INFO: loaded from: classes3.dex */
public class CapabilityHandleService extends PluginService {
    private static final Map<String, List<String>> ALLOWED_PACKAGES = null;
    public static final a Companion = null;
    public static final String TAG = "CapabilityHandleService";
    private static final int VERSION = 1;
    private final CapabilityHandleBinder binder;

    public static class CapabilityHandleBinder extends ICapabilityActionHandler.Stub {
        private final boolean shouldEnsureCaller;

        @d.c.b.a.f(b = "CapabilityHandleService.kt", c = {118}, d = "doJobInternal", e = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder")
        public static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f31961a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f31962b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f31963c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f31964d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f31965e;

            public a(CapabilityHandleBinder r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31964d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                this.f31963c = r2;
                this.f31965e |= Integer.MIN_VALUE;
                return CapabilityHandleBinder.access$doJobInternal(this.f31964d, null, null, null, this);
            }
        }

        public static final class b extends d.h.b.p implements d.h.a.b<d.m<? extends String, ? extends ca>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f31966a;

            public b(String r1) {
                this.f31966a = r1;
                super(1);
            }

            public final Boolean a(d.m<String, ? extends ca> r2) {
                d.h.b.o.e(r2, "it");
                return Boolean.valueOf(d.h.b.o.a(r2.a(), this.f31966a));
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(d.m<? extends String, ? extends ca> r3) {
                return a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"));
            }
        }

        public static final class c extends d.h.b.p implements d.h.a.b<d.m<? extends String, ? extends IntentFunction<?, ?>>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f31967a;

            public c(String r1) {
                this.f31967a = r1;
                super(1);
            }

            public final Boolean a(d.m<String, ? extends IntentFunction<?, ?>> r2) {
                d.h.b.o.e(r2, "it");
                return Boolean.valueOf(d.h.b.o.a(r2.a(), this.f31967a));
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(d.m<? extends String, ? extends IntentFunction<?, ?>> r3) {
                return a((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin"));
            }
        }

        public static final class d extends d.h.b.p implements d.h.a.b<Byte, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f31968a = null;

            static {
                f31968a = new d();
            }

            public d() {
                super(1);
            }

            public final CharSequence a(byte r3) {
                String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
                d.h.b.o.c(r2, "java.lang.String.format(format, *args)");
                return r2;
            }

            @Override // d.h.a.b
            public /* synthetic */ CharSequence invoke(Byte r3) {
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).byteValue());
            }
        }

        @d.c.b.a.f(b = "CapabilityHandleService.kt", c = {ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "invokeSuspend", e = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleAction$1$1$1")
        public static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f31969a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IMAppAction f31970b;

            public e(IMAppAction r3, d.c.d<? super e> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31970b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return new e(this.f31970b, r4);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f31969a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r8);
            L13:
                IMAppAction r9 = (IMAppAction) ZeusTransformUtils.preCheckCast(r8, IMAppAction.class, "com.obric.aiagent.plugin");
                Logger.INSTANCE.i(CapabilityHandleService.TAG, "sendActionExecuteResult: " + this.f31970b.getQuestionId() + ' ' + r9.getContent());
                AtomicCapabilitySdk.INSTANCE.sendActionExecuteResult$capabilitykit_release(r9);
            L15:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r8);
                if (this.f31970b.getReplyId() != 0) goto L15;
                ActionDispatcher r10 = ActionDispatcher.INSTANCE;
                IMAppAction r2 = this.f31970b;
                d.h.b.o.c(r2, "action");
                this.f31969a = 1;
                r8 = r10.onActionReceived(r2, this);
                if (r8 != r0) goto L13;
                return r0;
            }
        }

        @d.c.b.a.f(b = "CapabilityHandleService.kt", c = {97}, d = "invokeSuspend", e = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$1")
        public static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f31971a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f31972b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IntentCalling f31973c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f31974d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f31975e;

            public f(CapabilityHandleBinder r3, IntentCalling r4, String r5, String r6, d.c.d<? super f> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31972b = r3;
                this.f31973c = r4;
                this.f31974d = r5;
                this.f31975e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r7, d.c.d<?> r8) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                return new f(this.f31972b, this.f31973c, this.f31974d, this.f31975e, r5);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f31971a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                CapabilityHandleBinder r7 = this.f31972b;
                IntentCalling r2 = this.f31973c;
                String r3 = this.f31974d;
                String r4 = this.f31975e;
                this.f31971a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r7, r2, r3, r4, this) != r0) goto L12;
                return r0;
            }
        }

        @d.c.b.a.f(b = "CapabilityHandleService.kt", c = {101}, d = "invokeSuspend", e = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$2")
        public static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f31976a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f31977b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IntentCalling f31978c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f31979d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f31980e;

            public g(CapabilityHandleBinder r3, IntentCalling r4, String r5, String r6, d.c.d<? super g> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31977b = r3;
                this.f31978c = r4;
                this.f31979d = r5;
                this.f31980e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r7, d.c.d<?> r8) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                return new g(this.f31977b, this.f31978c, this.f31979d, this.f31980e, r5);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f31976a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L12:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                CapabilityHandleBinder r7 = this.f31977b;
                IntentCalling r2 = this.f31978c;
                String r3 = this.f31979d;
                String r4 = this.f31980e;
                this.f31976a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r7, r2, r3, r4, this) != r0) goto L12;
                return r0;
            }
        }

        @d.c.b.a.f(b = "CapabilityHandleService.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$openUriFile$1$1")
        public static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f31981a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Uri f31982b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IUriFileReceiver f31983c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f31984d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f31985e;

            public h(Uri r3, IUriFileReceiver r4, String r5, int r6, d.c.d<? super h> r7) {
                IUriFileReceiver r8 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r4, IUriFileReceiver.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31982b = r3;
                this.f31983c = r8;
                this.f31984d = r5;
                this.f31985e = r6;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r7, d.c.d<?> r8) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                return new h(this.f31982b, this.f31983c, this.f31984d, this.f31985e, r5);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f31981a != 0) goto L7;
                d.o.a(r4);
                Logger.INSTANCE.d(CapabilityHandleService.TAG, "openUriFile: " + this.f31982b + "; opening for receiver: " + this.f31983c);
                new q(this.f31982b, this.f31983c, this.f31984d).a(this.f31985e);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @d.c.b.a.f(b = "CapabilityHandleService.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$stopAction$1$1$1")
        public static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f31986a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f31987b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f31988c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f31989d;

            public i(String r3, String r4, String r5, d.c.d<? super i> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31987b = r3;
                this.f31988c = r4;
                this.f31989d = r5;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return new i(this.f31987b, this.f31988c, this.f31989d, r5);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f31986a != 0) goto L7;
                d.o.a(r3);
                p.f32174a.a(this.f31987b, this.f31988c, this.f31989d);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public CapabilityHandleBinder(boolean r1) {
            this.shouldEnsureCaller = r1;
        }

        public static final /* synthetic */ Object access$doJobInternal(CapabilityHandleBinder r2, IntentCalling r3, String r4, String r5, d.c.d r6) {
            return r2.doJobInternal(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        private final Object doJobInternal(IntentCalling r5, String r6, String r7, d.c.d<? super x> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            int r1 = r0.f31965e;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.f31965e = r1 - Integer.MIN_VALUE;
        L8:
            Object r4 = r0.f31963c;
            Object r10 = d.c.a.b.a();
            int r2 = r0.f31965e;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            r7 = (String) ZeusTransformUtils.preCheckCast(r0.f31962b, String.class, "com.obric.aiagent.plugin");
            r6 = (String) ZeusTransformUtils.preCheckCast(r0.f31961a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r4);
        L17:
            d.m r11 = (d.m) ZeusTransformUtils.preCheckCast(r4, d.m.class, "com.obric.aiagent.plugin");
            IntentResult<?> r12 = (IntentResult) ZeusTransformUtils.preCheckCast(r11.a(), IntentResult.class, "com.obric.aiagent.plugin");
            AtomicCapabilitySdk.INSTANCE.sendIntentExecutionResult$capabilitykit_release(r12, (IMAppAction) ZeusTransformUtils.preCheckCast(r11.b(), IMAppAction.class, "com.obric.aiagent.plugin"));
            if (r12.isFinal() == false) goto L64;
            com.obric.capabilitykit.c r13 = com.obric.capabilitykit.c.f32017a;
            LinkedHashMap<String, Set<d.m<String, ca>>> r14 = r13.c();
            monitor-enter(r14);
        L60:
            th = move-exception;
            throw th;
        L23:
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "doJobInternal jobId: " + r7 + " isFinal = true " + r13.c());     // Catch: Throwable -> L60
            if (Build.VERSION.SDK_INT < 24) goto L31;
            Set r15 = (Set) ZeusTransformUtils.preCheckCast(r13.c().get(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
            if (r15 == null) goto L28;
            final b r16 = new b(r7);     // Catch: Throwable -> L60
            d.c.b.a.b.a(r15.removeIf(new $$Lambda$CapabilityHandleService$CapabilityHandleBinder$YGOJ1Ikjg46BPenEhEQECPEKkPI(r16)));     // Catch: Throwable -> L60
        L28:
            Set r17 = (Set) ZeusTransformUtils.preCheckCast(p.f32174a.a().get(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
            if (r17 == null) goto L58;
            final c r18 = new c(r7);     // Catch: Throwable -> L60
            d.c.b.a.b.a(r17.removeIf(new $$Lambda$CapabilityHandleService$CapabilityHandleBinder$yx3x9I_D_5Fw2mIsBaiCYQc1XY(r18)));     // Catch: Throwable -> L60
        L58:
            monitor-exit(r14);
            goto L64
        L31:
            Set r19 = (Set) ZeusTransformUtils.preCheckCast(r13.c().get(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
            Iterator r20 = null;
            if (r19 == null) goto L34;
            Iterator r21 = r19.iterator();     // Catch: Throwable -> L60
        L36:
            if (r21 != null) goto L38;
        L40:
            boolean r3 = false;
        L41:
            if (r3 == false) goto L45;
            if (d.h.b.o.a(((d.m) ZeusTransformUtils.preCheckCast(r21.next(), d.m.class, "com.obric.aiagent.plugin")).a(), r7) == false) goto L36;
            r21.remove();     // Catch: Throwable -> L60
            goto L36
        L45:
            Set r22 = (Set) ZeusTransformUtils.preCheckCast(p.f32174a.a().get(r6), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
            if (r22 == null) goto L48;
            r20 = r22.iterator();     // Catch: Throwable -> L60
        L48:
            if (r20 != null) goto L50;
        L52:
            boolean r23 = false;
        L53:
            if (r23 == false) goto L58;
            if (d.h.b.o.a(((d.m) ZeusTransformUtils.preCheckCast(r20.next(), d.m.class, "com.obric.aiagent.plugin")).a(), r7) == false) goto L48;
            r20.remove();     // Catch: Throwable -> L60
            goto L48
        L50:
            if (r20.hasNext() != true) goto L52;
            r23 = true;
            goto L53
        L38:
            if (r21.hasNext() != true) goto L40;
            r3 = true;
            goto L41
        L34:
            r21 = null;
        L64:
            return x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r4);
            o r24 = o.f32167a;
            r0.f31961a = r6;
            r0.f31962b = r7;
            r0.f31965e = 1;
            r4 = r24.a(r5, r7, r0);
            if (r4 != r10) goto L17;
            return r10;
        L7:
            r0 = new a(this, r9);
            goto L8
        }

        private static final boolean doJobInternal$lambda$10$lambda$8(d.h.a.b r2, Object r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "$tmp0");
            return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }

        private static final boolean doJobInternal$lambda$10$lambda$9(d.h.a.b r2, Object r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "$tmp0");
            return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }

        private final boolean ensureCaller() {
            if (this.shouldEnsureCaller == true) goto L5;
            return true;
        L5:
            PackageManager r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
            if (r0.checkSignatures(1000, Binder.getCallingUid()) != 0) goto L8;
            return true;
        L8:
            String r3 = r0.getNameForUid(Binder.getCallingUid());
            if (r3 == null) goto L14;
            if (r0.checkSignatures("android", r3) != 0) goto L14;
            return true;
        L14:
            if (r3 != null) goto L16;
        L18:
            boolean r5 = false;
        L19:
            if (r5 == true) goto L21;
            return false;
        L21:
            List r2 = (List) ZeusTransformUtils.preCheckCast(CapabilityHandleService.access$getALLOWED_PACKAGES$cp().get(r3), List.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L24;
        L27:
            boolean r6 = true;
        L29:
            if (r6 == true) goto L48;
            if (r2 != null) goto L32;
        L35:
            boolean r7 = true;
        L36:
            if (r7 == true) goto L48;
            Signature[] r1 = r0.getPackageInfo(r3, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L46
            MessageDigest r8 = MessageDigest.getInstance("SHA-256");     // Catch: PackageManager.NameNotFoundException -> L46
            d.h.b.o.c(r1, "signatures");     // Catch: PackageManager.NameNotFoundException -> L46
            int r9 = r1.length;     // Catch: PackageManager.NameNotFoundException -> L46
            int r10 = 0;
        L39:
            if (r10 >= r9) goto L48;
            r8.update(r1[r10].toByteArray());     // Catch: PackageManager.NameNotFoundException -> L46
            byte[] r11 = r8.digest();     // Catch: PackageManager.NameNotFoundException -> L46
            d.h.b.o.c(r11, "messageDigest.digest()");     // Catch: PackageManager.NameNotFoundException -> L46
            if (r2.contains(d.a.i.a(r11, "", null, null, 0, null, d.f31968a, 30, null)) == true) goto L44;
            r10 = r10 + 1;
            goto L39
        L44:
            return true;
        L46:
            e = move-exception;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "ensureCaller failed", e);
            goto L48
        L32:
            if (r2.isEmpty() == true) goto L35;
            r7 = false;
        L48:
            Logger.INSTANCE.e(CapabilityHandleService.TAG, r3 + " not in allowed packages");
            return false;
        L24:
            if (r3.length() == 0) goto L27;
            r6 = false;
            goto L29
        L16:
            if (PackageUtils.INSTANCE.isPrivilegedApp(r3) != true) goto L18;
            r5 = true;
            goto L19
        }

        public static /* synthetic */ boolean lambda$YGOJ1Ikjg46BPenEhEQECPEKkPI(d.h.a.b r0, Object r1) {
            return doJobInternal$lambda$10$lambda$8(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$yx3x9I_D_5F-w2mIsBaiCYQc1XY, reason: not valid java name */
        public static /* synthetic */ boolean m923lambda$yx3x9I_D_5Fw2mIsBaiCYQc1XY(d.h.a.b r0, Object r1) {
            return doJobInternal$lambda$10$lambda$9(r0, r1);
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() {
            return 1;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(String r7) {
            Logger r6 = Logger.INSTANCE;
            r6.w(CapabilityHandleService.TAG, "handleAction: AppAction is deprecated and is replaced by the AppIntent framework.");
            r6.d(CapabilityHandleService.TAG, "doAction: " + r7);     // Catch: Throwable -> L13
            IMAppAction r8 = (IMAppAction) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r7, IMAppAction.class), IMAppAction.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
            if (r8 == null) goto L10;
            d.h.b.o.c(r8, "action");     // Catch: Throwable -> L13
            StringBuilder r2 = new StringBuilder().append("doAction questionId:").append(r8.getQuestionId()).append(", dispatchStarted=");     // Catch: Throwable -> L13
            ActionDispatcher r3 = ActionDispatcher.INSTANCE;     // Catch: Throwable -> L13
            r6.i(CapabilityHandleService.TAG, r2.append(r3.getDispatchStartedQuestion()).toString());     // Catch: Throwable -> L13
            Long r9 = r8.getQuestionId();     // Catch: Throwable -> L13
            if (r9 == null) goto L8;
            long r4 = r9.longValue();     // Catch: Throwable -> L13
        L9:
            r3.launchWithTrace(r4, new e(r8, null));     // Catch: Throwable -> L13
            goto L10
        L8:
            r4 = -1;
        L10:
            if (r8 == null) goto L20;
            return true;
        L20:
            return false;
        L13:
            th = move-exception;
            Throwable r10 = d.n.c(d.n.f(d.o.a(th)));
            if (r10 == null) goto L17;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleAction fail: " + d.a.a(r10));
        L17:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleIntentCalling(IntentCalling r14) {
            Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L36
            StringBuilder r3 = new StringBuilder().append("doIntent: name=");     // Catch: Throwable -> L36
            String r4 = null;
            if (r14 == null) goto L8;
            String r5 = r14.getIntentName();     // Catch: Throwable -> L36
        L9:
            r1.d(CapabilityHandleService.TAG, r3.append(r5).toString());     // Catch: Throwable -> L36
            if (r14 != null) goto L12;
        L33:
            if (r14 == null) goto L44;
            return true;
        L44:
            return false;
        L12:
            r1.i(CapabilityHandleService.TAG, "handleIntentCalling questionId:" + r14.getQuestionId());     // Catch: Throwable -> L36
            String r2 = String.valueOf(r14.getQuestionId());     // Catch: Throwable -> L36
            String r6 = UUID.randomUUID().toString();     // Catch: Throwable -> L36
            d.h.b.o.c(r6, "randomUUID().toString()");     // Catch: Throwable -> L36
            r1.i(CapabilityHandleService.TAG, "handleIntentCalling jobId: " + r6);     // Catch: Throwable -> L36
            Map<String, String> r7 = r14.getExt();     // Catch: Throwable -> L36
            if (r7 == null) goto L18;
            r4 = (String) ZeusTransformUtils.preCheckCast(r7.get(Ext.KEY_IS_PARALLEL), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        L18:
            if (d.h.b.o.a(r4, "true") == false) goto L21;
            am r8 = ActionDispatcher.INSTANCE.getParallelScope();     // Catch: Throwable -> L36
            d.c.g r9 = null;
            ao r11 = null;
            d.h.a.m r12 = new f(this, r14, r2, r6, null);     // Catch: Throwable -> L36
        L20:
            ca r13 = kotlinx.coroutines.i.a(r8, r9, r11, r12, 3, null);     // Catch: Throwable -> L36
            com.obric.capabilitykit.c r10 = com.obric.capabilitykit.c.f32017a;     // Catch: Throwable -> L36
            LinkedHashMap<String, Set<d.m<String, ca>>> r15 = r10.c();     // Catch: Throwable -> L36
            monitor-enter(r15);     // Catch: Throwable -> L36
            LinkedHashMap<String, Set<d.m<String, ca>>> r16 = r10.c();     // Catch: Throwable -> L30
            Set<d.m<String, ca>> r17 = r16.get(r2);     // Catch: Throwable -> L30
            if (r17 != null) goto L27;
            r17 = new LinkedHashSet();     // Catch: Throwable -> L30
            r16.put(r2, r17);     // Catch: Throwable -> L30
        L27:
            ((Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.aiagent.plugin")).add(d.s.a(r6, r13));     // Catch: Throwable -> L30
            monitor-exit(r15);     // Catch: Throwable -> L36
            goto L33
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L21:
            r8 = ActionDispatcher.INSTANCE.getScope();     // Catch: Throwable -> L36
            r9 = null;
            r11 = null;
            r12 = new g(this, r14, r2, r6, null);     // Catch: Throwable -> L36
            goto L20
        L8:
            r5 = null;
        L36:
            th = move-exception;
            Throwable r18 = d.n.c(d.n.f(d.o.a(th)));
            if (r18 == null) goto L40;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleIntentCalling fail: " + d.a.a(r18));
        L40:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int isTaskRunning(String r8, String r9) {
            d.h.b.o.e(r8, "messageId");
            d.h.b.o.e(r9, "jobId");
            com.obric.capabilitykit.c r7 = com.obric.capabilitykit.c.f32017a;
            LinkedHashMap<String, Set<d.m<String, ca>>> r0 = r7.c();
            monitor-enter(r0);
            Set r10 = (Set) ZeusTransformUtils.preCheckCast(r7.c().get(r8), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
            int r1 = 1;
            if (r10 == null) goto L24;
            d.h.b.o.c(r10, "jobMap[messageId]");     // Catch: Throwable -> L27
            Iterator r11 = r10.iterator();     // Catch: Throwable -> L27
        L8:
            if (r11.hasNext() == false) goto L12;
            Object r3 = r11.next();     // Catch: Throwable -> L27
            if (d.h.b.o.a(((d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin")).a(), r9) == false) goto L8;
        L13:
            d.m r12 = (d.m) ZeusTransformUtils.preCheckCast(r3, d.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
            if (r12 == null) goto L24;
            ca r13 = (ca) ZeusTransformUtils.preCheckCast(r12.d(), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
            if (r13.b() == false) goto L18;
            ca.a.a(r13, null, 1, null);     // Catch: Throwable -> L27
        L18:
            Boolean r14 = p.f32174a.a(r8, r9);     // Catch: Throwable -> L27
            if (d.h.b.o.a(r14, Boolean.TRUE) == true) goto L25;
            if (d.h.b.o.a(r14, Boolean.FALSE) == false) goto L24;
            r1 = 2;
        L25:
            monitor-exit(r0);
            return r1;
        L12:
            r3 = null;
        L24:
            r1 = 0;
        L27:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler.Stub, android.os.Binder
        public boolean onTransact(int r3, Parcel r4, Parcel r5, int r6) {
            d.h.b.o.e(r4, "data");
        L9:
            th = move-exception;
            Logger.INSTANCE.w(CapabilityHandleService.TAG, "onTransact throws error. It is likely that an error occurred during parameter transferring. th=" + th, th);
            throw th;
        L4:
            if (ensureCaller() == true) goto L8;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "onTransact " + r3 + ", caller not matched.");     // Catch: Throwable -> L9
            return false;
        L8:
            return super.onTransact(r3, r4, r5, r6);
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean openUriFile(Uri r19, IUriFileReceiver r20, String r21) {
            IUriFileReceiver r8 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r20, IUriFileReceiver.class, "com.obric.aiagent.plugin");
            if (ensureCaller() == true) goto L24;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", caller not matched.");
            return false;
        L24:
            Logger r12 = Logger.INSTANCE;     // Catch: Throwable -> L19
            r12.d(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", receiver: " + r8 + ", receiverPackage&Pid: " + r21);     // Catch: Throwable -> L19
            if (r19 == null) goto L17;
            if (r8 == null) goto L17;
            if (r21 == null) goto L17;
            List r1 = d.o.o.b(r21, new String[]{";"}, false, 0, 6, null);     // Catch: Throwable -> L19
            if (r1.size() == 2) goto L15;
            r12.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", unknown receiver pid");     // Catch: Throwable -> L19
            return false;
        L15:
            kotlinx.coroutines.i.a(ActionDispatcher.INSTANCE.getScope(), null, null, new h(r19, r8, (String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.aiagent.plugin"), Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.aiagent.plugin")), null), 3, null);     // Catch: Throwable -> L19
            return true;
        L17:
            r12.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", invalid params.");     // Catch: Throwable -> L19
            return false;
        L19:
            th = move-exception;
            Throwable r0 = d.n.c(d.n.f(d.o.a(th)));
            if (r0 == null) goto L23;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile fail: " + d.a.a(r0));
        L23:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopAction(String r13, String r14) {
            d.h.b.o.e(r13, "messageId");
            d.h.b.o.e(r14, "reason");
            Logger r12 = Logger.INSTANCE;
            StringBuilder r0 = new StringBuilder().append("stopAction: ").append(r13).append(" reason: ").append(r14).append(" jobMap ");
            com.obric.capabilitykit.c r1 = com.obric.capabilitykit.c.f32017a;
            r12.d(CapabilityHandleService.TAG, r0.append(r1.c()).toString());
            LinkedHashMap<String, Set<d.m<String, ca>>> r15 = r1.c();
            monitor-enter(r15);
            Set r2 = (Set) ZeusTransformUtils.preCheckCast(r1.c().get(r13), Set.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            boolean r3 = true;
            if (r2 == null) goto L13;
            d.h.b.o.c(r2, "jobMap[messageId]");     // Catch: Throwable -> L19
            Iterator r4 = r2.iterator();     // Catch: Throwable -> L19
        L8:
            if (r4.hasNext() == false) goto L13;
            d.m r5 = (d.m) ZeusTransformUtils.preCheckCast(r4.next(), d.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            ca r7 = (ca) ZeusTransformUtils.preCheckCast(r5.d(), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            if (r7.b() == false) goto L12;
            ca.a.a(r7, null, 1, null);     // Catch: Throwable -> L19
        L12:
            kotlinx.coroutines.i.a(ActionDispatcher.INSTANCE.getScope(), null, null, new i(r13, r14, r6, null), 3, null);     // Catch: Throwable -> L19
        L13:
            if (com.obric.capabilitykit.c.f32017a.c().remove(r13) != null) goto L17;
            r3 = false;
        L17:
            monitor-exit(r15);
            return r3;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopComplexTask(String r2) {
            d.h.b.o.e(r2, "messageId");
            return stopAction(r2, "user stop in complex task");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        ALLOWED_PACKAGES = d.a.ao.a(d.s.a("com.larus.nova", d.a.p.a("ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a")));
    }

    public CapabilityHandleService() {
        this.binder = new CapabilityHandleBinder(true);
    }

    public static final /* synthetic */ Map access$getALLOWED_PACKAGES$cp() {
        return ALLOWED_PACKAGES;
    }

    public IBinder onBind(Intent r3) {
        d.h.b.o.e(r3, MemorySourceLinkType.INTENT);
        Logger.INSTANCE.i(TAG, "onBind");
        return this.binder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        AppHost.Companion r0 = AppHost.Companion;
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "application");
        r0.setAppHost(new i(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        Logger.INSTANCE.i(TAG, "onDestroy");
    }
}
