package stepai.aios.guiexecutor.core;

import C7.r;
import D7.w;
import J7.c;
import N9.j;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.c0;
import org.java_websocket.WebSocketImpl;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiExecutor;
import stepai.aios.guiexecutor.api.GuiExecutorStatus;
import stepai.aios.guiexecutor.api.GuiResult;
import w9.e;
import w9.f;
import w9.g;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 K2\u00020\u0001:\u0001KB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0082@¢\u0006\u0004\b\u0013\u0010\u0012J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0082@¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u0018\u0010\u000eJ$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0096@¢\u0006\u0004\b\u0019\u0010\u0012J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0015¢\u0006\u0004\b)\u0010\u0017J\r\u0010+\u001a\u00020*¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0015¢\u0006\u0004\b0\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R \u00109\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u000208078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER(\u0010G\u001a\u0004\u0018\u00010\u001a2\b\u0010F\u001a\u0004\u0018\u00010\u001a8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lstepai/aios/guiexecutor/core/DefaultGuiExecutor;", "Lstepai/aios/guiexecutor/api/GuiExecutor;", "Lstepai/aios/guiexecutor/core/CommandDispatcher;", "commandDispatcher", "Lstepai/aios/guiexecutor/core/CommandValidator;", "validator", "Lstepai/aios/guiexecutor/core/GuiExecutorConfig;", "config", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/core/CommandDispatcher;Lstepai/aios/guiexecutor/core/CommandValidator;Lstepai/aios/guiexecutor/core/GuiExecutorConfig;)V", "Lstepai/aios/guiexecutor/api/GuiCommand;", "command", "Lstepai/aios/guiexecutor/api/GuiResult;", "executeWithTimeout", "(Lstepai/aios/guiexecutor/api/GuiCommand;LH7/c;)Ljava/lang/Object;", "", "commands", "executeSequential", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "executeParallel", "executeMixed", "LC7/r;", "updateStatus", "()V", "execute", "executeBatch", "Lstepai/aios/guiexecutor/core/AppInfo;", "getLastAwokenApp", "()Lstepai/aios/guiexecutor/core/AppInfo;", "Lstepai/aios/guiexecutor/api/GuiCommandType;", "commandType", "", "isSupported", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)Z", "Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", "getStatus", "()Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", "", "commandId", "cancelCommand", "(Ljava/lang/String;)Z", "cancelAllCommands", "", "getActiveCommandCount", "()I", "Lstepai/aios/guiexecutor/core/ExecutionStats;", "getExecutionStats", "()Lstepai/aios/guiexecutor/core/ExecutionStats;", "shutdown", "Lstepai/aios/guiexecutor/core/CommandDispatcher;", "Lstepai/aios/guiexecutor/core/CommandValidator;", "Lstepai/aios/guiexecutor/core/GuiExecutorConfig;", "Lm9/z;", "executionScope", "Lm9/z;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lm9/c0;", "activeCommands", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicInteger;", "executionCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lw9/e;", "concurrencySemaphore", "Lw9/e;", "Lstepai/aios/guiexecutor/core/GuiResourceScheduler;", "resourceScheduler", "Lstepai/aios/guiexecutor/core/GuiResourceScheduler;", "status", "Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", "value", "lastAwokenApp", "Lstepai/aios/guiexecutor/core/AppInfo;", "setLastAwokenApp", "(Lstepai/aios/guiexecutor/core/AppInfo;)V", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultGuiExecutor implements GuiExecutor {
    private static final String TAG = "DefaultGuiExecutor";
    private final ConcurrentHashMap<String, c0> activeCommands;
    private final CommandDispatcher commandDispatcher;
    private final e concurrencySemaphore;
    private final GuiExecutorConfig config;
    private final AtomicInteger executionCounter;
    private final InterfaceC1733z executionScope;
    private AppInfo lastAwokenApp;
    private final GuiResourceScheduler resourceScheduler;
    private volatile GuiExecutorStatus status;
    private final CommandValidator validator;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BatchExecutionMode.values().length];
            try {
                iArr[BatchExecutionMode.SEQUENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BatchExecutionMode.PARALLEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BatchExecutionMode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GuiCommandType.values().length];
            try {
                iArr2[GuiCommandType.ASK_FOR_INPUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GuiCommandType.TAKEOVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[GuiCommandType.WAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor", f = "DefaultGuiExecutor.kt", l = {WebSocketImpl.DEFAULT_PORT}, m = "execute", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.DefaultGuiExecutor$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultGuiExecutor.this.execute(null, this);
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor", f = "DefaultGuiExecutor.kt", l = {178, 184}, m = "executeMixed", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeMixed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C19501(H7.c<? super C19501> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultGuiExecutor.this.executeMixed(null, this);
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor", f = "DefaultGuiExecutor.kt", l = {146}, m = "executeSequential", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeSequential$1, reason: invalid class name and case insensitive filesystem */
    public static final class C19511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C19511(H7.c<? super C19511> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultGuiExecutor.this.executeSequential(null, this);
        }
    }

    @c(c = "stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeWithTimeout$2", f = "DefaultGuiExecutor.kt", l = {138}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiexecutor/api/GuiResult;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiexecutor/api/GuiResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeWithTimeout$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ GuiCommand $command;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(GuiCommand guiCommand, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$command = guiCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return DefaultGuiExecutor.this.new AnonymousClass2(this.$command, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            CommandDispatcher commandDispatcher = DefaultGuiExecutor.this.commandDispatcher;
            GuiCommand guiCommand = this.$command;
            this.label = 1;
            Object objDispatch = commandDispatcher.dispatch(guiCommand, this);
            return objDispatch == coroutineSingletons ? coroutineSingletons : objDispatch;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super GuiResult> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public DefaultGuiExecutor(CommandDispatcher commandDispatcher, CommandValidator validator, GuiExecutorConfig config) {
        k.f(commandDispatcher, "commandDispatcher");
        k.f(validator, "validator");
        k.f(config, "config");
        this.commandDispatcher = commandDispatcher;
        this.validator = validator;
        this.config = config;
        this.executionScope = AbstractC1683A.b(AbstractC1691I.f5315a.plus(AbstractC1683A.c()));
        this.activeCommands = new ConcurrentHashMap<>();
        this.executionCounter = new AtomicInteger(0);
        int maxConcurrentCommands = config.getMaxConcurrentCommands();
        int i = g.f6856a;
        this.concurrencySemaphore = new f(maxConcurrentCommands);
        this.resourceScheduler = new GuiResourceScheduler();
        this.status = GuiExecutorStatus.READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
    
        if (r5 == r4) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r19v0, types: [stepai.aios.guiexecutor.core.DefaultGuiExecutor] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeMixed(java.util.List<stepai.aios.guiexecutor.api.GuiCommand> r20, H7.c<? super java.util.List<stepai.aios.guiexecutor.api.GuiResult>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.DefaultGuiExecutor.executeMixed(java.util.List, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeParallel(List<GuiCommand> list, H7.c<? super List<GuiResult>> cVar) {
        List<GuiCommand> list2 = list;
        ArrayList arrayList = new ArrayList(w.c0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC1683A.d(this.executionScope, null, new DefaultGuiExecutor$executeParallel$2$1(this, (GuiCommand) it.next(), null), 3));
        }
        return a.b(arrayList, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Path cross not found for [B:22:0x0075, B:15:0x004c], limit reached: 25 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0067 -> B:20:0x006a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeSequential(java.util.List<stepai.aios.guiexecutor.api.GuiCommand> r6, H7.c<? super java.util.List<stepai.aios.guiexecutor.api.GuiResult>> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof stepai.aios.guiexecutor.core.DefaultGuiExecutor.C19511
            if (r0 == 0) goto L13
            r0 = r7
            stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeSequential$1 r0 = (stepai.aios.guiexecutor.core.DefaultGuiExecutor.C19511) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeSequential$1 r0 = new stepai.aios.guiexecutor.core.DefaultGuiExecutor$executeSequential$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.L$3
            stepai.aios.guiexecutor.api.GuiCommand r6 = (stepai.aios.guiexecutor.api.GuiCommand) r6
            java.lang.Object r6 = r0.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$0
            java.util.List r4 = (java.util.List) r4
            kotlin.b.b(r7)
            goto L6a
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.b.b(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
            r2 = r7
        L4c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L7d
            java.lang.Object r7 = r6.next()
            stepai.aios.guiexecutor.api.GuiCommand r7 = (stepai.aios.guiexecutor.api.GuiCommand) r7
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r6
            r0.L$3 = r4
            r0.label = r3
            java.lang.Object r7 = r5.execute(r7, r0)
            if (r7 != r1) goto L6a
            return r1
        L6a:
            stepai.aios.guiexecutor.api.GuiResult r7 = (stepai.aios.guiexecutor.api.GuiResult) r7
            r2.add(r7)
            boolean r7 = r7.getSuccess()
            if (r7 != 0) goto L4c
            stepai.aios.guiexecutor.core.GuiExecutorConfig r7 = r5.config
            boolean r7 = r7.getFailFastOnBatch()
            if (r7 == 0) goto L4c
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.DefaultGuiExecutor.executeSequential(java.util.List, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeWithTimeout(GuiCommand guiCommand, H7.c<? super GuiResult> cVar) {
        return a.o(guiCommand.getOptions().getTimeout(), new AnonymousClass2(guiCommand, null), cVar);
    }

    private final void setLastAwokenApp(AppInfo appInfo) {
        this.lastAwokenApp = appInfo;
        j.H(androidx.appfunctions.metadata.a.m("gui.last_awoken_app changed to ", appInfo != null ? appInfo.getName() : null, " (", appInfo != null ? appInfo.getPackageName() : null, ")"), TAG);
    }

    private final void updateStatus() {
        if (this.status == GuiExecutorStatus.DISABLED) {
            return;
        }
        this.status = this.activeCommands.isEmpty() ? GuiExecutorStatus.READY : GuiExecutorStatus.BUSY;
    }

    public final void cancelAllCommands() {
        int size = this.activeCommands.size();
        Collection<c0> collectionValues = this.activeCommands.values();
        k.e(collectionValues, "<get-values>(...)");
        for (c0 c0Var : collectionValues) {
            k.c(c0Var);
            c0Var.cancel(null);
        }
        this.activeCommands.clear();
        updateStatus();
        j.H("Cancelled " + size + " active commands", TAG);
    }

    @Override // stepai.aios.guiexecutor.api.GuiExecutor
    public boolean cancelCommand(String commandId) {
        k.f(commandId, "commandId");
        c0 c0Var = this.activeCommands.get(commandId);
        if (c0Var == null) {
            return false;
        }
        c0Var.cancel(null);
        this.activeCommands.remove(commandId);
        j.H("Cancelled command: ".concat(commandId), TAG);
        updateStatus();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a A[Catch: all -> 0x0195, TRY_LEAVE, TryCatch #5 {all -> 0x0195, blocks: (B:41:0x0156, B:43:0x016a), top: B:88:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019a A[Catch: all -> 0x0192, TryCatch #1 {all -> 0x0192, blocks: (B:45:0x0184, B:59:0x01e3, B:61:0x01eb, B:62:0x0213, B:50:0x019a, B:52:0x01aa, B:54:0x01b0, B:56:0x01b6, B:58:0x01bc), top: B:82:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01eb A[Catch: all -> 0x0192, TryCatch #1 {all -> 0x0192, blocks: (B:45:0x0184, B:59:0x01e3, B:61:0x01eb, B:62:0x0213, B:50:0x019a, B:52:0x01aa, B:54:0x01b0, B:56:0x01b6, B:58:0x01bc), top: B:82:0x0168 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    @Override // stepai.aios.guiexecutor.api.GuiExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(stepai.aios.guiexecutor.api.GuiCommand r34, H7.c<? super stepai.aios.guiexecutor.api.GuiResult> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.core.DefaultGuiExecutor.execute(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiExecutor
    public Object executeBatch(List<GuiCommand> list, H7.c<? super List<GuiResult>> cVar) {
        j.H("Executing batch of " + list.size() + " commands", TAG);
        int i = WhenMappings.$EnumSwitchMapping$0[this.config.getBatchExecutionMode().ordinal()];
        if (i == 1) {
            return executeSequential(list, cVar);
        }
        if (i == 2) {
            return executeParallel(list, cVar);
        }
        if (i == 3) {
            return executeMixed(list, cVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getActiveCommandCount() {
        return this.activeCommands.size();
    }

    public final ExecutionStats getExecutionStats() {
        return new ExecutionStats(this.executionCounter.get(), this.activeCommands.size(), this.status);
    }

    @Override // stepai.aios.guiexecutor.api.GuiExecutor
    public AppInfo getLastAwokenApp() {
        return this.lastAwokenApp;
    }

    @Override // stepai.aios.guiexecutor.api.GuiExecutor
    public GuiExecutorStatus getStatus() {
        return this.status;
    }

    @Override // stepai.aios.guiexecutor.api.GuiExecutor
    public boolean isSupported(GuiCommandType commandType) {
        k.f(commandType, "commandType");
        return this.commandDispatcher.isSupported(commandType);
    }

    public final void shutdown() {
        j.H("Shutting down GUI executor", TAG);
        cancelAllCommands();
        AbstractC1683A.e(this.executionScope, null);
        this.status = GuiExecutorStatus.DISABLED;
    }

    public /* synthetic */ DefaultGuiExecutor(CommandDispatcher commandDispatcher, CommandValidator commandValidator, GuiExecutorConfig guiExecutorConfig, int i, kotlin.jvm.internal.e eVar) {
        this(commandDispatcher, commandValidator, (i & 4) != 0 ? GuiExecutorConfig.INSTANCE.m7370default() : guiExecutorConfig);
    }
}
