package org.apache.commons.math.exception.util;

import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public interface Localizable extends Serializable {
    String getLocalizedString(Locale r1);

    String getSourceString();
}
