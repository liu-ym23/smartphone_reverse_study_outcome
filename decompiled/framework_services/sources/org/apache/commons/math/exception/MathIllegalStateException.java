package org.apache.commons.math.exception;

import java.util.Locale;
import org.apache.commons.math.exception.util.ArgUtils;
import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.MessageFactory;

/* JADX INFO: loaded from: classes3.dex */
public class MathIllegalStateException extends IllegalStateException implements MathThrowable {
    private static final long serialVersionUID = -6024911025449780478L;
    private final Object[] arguments;
    private final Localizable general;
    private final Localizable specific;

    public MathIllegalStateException(Localizable specific, Localizable general, Object... args) {
        this(null, specific, general, args);
    }

    public MathIllegalStateException(Throwable cause, Localizable specific, Localizable general, Object... args) {
        super(cause);
        this.specific = specific;
        this.general = general;
        this.arguments = ArgUtils.flatten(args);
    }

    public MathIllegalStateException(Localizable general, Object... args) {
        this(null, null, general, args);
    }

    public MathIllegalStateException(Throwable cause, Localizable general, Object... args) {
        this(cause, null, general, args);
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public Localizable getSpecificPattern() {
        return this.specific;
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public Localizable getGeneralPattern() {
        return this.general;
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public Object[] getArguments() {
        return (Object[]) this.arguments.clone();
    }

    @Override // org.apache.commons.math.exception.MathThrowable
    public String getMessage(Locale locale) {
        return MessageFactory.buildMessage(locale, this.specific, this.general, this.arguments);
    }

    @Override // java.lang.Throwable, org.apache.commons.math.exception.MathThrowable
    public String getMessage() {
        return getMessage(Locale.US);
    }

    @Override // java.lang.Throwable, org.apache.commons.math.exception.MathThrowable
    public String getLocalizedMessage() {
        return getMessage(Locale.getDefault());
    }
}
