package com.android.server.wm;

import android.content.Context;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtDisplayRotation extends IExtBase {
    default boolean updateRotationUnchecked(Context context, int oldRotation, int rotation) {
        return false;
    }

    default boolean onProposedRotationChanged(Context mContext, int rotation) {
        return false;
    }
}
