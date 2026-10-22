package bh0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static boolean a(IRoom r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Map<String, Long> r101 = r100.getLinkMap();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.containsKey(String.valueOf(4)) == false) goto L11;
        return true;
    L11:
        if (r101.containsKey(String.valueOf(5)) == false) goto L13;
        return true;
    L13:
        if (r101.containsKey(String.valueOf(8)) == false) goto L15;
        return true;
    L15:
        if (r101.containsKey(String.valueOf(9)) == false) goto L17;
        return true;
    L17:
        if (r101.containsKey(String.valueOf(12)) == false) goto L19;
        return true;
    L19:
        if (r101.containsKey(String.valueOf(16)) == true) goto L28;
        return false;
    L28:
        return true;
    }
}
