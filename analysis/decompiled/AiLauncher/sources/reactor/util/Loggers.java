package reactor.util;

import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.regex.Matcher;
import reactor.util.annotation.Nullable;
import vc.c;
import vc.e;

/* loaded from: classes5.dex */
public abstract class Loggers {
    public static final String FALLBACK_PROPERTY = "reactor.logging.fallback";
    private static Function<String, ? extends Logger> LOGGER_FACTORY;

    public static final class ConsoleLoggerFactory implements Function<String, Logger> {
        private static final Map<ConsoleLoggerKey, WeakReference<Logger>> consoleLoggers = new WeakHashMap();
        final boolean verbose;

        public ConsoleLoggerFactory(boolean z10) {
            this.verbose = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public Logger apply(String str) {
            Logger consoleLogger = null;
            ConsoleLoggerKey consoleLoggerKey = new ConsoleLoggerKey(str, this.verbose);
            Map<ConsoleLoggerKey, WeakReference<Logger>> map = consoleLoggers;
            synchronized (map) {
                try {
                    WeakReference<Logger> weakReference = map.get(consoleLoggerKey);
                    if (weakReference != null) {
                        consoleLogger = weakReference.get();
                    }
                    if (consoleLogger == null) {
                        consoleLogger = new ConsoleLogger(consoleLoggerKey);
                        map.put(consoleLoggerKey, new WeakReference<>(consoleLogger));
                    }
                } finally {
                }
            }
            return consoleLogger;
        }
    }

    public static final class ConsoleLoggerKey {
        private final String name;
        private final boolean verbose;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ConsoleLoggerKey.class == obj.getClass()) {
                ConsoleLoggerKey consoleLoggerKey = (ConsoleLoggerKey) obj;
                if (this.verbose == consoleLoggerKey.verbose && Objects.equals(this.name, consoleLoggerKey.name)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.name, Boolean.valueOf(this.verbose));
        }

        private ConsoleLoggerKey(String str, boolean z10) {
            this.name = str;
            this.verbose = z10;
        }
    }

    public static final class JdkLogger implements Logger {
        private final java.util.logging.Logger logger;

        public JdkLogger(java.util.logging.Logger logger) {
            this.logger = logger;
        }

        @Override // reactor.util.Logger
        public void debug(String str) {
            this.logger.log(Level.FINE, str);
        }

        @Override // reactor.util.Logger
        public void error(String str) {
            this.logger.log(Level.SEVERE, str);
        }

        @Nullable
        public final String format(@Nullable String str, @Nullable Object... objArr) {
            if (str == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                for (Object obj : objArr) {
                    str = str.replaceFirst("\\{\\}", Matcher.quoteReplacement(String.valueOf(obj)));
                }
            }
            return str;
        }

        @Override // reactor.util.Logger
        public String getName() {
            return this.logger.getName();
        }

        @Override // reactor.util.Logger
        public void info(String str) {
            this.logger.log(Level.INFO, str);
        }

        @Override // reactor.util.Logger
        public boolean isDebugEnabled() {
            return this.logger.isLoggable(Level.FINE);
        }

        @Override // reactor.util.Logger
        public boolean isErrorEnabled() {
            return this.logger.isLoggable(Level.SEVERE);
        }

        @Override // reactor.util.Logger
        public boolean isInfoEnabled() {
            return this.logger.isLoggable(Level.INFO);
        }

        @Override // reactor.util.Logger
        public boolean isTraceEnabled() {
            return this.logger.isLoggable(Level.FINEST);
        }

        @Override // reactor.util.Logger
        public boolean isWarnEnabled() {
            return this.logger.isLoggable(Level.WARNING);
        }

        @Override // reactor.util.Logger
        public void trace(String str) {
            this.logger.log(Level.FINEST, str);
        }

        @Override // reactor.util.Logger
        public void warn(String str) {
            this.logger.log(Level.WARNING, str);
        }

        @Override // reactor.util.Logger
        public void debug(String str, Object... objArr) {
            this.logger.log(Level.FINE, format(str, objArr));
        }

