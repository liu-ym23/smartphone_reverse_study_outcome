package com.bytedance.android.livesdkapi.depend.model.live.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0004"}, d2 = {"isInvalide", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/ISpeakingImage;", "isMedimInvalide", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ISpeakingImageKt {
    public static final boolean isInvalide(ISpeakingImage r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.getLow() == null) goto L10;
        if (r100.getMedium() == null) goto L10;
        if (r100.getHigh() == null) goto L10;
        return true;
    }

    public static final boolean isMedimInvalide(ISpeakingImage r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.getMedium() == null) goto L6;
        return true;
    }
}
