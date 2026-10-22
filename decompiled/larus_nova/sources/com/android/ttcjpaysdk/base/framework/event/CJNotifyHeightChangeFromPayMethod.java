package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJNotifyHeightChangeFromPayMethod;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "unknownHeight", "", "isRemove", "", "isDoLayerAnimation", "isAdjustHeightSilently", "(IZZZ)V", "()Z", "setAdjustHeightSilently", "(Z)V", "setDoLayerAnimation", "setRemove", "getUnknownHeight", "()I", "setUnknownHeight", "(I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJNotifyHeightChangeFromPayMethod extends BaseEvent {
    private boolean isAdjustHeightSilently;
    private boolean isDoLayerAnimation;
    private boolean isRemove;
    private int unknownHeight;

    public final int getUnknownHeight() {
        return this.unknownHeight;
    }

    public final boolean isAdjustHeightSilently() {
        return this.isAdjustHeightSilently;
    }

    public final boolean isDoLayerAnimation() {
        return this.isDoLayerAnimation;
    }

    public final boolean isRemove() {
        return this.isRemove;
    }

    public final void setAdjustHeightSilently(boolean r100) {
        this.isAdjustHeightSilently = r100;
    }

    public final void setDoLayerAnimation(boolean r100) {
        this.isDoLayerAnimation = r100;
    }

    public final void setRemove(boolean r100) {
        this.isRemove = r100;
    }

    public final void setUnknownHeight(int r100) {
        this.unknownHeight = r100;
    }

    public CJNotifyHeightChangeFromPayMethod(int r100, boolean r101, boolean r102, boolean r103) {
        this.unknownHeight = r100;
        this.isRemove = r101;
        this.isDoLayerAnimation = r102;
        this.isAdjustHeightSilently = r103;
    }
}
