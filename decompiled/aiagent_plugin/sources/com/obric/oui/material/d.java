package com.obric.oui.material;

import android.graphics.Color;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MaterialConfigBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f35485a = null;

    static {
        f35485a = new d();
    }

    private d() {
    }

    public final c[] a(c[] r10, int r11) {
        d.h.b.o.e(r10, "baseConfigs");
        int r9 = com.obric.oui.color.d.a(r11, 0.1f);
        int r12 = Color.argb(102, Color.red(r9), Color.green(r9), Color.blue(r9));
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r10.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r10.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L9;
        c r5 = r10[r4];
        c r6 = r5.l();
        r6.a(f35485a.a(r9));
        com.obric.oui.color.e r7 = r5.e();
        if (r7 != null) goto L7;
        com.obric.oui.color.e r8 = null;
    L8:
        r6.a(r8);
        r0.add(r6);
        r4 = r4 + 1;
        goto L3
    L7:
        r8 = new com.obric.oui.color.e(r7.a(), r12, r7.c());
        goto L8
    L9:
        Object[] r13 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (c[]) ZeusTransformUtils.preCheckCast(r13, c[].class, "com.obric.aiagent.plugin");
    }

    public final com.obric.oui.color.a[] a(int r4) {
        return new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, com.obric.oui.a.a.f33929d), new com.obric.oui.color.a(-3355444, com.obric.oui.a.a.p), new com.obric.oui.color.a(r4, com.obric.oui.a.a.D)};
    }
}
