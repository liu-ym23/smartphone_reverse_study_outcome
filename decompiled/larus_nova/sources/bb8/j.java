package bb8;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes25.dex */
public final class j {
    public static final boolean a(i r100) {
        if (r100 == null) goto L4;
        Long r101 = r100.e();
    L6:
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r100.e().longValue() > 0) goto L11;
        return false;
    L11:
        if ((AppHost.f326268a.getAppClock().currentTimeMillis() / ((long) 1000)) < r100.e().longValue()) goto L15;
        return true;
    L15:
        return false;
    L4:
        r101 = null;
        goto L6
    }
}
