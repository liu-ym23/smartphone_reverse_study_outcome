package c12;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class e extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f22023n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22024o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public GiftResourceFileCacheService f22025p;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.e
    public final int a() {
        if (this.f22025p != null) goto L5;
        this.f22025p = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
    L5:
        GiftResourceFileCacheService r100 = this.f22025p;
        if (r100 == null) goto L39;
        com.bytedance.android.livesdk.gift.configmodel.f r101 = r100.h();
        if (r101 != null) goto L10;
        return 0;
    L10:
        if (r101.getEnable() != true) goto L41;
        GiftResourceFileCacheService r102 = this.f22025p;
        if (r102 == null) goto L42;
        String r103 = this.f129101k;
        ConcurrentHashMap<String, String> r104 = r102.f131396c;
        if (r104 != null) goto L16;
        return 0;
    L16:
        if (r104.isEmpty() == true) goto L48;
        String r105 = r102.f131396c.get(r103);
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L28;
        return 1;
    L28:
        if (r102.h().n7() == true) goto L34;
        if (r102.f131399f == false) goto L34;
        return 2;
    L34:
        if (r102.f131399f == true) goto L46;
        long r107 = r102.f131405l;
        if (r107 >= 100000) goto L47;
        r102.f131405l = r107 + 1;
        return 0;
    L47:
        return 0;
    L46:
        return 0;
    L21:
        if (r105.length() == 0) goto L24;
        r106 = false;
        goto L25
    L48:
        return 0;
    L42:
        return 0;
    L41:
        return 0;
    L39:
        return 0;
    }

    public e(long r100, String[] r101, String r102, long r103, GiftResourceFileCacheService r104) {
        Intrinsics.checkNotNullParameter(r101, "urls");
        Intrinsics.checkNotNullParameter(r102, "md5");
        super(r100, r101, r102, r103);
        this.f22025p = r104;
    }
}
