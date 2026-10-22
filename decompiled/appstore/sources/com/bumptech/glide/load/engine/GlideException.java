package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = null;
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;

    @Nullable
    private Exception exception;
    private Key key;

    public static final class IndentedAppendable implements Appendable {
        private static final String EMPTY_SEQUENCE = "";
        private static final String INDENT = "  ";
        private final Appendable appendable;
        private boolean printedNewLine;

        public IndentedAppendable(Appendable r10) {
            this.printedNewLine = true;
            this.appendable = r10;
        }

        @NonNull
        private CharSequence safeSequence(@Nullable CharSequence r10) {
            if (r10 != null) goto L5;
            return "";
        L5:
            return r10;
        }

        @Override // java.lang.Appendable
        public Appendable append(char r10) throws IOException {
            boolean r11 = false;
            if (this.printedNewLine == false) goto L6;
            this.printedNewLine = false;
            this.appendable.append(INDENT);
        L6:
            if (r10 != '\n') goto L8;
            r11 = true;
        L8:
            this.printedNewLine = r11;
            this.appendable.append(r10);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence r10) throws IOException {
            CharSequence r11 = safeSequence(r10);
            return append(r11, 0, r11.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence r10, int r11, int r12) throws IOException {
            CharSequence r13 = safeSequence(r10);
            boolean r14 = false;
            if (this.printedNewLine == false) goto L6;
            this.printedNewLine = false;
            this.appendable.append(INDENT);
        L6:
            if (r13.length() > 0) goto L8;
        L10:
            this.printedNewLine = r14;
            this.appendable.append(r13, r11, r12);
            return this;
        L8:
            if (r13.charAt(r12 - 1) != '\n') goto L10;
            r14 = true;
            goto L10
        }
    }

    static {
        EMPTY_ELEMENTS = new StackTraceElement[0];
    }

    public GlideException(String r10) {
        this(r10, Collections.emptyList());
    }

    private void addRootCauses(Throwable r10, List<Throwable> r11) {
        if ((r10 instanceof GlideException) == false) goto L8;
        Iterator<Throwable> r12 = ((GlideException) r10).getCauses().iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        addRootCauses(r12.next(), r11);
        goto L6
    L11:
        return;
    L8:
        r11.add(r10);
    }

    private static void appendCauses(List<Throwable> r10, Appendable r11) {
        appendCausesWrapped(r10, r11);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void appendCausesWrapped(List<Throwable> r10, Appendable r11) throws IOException {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r14 = r13 + 1;
        r11.append("Cause (").append(String.valueOf(r14)).append(" of ").append(String.valueOf(r12)).append("): ");
        Throwable r15 = r10.get(r13);
        if ((r15 instanceof GlideException) == false) goto L7;
        ((GlideException) r15).printStackTrace(r11);
    L8:
        r13 = r14;
        goto L3
    L7:
        appendExceptionMessage(r15, r11);
        goto L8
    }

    private static void appendExceptionMessage(Throwable r10, Appendable r11) {
        r11.append(r10.getClass().toString()).append(": ").append(r10.getMessage()).append('\n');     // Catch: IOException -> L4
        return;
    L5:
        throw new RuntimeException(r10);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r10 = new StringBuilder(71);
        r10.append(this.detailMessage);
        String r11 = "";
        if (this.dataClass == null) goto L5;
        String r12 = ", " + this.dataClass;
    L6:
        r10.append(r12);
        if (this.dataSource == null) goto L9;
        String r13 = ", " + this.dataSource;
    L10:
        r10.append(r13);
        if (this.key == null) goto L13;
        r11 = ", " + this.key;
    L13:
        r10.append(r11);
        List<Throwable> r14 = getRootCauses();
        if (r14.isEmpty() == false) goto L18;
        return r10.toString();
    L18:
        if (r14.size() != 1) goto L20;
        r10.append("\nThere was 1 cause:");
    L21:
        Iterator<Throwable> r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L25;
        Throwable r16 = r15.next();
        r10.append('\n');
        r10.append(r16.getClass().getName());
        r10.append('(');
        r10.append(r16.getMessage());
        r10.append(')');
        goto L23
    L25:
        r10.append("\n call GlideException#logRootCauses(String) for more detail");
        return r10.toString();
    L20:
        r10.append("\nThere were ");
        r10.append(r14.size());
        r10.append(" causes:");
        goto L21
    L9:
        r13 = "";
        goto L10
    L5:
        r12 = "";
        goto L6
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList r10 = new ArrayList();
        addRootCauses(this, r10);
        return r10;
    }

    public void logRootCauses(String r10) {
        List<Throwable> r11 = getRootCauses();
        int r12 = r11.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        StringBuilder r14 = new StringBuilder();
        r14.append("Root cause (");
        int r15 = r13 + 1;
        r14.append(r15);
        r14.append(" of ");
        r14.append(r12);
        r14.append(")");
        Log.i(r10, r14.toString(), r11.get(r13));
        r13 = r15;
        goto L3
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setLoggingDetails(Key r10, DataSource r11) {
        setLoggingDetails(r10, r11, null);
    }

    public void setOrigin(@Nullable Exception r10) {
        this.exception = r10;
    }

    public GlideException(String r10, Throwable r11) {
        this(r10, Collections.singletonList(r11));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r10) {
        printStackTrace(r10);
    }

    public void setLoggingDetails(Key r10, DataSource r11, Class<?> r12) {
        this.key = r10;
        this.dataSource = r11;
        this.dataClass = r12;
    }

    public GlideException(String r10, List<Throwable> r11) {
        this.detailMessage = r10;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = r11;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r10) {
        printStackTrace(r10);
    }

    private void printStackTrace(Appendable r10) {
        appendExceptionMessage(this, r10);
        appendCauses(getCauses(), new IndentedAppendable(r10));
    }
}
