package org.apache.commons.math.exception;

import org.apache.commons.math.exception.util.Localizable;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class NoDataException extends MathIllegalStateException {
    private static final long serialVersionUID = -3629324471511904459L;

    public NoDataException() {
        this(null);
    }

    public NoDataException(Localizable specific) {
        super(specific, LocalizedFormats.NO_DATA, null);
    }
}
