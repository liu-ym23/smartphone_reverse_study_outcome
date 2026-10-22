package com.alibaba.gaiax.render.utils;

import com.alibaba.gaiax.api.GXIEventListener;
import com.alibaba.gaiax.model.GXAnimation;
import com.alibaba.gaiax.model.GXGesture;
import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alibaba/gaiax/render/utils/GXIManualExposureEventListener;", "Lcom/alibaba/gaiax/api/GXIEventListener;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXIManualExposureEventListener extends GXIEventListener {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onAnimationEvent(GXIManualExposureEventListener r100, GXAnimation r101) {
            Intrinsics.checkNotNullParameter(r101, "gxAnimation");
            GXIEventListener.DefaultImpls.onAnimationEvent(r100, r101);
        }

        public static void onGestureEvent(GXIManualExposureEventListener r100, GXGesture r101) {
            Intrinsics.checkNotNullParameter(r101, "gxGesture");
            GXIEventListener.DefaultImpls.onGestureEvent(r100, r101);
        }

        public static void onScrollEvent(GXIManualExposureEventListener r100, GXScroll r101) {
            Intrinsics.checkNotNullParameter(r101, "gxScroll");
            GXIEventListener.DefaultImpls.onScrollEvent(r100, r101);
        }
    }
}
