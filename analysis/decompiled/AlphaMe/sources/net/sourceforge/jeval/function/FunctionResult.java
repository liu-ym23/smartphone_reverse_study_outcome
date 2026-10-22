package net.sourceforge.jeval.function;

/* loaded from: classes2.dex */
public class FunctionResult {
    private String result;
    private int type;

    public FunctionResult(String str, int i4) throws FunctionException {
        if (i4 < 0 || i4 > 1) {
            throw new FunctionException("Invalid function result type.");
        }
        this.result = str;
        this.type = i4;
    }

    public String getResult() {
        return this.result;
    }

    public int getType() {
        return this.type;
    }
}
