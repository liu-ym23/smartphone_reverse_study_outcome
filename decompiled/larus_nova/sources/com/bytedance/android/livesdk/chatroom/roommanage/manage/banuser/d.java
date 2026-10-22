package com.bytedance.android.livesdk.chatroom.roommanage.manage.banuser;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f111469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f111470b;

    public d(f r100, Function0 r101) {
        this.f111469a = r100;
        this.f111470b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        f r102 = this.f111469a;
        int r103 = r102.f111476e + 1;
        r102.f111476e = r103;
        int r104 = r102.f111477f;
        if (r103 > r104) goto L5;
        r102.f111481j.b(r103, r104);
    L5:
        this.f111470b.invoke();
        this.f111469a.f111475d = false;
    }
}
