package com.obric.common.oea.foundation.animation.e;

import android.view.View;
import com.obric.common.oea.foundation.animation.engine.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f32354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.obric.common.oea.foundation.animation.engine.c<? super T>, e> f32355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a<T> f32356c;

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    public interface a<T extends View> {
        void a(c<T> r1);
    }

    public final c<T> a() {
        c<T> r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        if (r2.f32354a.isEmpty() == true) goto L13;
        List r3 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r2.f32354a, Iterable.class, "com.obric.aiagent.plugin"));
        r2.f32354a.clear();
        a<T> r4 = r2.f32356c;
        if (r4 == null) goto L8;
        r4.a(r2);
    L8:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")).a();
    L13:
        return (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
    }

    public final void b() {
        this.f32354a.clear();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f32355b.values(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r2 = r5.next();
        if (((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).g() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((e) ZeusTransformUtils.preCheckCast(r6.next(), e.class, "com.obric.aiagent.plugin")).f();
        goto L10
    }
}
