package androidx.core.os;

import android.os.PersistableBundle;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0007¨\u0006\n"}, d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "toPersistableBundle", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }

    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... r100) {
        PersistableBundle r101 = PersistableBundleApi21ImplKt.createPersistableBundle(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair<String, ? extends Object> r104 = r100[r103];
        PersistableBundleApi21ImplKt.putValue(r101, r104.component1(), r104.component2());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> r100) {
        PersistableBundle r101 = PersistableBundleApi21ImplKt.createPersistableBundle(r100.size());
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        PersistableBundleApi21ImplKt.putValue(r101, r103.getKey(), r103.getValue());
        goto L4
    L6:
        return r101;
    }
}
