package bs6;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.groupon.host.ILifeGrouponService;
import java.util.concurrent.ConcurrentHashMap;
import lz6.x;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final ILifeGrouponService a() {
        zt6.a r100 = HostServiceUtilsKt.c0();
        if (r100 == null) goto L6;
        r100.c();
        r100.b();
        return new x();
    L6:
        ConcurrentHashMap<Class<?>, Object> r101 = LifeServiceManager.f162660a;
        ILifeGrouponService r102 = (ILifeGrouponService) LifeServiceManager.b(ILifeGrouponService.class);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new x();
    }
}
