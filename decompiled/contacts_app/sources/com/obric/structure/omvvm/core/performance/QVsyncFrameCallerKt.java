package com.obric.structure.omvvm.core.performance;

import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.extension.QConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: QVsyncFrameCaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00018BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ANIMATION_LIMIT", "", "FRAME_INTERVAL", "MIN_LIMIT", "getMIN_LIMIT", "()Ljava/lang/Long;", "Ljava/lang/Long;", "TAG", "", "omvvm-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class QVsyncFrameCallerKt {
    private static final long ANIMATION_LIMIT = 8000000;
    private static final long FRAME_INTERVAL = 16000000;
    private static Long MIN_LIMIT = null;
    private static final String TAG = "QVsyncFrameCaller";

    static {
    }

    public static final /* synthetic */ Long access$getMIN_LIMIT() {
        return getMIN_LIMIT();
    }

    public static final /* synthetic */ void access$setMIN_LIMIT$p(Long r0) {
        MIN_LIMIT = r0;
    }

    private static final Long getMIN_LIMIT() {
        if (MIN_LIMIT != null) goto L19;
        QConfig r0 = Q.INSTANCE.getCig$omvvm_core_release();
        boolean r1 = true;
        if (r0 == null) goto L7;
        int r2 = r0.frameMinLimit();
    L9:
        if (1 <= r2) goto L11;
    L13:
        r1 = false;
    L15:
        if (r1 == false) goto L17;
        MIN_LIMIT = Long.valueOf(((long) r2) * 1000000);
        goto L19
    L17:
        MIN_LIMIT = 1000000L;
        goto L19
    L11:
        if (r2 >= 17) goto L13;
    L7:
        r2 = 1;
    L19:
        return MIN_LIMIT;
    }
}
