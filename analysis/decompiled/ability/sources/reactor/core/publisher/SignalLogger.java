package reactor.core.publisher;

import com.stepos.agentbus.generated.AgentBusWakeContract;
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

/* loaded from: classes4.dex */
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
    final long id;
    final Level level;
    final Logger log;
    final String operatorLine;
    final int options;
    final CorePublisher<IN> source;

    public SignalLogger(CorePublisher<IN> corePublisher, @Nullable String str, Level level, boolean z10, SignalType... signalTypeArr) {
        this(corePublisher, str, level, z10, new W(2), signalTypeArr);
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
    public /* synthetic */ void lambda$onRequestCall$8(long j5) {
        log(SignalType.REQUEST, Long.MAX_VALUE == j5 ? "unbounded" : Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSubscribeCall$0(Z9.e eVar) {
        log(SignalType.ON_SUBSCRIBE, subscriptionAsString(eVar));
    }

    public static String subscriptionAsString(@Nullable Z9.e eVar) {
        if (eVar == null) {
            return "null subscription";
        }
        StringBuilder sb = new StringBuilder();
        if (eVar instanceof Fuseable.SynchronousSubscription) {
            sb.append("[Synchronous Fuseable] ");
        } else if (eVar instanceof Fuseable.QueueSubscription) {
            sb.append("[Fuseable] ");
        }
        Class<?> cls = eVar.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = cls.getName();
        }
        sb.append(canonicalName.replaceFirst(cls.getPackage().getName() + ".", ""));
        return sb.toString();
    }

    public void log(SignalType signalType, Object obj) {
        String string = this.fuseable ? LOG_TEMPLATE_FUSEABLE : LOG_TEMPLATE;
        if (this.operatorLine != null) {
            StringBuilder sbX = androidx.appfunctions.metadata.a.x(string, " ");
            sbX.append(this.operatorLine);
            string = sbX.toString();
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
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new m0(this, 0);
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCancelCall() {
        if ((this.options & 2) != 2) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new m0(this, 1);
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onCompleteCall() {
        if ((this.options & 8) != 8) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new m0(this, 2);
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Context> onCurrentContextCall() {
        if ((this.options & 256) != 256) {
            return null;
        }
        if ((this.level == Level.FINE && this.log.isDebugEnabled()) || (this.level == Level.FINEST && this.log.isTraceEnabled())) {
            return new k0(this, 1);
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Throwable> onErrorCall() {
        Level level = this.level;
        Level level2 = Level.FINE;
        boolean z10 = false;
        boolean z11 = level == level2 && this.log.isDebugEnabled();
        Level level3 = this.level;
        Level level4 = Level.FINEST;
        boolean z12 = level3 == level4 && this.log.isTraceEnabled();
        Level level5 = this.level;
        if (level5 != level2 && level5 != level4 && this.log.isErrorEnabled()) {
            z10 = true;
        }
        if ((this.options & 16) != 16) {
            return null;
        }
        if (!z10 && !z11 && !z12) {
            return null;
        }
        final String string = this.fuseable ? LOG_TEMPLATE_FUSEABLE : LOG_TEMPLATE;
        if (this.operatorLine != null) {
            StringBuilder sbX = androidx.appfunctions.metadata.a.x(string, " ");
            sbX.append(this.operatorLine);
            string = sbX.toString();
        }
        if (z12) {
            final int i = 1;
            return new Consumer(this) { // from class: reactor.core.publisher.l0
                public final /* synthetic */ SignalLogger b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i) {
                        case 0:
                            this.b.lambda$onErrorCall$5(string, (Throwable) obj);
                            break;
                        case 1:
                            this.b.lambda$onErrorCall$3(string, (Throwable) obj);
                            break;
                        default:
                            this.b.lambda$onErrorCall$4(string, (Throwable) obj);
                            break;
                    }
                }
            };
        }
        if (z11) {
            final int i6 = 2;
            return new Consumer(this) { // from class: reactor.core.publisher.l0
                public final /* synthetic */ SignalLogger b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i6) {
                        case 0:
                            this.b.lambda$onErrorCall$5(string, (Throwable) obj);
                            break;
                        case 1:
                            this.b.lambda$onErrorCall$3(string, (Throwable) obj);
                            break;
                        default:
                            this.b.lambda$onErrorCall$4(string, (Throwable) obj);
                            break;
                    }
                }
            };
        }
        final int i10 = 0;
        return new Consumer(this) { // from class: reactor.core.publisher.l0
            public final /* synthetic */ SignalLogger b;

            {
                this.b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i10) {
                    case 0:
                        this.b.lambda$onErrorCall$5(string, (Throwable) obj);
                        break;
                    case 1:
                        this.b.lambda$onErrorCall$3(string, (Throwable) obj);
                        break;
                    default:
                        this.b.lambda$onErrorCall$4(string, (Throwable) obj);
                        break;
                }
            }
        };
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super IN> onNextCall() {
        if ((this.options & 32) != 32) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new k0(this, 0);
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public LongConsumer onRequestCall() {
        if ((this.options & 4) != 4) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new LongConsumer() { // from class: reactor.core.publisher.n0
                @Override // java.util.function.LongConsumer
                public final void accept(long j5) {
                    this.f5928a.lambda$onRequestCall$8(j5);
                }
            };
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super Z9.e> onSubscribeCall() {
        if ((this.options & 64) != 64) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new k0(this, 2);
        }
        return null;
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
        } catch (UnsupportedOperationException e) {
            log(signalType, String.valueOf(obj));
            if (this.log.isDebugEnabled()) {
                this.log.debug("UnsupportedOperationException has been raised by the logging framework, does your log() placement make sense? eg. 'window(2).log()' instead of 'window(2).flatMap(w -> w.log())'", e);
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
        return "/loggers/" + this.log.getName() + "/" + this.id;
    }

    public SignalLogger(CorePublisher<IN> corePublisher, @Nullable String str, Level level, boolean z10, Function<String, Logger> function, @Nullable SignalType... signalTypeArr) {
        String string;
        Objects.requireNonNull(corePublisher, AgentBusWakeContract.EXTRA_SOURCE);
        this.source = corePublisher;
        long andIncrement = IDS.getAndIncrement();
        this.id = andIncrement;
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
                StringBuilder sbX = androidx.appfunctions.metadata.a.x(str, "Mono.");
                sbX.append(corePublisher.getClass().getSimpleName().replace("Mono", ""));
                string = sbX.toString();
            } else if (corePublisher instanceof ParallelFlux) {
                StringBuilder sbX2 = androidx.appfunctions.metadata.a.x(str, "Parallel.");
                sbX2.append(corePublisher.getClass().getSimpleName().replace("Parallel", ""));
                string = sbX2.toString();
            } else {
                StringBuilder sbX3 = androidx.appfunctions.metadata.a.x(str, "Flux.");
                sbX3.append(corePublisher.getClass().getSimpleName().replace("Flux", ""));
                string = sbX3.toString();
            }
            str = string + "." + andIncrement;
        }
        this.log = function.apply(str);
        this.level = level;
        if (signalTypeArr == null || signalTypeArr.length == 0) {
            this.options = 510;
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
                i |= 128;
            } else if (signalType == SignalType.AFTER_TERMINATE) {
                i |= 1;
            }
        }
        this.options = i;
    }
}
