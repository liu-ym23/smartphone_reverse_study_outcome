package com.bytedance.android.shopping.commentv3.audio;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q implements g {

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.g
    public final x a(w r100, StopReason r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "reason");
        return new x(true);
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.g
    public final u b(v r100, w r110) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r110 == null) goto L5;
        boolean r111 = Intrinsics.areEqual(r110.f172646a, r100.f172643a);
        if (r111 == false) goto L9;
        StopReason r101 = StopReason.REPLAY_SAME_SLICE;
    L10:
        StopReason r102 = r101;
        if (r111 == false) goto L13;
        y r112 = new y(true, true, true);
    L15:
        return new u(true, true, r102, r112, new t(r100.f172643a, r100.f172644b, ExternalAudioInterruptReason.COMMENT_AUDIO_PLAY, ExternalAudioTargetScope.CURRENT_PAGE_AND_FLOATING_AUDIO));
    L13:
        r112 = new y(false, 7);
        goto L15
    L9:
        r101 = StopReason.REPLACED_BY_OTHER;
        goto L10
    L5:
        return new u(true, new t(r100.f172643a, r100.f172644b, ExternalAudioInterruptReason.COMMENT_AUDIO_PLAY, ExternalAudioTargetScope.CURRENT_PAGE_AND_FLOATING_AUDIO), 12);
    }
}
