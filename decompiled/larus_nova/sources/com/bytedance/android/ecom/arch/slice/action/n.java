package com.bytedance.android.ecom.arch.slice.action;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class n {
    public static final IAction a(Object r100) {
        if ((r100 instanceof IAction) == true) goto L5;
        boolean r101 = r100 instanceof Map;
        if (r101 == false) goto L14;
        SlcCommonAction.a r102 = SlcCommonAction.Companion;
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        r102.getClass();
        return SlcCommonAction.a.b((Map) r100);
    L14:
        if ((r100 instanceof List) == false) goto L17;
        SlcCommonAction.Companion.getClass();
        return SlcCommonAction.a.a((List) r100);
    L17:
        return null;
    L5:
        return (IAction) r100;
    }
}
