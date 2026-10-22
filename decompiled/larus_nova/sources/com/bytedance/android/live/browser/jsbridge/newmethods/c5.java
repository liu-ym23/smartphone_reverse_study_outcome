package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class c5<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w4 f63330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GetMessageBoardDataResultModel f63331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.msgboard.a f63332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w20.p9 f63333d;

    public c5(w4 r100, GetMessageBoardDataResultModel r101, com.bytedance.android.livesdk.chatroom.msgboard.a r102, long r103, w20.p9 r104) {
        this.f63330a = r100;
        this.f63331b = r101;
        this.f63332c = r102;
        this.f63333d = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        w4 r102 = this.f63330a;
        GetMessageBoardDataResultModel r103 = this.f63331b;
        com.bytedance.android.livesdk.chatroom.msgboard.a r104 = this.f63332c;
        List<String> r105 = r102.f63699a;
        this.f63333d.getClass();
        w4.j(r102, r103, r104, r105);
    }
}
