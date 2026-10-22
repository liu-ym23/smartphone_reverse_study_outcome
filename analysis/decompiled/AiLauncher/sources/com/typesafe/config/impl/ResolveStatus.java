package com.typesafe.config.impl;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
enum ResolveStatus {
    UNRESOLVED,
    RESOLVED;

    public static final ResolveStatus fromBoolean(boolean z10) {
        return z10 ? RESOLVED : UNRESOLVED;
    }

    public static final ResolveStatus fromValues(Collection<? extends AbstractConfigValue> collection) {
        Iterator<? extends AbstractConfigValue> it = collection.iterator();
        while (it.hasNext()) {
            ResolveStatus resolveStatusJ0 = it.next().j0();
            ResolveStatus resolveStatus = UNRESOLVED;
            if (resolveStatusJ0 == resolveStatus) {
                return resolveStatus;
            }
        }
        return RESOLVED;
    }
}
