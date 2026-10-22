package com.bytedance.android.live.livelink;

import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.kmp.live.livelink.api.ILiveLinkServiceKmp;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ec6.b;
import hh1.v0;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sk0.c;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/livelink/LiveLinkServiceKmp;", "Lcom/bytedance/kmp/live/livelink/api/ILiveLinkServiceKmp;", "Lhh1/v0;", "factory", "Luf2/d0;", "liveCore", "Lec6/a;", "wrapLiveVideoClientFactory", "iLiveAVClientFactory", "unWrapLiveVideoClientFactory", "Lec6/b;", "bizLiveAVClient", "Lcom/bytedance/android/live/pushstream/d;", "unWrapBizLiveAVClient", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multi-link-service-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveLinkServiceKmp implements ILiveLinkServiceKmp {
    public static final a Companion = null;
    public static final String TAG = "LiveLinkService";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveLinkServiceKmp() {
        k.l(ILiveLinkServiceKmp.class, this);
        LinkedHashMap r100 = new LinkedHashMap();
        ((IMiddlewareNetworkService) k.n(IMiddlewareNetworkService.class)).injectProtoDecoders(r100);
    }

    @Override // com.bytedance.kmp.live.livelink.api.ILiveLinkServiceKmp
    public d unWrapBizLiveAVClient(b r100) {
        Intrinsics.checkNotNullParameter(r100, "bizLiveAVClient");
        if ((r100 instanceof c) == true) goto L5;
        r100 = null;
    L5:
        c r101 = (c) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f542326i;
    }

    @Override // com.bytedance.kmp.live.livelink.api.ILiveLinkServiceKmp
    public v0 unWrapLiveVideoClientFactory(ec6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "iLiveAVClientFactory");
        if ((r100 instanceof sk0.b) == true) goto L5;
        r100 = null;
    L5:
        sk0.b r101 = (sk0.b) r100;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f542316c;
    }

    @Override // com.bytedance.kmp.live.livelink.api.ILiveLinkServiceKmp
    public ec6.a wrapLiveVideoClientFactory(v0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        return new sk0.b(r100, r101);
    }
}
