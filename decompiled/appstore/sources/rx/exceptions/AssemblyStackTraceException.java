package rx.exceptions;

import java.util.HashSet;
import og.c;

/* JADX INFO: loaded from: classes4.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    public AssemblyStackTraceException(String r10) {
        super(r10);
    }

    public static AssemblyStackTraceException find(Throwable r10) {
        HashSet r11 = new HashSet();
    L4:
        if ((r10 instanceof AssemblyStackTraceException) == true) goto L6;
        if (r10 == null) goto L14;
        if (r10.getCause() == null) goto L14;
        r10 = r10.getCause();
        if (r11.add(r10) == true) goto L4;
    L14:
        return null;
    L6:
        return (AssemblyStackTraceException) r10;
    }

    public void attachTo(Throwable r10) {
        HashSet r11 = new HashSet();
    L4:
        if (r10.getCause() == null) goto L13;
        r10 = r10.getCause();
        if (r11.add(r10) == true) goto L4;
        c.j(this);
        return;
    L13:
        r10.initCause(this);     // Catch: IllegalStateException -> L7
        return;
    L7:
        c.j(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", r10));
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }
}
