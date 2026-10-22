package com.obric.aiagent.assistant.common.ui.icon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: TaskIconColorResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f16137b = null;

    private a() {
    }

    static {
        a r0 = new a();
        f16136a = r0;
        f16137b = r0.a();
    }

    public static final Drawable a(Context r2, int r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        return TaskIconGradientTintDrawable.a(r5, r3, a(r4), a(r5));
    }

    public static final int a(String r2) {
        String r3 = e.f16143a.b(r2);
        if (r3 == null) goto L5;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(f16137b.get(r3), Integer.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L13;
        r4 = (Integer) ZeusTransformUtils.preCheckCast(f16137b.get("gray"), Integer.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
        return 0;
    L13:
        return r4.intValue();
    L5:
        r4 = null;
        goto L6
    }

    public static final boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        if ((ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    private final Map<String, Integer> a() {
        return (Map) ZeusTransformUtils.preCheckCast(ao.d(new m[]{s.a("red", -1031112), s.a("orange", -552951), s.a("yellow", -1398264), s.a("green", -15550614), s.a("cyan", -16339244), s.a("blue", -13734913), s.a("purple", -8758536), s.a("pink", -1893548), s.a("gray", -10063739)}), Map.class, "com.obric.aiagent.plugin");
    }
}
