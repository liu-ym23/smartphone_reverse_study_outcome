package ag1;

import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Long a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        IVSHistoryProgressService r101 = (IVSHistoryProgressService) jc1.k.f(IVSHistoryProgressService.class);
        if (r101 == null) goto L5;
        Long r102 = r101.getFirstShowTime(r100);
    L6:
        if (r102 != null) goto L8;
        return r102;
    L8:
        return Long.valueOf(r102.longValue() / ((long) 1000));
    L5:
        r102 = null;
        goto L6
    }
}
