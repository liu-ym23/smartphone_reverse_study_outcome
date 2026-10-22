package com.bytedance.android.live.broadcast.effect;

import am2.w;
import am2.z;
import com.bytedance.android.live.broadcast.api.model.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.n;
import com.bytedance.android.live.effect.api.t;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import java.util.HashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class EffectHostLiveService implements com.bytedance.android.live.effect.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f59142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f59143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f59144g;

    @Override // com.bytedance.android.live.effect.api.c
    public final DownloadableModelConfig b() {
        IDownloadableModelConfigService r100 = (IDownloadableModelConfigService) k.f(IDownloadableModelConfigService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDownloadModelConfig();
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final t c() {
        return (a) this.f59139b.getValue();
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final n e() {
        return (b) this.f59138a.getValue();
    }

    public EffectHostLiveService() {
        this.f59138a = LazyKt.lazy(new EffectHostLiveService$touchHandler$2(this));
        this.f59139b = LazyKt.lazy(new EffectHostLiveService$composerHandler$2(this));
        this.f59140c = LazyKt.lazy(EffectHostLiveService$liveStickerEffect$2.INSTANCE);
        this.f59141d = LazyKt.lazy(EffectHostLiveService$liveTouchEffect$2.INSTANCE);
        this.f59142e = LazyKt.lazy(EffectHostLiveService$stickerReportUtil$2.INSTANCE);
        this.f59143f = "";
        this.f59144g = LazyKt.lazy(EffectHostLiveService$commerceEffectService$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        xs2.b.a().post(new c(r100));
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void d(boolean r100) {
        q00.a r101 = (q00.a) this.f59144g.getValue();
        if (r101 == null) goto L5;
        r101.d(r100);
    L5:
        q00.a r102 = (q00.a) this.f59144g.getValue();
        Boolean r103 = null;
        if (r102 == null) goto L8;
        Boolean r104 = Boolean.valueOf(r102.c());
    L9:
        boolean r105 = r104.booleanValue();
        q00.a r106 = (q00.a) this.f59144g.getValue();
        if (r106 == null) goto L12;
        r103 = Boolean.valueOf(r106.a());
    L12:
        ALogger.d("COMMODITY_NO_FILTER", "post liveCommerceEffectEvent, unUsedEffect: " + r105 + ", commerceNoFilter: " + r103.booleanValue());
        xs2.b.a().post(new q0());
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void sendLog(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        if (r101.get(MonitorConstants.EXTRA_DOWNLOAD_PAGE) != null) goto L5;
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, this.f59143f);
    L5:
        u.l().sendLog(r100, r101, new Object[]{Room.class, new z(), w.class});
    }
}
