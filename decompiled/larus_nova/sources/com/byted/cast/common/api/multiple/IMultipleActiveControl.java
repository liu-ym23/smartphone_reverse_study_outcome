package com.byted.cast.common.api.multiple;

import com.byted.cast.common.api.IActiveControl;

/* JADX INFO: loaded from: classes39.dex */
public interface IMultipleActiveControl extends IActiveControl {

    /* JADX INFO: renamed from: com.byted.cast.common.api.multiple.IMultipleActiveControl$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$updateDrama(IMultipleActiveControl r100, String r101) {
        }
    }

    float getPlayerVolume(String r100);

    void setPlayerVolume(String r100, float r101);

    void updateDrama(String r100);
}
