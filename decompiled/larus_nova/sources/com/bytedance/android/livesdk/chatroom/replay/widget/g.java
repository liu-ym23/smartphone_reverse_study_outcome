package com.bytedance.android.livesdk.chatroom.replay.widget;

import com.bytedance.android.annie.api.container.HybridDialog;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayBottomPanelManagerWidget f110373a;

    public g(ReplayBottomPanelManagerWidget r100) {
        this.f110373a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JSONObject r101 = (JSONObject) r100;
        if (r101 == null) goto L8;
        HybridDialog r102 = this.f110373a.f110312a;
        if (r102 == null) goto L9;
        r102.sendJsEvent("H5_roomStatusChange", r101);
        return;
    L9:
        return;
    }
}
