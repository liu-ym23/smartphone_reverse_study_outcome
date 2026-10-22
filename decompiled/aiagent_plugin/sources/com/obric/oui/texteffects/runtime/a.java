package com.obric.oui.texteffects.runtime;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36451a = null;

    static {
        f36451a = new a();
    }

    private a() {
    }

    public final void a(d r8, Collection<b> r9, float r10) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.aiagent.plugin");
        o.e(r8, "frame");
        o.e(r7, "bindings");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r11.next(), b.class, "com.obric.aiagent.plugin")).c();
        goto L4
    L6:
        int r12 = 0;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L23;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.aiagent.plugin");
        String r3 = r2.c();
        if (r3 == null) goto L8;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).a(), r3) == false) goto L14;
    L19:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        r6.a(r2, r10);
        r12 = r12 + 1;
        goto L8
    L18:
        r5 = null;
        goto L19
    L23:
        com.obric.oui.texteffects.a r0 = com.obric.oui.texteffects.a.f36355a;
        if (com.obric.oui.texteffects.a.a() == true) goto L26;
        return;
    L26:
        if (com.obric.oui.texteffects.a.b() == false) goto L41;
        a(o.a("OUITextEffects/", "ExternalApplier"), "apply frameLayers=" + r8.a().size() + ", bindings=" + r7.size() + ", applied=" + r12 + ", parentWidth=" + r10);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
