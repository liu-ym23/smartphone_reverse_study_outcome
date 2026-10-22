package c50;

import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static String b(DataCenter r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return a(((Long) r100.get("data_room_id", -1L)).longValue(), ((Integer) r100.get("data_fragment_hashcode", -1)).intValue());
    }

    public static String a(long r100, int r101) {
        if (r100 < 0) goto L8;
        if (r101 < 0) goto L8;
        return "" + r100 + ":" + r101;
    L8:
        return "";
    }
}
