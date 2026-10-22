package com.tmall.wireless.tangram.expression;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public class TangramExpr {
    private static final char ARRAY_END = ']';
    private static final char ARRAY_START = '[';
    private static final char DOT = '.';
    private static final int STATE_ARRAY_END = 2;
    private static final int STATE_ARRAY_START = 1;
    private static final int STATE_COMMON = 0;
    private Queue<String> exprFragment;
    private int state;

    public TangramExpr(String r10) {
        this.exprFragment = new LinkedList();
        compile(r10);
    }

    private void compile(String r10) {
        StringBuilder r11 = new StringBuilder();
        this.state = 0;
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L27;
        char r14 = r10.charAt(r13);
        if (r14 != '.') goto L7;
        int r15 = this.state;
        if (r15 != 1) goto L22;
        r11.append(r14);
    L25:
        r13 = r13 + 1;
        goto L3
    L22:
        if (r15 != 2) goto L24;
        this.state = 0;
        goto L25
    L24:
        this.exprFragment.offer(r11.toString());
        r11.delete(0, r11.length());
        goto L25
    L7:
        if (r14 == '[') goto L16;
        if (r14 == ']') goto L12;
        r11.append(r14);
        goto L25
    L12:
        if (this.state != 1) goto L14;
        this.exprFragment.offer(r11.toString());
        r11.delete(0, r11.length());
        this.state = 2;
        goto L25
    L14:
        return;
    L16:
        if (this.state != 0) goto L18;
        this.exprFragment.offer(r11.toString());
        r11.delete(0, r11.length());
        this.state = 1;
        goto L25
    L18:
        return;
    L27:
        if (this.state != 0) goto L39;
        this.exprFragment.offer(r11.toString());
        return;
    }

    public boolean hasNextFragment() {
        return !this.exprFragment.isEmpty();
    }

    public String nextFragment() {
        return this.exprFragment.poll();
    }
}
