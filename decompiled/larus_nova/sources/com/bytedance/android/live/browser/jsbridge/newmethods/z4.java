package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class z4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w4 f63746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetMessageBoardDataResultModel f63747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.msgboard.a f63748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w20.p9 f63749d;

    public z4(w4 r100, GetMessageBoardDataResultModel r101, com.bytedance.android.livesdk.chatroom.msgboard.a r102, long r103, w20.p9 r104) {
        this.f63746a = r100;
        this.f63747b = r101;
        this.f63748c = r102;
        this.f63749d = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        w4 r102 = this.f63746a;
        GetMessageBoardDataResultModel r103 = this.f63747b;
        com.bytedance.android.livesdk.chatroom.msgboard.a r104 = this.f63748c;
        List<String> r105 = r102.f63699a;
        this.f63749d.getClass();
        w4.j(r102, r103, r104, r105);
        xs2.b.a().post(new RefreshVSMessageBoardDataEvent());
    }
}
