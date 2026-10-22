package bz1;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;
import mz0.j;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        p11.j r101 = ((ILinkService) f.a(ILinkService.class)).getRevenueLinkDataHolder();
        r100.d(r101.getChannelId());
        r100.i(r101.a());
        r100.f((int) r101.getDuration());
        r100.c(r101.A());
        r100.h(r101.getPkId());
        r100.j(r101.B());
        r100.b(r101.getRequestId());
        r100.e(r101.isOnceMore());
        r100.g(r101.getTheme());
    }
}
