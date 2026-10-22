package com.bytedance.android.livesdkapi;

import com.bytedance.android.livesdkapi.service.IInternalBusinessService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/TTInternalBusinessService;", "", "()V", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TTInternalBusinessService {
    public static final Companion Companion = null;
    private static volatile ITTLiveSDKProxy sLiveSDKProxy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/TTInternalBusinessService$Companion;", "", "()V", "sLiveSDKProxy", "Lcom/bytedance/android/livesdkapi/ITTLiveSDKProxy;", "getBusinessService", "Lcom/bytedance/android/livesdkapi/service/IInternalBusinessService;", "setSDKContext", "", "liveContext", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final IInternalBusinessService getBusinessService() {
            if (TTInternalBusinessService.access$getSLiveSDKProxy$cp() != null) goto L5;
            return null;
        L5:
            ITTLiveSDKProxy r100 = TTInternalBusinessService.access$getSLiveSDKProxy$cp();
            Intrinsics.checkNotNull(r100);
            return (IInternalBusinessService) r100.getService(IInternalBusinessService.class);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setSDKContext(ITTLiveSDKProxy r100) {
            Intrinsics.checkNotNullParameter(r100, "liveContext");
            TTInternalBusinessService.access$setSLiveSDKProxy$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TTInternalBusinessService() {
    }

    @JvmStatic
    public static final IInternalBusinessService getBusinessService() {
        return Companion.getBusinessService();
    }

    public static final /* synthetic */ ITTLiveSDKProxy access$getSLiveSDKProxy$cp() {
        return sLiveSDKProxy;
    }

    public static final /* synthetic */ void access$setSLiveSDKProxy$cp(ITTLiveSDKProxy r100) {
        sLiveSDKProxy = r100;
    }
}
