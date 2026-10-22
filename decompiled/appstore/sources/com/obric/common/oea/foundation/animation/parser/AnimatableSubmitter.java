package com.obric.common.oea.foundation.animation.parser;

import android.view.View;
import com.obric.common.oea.foundation.animation.builder.a;
import gb.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jb.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class AnimatableSubmitter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimatableSubmitter f11547a = null;

    static {
        f11547a = new AnimatableSubmitter();
    }

    public AnimatableSubmitter() {
    }

    public final d a(a r10, View r11, List r12, Function3 r13, final Function2 r14) {
        if (r11 == null) goto L15;
        gb.a r15 = b.f20040c.c(r11);
        if (r15 == null) goto L6;
        float r16 = r15.b();
    L7:
        Iterator r17 = r12.iterator();
    L9:
        if (r17.hasNext() == false) goto L15;
        gb.a r18 = (gb.a) r17.next();
        if (r18.e() != null) goto L13;
        qb.b.f23627c.a("AnimatableSubmitter", "没指定初始速度，重设velocity " + r16);
        r18.o(Float.valueOf(r16));
    L14:
        b.f20040c.a(r11, r18);
        goto L9
    L13:
        qb.b.f23627c.a("AnimatableSubmitter", "指定了初始速度，" + r18.e());
        goto L14
    L6:
        r16 = 0.0f;
    L15:
        final d r19 = new d();
        b.f20040c.b(r19);
        r19.e(r10, r11, r12, r13, new AnimatableSubmitter$animate$2(r14, r19));
        return r19;
    }

    public final gb.a b(ib.a r10) {
        return r10.a();
    }

    public final d c(a r10, View r11, List r12, Function3 r13, Function2 r14) {
        q.g(r10, "animConfig");
        q.g(r12, "animationCommands");
        ArrayList r15 = new ArrayList();
        Iterator r16 = r12.iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        ib.a r17 = (ib.a) r16.next();
        r15.add(f11547a.b(r17));
        goto L4
    L7:
        return a(r10, r11, r15, r13, r14);
    }
}
