package reactor.core.publisher;

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
import reactor.util.Loggers;
import reactor.util.annotation.Nullable;
import reactor.util.context.Context;

/* loaded from: classes5.dex */
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
        this(corePublisher, str, level, z10, new Function() { // from class: reactor.core.publisher.E2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Loggers.getLogger((String) obj);
            }
        }, signalTypeArr);
    }

    public static /* synthetic */ void a(SignalLogger signalLogger, long j10) {
        signalLogger.getClass();
        signalLogger.log(SignalType.REQUEST, Long.MAX_VALUE == j10 ? "unbounded" : Long.valueOf(j10));
    }

    public static /* synthetic */ void b(SignalLogger signalLogger) {
        signalLogger.getClass();
        signalLogger.log(SignalType.ON_COMPLETE, "");
    }

    public static /* synthetic */ void c(SignalLogger signalLogger, qc.d dVar) {
        signalLogger.getClass();
        signalLogger.log(SignalType.ON_SUBSCRIBE, subscriptionAsString(dVar));
    }

    public static /* synthetic */ void d(SignalLogger signalLogger) {
        signalLogger.getClass();
        signalLogger.log(SignalType.CANCEL, "");
    }

    public static /* synthetic */ void e(SignalLogger signalLogger, String str, Throwable th) {
        signalLogger.log.debug(str, SignalType.ON_ERROR, th, signalLogger.source);
        signalLogger.log.debug("", th);
    }

    public static /* synthetic */ void f(SignalLogger signalLogger, Context context) {
        signalLogger.getClass();
        signalLogger.log(SignalType.CURRENT_CONTEXT, context);
    }

    public static /* synthetic */ void g(SignalLogger signalLogger, String str, Throwable th) {
        signalLogger.log.error(str, SignalType.ON_ERROR, th, signalLogger.source);
        signalLogger.log.error("", th);
    }

    public static /* synthetic */ void h(SignalLogger signalLogger, String str, Throwable th) {
        signalLogger.log.trace(str, SignalType.ON_ERROR, th, signalLogger.source);
        signalLogger.log.trace("", th);
    }

    public static /* synthetic */ void j(SignalLogger signalLogger, Object obj) {
        signalLogger.getClass();
        signalLogger.safeLog(SignalType.ON_NEXT, obj);
    }

    public static /* synthetic */ void k(SignalLogger signalLogger) {
        signalLogger.getClass();
        signalLogger.log(SignalType.AFTER_TERMINATE, "");
    }

    public static String subscriptionAsString(@Nullable qc.d dVar) {
        if (dVar == null) {
            return "null subscription";
        }
        StringBuilder sb2 = new StringBuilder();
        if (dVar instanceof Fuseable.SynchronousSubscription) {
            sb2.append("[Synchronous Fuseable] ");
        } else if (dVar instanceof Fuseable.QueueSubscription) {
            sb2.append("[Fuseable] ");
        }
        Class<?> cls = dVar.getClass();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = cls.getName();
        }
        sb2.append(canonicalName.replaceFirst(cls.getPackage().getName() + ".", ""));
        return sb2.toString();
    }

    public void log(SignalType signalType, Object obj) {
        String str = this.fuseable ? LOG_TEMPLATE_FUSEABLE : LOG_TEMPLATE;
        if (this.operatorLine != null) {
            str = str + " " + this.operatorLine;
        }
        Level level = this.level;
        if (level == Level.FINEST) {
            this.log.trace(str, signalType, obj);
            return;
        }
        if (level == Level.FINE) {
            this.log.debug(str, signalType, obj);
            return;
        }
        if (level == Level.INFO) {
            this.log.info(str, signalType, obj);
        } else if (level == Level.WARNING) {
            this.log.warn(str, signalType, obj);
        } else if (level == Level.SEVERE) {
            this.log.error(str, signalType, obj);
        }
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Runnable onAfterTerminateCall() {
        if ((this.options & 1) != 1) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new Runnable() { // from class: reactor.core.publisher.A2
                @Override // java.lang.Runnable
                public final void run() {
                    SignalLogger.k(this.f39447a);
                }
            };
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
            return new Runnable() { // from class: reactor.core.publisher.B2
                @Override // java.lang.Runnable
                public final void run() {
                    SignalLogger.d(this.f39450a);
                }
            };
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
            return new Runnable() { // from class: reactor.core.publisher.F2
                @Override // java.lang.Runnable
                public final void run() {
                    SignalLogger.b(this.f39468a);
                }
            };
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
            return new Consumer() { // from class: reactor.core.publisher.z2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    SignalLogger.f(this.f39827a, (Context) obj);
                }
            };
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
        final String str = this.fuseable ? LOG_TEMPLATE_FUSEABLE : LOG_TEMPLATE;
        if (this.operatorLine != null) {
            str = str + " " + this.operatorLine;
        }
        return z12 ? new Consumer() { // from class: reactor.core.publisher.G2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SignalLogger.h(this.f39618a, str, (Throwable) obj);
            }
        } : z11 ? new Consumer() { // from class: reactor.core.publisher.H2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SignalLogger.e(this.f39623a, str, (Throwable) obj);
            }
        } : new Consumer() { // from class: reactor.core.publisher.y2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                SignalLogger.g(this.f39821a, str, (Throwable) obj);
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
            return new Consumer() { // from class: reactor.core.publisher.x2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    SignalLogger.j(this.f39816a, obj);
                }
            };
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
            return new LongConsumer() { // from class: reactor.core.publisher.D2
                @Override // java.util.function.LongConsumer
                public final void accept(long j10) {
                    SignalLogger.a(this.f39462a, j10);
                }
            };
        }
        return null;
    }

    @Override // reactor.core.publisher.SignalPeek
    @Nullable
    public Consumer<? super qc.d> onSubscribeCall() {
        if ((this.options & 64) != 64) {
            return null;
        }
        if (this.level != Level.INFO || this.log.isInfoEnabled()) {
            return new Consumer() { // from class: reactor.core.publisher.C2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    SignalLogger.c(this.f39457a, (qc.d) obj);
                }
            };
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
        return "/loggers/" + this.log.getName() + "/" + this.id;
    }

    public SignalLogger(CorePublisher<IN> corePublisher, @Nullable String str, Level level, boolean z10, Function<String, Logger> function, @Nullable SignalType... signalTypeArr) {
        String str2;
        Objects.requireNonNull(corePublisher, "source");
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
                str2 = str + "Mono." + corePublisher.getClass().getSimpleName().replace("Mono", "");
            } else if (corePublisher instanceof ParallelFlux) {
                str2 = str + "Parallel." + corePublisher.getClass().getSimpleName().replace("Parallel", "");
            } else {
                str2 = str + "Flux." + corePublisher.getClass().getSimpleName().replace("Flux", "");
            }
            str = str2 + "." + andIncrement;
        }
        this.log = function.apply(str);
        this.level = level;
        if (signalTypeArr == null || signalTypeArr.length == 0) {
            this.options = ALL;
            return;
        }
        int i10 = 0;
        for (SignalType signalType : signalTypeArr) {
            if (signalType == SignalType.CANCEL) {
                i10 |= 2;
            } else if (signalType == SignalType.CURRENT_CONTEXT) {
                i10 |= 256;
            } else if (signalType == SignalType.ON_SUBSCRIBE) {
                i10 |= 64;
            } else if (signalType == SignalType.REQUEST) {
                i10 |= 4;
            } else if (signalType == SignalType.ON_NEXT) {
                i10 |= 32;
            } else if (signalType == SignalType.ON_ERROR) {
                i10 |= 16;
            } else if (signalType == SignalType.ON_COMPLETE) {
                i10 |= 8;
            } else if (signalType == SignalType.SUBSCRIBE) {
                i10 |= 128;
            } else if (signalType == SignalType.AFTER_TERMINATE) {
                i10 |= 1;
            }
        }
        this.options = i10;
    }
}
