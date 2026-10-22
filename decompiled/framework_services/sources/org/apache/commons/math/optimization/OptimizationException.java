package org.apache.commons.math.optimization;

import org.apache.commons.math.ConvergenceException;
import org.apache.commons.math.exception.util.DummyLocalizable;
import org.apache.commons.math.exception.util.Localizable;

/* JADX INFO: loaded from: classes3.dex */
public class OptimizationException extends ConvergenceException {
    private static final long serialVersionUID = -4605887730798282127L;

    @Deprecated
    public OptimizationException(String specifier, Object... parts) {
        this(new DummyLocalizable(specifier), parts);
    }

    public OptimizationException(Localizable specifier, Object... parts) {
        super(specifier, parts);
    }

    public OptimizationException(Throwable cause) {
        super(cause);
    }
}
