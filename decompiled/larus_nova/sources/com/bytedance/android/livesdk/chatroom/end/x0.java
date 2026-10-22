package com.bytedance.android.livesdk.chatroom.end;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class x0 implements Consumer<SubscriberJsEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewLiveBroadcastEndFragment f106195a;

    public x0(NewLiveBroadcastEndFragment r100) {
        this.f106195a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(SubscriberJsEvent r100) throws Exception {
        SubscriberJsEvent r101 = r100;
        HashMap r102 = new HashMap();
        if (r101 != null) goto L5;
    L9:
        NewLiveBroadcastEndFragment r103 = this.f106195a;
        int r104 = NewLiveBroadcastEndFragment.f106016o;
        if (r103.U90() == null) goto L12;
        r102.put("scene", this.f106195a.U90());
    L12:
        r102.put("stage", "close_page_all_load_time");
        this.f106195a.getClass();
        return;
    L5:
        if (r101.getParams() == null) goto L9;
        if (r101.getParams().get("diff_duration") == null) goto L9;
        r102.put("diff_duration", r101.getParams().get("diff_duration").toString());
        goto L9
    }
}
