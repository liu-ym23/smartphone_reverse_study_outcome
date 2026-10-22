package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }

        CompositeExceptionCausalChain() {
        }
    }

    static abstract class PrintStreamOrWriter {
        abstract void println(Object r1);

        PrintStreamOrWriter() {
        }
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream r1) {
            this.printStream = r1;
        }

        @Override // io.reactivex.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object r1) {
            this.printStream.println(r1);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter r1) {
            this.printWriter = r1;
        }

        @Override // io.reactivex.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object r1) {
            this.printWriter.println(r1);
        }
    }

    public CompositeException(Throwable... r2) {
        if (r2 != null) goto L4;
        List r3 = Collections.singletonList(new NullPointerException("exceptions was null"));
    L5:
        this(r3);
        return;
    L4:
        r3 = Arrays.asList(r2);
        goto L5
    }

    public CompositeException(Iterable<? extends Throwable> r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        ArrayList r1 = new ArrayList();
        if (r5 == null) goto L13;
        Iterator<? extends Throwable> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Throwable r2 = r6.next();
        if ((r2 instanceof CompositeException) == true) goto L9;
        if (r2 != null) goto L11;
        r0.add(new NullPointerException("Throwable was null!"));
        goto L6
    L11:
        r0.add(r2);
        goto L6
    L9:
        r0.addAll(((CompositeException) r2).getExceptions());
    L15:
        if (r0.isEmpty() == true) goto L19;
        r1.addAll(r0);
        List<Throwable> r7 = Collections.unmodifiableList(r1);
        this.exceptions = r7;
        this.message = r7.size() + " exceptions occurred. ";
        return;
    L19:
        throw new IllegalArgumentException("errors is empty");
    L13:
        r0.add(new NullPointerException("errors was null"));
        goto L15
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.cause != null) goto L22;
        CompositeExceptionCausalChain r0 = new CompositeExceptionCausalChain();     // Catch: Throwable -> L25
        HashSet r1 = new HashSet();     // Catch: Throwable -> L25
        Iterator<Throwable> r2 = this.exceptions.iterator();     // Catch: Throwable -> L25
        Throwable r3 = r0;
    L7:
        if (r2.hasNext() == false) goto L21;
        Throwable r4 = r2.next();     // Catch: Throwable -> L25
        if (r1.contains(r4) == true) goto L7;
        r1.add(r4);     // Catch: Throwable -> L25
        Iterator<Throwable> r5 = getListOfCauses(r4).iterator();     // Catch: Throwable -> L25
    L13:
        if (r5.hasNext() == false) goto L31;
        Throwable r6 = r5.next();     // Catch: Throwable -> L25
        if (r1.contains(r6) == true) goto L16;
        r1.add(r6);     // Catch: Throwable -> L25
        goto L13
    L16:
        r4 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");     // Catch: Throwable -> L25
        goto L13
    L31:
        r3.initCause(r4);     // Catch: Throwable -> L28
    L20:
        r3 = getRootCause(r3);     // Catch: Throwable -> L25
        goto L7
    L21:
        this.cause = r0;     // Catch: Throwable -> L25
    L22:
        Throwable r7 = this.cause;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r7;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r2) {
        printStackTrace(new WrappedPrintStream(r2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r2) {
        printStackTrace(new WrappedPrintWriter(r2));
    }

    private void printStackTrace(PrintStreamOrWriter r8) {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(this).append('\n');
        StackTraceElement[] r1 = getStackTrace();
        int r3 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        r0.append("\tat ").append(r1[r4]).append('\n');
        r4 = r4 + 1;
        goto L3
    L5:
        Iterator<Throwable> r2 = this.exceptions.iterator();
        int r5 = 1;
    L7:
        if (r2.hasNext() == false) goto L9;
        Throwable r6 = r2.next();
        r0.append("  ComposedException ").append(r5).append(" :\n");
        appendStackTrace(r0, r6, "\t");
        r5 = r5 + 1;
        goto L7
    L9:
        r8.println(r0.toString());
    }

    private void appendStackTrace(StringBuilder r6, Throwable r7, String r8) {
        r6.append(r8).append(r7).append('\n');
        StackTraceElement[] r9 = r7.getStackTrace();
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        StackTraceElement r3 = r9[r2];
        r6.append("\t\tat ").append(r3).append('\n');
        r2 = r2 + 1;
        goto L3
    L6:
        if (r7.getCause() == null) goto L10;
        r6.append("\tCaused by: ");
        appendStackTrace(r6, r7.getCause(), "");
        return;
    }

    private List<Throwable> getListOfCauses(Throwable r2) {
        ArrayList r1 = new ArrayList();
        Throwable r0 = r2.getCause();
        if (r0 == null) goto L11;
        if (r0 == r2) goto L11;
    L6:
        r1.add(r0);
        Throwable r3 = r0.getCause();
        if (r3 == null) goto L11;
        if (r3 == r0) goto L11;
        r0 = r3;
    L11:
        return r1;
    }

    public int size() {
        return this.exceptions.size();
    }

    Throwable getRootCause(Throwable r1) {
        Throwable r0 = r1.getCause();
        if (r0 == null) goto L12;
        if (r1 == r0) goto L12;
    L6:
        Throwable r2 = r0.getCause();
        if (r2 == null) goto L11;
        if (r2 == r0) goto L11;
        r0 = r2;
    L11:
        return r0;
    L12:
        return r1;
    }
}
