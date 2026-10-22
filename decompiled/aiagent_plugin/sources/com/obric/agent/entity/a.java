package com.obric.agent.entity;

import com.obric.capabilitykit.entity.app.AppEntity;
import d.h.b.o;

/* JADX INFO: compiled from: EntityManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String a(AppEntity r6) {
        o.e(r6, "entity");
        String r0 = r6.getId() + '_' + r6.getType();
        if (r6.getType() != 201) goto L5;
        return r0;
    L5:
        long r2 = r6.getCreateTime();
        if (r2 > 0) goto L9;
        return r0;
    L9:
        return r0 + '_' + r2;
    }
}
