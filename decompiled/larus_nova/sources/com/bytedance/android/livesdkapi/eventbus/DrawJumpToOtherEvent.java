package com.bytedance.android.livesdkapi.eventbus;

import android.os.Bundle;

/* JADX INFO: loaded from: classes12.dex */
public class DrawJumpToOtherEvent {
    public Bundle mBundle;
    public long mRoomId;

    public DrawJumpToOtherEvent(long r100, Bundle r101) {
        this.mRoomId = r100;
        this.mBundle = r101;
    }
}
