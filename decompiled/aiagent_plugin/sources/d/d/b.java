package d.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: EnumEntries.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final <E extends Enum<E>> a<E> a(E[] r2) {
        o.e(r2, "entries");
        return (a) ZeusTransformUtils.preCheckCast(new c(r2), a.class, "com.obric.aiagent.plugin");
    }
}
