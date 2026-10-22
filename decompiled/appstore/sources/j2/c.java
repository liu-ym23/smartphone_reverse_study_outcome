package j2;

import f3.g;

/* JADX INFO: loaded from: classes.dex */
public class c extends g {
    public c() {
    }

    @Override // f3.g, com.bytedance.apm6.memory.config.MemoryConfigService
    public j3.a getConfig() {
        j3.a r10 = super.getConfig();
        if (r10 == null) goto L5;
        r10.g(w0.c.C());
        r10.h(w0.c.I());
    L5:
        return r10;
    }
}
