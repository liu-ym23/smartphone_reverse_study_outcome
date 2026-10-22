package r6;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static boolean a(String r10, Set r11) {
        if (e.b(r10) == false) goto L5;
        return false;
    L5:
        if (r11 == null) goto L18;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        String r13 = (String) r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L8;
        if (r10.startsWith(r13) == false) goto L8;
        if (Logger.debug() == false) goto L25;
        Logger.d("RequestDelayHelper", "app delay, matched, rule is " + r13 + " request path is " + r10);
        return true;
    L25:
        return true;
    L18:
        return false;
    }
}
