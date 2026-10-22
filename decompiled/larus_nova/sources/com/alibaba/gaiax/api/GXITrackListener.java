package com.alibaba.gaiax.api;

import com.alibaba.gaiax.model.GXTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/api/GXITrackListener;", "", "onManualClickTrackEvent", "", "gxTrack", "Lcom/alibaba/gaiax/model/GXTrack;", "onManualExposureTrackEvent", "onTrackEvent", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface GXITrackListener {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onManualClickTrackEvent(GXITrackListener r100, GXTrack r101) {
            Intrinsics.checkNotNullParameter(r101, "gxTrack");
        }

        public static void onManualExposureTrackEvent(GXITrackListener r100, GXTrack r101) {
            Intrinsics.checkNotNullParameter(r101, "gxTrack");
        }

        public static void onTrackEvent(GXITrackListener r100, GXTrack r101) {
            Intrinsics.checkNotNullParameter(r101, "gxTrack");
        }
    }

    void onManualClickTrackEvent(GXTrack r100);

    void onManualExposureTrackEvent(GXTrack r100);

    void onTrackEvent(GXTrack r100);
}
