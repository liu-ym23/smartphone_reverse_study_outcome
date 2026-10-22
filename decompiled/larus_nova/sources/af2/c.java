package af2;

import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.t1;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final String a(b r100) {
        if ((r100 instanceof a1) == false) goto L7;
        return ((a1) r100).getUserId();
    L7:
        if ((r100 instanceof t1) == true) goto L9;
        return null;
    L9:
        return ((t1) r100).getUserId();
    }

    public static final long b(b r100) {
        if ((r100 instanceof a1) == false) goto L7;
        return ((a1) r100).getScore();
    L7:
        if ((r100 instanceof t1) == true) goto L9;
        return 0;
    L9:
        return ((t1) r100).getScore();
    }
}
