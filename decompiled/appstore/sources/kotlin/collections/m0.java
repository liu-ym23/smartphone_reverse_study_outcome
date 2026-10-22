package kotlin.collections;

import java.util.Map;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m0 extends l0 {
    public static Sequence v(Map r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return b0.Q(r10.entrySet());
    }
}
