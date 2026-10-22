package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes28.dex */
public class MethodCollector {
    private int currentParameter;
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final StringBuilder result;

    public String getResult() {
        if (this.result.length() != 0) goto L7;
        return "";
    L7:
        return this.result.substring(1);
    }

    public MethodCollector(int r100, int r101) {
        this.ignoreCount = r100;
        this.paramCount = r101;
        this.result = new StringBuilder();
        boolean r102 = false;
        this.currentParameter = 0;
        if (r101 != 0) goto L5;
        r102 = true;
    L5:
        this.debugInfoPresent = r102;
    }

    public void visitLocalVariable(String r100, int r101) {
        int r102 = this.ignoreCount;
        if (r101 >= r102) goto L5;
        return;
    L5:
        if (r101 < (r102 + this.paramCount)) goto L7;
        return;
    L7:
        if (r100.equals("arg" + this.currentParameter) == true) goto L9;
        this.debugInfoPresent = true;
    L9:
        this.result.append(',');
        this.result.append(r100);
        this.currentParameter++;
    }
}
