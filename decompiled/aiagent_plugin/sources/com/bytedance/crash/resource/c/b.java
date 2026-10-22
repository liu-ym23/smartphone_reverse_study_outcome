package com.bytedance.crash.resource.c;

import com.bytedance.crash.config.h;
import com.bytedance.crash.resource.c;
import org.json.JSONArray;

/* JADX INFO: compiled from: NativeHeapTrackerConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected boolean o;
    boolean p;

    public b(JSONArray r7) {
        super(21, 33, 1);
        this.m = 3;
        this.n = 500;
        this.p = false;
        if (h.g() == false) goto L5;
        this.l = 0;
        this.i = 30;
        this.j = 300;
        this.h = 1;
        this.o = false;
        this.k = 2;
        this.p = true;
        this.n = 4;
        this.m = 3;
        return;
    L5:
        this.h = r7.optInt(0);
        this.i = r7.optInt(1);
        this.j = r7.optInt(2);
        this.o = r7.optBoolean(3);
        this.k = r7.optInt(5);
        this.l = r7.optInt(6);
        if (r7.length() < 9) goto L8;
        this.m = r7.optInt(7);
        this.n = r7.optInt(8);
    L8:
        this.h = Math.max(4, this.h);
    }

    @Override // com.bytedance.crash.resource.c
    public String toString() {
        return "pollSecond=" + this.h + "\nwaterLineMB=" + this.i + "\ncollectSizeMB=" + this.j + "\nneedDumpMemInfo=" + this.o + "\ndebug=" + this.p + "\nmonitorSize=" + this.k + "\nmonitorType=" + this.l + "\nbtFlag=" + this.m + "\nbtSize=" + this.n + "\n";
    }
}
