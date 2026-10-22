package com.bytedance.android.shopping.abscontainer.common_biz.helper;

import j33.f;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(f r100, e43.a r101) {
        Intrinsics.checkNotNullParameter(r100, "yataAbility");
        Object r102 = null;
        if (r101 == null) goto L7;
        Map<String, Object> r103 = r101.a();
        if (r103 == null) goto L7;
        Object r104 = r103.get("is_client_cache");
    L9:
        if ((r104 instanceof Boolean) == true) goto L11;
        r104 = null;
    L11:
        Boolean r105 = (Boolean) r104;
        if (r105 != null) goto L18;
        Object r106 = r100.e("is_client_cache");
        if ((r106 instanceof Boolean) == false) goto L17;
        r102 = r106;
    L17:
        r105 = (Boolean) r102;
    L18:
        if (r105 != null) goto L22;
        return false;
    L22:
        return r105.booleanValue();
    L7:
        r104 = null;
        goto L9
    }
}
