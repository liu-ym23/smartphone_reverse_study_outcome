package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.framework.AnimUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJNotifyAnimShowEndEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "page", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "(Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;)V", "getPage", "()Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "setPage", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJNotifyAnimShowEndEvent extends BaseEvent {
    private AnimUtil.IAnimView page;

    public final AnimUtil.IAnimView getPage() {
        return this.page;
    }

    public CJNotifyAnimShowEndEvent(AnimUtil.IAnimView r100) {
        this.page = r100;
    }

    public final void setPage(AnimUtil.IAnimView r100) {
        this.page = r100;
    }
}
