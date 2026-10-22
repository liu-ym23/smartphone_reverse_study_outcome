package org.apache.commons.math.exception;

import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class MathInternalError extends MathIllegalStateException {
    private static final String REPORT_URL = "https://issues.apache.org/jira/browse/MATH";
    private static final long serialVersionUID = -6276776513966934846L;

    public MathInternalError() {
        super(LocalizedFormats.INTERNAL_ERROR, new Object[]{REPORT_URL});
    }

    public MathInternalError(Throwable cause) {
        super(LocalizedFormats.INTERNAL_ERROR, new Object[]{REPORT_URL});
    }
}
