package com.bytedance.android.livesdk.chatroom.roommanage.admin;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomAdminManageListPresenter f111237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ td1.d f111238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f111239c;

    public b(LiveRoomAdminManageListPresenter r100, td1.d r101, Function0 r102) {
        this.f111237a = r100;
        this.f111238b = r101;
        this.f111239c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        this.f111237a.f111192g.f545502a--;
        td1.d r102 = this.f111238b;
        r102.f545503a = false;
        td1.d.b(r102.adminPrivileges, false);
        LiveRoomAdminManageListPresenter.a(this.f111237a);
        this.f111237a.f111190e = false;
        Function0 r103 = this.f111239c;
        if (r103 == null) goto L6;
        Unit r104 = (Unit) r103.invoke();
        return;
    }
}
