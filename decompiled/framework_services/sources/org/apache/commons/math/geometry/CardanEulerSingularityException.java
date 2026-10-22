package org.apache.commons.math.geometry;

import org.apache.commons.math.MathException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class CardanEulerSingularityException extends MathException {
    private static final long serialVersionUID = -1360952845582206770L;

    public CardanEulerSingularityException(boolean isCardan) {
        if (isCardan == false) goto L4;
        LocalizedFormats r0 = LocalizedFormats.CARDAN_ANGLES_SINGULARITY;
    L5:
        super(r0, new Object[0]);
        return;
    L4:
        r0 = LocalizedFormats.EULER_ANGLES_SINGULARITY;
        goto L5
    }
}
