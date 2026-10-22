package net.sourceforge.jeval.function;

import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public interface Function {
    FunctionResult execute(Evaluator evaluator, String str) throws FunctionException;

    String getName();
}
