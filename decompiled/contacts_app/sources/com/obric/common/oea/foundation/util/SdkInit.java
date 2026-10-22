package com.obric.common.oea.foundation.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SdkInit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/foundation/util/SdkInit;", "", "()V", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SdkInit {
    public static final Companion Companion = null;
    private static final String TAG = "OEA_FOUNDATION";
    private static int instanceCount;

    /* JADX INFO: compiled from: SdkInit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/util/SdkInit$Companion;", "", "()V", "TAG", "", "instanceCount", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SdkInit() {
        if (instanceCount != 0) goto L5;
        OEALogger.INSTANCE.r(TAG, "init, SDK_BUILD_NO: [20260305-10:39:59|5|79c4c13|20260304-19:36:11_feature: adapt system smooth corner]");
    L5:
        instanceCount++;
    }
}
