package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final <T> Iterator<T> a(T[] r2) {
        o.e(r2, "array");
        return (Iterator) ZeusTransformUtils.preCheckCast(new b(r2), Iterator.class, "com.obric.aiagent.plugin");
    }
}
