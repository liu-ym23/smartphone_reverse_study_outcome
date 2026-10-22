package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
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

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        public CompositeExceptionCausalChain() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    public static abstract class a {
        public a() {
        }

        public abstract void a(Object r10);
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrintStream f20596a;

        public b(PrintStream r10) {
            this.f20596a = r10;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        public void a(Object r10) {
            this.f20596a.println(r10);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrintWriter f20597a;

        public c(PrintWriter r10) {
            this.f20597a = r10;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        public void a(Object r10) {
            this.f20597a.println(r10);
        }
    }

    public CompositeException(@NonNull Throwable... r10) {
        if (r10 != null) goto L4;
        List r11 = Collections.singletonList(new NullPointerException("exceptions was null"));
    L5:
        this(r11);
        return;
    L4:
        r11 = Arrays.asList(r10);
        goto L5
    }

    private void appendStackTrace(StringBuilder r10, Throwable r11, String r12) {
        r10.append(r12);
        r10.append(r11);
        r10.append('\n');
        StackTraceElement[] r13 = r11.getStackTrace();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L6;
        StackTraceElement r16 = r13[r15];
        r10.append("\t\tat ");
        r10.append(r16);
        r10.append('\n');
        r15 = r15 + 1;
        goto L3
    L6:
        if (r11.getCause() == null) goto L10;
        r10.append("\tCaused by: ");
        appendStackTrace(r10, r11.getCause(), "");
        return;
    }

    private List<Throwable> getListOfCauses(Throwable r10) {
        ArrayList r11 = new ArrayList();
        Throwable r12 = r10.getCause();
        if (r12 == null) goto L11;
        if (r12 == r10) goto L11;
    L6:
        r11.add(r12);
        Throwable r13 = r12.getCause();
        if (r13 == null) goto L11;
        if (r13 == r12) goto L11;
        r12 = r13;
    L11:
        return r11;
    }

    @Override // java.lang.Throwable
    @NonNull
    public synchronized Throwable getCause() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.cause != null) goto L24;
        CompositeExceptionCausalChain r10 = new CompositeExceptionCausalChain();     // Catch: Throwable -> L17
        HashSet r11 = new HashSet();     // Catch: Throwable -> L17
        Iterator<Throwable> r12 = this.exceptions.iterator();     // Catch: Throwable -> L17
        Throwable r13 = r10;
    L7:
        if (r12.hasNext() == false) goto L23;
        Throwable r14 = r12.next();     // Catch: Throwable -> L17
        if (r11.contains(r14) == true) goto L7;
        r11.add(r14);     // Catch: Throwable -> L17
        Iterator<Throwable> r15 = getListOfCauses(r14).iterator();     // Catch: Throwable -> L17
    L13:
        if (r15.hasNext() == false) goto L30;
        Throwable r16 = r15.next();     // Catch: Throwable -> L17
        if (r11.contains(r16) == true) goto L16;
        r11.add(r16);     // Catch: Throwable -> L17
        goto L13
    L16:
        r14 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");     // Catch: Throwable -> L17
        goto L13
    L30:
        r13.initCause(r14);     // Catch: Throwable -> L29
    L22:
        r13 = getRootCause(r13);     // Catch: Throwable -> L17
        goto L7
    L23:
        this.cause = r10;     // Catch: Throwable -> L17
    L24:
        Throwable r17 = this.cause;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r17;
    }

    @NonNull
    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        return this.message;
    }

    public Throwable getRootCause(Throwable r10) {
        Throwable r11 = r10.getCause();
        if (r11 == null) goto L12;
        if (r10 == r11) goto L12;
    L6:
        Throwable r12 = r11.getCause();
        if (r12 == null) goto L11;
        if (r12 == r11) goto L11;
        r11 = r12;
    L11:
        return r11;
    L12:
        return r10;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.exceptions.size();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r10) {
        printStackTrace(new b(r10));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r10) {
        printStackTrace(new c(r10));
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        ArrayList r12 = new ArrayList();
        if (r10 == null) goto L13;
        Iterator<? extends Throwable> r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L15;
        Throwable r14 = r13.next();
        if ((r14 instanceof CompositeException) == true) goto L9;
        if (r14 != null) goto L11;
        r11.add(new NullPointerException("Throwable was null!"));
        goto L6
    L11:
        r11.add(r14);
        goto L6
    L9:
        r11.addAll(((CompositeException) r14).getExceptions());
    L15:
        if (r11.isEmpty() == true) goto L19;
        r12.addAll(r11);
        List<Throwable> r15 = Collections.unmodifiableList(r12);
        this.exceptions = r15;
        this.message = r15.size() + " exceptions occurred. ";
        return;
    L19:
        throw new IllegalArgumentException("errors is empty");
    L13:
        r11.add(new NullPointerException("errors was null"));
        goto L15
    }

    private void printStackTrace(a r10) {
        StringBuilder r11 = new StringBuilder(128);
        r11.append(this);
        r11.append('\n');
        StackTraceElement[] r12 = getStackTrace();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        StackTraceElement r15 = r12[r14];
        r11.append("\tat ");
        r11.append(r15);
        r11.append('\n');
        r14 = r14 + 1;
        goto L3
    L5:
        Iterator<Throwable> r16 = this.exceptions.iterator();
        int r17 = 1;
    L7:
        if (r16.hasNext() == false) goto L9;
        Throwable r18 = r16.next();
        r11.append("  ComposedException ");
        r11.append(r17);
        r11.append(" :\n");
        appendStackTrace(r11, r18, "\t");
        r17 = r17 + 1;
        goto L7
    L9:
        r10.a(r11.toString());
    }
}
