package com.bytedance.android.livesdkapi.depend.model.live;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0019\u0010\r\u001a\u00020\u000e*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"multiStreamDataEx", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKt;", "getMultiStreamDataEx", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)Ljava/lang/String;", "pushSdkParamsEx", "getPushSdkParamsEx", "qualityListEx", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseQuality;", "getQualityListEx", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)Ljava/util/List;", "streamOrientationEx", "", "getStreamOrientationEx", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)I", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IBaseStreamUrlKt_androidKt {
    public static final String getMultiStreamDataEx(IBaseStreamUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$multiStreamDataEx");
        ILiveCoreSDKData r101 = r100.getLiveCoreSDKData();
        if (r101 == null) goto L7;
        IPullData r102 = r101.getPullData();
        if (r102 == null) goto L7;
        return r102.getStreamData();
    L7:
        return null;
    }

    public static final String getPushSdkParamsEx(IBaseStreamUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pushSdkParamsEx");
        return r100.getPushSdkParams();
    }

    public static final List<IBaseQuality> getQualityListEx(IBaseStreamUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$qualityListEx");
        ILiveCoreSDKData r101 = r100.getLiveCoreSDKData();
        if (r101 == null) goto L9;
        IPullData r102 = r101.getPullData();
        if (r102 == null) goto L9;
        IOptions r103 = r102.getOptions();
        if (r103 == null) goto L9;
        return r103.getQualityList();
    L9:
        return null;
    }

    public static final int getStreamOrientationEx(IBaseStreamUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamOrientationEx");
        return r100.getStreamOrientation();
    }
}
