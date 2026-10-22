package com.bytedance.android.ec.hybrid.service;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.tools.MallAndDeepFeedAnimExtension;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/service/MallDeepFeedAnimationServiceImpl;", "Lcom/bytedance/android/ec/hybrid/service/IMallDeepFeedAnimationService;", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallDeepFeedAnimationServiceImpl implements IMallDeepFeedAnimationService {
    public MallDeepFeedAnimationServiceImpl() {
    }

    @Override // com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService
    public final void clear() {
        Lazy r100 = MallAndDeepFeedAnimExtension.f47618a;
    }

    @Override // com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService
    public final boolean a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorActivity");
        Lazy r101 = MallAndDeepFeedAnimExtension.f47618a;
        Intrinsics.checkNotNullParameter(r100, "anchorActivity");
        TransitionAnimationHelper.c(r100, null, true);
        TransitionAnimationHelper.c(r100, null, false);
        r100.finish();
        Lazy r102 = MallAndDeepFeedAnimExtension.f47618a;
        return false;
    }

    @Override // com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService
    public final void c(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorActivity");
        Lazy r101 = MallAndDeepFeedAnimExtension.f47618a;
        Intrinsics.checkNotNullParameter(r100, "anchorActivity");
        TransitionAnimationHelper.c(r100, null, true);
        TransitionAnimationHelper.c(r100, null, false);
    }

    @Override // com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService
    public final ImageView b(Activity r100, Bitmap r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return TransitionAnimationHelper.c(r100, r101, r102);
    }
}
