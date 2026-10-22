package b20;

import androidx.viewpager.widget.ViewPager;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends e {
    public b() {
    }

    @Override // b20.e
    public final boolean a(long r100, Map<String, ? extends Object> r101) {
        if (r101 == null) goto L4;
        Object r102 = r101.get("selected_group_id");
    L6:
        if ((r102 instanceof Long) == true) goto L9;
    L11:
        return false;
    L9:
        if (r100 != ((Long) r102).longValue()) goto L11;
        return true;
    L4:
        r102 = null;
        goto L6
    }

    @Override // b20.e
    public final boolean b(List r100, ViewPager r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 != null) goto L5;
    L7:
        if (r101 == null) goto L9;
        r101.post(new a(r101, r102));
    L9:
        return true;
    L5:
        if (r101.getCurrentItem() != r102) goto L7;
        return true;
    }
}
