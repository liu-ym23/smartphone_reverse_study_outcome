package reactor.util;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public interface Logger {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @FunctionalInterface
    public interface ChoiceOfMessageSupplier {
        String get(boolean z10);
    }

    void debug(String str);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    void error(String str);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    default void errorOrDebug(ChoiceOfMessageSupplier choiceOfMessageSupplier) {
        if (isDebugEnabled()) {
            debug(choiceOfMessageSupplier.get(true));
        } else if (isErrorEnabled()) {
            error(choiceOfMessageSupplier.get(false));
        }
    }

    String getName();

    void info(String str);

    void info(String str, Throwable th);

    void info(String str, Object... objArr);

    default void infoOrDebug(ChoiceOfMessageSupplier choiceOfMessageSupplier) {
        if (isDebugEnabled()) {
            debug(choiceOfMessageSupplier.get(true));
        } else if (isInfoEnabled()) {
            info(choiceOfMessageSupplier.get(false));
        }
    }

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void trace(String str);

    void trace(String str, Throwable th);

    void trace(String str, Object... objArr);

    void warn(String str);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);

    default void warnOrDebug(ChoiceOfMessageSupplier choiceOfMessageSupplier) {
        if (isDebugEnabled()) {
            debug(choiceOfMessageSupplier.get(true));
        } else if (isWarnEnabled()) {
            warn(choiceOfMessageSupplier.get(false));
        }
    }

    default void errorOrDebug(ChoiceOfMessageSupplier choiceOfMessageSupplier, Throwable th) {
        if (isDebugEnabled()) {
            debug(choiceOfMessageSupplier.get(true), th);
        } else if (isErrorEnabled()) {
            error(choiceOfMessageSupplier.get(false), th);
        }
    }

    default void infoOrDebug(ChoiceOfMessageSupplier choiceOfMessageSupplier, Throwable th) {
        if (isDebugEnabled()) {
            debug(choiceOfMessageSupplier.get(true), th);
        } else if (isInfoEnabled()) {
            info(choiceOfMessageSupplier.get(false), th);
        }
    }

    default void warnOrDebug(ChoiceOfMessageSupplier choiceOfMessageSupplier, Throwable th) {
        if (isDebugEnabled()) {
            debug(choiceOfMessageSupplier.get(true), th);
        } else if (isWarnEnabled()) {
            warn(choiceOfMessageSupplier.get(false), th);
        }
    }
}
