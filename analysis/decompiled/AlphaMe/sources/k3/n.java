package k3;

import ch.qos.logback.core.CoreConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class n implements z {

    @NotNull
    private final z delegate;

    public n(z delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    @JvmName(name = "-deprecated_delegate")
    @NotNull
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final z m16deprecated_delegate() {
        return this.delegate;
    }

    @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @JvmName(name = "delegate")
    @NotNull
    public final z delegate() {
        return this.delegate;
    }

    @Override // k3.z, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // k3.z
    @NotNull
    public C0683E timeout() {
        return this.delegate.timeout();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + CoreConstants.LEFT_PARENTHESIS_CHAR + this.delegate + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Override // k3.z
    public void write(C0694i source, long j4) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(source, j4);
    }
}
