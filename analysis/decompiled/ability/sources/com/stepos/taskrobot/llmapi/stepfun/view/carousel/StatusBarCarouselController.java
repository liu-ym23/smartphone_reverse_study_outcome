package com.stepos.taskrobot.llmapi.stepfun.view.carousel;

import B7.a;
import C7.r;
import J7.c;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.i;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.j;
import p9.l;
import p9.t;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0002*+B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController;", "", "Lm9/z;", "scope", "", "intervalMs", AppAgent.CONSTRUCT, "(Lm9/z;J)V", "Lm9/c0;", "launchTickLoop", "()Lm9/c0;", "LC7/r;", "advance", "()V", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;", "prev", "nextFixed", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;)Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;", "start", "stop", "", "text", "onExplainUpdated", "(Ljava/lang/String;)V", "onTaskRecoveredFromTakeover", "Lm9/z;", "J", "Lp9/j;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display;", "_display", "Lp9/j;", "Lp9/t;", "display", "Lp9/t;", "getDisplay", "()Lp9/t;", "currentExplain", "Ljava/lang/String;", "lastFixedShown", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;", "tickJob", "Lm9/c0;", "FixedSlot", "Display", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StatusBarCarouselController {
    private final j _display;
    private String currentExplain;
    private final t display;
    private final long intervalMs;
    private FixedSlot lastFixedShown;
    private final InterfaceC1733z scope;
    private c0 tickJob;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display;", "", AppAgent.CONSTRUCT, "()V", "Explain", "Fixed", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display$Explain;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display$Fixed;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Display {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display$Explain;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display;", "text", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Explain extends Display {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Explain(String text) {
                super(null);
                k.f(text, "text");
                this.text = text;
            }

            public static /* synthetic */ Explain copy$default(Explain explain, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = explain.text;
                }
                return explain.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final Explain copy(String text) {
                k.f(text, "text");
                return new Explain(text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Explain) && k.b(this.text, ((Explain) other).text);
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return a.m("Explain(text=", this.text, ")");
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display$Fixed;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$Display;", "slot", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;)V", "getSlot", "()Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Fixed extends Display {
            private final FixedSlot slot;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fixed(FixedSlot slot) {
                super(null);
                k.f(slot, "slot");
                this.slot = slot;
            }

            public static /* synthetic */ Fixed copy$default(Fixed fixed, FixedSlot fixedSlot, int i, Object obj) {
                if ((i & 1) != 0) {
                    fixedSlot = fixed.slot;
                }
                return fixed.copy(fixedSlot);
            }

            /* renamed from: component1, reason: from getter */
            public final FixedSlot getSlot() {
                return this.slot;
            }

            public final Fixed copy(FixedSlot slot) {
                k.f(slot, "slot");
                return new Fixed(slot);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fixed) && this.slot == ((Fixed) other).slot;
            }

            public final FixedSlot getSlot() {
                return this.slot;
            }

            public int hashCode() {
                return this.slot.hashCode();
            }

            public String toString() {
                return "Fixed(slot=" + this.slot + ")";
            }
        }

        public /* synthetic */ Display(e eVar) {
            this();
        }

        private Display() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController$FixedSlot;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "TOUCH_HINT", "INPUT_HINT", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FixedSlot {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ FixedSlot[] $VALUES;
        public static final FixedSlot TOUCH_HINT = new FixedSlot("TOUCH_HINT", 0);
        public static final FixedSlot INPUT_HINT = new FixedSlot("INPUT_HINT", 1);

        private static final /* synthetic */ FixedSlot[] $values() {
            return new FixedSlot[]{TOUCH_HINT, INPUT_HINT};
        }

        static {
            FixedSlot[] fixedSlotArr$values = $values();
            $VALUES = fixedSlotArr$values;
            $ENTRIES = kotlin.enums.a.a(fixedSlotArr$values);
        }

        private FixedSlot(String str, int i) {
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static FixedSlot valueOf(String str) {
            return (FixedSlot) Enum.valueOf(FixedSlot.class, str);
        }

        public static FixedSlot[] values() {
            return (FixedSlot[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FixedSlot.values().length];
            try {
                iArr[FixedSlot.INPUT_HINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FixedSlot.TOUCH_HINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController$launchTickLoop$1", f = "StatusBarCarouselController.kt", l = {77}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController$launchTickLoop$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = StatusBarCarouselController.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0030 -> B:14:0x0033). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                m9.z r0 = (m9.InterfaceC1733z) r0
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r6.label
                r3 = 1
                if (r2 == 0) goto L19
                if (r2 != r3) goto L11
                kotlin.b.b(r7)
                goto L33
            L11:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L19:
                kotlin.b.b(r7)
            L1c:
                boolean r7 = m9.AbstractC1683A.l(r0)
                if (r7 == 0) goto L39
                com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController r7 = com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController.this
                long r4 = com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController.access$getIntervalMs$p(r7)
                r6.L$0 = r0
                r6.label = r3
                java.lang.Object r7 = kotlinx.coroutines.a.f(r4, r6)
                if (r7 != r1) goto L33
                return r1
            L33:
                com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController r7 = com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController.this
                com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController.access$advance(r7)
                goto L1c
            L39:
                C7.r r6 = C7.r.f317a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public StatusBarCarouselController(InterfaceC1733z scope, long j5) {
        k.f(scope, "scope");
        this.scope = scope;
        this.intervalMs = j5;
        i iVarC = p9.e.c(new Display.Fixed(FixedSlot.TOUCH_HINT));
        this._display = iVarC;
        this.display = new l(iVarC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void advance() {
        if (this.currentExplain != null) {
            this.currentExplain = null;
            FixedSlot fixedSlotNextFixed = nextFixed(this.lastFixedShown);
            this.lastFixedShown = fixedSlotNextFixed;
            j jVar = this._display;
            Display.Fixed fixed = new Display.Fixed(fixedSlotNextFixed);
            i iVar = (i) jVar;
            iVar.getClass();
            iVar.j(null, fixed);
            return;
        }
        Display display = (Display) ((i) this._display).getValue();
        if (display instanceof Display.Fixed) {
            FixedSlot fixedSlotNextFixed2 = nextFixed(((Display.Fixed) display).getSlot());
            this.lastFixedShown = fixedSlotNextFixed2;
            j jVar2 = this._display;
            Display.Fixed fixed2 = new Display.Fixed(fixedSlotNextFixed2);
            i iVar2 = (i) jVar2;
            iVar2.getClass();
            iVar2.j(null, fixed2);
        }
    }

    private final c0 launchTickLoop() {
        return AbstractC1683A.n(this.scope, null, new AnonymousClass1(null), 3);
    }

    private final FixedSlot nextFixed(FixedSlot prev) {
        int i = prev == null ? -1 : WhenMappings.$EnumSwitchMapping$0[prev.ordinal()];
        if (i == -1 || i == 1) {
            return FixedSlot.TOUCH_HINT;
        }
        if (i == 2) {
            return FixedSlot.INPUT_HINT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final t getDisplay() {
        return this.display;
    }

    public final void onExplainUpdated(String text) {
        k.f(text, "text");
        if (text.length() == 0) {
            return;
        }
        this.currentExplain = text;
        j jVar = this._display;
        Display.Explain explain = new Display.Explain(text);
        i iVar = (i) jVar;
        iVar.getClass();
        iVar.j(null, explain);
        c0 c0Var = this.tickJob;
        if (c0Var == null || !c0Var.isActive()) {
            return;
        }
        c0 c0Var2 = this.tickJob;
        if (c0Var2 != null) {
            c0Var2.cancel(null);
        }
        this.tickJob = launchTickLoop();
    }

    public final void onTaskRecoveredFromTakeover() {
        this.currentExplain = null;
        if (((i) this._display).getValue() instanceof Display.Explain) {
            FixedSlot fixedSlotNextFixed = nextFixed(this.lastFixedShown);
            this.lastFixedShown = fixedSlotNextFixed;
            j jVar = this._display;
            Display.Fixed fixed = new Display.Fixed(fixedSlotNextFixed);
            i iVar = (i) jVar;
            iVar.getClass();
            iVar.j(null, fixed);
        }
    }

    public final void start() {
        c0 c0Var = this.tickJob;
        if (c0Var == null || !c0Var.isActive()) {
            this.tickJob = launchTickLoop();
        }
    }

    public final void stop() {
        c0 c0Var = this.tickJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.tickJob = null;
    }

    public /* synthetic */ StatusBarCarouselController(InterfaceC1733z interfaceC1733z, long j5, int i, e eVar) {
        this(interfaceC1733z, (i & 2) != 0 ? 5000L : j5);
    }
}
