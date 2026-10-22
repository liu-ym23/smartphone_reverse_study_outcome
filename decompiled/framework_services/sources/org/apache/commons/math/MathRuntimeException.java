package org.apache.commons.math;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.apache.commons.math.exception.MathThrowable;
import org.apache.commons.math.exception.util.DummyLocalizable;
import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class MathRuntimeException extends RuntimeException implements MathThrowable {
    private static final long serialVersionUID = 9058794795027570002L;
    private final Object[] arguments;
    private final Localizable pattern;

    static /* synthetic */ String access$000(Locale x0, Localizable x1, Object[] x2) {
        return buildMessage(x0, x1, x2);
    }

    @Deprecated
    public MathRuntimeException(String pattern, Object... arguments) {
        this(new DummyLocalizable(pattern), arguments);
    }

    public MathRuntimeException(Localizable pattern, Object... arguments) {
        this.pattern = pattern;
        if (arguments != null) goto L5;
        Object[] r0 = new Object[0];
    L6:
        this.arguments = r0;
        return;
    L5:
        r0 = (Object[]) arguments.clone();
        goto L6
    }

    public MathRuntimeException(Throwable rootCause) {
        super(rootCause);
        this.pattern = LocalizedFormats.SIMPLE_MESSAGE;
        if (rootCause != null) goto L5;
        String r0 = "";
    L6:
        this.arguments = new Object[]{r0};
        return;
    L5:
        r0 = rootCause.getMessage();
        goto L6
    }

    @Deprecated
    public MathRuntimeException(Throwable rootCause, String pattern, Object... arguments) {
        this(rootCause, new DummyLocalizable(pattern), arguments);
    }

    public MathRuntimeException(Throwable rootCause, Localizable pattern, Object... arguments) {
        super(rootCause);
        this.pattern = pattern;
        if (arguments != null) goto L5;
        Object[] r0 = new Object[0];
    L6:
        this.arguments = r0;
        return;
    L5:
        r0 = (Object[]) arguments.clone();
        goto L6
    }

    private static String buildMessage(Locale locale, Localizable pattern, Object... arguments) {
        return new MessageFormat(pattern.getLocalizedString(locale), locale).format(arguments);
    }

    @Deprecated
    public String getPattern() {
        return this.pattern.getSourceString();
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public Localizable getSpecificPattern() {
        return null;
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public Localizable getGeneralPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public Object[] getArguments() {
        return (Object[]) this.arguments.clone();
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public String getMessage(Locale locale) {
        if (this.pattern != null) goto L5;
        return "";
    L5:
        return buildMessage(locale, this.pattern, this.arguments);
    }

    @Override // java.lang.Throwable, org.apache.commons.math.exception.MathThrowable
    public String getMessage() {
        return getMessage(Locale.US);
    }

    @Override // java.lang.Throwable, org.apache.commons.math.exception.MathThrowable
    public String getLocalizedMessage() {
        return getMessage(Locale.getDefault());
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream out) {
        monitor-enter(out);
        PrintWriter pw = new PrintWriter(out, false);     // Catch: Throwable -> L6
        printStackTrace(pw);     // Catch: Throwable -> L6
        pw.flush();     // Catch: Throwable -> L6
        monitor-exit(out);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static ArithmeticException createArithmeticException(String pattern, Object... arguments) {
        return createArithmeticException(new DummyLocalizable(pattern), arguments);
    }

    public static ArithmeticException createArithmeticException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass1(pattern, arguments);
    }

    @Deprecated
    public static ArrayIndexOutOfBoundsException createArrayIndexOutOfBoundsException(String pattern, Object... arguments) {
        return createArrayIndexOutOfBoundsException(new DummyLocalizable(pattern), arguments);
    }

    public static ArrayIndexOutOfBoundsException createArrayIndexOutOfBoundsException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass2(pattern, arguments);
    }

    @Deprecated
    public static EOFException createEOFException(String pattern, Object... arguments) {
        return createEOFException(new DummyLocalizable(pattern), arguments);
    }

    public static EOFException createEOFException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass3(pattern, arguments);
    }

    public static IOException createIOException(Throwable rootCause) {
        IOException ioe = new IOException(rootCause.getLocalizedMessage());
        ioe.initCause(rootCause);
        return ioe;
    }

    @Deprecated
    public static IllegalArgumentException createIllegalArgumentException(String pattern, Object... arguments) {
        return createIllegalArgumentException(new DummyLocalizable(pattern), arguments);
    }

    public static IllegalArgumentException createIllegalArgumentException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass4(pattern, arguments);
    }

    public static IllegalArgumentException createIllegalArgumentException(Throwable rootCause) {
        IllegalArgumentException iae = new IllegalArgumentException(rootCause.getLocalizedMessage());
        iae.initCause(rootCause);
        return iae;
    }

    @Deprecated
    public static IllegalStateException createIllegalStateException(String pattern, Object... arguments) {
        return createIllegalStateException(new DummyLocalizable(pattern), arguments);
    }

    public static IllegalStateException createIllegalStateException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass5(pattern, arguments);
    }

    @Deprecated
    public static ConcurrentModificationException createConcurrentModificationException(String pattern, Object... arguments) {
        return createConcurrentModificationException(new DummyLocalizable(pattern), arguments);
    }

    public static ConcurrentModificationException createConcurrentModificationException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass6(pattern, arguments);
    }

    @Deprecated
    public static NoSuchElementException createNoSuchElementException(String pattern, Object... arguments) {
        return createNoSuchElementException(new DummyLocalizable(pattern), arguments);
    }

    public static NoSuchElementException createNoSuchElementException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass7(pattern, arguments);
    }

    @Deprecated
    public static UnsupportedOperationException createUnsupportedOperationException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass8(pattern, arguments);
    }

    @Deprecated
    public static NullPointerException createNullPointerException(String pattern, Object... arguments) {
        return createNullPointerException(new DummyLocalizable(pattern), arguments);
    }

    @Deprecated
    public static NullPointerException createNullPointerException(final Localizable pattern, final Object... arguments) {
        return new AnonymousClass9(pattern, arguments);
    }

    @Deprecated
    public static ParseException createParseException(int offset, String pattern, Object... arguments) {
        return createParseException(offset, new DummyLocalizable(pattern), arguments);
    }

    public static ParseException createParseException(final int offset, final Localizable pattern, final Object... arguments) {
        final String r1 = null;
        return new AnonymousClass10(r1, offset, pattern, arguments);
    }

    public static RuntimeException createInternalError(final Throwable cause) {
        return new AnonymousClass11(cause);
    }
}
