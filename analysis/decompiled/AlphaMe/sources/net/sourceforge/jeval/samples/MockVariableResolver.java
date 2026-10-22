package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.VariableResolver;
import net.sourceforge.jeval.function.FunctionException;

/* loaded from: classes2.dex */
public class MockVariableResolver implements VariableResolver {
    @Override // net.sourceforge.jeval.VariableResolver
    public String resolveVariable(String str) throws FunctionException {
        if (str.equals("MockVariable1")) {
            return "1";
        }
        if (str.equals("MockVariable2")) {
            return "2";
        }
        if (str.equals("MockVariable3")) {
            throw new FunctionException("Invalid mock variable name.");
        }
        return null;
    }
}
