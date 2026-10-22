package com.bytedance.bdtracker;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class a0 extends c0 {
    public long g;
    public JSONObject h;

    public a0(e0 e0Var) {
        super(e0Var);
        this.g = 0L;
        this.h = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1 A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x0014, B:9:0x001c, B:14:0x002a, B:20:0x005a, B:22:0x0094, B:24:0x00a7, B:26:0x00b7, B:32:0x00d1, B:34:0x00f6, B:28:0x00bf, B:37:0x00fb, B:38:0x00fd, B:19:0x004f, B:21:0x0090, B:16:0x0035), top: B:44:0x0001, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized org.json.JSONObject a(int r14) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.a0.a(int):org.json.JSONObject");
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() {
        try {
            return a(60000) != null;
        } catch (Throwable th) {
            this.f.D.error(2, "Do fetch config failed", th, new Object[0]);
            return false;
        }
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "AbConfigure";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return h0.h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long h() {
        long j = this.e.e.f.getLong("abtest_fetch_interval", 0L);
        if (j < 600000) {
            return 600000L;
        }
        return j;
    }
}
