package android.net.shared;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelableUtil {
    public ParcelableUtil() {
    }

    public static <ParcelableType, BaseType> ParcelableType[] toParcelableArray(Collection<BaseType> r5, Function<BaseType, ParcelableType> r6, Class<ParcelableType> r7) {
        ParcelableType[] r0 = (ParcelableType[]) ((Object[]) Array.newInstance(r7, r5.size()));
        int r1 = 0;
        Iterator<BaseType> r2 = r5.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0[r1] = r6.apply(r2.next());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static <ParcelableType, BaseType> ArrayList<BaseType> fromParcelableArray(ParcelableType[] parceled, Function<ParcelableType, BaseType> conv) {
        ArrayList<BaseType> out = new ArrayList(parceled.length);
        int r1 = parceled.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ParcelableType t = parceled[r2];
        out.add(conv.apply(t));
        r2 = r2 + 1;
        goto L3
    L5:
        return out;
    }
}
