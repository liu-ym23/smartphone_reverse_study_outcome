package com.bytedance.crash.resource.d;

import com.bytedance.crash.config.h;
import com.bytedance.crash.resource.c;
import org.json.JSONArray;

/* JADX INFO: compiled from: RefMonitorConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    private final int n;
    private final int o;

    public b(int r6, JSONArray r7, int r8) {
        super(23, 33, 5);
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 50000;
        this.l = 50000;
        this.m = 500;
        this.n = 1000;
        this.o = 500;
        if (h.g() == false) goto L5;
        this.h = 7;
        this.i = 3;
        this.k = 1000;
        this.l = 1000;
        this.m = 350;
        this.j = 4;
        return;
    L5:
        this.h = r6;
        this.i = r8;
        int r9 = r7.length();
        if (r9 < 2) goto L10;
        this.k = r7.optInt(0);
        this.l = r7.optInt(1);
        if (r9 != 3) goto L10;
        this.m = r7.optInt(2);
    L10:
        this.k = Math.max(1000, this.k);
        this.l = Math.max(1000, this.l);
        this.m = Math.max(500, this.m);
    }

    @Override // com.bytedance.crash.resource.c
    public String toString() {
        return "monitorType=" + this.h + "\nlimitGlobal=" + this.k + "\nlimitWeak=" + this.l + "\nlimitLocal=" + this.m + "\nbtFlag=" + this.i + "\ndebugType=" + this.j + "\n";
    }
}
