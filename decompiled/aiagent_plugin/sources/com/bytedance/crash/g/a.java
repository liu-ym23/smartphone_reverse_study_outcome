package com.bytedance.crash.g;

import java.io.File;

/* JADX INFO: compiled from: LooperMessageConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    static File a(File r2) {
        return new File(r2, "current.json");
    }

    static File b(File r2) {
        return new File(r2, "history.json");
    }

    static File c(File r2) {
        return new File(r2, "pending.json");
    }

    static File d(File r2) {
        return new File(r2, "block_stack.json");
    }
}
