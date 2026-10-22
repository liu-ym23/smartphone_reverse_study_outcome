package com.tmall.wireless.tangram.core.protocol;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface ViewMounter<DT, V extends View> {
    void mountView(@NonNull DT r10, @NonNull V r11);

    void unmountView(@NonNull DT r10, @NonNull V r11);
}
