package com.obric.capabilitykit.corecommon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectUtil {
    public static final ReflectUtil INSTANCE = null;

    static {
        INSTANCE = new ReflectUtil();
    }

    private ReflectUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T tryCast(Object r2) {
        o.a(3, "T");
        if (ZeusTransformUtils.instanceOf(r2, Object.class) == false) goto L5;
        return r2;
    L5:
        return null;
    }
}
