package com.bytedance.android.livesdk.chatroom.ui.behavior;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarVideoQualityBehavior f112654a;

    public e(ToolbarVideoQualityBehavior r100) {
        this.f112654a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        ToolbarVideoQualityBehavior r102 = this.f112654a;
        int r103 = ToolbarVideoQualityBehavior.f112614m;
        r102.c();
        ALogger.d("ToolbarVideoQualityBehavior", "playerViewVisibleTriggeredByUser");
    }
}
