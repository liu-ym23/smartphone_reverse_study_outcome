package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class y4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w4 f63728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetMessageBoardDataResultModel f63729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.msgboard.a f63730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w20.p9 f63731d;

    public y4(w4 r100, GetMessageBoardDataResultModel r101, com.bytedance.android.livesdk.chatroom.msgboard.a r102, long r103, w20.p9 r104) {
        this.f63728a = r100;
        this.f63729b = r101;
        this.f63730c = r102;
        this.f63731d = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        w4 r101 = this.f63728a;
        GetMessageBoardDataResultModel r102 = this.f63729b;
        com.bytedance.android.livesdk.chatroom.msgboard.a r103 = this.f63730c;
        List<String> r104 = r101.f63699a;
        this.f63731d.getClass();
        w4.j(r101, r102, r103, r104);
        xs2.b.a().post(new RefreshVSMessageBoardDataEvent());
    }
}
