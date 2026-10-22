package com.bytedance.android.annie.debug;

import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f39389a;

    static {
    }

    public d() {
    }

    public static final Map a() {
        LinkedHashMap r100 = new LinkedHashMap();
        if (a8.b.f2135a.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L13;
        r100.put("x-tt-env", a8.b.f2135a);
        if (StringsKt.startsWith$default(a8.b.f2135a, "ppe_", false, 2, null) == false) goto L11;
        r100.put(ByteNetEnvHeaderName.PPE, "1");
        goto L13
    L11:
        if (StringsKt.startsWith$default(a8.b.f2135a, "boe_", false, 2, null) == false) goto L13;
        r100.put(ByteNetEnvHeaderName.BOE, "1");
    L13:
        return r100;
    L5:
        r101 = false;
        goto L6
    }
}
