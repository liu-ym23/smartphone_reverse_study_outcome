package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadBubbleLoader f115831a;

    public f(PadBubbleLoader r100) {
        this.f115831a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Object r101 = ((Map) r100).get("has_pad_devices");
        if ((r101 instanceof Boolean) == true) goto L5;
        r101 = null;
    L5:
        Boolean r102 = (Boolean) r101;
        if (r102 == null) goto L8;
        this.f115831a.f115794g = r102.booleanValue();
    L8:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r103 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r103.d(this.f115831a.f115789b);
        r103.c("scan pad devices callback");
        r103.a("hasDevices", Boolean.valueOf(this.f115831a.f115794g));
        MorePanelBubbleAlog.a(r103.b());
        this.f115831a.b();
    }
}
