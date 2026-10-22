package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.model.user.o0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"hostUids", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;", "getHostUids", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;)Ljava/util/List;", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IOfficialChannelInfoModelExtensionKt {
    public static final List<String> getHostUids(IOfficialChannelInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$hostUids");
        o0.a r101 = o0.f58946a;
        r100.getHostAwemeUids();
        List<String> r102 = r100.getHostOpenIds();
        r101.getClass();
        return o0.a.h(r102);
    }
}
