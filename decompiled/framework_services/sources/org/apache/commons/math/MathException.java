package org.apache.commons.math;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Locale;
import org.apache.commons.math.exception.MathThrowable;
import org.apache.commons.math.exception.util.DummyLocalizable;
import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class MathException extends Exception implements MathThrowable {
    private static final long serialVersionUID = 7428019509644517071L;
    private final Object[] arguments;
    private final Localizable pattern;

    public MathException() {
        this.pattern = LocalizedFormats.SIMPLE_MESSAGE;
        this.arguments = new Object[]{""};
    }

    @Deprecated
    public MathException(String pattern, Object... arguments) {
        this(new DummyLocalizable(pattern), arguments);
    }

    public MathException(Localizable pattern, Object... arguments) {
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

    public MathException(Throwable rootCause) {
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
    public MathException(Throwable rootCause, String pattern, Object... arguments) {
        this(rootCause, new DummyLocalizable(pattern), arguments);
    }

    public MathException(Throwable rootCause, Localizable pattern, Object... arguments) {
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
        return new MessageFormat(this.pattern.getLocalizedString(locale), locale).format(this.arguments);
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
}
