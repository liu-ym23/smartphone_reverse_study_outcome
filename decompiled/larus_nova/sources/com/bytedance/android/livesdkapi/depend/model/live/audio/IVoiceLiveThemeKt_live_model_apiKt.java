package com.bytedance.android.livesdkapi.depend.model.live.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0002¨\u0006\t"}, d2 = {"getLocalPathKmp", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "isLocalUgcThemeKmp", "", "isSourceEqualKmp", "theme", "isUgcImageKmp", "isVideoThemeKmp", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IVoiceLiveThemeKt_live_model_apiKt {
    public static final String getLocalPathKmp(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getLocalPathKmp");
        return r100.getLocalPath();
    }

    public static final boolean isLocalUgcThemeKmp(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isLocalUgcThemeKmp");
        if (IVoiceLiveThemeKt.isUgcImage(r100) == true) goto L5;
        return false;
    L5:
        if (r100.getStaticBackground() == null) goto L7;
        return false;
    L7:
        if (r100.getLocalPath().length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r101 = false;
        goto L10
    }

    public static final boolean isUgcImageKmp(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isUgcImageKmp");
        return IVoiceLiveThemeKt.isUgcImage(r100);
    }

    public static final boolean isVideoThemeKmp(IVoiceLiveTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVideoThemeKmp");
        return IVoiceLiveThemeKt.isVideoTheme(r100);
    }

    public static final boolean isSourceEqualKmp(IVoiceLiveTheme r100, IVoiceLiveTheme r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSourceEqualKmp");
        Intrinsics.checkNotNullParameter(r101, "theme");
        return IVoiceLiveThemeKt.isSourceEqual(r100, r101);
    }
}
