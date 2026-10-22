package androidx.lifecycle.a;

import androidx.lifecycle.aj;
import androidx.lifecycle.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: InitializerViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e<?>> f1969a;

    public c() {
        this.f1969a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final <T extends aj> void a(d.m.c<T> r3, d.h.a.b<? super a, ? extends T> r4) {
        d.m.c r5 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r3, d.m.c.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "clazz");
        o.e(r6, "initializer");
        this.f1969a.add(new e(d.h.a.a(r5), r6));
    }

    public final am.b a() {
        e[] r3 = (e[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(this.f1969a, Collection.class, "com.obric.aiagent.plugin")).toArray(new e[0]), e[].class, "com.obric.aiagent.plugin");
        return (am.b) ZeusTransformUtils.preCheckCast(new b((e[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), e[].class, "com.obric.aiagent.plugin")), am.b.class, "com.obric.aiagent.plugin");
    }
}
