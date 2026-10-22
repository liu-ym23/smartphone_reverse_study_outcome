package c5;

import java.util.Collection;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class o extends n {
    public static int n0(Iterable iterable, int i8) {
        kotlin.jvm.internal.p.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i8;
    }
}