        @Override // reactor.util.Logger
        public void error(String str, Object... objArr) {
            this.logger.log(Level.SEVERE, format(str, objArr));
        }

        @Override // reactor.util.Logger
        public void info(String str, Object... objArr) {
            this.logger.log(Level.INFO, format(str, objArr));
        }

        @Override // reactor.util.Logger
        public void trace(String str, Object... objArr) {
            this.logger.log(Level.FINEST, format(str, objArr));
        }

        @Override // reactor.util.Logger
        public void warn(String str, Object... objArr) {
            this.logger.log(Level.WARNING, format(str, objArr));
        }

        @Override // reactor.util.Logger
        public void debug(String str, Throwable th) {
            this.logger.log(Level.FINE, str, th);
        }

        @Override // reactor.util.Logger
        public void error(String str, Throwable th) {
            this.logger.log(Level.SEVERE, str, th);
        }

        @Override // reactor.util.Logger
        public void info(String str, Throwable th) {
            this.logger.log(Level.INFO, str, th);
        }

        @Override // reactor.util.Logger
        public void trace(String str, Throwable th) {
            this.logger.log(Level.FINEST, str, th);
        }

        @Override // reactor.util.Logger
        public void warn(String str, Throwable th) {
            this.logger.log(Level.WARNING, str, th);
        }
    }

    public static class JdkLoggerFactory implements Function<String, Logger> {
        private JdkLoggerFactory() {
        }

        @Override // java.util.function.Function
        public Logger apply(String str) {
            return new JdkLogger(java.util.logging.Logger.getLogger(str));
        }
    }

    public static class Slf4JLogger implements Logger {
        private final c logger;

        public Slf4JLogger(c cVar) {
            this.logger = cVar;
        }

        @Override // reactor.util.Logger
        public void debug(String str) {
            this.logger.debug(str);
        }

        @Override // reactor.util.Logger
        public void error(String str) {
            this.logger.error(str);
        }

        @Override // reactor.util.Logger
        public String getName() {
            return this.logger.getName();
        }

        @Override // reactor.util.Logger
        public void info(String str) {
            this.logger.info(str);
        }

        @Override // reactor.util.Logger
        public boolean isDebugEnabled() {
            return this.logger.isDebugEnabled();
        }

        @Override // reactor.util.Logger
        public boolean isErrorEnabled() {
            return this.logger.isErrorEnabled();
        }

        @Override // reactor.util.Logger
        public boolean isInfoEnabled() {
            return this.logger.isInfoEnabled();
        }

        @Override // reactor.util.Logger
        public boolean isTraceEnabled() {
            return this.logger.isTraceEnabled();
        }

        @Override // reactor.util.Logger
        public boolean isWarnEnabled() {
            return this.logger.isWarnEnabled();
        }

        @Override // reactor.util.Logger
        public void trace(String str) {
            this.logger.trace(str);
        }

        @Override // reactor.util.Logger
        public void warn(String str) {
            this.logger.warn(str);
        }

        @Override // reactor.util.Logger
        public void debug(String str, Object... objArr) {
            this.logger.debug(str, objArr);
        }

        @Override // reactor.util.Logger
        public void error(String str, Object... objArr) {
            this.logger.error(str, objArr);
        }

        @Override // reactor.util.Logger
        public void info(String str, Object... objArr) {
            this.logger.info(str, objArr);
        }

        @Override // reactor.util.Logger
        public void trace(String str, Object... objArr) {
            this.logger.trace(str, objArr);
        }

        @Override // reactor.util.Logger
        public void warn(String str, Object... objArr) {
            this.logger.warn(str, objArr);
        }

        @Override // reactor.util.Logger
        public void debug(String str, Throwable th) {
            this.logger.debug(str, th);
        }

        @Override // reactor.util.Logger
        public void error(String str, Throwable th) {
            this.logger.error(str, th);
        }

        @Override // reactor.util.Logger
        public void info(String str, Throwable th) {
            this.logger.info(str, th);
        }

