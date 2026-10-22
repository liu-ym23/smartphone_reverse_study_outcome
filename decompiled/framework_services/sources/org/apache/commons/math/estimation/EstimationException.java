package org.apache.commons.math.estimation;

import org.apache.commons.math.MathException;
import org.apache.commons.math.exception.util.DummyLocalizable;
import org.apache.commons.math.exception.util.Localizable;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class EstimationException extends MathException {
    private static final long serialVersionUID = -573038581493881337L;

    public EstimationException(String specifier, Object... parts) {
        this(new DummyLocalizable(specifier), parts);
    }

    public EstimationException(Localizable specifier, Object... parts) {
        super(specifier, parts);
    }
}
