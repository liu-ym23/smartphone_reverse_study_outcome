package com.alibaba.gaiax.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/utils/GXPropUtils;", "", "()V", "isLog", "", "Ljava/lang/Boolean;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXPropUtils {
    public static final GXPropUtils INSTANCE = null;
    private static Boolean isLog;

    static {
        INSTANCE = new GXPropUtils();
    }

    private GXPropUtils() {
    }

    public final boolean isLog() {
        if (isLog != null) goto L5;
        isLog = Boolean.valueOf(Intrinsics.areEqual("1", GXSystemProp.INSTANCE.get("debug.com.alibaba.gaiax.log", "0")));
    L5:
        Boolean r100 = isLog;
        if (r100 != null) goto L10;
        return false;
    L10:
        return r100.booleanValue();
    }
}
