package com.stepos.taskrobot.vdbroadcast;

import C7.r;
import D7.v;
import D7.w;
import S7.n;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.ComposerKt;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.ability.OpenOnDisplayResult;
import com.stepos.taskrobot.ability.a;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import f6.AbstractC1436a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import stepai.android.llm.base.twoway.FlowType;
import u6.C2041a;
import u6.c;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJU\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J[\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJs\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010 J\u0017\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\u00020\u000e*\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\u0003J\u001b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b)\u0010*J)\u0010-\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u0010\u0003R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/stepos/taskrobot/vdbroadcast/VdTaskService;", "Landroid/app/Service;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Intent;", "intent", "LC7/r;", "handleStart", "(Landroid/content/Intent;)V", "handleCancel", "Lu6/a;", "task", "", NotificationCompat.CATEGORY_EVENT, "", "errorCode", "errorMessage", "reason", "", "joinStartJob", "notify", "terminate", "(Lu6/a;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZ)V", WindowStateInfo.KEY_DISPLAY_ID, "", "elapsedMs", "sendEvent", "(Lu6/a;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "requestId", "callbackPackage", "callbackAction", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "isCallerTrusted", "(Ljava/lang/String;)Z", "Lcom/stepos/taskrobot/ability/OpenOnDisplayResult$Reason;", "toErrorCode", "(Lcom/stepos/taskrobot/ability/OpenOnDisplayResult$Reason;)I", "stopIfIdle", AppAgent.ON_CREATE, "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Lcom/stepos/taskrobot/ability/a;", "mdi", "Lcom/stepos/taskrobot/ability/a;", "Lm9/z;", "scope", "Lm9/z;", "Ljava/util/concurrent/ConcurrentHashMap;", "tasks", "Ljava/util/concurrent/ConcurrentHashMap;", "lastStartId", "I", "destroying", "Z", "Companion", "u6/c", "vdbroadcast_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VdTaskService extends Service {
    public static final c Companion = new c();
    private static final long START_JOB_JOIN_TIMEOUT_MS = 45000;
    private static final String TAG = "vdbroadcast";
    private volatile boolean destroying;
    private volatile int lastStartId;
    private a mdi;
    private final InterfaceC1733z scope;
    private final ConcurrentHashMap<String, C2041a> tasks;

    @J7.c(c = "com.stepos.taskrobot.vdbroadcast.VdTaskService$handleStart$1", f = "VdTaskService.kt", l = {185}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.vdbroadcast.VdTaskService$handleStart$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f4070a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ VdTaskService d;
        public final /* synthetic */ C2041a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j5, String str, VdTaskService vdTaskService, C2041a c2041a, H7.c cVar) {
            super(2, cVar);
            this.b = j5;
            this.c = str;
            this.d = vdTaskService;
            this.e = c2041a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, this.c, this.d, this.e, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4070a;
            long j5 = this.b;
            if (i == 0) {
                b.b(obj);
                this.f4070a = 1;
                if (kotlinx.coroutines.a.f(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            StringBuilder sb = new StringBuilder("timeout fired: requestId=");
            sb.append(this.c);
            sb.append(" after ");
            sb.append(j5);
            com.stepos.statsrpk.service.c.r(sb, "ms", VdTaskService.TAG, true);
            VdTaskService.terminate$default(this.d, this.e, InjectExperienceResult.REASON_TIMEOUT, null, null, null, true, false, 92, null);
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.vdbroadcast.VdTaskService$handleStart$2", f = "VdTaskService.kt", l = {195}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.vdbroadcast.VdTaskService$handleStart$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f4071a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ C2041a f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, boolean z10, C2041a c2041a, String str3, H7.c cVar) {
            super(2, cVar);
            this.c = str;
            this.d = str2;
            this.e = z10;
            this.f = c2041a;
            this.g = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return VdTaskService.this.new AnonymousClass2(this.c, this.d, this.e, this.f, this.g, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r rVar = r.f317a;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4071a;
            if (i == 0) {
                b.b(obj);
                a aVar = VdTaskService.this.mdi;
                if (aVar == null) {
                    k.n("mdi");
                    throw null;
                }
                String str = this.c;
                String str2 = this.d;
                boolean z10 = this.e;
                this.f4071a = 1;
                obj = aVar.j(str, str2, z10, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            OpenOnDisplayResult openOnDisplayResult = (OpenOnDisplayResult) obj;
            if (openOnDisplayResult instanceof Z5.c) {
                if (this.f.k.get()) {
                    AbstractC1436a.e(VdTaskService.TAG, "start finished but task already terminated: requestId=".concat(this.g), true);
                    return rVar;
                }
                this.f.h = VdTaskState.b;
                Z5.c cVar = (Z5.c) openOnDisplayResult;
                AbstractC1436a.d(VdTaskService.TAG, "start success: requestId=" + this.g + " displayId=" + cVar.b, true);
                VdTaskService.sendEvent$default(VdTaskService.this, this.f, "success", new Integer(cVar.b), null, null, null, null, MenuKt.InTransitionDuration, null);
                return rVar;
            }
            if (!(openOnDisplayResult instanceof com.stepos.taskrobot.ability.b)) {
                throw new NoWhenBranchMatchedException();
            }
            com.stepos.taskrobot.ability.b bVar = (com.stepos.taskrobot.ability.b) openOnDisplayResult;
            AbstractC1436a.b(VdTaskService.TAG, "start failed: requestId=" + this.g + " reason=" + bVar.f4023a + " detail=" + bVar.b, true);
            VdTaskService vdTaskService = VdTaskService.this;
            VdTaskService.terminate$default(vdTaskService, this.f, FlowType.FAILED, new Integer(vdTaskService.toErrorCode(bVar.f4023a)), bVar.b, null, false, false, 80, null);
            return rVar;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.vdbroadcast.VdTaskService$onDestroy$2", f = "VdTaskService.kt", l = {462}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.vdbroadcast.VdTaskService$onDestroy$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12012 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public Iterator f4072a;
        public C2041a b;
        public int c;
        public final /* synthetic */ List d;
        public final /* synthetic */ VdTaskService e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12012(List list, VdTaskService vdTaskService, H7.c cVar) {
            super(2, cVar);
            this.d = list;
            this.e = vdTaskService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C12012(this.d, this.e, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C12012) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0060 -> B:26:0x008d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0066 -> B:26:0x008d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007d -> B:23:0x0080). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 231
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.vdbroadcast.VdTaskService.C12012.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @J7.c(c = "com.stepos.taskrobot.vdbroadcast.VdTaskService$terminate$1", f = "VdTaskService.kt", l = {302}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.vdbroadcast.VdTaskService$terminate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12021 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f4074a;
        public final /* synthetic */ C2041a b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ VdTaskService d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Integer g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12021(C2041a c2041a, boolean z10, VdTaskService vdTaskService, boolean z11, String str, Integer num, String str2, String str3, H7.c cVar) {
            super(2, cVar);
            this.b = c2041a;
            this.c = z10;
            this.d = vdTaskService;
            this.e = z11;
            this.f = str;
            this.g = num;
            this.h = str2;
            this.i = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C12021(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C12021) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.vdbroadcast.VdTaskService.C12021.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public VdTaskService() {
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.scope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        this.tasks = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleCancel(android.content.Intent r15) {
        /*
            r14 = this;
            java.lang.String r0 = "requestId"
            java.lang.String r2 = r15.getStringExtra(r0)
            r0 = 1
            java.lang.String r1 = "vdbroadcast"
            if (r2 == 0) goto L11
            boolean r3 = j9.m.s0(r2)
            if (r3 == 0) goto L14
        L11:
            r4 = r14
            goto La1
        L14:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, u6.a> r3 = r14.tasks
            java.lang.Object r3 = r3.get(r2)
            r5 = r3
            u6.a r5 = (u6.C2041a) r5
            java.lang.String r3 = "callbackPackage"
            if (r5 != 0) goto L6f
            java.lang.String r4 = "handleCancel: requestId="
            java.lang.String r5 = " not found"
            B7.a.z(r4, r2, r5, r1, r0)
            java.lang.String r3 = r15.getStringExtra(r3)
            if (r3 == 0) goto L6a
            boolean r0 = j9.m.s0(r3)
            if (r0 == 0) goto L35
            goto L6a
        L35:
            boolean r0 = r14.isCallerTrusted(r3)
            if (r0 == 0) goto L6a
            java.lang.String r0 = "callbackAction"
            java.lang.String r15 = r15.getStringExtra(r0)
            if (r15 == 0) goto L4f
            boolean r0 = j9.m.s0(r15)
            if (r0 != 0) goto L4a
            goto L4b
        L4a:
            r15 = 0
        L4b:
            if (r15 == 0) goto L4f
        L4d:
            r4 = r15
            goto L52
        L4f:
            java.lang.String r15 = "com.stepos.taskrobot.vdbroadcast.action.TASK_EVENT"
            goto L4d
        L52:
            r15 = 102(0x66, float:1.43E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r15)
            r12 = 800(0x320, float:1.121E-42)
            r13 = 0
            java.lang.String r5 = ""
            java.lang.String r6 = "failed"
            r7 = 0
            java.lang.String r9 = "no running task for this requestId"
            r10 = 0
            r11 = 0
            r1 = r14
            sendEvent$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r4 = r1
            goto L6b
        L6a:
            r4 = r14
        L6b:
            r4.stopIfIdle()
            return
        L6f:
            r4 = r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r2 = "handleCancel: cancelling "
            r14.<init>(r2)
            r14.append(r5)
            java.lang.String r14 = r14.toString()
            f6.AbstractC1436a.d(r1, r14, r0)
            java.lang.String r14 = r15.getStringExtra(r3)
            if (r14 == 0) goto L90
            boolean r14 = j9.m.s0(r14)
            if (r14 == 0) goto L8e
            goto L90
        L8e:
            r14 = 0
            goto L91
        L90:
            r14 = r0
        L91:
            r11 = r14 ^ 1
            r12 = 12
            r13 = 0
            java.lang.String r6 = "finished"
            r7 = 0
            r8 = 0
            java.lang.String r9 = "cancelled"
            r10 = 1
            terminate$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        La1:
            java.lang.String r14 = "handleCancel: missing requestId, dropped"
            f6.AbstractC1436a.b(r1, r14, r0)
            r4.stopIfIdle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.vdbroadcast.VdTaskService.handleCancel(android.content.Intent):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleStart(android.content.Intent r21) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.vdbroadcast.VdTaskService.handleStart(android.content.Intent):void");
    }

    private final boolean isCallerTrusted(String callbackPackage) {
        try {
            getPackageManager().getPackageInfo(callbackPackage, 0);
            int iCheckSignatures = getPackageManager().checkSignatures(getPackageName(), callbackPackage);
            if (iCheckSignatures == 0) {
                return true;
            }
            AbstractC1436a.b(TAG, "isCallerTrusted: signature mismatch for " + callbackPackage + " (result=" + iCheckSignatures + ")", true);
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            AbstractC1436a.b(TAG, "isCallerTrusted: package not found: " + callbackPackage, true);
            return false;
        } catch (Throwable th) {
            AbstractC1436a.c(TAG, "isCallerTrusted: check failed for " + callbackPackage, th);
            return false;
        }
    }

    private final void sendEvent(C2041a task, String event, Integer displayId, Integer errorCode, String errorMessage, String reason, Long elapsedMs) {
        sendEvent(task.f6711a, task.e, task.f, task.c, event, displayId, errorCode, errorMessage, reason, elapsedMs);
    }

    public static /* synthetic */ void sendEvent$default(VdTaskService vdTaskService, C2041a c2041a, String str, Integer num, Integer num2, String str2, String str3, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            num2 = null;
        }
        if ((i & 16) != 0) {
            str2 = null;
        }
        if ((i & 32) != 0) {
            str3 = null;
        }
        if ((i & 64) != 0) {
            l = null;
        }
        vdTaskService.sendEvent(c2041a, str, num, num2, str2, str3, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopIfIdle() {
        if (this.destroying || !this.tasks.isEmpty()) {
            return;
        }
        boolean zStopSelfResult = stopSelfResult(this.lastStartId);
        AbstractC1436a.d(TAG, "stopIfIdle: no task left, stopSelfResult(" + this.lastStartId + ")=" + zStopSelfResult, true);
    }

    private final void terminate(C2041a task, String event, Integer errorCode, String errorMessage, String reason, boolean joinStartJob, boolean notify) {
        if (task.k.compareAndSet(false, true)) {
            AbstractC1683A.n(this.scope, null, new C12021(task, joinStartJob, this, notify, event, errorCode, errorMessage, reason, null), 3);
            return;
        }
        AbstractC1436a.a(TAG, "terminate: requestId=" + task.f6711a + " already terminated, skip", true);
    }

    public static /* synthetic */ void terminate$default(VdTaskService vdTaskService, C2041a c2041a, String str, Integer num, String str2, String str3, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            str3 = null;
        }
        if ((i & 64) != 0) {
            z11 = true;
        }
        vdTaskService.terminate(c2041a, str, num, str2, str3, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toErrorCode(OpenOnDisplayResult.Reason reason) {
        int iOrdinal = reason.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return 200;
        }
        if (iOrdinal == 2) {
            return ComposerKt.providerKey;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.mdi = Z5.b.f1595a.a(applicationContext);
        AbstractC1436a.d(TAG, "VdTaskService onCreate", true);
    }

    @Override // android.app.Service
    public void onDestroy() throws Throwable {
        this.destroying = true;
        AbstractC1436a.d(TAG, "VdTaskService onDestroy: pending tasks=" + this.tasks.size(), true);
        Collection<C2041a> collectionValues = this.tasks.values();
        k.e(collectionValues, "<get-values>(...)");
        List listF1 = v.f1(collectionValues);
        if (!listF1.isEmpty()) {
            int size = listF1.size();
            List list = listF1;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((C2041a) it.next()).f6711a);
            }
            AbstractC1436a.e(TAG, "onDestroy: force-terminating " + size + " running task(s), requestIds=" + arrayList, true);
            AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12012(listF1, this, null));
        }
        AbstractC1683A.e(this.scope, null);
        AbstractC1436a.d(TAG, "VdTaskService onDestroy done", true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.lastStartId = startId;
        String action = intent != null ? intent.getAction() : null;
        String stringExtra = intent != null ? intent.getStringExtra("requestId") : null;
        int size = this.tasks.size();
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(startId, "onStartCommand: action=", action, " startId=", " requestId=");
        sbT.append(stringExtra);
        sbT.append(" runningTasks=");
        sbT.append(size);
        AbstractC1436a.d(TAG, sbT.toString(), true);
        String action2 = intent != null ? intent.getAction() : null;
        if (action2 != null) {
            int iHashCode = action2.hashCode();
            if (iHashCode != -184364153) {
                if (iHashCode == 2102427749 && action2.equals("com.stepos.taskrobot.vdbroadcast.action.START_TASK")) {
                    handleStart(intent);
                    return 2;
                }
            } else if (action2.equals("com.stepos.taskrobot.vdbroadcast.action.CANCEL_TASK")) {
                handleCancel(intent);
                return 2;
            }
        }
        AbstractC1436a.e(TAG, "onStartCommand: unexpected action=" + (intent != null ? intent.getAction() : null), true);
        stopIfIdle();
        return 2;
    }

    public static /* synthetic */ void sendEvent$default(VdTaskService vdTaskService, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, Long l, int i, Object obj) {
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            num2 = null;
        }
        if ((i & 128) != 0) {
            str6 = null;
        }
        if ((i & 256) != 0) {
            str7 = null;
        }
        if ((i & 512) != 0) {
            l = null;
        }
        vdTaskService.sendEvent(str, str2, str3, str4, str5, num, num2, str6, str7, l);
    }

    private final void sendEvent(String requestId, String callbackPackage, String callbackAction, String taskName, String event, Integer displayId, Integer errorCode, String errorMessage, String reason, Long elapsedMs) {
        Intent intent = new Intent(callbackAction);
        intent.setPackage(callbackPackage);
        intent.addFlags(32);
        intent.putExtra("requestId", requestId);
        intent.putExtra(NotificationCompat.CATEGORY_EVENT, event);
        intent.putExtra(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, taskName);
        if (displayId != null) {
            intent.putExtra(WindowStateInfo.KEY_DISPLAY_ID, displayId.intValue());
        }
        if (errorCode != null) {
            intent.putExtra("errorCode", errorCode.intValue());
        }
        if (errorMessage != null) {
            intent.putExtra("errorMessage", errorMessage);
        }
        if (reason != null) {
            intent.putExtra("reason", reason);
        }
        if (elapsedMs != null) {
            intent.putExtra("elapsedMs", elapsedMs.longValue());
        }
        try {
            sendBroadcast(intent, "com.stepos.taskrobot.vdbroadcast.permission.VD_TASK");
            AbstractC1436a.d(TAG, "sendEvent: event=" + event + " requestId=" + requestId + " → " + callbackPackage + " (action=" + callbackAction + " displayId=" + displayId + " errorCode=" + errorCode + ")", true);
        } catch (Throwable th) {
            StringBuilder sbW = B7.a.w("sendEvent failed: event=", event, " requestId=", requestId, " pkg=");
            sbW.append(callbackPackage);
            AbstractC1436a.c(TAG, sbW.toString(), th);
        }
    }
}
