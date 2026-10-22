package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJNotifyOuterCounterAvatarAnim;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "targetHeight", "", "(I)V", "getTargetHeight", "()I", "setTargetHeight", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJNotifyOuterCounterAvatarAnim extends BaseEvent {
    private int targetHeight;

    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public CJNotifyOuterCounterAvatarAnim(int r100) {
        this.targetHeight = r100;
    }

    public final void setTargetHeight(int r100) {
        this.targetHeight = r100;
    }
}
