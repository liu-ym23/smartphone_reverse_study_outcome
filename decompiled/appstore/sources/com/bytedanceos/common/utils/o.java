package com.bytedanceos.common.utils;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static final void a(String r10, Function0 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "param");
        ec.d.f19371l.a().x(r10, new JSONObject((Map) r11.invoke()));
    }
}
