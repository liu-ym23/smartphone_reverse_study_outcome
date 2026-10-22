package c31;

import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.revenue.service.room.c;
import dy0.b;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final int a() {
        c r100 = (c) ((b) e.c(j.C0.a(), c.class));
        if (r100 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r101 = r100.getRoomContext();
        if (r101 == null) goto L11;
        Pair<Integer, Integer> r102 = r101.getPlayerSize();
        if (r102 == null) goto L11;
        Integer r103 = r102.getSecond();
        if (r103 == null) goto L11;
        return r103.intValue();
    L11:
        return 0;
    }
}
