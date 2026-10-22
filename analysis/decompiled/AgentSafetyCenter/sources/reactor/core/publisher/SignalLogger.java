package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongConsumer;
import java.util.logging.Level;
import reactor.core.CorePublisher;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.Logger;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class SignalLogger<IN> implements SignalPeek<IN> {
    static final int AFTER_TERMINATE = 1;
    static final int ALL = 510;
    static final int CANCEL = 2;
    static final int CONTEXT_PARENT = 256;
    static final AtomicLong IDS = new AtomicLong(1);
    static final String LOG_TEMPLATE = "{}({})";
    static final String LOG_TEMPLATE_FUSEABLE = "| {}({})";
    static final int ON_COMPLETE = 8;
    static final int ON_ERROR = 16;
    static final int ON_NEXT = 32;
    static final int ON_SUBSCRIBE = 64;
    static final int REQUEST = 4;
    static final int SUBSCRIBE = 128;
    final boolean fuseable;

    /* renamed from: id, reason: collision with root package name */
    final long f10752id;
    final Level level;
    final Logger log;
    final String operatorLine;
    final int options;
    final CorePublisher<IN> source;

    public SignalLogger(CorePublisher<IN> corePublisher, @Nullable String str, Level level, boolean z10, Function<String, Logger> function, @Nullable SignalType... signalTypeArr) {
        String string;
        Objects.requireNonNull(corePublisher, "source");
        this.source = corePublisher;
        long andIncrement = IDS.getAndIncrement();
        this.f10752id = andIncrement;
        this.fuseable = corePublisher instanceof Fuseable;
        if (z10) {
            this.operatorLine = Traces.extractOperatorAssemblyInformation(Traces.callSiteSupplierFactory.get().get());
        } else {
            this.operatorLine = null;
        }
        boolean z11 = str == null || str.isEmpty() || str.endsWith(".");
        if (z11 && str == null) {
            str = "reactor.";
        }
        if (z11) {
            if (corePublisher instanceof Mono) {
                StringBuilder sbV = k0.a.v(str, "Mono.");
                sbV.append(corePublisher.getClass().getSimpleName().replace("Mono", ""));
                string = sbV.toString();
            } else if (corePublisher instanceof ParallelFlux) {
                StringBuilder sbV2 = k0.a.v(str, "Parallel.");
                sbV2.append(corePublisher.getClass().getSimpleName().replace("Parallel", ""));
                string = sbV2.toString();
            } else {
                StringBuilder sbV3 = k0.a.v(str, "Flux.");
                sbV3.append(corePublisher.getClass().getSimpleName().replace("Flux", ""));
                string = sbV3.toString();
            }
            str = string + "." + andIncrement;
        }
        this.log = function.apply(str);
        this.level = level;
        if (signalTypeArr == null || signalTypeArr.length == 0) {
            this.options = ALL;
            return;
        }
        int i = 0;
        for (SignalType signalType : signalTypeArr) {
            if (signalType == SignalType.CANCEL) {
                i |= 2;
            } else if (signalType == SignalType.CURRENT_CONTEXT) {
                i |= 256;
            } else if (signalType == SignalType.ON_SUBSCRIBE) {
                i |= 64;
            } else if (signalType == SignalType.REQUEST) {
                i |= 4;
            } else if (signalType == SignalType.ON_NEXT) {
                i |= 32;
            } else if (signalType == SignalType.ON_ERROR) {
                i |= 16;
            } else if (signalType == SignalType.ON_COMPLETE) {
                i |= 8;
            } else if (signalType == SignalType.SUBSCRIBE) {
                i |= SUBSCRIBE;
            } else if (signalType == SignalType.AFTER_TERMINATE) {
                i |= 1;
            }
        }
        this.options = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAfterTerminateCall$7() {
        log(SignalType.AFTER_TERMINATE, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCancelCall$9() {
        log(SignalType.CANCEL, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCompleteCall$6() {
        log(SignalType.ON_COMPLETE, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCurrentContextCall$1(Context context) {
        log(SignalType.CURRENT_CONTEXT, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onErrorCall$3(String str, Throwable th) {
        this.log.trace(str, SignalType.ON_ERROR, th, this.source);
        this.log.trace("", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onErrorCall$4(String str, Throwable th) {
        this.log.debug(str, SignalType.ON_ERROR, th, this.source);
        this.log.debug("", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onErrorCall$5(String str, Throwable th) {
        this.log.error(str, SignalType.ON_ERROR, th, this.source);
        this.log.error("", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNextCall$2(Object obj) {
        safeLog(SignalType.ON_NEXT, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestCall$8(long j10) {
        log(SignalType.REQUEST, Long.MAX_VALUE == j10 ? "unbounded" : Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSubscribeCall$0(qd.e eVar) {
        log(SignalType.ON_SUBSCRIBE, subscriptionAsString(eVar));
    }

    public static String subscriptionAsString(@Nullable qd.e eVar) {
        if (eVar == null) {
            return "null subscription";
        }
        StringBuilder sb2 = new StringBuilder();
        if (eVar instanceof Fuseable.SynchronousSubscription) {
            sb2.append("[Synchronous Fuseable] ");
        } else if (eVar instanceof Fuseable.QueueSubscription) {
            sb2.append("[Fuseable] ");
        }
        Class<?> cls = eVar.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = cls.getName();
        }
        sb2.append(canonicalName.replaceFirst(cls.getPackage().getName() + ".", ""));
        return sb2.toString();
    }

    public void log(SignalType signalType, Object obj) {
        String string = this.fuseable ? LOG_TEMPLATE_FUSEABLE : LOG_TEMPLATE;
        if (this.operatorLine != null) {
            StringBuilder sbV = k0.a.v(string, " ");
            sbV.append(this.operatorLine);
            string = sbV.toString();
        }
        Level level = this.level;
        if (level == Level.FINEST) {
            this.log.trace(string, signalType, obj);
            return;
        }
        if (level == Level.FINE) {
            this.log.debug(string, signalType, obj);
            return;
        }
        if (level == Level.INFO) {
            this.log.info(string, signalType, obj);
        } else if (level == Level.WARNING) {
            this.log.warn(string, signalType, obj);
        } else if (level == Level.SEVERE) {
            this.log.error(string, signalType, obj);
        }
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onAfterTerminateCall() {
        if ((this.options & 1) != 1) {
            return null;
        }
        if (this.level == Level.INFO && !this.log.isInfoEnabled()) {
            return null;
        }
        l1 l1Var = new l1(0);
        l1Var.f10820f = this;
        VarHandle.storeStoreFence();
        return l1Var;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCancelCall() {
        if ((this.options & 2) != 2) {
            return null;
        }
        if (this.level == Level.INFO && !this.log.isInfoEnabled()) {
            return null;
        }
        l1 l1Var = new l1(1);
        l1Var.f10820f = this;
        VarHandle.storeStoreFence();
        return l1Var;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCompleteCall() {
        if ((this.options & 8) != 8) {
            return null;
        }
        if (this.level == Level.INFO && !this.log.isInfoEnabled()) {
            return null;
        }
        l1 l1Var = new l1(2);
        l1Var.f10820f = this;
        VarHandle.storeStoreFence();
        return l1Var;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Context> onCurrentContextCall() {
        if ((this.options & 256) != 256) {
            return null;
        }
        if ((this.level != Level.FINE || !this.log.isDebugEnabled()) && (this.level != Level.FINEST || !this.log.isTraceEnabled())) {
            return null;
        }
        j1 j1Var = new j1(1);
        j1Var.f10809f = this;
        VarHandle.storeStoreFence();
        return j1Var;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Throwable> onErrorCall() {
        Level level = this.level;
        Level level2 = Level.FINE;
        int i = 0;
        int i3 = 1;
        boolean z10 = level == level2 && this.log.isDebugEnabled();
        Level level3 = this.level;
        Level level4 = Level.FINEST;
        boolean z11 = level3 == level4 && this.log.isTraceEnabled();
        Level level5 = this.level;
        boolean z12 = (level5 == level2 || level5 == level4 || !this.log.isErrorEnabled()) ? false : true;
        if ((this.options & 16) != 16) {
            return null;
        }
        if (!z12 && !z10 && !z11) {
            return null;
        }
        String string = this.fuseable ? LOG_TEMPLATE_FUSEABLE : LOG_TEMPLATE;
        if (this.operatorLine != null) {
            StringBuilder sbV = k0.a.v(string, " ");
            sbV.append(this.operatorLine);
            string = sbV.toString();
        }
        if (z11) {
            k1 k1Var = new k1(i3);
            k1Var.f10812f = this;
            k1Var.f10813g = string;
            VarHandle.storeStoreFence();
            return k1Var;
        }
        if (z10) {
            k1 k1Var2 = new k1(2);
            k1Var2.f10812f = this;
            k1Var2.f10813g = string;
            VarHandle.storeStoreFence();
            return k1Var2;
        }
        k1 k1Var3 = new k1(i);
        k1Var3.f10812f = this;
        k1Var3.f10813g = string;
        VarHandle.storeStoreFence();
        return k1Var3;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super IN> onNextCall() {
        if ((this.options & 32) != 32) {
            return null;
        }
        if (this.level == Level.INFO && !this.log.isInfoEnabled()) {
            return null;
        }
        j1 j1Var = new j1(0);
        j1Var.f10809f = this;
        VarHandle.storeStoreFence();
        return j1Var;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public LongConsumer onRequestCall() {
        if ((this.options & 4) != 4) {
            return null;
        }
        if (this.level == Level.INFO && !this.log.isInfoEnabled()) {
            return null;
        }
        m1 m1Var = new m1();
        m1Var.f10825a = this;
        VarHandle.storeStoreFence();
        return m1Var;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super qd.e> onSubscribeCall() {
        if ((this.options & 64) != 64) {
            return null;
        }
        if (this.level == Level.INFO && !this.log.isInfoEnabled()) {
            return null;
        }
        j1 j1Var = new j1(2);
        j1Var.f10809f = this;
        VarHandle.storeStoreFence();
        return j1Var;
    }

    public void safeLog(SignalType signalType, Object obj) {
        if (obj instanceof Fuseable.QueueSubscription) {
            obj = String.valueOf(obj);
            if (this.log.isDebugEnabled()) {
                this.log.debug("A Fuseable Subscription has been passed to the logging framework, this is generally a sign of a misplaced log(), eg. 'window(2).log()' instead of 'window(2).flatMap(w -> w.log())'");
            }
        }
        try {
            log(signalType, obj);
        } catch (UnsupportedOperationException e10) {
            log(signalType, String.valueOf(obj));
            if (this.log.isDebugEnabled()) {
                this.log.debug("UnsupportedOperationException has been raised by the logging framework, does your log() placement make sense? eg. 'window(2).log()' instead of 'window(2).flatMap(w -> w.log())'", e10);
            }
        }
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        return null;
    }

    public String toString() {
        return "/loggers/" + this.log.getName() + "/" + this.f10752id;
    }

    public SignalLogger(CorePublisher<IN> corePublisher, @Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        this(corePublisher, str, level, z10, new w0(2), signalTypeArr);
    }
}
