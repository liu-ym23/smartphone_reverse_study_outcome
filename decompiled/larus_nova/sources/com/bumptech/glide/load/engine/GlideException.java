package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = null;
    public static final int ERROR_CODE_DECODE = 701004;
    public static final int ERROR_CODE_DECODE_JOB_CANCELLED = 701005;
    public static final int ERROR_CODE_DECODE_JOB_EXCEPTION = 701006;
    public static final int ERROR_CODE_DECODE_JOB_FAILED = 701007;
    public static final int ERROR_CODE_DECODE_JOB_FETCHER_FAILED = 701008;
    public static final int ERROR_CODE_DECODE_RESOURCE_FAILED = 701009;
    public static final int ERROR_CODE_DEFAULT = 701000;
    public static final int ERROR_CODE_FETCH_RESOURCE_FAILED = 701011;
    public static final int ERROR_CODE_LOAD_RESOURCE_FAILED = 701010;
    public static final int ERROR_CODE_PARAMS = 701001;
    public static final int ERROR_CODE_RESOURCE_CONTENT_IS_EMPTY = 701013;
    public static final int ERROR_CODE_RESOURCE_IS_EMPTY = 701012;
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private int errorCode;
    private Exception exception;
    private transient Key key;

    public static final class IndentedAppendable implements Appendable {
        private static final String EMPTY_SEQUENCE = "";
        private static final String INDENT = "  ";
        private final Appendable appendable;
        private boolean printedNewLine;

        private CharSequence safeSequence(CharSequence r100) {
            if (r100 != null) goto L5;
            return "";
        L5:
            return r100;
        }

        public IndentedAppendable(Appendable r100) {
            this.printedNewLine = true;
            this.appendable = r100;
        }

        @Override // java.lang.Appendable
        public Appendable append(char r100) throws IOException {
            boolean r101 = false;
            if (this.printedNewLine == false) goto L6;
            this.printedNewLine = false;
            this.appendable.append("  ");
        L6:
            if (r100 != '\n') goto L8;
            r101 = true;
        L8:
            this.printedNewLine = r101;
            this.appendable.append(r100);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r100) throws IOException {
            CharSequence r101 = safeSequence(r100);
            return append(r101, 0, r101.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r100, int r101, int r102) throws IOException {
            CharSequence r103 = safeSequence(r100);
            boolean r104 = false;
            if (this.printedNewLine == false) goto L6;
            this.printedNewLine = false;
            this.appendable.append("  ");
        L6:
            if (r103.length() > 0) goto L8;
        L10:
            this.printedNewLine = r104;
            this.appendable.append(r103, r101, r102);
            return this;
        L8:
            if (r103.charAt(r102 - 1) != '\n') goto L10;
            r104 = true;
            goto L10
        }
    }

    static {
        EMPTY_ELEMENTS = new StackTraceElement[0];
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r100 = new StringBuilder(71);
        r100.append(this.detailMessage);
        String r101 = "";
        if (this.dataClass == null) goto L5;
        String r102 = ", " + this.dataClass;
    L6:
        r100.append(r102);
        if (this.dataSource == null) goto L9;
        String r103 = ", " + this.dataSource;
    L10:
        r100.append(r103);
        if (this.key == null) goto L13;
        r101 = ", " + this.key;
    L13:
        r100.append(r101);
        List<Throwable> r104 = getRootCauses();
        if (r104.isEmpty() == false) goto L18;
        return r100.toString();
    L18:
        if (r104.size() != 1) goto L20;
        r100.append("\nThere was 1 cause:");
    L21:
        Iterator<Throwable> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L25;
        Throwable r106 = r105.next();
        r100.append('\n');
        r100.append(r106.getClass().getName());
        r100.append('(');
        r100.append(Log.getStackTraceString(r106));
        r100.append("), errorCode:");
        r100.append(this.errorCode);
        goto L23
    L25:
        r100.append("\n call GlideException#logRootCauses(String) for more detail");
        return r100.toString();
    L20:
        r100.append("\nThere were ");
        r100.append(r104.size());
        r100.append(" causes:");
        goto L21
    L9:
        r103 = "";
        goto L10
    L5:
        r102 = "";
        goto L6
    }

    public List<Throwable> getRootCauses() {
        ArrayList r100 = new ArrayList();
        addRootCauses(this, r100);
        return r100;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public GlideException(String r100) {
        this(r100, Collections.emptyList());
    }

    public static boolean isGlideException(int r100) {
        return Arrays.asList(new Integer[]{Integer.valueOf(ERROR_CODE_DEFAULT), Integer.valueOf(ERROR_CODE_PARAMS), Integer.valueOf(ERROR_CODE_DECODE), Integer.valueOf(ERROR_CODE_DECODE_JOB_CANCELLED), Integer.valueOf(ERROR_CODE_DECODE_JOB_EXCEPTION), Integer.valueOf(ERROR_CODE_DECODE_JOB_FAILED), Integer.valueOf(ERROR_CODE_DECODE_JOB_FETCHER_FAILED), Integer.valueOf(ERROR_CODE_DECODE_RESOURCE_FAILED), Integer.valueOf(ERROR_CODE_LOAD_RESOURCE_FAILED), Integer.valueOf(ERROR_CODE_FETCH_RESOURCE_FAILED), Integer.valueOf(ERROR_CODE_RESOURCE_IS_EMPTY), Integer.valueOf(ERROR_CODE_RESOURCE_CONTENT_IS_EMPTY)}).contains(Integer.valueOf(r100));
    }

    private void printStackTrace(Appendable r100) {
        appendExceptionMessage(this, r100);
        appendCauses(getCauses(), new IndentedAppendable(r100));
    }

    public void logRootCauses(String r100) {
        List<Throwable> r101 = getRootCauses();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r104 = r103 + 1;
        Throwable r105 = (Throwable) ListProtector.get(r101, r103);
        r103 = r104;
        goto L3
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setOrigin(Exception r100) {
        this.exception = r100;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r100) {
        printStackTrace(r100);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r100) {
        printStackTrace(r100);
    }

    public GlideException(String r100, List<Throwable> r101) {
        this.errorCode = ERROR_CODE_DEFAULT;
        this.detailMessage = r100;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = r101;
    }

    private void addRootCauses(Throwable r100, List<Throwable> r101) {
        if ((r100 instanceof GlideException) == false) goto L8;
        Iterator<Throwable> r102 = ((GlideException) r100).getCauses().iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        addRootCauses(r102.next(), r101);
        goto L6
    L11:
        return;
    L8:
        r101.add(r100);
    }

    private static void appendCauses(List<Throwable> r100, Appendable r101) {
        appendCausesWrapped(r100, r101);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void appendCausesWrapped(List<Throwable> r100, Appendable r101) throws IOException {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r104 = r103 + 1;
        r101.append("Cause (").append(String.valueOf(r104)).append(" of ").append(String.valueOf(r102)).append("): ");
        Throwable r105 = (Throwable) ListProtector.get(r100, r103);
        if ((r105 instanceof GlideException) == false) goto L7;
        ((GlideException) r105).printStackTrace(r101);
    L8:
        r103 = r104;
        goto L3
    L7:
        appendExceptionMessage(r105, r101);
        goto L8
    }

    private static void appendExceptionMessage(Throwable r100, Appendable r101) {
        r101.append(r100.getClass().toString()).append(": ").append(r100.getMessage()).append('\n');     // Catch: IOException -> L4
        return;
    L5:
        throw new RuntimeException(r100);
    }

    public void setLoggingDetails(Key r100, DataSource r101) {
        setLoggingDetails(r100, r101, null);
    }

    public GlideException(String r100, Throwable r101) {
        this(r100, Collections.singletonList(r101));
    }

    public void setLoggingDetails(Key r100, DataSource r101, Class<?> r102) {
        this.key = r100;
        this.dataSource = r101;
        this.dataClass = r102;
    }
}