        @Override // reactor.util.Logger
        public void trace(String str, Throwable th) {
            this.logger.trace(str, th);
        }

        @Override // reactor.util.Logger
        public void warn(String str, Throwable th) {
            this.logger.warn(str, th);
        }
    }

    public static class Slf4JLoggerFactory implements Function<String, Logger> {
        private Slf4JLoggerFactory() {
        }

        @Override // java.util.function.Function
        public Logger apply(String str) {
            return new Slf4JLogger(e.m(str));
        }
    }

    static {
        resetLoggerFactory();
    }

    public static Logger getLogger(String str) {
        return LOGGER_FACTORY.apply(str);
    }

    public static boolean isFallbackToJdk() {
        return "JDK".equalsIgnoreCase(System.getProperty(FALLBACK_PROPERTY));
    }

    public static void resetLoggerFactory() {
        try {
            useSl4jLoggers();
        } catch (Throwable unused) {
            if (isFallbackToJdk()) {
                useJdkLoggers();
            } else {
                useConsoleLoggers();
            }
        }
    }

    public static void useConsoleLoggers() {
        String name = Loggers.class.getName();
        ConsoleLoggerFactory consoleLoggerFactory = new ConsoleLoggerFactory(false);
        LOGGER_FACTORY = consoleLoggerFactory;
        consoleLoggerFactory.apply((ConsoleLoggerFactory) name).debug("Using Console logging");
    }

    public static void useCustomLoggers(Function<String, ? extends Logger> function) {
        String name = Loggers.class.getName();
        LOGGER_FACTORY = function;
        function.apply(name).debug("Using custom logging");
    }

    public static void useJdkLoggers() {
        String name = Loggers.class.getName();
        JdkLoggerFactory jdkLoggerFactory = new JdkLoggerFactory();
        LOGGER_FACTORY = jdkLoggerFactory;
        jdkLoggerFactory.apply((JdkLoggerFactory) name).debug("Using JDK logging framework");
    }

    public static void useSl4jLoggers() {
        String name = Loggers.class.getName();
        Slf4JLoggerFactory slf4JLoggerFactory = new Slf4JLoggerFactory();
        LOGGER_FACTORY = slf4JLoggerFactory;
        slf4JLoggerFactory.apply((Slf4JLoggerFactory) name).debug("Using Slf4j logging framework");
    }

    public static void useVerboseConsoleLoggers() {
        String name = Loggers.class.getName();
        ConsoleLoggerFactory consoleLoggerFactory = new ConsoleLoggerFactory(true);
        LOGGER_FACTORY = consoleLoggerFactory;
        consoleLoggerFactory.apply((ConsoleLoggerFactory) name).debug("Using Verbose Console logging");
    }

    public static final class ConsoleLogger implements Logger {
        private final PrintStream err;
        private final ConsoleLoggerKey identifier;
        private final PrintStream log;

        public ConsoleLogger(ConsoleLoggerKey consoleLoggerKey, PrintStream printStream, PrintStream printStream2) {
            this.identifier = consoleLoggerKey;
            this.log = printStream;
            this.err = printStream2;
        }

        @Override // reactor.util.Logger
        public synchronized void debug(String str) {
            if (this.identifier.verbose) {
                this.log.format("[DEBUG] (%s) %s\n", Thread.currentThread().getName(), str);
            }
        }

        @Override // reactor.util.Logger
        public synchronized void error(String str) {
            this.err.format("[ERROR] (%s) %s\n", Thread.currentThread().getName(), str);
        }

        @Nullable
        public final String format(@Nullable String str, @Nullable Object... objArr) {
            if (str == null) {
                return null;
            }
            if (objArr != null && objArr.length != 0) {
                for (Object obj : objArr) {
                    str = str.replaceFirst("\\{\\}", Matcher.quoteReplacement(String.valueOf(obj)));
                }
            }
            return str;
        }

        @Override // reactor.util.Logger
        public String getName() {
            return this.identifier.name;
        }

        @Override // reactor.util.Logger
        public synchronized void info(String str) {
            this.log.format("[ INFO] (%s) %s\n", Thread.currentThread().getName(), str);
        }

