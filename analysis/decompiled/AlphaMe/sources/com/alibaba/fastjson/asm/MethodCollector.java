package com.alibaba.fastjson.asm;

/* loaded from: classes.dex */
public class MethodCollector {
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final StringBuffer result = new StringBuffer();
    private int currentParameter = 0;

    public MethodCollector(int i4, int i5) {
        this.ignoreCount = i4;
        this.paramCount = i5;
        this.debugInfoPresent = i5 == 0;
    }

    public String getResult() {
        return this.result.length() != 0 ? this.result.substring(1) : "";
    }

    public void visitLocalVariable(String str, int i4) {
        int i5 = this.ignoreCount;
        if (i4 < i5 || i4 >= i5 + this.paramCount) {
            return;
        }
        if (!str.equals("arg" + this.currentParameter)) {
            this.debugInfoPresent = true;
        }
        this.result.append(',');
        this.result.append(str);
        this.currentParameter++;
    }
}
