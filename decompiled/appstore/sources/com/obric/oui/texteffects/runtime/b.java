package com.obric.oui.texteffects.runtime;

import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17329a = null;

    static {
        f17329a = new b();
    }

    public b() {
    }

    public final void a(d r10, Collection r11, float r12) {
        q.g(r10, "frame");
        q.g(r11, "bindings");
        Collection r13 = r11;
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        ((ExternalViewLayerBinding) r14.next()).d();
        goto L4
    L6:
        Iterator r15 = r10.a().iterator();
        int r16 = 0;
    L8:
        if (r15.hasNext() == false) goto L24;
        c r17 = (c) r15.next();
        String r18 = r17.c();
        if (r18 == null) goto L8;
        Iterator r19 = r13.iterator();
    L14:
        if (r19.hasNext() == false) goto L18;
        Object r20 = r19.next();
        if (q.b(((ExternalViewLayerBinding) r20).b(), r18) == false) goto L14;
    L19:
        ExternalViewLayerBinding r21 = (ExternalViewLayerBinding) r20;
        if (r21 == null) goto L8;
        r21.a(r17, r12);
        r16 = r16 + 1;
        goto L8
    L18:
        r20 = null;
        goto L19
    L24:
        if (com.obric.oui.texteffects.e.a() == true) goto L26;
        return;
    L26:
        if (com.obric.oui.texteffects.e.b() == false) goto L41;
        Log.d(q.p("OUITextEffects/", "ExternalApplier"), "apply frameLayers=" + r10.a().size() + ", bindings=" + r11.size() + ", applied=" + r16 + ", parentWidth=" + r12);
        return;
    }
}