        @Override // reactor.util.Logger
        public boolean isDebugEnabled() {
            return this.identifier.verbose;
        }

        @Override // reactor.util.Logger
        public boolean isErrorEnabled() {
            return true;
        }

        @Override // reactor.util.Logger
        public boolean isInfoEnabled() {
            return true;
        }

        @Override // reactor.util.Logger
        public boolean isTraceEnabled() {
            return this.identifier.verbose;
        }

        @Override // reactor.util.Logger
        public boolean isWarnEnabled() {
            return true;
        }

        public String toString() {
            return "ConsoleLogger[name=" + getName() + ", verbose=" + this.identifier.verbose + "]";
        }

        @Override // reactor.util.Logger
        public synchronized void trace(String str) {
            if (this.identifier.verbose) {
                this.log.format("[TRACE] (%s) %s\n", Thread.currentThread().getName(), str);
            }
        }

        @Override // reactor.util.Logger
        public synchronized void warn(String str) {
            this.err.format("[ WARN] (%s) %s\n", Thread.currentThread().getName(), str);
        }

        @Override // reactor.util.Logger
        public synchronized void error(String str, Object... objArr) {
            this.err.format("[ERROR] (%s) %s\n", Thread.currentThread().getName(), format(str, objArr));
        }

        @Override // reactor.util.Logger
        public synchronized void info(String str, Object... objArr) {
            this.log.format("[ INFO] (%s) %s\n", Thread.currentThread().getName(), format(str, objArr));
        }

        @Override // reactor.util.Logger
        public synchronized void warn(String str, Object... objArr) {
            this.err.format("[ WARN] (%s) %s\n", Thread.currentThread().getName(), format(str, objArr));
        }

        public ConsoleLogger(String str, PrintStream printStream, PrintStream printStream2, boolean z10) {
            this(new ConsoleLoggerKey(str, z10), printStream, printStream2);
        }

        @Override // reactor.util.Logger
        public synchronized void debug(String str, Object... objArr) {
            if (this.identifier.verbose) {
                this.log.format("[DEBUG] (%s) %s\n", Thread.currentThread().getName(), format(str, objArr));
            }
        }

        @Override // reactor.util.Logger
        public synchronized void error(String str, Throwable th) {
            this.err.format("[ERROR] (%s) %s - %s\n", Thread.currentThread().getName(), str, th);
            th.printStackTrace(this.err);
        }

        @Override // reactor.util.Logger
        public synchronized void info(String str, Throwable th) {
            this.log.format("[ INFO] (%s) %s - %s\n", Thread.currentThread().getName(), str, th);
            th.printStackTrace(this.log);
        }

        @Override // reactor.util.Logger
        public synchronized void trace(String str, Object... objArr) {
            if (this.identifier.verbose) {
                this.log.format("[TRACE] (%s) %s\n", Thread.currentThread().getName(), format(str, objArr));
            }
        }

        @Override // reactor.util.Logger
        public synchronized void warn(String str, Throwable th) {
            this.err.format("[ WARN] (%s) %s - %s\n", Thread.currentThread().getName(), str, th);
            th.printStackTrace(this.err);
        }

        public ConsoleLogger(ConsoleLoggerKey consoleLoggerKey) {
            this(consoleLoggerKey, System.out, System.err);
        }

        @Override // reactor.util.Logger
        public synchronized void debug(String str, Throwable th) {
            if (this.identifier.verbose) {
                this.log.format("[DEBUG] (%s) %s - %s\n", Thread.currentThread().getName(), str, th);
                th.printStackTrace(this.log);
            }
        }

        @Override // reactor.util.Logger
        public synchronized void trace(String str, Throwable th) {
            if (this.identifier.verbose) {
                this.log.format("[TRACE] (%s) %s - %s\n", Thread.currentThread().getName(), str, th);
                th.printStackTrace(this.log);
            }
        }
    }

    public static Logger getLogger(Class<?> cls) {
        return LOGGER_FACTORY.apply(cls.getName());
    }
}
