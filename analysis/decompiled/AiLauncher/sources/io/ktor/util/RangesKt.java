package io.ktor.util;

import kotlin.Metadata;
import v9.C5683l;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lv9/l;", "other", "", "contains", "(Lv9/l;Lv9/l;)Z", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RangesKt {
    public static final boolean contains(C5683l c5683l, C5683l other) {
        kotlin.jvm.internal.p.i(c5683l, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        return other.getFirst() >= c5683l.k().longValue() && other.getLast() <= c5683l.j().longValue();
    }
}
