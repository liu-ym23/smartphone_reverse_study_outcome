package com.stepos.ailauncher.chat.api;

import La.D;
import La.H;
import Ua.M;
import Y8.j;
import Y8.t;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.CreateVMBody;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReInstallVMRequest;
import kotlin.collections.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import tb.AbstractC5531D;
import tb.C5528A;
import yc.v;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042(\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0082@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0013\u0010\u0012J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0019\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001a\u0010\u0012J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001c\u0010\u0010J\u0010\u0010\u001d\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMApi;", "", "<init>", "()V", "", "logName", "Lkotlin/Function2;", "Lcom/stepos/ailauncher/chat/api/VMService;", "Le9/c;", "Lyc/v;", "Ltb/D;", "call", "executeVMApi", "(Ljava/lang/String;Lp9/p;Le9/c;)Ljava/lang/Object;", "inviteCode", "createVM", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "deleteVM", "(Le9/c;)Ljava/lang/Object;", "doctorFixVM", "LK6/z;", "request", "deleteMemory", "reInstallVM", "(LK6/z;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "restartVM", "queryVMStatus", "action", "powerVM", "deleteVMMemory", "TAG", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VMApi {
    private final String TAG = "VMApi";
    private final Gson gson = new Gson();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$createVM$2", f = "VMApi.kt", l = {84}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$createVM$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        final /* synthetic */ String $inviteCode;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$inviteCode = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$inviteCode, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((AnonymousClass2) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            CreateVMBody createVMBody = new CreateVMBody(this.$inviteCode);
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objCreateVM = vMService.createVM(createVMBody, this);
            return objCreateVM == objG ? objG : objCreateVM;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$deleteVM$2", f = "VMApi.kt", l = {88}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$deleteVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25202 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C25202(InterfaceC4014c<? super C25202> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25202 c25202 = new C25202(interfaceC4014c);
            c25202.L$0 = obj;
            return c25202;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25202) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objDeleteVM = vMService.deleteVM(this);
            return objDeleteVM == objG ? objG : objDeleteVM;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$deleteVMMemory$2", f = "VMApi.kt", l = {108}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$deleteVMMemory$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25212 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C25212(InterfaceC4014c<? super C25212> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25212 c25212 = new C25212(interfaceC4014c);
            c25212.L$0 = obj;
            return c25212;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25212) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objDeleteVMMemory = vMService.deleteVMMemory(this);
            return objDeleteVMMemory == objG ? objG : objDeleteVMMemory;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$doctorFixVM$2", f = "VMApi.kt", l = {91}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$doctorFixVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25222 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C25222(InterfaceC4014c<? super C25222> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25222 c25222 = new C25222(interfaceC4014c);
            c25222.L$0 = obj;
            return c25222;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25222) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objDoctorFixVM = vMService.doctorFixVM(this);
            return objDoctorFixVM == objG ? objG : objDoctorFixVM;
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi", f = "VMApi.kt", l = {22}, m = "executeVMApi", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$executeVMApi$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VMApi.this.executeVMApi(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "kotlin.jvm.PlatformType", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$executeVMApi$2", f = "VMApi.kt", l = {26}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$executeVMApi$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25232 extends SuspendLambda implements p<M, InterfaceC4014c<? super String>, Object> {
        final /* synthetic */ p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> $call;
        final /* synthetic */ String $logName;
        Object L$0;
        int label;
        final /* synthetic */ VMApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C25232(String str, p<? super VMService, ? super InterfaceC4014c<? super v<AbstractC5531D>>, ? extends Object> pVar, VMApi vMApi, InterfaceC4014c<? super C25232> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$logName = str;
            this.$call = pVar;
            this.this$0 = vMApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C25232(this.$logName, this.$call, this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super String> interfaceC4014c) {
            return ((C25232) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objInvoke;
            AbstractC5531D abstractC5531DD;
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    C4148a.k("OpenTrace", "VMApi." + this.$logName + " start t=" + SystemClock.elapsedRealtime(), false, 4, null);
                    VMService vMService = (VMService) HttpManager.INSTANCE.create(VMService.class, "__default__");
                    p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> pVar = this.$call;
                    this.L$0 = h.a(vMService);
                    this.label = 1;
                    objInvoke = pVar.invoke(vMService, this);
                    if (objInvoke == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                    objInvoke = obj;
                }
                v vVar = (v) objInvoke;
                C5528A request = vVar.h().getRequest();
                C4148a.d("VmConfigDiag", this.$logName + " url=" + request.getUrl().getScheme() + "://" + request.getUrl().getHost() + request.getUrl().c() + " httpCode=" + vVar.b() + " requestId=" + request.e("X-Request-Id") + " traceId=" + vVar.e().b("zy-trace-id"), false, 4, null);
                try {
                    String strA = (!vVar.f() ? (abstractC5531DD = vVar.d()) != null : (abstractC5531DD = (AbstractC5531D) vVar.a()) != null) ? null : abstractC5531DD.A();
                    C4148a.k(this.this$0.TAG, this.$logName + " raw: " + strA, false, 4, null);
                    C4148a.k("OpenTrace", "VMApi." + this.$logName + " done t=" + SystemClock.elapsedRealtime(), false, 4, null);
                    if (strA == null || H.x0(strA)) {
                        return this.this$0.getGson().toJson(a.m(j.a("code", C4109a.f(vVar.b())), j.a(C3081a.ERROR_MSG, "raw is empty"), j.a("data", "{}")));
                    }
                    String string = H.D1(strA).toString();
                    return ((D.X(string, Const.STR_MART_JSON_BEGIN, false, 2, null) && D.K(string, "}", false, 2, null)) || (D.X(string, "[", false, 2, null) && D.K(string, "]", false, 2, null))) ? strA : this.this$0.getGson().toJson(a.m(j.a("code", C4109a.f(vVar.b())), j.a("data", strA)));
                } catch (Throwable th) {
                    C4148a.g(this.this$0.TAG, this.$logName + " read body: " + th.getMessage(), th, false, 8, null);
                    Gson gson = this.this$0.getGson();
                    Pair pairA = j.a("code", C4109a.f(vVar.b()));
                    String message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    return gson.toJson(a.m(pairA, j.a(C3081a.ERROR_MSG, message)));
                }
            } catch (Throwable th2) {
                C4148a.g(this.this$0.TAG, this.$logName + ": " + th2.getMessage(), th2, false, 8, null);
                Gson gson2 = this.this$0.getGson();
                Pair pairA2 = j.a("code", C4109a.f(-1));
                String message2 = th2.getMessage();
                if (message2 == null) {
                    message2 = "unknown";
                }
                return gson2.toJson(a.m(pairA2, j.a(C3081a.ERROR_MSG, message2)));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$powerVM$2", f = "VMApi.kt", l = {105}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$powerVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25242 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        final /* synthetic */ String $action;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C25242(String str, InterfaceC4014c<? super C25242> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$action = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25242 c25242 = new C25242(this.$action, interfaceC4014c);
            c25242.L$0 = obj;
            return c25242;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25242) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            String str = this.$action;
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objPowerVM = vMService.powerVM(str, this);
            return objPowerVM == objG ? objG : objPowerVM;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$queryVMStatus$2", f = "VMApi.kt", l = {102}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$queryVMStatus$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25252 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C25252(InterfaceC4014c<? super C25252> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25252 c25252 = new C25252(interfaceC4014c);
            c25252.L$0 = obj;
            return c25252;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25252) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objQueryVMStatus = vMService.queryVMStatus(this);
            return objQueryVMStatus == objG ? objG : objQueryVMStatus;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$reInstallVM$2", f = "VMApi.kt", l = {95}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$reInstallVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25262 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        final /* synthetic */ String $deleteMemory;
        final /* synthetic */ ReInstallVMRequest $request;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C25262(ReInstallVMRequest reInstallVMRequest, String str, InterfaceC4014c<? super C25262> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = reInstallVMRequest;
            this.$deleteMemory = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25262 c25262 = new C25262(this.$request, this.$deleteMemory, interfaceC4014c);
            c25262.L$0 = obj;
            return c25262;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25262) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            String lowerCase = this.$request.getModel().name().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            String str = this.$deleteMemory;
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objReInstallVM = vMService.reInstallVM(lowerCase, str, this);
            return objReInstallVM == objG ? objG : objReInstallVM;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/ailauncher/chat/api/VMService;", "it", "Lyc/v;", "Ltb/D;", "<anonymous>", "(Lcom/stepos/ailauncher/chat/api/VMService;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.api.VMApi$restartVM$2", f = "VMApi.kt", l = {99}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.api.VMApi$restartVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C25272 extends SuspendLambda implements p<VMService, InterfaceC4014c<? super v<AbstractC5531D>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C25272(InterfaceC4014c<? super C25272> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C25272 c25272 = new C25272(interfaceC4014c);
            c25272.L$0 = obj;
            return c25272;
        }

        @Override // p9.p
        public final Object invoke(VMService vMService, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c) {
            return ((C25272) create(vMService, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            VMService vMService = (VMService) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            this.L$0 = h.a(vMService);
            this.label = 1;
            Object objRestartVM = vMService.restartVM(this);
            return objRestartVM == objG ? objG : objRestartVM;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeVMApi(java.lang.String r6, p9.p<? super com.stepos.ailauncher.chat.api.VMService, ? super e9.InterfaceC4014c<? super yc.v<tb.AbstractC5531D>>, ? extends java.lang.Object> r7, e9.InterfaceC4014c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.chat.api.VMApi.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.chat.api.VMApi$executeVMApi$1 r0 = (com.stepos.ailauncher.chat.api.VMApi.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.api.VMApi$executeVMApi$1 r0 = new com.stepos.ailauncher.chat.api.VMApi$executeVMApi$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$1
            p9.p r5 = (p9.p) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r8)
            goto L5b
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.C4849c.b(r8)
            Ua.I r8 = Ua.Y.b()
            com.stepos.ailauncher.chat.api.VMApi$executeVMApi$2 r2 = new com.stepos.ailauncher.chat.api.VMApi$executeVMApi$2
            r4 = 0
            r2.<init>(r6, r7, r5, r4)
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r7)
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = Ua.C1056g.j(r8, r2, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.p.h(r8, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.api.VMApi.executeVMApi(java.lang.String, p9.p, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object reInstallVM$default(VMApi vMApi, ReInstallVMRequest reInstallVMRequest, String str, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "true";
        }
        return vMApi.reInstallVM(reInstallVMRequest, str, interfaceC4014c);
    }

    public final Object createVM(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("createVM", new AnonymousClass2(str, null), interfaceC4014c);
    }

    public final Object deleteVM(InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("deleteVM", new C25202(null), interfaceC4014c);
    }

    public final Object deleteVMMemory(InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("deleteVMMemory", new C25212(null), interfaceC4014c);
    }

    public final Object doctorFixVM(InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("doctorFixVM", new C25222(null), interfaceC4014c);
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final Object powerVM(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("powerVM", new C25242(str, null), interfaceC4014c);
    }

    public final Object queryVMStatus(InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("queryVMStatus", new C25252(null), interfaceC4014c);
    }

    public final Object reInstallVM(ReInstallVMRequest reInstallVMRequest, String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("reInstallVM", new C25262(reInstallVMRequest, str, null), interfaceC4014c);
    }

    public final Object restartVM(InterfaceC4014c<? super String> interfaceC4014c) {
        return executeVMApi("restartVM", new C25272(null), interfaceC4014c);
    }
}
