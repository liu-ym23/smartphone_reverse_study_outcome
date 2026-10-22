package com.bytedance.android.livesdk.chatroom.end;

import android.view.View;
import com.bytedance.android.live.core.ui.BaseFragment;

/* JADX INFO: loaded from: classes7.dex */
public class LiveEndFragment extends BaseFragment {
    public LiveEndFragment() {
    }

    public final <T extends View> T findViewById(int r100) {
        if (getView() != null) goto L7;
        return null;
    L7:
        return (T) getView().findViewById(r100);
    }
}
