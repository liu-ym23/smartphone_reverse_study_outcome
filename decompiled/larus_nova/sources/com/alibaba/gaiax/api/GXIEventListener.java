package com.alibaba.gaiax.api;

import com.alibaba.gaiax.model.GXAnimation;
import com.alibaba.gaiax.model.GXGesture;
import com.alibaba.gaiax.model.GXScroll;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/api/GXIEventListener;", "", "onAnimationEvent", "", "gxAnimation", "Lcom/alibaba/gaiax/model/GXAnimation;", "onGestureEvent", "gxGesture", "Lcom/alibaba/gaiax/model/GXGesture;", "onScrollEvent", "gxScroll", "Lcom/alibaba/gaiax/model/GXScroll;", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXIEventListener {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onAnimationEvent(GXIEventListener r100, GXAnimation r101) {
            Intrinsics.checkNotNullParameter(r101, "gxAnimation");
        }

        public static void onGestureEvent(GXIEventListener r100, GXGesture r101) {
            Intrinsics.checkNotNullParameter(r101, "gxGesture");
        }

        public static void onScrollEvent(GXIEventListener r100, GXScroll r101) {
            Intrinsics.checkNotNullParameter(r101, "gxScroll");
        }
    }

    void onAnimationEvent(GXAnimation r100);

    void onGestureEvent(GXGesture r100);

    void onScrollEvent(GXScroll r100);
}
