package com.bytedance.android.live.broadcast.effectmanager;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.live.broadcast.effect.IDownloadableModelConfigService;
import com.bytedance.android.live.effect.api.LiveEffectBaseContext;
import com.bytedance.android.live.effect.utils.d;
import com.bytedance.android.live.effect.utils.l;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdkapi.LiveConsts;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kjc.b;
import kjc.c;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcast/effectmanager/DownloadableModelConfigService;", "Lcom/bytedance/android/live/broadcast/effect/IDownloadableModelConfigService;", "()V", "getDownloadModelConfig", "Lcom/ss/android/ugc/effectmanager/DownloadableModelConfig;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DownloadableModelConfigService implements IDownloadableModelConfigService {
    public DownloadableModelConfigService() {
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [T, kotlin.Unit] */
    @Override // com.bytedance.android.live.broadcast.effect.IDownloadableModelConfigService
    public DownloadableModelConfig getDownloadModelConfig() {
        final a r100 = new a();
        IHostContext r101 = (IHostContext) k.n(IHostContext.class);
        final Context r102 = r101.context();
        final DownloadableModelConfig.Builder r103 = new DownloadableModelConfig.Builder();
        c r104 = new c();
        com.bytedance.android.livesdk.paas.a.a(r104, new DownloadableModelProvider$getDLModelConfig$$inlined$call$lambda$1(r100, r103, r102));
        if (r104.f503731b == true) goto L9;
        b<T> r105 = r104.f503730a;
        ArrayList r106 = new ArrayList();
        Iterator r107 = ((ArrayList) r100.f59146a).iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        r106.add(new Host((String) r107.next()));
        goto L6
    L8:
        List<Host> r108 = LiveEffectBaseContext.f66723e;
        r103.setAccessKey("142710f02c3a11e8b42429f14557854a").setHosts(r106).setSdkVersion(LiveConsts.TTLIVESDK_EFFECT_VERSION).setWorkspace(new PolarisFileWrapper(r102.getFilesDir(), "effect/").getAbsolutePath()).setEffectNetWorker(new d());
        r105.f503729a = Unit.INSTANCE;
    L9:
        T r109 = r104.f503730a.f503729a;
        r103.setContext(r102).setAssetManager(r102.getAssets()).setJsonConverter(new l()).setExclusionPattern("(?=^((?!tt_face|kws).)+)^((?!png|dat).)+").setAppId(String.valueOf(r101.appId())).setDeviceType(URLEncoder.encode(Build.MODEL)).setModelFileEnv(DownloadableModelConfig.ModelFileEnv.ONLINE).setExecutor(PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("effect_downloader", true)));
        return r103.build();
    }
}
