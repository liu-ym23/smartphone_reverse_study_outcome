package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

/* JADX INFO: compiled from: AppFunctionDataTypeMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ai extends i {
    /* JADX WARN: Multi-variable type inference failed */
    public ai() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ai(boolean r1, String r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "";
    L8:
        this(r1, r2);
    }

    public ai(boolean r2, String r3) {
        d.h.b.o.e(r3, "description");
        super(r2, r3);
    }
}
