package com.obric.aiagent.assistant.common.ui.icon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TaskIconRandomizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16140a = null;

    static {
        f16140a = new c();
    }

    private c() {
    }

    public static final String a(String r1, String r2, String r3) {
        List<String> r4 = b.a(r1);
        if (r4.isEmpty() == true) goto L5;
        String r5 = e.f16143a.b(r2);
        if (r5 != null) goto L9;
    L11:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r4.get(Math.floorMod(r3.hashCode(), r4.size())), String.class, "com.obric.aiagent.plugin");
    L9:
        if (r4.contains(r5) == false) goto L11;
        return r5;
    L5:
        return e.f16146d.a();
    }
}
