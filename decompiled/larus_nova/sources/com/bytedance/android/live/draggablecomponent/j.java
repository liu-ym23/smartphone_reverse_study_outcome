package com.bytedance.android.live.draggablecomponent;

import com.bytedance.android.livesdk.message.model.InfoBoxBackGround;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveAnchorTeleprompterView f66667a;

    public j(LiveAnchorTeleprompterView r100) {
        this.f66667a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f66667a.e((InfoBoxBackGround) sh6.c.b((sh6.b) r100));
    }
}
