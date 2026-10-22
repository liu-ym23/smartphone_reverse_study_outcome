package com.bytedance.android.livesdkapi.depend.live;

import android.view.KeyEvent;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes12.dex */
public interface IEventService {
    public static final int KEY_DOWN = 0;
    public static final int KEY_UP = 1;

    void bindDataCenter(ViewModel r100);

    void postChargeEvent();

    boolean postKeyEvent(int r100, int r101, KeyEvent r102);
}
