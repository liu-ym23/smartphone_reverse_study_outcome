package k6;

import android.text.TextUtils;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static String a() {
        String r10 = TTNetInit.getTTNetDepend().getCdnHostSuffix();
        if (r10 == null) goto L8;
        if (TextUtils.isEmpty(r10) == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("cdnHostSuffix is not init !!!");
    }

    public static String b() {
        String r10 = TTNetInit.getTTNetDepend().getHostSuffix();
        if (r10 == null) goto L8;
        if (TextUtils.isEmpty(r10) == true) goto L8;
        return r10;
    L8:
        throw new IllegalArgumentException("hostSuffix is not init !!!");
    }
}
