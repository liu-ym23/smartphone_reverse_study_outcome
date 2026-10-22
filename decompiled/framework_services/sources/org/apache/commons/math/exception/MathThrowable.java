package org.apache.commons.math.exception;

import java.util.Locale;
import org.apache.commons.math.exception.util.Localizable;

/* JADX INFO: loaded from: classes3.dex */
public interface MathThrowable {
    Object[] getArguments();

    Localizable getGeneralPattern();

    String getLocalizedMessage();

    String getMessage();

    String getMessage(Locale r1);

    Localizable getSpecificPattern();
}
