package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import S7.n;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lkotlin/Function2;", "LC7/r;", "body", "forEachOneBit", "(ILS7/n;)V", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ForEachOneBitKt {
    public static final void forEachOneBit(int i, n nVar) {
        int i6 = 0;
        while (i != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i);
            nVar.invoke(Integer.valueOf(iLowestOneBit), Integer.valueOf(i6));
            i6++;
            i ^= iLowestOneBit;
        }
    }
}
