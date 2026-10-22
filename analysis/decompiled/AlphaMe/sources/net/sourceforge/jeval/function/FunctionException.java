package net.sourceforge.jeval.function;

/* loaded from: classes2.dex */
public class FunctionException extends Exception {
    private static final long serialVersionUID = 4767250768467137620L;

    public FunctionException(String str) {
        super(str);
    }

    public FunctionException(Exception exc) {
        super(exc);
    }

    public FunctionException(String str, Exception exc) {
        super(str, exc);
    }
}
