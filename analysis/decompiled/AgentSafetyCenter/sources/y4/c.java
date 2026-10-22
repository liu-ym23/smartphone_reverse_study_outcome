package y4;

import java.io.Closeable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface c extends Closeable {
    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z10);

    z4.c w();
}
