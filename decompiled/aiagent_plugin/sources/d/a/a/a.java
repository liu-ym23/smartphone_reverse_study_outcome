package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.Map.Entry;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends d.a.f<E> {
    public abstract boolean b(Map.Entry<? extends K, ? extends V> r1);

    public a() {
    }

    public boolean c(Map.Entry<?, ?> r3) {
        return super.remove((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L7;
        return false;
    L7:
        return a((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L7;
        return false;
    L7:
        return c((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(E r3) {
        Map.Entry<? extends K, ? extends V> r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r4, "element");
        return b(r4);
    }
}
