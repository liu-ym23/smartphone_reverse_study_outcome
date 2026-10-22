package a03;

import android.content.Context;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.d10;
import com.bytedance.android.livesdk.utils.IMessageManagerProviderService;
import com.bytedance.android.livesdk.utils.z4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import jc1.k;
import vlc.j;

/* JADX INFO: loaded from: classes12.dex */
public class d implements IMessageManagerProviderService {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.utils.IMessageManagerProviderService
    public vlc.d configFloatWindow(Context r110, long r111, Map<String, String> r112, ylc.e r113) {
        String r100 = ((IMiddlewareUserService) k.f(IMiddlewareUserService.class)).user().n();
        ArrayList r114 = new ArrayList();
        vlc.b r101 = z4.d();
        r114.add(new com.bytedance.android.livesdk.message.interceptor.d(r111));
        if (r101 == null) goto L5;
        r114.add(r101);
    L5:
        ArrayList r115 = new ArrayList();
        if ((r101 instanceof j) == false) goto L8;
        r115.add((j) r101);
    L8:
        if (r113 != null) goto L10;
    L12:
        hm2.a r102 = new hm2.a(r110, r111, r100, r112, r114, r115);
        int r103 = vs1.d.f556977a;
        d10 r104 = d10.f119994a;
        if (r104.getValue().d() == false) goto L20;
        if (r104.getValue().c() <= 0) goto L20;
        if (r104.getValue().a() <= 0) goto L20;
        return st2.b.a(r104.getValue().c(), r104.getValue().a(), r102.f(), r114, r115, Collections.emptyList());
    L20:
        return amc.f.a(r102);
    L10:
        if ((r101 instanceof ylc.c) == false) goto L12;
        r113.c((ylc.c) r101);
        goto L12
    }

    @Override // com.bytedance.android.livesdk.utils.IMessageManagerProviderService
    public vlc.d configOuter(String r100, long r101, Context r102, Map<String, String> r103) {
        return z4.b(r100, r101, r102, r103);
    }
}
