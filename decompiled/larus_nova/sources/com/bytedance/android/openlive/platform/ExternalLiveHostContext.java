package com.bytedance.android.openlive.platform;

import com.bytedance.android.livehostapi.platform.LiveHostContext;
import com.bytedance.android.openlive.LiveContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/openlive/platform/ExternalLiveHostContext;", "Lcom/bytedance/android/livehostapi/platform/LiveHostContext;", "liveContext", "Lcom/bytedance/android/openlive/LiveContext;", "(Lcom/bytedance/android/openlive/LiveContext;)V", "ecHostAppId", "", "getFEParamExtra", "", "hostAppId", "", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class ExternalLiveHostContext extends LiveHostContext {
    private final LiveContext liveContext;

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public String ecHostAppId() {
        return this.liveContext.getEcHostAppId();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public Map<String, String> getFEParamExtra() {
        Map<String, String> r100 = this.liveContext.getFeParamsExtra();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return super.getFEParamExtra();
    }

    @Override // com.bytedance.android.livehostapi.platform.LiveHostContext, com.bytedance.android.livehostapi.wrap.AbsHostContext, com.bytedance.android.livehostapi.hostdefault.HostContextDefault, com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext
    public int hostAppId() {
        Integer r100 = StringsKt.toIntOrNull(this.liveContext.getGeneralAppId());
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public ExternalLiveHostContext(LiveContext r100) {
        Intrinsics.checkNotNullParameter(r100, "liveContext");
        this.liveContext = r100;
    }
}
