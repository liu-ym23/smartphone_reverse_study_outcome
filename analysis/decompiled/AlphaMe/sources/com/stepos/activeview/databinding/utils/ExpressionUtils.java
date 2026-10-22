package com.stepos.activeview.databinding.utils;

import net.sourceforge.jeval.EvaluationConstants;

/* loaded from: classes.dex */
public class ExpressionUtils {
    public static boolean isReferenceVar(String str) {
        return str.indexOf(EvaluationConstants.OPEN_VARIABLE) >= 0;
    }
}
